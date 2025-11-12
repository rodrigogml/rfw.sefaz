package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CST_COFINS;

/**
 * Grupo COFINS (TAG {@code COFINS}, ID S01).<br>
 * Este VO agrega os campos de todos os subgrupos da COFINS:
 * <ul>
 * <li>COFINSAliq (S02): vBC (S07), pCOFINS (S08), vCOFINS (S11)</li>
 * <li>COFINSQtde (S03): qBCProd (S09), vAliqProd (S10), vCOFINS (S11)</li>
 * <li>COFINSNT (S04): apenas CST (S06)</li>
 * <li>COFINSOutr (S05): pode usar {@code vBC/pCOFINS} ou {@code qBCProd/vAliqProd} + vCOFINS</li>
 * </ul>
 * O campo {@code cst} (S06) determina qual combinação deve ser preenchida.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_cofins")
public class COFINSVO extends RFWVO {

  private static final long serialVersionUID = -8852199287673186725L;

  /** ID: S06 – Código de Situação Tributária da COFINS. */
  @RFWMetaEnumField(caption = "Situação tributária COFINS", required = true)
  private SEFAZ_CST_COFINS cst = null;

  /** ID: S07 – Base de cálculo da COFINS (13v2). Usado em S02/S05 (alíquota %). */
  @RFWMetaBigDecimalField(caption = "Base de cálculo COFINS", required = false, scale = 2, absolute = true)
  private BigDecimal vBC = null;

  /** ID: S08 – Alíquota COFINS em percentual (3v2–4). Usado em S02/S05 (alíquota %). */
  @RFWMetaBigDecimalField(caption = "Alíquota COFINS (%)", required = false, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pCOFINS = null;

  /** ID: S09 – Quantidade vendida (12v0–4). Usado em S03/S05 (alíquota em R$). */
  @RFWMetaBigDecimalField(caption = "Quantidade para COFINS", required = false, scale = 0, scaleMax = 4, absolute = true)
  private BigDecimal qBCProd = null;

  /** ID: S10 – Alíquota em reais por unidade (11v0–4). Usado em S03/S05 (alíquota em R$). */
  @RFWMetaBigDecimalField(caption = "Alíquota (R$) COFINS", required = false, scale = 0, scaleMax = 4, absolute = true)
  private BigDecimal vAliqProd = null;

  /** ID: S11 – Valor da COFINS (13v2). Presente em S02/S03/S05. */
  @RFWMetaBigDecimalField(caption = "Valor da COFINS", required = false, scale = 2, absolute = true)
  private BigDecimal vCOFINS = null;

  /**
   * # iD: S06 – Código de Situação Tributária da COFINS.
   *
   * @return the iD: S06 – Código de Situação Tributária da COFINS
   */
  public SEFAZ_CST_COFINS getCst() {
    return cst;
  }

  /**
   * # iD: S06 – Código de Situação Tributária da COFINS.
   *
   * @param cst the new iD: S06 – Código de Situação Tributária da COFINS
   */
  public void setCst(SEFAZ_CST_COFINS cst) {
    this.cst = cst;
  }

  /**
   * # iD: S07 – Base de cálculo da COFINS (13v2). Usado em S02/S05 (alíquota %).
   *
   * @return the iD: S07 – Base de cálculo da COFINS (13v2)
   */
  public BigDecimal getVBC() {
    return vBC;
  }

  /**
   * # iD: S07 – Base de cálculo da COFINS (13v2). Usado em S02/S05 (alíquota %).
   *
   * @param vBC the new iD: S07 – Base de cálculo da COFINS (13v2)
   */
  public void setVBC(BigDecimal vBC) {
    this.vBC = vBC;
  }

  /**
   * # iD: S08 – Alíquota COFINS em percentual (3v2–4). Usado em S02/S05 (alíquota %).
   *
   * @return the iD: S08 – Alíquota COFINS em percentual (3v2–4)
   */
  public BigDecimal getPCOFINS() {
    return pCOFINS;
  }

  /**
   * # iD: S08 – Alíquota COFINS em percentual (3v2–4). Usado em S02/S05 (alíquota %).
   *
   * @param pCOFINS the new iD: S08 – Alíquota COFINS em percentual (3v2–4)
   */
  public void setPCOFINS(BigDecimal pCOFINS) {
    this.pCOFINS = pCOFINS;
  }

  /**
   * # iD: S09 – Quantidade vendida (12v0–4). Usado em S03/S05 (alíquota em R$).
   *
   * @return the iD: S09 – Quantidade vendida (12v0–4)
   */
  public BigDecimal getQBCProd() {
    return qBCProd;
  }

  /**
   * # iD: S09 – Quantidade vendida (12v0–4). Usado em S03/S05 (alíquota em R$).
   *
   * @param qBCProd the new iD: S09 – Quantidade vendida (12v0–4)
   */
  public void setQBCProd(BigDecimal qBCProd) {
    this.qBCProd = qBCProd;
  }

  /**
   * # iD: S10 – Alíquota em reais por unidade (11v0–4). Usado em S03/S05 (alíquota em R$).
   *
   * @return the iD: S10 – Alíquota em reais por unidade (11v0–4)
   */
  public BigDecimal getVAliqProd() {
    return vAliqProd;
  }

  /**
   * # iD: S10 – Alíquota em reais por unidade (11v0–4). Usado em S03/S05 (alíquota em R$).
   *
   * @param vAliqProd the new iD: S10 – Alíquota em reais por unidade (11v0–4)
   */
  public void setVAliqProd(BigDecimal vAliqProd) {
    this.vAliqProd = vAliqProd;
  }

  /**
   * # iD: S11 – Valor da COFINS (13v2). Presente em S02/S03/S05.
   *
   * @return the iD: S11 – Valor da COFINS (13v2)
   */
  public BigDecimal getVCOFINS() {
    return vCOFINS;
  }

  /**
   * # iD: S11 – Valor da COFINS (13v2). Presente em S02/S03/S05.
   *
   * @param vCOFINS the new iD: S11 – Valor da COFINS (13v2)
   */
  public void setVCOFINS(BigDecimal vCOFINS) {
    this.vCOFINS = vCOFINS;
  }

}