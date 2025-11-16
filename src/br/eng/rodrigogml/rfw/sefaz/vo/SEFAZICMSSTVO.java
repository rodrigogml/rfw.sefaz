package br.eng.rodrigogml.rfw.sefaz.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CST_ICMS;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_orig;

/**
 * Grupo N10b - ICMSST.
 *
 * Grupo de repasse de ICMS ST retido anteriormente em operações interestaduais com repasses através do Substituto Tributário (tag ICMSST / N10b).
 * <p>
 * Representa o ICMS ST devido para a UF de destino nas operações interestaduais de produtos que tiveram retenção antecipada de ICMS por ST na UF do remetente, com repasse via substituto tributário (v2.0 e NT 2018.005).
 *
 * Observação: nas annotations o atributo {@code required} é sempre definido como false conforme solicitado, mesmo que o MOC defina obrigatoriedade.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_icmsst")
public class SEFAZICMSSTVO extends RFWVO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * Relação com o ICMS da operação (tag ICMS / N01). Associação pai para o grupo ICMSST.
   */
  @RFWMetaRelationshipField(caption = "ICMS", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_icms")
  private SEFAZICMSVO icmsVO = null;

  /**
   * N11 - orig. Origem da mercadoria. Ocor.: 1–1 / Tam.: 1 / Tipo: N. Ver valores em {@link SEFAZ_orig}. <br>
   * Utilizada no contexto do repasse de ICMS ST retido anteriormente, em operações interestaduais com substituto tributário.
   */
  @RFWMetaEnumField(caption = "Origem da mercadoria (ICMS ST)", required = false)
  private SEFAZ_orig orig;

  /**
   * N12 - CST. Tributação do ICMS. Ocor.: 1–1 / Tam.: 2 / Tipo: N. <br>
   * Valores permitidos para ICMSST: <br>
   * 41 – Não tributada; <br>
   * 60 – Cobrado anteriormente por substituição tributária. <br>
   * Mapeado para {@link SEFAZ_CST_ICMS}.
   */
  @RFWMetaEnumField(caption = "CST do ICMS (ICMS ST)", required = false)
  private SEFAZ_CST_ICMS cst;

  /**
   * N26 - vBCSTRet. Valor da base de cálculo do ICMS ST retido na UF remetente. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * Informar o valor da BC do ICMS ST que foi retido antecipadamente na UF de origem.
   */
  @RFWMetaBigDecimalField(caption = "BC do ICMS ST retido na UF remetente", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vbcSTRet;

  /**
   * N26a - pST. Alíquota suportada pelo consumidor final. Ocor.: 0–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * Deve ser informada a alíquota do cálculo do ICMS-ST, já incluindo o FCP quando incidir sobre a mercadoria. Ex.: 18% ICMS + 2% FCP informar 20%.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota suportada pelo consumidor final (pST)", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal pst;

  /**
   * N26b - vICMSSubstituto. Valor do ICMS próprio do substituto. Ocor.: 0–1 / Tam.: 13v2 / Tipo: N. <br>
   * Valor do ICMS próprio do substituto tributário cobrado em operação anterior.
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS próprio do substituto", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vicmsSubstituto;

  /**
   * N27 - vICMSSTRet. Valor do ICMS ST retido na UF remetente. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * Informar o valor do ICMS ST retido antecipadamente na UF de origem.
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS ST retido na UF remetente", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vicmsSTRet;

  /**
   * N27a - vBCFCPSTRet. Valor da base de cálculo do FCP retido anteriormente por ST. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * Informar o valor da BC do FCP-ST retido anteriormente na UF remetente.
   */
  @RFWMetaBigDecimalField(caption = "BC do FCP ST retido anteriormente", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vbcFCPSTRet;

  /**
   * N27b - pFCPSTRet. Percentual do FCP retido anteriormente por substituição tributária. <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * Percentual relativo ao Fundo de Combate à Pobreza (FCP) retido por ST.
   */
  @RFWMetaBigDecimalField(caption = "Percentual do FCP ST retido anteriormente", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal pfcpSTRet;

  /**
   * N27d - vFCPSTRet. Valor do FCP retido por substituição tributária. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * Valor do ICMS relativo ao FCP retido anteriormente por ST.
   */
  @RFWMetaBigDecimalField(caption = "Valor do FCP ST retido anteriormente", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vfcpSTRet;

  /**
   * N31 - vBCSTDest. Valor da base de cálculo do ICMS ST da UF de destino. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * Base de cálculo do ICMS ST considerada para a UF de destino na operação interestadual.
   */
  @RFWMetaBigDecimalField(caption = "BC do ICMS ST da UF destino", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vbcSTDest;

  /**
   * N32 - vICMSSTDest. Valor do ICMS ST da UF de destino. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * Valor do ICMS ST devido à UF de destino na operação interestadual.
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS ST da UF destino", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vicmsSTDest;

  /**
   * N34 - pRedBCEfet. Percentual de redução da base de cálculo efetiva. <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * Percentual de redução que seria aplicado caso a operação estivesse submetida ao regime comum, para obtenção da base de cálculo efetiva (vBCEfet). Campo opcional, a critério da UF.
   */
  @RFWMetaBigDecimalField(caption = "Percentual de redução da BC efetiva (ICMS ST)", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal predBCEfet;

  /**
   * N35 - vBCEfet. Valor da base de cálculo efetiva. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * Valor da base que seria atribuída à operação própria do contribuinte substituto, caso estivesse no regime comum, obtida por vProd × (1 - pRedBCEfet). Campo opcional, a critério da UF.
   */
  @RFWMetaBigDecimalField(caption = "Base de cálculo efetiva (ICMS ST)", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vbcfet;

  /**
   * N36 - pICMSEfet. Alíquota efetiva do ICMS. <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * Alíquota que seria aplicada à operação a consumidor final, caso estivesse submetida ao regime comum de tributação. Campo opcional, a critério da UF.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota efetiva do ICMS (ICMS ST)", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal picmsEfet;

  /**
   * N37 - vICMSEfet. Valor do ICMS efetivo. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * Obtido pelo produto de vBCEfet por pICMSEfet, simulando a tributação no regime comum. Campo opcional, a critério da UF.
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS efetivo (ICMS ST)", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vicmsEfet;

  /**
   * # relação com o ICMS da operação (tag ICMS / N01). Associação pai para o grupo ICMSST.
   *
   * @return the relação com o ICMS da operação (tag ICMS / N01)
   */
  public SEFAZICMSVO getIcmsVO() {
    return icmsVO;
  }

  /**
   * # relação com o ICMS da operação (tag ICMS / N01). Associação pai para o grupo ICMSST.
   *
   * @param icmsVO the new relação com o ICMS da operação (tag ICMS / N01)
   */
  public void setIcmsVO(SEFAZICMSVO icmsVO) {
    this.icmsVO = icmsVO;
  }

  /**
   * # n11 - orig. Origem da mercadoria. Ocor.: 1–1 / Tam.: 1 / Tipo: N. Ver valores em {@link SEFAZ_orig}. <br>
   * Utilizada no contexto do repasse de ICMS ST retido anteriormente, em operações interestaduais com substituto tributário.
   *
   * @return the n11 - orig
   */
  public SEFAZ_orig getOrig() {
    return orig;
  }

  /**
   * # n11 - orig. Origem da mercadoria. Ocor.: 1–1 / Tam.: 1 / Tipo: N. Ver valores em {@link SEFAZ_orig}. <br>
   * Utilizada no contexto do repasse de ICMS ST retido anteriormente, em operações interestaduais com substituto tributário.
   *
   * @param orig the new n11 - orig
   */
  public void setOrig(SEFAZ_orig orig) {
    this.orig = orig;
  }

  /**
   * # n12 - CST. Tributação do ICMS. Ocor.: 1–1 / Tam.: 2 / Tipo: N. <br>
   * Valores permitidos para ICMSST: <br>
   * 41 – Não tributada; <br>
   * 60 – Cobrado anteriormente por substituição tributária. <br>
   * Mapeado para {@link SEFAZ_CST_ICMS}.
   *
   * @return the n12 - CST
   */
  public SEFAZ_CST_ICMS getCst() {
    return cst;
  }

  /**
   * # n12 - CST. Tributação do ICMS. Ocor.: 1–1 / Tam.: 2 / Tipo: N. <br>
   * Valores permitidos para ICMSST: <br>
   * 41 – Não tributada; <br>
   * 60 – Cobrado anteriormente por substituição tributária. <br>
   * Mapeado para {@link SEFAZ_CST_ICMS}.
   *
   * @param cst the new n12 - CST
   */
  public void setCst(SEFAZ_CST_ICMS cst) {
    this.cst = cst;
  }

  /**
   * # n26 - vBCSTRet. Valor da base de cálculo do ICMS ST retido na UF remetente. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * Informar o valor da BC do ICMS ST que foi retido antecipadamente na UF de origem.
   *
   * @return the n26 - vBCSTRet
   */
  public BigDecimal getVbcSTRet() {
    return vbcSTRet;
  }

  /**
   * # n26 - vBCSTRet. Valor da base de cálculo do ICMS ST retido na UF remetente. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * Informar o valor da BC do ICMS ST que foi retido antecipadamente na UF de origem.
   *
   * @param vbcSTRet the new n26 - vBCSTRet
   */
  public void setVbcSTRet(BigDecimal vbcSTRet) {
    this.vbcSTRet = vbcSTRet;
  }

  /**
   * # n26a - pST. Alíquota suportada pelo consumidor final. Ocor.: 0–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * Deve ser informada a alíquota do cálculo do ICMS-ST, já incluindo o FCP quando incidir sobre a mercadoria. Ex.: 18% ICMS + 2% FCP informar 20%.
   *
   * @return the n26a - pST
   */
  public BigDecimal getPst() {
    return pst;
  }

  /**
   * # n26a - pST. Alíquota suportada pelo consumidor final. Ocor.: 0–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * Deve ser informada a alíquota do cálculo do ICMS-ST, já incluindo o FCP quando incidir sobre a mercadoria. Ex.: 18% ICMS + 2% FCP informar 20%.
   *
   * @param pst the new n26a - pST
   */
  public void setPst(BigDecimal pst) {
    this.pst = pst;
  }

  /**
   * # n26b - vICMSSubstituto. Valor do ICMS próprio do substituto. Ocor.: 0–1 / Tam.: 13v2 / Tipo: N. <br>
   * Valor do ICMS próprio do substituto tributário cobrado em operação anterior.
   *
   * @return the n26b - vICMSSubstituto
   */
  public BigDecimal getVicmsSubstituto() {
    return vicmsSubstituto;
  }

  /**
   * # n26b - vICMSSubstituto. Valor do ICMS próprio do substituto. Ocor.: 0–1 / Tam.: 13v2 / Tipo: N. <br>
   * Valor do ICMS próprio do substituto tributário cobrado em operação anterior.
   *
   * @param vicmsSubstituto the new n26b - vICMSSubstituto
   */
  public void setVicmsSubstituto(BigDecimal vicmsSubstituto) {
    this.vicmsSubstituto = vicmsSubstituto;
  }

  /**
   * # n27 - vICMSSTRet. Valor do ICMS ST retido na UF remetente. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * Informar o valor do ICMS ST retido antecipadamente na UF de origem.
   *
   * @return the n27 - vICMSSTRet
   */
  public BigDecimal getVicmsSTRet() {
    return vicmsSTRet;
  }

  /**
   * # n27 - vICMSSTRet. Valor do ICMS ST retido na UF remetente. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * Informar o valor do ICMS ST retido antecipadamente na UF de origem.
   *
   * @param vicmsSTRet the new n27 - vICMSSTRet
   */
  public void setVicmsSTRet(BigDecimal vicmsSTRet) {
    this.vicmsSTRet = vicmsSTRet;
  }

  /**
   * # n27a - vBCFCPSTRet. Valor da base de cálculo do FCP retido anteriormente por ST. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * Informar o valor da BC do FCP-ST retido anteriormente na UF remetente.
   *
   * @return the n27a - vBCFCPSTRet
   */
  public BigDecimal getVbcFCPSTRet() {
    return vbcFCPSTRet;
  }

  /**
   * # n27a - vBCFCPSTRet. Valor da base de cálculo do FCP retido anteriormente por ST. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * Informar o valor da BC do FCP-ST retido anteriormente na UF remetente.
   *
   * @param vbcFCPSTRet the new n27a - vBCFCPSTRet
   */
  public void setVbcFCPSTRet(BigDecimal vbcFCPSTRet) {
    this.vbcFCPSTRet = vbcFCPSTRet;
  }

  /**
   * # n27b - pFCPSTRet. Percentual do FCP retido anteriormente por substituição tributária. <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * Percentual relativo ao Fundo de Combate à Pobreza (FCP) retido por ST.
   *
   * @return the n27b - pFCPSTRet
   */
  public BigDecimal getPfcpSTRet() {
    return pfcpSTRet;
  }

  /**
   * # n27b - pFCPSTRet. Percentual do FCP retido anteriormente por substituição tributária. <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * Percentual relativo ao Fundo de Combate à Pobreza (FCP) retido por ST.
   *
   * @param pfcpSTRet the new n27b - pFCPSTRet
   */
  public void setPfcpSTRet(BigDecimal pfcpSTRet) {
    this.pfcpSTRet = pfcpSTRet;
  }

  /**
   * # n27d - vFCPSTRet. Valor do FCP retido por substituição tributária. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * Valor do ICMS relativo ao FCP retido anteriormente por ST.
   *
   * @return the n27d - vFCPSTRet
   */
  public BigDecimal getVfcpSTRet() {
    return vfcpSTRet;
  }

  /**
   * # n27d - vFCPSTRet. Valor do FCP retido por substituição tributária. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * Valor do ICMS relativo ao FCP retido anteriormente por ST.
   *
   * @param vfcpSTRet the new n27d - vFCPSTRet
   */
  public void setVfcpSTRet(BigDecimal vfcpSTRet) {
    this.vfcpSTRet = vfcpSTRet;
  }

  /**
   * # n31 - vBCSTDest. Valor da base de cálculo do ICMS ST da UF de destino. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * Base de cálculo do ICMS ST considerada para a UF de destino na operação interestadual.
   *
   * @return the n31 - vBCSTDest
   */
  public BigDecimal getVbcSTDest() {
    return vbcSTDest;
  }

  /**
   * # n31 - vBCSTDest. Valor da base de cálculo do ICMS ST da UF de destino. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * Base de cálculo do ICMS ST considerada para a UF de destino na operação interestadual.
   *
   * @param vbcSTDest the new n31 - vBCSTDest
   */
  public void setVbcSTDest(BigDecimal vbcSTDest) {
    this.vbcSTDest = vbcSTDest;
  }

  /**
   * # n32 - vICMSSTDest. Valor do ICMS ST da UF de destino. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * Valor do ICMS ST devido à UF de destino na operação interestadual.
   *
   * @return the n32 - vICMSSTDest
   */
  public BigDecimal getVicmsSTDest() {
    return vicmsSTDest;
  }

  /**
   * # n32 - vICMSSTDest. Valor do ICMS ST da UF de destino. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * Valor do ICMS ST devido à UF de destino na operação interestadual.
   *
   * @param vicmsSTDest the new n32 - vICMSSTDest
   */
  public void setVicmsSTDest(BigDecimal vicmsSTDest) {
    this.vicmsSTDest = vicmsSTDest;
  }

  /**
   * # n34 - pRedBCEfet. Percentual de redução da base de cálculo efetiva. <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * Percentual de redução que seria aplicado caso a operação estivesse submetida ao regime comum, para obtenção da base de cálculo efetiva (vBCEfet). Campo opcional, a critério da UF.
   *
   * @return the n34 - pRedBCEfet
   */
  public BigDecimal getPredBCEfet() {
    return predBCEfet;
  }

  /**
   * # n34 - pRedBCEfet. Percentual de redução da base de cálculo efetiva. <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * Percentual de redução que seria aplicado caso a operação estivesse submetida ao regime comum, para obtenção da base de cálculo efetiva (vBCEfet). Campo opcional, a critério da UF.
   *
   * @param predBCEfet the new n34 - pRedBCEfet
   */
  public void setPredBCEfet(BigDecimal predBCEfet) {
    this.predBCEfet = predBCEfet;
  }

  /**
   * # n35 - vBCEfet. Valor da base de cálculo efetiva. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * Valor da base que seria atribuída à operação própria do contribuinte substituto, caso estivesse no regime comum, obtida por vProd × (1 - pRedBCEfet). Campo opcional, a critério da UF.
   *
   * @return the n35 - vBCEfet
   */
  public BigDecimal getVbcfet() {
    return vbcfet;
  }

  /**
   * # n35 - vBCEfet. Valor da base de cálculo efetiva. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * Valor da base que seria atribuída à operação própria do contribuinte substituto, caso estivesse no regime comum, obtida por vProd × (1 - pRedBCEfet). Campo opcional, a critério da UF.
   *
   * @param vbcfet the new n35 - vBCEfet
   */
  public void setVbcfet(BigDecimal vbcfet) {
    this.vbcfet = vbcfet;
  }

  /**
   * # n36 - pICMSEfet. Alíquota efetiva do ICMS. <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * Alíquota que seria aplicada à operação a consumidor final, caso estivesse submetida ao regime comum de tributação. Campo opcional, a critério da UF.
   *
   * @return the n36 - pICMSEfet
   */
  public BigDecimal getPicmsEfet() {
    return picmsEfet;
  }

  /**
   * # n36 - pICMSEfet. Alíquota efetiva do ICMS. <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * Alíquota que seria aplicada à operação a consumidor final, caso estivesse submetida ao regime comum de tributação. Campo opcional, a critério da UF.
   *
   * @param picmsEfet the new n36 - pICMSEfet
   */
  public void setPicmsEfet(BigDecimal picmsEfet) {
    this.picmsEfet = picmsEfet;
  }

  /**
   * # n37 - vICMSEfet. Valor do ICMS efetivo. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * Obtido pelo produto de vBCEfet por pICMSEfet, simulando a tributação no regime comum. Campo opcional, a critério da UF.
   *
   * @return the n37 - vICMSEfet
   */
  public BigDecimal getVicmsEfet() {
    return vicmsEfet;
  }

  /**
   * # n37 - vICMSEfet. Valor do ICMS efetivo. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * Obtido pelo produto de vBCEfet por pICMSEfet, simulando a tributação no regime comum. Campo opcional, a critério da UF.
   *
   * @param vicmsEfet the new n37 - vICMSEfet
   */
  public void setVicmsEfet(BigDecimal vicmsEfet) {
    this.vicmsEfet = vicmsEfet;
  }

}
