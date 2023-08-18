package br.eng.rodrigogml.rfw.sefaz.vos;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "NFe" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class NFeVO extends RFWVO {

  private static final long serialVersionUID = 2120555035105610040L;

  /**
   * A01 infNFe Informações da NF-e G Raiz - 1-1 Grupo que contém as informações da NF-e
   */
  @RFWMetaRelationshipField(caption = "Informações da NF-e", relationship = RelationshipTypes.COMPOSITION, required = true)
  private InfNFeVO infNFe = null;

  /**
   * # a01 infNFe Informações da NF-e G Raiz - 1-1 Grupo que contém as informações da NF-e.
   *
   * @return # a01 infNFe Informações da NF-e G Raiz - 1-1 Grupo que contém as informações da NF-e
   */
  public InfNFeVO getInfNFe() {
    return infNFe;
  }

  /**
   * # a01 infNFe Informações da NF-e G Raiz - 1-1 Grupo que contém as informações da NF-e.
   *
   * @param infNFe # a01 infNFe Informações da NF-e G Raiz - 1-1 Grupo que contém as informações da NF-e
   */
  public void setInfNFe(InfNFeVO infNFeVO) {
    this.infNFe = infNFeVO;
  }

}
