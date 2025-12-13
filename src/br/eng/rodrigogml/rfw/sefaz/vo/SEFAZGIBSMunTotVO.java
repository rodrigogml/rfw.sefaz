package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * gIBSMun - Grupo total do IBS de competência do Município.
 */
public class SEFAZGIBSMunTotVO extends RFWVO {

  private static final long serialVersionUID = 4320787501356622213L;

  /**
   * {@link SEFAZGIBSTotVO}
   */
  @RFWMetaRelationshipField(caption = "Total", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true)
  private SEFAZGIBSTotVO gibsTotVO = null;

  /**
   * vDif - Valor total do diferimento do IBS do Município.
   */
  @RFWMetaBigDecimalField(caption = "Total do Diferimento do IBS do Município", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vdif;

  /**
   * vDevTrib - Valor total da devolução de tributos do IBS do Município.
   */
  @RFWMetaBigDecimalField(caption = "Total da Devolução de Tributos do IBS do Município", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vdevTrib;

  /**
   * vIBSMun - Valor total do IBS do Município.
   */
  @RFWMetaBigDecimalField(caption = "Total do IBS do Município", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vibsMun;

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
   * # vDif - Valor total do diferimento do IBS do Município.
   *
   * @return the vDif - Valor total do diferimento do IBS do Município
   */
  public BigDecimal getVdif() {
    return vdif;
  }

  /**
   * # vDif - Valor total do diferimento do IBS do Município.
   *
   * @param vdif the new vDif - Valor total do diferimento do IBS do Município
   */
  public void setVdif(BigDecimal vdif) {
    this.vdif = vdif;
  }

  /**
   * # vDevTrib - Valor total da devolução de tributos do IBS do Município.
   *
   * @return the vDevTrib - Valor total da devolução de tributos do IBS do Município
   */
  public BigDecimal getVdevTrib() {
    return vdevTrib;
  }

  /**
   * # vDevTrib - Valor total da devolução de tributos do IBS do Município.
   *
   * @param vdevTrib the new vDevTrib - Valor total da devolução de tributos do IBS do Município
   */
  public void setVdevTrib(BigDecimal vdevTrib) {
    this.vdevTrib = vdevTrib;
  }

  /**
   * # vIBSMun - Valor total do IBS do Município.
   *
   * @return the vIBSMun - Valor total do IBS do Município
   */
  public BigDecimal getVibsMun() {
    return vibsMun;
  }

  /**
   * # vIBSMun - Valor total do IBS do Município.
   *
   * @param vibsMun the new vIBSMun - Valor total do IBS do Município
   */
  public void setVibsMun(BigDecimal vibsMun) {
    this.vibsMun = vibsMun;
  }
}
