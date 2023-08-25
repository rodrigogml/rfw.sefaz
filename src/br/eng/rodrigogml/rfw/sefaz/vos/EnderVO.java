package br.eng.rodrigogml.rfw.sefaz.vos;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "infCad" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integra��o com o framework, pertindo a valida��o e at� a persist�ncia se o sistema assim desejar. N�o h� preocupa��o de gerar JavaDOC nestas classes pois ela deve representar exatamente a documenta��o da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Valida��o da NF-e.
 */
public class EnderVO extends RFWVO {

  private static final long serialVersionUID = 307918296071520131L;

  /**
   * GR23 xLgr E GR22 C 0-1 1-255<br>
   * Nome do Logradouro
   */
  @RFWMetaStringField(caption = "Logradouro", minlength = 1, maxLength = 255, required = false)
  private String xlgr = null;

  /**
   * GR24 Nro E GR22 C 0-1 1-60<br>
   * N�mero
   */
  @RFWMetaStringField(caption = "N�mero", minlength = 1, maxLength = 60, required = false)
  private String nro = null;

  /**
   * GR25 xCpl E GR22 C 0-1 1-60<br>
   * Complemento
   */
  @RFWMetaStringField(caption = "Complemento", minlength = 1, maxLength = 60, required = false)
  private String xcpl = null;

  /**
   * GR26 xBairro E GR22 C 0-1 1-60<br>
   * Nome do Bairro
   */
  @RFWMetaStringField(caption = "Nome do Bairro", minlength = 1, maxLength = 60, required = false)
  private String xbairro = null;

  /**
   * GR27 cMun E GR22 N 0-1 7<Br>
   * C�digo do Munic�pio do Contribuinte, conforme Tabela do IBGE
   */
  @RFWMetaStringField(caption = "C�digo do Munic�pio", minlength = 7, maxLength = 7, required = false)
  private String cmun = null;

  /**
   * GR28 xMun E GR22 C 0-1 1-60<Br>
   * Nome do munic�pio
   */
  @RFWMetaStringField(caption = "Nome do Munic�pio", minlength = 1, maxLength = 60, required = false)
  private String xmun = null;

  /**
   * GR29 CEP E GR22 N 0-1 7-8<Br>
   * C�digo do CEP
   */
  @RFWMetaStringField(caption = "CEP", minlength = 7, maxLength = 8, required = false)
  private String cep = null;

  /**
   * # gR23 xLgr E GR22 C 0-1 1-255<br>
   * Nome do Logradouro.
   *
   * @return # gR23 xLgr E GR22 C 0-1 1-255<br>
   *         Nome do Logradouro
   */
  public String getXlgr() {
    return xlgr;
  }

  /**
   * # gR23 xLgr E GR22 C 0-1 1-255<br>
   * Nome do Logradouro.
   *
   * @param xlgr # gR23 xLgr E GR22 C 0-1 1-255<br>
   *          Nome do Logradouro
   */
  public void setXlgr(String xlgr) {
    this.xlgr = xlgr;
  }

  /**
   * # gR24 Nro E GR22 C 0-1 1-60<br>
   * N�mero.
   *
   * @return # gR24 Nro E GR22 C 0-1 1-60<br>
   *         N�mero
   */
  public String getNro() {
    return nro;
  }

  /**
   * # gR24 Nro E GR22 C 0-1 1-60<br>
   * N�mero.
   *
   * @param nro # gR24 Nro E GR22 C 0-1 1-60<br>
   *          N�mero
   */
  public void setNro(String nro) {
    this.nro = nro;
  }

  /**
   * # gR25 xCpl E GR22 C 0-1 1-60<br>
   * Complemento.
   *
   * @return # gR25 xCpl E GR22 C 0-1 1-60<br>
   *         Complemento
   */
  public String getXcpl() {
    return xcpl;
  }

  /**
   * # gR25 xCpl E GR22 C 0-1 1-60<br>
   * Complemento.
   *
   * @param xcpl # gR25 xCpl E GR22 C 0-1 1-60<br>
   *          Complemento
   */
  public void setXcpl(String xcpl) {
    this.xcpl = xcpl;
  }

  /**
   * # gR26 xBairro E GR22 C 0-1 1-60<br>
   * Nome do Bairro.
   *
   * @return # gR26 xBairro E GR22 C 0-1 1-60<br>
   *         Nome do Bairro
   */
  public String getXbairro() {
    return xbairro;
  }

  /**
   * # gR26 xBairro E GR22 C 0-1 1-60<br>
   * Nome do Bairro.
   *
   * @param xbairro # gR26 xBairro E GR22 C 0-1 1-60<br>
   *          Nome do Bairro
   */
  public void setXbairro(String xbairro) {
    this.xbairro = xbairro;
  }

  /**
   * # gR27 cMun E GR22 N 0-1 7<Br>
   * C�digo do Munic�pio do Contribuinte, conforme Tabela do IBGE.
   *
   * @return # gR27 cMun E GR22 N 0-1 7<Br>
   *         C�digo do Munic�pio do Contribuinte, conforme Tabela do IBGE
   */
  public String getCmun() {
    return cmun;
  }

  /**
   * # gR27 cMun E GR22 N 0-1 7<Br>
   * C�digo do Munic�pio do Contribuinte, conforme Tabela do IBGE.
   *
   * @param cmun # gR27 cMun E GR22 N 0-1 7<Br>
   *          C�digo do Munic�pio do Contribuinte, conforme Tabela do IBGE
   */
  public void setCmun(String cmun) {
    this.cmun = cmun;
  }

  /**
   * # gR28 xMun E GR22 C 0-1 1-60<Br>
   * Nome do munic�pio.
   *
   * @return # gR28 xMun E GR22 C 0-1 1-60<Br>
   *         Nome do munic�pio
   */
  public String getXmun() {
    return xmun;
  }

  /**
   * # gR28 xMun E GR22 C 0-1 1-60<Br>
   * Nome do munic�pio.
   *
   * @param xmun # gR28 xMun E GR22 C 0-1 1-60<Br>
   *          Nome do munic�pio
   */
  public void setXmun(String xmun) {
    this.xmun = xmun;
  }

  /**
   * # gR29 CEP E GR22 N 0-1 7-8<Br>
   * C�digo do CEP.
   *
   * @return # gR29 CEP E GR22 N 0-1 7-8<Br>
   *         C�digo do CEP
   */
  public String getCep() {
    return cep;
  }

  /**
   * # gR29 CEP E GR22 N 0-1 7-8<Br>
   * C�digo do CEP.
   *
   * @param cep # gR29 CEP E GR22 N 0-1 7-8<Br>
   *          C�digo do CEP
   */
  public void setCep(String cep) {
    this.cep = cep;
  }

}
