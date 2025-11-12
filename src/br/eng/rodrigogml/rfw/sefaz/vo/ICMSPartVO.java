package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CST_ICMS;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_modBC;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_orig;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_modBCST;

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
  private SEFAZ_orig orig = null;

  /**
   * ID: N12<br>
   * Situação tributária do ICMS na partilha (campo {@code CST}).<br>
   * Para este grupo são utilizados principalmente:<br>
   * 10 = Tributada e com cobrança do ICMS por substituição tributária;<br>
   * 90 = Outros.<br>
   * Implementada na enum {@link SEFAZSituacaoTributariaICMS}.
   */
  @RFWMetaEnumField(caption = "Situação tributária ICMS", required = false)
  private SEFAZ_CST_ICMS cst = null;

  /**
   * ID: N13<br>
   * Modalidade de determinação da base de cálculo do ICMS (campo {@code modBC}).<br>
   * Utiliza a enum {@link SEFAZModalidadeDeterminacaoBCICMS} com as modalidades: margem de valor agregado, pauta (valor), preço tabelado máximo ou valor da operação.
   */
  @RFWMetaEnumField(caption = "Modalidade BC ICMS", required = false)
  private SEFAZ_modBC modBC = null;

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
  private SEFAZ_modBCST modBCST = null;

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

}
