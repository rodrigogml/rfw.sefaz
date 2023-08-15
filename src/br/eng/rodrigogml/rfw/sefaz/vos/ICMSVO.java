package br.eng.rodrigogml.rfw.sefaz.vos;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "ICMS" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class ICMSVO extends RFWVO {

  private static final long serialVersionUID = 6008814847693935270L;

  /**
   * N02 ICMS00 Grupo Tributação do ICMS= 00 CG N01 1-1<br>
   * Tributada integralmente
   */
  @RFWMetaRelationshipField(caption = "Tributada Integralmente", required = false, relationship = RelationshipTypes.ASSOCIATION)
  private ICMS00VO icms00 = null;

  /**
   * N03 ICMS10 Grupo Tributação do ICMS = 10 CG N01 1-1<br>
   * Tributada e com cobrança do ICMS por substituição tributária
   */
  @RFWMetaRelationshipField(caption = "Tributada com Cobrança de ICMS por ST", required = false, relationship = RelationshipTypes.ASSOCIATION)
  private ICMS10VO icms10 = null;

  /**
   * N04 ICMS20 Grupo Tributação do ICMS = 20 CG N01 1-1 Tributação com redução de base de cálculo
   */
  @RFWMetaRelationshipField(caption = "Tributação com Redução da BC", required = false, relationship = RelationshipTypes.ASSOCIATION)
  private ICMS20VO icms20 = null;

  /**
   * 193 N05 ICMS30 Grupo Tributação do ICMS = 30 CG N01 1-1<br>
   * Tributação Isenta ou não tributada e com cobrança do ICMS por substituição tributária
   */
  @RFWMetaRelationshipField(caption = "Tributação Isenta ou Nâo Tributada com ST", required = false, relationship = RelationshipTypes.ASSOCIATION)
  private ICMS30VO icms30 = null;

  /**
   * # n02 ICMS00 Grupo Tributação do ICMS= 00 CG N01 1-1<br>
   * Tributada integralmente.
   *
   * @return # n02 ICMS00 Grupo Tributação do ICMS= 00 CG N01 1-1<br>
   *         Tributada integralmente
   */
  public ICMS00VO getIcms00() {
    return icms00;
  }

  /**
   * # n02 ICMS00 Grupo Tributação do ICMS= 00 CG N01 1-1<br>
   * Tributada integralmente.
   *
   * @param icms00 # n02 ICMS00 Grupo Tributação do ICMS= 00 CG N01 1-1<br>
   *          Tributada integralmente
   */
  public void setIcms00(ICMS00VO icms00) {
    this.icms00 = icms00;
  }

  /**
   * # n03 ICMS10 Grupo Tributação do ICMS = 10 CG N01 1-1<br>
   * Tributada e com cobrança do ICMS por substituição tributária.
   *
   * @return # n03 ICMS10 Grupo Tributação do ICMS = 10 CG N01 1-1<br>
   *         Tributada e com cobrança do ICMS por substituição tributária
   */
  public ICMS10VO getIcms10() {
    return icms10;
  }

  /**
   * # n03 ICMS10 Grupo Tributação do ICMS = 10 CG N01 1-1<br>
   * Tributada e com cobrança do ICMS por substituição tributária.
   *
   * @param icms10 # n03 ICMS10 Grupo Tributação do ICMS = 10 CG N01 1-1<br>
   *          Tributada e com cobrança do ICMS por substituição tributária
   */
  public void setIcms10(ICMS10VO icms10) {
    this.icms10 = icms10;
  }

  /**
   * # n04 ICMS20 Grupo Tributação do ICMS = 20 CG N01 1-1 Tributação com redução de base de cálculo.
   *
   * @return # n04 ICMS20 Grupo Tributação do ICMS = 20 CG N01 1-1 Tributação com redução de base de cálculo
   */
  public ICMS20VO getIcms20() {
    return icms20;
  }

  /**
   * # n04 ICMS20 Grupo Tributação do ICMS = 20 CG N01 1-1 Tributação com redução de base de cálculo.
   *
   * @param icms20 # n04 ICMS20 Grupo Tributação do ICMS = 20 CG N01 1-1 Tributação com redução de base de cálculo
   */
  public void setIcms20(ICMS20VO icms20) {
    this.icms20 = icms20;
  }

  public ICMS30VO getIcms30() {
    return icms30;
  }

  public void setIcms30(ICMS30VO icms30) {
    this.icms30 = icms30;
  }

}
