package br.eng.rodrigogml.rfw.sefaz.vo;

import java.io.Serializable;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCNPJField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCPFField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringEmailField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringIEField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.IndIEDestEnum;

/**
 * Grupo E - Identificação do Destinatário da NF-e (tag dest / E01). Grupo obrigatório para a NF-e (modelo 55).
 *
 * Observação: a obrigatoriedade dos campos segue o MOC, mas nas annotations o atributo {@code required} é sempre definido como false conforme solicitado.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_dest")
public class SEFAZDestVO extends RFWVO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * {@link SEFAZInfNFeVO}
   */
  @RFWMetaRelationshipField(caption = "InfNFe", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_infnfe")
  private SEFAZInfNFeVO infNFeVO = null;

  /**
   * {@link SEFAZEnderDestVO}
   */
  @RFWMetaRelationshipField(caption = "EnderDest", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_dest")
  private SEFAZEnderDestVO enderDestVO = null;

  /**
   * E02 - CNPJ do destinatário. Condicional ao CPF/idEstrangeiro: informar CNPJ ou CPF do destinatário, preenchendo os zeros não significativos. No caso de operação com o exterior, ou para comprador estrangeiro, informar a tag idEstrangeiro. Ocor.: 1-1 / Tam.: 14 / Tipo: N.
   */
  @RFWMetaStringCNPJField(caption = "CNPJ do destinatário", required = false, unique = false)
  private String cnpj;

  /**
   * E03 - CPF do destinatário. Condicional ao CNPJ/idEstrangeiro: informar CPF do destinatário quando não houver CNPJ, conforme regras da SEFAZ. Ocor.: 1-1 / Tam.: 11 / Tipo: N.
   */
  @RFWMetaStringCPFField(caption = "CPF do destinatário", required = false, unique = false)
  private String cpf;

  /**
   * E03a - idEstrangeiro. Identificação do destinatário no caso de comprador estrangeiro. Informar no caso de operação com o exterior ou para comprador estrangeiro. Informar número do passaporte ou outro documento legal (campo aceita valor nulo). Ocor.: 1-1 / Tam.: 0,5-20 / Tipo: C. Aceita algarismos, letras (maiúsculas e minúsculas) e caracteres: [: . + - / ( )].
   */
  @RFWMetaStringField(caption = "Identificação destinatário estrangeiro", required = false, unique = false, maxLength = 20, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String idEstrangeiro;

  /**
   * E04 - xNome. Razão Social ou nome do destinatário. Tag obrigatória para a NF-e (modelo 55) e opcional para a NFC-e. Ocor.: 0-1 / Tam.: 2-60 / Tipo: C.
   */
  @RFWMetaStringField(caption = "Nome/Razão Social do destinatário", required = false, unique = false, maxLength = 60, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xnome;

  /**
   * E16a - indIEDest. Indicador da IE do Destinatário. Valores: 1 = Contribuinte ICMS (informar a IE do destinatário); 2 = Contribuinte isento de Inscrição no cadastro de Contribuintes; 9 = Não Contribuinte, que pode ou não possuir IE. Notas: - NFC-e: indIEDest=9 e não informar IE; - Operação com exterior: indIEDest=9 e não informar IE; - Contribuinte isento (indIEDest=2): não informar IE. Ocor.:
   * 1-1 / Tam.: 1 / Tipo: N.
   */
  @RFWMetaEnumField(caption = "Indicador da IE do destinatário", required = false)
  private IndIEDestEnum indIEDest;

  /**
   * E17 - IE. Inscrição Estadual do destinatário. Campo opcional. Informar somente algarismos, sem caracteres de formatação. Ocor.: 0-1 / Tam.: 2-14 / Tipo: N.
   */
  @RFWMetaStringIEField(caption = "Inscrição Estadual do destinatário", required = false, unique = false)
  private String ie;

  /**
   * E18 - ISUF. Inscrição na SUFRAMA. Obrigatório nas operações com incentivos fiscais em áreas sob controle da SUFRAMA. Ocor.: 0-1 / Tam.: 8-9 / Tipo: N.
   */
  @RFWMetaStringField(caption = "Inscrição SUFRAMA", required = false, unique = false, maxLength = 9, minLength = 8, pattern = "^[0-9]{8,9}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String isuf;

  /**
   * E18a - IM. Inscrição Municipal do Tomador do Serviço. Campo opcional, pode ser informado em NF-e conjugada. Ocor.: 0-1 / Tam.: 1-15 / Tipo: C.
   */
  @RFWMetaStringField(caption = "Inscrição Municipal", required = false, unique = false, maxLength = 15, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String im;

  /**
   * E19 - email. E-mail de recepção da NF-e indicado pelo destinatário. Campo opcional. Ocor.: 0-1 / Tam.: 1-60 / Tipo: C.
   */
  @RFWMetaStringEmailField(caption = "E-mail do destinatário", required = false, maxLength = 60, unique = false, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL, useRFC822 = false)
  private String email;

  /**
   * # {@link SEFAZInfNFeVO}.
   *
   * @return the {@link SEFAZInfNFeVO}
   */
  public SEFAZInfNFeVO getInfNFeVO() {
    return infNFeVO;
  }

  /**
   * # {@link SEFAZInfNFeVO}.
   *
   * @param infNFeVO the new {@link SEFAZInfNFeVO}
   */
  public void setInfNFeVO(SEFAZInfNFeVO infNFeVO) {
    this.infNFeVO = infNFeVO;
  }

  /**
   * # e02 - CNPJ do destinatário. Condicional ao CPF/idEstrangeiro: informar CNPJ ou CPF do destinatário, preenchendo os zeros não significativos. No caso de operação com o exterior, ou para comprador estrangeiro, informar a tag idEstrangeiro. Ocor.: 1-1 / Tam.: 14 / Tipo: N.
   *
   * @return the e02 - CNPJ do destinatário
   */
  public String getCnpj() {
    return cnpj;
  }

  /**
   * # e02 - CNPJ do destinatário. Condicional ao CPF/idEstrangeiro: informar CNPJ ou CPF do destinatário, preenchendo os zeros não significativos. No caso de operação com o exterior, ou para comprador estrangeiro, informar a tag idEstrangeiro. Ocor.: 1-1 / Tam.: 14 / Tipo: N.
   *
   * @param cnpj the new e02 - CNPJ do destinatário
   */
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  /**
   * # e03 - CPF do destinatário. Condicional ao CNPJ/idEstrangeiro: informar CPF do destinatário quando não houver CNPJ, conforme regras da SEFAZ. Ocor.: 1-1 / Tam.: 11 / Tipo: N.
   *
   * @return the e03 - CPF do destinatário
   */
  public String getCpf() {
    return cpf;
  }

  /**
   * # e03 - CPF do destinatário. Condicional ao CNPJ/idEstrangeiro: informar CPF do destinatário quando não houver CNPJ, conforme regras da SEFAZ. Ocor.: 1-1 / Tam.: 11 / Tipo: N.
   *
   * @param cpf the new e03 - CPF do destinatário
   */
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  /**
   * # e03a - idEstrangeiro. Identificação do destinatário no caso de comprador estrangeiro. Informar no caso de operação com o exterior ou para comprador estrangeiro. Informar número do passaporte ou outro documento legal (campo aceita valor nulo). Ocor.: 1-1 / Tam.: 0,5-20 / Tipo: C. Aceita algarismos, letras (maiúsculas e minúsculas) e caracteres: [: . + - / ( )].
   *
   * @return the e03a - idEstrangeiro
   */
  public String getIdEstrangeiro() {
    return idEstrangeiro;
  }

  /**
   * # e03a - idEstrangeiro. Identificação do destinatário no caso de comprador estrangeiro. Informar no caso de operação com o exterior ou para comprador estrangeiro. Informar número do passaporte ou outro documento legal (campo aceita valor nulo). Ocor.: 1-1 / Tam.: 0,5-20 / Tipo: C. Aceita algarismos, letras (maiúsculas e minúsculas) e caracteres: [: . + - / ( )].
   *
   * @param idEstrangeiro the new e03a - idEstrangeiro
   */
  public void setIdEstrangeiro(String idEstrangeiro) {
    this.idEstrangeiro = idEstrangeiro;
  }

  /**
   * # e04 - xNome. Razão Social ou nome do destinatário. Tag obrigatória para a NF-e (modelo 55) e opcional para a NFC-e. Ocor.: 0-1 / Tam.: 2-60 / Tipo: C.
   *
   * @return the e04 - xNome
   */
  public String getXnome() {
    return xnome;
  }

  /**
   * # e04 - xNome. Razão Social ou nome do destinatário. Tag obrigatória para a NF-e (modelo 55) e opcional para a NFC-e. Ocor.: 0-1 / Tam.: 2-60 / Tipo: C.
   *
   * @param xnome the new e04 - xNome
   */
  public void setXnome(String xnome) {
    this.xnome = xnome;
  }

  /**
   * # e16a - indIEDest. Indicador da IE do Destinatário. Valores: 1 = Contribuinte ICMS (informar a IE do destinatário); 2 = Contribuinte isento de Inscrição no cadastro de Contribuintes; 9 = Não Contribuinte, que pode ou não possuir IE. Notas: - NFC-e: indIEDest=9 e não informar IE; - Operação com exterior: indIEDest=9 e não informar IE; - Contribuinte isento (indIEDest=2): não informar IE.
   * Ocor.: 1-1 / Tam.: 1 / Tipo: N.
   *
   * @return the e16a - indIEDest
   */
  public IndIEDestEnum getIndIEDest() {
    return indIEDest;
  }

  /**
   * # e16a - indIEDest. Indicador da IE do Destinatário. Valores: 1 = Contribuinte ICMS (informar a IE do destinatário); 2 = Contribuinte isento de Inscrição no cadastro de Contribuintes; 9 = Não Contribuinte, que pode ou não possuir IE. Notas: - NFC-e: indIEDest=9 e não informar IE; - Operação com exterior: indIEDest=9 e não informar IE; - Contribuinte isento (indIEDest=2): não informar IE.
   * Ocor.: 1-1 / Tam.: 1 / Tipo: N.
   *
   * @param indIEDest the new e16a - indIEDest
   */
  public void setIndIEDest(IndIEDestEnum indIEDest) {
    this.indIEDest = indIEDest;
  }

  /**
   * # e17 - IE. Inscrição Estadual do destinatário. Campo opcional. Informar somente algarismos, sem caracteres de formatação. Ocor.: 0-1 / Tam.: 2-14 / Tipo: N.
   *
   * @return the e17 - IE
   */
  public String getIe() {
    return ie;
  }

  /**
   * # e17 - IE. Inscrição Estadual do destinatário. Campo opcional. Informar somente algarismos, sem caracteres de formatação. Ocor.: 0-1 / Tam.: 2-14 / Tipo: N.
   *
   * @param ie the new e17 - IE
   */
  public void setIe(String ie) {
    this.ie = ie;
  }

  /**
   * # e18 - ISUF. Inscrição na SUFRAMA. Obrigatório nas operações com incentivos fiscais em áreas sob controle da SUFRAMA. Ocor.: 0-1 / Tam.: 8-9 / Tipo: N.
   *
   * @return the e18 - ISUF
   */
  public String getIsuf() {
    return isuf;
  }

  /**
   * # e18 - ISUF. Inscrição na SUFRAMA. Obrigatório nas operações com incentivos fiscais em áreas sob controle da SUFRAMA. Ocor.: 0-1 / Tam.: 8-9 / Tipo: N.
   *
   * @param isuf the new e18 - ISUF
   */
  public void setIsuf(String isuf) {
    this.isuf = isuf;
  }

  /**
   * # e18a - IM. Inscrição Municipal do Tomador do Serviço. Campo opcional, pode ser informado em NF-e conjugada. Ocor.: 0-1 / Tam.: 1-15 / Tipo: C.
   *
   * @return the e18a - IM
   */
  public String getIm() {
    return im;
  }

  /**
   * # e18a - IM. Inscrição Municipal do Tomador do Serviço. Campo opcional, pode ser informado em NF-e conjugada. Ocor.: 0-1 / Tam.: 1-15 / Tipo: C.
   *
   * @param im the new e18a - IM
   */
  public void setIm(String im) {
    this.im = im;
  }

  /**
   * # e19 - email. E-mail de recepção da NF-e indicado pelo destinatário. Campo opcional. Ocor.: 0-1 / Tam.: 1-60 / Tipo: C.
   *
   * @return the e19 - email
   */
  public String getEmail() {
    return email;
  }

  /**
   * # e19 - email. E-mail de recepção da NF-e indicado pelo destinatário. Campo opcional. Ocor.: 0-1 / Tam.: 1-60 / Tipo: C.
   *
   * @param email the new e19 - email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * # {@link SEFAZEnderDestVO}.
   *
   * @return the {@link SEFAZEnderDestVO}
   */
  public SEFAZEnderDestVO getEnderDestVO() {
    return enderDestVO;
  }

  /**
   * # {@link SEFAZEnderDestVO}.
   *
   * @param enderDestVO the new {@link SEFAZEnderDestVO}
   */
  public void setEnderDestVO(SEFAZEnderDestVO enderDestVO) {
    this.enderDestVO = enderDestVO;
  }
}
