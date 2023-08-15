package br.eng.rodrigogml.rfw.sefaz.vos;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "ICMS20" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class ICMS20VO extends RFWVO {

  private static final long serialVersionUID = 3497328689172678619L;

  /**
   * N11 orig Origem da mercadoria E N04 N 1-1 1
   * <li>0 - Nacional, exceto as indicadas nos códigos 3, 4, 5 e 8; 1 - Estrangeira - Importação direta, exceto a indicada no código 6;
   * <li>2 - Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7;
   * <li>3 - Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% e inferior ou igual a 70%;
   * <li>4 - Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam as legislações citadas nos Ajustes;
   * <li>5 - Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40%;
   * <li>6 - Estrangeira - Importação direta, sem similar nacional, constante em lista da CAMEX e gás natural;
   * <li>7 - Estrangeira - Adquirida no mercado interno, sem similar nacional, constante lista CAMEX e gás natural.
   * <li>8 - Nacional, mercadoria ou bem com Conteúdo de Importação superior a 70%;
   */
  @RFWMetaStringField(caption = "Origem da Mercadoria", minlength = 1, maxLength = 1, required = true, pattern = "^(0|2|3|4|5|6|7|8)$")
  private String orig = null;

  /**
   * N12 CST Tributação do ICMS = 20 E N04 N 1-1 2<br>
   * 20=Com redução de base de cálculo
   */
  @RFWMetaStringField(caption = "CST", minlength = 2, maxLength = 2, required = true, pattern = "20")
  private String cst = null;

  /**
   * N13 modBC Modalidade de determinação da BC do ICMS E N04 N 1-1 1
   * <li>0=Margem Valor Agregado (%);
   * <li>1=Pauta (Valor);
   * <li>2=Preço Tabelado Máx. (valor);
   * <li>3=Valor da operação.
   */
  @RFWMetaStringField(caption = "Modalidade de BC do ICMS", minlength = 1, maxLength = 1, required = true, pattern = "^(0|1|2|3)$")
  private String modBC = null;

  /**
   * N14 pRedBC Percentual da Redução de BC E N04 N 1-1 3v2-4
   */
  @RFWMetaBigDecimalField(caption = "Percentual Redução BC do ICMS ST", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = false)
  private BigDecimal predBCST = null;

  /**
   * N15 vBC Valor da BC do ICMS E N04 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor BC do ICMS", minValue = "0", maxValue = "9999999999999.99", required = true, scale = 2)
  private BigDecimal vbc = null;

  /**
   * N16 pICMS Alíquota do imposto E N04 N 1-1 3v2-4<br>
   * Alíquota do ICMS sem o FCP. Quando for o caso, informar a alíquota do FCP no campo pFCP
   */
  @RFWMetaBigDecimalField(caption = "Alíquota do ICMS", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = true)
  private BigDecimal picms = null;

  /**
   * N17 vICMS Valor do ICMS E N04 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = true)
  private BigDecimal vicms = null;

  /**
   * N17a vBCFCP Valor da Base de Cálculo do FCP E N17.1 N 1-1 13v2<br>
   * Informar o valor da Base de Cálculo do FCP
   */
  @RFWMetaBigDecimalField(caption = "Base Cálculo do FCP", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vbcFCP = null;

  /**
   * N17.b pFCP Percentual do Fundo de Combate à Pobreza (FCP) E N17.0 N 1-1 3v2-4<br>
   * Percentual relativo ao Fundo de Combate à Pobreza (FCP).
   */
  @RFWMetaBigDecimalField(caption = "Percentual FCP", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = false)
  private BigDecimal pfcp = null;

  /**
   * N17c vFCP Valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP) E N17.1 N 1-1 13v2<br>
   * Valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP).
   */
  @RFWMetaBigDecimalField(caption = "Base Cálculo do FCP", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vfcp = null;

  /**
   * N28a vICMSDeson Valor do ICMS desonerado E N27.1 N 1-1 13v2<br>
   * Informar apenas nos motivos de desoneração documentados abaixo.
   */
  @RFWMetaBigDecimalField(caption = "Base Cálculo do FCP", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vicmsDeson = null;

  /**
   * N28 motDesICMS Motivo da desoneração do ICMS E N27.1 N 1-1 2<br>
   * Campo será preenchido quando o campo anterior estiver preenchido. Informar o motivo da desoneração:
   * <li>3=Uso na agropecuária;
   * <li>9=Outros;
   * <li>12=Órgão de fomento e desenvolvimento agropecuário.
   */
  @RFWMetaStringField(caption = "Motivo da Desoneração do ICMS", minlength = 1, maxLength = 2, required = false, pattern = "^(0|3|9|12)$")
  private String motDesICMS = null;

  /**
   * # n11 orig Origem da mercadoria E N04 N 1-1 1
   * <li>0 - Nacional, exceto as indicadas nos códigos 3, 4, 5 e 8; 1 - Estrangeira - Importação direta, exceto a indicada no código 6;
   * <li>2 - Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7;
   * <li>3 - Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% e inferior ou igual a 70%;
   * <li>4 - Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam as legislações citadas nos Ajustes;
   * <li>5 - Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40%;
   * <li>6 - Estrangeira - Importação direta, sem similar nacional, constante em lista da CAMEX e gás natural;
   * <li>7 - Estrangeira - Adquirida no mercado interno, sem similar nacional, constante lista CAMEX e gás natural.
   * <li>8 - Nacional, mercadoria ou bem com Conteúdo de Importação superior a 70%;.
   *
   * @return # n11 orig Origem da mercadoria E N04 N 1-1 1
   *         <li>0 - Nacional, exceto as indicadas nos códigos 3, 4, 5 e 8; 1 - Estrangeira - Importação direta, exceto a indicada no código 6;
   *         <li>2 - Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7;
   *         <li>3 - Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% e inferior ou igual a 70%;
   *         <li>4 - Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam as legislações citadas nos Ajustes;
   *         <li>5 - Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40%;
   *         <li>6 - Estrangeira - Importação direta, sem similar nacional, constante em lista da CAMEX e gás natural;
   *         <li>7 - Estrangeira - Adquirida no mercado interno, sem similar nacional, constante lista CAMEX e gás natural
   */
  public String getOrig() {
    return orig;
  }

  /**
   * # n11 orig Origem da mercadoria E N04 N 1-1 1
   * <li>0 - Nacional, exceto as indicadas nos códigos 3, 4, 5 e 8; 1 - Estrangeira - Importação direta, exceto a indicada no código 6;
   * <li>2 - Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7;
   * <li>3 - Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% e inferior ou igual a 70%;
   * <li>4 - Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam as legislações citadas nos Ajustes;
   * <li>5 - Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40%;
   * <li>6 - Estrangeira - Importação direta, sem similar nacional, constante em lista da CAMEX e gás natural;
   * <li>7 - Estrangeira - Adquirida no mercado interno, sem similar nacional, constante lista CAMEX e gás natural.
   * <li>8 - Nacional, mercadoria ou bem com Conteúdo de Importação superior a 70%;.
   *
   * @param orig # n11 orig Origem da mercadoria E N04 N 1-1 1
   *          <li>0 - Nacional, exceto as indicadas nos códigos 3, 4, 5 e 8; 1 - Estrangeira - Importação direta, exceto a indicada no código 6;
   *          <li>2 - Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7;
   *          <li>3 - Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% e inferior ou igual a 70%;
   *          <li>4 - Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam as legislações citadas nos Ajustes;
   *          <li>5 - Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40%;
   *          <li>6 - Estrangeira - Importação direta, sem similar nacional, constante em lista da CAMEX e gás natural;
   *          <li>7 - Estrangeira - Adquirida no mercado interno, sem similar nacional, constante lista CAMEX e gás natural
   */
  public void setOrig(String orig) {
    this.orig = orig;
  }

  /**
   * # n12 CST Tributação do ICMS = 20 E N04 N 1-1 2<br>
   * 20=Com redução de base de cálculo.
   *
   * @return # n12 CST Tributação do ICMS = 20 E N04 N 1-1 2<br>
   *         20=Com redução de base de cálculo
   */
  public String getCst() {
    return cst;
  }

  /**
   * # n12 CST Tributação do ICMS = 20 E N04 N 1-1 2<br>
   * 20=Com redução de base de cálculo.
   *
   * @param cst # n12 CST Tributação do ICMS = 20 E N04 N 1-1 2<br>
   *          20=Com redução de base de cálculo
   */
  public void setCst(String cst) {
    this.cst = cst;
  }

  /**
   * # n13 modBC Modalidade de determinação da BC do ICMS E N04 N 1-1 1
   * <li>0=Margem Valor Agregado (%);
   * <li>1=Pauta (Valor);
   * <li>2=Preço Tabelado Máx. (valor);
   * <li>3=Valor da operação.
   *
   * @return # n13 modBC Modalidade de determinação da BC do ICMS E N04 N 1-1 1
   *         <li>0=Margem Valor Agregado (%);
   *         <li>1=Pauta (Valor);
   *         <li>2=Preço Tabelado Máx
   */
  public String getModBC() {
    return modBC;
  }

  /**
   * # n13 modBC Modalidade de determinação da BC do ICMS E N04 N 1-1 1
   * <li>0=Margem Valor Agregado (%);
   * <li>1=Pauta (Valor);
   * <li>2=Preço Tabelado Máx. (valor);
   * <li>3=Valor da operação.
   *
   * @param modBC # n13 modBC Modalidade de determinação da BC do ICMS E N04 N 1-1 1
   *          <li>0=Margem Valor Agregado (%);
   *          <li>1=Pauta (Valor);
   *          <li>2=Preço Tabelado Máx
   */
  public void setModBC(String modBC) {
    this.modBC = modBC;
  }

  /**
   * # n14 pRedBC Percentual da Redução de BC E N04 N 1-1 3v2-4.
   *
   * @return # n14 pRedBC Percentual da Redução de BC E N04 N 1-1 3v2-4
   */
  public BigDecimal getPredBCST() {
    return predBCST;
  }

  /**
   * # n14 pRedBC Percentual da Redução de BC E N04 N 1-1 3v2-4.
   *
   * @param predBCST # n14 pRedBC Percentual da Redução de BC E N04 N 1-1 3v2-4
   */
  public void setPredBCST(BigDecimal predBCST) {
    this.predBCST = predBCST;
  }

  /**
   * # n15 vBC Valor da BC do ICMS E N04 N 1-1 13v2.
   *
   * @return # n15 vBC Valor da BC do ICMS E N04 N 1-1 13v2
   */
  public BigDecimal getVbc() {
    return vbc;
  }

  /**
   * # n15 vBC Valor da BC do ICMS E N04 N 1-1 13v2.
   *
   * @param vbc # n15 vBC Valor da BC do ICMS E N04 N 1-1 13v2
   */
  public void setVbc(BigDecimal vbc) {
    this.vbc = vbc;
  }

  /**
   * # n16 pICMS Alíquota do imposto E N04 N 1-1 3v2-4<br>
   * Alíquota do ICMS sem o FCP. Quando for o caso, informar a alíquota do FCP no campo pFCP.
   *
   * @return # n16 pICMS Alíquota do imposto E N04 N 1-1 3v2-4<br>
   *         Alíquota do ICMS sem o FCP
   */
  public BigDecimal getPicms() {
    return picms;
  }

  /**
   * # n16 pICMS Alíquota do imposto E N04 N 1-1 3v2-4<br>
   * Alíquota do ICMS sem o FCP. Quando for o caso, informar a alíquota do FCP no campo pFCP.
   *
   * @param picms # n16 pICMS Alíquota do imposto E N04 N 1-1 3v2-4<br>
   *          Alíquota do ICMS sem o FCP
   */
  public void setPicms(BigDecimal picms) {
    this.picms = picms;
  }

  /**
   * # n17 vICMS Valor do ICMS E N04 N 1-1 13v2.
   *
   * @return # n17 vICMS Valor do ICMS E N04 N 1-1 13v2
   */
  public BigDecimal getVicms() {
    return vicms;
  }

  /**
   * # n17 vICMS Valor do ICMS E N04 N 1-1 13v2.
   *
   * @param vicms # n17 vICMS Valor do ICMS E N04 N 1-1 13v2
   */
  public void setVicms(BigDecimal vicms) {
    this.vicms = vicms;
  }

  /**
   * # n17a vBCFCP Valor da Base de Cálculo do FCP E N17.1 N 1-1 13v2<br>
   * Informar o valor da Base de Cálculo do FCP.
   *
   * @return # n17a vBCFCP Valor da Base de Cálculo do FCP E N17
   */
  public BigDecimal getVbcFCP() {
    return vbcFCP;
  }

  /**
   * # n17a vBCFCP Valor da Base de Cálculo do FCP E N17.1 N 1-1 13v2<br>
   * Informar o valor da Base de Cálculo do FCP.
   *
   * @param vbcFCP # n17a vBCFCP Valor da Base de Cálculo do FCP E N17
   */
  public void setVbcFCP(BigDecimal vbcFCP) {
    this.vbcFCP = vbcFCP;
  }

  /**
   * # n17.b pFCP Percentual do Fundo de Combate à Pobreza (FCP) E N17.0 N 1-1 3v2-4<br>
   * Percentual relativo ao Fundo de Combate à Pobreza (FCP).
   *
   * @return # n17
   */
  public BigDecimal getPfcp() {
    return pfcp;
  }

  /**
   * # n17.b pFCP Percentual do Fundo de Combate à Pobreza (FCP) E N17.0 N 1-1 3v2-4<br>
   * Percentual relativo ao Fundo de Combate à Pobreza (FCP).
   *
   * @param pfcp # n17
   */
  public void setPfcp(BigDecimal pfcp) {
    this.pfcp = pfcp;
  }

  /**
   * # n17c vFCP Valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP) E N17.1 N 1-1 13v2<br>
   * Valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP).
   *
   * @return # n17c vFCP Valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP) E N17
   */
  public BigDecimal getVfcp() {
    return vfcp;
  }

  /**
   * # n17c vFCP Valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP) E N17.1 N 1-1 13v2<br>
   * Valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP).
   *
   * @param vfcp # n17c vFCP Valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP) E N17
   */
  public void setVfcp(BigDecimal vfcp) {
    this.vfcp = vfcp;
  }

  /**
   * # n28a vICMSDeson Valor do ICMS desonerado E N27.1 N 1-1 13v2<br>
   * Informar apenas nos motivos de desoneração documentados abaixo.
   *
   * @return # n28a vICMSDeson Valor do ICMS desonerado E N27
   */
  public BigDecimal getVicmsDeson() {
    return vicmsDeson;
  }

  /**
   * # n28a vICMSDeson Valor do ICMS desonerado E N27.1 N 1-1 13v2<br>
   * Informar apenas nos motivos de desoneração documentados abaixo.
   *
   * @param vicmsDeson # n28a vICMSDeson Valor do ICMS desonerado E N27
   */
  public void setVicmsDeson(BigDecimal vicmsDeson) {
    this.vicmsDeson = vicmsDeson;
  }

  /**
   * # n28 motDesICMS Motivo da desoneração do ICMS E N27.1 N 1-1 2<br>
   * Campo será preenchido quando o campo anterior estiver preenchido. Informar o motivo da desoneração:
   * <li>3=Uso na agropecuária;
   * <li>9=Outros;
   * <li>12=Órgão de fomento e desenvolvimento agropecuário.
   *
   * @return # n28 motDesICMS Motivo da desoneração do ICMS E N27
   */
  public String getMotDesICMS() {
    return motDesICMS;
  }

  /**
   * # n28 motDesICMS Motivo da desoneração do ICMS E N27.1 N 1-1 2<br>
   * Campo será preenchido quando o campo anterior estiver preenchido. Informar o motivo da desoneração:
   * <li>3=Uso na agropecuária;
   * <li>9=Outros;
   * <li>12=Órgão de fomento e desenvolvimento agropecuário.
   *
   * @param motDesICMS # n28 motDesICMS Motivo da desoneração do ICMS E N27
   */
  public void setMotDesICMS(String motDesICMS) {
    this.motDesICMS = motDesICMS;
  }

}