package br.eng.rodrigogml.rfw.sefaz.vos;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "total" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class TotalVO extends RFWVO {

  private static final long serialVersionUID = -5922872338549423712L;

  /**
   * W03 vBC Base de Cálculo do ICMS E W02 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "BC do ICMS", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = true)
  private BigDecimal vbc = null;

  /**
   * W04 vICMS Valor Total do ICMS E W02 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Total do ICMS", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = true)
  private BigDecimal vicms = null;

  /**
   * W04a vICMSDeson Valor Total do ICMS desonerado E W02 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Total ICMS Desonerado", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = true)
  private BigDecimal vicmsDeson = null;

  /**
   * W04c vFCPUFDest Valor total do ICMS relativo Fundo de Combate à Pobreza (FCP) da UF de destino E W02 N 0-1 13v2<br>
   * Valor total do ICMS relativo ao Fundo de Combate à Pobreza (FCP) para a UF de destino. (Incluído na NT 2015/003)
   */
  @RFWMetaBigDecimalField(caption = "Total ICMS Relativo FCP", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = false)
  private BigDecimal vfcpUFDest = null;

  /**
   * W04e vICMSUFDest Valor total do ICMS Interestadual para a UF de destino E W02 N 0-1 13v2<br>
   * Valor total do ICMS Interestadual para a UF de destino, já considerando o valor do ICMS relativo ao Fundo de Combate à Pobreza naquela UF. (Incluído na NT 2015/003)
   */
  @RFWMetaBigDecimalField(caption = "Total ICMS Interstadual UF Destino", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = false)
  private BigDecimal vicmsUFDest = null;

  /**
   * W04g vICMSUFRemet Valor total do ICMS Interestadual para a UF do remetente E W02 N 0-1 13v2<br>
   * Valor total do ICMS Interestadual para a UF do remetente. Nota: A partir de 2019, este valor será zero. (Incluído na NT 2015/003)
   */
  @RFWMetaBigDecimalField(caption = "Total ICMS Interstadual UF Remetente", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = false)
  private BigDecimal vicmsUFRemet = null;

  /**
   * W04h vFCP Valor Total do FCP (Fundo de Combate à Pobreza) E W02 N 1-1 13v2<br>
   * Corresponde ao total da soma dos campos id: N17c (Incluído na NT2016.002)
   */
  @RFWMetaBigDecimalField(caption = "Total FCP", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = true)
  private BigDecimal vfcp = null;

  /**
   * W05 vBCST Base de Cálculo do ICMS ST E W02 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "BC do ICMS ST", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = true)
  private BigDecimal vbcST = null;

  /**
   * W06 vST Valor Total do ICMS ST E W02 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Total ICMS ST", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = true)
  private BigDecimal vst = null;

  /**
   * W06a vFCPST Valor Total do FCP (Fundo de Combate à Pobreza) retido por substituição tributária E W02 N 1-1 13v2<br>
   * Corresponde ao total da soma dos campos id:N23d (Incluído na NT2016.002)
   */
  @RFWMetaBigDecimalField(caption = "Total FCP Retido por ST", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = true)
  private BigDecimal vfcpST = null;

  /**
   * W06b vFCPSTRet Valor Total do FCP retido anteriormente por Substituição Tributária E W02 N 1-1 13v2<br>
   * Corresponde ao total da soma dos campos id:N27d (Incluído na NT2016.002)
   */
  @RFWMetaBigDecimalField(caption = "Total FCP Retido Anteriormente por ST", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = true)
  private BigDecimal vfcpSTRet = null;

  /**
   * W07 vProd Valor Total dos produtos e serviços E W02 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Total de Produtos e Serviços", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = true)
  private BigDecimal vprod = null;

  /**
   * W08 vFrete Valor Total do Frete E W02 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Total do Frete", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = true)
  private BigDecimal vfrete = null;

  /**
   * W09 vSeg Valor Total do Seguro E W02 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Total do Seguro", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = true)
  private BigDecimal vseg = null;

  /**
   * W10 vDesc Valor Total do Desconto E W02 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Total do Desconto", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = true)
  private BigDecimal vdesc = null;

  /**
   * W11 vII Valor Total do II E W02 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Total do Imposto de Importação", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = true)
  private BigDecimal vii = null;

  /**
   * W12 vIPI Valor Total do IPI E W02 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Total do IPI", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = true)
  private BigDecimal vipi = null;

  /**
   * W12a vIPIDevol Valor Total do IPI devolvido E W02 N 1-1 13v2<br>
   * Deve ser informado quando preenchido o Grupo Tributos Devolvidos na emissão de nota finNFe=4 (devolução) nas operações com não contribuintes do IPI. Corresponde ao total da soma dos campos id:UA04. (Incluído na NT2016.002)
   */
  @RFWMetaBigDecimalField(caption = "Total do IPI Devolvido", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = true)
  private BigDecimal vipiDevol = null;

  /**
   * W13 vPIS Valor do PIS E W02 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Total do PIS", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = true)
  private BigDecimal vpis = null;

  /**
   * W14 vCOFINS Valor da COFINS E W02 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Total do COFINS", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = true)
  private BigDecimal vcofins = null;

  /**
   * W15 vOutro Outras Despesas acessórias E W02 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Outras Despesas Acessórias", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = true)
  private BigDecimal voutro = null;

  /**
   * W16 vNF Valor Total da NF-e E W02 N 1-1 13v2<br>
   * Vide validação para este campo na regra de validação "W16-xx".
   */
  @RFWMetaBigDecimalField(caption = "Valor Total da NFe", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = true)
  private BigDecimal vnf = null;

  /**
   * W16a vTotTrib Valor aproximado total de tributos federais, estaduais e municipais. E W02 N 0-1 13v2<br>
   * (NT 2013/003)
   */
  @RFWMetaBigDecimalField(caption = "Valor Aproximado dos Tributos", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = false)
  private BigDecimal vtotTrib = null;

  /**
   * # w03 vBC Base de Cálculo do ICMS E W02 N 1-1 13v2.
   *
   * @return # w03 vBC Base de Cálculo do ICMS E W02 N 1-1 13v2
   */
  public BigDecimal getVbc() {
    return vbc;
  }

  /**
   * # w03 vBC Base de Cálculo do ICMS E W02 N 1-1 13v2.
   *
   * @param vbc # w03 vBC Base de Cálculo do ICMS E W02 N 1-1 13v2
   */
  public void setVbc(BigDecimal vbc) {
    this.vbc = vbc;
  }

  /**
   * # w04 vICMS Valor Total do ICMS E W02 N 1-1 13v2.
   *
   * @return # w04 vICMS Valor Total do ICMS E W02 N 1-1 13v2
   */
  public BigDecimal getVicms() {
    return vicms;
  }

  /**
   * # w04 vICMS Valor Total do ICMS E W02 N 1-1 13v2.
   *
   * @param vicms # w04 vICMS Valor Total do ICMS E W02 N 1-1 13v2
   */
  public void setVicms(BigDecimal vicms) {
    this.vicms = vicms;
  }

  /**
   * # w04a vICMSDeson Valor Total do ICMS desonerado E W02 N 1-1 13v2.
   *
   * @return # w04a vICMSDeson Valor Total do ICMS desonerado E W02 N 1-1 13v2
   */
  public BigDecimal getVicmsDeson() {
    return vicmsDeson;
  }

  /**
   * # w04a vICMSDeson Valor Total do ICMS desonerado E W02 N 1-1 13v2.
   *
   * @param vicmsDeson # w04a vICMSDeson Valor Total do ICMS desonerado E W02 N 1-1 13v2
   */
  public void setVicmsDeson(BigDecimal vicmsDeson) {
    this.vicmsDeson = vicmsDeson;
  }

  /**
   * # w04c vFCPUFDest Valor total do ICMS relativo Fundo de Combate à Pobreza (FCP) da UF de destino E W02 N 0-1 13v2<br>
   * Valor total do ICMS relativo ao Fundo de Combate à Pobreza (FCP) para a UF de destino. (Incluído na NT 2015/003).
   *
   * @return # w04c vFCPUFDest Valor total do ICMS relativo Fundo de Combate à Pobreza (FCP) da UF de destino E W02 N 0-1 13v2<br>
   *         Valor total do ICMS relativo ao Fundo de Combate à Pobreza (FCP) para a UF de destino
   */
  public BigDecimal getVfcpUFDest() {
    return vfcpUFDest;
  }

  /**
   * # w04c vFCPUFDest Valor total do ICMS relativo Fundo de Combate à Pobreza (FCP) da UF de destino E W02 N 0-1 13v2<br>
   * Valor total do ICMS relativo ao Fundo de Combate à Pobreza (FCP) para a UF de destino. (Incluído na NT 2015/003).
   *
   * @param vfcpUFDest # w04c vFCPUFDest Valor total do ICMS relativo Fundo de Combate à Pobreza (FCP) da UF de destino E W02 N 0-1 13v2<br>
   *          Valor total do ICMS relativo ao Fundo de Combate à Pobreza (FCP) para a UF de destino
   */
  public void setVfcpUFDest(BigDecimal vfcpUFDest) {
    this.vfcpUFDest = vfcpUFDest;
  }

  /**
   * # w04e vICMSUFDest Valor total do ICMS Interestadual para a UF de destino E W02 N 0-1 13v2<br>
   * Valor total do ICMS Interestadual para a UF de destino, já considerando o valor do ICMS relativo ao Fundo de Combate à Pobreza naquela UF. (Incluído na NT 2015/003).
   *
   * @return # w04e vICMSUFDest Valor total do ICMS Interestadual para a UF de destino E W02 N 0-1 13v2<br>
   *         Valor total do ICMS Interestadual para a UF de destino, já considerando o valor do ICMS relativo ao Fundo de Combate à Pobreza naquela UF
   */
  public BigDecimal getVicmsUFDest() {
    return vicmsUFDest;
  }

  /**
   * # w04e vICMSUFDest Valor total do ICMS Interestadual para a UF de destino E W02 N 0-1 13v2<br>
   * Valor total do ICMS Interestadual para a UF de destino, já considerando o valor do ICMS relativo ao Fundo de Combate à Pobreza naquela UF. (Incluído na NT 2015/003).
   *
   * @param vicmsUFDest # w04e vICMSUFDest Valor total do ICMS Interestadual para a UF de destino E W02 N 0-1 13v2<br>
   *          Valor total do ICMS Interestadual para a UF de destino, já considerando o valor do ICMS relativo ao Fundo de Combate à Pobreza naquela UF
   */
  public void setVicmsUFDest(BigDecimal vicmsUFDest) {
    this.vicmsUFDest = vicmsUFDest;
  }

  /**
   * # w04g vICMSUFRemet Valor total do ICMS Interestadual para a UF do remetente E W02 N 0-1 13v2<br>
   * Valor total do ICMS Interestadual para a UF do remetente. Nota: A partir de 2019, este valor será zero. (Incluído na NT 2015/003).
   *
   * @return # w04g vICMSUFRemet Valor total do ICMS Interestadual para a UF do remetente E W02 N 0-1 13v2<br>
   *         Valor total do ICMS Interestadual para a UF do remetente
   */
  public BigDecimal getVicmsUFRemet() {
    return vicmsUFRemet;
  }

  /**
   * # w04g vICMSUFRemet Valor total do ICMS Interestadual para a UF do remetente E W02 N 0-1 13v2<br>
   * Valor total do ICMS Interestadual para a UF do remetente. Nota: A partir de 2019, este valor será zero. (Incluído na NT 2015/003).
   *
   * @param vicmsUFRemet # w04g vICMSUFRemet Valor total do ICMS Interestadual para a UF do remetente E W02 N 0-1 13v2<br>
   *          Valor total do ICMS Interestadual para a UF do remetente
   */
  public void setVicmsUFRemet(BigDecimal vicmsUFRemet) {
    this.vicmsUFRemet = vicmsUFRemet;
  }

  /**
   * # w04h vFCP Valor Total do FCP (Fundo de Combate à Pobreza) E W02 N 1-1 13v2<br>
   * Corresponde ao total da soma dos campos id: N17c (Incluído na NT2016.002).
   *
   * @return # w04h vFCP Valor Total do FCP (Fundo de Combate à Pobreza) E W02 N 1-1 13v2<br>
   *         Corresponde ao total da soma dos campos id: N17c (Incluído na NT2016
   */
  public BigDecimal getVfcp() {
    return vfcp;
  }

  /**
   * # w04h vFCP Valor Total do FCP (Fundo de Combate à Pobreza) E W02 N 1-1 13v2<br>
   * Corresponde ao total da soma dos campos id: N17c (Incluído na NT2016.002).
   *
   * @param vfcp # w04h vFCP Valor Total do FCP (Fundo de Combate à Pobreza) E W02 N 1-1 13v2<br>
   *          Corresponde ao total da soma dos campos id: N17c (Incluído na NT2016
   */
  public void setVfcp(BigDecimal vfcp) {
    this.vfcp = vfcp;
  }

  /**
   * # w05 vBCST Base de Cálculo do ICMS ST E W02 N 1-1 13v2.
   *
   * @return # w05 vBCST Base de Cálculo do ICMS ST E W02 N 1-1 13v2
   */
  public BigDecimal getVbcST() {
    return vbcST;
  }

  /**
   * # w05 vBCST Base de Cálculo do ICMS ST E W02 N 1-1 13v2.
   *
   * @param vbcST # w05 vBCST Base de Cálculo do ICMS ST E W02 N 1-1 13v2
   */
  public void setVbcST(BigDecimal vbcST) {
    this.vbcST = vbcST;
  }

  /**
   * # w06 vST Valor Total do ICMS ST E W02 N 1-1 13v2.
   *
   * @return # w06 vST Valor Total do ICMS ST E W02 N 1-1 13v2
   */
  public BigDecimal getVst() {
    return vst;
  }

  /**
   * # w06 vST Valor Total do ICMS ST E W02 N 1-1 13v2.
   *
   * @param vst # w06 vST Valor Total do ICMS ST E W02 N 1-1 13v2
   */
  public void setVst(BigDecimal vst) {
    this.vst = vst;
  }

  /**
   * # w06a vFCPST Valor Total do FCP (Fundo de Combate à Pobreza) retido por substituição tributária E W02 N 1-1 13v2<br>
   * Corresponde ao total da soma dos campos id:N23d (Incluído na NT2016.002).
   *
   * @return # w06a vFCPST Valor Total do FCP (Fundo de Combate à Pobreza) retido por substituição tributária E W02 N 1-1 13v2<br>
   *         Corresponde ao total da soma dos campos id:N23d (Incluído na NT2016
   */
  public BigDecimal getVfcpST() {
    return vfcpST;
  }

  /**
   * # w06a vFCPST Valor Total do FCP (Fundo de Combate à Pobreza) retido por substituição tributária E W02 N 1-1 13v2<br>
   * Corresponde ao total da soma dos campos id:N23d (Incluído na NT2016.002).
   *
   * @param vfcpST # w06a vFCPST Valor Total do FCP (Fundo de Combate à Pobreza) retido por substituição tributária E W02 N 1-1 13v2<br>
   *          Corresponde ao total da soma dos campos id:N23d (Incluído na NT2016
   */
  public void setVfcpST(BigDecimal vfcpST) {
    this.vfcpST = vfcpST;
  }

  /**
   * # w06b vFCPSTRet Valor Total do FCP retido anteriormente por Substituição Tributária E W02 N 1-1 13v2<br>
   * Corresponde ao total da soma dos campos id:N27d (Incluído na NT2016.002).
   *
   * @return # w06b vFCPSTRet Valor Total do FCP retido anteriormente por Substituição Tributária E W02 N 1-1 13v2<br>
   *         Corresponde ao total da soma dos campos id:N27d (Incluído na NT2016
   */
  public BigDecimal getVfcpSTRet() {
    return vfcpSTRet;
  }

  /**
   * # w06b vFCPSTRet Valor Total do FCP retido anteriormente por Substituição Tributária E W02 N 1-1 13v2<br>
   * Corresponde ao total da soma dos campos id:N27d (Incluído na NT2016.002).
   *
   * @param vfcpSTRet # w06b vFCPSTRet Valor Total do FCP retido anteriormente por Substituição Tributária E W02 N 1-1 13v2<br>
   *          Corresponde ao total da soma dos campos id:N27d (Incluído na NT2016
   */
  public void setVfcpSTRet(BigDecimal vfcpSTRet) {
    this.vfcpSTRet = vfcpSTRet;
  }

  /**
   * # w07 vProd Valor Total dos produtos e serviços E W02 N 1-1 13v2.
   *
   * @return # w07 vProd Valor Total dos produtos e serviços E W02 N 1-1 13v2
   */
  public BigDecimal getVprod() {
    return vprod;
  }

  /**
   * # w07 vProd Valor Total dos produtos e serviços E W02 N 1-1 13v2.
   *
   * @param vprod # w07 vProd Valor Total dos produtos e serviços E W02 N 1-1 13v2
   */
  public void setVprod(BigDecimal vprod) {
    this.vprod = vprod;
  }

  /**
   * # w08 vFrete Valor Total do Frete E W02 N 1-1 13v2.
   *
   * @return # w08 vFrete Valor Total do Frete E W02 N 1-1 13v2
   */
  public BigDecimal getVfrete() {
    return vfrete;
  }

  /**
   * # w08 vFrete Valor Total do Frete E W02 N 1-1 13v2.
   *
   * @param vfrete # w08 vFrete Valor Total do Frete E W02 N 1-1 13v2
   */
  public void setVfrete(BigDecimal vfrete) {
    this.vfrete = vfrete;
  }

  /**
   * # w09 vSeg Valor Total do Seguro E W02 N 1-1 13v2.
   *
   * @return # w09 vSeg Valor Total do Seguro E W02 N 1-1 13v2
   */
  public BigDecimal getVseg() {
    return vseg;
  }

  /**
   * # w09 vSeg Valor Total do Seguro E W02 N 1-1 13v2.
   *
   * @param vseg # w09 vSeg Valor Total do Seguro E W02 N 1-1 13v2
   */
  public void setVseg(BigDecimal vseg) {
    this.vseg = vseg;
  }

  /**
   * # w10 vDesc Valor Total do Desconto E W02 N 1-1 13v2.
   *
   * @return # w10 vDesc Valor Total do Desconto E W02 N 1-1 13v2
   */
  public BigDecimal getVdesc() {
    return vdesc;
  }

  /**
   * # w10 vDesc Valor Total do Desconto E W02 N 1-1 13v2.
   *
   * @param vdesc # w10 vDesc Valor Total do Desconto E W02 N 1-1 13v2
   */
  public void setVdesc(BigDecimal vdesc) {
    this.vdesc = vdesc;
  }

  /**
   * # w11 vII Valor Total do II E W02 N 1-1 13v2.
   *
   * @return # w11 vII Valor Total do II E W02 N 1-1 13v2
   */
  public BigDecimal getVii() {
    return vii;
  }

  /**
   * # w11 vII Valor Total do II E W02 N 1-1 13v2.
   *
   * @param vii # w11 vII Valor Total do II E W02 N 1-1 13v2
   */
  public void setVii(BigDecimal vii) {
    this.vii = vii;
  }

  /**
   * # w12 vIPI Valor Total do IPI E W02 N 1-1 13v2.
   *
   * @return # w12 vIPI Valor Total do IPI E W02 N 1-1 13v2
   */
  public BigDecimal getVipi() {
    return vipi;
  }

  /**
   * # w12 vIPI Valor Total do IPI E W02 N 1-1 13v2.
   *
   * @param vipi # w12 vIPI Valor Total do IPI E W02 N 1-1 13v2
   */
  public void setVipi(BigDecimal vipi) {
    this.vipi = vipi;
  }

  /**
   * # w12a vIPIDevol Valor Total do IPI devolvido E W02 N 1-1 13v2<br>
   * Deve ser informado quando preenchido o Grupo Tributos Devolvidos na emissão de nota finNFe=4 (devolução) nas operações com não contribuintes do IPI. Corresponde ao total da soma dos campos id:UA04. (Incluído na NT2016.002).
   *
   * @return # w12a vIPIDevol Valor Total do IPI devolvido E W02 N 1-1 13v2<br>
   *         Deve ser informado quando preenchido o Grupo Tributos Devolvidos na emissão de nota finNFe=4 (devolução) nas operações com não contribuintes do IPI
   */
  public BigDecimal getVipiDevol() {
    return vipiDevol;
  }

  /**
   * # w12a vIPIDevol Valor Total do IPI devolvido E W02 N 1-1 13v2<br>
   * Deve ser informado quando preenchido o Grupo Tributos Devolvidos na emissão de nota finNFe=4 (devolução) nas operações com não contribuintes do IPI. Corresponde ao total da soma dos campos id:UA04. (Incluído na NT2016.002).
   *
   * @param vipiDevol # w12a vIPIDevol Valor Total do IPI devolvido E W02 N 1-1 13v2<br>
   *          Deve ser informado quando preenchido o Grupo Tributos Devolvidos na emissão de nota finNFe=4 (devolução) nas operações com não contribuintes do IPI
   */
  public void setVipiDevol(BigDecimal vipiDevol) {
    this.vipiDevol = vipiDevol;
  }

  /**
   * # w13 vPIS Valor do PIS E W02 N 1-1 13v2.
   *
   * @return # w13 vPIS Valor do PIS E W02 N 1-1 13v2
   */
  public BigDecimal getVpis() {
    return vpis;
  }

  /**
   * # w13 vPIS Valor do PIS E W02 N 1-1 13v2.
   *
   * @param vpis # w13 vPIS Valor do PIS E W02 N 1-1 13v2
   */
  public void setVpis(BigDecimal vpis) {
    this.vpis = vpis;
  }

  /**
   * # w14 vCOFINS Valor da COFINS E W02 N 1-1 13v2.
   *
   * @return # w14 vCOFINS Valor da COFINS E W02 N 1-1 13v2
   */
  public BigDecimal getVcofins() {
    return vcofins;
  }

  /**
   * # w14 vCOFINS Valor da COFINS E W02 N 1-1 13v2.
   *
   * @param vcofins # w14 vCOFINS Valor da COFINS E W02 N 1-1 13v2
   */
  public void setVcofins(BigDecimal vcofins) {
    this.vcofins = vcofins;
  }

  /**
   * # w15 vOutro Outras Despesas acessórias E W02 N 1-1 13v2.
   *
   * @return # w15 vOutro Outras Despesas acessórias E W02 N 1-1 13v2
   */
  public BigDecimal getVoutro() {
    return voutro;
  }

  /**
   * # w15 vOutro Outras Despesas acessórias E W02 N 1-1 13v2.
   *
   * @param voutro # w15 vOutro Outras Despesas acessórias E W02 N 1-1 13v2
   */
  public void setVoutro(BigDecimal voutro) {
    this.voutro = voutro;
  }

  /**
   * # w16 vNF Valor Total da NF-e E W02 N 1-1 13v2<br>
   * Vide validação para este campo na regra de validação "W16-xx".
   *
   * @return # w16 vNF Valor Total da NF-e E W02 N 1-1 13v2<br>
   *         Vide validação para este campo na regra de validação "W16-xx"
   */
  public BigDecimal getVnf() {
    return vnf;
  }

  /**
   * # w16 vNF Valor Total da NF-e E W02 N 1-1 13v2<br>
   * Vide validação para este campo na regra de validação "W16-xx".
   *
   * @param vnf # w16 vNF Valor Total da NF-e E W02 N 1-1 13v2<br>
   *          Vide validação para este campo na regra de validação "W16-xx"
   */
  public void setVnf(BigDecimal vnf) {
    this.vnf = vnf;
  }

  /**
   * # w16a vTotTrib Valor aproximado total de tributos federais, estaduais e municipais. E W02 N 0-1 13v2<br>
   * (NT 2013/003).
   *
   * @return # w16a vTotTrib Valor aproximado total de tributos federais, estaduais e municipais
   */
  public BigDecimal getVtotTrib() {
    return vtotTrib;
  }

  /**
   * # w16a vTotTrib Valor aproximado total de tributos federais, estaduais e municipais. E W02 N 0-1 13v2<br>
   * (NT 2013/003).
   *
   * @param vtotTrib # w16a vTotTrib Valor aproximado total de tributos federais, estaduais e municipais
   */
  public void setVtotTrib(BigDecimal vtotTrib) {
    this.vtotTrib = vtotTrib;
  }
}