package br.eng.rodrigogml.rfw.sefaz.vos;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "ICMS30" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class ICMS30VO extends RFWVO {

  private static final long serialVersionUID = 375502859651065585L;

  /**
   * N11 orig Origem da mercadoria E N05 N 1-1 1
   * <li>0 - Nacional, exceto as indicadas nos códigos 3, 4, 5 e 8; 1 - Estrangeira - Importação direta, exceto a indicada no código 6;
   * <li>2 - Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7;
   * <li>3 - Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% e inferior ou igual a 70%;
   * <li>4 - Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam as legislações citadas nos Ajustes;
   * <li>5 - Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40%;
   * <li>6 - Estrangeira - Importação direta, sem similar nacional, constante em lista da CAMEX e gás natural;
   * <li>7 - Estrangeira - Adquirida no mercado interno, sem similar nacional, constante lista CAMEX e gás natural.
   * <li>8 - Nacional, mercadoria ou bem com Conteúdo de Importação superior a 70%;
   */
  @RFWMetaStringField(caption = "Origem da Mercadoria", minlength = 1, maxLength = 1, required = true, pattern = "^(0|2|3|4|5|6|7|8)$")
  private String orig = null;

  /**
   * N12 CST Tributação do ICMS = 30 E N05 N 1-1 2<br>
   * 30=Isenta ou não tributada e com cobrança do ICMS por substituição tributária
   */
  @RFWMetaStringField(caption = "CST", minlength = 2, maxLength = 2, required = true, pattern = "20")
  private String cst = null;
}
