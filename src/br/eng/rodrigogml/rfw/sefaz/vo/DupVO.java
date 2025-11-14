package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Grupo de Parcelas da Fatura (TAG {@code dup}, ID Y07).<br>
 * Contém informações individuais de cada parcela da cobrança.<br>
 * <br>
 *
 * Ocorrência no grupo Y01: 0–120.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_parcela")
public class DupVO extends RFWVO {

  private static final long serialVersionUID = -7833270006195929397L;

  /**
   * ID: Y08 – Campo {@code nDup}.<br>
   * Número da parcela com 3 algarismos, sequenciais e consecutivos.<br>
   * Exemplos: "001", "002", "003"...<br>
   * Ocorrência: 0-1.<br>
   * Tamanho: 1–60 (SEFAZ exige padrão de 3 algarismos).
   */
  @RFWMetaStringField(caption = "Número da parcela", required = false, maxLength = 60)
  private String nDup = null;

  /**
   * ID: Y09 – Campo {@code dVenc}.<br>
   * Data de vencimento da parcela.<br>
   * Formato: "AAAA-MM-DD".<br>
   * Ocorrência: 0-1.
   */
  @RFWMetaStringField(caption = "Data de vencimento", required = false, maxLength = 10)
  private String dVenc = null;

  /**
   * ID: Y10 – Campo {@code vDup}.<br>
   * Valor da parcela.<br>
   * Ocorrência: 1-1.<br>
   * Formato: 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor da parcela", required = false, scale = 2, absolute = true)
  private BigDecimal vDup = null;

  /**
   * # iD: Y08 – Campo {@code nDup}.<br>
   * Número da parcela com 3 algarismos, sequenciais e consecutivos.<br>
   * Exemplos: "001", "002", "003"..<br>
   * Ocorrência: 0-1.<br>
   * Tamanho: 1–60 (SEFAZ exige padrão de 3 algarismos).
   *
   * @return the iD: Y08 – Campo {@code nDup}
   */
  public String getNDup() {
    return nDup;
  }

  /**
   * # iD: Y08 – Campo {@code nDup}.<br>
   * Número da parcela com 3 algarismos, sequenciais e consecutivos.<br>
   * Exemplos: "001", "002", "003"..<br>
   * Ocorrência: 0-1.<br>
   * Tamanho: 1–60 (SEFAZ exige padrão de 3 algarismos).
   *
   * @param nDup the new iD: Y08 – Campo {@code nDup}
   */
  public void setNDup(String nDup) {
    this.nDup = nDup;
  }

  /**
   * # iD: Y09 – Campo {@code dVenc}.<br>
   * Data de vencimento da parcela.<br>
   * Formato: "AAAA-MM-DD".<br>
   * Ocorrência: 0-1.
   *
   * @return the iD: Y09 – Campo {@code dVenc}
   */
  public String getDVenc() {
    return dVenc;
  }

  /**
   * # iD: Y09 – Campo {@code dVenc}.<br>
   * Data de vencimento da parcela.<br>
   * Formato: "AAAA-MM-DD".<br>
   * Ocorrência: 0-1.
   *
   * @param dVenc the new iD: Y09 – Campo {@code dVenc}
   */
  public void setDVenc(String dVenc) {
    this.dVenc = dVenc;
  }

  /**
   * # iD: Y10 – Campo {@code vDup}.<br>
   * Valor da parcela.<br>
   * Ocorrência: 1-1.<br>
   * Formato: 13v2.
   *
   * @return the iD: Y10 – Campo {@code vDup}
   */
  public BigDecimal getVDup() {
    return vDup;
  }

  /**
   * # iD: Y10 – Campo {@code vDup}.<br>
   * Valor da parcela.<br>
   * Ocorrência: 1-1.<br>
   * Formato: 13v2.
   *
   * @param vDup the new iD: Y10 – Campo {@code vDup}
   */
  public void setVDup(BigDecimal vDup) {
    this.vDup = vDup;
  }

}
