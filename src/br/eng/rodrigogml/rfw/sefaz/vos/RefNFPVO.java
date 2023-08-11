package br.eng.rodrigogml.rfw.sefaz.vos;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaIntegerField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCNPJField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCPFField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "refNFP" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class RefNFPVO extends RFWVO {

  private static final long serialVersionUID = 6977488896553126607L;

  /**
   * BA11 cUF Código da UF do emitente E BA10 N 1-1 2<br>
   * Utilizar a Tabela do IBGE (Seção 8.1 do MOC – Visão Geral, Tabela de UF, Município e País) (v2.0)
   */
  @RFWMetaIntegerField(caption = "Código da UF", minvalue = 0, maxvalue = 99, required = true)
  private Integer cuf = null;

  /**
   * BA12 AAMM Ano e Mês de emissão da NF-e E BA10 N 1-1 4<br>
   * AAMM da emissão da NF de produtor (v2.0)
   */
  @RFWMetaStringField(caption = "Ano e Mês de Emissão", minlength = 4, maxlength = 4, required = true, pattern = "\\d{4}")
  private String aamm = null;

  /**
   * BA13 CNPJ CNPJ do emitente CE BA10 N 1-1 14<BR>
   * Informar o CNPJ do emitente da NF de produtor (v2.0)
   */
  @RFWMetaStringCNPJField(caption = "CNPJ do Emitente", required = false)
  private String cnpj = null;

  /**
   * BA14 CPF CPF do emitente CE BA10 N 1-1 11<br>
   * Informar o CPF do emitente da NF de produtor (v2.0)
   */
  @RFWMetaStringCPFField(caption = "CPF do Emitente", required = false)
  private String cpf = null;

  /**
   * BA15 IE IE do emitente E BA10 N 1-1 2 - 14<br>
   * Informar a IE do emitente da NF de Produtor ou o literal “ISENTO” (v2.0)
   */
  @RFWMetaStringField(caption = "IE do Emitente", minlength = 2, maxlength = 14, required = true, pattern = "^(ISENTO|[0-9]+)$")
  private String ie = null;

  /**
   * BA16 mod Modelo do Documento Fiscal E BA10 N 1-1 2
   * <li>04=NF de Produtor
   * <li>01=NF (v2.0)
   */
  @RFWMetaStringField(caption = "Modelo do Documento Fiscal", minlength = 2, maxlength = 2, required = true, pattern = "^(01|02)$")
  private String mod = null;

  /**
   * BA17 serie Série do Documento Fiscal E BA10 N 1-1 1 - 3<br>
   * Informar a série do documento fiscal (informar zero se inexistente) (v2.0).
   */
  @RFWMetaIntegerField(caption = "Serie", minvalue = 1, maxvalue = 999, required = true)
  private Integer serie = null;

  /**
   * BA18 nNF Número do Documento Fiscal E BA10 N 1-1 1 - 9<br>
   * Faixa: 1–999999999
   */
  @RFWMetaIntegerField(caption = "Número do Documento Fiscal", minvalue = 0, maxvalue = 999999999, required = true)
  private Integer nnf = null;

  /**
   * BA19 refCTe Chave de acesso do CT-e referenciada CE BA01 N 1-1 44<br>
   * Utilizar esta TAG para referenciar um CT-e emitido anteriormente, vinculada a NF-e atual - (v2.0).
   */
  @RFWMetaStringField(caption = "Chave da CT-e", minlength = 44, maxlength = 44, required = true, pattern = "\\d{44}")
  private String refCTe = null;

  /**
   * # bA11 cUF Código da UF do emitente E BA10 N 1-1 2<br>
   * Utilizar a Tabela do IBGE (Seção 8.1 do MOC – Visão Geral, Tabela de UF, Município e País) (v2.0).
   *
   * @return # bA11 cUF Código da UF do emitente E BA10 N 1-1 2<br>
   *         Utilizar a Tabela do IBGE (Seção 8
   */
  public Integer getCuf() {
    return cuf;
  }

  /**
   * # bA11 cUF Código da UF do emitente E BA10 N 1-1 2<br>
   * Utilizar a Tabela do IBGE (Seção 8.1 do MOC – Visão Geral, Tabela de UF, Município e País) (v2.0).
   *
   * @param cuf # bA11 cUF Código da UF do emitente E BA10 N 1-1 2<br>
   *          Utilizar a Tabela do IBGE (Seção 8
   */
  public void setCuf(Integer cuf) {
    this.cuf = cuf;
  }

  /**
   * # bA12 AAMM Ano e Mês de emissão da NF-e E BA10 N 1-1 4<br>
   * AAMM da emissão da NF de produtor (v2.0).
   *
   * @return # bA12 AAMM Ano e Mês de emissão da NF-e E BA10 N 1-1 4<br>
   *         AAMM da emissão da NF de produtor (v2
   */
  public String getAamm() {
    return aamm;
  }

  /**
   * # bA12 AAMM Ano e Mês de emissão da NF-e E BA10 N 1-1 4<br>
   * AAMM da emissão da NF de produtor (v2.0).
   *
   * @param aamm # bA12 AAMM Ano e Mês de emissão da NF-e E BA10 N 1-1 4<br>
   *          AAMM da emissão da NF de produtor (v2
   */
  public void setAamm(String aamm) {
    this.aamm = aamm;
  }

  /**
   * # bA13 CNPJ CNPJ do emitente CE BA10 N 1-1 14<BR>
   * Informar o CNPJ do emitente da NF de produtor (v2.0).
   *
   * @return # bA13 CNPJ CNPJ do emitente CE BA10 N 1-1 14<BR>
   *         Informar o CNPJ do emitente da NF de produtor (v2
   */
  public String getCnpj() {
    return cnpj;
  }

  /**
   * # bA13 CNPJ CNPJ do emitente CE BA10 N 1-1 14<BR>
   * Informar o CNPJ do emitente da NF de produtor (v2.0).
   *
   * @param cnpj # bA13 CNPJ CNPJ do emitente CE BA10 N 1-1 14<BR>
   *          Informar o CNPJ do emitente da NF de produtor (v2
   */
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  /**
   * # bA14 CPF CPF do emitente CE BA10 N 1-1 11<br>
   * Informar o CPF do emitente da NF de produtor (v2.0).
   *
   * @return # bA14 CPF CPF do emitente CE BA10 N 1-1 11<br>
   *         Informar o CPF do emitente da NF de produtor (v2
   */
  public String getCpf() {
    return cpf;
  }

  /**
   * # bA14 CPF CPF do emitente CE BA10 N 1-1 11<br>
   * Informar o CPF do emitente da NF de produtor (v2.0).
   *
   * @param cpf # bA14 CPF CPF do emitente CE BA10 N 1-1 11<br>
   *          Informar o CPF do emitente da NF de produtor (v2
   */
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  /**
   * # bA15 IE IE do emitente E BA10 N 1-1 2 - 14<br>
   * Informar a IE do emitente da NF de Produtor ou o literal “ISENTO” (v2.0).
   *
   * @return # bA15 IE IE do emitente E BA10 N 1-1 2 - 14<br>
   *         Informar a IE do emitente da NF de Produtor ou o literal “ISENTO” (v2
   */
  public String getIe() {
    return ie;
  }

  /**
   * # bA15 IE IE do emitente E BA10 N 1-1 2 - 14<br>
   * Informar a IE do emitente da NF de Produtor ou o literal “ISENTO” (v2.0).
   *
   * @param ie # bA15 IE IE do emitente E BA10 N 1-1 2 - 14<br>
   *          Informar a IE do emitente da NF de Produtor ou o literal “ISENTO” (v2
   */
  public void setIe(String ie) {
    this.ie = ie;
  }

  /**
   * # bA16 mod Modelo do Documento Fiscal E BA10 N 1-1 2
   * <li>04=NF de Produtor
   * <li>01=NF (v2.0).
   *
   * @return # bA16 mod Modelo do Documento Fiscal E BA10 N 1-1 2
   *         <li>04=NF de Produtor
   *         <li>01=NF (v2
   */
  public String getMod() {
    return mod;
  }

  /**
   * # bA16 mod Modelo do Documento Fiscal E BA10 N 1-1 2
   * <li>04=NF de Produtor
   * <li>01=NF (v2.0).
   *
   * @param mod # bA16 mod Modelo do Documento Fiscal E BA10 N 1-1 2
   *          <li>04=NF de Produtor
   *          <li>01=NF (v2
   */
  public void setMod(String mod) {
    this.mod = mod;
  }

  /**
   * # bA17 serie Série do Documento Fiscal E BA10 N 1-1 1 - 3<br>
   * Informar a série do documento fiscal (informar zero se inexistente) (v2.0).
   *
   * @return # bA17 serie Série do Documento Fiscal E BA10 N 1-1 1 - 3<br>
   *         Informar a série do documento fiscal (informar zero se inexistente) (v2
   */
  public Integer getSerie() {
    return serie;
  }

  /**
   * # bA17 serie Série do Documento Fiscal E BA10 N 1-1 1 - 3<br>
   * Informar a série do documento fiscal (informar zero se inexistente) (v2.0).
   *
   * @param serie # bA17 serie Série do Documento Fiscal E BA10 N 1-1 1 - 3<br>
   *          Informar a série do documento fiscal (informar zero se inexistente) (v2
   */
  public void setSerie(Integer serie) {
    this.serie = serie;
  }

  /**
   * # bA18 nNF Número do Documento Fiscal E BA10 N 1-1 1 - 9<br>
   * Faixa: 1–999999999.
   *
   * @return # bA18 nNF Número do Documento Fiscal E BA10 N 1-1 1 - 9<br>
   *         Faixa: 1–999999999
   */
  public Integer getNnf() {
    return nnf;
  }

  /**
   * # bA18 nNF Número do Documento Fiscal E BA10 N 1-1 1 - 9<br>
   * Faixa: 1–999999999.
   *
   * @param nnf # bA18 nNF Número do Documento Fiscal E BA10 N 1-1 1 - 9<br>
   *          Faixa: 1–999999999
   */
  public void setNnf(Integer nnf) {
    this.nnf = nnf;
  }

  /**
   * # bA19 refCTe Chave de acesso do CT-e referenciada CE BA01 N 1-1 44<br>
   * Utilizar esta TAG para referenciar um CT-e emitido anteriormente, vinculada a NF-e atual - (v2.0).
   *
   * @return # bA19 refCTe Chave de acesso do CT-e referenciada CE BA01 N 1-1 44<br>
   *         Utilizar esta TAG para referenciar um CT-e emitido anteriormente, vinculada a NF-e atual - (v2
   */
  public String getRefCTe() {
    return refCTe;
  }

  /**
   * # bA19 refCTe Chave de acesso do CT-e referenciada CE BA01 N 1-1 44<br>
   * Utilizar esta TAG para referenciar um CT-e emitido anteriormente, vinculada a NF-e atual - (v2.0).
   *
   * @param refCTe # bA19 refCTe Chave de acesso do CT-e referenciada CE BA01 N 1-1 44<br>
   *          Utilizar esta TAG para referenciar um CT-e emitido anteriormente, vinculada a NF-e atual - (v2
   */
  public void setRefCTe(String refCTe) {
    this.refCTe = refCTe;
  }

}
