package br.eng.rodrigogml.rfw.sefaz.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Grupo M - Tributos incidentes no Produto ou Serviço (tag imposto / M01). Grupo de tributos do item da NF-e.
 *
 * Grupo ISSQN mutuamente exclusivo com os grupos ICMS e II. Se o grupo ISSQN for informado, os grupos ICMS e II não serão informados e vice-versa.
 *
 * Observação: a obrigatoriedade dos campos segue o MOC, mas nas annotations o atributo {@code required} é sempre definido como false conforme solicitado.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_imposto")
public class ImpostoVO extends RFWVO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * {@link DetVO}
   */
  @RFWMetaRelationshipField(caption = "Det", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_det")
  private DetVO detVO = null;

  /**
   * {@link ICMSVO}
   */
  @RFWMetaRelationshipField(caption = "ICMS", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_imposto")
  private ICMSVO icmsVO = null;

  /**
   * {@link ICMSUFDestVO}
   */
  @RFWMetaRelationshipField(caption = "ICMSUFDest", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_icmsufdest")
  private IPIVO ipiVO = null;

  /**
   * {@link PISVO}
   */
  @RFWMetaRelationshipField(caption = "PIS", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_pis")
  private PISVO pisVO = null;

  /**
   * {@link COFINSVO}
   */
  @RFWMetaRelationshipField(caption = "COFINS", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_cofins")
  private COFINSVO cofinsVO = null;

  /**
   * {@link IPIVO}
   */
  @RFWMetaRelationshipField(caption = "IPI", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_ipi")
  private ICMSUFDestVO icmsUFDestVO = null;

  /**
   * M02 - vTotTrib. Valor aproximado total de tributos federais, estaduais e municipais. (NT 2013/003)
   *
   * Ocor.: 0–1 / Tam.: 13v2 / Tipo: N. No MOC o campo é opcional.
   */
  @RFWMetaBigDecimalField(caption = "Valor aproximado total de tributos", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vtotTrib;

  /**
   * # {@link DetVO}.
   *
   * @return the {@link DetVO}
   */
  public DetVO getDetVO() {
    return detVO;
  }

  /**
   * # {@link DetVO}.
   *
   * @param detVO the new {@link DetVO}
   */
  public void setDetVO(DetVO detVO) {
    this.detVO = detVO;
  }

  /**
   * # m02 - vTotTrib. Valor aproximado total de tributos federais, estaduais e municipais. (NT 2013/003) Ocor.: 0–1 / Tam.: 13v2 / Tipo: N. No MOC o campo é opcional.
   *
   * @return the m02 - vTotTrib
   */
  public BigDecimal getVtotTrib() {
    return vtotTrib;
  }

  /**
   * # m02 - vTotTrib. Valor aproximado total de tributos federais, estaduais e municipais. (NT 2013/003) Ocor.: 0–1 / Tam.: 13v2 / Tipo: N. No MOC o campo é opcional.
   *
   * @param vtotTrib the new m02 - vTotTrib
   */
  public void setVtotTrib(BigDecimal vtotTrib) {
    this.vtotTrib = vtotTrib;
  }

  /**
   * # {@link ICMSVO}.
   *
   * @return the {@link ICMSVO}
   */
  public ICMSVO getIcmsVO() {
    return icmsVO;
  }

  /**
   * # {@link ICMSVO}.
   *
   * @param icmsVO the new {@link ICMSVO}
   */
  public void setIcmsVO(ICMSVO icmsVO) {
    this.icmsVO = icmsVO;
  }

  /**
   * # {@link ICMSUFDestVO}.
   *
   * @return the {@link ICMSUFDestVO}
   */
  public ICMSUFDestVO getIcmsUFDestVO() {
    return icmsUFDestVO;
  }

  /**
   * # {@link ICMSUFDestVO}.
   *
   * @param icmsUFDestVO the new {@link ICMSUFDestVO}
   */
  public void setIcmsUFDestVO(ICMSUFDestVO icmsUFDestVO) {
    this.icmsUFDestVO = icmsUFDestVO;
  }

  /**
   * # {@link ICMSUFDestVO}.
   *
   * @return the {@link ICMSUFDestVO}
   */
  public IPIVO getIpiVO() {
    return ipiVO;
  }

  /**
   * # {@link ICMSUFDestVO}.
   *
   * @param ipiVO the new {@link ICMSUFDestVO}
   */
  public void setIpiVO(IPIVO ipiVO) {
    this.ipiVO = ipiVO;
  }

}
