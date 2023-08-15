package br.eng.rodrigogml.rfw.sefaz.vos;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCEPField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "enderEmit" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integra��o com o framework, pertindo a valida��o e at� a persist�ncia se o sistema assim desejar. N�o h� preocupa��o de gerar JavaDOC nestas classes pois ela deve representar exatamente a documenta��o da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Valida��o da NF-e.
 */
public class EnderEmitVO extends RFWVO {

  private static final long serialVersionUID = -7391617811921685802L;

  /**
   * C06 xLgr Logradouro E C05 C 1-1 2 - 60
   */
  @RFWMetaStringField(caption = "Logaradouro", minlength = 2, maxLength = 60, required = true, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xLgr = null;

  /**
   * C07 nro N�mero E C05 C 1-1 1 - 60
   */
  @RFWMetaStringField(caption = "N�mero", minlength = 1, maxLength = 60, required = true, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String nro = null;

  /**
   * C08 xCpl Complemento E C05 C 0-1 1 - 60
   */
  @RFWMetaStringField(caption = "Complemento", minlength = 1, maxLength = 60, required = false, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xcpl = null;

  /**
   * C09 xBairro Bairro E C05 C 1-1 2 - 60
   */
  @RFWMetaStringField(caption = "Bairro", minlength = 2, maxLength = 60, required = true, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xbairro = null;

  /**
   * C10 cMun C�digo do munic�pio E C05 N 1-1 7<br>
   * Utilizar a Tabela do IBGE (Se��o 8.2 do MOC � Vis�o Geral, Tabela de UF, Munic�pio e Pa�s)
   */
  @RFWMetaStringField(caption = "C�digo Munic�pio", minlength = 7, maxLength = 7, required = true, pattern = "\\d{7}")
  private String cmun = null;

  /**
   * C11 xMun Nome do munic�pio E C05 C 1-1 2 - 60
   */
  @RFWMetaStringField(caption = "Nome Munic�pio", minlength = 2, maxLength = 60, required = true, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xmun = null;

  /**
   * C12 UF Sigla da UF E C05 C 1-1 2
   */
  @RFWMetaStringField(caption = "Sigla da UF", minlength = 2, maxLength = 2, required = true, pattern = "^(AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|MG|MS|MT|PA|PB|PE|PI|PR|RJ|RN|RO|RR|RS|SC|SE|SP|TO)$")
  private String uf = null;

  /**
   * C13 CEP C�digo do CEP E C05 N 1-1 8 Informar os zeros n�o significativos. (NT 2011/004)
   */
  @RFWMetaStringCEPField(caption = "CEP", required = true)
  private String cep = null;

  /**
   * C14 cPais C�digo do Pa�s E C05 N 0-1 4<br>
   * 1058=Brasil
   */
  @RFWMetaStringField(caption = "C�digo do Pa�s", minlength = 4, maxLength = 4, required = false, pattern = "\\d{4}")
  private String cpais = null;

  /**
   * C15 xPais Nome do Pa�s E C05 C 0-1 1 - 60<br>
   * Brasil ou BRASIL
   */
  @RFWMetaStringField(caption = "Nome do Pa�s", minlength = 1, maxLength = 60, required = true, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xnome = null;

  /**
   * C16 fone Telefone E C05 N 0-1 6 - 14<br>
   * Preencher com o C�digo DDD + n�mero do telefone. Nas opera��es com exterior � permitido informar o c�digo do pa�s + c�digo da localidade + n�mero do telefone (v2.0)
   */
  @RFWMetaStringField(caption = "Telefone", minlength = 6, maxLength = 14, required = false, pattern = "\\d{6,14}")
  private String fone = null;

  public String getxLgr() {
    return xLgr;
  }

  public void setxLgr(String xLgr) {
    this.xLgr = xLgr;
  }

  /**
   * # c07 nro N�mero E C05 C 1-1 1 - 60.
   *
   * @return # c07 nro N�mero E C05 C 1-1 1 - 60
   */
  public String getNro() {
    return nro;
  }

  /**
   * # c07 nro N�mero E C05 C 1-1 1 - 60.
   *
   * @param nro # c07 nro N�mero E C05 C 1-1 1 - 60
   */
  public void setNro(String nro) {
    this.nro = nro;
  }

  /**
   * # c08 xCpl Complemento E C05 C 0-1 1 - 60.
   *
   * @return # c08 xCpl Complemento E C05 C 0-1 1 - 60
   */
  public String getXcpl() {
    return xcpl;
  }

  /**
   * # c08 xCpl Complemento E C05 C 0-1 1 - 60.
   *
   * @param xcpl # c08 xCpl Complemento E C05 C 0-1 1 - 60
   */
  public void setXcpl(String xcpl) {
    this.xcpl = xcpl;
  }

  /**
   * # c09 xBairro Bairro E C05 C 1-1 2 - 60.
   *
   * @return # c09 xBairro Bairro E C05 C 1-1 2 - 60
   */
  public String getXbairro() {
    return xbairro;
  }

  /**
   * # c09 xBairro Bairro E C05 C 1-1 2 - 60.
   *
   * @param xbairro # c09 xBairro Bairro E C05 C 1-1 2 - 60
   */
  public void setXbairro(String xbairro) {
    this.xbairro = xbairro;
  }

  /**
   * # c10 cMun C�digo do munic�pio E C05 N 1-1 7<br>
   * Utilizar a Tabela do IBGE (Se��o 8.2 do MOC � Vis�o Geral, Tabela de UF, Munic�pio e Pa�s).
   *
   * @return # c10 cMun C�digo do munic�pio E C05 N 1-1 7<br>
   *         Utilizar a Tabela do IBGE (Se��o 8
   */
  public String getCmun() {
    return cmun;
  }

  /**
   * # c10 cMun C�digo do munic�pio E C05 N 1-1 7<br>
   * Utilizar a Tabela do IBGE (Se��o 8.2 do MOC � Vis�o Geral, Tabela de UF, Munic�pio e Pa�s).
   *
   * @param cmun # c10 cMun C�digo do munic�pio E C05 N 1-1 7<br>
   *          Utilizar a Tabela do IBGE (Se��o 8
   */
  public void setCmun(String cmun) {
    this.cmun = cmun;
  }

  /**
   * # c11 xMun Nome do munic�pio E C05 C 1-1 2 - 60.
   *
   * @return # c11 xMun Nome do munic�pio E C05 C 1-1 2 - 60
   */
  public String getXmun() {
    return xmun;
  }

  /**
   * # c11 xMun Nome do munic�pio E C05 C 1-1 2 - 60.
   *
   * @param xmun # c11 xMun Nome do munic�pio E C05 C 1-1 2 - 60
   */
  public void setXmun(String xmun) {
    this.xmun = xmun;
  }

  /**
   * # c12 UF Sigla da UF E C05 C 1-1 2.
   *
   * @return # c12 UF Sigla da UF E C05 C 1-1 2
   */
  public String getUf() {
    return uf;
  }

  /**
   * # c12 UF Sigla da UF E C05 C 1-1 2.
   *
   * @param uf # c12 UF Sigla da UF E C05 C 1-1 2
   */
  public void setUf(String uf) {
    this.uf = uf;
  }

  /**
   * # c13 CEP C�digo do CEP E C05 N 1-1 8 Informar os zeros n�o significativos. (NT 2011/004).
   *
   * @return # c13 CEP C�digo do CEP E C05 N 1-1 8 Informar os zeros n�o significativos
   */
  public String getCep() {
    return cep;
  }

  /**
   * # c13 CEP C�digo do CEP E C05 N 1-1 8 Informar os zeros n�o significativos. (NT 2011/004).
   *
   * @param cep # c13 CEP C�digo do CEP E C05 N 1-1 8 Informar os zeros n�o significativos
   */
  public void setCep(String cep) {
    this.cep = cep;
  }

  /**
   * # c14 cPais C�digo do Pa�s E C05 N 0-1 4<br>
   * 1058=Brasil.
   *
   * @return # c14 cPais C�digo do Pa�s E C05 N 0-1 4<br>
   *         1058=Brasil
   */
  public String getCpais() {
    return cpais;
  }

  /**
   * # c14 cPais C�digo do Pa�s E C05 N 0-1 4<br>
   * 1058=Brasil.
   *
   * @param cpais # c14 cPais C�digo do Pa�s E C05 N 0-1 4<br>
   *          1058=Brasil
   */
  public void setCpais(String cpais) {
    this.cpais = cpais;
  }

  /**
   * # c15 xPais Nome do Pa�s E C05 C 0-1 1 - 60<br>
   * Brasil ou BRASIL.
   *
   * @return # c15 xPais Nome do Pa�s E C05 C 0-1 1 - 60<br>
   *         Brasil ou BRASIL
   */
  public String getXnome() {
    return xnome;
  }

  /**
   * # c15 xPais Nome do Pa�s E C05 C 0-1 1 - 60<br>
   * Brasil ou BRASIL.
   *
   * @param xnome # c15 xPais Nome do Pa�s E C05 C 0-1 1 - 60<br>
   *          Brasil ou BRASIL
   */
  public void setXnome(String xnome) {
    this.xnome = xnome;
  }

  /**
   * # c16 fone Telefone E C05 N 0-1 6 - 14<br>
   * Preencher com o C�digo DDD + n�mero do telefone. Nas opera��es com exterior � permitido informar o c�digo do pa�s + c�digo da localidade + n�mero do telefone (v2.0).
   *
   * @return # c16 fone Telefone E C05 N 0-1 6 - 14<br>
   *         Preencher com o C�digo DDD + n�mero do telefone
   */
  public String getFone() {
    return fone;
  }

  /**
   * # c16 fone Telefone E C05 N 0-1 6 - 14<br>
   * Preencher com o C�digo DDD + n�mero do telefone. Nas opera��es com exterior � permitido informar o c�digo do pa�s + c�digo da localidade + n�mero do telefone (v2.0).
   *
   * @param fone # c16 fone Telefone E C05 N 0-1 6 - 14<br>
   *          Preencher com o C�digo DDD + n�mero do telefone
   */
  public void setFone(String fone) {
    this.fone = fone;
  }

}
