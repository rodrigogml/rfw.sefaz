package br.eng.rodrigogml.rfw.sefaz.vos;

import java.util.List;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "infNFe" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integra��o com o framework, pertindo a valida��o e at� a persist�ncia se o sistema assim desejar. N�o h� preocupa��o de gerar JavaDOC nestas classes pois ela deve representar exatamente a documenta��o da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Valida��o da NF-e.
 */
public class InfNFeVO extends RFWVO {

  private static final long serialVersionUID = 5158903694543076637L;

  /**
   * A02 versao Vers�o do leiaute A A01 C 1-1 1 - 4 Vers�o do leiaute (4.00)
   */
  @RFWMetaStringField(caption = "Vers�o do Leiaute", maxLength = 4, minlength = 1, required = true)
  private String versao = null;

  /**
   * A03 Id Identificador da TAG a ser assinada ID A01 C 1-1 47 Informar a Chave de Acesso precedida do literal �NFe�,<Br>
   * <b>Note que este atributo no XML � "id", mas foi chamado de idAttribute para evitar o conflito com o ID herdado de {@link RFWVO}
   */
  @RFWMetaStringField(caption = "Id", maxLength = 47, minlength = 47, required = true, pattern = "NFe[0-9]{44}")
  private String idAttribute = null;

  /**
   * B01 ide Informa��es de identifica��o da NF-e G A01 1-1
   */
  @RFWMetaRelationshipField(caption = "Informa��es de Identifica��o da NFe", required = true, relationship = RelationshipTypes.ASSOCIATION)
  private IdeVO ide = null;

  /**
   * C01 emit Identifica��o do emitente da NF-e G A01 1-1
   */
  @RFWMetaRelationshipField(caption = "Identifica��o do Emitente da NFe", required = true, relationship = RelationshipTypes.ASSOCIATION)
  private EmitVO emit = null;

  /**
   * H01 det Detalhamento de Produtos e Servi�os G A01 1-990<br>
   * M�ltiplas ocorr�ncias (m�ximo = 990)
   */
  @RFWMetaRelationshipField(caption = "Detalhamento de Produtos e Servi�os", minSize = 1, required = true, relationship = RelationshipTypes.ASSOCIATION)
  public List<DetVO> det = null;

  /**
   * # a02 versao Vers�o do leiaute A A01 C 1-1 1 - 4 Vers�o do leiaute (4.00).
   *
   * @return # a02 versao Vers�o do leiaute A A01 C 1-1 1 - 4 Vers�o do leiaute (4
   */
  public String getVersao() {
    return versao;
  }

  /**
   * # a02 versao Vers�o do leiaute A A01 C 1-1 1 - 4 Vers�o do leiaute (4.00).
   *
   * @param versao # a02 versao Vers�o do leiaute A A01 C 1-1 1 - 4 Vers�o do leiaute (4
   */
  public void setVersao(String versao) {
    this.versao = versao;
  }

  /**
   * # a03 Id Identificador da TAG a ser assinada ID A01 C 1-1 47 Informar a Chave de Acesso precedida do literal �NFe�,<Br>
   * <b>Note que este atributo no XML � "id", mas foi chamado de idAttribute para evitar o conflito com o ID herdado de {@link RFWVO}.
   *
   * @return # a03 Id Identificador da TAG a ser assinada ID A01 C 1-1 47 Informar a Chave de Acesso precedida do literal �NFe�,<Br>
   *         <b>Note que este atributo no XML � "id", mas foi chamado de idAttribute para evitar o conflito com o ID herdado de {@link RFWVO}
   */
  public String getIdAttribute() {
    return idAttribute;
  }

  /**
   * # a03 Id Identificador da TAG a ser assinada ID A01 C 1-1 47 Informar a Chave de Acesso precedida do literal �NFe�,<Br>
   * <b>Note que este atributo no XML � "id", mas foi chamado de idAttribute para evitar o conflito com o ID herdado de {@link RFWVO}.
   *
   * @param idAttribute # a03 Id Identificador da TAG a ser assinada ID A01 C 1-1 47 Informar a Chave de Acesso precedida do literal �NFe�,<Br>
   *          <b>Note que este atributo no XML � "id", mas foi chamado de idAttribute para evitar o conflito com o ID herdado de {@link RFWVO}
   */
  public void setIdAttribute(String idAttribute) {
    this.idAttribute = idAttribute;
  }

  /**
   * # b01 ide Informa��es de identifica��o da NF-e G A01 1-1.
   *
   * @return # b01 ide Informa��es de identifica��o da NF-e G A01 1-1
   */
  public IdeVO getIde() {
    return ide;
  }

  /**
   * # b01 ide Informa��es de identifica��o da NF-e G A01 1-1.
   *
   * @param ide # b01 ide Informa��es de identifica��o da NF-e G A01 1-1
   */
  public void setIde(IdeVO ide) {
    this.ide = ide;
  }

  /**
   * # c01 emit Identifica��o do emitente da NF-e G A01 1-1.
   *
   * @return # c01 emit Identifica��o do emitente da NF-e G A01 1-1
   */
  public EmitVO getEmit() {
    return emit;
  }

  /**
   * # c01 emit Identifica��o do emitente da NF-e G A01 1-1.
   *
   * @param emit # c01 emit Identifica��o do emitente da NF-e G A01 1-1
   */
  public void setEmit(EmitVO emit) {
    this.emit = emit;
  }

  /**
   * # h01 det Detalhamento de Produtos e Servi�os G A01 1-990<br>
   * M�ltiplas ocorr�ncias (m�ximo = 990).
   *
   * @return # h01 det Detalhamento de Produtos e Servi�os G A01 1-990<br>
   *         M�ltiplas ocorr�ncias (m�ximo = 990)
   */
  public List<DetVO> getDet() {
    return det;
  }

  /**
   * # h01 det Detalhamento de Produtos e Servi�os G A01 1-990<br>
   * M�ltiplas ocorr�ncias (m�ximo = 990).
   *
   * @param det # h01 det Detalhamento de Produtos e Servi�os G A01 1-990<br>
   *          M�ltiplas ocorr�ncias (m�ximo = 990)
   */
  public void setDet(List<DetVO> det) {
    this.det = det;
  }

}
