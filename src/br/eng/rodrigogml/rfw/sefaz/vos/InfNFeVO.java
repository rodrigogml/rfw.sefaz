package br.eng.rodrigogml.rfw.sefaz.vos;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "infNFe" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class InfNFeVO extends RFWVO {

  private static final long serialVersionUID = 5158903694543076637L;

  /**
   * A02 versao Versão do leiaute A A01 C 1-1 1 - 4 Versão do leiaute (4.00)
   */
  @RFWMetaStringField(caption = "Versão do Leiaute", maxlength = 4, minlength = 1, required = true)
  private String versao = null;

  /**
   * A03 Id Identificador da TAG a ser assinada ID A01 C 1-1 47 Informar a Chave de Acesso precedida do literal ‘NFe’,<Br>
   * <b>Note que este atributo no XML é "id", mas foi chamado de idAttribute para evitar o conflito com o ID herdado de {@link RFWVO}
   */
  @RFWMetaStringField(caption = "Id", maxlength = 47, minlength = 47, required = true, pattern = "NFe[0-9]{44}")
  private String idAttribute = null;

  /**
   * # a02 versao Versão do leiaute A A01 C 1-1 1 - 4 Versão do leiaute (4.00).
   *
   * @return # a02 versao Versão do leiaute A A01 C 1-1 1 - 4 Versão do leiaute (4
   */
  public String getVersao() {
    return versao;
  }

  /**
   * # a02 versao Versão do leiaute A A01 C 1-1 1 - 4 Versão do leiaute (4.00).
   *
   * @param versao # a02 versao Versão do leiaute A A01 C 1-1 1 - 4 Versão do leiaute (4
   */
  public void setVersao(String versao) {
    this.versao = versao;
  }

  /**
   * # a03 Id Identificador da TAG a ser assinada ID A01 C 1-1 47 Informar a Chave de Acesso precedida do literal ‘NFe’,<Br>
   * <b>Note que este atributo no XML é "id", mas foi chamado de idAttribute para evitar o conflito com o ID herdado de {@link RFWVO}.
   *
   * @return # a03 Id Identificador da TAG a ser assinada ID A01 C 1-1 47 Informar a Chave de Acesso precedida do literal ‘NFe’,<Br>
   *         <b>Note que este atributo no XML é "id", mas foi chamado de idAttribute para evitar o conflito com o ID herdado de {@link RFWVO}
   */
  public String getIdAttribute() {
    return idAttribute;
  }

  /**
   * # a03 Id Identificador da TAG a ser assinada ID A01 C 1-1 47 Informar a Chave de Acesso precedida do literal ‘NFe’,<Br>
   * <b>Note que este atributo no XML é "id", mas foi chamado de idAttribute para evitar o conflito com o ID herdado de {@link RFWVO}.
   *
   * @param idAttribute # a03 Id Identificador da TAG a ser assinada ID A01 C 1-1 47 Informar a Chave de Acesso precedida do literal ‘NFe’,<Br>
   *          <b>Note que este atributo no XML é "id", mas foi chamado de idAttribute para evitar o conflito com o ID herdado de {@link RFWVO}
   */
  public void setIdAttribute(String idAttribute) {
    this.idAttribute = idAttribute;
  }

}
