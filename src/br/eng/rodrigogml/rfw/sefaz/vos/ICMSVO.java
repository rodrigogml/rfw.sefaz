package br.eng.rodrigogml.rfw.sefaz.vos;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "ICMS" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integra��o com o framework, pertindo a valida��o e at� a persist�ncia se o sistema assim desejar. N�o h� preocupa��o de gerar JavaDOC nestas classes pois ela deve representar exatamente a documenta��o da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Valida��o da NF-e.
 */
public class ICMSVO extends RFWVO {

  private static final long serialVersionUID = 6008814847693935270L;

  /**
   * N02 ICMS00 Grupo Tributa��o do ICMS= 00 CG N01 1-1<br>
   * Tributada integralmente
   */
  @RFWMetaRelationshipField(caption = "Tributada Integralmente", required = false, relationship = RelationshipTypes.ASSOCIATION)
  private ICMS00VO icms00 = null;

  /**
   * N03 ICMS10 Grupo Tributa��o do ICMS = 10 CG N01 1-1<br>
   * Tributada e com cobran�a do ICMS por substitui��o tribut�ria
   */
  @RFWMetaRelationshipField(caption = "Tributada com Cobran�a de ICMS por ST", required = false, relationship = RelationshipTypes.ASSOCIATION)
  private ICMS10VO icms10 = null;

  /**
   * N04 ICMS20 Grupo Tributa��o do ICMS = 20 CG N01 1-1 Tributa��o com redu��o de base de c�lculo
   */
  @RFWMetaRelationshipField(caption = "Tributa��o com Redu��o da BC", required = false, relationship = RelationshipTypes.ASSOCIATION)
  private ICMS20VO icms20 = null;

  /**
   * 193 N05 ICMS30 Grupo Tributa��o do ICMS = 30 CG N01 1-1<br>
   * Tributa��o Isenta ou n�o tributada e com cobran�a do ICMS por substitui��o tribut�ria
   */
  @RFWMetaRelationshipField(caption = "Tributa��o Isenta ou N�o Tributada com ST", required = false, relationship = RelationshipTypes.ASSOCIATION)
  private ICMS30VO icms30 = null;

  /**
   * # n02 ICMS00 Grupo Tributa��o do ICMS= 00 CG N01 1-1<br>
   * Tributada integralmente.
   *
   * @return # n02 ICMS00 Grupo Tributa��o do ICMS= 00 CG N01 1-1<br>
   *         Tributada integralmente
   */
  public ICMS00VO getIcms00() {
    return icms00;
  }

  /**
   * # n02 ICMS00 Grupo Tributa��o do ICMS= 00 CG N01 1-1<br>
   * Tributada integralmente.
   *
   * @param icms00 # n02 ICMS00 Grupo Tributa��o do ICMS= 00 CG N01 1-1<br>
   *          Tributada integralmente
   */
  public void setIcms00(ICMS00VO icms00) {
    this.icms00 = icms00;
  }

  /**
   * # n03 ICMS10 Grupo Tributa��o do ICMS = 10 CG N01 1-1<br>
   * Tributada e com cobran�a do ICMS por substitui��o tribut�ria.
   *
   * @return # n03 ICMS10 Grupo Tributa��o do ICMS = 10 CG N01 1-1<br>
   *         Tributada e com cobran�a do ICMS por substitui��o tribut�ria
   */
  public ICMS10VO getIcms10() {
    return icms10;
  }

  /**
   * # n03 ICMS10 Grupo Tributa��o do ICMS = 10 CG N01 1-1<br>
   * Tributada e com cobran�a do ICMS por substitui��o tribut�ria.
   *
   * @param icms10 # n03 ICMS10 Grupo Tributa��o do ICMS = 10 CG N01 1-1<br>
   *          Tributada e com cobran�a do ICMS por substitui��o tribut�ria
   */
  public void setIcms10(ICMS10VO icms10) {
    this.icms10 = icms10;
  }

  /**
   * # n04 ICMS20 Grupo Tributa��o do ICMS = 20 CG N01 1-1 Tributa��o com redu��o de base de c�lculo.
   *
   * @return # n04 ICMS20 Grupo Tributa��o do ICMS = 20 CG N01 1-1 Tributa��o com redu��o de base de c�lculo
   */
  public ICMS20VO getIcms20() {
    return icms20;
  }

  /**
   * # n04 ICMS20 Grupo Tributa��o do ICMS = 20 CG N01 1-1 Tributa��o com redu��o de base de c�lculo.
   *
   * @param icms20 # n04 ICMS20 Grupo Tributa��o do ICMS = 20 CG N01 1-1 Tributa��o com redu��o de base de c�lculo
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
