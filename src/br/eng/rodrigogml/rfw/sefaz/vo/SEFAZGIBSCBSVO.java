package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * gIBSCBS - Grupo de Informações do IBS e da CBS.
 */
public class SEFAZGIBSCBSVO extends RFWVO {

  private static final long serialVersionUID = -7218979796186761492L;

  /**
   * {@link SEFAZIBSCBSVO}
   */
  @RFWMetaRelationshipField(caption = "IBSCBS", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true)
  private SEFAZIBSCBSVO ibsCBSVO = null;

  /**
   * gIBSUF - Grupo de Informações do IBS da UF.
   */
  private SEFAZGIBSUFVO gibsUFVO;

  /**
   * gIBSMun - Grupo de Informações do IBS do Município.
   */
  private SEFAZGIBSMunVO gibsMunVO;

  /**
   * vIBS - Valor total do IBS.
   */
  @RFWMetaBigDecimalField(caption = "Valor do IBS", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vibs;

  /**
   * gCBS - Grupo de Informações da CBS.
   */
  private SEFAZGCBSVO gcbs;

  /**
   * gTribRegular - Grupo de Informações da Tributação Regular.
   */
  private SEFAZGTribRegularVO gtribRegular;

  /**
   * gTransfCred - Grupo de Transferências de Crédito.
   */
  private SEFAZGTransfCredVO gtransfCred;

  /**
   * gAjusteCompet - Grupo de Ajuste de Competência.
   */
  private SEFAZGAjusteCompetVO gajusteCompet;

  /**
   * vBC - Base de Cálculo do IBS e CBS.
   */
  @RFWMetaBigDecimalField(caption = "Base de Cálculo do IBS e CBS", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vbc;

  /**
   * # {@link SEFAZIBSCBSVO}.
   *
   * @return the {@link SEFAZIBSCBSVO}
   */
  public SEFAZIBSCBSVO getIbsCBSVO() {
    return ibsCBSVO;
  }

  /**
   * # {@link SEFAZIBSCBSVO}.
   *
   * @param ibsCBSVO the new {@link SEFAZIBSCBSVO}
   */
  public void setIbsCBSVO(SEFAZIBSCBSVO ibsCBSVO) {
    this.ibsCBSVO = ibsCBSVO;
  }

  /**
   * # gIBSUF - Grupo de Informações do IBS da UF.
   *
   * @return the gIBSUF - Grupo de Informações do IBS da UF
   */
  public SEFAZGIBSUFVO getGibsUFVO() {
    return gibsUFVO;
  }

  /**
   * # gIBSUF - Grupo de Informações do IBS da UF.
   *
   * @param gibsUFVO the new gIBSUF - Grupo de Informações do IBS da UF
   */
  public void setGibsUFVO(SEFAZGIBSUFVO gibsUFVO) {
    this.gibsUFVO = gibsUFVO;
  }

  /**
   * # gIBSMun - Grupo de Informações do IBS do Município.
   *
   * @return the gIBSMun - Grupo de Informações do IBS do Município
   */
  public SEFAZGIBSMunVO getGibsMunVO() {
    return gibsMunVO;
  }

  /**
   * # gIBSMun - Grupo de Informações do IBS do Município.
   *
   * @param gibsMunVO the new gIBSMun - Grupo de Informações do IBS do Município
   */
  public void setGibsMunVO(SEFAZGIBSMunVO gibsMun) {
    this.gibsMunVO = gibsMun;
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
   * # gCBS - Grupo de Informações da CBS.
   *
   * @return the gCBS - Grupo de Informações da CBS
   */
  public SEFAZGCBSVO getGcbs() {
    return gcbs;
  }

  /**
   * # gCBS - Grupo de Informações da CBS.
   *
   * @param gcbs the new gCBS - Grupo de Informações da CBS
   */
  public void setGcbs(SEFAZGCBSVO gcbs) {
    this.gcbs = gcbs;
  }

  /**
   * # gTribRegular - Grupo de Informações da Tributação Regular.
   *
   * @return the gTribRegular - Grupo de Informações da Tributação Regular
   */
  public SEFAZGTribRegularVO getGtribRegular() {
    return gtribRegular;
  }

  /**
   * # gTribRegular - Grupo de Informações da Tributação Regular.
   *
   * @param gtribRegular the new gTribRegular - Grupo de Informações da Tributação Regular
   */
  public void setGtribRegular(SEFAZGTribRegularVO gtribRegular) {
    this.gtribRegular = gtribRegular;
  }

  /**
   * # vBC - Base de Cálculo do IBS e CBS.
   *
   * @return the vBC - Base de Cálculo do IBS e CBS
   */
  public BigDecimal getVbc() {
    return vbc;
  }

  /**
   * # vBC - Base de Cálculo do IBS e CBS.
   *
   * @param vbc the new vBC - Base de Cálculo do IBS e CBS
   */
  public void setVbc(BigDecimal vbc) {
    this.vbc = vbc;
  }

  public SEFAZGTransfCredVO getGtransfCred() {
    return gtransfCred;
  }

  public void setGtransfCred(SEFAZGTransfCredVO gtransfCred) {
    this.gtransfCred = gtransfCred;
  }

  public SEFAZGAjusteCompetVO getGajusteCompet() {
    return gajusteCompet;
  }

  public void setGajusteCompet(SEFAZGAjusteCompetVO gajusteCompet) {
    this.gajusteCompet = gajusteCompet;
  }

}
