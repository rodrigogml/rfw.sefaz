package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * gCBS - Grupo de Informações da CBS.
 */
public class SEFAZGCBSVO extends RFWVO {

  private static final long serialVersionUID = -6866813984960472902L;

  /**
   * {@link SEFAZGIBSCBSVO}
   */
  @RFWMetaRelationshipField(caption = "IBSCBS", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true)
  private SEFAZGIBSCBSVO gibsCBSVO = null;

  /**
   * pCBS - Alíquota da CBS.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota da CBS", required = true, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pcbs;

  /**
   * vCBS - Valor da CBS.
   */
  @RFWMetaBigDecimalField(caption = "Valor da CBS", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vcbs;

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
   * # pCBS - Alíquota da CBS.
   *
   * @return the pCBS - Alíquota da CBS
   */
  public BigDecimal getPcbs() {
    return pcbs;
  }

  /**
   * # pCBS - Alíquota da CBS.
   *
   * @param pcbs the new pCBS - Alíquota da CBS
   */
  public void setPcbs(BigDecimal pcbs) {
    this.pcbs = pcbs;
  }

  /**
   * # vCBS - Valor da CBS.
   *
   * @return the vCBS - Valor da CBS
   */
  public BigDecimal getVcbs() {
    return vcbs;
  }

  /**
   * # vCBS - Valor da CBS.
   *
   * @param vcbs the new vCBS - Valor da CBS
   */
  public void setVcbs(BigDecimal vcbs) {
    this.vcbs = vcbs;
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