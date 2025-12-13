package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Referência de NF-e utilizada em pagamento antecipado.
 */
public class SEFAZPagAntecipadoRefVO extends RFWVO {

  private static final long serialVersionUID = -6143485065629154390L;

  /**
   * {@link SEFAZPagAntecipadoVO}.
   */
  @RFWMetaRelationshipField(caption = "PagAntecipado", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_pag_antecipado")
  private SEFAZPagAntecipadoVO pagAntecipadoVO = null;

  /**
   * Chave de acesso da NF-e referenciada.
   */
  @RFWMetaStringField(caption = "Chave da NF-e", required = true, maxLength = 44, minLength = 44)
  private String refNFe = null;

  public SEFAZPagAntecipadoVO getPagAntecipadoVO() {
    return this.pagAntecipadoVO;
  }

  public void setPagAntecipadoVO(SEFAZPagAntecipadoVO pagAntecipadoVO) {
    this.pagAntecipadoVO = pagAntecipadoVO;
  }

  public String getRefNFe() {
    return this.refNFe;
  }

  public void setRefNFe(String refNFe) {
    this.refNFe = refNFe;
  }

}
