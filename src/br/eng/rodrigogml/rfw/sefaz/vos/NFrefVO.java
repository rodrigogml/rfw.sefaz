package br.eng.rodrigogml.rfw.sefaz.vos;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "NFref" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class NFrefVO extends RFWVO {

  private static final long serialVersionUID = 9201315517649676374L;

  /**
   * BA02 refNFe Chave de acesso da NF-e referenciada CE BA01 N 1-1 44 <br>
   * Referencia uma NF-e (modelo 55) emitida anteriormente, vinculada a NF-e atual, ou uma NFC-e (modelo 65)
   */
  @RFWMetaStringField(caption = "Chave Acesso NFe Referenciada", minlength = 44, maxLength = 44, required = false)
  private String refNFe = null;

  /**
   * BA03 refNF Informação da NF modelo 1/1A ou NF modelo 2 referenciada (alterado pela NT2016.002) CG BA01 1-1
   */
  @RFWMetaRelationshipField(caption = "NF modelo 1/1A ou 2", relationship = RelationshipTypes.ASSOCIATION, required = false)
  private RefNFVO refNF = null;

  /**
   * BA10 refNFP Informações da NF de produtor rural referenciada CG BA01 1-1
   */
  @RFWMetaRelationshipField(caption = "NF Produtor Rural", relationship = RelationshipTypes.ASSOCIATION, required = false)
  private RefNFPVO refNFP = null;

  /**
   * BA20 refECF Informações do Cupom Fiscal referenciado CG BA01 1-1<br>
   * Grupo do Cupom Fiscal vinculado à NF-e (v2.0)
   */
  @RFWMetaRelationshipField(caption = "Cupom Fiscal", relationship = RelationshipTypes.ASSOCIATION, required = false)
  private RefECFVO recECF = null;

  /**
   * # bA02 refNFe Chave de acesso da NF-e referenciada CE BA01 N 1-1 44 <br>
   * Referencia uma NF-e (modelo 55) emitida anteriormente, vinculada a NF-e atual, ou uma NFC-e (modelo 65).
   *
   * @return # bA02 refNFe Chave de acesso da NF-e referenciada CE BA01 N 1-1 44 <br>
   *         Referencia uma NF-e (modelo 55) emitida anteriormente, vinculada a NF-e atual, ou uma NFC-e (modelo 65)
   */
  public String getRefNFe() {
    return refNFe;
  }

  /**
   * # bA02 refNFe Chave de acesso da NF-e referenciada CE BA01 N 1-1 44 <br>
   * Referencia uma NF-e (modelo 55) emitida anteriormente, vinculada a NF-e atual, ou uma NFC-e (modelo 65).
   *
   * @param refNFe # bA02 refNFe Chave de acesso da NF-e referenciada CE BA01 N 1-1 44 <br>
   *          Referencia uma NF-e (modelo 55) emitida anteriormente, vinculada a NF-e atual, ou uma NFC-e (modelo 65)
   */
  public void setRefNFe(String refNFe) {
    this.refNFe = refNFe;
  }

  /**
   * # bA03 refNF Informação da NF modelo 1/1A ou NF modelo 2 referenciada (alterado pela NT2016.002) CG BA01 1-1.
   *
   * @return # bA03 refNF Informação da NF modelo 1/1A ou NF modelo 2 referenciada (alterado pela NT2016
   */
  public RefNFVO getRefNF() {
    return refNF;
  }

  /**
   * # bA03 refNF Informação da NF modelo 1/1A ou NF modelo 2 referenciada (alterado pela NT2016.002) CG BA01 1-1.
   *
   * @param refNF # bA03 refNF Informação da NF modelo 1/1A ou NF modelo 2 referenciada (alterado pela NT2016
   */
  public void setRefNF(RefNFVO refNF) {
    this.refNF = refNF;
  }

  /**
   * # bA10 refNFP Informações da NF de produtor rural referenciada CG BA01 1-1.
   *
   * @return # bA10 refNFP Informações da NF de produtor rural referenciada CG BA01 1-1
   */
  public RefNFPVO getRefNFP() {
    return refNFP;
  }

  /**
   * # bA10 refNFP Informações da NF de produtor rural referenciada CG BA01 1-1.
   *
   * @param refNFP # bA10 refNFP Informações da NF de produtor rural referenciada CG BA01 1-1
   */
  public void setRefNFP(RefNFPVO refNFP) {
    this.refNFP = refNFP;
  }

  /**
   * # bA20 refECF Informações do Cupom Fiscal referenciado CG BA01 1-1<br>
   * Grupo do Cupom Fiscal vinculado à NF-e (v2.0).
   *
   * @return # bA20 refECF Informações do Cupom Fiscal referenciado CG BA01 1-1<br>
   *         Grupo do Cupom Fiscal vinculado à NF-e (v2
   */
  public RefECFVO getRecECF() {
    return recECF;
  }

  /**
   * # bA20 refECF Informações do Cupom Fiscal referenciado CG BA01 1-1<br>
   * Grupo do Cupom Fiscal vinculado à NF-e (v2.0).
   *
   * @param recECF # bA20 refECF Informações do Cupom Fiscal referenciado CG BA01 1-1<br>
   *          Grupo do Cupom Fiscal vinculado à NF-e (v2
   */
  public void setRecECF(RefECFVO recECF) {
    this.recECF = recECF;
  }

}
