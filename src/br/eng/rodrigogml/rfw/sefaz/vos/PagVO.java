package br.eng.rodrigogml.rfw.sefaz.vos;

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
  private DetPagVO detPag = null;

  /**
   * # yA01a detPag Grupo Detalhamento do Pagamento G YA01 1-100.
   *
   * @return # yA01a detPag Grupo Detalhamento do Pagamento G YA01 1-100
   */
  public DetPagVO getDetPag() {
    return detPag;
  }

  /**
   * # yA01a detPag Grupo Detalhamento do Pagamento G YA01 1-100.
   *
   * @param detPag # yA01a detPag Grupo Detalhamento do Pagamento G YA01 1-100
   */
  public void setDetPag(DetPagVO detPag) {
    this.detPag = detPag;
  }

}
