package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCNPJField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCPFField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringIEField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_mod;

/**
 * VO para o grupo BA10 (refNFP) – Informações da NF de produtor rural referenciada. Utilizado para referenciar documento fiscal de produtor rural vinculado à NF-e.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_refnfp")
public class RefNFPVO extends RFWVO {

  private static final long serialVersionUID = 1L;

  /**
   * {@link NFRefVO}
   */
  @RFWMetaRelationshipField(caption = "NFRef", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_nfref")
  private NFRefVO nfRefVO = null;

  /**
   * BA11 - Código da UF do emitente. Utilizar a tabela de UF do IBGE. Ocorrência: 1-1.
   */
  @RFWMetaStringField(caption = "Código da UF do emitente da NF de produtor", required = true, unique = false, maxLength = 2, minLength = 2, pattern = "", preProcess = { PreProcessOption.NONE })
  private String cuf;

  /**
   * BA12 - Ano e Mês de emissão da NF de produtor. Formato AAMM da emissão da NF de produtor. Ocorrência: 1-1.
   */
  @RFWMetaStringField(caption = "Ano e mês da emissão da NF de produtor (AAMM)", required = true, unique = false, maxLength = 4, minLength = 4, pattern = "", preProcess = { PreProcessOption.NONE })
  private String aamm;

  /**
   * BA13 - CNPJ do emitente da NF de produtor. Conteúdo numérico com 14 dígitos, sem máscara. Ocorrência: 0-1 (condicional).
   */
  @RFWMetaStringCNPJField(caption = "CNPJ do emitente da NF de produtor", required = false, unique = false, preProcess = { PreProcessOption.NONE })
  private String cnpj;

  /**
   * BA14 - CPF do emitente da NF de produtor. Conteúdo numérico com 11 dígitos, sem máscara. Ocorrência: 1-1 (quando pessoa física).
   */
  @RFWMetaStringCPFField(caption = "CPF do emitente da NF de produtor", required = true, unique = false, preProcess = { PreProcessOption.NONE })
  private String cpf;

  /**
   * BA15 - Inscrição Estadual (IE) do emitente da NF de produtor. Informar a IE do emitente da NF de Produtor ou literal “ISENTO”. Tamanho 2-14 caracteres. Ocorrência: 1-1.
   */
  @RFWMetaStringIEField(caption = "IE do emitente da NF de produtor", required = true, unique = false, uf = "", uffield = "", preProcess = { PreProcessOption.NONE })
  private String ie;

  /**
   * BA16 - Modelo do Documento Fiscal. Valores possíveis: 04 = NF de Produtor 01 = NF. Ocorrência: 1-1.
   */
  @RFWMetaEnumField(caption = "Modelo do Documento Fiscal (01 ou 02)", required = false)
  private SEFAZ_mod mod;

  /**
   * BA17 - Série do Documento Fiscal. Informar a série do documento fiscal; informar zero se inexistente. Ocorrência: 1-1.
   */
  @RFWMetaStringField(caption = "Série do Documento Fiscal da NF de produtor", required = true, unique = false, maxLength = -1, minLength = -1, pattern = "", preProcess = { PreProcessOption.NONE })
  private String serie;

  /**
   * BA18 - Número do Documento Fiscal. Faixa: 1–999999999. Tamanho 1-9 caracteres. Ocorrência: 1-1.
   */
  @RFWMetaStringField(caption = "Número do Documento Fiscal da NF de produtor", required = true, unique = false, maxLength = 9, minLength = 1, pattern = "", preProcess = { PreProcessOption.NONE })
  private String nnf;

  /**
   * # {@link NFRefVO}.
   *
   * @return the {@link NFRefVO}
   */
  public NFRefVO getNfRefVO() {
    return nfRefVO;
  }

  /**
   * # {@link NFRefVO}.
   *
   * @param nfRefVO the new {@link NFRefVO}
   */
  public void setNfRefVO(NFRefVO nfRefVO) {
    this.nfRefVO = nfRefVO;
  }

  /**
   * # bA11 - Código da UF do emitente. Utilizar a tabela de UF do IBGE. Ocorrência: 1-1.
   *
   * @return the bA11 - Código da UF do emitente
   */
  public String getCuf() {
    return cuf;
  }

  /**
   * # bA11 - Código da UF do emitente. Utilizar a tabela de UF do IBGE. Ocorrência: 1-1.
   *
   * @param cuf the new bA11 - Código da UF do emitente
   */
  public void setCuf(String cuf) {
    this.cuf = cuf;
  }

  /**
   * # bA12 - Ano e Mês de emissão da NF de produtor. Formato AAMM da emissão da NF de produtor. Ocorrência: 1-1.
   *
   * @return the bA12 - Ano e Mês de emissão da NF de produtor
   */
  public String getAamm() {
    return aamm;
  }

  /**
   * # bA12 - Ano e Mês de emissão da NF de produtor. Formato AAMM da emissão da NF de produtor. Ocorrência: 1-1.
   *
   * @param aamm the new bA12 - Ano e Mês de emissão da NF de produtor
   */
  public void setAamm(String aamm) {
    this.aamm = aamm;
  }

  /**
   * # bA13 - CNPJ do emitente da NF de produtor. Conteúdo numérico com 14 dígitos, sem máscara. Ocorrência: 0-1 (condicional).
   *
   * @return the bA13 - CNPJ do emitente da NF de produtor
   */
  public String getCnpj() {
    return cnpj;
  }

  /**
   * # bA13 - CNPJ do emitente da NF de produtor. Conteúdo numérico com 14 dígitos, sem máscara. Ocorrência: 0-1 (condicional).
   *
   * @param cnpj the new bA13 - CNPJ do emitente da NF de produtor
   */
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  /**
   * # bA14 - CPF do emitente da NF de produtor. Conteúdo numérico com 11 dígitos, sem máscara. Ocorrência: 1-1 (quando pessoa física).
   *
   * @return the bA14 - CPF do emitente da NF de produtor
   */
  public String getCpf() {
    return cpf;
  }

  /**
   * # bA14 - CPF do emitente da NF de produtor. Conteúdo numérico com 11 dígitos, sem máscara. Ocorrência: 1-1 (quando pessoa física).
   *
   * @param cpf the new bA14 - CPF do emitente da NF de produtor
   */
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  /**
   * # bA15 - Inscrição Estadual (IE) do emitente da NF de produtor. Informar a IE do emitente da NF de Produtor ou literal “ISENTO”. Tamanho 2-14 caracteres. Ocorrência: 1-1.
   *
   * @return the bA15 - Inscrição Estadual (IE) do emitente da NF de produtor
   */
  public String getIe() {
    return ie;
  }

  /**
   * # bA15 - Inscrição Estadual (IE) do emitente da NF de produtor. Informar a IE do emitente da NF de Produtor ou literal “ISENTO”. Tamanho 2-14 caracteres. Ocorrência: 1-1.
   *
   * @param ie the new bA15 - Inscrição Estadual (IE) do emitente da NF de produtor
   */
  public void setIe(String ie) {
    this.ie = ie;
  }

  /**
   * # bA17 - Série do Documento Fiscal. Informar a série do documento fiscal; informar zero se inexistente. Ocorrência: 1-1.
   *
   * @return the bA17 - Série do Documento Fiscal
   */
  public String getSerie() {
    return serie;
  }

  /**
   * # bA17 - Série do Documento Fiscal. Informar a série do documento fiscal; informar zero se inexistente. Ocorrência: 1-1.
   *
   * @param serie the new bA17 - Série do Documento Fiscal
   */
  public void setSerie(String serie) {
    this.serie = serie;
  }

  /**
   * # bA18 - Número do Documento Fiscal. Faixa: 1–999999999. Tamanho 1-9 caracteres. Ocorrência: 1-1.
   *
   * @return the bA18 - Número do Documento Fiscal
   */
  public String getNnf() {
    return nnf;
  }

  /**
   * # bA18 - Número do Documento Fiscal. Faixa: 1–999999999. Tamanho 1-9 caracteres. Ocorrência: 1-1.
   *
   * @param nnf the new bA18 - Número do Documento Fiscal
   */
  public void setNnf(String nnf) {
    this.nnf = nnf;
  }
}
