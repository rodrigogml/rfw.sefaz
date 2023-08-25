package br.eng.rodrigogml.rfw.sefaz.vos;

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
   * Número
   */
  @RFWMetaStringField(caption = "Número", minlength = 1, maxLength = 60, required = false)
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
   * Código do Município do Contribuinte, conforme Tabela do IBGE
   */
  @RFWMetaStringField(caption = "Código do Município", minlength = 7, maxLength = 7, required = false)
  private String cmun = null;

  /**
   * GR28 xMun E GR22 C 0-1 1-60<Br>
   * Nome do município
   */
  @RFWMetaStringField(caption = "Nome do Município", minlength = 1, maxLength = 60, required = false)
  private String xmun = null;

  /**
   * GR29 CEP E GR22 N 0-1 7-8<Br>
   * Código do CEP
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
   * Número.
   *
   * @return # gR24 Nro E GR22 C 0-1 1-60<br>
   *         Número
   */
  public String getNro() {
    return nro;
  }

  /**
   * # gR24 Nro E GR22 C 0-1 1-60<br>
   * Número.
   *
   * @param nro # gR24 Nro E GR22 C 0-1 1-60<br>
   *          Número
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
   * Código do Município do Contribuinte, conforme Tabela do IBGE.
   *
   * @return # gR27 cMun E GR22 N 0-1 7<Br>
   *         Código do Município do Contribuinte, conforme Tabela do IBGE
   */
  public String getCmun() {
    return cmun;
  }

  /**
   * # gR27 cMun E GR22 N 0-1 7<Br>
   * Código do Município do Contribuinte, conforme Tabela do IBGE.
   *
   * @param cmun # gR27 cMun E GR22 N 0-1 7<Br>
   *          Código do Município do Contribuinte, conforme Tabela do IBGE
   */
  public void setCmun(String cmun) {
    this.cmun = cmun;
  }

  /**
   * # gR28 xMun E GR22 C 0-1 1-60<Br>
   * Nome do município.
   *
   * @return # gR28 xMun E GR22 C 0-1 1-60<Br>
   *         Nome do município
   */
  public String getXmun() {
    return xmun;
  }

  /**
   * # gR28 xMun E GR22 C 0-1 1-60<Br>
   * Nome do município.
   *
   * @param xmun # gR28 xMun E GR22 C 0-1 1-60<Br>
   *          Nome do município
   */
  public void setXmun(String xmun) {
    this.xmun = xmun;
  }

  /**
   * # gR29 CEP E GR22 N 0-1 7-8<Br>
   * Código do CEP.
   *
   * @return # gR29 CEP E GR22 N 0-1 7-8<Br>
   *         Código do CEP
   */
  public String getCep() {
    return cep;
  }

  /**
   * # gR29 CEP E GR22 N 0-1 7-8<Br>
   * Código do CEP.
   *
   * @param cep # gR29 CEP E GR22 N 0-1 7-8<Br>
   *          Código do CEP
   */
  public void setCep(String cep) {
    this.cep = cep;
  }

}
