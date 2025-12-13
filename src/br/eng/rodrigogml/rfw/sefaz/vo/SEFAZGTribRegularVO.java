package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * gTribRegular - Grupo de Informações da Tributação Regular.
 */
public class SEFAZGTribRegularVO extends RFWVO {

  private static final long serialVersionUID = 2263774257570970104L;

  /**
   * {@link SEFAZGIBSCBSVO}
   */
  @RFWMetaRelationshipField(caption = "IBSCBS", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true)
  private SEFAZGIBSCBSVO gibsCBSVO = null;

  /**
   * CSTReg - Código de Situação Tributária regular do IBS e CBS.
   */
  @RFWMetaStringField(caption = "CST Regular do IBS e CBS", required = true, maxLength = 3, pattern = "^[0-9]{3}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cstreg;

  /**
   * cClassTribReg - Código de Classificação Tributária regular.
   */
  @RFWMetaStringField(caption = "Classificação Tributária Regular", required = true, maxLength = 6, pattern = "^[0-9]{6}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cclassTribReg;

  /**
   * pAliqEfetRegIBSUF - Alíquota efetiva do IBS da UF.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota Efetiva IBS UF", required = true, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal paliqEfetRegIbsUf;

  /**
   * vTribRegIBSUF - Valor do tributo IBS da UF.
   */
  @RFWMetaBigDecimalField(caption = "Valor do Tributo IBS UF", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vtribRegIbsUf;

  /**
   * pAliqEfetRegIBSMun - Alíquota efetiva do IBS do Município.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota Efetiva IBS Município", required = true, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal paliqEfetRegIbsMun;

  /**
   * vTribRegIBSMun - Valor do tributo IBS do Município.
   */
  @RFWMetaBigDecimalField(caption = "Valor do Tributo IBS Município", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vtribRegIbsMun;

  /**
   * pAliqEfetRegCBS - Alíquota efetiva da CBS.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota Efetiva CBS", required = true, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal paliqEfetRegCbs;

  /**
   * vTribRegCBS - Valor do tributo da CBS.
   */
  @RFWMetaBigDecimalField(caption = "Valor do Tributo CBS", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vtribRegCbs;

  /**
   * # cSTReg - Código de Situação Tributária regular do IBS e CBS.
   *
   * @return the cSTReg - Código de Situação Tributária regular do IBS e CBS
   */
  public String getCstreg() {
    return cstreg;
  }

  /**
   * # cSTReg - Código de Situação Tributária regular do IBS e CBS.
   *
   * @param cstreg the new cSTReg - Código de Situação Tributária regular do IBS e CBS
   */
  public void setCstreg(String cstreg) {
    this.cstreg = cstreg;
  }

  /**
   * # cClassTribReg - Código de Classificação Tributária regular.
   *
   * @return the cClassTribReg - Código de Classificação Tributária regular
   */
  public String getCclassTribReg() {
    return cclassTribReg;
  }

  /**
   * # cClassTribReg - Código de Classificação Tributária regular.
   *
   * @param cclassTribReg the new cClassTribReg - Código de Classificação Tributária regular
   */
  public void setCclassTribReg(String cclassTribReg) {
    this.cclassTribReg = cclassTribReg;
  }

  /**
   * # pAliqEfetRegIBSUF - Alíquota efetiva do IBS da UF.
   *
   * @return the pAliqEfetRegIBSUF - Alíquota efetiva do IBS da UF
   */
  public BigDecimal getPaliqEfetRegIbsUf() {
    return paliqEfetRegIbsUf;
  }

  /**
   * # pAliqEfetRegIBSUF - Alíquota efetiva do IBS da UF.
   *
   * @param paliqEfetRegIbsUf the new pAliqEfetRegIBSUF - Alíquota efetiva do IBS da UF
   */
  public void setPaliqEfetRegIbsUf(BigDecimal paliqEfetRegIbsUf) {
    this.paliqEfetRegIbsUf = paliqEfetRegIbsUf;
  }

  /**
   * # vTribRegIBSUF - Valor do tributo IBS da UF.
   *
   * @return the vTribRegIBSUF - Valor do tributo IBS da UF
   */
  public BigDecimal getVtribRegIbsUf() {
    return vtribRegIbsUf;
  }

  /**
   * # vTribRegIBSUF - Valor do tributo IBS da UF.
   *
   * @param vtribRegIbsUf the new vTribRegIBSUF - Valor do tributo IBS da UF
   */
  public void setVtribRegIbsUf(BigDecimal vtribRegIbsUf) {
    this.vtribRegIbsUf = vtribRegIbsUf;
  }

  /**
   * # pAliqEfetRegIBSMun - Alíquota efetiva do IBS do Município.
   *
   * @return the pAliqEfetRegIBSMun - Alíquota efetiva do IBS do Município
   */
  public BigDecimal getPaliqEfetRegIbsMun() {
    return paliqEfetRegIbsMun;
  }

  /**
   * # pAliqEfetRegIBSMun - Alíquota efetiva do IBS do Município.
   *
   * @param paliqEfetRegIbsMun the new pAliqEfetRegIBSMun - Alíquota efetiva do IBS do Município
   */
  public void setPaliqEfetRegIbsMun(BigDecimal paliqEfetRegIbsMun) {
    this.paliqEfetRegIbsMun = paliqEfetRegIbsMun;
  }

  /**
   * # vTribRegIBSMun - Valor do tributo IBS do Município.
   *
   * @return the vTribRegIBSMun - Valor do tributo IBS do Município
   */
  public BigDecimal getVtribRegIbsMun() {
    return vtribRegIbsMun;
  }

  /**
   * # vTribRegIBSMun - Valor do tributo IBS do Município.
   *
   * @param vtribRegIbsMun the new vTribRegIBSMun - Valor do tributo IBS do Município
   */
  public void setVtribRegIbsMun(BigDecimal vtribRegIbsMun) {
    this.vtribRegIbsMun = vtribRegIbsMun;
  }

  /**
   * # pAliqEfetRegCBS - Alíquota efetiva da CBS.
   *
   * @return the pAliqEfetRegCBS - Alíquota efetiva da CBS
   */
  public BigDecimal getPaliqEfetRegCbs() {
    return paliqEfetRegCbs;
  }

  /**
   * # pAliqEfetRegCBS - Alíquota efetiva da CBS.
   *
   * @param paliqEfetRegCbs the new pAliqEfetRegCBS - Alíquota efetiva da CBS
   */
  public void setPaliqEfetRegCbs(BigDecimal paliqEfetRegCbs) {
    this.paliqEfetRegCbs = paliqEfetRegCbs;
  }

  /**
   * # vTribRegCBS - Valor do tributo da CBS.
   *
   * @return the vTribRegCBS - Valor do tributo da CBS
   */
  public BigDecimal getVtribRegCbs() {
    return vtribRegCbs;
  }

  /**
   * # vTribRegCBS - Valor do tributo da CBS.
   *
   * @param vtribRegCbs the new vTribRegCBS - Valor do tributo da CBS
   */
  public void setVtribRegCbs(BigDecimal vtribRegCbs) {
    this.vtribRegCbs = vtribRegCbs;
  }

  /**
   * # {@link SEFAZGIBSCBSVO}.
   *
   * @return the {@link SEFAZGIBSCBSVO}
   */
  public SEFAZGIBSCBSVO getGibsCBSVO() {
    return gibsCBSVO;
  }

  /**
   * # {@link SEFAZGIBSCBSVO}.
   *
   * @param gibsCBSVO the new {@link SEFAZGIBSCBSVO}
   */
  public void setGibsCBSVO(SEFAZGIBSCBSVO gibsCBSVO) {
    this.gibsCBSVO = gibsCBSVO;
  }
}
