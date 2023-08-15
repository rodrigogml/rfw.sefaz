package br.eng.rodrigogml.rfw.sefaz.vos;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "ICMS20" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integra��o com o framework, pertindo a valida��o e at� a persist�ncia se o sistema assim desejar. N�o h� preocupa��o de gerar JavaDOC nestas classes pois ela deve representar exatamente a documenta��o da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Valida��o da NF-e.
 */
public class ICMS20VO extends RFWVO {

  private static final long serialVersionUID = 3497328689172678619L;

  /**
   * N11 orig Origem da mercadoria E N04 N 1-1 1
   * <li>0 - Nacional, exceto as indicadas nos c�digos 3, 4, 5 e 8; 1 - Estrangeira - Importa��o direta, exceto a indicada no c�digo 6;
   * <li>2 - Estrangeira - Adquirida no mercado interno, exceto a indicada no c�digo 7;
   * <li>3 - Nacional, mercadoria ou bem com Conte�do de Importa��o superior a 40% e inferior ou igual a 70%;
   * <li>4 - Nacional, cuja produ��o tenha sido feita em conformidade com os processos produtivos b�sicos de que tratam as legisla��es citadas nos Ajustes;
   * <li>5 - Nacional, mercadoria ou bem com Conte�do de Importa��o inferior ou igual a 40%;
   * <li>6 - Estrangeira - Importa��o direta, sem similar nacional, constante em lista da CAMEX e g�s natural;
   * <li>7 - Estrangeira - Adquirida no mercado interno, sem similar nacional, constante lista CAMEX e g�s natural.
   * <li>8 - Nacional, mercadoria ou bem com Conte�do de Importa��o superior a 70%;
   */
  @RFWMetaStringField(caption = "Origem da Mercadoria", minlength = 1, maxLength = 1, required = true, pattern = "^(0|2|3|4|5|6|7|8)$")
  private String orig = null;

  /**
   * N12 CST Tributa��o do ICMS = 20 E N04 N 1-1 2<br>
   * 20=Com redu��o de base de c�lculo
   */
  @RFWMetaStringField(caption = "CST", minlength = 2, maxLength = 2, required = true, pattern = "20")
  private String cst = null;

  /**
   * N13 modBC Modalidade de determina��o da BC do ICMS E N04 N 1-1 1
   * <li>0=Margem Valor Agregado (%);
   * <li>1=Pauta (Valor);
   * <li>2=Pre�o Tabelado M�x. (valor);
   * <li>3=Valor da opera��o.
   */
  @RFWMetaStringField(caption = "Modalidade de BC do ICMS", minlength = 1, maxLength = 1, required = true, pattern = "^(0|1|2|3)$")
  private String modBC = null;

  /**
   * N14 pRedBC Percentual da Redu��o de BC E N04 N 1-1 3v2-4
   */
  @RFWMetaBigDecimalField(caption = "Percentual Redu��o BC do ICMS ST", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = false)
  private BigDecimal predBCST = null;

  /**
   * N15 vBC Valor da BC do ICMS E N04 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor BC do ICMS", minValue = "0", maxValue = "9999999999999.99", required = true, scale = 2)
  private BigDecimal vbc = null;

  /**
   * N16 pICMS Al�quota do imposto E N04 N 1-1 3v2-4<br>
   * Al�quota do ICMS sem o FCP. Quando for o caso, informar a al�quota do FCP no campo pFCP
   */
  @RFWMetaBigDecimalField(caption = "Al�quota do ICMS", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = true)
  private BigDecimal picms = null;

  /**
   * N17 vICMS Valor do ICMS E N04 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = true)
  private BigDecimal vicms = null;

  /**
   * N17a vBCFCP Valor da Base de C�lculo do FCP E N17.1 N 1-1 13v2<br>
   * Informar o valor da Base de C�lculo do FCP
   */
  @RFWMetaBigDecimalField(caption = "Base C�lculo do FCP", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vbcFCP = null;

  /**
   * N17.b pFCP Percentual do Fundo de Combate � Pobreza (FCP) E N17.0 N 1-1 3v2-4<br>
   * Percentual relativo ao Fundo de Combate � Pobreza (FCP).
   */
  @RFWMetaBigDecimalField(caption = "Percentual FCP", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = false)
  private BigDecimal pfcp = null;

  /**
   * N17c vFCP Valor do ICMS relativo ao Fundo de Combate � Pobreza (FCP) E N17.1 N 1-1 13v2<br>
   * Valor do ICMS relativo ao Fundo de Combate � Pobreza (FCP).
   */
  @RFWMetaBigDecimalField(caption = "Base C�lculo do FCP", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vfcp = null;

  /**
   * N28a vICMSDeson Valor do ICMS desonerado E N27.1 N 1-1 13v2<br>
   * Informar apenas nos motivos de desonera��o documentados abaixo.
   */
  @RFWMetaBigDecimalField(caption = "Base C�lculo do FCP", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vicmsDeson = null;

  /**
   * N28 motDesICMS Motivo da desonera��o do ICMS E N27.1 N 1-1 2<br>
   * Campo ser� preenchido quando o campo anterior estiver preenchido. Informar o motivo da desonera��o:
   * <li>3=Uso na agropecu�ria;
   * <li>9=Outros;
   * <li>12=�rg�o de fomento e desenvolvimento agropecu�rio.
   */
  @RFWMetaStringField(caption = "Motivo da Desonera��o do ICMS", minlength = 1, maxLength = 2, required = false, pattern = "^(0|3|9|12)$")
  private String motDesICMS = null;

  /**
   * # n11 orig Origem da mercadoria E N04 N 1-1 1
   * <li>0 - Nacional, exceto as indicadas nos c�digos 3, 4, 5 e 8; 1 - Estrangeira - Importa��o direta, exceto a indicada no c�digo 6;
   * <li>2 - Estrangeira - Adquirida no mercado interno, exceto a indicada no c�digo 7;
   * <li>3 - Nacional, mercadoria ou bem com Conte�do de Importa��o superior a 40% e inferior ou igual a 70%;
   * <li>4 - Nacional, cuja produ��o tenha sido feita em conformidade com os processos produtivos b�sicos de que tratam as legisla��es citadas nos Ajustes;
   * <li>5 - Nacional, mercadoria ou bem com Conte�do de Importa��o inferior ou igual a 40%;
   * <li>6 - Estrangeira - Importa��o direta, sem similar nacional, constante em lista da CAMEX e g�s natural;
   * <li>7 - Estrangeira - Adquirida no mercado interno, sem similar nacional, constante lista CAMEX e g�s natural.
   * <li>8 - Nacional, mercadoria ou bem com Conte�do de Importa��o superior a 70%;.
   *
   * @return # n11 orig Origem da mercadoria E N04 N 1-1 1
   *         <li>0 - Nacional, exceto as indicadas nos c�digos 3, 4, 5 e 8; 1 - Estrangeira - Importa��o direta, exceto a indicada no c�digo 6;
   *         <li>2 - Estrangeira - Adquirida no mercado interno, exceto a indicada no c�digo 7;
   *         <li>3 - Nacional, mercadoria ou bem com Conte�do de Importa��o superior a 40% e inferior ou igual a 70%;
   *         <li>4 - Nacional, cuja produ��o tenha sido feita em conformidade com os processos produtivos b�sicos de que tratam as legisla��es citadas nos Ajustes;
   *         <li>5 - Nacional, mercadoria ou bem com Conte�do de Importa��o inferior ou igual a 40%;
   *         <li>6 - Estrangeira - Importa��o direta, sem similar nacional, constante em lista da CAMEX e g�s natural;
   *         <li>7 - Estrangeira - Adquirida no mercado interno, sem similar nacional, constante lista CAMEX e g�s natural
   */
  public String getOrig() {
    return orig;
  }

  /**
   * # n11 orig Origem da mercadoria E N04 N 1-1 1
   * <li>0 - Nacional, exceto as indicadas nos c�digos 3, 4, 5 e 8; 1 - Estrangeira - Importa��o direta, exceto a indicada no c�digo 6;
   * <li>2 - Estrangeira - Adquirida no mercado interno, exceto a indicada no c�digo 7;
   * <li>3 - Nacional, mercadoria ou bem com Conte�do de Importa��o superior a 40% e inferior ou igual a 70%;
   * <li>4 - Nacional, cuja produ��o tenha sido feita em conformidade com os processos produtivos b�sicos de que tratam as legisla��es citadas nos Ajustes;
   * <li>5 - Nacional, mercadoria ou bem com Conte�do de Importa��o inferior ou igual a 40%;
   * <li>6 - Estrangeira - Importa��o direta, sem similar nacional, constante em lista da CAMEX e g�s natural;
   * <li>7 - Estrangeira - Adquirida no mercado interno, sem similar nacional, constante lista CAMEX e g�s natural.
   * <li>8 - Nacional, mercadoria ou bem com Conte�do de Importa��o superior a 70%;.
   *
   * @param orig # n11 orig Origem da mercadoria E N04 N 1-1 1
   *          <li>0 - Nacional, exceto as indicadas nos c�digos 3, 4, 5 e 8; 1 - Estrangeira - Importa��o direta, exceto a indicada no c�digo 6;
   *          <li>2 - Estrangeira - Adquirida no mercado interno, exceto a indicada no c�digo 7;
   *          <li>3 - Nacional, mercadoria ou bem com Conte�do de Importa��o superior a 40% e inferior ou igual a 70%;
   *          <li>4 - Nacional, cuja produ��o tenha sido feita em conformidade com os processos produtivos b�sicos de que tratam as legisla��es citadas nos Ajustes;
   *          <li>5 - Nacional, mercadoria ou bem com Conte�do de Importa��o inferior ou igual a 40%;
   *          <li>6 - Estrangeira - Importa��o direta, sem similar nacional, constante em lista da CAMEX e g�s natural;
   *          <li>7 - Estrangeira - Adquirida no mercado interno, sem similar nacional, constante lista CAMEX e g�s natural
   */
  public void setOrig(String orig) {
    this.orig = orig;
  }

  /**
   * # n12 CST Tributa��o do ICMS = 20 E N04 N 1-1 2<br>
   * 20=Com redu��o de base de c�lculo.
   *
   * @return # n12 CST Tributa��o do ICMS = 20 E N04 N 1-1 2<br>
   *         20=Com redu��o de base de c�lculo
   */
  public String getCst() {
    return cst;
  }

  /**
   * # n12 CST Tributa��o do ICMS = 20 E N04 N 1-1 2<br>
   * 20=Com redu��o de base de c�lculo.
   *
   * @param cst # n12 CST Tributa��o do ICMS = 20 E N04 N 1-1 2<br>
   *          20=Com redu��o de base de c�lculo
   */
  public void setCst(String cst) {
    this.cst = cst;
  }

  /**
   * # n13 modBC Modalidade de determina��o da BC do ICMS E N04 N 1-1 1
   * <li>0=Margem Valor Agregado (%);
   * <li>1=Pauta (Valor);
   * <li>2=Pre�o Tabelado M�x. (valor);
   * <li>3=Valor da opera��o.
   *
   * @return # n13 modBC Modalidade de determina��o da BC do ICMS E N04 N 1-1 1
   *         <li>0=Margem Valor Agregado (%);
   *         <li>1=Pauta (Valor);
   *         <li>2=Pre�o Tabelado M�x
   */
  public String getModBC() {
    return modBC;
  }

  /**
   * # n13 modBC Modalidade de determina��o da BC do ICMS E N04 N 1-1 1
   * <li>0=Margem Valor Agregado (%);
   * <li>1=Pauta (Valor);
   * <li>2=Pre�o Tabelado M�x. (valor);
   * <li>3=Valor da opera��o.
   *
   * @param modBC # n13 modBC Modalidade de determina��o da BC do ICMS E N04 N 1-1 1
   *          <li>0=Margem Valor Agregado (%);
   *          <li>1=Pauta (Valor);
   *          <li>2=Pre�o Tabelado M�x
   */
  public void setModBC(String modBC) {
    this.modBC = modBC;
  }

  /**
   * # n14 pRedBC Percentual da Redu��o de BC E N04 N 1-1 3v2-4.
   *
   * @return # n14 pRedBC Percentual da Redu��o de BC E N04 N 1-1 3v2-4
   */
  public BigDecimal getPredBCST() {
    return predBCST;
  }

  /**
   * # n14 pRedBC Percentual da Redu��o de BC E N04 N 1-1 3v2-4.
   *
   * @param predBCST # n14 pRedBC Percentual da Redu��o de BC E N04 N 1-1 3v2-4
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
   * # n16 pICMS Al�quota do imposto E N04 N 1-1 3v2-4<br>
   * Al�quota do ICMS sem o FCP. Quando for o caso, informar a al�quota do FCP no campo pFCP.
   *
   * @return # n16 pICMS Al�quota do imposto E N04 N 1-1 3v2-4<br>
   *         Al�quota do ICMS sem o FCP
   */
  public BigDecimal getPicms() {
    return picms;
  }

  /**
   * # n16 pICMS Al�quota do imposto E N04 N 1-1 3v2-4<br>
   * Al�quota do ICMS sem o FCP. Quando for o caso, informar a al�quota do FCP no campo pFCP.
   *
   * @param picms # n16 pICMS Al�quota do imposto E N04 N 1-1 3v2-4<br>
   *          Al�quota do ICMS sem o FCP
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
   * # n17a vBCFCP Valor da Base de C�lculo do FCP E N17.1 N 1-1 13v2<br>
   * Informar o valor da Base de C�lculo do FCP.
   *
   * @return # n17a vBCFCP Valor da Base de C�lculo do FCP E N17
   */
  public BigDecimal getVbcFCP() {
    return vbcFCP;
  }

  /**
   * # n17a vBCFCP Valor da Base de C�lculo do FCP E N17.1 N 1-1 13v2<br>
   * Informar o valor da Base de C�lculo do FCP.
   *
   * @param vbcFCP # n17a vBCFCP Valor da Base de C�lculo do FCP E N17
   */
  public void setVbcFCP(BigDecimal vbcFCP) {
    this.vbcFCP = vbcFCP;
  }

  /**
   * # n17.b pFCP Percentual do Fundo de Combate � Pobreza (FCP) E N17.0 N 1-1 3v2-4<br>
   * Percentual relativo ao Fundo de Combate � Pobreza (FCP).
   *
   * @return # n17
   */
  public BigDecimal getPfcp() {
    return pfcp;
  }

  /**
   * # n17.b pFCP Percentual do Fundo de Combate � Pobreza (FCP) E N17.0 N 1-1 3v2-4<br>
   * Percentual relativo ao Fundo de Combate � Pobreza (FCP).
   *
   * @param pfcp # n17
   */
  public void setPfcp(BigDecimal pfcp) {
    this.pfcp = pfcp;
  }

  /**
   * # n17c vFCP Valor do ICMS relativo ao Fundo de Combate � Pobreza (FCP) E N17.1 N 1-1 13v2<br>
   * Valor do ICMS relativo ao Fundo de Combate � Pobreza (FCP).
   *
   * @return # n17c vFCP Valor do ICMS relativo ao Fundo de Combate � Pobreza (FCP) E N17
   */
  public BigDecimal getVfcp() {
    return vfcp;
  }

  /**
   * # n17c vFCP Valor do ICMS relativo ao Fundo de Combate � Pobreza (FCP) E N17.1 N 1-1 13v2<br>
   * Valor do ICMS relativo ao Fundo de Combate � Pobreza (FCP).
   *
   * @param vfcp # n17c vFCP Valor do ICMS relativo ao Fundo de Combate � Pobreza (FCP) E N17
   */
  public void setVfcp(BigDecimal vfcp) {
    this.vfcp = vfcp;
  }

  /**
   * # n28a vICMSDeson Valor do ICMS desonerado E N27.1 N 1-1 13v2<br>
   * Informar apenas nos motivos de desonera��o documentados abaixo.
   *
   * @return # n28a vICMSDeson Valor do ICMS desonerado E N27
   */
  public BigDecimal getVicmsDeson() {
    return vicmsDeson;
  }

  /**
   * # n28a vICMSDeson Valor do ICMS desonerado E N27.1 N 1-1 13v2<br>
   * Informar apenas nos motivos de desonera��o documentados abaixo.
   *
   * @param vicmsDeson # n28a vICMSDeson Valor do ICMS desonerado E N27
   */
  public void setVicmsDeson(BigDecimal vicmsDeson) {
    this.vicmsDeson = vicmsDeson;
  }

  /**
   * # n28 motDesICMS Motivo da desonera��o do ICMS E N27.1 N 1-1 2<br>
   * Campo ser� preenchido quando o campo anterior estiver preenchido. Informar o motivo da desonera��o:
   * <li>3=Uso na agropecu�ria;
   * <li>9=Outros;
   * <li>12=�rg�o de fomento e desenvolvimento agropecu�rio.
   *
   * @return # n28 motDesICMS Motivo da desonera��o do ICMS E N27
   */
  public String getMotDesICMS() {
    return motDesICMS;
  }

  /**
   * # n28 motDesICMS Motivo da desonera��o do ICMS E N27.1 N 1-1 2<br>
   * Campo ser� preenchido quando o campo anterior estiver preenchido. Informar o motivo da desonera��o:
   * <li>3=Uso na agropecu�ria;
   * <li>9=Outros;
   * <li>12=�rg�o de fomento e desenvolvimento agropecu�rio.
   *
   * @param motDesICMS # n28 motDesICMS Motivo da desonera��o do ICMS E N27
   */
  public void setMotDesICMS(String motDesICMS) {
    this.motDesICMS = motDesICMS;
  }

}