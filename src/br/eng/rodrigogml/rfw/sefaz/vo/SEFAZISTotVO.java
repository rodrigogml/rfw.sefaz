package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * ISTot - Grupo total do Imposto Seletivo.
 * <p>
 * O grupo de valores totais da NF-e deve ser informado com o somatório do campo correspondente dos itens.
 * <p>
 * O Imposto Seletivo é "por fora", devendo seu valor ser adicionado ao valor total da NF-e.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_istot")
public class SEFAZISTotVO extends RFWVO {

  private static final long serialVersionUID = 5800106790439125619L;

  /**
   * {@link SEFAZTotalVO}
   */
  @RFWMetaRelationshipField(caption = "Total", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_total")
  private SEFAZTotalVO totalVO = null;

  /**
   * vIS - Total do Imposto Seletivo.
   */
  @RFWMetaBigDecimalField(caption = "Total do Imposto Seletivo", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vis;

  /**
   * # {@link SEFAZTotalVO}.
   *
   * @return the {@link SEFAZTotalVO}
   */
  public SEFAZTotalVO getTotalVO() {
    return totalVO;
  }

  /**
   * # {@link SEFAZTotalVO}.
   *
   * @param totalVO the new {@link SEFAZTotalVO}
   */
  public void setTotalVO(SEFAZTotalVO totalVO) {
    this.totalVO = totalVO;
  }

  /**
   * # vIS - Total do Imposto Seletivo.
   *
   * @return the vIS - Total do Imposto Seletivo
   */
  public BigDecimal getVis() {
    return vis;
  }

  /**
   * # vIS - Total do Imposto Seletivo.
   *
   * @param vis the new vIS - Total do Imposto Seletivo
   */
  public void setVis(BigDecimal vis) {
    this.vis = vis;
  }

}
