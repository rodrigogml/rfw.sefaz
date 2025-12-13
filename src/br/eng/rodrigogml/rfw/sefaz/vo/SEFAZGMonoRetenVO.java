package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * gMonoReten - Grupo de informações da Tributação Monofásica Sujeita à Retenção.
 */
public class SEFAZGMonoRetenVO extends RFWVO {

  private static final long serialVersionUID = -5064919138181140918L;

  /**
   * {@link SEFAZGIBSCBSMonoVO}
   */
  @RFWMetaRelationshipField(caption = "IBSCBS", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true)
  private SEFAZGIBSCBSMonoVO gibsCBSMonoVO = null;

  /**
   * qBCMonoReten - Quantidade tributada sujeita à retenção.
   */
  @RFWMetaBigDecimalField(caption = "Quantidade Tributada com Retenção", required = true, scale = 0, scaleMax = 4, absolute = true)
  private BigDecimal qbcMonoReten;

  /**
   * adRemIBSReten - Alíquota ad rem do IBS sujeita à retenção.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota ad rem do IBS com Retenção", required = true, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal adremIbsReten;

  /**
   * vIBSMonoReten - Valor do IBS monofásico sujeito à retenção.
   */
  @RFWMetaBigDecimalField(caption = "Valor do IBS Monofásico com Retenção", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vibsMonoReten;

  /**
   * adRemCBSReten - Alíquota ad rem da CBS sujeita à retenção.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota ad rem da CBS com Retenção", required = true, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal adremCbsReten;

  /**
   * vCBSMonoReten - Valor da CBS monofásica sujeita à retenção.
   */
  @RFWMetaBigDecimalField(caption = "Valor da CBS Monofásica com Retenção", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vcbsMonoReten;

  /**
   * # qBCMonoReten - Quantidade tributada sujeita à retenção.
   *
   * @return the qBCMonoReten - Quantidade tributada sujeita à retenção
   */
  public BigDecimal getQbcMonoReten() {
    return qbcMonoReten;
  }

  /**
   * # qBCMonoReten - Quantidade tributada sujeita à retenção.
   *
   * @param qbcMonoReten the new qBCMonoReten - Quantidade tributada sujeita à retenção
   */
  public void setQbcMonoReten(BigDecimal qbcMonoReten) {
    this.qbcMonoReten = qbcMonoReten;
  }

  /**
   * # adRemIBSReten - Alíquota ad rem do IBS sujeita à retenção.
   *
   * @return the adRemIBSReten - Alíquota ad rem do IBS sujeita à retenção
   */
  public BigDecimal getAdremIbsReten() {
    return adremIbsReten;
  }

  /**
   * # adRemIBSReten - Alíquota ad rem do IBS sujeita à retenção.
   *
   * @param adremIbsReten the new adRemIBSReten - Alíquota ad rem do IBS sujeita à retenção
   */
  public void setAdremIbsReten(BigDecimal adremIbsReten) {
    this.adremIbsReten = adremIbsReten;
  }

  /**
   * # vIBSMonoReten - Valor do IBS monofásico sujeito à retenção.
   *
   * @return the vIBSMonoReten - Valor do IBS monofásico sujeito à retenção
   */
  public BigDecimal getVibsMonoReten() {
    return vibsMonoReten;
  }

  /**
   * # vIBSMonoReten - Valor do IBS monofásico sujeito à retenção.
   *
   * @param vibsMonoReten the new vIBSMonoReten - Valor do IBS monofásico sujeito à retenção
   */
  public void setVibsMonoReten(BigDecimal vibsMonoReten) {
    this.vibsMonoReten = vibsMonoReten;
  }

  /**
   * # adRemCBSReten - Alíquota ad rem da CBS sujeita à retenção.
   *
   * @return the adRemCBSReten - Alíquota ad rem da CBS sujeita à retenção
   */
  public BigDecimal getAdremCbsReten() {
    return adremCbsReten;
  }

  /**
   * # adRemCBSReten - Alíquota ad rem da CBS sujeita à retenção.
   *
   * @param adremCbsReten the new adRemCBSReten - Alíquota ad rem da CBS sujeita à retenção
   */
  public void setAdremCbsReten(BigDecimal adremCbsReten) {
    this.adremCbsReten = adremCbsReten;
  }

  /**
   * # vCBSMonoReten - Valor da CBS monofásica sujeita à retenção.
   *
   * @return the vCBSMonoReten - Valor da CBS monofásica sujeita à retenção
   */
  public BigDecimal getVcbsMonoReten() {
    return vcbsMonoReten;
  }

  /**
   * # vCBSMonoReten - Valor da CBS monofásica sujeita à retenção.
   *
   * @param vcbsMonoReten the new vCBSMonoReten - Valor da CBS monofásica sujeita à retenção
   */
  public void setVcbsMonoReten(BigDecimal vcbsMonoReten) {
    this.vcbsMonoReten = vcbsMonoReten;
  }

  /**
   * # {@link SEFAZGIBSCBSMonoVO}.
   *
   * @return the {@link SEFAZGIBSCBSMonoVO}
   */
  public SEFAZGIBSCBSMonoVO getGibsCBSMonoVO() {
    return gibsCBSMonoVO;
  }

  /**
   * # {@link SEFAZGIBSCBSMonoVO}.
   *
   * @param gibsCBSMonoVO the new {@link SEFAZGIBSCBSMonoVO}
   */
  public void setGibsCBSMonoVO(SEFAZGIBSCBSMonoVO gibsCBSMonoVO) {
    this.gibsCBSMonoVO = gibsCBSMonoVO;
  }
}
