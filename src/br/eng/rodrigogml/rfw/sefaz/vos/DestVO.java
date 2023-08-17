package br.eng.rodrigogml.rfw.sefaz.vos;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCNPJField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCPFField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringEmailField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "dest" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class DestVO extends RFWVO {

  private static final long serialVersionUID = 4725942875037339955L;

  /**
   * E05 enderDest Endereço do Destinatário da NF-e G E01 0 -1 Grupo Obrig.atório para a NF-e (modelo 55).
   */
  @RFWMetaRelationshipField(caption = "Endereço do Destinatário", required = false, relationship = RelationshipTypes.COMPOSITION)
  private EnderDestVO enderDest = null;

  /**
   * E02 CNPJ CNPJ do destinatário CE E01 N 1-1 14<br>
   * Informar o CNPJ ou o CPF do destinatário, preenchendo os zeros não significativos. No caso de operação com o exterior, ou para comprador estrangeiro informar a tag "idEstrangeiro”.
   */
  @RFWMetaStringCNPJField(caption = "CNPJ Destinatário", required = false)
  private String cnpj = null;

  /**
   * E03 CPF CPF do destinatário CE E01 N 1-1 11<br>
   * Informar o CNPJ ou o CPF do destinatário, preenchendo os zeros não significativos. No caso de operação com o exterior, ou para comprador estrangeiro informar a tag "idEstrangeiro”.
   */
  @RFWMetaStringCPFField(caption = "CPF Destinatário", required = false)
  private String cpf = null;

  /**
   * E03a idEstrangeiro Identificação do destinatário no caso de comprador estrangeiro CE E01 C 1-1 0,5,20<br>
   * Informar esta tag no caso de operação com o exterior, ou para comprador estrangeiro. Informar o número do passaporte ou outro documento legal para identificar pessoa estrangeira (campo aceita valor nulo). Observação: Campo aceita algarismos, letras (maiúsculas e minúsculas) e os caracteres do conjunto que segue: [:.+-/()]
   */
  @RFWMetaStringField(caption = "ID Estrangeiro", minlength = 0, maxLength = 20, required = false, pattern = "[A-Za-z\\d\\:\\.\\+\\-\\/\\(\\)]")
  private String idEstrangeiro = null;

  /**
   * E04 xNome Razão Social ou nome do destinatário E E01 C 0-1 2 - 60<br>
   * Tag Obrigatória para a NF-e (modelo 55) e opcional para a NFC-e.
   */
  @RFWMetaStringField(caption = "Nome Destinatário", minlength = 2, maxLength = 60, required = false, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xnome = null;

  /**
   * E16a indIEDest Indicador da IE do Destinatário E E01 N 1-1 1<br>
   * <li>1=Contribuinte ICMS (informar a IE do destinatário);
   * <li>2=Contribuinte isento de Inscrição no cadastro de Contribuintes
   * <li>9=Não Contribuinte, que pode ou não possuir Inscrição Estadual no Cadastro de Contribuintes do ICMS. <br>
   * Nota 1: No caso de NFC-e informar indIEDest=9 e não informar a tag IE do destinatário; <br>
   * Nota 2: No caso de operação com o Exterior informar indIEDest=9 e não informar a tag IE do destinatário; <br>
   * Nota 3: No caso de Contribuinte Isento de Inscrição (indIEDest=2), não informar a tag IE do destinatário.
   */
  @RFWMetaStringField(caption = "Indicador IE Destinatário", minlength = 1, maxLength = 1, required = true, pattern = "^(1|2|9)$")
  private String indIEDest = null;

  /**
   * E17 IE Inscrição Estadual do Destinatário E E01 N 0-1 2 - 14<br>
   * Campo opcional. Informar somente os algarismos, sem os caracteres de formatação (ponto, barra, hífen, etc.).
   */
  @RFWMetaStringField(caption = "IE Destinatário", minlength = 2, maxLength = 14, required = false, pattern = "\\d*")
  private String ie = null;

  /**
   * E18 ISUF Inscrição na SUFRAMA E E01 N 0-1 8 - 9<br>
   * Obrigatório, nas operações que se beneficiam de incentivos fiscais existentes nas áreas sob controle da SUFRAMA. A omissão desta informação impede o processamento da operação pelo Sistema de Mercadoria Nacional da SUFRAMA e a liberação da Declaração de Ingresso, prejudicando a comprovação do ingresso / internamento da mercadoria nestas áreas. (v2.0)
   */
  @RFWMetaStringField(caption = "Inscrição SUFRAMA", minlength = 8, maxLength = 9, required = false, pattern = "\\d*")
  private String isuf = null;

  /**
   * E18a IM Inscrição Municipal do Tomador do Serviço E E01 C 0-1 1 - 15<br>
   * Campo opcional, pode ser informado na NF-e conjugada, com itens de produtos sujeitos ao ICMS e itens de serviços sujeitos ao ISSQN.
   */
  @RFWMetaStringField(caption = "Inscrição Municipal do Tomador", minlength = 1, maxLength = 15, required = false, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String im = null;

  /**
   * E19 email email E E01 C 0-1 1 - 60<br>
   * Campo pode ser utilizado para informar o e-mail de recepção da NF-e indicada pelo destinatário (v2.0)
   *
   */
  @RFWMetaStringEmailField(caption = "Email", required = false)
  private String email = null;

  /**
   * # e02 CNPJ CNPJ do destinatário CE E01 N 1-1 14<br>
   * Informar o CNPJ ou o CPF do destinatário, preenchendo os zeros não significativos. No caso de operação com o exterior, ou para comprador estrangeiro informar a tag "idEstrangeiro”.
   *
   * @return # e02 CNPJ CNPJ do destinatário CE E01 N 1-1 14<br>
   *         Informar o CNPJ ou o CPF do destinatário, preenchendo os zeros não significativos
   */
  public String getCnpj() {
    return cnpj;
  }

  /**
   * # e02 CNPJ CNPJ do destinatário CE E01 N 1-1 14<br>
   * Informar o CNPJ ou o CPF do destinatário, preenchendo os zeros não significativos. No caso de operação com o exterior, ou para comprador estrangeiro informar a tag "idEstrangeiro”.
   *
   * @param cnpj # e02 CNPJ CNPJ do destinatário CE E01 N 1-1 14<br>
   *          Informar o CNPJ ou o CPF do destinatário, preenchendo os zeros não significativos
   */
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  /**
   * # e03 CPF CPF do destinatário CE E01 N 1-1 11<br>
   * Informar o CNPJ ou o CPF do destinatário, preenchendo os zeros não significativos. No caso de operação com o exterior, ou para comprador estrangeiro informar a tag "idEstrangeiro”.
   *
   * @return # e03 CPF CPF do destinatário CE E01 N 1-1 11<br>
   *         Informar o CNPJ ou o CPF do destinatário, preenchendo os zeros não significativos
   */
  public String getCpf() {
    return cpf;
  }

  /**
   * # e03 CPF CPF do destinatário CE E01 N 1-1 11<br>
   * Informar o CNPJ ou o CPF do destinatário, preenchendo os zeros não significativos. No caso de operação com o exterior, ou para comprador estrangeiro informar a tag "idEstrangeiro”.
   *
   * @param cpf # e03 CPF CPF do destinatário CE E01 N 1-1 11<br>
   *          Informar o CNPJ ou o CPF do destinatário, preenchendo os zeros não significativos
   */
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  /**
   * # e03a idEstrangeiro Identificação do destinatário no caso de comprador estrangeiro CE E01 C 1-1 0,5,20<br>
   * Informar esta tag no caso de operação com o exterior, ou para comprador estrangeiro. Informar o número do passaporte ou outro documento legal para identificar pessoa estrangeira (campo aceita valor nulo). Observação: Campo aceita algarismos, letras (maiúsculas e minúsculas) e os caracteres do conjunto que segue: [:.+-/()].
   *
   * @return # e03a idEstrangeiro Identificação do destinatário no caso de comprador estrangeiro CE E01 C 1-1 0,5,20<br>
   *         Informar esta tag no caso de operação com o exterior, ou para comprador estrangeiro
   */
  public String getIdEstrangeiro() {
    return idEstrangeiro;
  }

  /**
   * # e03a idEstrangeiro Identificação do destinatário no caso de comprador estrangeiro CE E01 C 1-1 0,5,20<br>
   * Informar esta tag no caso de operação com o exterior, ou para comprador estrangeiro. Informar o número do passaporte ou outro documento legal para identificar pessoa estrangeira (campo aceita valor nulo). Observação: Campo aceita algarismos, letras (maiúsculas e minúsculas) e os caracteres do conjunto que segue: [:.+-/()].
   *
   * @param idEstrangeiro # e03a idEstrangeiro Identificação do destinatário no caso de comprador estrangeiro CE E01 C 1-1 0,5,20<br>
   *          Informar esta tag no caso de operação com o exterior, ou para comprador estrangeiro
   */
  public void setIdEstrangeiro(String idEstrangeiro) {
    this.idEstrangeiro = idEstrangeiro;
  }

  /**
   * # e04 xNome Razão Social ou nome do destinatário E E01 C 0-1 2 - 60<br>
   * Tag Obrigatória para a NF-e (modelo 55) e opcional para a NFC-e.
   *
   * @return # e04 xNome Razão Social ou nome do destinatário E E01 C 0-1 2 - 60<br>
   *         Tag Obrigatória para a NF-e (modelo 55) e opcional para a NFC-e
   */
  public String getXnome() {
    return xnome;
  }

  /**
   * # e04 xNome Razão Social ou nome do destinatário E E01 C 0-1 2 - 60<br>
   * Tag Obrigatória para a NF-e (modelo 55) e opcional para a NFC-e.
   *
   * @param xnome # e04 xNome Razão Social ou nome do destinatário E E01 C 0-1 2 - 60<br>
   *          Tag Obrigatória para a NF-e (modelo 55) e opcional para a NFC-e
   */
  public void setXnome(String xnome) {
    this.xnome = xnome;
  }

  /**
   * # e16a indIEDest Indicador da IE do Destinatário E E01 N 1-1 1<br>
   * <li>1=Contribuinte ICMS (informar a IE do destinatário);
   * <li>2=Contribuinte isento de Inscrição no cadastro de Contribuintes
   * <li>9=Não Contribuinte, que pode ou não possuir Inscrição Estadual no Cadastro de Contribuintes do ICMS. <br>
   * Nota 1: No caso de NFC-e informar indIEDest=9 e não informar a tag IE do destinatário; <br>
   * Nota 2: No caso de operação com o Exterior informar indIEDest=9 e não informar a tag IE do destinatário; <br>
   * Nota 3: No caso de Contribuinte Isento de Inscrição (indIEDest=2), não informar a tag IE do destinatário.
   *
   * @return # e16a indIEDest Indicador da IE do Destinatário E E01 N 1-1 1<br>
   *         <li>1=Contribuinte ICMS (informar a IE do destinatário);
   *         <li>2=Contribuinte isento de Inscrição no cadastro de Contribuintes
   *         <li>9=Não Contribuinte, que pode ou não possuir Inscrição Estadual no Cadastro de Contribuintes do ICMS
   */
  public String getIndIEDest() {
    return indIEDest;
  }

  /**
   * # e16a indIEDest Indicador da IE do Destinatário E E01 N 1-1 1<br>
   * <li>1=Contribuinte ICMS (informar a IE do destinatário);
   * <li>2=Contribuinte isento de Inscrição no cadastro de Contribuintes
   * <li>9=Não Contribuinte, que pode ou não possuir Inscrição Estadual no Cadastro de Contribuintes do ICMS. <br>
   * Nota 1: No caso de NFC-e informar indIEDest=9 e não informar a tag IE do destinatário; <br>
   * Nota 2: No caso de operação com o Exterior informar indIEDest=9 e não informar a tag IE do destinatário; <br>
   * Nota 3: No caso de Contribuinte Isento de Inscrição (indIEDest=2), não informar a tag IE do destinatário.
   *
   * @param indIEDest # e16a indIEDest Indicador da IE do Destinatário E E01 N 1-1 1<br>
   *          <li>1=Contribuinte ICMS (informar a IE do destinatário);
   *          <li>2=Contribuinte isento de Inscrição no cadastro de Contribuintes
   *          <li>9=Não Contribuinte, que pode ou não possuir Inscrição Estadual no Cadastro de Contribuintes do ICMS
   */
  public void setIndIEDest(String indIEDest) {
    this.indIEDest = indIEDest;
  }

  /**
   * # e17 IE Inscrição Estadual do Destinatário E E01 N 0-1 2 - 14<br>
   * Campo opcional. Informar somente os algarismos, sem os caracteres de formatação (ponto, barra, hífen, etc.).
   *
   * @return # e17 IE Inscrição Estadual do Destinatário E E01 N 0-1 2 - 14<br>
   *         Campo opcional
   */
  public String getIe() {
    return ie;
  }

  /**
   * # e17 IE Inscrição Estadual do Destinatário E E01 N 0-1 2 - 14<br>
   * Campo opcional. Informar somente os algarismos, sem os caracteres de formatação (ponto, barra, hífen, etc.).
   *
   * @param ie # e17 IE Inscrição Estadual do Destinatário E E01 N 0-1 2 - 14<br>
   *          Campo opcional
   */
  public void setIe(String ie) {
    this.ie = ie;
  }

  /**
   * # e18 ISUF Inscrição na SUFRAMA E E01 N 0-1 8 - 9<br>
   * Obrigatório, nas operações que se beneficiam de incentivos fiscais existentes nas áreas sob controle da SUFRAMA. A omissão desta informação impede o processamento da operação pelo Sistema de Mercadoria Nacional da SUFRAMA e a liberação da Declaração de Ingresso, prejudicando a comprovação do ingresso / internamento da mercadoria nestas áreas. (v2.0).
   *
   * @return # e18 ISUF Inscrição na SUFRAMA E E01 N 0-1 8 - 9<br>
   *         Obrigatório, nas operações que se beneficiam de incentivos fiscais existentes nas áreas sob controle da SUFRAMA
   */
  public String getIsuf() {
    return isuf;
  }

  /**
   * # e18 ISUF Inscrição na SUFRAMA E E01 N 0-1 8 - 9<br>
   * Obrigatório, nas operações que se beneficiam de incentivos fiscais existentes nas áreas sob controle da SUFRAMA. A omissão desta informação impede o processamento da operação pelo Sistema de Mercadoria Nacional da SUFRAMA e a liberação da Declaração de Ingresso, prejudicando a comprovação do ingresso / internamento da mercadoria nestas áreas. (v2.0).
   *
   * @param isuf # e18 ISUF Inscrição na SUFRAMA E E01 N 0-1 8 - 9<br>
   *          Obrigatório, nas operações que se beneficiam de incentivos fiscais existentes nas áreas sob controle da SUFRAMA
   */
  public void setIsuf(String isuf) {
    this.isuf = isuf;
  }

  /**
   * # e18a IM Inscrição Municipal do Tomador do Serviço E E01 C 0-1 1 - 15<br>
   * Campo opcional, pode ser informado na NF-e conjugada, com itens de produtos sujeitos ao ICMS e itens de serviços sujeitos ao ISSQN.
   *
   * @return # e18a IM Inscrição Municipal do Tomador do Serviço E E01 C 0-1 1 - 15<br>
   *         Campo opcional, pode ser informado na NF-e conjugada, com itens de produtos sujeitos ao ICMS e itens de serviços sujeitos ao ISSQN
   */
  public String getIm() {
    return im;
  }

  /**
   * # e18a IM Inscrição Municipal do Tomador do Serviço E E01 C 0-1 1 - 15<br>
   * Campo opcional, pode ser informado na NF-e conjugada, com itens de produtos sujeitos ao ICMS e itens de serviços sujeitos ao ISSQN.
   *
   * @param im # e18a IM Inscrição Municipal do Tomador do Serviço E E01 C 0-1 1 - 15<br>
   *          Campo opcional, pode ser informado na NF-e conjugada, com itens de produtos sujeitos ao ICMS e itens de serviços sujeitos ao ISSQN
   */
  public void setIm(String im) {
    this.im = im;
  }

  /**
   * # e19 email email E E01 C 0-1 1 - 60<br>
   * Campo pode ser utilizado para informar o e-mail de recepção da NF-e indicada pelo destinatário (v2.0).
   *
   * @return # e19 email email E E01 C 0-1 1 - 60<br>
   *         Campo pode ser utilizado para informar o e-mail de recepção da NF-e indicada pelo destinatário (v2
   */
  public String getEmail() {
    return email;
  }

  /**
   * # e19 email email E E01 C 0-1 1 - 60<br>
   * Campo pode ser utilizado para informar o e-mail de recepção da NF-e indicada pelo destinatário (v2.0).
   *
   * @param email # e19 email email E E01 C 0-1 1 - 60<br>
   *          Campo pode ser utilizado para informar o e-mail de recepção da NF-e indicada pelo destinatário (v2
   */
  public void setEmail(String email) {
    this.email = email;
  }

}
