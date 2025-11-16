package br.eng.rodrigogml.rfw.sefaz.mapper;

import java.util.ArrayList;
import java.util.List;

import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indSinc;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_versao;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZEnviNFeVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZNFeVO;

import xsdobjects.enviNFe400.TEnviNFe;
import xsdobjects.enviNFe400.TNFe;

/**
 * Mapper responsvel por converter o VO {@link SEFAZEnviNFeVO} no contrato JAXB {@link TEnviNFe} utilizado pelo mtodo {@code nfeAutorizacaoLoteV400} (envio de lote v4.00), e vice-versa.
 *
 * <p>
 * O objetivo desta classe centralizar as converses VO &lt;-&gt; JAXB do lote, mantendo as regras de preenchimento fora da camada de validao/persistncia. Converses recursivas (NF-e e filhos) sero disponibilizadas em mtodos privados especficos, a medida que novas tarefas forem liberadas.
 */
public final class MapperForNfeAutorizacaoLoteV400 {

  private MapperForNfeAutorizacaoLoteV400() {
  }

  /**
   * Converte o {@link SEFAZEnviNFeVO} para {@link TEnviNFe}, preenchendo atributos simples e delegando a converso dos descendentes para submtodos.
   *
   * @param source VO persistido/instanciado internamente.
   * @return {@link TEnviNFe} pronto para assinatura e envio; {@code null} se {@code source} for {@code null}.
   */
  public static TEnviNFe toJaxb(SEFAZEnviNFeVO source) {
    if (source == null) {
      return null;
    }
    TEnviNFe target = new TEnviNFe();
    if (source.getVersao() != null) {
      target.setVersao(source.getVersao().getXmlData());
    }
    target.setIdLote(source.getIdLote());
    if (source.getIndSinc() != null) {
      target.setIndSinc(source.getIndSinc().getXmlData());
    }
    if (source.getNfeList() != null && !source.getNfeList().isEmpty()) {
      target.getNFe().addAll(mapNFeListToJaxb(source.getNfeList()));
    }
    return target;
  }

  /**
   * Converte o {@link TEnviNFe} retornado/emitido para o VO equivalente.
   *
   * @param source objeto JAXB recebido/construido via SEFAZ.
   * @return {@link SEFAZEnviNFeVO} populado; {@code null} se {@code source} for {@code null}.
   */
  public static SEFAZEnviNFeVO toVO(TEnviNFe source) {
    if (source == null) {
      return null;
    }
    SEFAZEnviNFeVO target = new SEFAZEnviNFeVO();
    if (source.getVersao() != null) {
      target.setVersao(SEFAZEnums.valueOfXMLData(SEFAZ_versao.class, source.getVersao()));
    }
    target.setIdLote(source.getIdLote());
    if (source.getIndSinc() != null) {
      target.setIndSinc(SEFAZEnums.valueOfXMLData(SEFAZ_indSinc.class, source.getIndSinc()));
    }
    if (source.getNFe() != null && !source.getNFe().isEmpty()) {
      target.setNfeList(mapNFeListToVo(source.getNFe(), target));
    }
    return target;
  }

  private static List<TNFe> mapNFeListToJaxb(List<SEFAZNFeVO> sourceList) {
    if (sourceList == null || sourceList.isEmpty()) {
      return new ArrayList<>();
    }
    List<TNFe> targetList = new ArrayList<>(sourceList.size());
    for (SEFAZNFeVO nfeVO : sourceList) {
      targetList.add(toJaxbNFe(nfeVO));
    }
    return targetList;
  }

  private static List<SEFAZNFeVO> mapNFeListToVo(List<TNFe> sourceList, SEFAZEnviNFeVO parent) {
    if (sourceList == null || sourceList.isEmpty()) {
      return new ArrayList<>();
    }
    List<SEFAZNFeVO> targetList = new ArrayList<>(sourceList.size());
    for (TNFe nfe : sourceList) {
      targetList.add(toVoNFe(nfe, parent));
    }
    return targetList;
  }

  private static TNFe toJaxbNFe(SEFAZNFeVO nfeVO) {
    throw new UnsupportedOperationException("Conversao SEFAZNFeVO -> TNFe (nfeAutorizacaoLote v4.00) ainda nao implementada.");
  }

  private static SEFAZNFeVO toVoNFe(TNFe nfe, SEFAZEnviNFeVO parent) {
    throw new UnsupportedOperationException("Conversao TNFe -> SEFAZNFeVO (nfeAutorizacaoLote v4.00) ainda nao implementada.");
  }
}
