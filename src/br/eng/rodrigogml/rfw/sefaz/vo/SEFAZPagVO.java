package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;
import java.util.List;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Grupo YA01 - pag: Informações de Pagamento.
 * <p>
 * Ocorre 1-1 dentro do grupo A01 (infNFe).
 * <p>
 * Obrigatório para NF-e e NFC-e. Para notas com finalidade de Ajuste ou Devolução, o campo Meio de Pagamento (tPag) deve ser preenchido com 90 = Sem Pagamento.
 * <p>
 * Contém:
 * <ul>
 * <li>YA01a - detPag: Grupo Detalhamento do Pagamento (1-100);</li>
 * <li>YA09 - vTroco: Valor do troco.</li>
 * </ul>
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_pag")
public class SEFAZPagVO extends RFWVO {

  private static final long serialVersionUID = -9131921713134649028L;

  /**
   * {@link SEFAZInfNFeVO}
   */
  @RFWMetaRelationshipField(caption = "InfNFe", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_infnfe")
  private SEFAZInfNFeVO infNFeVO = null;

  /**
   * YA01a - detPag: Grupo Detalhamento do Pagamento. Ocorrência: 1-100.
   */
  @RFWMetaRelationshipField(caption = "DetPag", relationship = RelationshipTypes.COMPOSITION, required = false, minSize = 1, maxSize = 100, columnMapped = "idsefaz_pag")
  private List<SEFAZDetPagVO> detPag;

  /**
   * YA09 - vTroco: Valor do troco. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional). Incluído na NT 2016.002.
   */
  @RFWMetaBigDecimalField(caption = "vTroco", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vtroco;

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
   * # yA01a - detPag: Grupo Detalhamento do Pagamento. Ocorrência: 1-100.
   *
   * @return the yA01a - detPag: Grupo Detalhamento do Pagamento
   */
  public List<SEFAZDetPagVO> getDetPag() {
    return detPag;
  }

  /**
   * # yA01a - detPag: Grupo Detalhamento do Pagamento. Ocorrência: 1-100.
   *
   * @param detPag the new yA01a - detPag: Grupo Detalhamento do Pagamento
   */
  public void setDetPag(List<SEFAZDetPagVO> detPag) {
    this.detPag = detPag;
  }

  /**
   * # yA09 - vTroco: Valor do troco. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional). Incluído na NT 2016.002.
   *
   * @return the yA09 - vTroco: Valor do troco
   */
  public BigDecimal getVtroco() {
    return vtroco;
  }

  /**
   * # yA09 - vTroco: Valor do troco. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional). Incluído na NT 2016.002.
   *
   * @param vtroco the new yA09 - vTroco: Valor do troco
   */
  public void setVtroco(BigDecimal vtroco) {
    this.vtroco = vtroco;
  }
}
