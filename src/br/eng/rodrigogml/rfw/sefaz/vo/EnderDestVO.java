package br.eng.rodrigogml.rfw.sefaz.vo;

import java.io.Serializable;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Grupo E05 - enderDest. Endereço do Destinatário da NF-e. Grupo obrigatório para a NF-e (modelo 55).
 *
 * Observação: a obrigatoriedade dos campos segue o MOC, mas nas annotations o atributo {@code required} é sempre definido como false conforme solicitado.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_enderdest")
public class EnderDestVO extends RFWVO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * {@link DestVO}
   */
  @RFWMetaRelationshipField(caption = "Dest", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_dest")
  private DestVO destVO = null;

  /**
   * E06 - xLgr. Logradouro do endereço do destinatário. Ocor.: 1-1 / Tam.: 2-60 / Tipo: C.
   */
  @RFWMetaStringField(caption = "Logradouro", required = false, unique = false, maxLength = 60, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xlgr;

  /**
   * E07 - nro. Número do endereço. Ocor.: 1-1 / Tam.: 1-60 / Tipo: C.
   */
  @RFWMetaStringField(caption = "Número", required = false, unique = false, maxLength = 60, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String nro;

  /**
   * E08 - xCpl. Complemento do endereço. Ocor.: 0-1 / Tam.: 1-60 / Tipo: C.
   */
  @RFWMetaStringField(caption = "Complemento", required = false, unique = false, maxLength = 60, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xcpl;

  /**
   * E09 - xBairro. Bairro do endereço do destinatário. Ocor.: 1-1 / Tam.: 2-60 / Tipo: C.
   */
  @RFWMetaStringField(caption = "Bairro", required = false, unique = false, maxLength = 60, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xbairro;

  /**
   * E10 - cMun. Código do município do endereço do destinatário. Utilizar a Tabela do IBGE. Ocor.: 1-1 / Tam.: 7 / Tipo: N.
   */
  @RFWMetaStringField(caption = "Código do município (IBGE)", required = false, unique = false, maxLength = 7, pattern = "^[0-9]{7}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cmun;

  /**
   * E11 - xMun. Nome do município. Informar “EXTERIOR” para operações com o exterior. Ocor.: 1-1 / Tam.: 2-60 / Tipo: C.
   */
  @RFWMetaStringField(caption = "Nome do município", required = false, unique = false, maxLength = 60, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xmun;

  /**
   * E12 - UF. Sigla da UF. Informar “EX” para operações com o exterior. Ocor.: 1-1 / Tam.: 2 / Tipo: C.
   */
  @RFWMetaStringField(caption = "UF", required = false, unique = false, maxLength = 2, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String uf;

  /**
   * E13 - CEP. Código do CEP, com zeros não significativos. Ocor.: 0-1 / Tam.: 8 / Tipo: N.
   */
  @RFWMetaStringField(caption = "CEP", required = false, unique = false, maxLength = 8, pattern = "^[0-9]{8}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cep;

  /**
   * E14 - cPais. Código do País, conforme Tabela do BACEN. Ocor.: 0-1 / Tam.: 2-4 / Tipo: N.
   */
  @RFWMetaStringField(caption = "Código do país (BACEN)", required = false, unique = false, maxLength = 4, minLength = 2, pattern = "^[0-9]{2,4}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cpais;

  /**
   * E15 - xPais. Nome do País. Ocor.: 0-1 / Tam.: 2-60 / Tipo: C.
   */
  @RFWMetaStringField(caption = "Nome do país", required = false, unique = false, maxLength = 60, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xpais;

  /**
   * E16 - fone. Telefone do destinatário. Preencher com Código DDD + número ou, em operações com exterior, código do país + código da localidade + número do telefone. Ocor.: 0-1 / Tam.: 6-14 / Tipo: N.
   */
  @RFWMetaStringField(caption = "Telefone", required = false, unique = false, maxLength = 14, minLength = 6, pattern = "^[0-9]{6,14}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String fone;

  /**
   * # e06 - xLgr. Logradouro do endereço do destinatário. Ocor.: 1-1 / Tam.: 2-60 / Tipo: C.
   *
   * @return the e06 - xLgr
   */
  public String getXlgr() {
    return xlgr;
  }

  /**
   * # e06 - xLgr. Logradouro do endereço do destinatário. Ocor.: 1-1 / Tam.: 2-60 / Tipo: C.
   *
   * @param xlgr the new e06 - xLgr
   */
  public void setXlgr(String xlgr) {
    this.xlgr = xlgr;
  }

  /**
   * # e07 - nro. Número do endereço. Ocor.: 1-1 / Tam.: 1-60 / Tipo: C.
   *
   * @return the e07 - nro
   */
  public String getNro() {
    return nro;
  }

  /**
   * # e07 - nro. Número do endereço. Ocor.: 1-1 / Tam.: 1-60 / Tipo: C.
   *
   * @param nro the new e07 - nro
   */
  public void setNro(String nro) {
    this.nro = nro;
  }

  /**
   * # e08 - xCpl. Complemento do endereço. Ocor.: 0-1 / Tam.: 1-60 / Tipo: C.
   *
   * @return the e08 - xCpl
   */
  public String getXcpl() {
    return xcpl;
  }

  /**
   * # e08 - xCpl. Complemento do endereço. Ocor.: 0-1 / Tam.: 1-60 / Tipo: C.
   *
   * @param xcpl the new e08 - xCpl
   */
  public void setXcpl(String xcpl) {
    this.xcpl = xcpl;
  }

  /**
   * # e09 - xBairro. Bairro do endereço do destinatário. Ocor.: 1-1 / Tam.: 2-60 / Tipo: C.
   *
   * @return the e09 - xBairro
   */
  public String getXbairro() {
    return xbairro;
  }

  /**
   * # e09 - xBairro. Bairro do endereço do destinatário. Ocor.: 1-1 / Tam.: 2-60 / Tipo: C.
   *
   * @param xbairro the new e09 - xBairro
   */
  public void setXbairro(String xbairro) {
    this.xbairro = xbairro;
  }

  /**
   * # e10 - cMun. Código do município do endereço do destinatário. Utilizar a Tabela do IBGE. Ocor.: 1-1 / Tam.: 7 / Tipo: N.
   *
   * @return the e10 - cMun
   */
  public String getCmun() {
    return cmun;
  }

  /**
   * # e10 - cMun. Código do município do endereço do destinatário. Utilizar a Tabela do IBGE. Ocor.: 1-1 / Tam.: 7 / Tipo: N.
   *
   * @param cmun the new e10 - cMun
   */
  public void setCmun(String cmun) {
    this.cmun = cmun;
  }

  /**
   * # e11 - xMun. Nome do município. Informar “EXTERIOR” para operações com o exterior. Ocor.: 1-1 / Tam.: 2-60 / Tipo: C.
   *
   * @return the e11 - xMun
   */
  public String getXmun() {
    return xmun;
  }

  /**
   * # e11 - xMun. Nome do município. Informar “EXTERIOR” para operações com o exterior. Ocor.: 1-1 / Tam.: 2-60 / Tipo: C.
   *
   * @param xmun the new e11 - xMun
   */
  public void setXmun(String xmun) {
    this.xmun = xmun;
  }

  /**
   * # e12 - UF. Sigla da UF. Informar “EX” para operações com o exterior. Ocor.: 1-1 / Tam.: 2 / Tipo: C.
   *
   * @return the e12 - UF
   */
  public String getUf() {
    return uf;
  }

  /**
   * # e12 - UF. Sigla da UF. Informar “EX” para operações com o exterior. Ocor.: 1-1 / Tam.: 2 / Tipo: C.
   *
   * @param uf the new e12 - UF
   */
  public void setUf(String uf) {
    this.uf = uf;
  }

  /**
   * # e13 - CEP. Código do CEP, com zeros não significativos. Ocor.: 0-1 / Tam.: 8 / Tipo: N.
   *
   * @return the e13 - CEP
   */
  public String getCep() {
    return cep;
  }

  /**
   * # e13 - CEP. Código do CEP, com zeros não significativos. Ocor.: 0-1 / Tam.: 8 / Tipo: N.
   *
   * @param cep the new e13 - CEP
   */
  public void setCep(String cep) {
    this.cep = cep;
  }

  /**
   * # e14 - cPais. Código do País, conforme Tabela do BACEN. Ocor.: 0-1 / Tam.: 2-4 / Tipo: N.
   *
   * @return the e14 - cPais
   */
  public String getCpais() {
    return cpais;
  }

  /**
   * # e14 - cPais. Código do País, conforme Tabela do BACEN. Ocor.: 0-1 / Tam.: 2-4 / Tipo: N.
   *
   * @param cpais the new e14 - cPais
   */
  public void setCpais(String cpais) {
    this.cpais = cpais;
  }

  /**
   * # e15 - xPais. Nome do País. Ocor.: 0-1 / Tam.: 2-60 / Tipo: C.
   *
   * @return the e15 - xPais
   */
  public String getXpais() {
    return xpais;
  }

  /**
   * # e15 - xPais. Nome do País. Ocor.: 0-1 / Tam.: 2-60 / Tipo: C.
   *
   * @param xpais the new e15 - xPais
   */
  public void setXpais(String xpais) {
    this.xpais = xpais;
  }

  /**
   * # e16 - fone. Telefone do destinatário. Preencher com Código DDD + número ou, em operações com exterior, código do país + código da localidade + número do telefone. Ocor.: 0-1 / Tam.: 6-14 / Tipo: N.
   *
   * @return the e16 - fone
   */
  public String getFone() {
    return fone;
  }

  /**
   * # e16 - fone. Telefone do destinatário. Preencher com Código DDD + número ou, em operações com exterior, código do país + código da localidade + número do telefone. Ocor.: 0-1 / Tam.: 6-14 / Tipo: N.
   *
   * @param fone the new e16 - fone
   */
  public void setFone(String fone) {
    this.fone = fone;
  }

}
