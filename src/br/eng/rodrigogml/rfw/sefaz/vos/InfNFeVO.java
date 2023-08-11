package br.eng.rodrigogml.rfw.sefaz.vos;

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
  @RFWMetaStringField(caption = "Vers�o do Leiaute", maxlength = 4, minlength = 1, required = true)
  private String versao = null;

  /**
   * A03 Id Identificador da TAG a ser assinada ID A01 C 1-1 47 Informar a Chave de Acesso precedida do literal �NFe�,<Br>
   * <b>Note que este atributo no XML � "id", mas foi chamado de idAttribute para evitar o conflito com o ID herdado de {@link RFWVO}
   */
  @RFWMetaStringField(caption = "Id", maxlength = 47, minlength = 47, required = true, pattern = "NFe[0-9]{44}")
  private String idAttribute = null;

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

}
