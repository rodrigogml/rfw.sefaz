package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * gIBSUF - Grupo total do IBS de competência da UF.
 */
public class SEFAZGIBSUFTotVO extends RFWVO {

  private static final long serialVersionUID = -2457304091838434774L;

  /**
   * {@link SEFAZGIBSTotVO}
   */
  @RFWMetaRelationshipField(caption = "Total", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true)
  private SEFAZGIBSTotVO gibsTotVO = null;

  /**
   * vDif - Valor total do diferimento do IBS da UF.
   */
  @RFWMetaBigDecimalField(caption = "Total do Diferimento do IBS da UF", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vdif;

  /**
   * vDevTrib - Valor total da devolução de tributos do IBS da UF.
   */
  @RFWMetaBigDecimalField(caption = "Total da Devolução de Tributos do IBS da UF", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vdevTrib;

  /**
   * vIBSUF - Valor total do IBS da UF.
   */
  @RFWMetaBigDecimalField(caption = "Total do IBS da UF", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vibsUf;

  /**
   * # {@link SEFAZGIBSTotVO}.
   *
   * @return the {@link SEFAZGIBSTotVO}
   */
  public SEFAZGIBSTotVO getGibsTotVO() {
    return gibsTotVO;
  }

  /**
   * # {@link SEFAZGIBSTotVO}.
   *
   * @param gibsTotVO the new {@link SEFAZGIBSTotVO}
   */
  public void setGibsTotVO(SEFAZGIBSTotVO gibsTotVO) {
    this.gibsTotVO = gibsTotVO;
  }

  /**
   * # vDif - Valor total do diferimento do IBS da UF.
   *
   * @return the vDif - Valor total do diferimento do IBS da UF
   */
  public BigDecimal getVdif() {
    return vdif;
  }

  /**
   * # vDif - Valor total do diferimento do IBS da UF.
   *
   * @param vdif the new vDif - Valor total do diferimento do IBS da UF
   */
  public void setVdif(BigDecimal vdif) {
    this.vdif = vdif;
  }

  /**
   * # vDevTrib - Valor total da devolução de tributos do IBS da UF.
   *
   * @return the vDevTrib - Valor total da devolução de tributos do IBS da UF
   */
  public BigDecimal getVdevTrib() {
    return vdevTrib;
  }

  /**
   * # vDevTrib - Valor total da devolução de tributos do IBS da UF.
   *
   * @param vdevTrib the new vDevTrib - Valor total da devolução de tributos do IBS da UF
   */
  public void setVdevTrib(BigDecimal vdevTrib) {
    this.vdevTrib = vdevTrib;
  }

  /**
   * # vIBSUF - Valor total do IBS da UF.
   *
   * @return the vIBSUF - Valor total do IBS da UF
   */
  public BigDecimal getVibsUf() {
    return vibsUf;
  }

  /**
   * # vIBSUF - Valor total do IBS da UF.
   *
   * @param vibsUf the new vIBSUF - Valor total do IBS da UF
   */
  public void setVibsUf(BigDecimal vibsUf) {
    this.vibsUf = vibsUf;
  }
}
