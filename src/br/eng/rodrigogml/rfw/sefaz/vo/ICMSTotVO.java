package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Description: Totais referentes ao ICMS e valores globais da NF-e (TAG {@code ICMSTot}, ID W02).<br>
 * Este grupo consolida os totais monetários calculados a partir dos itens da NF-e, incluindo:
 * <ul>
 * <li>Base de cálculo e valor do ICMS próprio e do ICMS-ST;</li>
 * <li>ICMS desonerado e valores relacionados ao FCP (Fundo de Combate à Pobreza);</li>
 * <li>Totais de produtos/serviços, frete, seguro, descontos, II, IPI, PIS e COFINS;</li>
 * <li>Valor total da NF-e e valor aproximado de tributos ({@code vTotTrib}).</li>
 * </ul>
 * Todos os campos seguem o layout da NF-e – MOC 7.0 – Anexo I, seção de totais (ID W02 a W16a).
 *
 * @author BIS DEVil
 * @since (11 de nov. de 2025)
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_icmstot")
public class ICMSTotVO extends RFWVO {

  private static final long serialVersionUID = 5925518140468169540L;

  /**
   * ID: W03 – {@code vBC}<br>
   * Base de cálculo do ICMS próprio da NF-e.<br>
   * Corresponde ao somatório das bases de cálculo de ICMS dos itens (tag N15).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   */
  @RFWMetaBigDecimalField(caption = "BC ICMS", required = false, scale = 2, minValue = "0", absolute = true)
  private BigDecimal vBC = null;

  /**
   * ID: W04 – {@code vICMS}<br>
   * Valor total do ICMS próprio da NF-e.<br>
   * Corresponde ao somatório dos valores de ICMS dos itens (tag N17).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   */
  @RFWMetaBigDecimalField(caption = "ICMS total", required = false, scale = 2, minValue = "0", absolute = true)
  private BigDecimal vICMS = null;

  /**
   * ID: W04a – {@code vICMSDeson}<br>
   * Valor total do ICMS desonerado na NF-e.<br>
   * Somatório dos valores de ICMS desonerado informados por item (tag N28a).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   */
  @RFWMetaBigDecimalField(caption = "ICMS desonerado", required = false, scale = 2, minValue = "0", absolute = true)
  private BigDecimal vICMSDeson = null;

  /**
   * ID: W04c – {@code vFCPUFDest}<br>
   * Valor total do FCP devido à UF de destino.<br>
   * Somatório dos valores de FCP-UF destino calculados por item (tags N17c / N23d, conforme o tipo de ICMS).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   */
  @RFWMetaBigDecimalField(caption = "FCP UF destino", required = false, scale = 2, minValue = "0", absolute = true)
  private BigDecimal vFCPUFDest = null;

  /**
   * ID: W04e – {@code vICMSUFDest}<br>
   * Valor total do ICMS relativo à UF de destino.<br>
   * Utilizado nas operações interestaduais com partilha de ICMS para consumidor final.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   */
  @RFWMetaBigDecimalField(caption = "ICMS UF destino", required = false, scale = 2, minValue = "0", absolute = true)
  private BigDecimal vICMSUFDest = null;

  /**
   * ID: W04g – {@code vICMSUFRemet}<br>
   * Valor total do ICMS relativo à UF de origem/remetente.<br>
   * Complementa a partilha de ICMS nas operações interestaduais com consumidor final.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   */
  @RFWMetaBigDecimalField(caption = "ICMS UF remetente", required = false, scale = 2, minValue = "0", absolute = true)
  private BigDecimal vICMSUFRemet = null;

  /**
   * ID: W05 – {@code vBCST}<br>
   * Base de cálculo do ICMS ST (substituição tributária) da NF-e.<br>
   * Somatório das bases de cálculo de ICMS-ST dos itens (tag N21).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   */
  @RFWMetaBigDecimalField(caption = "BC ICMS ST", required = false, scale = 2, minValue = "0", absolute = true)
  private BigDecimal vBCST = null;

  /**
   * ID: W06 – {@code vST}<br>
   * Valor total do ICMS ST da NF-e.<br>
   * Somatório dos valores de ICMS-ST dos itens (tag N23).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   */
  @RFWMetaBigDecimalField(caption = "ICMS ST total", required = false, scale = 2, minValue = "0", absolute = true)
  private BigDecimal vST = null;

  /**
   * ID: W06a – {@code vFCPST}<br>
   * Valor total do FCP retido por substituição tributária.<br>
   * Corresponde ao somatório dos valores de FCP-ST dos itens (tag N23d).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   */
  @RFWMetaBigDecimalField(caption = "FCP ST", required = false, scale = 2, minValue = "0", absolute = true)
  private BigDecimal vFCPST = null;

  /**
   * ID: W06b – {@code vFCPSTRet}<br>
   * Valor total do FCP-ST retido anteriormente por substituição tributária.<br>
   * Somatório de {@code vFCPSTRet} informados nos itens (tag N27d).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   */
  @RFWMetaBigDecimalField(caption = "FCP ST retido ant.", required = false, scale = 2, minValue = "0", absolute = true)
  private BigDecimal vFCPSTRet = null;

  /**
   * ID: W07 – {@code vProd}<br>
   * Valor total bruto dos produtos e serviços da NF-e.<br>
   * Somatório dos valores {@code vProd} de cada item (tag I11).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   */
  @RFWMetaBigDecimalField(caption = "Total produtos/serviços", required = false, scale = 2, minValue = "0", absolute = true)
  private BigDecimal vProd = null;

  /**
   * ID: W08 – {@code vFrete}<br>
   * Valor total do frete da NF-e.<br>
   * Somatório dos valores de frete atribuídos por item ou informados em nível de documento.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   */
  @RFWMetaBigDecimalField(caption = "Total frete", required = false, scale = 2, minValue = "0", absolute = true)
  private BigDecimal vFrete = null;

  /**
   * ID: W09 – {@code vSeg}<br>
   * Valor total do seguro da NF-e.<br>
   * Somatório dos valores de seguro relacionados aos itens ou ao documento.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   */
  @RFWMetaBigDecimalField(caption = "Total seguro", required = false, scale = 2, minValue = "0", absolute = true)
  private BigDecimal vSeg = null;

  /**
   * ID: W10 – {@code vDesc}<br>
   * Valor total dos descontos concedidos na NF-e.<br>
   * Somatório dos descontos informados por item (tag I17) e/ou em nível de documento.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   */
  @RFWMetaBigDecimalField(caption = "Total descontos", required = false, scale = 2, minValue = "0", absolute = true)
  private BigDecimal vDesc = null;

  /**
   * ID: W11 – {@code vII}<br>
   * Valor total do Imposto de Importação agregado à NF-e.<br>
   * Somatório dos valores de II dos itens importados.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   */
  @RFWMetaBigDecimalField(caption = "Total II", required = false, scale = 2, minValue = "0", absolute = true)
  private BigDecimal vII = null;

  /**
   * ID: W12 – {@code vIPI}<br>
   * Valor total do IPI na NF-e.<br>
   * Somatório dos valores de IPI próprios dos itens (tags O14/O25, conforme enquadramento).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   */
  @RFWMetaBigDecimalField(caption = "Total IPI", required = false, scale = 2, minValue = "0", absolute = true)
  private BigDecimal vIPI = null;

  /**
   * ID: W12a – {@code vIPIDevol}<br>
   * Valor total do IPI devolvido.<br>
   * Deve ser informado quando preenchido o grupo de tributos devolvidos na operação (finNFe = 4, devolução de mercadoria).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   */
  @RFWMetaBigDecimalField(caption = "Total IPI devolvido", required = false, scale = 2, minValue = "0", absolute = true)
  private BigDecimal vIPIDevol = null;

  /**
   * ID: W13 – {@code vPIS}<br>
   * Valor total do PIS na NF-e.<br>
   * Somatório dos valores de PIS dos itens (tags R03/R06, conforme tipo de cálculo).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   */
  @RFWMetaBigDecimalField(caption = "Total PIS", required = false, scale = 2, minValue = "0", absolute = true)
  private BigDecimal vPIS = null;

  /**
   * ID: W14 – {@code vCOFINS}<br>
   * Valor total da COFINS na NF-e.<br>
   * Somatório dos valores de COFINS dos itens (tags S03/S06, conforme tipo de cálculo).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   */
  @RFWMetaBigDecimalField(caption = "Total COFINS", required = false, scale = 2, minValue = "0", absolute = true)
  private BigDecimal vCOFINS = null;

  /**
   * ID: W15 – {@code vOutro}<br>
   * Valor total de outras despesas acessórias da NF-e.<br>
   * Utilizado para valores que não se enquadram em frete, seguro ou descontos, mas compõem o valor total da nota.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   */
  @RFWMetaBigDecimalField(caption = "Outras despesas", required = false, scale = 2, minValue = "0", absolute = true)
  private BigDecimal vOutro = null;

  /**
   * ID: W16 – {@code vNF}<br>
   * Valor total da NF-e.<br>
   * Composto por: {@code vProd + vFrete + vSeg + vOutro + vII + vIPI - vDesc} e outros componentes definidos pela legislação, incluindo ICMS-ST e FCP, quando aplicável.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   */
  @RFWMetaBigDecimalField(caption = "Valor total da NF-e", required = false, scale = 2, minValue = "0", absolute = true)
  private BigDecimal vNF = null;

  /**
   * ID: W16a – {@code vTotTrib}<br>
   * Valor aproximado total de tributos federais, estaduais e municipais.<br>
   * Informado de acordo com a Lei da Transparência dos Tributos (Lei nº 12.741/2012) e legislação estadual/municipal pertinente.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   */
  @RFWMetaBigDecimalField(caption = "Valor aprox. tributos", required = false, scale = 2, minValue = "0", absolute = true)
  private BigDecimal vTotTrib = null;

  /**
   * # iD: W03 – {@code vBC}<br>
   * Base de cálculo do ICMS próprio da NF-e.<br>
   * Corresponde ao somatório das bases de cálculo de ICMS dos itens (tag N15).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @return the iD: W03 – {@code vBC}<br>
   *         Base de cálculo do ICMS próprio da NF-e
   */
  public BigDecimal getVBC() {
    return vBC;
  }

  /**
   * # iD: W03 – {@code vBC}<br>
   * Base de cálculo do ICMS próprio da NF-e.<br>
   * Corresponde ao somatório das bases de cálculo de ICMS dos itens (tag N15).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @param vBC the new iD: W03 – {@code vBC}<br>
   *          Base de cálculo do ICMS próprio da NF-e
   */
  public void setVBC(BigDecimal vBC) {
    this.vBC = vBC;
  }

  /**
   * # iD: W04 – {@code vICMS}<br>
   * Valor total do ICMS próprio da NF-e.<br>
   * Corresponde ao somatório dos valores de ICMS dos itens (tag N17).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @return the iD: W04 – {@code vICMS}<br>
   *         Valor total do ICMS próprio da NF-e
   */
  public BigDecimal getVICMS() {
    return vICMS;
  }

  /**
   * # iD: W04 – {@code vICMS}<br>
   * Valor total do ICMS próprio da NF-e.<br>
   * Corresponde ao somatório dos valores de ICMS dos itens (tag N17).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @param vICMS the new iD: W04 – {@code vICMS}<br>
   *          Valor total do ICMS próprio da NF-e
   */
  public void setVICMS(BigDecimal vICMS) {
    this.vICMS = vICMS;
  }

  /**
   * # iD: W04a – {@code vICMSDeson}<br>
   * Valor total do ICMS desonerado na NF-e.<br>
   * Somatório dos valores de ICMS desonerado informados por item (tag N28a).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @return the iD: W04a – {@code vICMSDeson}<br>
   *         Valor total do ICMS desonerado na NF-e
   */
  public BigDecimal getVICMSDeson() {
    return vICMSDeson;
  }

  /**
   * # iD: W04a – {@code vICMSDeson}<br>
   * Valor total do ICMS desonerado na NF-e.<br>
   * Somatório dos valores de ICMS desonerado informados por item (tag N28a).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @param vICMSDeson the new iD: W04a – {@code vICMSDeson}<br>
   *          Valor total do ICMS desonerado na NF-e
   */
  public void setVICMSDeson(BigDecimal vICMSDeson) {
    this.vICMSDeson = vICMSDeson;
  }

  /**
   * # iD: W04c – {@code vFCPUFDest}<br>
   * Valor total do FCP devido à UF de destino.<br>
   * Somatório dos valores de FCP-UF destino calculados por item (tags N17c / N23d, conforme o tipo de ICMS).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @return the iD: W04c – {@code vFCPUFDest}<br>
   *         Valor total do FCP devido à UF de destino
   */
  public BigDecimal getVFCPUFDest() {
    return vFCPUFDest;
  }

  /**
   * # iD: W04c – {@code vFCPUFDest}<br>
   * Valor total do FCP devido à UF de destino.<br>
   * Somatório dos valores de FCP-UF destino calculados por item (tags N17c / N23d, conforme o tipo de ICMS).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @param vFCPUFDest the new iD: W04c – {@code vFCPUFDest}<br>
   *          Valor total do FCP devido à UF de destino
   */
  public void setVFCPUFDest(BigDecimal vFCPUFDest) {
    this.vFCPUFDest = vFCPUFDest;
  }

  /**
   * # iD: W04e – {@code vICMSUFDest}<br>
   * Valor total do ICMS relativo à UF de destino.<br>
   * Utilizado nas operações interestaduais com partilha de ICMS para consumidor final.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @return the iD: W04e – {@code vICMSUFDest}<br>
   *         Valor total do ICMS relativo à UF de destino
   */
  public BigDecimal getVICMSUFDest() {
    return vICMSUFDest;
  }

  /**
   * # iD: W04e – {@code vICMSUFDest}<br>
   * Valor total do ICMS relativo à UF de destino.<br>
   * Utilizado nas operações interestaduais com partilha de ICMS para consumidor final.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @param vICMSUFDest the new iD: W04e – {@code vICMSUFDest}<br>
   *          Valor total do ICMS relativo à UF de destino
   */
  public void setVICMSUFDest(BigDecimal vICMSUFDest) {
    this.vICMSUFDest = vICMSUFDest;
  }

  /**
   * # iD: W04g – {@code vICMSUFRemet}<br>
   * Valor total do ICMS relativo à UF de origem/remetente.<br>
   * Complementa a partilha de ICMS nas operações interestaduais com consumidor final.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @return the iD: W04g – {@code vICMSUFRemet}<br>
   *         Valor total do ICMS relativo à UF de origem/remetente
   */
  public BigDecimal getVICMSUFRemet() {
    return vICMSUFRemet;
  }

  /**
   * # iD: W04g – {@code vICMSUFRemet}<br>
   * Valor total do ICMS relativo à UF de origem/remetente.<br>
   * Complementa a partilha de ICMS nas operações interestaduais com consumidor final.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @param vICMSUFRemet the new iD: W04g – {@code vICMSUFRemet}<br>
   *          Valor total do ICMS relativo à UF de origem/remetente
   */
  public void setVICMSUFRemet(BigDecimal vICMSUFRemet) {
    this.vICMSUFRemet = vICMSUFRemet;
  }

  /**
   * # iD: W05 – {@code vBCST}<br>
   * Base de cálculo do ICMS ST (substituição tributária) da NF-e.<br>
   * Somatório das bases de cálculo de ICMS-ST dos itens (tag N21).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @return the iD: W05 – {@code vBCST}<br>
   *         Base de cálculo do ICMS ST (substituição tributária) da NF-e
   */
  public BigDecimal getVBCST() {
    return vBCST;
  }

  /**
   * # iD: W05 – {@code vBCST}<br>
   * Base de cálculo do ICMS ST (substituição tributária) da NF-e.<br>
   * Somatório das bases de cálculo de ICMS-ST dos itens (tag N21).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @param vBCST the new iD: W05 – {@code vBCST}<br>
   *          Base de cálculo do ICMS ST (substituição tributária) da NF-e
   */
  public void setVBCST(BigDecimal vBCST) {
    this.vBCST = vBCST;
  }

  /**
   * # iD: W06 – {@code vST}<br>
   * Valor total do ICMS ST da NF-e.<br>
   * Somatório dos valores de ICMS-ST dos itens (tag N23).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @return the iD: W06 – {@code vST}<br>
   *         Valor total do ICMS ST da NF-e
   */
  public BigDecimal getVST() {
    return vST;
  }

  /**
   * # iD: W06 – {@code vST}<br>
   * Valor total do ICMS ST da NF-e.<br>
   * Somatório dos valores de ICMS-ST dos itens (tag N23).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @param vST the new iD: W06 – {@code vST}<br>
   *          Valor total do ICMS ST da NF-e
   */
  public void setVST(BigDecimal vST) {
    this.vST = vST;
  }

  /**
   * # iD: W06a – {@code vFCPST}<br>
   * Valor total do FCP retido por substituição tributária.<br>
   * Corresponde ao somatório dos valores de FCP-ST dos itens (tag N23d).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @return the iD: W06a – {@code vFCPST}<br>
   *         Valor total do FCP retido por substituição tributária
   */
  public BigDecimal getVFCPST() {
    return vFCPST;
  }

  /**
   * # iD: W06a – {@code vFCPST}<br>
   * Valor total do FCP retido por substituição tributária.<br>
   * Corresponde ao somatório dos valores de FCP-ST dos itens (tag N23d).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @param vFCPST the new iD: W06a – {@code vFCPST}<br>
   *          Valor total do FCP retido por substituição tributária
   */
  public void setVFCPST(BigDecimal vFCPST) {
    this.vFCPST = vFCPST;
  }

  /**
   * # iD: W06b – {@code vFCPSTRet}<br>
   * Valor total do FCP-ST retido anteriormente por substituição tributária.<br>
   * Somatório de {@code vFCPSTRet} informados nos itens (tag N27d).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @return the iD: W06b – {@code vFCPSTRet}<br>
   *         Valor total do FCP-ST retido anteriormente por substituição tributária
   */
  public BigDecimal getVFCPSTRet() {
    return vFCPSTRet;
  }

  /**
   * # iD: W06b – {@code vFCPSTRet}<br>
   * Valor total do FCP-ST retido anteriormente por substituição tributária.<br>
   * Somatório de {@code vFCPSTRet} informados nos itens (tag N27d).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @param vFCPSTRet the new iD: W06b – {@code vFCPSTRet}<br>
   *          Valor total do FCP-ST retido anteriormente por substituição tributária
   */
  public void setVFCPSTRet(BigDecimal vFCPSTRet) {
    this.vFCPSTRet = vFCPSTRet;
  }

  /**
   * # iD: W07 – {@code vProd}<br>
   * Valor total bruto dos produtos e serviços da NF-e.<br>
   * Somatório dos valores {@code vProd} de cada item (tag I11).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @return the iD: W07 – {@code vProd}<br>
   *         Valor total bruto dos produtos e serviços da NF-e
   */
  public BigDecimal getVProd() {
    return vProd;
  }

  /**
   * # iD: W07 – {@code vProd}<br>
   * Valor total bruto dos produtos e serviços da NF-e.<br>
   * Somatório dos valores {@code vProd} de cada item (tag I11).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @param vProd the new iD: W07 – {@code vProd}<br>
   *          Valor total bruto dos produtos e serviços da NF-e
   */
  public void setVProd(BigDecimal vProd) {
    this.vProd = vProd;
  }

  /**
   * # iD: W08 – {@code vFrete}<br>
   * Valor total do frete da NF-e.<br>
   * Somatório dos valores de frete atribuídos por item ou informados em nível de documento.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @return the iD: W08 – {@code vFrete}<br>
   *         Valor total do frete da NF-e
   */
  public BigDecimal getVFrete() {
    return vFrete;
  }

  /**
   * # iD: W08 – {@code vFrete}<br>
   * Valor total do frete da NF-e.<br>
   * Somatório dos valores de frete atribuídos por item ou informados em nível de documento.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @param vFrete the new iD: W08 – {@code vFrete}<br>
   *          Valor total do frete da NF-e
   */
  public void setVFrete(BigDecimal vFrete) {
    this.vFrete = vFrete;
  }

  /**
   * # iD: W09 – {@code vSeg}<br>
   * Valor total do seguro da NF-e.<br>
   * Somatório dos valores de seguro relacionados aos itens ou ao documento.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @return the iD: W09 – {@code vSeg}<br>
   *         Valor total do seguro da NF-e
   */
  public BigDecimal getVSeg() {
    return vSeg;
  }

  /**
   * # iD: W09 – {@code vSeg}<br>
   * Valor total do seguro da NF-e.<br>
   * Somatório dos valores de seguro relacionados aos itens ou ao documento.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @param vSeg the new iD: W09 – {@code vSeg}<br>
   *          Valor total do seguro da NF-e
   */
  public void setVSeg(BigDecimal vSeg) {
    this.vSeg = vSeg;
  }

  /**
   * # iD: W10 – {@code vDesc}<br>
   * Valor total dos descontos concedidos na NF-e.<br>
   * Somatório dos descontos informados por item (tag I17) e/ou em nível de documento.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @return the iD: W10 – {@code vDesc}<br>
   *         Valor total dos descontos concedidos na NF-e
   */
  public BigDecimal getVDesc() {
    return vDesc;
  }

  /**
   * # iD: W10 – {@code vDesc}<br>
   * Valor total dos descontos concedidos na NF-e.<br>
   * Somatório dos descontos informados por item (tag I17) e/ou em nível de documento.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @param vDesc the new iD: W10 – {@code vDesc}<br>
   *          Valor total dos descontos concedidos na NF-e
   */
  public void setVDesc(BigDecimal vDesc) {
    this.vDesc = vDesc;
  }

  /**
   * # iD: W11 – {@code vII}<br>
   * Valor total do Imposto de Importação agregado à NF-e.<br>
   * Somatório dos valores de II dos itens importados.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @return the iD: W11 – {@code vII}<br>
   *         Valor total do Imposto de Importação agregado à NF-e
   */
  public BigDecimal getVII() {
    return vII;
  }

  /**
   * # iD: W11 – {@code vII}<br>
   * Valor total do Imposto de Importação agregado à NF-e.<br>
   * Somatório dos valores de II dos itens importados.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @param vII the new iD: W11 – {@code vII}<br>
   *          Valor total do Imposto de Importação agregado à NF-e
   */
  public void setVII(BigDecimal vII) {
    this.vII = vII;
  }

  /**
   * # iD: W12 – {@code vIPI}<br>
   * Valor total do IPI na NF-e.<br>
   * Somatório dos valores de IPI próprios dos itens (tags O14/O25, conforme enquadramento).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @return the iD: W12 – {@code vIPI}<br>
   *         Valor total do IPI na NF-e
   */
  public BigDecimal getVIPI() {
    return vIPI;
  }

  /**
   * # iD: W12 – {@code vIPI}<br>
   * Valor total do IPI na NF-e.<br>
   * Somatório dos valores de IPI próprios dos itens (tags O14/O25, conforme enquadramento).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @param vIPI the new iD: W12 – {@code vIPI}<br>
   *          Valor total do IPI na NF-e
   */
  public void setVIPI(BigDecimal vIPI) {
    this.vIPI = vIPI;
  }

  /**
   * # iD: W12a – {@code vIPIDevol}<br>
   * Valor total do IPI devolvido.<br>
   * Deve ser informado quando preenchido o grupo de tributos devolvidos na operação (finNFe = 4, devolução de mercadoria).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @return the iD: W12a – {@code vIPIDevol}<br>
   *         Valor total do IPI devolvido
   */
  public BigDecimal getVIPIDevol() {
    return vIPIDevol;
  }

  /**
   * # iD: W12a – {@code vIPIDevol}<br>
   * Valor total do IPI devolvido.<br>
   * Deve ser informado quando preenchido o grupo de tributos devolvidos na operação (finNFe = 4, devolução de mercadoria).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @param vIPIDevol the new iD: W12a – {@code vIPIDevol}<br>
   *          Valor total do IPI devolvido
   */
  public void setVIPIDevol(BigDecimal vIPIDevol) {
    this.vIPIDevol = vIPIDevol;
  }

  /**
   * # iD: W13 – {@code vPIS}<br>
   * Valor total do PIS na NF-e.<br>
   * Somatório dos valores de PIS dos itens (tags R03/R06, conforme tipo de cálculo).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @return the iD: W13 – {@code vPIS}<br>
   *         Valor total do PIS na NF-e
   */
  public BigDecimal getVPIS() {
    return vPIS;
  }

  /**
   * # iD: W13 – {@code vPIS}<br>
   * Valor total do PIS na NF-e.<br>
   * Somatório dos valores de PIS dos itens (tags R03/R06, conforme tipo de cálculo).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @param vPIS the new iD: W13 – {@code vPIS}<br>
   *          Valor total do PIS na NF-e
   */
  public void setVPIS(BigDecimal vPIS) {
    this.vPIS = vPIS;
  }

  /**
   * # iD: W14 – {@code vCOFINS}<br>
   * Valor total da COFINS na NF-e.<br>
   * Somatório dos valores de COFINS dos itens (tags S03/S06, conforme tipo de cálculo).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @return the iD: W14 – {@code vCOFINS}<br>
   *         Valor total da COFINS na NF-e
   */
  public BigDecimal getVCOFINS() {
    return vCOFINS;
  }

  /**
   * # iD: W14 – {@code vCOFINS}<br>
   * Valor total da COFINS na NF-e.<br>
   * Somatório dos valores de COFINS dos itens (tags S03/S06, conforme tipo de cálculo).<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @param vCOFINS the new iD: W14 – {@code vCOFINS}<br>
   *          Valor total da COFINS na NF-e
   */
  public void setVCOFINS(BigDecimal vCOFINS) {
    this.vCOFINS = vCOFINS;
  }

  /**
   * # iD: W15 – {@code vOutro}<br>
   * Valor total de outras despesas acessórias da NF-e.<br>
   * Utilizado para valores que não se enquadram em frete, seguro ou descontos, mas compõem o valor total da nota.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @return the iD: W15 – {@code vOutro}<br>
   *         Valor total de outras despesas acessórias da NF-e
   */
  public BigDecimal getVOutro() {
    return vOutro;
  }

  /**
   * # iD: W15 – {@code vOutro}<br>
   * Valor total de outras despesas acessórias da NF-e.<br>
   * Utilizado para valores que não se enquadram em frete, seguro ou descontos, mas compõem o valor total da nota.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @param vOutro the new iD: W15 – {@code vOutro}<br>
   *          Valor total de outras despesas acessórias da NF-e
   */
  public void setVOutro(BigDecimal vOutro) {
    this.vOutro = vOutro;
  }

  /**
   * # iD: W16 – {@code vNF}<br>
   * Valor total da NF-e.<br>
   * Composto por: {@code vProd + vFrete + vSeg + vOutro + vII + vIPI - vDesc} e outros componentes definidos pela legislação, incluindo ICMS-ST e FCP, quando aplicável.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @return the iD: W16 – {@code vNF}<br>
   *         Valor total da NF-e
   */
  public BigDecimal getVNF() {
    return vNF;
  }

  /**
   * # iD: W16 – {@code vNF}<br>
   * Valor total da NF-e.<br>
   * Composto por: {@code vProd + vFrete + vSeg + vOutro + vII + vIPI - vDesc} e outros componentes definidos pela legislação, incluindo ICMS-ST e FCP, quando aplicável.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @param vNF the new iD: W16 – {@code vNF}<br>
   *          Valor total da NF-e
   */
  public void setVNF(BigDecimal vNF) {
    this.vNF = vNF;
  }

  /**
   * # iD: W16a – {@code vTotTrib}<br>
   * Valor aproximado total de tributos federais, estaduais e municipais.<br>
   * Informado de acordo com a Lei da Transparência dos Tributos (Lei nº 12.741/2012) e legislação estadual/municipal pertinente.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @return the iD: W16a – {@code vTotTrib}<br>
   *         Valor aproximado total de tributos federais, estaduais e municipais
   */
  public BigDecimal getVTotTrib() {
    return vTotTrib;
  }

  /**
   * # iD: W16a – {@code vTotTrib}<br>
   * Valor aproximado total de tributos federais, estaduais e municipais.<br>
   * Informado de acordo com a Lei da Transparência dos Tributos (Lei nº 12.741/2012) e legislação estadual/municipal pertinente.<br>
   * Tamanho: 13v2 – valor monetário não negativo.
   *
   * @param vTotTrib the new iD: W16a – {@code vTotTrib}<br>
   *          Valor aproximado total de tributos federais, estaduais e municipais
   */
  public void setVTotTrib(BigDecimal vTotTrib) {
    this.vTotTrib = vTotTrib;
  }
}
