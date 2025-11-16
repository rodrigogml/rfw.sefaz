package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Grupo W02 - ICMSTot: Totais referentes ao ICMS.
 * <p>
 * Ocorre 1-1 dentro do grupo W01 (total da NF-e).
 * <p>
 * O grupo de valores totais da NF-e deve ser informado com o somatório do campo correspondente dos itens.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_icmstot")
public class SEFAZICMSTotVO extends RFWVO {

  private static final long serialVersionUID = -2397540062424958813L;

  /**
   * {@link SEFAZTotalVO}
   */
  @RFWMetaRelationshipField(caption = "Total", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_total")
  private SEFAZTotalVO totalVO = null;

  /**
   * W03 - vBC: Base de Cálculo do ICMS. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura).
   */
  @RFWMetaBigDecimalField(caption = "vBC", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vbc;

  /**
   * W04 - vICMS: Valor Total do ICMS. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura).
   */
  @RFWMetaBigDecimalField(caption = "vICMS", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vicms;

  /**
   * W04a - vICMSDeson: Valor Total do ICMS desonerado. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura).
   */
  @RFWMetaBigDecimalField(caption = "vICMSDeson", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vicmsDeson;

  /**
   * W04c - vFCPUFDest: Valor total do ICMS relativo ao FCP da UF de destino. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional). Incluído na NT 2015/003.
   */
  @RFWMetaBigDecimalField(caption = "vFCPUFDest", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vfcpUFDest;

  /**
   * W04e - vICMSUFDest: Valor total do ICMS Interestadual para a UF de destino. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional). Já considera o valor do ICMS relativo ao FCP na UF de destino. Incluído na NT 2015/003.
   */
  @RFWMetaBigDecimalField(caption = "vICMSUFDest", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vicmsUFDest;

  /**
   * W04g - vICMSUFRemet: Valor total do ICMS Interestadual para a UF do remetente. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional). A partir de 2019 este valor será zero. Incluído na NT 2015/003.
   */
  @RFWMetaBigDecimalField(caption = "vICMSUFRemet", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vicmsUFRemet;

  /**
   * W04h - vFCP: Valor Total do FCP (Fundo de Combate à Pobreza). Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura). Corresponde ao total da soma dos campos id:N17c. Incluído na NT 2016.002.
   */
  @RFWMetaBigDecimalField(caption = "vFCP", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vfcp;

  /**
   * W05 - vBCST: Base de Cálculo do ICMS ST. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura).
   */
  @RFWMetaBigDecimalField(caption = "vBCST", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vbcST;

  /**
   * W06 - vST: Valor Total do ICMS ST. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura).
   */
  @RFWMetaBigDecimalField(caption = "vST", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vst;

  /**
   * W06a - vFCPST: Valor Total do FCP retido por substituição tributária. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura). Corresponde ao total da soma dos campos id:N23d. Incluído na NT 2016.002.
   */
  @RFWMetaBigDecimalField(caption = "vFCPST", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vfcpST;

  /**
   * W06b - vFCPSTRet: Valor Total do FCP retido anteriormente por ST. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura). Corresponde ao total da soma dos campos id:N27d. Incluído na NT 2016.002.
   */
  @RFWMetaBigDecimalField(caption = "vFCPSTRet", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vfcpSTRet;

  /**
   * W07 - vProd: Valor Total dos produtos e serviços. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   */
  @RFWMetaBigDecimalField(caption = "vProd", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vprod;

  /**
   * W08 - vFrete: Valor Total do Frete. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   */
  @RFWMetaBigDecimalField(caption = "vFrete", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vfrete;

  /**
   * W09 - vSeg: Valor Total do Seguro. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   */
  @RFWMetaBigDecimalField(caption = "vSeg", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vseg;

  /**
   * W10 - vDesc: Valor Total do Desconto. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   */
  @RFWMetaBigDecimalField(caption = "vDesc", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vdesc;

  /**
   * W11 - vII: Valor Total do Imposto de Importação (II). Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   */
  @RFWMetaBigDecimalField(caption = "vII", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vii;

  /**
   * W12 - vIPI: Valor Total do IPI. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   */
  @RFWMetaBigDecimalField(caption = "vIPI", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vipi;

  /**
   * W12a - vIPIDevol: Valor Total do IPI devolvido. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura quando usado). Deve ser informado quando preenchido o Grupo Tributos Devolvidos na emissão de NF-e de devolução (finNFe=4) em operações com não contribuintes do IPI. Corresponde ao total da soma dos campos id:UA04. Incluído na NT 2016.002.
   */
  @RFWMetaBigDecimalField(caption = "vIPIDevol", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vipiDevol;

  /**
   * W13 - vPIS: Valor do PIS. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   */
  @RFWMetaBigDecimalField(caption = "vPIS", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vpis;

  /**
   * W14 - vCOFINS: Valor da COFINS. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   */
  @RFWMetaBigDecimalField(caption = "vCOFINS", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vcofins;

  /**
   * W15 - vOutro: Outras Despesas acessórias. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   */
  @RFWMetaBigDecimalField(caption = "vOutro", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal voutro;

  /**
   * W16 - vNF: Valor Total da NF-e. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório). Vide regras de validação W16-xx no MOC.
   */
  @RFWMetaBigDecimalField(caption = "vNF", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vnf;

  /**
   * W16a - vTotTrib: Valor aproximado total de tributos federais, estaduais e municipais. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional). Incluído na NT 2013/003.
   */
  @RFWMetaBigDecimalField(caption = "vTotTrib", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vtotTrib;

  /**
   * # {@link SEFAZTotalVO}.
   *
   * @return the {@link SEFAZTotalVO}
   */
  public SEFAZTotalVO getTotalVO() {
    return totalVO;
  }

  /**
   * # {@link SEFAZTotalVO}.
   *
   * @param totalVO the new {@link SEFAZTotalVO}
   */
  public void setTotalVO(SEFAZTotalVO totalVO) {
    this.totalVO = totalVO;
  }

  /**
   * # w03 - vBC: Base de Cálculo do ICMS. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura).
   *
   * @return the w03 - vBC: Base de Cálculo do ICMS
   */
  public BigDecimal getVbc() {
    return vbc;
  }

  /**
   * # w03 - vBC: Base de Cálculo do ICMS. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura).
   *
   * @param vbc the new w03 - vBC: Base de Cálculo do ICMS
   */
  public void setVbc(BigDecimal vbc) {
    this.vbc = vbc;
  }

  /**
   * # w04 - vICMS: Valor Total do ICMS. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura).
   *
   * @return the w04 - vICMS: Valor Total do ICMS
   */
  public BigDecimal getVicms() {
    return vicms;
  }

  /**
   * # w04 - vICMS: Valor Total do ICMS. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura).
   *
   * @param vicms the new w04 - vICMS: Valor Total do ICMS
   */
  public void setVicms(BigDecimal vicms) {
    this.vicms = vicms;
  }

  /**
   * # w04a - vICMSDeson: Valor Total do ICMS desonerado. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura).
   *
   * @return the w04a - vICMSDeson: Valor Total do ICMS desonerado
   */
  public BigDecimal getVicmsDeson() {
    return vicmsDeson;
  }

  /**
   * # w04a - vICMSDeson: Valor Total do ICMS desonerado. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura).
   *
   * @param vicmsDeson the new w04a - vICMSDeson: Valor Total do ICMS desonerado
   */
  public void setVicmsDeson(BigDecimal vicmsDeson) {
    this.vicmsDeson = vicmsDeson;
  }

  /**
   * # w04c - vFCPUFDest: Valor total do ICMS relativo ao FCP da UF de destino. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional). Incluído na NT 2015/003.
   *
   * @return the w04c - vFCPUFDest: Valor total do ICMS relativo ao FCP da UF de destino
   */
  public BigDecimal getVfcpUFDest() {
    return vfcpUFDest;
  }

  /**
   * # w04c - vFCPUFDest: Valor total do ICMS relativo ao FCP da UF de destino. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional). Incluído na NT 2015/003.
   *
   * @param vfcpUFDest the new w04c - vFCPUFDest: Valor total do ICMS relativo ao FCP da UF de destino
   */
  public void setVfcpUFDest(BigDecimal vfcpUFDest) {
    this.vfcpUFDest = vfcpUFDest;
  }

  /**
   * # w04e - vICMSUFDest: Valor total do ICMS Interestadual para a UF de destino. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional). Já considera o valor do ICMS relativo ao FCP na UF de destino. Incluído na NT 2015/003.
   *
   * @return the w04e - vICMSUFDest: Valor total do ICMS Interestadual para a UF de destino
   */
  public BigDecimal getVicmsUFDest() {
    return vicmsUFDest;
  }

  /**
   * # w04e - vICMSUFDest: Valor total do ICMS Interestadual para a UF de destino. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional). Já considera o valor do ICMS relativo ao FCP na UF de destino. Incluído na NT 2015/003.
   *
   * @param vicmsUFDest the new w04e - vICMSUFDest: Valor total do ICMS Interestadual para a UF de destino
   */
  public void setVicmsUFDest(BigDecimal vicmsUFDest) {
    this.vicmsUFDest = vicmsUFDest;
  }

  /**
   * # w04g - vICMSUFRemet: Valor total do ICMS Interestadual para a UF do remetente. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional). A partir de 2019 este valor será zero. Incluído na NT 2015/003.
   *
   * @return the w04g - vICMSUFRemet: Valor total do ICMS Interestadual para a UF do remetente
   */
  public BigDecimal getVicmsUFRemet() {
    return vicmsUFRemet;
  }

  /**
   * # w04g - vICMSUFRemet: Valor total do ICMS Interestadual para a UF do remetente. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional). A partir de 2019 este valor será zero. Incluído na NT 2015/003.
   *
   * @param vicmsUFRemet the new w04g - vICMSUFRemet: Valor total do ICMS Interestadual para a UF do remetente
   */
  public void setVicmsUFRemet(BigDecimal vicmsUFRemet) {
    this.vicmsUFRemet = vicmsUFRemet;
  }

  /**
   * # w04h - vFCP: Valor Total do FCP (Fundo de Combate à Pobreza). Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura). Corresponde ao total da soma dos campos id:N17c. Incluído na NT 2016.002.
   *
   * @return the w04h - vFCP: Valor Total do FCP (Fundo de Combate à Pobreza)
   */
  public BigDecimal getVfcp() {
    return vfcp;
  }

  /**
   * # w04h - vFCP: Valor Total do FCP (Fundo de Combate à Pobreza). Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura). Corresponde ao total da soma dos campos id:N17c. Incluído na NT 2016.002.
   *
   * @param vfcp the new w04h - vFCP: Valor Total do FCP (Fundo de Combate à Pobreza)
   */
  public void setVfcp(BigDecimal vfcp) {
    this.vfcp = vfcp;
  }

  /**
   * # w05 - vBCST: Base de Cálculo do ICMS ST. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura).
   *
   * @return the w05 - vBCST: Base de Cálculo do ICMS ST
   */
  public BigDecimal getVbcST() {
    return vbcST;
  }

  /**
   * # w05 - vBCST: Base de Cálculo do ICMS ST. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura).
   *
   * @param vbcST the new w05 - vBCST: Base de Cálculo do ICMS ST
   */
  public void setVbcST(BigDecimal vbcST) {
    this.vbcST = vbcST;
  }

  /**
   * # w06 - vST: Valor Total do ICMS ST. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura).
   *
   * @return the w06 - vST: Valor Total do ICMS ST
   */
  public BigDecimal getVst() {
    return vst;
  }

  /**
   * # w06 - vST: Valor Total do ICMS ST. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura).
   *
   * @param vst the new w06 - vST: Valor Total do ICMS ST
   */
  public void setVst(BigDecimal vst) {
    this.vst = vst;
  }

  /**
   * # w06a - vFCPST: Valor Total do FCP retido por substituição tributária. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura). Corresponde ao total da soma dos campos id:N23d. Incluído na NT 2016.002.
   *
   * @return the w06a - vFCPST: Valor Total do FCP retido por substituição tributária
   */
  public BigDecimal getVfcpST() {
    return vfcpST;
  }

  /**
   * # w06a - vFCPST: Valor Total do FCP retido por substituição tributária. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura). Corresponde ao total da soma dos campos id:N23d. Incluído na NT 2016.002.
   *
   * @param vfcpST the new w06a - vFCPST: Valor Total do FCP retido por substituição tributária
   */
  public void setVfcpST(BigDecimal vfcpST) {
    this.vfcpST = vfcpST;
  }

  /**
   * # w06b - vFCPSTRet: Valor Total do FCP retido anteriormente por ST. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura). Corresponde ao total da soma dos campos id:N27d. Incluído na NT 2016.002.
   *
   * @return the w06b - vFCPSTRet: Valor Total do FCP retido anteriormente por ST
   */
  public BigDecimal getVfcpSTRet() {
    return vfcpSTRet;
  }

  /**
   * # w06b - vFCPSTRet: Valor Total do FCP retido anteriormente por ST. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura). Corresponde ao total da soma dos campos id:N27d. Incluído na NT 2016.002.
   *
   * @param vfcpSTRet the new w06b - vFCPSTRet: Valor Total do FCP retido anteriormente por ST
   */
  public void setVfcpSTRet(BigDecimal vfcpSTRet) {
    this.vfcpSTRet = vfcpSTRet;
  }

  /**
   * # w07 - vProd: Valor Total dos produtos e serviços. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   *
   * @return the w07 - vProd: Valor Total dos produtos e serviços
   */
  public BigDecimal getVprod() {
    return vprod;
  }

  /**
   * # w07 - vProd: Valor Total dos produtos e serviços. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   *
   * @param vprod the new w07 - vProd: Valor Total dos produtos e serviços
   */
  public void setVprod(BigDecimal vprod) {
    this.vprod = vprod;
  }

  /**
   * # w08 - vFrete: Valor Total do Frete. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   *
   * @return the w08 - vFrete: Valor Total do Frete
   */
  public BigDecimal getVfrete() {
    return vfrete;
  }

  /**
   * # w08 - vFrete: Valor Total do Frete. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   *
   * @param vfrete the new w08 - vFrete: Valor Total do Frete
   */
  public void setVfrete(BigDecimal vfrete) {
    this.vfrete = vfrete;
  }

  /**
   * # w09 - vSeg: Valor Total do Seguro. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   *
   * @return the w09 - vSeg: Valor Total do Seguro
   */
  public BigDecimal getVseg() {
    return vseg;
  }

  /**
   * # w09 - vSeg: Valor Total do Seguro. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   *
   * @param vseg the new w09 - vSeg: Valor Total do Seguro
   */
  public void setVseg(BigDecimal vseg) {
    this.vseg = vseg;
  }

  /**
   * # w10 - vDesc: Valor Total do Desconto. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   *
   * @return the w10 - vDesc: Valor Total do Desconto
   */
  public BigDecimal getVdesc() {
    return vdesc;
  }

  /**
   * # w10 - vDesc: Valor Total do Desconto. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   *
   * @param vdesc the new w10 - vDesc: Valor Total do Desconto
   */
  public void setVdesc(BigDecimal vdesc) {
    this.vdesc = vdesc;
  }

  /**
   * # w11 - vII: Valor Total do Imposto de Importação (II). Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   *
   * @return the w11 - vII: Valor Total do Imposto de Importação (II)
   */
  public BigDecimal getVii() {
    return vii;
  }

  /**
   * # w11 - vII: Valor Total do Imposto de Importação (II). Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   *
   * @param vii the new w11 - vII: Valor Total do Imposto de Importação (II)
   */
  public void setVii(BigDecimal vii) {
    this.vii = vii;
  }

  /**
   * # w12 - vIPI: Valor Total do IPI. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   *
   * @return the w12 - vIPI: Valor Total do IPI
   */
  public BigDecimal getVipi() {
    return vipi;
  }

  /**
   * # w12 - vIPI: Valor Total do IPI. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   *
   * @param vipi the new w12 - vIPI: Valor Total do IPI
   */
  public void setVipi(BigDecimal vipi) {
    this.vipi = vipi;
  }

  /**
   * # w12a - vIPIDevol: Valor Total do IPI devolvido. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura quando usado). Deve ser informado quando preenchido o Grupo Tributos Devolvidos na emissão de NF-e de devolução (finNFe=4) em operações com não contribuintes do IPI. Corresponde ao total da soma dos campos id:UA04. Incluído na NT 2016.002.
   *
   * @return the w12a - vIPIDevol: Valor Total do IPI devolvido
   */
  public BigDecimal getVipiDevol() {
    return vipiDevol;
  }

  /**
   * # w12a - vIPIDevol: Valor Total do IPI devolvido. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura quando usado). Deve ser informado quando preenchido o Grupo Tributos Devolvidos na emissão de NF-e de devolução (finNFe=4) em operações com não contribuintes do IPI. Corresponde ao total da soma dos campos id:UA04. Incluído na NT 2016.002.
   *
   * @param vipiDevol the new w12a - vIPIDevol: Valor Total do IPI devolvido
   */
  public void setVipiDevol(BigDecimal vipiDevol) {
    this.vipiDevol = vipiDevol;
  }

  /**
   * # w13 - vPIS: Valor do PIS. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   *
   * @return the w13 - vPIS: Valor do PIS
   */
  public BigDecimal getVpis() {
    return vpis;
  }

  /**
   * # w13 - vPIS: Valor do PIS. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   *
   * @param vpis the new w13 - vPIS: Valor do PIS
   */
  public void setVpis(BigDecimal vpis) {
    this.vpis = vpis;
  }

  /**
   * # w14 - vCOFINS: Valor da COFINS. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   *
   * @return the w14 - vCOFINS: Valor da COFINS
   */
  public BigDecimal getVcofins() {
    return vcofins;
  }

  /**
   * # w14 - vCOFINS: Valor da COFINS. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   *
   * @param vcofins the new w14 - vCOFINS: Valor da COFINS
   */
  public void setVcofins(BigDecimal vcofins) {
    this.vcofins = vcofins;
  }

  /**
   * # w15 - vOutro: Outras Despesas acessórias. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   *
   * @return the w15 - vOutro: Outras Despesas acessórias
   */
  public BigDecimal getVoutro() {
    return voutro;
  }

  /**
   * # w15 - vOutro: Outras Despesas acessórias. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório).
   *
   * @param voutro the new w15 - vOutro: Outras Despesas acessórias
   */
  public void setVoutro(BigDecimal voutro) {
    this.voutro = voutro;
  }

  /**
   * # w16 - vNF: Valor Total da NF-e. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório). Vide regras de validação W16-xx no MOC.
   *
   * @return the w16 - vNF: Valor Total da NF-e
   */
  public BigDecimal getVnf() {
    return vnf;
  }

  /**
   * # w16 - vNF: Valor Total da NF-e. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório). Vide regras de validação W16-xx no MOC.
   *
   * @param vnf the new w16 - vNF: Valor Total da NF-e
   */
  public void setVnf(BigDecimal vnf) {
    this.vnf = vnf;
  }

  /**
   * # w16a - vTotTrib: Valor aproximado total de tributos federais, estaduais e municipais. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional). Incluído na NT 2013/003.
   *
   * @return the w16a - vTotTrib: Valor aproximado total de tributos federais, estaduais e municipais
   */
  public BigDecimal getVtotTrib() {
    return vtotTrib;
  }

  /**
   * # w16a - vTotTrib: Valor aproximado total de tributos federais, estaduais e municipais. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional). Incluído na NT 2013/003.
   *
   * @param vtotTrib the new w16a - vTotTrib: Valor aproximado total de tributos federais, estaduais e municipais
   */
  public void setVtotTrib(BigDecimal vtotTrib) {
    this.vtotTrib = vtotTrib;
  }

}
