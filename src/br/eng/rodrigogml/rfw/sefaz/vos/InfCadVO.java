package br.eng.rodrigogml.rfw.sefaz.vos;

import java.time.LocalDate;
import java.util.List;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaDateField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "infCad" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class InfCadVO extends RFWVO {

  private static final long serialVersionUID = -6403968987720983710L;

  /**
   * GR08 IE E GR07 C 1-1 2-14<br>
   * Inscrição estadual do contribuinte
   */
  @RFWMetaStringField(caption = "IE", minlength = 2, maxLength = 14, required = true)
  private String ie = null;

  /**
   * GR09 CNPJ CE GR07 N 1-1 3-14<Br>
   * CNPJ do contribuinte
   */
  @RFWMetaStringField(caption = "CNPJ", minlength = 3, maxLength = 14, required = false)
  private String cnpj = null;

  /**
   * GR10 CPF CE GR07 N 1-1 3-11<br>
   * CPF em caso de pessoa física com IE
   */
  @RFWMetaStringField(caption = "CPF", minlength = 3, maxLength = 11, required = false)
  private String cpf = null;

  /**
   * GR11 UF E GR07 C 1-1 2<Br>
   * O campo deve ser preenchido com a sigla da UF de localização do contribuinte. Em algumas situações, a UF de localização pode ser diferente da UF consultada. Ex. IE de contribuinte inscrito como Substituto Tributário.
   */
  @RFWMetaStringField(caption = "UF", minlength = 2, maxLength = 2, required = true)
  private String uf = null;

  /**
   * GR12 cSit E GR07 N 1-1 1<br>
   * Situação do contribuinte:
   * <li>0=não habilitado;
   * <li>1=habilitado.
   */
  @RFWMetaStringField(caption = "Situação do Contribuinte", minlength = 1, maxLength = 1, required = true, pattern = "^(0|1)$")
  private String csit = null;

  /**
   * GR12a indCredNFe E GR07 N 1-1 1<br>
   * Indicador de contribuinte credenciado a emitir NF-e.
   * <li>0=Não credenciado para emissão da NF-e;
   * <li>1=Credenciado;
   * <li>2=Credenciado com obrigatoriedade para todas operações;
   * <li>3=Credenciado com obrigatoriedade parcial;
   * <li>4=a SEFAZ não fornece a informação. <br>
   * Este indicador significa apenas que o contribuinte é credenciado para emitir NF-e na SEFAZ consultada.
   */
  @RFWMetaStringField(caption = "Contribuinte Credenciado a Emitir NFe", minlength = 1, maxLength = 1, required = true, pattern = "^(0|1|2|3|4)$")
  private String indCredNFe = null;

  /**
   * GR12b indCredCTe E GR07 N 1-1 1<br>
   * Indicador de contribuinte credenciado a emitir CT-e.
   * <li>0=Não credenciado para emissão da CT-e;
   * <li>1=Credenciado;
   * <li>2=Credenciado com obrigatoriedade para todas operações;
   * <li>3=Credenciado com obrigatoriedade parcial;
   * <li>4=a SEFAZ não fornece a informação. <br>
   * Este indicador significa apenas que o contribuinte é credenciado para emitir CT-e na SEFAZ consultada
   */
  @RFWMetaStringField(caption = "Contribuinte Credenciado a Emitir CTe", minlength = 1, maxLength = 1, required = true, pattern = "^(0|1|2|3|4)$")
  private String indCredCTe = null;

  /**
   * GR13 xNome E GR07 C 1-1 1-60<br>
   * Razão Social ou nome do Contribuinte
   */
  @RFWMetaStringField(caption = "Razão Social / Nome", minlength = 1, maxLength = 60, required = true)
  private String xnome = null;

  /**
   * GR13a xFant E GR07 C 0-1 1-60<br>
   * Nome Fantasia
   */
  @RFWMetaStringField(caption = "Nome Fantasia", minlength = 1, maxLength = 60, required = false)
  private String xfant = null;

  /**
   * GR14 xRegApur E GR07 C 0-1 1-60<br>
   * Regime de Apuração do ICMS do Contribuinte
   */
  @RFWMetaStringField(caption = "Regime de Apuração", minlength = 1, maxLength = 60, required = false)
  private String xregApur = null;

  /**
   * GR15 CNAE E GR07 N 0-1 6-7<bR>
   * CNAE principal do contribuinte
   */
  @RFWMetaStringField(caption = "CNAE Principal", minlength = 6, maxLength = 7, required = false)
  private String cnar = null;

  /**
   * GR16 dIniAtiv E GR07 D 0-1<br>
   * Data de Início da Atividade do Contribuinte
   */
  @RFWMetaDateField(caption = "Data de Início da Atividade", required = false)
  private LocalDate diniAtiv = null;

  /**
   * GR17 dUltSit E GR07 D 0-1<Br>
   * Data da última modificação da situação cadastral do contribuinte.
   */
  @RFWMetaDateField(caption = "Data da Última Modificação", required = false)
  private LocalDate dultSit = null;

  /**
   * GR18 dBaixa E GR07 D 0-1<bR>
   * Data de ocorrência da baixa do contribuinte.
   */
  @RFWMetaDateField(caption = "Data da Ocorrência", required = false)
  private LocalDate dbaixa = null;

  /**
   * GR20 IEUnica E GR07 C 0-1 2-14<br>
   * IE única, este campo será informado quando o contribuinte possuir IE única
   */
  @RFWMetaStringField(caption = "IE Única", minlength = 2, maxLength = 14, required = false)
  private String ieUnica = null;

  /**
   * GR21 IEAtual E GR07 C 0-1 2-14<br>
   * IE atual (em caso de IE antiga consultada)
   */
  @RFWMetaStringField(caption = "IE Atual", minlength = 2, maxLength = 14, required = false)
  private String ieAtual = null;

  /**
   * GR22 Ender G GR07 0-1<br>
   * Endereço – grupo de informações opcionais.
   */
  @RFWMetaRelationshipField(caption = "Endereço", required = false, relationship = RelationshipTypes.COMPOSITION)
  private List<EnderVO> ender = null;

  /**
   * # gR08 IE E GR07 C 1-1 2-14<br>
   * Inscrição estadual do contribuinte.
   *
   * @return # gR08 IE E GR07 C 1-1 2-14<br>
   *         Inscrição estadual do contribuinte
   */
  public String getIe() {
    return ie;
  }

  /**
   * # gR08 IE E GR07 C 1-1 2-14<br>
   * Inscrição estadual do contribuinte.
   *
   * @param ie # gR08 IE E GR07 C 1-1 2-14<br>
   *          Inscrição estadual do contribuinte
   */
  public void setIe(String ie) {
    this.ie = ie;
  }

  /**
   * # gR09 CNPJ CE GR07 N 1-1 3-14<Br>
   * CNPJ do contribuinte.
   *
   * @return # gR09 CNPJ CE GR07 N 1-1 3-14<Br>
   *         CNPJ do contribuinte
   */
  public String getCnpj() {
    return cnpj;
  }

  /**
   * # gR09 CNPJ CE GR07 N 1-1 3-14<Br>
   * CNPJ do contribuinte.
   *
   * @param cnpj # gR09 CNPJ CE GR07 N 1-1 3-14<Br>
   *          CNPJ do contribuinte
   */
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  /**
   * # gR10 CPF CE GR07 N 1-1 3-11<br>
   * CPF em caso de pessoa física com IE.
   *
   * @return # gR10 CPF CE GR07 N 1-1 3-11<br>
   *         CPF em caso de pessoa física com IE
   */
  public String getCpf() {
    return cpf;
  }

  /**
   * # gR10 CPF CE GR07 N 1-1 3-11<br>
   * CPF em caso de pessoa física com IE.
   *
   * @param cpf # gR10 CPF CE GR07 N 1-1 3-11<br>
   *          CPF em caso de pessoa física com IE
   */
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  /**
   * # gR11 UF E GR07 C 1-1 2<Br>
   * O campo deve ser preenchido com a sigla da UF de localização do contribuinte. Em algumas situações, a UF de localização pode ser diferente da UF consultada. Ex. IE de contribuinte inscrito como Substituto Tributário.
   *
   * @return # gR11 UF E GR07 C 1-1 2<Br>
   *         O campo deve ser preenchido com a sigla da UF de localização do contribuinte
   */
  public String getUf() {
    return uf;
  }

  /**
   * # gR11 UF E GR07 C 1-1 2<Br>
   * O campo deve ser preenchido com a sigla da UF de localização do contribuinte. Em algumas situações, a UF de localização pode ser diferente da UF consultada. Ex. IE de contribuinte inscrito como Substituto Tributário.
   *
   * @param uf # gR11 UF E GR07 C 1-1 2<Br>
   *          O campo deve ser preenchido com a sigla da UF de localização do contribuinte
   */
  public void setUf(String uf) {
    this.uf = uf;
  }

  /**
   * # gR12 cSit E GR07 N 1-1 1<br>
   * Situação do contribuinte:
   * <li>0=não habilitado;
   * <li>1=habilitado.
   *
   * @return # gR12 cSit E GR07 N 1-1 1<br>
   *         Situação do contribuinte:
   *         <li>0=não habilitado;
   *         <li>1=habilitado
   */
  public String getCsit() {
    return csit;
  }

  /**
   * # gR12 cSit E GR07 N 1-1 1<br>
   * Situação do contribuinte:
   * <li>0=não habilitado;
   * <li>1=habilitado.
   *
   * @param csit # gR12 cSit E GR07 N 1-1 1<br>
   *          Situação do contribuinte:
   *          <li>0=não habilitado;
   *          <li>1=habilitado
   */
  public void setCsit(String csit) {
    this.csit = csit;
  }

  /**
   * # gR12a indCredNFe E GR07 N 1-1 1<br>
   * Indicador de contribuinte credenciado a emitir NF-e.
   * <li>0=Não credenciado para emissão da NF-e;
   * <li>1=Credenciado;
   * <li>2=Credenciado com obrigatoriedade para todas operações;
   * <li>3=Credenciado com obrigatoriedade parcial;
   * <li>4=a SEFAZ não fornece a informação. <br>
   * Este indicador significa apenas que o contribuinte é credenciado para emitir NF-e na SEFAZ consultada.
   *
   * @return # gR12a indCredNFe E GR07 N 1-1 1<br>
   *         Indicador de contribuinte credenciado a emitir NF-e
   */
  public String getIndCredNFe() {
    return indCredNFe;
  }

  /**
   * # gR12a indCredNFe E GR07 N 1-1 1<br>
   * Indicador de contribuinte credenciado a emitir NF-e.
   * <li>0=Não credenciado para emissão da NF-e;
   * <li>1=Credenciado;
   * <li>2=Credenciado com obrigatoriedade para todas operações;
   * <li>3=Credenciado com obrigatoriedade parcial;
   * <li>4=a SEFAZ não fornece a informação. <br>
   * Este indicador significa apenas que o contribuinte é credenciado para emitir NF-e na SEFAZ consultada.
   *
   * @param indCredNFe # gR12a indCredNFe E GR07 N 1-1 1<br>
   *          Indicador de contribuinte credenciado a emitir NF-e
   */
  public void setIndCredNFe(String indCredNFe) {
    this.indCredNFe = indCredNFe;
  }

  /**
   * # gR12b indCredCTe E GR07 N 1-1 1<br>
   * Indicador de contribuinte credenciado a emitir CT-e.
   * <li>0=Não credenciado para emissão da CT-e;
   * <li>1=Credenciado;
   * <li>2=Credenciado com obrigatoriedade para todas operações;
   * <li>3=Credenciado com obrigatoriedade parcial;
   * <li>4=a SEFAZ não fornece a informação. <br>
   * Este indicador significa apenas que o contribuinte é credenciado para emitir CT-e na SEFAZ consultada.
   *
   * @return # gR12b indCredCTe E GR07 N 1-1 1<br>
   *         Indicador de contribuinte credenciado a emitir CT-e
   */
  public String getIndCredCTe() {
    return indCredCTe;
  }

  /**
   * # gR12b indCredCTe E GR07 N 1-1 1<br>
   * Indicador de contribuinte credenciado a emitir CT-e.
   * <li>0=Não credenciado para emissão da CT-e;
   * <li>1=Credenciado;
   * <li>2=Credenciado com obrigatoriedade para todas operações;
   * <li>3=Credenciado com obrigatoriedade parcial;
   * <li>4=a SEFAZ não fornece a informação. <br>
   * Este indicador significa apenas que o contribuinte é credenciado para emitir CT-e na SEFAZ consultada.
   *
   * @param indCredCTe # gR12b indCredCTe E GR07 N 1-1 1<br>
   *          Indicador de contribuinte credenciado a emitir CT-e
   */
  public void setIndCredCTe(String indCredCTe) {
    this.indCredCTe = indCredCTe;
  }

  /**
   * # gR13 xNome E GR07 C 1-1 1-60<br>
   * Razão Social ou nome do Contribuinte.
   *
   * @return # gR13 xNome E GR07 C 1-1 1-60<br>
   *         Razão Social ou nome do Contribuinte
   */
  public String getXnome() {
    return xnome;
  }

  /**
   * # gR13 xNome E GR07 C 1-1 1-60<br>
   * Razão Social ou nome do Contribuinte.
   *
   * @param xnome # gR13 xNome E GR07 C 1-1 1-60<br>
   *          Razão Social ou nome do Contribuinte
   */
  public void setXnome(String xnome) {
    this.xnome = xnome;
  }

  /**
   * # gR13a xFant E GR07 C 0-1 1-60<br>
   * Nome Fantasia.
   *
   * @return # gR13a xFant E GR07 C 0-1 1-60<br>
   *         Nome Fantasia
   */
  public String getXfant() {
    return xfant;
  }

  /**
   * # gR13a xFant E GR07 C 0-1 1-60<br>
   * Nome Fantasia.
   *
   * @param xfant # gR13a xFant E GR07 C 0-1 1-60<br>
   *          Nome Fantasia
   */
  public void setXfant(String xfant) {
    this.xfant = xfant;
  }

  /**
   * # gR14 xRegApur E GR07 C 0-1 1-60<br>
   * Regime de Apuração do ICMS do Contribuinte.
   *
   * @return # gR14 xRegApur E GR07 C 0-1 1-60<br>
   *         Regime de Apuração do ICMS do Contribuinte
   */
  public String getXregApur() {
    return xregApur;
  }

  /**
   * # gR14 xRegApur E GR07 C 0-1 1-60<br>
   * Regime de Apuração do ICMS do Contribuinte.
   *
   * @param xregApur # gR14 xRegApur E GR07 C 0-1 1-60<br>
   *          Regime de Apuração do ICMS do Contribuinte
   */
  public void setXregApur(String xregApur) {
    this.xregApur = xregApur;
  }

  /**
   * # gR15 CNAE E GR07 N 0-1 6-7<bR>
   * CNAE principal do contribuinte.
   *
   * @return # gR15 CNAE E GR07 N 0-1 6-7<bR>
   *         CNAE principal do contribuinte
   */
  public String getCnar() {
    return cnar;
  }

  /**
   * # gR15 CNAE E GR07 N 0-1 6-7<bR>
   * CNAE principal do contribuinte.
   *
   * @param cnar # gR15 CNAE E GR07 N 0-1 6-7<bR>
   *          CNAE principal do contribuinte
   */
  public void setCnar(String cnar) {
    this.cnar = cnar;
  }

  /**
   * # gR16 dIniAtiv E GR07 D 0-1<br>
   * Data de Início da Atividade do Contribuinte.
   *
   * @return # gR16 dIniAtiv E GR07 D 0-1<br>
   *         Data de Início da Atividade do Contribuinte
   */
  public LocalDate getDiniAtiv() {
    return diniAtiv;
  }

  /**
   * # gR16 dIniAtiv E GR07 D 0-1<br>
   * Data de Início da Atividade do Contribuinte.
   *
   * @param diniAtiv # gR16 dIniAtiv E GR07 D 0-1<br>
   *          Data de Início da Atividade do Contribuinte
   */
  public void setDiniAtiv(LocalDate diniAtiv) {
    this.diniAtiv = diniAtiv;
  }

  /**
   * # gR17 dUltSit E GR07 D 0-1<Br>
   * Data da última modificação da situação cadastral do contribuinte.
   *
   * @return # gR17 dUltSit E GR07 D 0-1<Br>
   *         Data da última modificação da situação cadastral do contribuinte
   */
  public LocalDate getDultSit() {
    return dultSit;
  }

  /**
   * # gR17 dUltSit E GR07 D 0-1<Br>
   * Data da última modificação da situação cadastral do contribuinte.
   *
   * @param dultSit # gR17 dUltSit E GR07 D 0-1<Br>
   *          Data da última modificação da situação cadastral do contribuinte
   */
  public void setDultSit(LocalDate dultSit) {
    this.dultSit = dultSit;
  }

  /**
   * # gR18 dBaixa E GR07 D 0-1<bR>
   * Data de ocorrência da baixa do contribuinte.
   *
   * @return # gR18 dBaixa E GR07 D 0-1<bR>
   *         Data de ocorrência da baixa do contribuinte
   */
  public LocalDate getDbaixa() {
    return dbaixa;
  }

  /**
   * # gR18 dBaixa E GR07 D 0-1<bR>
   * Data de ocorrência da baixa do contribuinte.
   *
   * @param dbaixa # gR18 dBaixa E GR07 D 0-1<bR>
   *          Data de ocorrência da baixa do contribuinte
   */
  public void setDbaixa(LocalDate dbaixa) {
    this.dbaixa = dbaixa;
  }

  /**
   * # gR20 IEUnica E GR07 C 0-1 2-14<br>
   * IE única, este campo será informado quando o contribuinte possuir IE única.
   *
   * @return # gR20 IEUnica E GR07 C 0-1 2-14<br>
   *         IE única, este campo será informado quando o contribuinte possuir IE única
   */
  public String getIeUnica() {
    return ieUnica;
  }

  /**
   * # gR20 IEUnica E GR07 C 0-1 2-14<br>
   * IE única, este campo será informado quando o contribuinte possuir IE única.
   *
   * @param ieUnica # gR20 IEUnica E GR07 C 0-1 2-14<br>
   *          IE única, este campo será informado quando o contribuinte possuir IE única
   */
  public void setIeUnica(String ieUnica) {
    this.ieUnica = ieUnica;
  }

  /**
   * # gR21 IEAtual E GR07 C 0-1 2-14<br>
   * IE atual (em caso de IE antiga consultada).
   *
   * @return # gR21 IEAtual E GR07 C 0-1 2-14<br>
   *         IE atual (em caso de IE antiga consultada)
   */
  public String getIeAtual() {
    return ieAtual;
  }

  /**
   * # gR21 IEAtual E GR07 C 0-1 2-14<br>
   * IE atual (em caso de IE antiga consultada).
   *
   * @param ieAtual # gR21 IEAtual E GR07 C 0-1 2-14<br>
   *          IE atual (em caso de IE antiga consultada)
   */
  public void setIeAtual(String ieAtual) {
    this.ieAtual = ieAtual;
  }

  /**
   * # gR22 Ender G GR07 0-1<br>
   * Endereço – grupo de informações opcionais.
   *
   * @return # gR22 Ender G GR07 0-1<br>
   *         Endereço – grupo de informações opcionais
   */
  public List<EnderVO> getEnder() {
    return ender;
  }

  /**
   * # gR22 Ender G GR07 0-1<br>
   * Endereço – grupo de informações opcionais.
   *
   * @param ender # gR22 Ender G GR07 0-1<br>
   *          Endereço – grupo de informações opcionais
   */
  public void setEnder(List<EnderVO> ender) {
    this.ender = ender;
  }

}
