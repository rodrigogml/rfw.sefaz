package br.eng.rodrigogml.rfw.sefaz.vos;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "imposto" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class ImpostoVO extends RFWVO {

  private static final long serialVersionUID = 2398902738967069440L;

  /**
   * N01 ICMS Informações do ICMS da Operação própria e ST CG M01 1-1<br>
   * Informar apenas um dos grupos de tributação do ICMS (ICMS00, ICMS10, ...) (v2.0)
   */
  @RFWMetaRelationshipField(caption = "ICMS", required = true, relationship = RelationshipTypes.ASSOCIATION)
  private ICMSVO icms = null;

  /**
   * M02 vTotTrib Valor aproximado total de tributos federais, estaduais e municipais. E M01 N 0-1 13v2<br>
   * (NT 2013/003)
   */
  @RFWMetaBigDecimalField(caption = "Valor Aproximado dos Tributos", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vtotTrib = null;

  /**
   * # m02 vTotTrib Valor aproximado total de tributos federais, estaduais e municipais. E M01 N 0-1 13v2<br>
   * (NT 2013/003).
   *
   * @return # m02 vTotTrib Valor aproximado total de tributos federais, estaduais e municipais
   */
  public BigDecimal getVtotTrib() {
    return vtotTrib;
  }

  /**
   * # m02 vTotTrib Valor aproximado total de tributos federais, estaduais e municipais. E M01 N 0-1 13v2<br>
   * (NT 2013/003).
   *
   * @param vtotTrib # m02 vTotTrib Valor aproximado total de tributos federais, estaduais e municipais
   */
  public void setVtotTrib(BigDecimal vtotTrib) {
    this.vtotTrib = vtotTrib;
  }

  /**
   * # n01 ICMS Informações do ICMS da Operação própria e ST CG M01 1-1<br>
   * Informar apenas um dos grupos de tributação do ICMS (ICMS00, ICMS10, ..) (v2.0).
   *
   * @return # n01 ICMS Informações do ICMS da Operação própria e ST CG M01 1-1<br>
   *         Informar apenas um dos grupos de tributação do ICMS (ICMS00, ICMS10,
   */
  public ICMSVO getIcms() {
    return icms;
  }

  /**
   * # n01 ICMS Informações do ICMS da Operação própria e ST CG M01 1-1<br>
   * Informar apenas um dos grupos de tributação do ICMS (ICMS00, ICMS10, ..) (v2.0).
   *
   * @param icms # n01 ICMS Informações do ICMS da Operação própria e ST CG M01 1-1<br>
   *          Informar apenas um dos grupos de tributação do ICMS (ICMS00, ICMS10,
   */
  public void setIcms(ICMSVO icms) {
    this.icms = icms;
  }

}
