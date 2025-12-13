package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * gIBS - Grupo total do IBS.
 */
public class SEFAZGIBSTotVO extends RFWVO {

  private static final long serialVersionUID = 3120873599948294425L;

  /**
   * {@link SEFAZIBSCBSTotVO}
   */
  @RFWMetaRelationshipField(caption = "Total", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true)
  private SEFAZIBSCBSTotVO ibsCBSTotVO = null;

  /**
   * gIBSUF - Grupo total do IBS da UF.
   */
  private SEFAZGIBSUFTotVO gibsUf;

  /**
   * gIBSMun - Grupo total do IBS do Município.
   */
  private SEFAZGIBSMunTotVO gibsMun;

  /**
   * vIBS - Valor total do IBS.
   */
  @RFWMetaBigDecimalField(caption = "Valor Total do IBS", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vibs;

  /**
   * vCredPres - Valor total do crédito presumido do IBS.
   */
  @RFWMetaBigDecimalField(caption = "Total do Crédito Presumido do IBS", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vcredPres;

  /**
   * vCredPresCondSus - Valor total do crédito presumido do IBS em condição suspensiva.
   */
  @RFWMetaBigDecimalField(caption = "Total do Crédito Presumido do IBS em Condição Suspensiva", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vcredPresCondSus;

  /**
   * # {@link SEFAZIBSCBSTotVO}.
   *
   * @return the {@link SEFAZIBSCBSTotVO}
   */
  public SEFAZIBSCBSTotVO getIbsCBSTotVO() {
    return ibsCBSTotVO;
  }

  /**
   * # {@link SEFAZIBSCBSTotVO}.
   *
   * @param ibsCBSTotVO the new {@link SEFAZIBSCBSTotVO}
   */
  public void setIbsCBSTotVO(SEFAZIBSCBSTotVO ibsCBSTotVO) {
    this.ibsCBSTotVO = ibsCBSTotVO;
  }

  /**
   * # gIBSUF - Grupo total do IBS da UF.
   *
   * @return the gIBSUF - Grupo total do IBS da UF
   */
  public SEFAZGIBSUFTotVO getGibsUf() {
    return gibsUf;
  }

  /**
   * # gIBSUF - Grupo total do IBS da UF.
   *
   * @param gibsUf the new gIBSUF - Grupo total do IBS da UF
   */
  public void setGibsUf(SEFAZGIBSUFTotVO gibsUf) {
    this.gibsUf = gibsUf;
  }

  /**
   * # gIBSMun - Grupo total do IBS do Município.
   *
   * @return the gIBSMun - Grupo total do IBS do Município
   */
  public SEFAZGIBSMunTotVO getGibsMun() {
    return gibsMun;
  }

  /**
   * # gIBSMun - Grupo total do IBS do Município.
   *
   * @param gibsMun the new gIBSMun - Grupo total do IBS do Município
   */
  public void setGibsMun(SEFAZGIBSMunTotVO gibsMun) {
    this.gibsMun = gibsMun;
  }

  /**
   * # vIBS - Valor total do IBS.
   *
   * @return the vIBS - Valor total do IBS
   */
  public BigDecimal getVibs() {
    return vibs;
  }

  /**
   * # vIBS - Valor total do IBS.
   *
   * @param vibs the new vIBS - Valor total do IBS
   */
  public void setVibs(BigDecimal vibs) {
    this.vibs = vibs;
  }

  /**
   * # vCredPres - Valor total do crédito presumido do IBS.
   *
   * @return the vCredPres - Valor total do crédito presumido do IBS
   */
  public BigDecimal getVcredPres() {
    return vcredPres;
  }

  /**
   * # vCredPres - Valor total do crédito presumido do IBS.
   *
   * @param vcredPres the new vCredPres - Valor total do crédito presumido do IBS
   */
  public void setVcredPres(BigDecimal vcredPres) {
    this.vcredPres = vcredPres;
  }

  /**
   * # vCredPresCondSus - Valor total do crédito presumido do IBS em condição suspensiva.
   *
   * @return the vCredPresCondSus - Valor total do crédito presumido do IBS em condição suspensiva
   */
  public BigDecimal getVcredPresCondSus() {
    return vcredPresCondSus;
  }

  /**
   * # vCredPresCondSus - Valor total do crédito presumido do IBS em condição suspensiva.
   *
   * @param vcredPresCondSus the new vCredPresCondSus - Valor total do crédito presumido do IBS em condição suspensiva
   */
  public void setVcredPresCondSus(BigDecimal vcredPresCondSus) {
    this.vcredPresCondSus = vcredPresCondSus;
  }
}
