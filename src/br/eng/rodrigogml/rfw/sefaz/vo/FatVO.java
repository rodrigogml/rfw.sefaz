package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Grupo Fatura (TAG {@code fat}, ID Y02).<br>
 * Representa a fatura vinculada à cobrança da NF-e.<br>
 * <br>
 *
 * Ocorrência: 0-1 no grupo de cobrança Y01.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_fatura")
public class FatVO extends RFWVO {

  private static final long serialVersionUID = -5851469825579343906L;

  /**
   * ID: Y03 – Campo {@code nFat}.<br>
   * Número da fatura.<br>
   * Ocorrência: 0-1.<br>
   * Tamanho: 1–60 caracteres.
   */
  @RFWMetaStringField(caption = "Número da fatura", required = false, maxLength = 60)
  private String nFat = null;

  /**
   * ID: Y04 – Campo {@code vOrig}.<br>
   * Valor original da fatura antes de descontos.<br>
   * Ocorrência: 0-1.<br>
   * Formato: 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor original", required = false, scale = 2, absolute = true)
  private BigDecimal vOrig = null;

  /**
   * ID: Y05 – Campo {@code vDesc}.<br>
   * Valor total de descontos concedidos.<br>
   * Ocorrência: 0-1.<br>
   * Formato: 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor desconto", required = false, scale = 2, absolute = true)
  private BigDecimal vDesc = null;

  /**
   * ID: Y06 – Campo {@code vLiq}.<br>
   * Valor líquido da fatura após desconto.<br>
   * Ocorrência: 0-1.<br>
   * Formato: 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor líquido", required = false, scale = 2, absolute = true)
  private BigDecimal vLiq = null;

  /**
   * # iD: Y03 – Campo {@code nFat}.<br>
   * Número da fatura.<br>
   * Ocorrência: 0-1.<br>
   * Tamanho: 1–60 caracteres.
   *
   * @return the iD: Y03 – Campo {@code nFat}
   */
  public String getNFat() {
    return nFat;
  }

  /**
   * # iD: Y03 – Campo {@code nFat}.<br>
   * Número da fatura.<br>
   * Ocorrência: 0-1.<br>
   * Tamanho: 1–60 caracteres.
   *
   * @param nFat the new iD: Y03 – Campo {@code nFat}
   */
  public void setNFat(String nFat) {
    this.nFat = nFat;
  }

  /**
   * # iD: Y04 – Campo {@code vOrig}.<br>
   * Valor original da fatura antes de descontos.<br>
   * Ocorrência: 0-1.<br>
   * Formato: 13v2.
   *
   * @return the iD: Y04 – Campo {@code vOrig}
   */
  public BigDecimal getVOrig() {
    return vOrig;
  }

  /**
   * # iD: Y04 – Campo {@code vOrig}.<br>
   * Valor original da fatura antes de descontos.<br>
   * Ocorrência: 0-1.<br>
   * Formato: 13v2.
   *
   * @param vOrig the new iD: Y04 – Campo {@code vOrig}
   */
  public void setVOrig(BigDecimal vOrig) {
    this.vOrig = vOrig;
  }

  /**
   * # iD: Y05 – Campo {@code vDesc}.<br>
   * Valor total de descontos concedidos.<br>
   * Ocorrência: 0-1.<br>
   * Formato: 13v2.
   *
   * @return the iD: Y05 – Campo {@code vDesc}
   */
  public BigDecimal getVDesc() {
    return vDesc;
  }

  /**
   * # iD: Y05 – Campo {@code vDesc}.<br>
   * Valor total de descontos concedidos.<br>
   * Ocorrência: 0-1.<br>
   * Formato: 13v2.
   *
   * @param vDesc the new iD: Y05 – Campo {@code vDesc}
   */
  public void setVDesc(BigDecimal vDesc) {
    this.vDesc = vDesc;
  }

  /**
   * # iD: Y06 – Campo {@code vLiq}.<br>
   * Valor líquido da fatura após desconto.<br>
   * Ocorrência: 0-1.<br>
   * Formato: 13v2.
   *
   * @return the iD: Y06 – Campo {@code vLiq}
   */
  public BigDecimal getVLiq() {
    return vLiq;
  }

  /**
   * # iD: Y06 – Campo {@code vLiq}.<br>
   * Valor líquido da fatura após desconto.<br>
   * Ocorrência: 0-1.<br>
   * Formato: 13v2.
   *
   * @param vLiq the new iD: Y06 – Campo {@code vLiq}
   */
  public void setVLiq(BigDecimal vLiq) {
    this.vLiq = vLiq;
  }

}
