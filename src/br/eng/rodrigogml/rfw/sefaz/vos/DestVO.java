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
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integra��o com o framework, pertindo a valida��o e at� a persist�ncia se o sistema assim desejar. N�o h� preocupa��o de gerar JavaDOC nestas classes pois ela deve representar exatamente a documenta��o da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Valida��o da NF-e.
 */
public class DestVO extends RFWVO {

  private static final long serialVersionUID = 4725942875037339955L;

  /**
   * E05 enderDest Endere�o do Destinat�rio da NF-e G E01 0 -1 Grupo Obrig.at�rio para a NF-e (modelo 55).
   */
  @RFWMetaRelationshipField(caption = "Endere�o do Destinat�rio", required = false, relationship = RelationshipTypes.COMPOSITION)
  private EnderDestVO enderDest = null;

  /**
   * E02 CNPJ CNPJ do destinat�rio CE E01 N 1-1 14<br>
   * Informar o CNPJ ou o CPF do destinat�rio, preenchendo os zeros n�o significativos. No caso de opera��o com o exterior, ou para comprador estrangeiro informar a tag "idEstrangeiro�.
   */
  @RFWMetaStringCNPJField(caption = "CNPJ Destinat�rio", required = false)
  private String cnpj = null;

  /**
   * E03 CPF CPF do destinat�rio CE E01 N 1-1 11<br>
   * Informar o CNPJ ou o CPF do destinat�rio, preenchendo os zeros n�o significativos. No caso de opera��o com o exterior, ou para comprador estrangeiro informar a tag "idEstrangeiro�.
   */
  @RFWMetaStringCPFField(caption = "CPF Destinat�rio", required = false)
  private String cpf = null;

  /**
   * E03a idEstrangeiro Identifica��o do destinat�rio no caso de comprador estrangeiro CE E01 C 1-1 0,5,20<br>
   * Informar esta tag no caso de opera��o com o exterior, ou para comprador estrangeiro. Informar o n�mero do passaporte ou outro documento legal para identificar pessoa estrangeira (campo aceita valor nulo). Observa��o: Campo aceita algarismos, letras (mai�sculas e min�sculas) e os caracteres do conjunto que segue: [:.+-/()]
   */
  @RFWMetaStringField(caption = "ID Estrangeiro", minlength = 0, maxLength = 20, required = false, pattern = "[A-Za-z\\d\\:\\.\\+\\-\\/\\(\\)]")
  private String idEstrangeiro = null;

  /**
   * E04 xNome Raz�o Social ou nome do destinat�rio E E01 C 0-1 2 - 60<br>
   * Tag Obrigat�ria para a NF-e (modelo 55) e opcional para a NFC-e.
   */
  @RFWMetaStringField(caption = "Nome Destinat�rio", minlength = 2, maxLength = 60, required = false, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xnome = null;

  /**
   * E16a indIEDest Indicador da IE do Destinat�rio E E01 N 1-1 1<br>
   * <li>1=Contribuinte ICMS (informar a IE do destinat�rio);
   * <li>2=Contribuinte isento de Inscri��o no cadastro de Contribuintes
   * <li>9=N�o Contribuinte, que pode ou n�o possuir Inscri��o Estadual no Cadastro de Contribuintes do ICMS. <br>
   * Nota 1: No caso de NFC-e informar indIEDest=9 e n�o informar a tag IE do destinat�rio; <br>
   * Nota 2: No caso de opera��o com o Exterior informar indIEDest=9 e n�o informar a tag IE do destinat�rio; <br>
   * Nota 3: No caso de Contribuinte Isento de Inscri��o (indIEDest=2), n�o informar a tag IE do destinat�rio.
   */
  @RFWMetaStringField(caption = "Indicador IE Destinat�rio", minlength = 1, maxLength = 1, required = true, pattern = "^(1|2|9)$")
  private String indIEDest = null;

  /**
   * E17 IE Inscri��o Estadual do Destinat�rio E E01 N 0-1 2 - 14<br>
   * Campo opcional. Informar somente os algarismos, sem os caracteres de formata��o (ponto, barra, h�fen, etc.).
   */
  @RFWMetaStringField(caption = "IE Destinat�rio", minlength = 2, maxLength = 14, required = false, pattern = "\\d*")
  private String ie = null;

  /**
   * E18 ISUF Inscri��o na SUFRAMA E E01 N 0-1 8 - 9<br>
   * Obrigat�rio, nas opera��es que se beneficiam de incentivos fiscais existentes nas �reas sob controle da SUFRAMA. A omiss�o desta informa��o impede o processamento da opera��o pelo Sistema de Mercadoria Nacional da SUFRAMA e a libera��o da Declara��o de Ingresso, prejudicando a comprova��o do ingresso / internamento da mercadoria nestas �reas. (v2.0)
   */
  @RFWMetaStringField(caption = "Inscri��o SUFRAMA", minlength = 8, maxLength = 9, required = false, pattern = "\\d*")
  private String isuf = null;

  /**
   * E18a IM Inscri��o Municipal do Tomador do Servi�o E E01 C 0-1 1 - 15<br>
   * Campo opcional, pode ser informado na NF-e conjugada, com itens de produtos sujeitos ao ICMS e itens de servi�os sujeitos ao ISSQN.
   */
  @RFWMetaStringField(caption = "Inscri��o Municipal do Tomador", minlength = 1, maxLength = 15, required = false, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String im = null;

  /**
   * E19 email email E E01 C 0-1 1 - 60<br>
   * Campo pode ser utilizado para informar o e-mail de recep��o da NF-e indicada pelo destinat�rio (v2.0)
   *
   */
  @RFWMetaStringEmailField(caption = "Email", required = false)
  private String email = null;

  /**
   * # e02 CNPJ CNPJ do destinat�rio CE E01 N 1-1 14<br>
   * Informar o CNPJ ou o CPF do destinat�rio, preenchendo os zeros n�o significativos. No caso de opera��o com o exterior, ou para comprador estrangeiro informar a tag "idEstrangeiro�.
   *
   * @return # e02 CNPJ CNPJ do destinat�rio CE E01 N 1-1 14<br>
   *         Informar o CNPJ ou o CPF do destinat�rio, preenchendo os zeros n�o significativos
   */
  public String getCnpj() {
    return cnpj;
  }

  /**
   * # e02 CNPJ CNPJ do destinat�rio CE E01 N 1-1 14<br>
   * Informar o CNPJ ou o CPF do destinat�rio, preenchendo os zeros n�o significativos. No caso de opera��o com o exterior, ou para comprador estrangeiro informar a tag "idEstrangeiro�.
   *
   * @param cnpj # e02 CNPJ CNPJ do destinat�rio CE E01 N 1-1 14<br>
   *          Informar o CNPJ ou o CPF do destinat�rio, preenchendo os zeros n�o significativos
   */
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  /**
   * # e03 CPF CPF do destinat�rio CE E01 N 1-1 11<br>
   * Informar o CNPJ ou o CPF do destinat�rio, preenchendo os zeros n�o significativos. No caso de opera��o com o exterior, ou para comprador estrangeiro informar a tag "idEstrangeiro�.
   *
   * @return # e03 CPF CPF do destinat�rio CE E01 N 1-1 11<br>
   *         Informar o CNPJ ou o CPF do destinat�rio, preenchendo os zeros n�o significativos
   */
  public String getCpf() {
    return cpf;
  }

  /**
   * # e03 CPF CPF do destinat�rio CE E01 N 1-1 11<br>
   * Informar o CNPJ ou o CPF do destinat�rio, preenchendo os zeros n�o significativos. No caso de opera��o com o exterior, ou para comprador estrangeiro informar a tag "idEstrangeiro�.
   *
   * @param cpf # e03 CPF CPF do destinat�rio CE E01 N 1-1 11<br>
   *          Informar o CNPJ ou o CPF do destinat�rio, preenchendo os zeros n�o significativos
   */
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  /**
   * # e03a idEstrangeiro Identifica��o do destinat�rio no caso de comprador estrangeiro CE E01 C 1-1 0,5,20<br>
   * Informar esta tag no caso de opera��o com o exterior, ou para comprador estrangeiro. Informar o n�mero do passaporte ou outro documento legal para identificar pessoa estrangeira (campo aceita valor nulo). Observa��o: Campo aceita algarismos, letras (mai�sculas e min�sculas) e os caracteres do conjunto que segue: [:.+-/()].
   *
   * @return # e03a idEstrangeiro Identifica��o do destinat�rio no caso de comprador estrangeiro CE E01 C 1-1 0,5,20<br>
   *         Informar esta tag no caso de opera��o com o exterior, ou para comprador estrangeiro
   */
  public String getIdEstrangeiro() {
    return idEstrangeiro;
  }

  /**
   * # e03a idEstrangeiro Identifica��o do destinat�rio no caso de comprador estrangeiro CE E01 C 1-1 0,5,20<br>
   * Informar esta tag no caso de opera��o com o exterior, ou para comprador estrangeiro. Informar o n�mero do passaporte ou outro documento legal para identificar pessoa estrangeira (campo aceita valor nulo). Observa��o: Campo aceita algarismos, letras (mai�sculas e min�sculas) e os caracteres do conjunto que segue: [:.+-/()].
   *
   * @param idEstrangeiro # e03a idEstrangeiro Identifica��o do destinat�rio no caso de comprador estrangeiro CE E01 C 1-1 0,5,20<br>
   *          Informar esta tag no caso de opera��o com o exterior, ou para comprador estrangeiro
   */
  public void setIdEstrangeiro(String idEstrangeiro) {
    this.idEstrangeiro = idEstrangeiro;
  }

  /**
   * # e04 xNome Raz�o Social ou nome do destinat�rio E E01 C 0-1 2 - 60<br>
   * Tag Obrigat�ria para a NF-e (modelo 55) e opcional para a NFC-e.
   *
   * @return # e04 xNome Raz�o Social ou nome do destinat�rio E E01 C 0-1 2 - 60<br>
   *         Tag Obrigat�ria para a NF-e (modelo 55) e opcional para a NFC-e
   */
  public String getXnome() {
    return xnome;
  }

  /**
   * # e04 xNome Raz�o Social ou nome do destinat�rio E E01 C 0-1 2 - 60<br>
   * Tag Obrigat�ria para a NF-e (modelo 55) e opcional para a NFC-e.
   *
   * @param xnome # e04 xNome Raz�o Social ou nome do destinat�rio E E01 C 0-1 2 - 60<br>
   *          Tag Obrigat�ria para a NF-e (modelo 55) e opcional para a NFC-e
   */
  public void setXnome(String xnome) {
    this.xnome = xnome;
  }

  /**
   * # e16a indIEDest Indicador da IE do Destinat�rio E E01 N 1-1 1<br>
   * <li>1=Contribuinte ICMS (informar a IE do destinat�rio);
   * <li>2=Contribuinte isento de Inscri��o no cadastro de Contribuintes
   * <li>9=N�o Contribuinte, que pode ou n�o possuir Inscri��o Estadual no Cadastro de Contribuintes do ICMS. <br>
   * Nota 1: No caso de NFC-e informar indIEDest=9 e n�o informar a tag IE do destinat�rio; <br>
   * Nota 2: No caso de opera��o com o Exterior informar indIEDest=9 e n�o informar a tag IE do destinat�rio; <br>
   * Nota 3: No caso de Contribuinte Isento de Inscri��o (indIEDest=2), n�o informar a tag IE do destinat�rio.
   *
   * @return # e16a indIEDest Indicador da IE do Destinat�rio E E01 N 1-1 1<br>
   *         <li>1=Contribuinte ICMS (informar a IE do destinat�rio);
   *         <li>2=Contribuinte isento de Inscri��o no cadastro de Contribuintes
   *         <li>9=N�o Contribuinte, que pode ou n�o possuir Inscri��o Estadual no Cadastro de Contribuintes do ICMS
   */
  public String getIndIEDest() {
    return indIEDest;
  }

  /**
   * # e16a indIEDest Indicador da IE do Destinat�rio E E01 N 1-1 1<br>
   * <li>1=Contribuinte ICMS (informar a IE do destinat�rio);
   * <li>2=Contribuinte isento de Inscri��o no cadastro de Contribuintes
   * <li>9=N�o Contribuinte, que pode ou n�o possuir Inscri��o Estadual no Cadastro de Contribuintes do ICMS. <br>
   * Nota 1: No caso de NFC-e informar indIEDest=9 e n�o informar a tag IE do destinat�rio; <br>
   * Nota 2: No caso de opera��o com o Exterior informar indIEDest=9 e n�o informar a tag IE do destinat�rio; <br>
   * Nota 3: No caso de Contribuinte Isento de Inscri��o (indIEDest=2), n�o informar a tag IE do destinat�rio.
   *
   * @param indIEDest # e16a indIEDest Indicador da IE do Destinat�rio E E01 N 1-1 1<br>
   *          <li>1=Contribuinte ICMS (informar a IE do destinat�rio);
   *          <li>2=Contribuinte isento de Inscri��o no cadastro de Contribuintes
   *          <li>9=N�o Contribuinte, que pode ou n�o possuir Inscri��o Estadual no Cadastro de Contribuintes do ICMS
   */
  public void setIndIEDest(String indIEDest) {
    this.indIEDest = indIEDest;
  }

  /**
   * # e17 IE Inscri��o Estadual do Destinat�rio E E01 N 0-1 2 - 14<br>
   * Campo opcional. Informar somente os algarismos, sem os caracteres de formata��o (ponto, barra, h�fen, etc.).
   *
   * @return # e17 IE Inscri��o Estadual do Destinat�rio E E01 N 0-1 2 - 14<br>
   *         Campo opcional
   */
  public String getIe() {
    return ie;
  }

  /**
   * # e17 IE Inscri��o Estadual do Destinat�rio E E01 N 0-1 2 - 14<br>
   * Campo opcional. Informar somente os algarismos, sem os caracteres de formata��o (ponto, barra, h�fen, etc.).
   *
   * @param ie # e17 IE Inscri��o Estadual do Destinat�rio E E01 N 0-1 2 - 14<br>
   *          Campo opcional
   */
  public void setIe(String ie) {
    this.ie = ie;
  }

  /**
   * # e18 ISUF Inscri��o na SUFRAMA E E01 N 0-1 8 - 9<br>
   * Obrigat�rio, nas opera��es que se beneficiam de incentivos fiscais existentes nas �reas sob controle da SUFRAMA. A omiss�o desta informa��o impede o processamento da opera��o pelo Sistema de Mercadoria Nacional da SUFRAMA e a libera��o da Declara��o de Ingresso, prejudicando a comprova��o do ingresso / internamento da mercadoria nestas �reas. (v2.0).
   *
   * @return # e18 ISUF Inscri��o na SUFRAMA E E01 N 0-1 8 - 9<br>
   *         Obrigat�rio, nas opera��es que se beneficiam de incentivos fiscais existentes nas �reas sob controle da SUFRAMA
   */
  public String getIsuf() {
    return isuf;
  }

  /**
   * # e18 ISUF Inscri��o na SUFRAMA E E01 N 0-1 8 - 9<br>
   * Obrigat�rio, nas opera��es que se beneficiam de incentivos fiscais existentes nas �reas sob controle da SUFRAMA. A omiss�o desta informa��o impede o processamento da opera��o pelo Sistema de Mercadoria Nacional da SUFRAMA e a libera��o da Declara��o de Ingresso, prejudicando a comprova��o do ingresso / internamento da mercadoria nestas �reas. (v2.0).
   *
   * @param isuf # e18 ISUF Inscri��o na SUFRAMA E E01 N 0-1 8 - 9<br>
   *          Obrigat�rio, nas opera��es que se beneficiam de incentivos fiscais existentes nas �reas sob controle da SUFRAMA
   */
  public void setIsuf(String isuf) {
    this.isuf = isuf;
  }

  /**
   * # e18a IM Inscri��o Municipal do Tomador do Servi�o E E01 C 0-1 1 - 15<br>
   * Campo opcional, pode ser informado na NF-e conjugada, com itens de produtos sujeitos ao ICMS e itens de servi�os sujeitos ao ISSQN.
   *
   * @return # e18a IM Inscri��o Municipal do Tomador do Servi�o E E01 C 0-1 1 - 15<br>
   *         Campo opcional, pode ser informado na NF-e conjugada, com itens de produtos sujeitos ao ICMS e itens de servi�os sujeitos ao ISSQN
   */
  public String getIm() {
    return im;
  }

  /**
   * # e18a IM Inscri��o Municipal do Tomador do Servi�o E E01 C 0-1 1 - 15<br>
   * Campo opcional, pode ser informado na NF-e conjugada, com itens de produtos sujeitos ao ICMS e itens de servi�os sujeitos ao ISSQN.
   *
   * @param im # e18a IM Inscri��o Municipal do Tomador do Servi�o E E01 C 0-1 1 - 15<br>
   *          Campo opcional, pode ser informado na NF-e conjugada, com itens de produtos sujeitos ao ICMS e itens de servi�os sujeitos ao ISSQN
   */
  public void setIm(String im) {
    this.im = im;
  }

  /**
   * # e19 email email E E01 C 0-1 1 - 60<br>
   * Campo pode ser utilizado para informar o e-mail de recep��o da NF-e indicada pelo destinat�rio (v2.0).
   *
   * @return # e19 email email E E01 C 0-1 1 - 60<br>
   *         Campo pode ser utilizado para informar o e-mail de recep��o da NF-e indicada pelo destinat�rio (v2
   */
  public String getEmail() {
    return email;
  }

  /**
   * # e19 email email E E01 C 0-1 1 - 60<br>
   * Campo pode ser utilizado para informar o e-mail de recep��o da NF-e indicada pelo destinat�rio (v2.0).
   *
   * @param email # e19 email email E E01 C 0-1 1 - 60<br>
   *          Campo pode ser utilizado para informar o e-mail de recep��o da NF-e indicada pelo destinat�rio (v2
   */
  public void setEmail(String email) {
    this.email = email;
  }

}
