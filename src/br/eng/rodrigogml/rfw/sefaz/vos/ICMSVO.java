package br.eng.rodrigogml.rfw.sefaz.vos;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "ICMS" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integra��o com o framework, pertindo a valida��o e at� a persist�ncia se o sistema assim desejar. N�o h� preocupa��o de gerar JavaDOC nestas classes pois ela deve representar exatamente a documenta��o da NFe.<br>
 * <br>
 * Por serem muito parecidas e simplificar a manipula��o do objeto, todas as Tags, de ICMS00, ICMS10, etc. foram incorporadas dentro deste objeto.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Valida��o da NF-e.
 */
public class ICMSVO extends RFWVO {

  private static final long serialVersionUID = 6008814847693935270L;

  /**
   * <h4>TAG N02 - ICMS00</h4><br>
   * N11 orig Origem da mercadoria E N02 N 1-1 1
   *
   * <h4>TAG N03 - ICMS10</h4><br>
   * N11 orig Origem da mercadoria E N03 N 1-1 1
   *
   * <h4>TAG N04 - ICMS20</h4><br>
   * N11 orig Origem da mercadoria E N04 N 1-1 1
   *
   * <h4>TAG N05 - ICMS30</h4><br>
   * N11 orig Origem da mercadoria E N05 N 1-1 1
   *
   * <h4>TAG N06 - ICMS40</h4><br>
   * N11 orig Origem da mercadoria E N06 N 1-1 1
   *
   * <h4>TAG N07 - ICMS51</h4><br>
   * N11 orig Origem da mercadoria E N07 N 1-1 1
   *
   * <h4>TAG N08 - ICMS60</h4><br>
   * N11 orig Origem da mercadoria E N08 N 1-1 1
   *
   * <h4>TAG N09 - ICMS70</h4><br>
   * N11 orig Origem da mercadoria E N09 N 1-1 1
   *
   * <h4>TAG N10 - ICMS90</h4><br>
   * N11 orig Origem da mercadoria E N10 N 1-1 1
   *
   * <hr>
   * <li>0 - Nacional, exceto as indicadas nos c�digos 3, 4, 5 e 8;
   * <li>1 - Estrangeira - Importa��o direta, exceto a indicada no c�digo 6;
   * <li>2 - Estrangeira - Adquirida no mercado interno, exceto a indicada no c�digo 7;
   * <li>3 - Nacional, mercadoria ou bem com Conte�do de Importa��o superior a 40% e inferior ou igual a 70%;
   * <li>4 - Nacional, cuja produ��o tenha sido feita em conformidade com os processos produtivos b�sicos de que tratam as legisla��es citadas nos Ajustes;
   * <li>5 - Nacional, mercadoria ou bem com Conte�do de Importa��o inferior ou igual a 40%;
   * <li>6 - Estrangeira - Importa��o direta, sem similar nacional, constante em lista da CAMEX e g�s natural;
   * <li>7 - Estrangeira - Adquirida no mercado interno, sem similar nacional, constante lista CAMEX e g�s natural.
   * <li>8 - Nacional, mercadoria ou bem com Conte�do de Importa��o superior a 70%;
   */
  @RFWMetaStringField(caption = "Origem da Mercadoria", minlength = 1, maxLength = 1, required = true, pattern = "^(0|1|2|3|4|5|6|7|8)$")
  private String orig = null;

  /**
   * <h4>TAG N02 - ICMS00</h4><br>
   * N12 CST Tributa��o do ICMS = 00 E N02 N 1-1 2<br>
   * <li>00=Tributada integralmente
   *
   * <h4>TAG N03 - ICMS10</h4><br>
   * N12 CST Tributa��o do ICMS = 10 E N03 N 1-1 2<br>
   * <li>10=Tributada e com cobran�a do ICMS por substitui��o tribut�ria
   *
   * <h4>TAG N04 - ICMS20</h4><br>
   * N12 CST Tributa��o do ICMS = 20 E N04 N 1-1 2<br>
   * <li>20=Com redu��o de base de c�lculo
   *
   * <h4>TAG N05 - ICMS30</h4><br>
   * N12 CST Tributa��o do ICMS = 30 E N05 N 1-1 2<br>
   * <li>30=Isenta ou n�o tributada e com cobran�a do ICMS por substitui��o tribut�ria
   *
   * <h4>TAG N06 - ICMS40</h4><br>
   * N12 CST Tributa��o do ICMS = 40, 41 ou 50 E N06 N 1-1 2<br>
   * <li>40=Isenta;
   * <li>41=N�o tributada;
   * <li>50=Suspens�o.
   *
   * <h4>TAG N07 - ICMS51</h4><br>
   * N12 CST Tributa��o do ICMS = 51 E N07 N 1-1 2
   * <li>51=Diferimento
   *
   * <h4>TAG N08 - ICMS60</h4><br>
   * N12 CST Tributa��o do ICMS = 60 E N08 N 1-1 2
   * <li>60=ICMS cobrado anteriormente por substitui��o tribut�ria
   *
   * <h4>TAG N09 - ICMS70</h4><br>
   * CST Tributa��o do ICMS = 70 E N09 N 1-1 2
   * <li>70=Com redu��o de base de c�lculo e cobran�a do ICMS por substitui��o tribut�ria
   *
   * <h4>TAG N10 - ICMS90</h4><br>
   * N12 CST Tributa��o do ICMS = 90 E N10 N 1-1 2
   * <li>90=Outros
   *
   */
  @RFWMetaStringField(caption = "CST", minlength = 2, maxLength = 2, required = true, pattern = "^(00|10|20|30|40|41|50|51|60|70|90)$")
  private String cst = null;

  /**
   * <h4>TAG N02 - ICMS00</h4><br>
   * N13 modBC Modalidade de determina��o da BC do ICMS E N02 N 1-1 1<br>
   * <li>0=Margem Valor Agregado (%);
   * <li>1=Pauta (Valor);
   * <li>2=Pre�o Tabelado M�x. (valor);
   * <li>3=Valor da opera��o.
   *
   * <h4>TAG N03 - ICMS10</h4><br>
   * N13 modBC Modalidade de determina��o da BC do ICMS E N03 N 1-1 1<br>
   * <li>0=Pre�o tabelado ou m�ximo sugerido
   * <li>1=Lista Negativa (valor)
   * <li>2=Lista Positiva (valor);
   * <li>3=Lista Neutra (valor)
   * <li>4=Margem Valor Agregado (%)
   * <li>5=Pauta (valor)
   * <li>6=Valor da Opera��o (NT 2019.001)
   *
   * <h4>TAG N04 - ICMS20</h4><br>
   * N13 modBC Modalidade de determina��o da BC do ICMS E N04 N 1-1 1<br>
   * <li>0=Margem Valor Agregado (%);
   * <li>1=Pauta (Valor);
   * <li>2=Pre�o Tabelado M�x. (valor);
   * <li>3=Valor da opera��o.
   *
   * <h4>TAG N07 - ICMS51</h4><br>
   * N13 modBC Modalidade de determina��o da BC do ICMS E N07 N 0-1 1<br>
   * <li>0=Margem Valor Agregado (%);
   * <li>1=Pauta (Valor);
   * <li>2=Pre�o Tabelado M�x. (valor);
   * <li>3=Valor da opera��o.
   *
   * <h4>TAG N09 - ICMS70</h4><br>
   * N13 modBC Modalidade de determina��o da BC do ICMS E N09 N 1-1 1<br>
   * <li>0=Margem Valor Agregado (%);
   * <li>1=Pauta (Valor);
   * <li>2=Pre�o Tabelado M�x. (valor);
   * <li>3=Valor da opera��o.
   *
   * <h4>TAG N10 - ICMS90</h4><br>
   * N13 modBC Modalidade de determina��o da BC do ICMS E N12.1 N 1-1 1<bR>
   * <li>0=Margem Valor Agregado (%);
   * <li>1=Pauta (Valor);
   * <li>2=Pre�o Tabelado M�x. (valor);
   * <li>3=Valor da opera��o
   */
  @RFWMetaStringField(caption = "Modalidade de BC do ICMS", minlength = 1, maxLength = 1, required = true, pattern = "^(0|1|2|3)$")
  private String modBC = null;

  /**
   * <h4>TAG N02 - ICMS00</h4><br>
   * N15 vBC Valor da BC do ICMS E N02 N 1-1 13v2
   *
   * <h4>TAG N03 - ICMS10</h4><br>
   * N15 vBC Valor da BC do ICMS E N03 N 1-1 13v2
   *
   * <h4>TAG N04 - ICMS20</h4><br>
   * N15 vBC Valor da BC do ICMS E N04 N 1-1 13v2
   *
   * <h4>TAG N07 - ICMS51</h4><br>
   * N15 vBC Valor da BC do ICMS E N07 N 0-1 13v2
   *
   * <h4>TAG N09 - ICMS70</h4><br>
   * N15 vBC Valor da BC do ICMS E N09 N 1-1 13v2
   *
   * <h4>TAG N10 - ICMS90</h4><br>
   * N15 vBC Valor da BC do ICMS E N12.1 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor BC do ICMS", minValue = "0", maxValue = "9999999999999.99", required = false, scale = 2)
  private BigDecimal vbc = null;

  /**
   * <h4>TAG N02 - ICMS00</h4><br>
   * N16 pICMS Al�quota do imposto E N02 N 1-1 3v2-4 <br>
   * Al�quota do ICMS sem o FCP. Quando for o caso, informar a al�quota do FCP no campo pFCP
   *
   * <h4>TAG N03 - ICMS10</h4><br>
   * N16 pICMS Al�quota do imposto E N03 N 1-1 3v2-4 <br>
   * Al�quota do ICMS sem o FCP. Quando for o caso, informar a al�quota do FCP no campo pFCP.
   *
   * <h4>TAG N04 - ICMS20</h4><br>
   * N16 pICMS Al�quota do imposto E N04 N 1-1 3v2-4<br>
   * Al�quota do ICMS sem o FCP. Quando for o caso, informar a al�quota do FCP no campo pFCP
   *
   * <h4>TAG N07 - ICMS51</h4><br>
   * N16 pICMS Al�quota do imposto E N07 N 0-1 3v2-4<br>
   * Al�quota do ICMS sem o FCP. Quando for o caso, informar a al�quota do FCP no campo pFCP (Atualizado NT2016.002)
   *
   * <h4>TAG N09 - ICMS70</h4><br>
   * N16 pICMS Al�quota do imposto E N09 N 1-1 3v2-4<br>
   * Al�quota do ICMS sem o FCP. Quando for o caso, informar a al�quota do FCP no campo pFCP.
   *
   * <h4>TAG N10 - ICMS90</h4><br>
   * N16 pICMS Al�quota do imposto E N12.1 N 1-1 3v2-4<br>
   * Al�quota do ICMS sem o FCP. Quando for o caso, informar a al�quota do FCP no campo pFCP (Atualizado NT2016.002)
   *
   */
  @RFWMetaBigDecimalField(caption = "Al�quota do ICMS", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = true)
  private BigDecimal picms = null;

  /**
   * <h4>TAG N02 - ICMS00</h4><br>
   * N17 vICMS Valor do ICMS E N02 N 1-1 13v2
   *
   * <h4>TAG N03 - ICMS10</h4><br>
   * N17 vICMS Valor do ICMS E N03 N 1-1 13v2
   *
   * <h4>TAG N04 - ICMS20</h4><br>
   * N17 vICMS Valor do ICMS E N04 N 1-1 13v2
   *
   * <h4>TAG N07 - ICMS51</h4><br>
   * N17 vICMS Valor do ICMS E N07 N 0-1 13v2<br>
   * Informar o valor realmente devido.
   *
   * <h4>TAG N09 - ICMS70</h4><br>
   * N17 vICMS Valor do ICMS E N09 N 1-1 13v2
   *
   * <h4>TAG N10 - ICMS90</h4><br>
   * N17 vICMS Valor do ICMS E N12.1 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = true)
  private BigDecimal vicms = null;

  /**
   * <h4>TAG N02 - ICMS00</h4><br>
   * N17b pFCP Percentual do ICMS relativo ao Fundo de Combate � Pobreza (FCP) E N17.1 N 1-1 3v2-4 <br>
   * Percentual relativo ao Fundo de Combate � Pobreza (FCP).
   *
   * <h4>TAG N03 - ICMS10</h4><br>
   * N17.b pFCP Percentual do Fundo de Combate � Pobreza (FCP) E N17.0 N 1-1 3v2-4<br>
   * Percentual relativo ao Fundo de Combate � Pobreza (FCP).
   *
   * <h4>TAG N04 - ICMS20</h4><br>
   * N17b pFCP Percentual do ICMS relativo ao Fundo de Combate � Pobreza (FCP) E N17.1 N 1-1 3v2-4 <Br>
   * Percentual relativo ao Fundo de Combate � Pobreza (FCP).
   *
   * <h4>TAG N07 - ICMS51</h4><br>
   * N17b pFCP Percentual do ICMS relativo ao Fundo de Combate � Pobreza (FCP) E N17.1 N 1-1 3v2-4<br>
   * Percentual relativo ao Fundo de Combate � Pobreza (FCP).
   *
   * <h4>TAG N09 - ICMS70</h4><br>
   * N17b pFCP Percentual do ICMS relativo ao Fundo de Combate � Pobreza (FCP) E N17.0 N 1-1 3v2-4<br>
   * Percentual relativo ao Fundo de Combate � Pobreza (FCP) retido por substitui��o tribut�ria.<br>
   * Nota: Percentual m�ximo de 2%, conforme a legisla��o
   *
   * <h4>TAG N10 - ICMS90</h4><br>
   * N17b pFCP Percentual do ICMS relativo ao Fundo de Combate � Pobreza (FCP) E N17.0 N 1-1 3v2-4<br>
   * Percentual relativo ao Fundo de Combate � Pobreza (FCP). Nota: Percentual m�ximo de 2%, conforme a legisla��o.
   *
   */
  @RFWMetaBigDecimalField(caption = "Percentual do ICMS relativo ao FCP", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = false)
  private BigDecimal pfcp = null;

  /**
   * <h4>TAG N02 - ICMS00</h4><br>
   * N17c vFCP Valor do Fundo de Combate � Pobreza (FCP) E N17.1 N 1-1 13v2 <br>
   * Valor do ICMS relativo ao Fundo de Combate � Pobreza (FCP).
   *
   * <h4>TAG N03 - ICMS10</h4><br>
   * N17.c vFCP Valor do Fundo de Combate � Pobreza (FCP) E N17.0 N 1-1 13v2 <br>
   * Valor do ICMS relativo ao Fundo de Combate � Pobreza (FCP).
   *
   * <h4>TAG N04 - ICMS20</h4><br>
   * N17c vFCP Valor do ICMS relativo ao Fundo de Combate � Pobreza (FCP) E N17.1 N 1-1 13v2 <br>
   * Valor do ICMS relativo ao Fundo de Combate � Pobreza (FCP).
   *
   * <h4>TAG N07 - ICMS51</h4><br>
   * N17c vFCP Valor do ICMS relativo ao Fundo de Combate � Pobreza (FCP) E N17.1 N 1-1 13v2<br>
   * Valor do ICMS relativo ao Fundo de Combate � Pobreza (FCP).
   *
   * <h4>TAG N09 - ICMS70</h4><br>
   * N17c vFCP Valor do ICMS relativo ao Fundo de Combate � Pobreza (FCP) E N17.0 N 1-1 13v2<br>
   * Valor do ICMS relativo ao Fundo de Combate � Pobreza (FCP) retido por substitui��o tribut�ria.
   *
   * <h4>TAG N10 - ICMS90</h4><br>
   * N17c vFCP Valor do ICMS relativo ao Fundo de Combate � Pobreza (FCP) E N17.0 N 1-1 13v2<br>
   * Valor do ICMS relativo ao Fundo de Combate � Pobreza (FCP).
   *
   */
  @RFWMetaBigDecimalField(caption = "Valor do FCP", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vfcp = null;

  /**
   * <h4>TAG N02 - ICMS00</h4><br>
   * N17.a vBCFCP Valor da Base de C�lculo do FCP E N17.0 N 1-1 13v2 <br>
   * Informar o valor da Base de C�lculo do FCP
   *
   * <h4>TAG N04 - ICMS20</h4><br>
   * N17a vBCFCP Valor da Base de C�lculo do FCP E N17.1 N 1-1 13v2<Br>
   * Informar o valor da Base de C�lculo do FCP
   *
   * <h4>TAG N07 - ICMS51</h4><br>
   * N17a vBCFCP Valor da Base de C�lculo do FCP E N17.1 N 1-1 13v2<br>
   * Informar o valor da Base de C�lculo do FCP
   *
   * <h4>TAG N09 - ICMS70</h4><br>
   * N17a vBCFCP Valor da Base de C�lculo do FCP E N17.0 N 1-1 13v2<br>
   * Informar o valor da Base de C�lculo do FCP retido anteriormente por ST
   *
   * <h4>TAG N10 - ICMS90</h4><br>
   * N17a vBCFCP Valor da Base de C�lculo do FCP E N17.0 N 1-1 13v2<br>
   * Informar o valor da Base de C�lculo do FCP
   */
  @RFWMetaBigDecimalField(caption = "Base C�lculo do FCP", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vbcFCP = null;

  /**
   * <h4>TAG N03 - ICMS10</h4><br>
   * N18 modBCST Modalidade de determina��o da BC do ICMS ST E N03 N 1-1 1 <br>
   * <li>0=Pre�o tabelado ou m�ximo sugerido
   * <li>1=Lista Negativa (valor)
   * <li>2=Lista Positiva (valor);
   * <li>3=Lista Neutra (valor)
   * <li>4=Margem Valor Agregado (%)
   * <li>5=Pauta (valor)
   * <li>6=Valor da Opera��o (NT 2019.001)
   *
   * <h4>TAG N05 - ICMS30</h4><br>
   * N18 modBCST Modalidade de determina��o da BC do ICMS ST E N05 N 1-1 1<br>
   * <li>0=Pre�o tabelado ou m�ximo sugerido;
   * <li>1=Lista Negativa (valor)
   * <li>2=Lista Positiva (valor)
   * <li>3=Lista Neutra (valor)
   * <li>4=Margem Valor Agregado (%)
   * <li>5=Pauta (valor)
   * <li>6 = Valor da Opera��o (NT 2019.001)
   *
   * <h4>TAG N09 - ICMS70</h4><br>
   * N18 modBCST Modalidade de determina��o da BC do ICMS ST E N09 N 1-1 1<br>
   * <li>0=Pre�o tabelado ou m�ximo sugerido
   * <li>1=Lista Negativa (valor)
   * <li>2=Lista Positiva (valor)
   * <li>3=Lista Neutra (valor)
   * <li>4=Margem Valor Agregado (%)
   * <li>5=Pauta (valor)
   *
   * <h4>TAG N10 - ICMS90</h4><br>
   * N18 modBCST Modalidade de determina��o da BC do ICMS ST E N17.1 N 1-1 1<br>
   * <li>0=Pre�o tabelado ou m�ximo sugerido
   * <li>1=Lista Negativa (valor)
   * <li>2=Lista Positiva (valor)
   * <li>3=Lista Neutra (valor)
   * <li>4=Margem Valor Agregado (%)
   * <li>5=Pauta (valor)
   */
  @RFWMetaStringField(caption = "Modalidade da BC do ICMS ST", minlength = 1, maxLength = 1, required = false, pattern = "^(0|1|2|3|4|5|6)$")
  private String modBCST = null;

  /**
   * <h4>TAG N03 - ICMS10</h4><br>
   * N19 pMVAST Percentual da margem de valor Adicionado do ICMS ST E N03 N 0-1 3v2-4
   *
   * <h4>TAG N05 - ICMS30</h4><br>
   * N19 pMVAST Percentual da margem de valor Adicionado do ICMS ST E N05 N 0-1 3v2-4
   *
   * <h4>TAG N09 - ICMS70</h4><br>
   * N19 pMVAST Percentual da margem de valor Adicionado do ICMS ST E N09 N 0-1 3v2-4
   *
   * <h4>TAG N10 - ICMS90</h4><br>
   * N19 pMVAST Percentual da margem de valor Adicionado do ICMS ST E N17.1 N 0-1 3v2-4
   */
  @RFWMetaBigDecimalField(caption = "Percentual MVA do ICMS ST", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = false)
  private BigDecimal pmvaST = null;

  /**
   * <h4>TAG N03 - ICMS10</h4><br>
   * N20 pRedBCST Percentual da Redu��o de BC do ICMS ST E N03 N 0-1 3v2-4
   *
   * <h4>TAG N05 - ICMS30</h4><br>
   * N20 pRedBCST Percentual da Redu��o de BC do ICMS ST E N05 N 0-1 3v2-4
   *
   * <h4>TAG N09 - ICMS70</h4><br>
   * N20 pRedBCST Percentual da Redu��o de BC do ICMS ST E N09 N 0-1 3v2-4
   *
   * <h4>TAG N10 - ICMS90</h4><br>
   * N20 pRedBCST Percentual da Redu��o de BC do ICMS ST E N17.1 N 0-1 3v2-4
   */
  @RFWMetaBigDecimalField(caption = "Percentual Redu��o BC do ICMS ST", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = false)
  private BigDecimal predBCST = null;

  /**
   * <h4>TAG N03 - ICMS10</h4><br>
   * N21 vBCST Valor da BC do ICMS ST E N03 N 1-1 13v2
   *
   * <h4>TAG N05 - ICMS30</h4><br>
   * N21 vBCST Valor da BC do ICMS ST E N05 N 1-1 13v2
   *
   * <h4>TAG N09 - ICMS70</h4><br>
   * N21 vBCST Valor da BC do ICMS ST E N09 N 1-1 13v2
   *
   * <h4>TAG N10 - ICMS90</h4><br>
   * N21 vBCST Valor da BC do ICMS ST E N17.1 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Base C�lculo do FCP", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vbcST = null;

  /**
   * <h4>TAG N03 - ICMS10</h4><br>
   * N22 pICMSST Al�quota do imposto do ICMS ST E N03 N 1-1 3v2-4 <br>
   * Al�quota do ICMS ST sem o FCP. Quando for o caso, informar a al�quota do FCP no campo pFCP
   *
   * <h4>TAG N05 - ICMS30</h4><br>
   * N22 pICMSST Al�quota do imposto do ICMS ST E N05 N 1-1 3v2-4<br>
   * Al�quota do ICMS ST sem o FCP. Quando for o caso, informar a al�quota do FCP no campo pFCP
   *
   * <h4>TAG N09 - ICMS70</h4><br>
   * N22 pICMSST Al�quota do imposto do ICMS ST E N09 N 1-1 3v2-4<br>
   * Al�quota do ICMS ST sem o FCP. Quando for o caso, informar a al�quota do FCP no campo pFCP (Atualizado NT2016.002)
   *
   * <h4>TAG N10 - ICMS90</h4><br>
   * N22 pICMSST Al�quota do imposto do ICMS ST E N17.1 N 1-1 3v2-4<br>
   * Al�quota do ICMS ST sem o FCP. Quando for o caso, informar a al�quota do FCP no campo pFCP (Atualizado NT2016.002)
   */
  @RFWMetaBigDecimalField(caption = "Aliquota do ICMS ST", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = false)
  private BigDecimal picmsST = null;

  /**
   * <h4>TAG N03 - ICMS10</h4><br>
   * N23 vICMSST Valor do ICMS ST E N03 N 1-1 13v2 <br>
   * Valor do ICMS ST retido
   *
   * <h4>TAG N05 - ICMS30</h4><br>
   * N23 vICMSST Valor do ICMS ST E N05 N 1-1 13v2 <br>
   * Valor do ICMS ST retido
   *
   * <h4>TAG N09 - ICMS70</h4><br>
   * N23 vICMSST Valor do ICMS ST E N09 N 1-1 13v2<br>
   * Valor do ICMS ST retido
   *
   * <h4>TAG N10 - ICMS90</h4><br>
   * N23 vICMSST Valor do ICMS ST E N17.1 N 1-1 13v2<br>
   * Valor do ICMS ST retido
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS ST", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vicmsST = null;

  /**
   * <h4>TAG N03 - ICMS10</h4><br>
   * N23a vBCFCPST Valor da Base de C�lculo do FCP retido por Substitui��o Tribut�ria E N23.1 N 1-1 13v2<br>
   * Informar o valor da Base de C�lculo do FCP retido por Substitui��o Tribut�ria
   *
   * <h4>TAG N05 - ICMS30</h4><br>
   * N23a vBCFCPST Valor da Base de C�lculo do FCP E N23.1 N 1-1 13v2<br>
   * Informar o valor da Base de C�lculo do FCP retido por Substitui��o Tribut�ria
   *
   * <h4>TAG N09 - ICMS70</h4><br>
   * N23a vBCFCPST Informar o valor da Base de C�lculo do FCP retido por Substitui��o Tribut�ria E N23.1 N 1-1 13v2<br>
   * Informar o valor da Base de C�lculo do FCP retido por Substitui��o Tribut�ria
   *
   * <h4>TAG N10 - ICMS90</h4><br>
   * N23.a vBCFCPST Valor da Base de C�lculo do FCP retido por Substitui��o Tribut�ria E N23.1 N 1-1 13v2<br>
   * Informar o valor da Base de C�lculo do FCP retido por Substitui��o Tribut�ria
   */
  @RFWMetaBigDecimalField(caption = "Valor BC do FCP ST", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vbcFCPST = null;

  /**
   * <h4>TAG N03 - ICMS10</h4><br>
   * N23b pFCPST Percentual do FCP retido por Substitui��o Tribut�ria E N23.1 N 1-1 3v2-4 <br>
   * Percentual relativo ao Fundo de Combate � Pobreza (FCP) retido por substitui��o tribut�ria.
   *
   * <h4>TAG N05 - ICMS30</h4><br>
   * N23b pFCPST Percentual do FCP retido por Substitui��o Tribut�ria E N23.1 N 1-1 3v2-4<br>
   * Percentual relativo ao Fundo de Combate � Pobreza (FCP) retido por substitui��o tribut�ria
   *
   * <h4>TAG N09 - ICMS70</h4><br>
   * N23b pFCPST Percentual do FCP retido por Substitui��o Tribut�ria E N23.1 N 1-1 3v2-4<br>
   * Percentual relativo ao Fundo de Combate � Pobreza (FCP) retido por substitui��o tribut�ria. Nota: Percentual m�ximo de 2%, conforme a legisla��o.
   *
   * <h4>TAG N10 - ICMS90</h4><br>
   * N23.b pFCPST Percentual do FCP retido por Substitui��o Tribut�ria E N23.1 N 1-1 3v2-4<br>
   * Percentual relativo ao Fundo de Combate � Pobreza (FCP) retido por substitui��o tribut�ria.
   */
  @RFWMetaBigDecimalField(caption = "Percentual do FCP ST", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = false)
  private BigDecimal pfcpST = null;

  /**
   * <h4>TAG N03 - ICMS10</h4><br>
   * N23d vFCPST Valor do FCP retido por Substitui��o Tribut�ria E N23.1 N 1-1 13v2 <br>
   * Valor do ICMS relativo ao Fundo de Combate � Pobreza (FCP) retido por substitui��o tribut�ria.
   *
   * <h4>TAG N05 - ICMS30</h4><br>
   * N23d vFCPST Valor do FCP retido por Substitui��o Tribut�ria E N23.1 N 1-1 13v2 <br>
   * Valor do ICMS relativo ao Fundo de Combate � Pobreza (FCP) retido por substitui��o tribut�ria.
   *
   * <h4>TAG N09 - ICMS70</h4><br>
   * N23d vFCPST Valor do FCP retido por Substitui��o Tribut�ria E N23.1 N 1-1 13v2<br>
   * Valor do ICMS relativo ao Fundo de Combate � Pobreza (FCP) retido por substitui��o tribut�ria.
   *
   * <h4>TAG N10 - ICMS90</h4><br>
   * N23.d vFCPST Valor do FCP retido por Substitui��o Tribut�ria E N23.1 N 1-1 13v2<br>
   * Valor do ICMS relativo ao Fundo de Combate � Pobreza (FCP) retido por substitui��o tribut�ria.
   */
  @RFWMetaBigDecimalField(caption = "Valor FCP ST", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vfcpST = null;

  /**
   * <h4>TAG N04 - ICMS20</h4><br>
   * N14 pRedBC Percentual da Redu��o de BC E N04 N 1-1 3v2-4
   *
   * <h4>TAG N07 - ICMS51</h4><br>
   * N14 pRedBC Percentual da Redu��o de BC E N07 N 0-1 3v2-4
   *
   * <h4>TAG N09 - ICMS70</h4><br>
   * N14 pRedBC Percentual da Redu��o de BC E N09 N 1-1 3v2-4
   *
   * <h4>TAG N10 - ICMS90</h4><br>
   * N14 pRedBC Percentual da Redu��o de BC E N12.1 N 0-1 3v2-4
   */
  @RFWMetaBigDecimalField(caption = "Percentual de Redu��o de BC", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = false)
  private BigDecimal predBC = null;

  /**
   * <h4>TAG N04 - ICMS20</h4><br>
   * N28a vICMSDeson Valor do ICMS desonerado E N27.1 N 1-1 13v2 <br>
   * Informar apenas nos motivos de desonera��o documentados abaixo.
   *
   * <h4>TAG N05 - ICMS30</h4><br>
   * N28a vICMSDeson Valor do ICMS desonerado E N27.1 N 1-1 13v2<br>
   * Informar apenas nos motivos de desonera��o documentados abaixo.
   *
   * <h4>TAG N06 - ICMS40</h4><br>
   * N28a vICMSDeson Valor do ICMS E N27.1 N 1-1 13v2<br>
   * Informar nas opera��es:
   * <li>a) com produtos beneficiados com a desonera��o condicional do ICMS.
   * <li>b) destinadas � SUFRAMA, informando-se o valor que seria devido se n�o houvesse isen��o.
   * <li>c) de venda a �rg�o da administra��o p�blica direta e suas funda��es e autarquias com isen��o do ICMS. (NT 2011/004
   * <li>d) demais casos solicitados pelo Fisco. (NT2016.002)
   *
   * <h4>TAG N09 - ICMS70</h4><br>
   * N28a vICMSDeson Valor do ICMS desonerado E N27.1 N 1-1 13v2<br>
   * Informar apenas nos motivos de desonera��o documentados abaixo.
   *
   * <h4>TAG N10 - ICMS90</h4><br>
   * N28a vICMSDeson Valor do ICMS desonerado E N27.1 N 1-1 13v2<br>
   * Informar apenas nos motivos de desonera��o documentados abaixo.
   */
  @RFWMetaBigDecimalField(caption = "Base C�lculo do FCP", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vicmsDeson = null;

  /**
   * <h4>TAG N04 - ICMS20</h4><br>
   * N28 motDesICMS Motivo da desonera��o do ICMS E N27.1 N 1-1 2 <Br>
   * Campo ser� preenchido quando o campo anterior estiver preenchido. Informar o motivo da desonera��o:
   * <li>3=Uso na agropecu�ria;
   * <li>9=Outros;
   * <li>12=�rg�o de fomento e desenvolvimento agropecu�rio. <Br>
   *
   * <h4>TAG N05 - ICMS30</h4><br>
   * N28 motDesICMS Motivo da desonera��o do ICMS E N27.1 N 1-1 2<br>
   * Campo ser� preenchido quando o campo anterior estiver preenchido. Informar o motivo da desonera��o:
   * <li>6=Utilit�rios e Motocicletas da Amaz�nia Ocidental e �reas de Livre Com�rcio (Resolu��o 714/88 e 790/94 � CONTRAN e suas altera��es);
   * <li>7=SUFRAMA;
   * <li>9=Outros;
   * <hr>
   * <u><b>Observa��o:</b></u> N�o foi definido um Patterno no meta dado deste atributo por n�o ter certeza do preenchimento, pois, as op��es incluem "3" mas o tamanho do campo est� fixo em "2" e n�o em "1-2" como o padr�o seguido no documento. Logo n�o est� claro se deve ser "3" ou "03" o preenchimento correto. Ao descobrir, corrigir o pattern do atributo para melhorar a valida��o.
   *
   * <h4>TAG N06 - ICMS40</h4><br>
   * N28 motDesICMS Motivo da desonera��o do ICMS E N27.1 N 1-1 2<bR>
   * Campo ser� preenchido quando o campo anterior estiver preenchido. Informar o motivo da desonera��o:
   * <li>1=T�xi;
   * <li>3=Produtor Agropecu�rio;
   * <li>4=Frotista/Locadora;
   * <li>5=Diplom�tico/Consular;
   * <li>6=Utilit�rios e Motocicletas da Amaz�nia Ocidental e �reas de Livre Com�rcio (Resolu��o 714/88 e 790/94 � CONTRAN e suas altera��es);
   * <li>7=SUFRAMA;
   * <li>8=Venda a �rg�o P�blico;
   * <li>9=Outros. (NT 2011/004);
   * <li>10=Deficiente Condutor (Conv�nio ICMS 38/12);
   * <li>11=Deficiente N�o Condutor (Conv�nio ICMS 38/12).
   * <li>16=Olimp�adas Rio 2016 (NT 2015.002);
   * <li>90=Solicitado pelo Fisco (NT2016.002) <br>
   * Revogada a partir da vers�o 3.10 a possibilidade de usar o motivo
   * <li>2=Deficiente F�sico
   *
   * <h4>TAG N09 - ICMS70</h4><br>
   * N28 motDesICMS Motivo da desonera��o do ICMS E N27.1 N 1-1 2<br>
   * Campo ser� preenchido quando o campo anterior estiver preenchido. Informar o motivo da desonera��o:<br>
   * <li>3=Uso na agropecu�ria
   * <li>9=Outros
   * <li>12=�rg�o de fomento e desenvolvimento agropecu�rio
   *
   * <h4>TAG N10 - ICMS90</h4><br>
   * N28 motDesICMS Motivo da desonera��o do ICMS E N27.1 N 1-1 2<br>
   * Campo ser� preenchido quando o campo anterior estiver preenchido. Informar o motivo da desonera��o:
   * <li>3=Uso na agropecu�ria;
   * <li>9=Outros;
   * <li>12=�rg�o de fomento e desenvolvimento agropecu�rio.
   */
  @RFWMetaStringField(caption = "Motivo da Desonera��o do ICMS", minlength = 1, maxLength = 2, required = false)
  private String motDesICMS = null;

  /**
   * <h4>TAG N07 - ICMS51</h4><br>
   * N16a vICMSOp Valor do ICMS da Opera��o E N07 N 0-1 13v2<br>
   * Valor como se n�o tivesse o diferimento
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS da Opera��o", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vicmsOp = null;

  /**
   * <h4>TAG N07 - ICMS51</h4><br>
   * N16b pDif Percentual do diferimento E N07 N 0-1 3v2-4<br>
   * No caso de diferimento total, informar o percentual de diferimento "100".
   */
  @RFWMetaBigDecimalField(caption = "Percentual do Diferimento", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = false)
  private BigDecimal pdif = null;

  /**
   * <h4>TAG N07 - ICMS51</h4><br>
   * N16c vICMSDif Valor do ICMS diferido E N07 N 0-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS Diferido", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vicmsDif = null;

  /**
   * <h4>TAG N08 - ICMS60</h4><br>
   * N26 vBCSTRet Valor da BC do ICMS ST retido E N25.1 N 1-1 13v2<br>
   * Valor da BC do ICMS ST cobrado anteriormente por ST (v2.0).<br>
   * O valor pode ser omitido quando a legisla��o n�o exigir a sua informa��o. (NT 2011/004)
   */
  @RFWMetaBigDecimalField(caption = "Valor da BC do ICMS ST Retido", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vbcSTRet = null;

  /**
   * <h4>TAG N08 - ICMS60</h4><br>
   * N26a pST Al�quota suportada pelo Consumidor Final E N25.1 N 1-1 3v2-4<br>
   * Deve ser informada a al�quota do c�lculo do ICMS-ST, j� incluso o FCP caso incida sobre a mercadoria. Exemplo: al�quota da mercadoria na venda ao consumidor final = 18% e 2% de FCP. A al�quota a ser informada no campo pST deve ser 20%. (Atualizado NT2016.002)
   */
  @RFWMetaBigDecimalField(caption = "Al�quota Suportada pelo Consumidor Final", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = false)
  private BigDecimal pst = null;

  /**
   * <h4>TAG N08 - ICMS60</h4><br>
   * N26b vICMSSubstituto Valor do ICMS pr�prio do Substituto E N25.1 N 0-1 13v2 <br>
   * Valor do ICMS Pr�prio do Substituto cobrado em opera��o anterior (Criado na NT 2018.005. Atualizado na 2018.005 v1.20)
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS Pr�prio do Substituto", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vicmsSubstituto = null;

  /**
   * <h4>TAG N08 - ICMS60</h4><br>
   * N27 vICMSSTRet Valor do ICMS ST retido E N25.1 N 1-1 13v2<br>
   * Valor do ICMS ST cobrado anteriormente por ST (v2.0). O valor pode ser omitido quando a legisla��o n�o exigir a sua informa��o. (NT 2011/004)
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS ST Retido", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vicmsSTRet = null;

  /**
   * <h4>TAG N08 - ICMS60</h4><br>
   * N27a vBCFCPSTRet Valor da Base de C�lculo do FCP retido anteriormente E N27.1 N 1-1 13v2 <br>
   * Informar o valor da Base de C�lculo do FCP retido anteriormente por ST
   */
  @RFWMetaBigDecimalField(caption = "BC do FCP Retido Anteriormente", minValue = "0", maxValue = "0", scale = 2, required = false)
  private BigDecimal vbcFCPSTRet = null;

  /**
   * <h4>TAG N08 - ICMS60</h4><br>
   * N27b pFCPSTRet Percentual do FCP retido anteriormente por Substitui��o Tribut�ria E N27.1 N 1-1 3v2-4 <br>
   * Percentual relativo ao Fundo de Combate � Pobreza (FCP) retido por substitui��o tribut�ria.
   */
  @RFWMetaBigDecimalField(caption = "Percentual do FCP Retido Anteriormente por ST", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = false)
  private BigDecimal pfcpSTRet = null;

  /**
   * <h4>TAG N08 - ICMS60</h4><br>
   * N27d vFCPSTRet Valor do FCP retido por Substitui��o Tribut�ria E N27.1 N 1-1 13v2<Br>
   * Valor do ICMS relativo ao Fundo de Combate � Pobreza (FCP) retido por substitui��o tribut�ria.
   */
  @RFWMetaBigDecimalField(caption = "Valor do FCP Retido por ST", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vfcpSTRet = null;

  /**
   * <h4>TAG N08 - ICMS60</h4><br>
   * N34 pRedBCEfet Percentual de redu��o da base de c�lculo efetiva E N33 N 1-1 3v2-4<br>
   * Percentual de redu��o, caso estivesse submetida ao regime comum de tributa��o, para obten��o da base de c�lculo efetiva (vBCEfet).<br>
   * Obs.: opcional a crit�rio da UF
   */
  @RFWMetaBigDecimalField(caption = "Percentual da Redu��o da Base de C�lculo Efetiva", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = false)
  private BigDecimal predBCEfet = null;

  /**
   * <h4>TAG N08 - ICMS60</h4><br>
   * N35 vBCEfet Valor da base de c�lculo efetiva E N33 N 1-1 13v2<br>
   * Valor da base de c�lculo que seria atribu�da � opera��o pr�pria do contribuinte substitu�do, caso estivesse submetida ao regime comum de tributa��o, obtida pelo produto do Vprod por (1- pRedBCEfet).<br>
   * Obs.: opcional a crit�rio da UF.
   */
  @RFWMetaBigDecimalField(caption = "Valor da BC Efetiva", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = true)
  private BigDecimal vbcEfet = null;

  /**
   * <h4>TAG N08 - ICMS60</h4><br>
   * N36 pICMSEfet Al�quota do ICMS efetiva E N33 N 1-1 3v2-4<br>
   * Al�quota do ICMS na opera��o a consumidor final, caso estivesse submetida ao regime comum de tributa��o. <br>
   * Obs.: opcional a crit�rio da UF.
   */
  @RFWMetaBigDecimalField(caption = "Al�quota do ICMS Efetiva", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = false)
  private BigDecimal picmsEfet = null;

  /**
   * <h4>TAG N08 - ICMS60</h4><br>
   * N37 vICMSEfet Valor do ICMS efetivo E N33 N 1-1 13v2<br>
   * Obtido pelo produto do valor do campo pICMSEfet pelo valor do campo vBCEfet, caso estivesse submetida ao regime comum de tributa��o. <br>
   * Obs.: opcional a crit�rio da UF.
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS Efetivo", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vicmsEfet = null;

}