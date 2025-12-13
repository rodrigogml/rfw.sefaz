package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * gAjusteCompet - Grupo de Ajuste de Competência.
 */
public class SEFAZGAjusteCompetVO extends RFWVO {

  private static final long serialVersionUID = -9086739244047272783L;
  /**
   * {@link SEFAZGIBSCBSVO}
   */
  @RFWMetaRelationshipField(caption = "IBSCBS", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true)
  private SEFAZGIBSCBSVO gibsCBSVO = null;

  /**
   * competApur - Ano e mês de referência do período de apuração (AAAA-MM).
   */
  @RFWMetaStringField(caption = "Competência de Apuração", required = true, maxLength = 7, pattern = "^[0-9]{4}-[0-9]{2}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String competApur;

  /**
   * vIBS - Valor do IBS.
   */
  @RFWMetaBigDecimalField(caption = "Valor do IBS", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vibs;

  /**
   * vCBS - Valor da CBS.
   */
  @RFWMetaBigDecimalField(caption = "Valor da CBS", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vcbs;

  /**
   * # {@link SEFAZGIBSCBSVO}.
   *
   * @return the {@link SEFAZGIBSCBSVO}
   */
  public SEFAZGIBSCBSVO getGibsCBSVO() {
    return gibsCBSVO;
  }

  /**
   * # {@link SEFAZGIBSCBSVO}.
   *
   * @param gibsCBSVO the new {@link SEFAZGIBSCBSVO}
   */
  public void setGibsCBSVO(SEFAZGIBSCBSVO gibsCBSVO) {
    this.gibsCBSVO = gibsCBSVO;
  }

  /**
   * # competApur - Ano e mês de referência do período de apuração (AAAA-MM).
   *
   * @return the competApur - Ano e mês de referência do período de apuração (AAAA-MM)
   */
  public String getCompetApur() {
    return competApur;
  }

  /**
   * # competApur - Ano e mês de referência do período de apuração (AAAA-MM).
   *
   * @param competApur the new competApur - Ano e mês de referência do período de apuração (AAAA-MM)
   */
  public void setCompetApur(String competApur) {
    this.competApur = competApur;
  }

  /**
   * # vIBS - Valor do IBS.
   *
   * @return the vIBS - Valor do IBS
   */
  public BigDecimal getVibs() {
    return vibs;
  }

  /**
   * # vIBS - Valor do IBS.
   *
   * @param vibs the new vIBS - Valor do IBS
   */
  public void setVibs(BigDecimal vibs) {
    this.vibs = vibs;
  }

  /**
   * # vCBS - Valor da CBS.
   *
   * @return the vCBS - Valor da CBS
   */
  public BigDecimal getVcbs() {
    return vcbs;
  }

  /**
   * # vCBS - Valor da CBS.
   *
   * @param vcbs the new vCBS - Valor da CBS
   */
  public void setVcbs(BigDecimal vcbs) {
    this.vcbs = vcbs;
  }
}
