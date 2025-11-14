package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Description: Grupo de totais da NF-e (TAG {@code total}, ID W01).<br>
 * Este VO consolida os totais da nota fiscal, começando pelos totais de ICMS informados no subgrupo {@code ICMSTot} (ID W02).<br>
 * <br>
 * Estrutura principal:
 * <ul>
 * <li>W01 – {@code total}: grupo de totais da NF-e.</li>
 * <li>W02 – {@code ICMSTot}: totais referentes ao ICMS e valores globais da NF-e.</li>
 * </ul>
 *
 * A NF-e deve possuir exatamente um grupo {@code total} por documento autorizado.
 *
 * @author BIS DEVil
 * @since (11 de nov. de 2025)
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_total")
public class TotalVO extends RFWVO {

  private static final long serialVersionUID = -2109042558504329217L;

  /**
   * ID: W02<br>
   * Grupo de totais referentes ao ICMS ({@code ICMSTot}).<br>
   * Reúne os totais de ICMS próprio, ICMS-ST, FCP, valores globais de produtos, frete, seguro, descontos, tributos e o valor total da NF-e.<br>
   * Deve refletir o somatório dos respectivos campos dos itens da NF-e.
   */
  @RFWMetaRelationshipField(caption = "Totais de ICMS e da NF-e", required = false, relationship = RelationshipTypes.COMPOSITION, column = "id_icmstot")
  private ICMSTotVO icmsTot = null;

  /**
   * # iD: W02<br>
   * Grupo de totais referentes ao ICMS ({@code ICMSTot}).<br>
   * Reúne os totais de ICMS próprio, ICMS-ST, FCP, valores globais de produtos, frete, seguro, descontos, tributos e o valor total da NF-e.<br>
   * Deve refletir o somatório dos respectivos campos dos itens da NF-e.
   *
   * @return the iD: W02<br>
   *         Grupo de totais referentes ao ICMS ({@code ICMSTot})
   */
  public ICMSTotVO getIcmsTot() {
    return icmsTot;
  }

  /**
   * # iD: W02<br>
   * Grupo de totais referentes ao ICMS ({@code ICMSTot}).<br>
   * Reúne os totais de ICMS próprio, ICMS-ST, FCP, valores globais de produtos, frete, seguro, descontos, tributos e o valor total da NF-e.<br>
   * Deve refletir o somatório dos respectivos campos dos itens da NF-e.
   *
   * @param icmsTot the new iD: W02<br>
   *          Grupo de totais referentes ao ICMS ({@code ICMSTot})
   */
  public void setIcmsTot(ICMSTotVO icmsTot) {
    this.icmsTot = icmsTot;
  }
}
