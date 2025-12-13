package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * gCredPresIBSZFM - Grupo para apropriação de crédito presumido de IBS sobre o saldo devedor na Zona Franca de Manaus (art. 450, § 1º, LC 214/2025).
 */
public class SEFAZGCredPresIBSZFMVO extends RFWVO {

  private static final long serialVersionUID = 4101859416050095687L;

  /**
   * {@link SEFAZIBSCBSVO}
   */
  @RFWMetaRelationshipField(caption = "IBSCBS", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true)
  private SEFAZIBSCBSVO ibsCBSVO = null;

  /**
   * competApur - Ano e mês de referência do período de apuração (AAAA-MM).
   */
  @RFWMetaStringField(caption = "Competência de Apuração", required = true, maxLength = 7, pattern = "^[0-9]{4}-[0-9]{2}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String competApur;

  /**
   * tpCredPresIBSZFM - Tipo de classificação para cálculo do crédito presumido na ZFM.
   * <p>
   * 0 - Sem crédito presumido 1 - Bens de consumo final (55%) 2 - Bens de capital (75%) 3 - Bens intermediários (90,25%) 4 - Bens de informática e outros definidos em legislação (100%)
   */
  @RFWMetaStringField(caption = "Tipo de Crédito Presumido IBS ZFM", required = true, maxLength = 1, pattern = "^[0-4]{1}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String tpcredPresIbsZfm;

  /**
   * vCredPresIBSZFM - Valor do crédito presumido de IBS calculado sobre o saldo devedor apurado.
   */
  @RFWMetaBigDecimalField(caption = "Valor do Crédito Presumido IBS ZFM", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vcredPresIbsZfm;

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
   * # tpCredPresIBSZFM - Tipo de classificação para cálculo do crédito presumido na ZFM.
   * <p>
   * 0 - Sem crédito presumido 1 - Bens de consumo final (55%) 2 - Bens de capital (75%) 3 - Bens intermediários (90,25%) 4 - Bens de informática e outros definidos em legislação (100%).
   *
   * @return the tpCredPresIBSZFM - Tipo de classificação para cálculo do crédito presumido na ZFM
   */
  public String getTpcredPresIbsZfm() {
    return tpcredPresIbsZfm;
  }

  /**
   * # tpCredPresIBSZFM - Tipo de classificação para cálculo do crédito presumido na ZFM.
   * <p>
   * 0 - Sem crédito presumido 1 - Bens de consumo final (55%) 2 - Bens de capital (75%) 3 - Bens intermediários (90,25%) 4 - Bens de informática e outros definidos em legislação (100%).
   *
   * @param tpcredPresIbsZfm the new tpCredPresIBSZFM - Tipo de classificação para cálculo do crédito presumido na ZFM
   */
  public void setTpcredPresIbsZfm(String tpcredPresIbsZfm) {
    this.tpcredPresIbsZfm = tpcredPresIbsZfm;
  }

  /**
   * # vCredPresIBSZFM - Valor do crédito presumido de IBS calculado sobre o saldo devedor apurado.
   *
   * @return the vCredPresIBSZFM - Valor do crédito presumido de IBS calculado sobre o saldo devedor apurado
   */
  public BigDecimal getVcredPresIbsZfm() {
    return vcredPresIbsZfm;
  }

  /**
   * # vCredPresIBSZFM - Valor do crédito presumido de IBS calculado sobre o saldo devedor apurado.
   *
   * @param vcredPresIbsZfm the new vCredPresIBSZFM - Valor do crédito presumido de IBS calculado sobre o saldo devedor apurado
   */
  public void setVcredPresIbsZfm(BigDecimal vcredPresIbsZfm) {
    this.vcredPresIbsZfm = vcredPresIbsZfm;
  }
}
