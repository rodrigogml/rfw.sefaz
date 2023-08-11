package br.eng.rodrigogml.rfw.sefaz.vos;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaIntegerField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCNPJField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "refNF" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class RefNFVO extends RFWVO {

  private static final long serialVersionUID = 8495916098430332153L;

  /**
   * BA04 cUF Código da UF do emitente E BA03 N 1-1 2<BR>
   * Utilizar a Tabela do IBGE (Seção 8.1 do MOC Visão GeralTabela de UF, Município e País)
   */
  @RFWMetaIntegerField(caption = "Código da UF", minvalue = 0, maxvalue = 99, required = true)
  private Integer cuf = null;

  /**
   * BA05 AAMM Ano e Mês de emissão da NF-e E BA03 N 1-1 4<br>
   * AAMM da emissão da NF
   */
  @RFWMetaStringField(caption = "Ano e Mês de Emissão", minlength = 4, maxlength = 4, required = true, pattern = "\\d{4}")
  private String aamm = null;

  /**
   * BA06 CNPJ CNPJ do emitente E BA03 N 1-1 14<br>
   * Informar o CNPJ do emitente da NF
   */
  @RFWMetaStringCNPJField(caption = "CNPJ do Emitente", required = true)
  private String cnpj = null;

  /**
   * BA07 mod Modelo do Documento Fiscal E BA03 N 1-1 2
   * <li>01=modelo 01
   * <li>02=modelo 02 (incluído na NT2016.002)
   */
  @RFWMetaStringField(caption = "Modelo do Documento Fiscal", minlength = 2, maxlength = 2, required = true, pattern = "^(01|02)$")
  private String mod = null;

  /**
   * BA08 serie Série do Documento Fiscal E BA03 N 1-1 1 - 3<br>
   * Informar zero se não utilizada Série do documento fiscal.
   */
  @RFWMetaIntegerField(caption = "Serie", minvalue = 1, maxvalue = 999, required = true)
  private Integer serie = null;

  /**
   * BA09 nNF Número do Documento Fiscal E BA03 N 1-1 1 - 9<br>
   * Faixa: 1–999999999
   */
  @RFWMetaIntegerField(caption = "Número do Documento Fiscal", minvalue = 0, maxvalue = 999999999, required = true)
  private Integer nnf = null;

  /**
   * # bA04 cUF Código da UF do emitente E BA03 N 1-1 2<BR>
   * Utilizar a Tabela do IBGE (Seção 8.1 do MOC Visão GeralTabela de UF, Município e País).
   *
   * @return # bA04 cUF Código da UF do emitente E BA03 N 1-1 2<BR>
   *         Utilizar a Tabela do IBGE (Seção 8
   */
  public Integer getCuf() {
    return cuf;
  }

  /**
   * # bA04 cUF Código da UF do emitente E BA03 N 1-1 2<BR>
   * Utilizar a Tabela do IBGE (Seção 8.1 do MOC Visão GeralTabela de UF, Município e País).
   *
   * @param cuf # bA04 cUF Código da UF do emitente E BA03 N 1-1 2<BR>
   *          Utilizar a Tabela do IBGE (Seção 8
   */
  public void setCuf(Integer cuf) {
    this.cuf = cuf;
  }

  /**
   * # bA05 AAMM Ano e Mês de emissão da NF-e E BA03 N 1-1 4<br>
   * AAMM da emissão da NF.
   *
   * @return # bA05 AAMM Ano e Mês de emissão da NF-e E BA03 N 1-1 4<br>
   *         AAMM da emissão da NF
   */
  public String getAamm() {
    return aamm;
  }

  /**
   * # bA05 AAMM Ano e Mês de emissão da NF-e E BA03 N 1-1 4<br>
   * AAMM da emissão da NF.
   *
   * @param aamm # bA05 AAMM Ano e Mês de emissão da NF-e E BA03 N 1-1 4<br>
   *          AAMM da emissão da NF
   */
  public void setAamm(String aamm) {
    this.aamm = aamm;
  }

  /**
   * # bA06 CNPJ CNPJ do emitente E BA03 N 1-1 14<br>
   * Informar o CNPJ do emitente da NF.
   *
   * @return # bA06 CNPJ CNPJ do emitente E BA03 N 1-1 14<br>
   *         Informar o CNPJ do emitente da NF
   */
  public String getCnpj() {
    return cnpj;
  }

  /**
   * # bA06 CNPJ CNPJ do emitente E BA03 N 1-1 14<br>
   * Informar o CNPJ do emitente da NF.
   *
   * @param cnpj # bA06 CNPJ CNPJ do emitente E BA03 N 1-1 14<br>
   *          Informar o CNPJ do emitente da NF
   */
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  /**
   * # bA07 mod Modelo do Documento Fiscal E BA03 N 1-1 2
   * <li>01=modelo 01
   * <li>02=modelo 02 (incluído na NT2016.002).
   *
   * @return # bA07 mod Modelo do Documento Fiscal E BA03 N 1-1 2
   *         <li>01=modelo 01
   *         <li>02=modelo 02 (incluído na NT2016
   */
  public String getMod() {
    return mod;
  }

  /**
   * # bA07 mod Modelo do Documento Fiscal E BA03 N 1-1 2
   * <li>01=modelo 01
   * <li>02=modelo 02 (incluído na NT2016.002).
   *
   * @param mod # bA07 mod Modelo do Documento Fiscal E BA03 N 1-1 2
   *          <li>01=modelo 01
   *          <li>02=modelo 02 (incluído na NT2016
   */
  public void setMod(String mod) {
    this.mod = mod;
  }

  /**
   * # bA08 serie Série do Documento Fiscal E BA03 N 1-1 1 - 3<br>
   * Informar zero se não utilizada Série do documento fiscal.
   *
   * @return # bA08 serie Série do Documento Fiscal E BA03 N 1-1 1 - 3<br>
   *         Informar zero se não utilizada Série do documento fiscal
   */
  public Integer getSerie() {
    return serie;
  }

  /**
   * # bA08 serie Série do Documento Fiscal E BA03 N 1-1 1 - 3<br>
   * Informar zero se não utilizada Série do documento fiscal.
   *
   * @param serie # bA08 serie Série do Documento Fiscal E BA03 N 1-1 1 - 3<br>
   *          Informar zero se não utilizada Série do documento fiscal
   */
  public void setSerie(Integer serie) {
    this.serie = serie;
  }

  /**
   * # bA09 nNF Número do Documento Fiscal E BA03 N 1-1 1 - 9<br>
   * Faixa: 1–999999999.
   *
   * @return # bA09 nNF Número do Documento Fiscal E BA03 N 1-1 1 - 9<br>
   *         Faixa: 1–999999999
   */
  public Integer getNnf() {
    return nnf;
  }

  /**
   * # bA09 nNF Número do Documento Fiscal E BA03 N 1-1 1 - 9<br>
   * Faixa: 1–999999999.
   *
   * @param nnf # bA09 nNF Número do Documento Fiscal E BA03 N 1-1 1 - 9<br>
   *          Faixa: 1–999999999
   */
  public void setNnf(Integer nnf) {
    this.nnf = nnf;
  }

}
