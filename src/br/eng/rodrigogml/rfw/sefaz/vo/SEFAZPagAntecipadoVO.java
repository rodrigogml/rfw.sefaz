package br.eng.rodrigogml.rfw.sefaz.vo;

import java.util.List;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Grupo de pagamentos antecipados ({@code gPagAntecipado}).
 */
public class SEFAZPagAntecipadoVO extends RFWVO {

  private static final long serialVersionUID = 6605312864781548378L;

  /**
   * {@link SEFAZIdeVO}.
   */
  @RFWMetaRelationshipField(caption = "Ide", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_ide")
  private SEFAZIdeVO ideVO = null;

  /**
   * Referências de NF-e com pagamento antecipado.
   */
  @RFWMetaRelationshipField(caption = "RefNFe pagamento antecipado", relationship = RelationshipTypes.COMPOSITION, required = true, columnMapped = "idsefaz_pag_antecipado_ref", minSize = 1, maxSize = 99)
  private List<SEFAZPagAntecipadoRefVO> refNFeList = null;

  public SEFAZIdeVO getIdeVO() {
    return this.ideVO;
  }

  public void setIdeVO(SEFAZIdeVO ideVO) {
    this.ideVO = ideVO;
  }

  public List<SEFAZPagAntecipadoRefVO> getRefNFeList() {
    return this.refNFeList;
  }

  public void setRefNFeList(List<SEFAZPagAntecipadoRefVO> refNFeList) {
    this.refNFeList = refNFeList;
  }

}
