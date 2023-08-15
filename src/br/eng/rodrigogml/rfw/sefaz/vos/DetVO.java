package br.eng.rodrigogml.rfw.sefaz.vos;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaIntegerField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "det" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class DetVO extends RFWVO {

  private static final long serialVersionUID = 5655700438027581802L;

  /**
   * H02 nItem Número do item A H01 N 1-1 1 - 3<br>
   * Número do item (1-990)
   */
  @RFWMetaIntegerField(caption = "Número do Item", minvalue = 1, maxvalue = 990, required = true)
  private Integer nitem = null;

  /**
   * I01 prod Detalhamento de Produtos e Serviços G H01 1-1
   */
  @RFWMetaRelationshipField(caption = "Detalhamento de Produtos e Serviços", required = true, relationship = RelationshipTypes.ASSOCIATION)
  private ProdVO prod = null;

  /**
   * M01 imposto Tributos incidentes no Produto ou Serviço G H01 1-1<br>
   * Grupo ISSQN mutuamente exclusivo com os grupos ICMS e II, isto é, se o grupo ISSQN for informado os grupos ICMS e II não serão informados e vice-versa.
   */
  @RFWMetaRelationshipField(caption = "Tributos Incidentes no Produto/Serviço", required = true, relationship = RelationshipTypes.ASSOCIATION)
  private ImpostoVO imposto = null;

  /**
   * # h02 nItem Número do item A H01 N 1-1 1 - 3<br>
   * Número do item (1-990).
   *
   * @return # h02 nItem Número do item A H01 N 1-1 1 - 3<br>
   *         Número do item (1-990)
   */
  public Integer getNitem() {
    return nitem;
  }

  /**
   * # h02 nItem Número do item A H01 N 1-1 1 - 3<br>
   * Número do item (1-990).
   *
   * @param nitem # h02 nItem Número do item A H01 N 1-1 1 - 3<br>
   *          Número do item (1-990)
   */
  public void setNitem(Integer nitem) {
    this.nitem = nitem;
  }

  /**
   * # i01 prod Detalhamento de Produtos e Serviços G H01 1-1.
   *
   * @return # i01 prod Detalhamento de Produtos e Serviços G H01 1-1
   */
  public ProdVO getProd() {
    return prod;
  }

  /**
   * # i01 prod Detalhamento de Produtos e Serviços G H01 1-1.
   *
   * @param prod # i01 prod Detalhamento de Produtos e Serviços G H01 1-1
   */
  public void setProd(ProdVO prod) {
    this.prod = prod;
  }

  /**
   * # m01 imposto Tributos incidentes no Produto ou Serviço G H01 1-1<br>
   * Grupo ISSQN mutuamente exclusivo com os grupos ICMS e II, isto é, se o grupo ISSQN for informado os grupos ICMS e II não serão informados e vice-versa.
   *
   * @return # m01 imposto Tributos incidentes no Produto ou Serviço G H01 1-1<br>
   *         Grupo ISSQN mutuamente exclusivo com os grupos ICMS e II, isto é, se o grupo ISSQN for informado os grupos ICMS e II não serão informados e vice-versa
   */
  public ImpostoVO getImposto() {
    return imposto;
  }

  /**
   * # m01 imposto Tributos incidentes no Produto ou Serviço G H01 1-1<br>
   * Grupo ISSQN mutuamente exclusivo com os grupos ICMS e II, isto é, se o grupo ISSQN for informado os grupos ICMS e II não serão informados e vice-versa.
   *
   * @param imposto # m01 imposto Tributos incidentes no Produto ou Serviço G H01 1-1<br>
   *          Grupo ISSQN mutuamente exclusivo com os grupos ICMS e II, isto é, se o grupo ISSQN for informado os grupos ICMS e II não serão informados e vice-versa
   */
  public void setImposto(ImpostoVO imposto) {
    this.imposto = imposto;
  }

}
