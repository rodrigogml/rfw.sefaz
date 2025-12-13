package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * gCredPresOper - Crédito Presumido da Operação.
 * <p>
 * A permissão ou vedação do preenchimento deste grupo está condicionada ao indicador "ind_gCredPresOper" da tabela de cClassTrib do IBS e da CBS.
 * <p>
 * O valor "1" do indicador permite a utilização do crédito presumido, mas não obriga.
 */
public class SEFAZGCredPresOperVO extends RFWVO {

  private static final long serialVersionUID = 4208892282358075799L;

  /**
   * {@link SEFAZIBSCBSVO}
   */
  @RFWMetaRelationshipField(caption = "IBSCBS", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true)
  private SEFAZIBSCBSVO ibsCBSVO = null;

  /**
   * gIBSCredPres - Grupo de Informações do Crédito Presumido referente ao IBS.
   */
  private SEFAZGIBSCredPresVO gibsCredPres;

  /**
   * gCBSCredPres - Grupo de Informações do Crédito Presumido referente à CBS.
   */
  private SEFAZGCBSCredPresVO gcbsCredPres;

  /**
   * vBCCredPres - Valor da Base de Cálculo do Crédito Presumido da Operação.
   */
  @RFWMetaBigDecimalField(caption = "Base de Cálculo do Crédito Presumido", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vbccredPres;

  /**
   * cCredPres - Código de Classificação do Crédito Presumido.
   * <p>
   * Utilizar tabela cCredPres (Anexo IV).
   */
  @RFWMetaStringField(caption = "Classificação do Crédito Presumido", required = true, maxLength = 2, pattern = "^[0-9]{2}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String ccredPres;

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
   * # gIBSCredPres - Grupo de Informações do Crédito Presumido referente ao IBS.
   *
   * @return the gIBSCredPres - Grupo de Informações do Crédito Presumido referente ao IBS
   */
  public SEFAZGIBSCredPresVO getGibsCredPres() {
    return gibsCredPres;
  }

  /**
   * # gIBSCredPres - Grupo de Informações do Crédito Presumido referente ao IBS.
   *
   * @param gibsCredPres the new gIBSCredPres - Grupo de Informações do Crédito Presumido referente ao IBS
   */
  public void setGibsCredPres(SEFAZGIBSCredPresVO gibsCredPres) {
    this.gibsCredPres = gibsCredPres;
  }

  /**
   * # gCBSCredPres - Grupo de Informações do Crédito Presumido referente à CBS.
   *
   * @return the gCBSCredPres - Grupo de Informações do Crédito Presumido referente à CBS
   */
  public SEFAZGCBSCredPresVO getGcbsCredPres() {
    return gcbsCredPres;
  }

  /**
   * # gCBSCredPres - Grupo de Informações do Crédito Presumido referente à CBS.
   *
   * @param gcbsCredPres the new gCBSCredPres - Grupo de Informações do Crédito Presumido referente à CBS
   */
  public void setGcbsCredPres(SEFAZGCBSCredPresVO gcbsCredPres) {
    this.gcbsCredPres = gcbsCredPres;
  }

  /**
   * # vBCCredPres - Valor da Base de Cálculo do Crédito Presumido da Operação.
   *
   * @return the vBCCredPres - Valor da Base de Cálculo do Crédito Presumido da Operação
   */
  public BigDecimal getVbccredPres() {
    return vbccredPres;
  }

  /**
   * # vBCCredPres - Valor da Base de Cálculo do Crédito Presumido da Operação.
   *
   * @param vbccredPres the new vBCCredPres - Valor da Base de Cálculo do Crédito Presumido da Operação
   */
  public void setVbccredPres(BigDecimal vbccredPres) {
    this.vbccredPres = vbccredPres;
  }

  /**
   * # cCredPres - Código de Classificação do Crédito Presumido.
   * <p>
   * Utilizar tabela cCredPres (Anexo IV).
   *
   * @return the cCredPres - Código de Classificação do Crédito Presumido
   */
  public String getCcredPres() {
    return ccredPres;
  }

  /**
   * # cCredPres - Código de Classificação do Crédito Presumido.
   * <p>
   * Utilizar tabela cCredPres (Anexo IV).
   *
   * @param ccredPres the new cCredPres - Código de Classificação do Crédito Presumido
   */
  public void setCcredPres(String ccredPres) {
    this.ccredPres = ccredPres;
  }

}
