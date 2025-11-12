package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CST_PIS;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_orig;

/**
 * Description: Grupo PIS do item (TAG {@code PIS}, ID Q01).<br>
 * Este VO agrega os campos dos subgrupos: PISAliq (Q02), PISQtde (Q03), PISNT (Q04) e PISOutr (Q05).<br>
 * A escolha do conjunto de preenchimento é determinada pelo {@link #cst}.
 *
 * @author BIS DEVil
 * @since (11 de nov. de 2025)
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_pis")
public class PISVO extends RFWVO {

  private static final long serialVersionUID = -3779892123456678901L;

  /**
   * ID: N11 (referência cruzada, caso seu fluxo utilize origem também no PIS).<br>
   * Origem da mercadoria (quando aplicável no fluxo do emissor).
   */
  @RFWMetaEnumField(caption = "Origem da mercadoria", required = false)
  private SEFAZ_orig orig = null;

  /**
   * ID: Q06<br>
   * Código de Situação Tributária do PIS. Define o conjunto de cálculo (alíquota %, por quantidade, não tributado ou “Outras”).<br>
   * Valores conforme {@link SEFAZ_CST_PIS}.
   */
  @RFWMetaEnumField(caption = "Situação tributária PIS", required = false)
  private SEFAZ_CST_PIS cst = null;

  /**
   * ID: Q07<br>
   * Base de cálculo do PIS (13v2).
   */
  @RFWMetaBigDecimalField(caption = "Base de cálculo PIS", required = false, scale = 2, absolute = true)
  private BigDecimal vBC = null;

  /**
   * ID: Q08<br>
   * Alíquota do PIS em percentual (3v2–4).
   */
  @RFWMetaBigDecimalField(caption = "Alíquota PIS (%)", required = false, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pPIS = null;

  /**
   * ID: Q09<br>
   * Valor do PIS (13v2).
   */
  @RFWMetaBigDecimalField(caption = "Valor do PIS", required = false, scale = 2, absolute = true)
  private BigDecimal vPIS = null;

  // ====== Campos para cálculo por QUANTIDADE – PISQtde (Q03) e PISOutr (Q05) ======

  /**
   * ID: Q10<br>
   * Quantidade vendida para fins de cálculo (12v0–4).
   */
  @RFWMetaBigDecimalField(caption = "Quantidade para cálculo", required = false, scale = 0, scaleMax = 4, absolute = true)
  private BigDecimal qBCProd = null;

  /**
   * ID: Q11<br>
   * Alíquota em reais por unidade de produto (11v0–4).
   */
  @RFWMetaBigDecimalField(caption = "Alíquota por unidade (R$)", required = false, scale = 0, scaleMax = 4, absolute = true)
  private BigDecimal vAliqProd = null;

  /**
   * # iD: N11 (referência cruzada, caso seu fluxo utilize origem também no PIS).<br>
   * Origem da mercadoria (quando aplicável no fluxo do emissor).
   *
   * @return the iD: N11 (referência cruzada, caso seu fluxo utilize origem também no PIS)
   */
  public SEFAZ_orig getOrig() {
    return orig;
  }

  /**
   * # iD: N11 (referência cruzada, caso seu fluxo utilize origem também no PIS).<br>
   * Origem da mercadoria (quando aplicável no fluxo do emissor).
   *
   * @param orig the new iD: N11 (referência cruzada, caso seu fluxo utilize origem também no PIS)
   */
  public void setOrig(SEFAZ_orig orig) {
    this.orig = orig;
  }

  /**
   * # iD: Q06<br>
   * Código de Situação Tributária do PIS. Define o conjunto de cálculo (alíquota %, por quantidade, não tributado ou “Outras”).<br>
   * Valores conforme {@link SEFAZ_CST_PIS}.
   *
   * @return the iD: Q06<br>
   *         Código de Situação Tributária do PIS
   */
  public SEFAZ_CST_PIS getCst() {
    return cst;
  }

  /**
   * # iD: Q06<br>
   * Código de Situação Tributária do PIS. Define o conjunto de cálculo (alíquota %, por quantidade, não tributado ou “Outras”).<br>
   * Valores conforme {@link SEFAZ_CST_PIS}.
   *
   * @param cst the new iD: Q06<br>
   *          Código de Situação Tributária do PIS
   */
  public void setCst(SEFAZ_CST_PIS cst) {
    this.cst = cst;
  }

  /**
   * # iD: Q07<br>
   * Base de cálculo do PIS (13v2).
   *
   * @return the iD: Q07<br>
   *         Base de cálculo do PIS (13v2)
   */
  public BigDecimal getVBC() {
    return vBC;
  }

  /**
   * # iD: Q07<br>
   * Base de cálculo do PIS (13v2).
   *
   * @param vBC the new iD: Q07<br>
   *          Base de cálculo do PIS (13v2)
   */
  public void setVBC(BigDecimal vBC) {
    this.vBC = vBC;
  }

  /**
   * # iD: Q08<br>
   * Alíquota do PIS em percentual (3v2–4).
   *
   * @return the iD: Q08<br>
   *         Alíquota do PIS em percentual (3v2–4)
   */
  public BigDecimal getPPIS() {
    return pPIS;
  }

  /**
   * # iD: Q08<br>
   * Alíquota do PIS em percentual (3v2–4).
   *
   * @param pPIS the new iD: Q08<br>
   *          Alíquota do PIS em percentual (3v2–4)
   */
  public void setPPIS(BigDecimal pPIS) {
    this.pPIS = pPIS;
  }

  /**
   * # iD: Q09<br>
   * Valor do PIS (13v2).
   *
   * @return the iD: Q09<br>
   *         Valor do PIS (13v2)
   */
  public BigDecimal getVPIS() {
    return vPIS;
  }

  /**
   * # iD: Q09<br>
   * Valor do PIS (13v2).
   *
   * @param vPIS the new iD: Q09<br>
   *          Valor do PIS (13v2)
   */
  public void setVPIS(BigDecimal vPIS) {
    this.vPIS = vPIS;
  }

  /**
   * # iD: Q10<br>
   * Quantidade vendida para fins de cálculo (12v0–4).
   *
   * @return the iD: Q10<br>
   *         Quantidade vendida para fins de cálculo (12v0–4)
   */
  public BigDecimal getQBCProd() {
    return qBCProd;
  }

  /**
   * # iD: Q10<br>
   * Quantidade vendida para fins de cálculo (12v0–4).
   *
   * @param qBCProd the new iD: Q10<br>
   *          Quantidade vendida para fins de cálculo (12v0–4)
   */
  public void setQBCProd(BigDecimal qBCProd) {
    this.qBCProd = qBCProd;
  }

  /**
   * # iD: Q11<br>
   * Alíquota em reais por unidade de produto (11v0–4).
   *
   * @return the iD: Q11<br>
   *         Alíquota em reais por unidade de produto (11v0–4)
   */
  public BigDecimal getVAliqProd() {
    return vAliqProd;
  }

  /**
   * # iD: Q11<br>
   * Alíquota em reais por unidade de produto (11v0–4).
   *
   * @param vAliqProd the new iD: Q11<br>
   *          Alíquota em reais por unidade de produto (11v0–4)
   */
  public void setVAliqProd(BigDecimal vAliqProd) {
    this.vAliqProd = vAliqProd;
  }

}
