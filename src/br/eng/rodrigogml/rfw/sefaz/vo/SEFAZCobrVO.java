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
public class SEFAZCobrVO extends RFWVO {

  private static final long serialVersionUID = -8561421828373636674L;

  /**
   * {@link SEFAZInfNFeVO}
   */
  @RFWMetaRelationshipField(caption = "InfNFe", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_infnfe")
  private SEFAZInfNFeVO infNFeVO = null;

  /**
   * {@link SEFAZFatVO}
   */
  @RFWMetaRelationshipField(caption = "Fat", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_fat")
  private SEFAZFatVO fatVO = null;

  /**
   * {@link SEFAZDupVO}
   */
  @RFWMetaRelationshipField(caption = "Dup", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_dup", minSize = 0, maxSize = 120)
  private List<SEFAZFatVO> dupList = null;

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
   * # {@link SEFAZFatVO}.
   *
   * @return the {@link SEFAZFatVO}
   */
  public SEFAZFatVO getFatVO() {
    return fatVO;
  }

  /**
   * # {@link SEFAZFatVO}.
   *
   * @param fatVO the new {@link SEFAZFatVO}
   */
  public void setFatVO(SEFAZFatVO fatVO) {
    this.fatVO = fatVO;
  }

  /**
   * # {@link SEFAZDupVO}.
   *
   * @return the {@link SEFAZDupVO}
   */
  public List<SEFAZFatVO> getDupList() {
    return dupList;
  }

  /**
   * # {@link SEFAZDupVO}.
   *
   * @param dupList the new {@link SEFAZDupVO}
   */
  public void setDupList(List<SEFAZFatVO> dupList) {
    this.dupList = dupList;
  }

}
