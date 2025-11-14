package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * COFINS Substituição Tributária (TAG {@code COFINSST}, ID T01).<br>
 * Grupo opcional para informar COFINS de Substituição Tributária do item.<br>
 * <ul>
 * <li>Cálculo em percentual: vBC (T02) + pCOFINS (T03) ? vCOFINS (T06)</li>
 * <li>Cálculo em valor: qBCProd (T04) + vAliqProd (T05) ? vCOFINS (T06)</li>
 * </ul>
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_cofinsst")
public class COFINSSTVO extends RFWVO {

  private static final long serialVersionUID = -4898532645109388735L;

  /**
   * ID: T02 – Valor da Base de Cálculo da COFINS ST (13v2).<br>
   * Utilizado quando o cálculo é feito em percentual.
   */
  @RFWMetaBigDecimalField(caption = "Base de cálculo COFINS ST", required = false, scale = 2, absolute = true, minValue = "0")
  private BigDecimal vBC = null;

  /**
   * ID: T03 – Alíquota da COFINS ST em percentual (3v2-4).<br>
   * Utilizada em conjunto com {@link #vBC}.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota COFINS ST (%)", required = false, scale = 2, scaleMax = 4, absolute = true, minValue = "0")
  private BigDecimal pCOFINS = null;

  /**
   * ID: T04 – Quantidade vendida (12v0-4).<br>
   * Utilizada quando o cálculo da COFINS ST é em valor por unidade.
   */
  @RFWMetaBigDecimalField(caption = "Quantidade para COFINS ST", required = false, scale = 0, scaleMax = 4, absolute = true, minValue = "0")
  private BigDecimal qBCProd = null;

  /**
   * ID: T05 – Alíquota da COFINS ST em reais (11v0-4).<br>
   * Utilizada em conjunto com {@link #qBCProd}.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota COFINS ST (R$)", required = false, scale = 0, scaleMax = 4, absolute = true, minValue = "0")
  private BigDecimal vAliqProd = null;

  /**
   * ID: T06 – Valor da COFINS ST (13v2).<br>
   * Resultado do cálculo, tanto em percentual quanto em valor.
   */
  @RFWMetaBigDecimalField(caption = "Valor da COFINS ST", required = false, scale = 2, absolute = true, minValue = "0")
  private BigDecimal vCOFINS = null;

  /**
   * # iD: T02 – Valor da Base de Cálculo da COFINS ST (13v2).<br>
   * Utilizado quando o cálculo é feito em percentual.
   *
   * @return the iD: T02 – Valor da Base de Cálculo da COFINS ST (13v2)
   */
  public BigDecimal getVBC() {
    return vBC;
  }

  /**
   * # iD: T02 – Valor da Base de Cálculo da COFINS ST (13v2).<br>
   * Utilizado quando o cálculo é feito em percentual.
   *
   * @param vBC the new iD: T02 – Valor da Base de Cálculo da COFINS ST (13v2)
   */
  public void setVBC(BigDecimal vBC) {
    this.vBC = vBC;
  }

  /**
   * # iD: T03 – Alíquota da COFINS ST em percentual (3v2-4).<br>
   * Utilizada em conjunto com {@link #vBC}.
   *
   * @return the iD: T03 – Alíquota da COFINS ST em percentual (3v2-4)
   */
  public BigDecimal getPCOFINS() {
    return pCOFINS;
  }

  /**
   * # iD: T03 – Alíquota da COFINS ST em percentual (3v2-4).<br>
   * Utilizada em conjunto com {@link #vBC}.
   *
   * @param pCOFINS the new iD: T03 – Alíquota da COFINS ST em percentual (3v2-4)
   */
  public void setPCOFINS(BigDecimal pCOFINS) {
    this.pCOFINS = pCOFINS;
  }

  /**
   * # iD: T04 – Quantidade vendida (12v0-4).<br>
   * Utilizada quando o cálculo da COFINS ST é em valor por unidade.
   *
   * @return the iD: T04 – Quantidade vendida (12v0-4)
   */
  public BigDecimal getQBCProd() {
    return qBCProd;
  }

  /**
   * # iD: T04 – Quantidade vendida (12v0-4).<br>
   * Utilizada quando o cálculo da COFINS ST é em valor por unidade.
   *
   * @param qBCProd the new iD: T04 – Quantidade vendida (12v0-4)
   */
  public void setQBCProd(BigDecimal qBCProd) {
    this.qBCProd = qBCProd;
  }

  /**
   * # iD: T05 – Alíquota da COFINS ST em reais (11v0-4).<br>
   * Utilizada em conjunto com {@link #qBCProd}.
   *
   * @return the iD: T05 – Alíquota da COFINS ST em reais (11v0-4)
   */
  public BigDecimal getVAliqProd() {
    return vAliqProd;
  }

  /**
   * # iD: T05 – Alíquota da COFINS ST em reais (11v0-4).<br>
   * Utilizada em conjunto com {@link #qBCProd}.
   *
   * @param vAliqProd the new iD: T05 – Alíquota da COFINS ST em reais (11v0-4)
   */
  public void setVAliqProd(BigDecimal vAliqProd) {
    this.vAliqProd = vAliqProd;
  }

  /**
   * # iD: T06 – Valor da COFINS ST (13v2).<br>
   * Resultado do cálculo, tanto em percentual quanto em valor.
   *
   * @return the iD: T06 – Valor da COFINS ST (13v2)
   */
  public BigDecimal getVCOFINS() {
    return vCOFINS;
  }

  /**
   * # iD: T06 – Valor da COFINS ST (13v2).<br>
   * Resultado do cálculo, tanto em percentual quanto em valor.
   *
   * @param vCOFINS the new iD: T06 – Valor da COFINS ST (13v2)
   */
  public void setVCOFINS(BigDecimal vCOFINS) {
    this.vCOFINS = vCOFINS;
  }
}