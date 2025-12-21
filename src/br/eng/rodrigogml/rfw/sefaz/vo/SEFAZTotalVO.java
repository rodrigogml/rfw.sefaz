package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Grupo W01 - total: Totais da NF-e.
 * <p>
 * Ocorre 1-1 dentro do grupo A01 (infNFe). O grupo de valores totais da NF-e deve ser informado com o somatório do campo correspondente dos itens.
 * <p>
 * Contém:
 * <ul>
 * <li>W02 - ICMSTot: Totais referentes ao ICMS (mapeado em {@link SEFAZICMSTotVO});</li>
 * <li>W17 - ISSQNtot: Totais referentes ao ISSQN (campos abaixo neste mesmo VO).</li>
 * </ul>
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_total")
public class SEFAZTotalVO extends RFWVO {

  private static final long serialVersionUID = -8582574194460781124L;

  /**
   * {@link SEFAZInfNFeVO}
   */
  @RFWMetaRelationshipField(caption = "InfNFe", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_infnfe")
  private SEFAZInfNFeVO infNFeVO = null;

  /**
   * {@link SEFAZICMSTotVO}
   */
  @RFWMetaRelationshipField(caption = "ICMSTot", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_icmstot")
  private SEFAZICMSTotVO icmsTotVO = null;

  /**
   * {@link SEFAZISSQNTotVO}
   */
  @RFWMetaRelationshipField(caption = "ISSQNTot", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_issqntot")
  private SEFAZISSQNTotVO issqnTotVO = null;

  /**
   * {@link SEFAZISTotVO}
   */
  @RFWMetaRelationshipField(caption = "ISTot", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_istot")
  private SEFAZISTotVO isTotVO = null;

  /**
   * {@link SEFAZIBSCBSTotVO}
   */
  @RFWMetaRelationshipField(caption = "IBSCBSTot", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_ibscbstot")
  private SEFAZIBSCBSTotVO ibsCbsTotVO = null;

  /**
   * # {@link SEFAZInfNFeVO}.
   *
   * @return the {@link SEFAZInfNFeVO}
   */
  public SEFAZInfNFeVO getInfNFeVO() {
    return infNFeVO;
  }

  /**
   * # {@link SEFAZInfNFeVO}.
   *
   * @param infNFeVO the new {@link SEFAZInfNFeVO}
   */
  public void setInfNFeVO(SEFAZInfNFeVO infNFeVO) {
    this.infNFeVO = infNFeVO;
  }

  /**
   * # {@link SEFAZICMSTotVO}.
   *
   * @return the {@link SEFAZICMSTotVO}
   */
  public SEFAZICMSTotVO getIcmsTotVO() {
    return icmsTotVO;
  }

  /**
   * # {@link SEFAZICMSTotVO}.
   *
   * @param icmsTotVO the new {@link SEFAZICMSTotVO}
   */
  public void setIcmsTotVO(SEFAZICMSTotVO icmsTotVO) {
    this.icmsTotVO = icmsTotVO;
  }

  /**
   * # {@link SEFAZISSQNTotVO}.
   *
   * @return the {@link SEFAZISSQNTotVO}
   */
  public SEFAZISSQNTotVO getIssqnTotVO() {
    return issqnTotVO;
  }

  /**
   * # {@link SEFAZISSQNTotVO}.
   *
   * @param issqnTotVO the new {@link SEFAZISSQNTotVO}
   */
  public void setIssqnTotVO(SEFAZISSQNTotVO issqnTotVO) {
    this.issqnTotVO = issqnTotVO;
  }

  /**
   * # {@link SEFAZISTotVO}.
   *
   * @return the {@link SEFAZISTotVO}
   */
  public SEFAZISTotVO getIsTotVO() {
    return isTotVO;
  }

  /**
   * # {@link SEFAZISTotVO}.
   *
   * @param isTotVO the new {@link SEFAZISTotVO}
   */
  public void setIsTotVO(SEFAZISTotVO isTotVO) {
    this.isTotVO = isTotVO;
  }

  /**
   * # {@link SEFAZIBSCBSTotVO}.
   *
   * @return the {@link SEFAZIBSCBSTotVO}
   */
  public SEFAZIBSCBSTotVO getIbsCbsTotVO() {
    return ibsCbsTotVO;
  }

  /**
   * # {@link SEFAZIBSCBSTotVO}.
   *
   * @param ibsCbsTotVO the new {@link SEFAZIBSCBSTotVO}
   */
  public void setIbsCbsTotVO(SEFAZIBSCBSTotVO ibsCbsTotVO) {
    this.ibsCbsTotVO = ibsCbsTotVO;
  }

}
