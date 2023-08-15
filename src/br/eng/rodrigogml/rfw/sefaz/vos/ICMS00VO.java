package br.eng.rodrigogml.rfw.sefaz.vos;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "ICMS00" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integra��o com o framework, pertindo a valida��o e at� a persist�ncia se o sistema assim desejar. N�o h� preocupa��o de gerar JavaDOC nestas classes pois ela deve representar exatamente a documenta��o da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Valida��o da NF-e.
 */
public class ICMS00VO extends RFWVO {

  private static final long serialVersionUID = 8044453844731957098L;

  /**
   * N11 orig Origem da mercadoria E N02 N 1-1 1
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
   * N12 CST Tributa��o do ICMS = 00 E N02 N 1-1 2<br>
   * 00=Tributada integralmente
   */
  @RFWMetaStringField(caption = "CST", minlength = 2, maxLength = 2, required = true, pattern = "00")
  private String cst = null;

  /**
   * N13 modBC Modalidade de determina��o da BC do ICMS E N02 N 1-1 1
   * <li>0=Margem Valor Agregado (%);
   * <li>1=Pauta (Valor);
   * <li>2=Pre�o Tabelado M�x. (valor);
   * <li>3=Valor da opera��o.
   */
  @RFWMetaStringField(caption = "Modalidade de BC do ICMS", minlength = 1, maxLength = 1, required = true, pattern = "^(0|1|2|3)$")
  private String modBC = null;

  /**
   * N15 vBC Valor da BC do ICMS E N02 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor BC do ICMS", minValue = "0", maxValue = "9999999999999.99", required = true, scale = 2)
  private BigDecimal vbc = null;

  /**
   * N16 pICMS Al�quota do imposto E N02 N 1-1 3v2-4<br>
   * Al�quota do ICMS sem o FCP. Quando for o caso, informar a al�quota do FCP no campo pFCP
   */
  @RFWMetaBigDecimalField(caption = "Al�quota do ICMS", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = true)
  private BigDecimal picms = null;

  /**
   * N17 vICMS Valor do ICMS E N02 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = true)
  private BigDecimal vicms = null;

  /**
   * # n11 orig Origem da mercadoria E N02 N 1-1 1
   * <li>0 - Nacional, exceto as indicadas nos c�digos 3, 4, 5 e 8; 1 - Estrangeira - Importa��o direta, exceto a indicada no c�digo 6;
   * <li>2 - Estrangeira - Adquirida no mercado interno, exceto a indicada no c�digo 7;
   * <li>3 - Nacional, mercadoria ou bem com Conte�do de Importa��o superior a 40% e inferior ou igual a 70%;
   * <li>4 - Nacional, cuja produ��o tenha sido feita em conformidade com os processos produtivos b�sicos de que tratam as legisla��es citadas nos Ajustes;
   * <li>5 - Nacional, mercadoria ou bem com Conte�do de Importa��o inferior ou igual a 40%;
   * <li>6 - Estrangeira - Importa��o direta, sem similar nacional, constante em lista da CAMEX e g�s natural;
   * <li>7 - Estrangeira - Adquirida no mercado interno, sem similar nacional, constante lista CAMEX e g�s natural.
   * <li>8 - Nacional, mercadoria ou bem com Conte�do de Importa��o superior a 70%;.
   *
   * @return # n11 orig Origem da mercadoria E N02 N 1-1 1
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
   * # n11 orig Origem da mercadoria E N02 N 1-1 1
   * <li>0 - Nacional, exceto as indicadas nos c�digos 3, 4, 5 e 8; 1 - Estrangeira - Importa��o direta, exceto a indicada no c�digo 6;
   * <li>2 - Estrangeira - Adquirida no mercado interno, exceto a indicada no c�digo 7;
   * <li>3 - Nacional, mercadoria ou bem com Conte�do de Importa��o superior a 40% e inferior ou igual a 70%;
   * <li>4 - Nacional, cuja produ��o tenha sido feita em conformidade com os processos produtivos b�sicos de que tratam as legisla��es citadas nos Ajustes;
   * <li>5 - Nacional, mercadoria ou bem com Conte�do de Importa��o inferior ou igual a 40%;
   * <li>6 - Estrangeira - Importa��o direta, sem similar nacional, constante em lista da CAMEX e g�s natural;
   * <li>7 - Estrangeira - Adquirida no mercado interno, sem similar nacional, constante lista CAMEX e g�s natural.
   * <li>8 - Nacional, mercadoria ou bem com Conte�do de Importa��o superior a 70%;.
   *
   * @param orig # n11 orig Origem da mercadoria E N02 N 1-1 1
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
   * # n12 CST Tributa��o do ICMS = 00 E N02 N 1-1 2<br>
   * 00=Tributada integralmente.
   *
   * @return # n12 CST Tributa��o do ICMS = 00 E N02 N 1-1 2<br>
   *         00=Tributada integralmente
   */
  public String getCst() {
    return cst;
  }

  /**
   * # n12 CST Tributa��o do ICMS = 00 E N02 N 1-1 2<br>
   * 00=Tributada integralmente.
   *
   * @param cst # n12 CST Tributa��o do ICMS = 00 E N02 N 1-1 2<br>
   *          00=Tributada integralmente
   */
  public void setCst(String cst) {
    this.cst = cst;
  }

  /**
   * # n13 modBC Modalidade de determina��o da BC do ICMS E N02 N 1-1 1
   * <li>0=Margem Valor Agregado (%);
   * <li>1=Pauta (Valor);
   * <li>2=Pre�o Tabelado M�x. (valor);
   * <li>3=Valor da opera��o.
   *
   * @return # n13 modBC Modalidade de determina��o da BC do ICMS E N02 N 1-1 1
   *         <li>0=Margem Valor Agregado (%);
   *         <li>1=Pauta (Valor);
   *         <li>2=Pre�o Tabelado M�x
   */
  public String getModBC() {
    return modBC;
  }

  /**
   * # n13 modBC Modalidade de determina��o da BC do ICMS E N02 N 1-1 1
   * <li>0=Margem Valor Agregado (%);
   * <li>1=Pauta (Valor);
   * <li>2=Pre�o Tabelado M�x. (valor);
   * <li>3=Valor da opera��o.
   *
   * @param modBC # n13 modBC Modalidade de determina��o da BC do ICMS E N02 N 1-1 1
   *          <li>0=Margem Valor Agregado (%);
   *          <li>1=Pauta (Valor);
   *          <li>2=Pre�o Tabelado M�x
   */
  public void setModBC(String modBC) {
    this.modBC = modBC;
  }

  /**
   * # n15 vBC Valor da BC do ICMS E N02 N 1-1 13v2.
   *
   * @return # n15 vBC Valor da BC do ICMS E N02 N 1-1 13v2
   */
  public BigDecimal getVbc() {
    return vbc;
  }

  /**
   * # n15 vBC Valor da BC do ICMS E N02 N 1-1 13v2.
   *
   * @param vbc # n15 vBC Valor da BC do ICMS E N02 N 1-1 13v2
   */
  public void setVbc(BigDecimal vbc) {
    this.vbc = vbc;
  }

  /**
   * # n16 pICMS Al�quota do imposto E N02 N 1-1 3v2-4<br>
   * Al�quota do ICMS sem o FCP. Quando for o caso, informar a al�quota do FCP no campo pFCP.
   *
   * @return # n16 pICMS Al�quota do imposto E N02 N 1-1 3v2-4<br>
   *         Al�quota do ICMS sem o FCP
   */
  public BigDecimal getPicms() {
    return picms;
  }

  /**
   * # n16 pICMS Al�quota do imposto E N02 N 1-1 3v2-4<br>
   * Al�quota do ICMS sem o FCP. Quando for o caso, informar a al�quota do FCP no campo pFCP.
   *
   * @param picms # n16 pICMS Al�quota do imposto E N02 N 1-1 3v2-4<br>
   *          Al�quota do ICMS sem o FCP
   */
  public void setPicms(BigDecimal picms) {
    this.picms = picms;
  }

  /**
   * # n17 vICMS Valor do ICMS E N02 N 1-1 13v2.
   *
   * @return # n17 vICMS Valor do ICMS E N02 N 1-1 13v2
   */
  public BigDecimal getVicms() {
    return vicms;
  }

  /**
   * # n17 vICMS Valor do ICMS E N02 N 1-1 13v2.
   *
   * @param vicms # n17 vICMS Valor do ICMS E N02 N 1-1 13v2
   */
  public void setVicms(BigDecimal vicms) {
    this.vicms = vicms;
  }

}
