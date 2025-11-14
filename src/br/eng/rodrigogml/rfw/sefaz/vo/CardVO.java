package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCNPJField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tBand;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tpIntegra;

/**
 * Grupo YA04 - card: Informações de pagamento com cartão.
 * <p>
 * Ocorre 0-1 dentro de YA01a (detPag).
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_card")
public class CardVO extends RFWVO {

  private static final long serialVersionUID = 2300797850028354990L;

  /**
   * {@link DetPagVO}
   */
  @RFWMetaRelationshipField(caption = "DetPag", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_detpag")
  private DetPagVO detPagVO = null;

  /**
   * YA04a - tpIntegra: Tipo de Integração para pagamento. Tipo: N, Tamanho: 1, Ocorrência: 1-1 (obrigatório na estrutura do grupo card). Valores: 1 = Pagamento integrado com o sistema de automação da empresa (TEF, e-commerce etc.); 2 = Pagamento não integrado (POS, etc.).
   */
  @RFWMetaEnumField(caption = "tpIntegra", required = false)
  private SEFAZ_tpIntegra tpIntegra;

  /**
   * YA05 - CNPJ: CNPJ da instituição de pagamento. Tipo: C, Tamanho: 14, Ocorrência: 0-1.
   * <p>
   * Informar o CNPJ da instituição de pagamento, adquirente ou subadquirente. Caso o pagamento seja processado por intermediador da transação, informar o CNPJ deste.
   */
  @RFWMetaStringCNPJField(caption = "CNPJ", required = false, unique = false)
  private String cnpj;

  /**
   * YA06 - tBand: Bandeira da operadora de cartão de crédito e/ou débito. Tipo: N, Tamanho: 2, Ocorrência: 0-1. Exemplos: 01=Visa, 02=Mastercard, 06=Elo, 99=Outros.
   */
  @RFWMetaEnumField(caption = "tBand", required = false)
  private SEFAZ_tBand tband;

  /**
   * YA07 - cAut: Número de autorização da operação com cartão. Tipo: C, Tamanho: 1-20, Ocorrência: 0-1.
   * <p>
   * Identifica o número de autorização da transação da operação com cartão de crédito e/ou débito.
   */
  @RFWMetaStringField(caption = "cAut", required = false, unique = false, maxLength = 20, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String caut;

  /**
   * # {@link DetPagVO}.
   *
   * @return the {@link DetPagVO}
   */
  public DetPagVO getDetPagVO() {
    return detPagVO;
  }

  /**
   * # {@link DetPagVO}.
   *
   * @param detPagVO the new {@link DetPagVO}
   */
  public void setDetPagVO(DetPagVO detPagVO) {
    this.detPagVO = detPagVO;
  }

  /**
   * # yA04a - tpIntegra: Tipo de Integração para pagamento. Tipo: N, Tamanho: 1, Ocorrência: 1-1 (obrigatório na estrutura do grupo card). Valores: 1 = Pagamento integrado com o sistema de automação da empresa (TEF, e-commerce etc.); 2 = Pagamento não integrado (POS, etc.).
   *
   * @return the yA04a - tpIntegra: Tipo de Integração para pagamento
   */
  public SEFAZ_tpIntegra getTpIntegra() {
    return tpIntegra;
  }

  /**
   * # yA04a - tpIntegra: Tipo de Integração para pagamento. Tipo: N, Tamanho: 1, Ocorrência: 1-1 (obrigatório na estrutura do grupo card). Valores: 1 = Pagamento integrado com o sistema de automação da empresa (TEF, e-commerce etc.); 2 = Pagamento não integrado (POS, etc.).
   *
   * @param tpIntegra the new yA04a - tpIntegra: Tipo de Integração para pagamento
   */
  public void setTpIntegra(SEFAZ_tpIntegra tpIntegra) {
    this.tpIntegra = tpIntegra;
  }

  /**
   * # yA05 - CNPJ: CNPJ da instituição de pagamento. Tipo: C, Tamanho: 14, Ocorrência: 0-1.
   * <p>
   * Informar o CNPJ da instituição de pagamento, adquirente ou subadquirente. Caso o pagamento seja processado por intermediador da transação, informar o CNPJ deste.
   *
   * @return the yA05 - CNPJ: CNPJ da instituição de pagamento
   */
  public String getCnpj() {
    return cnpj;
  }

  /**
   * # yA05 - CNPJ: CNPJ da instituição de pagamento. Tipo: C, Tamanho: 14, Ocorrência: 0-1.
   * <p>
   * Informar o CNPJ da instituição de pagamento, adquirente ou subadquirente. Caso o pagamento seja processado por intermediador da transação, informar o CNPJ deste.
   *
   * @param cnpj the new yA05 - CNPJ: CNPJ da instituição de pagamento
   */
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  /**
   * # yA06 - tBand: Bandeira da operadora de cartão de crédito e/ou débito. Tipo: N, Tamanho: 2, Ocorrência: 0-1. Exemplos: 01=Visa, 02=Mastercard, 06=Elo, 99=Outros.
   *
   * @return the yA06 - tBand: Bandeira da operadora de cartão de crédito e/ou débito
   */
  public SEFAZ_tBand getTband() {
    return tband;
  }

  /**
   * # yA06 - tBand: Bandeira da operadora de cartão de crédito e/ou débito. Tipo: N, Tamanho: 2, Ocorrência: 0-1. Exemplos: 01=Visa, 02=Mastercard, 06=Elo, 99=Outros.
   *
   * @param tband the new yA06 - tBand: Bandeira da operadora de cartão de crédito e/ou débito
   */
  public void setTband(SEFAZ_tBand tband) {
    this.tband = tband;
  }

  /**
   * # yA07 - cAut: Número de autorização da operação com cartão. Tipo: C, Tamanho: 1-20, Ocorrência: 0-1.
   * <p>
   * Identifica o número de autorização da transação da operação com cartão de crédito e/ou débito.
   *
   * @return the yA07 - cAut: Número de autorização da operação com cartão
   */
  public String getCaut() {
    return caut;
  }

  /**
   * # yA07 - cAut: Número de autorização da operação com cartão. Tipo: C, Tamanho: 1-20, Ocorrência: 0-1.
   * <p>
   * Identifica o número de autorização da transação da operação com cartão de crédito e/ou débito.
   *
   * @param caut the new yA07 - cAut: Número de autorização da operação com cartão
   */
  public void setCaut(String caut) {
    this.caut = caut;
  }

}
