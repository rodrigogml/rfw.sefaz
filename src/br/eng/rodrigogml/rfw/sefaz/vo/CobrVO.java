package br.eng.rodrigogml.rfw.sefaz.vo;

import java.util.List;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Grupo Y01 - cobr: Cobrança.
 * <p>
 * Ocorre 0-1 dentro do grupo A01 (infNFe).
 * <p>
 * Contém:
 * <ul>
 * <li>Y02 - fat: Grupo Fatura;</li>
 * <li>Y07 - dup: Grupo Parcelas (0-120 ocorrências).</li>
 * </ul>
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_cobr")
public class CobrVO extends RFWVO {

  private static final long serialVersionUID = -8561421828373636674L;

  /**
   * {@link InfNFeVO}
   */
  @RFWMetaRelationshipField(caption = "InfNFe", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_infnfe")
  private InfNFeVO infNFeVO = null;

  /**
   * {@link FatVO}
   */
  @RFWMetaRelationshipField(caption = "Fat", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_fat")
  private FatVO fatVO = null;

  /**
   * {@link DupVO}
   */
  @RFWMetaRelationshipField(caption = "Dup", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_dup", minSize = 0, maxSize = 120)
  private List<FatVO> dupList = null;

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
   * # {@link FatVO}.
   *
   * @return the {@link FatVO}
   */
  public FatVO getFatVO() {
    return fatVO;
  }

  /**
   * # {@link FatVO}.
   *
   * @param fatVO the new {@link FatVO}
   */
  public void setFatVO(FatVO fatVO) {
    this.fatVO = fatVO;
  }

  /**
   * # {@link DupVO}.
   *
   * @return the {@link DupVO}
   */
  public List<FatVO> getDupList() {
    return dupList;
  }

  /**
   * # {@link DupVO}.
   *
   * @param dupList the new {@link DupVO}
   */
  public void setDupList(List<FatVO> dupList) {
    this.dupList = dupList;
  }

}
