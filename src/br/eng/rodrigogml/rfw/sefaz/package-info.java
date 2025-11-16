/**
 * Convenções de persistência e mapeamento do módulo RFW.SEFAZ.
 * <ul>
 *   <li>Todos os objetos persistidos usam tabelas prefixadas com <code>sefaz_</code> no schema <code>_RFW.SEFAZ</code>, com chave primária <code>id</code> BIGINT auto increment.</li>
 *   <li>Os relacionamentos seguem a hierarquia definida nos VOs. Primeiro crie as tabelas pais (por exemplo, <code>sefaz_infnfe</code>) e depois as filhas (<code>sefaz_dest</code>, <code>sefaz_pag</code> etc.), garantindo chaves estrangeiras explícitas.</li>
 *   <li>Campos baseados em enumerações (<code>@RFWMetaEnumField</code>) devem sempre ser persistidos como <code>varchar(50)</code>. Nenhum valor atual ultrapassa 50 caracteres, mas revise novas enums antes de mapear.</li>
 *   <li>Campos textuais usam UTF-8 e devem seguir os limites definidos nos metadados (comprimento, obrigatoriedade, máscaras e pré-processamentos).</li>
 *   <li>Use <code>ENGINE=InnoDB</code> e nomeie constraints no padrão <code>fk_[tabela_filha]_[tabela_pai]</code>, como já feito em {@link br.eng.rodrigogml.rfw.sefaz.vo.SEFAZNFeVO} e correlatos.</li>
 * </ul>
 */
package br.eng.rodrigogml.rfw.sefaz;
