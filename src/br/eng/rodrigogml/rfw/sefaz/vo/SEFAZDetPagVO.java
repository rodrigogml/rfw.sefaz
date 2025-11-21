package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indPag;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tPag;

/**
 * Grupo YA01a - detPag: Detalhamento do Pagamento.
 * <p>
 * Ocorre 1-100 dentro do grupo YA01 (pag).
 * <p>
 * Representa um meio de pagamento (tPag), com valor (vPag) e, opcionalmente, detalhes de cartão (card) quando aplicável.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_detpag")
public class SEFAZDetPagVO extends RFWVO {

  private static final long serialVersionUID = 5666558123175030448L;

  /**
   * {@link SEFAZPagVO}
   */
  @RFWMetaRelationshipField(caption = "Pag", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_pag")
  private SEFAZPagVO pagVO = null;

  /**
   * YA04 - card: Grupo de Cartões. Ocorrência: 0-1.
   * <p>
   * Informado quando o meio de pagamento (tPag) envolver cartão de crédito ou débito.
   */
  @RFWMetaRelationshipField(caption = "Card", relationship = RelationshipTypes.COMPOSITION, required = false, column = "idsefaz_detpag")
  private SEFAZCardVO card;

  /**
   * YA01b - indPag: Indicador da Forma de Pagamento. Tipo: N, Tamanho: 1, Ocorrência: 0-1 (campo opcional). Valores: 0 = Pagamento à Vista, 1 = Pagamento à Prazo.
   */
  @RFWMetaEnumField(caption = "indPag", required = false)
  private SEFAZ_indPag indPag;

  /**
   * YA02 - tPag: Meio de pagamento. Tipo: N, Tamanho: 2, Ocorrência: 1-1 (obrigatório na estrutura). Ex.: 01=Dinheiro, 03=Cartão de Crédito, 17=PIX, 90=Sem pagamento, etc.
   */
  @RFWMetaEnumField(caption = "tPag", required = false)
  private SEFAZ_tPag tpag;

  /**
   * YA03 - vPag: Valor do Pagamento. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura).
   */
  @RFWMetaBigDecimalField(caption = "vPag", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vpag;

  /**
   * # {@link SEFAZPagVO}.
   *
   * @return the {@link SEFAZPagVO}
   */
  public SEFAZPagVO getPagVO() {
    return pagVO;
  }

  /**
   * # {@link SEFAZPagVO}.
   *
   * @param pagVO the new {@link SEFAZPagVO}
   */
  public void setPagVO(SEFAZPagVO pagVO) {
    this.pagVO = pagVO;
  }

  /**
   * # yA04 - card: Grupo de Cartões. Ocorrência: 0-1.
   * <p>
   * Informado quando o meio de pagamento (tPag) envolver cartão de crédito ou débito.
   *
   * @return the yA04 - card: Grupo de Cartões
   */
  public SEFAZCardVO getCard() {
    return card;
  }

  /**
   * # yA04 - card: Grupo de Cartões. Ocorrência: 0-1.
   * <p>
   * Informado quando o meio de pagamento (tPag) envolver cartão de crédito ou débito.
   *
   * @param card the new yA04 - card: Grupo de Cartões
   */
  public void setCard(SEFAZCardVO card) {
    this.card = card;
  }

  /**
   * # yA01b - indPag: Indicador da Forma de Pagamento. Tipo: N, Tamanho: 1, Ocorrência: 0-1 (campo opcional). Valores: 0 = Pagamento à Vista, 1 = Pagamento à Prazo.
   *
   * @return the yA01b - indPag: Indicador da Forma de Pagamento
   */
  public SEFAZ_indPag getIndPag() {
    return indPag;
  }

  /**
   * # yA01b - indPag: Indicador da Forma de Pagamento. Tipo: N, Tamanho: 1, Ocorrência: 0-1 (campo opcional). Valores: 0 = Pagamento à Vista, 1 = Pagamento à Prazo.
   *
   * @param indPag the new yA01b - indPag: Indicador da Forma de Pagamento
   */
  public void setIndPag(SEFAZ_indPag indPag) {
    this.indPag = indPag;
  }

  /**
   * # yA02 - tPag: Meio de pagamento. Tipo: N, Tamanho: 2, Ocorrência: 1-1 (obrigatório na estrutura). Ex.: 01=Dinheiro, 03=Cartão de Crédito, 17=PIX, 90=Sem pagamento, etc.
   *
   * @return the yA02 - tPag: Meio de pagamento
   */
  public SEFAZ_tPag getTpag() {
    return tpag;
  }

  /**
   * # yA02 - tPag: Meio de pagamento. Tipo: N, Tamanho: 2, Ocorrência: 1-1 (obrigatório na estrutura). Ex.: 01=Dinheiro, 03=Cartão de Crédito, 17=PIX, 90=Sem pagamento, etc.
   *
   * @param tpag the new yA02 - tPag: Meio de pagamento
   */
  public void setTpag(SEFAZ_tPag tpag) {
    this.tpag = tpag;
  }

  /**
   * # yA03 - vPag: Valor do Pagamento. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura).
   *
   * @return the yA03 - vPag: Valor do Pagamento
   */
  public BigDecimal getVpag() {
    return vpag;
  }

  /**
   * # yA03 - vPag: Valor do Pagamento. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura).
   *
   * @param vpag the new yA03 - vPag: Valor do Pagamento
   */
  public void setVpag(BigDecimal vpag) {
    this.vpag = vpag;
  }

}
