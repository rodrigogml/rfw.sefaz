package br.eng.rodrigogml.rfw.sefaz.vos;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "PISST" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class PISSTVO extends RFWVO {

  private static final long serialVersionUID = 3802262404732900624L;

  /**
   * R02 vBC Valor da Base de Cálculo do PIS E R01.1 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valod BC do PIS", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vbc = null;

  /**
   * R03 pPIS Alíquota do PIS (em percentual) E R01.1 N 1-1 3v2-4
   */
  @RFWMetaBigDecimalField(caption = "Alíquota do PIS (%)", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = false)
  private BigDecimal ppis = null;

  /**
   * R04 qBCProd Quantidade Vendida E R031. N 1-1 12v0-4
   */
  @RFWMetaBigDecimalField(caption = "Quantidade Vendida", minValue = "0", maxValue = "999999999999.9999", scale = 0, scaleMax = 4, required = false)
  private BigDecimal qbcProd = null;

  /**
   * R05 vAliqProd Alíquota do PIS (em reais) E R03.1 N 1-1 11v0-4
   */
  @RFWMetaBigDecimalField(caption = "Alíquota do PIS ($)", minValue = "0", maxValue = "99999999999.9999", scale = 0, scaleMax = 4, required = false)
  private BigDecimal valiqProd = null;

  /**
   * R06 vPIS Valor do PIS E R01 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor do PIS", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vpis = null;

  /**
   * # r02 vBC Valor da Base de Cálculo do PIS E R01.1 N 1-1 13v2.
   *
   * @return # r02 vBC Valor da Base de Cálculo do PIS E R01
   */
  public BigDecimal getVbc() {
    return vbc;
  }

  /**
   * # r02 vBC Valor da Base de Cálculo do PIS E R01.1 N 1-1 13v2.
   *
   * @param vbc # r02 vBC Valor da Base de Cálculo do PIS E R01
   */
  public void setVbc(BigDecimal vbc) {
    this.vbc = vbc;
  }

  /**
   * # r03 pPIS Alíquota do PIS (em percentual) E R01.1 N 1-1 3v2-4.
   *
   * @return # r03 pPIS Alíquota do PIS (em percentual) E R01
   */
  public BigDecimal getPpis() {
    return ppis;
  }

  /**
   * # r03 pPIS Alíquota do PIS (em percentual) E R01.1 N 1-1 3v2-4.
   *
   * @param ppis # r03 pPIS Alíquota do PIS (em percentual) E R01
   */
  public void setPpis(BigDecimal ppis) {
    this.ppis = ppis;
  }

  /**
   * # r04 qBCProd Quantidade Vendida E R031. N 1-1 12v0-4.
   *
   * @return # r04 qBCProd Quantidade Vendida E R031
   */
  public BigDecimal getQbcProd() {
    return qbcProd;
  }

  /**
   * # r04 qBCProd Quantidade Vendida E R031. N 1-1 12v0-4.
   *
   * @param qbcProd # r04 qBCProd Quantidade Vendida E R031
   */
  public void setQbcProd(BigDecimal qbcProd) {
    this.qbcProd = qbcProd;
  }

  /**
   * # r05 vAliqProd Alíquota do PIS (em reais) E R03.1 N 1-1 11v0-4.
   *
   * @return # r05 vAliqProd Alíquota do PIS (em reais) E R03
   */
  public BigDecimal getValiqProd() {
    return valiqProd;
  }

  /**
   * # r05 vAliqProd Alíquota do PIS (em reais) E R03.1 N 1-1 11v0-4.
   *
   * @param valiqProd # r05 vAliqProd Alíquota do PIS (em reais) E R03
   */
  public void setValiqProd(BigDecimal valiqProd) {
    this.valiqProd = valiqProd;
  }

  /**
   * # r06 vPIS Valor do PIS E R01 N 1-1 13v2.
   *
   * @return # r06 vPIS Valor do PIS E R01 N 1-1 13v2
   */
  public BigDecimal getVpis() {
    return vpis;
  }

  /**
   * # r06 vPIS Valor do PIS E R01 N 1-1 13v2.
   *
   * @param vpis # r06 vPIS Valor do PIS E R01 N 1-1 13v2
   */
  public void setVpis(BigDecimal vpis) {
    this.vpis = vpis;
  }

}
