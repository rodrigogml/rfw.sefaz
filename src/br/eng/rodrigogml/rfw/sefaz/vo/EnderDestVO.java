package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Tag: <b>enderDest</b> — Endereço do Destinatário (Grupo E05).<br>
 * Campos E06..E16.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_enderdest")
public class EnderDestVO extends RFWVO {

  private static final long serialVersionUID = 1L;

  /** ID: E06 — xLgr (C, 2–60). Logradouro. */
  @RFWMetaStringField(caption = "Logradouro", maxLength = 60, minlength = 2, required = false)
  private String xLgr = null;

  /** ID: E07 — nro (C, 1–60). Número. */
  @RFWMetaStringField(caption = "Número", maxLength = 60, minlength = 1, required = false)
  private String nro = null;

  /** ID: E08 — xCpl (C, 0–1, 1–60). Complemento. */
  @RFWMetaStringField(caption = "Complemento", maxLength = 60, minlength = 1, required = false)
  private String xCpl = null;

  /** ID: E09 — xBairro (C, 2–60). Bairro. */
  @RFWMetaStringField(caption = "Bairro", maxLength = 60, minlength = 2, required = false)
  private String xBairro = null;

  /** ID: E10 — cMun (N, 7). Código do município (IBGE). */
  @RFWMetaBigDecimalField(caption = "Código do município (IBGE)", minValue = "0", maxValue = "9999999", scale = 0, absolute = true, required = false)
  private BigDecimal cMun = null;

  /** ID: E11 — xMun (C, 2–60). Nome do município (usar “EXTERIOR” para operações com o exterior). */
  @RFWMetaStringField(caption = "Município", maxLength = 60, minlength = 2, required = false)
  private String xMun = null;

  /** ID: E12 — UF (C, 2). Sigla da UF (usar “EX” para operações com o exterior). */
  @RFWMetaStringField(caption = "UF", maxLength = 2, minlength = 2, required = false)
  private String UF = null;

  /** ID: E13 — CEP (N, 8). Zeros não significativos. */
  @RFWMetaBigDecimalField(caption = "CEP", minValue = "0", maxValue = "99999999", scale = 0, absolute = true, required = false)
  private BigDecimal CEP = null;

  /** ID: E14 — cPais (N, 2–4). Código do país (BACEN). */
  @RFWMetaBigDecimalField(caption = "Código do país", minValue = "0", maxValue = "9999", scale = 0, absolute = true, required = false)
  private BigDecimal cPais = null;

  /** ID: E15 — xPais (C, 2–60). Nome do país. */
  @RFWMetaStringField(caption = "País", maxLength = 60, minlength = 2, required = false)
  private String xPais = null;

  /**
   * ID: E16 — fone (N, 6–14). DDD+telefone. Em operações com exterior pode conter código do país + código da localidade + número (sem formatação).
   */
  @RFWMetaBigDecimalField(caption = "Telefone", minValue = "0", maxValue = "99999999999999", scale = 0, absolute = true, required = false)
  private BigDecimal fone = null;

  /**
   * # iD: E06 — xLgr (C, 2–60). Logradouro.
   *
   * @return the iD: E06 — xLgr (C, 2–60)
   */
  public String getXLgr() {
    return xLgr;
  }

  /**
   * # iD: E06 — xLgr (C, 2–60). Logradouro.
   *
   * @param xLgr the new iD: E06 — xLgr (C, 2–60)
   */
  public void setXLgr(String xLgr) {
    this.xLgr = xLgr;
  }

  /**
   * # iD: E07 — nro (C, 1–60). Número.
   *
   * @return the iD: E07 — nro (C, 1–60)
   */
  public String getNro() {
    return nro;
  }

  /**
   * # iD: E07 — nro (C, 1–60). Número.
   *
   * @param nro the new iD: E07 — nro (C, 1–60)
   */
  public void setNro(String nro) {
    this.nro = nro;
  }

  /**
   * # iD: E08 — xCpl (C, 0–1, 1–60). Complemento.
   *
   * @return the iD: E08 — xCpl (C, 0–1, 1–60)
   */
  public String getXCpl() {
    return xCpl;
  }

  /**
   * # iD: E08 — xCpl (C, 0–1, 1–60). Complemento.
   *
   * @param xCpl the new iD: E08 — xCpl (C, 0–1, 1–60)
   */
  public void setXCpl(String xCpl) {
    this.xCpl = xCpl;
  }

  /**
   * # iD: E09 — xBairro (C, 2–60). Bairro.
   *
   * @return the iD: E09 — xBairro (C, 2–60)
   */
  public String getXBairro() {
    return xBairro;
  }

  /**
   * # iD: E09 — xBairro (C, 2–60). Bairro.
   *
   * @param xBairro the new iD: E09 — xBairro (C, 2–60)
   */
  public void setXBairro(String xBairro) {
    this.xBairro = xBairro;
  }

  /**
   * # iD: E10 — cMun (N, 7). Código do município (IBGE).
   *
   * @return the iD: E10 — cMun (N, 7)
   */
  public BigDecimal getCMun() {
    return cMun;
  }

  /**
   * # iD: E10 — cMun (N, 7). Código do município (IBGE).
   *
   * @param cMun the new iD: E10 — cMun (N, 7)
   */
  public void setCMun(BigDecimal cMun) {
    this.cMun = cMun;
  }

  /**
   * # iD: E11 — xMun (C, 2–60). Nome do município (usar “EXTERIOR” para operações com o exterior).
   *
   * @return the iD: E11 — xMun (C, 2–60)
   */
  public String getXMun() {
    return xMun;
  }

  /**
   * # iD: E11 — xMun (C, 2–60). Nome do município (usar “EXTERIOR” para operações com o exterior).
   *
   * @param xMun the new iD: E11 — xMun (C, 2–60)
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
   * # iD: E14 — cPais (N, 2–4). Código do país (BACEN).
   *
   * @return the iD: E14 — cPais (N, 2–4)
   */
  public BigDecimal getCPais() {
    return cPais;
  }

  /**
   * # iD: E14 — cPais (N, 2–4). Código do país (BACEN).
   *
   * @param cPais the new iD: E14 — cPais (N, 2–4)
   */
  public void setCPais(BigDecimal cPais) {
    this.cPais = cPais;
  }

  /**
   * # iD: E15 — xPais (C, 2–60). Nome do país.
   *
   * @return the iD: E15 — xPais (C, 2–60)
   */
  public String getXPais() {
    return xPais;
  }

  public void setXPais(String xPais) {
    this.xPais = xPais;
  }

  /**
   * # iD: E16 — fone (N, 6–14). DDD+telefone. Em operações com exterior pode conter código do país + código da localidade + número (sem formatação).
   *
   * @return the iD: E16 — fone (N, 6–14)
   */
  public BigDecimal getFone() {
    return fone;
  }

  /**
   * # iD: E16 — fone (N, 6–14). DDD+telefone. Em operações com exterior pode conter código do país + código da localidade + número (sem formatação).
   *
   * @param fone the new iD: E16 — fone (N, 6–14)
   */
  public void setFone(BigDecimal fone) {
    this.fone = fone;
  }

}
