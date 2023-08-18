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
  @RFWMetaRelationshipField(caption = "ICMS", required = true, relationship = RelationshipTypes.COMPOSITION)
  private ICMSVO icms = null;

  /**
   * O01 IPI Grupo IPI CG M01 0-1<br>
   * Informar apenas quando o item for sujeito ao IPI
   */
  @RFWMetaRelationshipField(caption = "IPI", required = true, relationship = RelationshipTypes.COMPOSITION)
  private IPIVO ipi = null;

  /**
   * Q01 PIS Grupo PIS G M01 0-1<br>
   * Informar apenas um dos grupos Q02, Q03, Q04 ou Q05 com base valor atribuído ao campo Q06 – CST do PIS
   */
  @RFWMetaRelationshipField(caption = "PIS", required = true, relationship = RelationshipTypes.COMPOSITION)
  private PISVO pis = null;

  /**
   * R01 PISST Grupo PIS Substituição Tributária G M01 0-1
   */
  @RFWMetaRelationshipField(caption = "PIS ST", required = true, relationship = RelationshipTypes.COMPOSITION)
  private PISSTVO pisST = null;

  /**
   * S01 COFINS Grupo COFINS G M01 0-1<br>
   * Informar apenas um dos grupos S02, S03, S04 ou S04 com base valor atribuído ao campo de CST da COFINS
   */
  @RFWMetaRelationshipField(caption = "COFINS", required = true, relationship = RelationshipTypes.COMPOSITION)
  private COFINSVO cofins = null;

  /**
   * T01 COFINSST Grupo COFINS Substituição Tributária G M01 0-1
   */
  @RFWMetaRelationshipField(caption = "COFINS ST", required = true, relationship = RelationshipTypes.COMPOSITION)
  private COFINSSTVO cofinsST = null;

  /**
   * M02 vTotTrib Valor aproximado total de tributos federais, estaduais e municipais. E M01 N 0-1 13v2<br>
   * (NT 2013/003)
   */
  @RFWMetaBigDecimalField(caption = "Valor Aproximado dos Tributos", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = false)
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

  /**
   * # o01 IPI Grupo IPI CG M01 0-1<br>
   * Informar apenas quando o item for sujeito ao IPI.
   *
   * @return # o01 IPI Grupo IPI CG M01 0-1<br>
   *         Informar apenas quando o item for sujeito ao IPI
   */
  public IPIVO getIpi() {
    return ipi;
  }

  /**
   * # o01 IPI Grupo IPI CG M01 0-1<br>
   * Informar apenas quando o item for sujeito ao IPI.
   *
   * @param ipi # o01 IPI Grupo IPI CG M01 0-1<br>
   *          Informar apenas quando o item for sujeito ao IPI
   */
  public void setIpi(IPIVO ipi) {
    this.ipi = ipi;
  }

  /**
   * # q01 PIS Grupo PIS G M01 0-1<br>
   * Informar apenas um dos grupos Q02, Q03, Q04 ou Q05 com base valor atribuído ao campo Q06 – CST do PIS.
   *
   * @return # q01 PIS Grupo PIS G M01 0-1<br>
   *         Informar apenas um dos grupos Q02, Q03, Q04 ou Q05 com base valor atribuído ao campo Q06 – CST do PIS
   */
  public PISVO getPis() {
    return pis;
  }

  /**
   * # q01 PIS Grupo PIS G M01 0-1<br>
   * Informar apenas um dos grupos Q02, Q03, Q04 ou Q05 com base valor atribuído ao campo Q06 – CST do PIS.
   *
   * @param pis # q01 PIS Grupo PIS G M01 0-1<br>
   *          Informar apenas um dos grupos Q02, Q03, Q04 ou Q05 com base valor atribuído ao campo Q06 – CST do PIS
   */
  public void setPis(PISVO pis) {
    this.pis = pis;
  }

  /**
   * # r01 PISST Grupo PIS Substituição Tributária G M01 0-1.
   *
   * @return # r01 PISST Grupo PIS Substituição Tributária G M01 0-1
   */
  public PISSTVO getPisST() {
    return pisST;
  }

  /**
   * # r01 PISST Grupo PIS Substituição Tributária G M01 0-1.
   *
   * @param pisST # r01 PISST Grupo PIS Substituição Tributária G M01 0-1
   */
  public void setPisST(PISSTVO pisST) {
    this.pisST = pisST;
  }

  /**
   * # s01 COFINS Grupo COFINS G M01 0-1<br>
   * Informar apenas um dos grupos S02, S03, S04 ou S04 com base valor atribuído ao campo de CST da COFINS.
   *
   * @return # s01 COFINS Grupo COFINS G M01 0-1<br>
   *         Informar apenas um dos grupos S02, S03, S04 ou S04 com base valor atribuído ao campo de CST da COFINS
   */
  public COFINSVO getCofins() {
    return cofins;
  }

  /**
   * # s01 COFINS Grupo COFINS G M01 0-1<br>
   * Informar apenas um dos grupos S02, S03, S04 ou S04 com base valor atribuído ao campo de CST da COFINS.
   *
   * @param cofins # s01 COFINS Grupo COFINS G M01 0-1<br>
   *          Informar apenas um dos grupos S02, S03, S04 ou S04 com base valor atribuído ao campo de CST da COFINS
   */
  public void setCofins(COFINSVO cofins) {
    this.cofins = cofins;
  }

  /**
   * # t01 COFINSST Grupo COFINS Substituição Tributária G M01 0-1.
   *
   * @return # t01 COFINSST Grupo COFINS Substituição Tributária G M01 0-1
   */
  public COFINSSTVO getCofinsST() {
    return cofinsST;
  }

  /**
   * # t01 COFINSST Grupo COFINS Substituição Tributária G M01 0-1.
   *
   * @param cofinsST # t01 COFINSST Grupo COFINS Substituição Tributária G M01 0-1
   */
  public void setCofinsST(COFINSSTVO cofinsST) {
    this.cofinsST = cofinsST;
  }

}
