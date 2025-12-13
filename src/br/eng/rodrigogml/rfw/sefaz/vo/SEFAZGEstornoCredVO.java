package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * gEstornoCred - Estorno de Crédito.
 * <p>
 * Grupo utilizado para informar os valores de crédito de IBS e CBS que deverão ser estornados.
 * <p>
 * A obrigatoriedade ou vedação do preenchimento deste grupo está condicionada ao indicador "ind_gEstornoCred" da tabela de cClassTrib do IBS e da CBS.
 */
public class SEFAZGEstornoCredVO extends RFWVO {

  private static final long serialVersionUID = 4292920879564298739L;

  /**
   * {@link SEFAZIBSCBSVO}
   */
  @RFWMetaRelationshipField(caption = "IBSCBS", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true)
  private SEFAZIBSCBSVO ibsCBSVO = null;
  /**
   * vIBSEstCred - Valor do IBS a ser estornado.
   */
  @RFWMetaBigDecimalField(caption = "Valor do IBS a ser Estornado", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vibseStCred;

  /**
   * vCBSEstCred - Valor da CBS a ser estornada.
   */
  @RFWMetaBigDecimalField(caption = "Valor da CBS a ser Estornada", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vcbseStCred;

  /**
   * # {@link SEFAZIBSCBSVO}.
   *
   * @return the {@link SEFAZIBSCBSVO}
   */
  public SEFAZIBSCBSVO getIbsCBSVO() {
    return ibsCBSVO;
  }

  /**
   * # {@link SEFAZIBSCBSVO}.
   *
   * @param ibsCBSVO the new {@link SEFAZIBSCBSVO}
   */
  public void setIbsCBSVO(SEFAZIBSCBSVO ibsCBSVO) {
    this.ibsCBSVO = ibsCBSVO;
  }

  /**
   * # vIBSEstCred - Valor do IBS a ser estornado.
   *
   * @return the vIBSEstCred - Valor do IBS a ser estornado
   */
  public BigDecimal getVibseStCred() {
    return vibseStCred;
  }

  /**
   * # vIBSEstCred - Valor do IBS a ser estornado.
   *
   * @param vibseStCred the new vIBSEstCred - Valor do IBS a ser estornado
   */
  public void setVibseStCred(BigDecimal vibseStCred) {
    this.vibseStCred = vibseStCred;
  }

  /**
   * # vCBSEstCred - Valor da CBS a ser estornada.
   *
   * @return the vCBSEstCred - Valor da CBS a ser estornada
   */
  public BigDecimal getVcbseStCred() {
    return vcbseStCred;
  }

  /**
   * # vCBSEstCred - Valor da CBS a ser estornada.
   *
   * @param vcbseStCred the new vCBSEstCred - Valor da CBS a ser estornada
   */
  public void setVcbseStCred(BigDecimal vcbseStCred) {
    this.vcbseStCred = vcbseStCred;
  }
}
