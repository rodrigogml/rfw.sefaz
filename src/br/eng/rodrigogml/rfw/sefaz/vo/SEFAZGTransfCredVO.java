package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * gTransfCred - Grupo de Transferências de Crédito.
 */
public class SEFAZGTransfCredVO extends RFWVO {

  private static final long serialVersionUID = 5220832756448165078L;

  /**
   * {@link SEFAZGIBSCBSVO}
   */
  @RFWMetaRelationshipField(caption = "IBSCBS", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true)
  private SEFAZGIBSCBSVO gibsCBSVO = null;

  /**
   * vIBS - Valor do IBS a ser transferido.
   */
  @RFWMetaBigDecimalField(caption = "Valor do IBS a Transferir", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vibs;

  /**
   * vCBS - Valor da CBS a ser transferida.
   */
  @RFWMetaBigDecimalField(caption = "Valor da CBS a Transferir", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vcbs;

  /**
   * # vIBS - Valor do IBS a ser transferido.
   *
   * @return the vIBS - Valor do IBS a ser transferido
   */
  public BigDecimal getVibs() {
    return vibs;
  }

  /**
   * # vIBS - Valor do IBS a ser transferido.
   *
   * @param vibs the new vIBS - Valor do IBS a ser transferido
   */
  public void setVibs(BigDecimal vibs) {
    this.vibs = vibs;
  }

  /**
   * # vCBS - Valor da CBS a ser transferida.
   *
   * @return the vCBS - Valor da CBS a ser transferida
   */
  public BigDecimal getVcbs() {
    return vcbs;
  }

  /**
   * # vCBS - Valor da CBS a ser transferida.
   *
   * @param vcbs the new vCBS - Valor da CBS a ser transferida
   */
  public void setVcbs(BigDecimal vcbs) {
    this.vcbs = vcbs;
  }

  /**
   * # {@link SEFAZGIBSCBSVO}.
   *
   * @return the {@link SEFAZGIBSCBSVO}
   */
  public SEFAZGIBSCBSVO getGibsCBSVO() {
    return gibsCBSVO;
  }

  /**
   * # {@link SEFAZGIBSCBSVO}.
   *
   * @param gibsCBSVO the new {@link SEFAZGIBSCBSVO}
   */
  public void setGibsCBSVO(SEFAZGIBSCBSVO gibsCBSVO) {
    this.gibsCBSVO = gibsCBSVO;
  }
}
