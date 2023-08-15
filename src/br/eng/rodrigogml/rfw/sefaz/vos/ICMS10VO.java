package br.eng.rodrigogml.rfw.sefaz.vos;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "ICMS10" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class ICMS10VO extends RFWVO {

  private static final long serialVersionUID = -1421958543799649304L;

  /**
   * N11 orig Origem da mercadoria E N03 N 1-1 1
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
   * N12 CST Tributação do ICMS = 10 E N03 N 1-1 2<br>
   * 10=Tributada e com cobrança do ICMS por substituição tributária
   */
  @RFWMetaStringField(caption = "CST", minlength = 2, maxLength = 2, required = true, pattern = "10")
  private String cst = null;

  /**
   * N13 modBC Modalidade de determinação da BC do ICMS E N03 N 1-1 1
   * <li>0=Margem Valor Agregado (%);
   * <li>1=Pauta (Valor);
   * <li>2=Preço Tabelado Máx. (valor);
   * <li>3=Valor da operação.
   */
  @RFWMetaStringField(caption = "Modalidade de BC do ICMS", minlength = 1, maxLength = 1, required = true, pattern = "^(0|1|2|3)$")
  private String modBC = null;

  /**
   * N15 vBC Valor da BC do ICMS E N03 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor BC do ICMS", minValue = "0", maxValue = "9999999999999.99", required = true, scale = 2)
  private BigDecimal vbc = null;

  /**
   * N16 pICMS Alíquota do imposto E N03 N 1-1 3v2-4<br>
   * Alíquota do ICMS sem o FCP. Quando for o caso, informar a alíquota do FCP no campo pFCP.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota do ICMS", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = true)
  private BigDecimal picms = null;

  /**
   * N17 vICMS Valor do ICMS E N03 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = true)
  private BigDecimal vicms = null;

  /**
   * N17.a vBCFCP Valor da Base de Cálculo do FCP E N17.0 N 1-1 13v2<br>
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
   * N17.c vFCP Valor do Fundo de Combate à Pobreza (FCP) E N17.0 N 1-1 13v2<br>
   * Valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP).
   */
  @RFWMetaBigDecimalField(caption = "Base Cálculo do FCP", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vfcp = null;

  /**
   * N18 modBCST Modalidade de determinação da BC do ICMS ST E N03 N 1-1 1
   * <li>0=Preço tabelado ou máximo sugerido
   * <li>1=Lista Negativa (valor)
   * <li>2=Lista Positiva (valor);
   * <li>3=Lista Neutra (valor)
   * <li>4=Margem Valor Agregado (%)
   * <li>5=Pauta (valor)
   * <li>6 = Valor da Operação (NT 2019.001)
   */
  @RFWMetaStringField(caption = "Modalidade da BC do ICMS ST", minlength = 1, maxLength = 1, required = false, pattern = "^(0|1|2|3|4|5|6)$")
  private String modBCST = null;

  /**
   * N19 pMVAST Percentual da margem de valor Adicionado do ICMS ST E N03 N 0-1 3v2-4
   */
  @RFWMetaBigDecimalField(caption = "Percentual MVA do ICMS ST", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = false)
  private BigDecimal pmvaST = null;

  /**
   * N20 pRedBCST Percentual da Redução de BC do ICMS ST E N03 N 0-1 3v2-4
   */
  @RFWMetaBigDecimalField(caption = "Percentual Redução BC do ICMS ST", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = false)
  private BigDecimal predBCST = null;

  /**
   * N21 vBCST Valor da BC do ICMS ST E N03 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Base Cálculo do FCP", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vbcST = null;

  /**
   * N22 pICMSST Alíquota do imposto do ICMS ST E N03 N 1-1 3v2-4<br>
   * Alíquota do ICMS ST sem o FCP. Quando for o caso, informar a alíquota do FCP no campo pFCP
   */
  @RFWMetaBigDecimalField(caption = "Aliquota do ICMS ST", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = false)
  private BigDecimal picmsST = null;

  /**
   * N23 vICMSST Valor do ICMS ST E N03 N 1-1 13v2<br>
   * Valor do ICMS ST retido
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS ST", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vicmsST = null;

  /**
   * N23a vBCFCPST Valor da Base de Cálculo do FCP retido por Substituição Tributária E N23.1 N 1-1 13v2<br>
   * Informar o valor da Base de Cálculo do FCP retido por Substituição Tributária
   */
  @RFWMetaBigDecimalField(caption = "Valor BC do FCP ST", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vbcFCPST = null;

  /**
   * N23b pFCPST Percentual do FCP retido por Substituição Tributária E N23.1 N 1-1 3v2-4<Br>
   * Percentual relativo ao Fundo de Combate à Pobreza (FCP) retido por substituição tributária.
   */
  @RFWMetaBigDecimalField(caption = "Percentual do FCP ST", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = false)
  private BigDecimal pfcpST = null;

  /**
   * N23d vFCPST Valor do FCP retido por Substituição Tributária E N23.1 N 1-1 13v2<br>
   * Valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP) retido por substituição tributária.
   */
  @RFWMetaBigDecimalField(caption = "Valor FCP ST", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vfcpST = null;

  /**
   * # n11 orig Origem da mercadoria E N03 N 1-1 1
   * <li>0 - Nacional, exceto as indicadas nos códigos 3, 4, 5 e 8; 1 - Estrangeira - Importação direta, exceto a indicada no código 6;
   * <li>2 - Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7;
   * <li>3 - Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% e inferior ou igual a 70%;
   * <li>4 - Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam as legislações citadas nos Ajustes;
   * <li>5 - Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40%;
   * <li>6 - Estrangeira - Importação direta, sem similar nacional, constante em lista da CAMEX e gás natural;
   * <li>7 - Estrangeira - Adquirida no mercado interno, sem similar nacional, constante lista CAMEX e gás natural.
   * <li>8 - Nacional, mercadoria ou bem com Conteúdo de Importação superior a 70%;.
   *
   * @return # n11 orig Origem da mercadoria E N03 N 1-1 1
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
   * # n11 orig Origem da mercadoria E N03 N 1-1 1
   * <li>0 - Nacional, exceto as indicadas nos códigos 3, 4, 5 e 8; 1 - Estrangeira - Importação direta, exceto a indicada no código 6;
   * <li>2 - Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7;
   * <li>3 - Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% e inferior ou igual a 70%;
   * <li>4 - Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam as legislações citadas nos Ajustes;
   * <li>5 - Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40%;
   * <li>6 - Estrangeira - Importação direta, sem similar nacional, constante em lista da CAMEX e gás natural;
   * <li>7 - Estrangeira - Adquirida no mercado interno, sem similar nacional, constante lista CAMEX e gás natural.
   * <li>8 - Nacional, mercadoria ou bem com Conteúdo de Importação superior a 70%;.
   *
   * @param orig # n11 orig Origem da mercadoria E N03 N 1-1 1
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
   * # n12 CST Tributação do ICMS = 10 E N03 N 1-1 2<br>
   * 10=Tributada e com cobrança do ICMS por substituição tributária.
   *
   * @return # n12 CST Tributação do ICMS = 10 E N03 N 1-1 2<br>
   *         10=Tributada e com cobrança do ICMS por substituição tributária
   */
  public String getCst() {
    return cst;
  }

  /**
   * # n12 CST Tributação do ICMS = 10 E N03 N 1-1 2<br>
   * 10=Tributada e com cobrança do ICMS por substituição tributária.
   *
   * @param cst # n12 CST Tributação do ICMS = 10 E N03 N 1-1 2<br>
   *          10=Tributada e com cobrança do ICMS por substituição tributária
   */
  public void setCst(String cst) {
    this.cst = cst;
  }

  /**
   * # n13 modBC Modalidade de determinação da BC do ICMS E N03 N 1-1 1
   * <li>0=Margem Valor Agregado (%);
   * <li>1=Pauta (Valor);
   * <li>2=Preço Tabelado Máx. (valor);
   * <li>3=Valor da operação.
   *
   * @return # n13 modBC Modalidade de determinação da BC do ICMS E N03 N 1-1 1
   *         <li>0=Margem Valor Agregado (%);
   *         <li>1=Pauta (Valor);
   *         <li>2=Preço Tabelado Máx
   */
  public String getModBC() {
    return modBC;
  }

  /**
   * # n13 modBC Modalidade de determinação da BC do ICMS E N03 N 1-1 1
   * <li>0=Margem Valor Agregado (%);
   * <li>1=Pauta (Valor);
   * <li>2=Preço Tabelado Máx. (valor);
   * <li>3=Valor da operação.
   *
   * @param modBC # n13 modBC Modalidade de determinação da BC do ICMS E N03 N 1-1 1
   *          <li>0=Margem Valor Agregado (%);
   *          <li>1=Pauta (Valor);
   *          <li>2=Preço Tabelado Máx
   */
  public void setModBC(String modBC) {
    this.modBC = modBC;
  }

  /**
   * # n15 vBC Valor da BC do ICMS E N03 N 1-1 13v2.
   *
   * @return # n15 vBC Valor da BC do ICMS E N03 N 1-1 13v2
   */
  public BigDecimal getVbc() {
    return vbc;
  }

  /**
   * # n15 vBC Valor da BC do ICMS E N03 N 1-1 13v2.
   *
   * @param vbc # n15 vBC Valor da BC do ICMS E N03 N 1-1 13v2
   */
  public void setVbc(BigDecimal vbc) {
    this.vbc = vbc;
  }

  /**
   * # n16 pICMS Alíquota do imposto E N03 N 1-1 3v2-4<br>
   * Alíquota do ICMS sem o FCP. Quando for o caso, informar a alíquota do FCP no campo pFCP.
   *
   * @return # n16 pICMS Alíquota do imposto E N03 N 1-1 3v2-4<br>
   *         Alíquota do ICMS sem o FCP
   */
  public BigDecimal getPicms() {
    return picms;
  }

  /**
   * # n16 pICMS Alíquota do imposto E N03 N 1-1 3v2-4<br>
   * Alíquota do ICMS sem o FCP. Quando for o caso, informar a alíquota do FCP no campo pFCP.
   *
   * @param picms # n16 pICMS Alíquota do imposto E N03 N 1-1 3v2-4<br>
   *          Alíquota do ICMS sem o FCP
   */
  public void setPicms(BigDecimal picms) {
    this.picms = picms;
  }

  /**
   * # n17 vICMS Valor do ICMS E N03 N 1-1 13v2.
   *
   * @return # n17 vICMS Valor do ICMS E N03 N 1-1 13v2
   */
  public BigDecimal getVicms() {
    return vicms;
  }

  /**
   * # n17 vICMS Valor do ICMS E N03 N 1-1 13v2.
   *
   * @param vicms # n17 vICMS Valor do ICMS E N03 N 1-1 13v2
   */
  public void setVicms(BigDecimal vicms) {
    this.vicms = vicms;
  }

  /**
   * # n17.a vBCFCP Valor da Base de Cálculo do FCP E N17.0 N 1-1 13v2<br>
   * Informar o valor da Base de Cálculo do FCP.
   *
   * @return # n17
   */
  public BigDecimal getVbcFCP() {
    return vbcFCP;
  }

  /**
   * # n17.a vBCFCP Valor da Base de Cálculo do FCP E N17.0 N 1-1 13v2<br>
   * Informar o valor da Base de Cálculo do FCP.
   *
   * @param vbcFCP # n17
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
   * # n17.c vFCP Valor do Fundo de Combate à Pobreza (FCP) E N17.0 N 1-1 13v2<br>
   * Valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP).
   *
   * @return # n17
   */
  public BigDecimal getVfcp() {
    return vfcp;
  }

  /**
   * # n17.c vFCP Valor do Fundo de Combate à Pobreza (FCP) E N17.0 N 1-1 13v2<br>
   * Valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP).
   *
   * @param vfcp # n17
   */
  public void setVfcp(BigDecimal vfcp) {
    this.vfcp = vfcp;
  }

  /**
   * # n18 modBCST Modalidade de determinação da BC do ICMS ST E N03 N 1-1 1
   * <li>0=Preço tabelado ou máximo sugerido
   * <li>1=Lista Negativa (valor)
   * <li>2=Lista Positiva (valor);
   * <li>3=Lista Neutra (valor)
   * <li>4=Margem Valor Agregado (%)
   * <li>5=Pauta (valor)
   * <li>6 = Valor da Operação (NT 2019.001).
   *
   * @return # n18 modBCST Modalidade de determinação da BC do ICMS ST E N03 N 1-1 1
   *         <li>0=Preço tabelado ou máximo sugerido
   *         <li>1=Lista Negativa (valor)
   *         <li>2=Lista Positiva (valor);
   *         <li>3=Lista Neutra (valor)
   *         <li>4=Margem Valor Agregado (%)
   *         <li>5=Pauta (valor)
   *         <li>6 = Valor da Operação (NT 2019
   */
  public String getModBCST() {
    return modBCST;
  }

  /**
   * # n18 modBCST Modalidade de determinação da BC do ICMS ST E N03 N 1-1 1
   * <li>0=Preço tabelado ou máximo sugerido
   * <li>1=Lista Negativa (valor)
   * <li>2=Lista Positiva (valor);
   * <li>3=Lista Neutra (valor)
   * <li>4=Margem Valor Agregado (%)
   * <li>5=Pauta (valor)
   * <li>6 = Valor da Operação (NT 2019.001).
   *
   * @param modBCST # n18 modBCST Modalidade de determinação da BC do ICMS ST E N03 N 1-1 1
   *          <li>0=Preço tabelado ou máximo sugerido
   *          <li>1=Lista Negativa (valor)
   *          <li>2=Lista Positiva (valor);
   *          <li>3=Lista Neutra (valor)
   *          <li>4=Margem Valor Agregado (%)
   *          <li>5=Pauta (valor)
   *          <li>6 = Valor da Operação (NT 2019
   */
  public void setModBCST(String modBCST) {
    this.modBCST = modBCST;
  }

  /**
   * # n19 pMVAST Percentual da margem de valor Adicionado do ICMS ST E N03 N 0-1 3v2-4.
   *
   * @return # n19 pMVAST Percentual da margem de valor Adicionado do ICMS ST E N03 N 0-1 3v2-4
   */
  public BigDecimal getPmvaST() {
    return pmvaST;
  }

  /**
   * # n19 pMVAST Percentual da margem de valor Adicionado do ICMS ST E N03 N 0-1 3v2-4.
   *
   * @param pmvaST # n19 pMVAST Percentual da margem de valor Adicionado do ICMS ST E N03 N 0-1 3v2-4
   */
  public void setPmvaST(BigDecimal pmvaST) {
    this.pmvaST = pmvaST;
  }

  /**
   * # n20 pRedBCST Percentual da Redução de BC do ICMS ST E N03 N 0-1 3v2-4.
   *
   * @return # n20 pRedBCST Percentual da Redução de BC do ICMS ST E N03 N 0-1 3v2-4
   */
  public BigDecimal getPredBCST() {
    return predBCST;
  }

  /**
   * # n20 pRedBCST Percentual da Redução de BC do ICMS ST E N03 N 0-1 3v2-4.
   *
   * @param predBCST # n20 pRedBCST Percentual da Redução de BC do ICMS ST E N03 N 0-1 3v2-4
   */
  public void setPredBCST(BigDecimal predBCST) {
    this.predBCST = predBCST;
  }

  /**
   * # n21 vBCST Valor da BC do ICMS ST E N03 N 1-1 13v2.
   *
   * @return # n21 vBCST Valor da BC do ICMS ST E N03 N 1-1 13v2
   */
  public BigDecimal getVbcST() {
    return vbcST;
  }

  /**
   * # n21 vBCST Valor da BC do ICMS ST E N03 N 1-1 13v2.
   *
   * @param vbcST # n21 vBCST Valor da BC do ICMS ST E N03 N 1-1 13v2
   */
  public void setVbcST(BigDecimal vbcST) {
    this.vbcST = vbcST;
  }

  /**
   * # n22 pICMSST Alíquota do imposto do ICMS ST E N03 N 1-1 3v2-4<br>
   * Alíquota do ICMS ST sem o FCP. Quando for o caso, informar a alíquota do FCP no campo pFCP.
   *
   * @return # n22 pICMSST Alíquota do imposto do ICMS ST E N03 N 1-1 3v2-4<br>
   *         Alíquota do ICMS ST sem o FCP
   */
  public BigDecimal getPicmsST() {
    return picmsST;
  }

  /**
   * # n22 pICMSST Alíquota do imposto do ICMS ST E N03 N 1-1 3v2-4<br>
   * Alíquota do ICMS ST sem o FCP. Quando for o caso, informar a alíquota do FCP no campo pFCP.
   *
   * @param picmsST # n22 pICMSST Alíquota do imposto do ICMS ST E N03 N 1-1 3v2-4<br>
   *          Alíquota do ICMS ST sem o FCP
   */
  public void setPicmsST(BigDecimal picmsST) {
    this.picmsST = picmsST;
  }

  /**
   * # n23 vICMSST Valor do ICMS ST E N03 N 1-1 13v2<br>
   * Valor do ICMS ST retido.
   *
   * @return # n23 vICMSST Valor do ICMS ST E N03 N 1-1 13v2<br>
   *         Valor do ICMS ST retido
   */
  public BigDecimal getVicmsST() {
    return vicmsST;
  }

  /**
   * # n23 vICMSST Valor do ICMS ST E N03 N 1-1 13v2<br>
   * Valor do ICMS ST retido.
   *
   * @param vicmsST # n23 vICMSST Valor do ICMS ST E N03 N 1-1 13v2<br>
   *          Valor do ICMS ST retido
   */
  public void setVicmsST(BigDecimal vicmsST) {
    this.vicmsST = vicmsST;
  }

  /**
   * # n23a vBCFCPST Valor da Base de Cálculo do FCP retido por Substituição Tributária E N23.1 N 1-1 13v2<br>
   * Informar o valor da Base de Cálculo do FCP retido por Substituição Tributária.
   *
   * @return # n23a vBCFCPST Valor da Base de Cálculo do FCP retido por Substituição Tributária E N23
   */
  public BigDecimal getVbcFCPST() {
    return vbcFCPST;
  }

  /**
   * # n23a vBCFCPST Valor da Base de Cálculo do FCP retido por Substituição Tributária E N23.1 N 1-1 13v2<br>
   * Informar o valor da Base de Cálculo do FCP retido por Substituição Tributária.
   *
   * @param vbcFCPST # n23a vBCFCPST Valor da Base de Cálculo do FCP retido por Substituição Tributária E N23
   */
  public void setVbcFCPST(BigDecimal vbcFCPST) {
    this.vbcFCPST = vbcFCPST;
  }

  /**
   * # n23b pFCPST Percentual do FCP retido por Substituição Tributária E N23.1 N 1-1 3v2-4<Br>
   * Percentual relativo ao Fundo de Combate à Pobreza (FCP) retido por substituição tributária.
   *
   * @return # n23b pFCPST Percentual do FCP retido por Substituição Tributária E N23
   */
  public BigDecimal getPfcpST() {
    return pfcpST;
  }

  /**
   * # n23b pFCPST Percentual do FCP retido por Substituição Tributária E N23.1 N 1-1 3v2-4<Br>
   * Percentual relativo ao Fundo de Combate à Pobreza (FCP) retido por substituição tributária.
   *
   * @param pfcpST # n23b pFCPST Percentual do FCP retido por Substituição Tributária E N23
   */
  public void setPfcpST(BigDecimal pfcpST) {
    this.pfcpST = pfcpST;
  }

  /**
   * # n23d vFCPST Valor do FCP retido por Substituição Tributária E N23.1 N 1-1 13v2<br>
   * Valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP) retido por substituição tributária.
   *
   * @return # n23d vFCPST Valor do FCP retido por Substituição Tributária E N23
   */
  public BigDecimal getVfcpST() {
    return vfcpST;
  }

  /**
   * # n23d vFCPST Valor do FCP retido por Substituição Tributária E N23.1 N 1-1 13v2<br>
   * Valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP) retido por substituição tributária.
   *
   * @param vfcpST # n23d vFCPST Valor do FCP retido por Substituição Tributária E N23
   */
  public void setVfcpST(BigDecimal vfcpST) {
    this.vfcpST = vfcpST;
  }

}