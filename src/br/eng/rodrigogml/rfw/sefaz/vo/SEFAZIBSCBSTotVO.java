package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * IBSCBSTot - Totais da NF-e com IBS e CBS.
 * <p>
 * O grupo de valores totais da NF-e deve ser informado com o somatório do campo correspondente dos itens.
 * <p>
 * O IBS e a CBS são "por fora", devendo seus valores ser adicionados ao valor total da NF-e.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_ibscbstot")
public class SEFAZIBSCBSTotVO extends RFWVO {

  private static final long serialVersionUID = -3568538045147807190L;

  /**
   * {@link SEFAZTotalVO}
   */
  @RFWMetaRelationshipField(caption = "Total", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_total")
  private SEFAZTotalVO totalVO = null;

  /**
   * gIBS - Grupo total do IBS.
   */
  private SEFAZGIBSTotVO gibs;

  /**
   * gCBS - Grupo total da CBS.
   */
  private SEFAZGCBSTotVO gcbs;

  /**
   * gMono - Grupo total da Monofasia.
   */
  private SEFAZGMonoTotVO gmono;

  /**
   * gEstornoCred - Grupo total do Estorno de Crédito.
   */
  private SEFAZGEstornoCredTotVO gestornoCred;

  /**
   * vBCIBSCBS - Valor total da Base de Cálculo do IBS e da CBS.
   */
  @RFWMetaBigDecimalField(caption = "Base de Cálculo Total do IBS e CBS", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vbcIbsCbs;

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
   * # gIBS - Grupo total do IBS.
   *
   * @return the gIBS - Grupo total do IBS
   */
  public SEFAZGIBSTotVO getGibs() {
    return gibs;
  }

  /**
   * # gIBS - Grupo total do IBS.
   *
   * @param gibs the new gIBS - Grupo total do IBS
   */
  public void setGibs(SEFAZGIBSTotVO gibs) {
    this.gibs = gibs;
  }

  /**
   * # gCBS - Grupo total da CBS.
   *
   * @return the gCBS - Grupo total da CBS
   */
  public SEFAZGCBSTotVO getGcbs() {
    return gcbs;
  }

  /**
   * # gCBS - Grupo total da CBS.
   *
   * @param gcbs the new gCBS - Grupo total da CBS
   */
  public void setGcbs(SEFAZGCBSTotVO gcbs) {
    this.gcbs = gcbs;
  }

  /**
   * # gMono - Grupo total da Monofasia.
   *
   * @return the gMono - Grupo total da Monofasia
   */
  public SEFAZGMonoTotVO getGmono() {
    return gmono;
  }

  /**
   * # gMono - Grupo total da Monofasia.
   *
   * @param gmono the new gMono - Grupo total da Monofasia
   */
  public void setGmono(SEFAZGMonoTotVO gmono) {
    this.gmono = gmono;
  }

  /**
   * # gEstornoCred - Grupo total do Estorno de Crédito.
   *
   * @return the gEstornoCred - Grupo total do Estorno de Crédito
   */
  public SEFAZGEstornoCredTotVO getGestornoCred() {
    return gestornoCred;
  }

  /**
   * # gEstornoCred - Grupo total do Estorno de Crédito.
   *
   * @param gestornoCred the new gEstornoCred - Grupo total do Estorno de Crédito
   */
  public void setGestornoCred(SEFAZGEstornoCredTotVO gestornoCred) {
    this.gestornoCred = gestornoCred;
  }

  /**
   * # vBCIBSCBS - Valor total da Base de Cálculo do IBS e da CBS.
   *
   * @return the vBCIBSCBS - Valor total da Base de Cálculo do IBS e da CBS
   */
  public BigDecimal getVbcIbsCbs() {
    return vbcIbsCbs;
  }

  /**
   * # vBCIBSCBS - Valor total da Base de Cálculo do IBS e da CBS.
   *
   * @param vbcIbsCbs the new vBCIBSCBS - Valor total da Base de Cálculo do IBS e da CBS
   */
  public void setVbcIbsCbs(BigDecimal vbcIbsCbs) {
    this.vbcIbsCbs = vbcIbsCbs;
  }

}
