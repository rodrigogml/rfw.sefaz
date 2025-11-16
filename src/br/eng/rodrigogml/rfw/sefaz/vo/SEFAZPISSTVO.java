package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Grupo PIS Substituição Tributária (TAG {@code PISST}, ID R01).<br>
 * Consolidado em objeto próprio conforme documentação MOC:
 * <ul>
 * <li>R02 – vBC (Base de cálculo do PIS ST, 13v2)</li>
 * <li>R03 – pPIS (Alíquota do PIS ST em %, 3v2–4)</li>
 * <li>R04 – qBCProd (Quantidade vendida, 12v0–4)</li>
 * <li>R05 – vAliqProd (Alíquota do PIS ST em R$/un, 11v0–4)</li>
 * <li>R06 – vPIS (Valor do PIS ST, 13v2)</li>
 * </ul>
 * Observação: as “Sequências XML” (R01.1 e R03.1) são apenas agrupamentos e não geram campos adicionais.
 *
 * @author BIS DEVil
 * @since (11 de nov. de 2025)
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_pisst")
public class SEFAZPISSTVO extends RFWVO {

  private static final long serialVersionUID = 3529187641203341903L;

  /** ID: R02 – Base de cálculo do PIS ST (13v2). */
  @RFWMetaBigDecimalField(caption = "Base de cálculo PIS ST", required = false, scale = 2, absolute = true)
  private BigDecimal vBC = null;

  /** ID: R03 – Alíquota do PIS ST em percentual (3v2–4). */
  @RFWMetaBigDecimalField(caption = "Alíquota PIS ST (%)", required = false, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pPIS = null;

  /** ID: R04 – Quantidade vendida para cálculo do PIS ST (12v0–4). */
  @RFWMetaBigDecimalField(caption = "Quantidade para ST", required = false, scale = 0, scaleMax = 4, absolute = true)
  private BigDecimal qBCProd = null;

  /** ID: R05 – Alíquota do PIS ST em reais por unidade (11v0–4). */
  @RFWMetaBigDecimalField(caption = "Alíquota (R$) PIS ST", required = false, scale = 0, scaleMax = 4, absolute = true)
  private BigDecimal vAliqProd = null;

  /** ID: R06 – Valor do PIS ST (13v2). */
  @RFWMetaBigDecimalField(caption = "Valor do PIS ST", required = false, scale = 2, absolute = true)
  private BigDecimal vPIS = null;

  /**
   * # iD: R02 – Base de cálculo do PIS ST (13v2).
   *
   * @return the iD: R02 – Base de cálculo do PIS ST (13v2)
   */
  public BigDecimal getVBC() {
    return vBC;
  }

  /**
   * # iD: R02 – Base de cálculo do PIS ST (13v2).
   *
   * @param vBC the new iD: R02 – Base de cálculo do PIS ST (13v2)
   */
  public void setVBC(BigDecimal vBC) {
    this.vBC = vBC;
  }

  /**
   * # iD: R03 – Alíquota do PIS ST em percentual (3v2–4).
   *
   * @return the iD: R03 – Alíquota do PIS ST em percentual (3v2–4)
   */
  public BigDecimal getPPIS() {
    return pPIS;
  }

  /**
   * # iD: R03 – Alíquota do PIS ST em percentual (3v2–4).
   *
   * @param pPIS the new iD: R03 – Alíquota do PIS ST em percentual (3v2–4)
   */
  public void setPPIS(BigDecimal pPIS) {
    this.pPIS = pPIS;
  }

  /**
   * # iD: R04 – Quantidade vendida para cálculo do PIS ST (12v0–4).
   *
   * @return the iD: R04 – Quantidade vendida para cálculo do PIS ST (12v0–4)
   */
  public BigDecimal getQBCProd() {
    return qBCProd;
  }

  /**
   * # iD: R04 – Quantidade vendida para cálculo do PIS ST (12v0–4).
   *
   * @param qBCProd the new iD: R04 – Quantidade vendida para cálculo do PIS ST (12v0–4)
   */
  public void setQBCProd(BigDecimal qBCProd) {
    this.qBCProd = qBCProd;
  }

  /**
   * # iD: R05 – Alíquota do PIS ST em reais por unidade (11v0–4).
   *
   * @return the iD: R05 – Alíquota do PIS ST em reais por unidade (11v0–4)
   */
  public BigDecimal getVAliqProd() {
    return vAliqProd;
  }

  /**
   * # iD: R05 – Alíquota do PIS ST em reais por unidade (11v0–4).
   *
   * @param vAliqProd the new iD: R05 – Alíquota do PIS ST em reais por unidade (11v0–4)
   */
  public void setVAliqProd(BigDecimal vAliqProd) {
    this.vAliqProd = vAliqProd;
  }

  /**
   * # iD: R06 – Valor do PIS ST (13v2).
   *
   * @return the iD: R06 – Valor do PIS ST (13v2)
   */
  public BigDecimal getVPIS() {
    return vPIS;
  }

  /**
   * # iD: R06 – Valor do PIS ST (13v2).
   *
   * @param vPIS the new iD: R06 – Valor do PIS ST (13v2)
   */
  public void setVPIS(BigDecimal vPIS) {
    this.vPIS = vPIS;
  }

}