package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Description: Grupo de informações do ICMS Interestadual para consumidor final não contribuinte (TAG {@code ICMSUFDest}, ID NA01).<br>
 * Criado pela NT 2015/003 e atualizado em versões posteriores do MOC 7.0.<br>
 * <br>
 *
 * Este grupo é utilizado em operações interestaduais com partilha do ICMS devido entre as UFs de origem e de destino (ou UF definida em legislação).<br>
 * <b>Não deve ser utilizado nas operações com veículos automotores novos</b> que possuam grupo próprio (ICMSPart).<br>
 *
 * @author BIS DEVil
 * @since (11 de nov. de 2025)
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_icmsufdest")
public class ICMSUFDestVO extends RFWVO {

  private static final long serialVersionUID = 1054876659154076543L;

  /**
   * ID: NA03<br>
   * Valor da Base de Cálculo do ICMS na UF de destino (vBCUFDest).<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "BC ICMS UF Destino", required = false, scale = 2, absolute = true)
  private BigDecimal vBCUFDest = null;

  /**
   * ID: NA04<br>
   * Valor da Base de Cálculo do FCP na UF de destino (vBCFCPUFDest).<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "BC FCP UF Destino", required = false, scale = 2, absolute = true)
  private BigDecimal vBCFCPUFDest = null;

  /**
   * ID: NA05<br>
   * Percentual do ICMS relativo ao Fundo de Combate à Pobreza (FCP) na UF de destino (pFCPUFDest).<br>
   * Percentual máximo de 2%, conforme legislação vigente.<br>
   * Tamanho 3v2-4.
   */
  @RFWMetaBigDecimalField(caption = "Perc. FCP UF Destino", required = false, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pFCPUFDest = null;

  /**
   * ID: NA07<br>
   * Alíquota interna da UF de destino (pICMSUFDest).<br>
   * Tamanho 3v2-4.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota interna UF Destino", required = false, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pICMSUFDest = null;

  /**
   * ID: NA09<br>
   * Alíquota interestadual das UF envolvidas (pICMSInter).<br>
   * Valores usuais: 4%, 7% ou 12%, conforme origem/destino.<br>
   * Tamanho 3v2-4.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota interestadual", required = false, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pICMSInter = null;

  /**
   * ID: NA11<br>
   * Percentual provisório de partilha do ICMS Interestadual (pICMSInterPart).<br>
   * Percentuais variáveis conforme o ano:
   * <ul>
   * <li>40% em 2016</li>
   * <li>60% em 2017</li>
   * <li>80% em 2018</li>
   * <li>100% a partir de 2019</li>
   * </ul>
   * Tamanho 3v2-4.
   */
  @RFWMetaBigDecimalField(caption = "Perc. partilha ICMS Inter", required = false, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pICMSInterPart = null;

  /**
   * ID: NA13<br>
   * Valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP) da UF de destino (vFCPUFDest).<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor FCP UF Destino", required = false, scale = 2, absolute = true)
  private BigDecimal vFCPUFDest = null;

  /**
   * ID: NA15<br>
   * Valor do ICMS Interestadual para a UF de destino (vICMSUFDest).<br>
   * Corresponde ao valor do ICMS a ser recolhido para a UF de destino.<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor ICMS UF Destino", required = false, scale = 2, absolute = true)
  private BigDecimal vICMSUFDest = null;

  /**
   * ID: NA17<br>
   * Valor do ICMS Interestadual para a UF de origem (vICMSUFRemet).<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor ICMS UF Remetente", required = false, scale = 2, absolute = true)
  private BigDecimal vICMSUFRemet = null;

}
