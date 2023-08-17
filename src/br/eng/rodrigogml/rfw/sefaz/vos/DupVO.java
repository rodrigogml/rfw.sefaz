package br.eng.rodrigogml.rfw.sefaz.vos;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaDateField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaDateField.DateResolution;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "dup" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class DupVO extends RFWVO {

  private static final long serialVersionUID = 884343088249413125L;

  /**
   * Y08 nDup Número da Parcela E Y07 C 0 - 1 1 - 60<br>
   * Obrigatória informação do número de parcelas com 3 algarismos, sequenciais e consecutivos. <Br>
   * Ex.: “001”,”002”,”003”,... <br>
   * Observação: este padrão de preenchimento será Obrig.atório somente a partir de 03/09/2018
   */
  @RFWMetaStringField(caption = "Número da Parcela", minlength = 1, maxLength = 60, required = false)
  private String ndup = null;

  /**
   * Y09 dVenc Data de vencimento E Y07 D 0 - 1<br>
   * Formato: “AAAA-MM-DD”.<br>
   * Obrigatória a informação da data de vencimento na ordem crescente das datas. Ex.: “2018-06-01”,”2018-07-01”, “2018-08-01”,...
   */
  @RFWMetaDateField(caption = "Data de Vencimento", required = false, resolution = DateResolution.DAY)
  private LocalDate dvenc = null;

  /**
   * Y10 vDup Valor da Parcela E Y07 N 1-1 13v2<br>
   * (NT 2012/003)
   */
  @RFWMetaBigDecimalField(caption = "Valor da Parcela", minValue = "0", maxValue = "9999999999999.99", required = true)
  private BigDecimal vdup = null;

  /**
   * # y08 nDup Número da Parcela E Y07 C 0 - 1 1 - 60<br>
   * Obrigatória informação do número de parcelas com 3 algarismos, sequenciais e consecutivos. <Br>
   * Ex.: “001”,”002”,”003”,.. <br>
   * Observação: este padrão de preenchimento será Obrig.atório somente a partir de 03/09/2018.
   *
   * @return # y08 nDup Número da Parcela E Y07 C 0 - 1 1 - 60<br>
   *         Obrigatória informação do número de parcelas com 3 algarismos, sequenciais e consecutivos
   */
  public String getNdup() {
    return ndup;
  }

  /**
   * # y08 nDup Número da Parcela E Y07 C 0 - 1 1 - 60<br>
   * Obrigatória informação do número de parcelas com 3 algarismos, sequenciais e consecutivos. <Br>
   * Ex.: “001”,”002”,”003”,.. <br>
   * Observação: este padrão de preenchimento será Obrig.atório somente a partir de 03/09/2018.
   *
   * @param ndup # y08 nDup Número da Parcela E Y07 C 0 - 1 1 - 60<br>
   *          Obrigatória informação do número de parcelas com 3 algarismos, sequenciais e consecutivos
   */
  public void setNdup(String ndup) {
    this.ndup = ndup;
  }

  /**
   * # y09 dVenc Data de vencimento E Y07 D 0 - 1<br>
   * Formato: “AAAA-MM-DD”.<br>
   * Obrigatória a informação da data de vencimento na ordem crescente das datas. Ex.: “2018-06-01”,”2018-07-01”, “2018-08-01”,..
   *
   * @return # y09 dVenc Data de vencimento E Y07 D 0 - 1<br>
   *         Formato: “AAAA-MM-DD”
   */
  public LocalDate getDvenc() {
    return dvenc;
  }

  /**
   * # y09 dVenc Data de vencimento E Y07 D 0 - 1<br>
   * Formato: “AAAA-MM-DD”.<br>
   * Obrigatória a informação da data de vencimento na ordem crescente das datas. Ex.: “2018-06-01”,”2018-07-01”, “2018-08-01”,..
   *
   * @param dvenc # y09 dVenc Data de vencimento E Y07 D 0 - 1<br>
   *          Formato: “AAAA-MM-DD”
   */
  public void setDvenc(LocalDate dvenc) {
    this.dvenc = dvenc;
  }

  /**
   * # y10 vDup Valor da Parcela E Y07 N 1-1 13v2<br>
   * (NT 2012/003).
   *
   * @return # y10 vDup Valor da Parcela E Y07 N 1-1 13v2<br>
   *         (NT 2012/003)
   */
  public BigDecimal getVdup() {
    return vdup;
  }

  /**
   * # y10 vDup Valor da Parcela E Y07 N 1-1 13v2<br>
   * (NT 2012/003).
   *
   * @param vdup # y10 vDup Valor da Parcela E Y07 N 1-1 13v2<br>
   *          (NT 2012/003)
   */
  public void setVdup(BigDecimal vdup) {
    this.vdup = vdup;
  }

}
