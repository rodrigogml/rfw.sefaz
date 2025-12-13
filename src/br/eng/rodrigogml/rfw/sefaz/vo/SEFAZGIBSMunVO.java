package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * gIBSMun - Grupo de Informações do IBS de competência do Município.
 */
public class SEFAZGIBSMunVO extends RFWVO {

  private static final long serialVersionUID = -25264745666510970L;

  /**
   * {@link SEFAZGIBSCBSVO}
   */
  @RFWMetaRelationshipField(caption = "IBSCBS", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true)
  private SEFAZGIBSCBSVO gibsCBSVO = null;

  /**
   * pIBSMun - Alíquota do IBS do Município.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota do IBS do Município", required = true, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pibsMun;

  /**
   * vIBSMun - Valor do IBS do Município.
   */
  @RFWMetaBigDecimalField(caption = "Valor do IBS do Município", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vibsMun;

  /**
   * pDif - Percentual do diferimento.
   */
  @RFWMetaBigDecimalField(caption = "Percentual do Diferimento", required = true, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pdif;

  /**
   * vDif - Valor do diferimento.
   */
  @RFWMetaBigDecimalField(caption = "Valor do Diferimento", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vdif;

  /**
   * vDevTrib - Valor do tributo devolvido.
   */
  @RFWMetaBigDecimalField(caption = "Valor do Tributo Devolvido", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vdevTrib;

  /**
   * pRedAliq - Percentual da redução de alíquota.
   */
  @RFWMetaBigDecimalField(caption = "Percentual de Redução da Alíquota", required = true, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal predAliq;

  /**
   * pAliqEfet - Alíquota efetiva após redução.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota Efetiva", required = true, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal paliqEfet;

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

  /**
   * # pIBSMun - Alíquota do IBS do Município.
   *
   * @return the pIBSMun - Alíquota do IBS do Município
   */
  public BigDecimal getPibsMun() {
    return pibsMun;
  }

  /**
   * # pIBSMun - Alíquota do IBS do Município.
   *
   * @param pibsMun the new pIBSMun - Alíquota do IBS do Município
   */
  public void setPibsMun(BigDecimal pibsMun) {
    this.pibsMun = pibsMun;
  }

  /**
   * # vIBSMun - Valor do IBS do Município.
   *
   * @return the vIBSMun - Valor do IBS do Município
   */
  public BigDecimal getVibsMun() {
    return vibsMun;
  }

  /**
   * # vIBSMun - Valor do IBS do Município.
   *
   * @param vibsMun the new vIBSMun - Valor do IBS do Município
   */
  public void setVibsMun(BigDecimal vibsMun) {
    this.vibsMun = vibsMun;
  }

  /**
   * # pDif - Percentual do diferimento.
   *
   * @return the pDif - Percentual do diferimento
   */
  public BigDecimal getPdif() {
    return pdif;
  }

  /**
   * # pDif - Percentual do diferimento.
   *
   * @param pdif the new pDif - Percentual do diferimento
   */
  public void setPdif(BigDecimal pdif) {
    this.pdif = pdif;
  }

  /**
   * # vDif - Valor do diferimento.
   *
   * @return the vDif - Valor do diferimento
   */
  public BigDecimal getVdif() {
    return vdif;
  }

  /**
   * # vDif - Valor do diferimento.
   *
   * @param vdif the new vDif - Valor do diferimento
   */
  public void setVdif(BigDecimal vdif) {
    this.vdif = vdif;
  }

  /**
   * # vDevTrib - Valor do tributo devolvido.
   *
   * @return the vDevTrib - Valor do tributo devolvido
   */
  public BigDecimal getVdevTrib() {
    return vdevTrib;
  }

  /**
   * # vDevTrib - Valor do tributo devolvido.
   *
   * @param vdevTrib the new vDevTrib - Valor do tributo devolvido
   */
  public void setVdevTrib(BigDecimal vdevTrib) {
    this.vdevTrib = vdevTrib;
  }

  /**
   * # pRedAliq - Percentual da redução de alíquota.
   *
   * @return the pRedAliq - Percentual da redução de alíquota
   */
  public BigDecimal getPredAliq() {
    return predAliq;
  }

  /**
   * # pRedAliq - Percentual da redução de alíquota.
   *
   * @param predAliq the new pRedAliq - Percentual da redução de alíquota
   */
  public void setPredAliq(BigDecimal predAliq) {
    this.predAliq = predAliq;
  }

  /**
   * # pAliqEfet - Alíquota efetiva após redução.
   *
   * @return the pAliqEfet - Alíquota efetiva após redução
   */
  public BigDecimal getPaliqEfet() {
    return paliqEfet;
  }

  /**
   * # pAliqEfet - Alíquota efetiva após redução.
   *
   * @param paliqEfet the new pAliqEfet - Alíquota efetiva após redução
   */
  public void setPaliqEfet(BigDecimal paliqEfet) {
    this.paliqEfet = paliqEfet;
  }

}