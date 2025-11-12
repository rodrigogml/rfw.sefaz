/*
 *
 */
package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CSOSN;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CST_ICMS;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_orig;

/**
 * Representa o grupo {@code ICMSST} (ID N10b) da NF-e.
 * <p>
 * Grupo de repasse do ICMS ST retido anteriormente em operações interestaduais com repasses através do Substituto Tributário.
 * </p>
 * <p>
 * Baseado no MOC 7.0 - Anexo I (versão 3.10, NT 2018.005 v1.0)
 * </p>
 *
 * @author BIS DEVil
 * @since 1.0.0
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_icmsst")
public class ICMSSTVO extends RFWVO {

  private static final long serialVersionUID = -3412928360482758310L;

  /**
   * ID: N11<br>
   * Campo: orig<br>
   * Descrição: Origem da mercadoria.
   */
  @RFWMetaEnumField(caption = "Origem da mercadoria", required = false)
  private SEFAZ_orig orig = null;

  /**
   * ID: N12<br>
   * Campo: CST<br>
   * Descrição: Situação tributária do ICMS.<br>
   * Valores válidos para este grupo: 41 = Não tributada; 60 = ICMS cobrado anteriormente por substituição tributária.
   */
  @RFWMetaEnumField(caption = "Situação tributária ICMS", required = false)
  private SEFAZ_CST_ICMS cst = null;

  /**
   * ID: N26<br>
   * Campo: vBCSTRet<br>
   * Descrição: Valor da base de cálculo do ICMS ST retido na UF remetente.
   */
  @RFWMetaBigDecimalField(caption = "Base de cálculo ICMS ST retido UF remetente", required = false, maxValue = "9999999999999.99", minValue = "0", scale = 2, absolute = true)
  private BigDecimal vBCSTRet = null;

  /**
   * ID: N26a<br>
   * Campo: pST<br>
   * Descrição: Alíquota suportada pelo consumidor final (%).
   */
  @RFWMetaBigDecimalField(caption = "Alíquota suportada pelo consumidor final (%)", required = false, maxValue = "999.9999", minValue = "0", scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pST = null;

  /**
   * ID: N26b<br>
   * Campo: vICMSSubstituto<br>
   * Descrição: Valor do ICMS próprio do substituto.
   */
  @RFWMetaBigDecimalField(caption = "Valor ICMS próprio do substituto", required = false, maxValue = "9999999999999.99", minValue = "0", scale = 2, absolute = true)
  private BigDecimal vICMSSubstituto = null;

  /**
   * ID: N27<br>
   * Campo: vICMSSTRet<br>
   * Descrição: Valor do ICMS ST retido na UF remetente.
   */
  @RFWMetaBigDecimalField(caption = "Valor ICMS ST retido UF remetente", required = false, maxValue = "9999999999999.99", minValue = "0", scale = 2, absolute = true)
  private BigDecimal vICMSSTRet = null;

  /**
   * ID: N27b<br>
   * Campo: vBCFCPSTRet<br>
   * Descrição: Valor da base de cálculo do FCP retido anteriormente por substituição tributária.
   */
  @RFWMetaBigDecimalField(caption = "Base de cálculo FCP retido anteriormente ST", required = false, maxValue = "9999999999999.99", minValue = "0", scale = 2, absolute = true)
  private BigDecimal vBCFCPSTRet = null;

  /**
   * ID: N27c<br>
   * Campo: pFCPSTRet<br>
   * Descrição: Percentual do FCP retido anteriormente por substituição tributária.
   */
  @RFWMetaBigDecimalField(caption = "Percentual FCP retido anteriormente ST (%)", required = false, maxValue = "999.9999", minValue = "0", scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pFCPSTRet = null;

  /**
   * ID: N27d<br>
   * Campo: vFCPSTRet<br>
   * Descrição: Valor do FCP retido por substituição tributária.
   */
  @RFWMetaBigDecimalField(caption = "Valor FCP retido ST", required = false, maxValue = "9999999999999.99", minValue = "0", scale = 2, absolute = true)
  private BigDecimal vFCPSTRet = null;

  /**
   * ID: N31<br>
   * Campo: vBCSTDest<br>
   * Descrição: Valor da base de cálculo do ICMS ST da UF destino.
   */
  @RFWMetaBigDecimalField(caption = "Base de cálculo ICMS ST UF destino", required = false, maxValue = "9999999999999.99", minValue = "0", scale = 2, absolute = true)
  private BigDecimal vBCSTDest = null;

  /**
   * ID: N32<br>
   * Campo: vICMSSTDest<br>
   * Descrição: Valor do ICMS ST da UF destino.
   */
  @RFWMetaBigDecimalField(caption = "Valor ICMS ST UF destino", required = false, maxValue = "9999999999999.99", minValue = "0", scale = 2, absolute = true)
  private BigDecimal vICMSSTDest = null;

  /**
   * ID: N12a<br>
   * Código de Situação da Operação – Simples Nacional (CSOSN).<br>
   * Utilizado apenas quando o contribuinte está no regime do Simples Nacional (grupos ICMSSN101, ICMSSN102, ICMSSN201, ICMSSN202, ICMSSN500 e ICMSSN900).<br>
   * Valores conforme {@link SEFAZ_CSOSN}.
   */
  @RFWMetaEnumField(caption = "Situação operação SN", required = false)
  private SEFAZ_CSOSN csosn = null;

  /**
   * ID: N29 (ICMSSN101 / ICMSSN201 / ICMSSN202 / ICMSSN900)<br>
   * Alíquota aplicável de cálculo do crédito no Simples Nacional (pCredSN).<br>
   * Tamanho 3v2-4.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota crédito SN", required = false, minValue = "0", scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pCredSN = null;

  /**
   * ID: N30 (ICMSSN101 / ICMSSN201 / ICMSSN202 / ICMSSN900)<br>
   * Valor de crédito do ICMS no Simples Nacional (vCredICMSSN).<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Crédito ICMS SN", required = false, minValue = "0", scale = 2, absolute = true)
  private BigDecimal vCredICMSSN = null;

  /**
   * # iD: N11<br>
   * Campo: orig<br>
   * Descrição: Origem da mercadoria.
   *
   * @return the iD: N11<br>
   *         Campo: orig<br>
   *         Descrição: Origem da mercadoria
   */
  public SEFAZ_orig getOrig() {
    return orig;
  }

  /**
   * # iD: N11<br>
   * Campo: orig<br>
   * Descrição: Origem da mercadoria.
   *
   * @param orig the new iD: N11<br>
   *          Campo: orig<br>
   *          Descrição: Origem da mercadoria
   */
  public void setOrig(SEFAZ_orig orig) {
    this.orig = orig;
  }

  /**
   * # iD: N12<br>
   * Campo: CST<br>
   * Descrição: Situação tributária do ICMS.<br>
   * Valores válidos para este grupo: 41 = Não tributada; 60 = ICMS cobrado anteriormente por substituição tributária.
   *
   * @return the iD: N12<br>
   *         Campo: CST<br>
   *         Descrição: Situação tributária do ICMS
   */
  public SEFAZ_CST_ICMS getCst() {
    return cst;
  }

  /**
   * # iD: N12<br>
   * Campo: CST<br>
   * Descrição: Situação tributária do ICMS.<br>
   * Valores válidos para este grupo: 41 = Não tributada; 60 = ICMS cobrado anteriormente por substituição tributária.
   *
   * @param cst the new iD: N12<br>
   *          Campo: CST<br>
   *          Descrição: Situação tributária do ICMS
   */
  public void setCst(SEFAZ_CST_ICMS cst) {
    this.cst = cst;
  }

  /**
   * # iD: N26<br>
   * Campo: vBCSTRet<br>
   * Descrição: Valor da base de cálculo do ICMS ST retido na UF remetente.
   *
   * @return the iD: N26<br>
   *         Campo: vBCSTRet<br>
   *         Descrição: Valor da base de cálculo do ICMS ST retido na UF remetente
   */
  public BigDecimal getVBCSTRet() {
    return vBCSTRet;
  }

  /**
   * # iD: N26<br>
   * Campo: vBCSTRet<br>
   * Descrição: Valor da base de cálculo do ICMS ST retido na UF remetente.
   *
   * @param vBCSTRet the new iD: N26<br>
   *          Campo: vBCSTRet<br>
   *          Descrição: Valor da base de cálculo do ICMS ST retido na UF remetente
   */
  public void setVBCSTRet(BigDecimal vBCSTRet) {
    this.vBCSTRet = vBCSTRet;
  }

  /**
   * # iD: N26a<br>
   * Campo: pST<br>
   * Descrição: Alíquota suportada pelo consumidor final (%).
   *
   * @return the iD: N26a<br>
   *         Campo: pST<br>
   *         Descrição: Alíquota suportada pelo consumidor final (%)
   */
  public BigDecimal getPST() {
    return pST;
  }

  /**
   * # iD: N26a<br>
   * Campo: pST<br>
   * Descrição: Alíquota suportada pelo consumidor final (%).
   *
   * @param pST the new iD: N26a<br>
   *          Campo: pST<br>
   *          Descrição: Alíquota suportada pelo consumidor final (%)
   */
  public void setPST(BigDecimal pST) {
    this.pST = pST;
  }

  /**
   * # iD: N26b<br>
   * Campo: vICMSSubstituto<br>
   * Descrição: Valor do ICMS próprio do substituto.
   *
   * @return the iD: N26b<br>
   *         Campo: vICMSSubstituto<br>
   *         Descrição: Valor do ICMS próprio do substituto
   */
  public BigDecimal getVICMSSubstituto() {
    return vICMSSubstituto;
  }

  /**
   * # iD: N26b<br>
   * Campo: vICMSSubstituto<br>
   * Descrição: Valor do ICMS próprio do substituto.
   *
   * @param vICMSSubstituto the new iD: N26b<br>
   *          Campo: vICMSSubstituto<br>
   *          Descrição: Valor do ICMS próprio do substituto
   */
  public void setVICMSSubstituto(BigDecimal vICMSSubstituto) {
    this.vICMSSubstituto = vICMSSubstituto;
  }

  /**
   * # iD: N27<br>
   * Campo: vICMSSTRet<br>
   * Descrição: Valor do ICMS ST retido na UF remetente.
   *
   * @return the iD: N27<br>
   *         Campo: vICMSSTRet<br>
   *         Descrição: Valor do ICMS ST retido na UF remetente
   */
  public BigDecimal getVICMSSTRet() {
    return vICMSSTRet;
  }

  /**
   * # iD: N27<br>
   * Campo: vICMSSTRet<br>
   * Descrição: Valor do ICMS ST retido na UF remetente.
   *
   * @param vICMSSTRet the new iD: N27<br>
   *          Campo: vICMSSTRet<br>
   *          Descrição: Valor do ICMS ST retido na UF remetente
   */
  public void setVICMSSTRet(BigDecimal vICMSSTRet) {
    this.vICMSSTRet = vICMSSTRet;
  }

  /**
   * # iD: N27b<br>
   * Campo: vBCFCPSTRet<br>
   * Descrição: Valor da base de cálculo do FCP retido anteriormente por substituição tributária.
   *
   * @return the iD: N27b<br>
   *         Campo: vBCFCPSTRet<br>
   *         Descrição: Valor da base de cálculo do FCP retido anteriormente por substituição tributária
   */
  public BigDecimal getVBCFCPSTRet() {
    return vBCFCPSTRet;
  }

  /**
   * # iD: N27b<br>
   * Campo: vBCFCPSTRet<br>
   * Descrição: Valor da base de cálculo do FCP retido anteriormente por substituição tributária.
   *
   * @param vBCFCPSTRet the new iD: N27b<br>
   *          Campo: vBCFCPSTRet<br>
   *          Descrição: Valor da base de cálculo do FCP retido anteriormente por substituição tributária
   */
  public void setVBCFCPSTRet(BigDecimal vBCFCPSTRet) {
    this.vBCFCPSTRet = vBCFCPSTRet;
  }

  /**
   * # iD: N27c<br>
   * Campo: pFCPSTRet<br>
   * Descrição: Percentual do FCP retido anteriormente por substituição tributária.
   *
   * @return the iD: N27c<br>
   *         Campo: pFCPSTRet<br>
   *         Descrição: Percentual do FCP retido anteriormente por substituição tributária
   */
  public BigDecimal getPFCPSTRet() {
    return pFCPSTRet;
  }

  /**
   * # iD: N27c<br>
   * Campo: pFCPSTRet<br>
   * Descrição: Percentual do FCP retido anteriormente por substituição tributária.
   *
   * @param pFCPSTRet the new iD: N27c<br>
   *          Campo: pFCPSTRet<br>
   *          Descrição: Percentual do FCP retido anteriormente por substituição tributária
   */
  public void setPFCPSTRet(BigDecimal pFCPSTRet) {
    this.pFCPSTRet = pFCPSTRet;
  }

  /**
   * # iD: N27d<br>
   * Campo: vFCPSTRet<br>
   * Descrição: Valor do FCP retido por substituição tributária.
   *
   * @return the iD: N27d<br>
   *         Campo: vFCPSTRet<br>
   *         Descrição: Valor do FCP retido por substituição tributária
   */
  public BigDecimal getVFCPSTRet() {
    return vFCPSTRet;
  }

  /**
   * # iD: N27d<br>
   * Campo: vFCPSTRet<br>
   * Descrição: Valor do FCP retido por substituição tributária.
   *
   * @param vFCPSTRet the new iD: N27d<br>
   *          Campo: vFCPSTRet<br>
   *          Descrição: Valor do FCP retido por substituição tributária
   */
  public void setVFCPSTRet(BigDecimal vFCPSTRet) {
    this.vFCPSTRet = vFCPSTRet;
  }

  /**
   * # iD: N31<br>
   * Campo: vBCSTDest<br>
   * Descrição: Valor da base de cálculo do ICMS ST da UF destino.
   *
   * @return the iD: N31<br>
   *         Campo: vBCSTDest<br>
   *         Descrição: Valor da base de cálculo do ICMS ST da UF destino
   */
  public BigDecimal getVBCSTDest() {
    return vBCSTDest;
  }

  /**
   * # iD: N31<br>
   * Campo: vBCSTDest<br>
   * Descrição: Valor da base de cálculo do ICMS ST da UF destino.
   *
   * @param vBCSTDest the new iD: N31<br>
   *          Campo: vBCSTDest<br>
   *          Descrição: Valor da base de cálculo do ICMS ST da UF destino
   */
  public void setVBCSTDest(BigDecimal vBCSTDest) {
    this.vBCSTDest = vBCSTDest;
  }

  /**
   * # iD: N32<br>
   * Campo: vICMSSTDest<br>
   * Descrição: Valor do ICMS ST da UF destino.
   *
   * @return the iD: N32<br>
   *         Campo: vICMSSTDest<br>
   *         Descrição: Valor do ICMS ST da UF destino
   */
  public BigDecimal getVICMSSTDest() {
    return vICMSSTDest;
  }

  /**
   * # iD: N32<br>
   * Campo: vICMSSTDest<br>
   * Descrição: Valor do ICMS ST da UF destino.
   *
   * @param vICMSSTDest the new iD: N32<br>
   *          Campo: vICMSSTDest<br>
   *          Descrição: Valor do ICMS ST da UF destino
   */
  public void setVICMSSTDest(BigDecimal vICMSSTDest) {
    this.vICMSSTDest = vICMSSTDest;
  }

  /**
   * # iD: N12a<br>
   * Código de Situação da Operação – Simples Nacional (CSOSN).<br>
   * Utilizado apenas quando o contribuinte está no regime do Simples Nacional (grupos ICMSSN101, ICMSSN102, ICMSSN201, ICMSSN202, ICMSSN500 e ICMSSN900).<br>
   * Valores conforme {@link SEFAZ_CSOSN}.
   *
   * @return the iD: N12a<br>
   *         Código de Situação da Operação – Simples Nacional (CSOSN)
   */
  public SEFAZ_CSOSN getCsosn() {
    return csosn;
  }

  /**
   * # iD: N12a<br>
   * Código de Situação da Operação – Simples Nacional (CSOSN).<br>
   * Utilizado apenas quando o contribuinte está no regime do Simples Nacional (grupos ICMSSN101, ICMSSN102, ICMSSN201, ICMSSN202, ICMSSN500 e ICMSSN900).<br>
   * Valores conforme {@link SEFAZ_CSOSN}.
   *
   * @param csosn the new iD: N12a<br>
   *          Código de Situação da Operação – Simples Nacional (CSOSN)
   */
  public void setCsosn(SEFAZ_CSOSN csosn) {
    this.csosn = csosn;
  }

  /**
   * # iD: N29 (ICMSSN101 / ICMSSN201 / ICMSSN202 / ICMSSN900)<br>
   * Alíquota aplicável de cálculo do crédito no Simples Nacional (pCredSN).<br>
   * Tamanho 3v2-4.
   *
   * @return the iD: N29 (ICMSSN101 / ICMSSN201 / ICMSSN202 / ICMSSN900)<br>
   *         Alíquota aplicável de cálculo do crédito no Simples Nacional (pCredSN)
   */
  public BigDecimal getPCredSN() {
    return pCredSN;
  }

  /**
   * # iD: N29 (ICMSSN101 / ICMSSN201 / ICMSSN202 / ICMSSN900)<br>
   * Alíquota aplicável de cálculo do crédito no Simples Nacional (pCredSN).<br>
   * Tamanho 3v2-4.
   *
   * @param pCredSN the new iD: N29 (ICMSSN101 / ICMSSN201 / ICMSSN202 / ICMSSN900)<br>
   *          Alíquota aplicável de cálculo do crédito no Simples Nacional (pCredSN)
   */
  public void setPCredSN(BigDecimal pCredSN) {
    this.pCredSN = pCredSN;
  }

  /**
   * # iD: N30 (ICMSSN101 / ICMSSN201 / ICMSSN202 / ICMSSN900)<br>
   * Valor de crédito do ICMS no Simples Nacional (vCredICMSSN).<br>
   * Tamanho 13v2.
   *
   * @return the iD: N30 (ICMSSN101 / ICMSSN201 / ICMSSN202 / ICMSSN900)<br>
   *         Valor de crédito do ICMS no Simples Nacional (vCredICMSSN)
   */
  public BigDecimal getVCredICMSSN() {
    return vCredICMSSN;
  }

  /**
   * # iD: N30 (ICMSSN101 / ICMSSN201 / ICMSSN202 / ICMSSN900)<br>
   * Valor de crédito do ICMS no Simples Nacional (vCredICMSSN).<br>
   * Tamanho 13v2.
   *
   * @param vCredICMSSN the new iD: N30 (ICMSSN101 / ICMSSN201 / ICMSSN202 / ICMSSN900)<br>
   *          Valor de crédito do ICMS no Simples Nacional (vCredICMSSN)
   */
  public void setVCredICMSSN(BigDecimal vCredICMSSN) {
    this.vCredICMSSN = vCredICMSSN;
  }

}
