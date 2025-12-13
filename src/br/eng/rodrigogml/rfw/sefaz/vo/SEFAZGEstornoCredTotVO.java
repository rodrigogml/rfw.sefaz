package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * gEstornoCred - Grupo total do Estorno de Crédito.
 */
public class SEFAZGEstornoCredTotVO extends RFWVO {

  private static final long serialVersionUID = 3486338352420833398L;

  /**
   * {@link SEFAZIBSCBSTotVO}
   */
  @RFWMetaRelationshipField(caption = "Total", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true)
  private SEFAZIBSCBSTotVO ibsCBSTotVO = null;

  /**
   * vIBSEstCred - Valor total do IBS estornado.
   */
  @RFWMetaBigDecimalField(caption = "Total do IBS Estornado", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vibseStCred;

  /**
   * vCBSEstCred - Valor total da CBS estornada.
   */
  @RFWMetaBigDecimalField(caption = "Total da CBS Estornada", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vcbseStCred;

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
   * # vIBSEstCred - Valor total do IBS estornado.
   *
   * @return the vIBSEstCred - Valor total do IBS estornado
   */
  public BigDecimal getVibseStCred() {
    return vibseStCred;
  }

  /**
   * # vIBSEstCred - Valor total do IBS estornado.
   *
   * @param vibseStCred the new vIBSEstCred - Valor total do IBS estornado
   */
  public void setVibseStCred(BigDecimal vibseStCred) {
    this.vibseStCred = vibseStCred;
  }

  /**
   * # vCBSEstCred - Valor total da CBS estornada.
   *
   * @return the vCBSEstCred - Valor total da CBS estornada
   */
  public BigDecimal getVcbseStCred() {
    return vcbseStCred;
  }

  /**
   * # vCBSEstCred - Valor total da CBS estornada.
   *
   * @param vcbseStCred the new vCBSEstCred - Valor total da CBS estornada
   */
  public void setVcbseStCred(BigDecimal vcbseStCred) {
    this.vcbseStCred = vcbseStCred;
  }
}
