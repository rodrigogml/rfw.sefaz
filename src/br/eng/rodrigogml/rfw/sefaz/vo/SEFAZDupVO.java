package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaDateField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Grupo Y07 - dup: Parcelas (duplicatas).
 * <p>
 * Ocorre 0-120 vezes dentro do grupo Y01 (cobr). Cada instância representa uma parcela da fatura.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_dup")
public class SEFAZDupVO extends RFWVO {

  private static final long serialVersionUID = -5357160685563910049L;

  /**
   * {@link SEFAZCobrVO}
   */
  @RFWMetaRelationshipField(caption = "Cobr", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_cobr")
  private SEFAZCobrVO cobrVO = null;

  /**
   * Y08 - nDup: Número da Parcela. Tipo: C, Tamanho: 1-60, Ocorrência: 0-1 (campo opcional).
   * <p>
   * Recomenda-se numeração com 3 algarismos, sequenciais e consecutivos (ex.: "001", "002", "003"...), obrigatória a partir de 03/09/2018 conforme NT.
   */
  @RFWMetaStringField(caption = "nDup", required = false, unique = false, maxLength = 60, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String ndup;

  /**
   * Y09 - dVenc: Data de vencimento. Tipo: D (data), Formato: “AAAA-MM-DD”, Ocorrência: 0-1 (campo opcional).
   * <p>
   * As datas de vencimento devem ser informadas em ordem crescente.
   */
  @RFWMetaDateField(caption = "dVenc", required = false, unique = false)
  private LocalDate dvenc;

  /**
   * Y10 - vDup: Valor da Parcela. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura da parcela).
   */
  @RFWMetaBigDecimalField(caption = "vDup", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vdup;

  /**
   * # {@link SEFAZCobrVO}.
   *
   * @return the {@link SEFAZCobrVO}
   */
  public SEFAZCobrVO getCobrVO() {
    return cobrVO;
  }

  /**
   * # {@link SEFAZCobrVO}.
   *
   * @param cobrVO the new {@link SEFAZCobrVO}
   */
  public void setCobrVO(SEFAZCobrVO cobrVO) {
    this.cobrVO = cobrVO;
  }

  /**
   * # y08 - nDup: Número da Parcela. Tipo: C, Tamanho: 1-60, Ocorrência: 0-1 (campo opcional).
   * <p>
   * Recomenda-se numeração com 3 algarismos, sequenciais e consecutivos (ex.: "001", "002", "003"..), obrigatória a partir de 03/09/2018 conforme NT.
   *
   * @return the y08 - nDup: Número da Parcela
   */
  public String getNdup() {
    return ndup;
  }

  /**
   * # y08 - nDup: Número da Parcela. Tipo: C, Tamanho: 1-60, Ocorrência: 0-1 (campo opcional).
   * <p>
   * Recomenda-se numeração com 3 algarismos, sequenciais e consecutivos (ex.: "001", "002", "003"..), obrigatória a partir de 03/09/2018 conforme NT.
   *
   * @param ndup the new y08 - nDup: Número da Parcela
   */
  public void setNdup(String ndup) {
    this.ndup = ndup;
  }

  /**
   * # y09 - dVenc: Data de vencimento. Tipo: D (data), Formato: “AAAA-MM-DD”, Ocorrência: 0-1 (campo opcional).
   * <p>
   * As datas de vencimento devem ser informadas em ordem crescente.
   *
   * @return the y09 - dVenc: Data de vencimento
   */
  public LocalDate getDvenc() {
    return dvenc;
  }

  /**
   * # y09 - dVenc: Data de vencimento. Tipo: D (data), Formato: “AAAA-MM-DD”, Ocorrência: 0-1 (campo opcional).
   * <p>
   * As datas de vencimento devem ser informadas em ordem crescente.
   *
   * @param dvenc the new y09 - dVenc: Data de vencimento
   */
  public void setDvenc(LocalDate dvenc) {
    this.dvenc = dvenc;
  }

  /**
   * # y10 - vDup: Valor da Parcela. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura da parcela).
   *
   * @return the y10 - vDup: Valor da Parcela
   */
  public BigDecimal getVdup() {
    return vdup;
  }

  /**
   * # y10 - vDup: Valor da Parcela. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura da parcela).
   *
   * @param vdup the new y10 - vDup: Valor da Parcela
   */
  public void setVdup(BigDecimal vdup) {
    this.vdup = vdup;
  }
}
