package br.eng.rodrigogml.rfw.sefaz.vos;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaIntegerField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCEPField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

public class EnderDestVO extends RFWVO {

  private static final long serialVersionUID = -8241763562888561084L;

  /**
   * E06 xLgr Logradouro E E05 C 1-1 2 - 60
   */
  @RFWMetaStringField(caption = "Logradouro", minlength = 2, maxLength = 60, required = true, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xlgr = null;

  /**
   * E07 nro N�mero E E05 C 1-1 1 - 60
   */
  @RFWMetaStringField(caption = "N�mero", minlength = 1, maxLength = 60, required = true)
  private String nro = null;

  /**
   * E08 xCpl Complemento E E05 C 0-1 1 - 60
   */
  @RFWMetaStringField(caption = "Complemento", minlength = 1, maxLength = 60, required = false, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xcpl = null;

  /**
   * E09 xBairro Bairro E E05 C 1-1 2 - 60
   */
  @RFWMetaStringField(caption = "Bairro", minlength = 2, maxLength = 60, required = true, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xbairro = null;

  /**
   * E10 cMun C�digo do munic�pio E E05 N 1-1 7<br>
   * Utilizar a Tabela do IBGE (Se��o 8.2 do MOC � Vis�o Geral, - Tabela de UF, Munic�pio e Pa�s).
   */
  @RFWMetaIntegerField(caption = "C�digo Munic�pio", minvalue = 0, maxvalue = 9999999, required = true)
  private Integer cmun = null;

  /**
   * E11 xMun Nome do munic�pio E E05 C 1-1 2 - 60<br>
   * Informar �EXTERIOR �para opera��es com o exterior
   */
  @RFWMetaStringField(caption = "Nome do Munic�pio", minlength = 2, maxLength = 60, required = true, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xmun = null;

  /**
   * E12 UF Sigla da UF E E05 C 1-1 2 Informar �EX� para opera��es com o exterior.
   */
  @RFWMetaStringField(caption = "Sigla UF", minlength = 2, maxLength = 2, required = true, pattern = "^(EX|AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|MG|MS|MT|PA|PB|PE|PI|PR|RJ|RN|RO|RR|RS|SC|SE|SP|TO)$")
  private String uf = null;

  /**
   * E13 CEP C�digo do CEP E E05 N 0-1 8<br>
   * Informar os zeros n�o significativos.
   */
  @RFWMetaStringCEPField(caption = "CEP", required = false)
  private String cep = null;

  /**
   * E14 cPais C�digo do Pa�s E E05 N 0-1 2 - 4<br>
   * Utilizar a Tabela do BACEN (Se��o 8.3 do MOC � Vis�o Geral, Tabela de UF, Munic�pio e Pa�s).
   */
  @RFWMetaIntegerField(caption = "C�digo do Pa�s", minvalue = 0, maxvalue = 9999, required = false)
  private Integer cpais = null;

  /**
   * E15 xPais Nome do Pa�s E E05 C 0-1 2 - 60
   */
  @RFWMetaStringField(caption = "Nome do Pa�s", minlength = 2, maxLength = 60, required = false, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xpais = null;

  /**
   * E16 fone Telefone E E05 N 0-1 6 - 14<br>
   * Preencher com o C�digo DDD + n�mero do telefone. Nas opera��es com exterior � permitido informar o c�digo do pa�s + c�digo da localidade + n�mero do telefone (v2.0)
   */
  @RFWMetaStringField(caption = "Telefone", minlength = 6, maxLength = 14, required = false, pattern = "\\d{6,14}", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String fone = null;

  /**
   * # e06 xLgr Logradouro E E05 C 1-1 2 - 60.
   *
   * @return # e06 xLgr Logradouro E E05 C 1-1 2 - 60
   */
  public String getXlgr() {
    return xlgr;
  }

  /**
   * # e06 xLgr Logradouro E E05 C 1-1 2 - 60.
   *
   * @param xlgr # e06 xLgr Logradouro E E05 C 1-1 2 - 60
   */
  public void setXlgr(String xlgr) {
    this.xlgr = xlgr;
  }

  /**
   * # e07 nro N�mero E E05 C 1-1 1 - 60.
   *
   * @return # e07 nro N�mero E E05 C 1-1 1 - 60
   */
  public String getNro() {
    return nro;
  }

  /**
   * # e07 nro N�mero E E05 C 1-1 1 - 60.
   *
   * @param nro # e07 nro N�mero E E05 C 1-1 1 - 60
   */
  public void setNro(String nro) {
    this.nro = nro;
  }

  /**
   * # e08 xCpl Complemento E E05 C 0-1 1 - 60.
   *
   * @return # e08 xCpl Complemento E E05 C 0-1 1 - 60
   */
  public String getXcpl() {
    return xcpl;
  }

  /**
   * # e08 xCpl Complemento E E05 C 0-1 1 - 60.
   *
   * @param xcpl # e08 xCpl Complemento E E05 C 0-1 1 - 60
   */
  public void setXcpl(String xcpl) {
    this.xcpl = xcpl;
  }

  /**
   * # e09 xBairro Bairro E E05 C 1-1 2 - 60.
   *
   * @return # e09 xBairro Bairro E E05 C 1-1 2 - 60
   */
  public String getXbairro() {
    return xbairro;
  }

  /**
   * # e09 xBairro Bairro E E05 C 1-1 2 - 60.
   *
   * @param xbairro # e09 xBairro Bairro E E05 C 1-1 2 - 60
   */
  public void setXbairro(String xbairro) {
    this.xbairro = xbairro;
  }

  /**
   * # e10 cMun C�digo do munic�pio E E05 N 1-1 7<br>
   * Utilizar a Tabela do IBGE (Se��o 8.2 do MOC � Vis�o Geral, - Tabela de UF, Munic�pio e Pa�s).
   *
   * @return # e10 cMun C�digo do munic�pio E E05 N 1-1 7<br>
   *         Utilizar a Tabela do IBGE (Se��o 8
   */
  public Integer getCmun() {
    return cmun;
  }

  /**
   * # e10 cMun C�digo do munic�pio E E05 N 1-1 7<br>
   * Utilizar a Tabela do IBGE (Se��o 8.2 do MOC � Vis�o Geral, - Tabela de UF, Munic�pio e Pa�s).
   *
   * @param cmun # e10 cMun C�digo do munic�pio E E05 N 1-1 7<br>
   *          Utilizar a Tabela do IBGE (Se��o 8
   */
  public void setCmun(Integer cmun) {
    this.cmun = cmun;
  }

  /**
   * # e11 xMun Nome do munic�pio E E05 C 1-1 2 - 60<br>
   * Informar �EXTERIOR �para opera��es com o exterior.
   *
   * @return # e11 xMun Nome do munic�pio E E05 C 1-1 2 - 60<br>
   *         Informar �EXTERIOR �para opera��es com o exterior
   */
  public String getXmun() {
    return xmun;
  }

  /**
   * # e11 xMun Nome do munic�pio E E05 C 1-1 2 - 60<br>
   * Informar �EXTERIOR �para opera��es com o exterior.
   *
   * @param xmun # e11 xMun Nome do munic�pio E E05 C 1-1 2 - 60<br>
   *          Informar �EXTERIOR �para opera��es com o exterior
   */
  public void setXmun(String xmun) {
    this.xmun = xmun;
  }

  /**
   * # e12 UF Sigla da UF E E05 C 1-1 2 Informar �EX� para opera��es com o exterior.
   *
   * @return # e12 UF Sigla da UF E E05 C 1-1 2 Informar �EX� para opera��es com o exterior
   */
  public String getUf() {
    return uf;
  }

  /**
   * # e12 UF Sigla da UF E E05 C 1-1 2 Informar �EX� para opera��es com o exterior.
   *
   * @param uf # e12 UF Sigla da UF E E05 C 1-1 2 Informar �EX� para opera��es com o exterior
   */
  public void setUf(String uf) {
    this.uf = uf;
  }

  /**
   * # e13 CEP C�digo do CEP E E05 N 0-1 8<br>
   * Informar os zeros n�o significativos.
   *
   * @return # e13 CEP C�digo do CEP E E05 N 0-1 8<br>
   *         Informar os zeros n�o significativos
   */
  public String getCep() {
    return cep;
  }

  /**
   * # e13 CEP C�digo do CEP E E05 N 0-1 8<br>
   * Informar os zeros n�o significativos.
   *
   * @param cep # e13 CEP C�digo do CEP E E05 N 0-1 8<br>
   *          Informar os zeros n�o significativos
   */
  public void setCep(String cep) {
    this.cep = cep;
  }

  /**
   * # e14 cPais C�digo do Pa�s E E05 N 0-1 2 - 4<br>
   * Utilizar a Tabela do BACEN (Se��o 8.3 do MOC � Vis�o Geral, Tabela de UF, Munic�pio e Pa�s).
   *
   * @return # e14 cPais C�digo do Pa�s E E05 N 0-1 2 - 4<br>
   *         Utilizar a Tabela do BACEN (Se��o 8
   */
  public Integer getCpais() {
    return cpais;
  }

  /**
   * # e14 cPais C�digo do Pa�s E E05 N 0-1 2 - 4<br>
   * Utilizar a Tabela do BACEN (Se��o 8.3 do MOC � Vis�o Geral, Tabela de UF, Munic�pio e Pa�s).
   *
   * @param cpais # e14 cPais C�digo do Pa�s E E05 N 0-1 2 - 4<br>
   *          Utilizar a Tabela do BACEN (Se��o 8
   */
  public void setCpais(Integer cpais) {
    this.cpais = cpais;
  }

  /**
   * # e15 xPais Nome do Pa�s E E05 C 0-1 2 - 60.
   *
   * @return # e15 xPais Nome do Pa�s E E05 C 0-1 2 - 60
   */
  public String getXpais() {
    return xpais;
  }

  /**
   * # e15 xPais Nome do Pa�s E E05 C 0-1 2 - 60.
   *
   * @param xpais # e15 xPais Nome do Pa�s E E05 C 0-1 2 - 60
   */
  public void setXpais(String xpais) {
    this.xpais = xpais;
  }

  /**
   * # e16 fone Telefone E E05 N 0-1 6 - 14<br>
   * Preencher com o C�digo DDD + n�mero do telefone. Nas opera��es com exterior � permitido informar o c�digo do pa�s + c�digo da localidade + n�mero do telefone (v2.0).
   *
   * @return # e16 fone Telefone E E05 N 0-1 6 - 14<br>
   *         Preencher com o C�digo DDD + n�mero do telefone
   */
  public String getFone() {
    return fone;
  }

  /**
   * # e16 fone Telefone E E05 N 0-1 6 - 14<br>
   * Preencher com o C�digo DDD + n�mero do telefone. Nas opera��es com exterior � permitido informar o c�digo do pa�s + c�digo da localidade + n�mero do telefone (v2.0).
   *
   * @param fone # e16 fone Telefone E E05 N 0-1 6 - 14<br>
   *          Preencher com o C�digo DDD + n�mero do telefone
   */
  public void setFone(String fone) {
    this.fone = fone;
  }
}
