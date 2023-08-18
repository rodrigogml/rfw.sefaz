package br.eng.rodrigogml.rfw.sefaz.vos;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "COFINSST" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class COFINSSTVO extends RFWVO {

  private static final long serialVersionUID = 3802262404732900624L;

  /**
   * T02 vBC Valor da Base de Cálculo da COFINS E T01.1 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valod BC do COFINS", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = false)
  private BigDecimal vbc = null;

  /**
   * T03 pCOFINS Alíquota da COFINS (em percentual) E T01.1 N 1-1 3v2-4
   */
  @RFWMetaBigDecimalField(caption = "Alíquota do COFINS (%)", minValue = "0", maxValue = "999.9999", scale = 0, scaleMax = 4, required = false)
  private BigDecimal pcofins = null;

  /**
   * T04 qBCProd Quantidade Vendida E T03.1 N 1-1 12v0-4
   */
  @RFWMetaBigDecimalField(caption = "Quantidade Vendida", minValue = "0", maxValue = "999999999999.9999", scale = 0, scaleMax = 4, required = false)
  private BigDecimal qbcProd = null;

  /**
   * T05 vAliqProd Alíquota da COFINS (em reais) E T03.1 N 1-1 11v0-4
   */
  @RFWMetaBigDecimalField(caption = "Alíquota do COFINS ($)", minValue = "0", maxValue = "99999999999.9999", scale = 0, scaleMax = 4, required = false)
  private BigDecimal valiqProd = null;

  /**
   * T06 vCOFINS Valor da COFINS E T01 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor do COFINS", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = false)
  private BigDecimal vcofins = null;

  /**
   * # t02 vBC Valor da Base de Cálculo da COFINS E T01.1 N 1-1 13v2.
   *
   * @return # t02 vBC Valor da Base de Cálculo da COFINS E T01
   */
  public BigDecimal getVbc() {
    return vbc;
  }

  /**
   * # t02 vBC Valor da Base de Cálculo da COFINS E T01.1 N 1-1 13v2.
   *
   * @param vbc # t02 vBC Valor da Base de Cálculo da COFINS E T01
   */
  public void setVbc(BigDecimal vbc) {
    this.vbc = vbc;
  }

  /**
   * # t03 pCOFINS Alíquota da COFINS (em percentual) E T01.1 N 1-1 3v2-4.
   *
   * @return # t03 pCOFINS Alíquota da COFINS (em percentual) E T01
   */
  public BigDecimal getPcofins() {
    return pcofins;
  }

  /**
   * # t03 pCOFINS Alíquota da COFINS (em percentual) E T01.1 N 1-1 3v2-4.
   *
   * @param pcofins # t03 pCOFINS Alíquota da COFINS (em percentual) E T01
   */
  public void setPcofins(BigDecimal pcofins) {
    this.pcofins = pcofins;
  }

  /**
   * # t04 qBCProd Quantidade Vendida E T03.1 N 1-1 12v0-4.
   *
   * @return # t04 qBCProd Quantidade Vendida E T03
   */
  public BigDecimal getQbcProd() {
    return qbcProd;
  }

  /**
   * # t04 qBCProd Quantidade Vendida E T03.1 N 1-1 12v0-4.
   *
   * @param qbcProd # t04 qBCProd Quantidade Vendida E T03
   */
  public void setQbcProd(BigDecimal qbcProd) {
    this.qbcProd = qbcProd;
  }

  /**
   * # t05 vAliqProd Alíquota da COFINS (em reais) E T03.1 N 1-1 11v0-4.
   *
   * @return # t05 vAliqProd Alíquota da COFINS (em reais) E T03
   */
  public BigDecimal getValiqProd() {
    return valiqProd;
  }

  /**
   * # t05 vAliqProd Alíquota da COFINS (em reais) E T03.1 N 1-1 11v0-4.
   *
   * @param valiqProd # t05 vAliqProd Alíquota da COFINS (em reais) E T03
   */
  public void setValiqProd(BigDecimal valiqProd) {
    this.valiqProd = valiqProd;
  }

  /**
   * # t06 vCOFINS Valor da COFINS E T01 N 1-1 13v2.
   *
   * @return # t06 vCOFINS Valor da COFINS E T01 N 1-1 13v2
   */
  public BigDecimal getVcofins() {
    return vcofins;
  }

  /**
   * # t06 vCOFINS Valor da COFINS E T01 N 1-1 13v2.
   *
   * @param vcofins # t06 vCOFINS Valor da COFINS E T01 N 1-1 13v2
   */
  public void setVcofins(BigDecimal vcofins) {
    this.vcofins = vcofins;
  }

}
