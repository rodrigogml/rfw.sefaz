package br.eng.rodrigogml.rfw.sefaz.vos;

import java.math.BigDecimal;
import java.util.List;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "cobr" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class CobrVO extends RFWVO {

  private static final long serialVersionUID = 3775993677223419493L;

  /**
   * Y03 nFat Número da Fatura E Y02 C 0-1 1 - 60
   */
  @RFWMetaStringField(caption = "Número da Fatura", minlength = 1, maxLength = 60, required = false)
  private String nfat = null;

  /**
   * Y04 vOrig Valor Original da Fatura E Y02 N 0-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor Original da Fatura", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = false)
  private BigDecimal vorig = null;

  /**
   * Y05 vDesc Valor do desconto E Y02 N 0-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor do Desconto", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = false)
  private BigDecimal vdesc = null;

  /**
   * Y06 vLiq Valor Líquido da Fatura E Y02 N 0-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor Líquido da Fatura", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = false)
  private BigDecimal vliq = null;

  /**
   * Y07 dup Grupo Parcelas G Y01 0-120 (NT 2011/004) (Grupo atualizado na NT2016.002)
   */
  @RFWMetaRelationshipField(caption = "Grupo Parcelas", required = false, relationship = RelationshipTypes.COMPOSITION)
  private List<DupVO> dup = null;

  /**
   * # y03 nFat Número da Fatura E Y02 C 0-1 1 - 60.
   *
   * @return # y03 nFat Número da Fatura E Y02 C 0-1 1 - 60
   */
  public String getNfat() {
    return nfat;
  }

  /**
   * # y03 nFat Número da Fatura E Y02 C 0-1 1 - 60.
   *
   * @param nfat # y03 nFat Número da Fatura E Y02 C 0-1 1 - 60
   */
  public void setNfat(String nfat) {
    this.nfat = nfat;
  }

  /**
   * # y04 vOrig Valor Original da Fatura E Y02 N 0-1 13v2.
   *
   * @return # y04 vOrig Valor Original da Fatura E Y02 N 0-1 13v2
   */
  public BigDecimal getVorig() {
    return vorig;
  }

  /**
   * # y04 vOrig Valor Original da Fatura E Y02 N 0-1 13v2.
   *
   * @param vorig # y04 vOrig Valor Original da Fatura E Y02 N 0-1 13v2
   */
  public void setVorig(BigDecimal vorig) {
    this.vorig = vorig;
  }

  /**
   * # y05 vDesc Valor do desconto E Y02 N 0-1 13v2.
   *
   * @return # y05 vDesc Valor do desconto E Y02 N 0-1 13v2
   */
  public BigDecimal getVdesc() {
    return vdesc;
  }

  /**
   * # y05 vDesc Valor do desconto E Y02 N 0-1 13v2.
   *
   * @param vdesc # y05 vDesc Valor do desconto E Y02 N 0-1 13v2
   */
  public void setVdesc(BigDecimal vdesc) {
    this.vdesc = vdesc;
  }

  /**
   * # y06 vLiq Valor Líquido da Fatura E Y02 N 0-1 13v2.
   *
   * @return # y06 vLiq Valor Líquido da Fatura E Y02 N 0-1 13v2
   */
  public BigDecimal getVliq() {
    return vliq;
  }

  /**
   * # y06 vLiq Valor Líquido da Fatura E Y02 N 0-1 13v2.
   *
   * @param vliq # y06 vLiq Valor Líquido da Fatura E Y02 N 0-1 13v2
   */
  public void setVliq(BigDecimal vliq) {
    this.vliq = vliq;
  }

  /**
   * # y07 dup Grupo Parcelas G Y01 0-120 (NT 2011/004) (Grupo atualizado na NT2016.002).
   *
   * @return # y07 dup Grupo Parcelas G Y01 0-120 (NT 2011/004) (Grupo atualizado na NT2016
   */
  public List<DupVO> getDup() {
    return dup;
  }

  /**
   * # y07 dup Grupo Parcelas G Y01 0-120 (NT 2011/004) (Grupo atualizado na NT2016.002).
   *
   * @param dup # y07 dup Grupo Parcelas G Y01 0-120 (NT 2011/004) (Grupo atualizado na NT2016
   */
  public void setDup(List<DupVO> dup) {
    this.dup = dup;
  }

}
