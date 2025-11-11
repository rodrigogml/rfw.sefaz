package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Classe que representa a tag <b>det</b> (Detalhamento de Produtos e Serviços) do XML da SEFAZ.<br>
 * ID: H01 — Grupo de detalhamento dos itens da NF-e.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_det")
public class DetVO extends RFWVO {

  private static final long serialVersionUID = -9048704109273818892L;

  /**
   * ID: H02 — nItem.<br>
   * Número sequencial do item na NF-e.<br>
   * Tipo: N — Tamanho: 1–3 — Intervalo: 1–990.
   */
  @RFWMetaBigDecimalField(caption = "Número do item", required = false, unique = false, minValue = "1", maxValue = "990", scale = 0, absolute = true)
  private BigDecimal nItem = null;

  /**
   * # iD: H02 — nItem.<br>
   * Número sequencial do item na NF-e.<br>
   * Tipo: N — Tamanho: 1–3 — Intervalo: 1–990.
   *
   * @return the iD: H02 — nItem
   */
  public BigDecimal getNItem() {
    return nItem;
  }

  /**
   * # iD: H02 — nItem.<br>
   * Número sequencial do item na NF-e.<br>
   * Tipo: N — Tamanho: 1–3 — Intervalo: 1–990.
   *
   * @param nItem the new iD: H02 — nItem
   */
  public void setNItem(BigDecimal nItem) {
    this.nItem = nItem;
  }

}
