package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * gIBSCredPres - Grupo de Informações do Crédito Presumido referente ao IBS.
 * <p>
 * Utilizado quando o crédito presumido for aproveitado pelo emitente do documento.
 */
public class SEFAZGIBSCredPresVO extends RFWVO {

  private static final long serialVersionUID = 2826809020904433943L;

  /**
   * {@link SEFAZGCredPresOperVO}
   */
  @RFWMetaRelationshipField(caption = "IBSCBS", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true)
  private SEFAZGCredPresOperVO gcredPresOperVO = null;

  /**
   * pCredPres - Percentual do Crédito Presumido do IBS.
   */
  @RFWMetaBigDecimalField(caption = "Percentual do Crédito Presumido do IBS", required = true, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pcredPres;

  /**
   * vCredPres - Valor do Crédito Presumido do IBS.
   */
  @RFWMetaBigDecimalField(caption = "Valor do Crédito Presumido do IBS", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vcredPres;

  /**
   * vCredPresCondSus - Valor do Crédito Presumido do IBS em condição suspensiva.
   */
  @RFWMetaBigDecimalField(caption = "Valor do Crédito Presumido do IBS em Condição Suspensiva", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vcredPresCondSus;

  /**
   * # {@link SEFAZGCredPresOperVO}.
   *
   * @return the {@link SEFAZGCredPresOperVO}
   */
  public SEFAZGCredPresOperVO getGcredPresOperVO() {
    return gcredPresOperVO;
  }

  /**
   * # {@link SEFAZGCredPresOperVO}.
   *
   * @param gcredPresOperVO the new {@link SEFAZGCredPresOperVO}
   */
  public void setGcredPresOperVO(SEFAZGCredPresOperVO gcredPresOperVO) {
    this.gcredPresOperVO = gcredPresOperVO;
  }

  /**
   * # pCredPres - Percentual do Crédito Presumido do IBS.
   *
   * @return the pCredPres - Percentual do Crédito Presumido do IBS
   */
  public BigDecimal getPcredPres() {
    return pcredPres;
  }

  /**
   * # pCredPres - Percentual do Crédito Presumido do IBS.
   *
   * @param pcredPres the new pCredPres - Percentual do Crédito Presumido do IBS
   */
  public void setPcredPres(BigDecimal pcredPres) {
    this.pcredPres = pcredPres;
  }

  /**
   * # vCredPres - Valor do Crédito Presumido do IBS.
   *
   * @return the vCredPres - Valor do Crédito Presumido do IBS
   */
  public BigDecimal getVcredPres() {
    return vcredPres;
  }

  /**
   * # vCredPres - Valor do Crédito Presumido do IBS.
   *
   * @param vcredPres the new vCredPres - Valor do Crédito Presumido do IBS
   */
  public void setVcredPres(BigDecimal vcredPres) {
    this.vcredPres = vcredPres;
  }

  /**
   * # vCredPresCondSus - Valor do Crédito Presumido do IBS em condição suspensiva.
   *
   * @return the vCredPresCondSus - Valor do Crédito Presumido do IBS em condição suspensiva
   */
  public BigDecimal getVcredPresCondSus() {
    return vcredPresCondSus;
  }

  /**
   * # vCredPresCondSus - Valor do Crédito Presumido do IBS em condição suspensiva.
   *
   * @param vcredPresCondSus the new vCredPresCondSus - Valor do Crédito Presumido do IBS em condição suspensiva
   */
  public void setVcredPresCondSus(BigDecimal vcredPresCondSus) {
    this.vcredPresCondSus = vcredPresCondSus;
  }
}
