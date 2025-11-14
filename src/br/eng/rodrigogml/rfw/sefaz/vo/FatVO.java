package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Grupo Y02 - fat: Fatura.
 * <p>
 * Ocorre 0-1 dentro do grupo Y01 (cobr).
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_fat")
public class FatVO extends RFWVO {

  private static final long serialVersionUID = 6959556491669725299L;

  /**
   * {@link CobrVO}
   */
  @RFWMetaRelationshipField(caption = "Cobr", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_cobr")
  private CobrVO cobrVO = null;

  /**
   * Y03 - nFat: Número da Fatura. Tipo: C, Tamanho: 1-60, Ocorrência: 0-1 (campo opcional).
   */
  @RFWMetaStringField(caption = "nFat", required = false, unique = false, maxLength = 60, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String nfat;

  /**
   * Y04 - vOrig: Valor Original da Fatura. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   */
  @RFWMetaBigDecimalField(caption = "vOrig", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vorig;

  /**
   * Y05 - vDesc: Valor do desconto. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   */
  @RFWMetaBigDecimalField(caption = "vDesc", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vdesc;

  /**
   * Y06 - vLiq: Valor Líquido da Fatura. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   */
  @RFWMetaBigDecimalField(caption = "vLiq", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vliq;

  /**
   * # {@link CobrVO}.
   *
   * @return the {@link CobrVO}
   */
  public CobrVO getCobrVO() {
    return cobrVO;
  }

  /**
   * # {@link CobrVO}.
   *
   * @param cobrVO the new {@link CobrVO}
   */
  public void setCobrVO(CobrVO cobrVO) {
    this.cobrVO = cobrVO;
  }

  /**
   * # y03 - nFat: Número da Fatura. Tipo: C, Tamanho: 1-60, Ocorrência: 0-1 (campo opcional).
   *
   * @return the y03 - nFat: Número da Fatura
   */
  public String getNfat() {
    return nfat;
  }

  /**
   * # y03 - nFat: Número da Fatura. Tipo: C, Tamanho: 1-60, Ocorrência: 0-1 (campo opcional).
   *
   * @param nfat the new y03 - nFat: Número da Fatura
   */
  public void setNfat(String nfat) {
    this.nfat = nfat;
  }

  /**
   * # y04 - vOrig: Valor Original da Fatura. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @return the y04 - vOrig: Valor Original da Fatura
   */
  public BigDecimal getVorig() {
    return vorig;
  }

  /**
   * # y04 - vOrig: Valor Original da Fatura. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @param vorig the new y04 - vOrig: Valor Original da Fatura
   */
  public void setVorig(BigDecimal vorig) {
    this.vorig = vorig;
  }

  /**
   * # y05 - vDesc: Valor do desconto. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @return the y05 - vDesc: Valor do desconto
   */
  public BigDecimal getVdesc() {
    return vdesc;
  }

  /**
   * # y05 - vDesc: Valor do desconto. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @param vdesc the new y05 - vDesc: Valor do desconto
   */
  public void setVdesc(BigDecimal vdesc) {
    this.vdesc = vdesc;
  }

  /**
   * # y06 - vLiq: Valor Líquido da Fatura. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @return the y06 - vLiq: Valor Líquido da Fatura
   */
  public BigDecimal getVliq() {
    return vliq;
  }

  /**
   * # y06 - vLiq: Valor Líquido da Fatura. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @param vliq the new y06 - vLiq: Valor Líquido da Fatura
   */
  public void setVliq(BigDecimal vliq) {
    this.vliq = vliq;
  }
}
