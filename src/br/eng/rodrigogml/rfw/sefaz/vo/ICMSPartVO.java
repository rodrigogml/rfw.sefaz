package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZICMSCST;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZModalidadeBaseCalculoICMS;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZModalidadeBaseCalculoICMSST;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZOrigemMercadoria;

/**
 * Representa o grupo {@code ICMSPart} (ID N10a) da NF-e.<br>
 * <br>
 * Grupo de Partilha do ICMS entre UF de origem e UF de destino ou UF definida em legislação específica, para operações interestaduais com consumidor final e partilha do imposto (v2.0).
 *
 * @author BIS DEVil
 * @since 1.0.0
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_icmspart")
public class ICMSPartVO extends RFWVO {

  private static final long serialVersionUID = 7695123456789012345L;

  /**
   * ID: N11<br>
   * Origem da mercadoria (campo {@code orig}).<br>
   * Valores conforme SEFAZ (0 a 8), indicando se o produto é nacional ou estrangeiro, com diferentes regras de conteúdo de importação.
   */
  @RFWMetaEnumField(caption = "Origem da mercadoria", required = false)
  private SEFAZOrigemMercadoria orig = null;

  /**
   * ID: N12<br>
   * Situação tributária do ICMS na partilha (campo {@code CST}).<br>
   * Para este grupo são utilizados principalmente:<br>
   * 10 = Tributada e com cobrança do ICMS por substituição tributária;<br>
   * 90 = Outros.<br>
   * Implementada na enum {@link SEFAZSituacaoTributariaICMS}.
   */
  @RFWMetaEnumField(caption = "Situação tributária ICMS", required = false)
  private SEFAZICMSCST cst = null;

  /**
   * ID: N13<br>
   * Modalidade de determinação da base de cálculo do ICMS (campo {@code modBC}).<br>
   * Utiliza a enum {@link SEFAZModalidadeDeterminacaoBCICMS} com as modalidades: margem de valor agregado, pauta (valor), preço tabelado máximo ou valor da operação.
   */
  @RFWMetaEnumField(caption = "Modalidade BC ICMS", required = false)
  private SEFAZModalidadeBaseCalculoICMS modBC = null;

  /**
   * ID: N15<br>
   * Valor da base de cálculo do ICMS (campo {@code vBC}).<br>
   * Tipo N, tamanho 13v2 (até 13 inteiros e 2 decimais).
   */
  @RFWMetaBigDecimalField(caption = "Base de cálculo ICMS", required = false, maxValue = "9999999999999.99", minValue = "0", scale = 2, absolute = true)
  private BigDecimal vBC = null;

  /**
   * ID: N14<br>
   * Percentual de redução da base de cálculo do ICMS (campo {@code pRedBC}).<br>
   * Tamanho 3v2-4 (até 3 inteiros e 2 a 4 casas decimais).
   */
  @RFWMetaBigDecimalField(caption = "Redução da BC ICMS (%)", required = false, maxValue = "999.9999", minValue = "0", scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pRedBC = null;

  /**
   * ID: N16<br>
   * Alíquota do ICMS (campo {@code pICMS}).<br>
   * Tamanho 3v2-4 (até 3 inteiros e 2 a 4 casas decimais).
   */
  @RFWMetaBigDecimalField(caption = "Alíquota ICMS (%)", required = false, maxValue = "999.9999", minValue = "0", scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pICMS = null;

  /**
   * ID: N17<br>
   * Valor do ICMS da operação própria (campo {@code vICMS}).<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor ICMS", required = false, maxValue = "9999999999999.99", minValue = "0", scale = 2, absolute = true)
  private BigDecimal vICMS = null;

  /**
   * ID: N18<br>
   * Modalidade de determinação da base de cálculo do ICMS ST (campo {@code modBCST}).<br>
   * Utiliza a enum {@link SEFAZModalidadeDeterminacaoBCICMSST} com modalidades como preço tabelado, listas positiva/negativa/neutra, margem de valor agregado e pauta.
   */
  @RFWMetaEnumField(caption = "Modalidade BC ICMS ST", required = false)
  private SEFAZModalidadeBaseCalculoICMSST modBCST = null;

  /**
   * ID: N19<br>
   * Percentual da margem de valor agregado do ICMS ST (campo {@code pMVAST}).<br>
   * Tamanho 3v2-4.
   */
  @RFWMetaBigDecimalField(caption = "MVA ICMS ST (%)", required = false, maxValue = "999.9999", minValue = "0", scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pMVAST = null;

  /**
   * ID: N20<br>
   * Percentual de redução da base de cálculo do ICMS ST (campo {@code pRedBCST}).<br>
   * Tamanho 3v2-4.
   */
  @RFWMetaBigDecimalField(caption = "Redução BC ICMS ST (%)", required = false, maxValue = "999.9999", minValue = "0", scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pRedBCST = null;

  /**
   * ID: N21<br>
   * Valor da base de cálculo do ICMS ST (campo {@code vBCST}).<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Base de cálculo ICMS ST", required = false, maxValue = "9999999999999.99", minValue = "0", scale = 2, absolute = true)
  private BigDecimal vBCST = null;

  /**
   * ID: N22<br>
   * Alíquota do ICMS ST (campo {@code pICMSST}).<br>
   * Tamanho 3v2-4.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota ICMS ST (%)", required = false, maxValue = "999.9999", minValue = "0", scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pICMSST = null;

  /**
   * ID: N23<br>
   * Valor do ICMS ST (campo {@code vICMSST}).<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor ICMS ST", required = false, maxValue = "9999999999999.99", minValue = "0", scale = 2, absolute = true)
  private BigDecimal vICMSST = null;

  /**
   * ID: N25<br>
   * Percentual para determinação do valor da base de cálculo da operação própria (campo {@code pBCOp}).<br>
   * Tamanho 3v2-4 (v2.0).
   */
  @RFWMetaBigDecimalField(caption = "Percentual BC operação própria (%)", required = false, maxValue = "999.9999", minValue = "0", scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pBCOp = null;

  /**
   * ID: N24<br>
   * UF para a qual é devido o ICMS ST da operação (campo {@code UFST}).<br>
   * Informar a sigla da UF (ou "EX" para exterior), sem pontuação.
   */
  @RFWMetaStringField(caption = "UF destino ICMS ST", required = false, maxLength = 2, minlength = 2, pattern = "^(AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|MT|MS|MG|PA|PB|PR|PE|PI|RJ|RN|RS|RO|RR|SC|SP|SE|TO|EX)")
  private String ufst = null;

  /**
   * # iD: N11<br>
   * Origem da mercadoria (campo {@code orig}).<br>
   * Valores conforme SEFAZ (0 a 8), indicando se o produto é nacional ou estrangeiro, com diferentes regras de conteúdo de importação.
   *
   * @return the iD: N11<br>
   *         Origem da mercadoria (campo {@code orig})
   */
  public SEFAZOrigemMercadoria getOrig() {
    return orig;
  }

  /**
   * # iD: N11<br>
   * Origem da mercadoria (campo {@code orig}).<br>
   * Valores conforme SEFAZ (0 a 8), indicando se o produto é nacional ou estrangeiro, com diferentes regras de conteúdo de importação.
   *
   * @param orig the new iD: N11<br>
   *          Origem da mercadoria (campo {@code orig})
   */
  public void setOrig(SEFAZOrigemMercadoria orig) {
    this.orig = orig;
  }

  /**
   * # iD: N12<br>
   * Situação tributária do ICMS na partilha (campo {@code CST}).<br>
   * Para este grupo são utilizados principalmente:<br>
   * 10 = Tributada e com cobrança do ICMS por substituição tributária;<br>
   * 90 = Outros.<br>
   * Implementada na enum {@link SEFAZSituacaoTributariaICMS}.
   *
   * @return the iD: N12<br>
   *         Situação tributária do ICMS na partilha (campo {@code CST})
   */
  public SEFAZICMSCST getCst() {
    return cst;
  }

  /**
   * # iD: N12<br>
   * Situação tributária do ICMS na partilha (campo {@code CST}).<br>
   * Para este grupo são utilizados principalmente:<br>
   * 10 = Tributada e com cobrança do ICMS por substituição tributária;<br>
   * 90 = Outros.<br>
   * Implementada na enum {@link SEFAZSituacaoTributariaICMS}.
   *
   * @param cst the new iD: N12<br>
   *          Situação tributária do ICMS na partilha (campo {@code CST})
   */
  public void setCst(SEFAZICMSCST cst) {
    this.cst = cst;
  }

  /**
   * # iD: N13<br>
   * Modalidade de determinação da base de cálculo do ICMS (campo {@code modBC}).<br>
   * Utiliza a enum {@link SEFAZModalidadeDeterminacaoBCICMS} com as modalidades: margem de valor agregado, pauta (valor), preço tabelado máximo ou valor da operação.
   *
   * @return the iD: N13<br>
   *         Modalidade de determinação da base de cálculo do ICMS (campo {@code modBC})
   */
  public SEFAZModalidadeBaseCalculoICMS getModBC() {
    return modBC;
  }

  /**
   * # iD: N13<br>
   * Modalidade de determinação da base de cálculo do ICMS (campo {@code modBC}).<br>
   * Utiliza a enum {@link SEFAZModalidadeDeterminacaoBCICMS} com as modalidades: margem de valor agregado, pauta (valor), preço tabelado máximo ou valor da operação.
   *
   * @param modBC the new iD: N13<br>
   *          Modalidade de determinação da base de cálculo do ICMS (campo {@code modBC})
   */
  public void setModBC(SEFAZModalidadeBaseCalculoICMS modBC) {
    this.modBC = modBC;
  }

  /**
   * # iD: N15<br>
   * Valor da base de cálculo do ICMS (campo {@code vBC}).<br>
   * Tipo N, tamanho 13v2 (até 13 inteiros e 2 decimais).
   *
   * @return the iD: N15<br>
   *         Valor da base de cálculo do ICMS (campo {@code vBC})
   */
  public BigDecimal getVBC() {
    return vBC;
  }

  /**
   * # iD: N15<br>
   * Valor da base de cálculo do ICMS (campo {@code vBC}).<br>
   * Tipo N, tamanho 13v2 (até 13 inteiros e 2 decimais).
   *
   * @param vBC the new iD: N15<br>
   *          Valor da base de cálculo do ICMS (campo {@code vBC})
   */
  public void setVBC(BigDecimal vBC) {
    this.vBC = vBC;
  }

  /**
   * # iD: N14<br>
   * Percentual de redução da base de cálculo do ICMS (campo {@code pRedBC}).<br>
   * Tamanho 3v2-4 (até 3 inteiros e 2 a 4 casas decimais).
   *
   * @return the iD: N14<br>
   *         Percentual de redução da base de cálculo do ICMS (campo {@code pRedBC})
   */
  public BigDecimal getPRedBC() {
    return pRedBC;
  }

  /**
   * # iD: N14<br>
   * Percentual de redução da base de cálculo do ICMS (campo {@code pRedBC}).<br>
   * Tamanho 3v2-4 (até 3 inteiros e 2 a 4 casas decimais).
   *
   * @param pRedBC the new iD: N14<br>
   *          Percentual de redução da base de cálculo do ICMS (campo {@code pRedBC})
   */
  public void setPRedBC(BigDecimal pRedBC) {
    this.pRedBC = pRedBC;
  }

  /**
   * # iD: N16<br>
   * Alíquota do ICMS (campo {@code pICMS}).<br>
   * Tamanho 3v2-4 (até 3 inteiros e 2 a 4 casas decimais).
   *
   * @return the iD: N16<br>
   *         Alíquota do ICMS (campo {@code pICMS})
   */
  public BigDecimal getPICMS() {
    return pICMS;
  }

  /**
   * # iD: N16<br>
   * Alíquota do ICMS (campo {@code pICMS}).<br>
   * Tamanho 3v2-4 (até 3 inteiros e 2 a 4 casas decimais).
   *
   * @param pICMS the new iD: N16<br>
   *          Alíquota do ICMS (campo {@code pICMS})
   */
  public void setPICMS(BigDecimal pICMS) {
    this.pICMS = pICMS;
  }

  /**
   * # iD: N17<br>
   * Valor do ICMS da operação própria (campo {@code vICMS}).<br>
   * Tamanho 13v2.
   *
   * @return the iD: N17<br>
   *         Valor do ICMS da operação própria (campo {@code vICMS})
   */
  public BigDecimal getVICMS() {
    return vICMS;
  }

  /**
   * # iD: N17<br>
   * Valor do ICMS da operação própria (campo {@code vICMS}).<br>
   * Tamanho 13v2.
   *
   * @param vICMS the new iD: N17<br>
   *          Valor do ICMS da operação própria (campo {@code vICMS})
   */
  public void setVICMS(BigDecimal vICMS) {
    this.vICMS = vICMS;
  }

  /**
   * # iD: N18<br>
   * Modalidade de determinação da base de cálculo do ICMS ST (campo {@code modBCST}).<br>
   * Utiliza a enum {@link SEFAZModalidadeDeterminacaoBCICMSST} com modalidades como preço tabelado, listas positiva/negativa/neutra, margem de valor agregado e pauta.
   *
   * @return the iD: N18<br>
   *         Modalidade de determinação da base de cálculo do ICMS ST (campo {@code modBCST})
   */
  public SEFAZModalidadeBaseCalculoICMSST getModBCST() {
    return modBCST;
  }

  /**
   * # iD: N18<br>
   * Modalidade de determinação da base de cálculo do ICMS ST (campo {@code modBCST}).<br>
   * Utiliza a enum {@link SEFAZModalidadeDeterminacaoBCICMSST} com modalidades como preço tabelado, listas positiva/negativa/neutra, margem de valor agregado e pauta.
   *
   * @param modBCST the new iD: N18<br>
   *          Modalidade de determinação da base de cálculo do ICMS ST (campo {@code modBCST})
   */
  public void setModBCST(SEFAZModalidadeBaseCalculoICMSST modBCST) {
    this.modBCST = modBCST;
  }

  /**
   * # iD: N19<br>
   * Percentual da margem de valor agregado do ICMS ST (campo {@code pMVAST}).<br>
   * Tamanho 3v2-4.
   *
   * @return the iD: N19<br>
   *         Percentual da margem de valor agregado do ICMS ST (campo {@code pMVAST})
   */
  public BigDecimal getPMVAST() {
    return pMVAST;
  }

  /**
   * # iD: N19<br>
   * Percentual da margem de valor agregado do ICMS ST (campo {@code pMVAST}).<br>
   * Tamanho 3v2-4.
   *
   * @param pMVAST the new iD: N19<br>
   *          Percentual da margem de valor agregado do ICMS ST (campo {@code pMVAST})
   */
  public void setPMVAST(BigDecimal pMVAST) {
    this.pMVAST = pMVAST;
  }

  /**
   * # iD: N20<br>
   * Percentual de redução da base de cálculo do ICMS ST (campo {@code pRedBCST}).<br>
   * Tamanho 3v2-4.
   *
   * @return the iD: N20<br>
   *         Percentual de redução da base de cálculo do ICMS ST (campo {@code pRedBCST})
   */
  public BigDecimal getPRedBCST() {
    return pRedBCST;
  }

  /**
   * # iD: N20<br>
   * Percentual de redução da base de cálculo do ICMS ST (campo {@code pRedBCST}).<br>
   * Tamanho 3v2-4.
   *
   * @param pRedBCST the new iD: N20<br>
   *          Percentual de redução da base de cálculo do ICMS ST (campo {@code pRedBCST})
   */
  public void setPRedBCST(BigDecimal pRedBCST) {
    this.pRedBCST = pRedBCST;
  }

  /**
   * # iD: N21<br>
   * Valor da base de cálculo do ICMS ST (campo {@code vBCST}).<br>
   * Tamanho 13v2.
   *
   * @return the iD: N21<br>
   *         Valor da base de cálculo do ICMS ST (campo {@code vBCST})
   */
  public BigDecimal getVBCST() {
    return vBCST;
  }

  /**
   * # iD: N21<br>
   * Valor da base de cálculo do ICMS ST (campo {@code vBCST}).<br>
   * Tamanho 13v2.
   *
   * @param vBCST the new iD: N21<br>
   *          Valor da base de cálculo do ICMS ST (campo {@code vBCST})
   */
  public void setVBCST(BigDecimal vBCST) {
    this.vBCST = vBCST;
  }

  /**
   * # iD: N22<br>
   * Alíquota do ICMS ST (campo {@code pICMSST}).<br>
   * Tamanho 3v2-4.
   *
   * @return the iD: N22<br>
   *         Alíquota do ICMS ST (campo {@code pICMSST})
   */
  public BigDecimal getPICMSST() {
    return pICMSST;
  }

  /**
   * # iD: N22<br>
   * Alíquota do ICMS ST (campo {@code pICMSST}).<br>
   * Tamanho 3v2-4.
   *
   * @param pICMSST the new iD: N22<br>
   *          Alíquota do ICMS ST (campo {@code pICMSST})
   */
  public void setPICMSST(BigDecimal pICMSST) {
    this.pICMSST = pICMSST;
  }

  /**
   * # iD: N23<br>
   * Valor do ICMS ST (campo {@code vICMSST}).<br>
   * Tamanho 13v2.
   *
   * @return the iD: N23<br>
   *         Valor do ICMS ST (campo {@code vICMSST})
   */
  public BigDecimal getVICMSST() {
    return vICMSST;
  }

  /**
   * # iD: N23<br>
   * Valor do ICMS ST (campo {@code vICMSST}).<br>
   * Tamanho 13v2.
   *
   * @param vICMSST the new iD: N23<br>
   *          Valor do ICMS ST (campo {@code vICMSST})
   */
  public void setVICMSST(BigDecimal vICMSST) {
    this.vICMSST = vICMSST;
  }

  /**
   * # iD: N25<br>
   * Percentual para determinação do valor da base de cálculo da operação própria (campo {@code pBCOp}).<br>
   * Tamanho 3v2-4 (v2.0).
   *
   * @return the iD: N25<br>
   *         Percentual para determinação do valor da base de cálculo da operação própria (campo {@code pBCOp})
   */
  public BigDecimal getPBCOp() {
    return pBCOp;
  }

  /**
   * # iD: N25<br>
   * Percentual para determinação do valor da base de cálculo da operação própria (campo {@code pBCOp}).<br>
   * Tamanho 3v2-4 (v2.0).
   *
   * @param pBCOp the new iD: N25<br>
   *          Percentual para determinação do valor da base de cálculo da operação própria (campo {@code pBCOp})
   */
  public void setPBCOp(BigDecimal pBCOp) {
    this.pBCOp = pBCOp;
  }

  /**
   * # iD: N24<br>
   * UF para a qual é devido o ICMS ST da operação (campo {@code UFST}).<br>
   * Informar a sigla da UF (ou "EX" para exterior), sem pontuação.
   *
   * @return the iD: N24<br>
   *         UF para a qual é devido o ICMS ST da operação (campo {@code UFST})
   */
  public String getUfst() {
    return ufst;
  }

  /**
   * # iD: N24<br>
   * UF para a qual é devido o ICMS ST da operação (campo {@code UFST}).<br>
   * Informar a sigla da UF (ou "EX" para exterior), sem pontuação.
   *
   * @param ufst the new iD: N24<br>
   *          UF para a qual é devido o ICMS ST da operação (campo {@code UFST})
   */
  public void setUfst(String ufst) {
    this.ufst = ufst;
  }

}
