package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * gMonoDif - Grupo de informações do Diferimento da Tributação Monofásica.
 */
public class SEFAZGMonoDifVO extends RFWVO {

  private static final long serialVersionUID = 3473557640306762738L;

  /**
   * {@link SEFAZGIBSCBSMonoVO}
   */
  @RFWMetaRelationshipField(caption = "IBSCBS", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true)
  private SEFAZGIBSCBSMonoVO gibsCBSMonoVO = null;

  /**
   * pDifIBS - Percentual do diferimento do IBS monofásico.
   */
  @RFWMetaBigDecimalField(caption = "Percentual de Diferimento do IBS Monofásico", required = true, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pdifIbs;

  /**
   * vIBSMonoDif - Valor do IBS monofásico diferido.
   */
  @RFWMetaBigDecimalField(caption = "Valor do IBS Monofásico Diferido", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vibsMonoDif;

  /**
   * pDifCBS - Percentual do diferimento da CBS monofásica.
   */
  @RFWMetaBigDecimalField(caption = "Percentual de Diferimento da CBS Monofásica", required = true, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pdifCbs;

  /**
   * vCBSMonoDif - Valor da CBS monofásica diferida.
   */
  @RFWMetaBigDecimalField(caption = "Valor da CBS Monofásica Diferida", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vcbsMonoDif;

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
   * # pDifIBS - Percentual do diferimento do IBS monofásico.
   *
   * @return the pDifIBS - Percentual do diferimento do IBS monofásico
   */
  public BigDecimal getPdifIbs() {
    return pdifIbs;
  }

  /**
   * # pDifIBS - Percentual do diferimento do IBS monofásico.
   *
   * @param pdifIbs the new pDifIBS - Percentual do diferimento do IBS monofásico
   */
  public void setPdifIbs(BigDecimal pdifIbs) {
    this.pdifIbs = pdifIbs;
  }

  /**
   * # vIBSMonoDif - Valor do IBS monofásico diferido.
   *
   * @return the vIBSMonoDif - Valor do IBS monofásico diferido
   */
  public BigDecimal getVibsMonoDif() {
    return vibsMonoDif;
  }

  /**
   * # vIBSMonoDif - Valor do IBS monofásico diferido.
   *
   * @param vibsMonoDif the new vIBSMonoDif - Valor do IBS monofásico diferido
   */
  public void setVibsMonoDif(BigDecimal vibsMonoDif) {
    this.vibsMonoDif = vibsMonoDif;
  }

  /**
   * # pDifCBS - Percentual do diferimento da CBS monofásica.
   *
   * @return the pDifCBS - Percentual do diferimento da CBS monofásica
   */
  public BigDecimal getPdifCbs() {
    return pdifCbs;
  }

  /**
   * # pDifCBS - Percentual do diferimento da CBS monofásica.
   *
   * @param pdifCbs the new pDifCBS - Percentual do diferimento da CBS monofásica
   */
  public void setPdifCbs(BigDecimal pdifCbs) {
    this.pdifCbs = pdifCbs;
  }

  /**
   * # vCBSMonoDif - Valor da CBS monofásica diferida.
   *
   * @return the vCBSMonoDif - Valor da CBS monofásica diferida
   */
  public BigDecimal getVcbsMonoDif() {
    return vcbsMonoDif;
  }

  /**
   * # vCBSMonoDif - Valor da CBS monofásica diferida.
   *
   * @param vcbsMonoDif the new vCBSMonoDif - Valor da CBS monofásica diferida
   */
  public void setVcbsMonoDif(BigDecimal vcbsMonoDif) {
    this.vcbsMonoDif = vcbsMonoDif;
  }
}
