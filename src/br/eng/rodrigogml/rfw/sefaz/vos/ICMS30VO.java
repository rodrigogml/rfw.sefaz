package br.eng.rodrigogml.rfw.sefaz.vos;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "ICMS30" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integra��o com o framework, pertindo a valida��o e at� a persist�ncia se o sistema assim desejar. N�o h� preocupa��o de gerar JavaDOC nestas classes pois ela deve representar exatamente a documenta��o da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Valida��o da NF-e.
 */
public class ICMS30VO extends RFWVO {

  private static final long serialVersionUID = 375502859651065585L;

  /**
   * N11 orig Origem da mercadoria E N05 N 1-1 1
   * <li>0 - Nacional, exceto as indicadas nos c�digos 3, 4, 5 e 8; 1 - Estrangeira - Importa��o direta, exceto a indicada no c�digo 6;
   * <li>2 - Estrangeira - Adquirida no mercado interno, exceto a indicada no c�digo 7;
   * <li>3 - Nacional, mercadoria ou bem com Conte�do de Importa��o superior a 40% e inferior ou igual a 70%;
   * <li>4 - Nacional, cuja produ��o tenha sido feita em conformidade com os processos produtivos b�sicos de que tratam as legisla��es citadas nos Ajustes;
   * <li>5 - Nacional, mercadoria ou bem com Conte�do de Importa��o inferior ou igual a 40%;
   * <li>6 - Estrangeira - Importa��o direta, sem similar nacional, constante em lista da CAMEX e g�s natural;
   * <li>7 - Estrangeira - Adquirida no mercado interno, sem similar nacional, constante lista CAMEX e g�s natural.
   * <li>8 - Nacional, mercadoria ou bem com Conte�do de Importa��o superior a 70%;
   */
  @RFWMetaStringField(caption = "Origem da Mercadoria", minlength = 1, maxLength = 1, required = true, pattern = "^(0|2|3|4|5|6|7|8)$")
  private String orig = null;

  /**
   * N12 CST Tributa��o do ICMS = 30 E N05 N 1-1 2<br>
   * 30=Isenta ou n�o tributada e com cobran�a do ICMS por substitui��o tribut�ria
   */
  @RFWMetaStringField(caption = "CST", minlength = 2, maxLength = 2, required = true, pattern = "20")
  private String cst = null;
}
