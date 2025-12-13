package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Dados do grupo de Compras Governamentais ({@code gCompraGov}).
 */
public class SEFAZCompraGovVO extends RFWVO {

  private static final long serialVersionUID = -8246173570317174997L;

  /**
   * {@link SEFAZIdeVO}.
   */
  @RFWMetaRelationshipField(caption = "Ide", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_ide")
  private SEFAZIdeVO ideVO = null;

  /**
   * Tipo de ente governamental ({@code tpEnteGov}).
   */
  @RFWMetaStringField(caption = "Tipo do ente governamental", required = true, maxLength = 1, minLength = 1)
  private String tpEnteGov = null;

  /**
   * Percentual de redução em compra governamental ({@code pRedutor}).
   */
  @RFWMetaStringField(caption = "Percentual redutor", required = true, maxLength = 15, minLength = 1)
  private String pRedutor = null;

  /**
   * Tipo da operação governamental ({@code tpOperGov}).
   */
  @RFWMetaStringField(caption = "Tipo da operação governamental", required = true, maxLength = 1, minLength = 1)
  private String tpOperGov = null;

  public SEFAZIdeVO getIdeVO() {
    return this.ideVO;
  }

  public void setIdeVO(SEFAZIdeVO ideVO) {
    this.ideVO = ideVO;
  }

  public String getTpEnteGov() {
    return this.tpEnteGov;
  }

  public void setTpEnteGov(String tpEnteGov) {
    this.tpEnteGov = tpEnteGov;
  }

  public String getPRedutor() {
    return this.pRedutor;
  }

  public void setPRedutor(String pRedutor) {
    this.pRedutor = pRedutor;
  }

  public String getTpOperGov() {
    return this.tpOperGov;
  }

  public void setTpOperGov(String tpOperGov) {
    this.tpOperGov = tpOperGov;
  }

}
