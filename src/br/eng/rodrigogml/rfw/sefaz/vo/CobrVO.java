package br.eng.rodrigogml.rfw.sefaz.vo;

import java.util.List;

import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Grupo de Cobrança da NF-e (TAG {@code cobr}, ID Y01).<br>
 * Pai dos grupos de Fatura (Y02) e Parcelas (Y07).<br>
 * <br>
 *
 * Ocorrência: 0-1.<br>
 * Utilizado quando existe cobrança agregada à operação comercial.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_cobr")
public class CobrVO extends RFWVO {

  private static final long serialVersionUID = 4701613484062145586L;

  /**
   * Grupo Fatura (TAG {@code fat}, ID Y02).<br>
   * Contém dados do número, valor original, descontos e valor líquido. Ocorrência: 0-1.
   */
  private FatVO fat = null;

  /**
   * Lista de parcelas (TAG {@code dup}, ID Y07).<br>
   * Ocorrência: 0-120 parcelas.<br>
   * Cada parcela define número, data de vencimento e valor.
   */
  private List<DupVO> parcelas = null;

}
