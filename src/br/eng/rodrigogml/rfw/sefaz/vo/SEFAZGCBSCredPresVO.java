package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * gCBSCredPres - Grupo de Informações do Crédito Presumido referente à CBS.
 * <p>
 * Utilizado quando o crédito presumido for aproveitado pelo emitente do documento.
 */
public class SEFAZGCBSCredPresVO extends RFWVO {

  private static final long serialVersionUID = 2262890303535372611L;

  /**
   * {@link SEFAZGCredPresOperVO}
   */
  @RFWMetaRelationshipField(caption = "IBSCBS", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true)
  private SEFAZGCredPresOperVO gcredPresOperVO = null;

  /**
   * pCredPres - Percentual do Crédito Presumido da CBS.
   */
  @RFWMetaBigDecimalField(caption = "Percentual do Crédito Presumido da CBS", required = true, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pcredPres;

  /**
   * vCredPres - Valor do Crédito Presumido da CBS.
   */
  @RFWMetaBigDecimalField(caption = "Valor do Crédito Presumido da CBS", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vcredPres;

  /**
   * vCredPresCondSus - Valor do Crédito Presumido da CBS em condição suspensiva.
   */
  @RFWMetaBigDecimalField(caption = "Valor do Crédito Presumido da CBS em Condição Suspensiva", required = true, scale = 2, scaleMax = 2, absolute = true)
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
   * # pCredPres - Percentual do Crédito Presumido da CBS.
   *
   * @return the pCredPres - Percentual do Crédito Presumido da CBS
   */
  public BigDecimal getPcredPres() {
    return pcredPres;
  }

  /**
   * # pCredPres - Percentual do Crédito Presumido da CBS.
   *
   * @param pcredPres the new pCredPres - Percentual do Crédito Presumido da CBS
   */
  public void setPcredPres(BigDecimal pcredPres) {
    this.pcredPres = pcredPres;
  }

  /**
   * # vCredPres - Valor do Crédito Presumido da CBS.
   *
   * @return the vCredPres - Valor do Crédito Presumido da CBS
   */
  public BigDecimal getVcredPres() {
    return vcredPres;
  }

  /**
   * # vCredPres - Valor do Crédito Presumido da CBS.
   *
   * @param vcredPres the new vCredPres - Valor do Crédito Presumido da CBS
   */
  public void setVcredPres(BigDecimal vcredPres) {
    this.vcredPres = vcredPres;
  }

  /**
   * # vCredPresCondSus - Valor do Crédito Presumido da CBS em condição suspensiva.
   *
   * @return the vCredPresCondSus - Valor do Crédito Presumido da CBS em condição suspensiva
   */
  public BigDecimal getVcredPresCondSus() {
    return vcredPresCondSus;
  }

  /**
   * # vCredPresCondSus - Valor do Crédito Presumido da CBS em condição suspensiva.
   *
   * @param vcredPresCondSus the new vCredPresCondSus - Valor do Crédito Presumido da CBS em condição suspensiva
   */
  public void setVcredPresCondSus(BigDecimal vcredPresCondSus) {
    this.vcredPresCondSus = vcredPresCondSus;
  }
}
