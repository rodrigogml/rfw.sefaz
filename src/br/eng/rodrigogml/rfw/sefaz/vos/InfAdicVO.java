package br.eng.rodrigogml.rfw.sefaz.vos;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "infAdic" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class InfAdicVO extends RFWVO {

  private static final long serialVersionUID = -6572633792439466768L;

  /**
   * Z02 infAdFisco Informações Adicionais de Interesse do Fisco E Z01 C 0-1 1 - 2000<br>
   * (v2.0)
   */
  @RFWMetaStringField(caption = "Informações Adicionais", minlength = 1, maxLength = 2000, required = false)
  private String infAdFisco = null;

  /**
   * Z03 infCpl Informações Complementares de interesse do Contribuinte E Z01 C 0-1 1 - 5000
   */
  @RFWMetaStringField(caption = "Informações Complementares", minlength = 1, maxLength = 5000, required = false)
  private String infCpl = null;

  /**
   * # z02 infAdFisco Informações Adicionais de Interesse do Fisco E Z01 C 0-1 1 - 2000<br>
   * (v2.0).
   *
   * @return # z02 infAdFisco Informações Adicionais de Interesse do Fisco E Z01 C 0-1 1 - 2000<br>
   *         (v2
   */
  public String getInfAdFisco() {
    return infAdFisco;
  }

  /**
   * # z02 infAdFisco Informações Adicionais de Interesse do Fisco E Z01 C 0-1 1 - 2000<br>
   * (v2.0).
   *
   * @param infAdFisco # z02 infAdFisco Informações Adicionais de Interesse do Fisco E Z01 C 0-1 1 - 2000<br>
   *          (v2
   */
  public void setInfAdFisco(String infAdFisco) {
    this.infAdFisco = infAdFisco;
  }

  /**
   * # z03 infCpl Informações Complementares de interesse do Contribuinte E Z01 C 0-1 1 - 5000.
   *
   * @return # z03 infCpl Informações Complementares de interesse do Contribuinte E Z01 C 0-1 1 - 5000
   */
  public String getInfCpl() {
    return infCpl;
  }

  /**
   * # z03 infCpl Informações Complementares de interesse do Contribuinte E Z01 C 0-1 1 - 5000.
   *
   * @param infCpl # z03 infCpl Informações Complementares de interesse do Contribuinte E Z01 C 0-1 1 - 5000
   */
  public void setInfCpl(String infCpl) {
    this.infCpl = infCpl;
  }

}
