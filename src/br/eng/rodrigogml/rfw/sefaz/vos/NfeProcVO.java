package br.eng.rodrigogml.rfw.sefaz.vos;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "nfeProc" do layout de XML de Distribuição da NFe.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class NfeProcVO extends RFWVO {

  private static final long serialVersionUID = -4780746374690135003L;

  /**
   * XR02 versao A XR01 N 1-1 1-2v2
   */
  @RFWMetaStringField(caption = "Versão", minlength = 4, maxLength = 5, required = true, pattern = "\\d{1,2}.\\d{2}")
  private String versao = null;

  /**
   * XR03 NFe G XR01 - 1-1 -<Br>
   * XR04 (dados) - - - - - Dados da NF-e, inclusive com os dados da assinatura
   */
  @RFWMetaRelationshipField(caption = "NFe", required = true, relationship = RelationshipTypes.COMPOSITION)
  private NFeVO nfe = null;

  /**
   * XR05 protNfe G XR01 - 1-1 - Protocolo de autorização ou denegação de uso do NF-e, conforme descrito no item 5.2.2.
   */
  @RFWMetaRelationshipField(caption = "Protocolo NFe", required = true, relationship = RelationshipTypes.COMPOSITION)
  private ProtNFeVO protNFe = null;

  /**
   * # xR02 versao A XR01 N 1-1 1-2v2.
   *
   * @return # xR02 versao A XR01 N 1-1 1-2v2
   */
  public String getVersao() {
    return versao;
  }

  /**
   * # xR02 versao A XR01 N 1-1 1-2v2.
   *
   * @param versao # xR02 versao A XR01 N 1-1 1-2v2
   */
  public void setVersao(String versao) {
    this.versao = versao;
  }

  /**
   * # xR03 NFe G XR01 - 1-1 -<Br>
   * XR04 (dados) - - - - - Dados da NF-e, inclusive com os dados da assinatura.
   *
   * @return # xR03 NFe G XR01 - 1-1 -<Br>
   *         XR04 (dados) - - - - - Dados da NF-e, inclusive com os dados da assinatura
   */
  public NFeVO getNfe() {
    return nfe;
  }

  /**
   * # xR03 NFe G XR01 - 1-1 -<Br>
   * XR04 (dados) - - - - - Dados da NF-e, inclusive com os dados da assinatura.
   *
   * @param nfe # xR03 NFe G XR01 - 1-1 -<Br>
   *          XR04 (dados) - - - - - Dados da NF-e, inclusive com os dados da assinatura
   */
  public void setNfe(NFeVO nfe) {
    this.nfe = nfe;
  }

  /**
   * # xR05 protNfe G XR01 - 1-1 - Protocolo de autorização ou denegação de uso do NF-e, conforme descrito no item 5.2.2.
   *
   * @return # xR05 protNfe G XR01 - 1-1 - Protocolo de autorização ou denegação de uso do NF-e, conforme descrito no item 5
   */
  public ProtNFeVO getProtNFe() {
    return protNFe;
  }

  /**
   * # xR05 protNfe G XR01 - 1-1 - Protocolo de autorização ou denegação de uso do NF-e, conforme descrito no item 5.2.2.
   *
   * @param protNFe # xR05 protNfe G XR01 - 1-1 - Protocolo de autorização ou denegação de uso do NF-e, conforme descrito no item 5
   */
  public void setProtNFe(ProtNFeVO protNFe) {
    this.protNFe = protNFe;
  }

}
