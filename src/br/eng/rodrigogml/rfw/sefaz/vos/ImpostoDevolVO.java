package br.eng.rodrigogml.rfw.sefaz.vos;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "impostoDevol" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class ImpostoDevolVO extends RFWVO {

  private static final long serialVersionUID = -552862590622703030L;

  /**
   * UA02 pDevol Percentual da mercadoria devolvida E UA01 N 1-1 3v2 Observação: O valor máximo deste percentual é 100%, no caso de devolução total da mercadoria.
   */
  @RFWMetaBigDecimalField(caption = "Percentual da Mercadoria Devolvida", minValue = "0", maxValue = "999.99", scale = 2, required = true)
  private BigDecimal pdevol = null;

  /**
   * UA04 vIPIDevol Valor do IPI devolvido E UA03 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor do IPI Devolvido", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = true)
  private BigDecimal vipiDevol = null;

  /**
   * # uA02 pDevol Percentual da mercadoria devolvida E UA01 N 1-1 3v2 Observação: O valor máximo deste percentual é 100%, no caso de devolução total da mercadoria.
   *
   * @return # uA02 pDevol Percentual da mercadoria devolvida E UA01 N 1-1 3v2 Observação: O valor máximo deste percentual é 100%, no caso de devolução total da mercadoria
   */
  public BigDecimal getPdevol() {
    return pdevol;
  }

  /**
   * # uA02 pDevol Percentual da mercadoria devolvida E UA01 N 1-1 3v2 Observação: O valor máximo deste percentual é 100%, no caso de devolução total da mercadoria.
   *
   * @param pdevol # uA02 pDevol Percentual da mercadoria devolvida E UA01 N 1-1 3v2 Observação: O valor máximo deste percentual é 100%, no caso de devolução total da mercadoria
   */
  public void setPdevol(BigDecimal pdevol) {
    this.pdevol = pdevol;
  }

  /**
   * # uA04 vIPIDevol Valor do IPI devolvido E UA03 N 1-1 13v2.
   *
   * @return # uA04 vIPIDevol Valor do IPI devolvido E UA03 N 1-1 13v2
   */
  public BigDecimal getVipiDevol() {
    return vipiDevol;
  }

  /**
   * # uA04 vIPIDevol Valor do IPI devolvido E UA03 N 1-1 13v2.
   *
   * @param vipiDevol # uA04 vIPIDevol Valor do IPI devolvido E UA03 N 1-1 13v2
   */
  public void setVipiDevol(BigDecimal vipiDevol) {
    this.vipiDevol = vipiDevol;
  }

}
