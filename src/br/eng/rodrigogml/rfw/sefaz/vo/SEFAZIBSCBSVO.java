package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CST_IBSCBS;

/**
 * IBSCBS - Informações do Imposto sobre Bens e Serviços (IBS) e da Contribuição sobre Bens e Serviços (CBS).
 *
 * @author Rodrigo Leitão
 * @since (13 de dez. de 2025)
 */
public class SEFAZIBSCBSVO extends RFWVO {

  private static final long serialVersionUID = -3837222129422932793L;

  /**
   * {@link SEFAZGIIBSCBSVO}
   */
  @RFWMetaRelationshipField(caption = "ICMS", relationship = RelationshipTypes.COMPOSITION, required = false)
  private SEFAZGIBSCBSVO gibsCbs;

  /**
   * CST - Código de Situação Tributária do IBS e CBS.
   */
  @RFWMetaStringField(caption = "CST do IBS e CBS", required = false, maxLength = 3, pattern = "^[0-9]{3}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private SEFAZ_CST_IBSCBS cst;

  /**
   * cClassTrib - Código de Classificação Tributária do IBS e CBS.
   */
  @RFWMetaStringField(caption = "Classificação Tributária do IBS e CBS", required = false, maxLength = 6, pattern = "^[0-9]{6}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cclassTrib;

  /**
   * indDoacao - Indicador da natureza da operação de doação.
   * <p>
   * Informar "1" quando doação.
   */
  @RFWMetaStringField(caption = "Indicador de Doação", required = false, maxLength = 1, pattern = "^[0-9]{1}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String indDoacao;

  /**
   * Gets the gibs cbs.
   *
   * @return the gibs cbs
   */
  public SEFAZGIBSCBSVO getGibsCbs() {
    return gibsCbs;
  }

  /**
   * Sets the gibs cbs.
   *
   * @param gibsCbs the new gibs cbs
   */
  public void setGibsCbs(SEFAZGIBSCBSVO gibsCbs) {
    this.gibsCbs = gibsCbs;
  }

  /**
   * # cST - Código de Situação Tributária do IBS e CBS.
   *
   * @return the cST - Código de Situação Tributária do IBS e CBS
   */
  public SEFAZ_CST_IBSCBS getCst() {
    return cst;
  }

  /**
   * # cST - Código de Situação Tributária do IBS e CBS.
   *
   * @param cst the new cST - Código de Situação Tributária do IBS e CBS
   */
  public void setCst(SEFAZ_CST_IBSCBS cst) {
    this.cst = cst;
  }

  /**
   * # cClassTrib - Código de Classificação Tributária do IBS e CBS.
   *
   * @return the cClassTrib - Código de Classificação Tributária do IBS e CBS
   */
  public String getCclassTrib() {
    return cclassTrib;
  }

  /**
   * # cClassTrib - Código de Classificação Tributária do IBS e CBS.
   *
   * @param cclassTrib the new cClassTrib - Código de Classificação Tributária do IBS e CBS
   */
  public void setCclassTrib(String cclassTrib) {
    this.cclassTrib = cclassTrib;
  }

  /**
   * # indDoacao - Indicador da natureza da operação de doação.
   * <p>
   * Informar "1" quando doação.
   *
   * @return the indDoacao - Indicador da natureza da operação de doação
   */
  public String getIndDoacao() {
    return indDoacao;
  }

  /**
   * # indDoacao - Indicador da natureza da operação de doação.
   * <p>
   * Informar "1" quando doação.
   *
   * @param indDoacao the new indDoacao - Indicador da natureza da operação de doação
   */
  public void setIndDoacao(String indDoacao) {
    this.indDoacao = indDoacao;
  }

}
