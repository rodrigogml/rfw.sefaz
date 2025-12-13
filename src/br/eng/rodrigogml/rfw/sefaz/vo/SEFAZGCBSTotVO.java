package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * gCBS - Grupo total da CBS.
 */
public class SEFAZGCBSTotVO extends RFWVO {

  private static final long serialVersionUID = -8206151624561270110L;

  /**
   * {@link SEFAZIBSCBSTotVO}
   */
  @RFWMetaRelationshipField(caption = "Total", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true)
  private SEFAZIBSCBSTotVO ibsCBSTotVO = null;

  /**
   * vDif - Valor total do diferimento da CBS.
   */
  @RFWMetaBigDecimalField(caption = "Total do Diferimento da CBS", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vdif;

  /**
   * vDevTrib - Valor total da devolução de tributos da CBS.
   */
  @RFWMetaBigDecimalField(caption = "Total da Devolução de Tributos da CBS", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vdevTrib;

  /**
   * vCBS - Valor total da CBS.
   */
  @RFWMetaBigDecimalField(caption = "Total da CBS", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vcbs;

  /**
   * vCredPres - Valor total do crédito presumido da CBS.
   */
  @RFWMetaBigDecimalField(caption = "Total do Crédito Presumido da CBS", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vcredPres;

  /**
   * vCredPresCondSus - Valor total do crédito presumido da CBS em condição suspensiva.
   */
  @RFWMetaBigDecimalField(caption = "Total do Crédito Presumido da CBS em Condição Suspensiva", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vcredPresCondSus;

  /**
   * # {@link SEFAZIBSCBSTotVO}.
   *
   * @return the {@link SEFAZIBSCBSTotVO}
   */
  public SEFAZIBSCBSTotVO getIbsCBSTotVO() {
    return ibsCBSTotVO;
  }

  /**
   * # {@link SEFAZIBSCBSTotVO}.
   *
   * @param ibsCBSTotVO the new {@link SEFAZIBSCBSTotVO}
   */
  public void setIbsCBSTotVO(SEFAZIBSCBSTotVO ibsCBSTotVO) {
    this.ibsCBSTotVO = ibsCBSTotVO;
  }

  /**
   * # vDif - Valor total do diferimento da CBS.
   *
   * @return the vDif - Valor total do diferimento da CBS
   */
  public BigDecimal getVdif() {
    return vdif;
  }

  /**
   * # vDif - Valor total do diferimento da CBS.
   *
   * @param vdif the new vDif - Valor total do diferimento da CBS
   */
  public void setVdif(BigDecimal vdif) {
    this.vdif = vdif;
  }

  /**
   * # vDevTrib - Valor total da devolução de tributos da CBS.
   *
   * @return the vDevTrib - Valor total da devolução de tributos da CBS
   */
  public BigDecimal getVdevTrib() {
    return vdevTrib;
  }

  /**
   * # vDevTrib - Valor total da devolução de tributos da CBS.
   *
   * @param vdevTrib the new vDevTrib - Valor total da devolução de tributos da CBS
   */
  public void setVdevTrib(BigDecimal vdevTrib) {
    this.vdevTrib = vdevTrib;
  }

  /**
   * # vCBS - Valor total da CBS.
   *
   * @return the vCBS - Valor total da CBS
   */
  public BigDecimal getVcbs() {
    return vcbs;
  }

  /**
   * # vCBS - Valor total da CBS.
   *
   * @param vcbs the new vCBS - Valor total da CBS
   */
  public void setVcbs(BigDecimal vcbs) {
    this.vcbs = vcbs;
  }

  /**
   * # vCredPres - Valor total do crédito presumido da CBS.
   *
   * @return the vCredPres - Valor total do crédito presumido da CBS
   */
  public BigDecimal getVcredPres() {
    return vcredPres;
  }

  /**
   * # vCredPres - Valor total do crédito presumido da CBS.
   *
   * @param vcredPres the new vCredPres - Valor total do crédito presumido da CBS
   */
  public void setVcredPres(BigDecimal vcredPres) {
    this.vcredPres = vcredPres;
  }

  /**
   * # vCredPresCondSus - Valor total do crédito presumido da CBS em condição suspensiva.
   *
   * @return the vCredPresCondSus - Valor total do crédito presumido da CBS em condição suspensiva
   */
  public BigDecimal getVcredPresCondSus() {
    return vcredPresCondSus;
  }

  /**
   * # vCredPresCondSus - Valor total do crédito presumido da CBS em condição suspensiva.
   *
   * @param vcredPresCondSus the new vCredPresCondSus - Valor total do crédito presumido da CBS em condição suspensiva
   */
  public void setVcredPresCondSus(BigDecimal vcredPresCondSus) {
    this.vcredPresCondSus = vcredPresCondSus;
  }
}
