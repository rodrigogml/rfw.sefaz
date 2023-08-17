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
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integra��o com o framework, pertindo a valida��o e at� a persist�ncia se o sistema assim desejar. N�o h� preocupa��o de gerar JavaDOC nestas classes pois ela deve representar exatamente a documenta��o da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Valida��o da NF-e.
 */
public class EmitVO extends RFWVO {

  private static final long serialVersionUID = -2317505306850443548L;

  /**
   * C05 enderEmit Endere�o do emitente G C01 1-1
   */
  @RFWMetaRelationshipField(caption = "Endere�o do Emitente", required = true, relationship = RelationshipTypes.COMPOSITION)
  private EnderEmitVO enderEmit = null;

  /**
   * C02 CNPJ CNPJ do emitente CE C01 N 1-1 14<br>
   * Informar o CNPJ do emitente. Na emiss�o de NF-e avulsa pelo Fisco, as informa��es do remetente ser�o informadas neste grupo. O CNPJ ou CPF dever�o ser informados com os zeros n�o significativos.
   */
  @RFWMetaStringCNPJField(caption = "CNPJ", required = false, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cnpj = null;

  /**
   * C02a CPF CPF do remetente CE C01 N 1-1 11
   */
  @RFWMetaStringCPFField(caption = "CPF", required = false, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cpf = null;

  /**
   * C03 xNome Raz�o Social ou Nome do emitente E C01 C 1-1 2 - 60
   */
  @RFWMetaStringField(caption = "Nome", minlength = 2, maxLength = 60, required = true, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xnome = null;

  /**
   * C04 xFant Nome fantasia E C01 C 0-1 1 - 60
   */
  @RFWMetaStringField(caption = "Nome Fantasia", minlength = 1, maxLength = 60, required = false, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xfant = null;

  /**
   * C17 IE Inscri��o Estadual do Emitente E C01 C 1-1 2 - 14<br>
   * Informar somente os algarismos, sem os caracteres de formata��o (ponto, barra, h�fen, etc.).
   */
  @RFWMetaStringIEField(caption = "IE", required = true)
  private String ie = null;

  /**
   * C18 IEST IE do Substituto Tribut�rio E C01 N 0-1 2 - 14<br>
   * IE do Substituto Tribut�rio da UF de destino da mercadoria, quando houver a reten��o do ICMS ST para a UF de destino
   */
  @RFWMetaStringIEField(caption = "IE ST", required = false)
  private String ieST = null;

  /**
   * C19 IM Inscri��o Municipal do Prestador de Servi�o E C18.1 C 1-1 1 - 15<Br>
   * Informado na emiss�o de NF-e conjugada, com itens de produtos sujeitos ao ICMS e itens de servi�os sujeitos ao ISSQN.
   */
  @RFWMetaStringField(caption = "IM", minlength = 1, maxLength = 15, required = false)
  private String im = null;

  /**
   * C20 CNAE CNAE fiscal E C18.1 N 0-1 7<br>
   * Campo Opcional. Pode ser informado quando a Inscri��o Municipal (id:C19) for informada.
   */
  @RFWMetaStringField(caption = "CNAE", minlength = 7, maxLength = 7, required = false, pattern = "\\d{7}")
  private String cnae = null;

  /**
   * C21 CRT C�digo de Regime Tribut�rio E C01 N 1-1 1
   * <li>1=Simples Nacional;
   * <li>2=Simples Nacional, excesso sublimite de receita bruta;
   * <li>3=Regime Normal. (v2.0).
   */
  @RFWMetaStringField(caption = "CRT", minlength = 1, maxLength = 1, required = false, pattern = "^(1|2|3)$")
  private String crt = null;

  /**
   * # c05 enderEmit Endere�o do emitente G C01 1-1.
   *
   * @return # c05 enderEmit Endere�o do emitente G C01 1-1
   */
  public EnderEmitVO getEnderEmit() {
    return enderEmit;
  }

  /**
   * # c05 enderEmit Endere�o do emitente G C01 1-1.
   *
   * @param enderEmit # c05 enderEmit Endere�o do emitente G C01 1-1
   */
  public void setEnderEmit(EnderEmitVO enderEmit) {
    this.enderEmit = enderEmit;
  }

  /**
   * # c02 CNPJ CNPJ do emitente CE C01 N 1-1 14<br>
   * Informar o CNPJ do emitente. Na emiss�o de NF-e avulsa pelo Fisco, as informa��es do remetente ser�o informadas neste grupo. O CNPJ ou CPF dever�o ser informados com os zeros n�o significativos.
   *
   * @return # c02 CNPJ CNPJ do emitente CE C01 N 1-1 14<br>
   *         Informar o CNPJ do emitente
   */
  public String getCnpj() {
    return cnpj;
  }

  /**
   * # c02 CNPJ CNPJ do emitente CE C01 N 1-1 14<br>
   * Informar o CNPJ do emitente. Na emiss�o de NF-e avulsa pelo Fisco, as informa��es do remetente ser�o informadas neste grupo. O CNPJ ou CPF dever�o ser informados com os zeros n�o significativos.
   *
   * @param cnpj # c02 CNPJ CNPJ do emitente CE C01 N 1-1 14<br>
   *          Informar o CNPJ do emitente
   */
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  /**
   * # c02a CPF CPF do remetente CE C01 N 1-1 11.
   *
   * @return # c02a CPF CPF do remetente CE C01 N 1-1 11
   */
  public String getCpf() {
    return cpf;
  }

  /**
   * # c02a CPF CPF do remetente CE C01 N 1-1 11.
   *
   * @param cpf # c02a CPF CPF do remetente CE C01 N 1-1 11
   */
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  /**
   * # c03 xNome Raz�o Social ou Nome do emitente E C01 C 1-1 2 - 60.
   *
   * @return # c03 xNome Raz�o Social ou Nome do emitente E C01 C 1-1 2 - 60
   */
  public String getXnome() {
    return xnome;
  }

  /**
   * # c03 xNome Raz�o Social ou Nome do emitente E C01 C 1-1 2 - 60.
   *
   * @param xnome # c03 xNome Raz�o Social ou Nome do emitente E C01 C 1-1 2 - 60
   */
  public void setXnome(String xnome) {
    this.xnome = xnome;
  }

  /**
   * # c04 xFant Nome fantasia E C01 C 0-1 1 - 60.
   *
   * @return # c04 xFant Nome fantasia E C01 C 0-1 1 - 60
   */
  public String getXfant() {
    return xfant;
  }

  /**
   * # c04 xFant Nome fantasia E C01 C 0-1 1 - 60.
   *
   * @param xfant # c04 xFant Nome fantasia E C01 C 0-1 1 - 60
   */
  public void setXfant(String xfant) {
    this.xfant = xfant;
  }

  /**
   * # c17 IE Inscri��o Estadual do Emitente E C01 C 1-1 2 - 14<br>
   * Informar somente os algarismos, sem os caracteres de formata��o (ponto, barra, h�fen, etc.).
   *
   * @return # c17 IE Inscri��o Estadual do Emitente E C01 C 1-1 2 - 14<br>
   *         Informar somente os algarismos, sem os caracteres de formata��o (ponto, barra, h�fen, etc
   */
  public String getIe() {
    return ie;
  }

  /**
   * # c17 IE Inscri��o Estadual do Emitente E C01 C 1-1 2 - 14<br>
   * Informar somente os algarismos, sem os caracteres de formata��o (ponto, barra, h�fen, etc.).
   *
   * @param ie # c17 IE Inscri��o Estadual do Emitente E C01 C 1-1 2 - 14<br>
   *          Informar somente os algarismos, sem os caracteres de formata��o (ponto, barra, h�fen, etc
   */
  public void setIe(String ie) {
    this.ie = ie;
  }

  /**
   * # c18 IEST IE do Substituto Tribut�rio E C01 N 0-1 2 - 14<br>
   * IE do Substituto Tribut�rio da UF de destino da mercadoria, quando houver a reten��o do ICMS ST para a UF de destino.
   *
   * @return # c18 IEST IE do Substituto Tribut�rio E C01 N 0-1 2 - 14<br>
   *         IE do Substituto Tribut�rio da UF de destino da mercadoria, quando houver a reten��o do ICMS ST para a UF de destino
   */
  public String getIeST() {
    return ieST;
  }

  /**
   * # c18 IEST IE do Substituto Tribut�rio E C01 N 0-1 2 - 14<br>
   * IE do Substituto Tribut�rio da UF de destino da mercadoria, quando houver a reten��o do ICMS ST para a UF de destino.
   *
   * @param ieST # c18 IEST IE do Substituto Tribut�rio E C01 N 0-1 2 - 14<br>
   *          IE do Substituto Tribut�rio da UF de destino da mercadoria, quando houver a reten��o do ICMS ST para a UF de destino
   */
  public void setIeST(String ieST) {
    this.ieST = ieST;
  }

  /**
   * # c19 IM Inscri��o Municipal do Prestador de Servi�o E C18.1 C 1-1 1 - 15<Br>
   * Informado na emiss�o de NF-e conjugada, com itens de produtos sujeitos ao ICMS e itens de servi�os sujeitos ao ISSQN.
   *
   * @return # c19 IM Inscri��o Municipal do Prestador de Servi�o E C18
   */
  public String getIm() {
    return im;
  }

  /**
   * # c19 IM Inscri��o Municipal do Prestador de Servi�o E C18.1 C 1-1 1 - 15<Br>
   * Informado na emiss�o de NF-e conjugada, com itens de produtos sujeitos ao ICMS e itens de servi�os sujeitos ao ISSQN.
   *
   * @param im # c19 IM Inscri��o Municipal do Prestador de Servi�o E C18
   */
  public void setIm(String im) {
    this.im = im;
  }

  /**
   * # c20 CNAE CNAE fiscal E C18.1 N 0-1 7<br>
   * Campo Opcional. Pode ser informado quando a Inscri��o Municipal (id:C19) for informada.
   *
   * @return # c20 CNAE CNAE fiscal E C18
   */
  public String getCnae() {
    return cnae;
  }

  /**
   * # c20 CNAE CNAE fiscal E C18.1 N 0-1 7<br>
   * Campo Opcional. Pode ser informado quando a Inscri��o Municipal (id:C19) for informada.
   *
   * @param cnae # c20 CNAE CNAE fiscal E C18
   */
  public void setCnae(String cnae) {
    this.cnae = cnae;
  }

  /**
   * # c21 CRT C�digo de Regime Tribut�rio E C01 N 1-1 1
   * <li>1=Simples Nacional;
   * <li>2=Simples Nacional, excesso sublimite de receita bruta;
   * <li>3=Regime Normal. (v2.0).
   *
   * @return # c21 CRT C�digo de Regime Tribut�rio E C01 N 1-1 1
   *         <li>1=Simples Nacional;
   *         <li>2=Simples Nacional, excesso sublimite de receita bruta;
   *         <li>3=Regime Normal
   */
  public String getCrt() {
    return crt;
  }

  /**
   * # c21 CRT C�digo de Regime Tribut�rio E C01 N 1-1 1
   * <li>1=Simples Nacional;
   * <li>2=Simples Nacional, excesso sublimite de receita bruta;
   * <li>3=Regime Normal. (v2.0).
   *
   * @param crt # c21 CRT C�digo de Regime Tribut�rio E C01 N 1-1 1
   *          <li>1=Simples Nacional;
   *          <li>2=Simples Nacional, excesso sublimite de receita bruta;
   *          <li>3=Regime Normal
   */
  public void setCrt(String crt) {
    this.crt = crt;
  }

}
