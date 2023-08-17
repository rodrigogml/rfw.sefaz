package br.eng.rodrigogml.rfw.sefaz.vos;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCNPJField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCPFField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringIEField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "emit" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class EmitVO extends RFWVO {

  private static final long serialVersionUID = -2317505306850443548L;

  /**
   * C05 enderEmit Endereço do emitente G C01 1-1
   */
  @RFWMetaRelationshipField(caption = "Endereço do Emitente", required = true, relationship = RelationshipTypes.COMPOSITION)
  private EnderEmitVO enderEmit = null;

  /**
   * C02 CNPJ CNPJ do emitente CE C01 N 1-1 14<br>
   * Informar o CNPJ do emitente. Na emissão de NF-e avulsa pelo Fisco, as informações do remetente serão informadas neste grupo. O CNPJ ou CPF deverão ser informados com os zeros não significativos.
   */
  @RFWMetaStringCNPJField(caption = "CNPJ", required = false, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cnpj = null;

  /**
   * C02a CPF CPF do remetente CE C01 N 1-1 11
   */
  @RFWMetaStringCPFField(caption = "CPF", required = false, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cpf = null;

  /**
   * C03 xNome Razão Social ou Nome do emitente E C01 C 1-1 2 - 60
   */
  @RFWMetaStringField(caption = "Nome", minlength = 2, maxLength = 60, required = true, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xnome = null;

  /**
   * C04 xFant Nome fantasia E C01 C 0-1 1 - 60
   */
  @RFWMetaStringField(caption = "Nome Fantasia", minlength = 1, maxLength = 60, required = false, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xfant = null;

  /**
   * C17 IE Inscrição Estadual do Emitente E C01 C 1-1 2 - 14<br>
   * Informar somente os algarismos, sem os caracteres de formatação (ponto, barra, hífen, etc.).
   */
  @RFWMetaStringIEField(caption = "IE", required = true)
  private String ie = null;

  /**
   * C18 IEST IE do Substituto Tributário E C01 N 0-1 2 - 14<br>
   * IE do Substituto Tributário da UF de destino da mercadoria, quando houver a retenção do ICMS ST para a UF de destino
   */
  @RFWMetaStringIEField(caption = "IE ST", required = false)
  private String ieST = null;

  /**
   * C19 IM Inscrição Municipal do Prestador de Serviço E C18.1 C 1-1 1 - 15<Br>
   * Informado na emissão de NF-e conjugada, com itens de produtos sujeitos ao ICMS e itens de serviços sujeitos ao ISSQN.
   */
  @RFWMetaStringField(caption = "IM", minlength = 1, maxLength = 15, required = false)
  private String im = null;

  /**
   * C20 CNAE CNAE fiscal E C18.1 N 0-1 7<br>
   * Campo Opcional. Pode ser informado quando a Inscrição Municipal (id:C19) for informada.
   */
  @RFWMetaStringField(caption = "CNAE", minlength = 7, maxLength = 7, required = false, pattern = "\\d{7}")
  private String cnae = null;

  /**
   * C21 CRT Código de Regime Tributário E C01 N 1-1 1
   * <li>1=Simples Nacional;
   * <li>2=Simples Nacional, excesso sublimite de receita bruta;
   * <li>3=Regime Normal. (v2.0).
   */
  @RFWMetaStringField(caption = "CRT", minlength = 1, maxLength = 1, required = false, pattern = "^(1|2|3)$")
  private String crt = null;

}
