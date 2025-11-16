#!/usr/bin/env python3
"""Utility to audit text encodings across the repository."""
from __future__ import annotations

import argparse
from collections import Counter
from dataclasses import dataclass
from pathlib import Path
from typing import Iterable

TEXT_EXTENSIONS = {
    '.java', '.xml', '.xsd', '.xslt', '.md', '.txt', '.properties', '.prefs', '.project',
    '.classpath', '.gitignore', '.lst', '.cfg', '.ini', '.json', '.wsdd', '.wsdl'
}
EXCLUDED_DIRS = {'.git', 'target', '.idea', '.vscode'}

@dataclass
class FileReport:
    path: Path
    encoding: str
    newline: str
    note: str = ''


def iter_files(root: Path) -> Iterable[Path]:
    for path in sorted(root.rglob('*')):
        if not path.is_file():
            continue
        if any(part in EXCLUDED_DIRS for part in path.parts):
            continue
        yield path


def detect_encoding(data: bytes) -> tuple[str, str, str]:
    if not data:
        return 'ASCII', 'Unix', 'Arquivo vazio'
    if b'\x00' in data:
        return 'Binário', 'n/a', 'Contém byte nulo'
    newline = 'Unix'
    if b'\r\n' in data and b'\n' in data:
        newline = 'Windows'
    elif b'\r' in data and b'\n' not in data:
        newline = 'Mac (CR)'
    if data.startswith(b'\xef\xbb\xbf'):
        try:
            data[3:].decode('utf-8')
            return 'UTF-8 BOM', newline, ''
        except UnicodeDecodeError:
            pass
    try:
        decoded = data.decode('utf-8')
        if all(ord(ch) < 128 for ch in decoded):
            return 'ASCII', newline, ''
        return 'UTF-8', newline, ''
    except UnicodeDecodeError:
        pass
    try:
        data.decode('cp1252')
        return 'Windows-1252', newline, ''
    except UnicodeDecodeError:
        pass
    try:
        data.decode('iso-8859-1')
        return 'ISO-8859-1', newline, ''
    except UnicodeDecodeError:
        pass
    return 'Desconhecido', newline, 'Necessário validar manualmente'


def build_report(root: Path, only_text: bool) -> tuple[list[FileReport], Counter]:
    rows: list[FileReport] = []
    counts: Counter[str] = Counter()
    for path in iter_files(root):
        ext = path.suffix.lower()
        is_text_hint = ext in TEXT_EXTENSIONS
        data = path.read_bytes()
        encoding, newline, note = detect_encoding(data)
        counts[encoding] += 1
        if encoding == 'Binário' and only_text and not is_text_hint:
            continue
        rows.append(FileReport(path.relative_to(root), encoding, newline, note))
    return rows, counts


def render_markdown(rows: list[FileReport], counts: Counter[str]) -> str:
    total = sum(counts.values())
    lines = [
        '# Relatório de charset',
        '',
        '## Resumo',
        '',
        '| Encoding | Quantidade | Percentual |',
        '| --- | ---: | ---: |'
    ]
    for encoding, qty in counts.most_common():
        percent = (qty / total) * 100 if total else 0
        lines.append(f"| {encoding} | {qty} | {percent:.1f}% |")
    lines.extend(['', '## Arquivos analisados', '', '| Arquivo | Encoding | Quebra de linha | Observações |', '| --- | --- | --- | --- |'])
    for row in rows:
        note = row.note.replace('|', '\\|')
        lines.append(f"| {row.path.as_posix()} | {row.encoding} | {row.newline} | {note} |")
    lines.append('')
    return '\n'.join(lines)


def main() -> None:
    parser = argparse.ArgumentParser(description='Audita os encodings dos arquivos do projeto.')
    parser.add_argument('--all', action='store_true', help='Incluir arquivos binários e extensões não textuais')
    parser.add_argument('--output', type=Path, default=Path('charset_report.md'), help='Arquivo Markdown de saída')
    args = parser.parse_args()

    root = Path(__file__).resolve().parents[1]
    rows, counts = build_report(root, only_text=not args.all)
    args.output.write_text(render_markdown(rows, counts), encoding='utf-8')
    print(f'Relatório gerado em {args.output}')


if __name__ == '__main__':
    main()
