package br.eng.rodrigogml.rfw.sefaz.vos;

import java.math.BigDecimal;
import java.util.List;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "pag" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class PagVO extends RFWVO {

  private static final long serialVersionUID = 1L;

  /**
   * YA01a detPag Grupo Detalhamento do Pagamento G YA01 1-100
   */
  @RFWMetaRelationshipField(caption = "Grupo Detalhemento do Pagamento", minSize = 1, required = true, relationship = RelationshipTypes.COMPOSITION)
  private List<DetPagVO> detPag = null;

  /**
   * YA09 vTroco Valor do troco E YA01 N 0-1 13v2<bR>
   * Valor do troco (Incluído na NT2016.002)
   */
  @RFWMetaBigDecimalField(caption = "Troco", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = false)
  private BigDecimal vtroco = null;

  /**
   * # yA01a detPag Grupo Detalhamento do Pagamento G YA01 1-100.
   *
   * @return # yA01a detPag Grupo Detalhamento do Pagamento G YA01 1-100
   */
  public List<DetPagVO> getDetPag() {
    return detPag;
  }

  /**
   * # yA01a detPag Grupo Detalhamento do Pagamento G YA01 1-100.
   *
   * @param detPag # yA01a detPag Grupo Detalhamento do Pagamento G YA01 1-100
   */
  public void setDetPag(List<DetPagVO> detPag) {
    this.detPag = detPag;
  }

  /**
   * # yA09 vTroco Valor do troco E YA01 N 0-1 13v2<bR>
   * Valor do troco (Incluído na NT2016.002).
   *
   * @return # yA09 vTroco Valor do troco E YA01 N 0-1 13v2<bR>
   *         Valor do troco (Incluído na NT2016
   */
  public BigDecimal getVtroco() {
    return vtroco;
  }

  /**
   * # yA09 vTroco Valor do troco E YA01 N 0-1 13v2<bR>
   * Valor do troco (Incluído na NT2016.002).
   *
   * @param vtroco # yA09 vTroco Valor do troco E YA01 N 0-1 13v2<bR>
   *          Valor do troco (Incluído na NT2016
   */
  public void setVtroco(BigDecimal vtroco) {
    this.vtroco = vtroco;
  }

}
