package br.eng.rodrigogml.rfw.sefaz.vos;

import javax.xml.bind.annotation.XmlRootElement;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "retConsCad" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
@XmlRootElement(name = "retConsCad")
public class RetConsCadVO extends RFWVO {

  private static final long serialVersionUID = 1179407465933790722L;

  /**
   * GR02 versao A GR01 N 1-1 1-2v2 Versão do leiaute
   */
  @RFWMetaStringField(caption = "Versão", minlength = 3, maxLength = 4, required = true, pattern = "\\d{1,2}\\.\\d{2}")
  private String versao = null;

  /**
   * GR03 infCons G GR01 - 1-1 - Dados da consulta
   */
  @RFWMetaRelationshipField(caption = "Dados da Consulta", required = true, relationship = RelationshipTypes.COMPOSITION)
  private InfConsVO infCons = null;

  /**
   * # gR02 versao A GR01 N 1-1 1-2v2 Versão do leiaute.
   *
   * @return # gR02 versao A GR01 N 1-1 1-2v2 Versão do leiaute
   */
  public String getVersao() {
    return versao;
  }

  /**
   * # gR02 versao A GR01 N 1-1 1-2v2 Versão do leiaute.
   *
   * @param versao # gR02 versao A GR01 N 1-1 1-2v2 Versão do leiaute
   */
  public void setVersao(String versao) {
    this.versao = versao;
  }

  /**
   * # gR03 infCons G GR01 - 1-1 - Dados da consulta.
   *
   * @return # gR03 infCons G GR01 - 1-1 - Dados da consulta
   */
  public InfConsVO getInfCons() {
    return infCons;
  }

  /**
   * # gR03 infCons G GR01 - 1-1 - Dados da consulta.
   *
   * @param infCons # gR03 infCons G GR01 - 1-1 - Dados da consulta
   */
  public void setInfCons(InfConsVO infCons) {
    this.infCons = infCons;
  }

}
