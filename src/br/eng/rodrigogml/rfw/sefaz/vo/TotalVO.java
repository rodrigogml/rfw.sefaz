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
 * <li>W02 - ICMSTot: Totais referentes ao ICMS (mapeado em {@link ICMSTotVO});</li>
 * <li>W17 - ISSQNtot: Totais referentes ao ISSQN (campos abaixo neste mesmo VO).</li>
 * </ul>
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_total")
public class TotalVO extends RFWVO {

  private static final long serialVersionUID = -8582574194460781124L;

  /**
   * {@link InfNFeVO}
   */
  @RFWMetaRelationshipField(caption = "InfNFe", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_infnfe")
  private InfNFeVO infNFeVO = null;

  /**
   * {@link ICMSTotVO}
   */
  @RFWMetaRelationshipField(caption = "ICMSTot", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_icmstot")
  private ICMSTotVO icmsTotVO = null;

  /**
   * {@link ISSQNTotVO}
   */
  @RFWMetaRelationshipField(caption = "ISSQNTot", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_issqntot")
  private ISSQNTotVO issqnTotVO = null;

  /**
   * # {@link InfNFeVO}.
   *
   * @return the {@link InfNFeVO}
   */
  public InfNFeVO getInfNFeVO() {
    return infNFeVO;
  }

  /**
   * # {@link InfNFeVO}.
   *
   * @param infNFeVO the new {@link InfNFeVO}
   */
  public void setInfNFeVO(InfNFeVO infNFeVO) {
    this.infNFeVO = infNFeVO;
  }

  /**
   * # {@link ICMSTotVO}.
   *
   * @return the {@link ICMSTotVO}
   */
  public ICMSTotVO getIcmsTotVO() {
    return icmsTotVO;
  }

  /**
   * # {@link ICMSTotVO}.
   *
   * @param icmsTotVO the new {@link ICMSTotVO}
   */
  public void setIcmsTotVO(ICMSTotVO icmsTotVO) {
    this.icmsTotVO = icmsTotVO;
  }

  /**
   * # {@link ISSQNTotVO}.
   *
   * @return the {@link ISSQNTotVO}
   */
  public ISSQNTotVO getIssqnTotVO() {
    return issqnTotVO;
  }

  /**
   * # {@link ISSQNTotVO}.
   *
   * @param issqnTotVO the new {@link ISSQNTotVO}
   */
  public void setIssqnTotVO(ISSQNTotVO issqnTotVO) {
    this.issqnTotVO = issqnTotVO;
  }

}
