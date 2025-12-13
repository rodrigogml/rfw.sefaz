package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * gMonoRet - Grupo de informações da Tributação Monofásica Retida Anteriormente.
 */
public class SEFAZGMonoRetVO extends RFWVO {

  private static final long serialVersionUID = 7181196882147266275L;

  /**
   * {@link SEFAZGIBSCBSMonoVO}
   */
  @RFWMetaRelationshipField(caption = "IBSCBS", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true)
  private SEFAZGIBSCBSMonoVO gibsCBSMonoVO = null;

  /**
   * qBCMonoRet - Quantidade tributada retida anteriormente.
   */
  @RFWMetaBigDecimalField(caption = "Quantidade Retida Anteriormente", required = true, scale = 0, scaleMax = 4, absolute = true)
  private BigDecimal qbcMonoRet;

  /**
   * adRemIBSRet - Alíquota ad rem do IBS retido anteriormente.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota ad rem do IBS Retido", required = true, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal adremIbsRet;

  /**
   * vIBSMonoRet - Valor do IBS retido anteriormente.
   */
  @RFWMetaBigDecimalField(caption = "Valor do IBS Retido Anteriormente", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vibsMonoRet;

  /**
   * adRemCBSRet - Alíquota ad rem da CBS retida anteriormente.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota ad rem da CBS Retida", required = true, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal adremCbsRet;

  /**
   * vCBSMonoRet - Valor da CBS retida anteriormente.
   */
  @RFWMetaBigDecimalField(caption = "Valor da CBS Retida Anteriormente", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vcbsMonoRet;

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

  /**
   * # qBCMonoRet - Quantidade tributada retida anteriormente.
   *
   * @return the qBCMonoRet - Quantidade tributada retida anteriormente
   */
  public BigDecimal getQbcMonoRet() {
    return qbcMonoRet;
  }

  /**
   * # qBCMonoRet - Quantidade tributada retida anteriormente.
   *
   * @param qbcMonoRet the new qBCMonoRet - Quantidade tributada retida anteriormente
   */
  public void setQbcMonoRet(BigDecimal qbcMonoRet) {
    this.qbcMonoRet = qbcMonoRet;
  }

  /**
   * # adRemIBSRet - Alíquota ad rem do IBS retido anteriormente.
   *
   * @return the adRemIBSRet - Alíquota ad rem do IBS retido anteriormente
   */
  public BigDecimal getAdremIbsRet() {
    return adremIbsRet;
  }

  /**
   * # adRemIBSRet - Alíquota ad rem do IBS retido anteriormente.
   *
   * @param adremIbsRet the new adRemIBSRet - Alíquota ad rem do IBS retido anteriormente
   */
  public void setAdremIbsRet(BigDecimal adremIbsRet) {
    this.adremIbsRet = adremIbsRet;
  }

  /**
   * # vIBSMonoRet - Valor do IBS retido anteriormente.
   *
   * @return the vIBSMonoRet - Valor do IBS retido anteriormente
   */
  public BigDecimal getVibsMonoRet() {
    return vibsMonoRet;
  }

  /**
   * # vIBSMonoRet - Valor do IBS retido anteriormente.
   *
   * @param vibsMonoRet the new vIBSMonoRet - Valor do IBS retido anteriormente
   */
  public void setVibsMonoRet(BigDecimal vibsMonoRet) {
    this.vibsMonoRet = vibsMonoRet;
  }

  /**
   * # adRemCBSRet - Alíquota ad rem da CBS retida anteriormente.
   *
   * @return the adRemCBSRet - Alíquota ad rem da CBS retida anteriormente
   */
  public BigDecimal getAdremCbsRet() {
    return adremCbsRet;
  }

  /**
   * # adRemCBSRet - Alíquota ad rem da CBS retida anteriormente.
   *
   * @param adremCbsRet the new adRemCBSRet - Alíquota ad rem da CBS retida anteriormente
   */
  public void setAdremCbsRet(BigDecimal adremCbsRet) {
    this.adremCbsRet = adremCbsRet;
  }

  /**
   * # vCBSMonoRet - Valor da CBS retida anteriormente.
   *
   * @return the vCBSMonoRet - Valor da CBS retida anteriormente
   */
  public BigDecimal getVcbsMonoRet() {
    return vcbsMonoRet;
  }

  /**
   * # vCBSMonoRet - Valor da CBS retida anteriormente.
   *
   * @param vcbsMonoRet the new vCBSMonoRet - Valor da CBS retida anteriormente
   */
  public void setVcbsMonoRet(BigDecimal vcbsMonoRet) {
    this.vcbsMonoRet = vcbsMonoRet;
  }

}
