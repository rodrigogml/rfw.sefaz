package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Tag: <b>enderEmit</b> — Endereço do emitente da NF-e (Grupo C05).<br>
 * Campos conforme MOC 4.0 (IDs C06..C16).
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_enderemit")
public class EnderEmitVO extends RFWVO {

  private static final long serialVersionUID = 1L;

  /**
   * ID: C06 — xLgr (C, 1-1, 2–60). Logradouro.
   */
  @RFWMetaStringField(caption = "Logradouro", maxLength = 60, minlength = 2, required = false)
  private String xLgr = null;

  /**
   * ID: C07 — nro (C, 1-1, 1–60). Número.
   */
  @RFWMetaStringField(caption = "Número", maxLength = 60, minlength = 1, required = false)
  private String nro = null;

  /**
   * ID: C08 — xCpl (C, 0-1, 1–60). Complemento.
   */
  @RFWMetaStringField(caption = "Complemento", maxLength = 60, minlength = 1, required = false)
  private String xCpl = null;

  /**
   * ID: C09 — xBairro (C, 1-1, 2–60). Bairro.
   */
  @RFWMetaStringField(caption = "Bairro", maxLength = 60, minlength = 2, required = false)
  private String xBairro = null;

  /**
   * ID: C10 — cMun (N, 1-1, 7). Código do município (IBGE).
   */
  @RFWMetaBigDecimalField(caption = "Código do município (IBGE)", minValue = "0", maxValue = "9999999", scale = 0, absolute = true, required = false)
  private BigDecimal cMun = null;

  /**
   * ID: C11 — xMun (C, 1-1, 2–60). Município.
   */
  @RFWMetaStringField(caption = "Município", maxLength = 60, minlength = 2, required = false)
  private String xMun = null;

  /**
   * ID: C12 — UF (C, 1-1, 2). Sigla da UF.
   */
  @RFWMetaStringField(caption = "UF", maxLength = 2, minlength = 2, required = false)
  private String UF = null;

  /**
   * ID: C13 — CEP (N, 0-1, 8). CEP (apenas dígitos; zeros não significativos).
   */
  @RFWMetaBigDecimalField(caption = "CEP", minValue = "0", maxValue = "99999999", scale = 0, absolute = true, required = false)
  private BigDecimal CEP = null;

  /**
   * ID: C14 — cPais (N, 0-1, 4). Código do país (ex.: 1058=Brasil).
   */
  @RFWMetaBigDecimalField(caption = "Código do país", minValue = "0", maxValue = "9999", scale = 0, absolute = true, required = false)
  private BigDecimal cPais = null;

  /**
   * ID: C15 — xPais (C, 0-1, 1–60). Nome do país (ex.: Brasil/BRASIL).
   */
  @RFWMetaStringField(caption = "País", maxLength = 60, minlength = 1, required = false)
  private String xPais = null;

  /**
   * ID: C16 — fone (N, 0-1, 6–14). Telefone (apenas dígitos; DDD+Número; com exterior pode incluir código do país e localidade).
   */
  @RFWMetaBigDecimalField(caption = "Telefone", minValue = "0", maxValue = "99999999999999", scale = 0, absolute = true, required = false)
  private BigDecimal fone = null;

  /**
   * # iD: C06 — xLgr (C, 1-1, 2–60). Logradouro.
   *
   * @return the iD: C06 — xLgr (C, 1-1, 2–60)
   */
  public String getXLgr() {
    return xLgr;
  }

  /**
   * # iD: C06 — xLgr (C, 1-1, 2–60). Logradouro.
   *
   * @param xLgr the new iD: C06 — xLgr (C, 1-1, 2–60)
   */
  public void setXLgr(String xLgr) {
    this.xLgr = xLgr;
  }

  /**
   * # iD: C07 — nro (C, 1-1, 1–60). Número.
   *
   * @return the iD: C07 — nro (C, 1-1, 1–60)
   */
  public String getNro() {
    return nro;
  }

  /**
   * # iD: C07 — nro (C, 1-1, 1–60). Número.
   *
   * @param nro the new iD: C07 — nro (C, 1-1, 1–60)
   */
  public void setNro(String nro) {
    this.nro = nro;
  }

  /**
   * # iD: C08 — xCpl (C, 0-1, 1–60). Complemento.
   *
   * @return the iD: C08 — xCpl (C, 0-1, 1–60)
   */
  public String getXCpl() {
    return xCpl;
  }

  /**
   * # iD: C08 — xCpl (C, 0-1, 1–60). Complemento.
   *
   * @param xCpl the new iD: C08 — xCpl (C, 0-1, 1–60)
   */
  public void setXCpl(String xCpl) {
    this.xCpl = xCpl;
  }

  /**
   * # iD: C09 — xBairro (C, 1-1, 2–60). Bairro.
   *
   * @return the iD: C09 — xBairro (C, 1-1, 2–60)
   */
  public String getXBairro() {
    return xBairro;
  }

  /**
   * # iD: C09 — xBairro (C, 1-1, 2–60). Bairro.
   *
   * @param xBairro the new iD: C09 — xBairro (C, 1-1, 2–60)
   */
  public void setXBairro(String xBairro) {
    this.xBairro = xBairro;
  }

  /**
   * # iD: C10 — cMun (N, 1-1, 7). Código do município (IBGE).
   *
   * @return the iD: C10 — cMun (N, 1-1, 7)
   */
  public BigDecimal getCMun() {
    return cMun;
  }

  /**
   * # iD: C10 — cMun (N, 1-1, 7). Código do município (IBGE).
   *
   * @param cMun the new iD: C10 — cMun (N, 1-1, 7)
   */
  public void setCMun(BigDecimal cMun) {
    this.cMun = cMun;
  }

  /**
   * # iD: C11 — xMun (C, 1-1, 2–60). Município.
   *
   * @return the iD: C11 — xMun (C, 1-1, 2–60)
   */
  public String getXMun() {
    return xMun;
  }

  /**
   * # iD: C11 — xMun (C, 1-1, 2–60). Município.
   *
   * @param xMun the new iD: C11 — xMun (C, 1-1, 2–60)
   */
  public void setXMun(String xMun) {
    this.xMun = xMun;
  }

  /**
   * Gets the uf.
   *
   * @return the uf
   */
  public String getUF() {
    return UF;
  }

  /**
   * Sets the uf.
   *
   * @param uF the new uf
   */
  public void setUF(String uF) {
    UF = uF;
  }

  /**
   * Gets the cep.
   *
   * @return the cep
   */
  public BigDecimal getCEP() {
    return CEP;
  }

  /**
   * Sets the cep.
   *
   * @param cEP the new cep
   */
  public void setCEP(BigDecimal cEP) {
    CEP = cEP;
  }

  /**
   * # iD: C14 — cPais (N, 0-1, 4). Código do país (ex.: 1058=Brasil).
   *
   * @return the iD: C14 — cPais (N, 0-1, 4)
   */
  public BigDecimal getCPais() {
    return cPais;
  }

  /**
   * # iD: C14 — cPais (N, 0-1, 4). Código do país (ex.: 1058=Brasil).
   *
   * @param cPais the new iD: C14 — cPais (N, 0-1, 4)
   */
  public void setCPais(BigDecimal cPais) {
    this.cPais = cPais;
  }

  /**
   * # iD: C15 — xPais (C, 0-1, 1–60). Nome do país (ex.: Brasil/BRASIL).
   *
   * @return the iD: C15 — xPais (C, 0-1, 1–60)
   */
  public String getXPais() {
    return xPais;
  }

  /**
   * # iD: C15 — xPais (C, 0-1, 1–60). Nome do país (ex.: Brasil/BRASIL).
   *
   * @param xPais the new iD: C15 — xPais (C, 0-1, 1–60)
   */
  public void setXPais(String xPais) {
    this.xPais = xPais;
  }

  /**
   * # iD: C16 — fone (N, 0-1, 6–14). Telefone (apenas dígitos; DDD+Número; com exterior pode incluir código do país e localidade).
   *
   * @return the iD: C16 — fone (N, 0-1, 6–14)
   */
  public BigDecimal getFone() {
    return fone;
  }

  /**
   * # iD: C16 — fone (N, 0-1, 6–14). Telefone (apenas dígitos; DDD+Número; com exterior pode incluir código do país e localidade).
   *
   * @param fone the new iD: C16 — fone (N, 0-1, 6–14)
   */
  public void setFone(BigDecimal fone) {
    this.fone = fone;
  }

}
