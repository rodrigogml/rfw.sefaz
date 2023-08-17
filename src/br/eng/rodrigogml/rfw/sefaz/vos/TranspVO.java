package br.eng.rodrigogml.rfw.sefaz.vos;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "transp" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integra��o com o framework, pertindo a valida��o e at� a persist�ncia se o sistema assim desejar. N�o h� preocupa��o de gerar JavaDOC nestas classes pois ela deve representar exatamente a documenta��o da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Valida��o da NF-e.
 */
public class TranspVO extends RFWVO {

  private static final long serialVersionUID = -6000619451608488140L;

  /**
   * X02 modFrete Modalidade do frete E X01 N 1-1 1 0=Contrata��o do Frete por conta do Remetente (CIF);<br>
   * <li>1=Contrata��o do Frete por conta do Destinat�rio (FOB);
   * <li>2=Contrata��o do Frete por conta de Terceiros;
   * <li>3=Transporte Pr�prio por conta do Remetente;
   * <li>4=Transporte Pr�prio por conta do Destinat�rio;
   * <li>9=Sem Ocorr�ncia de Transporte. <br>
   * (Atualizado na NT2016.002)
   */
  @RFWMetaStringField(caption = "Modalidade do Frete", minlength = 1, maxLength = 1, required = true, pattern = "^(0|1|2|3|4|9)$")
  private String modFrete = null;

  /**
   * # x02 modFrete Modalidade do frete E X01 N 1-1 1 0=Contrata��o do Frete por conta do Remetente (CIF);<br>
   * <li>1=Contrata��o do Frete por conta do Destinat�rio (FOB);
   * <li>2=Contrata��o do Frete por conta de Terceiros;
   * <li>3=Transporte Pr�prio por conta do Remetente;
   * <li>4=Transporte Pr�prio por conta do Destinat�rio;
   * <li>9=Sem Ocorr�ncia de Transporte. <br>
   * (Atualizado na NT2016.002).
   *
   * @return # x02 modFrete Modalidade do frete E X01 N 1-1 1 0=Contrata��o do Frete por conta do Remetente (CIF);<br>
   *         <li>1=Contrata��o do Frete por conta do Destinat�rio (FOB);
   *         <li>2=Contrata��o do Frete por conta de Terceiros;
   *         <li>3=Transporte Pr�prio por conta do Remetente;
   *         <li>4=Transporte Pr�prio por conta do Destinat�rio;
   *         <li>9=Sem Ocorr�ncia de Transporte
   */
  public String getModFrete() {
    return modFrete;
  }

  /**
   * # x02 modFrete Modalidade do frete E X01 N 1-1 1 0=Contrata��o do Frete por conta do Remetente (CIF);<br>
   * <li>1=Contrata��o do Frete por conta do Destinat�rio (FOB);
   * <li>2=Contrata��o do Frete por conta de Terceiros;
   * <li>3=Transporte Pr�prio por conta do Remetente;
   * <li>4=Transporte Pr�prio por conta do Destinat�rio;
   * <li>9=Sem Ocorr�ncia de Transporte. <br>
   * (Atualizado na NT2016.002).
   *
   * @param modFrete # x02 modFrete Modalidade do frete E X01 N 1-1 1 0=Contrata��o do Frete por conta do Remetente (CIF);<br>
   *          <li>1=Contrata��o do Frete por conta do Destinat�rio (FOB);
   *          <li>2=Contrata��o do Frete por conta de Terceiros;
   *          <li>3=Transporte Pr�prio por conta do Remetente;
   *          <li>4=Transporte Pr�prio por conta do Destinat�rio;
   *          <li>9=Sem Ocorr�ncia de Transporte
   */
  public void setModFrete(String modFrete) {
    this.modFrete = modFrete;
  }

}
