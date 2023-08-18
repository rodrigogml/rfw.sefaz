package br.eng.rodrigogml.rfw.sefaz.vos;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaIntegerField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
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
  @RFWMetaRelationshipField(caption = "Detalhamento de Produtos e Serviços", required = true, relationship = RelationshipTypes.COMPOSITION)
  private ProdVO prod = null;

  /**
   * M01 imposto Tributos incidentes no Produto ou Serviço G H01 1-1<br>
   * Grupo ISSQN mutuamente exclusivo com os grupos ICMS e II, isto é, se o grupo ISSQN for informado os grupos ICMS e II não serão informados e vice-versa.
   */
  @RFWMetaRelationshipField(caption = "Tributos Incidentes no Produto/Serviço", required = true, relationship = RelationshipTypes.COMPOSITION)
  private ImpostoVO imposto = null;

  /**
   * UA01 impostoDevol Informação do Imposto devolvido G H01 0-1<br>
   * Observação: O motivo da devolução deverá ser informado pela empresa no campo de Informações Adicionais do Produto (tag:infAdProd).
   */
  @RFWMetaRelationshipField(caption = "Informação do Imposto Devolvido", required = false, relationship = RelationshipTypes.COMPOSITION)
  private ImpostoDevolVO impostoDevol = null;

  /**
   * V01 infAdProd Informações Adicionais do Produto E H01 C 0-1 1-500<br>
   * Norma referenciada, informações complementares, etc.
   */
  @RFWMetaStringField(caption = "Informações Adicionais do Produto", minlength = 1, maxLength = 500, required = false)
  private String infAddProd = null;

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

  /**
   * # uA01 impostoDevol Informação do Imposto devolvido G H01 0-1<br>
   * Observação: O motivo da devolução deverá ser informado pela empresa no campo de Informações Adicionais do Produto (tag:infAdProd).
   *
   * @return # uA01 impostoDevol Informação do Imposto devolvido G H01 0-1<br>
   *         Observação: O motivo da devolução deverá ser informado pela empresa no campo de Informações Adicionais do Produto (tag:infAdProd)
   */
  public ImpostoDevolVO getImpostoDevol() {
    return impostoDevol;
  }

  /**
   * # uA01 impostoDevol Informação do Imposto devolvido G H01 0-1<br>
   * Observação: O motivo da devolução deverá ser informado pela empresa no campo de Informações Adicionais do Produto (tag:infAdProd).
   *
   * @param impostoDevol # uA01 impostoDevol Informação do Imposto devolvido G H01 0-1<br>
   *          Observação: O motivo da devolução deverá ser informado pela empresa no campo de Informações Adicionais do Produto (tag:infAdProd)
   */
  public void setImpostoDevol(ImpostoDevolVO impostoDevol) {
    this.impostoDevol = impostoDevol;
  }

  /**
   * # v01 infAdProd Informações Adicionais do Produto E H01 C 0-1 1-500<br>
   * Norma referenciada, informações complementares, etc.
   *
   * @return # v01 infAdProd Informações Adicionais do Produto E H01 C 0-1 1-500<br>
   *         Norma referenciada, informações complementares, etc
   */
  public String getInfAddProd() {
    return infAddProd;
  }

  /**
   * # v01 infAdProd Informações Adicionais do Produto E H01 C 0-1 1-500<br>
   * Norma referenciada, informações complementares, etc.
   *
   * @param infAddProd # v01 infAdProd Informações Adicionais do Produto E H01 C 0-1 1-500<br>
   *          Norma referenciada, informações complementares, etc
   */
  public void setInfAddProd(String infAddProd) {
    this.infAddProd = infAddProd;
  }

}
