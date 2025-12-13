/*
 *
 */
package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * gMonoPadrao - Grupo de informações da Tributação Monofásica Padrão.
 */
public class SEFAZGMonoPadraoVO extends RFWVO {

  private static final long serialVersionUID = 1332377110837583987L;

  /**
   * {@link SEFAZGIBSCBSMonoVO}
   */
  @RFWMetaRelationshipField(caption = "IBSCBS", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true)
  private SEFAZGIBSCBSMonoVO gibsCBSMonoVO = null;

  /**
   * qBCMono - Quantidade tributada na monofasia.
   */
  @RFWMetaBigDecimalField(caption = "Quantidade Tributável Monofásica", required = true, scale = 0, scaleMax = 4, absolute = true)
  private BigDecimal qbcMono;

  /**
   * adRemIBS - Alíquota ad rem do IBS.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota ad rem do IBS", required = true, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal adremIbs;

  /**
   * adRemCBS - Alíquota ad rem da CBS.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota ad rem da CBS", required = true, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal adremCbs;

  /**
   * vIBSMono - Valor do IBS monofásico.
   */
  @RFWMetaBigDecimalField(caption = "Valor do IBS Monofásico", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vibsMono;

  /**
   * vCBSMono - Valor da CBS monofásica.
   */
  @RFWMetaBigDecimalField(caption = "Valor da CBS Monofásica", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vcbsMono;

  /**
   * # qBCMono - Quantidade tributada na monofasia.
   *
   * @return the qBCMono - Quantidade tributada na monofasia
   */
  public BigDecimal getQbcMono() {
    return qbcMono;
  }

  /**
   * # qBCMono - Quantidade tributada na monofasia.
   *
   * @param qbcMono the new qBCMono - Quantidade tributada na monofasia
   */
  public void setQbcMono(BigDecimal qbcMono) {
    this.qbcMono = qbcMono;
  }

  /**
   * # adRemIBS - Alíquota ad rem do IBS.
   *
   * @return the adRemIBS - Alíquota ad rem do IBS
   */
  public BigDecimal getAdremIbs() {
    return adremIbs;
  }

  /**
   * # adRemIBS - Alíquota ad rem do IBS.
   *
   * @param adremIbs the new adRemIBS - Alíquota ad rem do IBS
   */
  public void setAdremIbs(BigDecimal adremIbs) {
    this.adremIbs = adremIbs;
  }

  /**
   * # adRemCBS - Alíquota ad rem da CBS.
   *
   * @return the adRemCBS - Alíquota ad rem da CBS
   */
  public BigDecimal getAdremCbs() {
    return adremCbs;
  }

  /**
   * # adRemCBS - Alíquota ad rem da CBS.
   *
   * @param adremCbs the new adRemCBS - Alíquota ad rem da CBS
   */
  public void setAdremCbs(BigDecimal adremCbs) {
    this.adremCbs = adremCbs;
  }

  /**
   * # vIBSMono - Valor do IBS monofásico.
   *
   * @return the vIBSMono - Valor do IBS monofásico
   */
  public BigDecimal getVibsMono() {
    return vibsMono;
  }

  /**
   * # vIBSMono - Valor do IBS monofásico.
   *
   * @param vibsMono the new vIBSMono - Valor do IBS monofásico
   */
  public void setVibsMono(BigDecimal vibsMono) {
    this.vibsMono = vibsMono;
  }

  /**
   * # vCBSMono - Valor da CBS monofásica.
   *
   * @return the vCBSMono - Valor da CBS monofásica
   */
  public BigDecimal getVcbsMono() {
    return vcbsMono;
  }

  /**
   * # vCBSMono - Valor da CBS monofásica.
   *
   * @param vcbsMono the new vCBSMono - Valor da CBS monofásica
   */
  public void setVcbsMono(BigDecimal vcbsMono) {
    this.vcbsMono = vcbsMono;
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
