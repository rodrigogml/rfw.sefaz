package br.eng.rodrigogml.rfw.sefaz.vo;

import java.io.Serializable;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCNPJField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_mod;

/**
 * VO para o grupo BA03 (refNF) – Informação da NF modelo 1/1A ou NF modelo 2 referenciada. Utilizado para detalhar documentos fiscais em papel (modelos 01 e 02) vinculados à NF-e.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_refnf")
public class SEFAZRefNFVO extends RFWVO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * {@link SEFAZNFRefVO}
   */
  @RFWMetaRelationshipField(caption = "NFRef", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_nfref")
  private SEFAZNFRefVO nfRefVO = null;

  /**
   * BA04 - Código da UF do emitente. Utilizar a tabela de UF do IBGE. Ocorrência: 1-1.
   */
  @RFWMetaStringField(caption = "Código da UF do emitente", required = true, unique = false, maxLength = 2, minLength = 2, pattern = "", preProcess = { PreProcessOption.NONE })
  private String cuf;

  /**
   * BA05 - Ano e Mês de emissão da NF. Formato AAMM da emissão da NF referenciada. Ocorrência: 1-1.
   */
  @RFWMetaStringField(caption = "Ano e mês de emissão da NF (AAMM)", required = true, unique = false, maxLength = 4, minLength = 4, pattern = "", preProcess = { PreProcessOption.NONE })
  private String aamm;

  /**
   * BA06 - CNPJ do emitente da NF referenciada. Conteúdo numérico com 14 dígitos, sem máscara. Ocorrência: 1-1.
   */
  @RFWMetaStringCNPJField(caption = "CNPJ do emitente da NF referenciada", required = true, unique = false, preProcess = { PreProcessOption.NONE })
  private String cnpj;

  /**
   * BA07 - Modelo do Documento Fiscal. Valores possíveis: 01 = modelo 01 02 = modelo 02. Ocorrência: 1-1.
   */
  @RFWMetaEnumField(caption = "Modelo do Documento Fiscal (01 ou 02)", required = false)
  private SEFAZ_mod mod;

  /**
   * BA08 - Série do Documento Fiscal. Informar a série do documento fiscal; informar zero se não utilizada série. Ocorrência: 1-1.
   */
  @RFWMetaStringField(caption = "Série do Documento Fiscal", required = true, unique = false, maxLength = -1, minLength = -1, pattern = "", preProcess = { PreProcessOption.NONE })
  private String serie;

  /**
   * BA09 - Número do Documento Fiscal. Faixa: 1–999999999. Tamanho 1-9 caracteres. Ocorrência: 1-1.
   */
  @RFWMetaStringField(caption = "Número do Documento Fiscal", required = true, unique = false, maxLength = 9, minLength = 1, pattern = "", preProcess = { PreProcessOption.NONE })
  private String nnf;

  /**
   * # bA04 - Código da UF do emitente. Utilizar a tabela de UF do IBGE. Ocorrência: 1-1.
   *
   * @return the bA04 - Código da UF do emitente
   */
  public String getCuf() {
    return cuf;
  }

  /**
   * # bA04 - Código da UF do emitente. Utilizar a tabela de UF do IBGE. Ocorrência: 1-1.
   *
   * @param cuf the new bA04 - Código da UF do emitente
   */
  public void setCuf(String cuf) {
    this.cuf = cuf;
  }

  /**
   * # bA05 - Ano e Mês de emissão da NF. Formato AAMM da emissão da NF referenciada. Ocorrência: 1-1.
   *
   * @return the bA05 - Ano e Mês de emissão da NF
   */
  public String getAamm() {
    return aamm;
  }

  /**
   * # bA05 - Ano e Mês de emissão da NF. Formato AAMM da emissão da NF referenciada. Ocorrência: 1-1.
   *
   * @param aamm the new bA05 - Ano e Mês de emissão da NF
   */
  public void setAamm(String aamm) {
    this.aamm = aamm;
  }

  /**
   * # bA06 - CNPJ do emitente da NF referenciada. Conteúdo numérico com 14 dígitos, sem máscara. Ocorrência: 1-1.
   *
   * @return the bA06 - CNPJ do emitente da NF referenciada
   */
  public String getCnpj() {
    return cnpj;
  }

  /**
   * # bA06 - CNPJ do emitente da NF referenciada. Conteúdo numérico com 14 dígitos, sem máscara. Ocorrência: 1-1.
   *
   * @param cnpj the new bA06 - CNPJ do emitente da NF referenciada
   */
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  /**
   * # bA08 - Série do Documento Fiscal. Informar a série do documento fiscal; informar zero se não utilizada série. Ocorrência: 1-1.
   *
   * @return the bA08 - Série do Documento Fiscal
   */
  public String getSerie() {
    return serie;
  }

  /**
   * # bA08 - Série do Documento Fiscal. Informar a série do documento fiscal; informar zero se não utilizada série. Ocorrência: 1-1.
   *
   * @param serie the new bA08 - Série do Documento Fiscal
   */
  public void setSerie(String serie) {
    this.serie = serie;
  }

  /**
   * # bA09 - Número do Documento Fiscal. Faixa: 1–999999999. Tamanho 1-9 caracteres. Ocorrência: 1-1.
   *
   * @return the bA09 - Número do Documento Fiscal
   */
  public String getNnf() {
    return nnf;
  }

  /**
   * # bA09 - Número do Documento Fiscal. Faixa: 1–999999999. Tamanho 1-9 caracteres. Ocorrência: 1-1.
   *
   * @param nnf the new bA09 - Número do Documento Fiscal
   */
  public void setNnf(String nnf) {
    this.nnf = nnf;
  }

  /**
   * # {@link SEFAZNFRefVO}.
   *
   * @return the {@link SEFAZNFRefVO}
   */
  public SEFAZNFRefVO getNfRefVO() {
    return nfRefVO;
  }

  /**
   * # {@link SEFAZNFRefVO}.
   *
   * @param nfRefVO the new {@link SEFAZNFRefVO}
   */
  public void setNfRefVO(SEFAZNFRefVO nfRefVO) {
    this.nfRefVO = nfRefVO;
  }

  /**
   * # bA07 - Modelo do Documento Fiscal. Valores possíveis: 01 = modelo 01 02 = modelo 02. Ocorrência: 1-1.
   *
   * @return the bA07 - Modelo do Documento Fiscal
   */
  public SEFAZ_mod getMod() {
    return mod;
  }

  /**
   * # bA07 - Modelo do Documento Fiscal. Valores possíveis: 01 = modelo 01 02 = modelo 02. Ocorrência: 1-1.
   *
   * @param mod the new bA07 - Modelo do Documento Fiscal
   */
  public void setMod(SEFAZ_mod mod) {
    this.mod = mod;
  }

}
