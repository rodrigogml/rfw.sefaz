package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * gMono - Grupo total da Monofasia.
 */
public class SEFAZGMonoTotVO extends RFWVO {

  private static final long serialVersionUID = 8169807621002055530L;

  /**
   * {@link SEFAZIBSCBSTotVO}
   */
  @RFWMetaRelationshipField(caption = "Total", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true)
  private SEFAZIBSCBSTotVO ibsCBSTotVO = null;

  /**
   * vIBSMono - Total do IBS monofásico.
   */
  @RFWMetaBigDecimalField(caption = "Total do IBS Monofásico", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vibsMono;

  /**
   * vCBSMono - Total da CBS monofásica.
   */
  @RFWMetaBigDecimalField(caption = "Total da CBS Monofásica", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vcbsMono;

  /**
   * vIBSMonoReten - Total do IBS monofásico sujeito à retenção.
   */
  @RFWMetaBigDecimalField(caption = "Total do IBS Monofásico com Retenção", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vibsMonoReten;

  /**
   * vCBSMonoReten - Total da CBS monofásica sujeita à retenção.
   */
  @RFWMetaBigDecimalField(caption = "Total da CBS Monofásica com Retenção", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vcbsMonoReten;

  /**
   * vIBSMonoRet - Total do IBS monofásico retido anteriormente.
   */
  @RFWMetaBigDecimalField(caption = "Total do IBS Monofásico Retido Anteriormente", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vibsMonoRet;

  /**
   * vCBSMonoRet - Total da CBS monofásica retida anteriormente.
   */
  @RFWMetaBigDecimalField(caption = "Total da CBS Monofásica Retida Anteriormente", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vcbsMonoRet;

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
   * # vIBSMono - Total do IBS monofásico.
   *
   * @return the vIBSMono - Total do IBS monofásico
   */
  public BigDecimal getVibsMono() {
    return vibsMono;
  }

  /**
   * # vIBSMono - Total do IBS monofásico.
   *
   * @param vibsMono the new vIBSMono - Total do IBS monofásico
   */
  public void setVibsMono(BigDecimal vibsMono) {
    this.vibsMono = vibsMono;
  }

  /**
   * # vCBSMono - Total da CBS monofásica.
   *
   * @return the vCBSMono - Total da CBS monofásica
   */
  public BigDecimal getVcbsMono() {
    return vcbsMono;
  }

  /**
   * # vCBSMono - Total da CBS monofásica.
   *
   * @param vcbsMono the new vCBSMono - Total da CBS monofásica
   */
  public void setVcbsMono(BigDecimal vcbsMono) {
    this.vcbsMono = vcbsMono;
  }

  /**
   * # vIBSMonoReten - Total do IBS monofásico sujeito à retenção.
   *
   * @return the vIBSMonoReten - Total do IBS monofásico sujeito à retenção
   */
  public BigDecimal getVibsMonoReten() {
    return vibsMonoReten;
  }

  /**
   * # vIBSMonoReten - Total do IBS monofásico sujeito à retenção.
   *
   * @param vibsMonoReten the new vIBSMonoReten - Total do IBS monofásico sujeito à retenção
   */
  public void setVibsMonoReten(BigDecimal vibsMonoReten) {
    this.vibsMonoReten = vibsMonoReten;
  }

  /**
   * # vCBSMonoReten - Total da CBS monofásica sujeita à retenção.
   *
   * @return the vCBSMonoReten - Total da CBS monofásica sujeita à retenção
   */
  public BigDecimal getVcbsMonoReten() {
    return vcbsMonoReten;
  }

  /**
   * # vCBSMonoReten - Total da CBS monofásica sujeita à retenção.
   *
   * @param vcbsMonoReten the new vCBSMonoReten - Total da CBS monofásica sujeita à retenção
   */
  public void setVcbsMonoReten(BigDecimal vcbsMonoReten) {
    this.vcbsMonoReten = vcbsMonoReten;
  }

  /**
   * # vIBSMonoRet - Total do IBS monofásico retido anteriormente.
   *
   * @return the vIBSMonoRet - Total do IBS monofásico retido anteriormente
   */
  public BigDecimal getVibsMonoRet() {
    return vibsMonoRet;
  }

  /**
   * # vIBSMonoRet - Total do IBS monofásico retido anteriormente.
   *
   * @param vibsMonoRet the new vIBSMonoRet - Total do IBS monofásico retido anteriormente
   */
  public void setVibsMonoRet(BigDecimal vibsMonoRet) {
    this.vibsMonoRet = vibsMonoRet;
  }

  /**
   * # vCBSMonoRet - Total da CBS monofásica retida anteriormente.
   *
   * @return the vCBSMonoRet - Total da CBS monofásica retida anteriormente
   */
  public BigDecimal getVcbsMonoRet() {
    return vcbsMonoRet;
  }

  /**
   * # vCBSMonoRet - Total da CBS monofásica retida anteriormente.
   *
   * @param vcbsMonoRet the new vCBSMonoRet - Total da CBS monofásica retida anteriormente
   */
  public void setVcbsMonoRet(BigDecimal vcbsMonoRet) {
    this.vcbsMonoRet = vcbsMonoRet;
  }
}
