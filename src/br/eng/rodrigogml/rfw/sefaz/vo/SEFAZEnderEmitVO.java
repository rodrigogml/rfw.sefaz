package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * VO da tag {@code <enderEmit>} (Grupo C - Endereço do Emitente da NF-e).
 * <p>
 * Representa o endereço completo do emitente, incluindo logradouro, número, complemento, bairro, município, UF, CEP, país e telefone.
 * <p>
 * Observação sobre obrigatoriedade: embora a documentação da NF-e indique a obrigatoriedade de vários campos (através das colunas "Ele" e "Ocor."), neste VO todos os atributos estão marcados com {@code required = false} nas anotações de metadados, por solicitação explícita.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_enderemit")
public class SEFAZEnderEmitVO extends RFWVO {

  private static final long serialVersionUID = -1937552470508130304L;

  /**
   * {@link SEFAZEmitVO}
   */
  @RFWMetaRelationshipField(caption = "Emit", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_emitvo")
  private SEFAZEmitVO emitVO = null;

  /**
   * Logradouro (id: C06).
   * <p>
   * Tipo: C, tamanho: 2-60, ocorrência: 1-1, Ele: E (obrigatório).
   */
  @RFWMetaStringField(caption = "Logradouro do emitente", required = false, maxLength = 60, minLength = 2, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xlgr;

  /**
   * Número (id: C07).
   * <p>
   * Tipo: C, tamanho: 1-60, ocorrência: 1-1, Ele: E (obrigatório).
   */
  @RFWMetaStringField(caption = "Número do endereço do emitente", required = false, maxLength = 60, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String nro;

  /**
   * Complemento (id: C08).
   * <p>
   * Tipo: C, tamanho: 1-60, ocorrência: 0-1, Ele: E (opcional).
   */
  @RFWMetaStringField(caption = "Complemento do endereço do emitente", required = false, maxLength = 60, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xcpl;

  /**
   * Bairro (id: C09).
   * <p>
   * Tipo: C, tamanho: 2-60, ocorrência: 1-1, Ele: E (obrigatório).
   */
  @RFWMetaStringField(caption = "Bairro do emitente", required = false, maxLength = 60, minLength = 2, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xbairro;

  /**
   * Nome do município (id: C11).
   * <p>
   * Tipo: C, tamanho: 2-60, ocorrência: 1-1, Ele: E (obrigatório).
   */
  @RFWMetaStringField(caption = "Nome do município", required = false, maxLength = 60, minLength = 2, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xmun;

  /**
   * Sigla da UF (id: C12).
   * <p>
   * Tipo: C, tamanho: 2, ocorrência: 1-1, Ele: E (obrigatório).
   */
  @RFWMetaStringField(caption = "UF do emitente", required = false, maxLength = 2, minLength = 2, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String uf;

  /**
   * Código do município (id: C10). Agora representado como String com validação de dígitos.
   */
  @RFWMetaStringField(caption = "Código do município (IBGE)", required = false, maxLength = 7, pattern = "^[0-9]{7}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cmun;

  /**
   * CEP do emitente (id: C13). Agora representado como String com validação numérica.
   */
  @RFWMetaStringField(caption = "CEP do emitente", required = false, maxLength = 8, pattern = "^[0-9]{8}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cep;

  /**
   * Código do país (id: C14). Agora representado como String com validação numérica.
   */
  @RFWMetaStringField(caption = "Código do país", required = false, maxLength = 4, pattern = "^[0-9]{1,4}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cpais;

  /**
   * Telefone do emitente (id: C16). Agora representado como String com validação numérica.
   */
  @RFWMetaStringField(caption = "Telefone do emitente", required = false, maxLength = 14, pattern = "^[0-9]{6,14}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String fone;

  /**
   * Nome do país (id: C15).
   * <p>
   * Tipo: C, tamanho: 1-60, ocorrência: 0-1, Ele: E (opcional). Normalmente preenchido como "Brasil" ou "BRASIL".
   */
  @RFWMetaStringField(caption = "Nome do país", required = false, maxLength = 60, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xpais;

  /**
   * # logradouro (id: C06).
   * <p>
   * Tipo: C, tamanho: 2-60, ocorrência: 1-1, Ele: E (obrigatório).
   *
   * @return the logradouro (id: C06)
   */
  public String getXlgr() {
    return xlgr;
  }

  /**
   * # logradouro (id: C06).
   * <p>
   * Tipo: C, tamanho: 2-60, ocorrência: 1-1, Ele: E (obrigatório).
   *
   * @param xlgr the new logradouro (id: C06)
   */
  public void setXlgr(String xlgr) {
    this.xlgr = xlgr;
  }

  /**
   * # número (id: C07).
   * <p>
   * Tipo: C, tamanho: 1-60, ocorrência: 1-1, Ele: E (obrigatório).
   *
   * @return the número (id: C07)
   */
  public String getNro() {
    return nro;
  }

  /**
   * # número (id: C07).
   * <p>
   * Tipo: C, tamanho: 1-60, ocorrência: 1-1, Ele: E (obrigatório).
   *
   * @param nro the new número (id: C07)
   */
  public void setNro(String nro) {
    this.nro = nro;
  }

  /**
   * # complemento (id: C08).
   * <p>
   * Tipo: C, tamanho: 1-60, ocorrência: 0-1, Ele: E (opcional).
   *
   * @return the complemento (id: C08)
   */
  public String getXcpl() {
    return xcpl;
  }

  /**
   * # complemento (id: C08).
   * <p>
   * Tipo: C, tamanho: 1-60, ocorrência: 0-1, Ele: E (opcional).
   *
   * @param xcpl the new complemento (id: C08)
   */
  public void setXcpl(String xcpl) {
    this.xcpl = xcpl;
  }

  /**
   * # bairro (id: C09).
   * <p>
   * Tipo: C, tamanho: 2-60, ocorrência: 1-1, Ele: E (obrigatório).
   *
   * @return the bairro (id: C09)
   */
  public String getXbairro() {
    return xbairro;
  }

  /**
   * # bairro (id: C09).
   * <p>
   * Tipo: C, tamanho: 2-60, ocorrência: 1-1, Ele: E (obrigatório).
   *
   * @param xbairro the new bairro (id: C09)
   */
  public void setXbairro(String xbairro) {
    this.xbairro = xbairro;
  }

  /**
   * # nome do município (id: C11).
   * <p>
   * Tipo: C, tamanho: 2-60, ocorrência: 1-1, Ele: E (obrigatório).
   *
   * @return the nome do município (id: C11)
   */
  public String getXmun() {
    return xmun;
  }

  /**
   * # nome do município (id: C11).
   * <p>
   * Tipo: C, tamanho: 2-60, ocorrência: 1-1, Ele: E (obrigatório).
   *
   * @param xmun the new nome do município (id: C11)
   */
  public void setXmun(String xmun) {
    this.xmun = xmun;
  }

  /**
   * # sigla da UF (id: C12).
   * <p>
   * Tipo: C, tamanho: 2, ocorrência: 1-1, Ele: E (obrigatório).
   *
   * @return the sigla da UF (id: C12)
   */
  public String getUf() {
    return uf;
  }

  /**
   * # sigla da UF (id: C12).
   * <p>
   * Tipo: C, tamanho: 2, ocorrência: 1-1, Ele: E (obrigatório).
   *
   * @param uf the new sigla da UF (id: C12)
   */
  public void setUf(String uf) {
    this.uf = uf;
  }

  /**
   * # código do município (id: C10). Agora representado como String com validação de dígitos.
   *
   * @return the código do município (id: C10)
   */
  public String getCmun() {
    return cmun;
  }

  /**
   * # código do município (id: C10). Agora representado como String com validação de dígitos.
   *
   * @param cmun the new código do município (id: C10)
   */
  public void setCmun(String cmun) {
    this.cmun = cmun;
  }

  /**
   * # cEP do emitente (id: C13). Agora representado como String com validação numérica.
   *
   * @return the cEP do emitente (id: C13)
   */
  public String getCep() {
    return cep;
  }

  /**
   * # cEP do emitente (id: C13). Agora representado como String com validação numérica.
   *
   * @param cep the new cEP do emitente (id: C13)
   */
  public void setCep(String cep) {
    this.cep = cep;
  }

  /**
   * # código do país (id: C14). Agora representado como String com validação numérica.
   *
   * @return the código do país (id: C14)
   */
  public String getCpais() {
    return cpais;
  }

  /**
   * # código do país (id: C14). Agora representado como String com validação numérica.
   *
   * @param cpais the new código do país (id: C14)
   */
  public void setCpais(String cpais) {
    this.cpais = cpais;
  }

  /**
   * # telefone do emitente (id: C16). Agora representado como String com validação numérica.
   *
   * @return the telefone do emitente (id: C16)
   */
  public String getFone() {
    return fone;
  }

  /**
   * # telefone do emitente (id: C16). Agora representado como String com validação numérica.
   *
   * @param fone the new telefone do emitente (id: C16)
   */
  public void setFone(String fone) {
    this.fone = fone;
  }

  /**
   * # nome do país (id: C15).
   * <p>
   * Tipo: C, tamanho: 1-60, ocorrência: 0-1, Ele: E (opcional). Normalmente preenchido como "Brasil" ou "BRASIL".
   *
   * @return the nome do país (id: C15)
   */
  public String getXpais() {
    return xpais;
  }

  /**
   * # nome do país (id: C15).
   * <p>
   * Tipo: C, tamanho: 1-60, ocorrência: 0-1, Ele: E (opcional). Normalmente preenchido como "Brasil" ou "BRASIL".
   *
   * @param xpais the new nome do país (id: C15)
   */
  public void setXpais(String xpais) {
    this.xpais = xpais;
  }

  /**
   * # {@link SEFAZEmitVO}.
   *
   * @return the {@link SEFAZEmitVO}
   */
  public SEFAZEmitVO getEmitVO() {
    return emitVO;
  }

  /**
   * # {@link SEFAZEmitVO}.
   *
   * @param emitVO the new {@link SEFAZEmitVO}
   */
  public void setEmitVO(SEFAZEmitVO emitVO) {
    this.emitVO = emitVO;
  }

}
