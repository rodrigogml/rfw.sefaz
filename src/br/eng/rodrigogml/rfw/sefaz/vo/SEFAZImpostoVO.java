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
public class SEFAZImpostoVO extends RFWVO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * {@link SEFAZDetVO}
   */
  @RFWMetaRelationshipField(caption = "Det", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_det")
  private SEFAZDetVO detVO = null;

  /**
   * {@link SEFAZICMSVO}
   */
  @RFWMetaRelationshipField(caption = "ICMS", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_imposto")
  private SEFAZICMSVO icmsVO = null;

  /**
   * {@link SEFAZICMSUFDestVO}
   */
  @RFWMetaRelationshipField(caption = "ICMSUFDest", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_imposto")
  private SEFAZICMSUFDestVO icmsUFDestVO = null;

  /**
   * {@link SEFAZIPIVO}
   */
  @RFWMetaRelationshipField(caption = "IPI", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_imposto")
  private SEFAZIPIVO ipiVO = null;

  /**
   * {@link SEFAZPISVO}
   */
  @RFWMetaRelationshipField(caption = "PIS", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_imposto")
  private SEFAZPISVO pisVO = null;

  /**
   * {@link SEFAZCOFINSVO}
   */
  @RFWMetaRelationshipField(caption = "COFINS", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_imposto")
  private SEFAZCOFINSVO cofinsVO = null;

  /**
   * {@link SEFAZISVO}
   */
  @RFWMetaRelationshipField(caption = "IS", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_imposto")
  private SEFAZISVO isVO = null;

  /**
   * {@link SEFAZIBSCBSVO}
   */
  @RFWMetaRelationshipField(caption = "IBSCBS", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_imposto")
  private SEFAZIBSCBSVO ibsCbsVO = null;

  /**
   * M02 - vTotTrib. Valor aproximado total de tributos federais, estaduais e municipais. (NT 2013/003)
   *
   * Ocor.: 0–1 / Tam.: 13v2 / Tipo: N. No MOC o campo é opcional.
   */
  @RFWMetaBigDecimalField(caption = "Valor aproximado total de tributos", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vtotTrib;

  /**
   * # {@link SEFAZDetVO}.
   *
   * @return the {@link SEFAZDetVO}
   */
  public SEFAZDetVO getDetVO() {
    return detVO;
  }

  /**
   * # {@link SEFAZDetVO}.
   *
   * @param detVO the new {@link SEFAZDetVO}
   */
  public void setDetVO(SEFAZDetVO detVO) {
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
   * # {@link SEFAZICMSVO}.
   *
   * @return the {@link SEFAZICMSVO}
   */
  public SEFAZICMSVO getIcmsVO() {
    return icmsVO;
  }

  /**
   * # {@link SEFAZICMSVO}.
   *
   * @param icmsVO the new {@link SEFAZICMSVO}
   */
  public void setIcmsVO(SEFAZICMSVO icmsVO) {
    this.icmsVO = icmsVO;
  }

  /**
   * # {@link SEFAZICMSUFDestVO}.
   *
   * @return the {@link SEFAZICMSUFDestVO}
   */
  public SEFAZICMSUFDestVO getIcmsUFDestVO() {
    return icmsUFDestVO;
  }

  /**
   * # {@link SEFAZICMSUFDestVO}.
   *
   * @param icmsUFDestVO the new {@link SEFAZICMSUFDestVO}
   */
  public void setIcmsUFDestVO(SEFAZICMSUFDestVO icmsUFDestVO) {
    this.icmsUFDestVO = icmsUFDestVO;
  }

  /**
   * # {@link SEFAZICMSUFDestVO}.
   *
   * @return the {@link SEFAZICMSUFDestVO}
   */
  public SEFAZIPIVO getIpiVO() {
    return ipiVO;
  }

  /**
   * # {@link SEFAZICMSUFDestVO}.
   *
   * @param ipiVO the new {@link SEFAZICMSUFDestVO}
   */
  public void setIpiVO(SEFAZIPIVO ipiVO) {
    this.ipiVO = ipiVO;
  }

  /**
   * # {@link SEFAZPISVO}.
   *
   * @return the {@link SEFAZPISVO}
   */
  public SEFAZPISVO getPisVO() {
    return pisVO;
  }

  /**
   * # {@link SEFAZPISVO}.
   *
   * @param pisVO the new {@link SEFAZPISVO}
   */
  public void setPisVO(SEFAZPISVO pisVO) {
    this.pisVO = pisVO;
  }

  /**
   * # {@link SEFAZCOFINSVO}.
   *
   * @return the {@link SEFAZCOFINSVO}
   */
  public SEFAZCOFINSVO getCofinsVO() {
    return cofinsVO;
  }

  /**
   * # {@link SEFAZCOFINSVO}.
   *
   * @param cofinsVO the new {@link SEFAZCOFINSVO}
   */
  public void setCofinsVO(SEFAZCOFINSVO cofinsVO) {
    this.cofinsVO = cofinsVO;
  }

  /**
   * # {@link SEFAZISVO}.
   *
   * @return the {@link SEFAZISVO}
   */
  public SEFAZISVO getIsVO() {
    return isVO;
  }

  /**
   * # {@link SEFAZISVO}.
   *
   * @param isVO the new {@link SEFAZISVO}
   */
  public void setIsVO(SEFAZISVO isVO) {
    this.isVO = isVO;
  }

  /**
   * # {@link SEFAZIBSCBSVO}.
   *
   * @return the {@link SEFAZIBSCBSVO}
   */
  public SEFAZIBSCBSVO getIbsCbsVO() {
    return ibsCbsVO;
  }

  /**
   * # {@link SEFAZIBSCBSVO}.
   *
   * @param ibsCbsVO the new {@link SEFAZIBSCBSVO}
   */
  public void setIbsCbsVO(SEFAZIBSCBSVO ibsCbsVO) {
    this.ibsCbsVO = ibsCbsVO;
  }

}
