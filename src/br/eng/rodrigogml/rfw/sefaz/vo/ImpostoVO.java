package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Classe que representa a tag <b>imposto</b> (Tributos incidentes no Produto ou Serviço) do XML da SEFAZ.<br>
 * Grupo <b>M01</b> — contém informações de tributos federais, estaduais e municipais referentes ao item da NF-e/NFC-e.<br>
 * Observação: O grupo ISSQN é mutuamente exclusivo com os grupos ICMS e II. Ou seja, caso ISSQN seja informado, ICMS e II não devem ser incluídos (e vice-versa).
 *
 * <p>
 * <b>Fonte:</b> Tabela NT 2013/003.
 * </p>
 *
 * @author BIS DEVil
 * @since 1.0.0
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_imposto")
public class ImpostoVO extends RFWVO {

  private static final long serialVersionUID = 621095716071205212L;

  /**
   * ID: M02 — vTotTrib.<br>
   * Valor aproximado total dos tributos federais, estaduais e municipais incidentes sobre o item. Campo opcional.<br>
   * Formato: 13v2.
   * <p>
   * Referência: NT 2013/003.
   * </p>
   */
  @RFWMetaBigDecimalField(caption = "Valor total de tributos", maxValue = "9999999999999.99", minValue = "0", scale = 2, scaleMax = 2, required = false, absolute = true)
  private BigDecimal vTotTrib = null;

  /**
   * # iD: M02 — vTotTrib.<br>
   * Valor aproximado total dos tributos federais, estaduais e municipais incidentes sobre o item. Campo opcional.<br>
   * Formato: 13v2.
   * <p>
   * Referência: NT 2013/003.
   * </p>
   * .
   *
   * @return the iD: M02 — vTotTrib
   */
  public BigDecimal getVTotTrib() {
    return vTotTrib;
  }

  /**
   * # iD: M02 — vTotTrib.<br>
   * Valor aproximado total dos tributos federais, estaduais e municipais incidentes sobre o item. Campo opcional.<br>
   * Formato: 13v2.
   * <p>
   * Referência: NT 2013/003.
   * </p>
   * .
   *
   * @param vTotTrib the new iD: M02 — vTotTrib
   */
  public void setVTotTrib(BigDecimal vTotTrib) {
    this.vTotTrib = vTotTrib;
  }

}
