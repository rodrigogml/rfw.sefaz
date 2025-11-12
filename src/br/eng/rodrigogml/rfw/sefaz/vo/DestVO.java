package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indIEDest;

/**
 * Tag: <b>dest</b> — Identificação do Destinatário da NF-e (Grupo E01).<br>
 * Campos principais (E02..E19). O subgrupo <b>enderDest</b> (E05) é modelado em VO próprio.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_dest")
public class DestVO extends RFWVO {

  private static final long serialVersionUID = 1L;

  /**
   * ID: E02 — CNPJ do destinatário (N, 14). Informar com zeros não significativos.
   */
  @RFWMetaBigDecimalField(caption = "CNPJ", maxValue = "99999999999999", minValue = "0", scale = 0, required = false, absolute = true)
  private BigDecimal CNPJ = null;

  /**
   * ID: E03 — CPF do destinatário (N, 11). Alternativo ao CNPJ.
   */
  @RFWMetaBigDecimalField(caption = "CPF", maxValue = "99999999999", minValue = "0", scale = 0, required = false, absolute = true)
  private BigDecimal CPF = null;

  /**
   * ID: E03a — idEstrangeiro (C, até 20). Número de passaporte ou documento válido para comprador estrangeiro. Aceita algarismos, letras (maiúsculas/minúsculas) e os caracteres [: . + - / ( )].
   */
  @RFWMetaStringField(caption = "Documento estrangeiro", maxLength = 20, minlength = 0, required = false, pattern = "[A-Za-z0-9:\\.\\+\\-/\\(\\)]{0,20}")
  private String idEstrangeiro = null;

  /**
   * ID: E04 — Razão Social ou nome do destinatário (C, 2–60). Obrigatório para NF-e (modelo 55) e opcional para NFC-e.
   */
  @RFWMetaStringField(caption = "Nome/Razão Social", maxLength = 60, minlength = 2, required = false)
  private String xNome = null;

  /**
   * ID: E16a — Indicador da IE do Destinatário (N, 1). 1=Contribuinte; 2=Isento; 9=Não contribuinte.
   */
  @RFWMetaEnumField(caption = "Indicador IE", required = false)
  private SEFAZ_indIEDest indIEDest = null;

  /**
   * ID: E17 — IE do destinatário (C, 2–14). Não informar quando indIEDest=2 ou 9.
   */
  @RFWMetaStringField(caption = "Inscrição Estadual", maxLength = 14, minlength = 2, required = false)
  private String IE = null;

  /**
   * ID: E18 — ISUF (N, 8–9). Obrigatório quando houver benefícios fiscais nas áreas da SUFRAMA.
   */
  @RFWMetaBigDecimalField(caption = "Inscrição SUFRAMA", maxValue = "999999999", minValue = "0", scale = 0, required = false, absolute = true)
  private BigDecimal ISUF = null;

  /**
   * ID: E18a — IM (C, 1–15). Inscrição Municipal do Tomador do Serviço (NF-e conjugada).
   */
  @RFWMetaStringField(caption = "Inscrição Municipal", maxLength = 15, minlength = 1, required = false)
  private String IM = null;

  /**
   * ID: E19 — email (C, 1–60). E-mail de recepção da NF-e informado pelo destinatário (v2.0).
   */
  @RFWMetaStringField(caption = "E-mail", maxLength = 60, minlength = 1, required = false)
  private String email = null;

  /**
   * Gets the cnpj.
   *
   * @return the cnpj
   */
  public BigDecimal getCNPJ() {
    return CNPJ;
  }

  /**
   * Sets the cnpj.
   *
   * @param cNPJ the new cnpj
   */
  public void setCNPJ(BigDecimal cNPJ) {
    CNPJ = cNPJ;
  }

  /**
   * Gets the cpf.
   *
   * @return the cpf
   */
  public BigDecimal getCPF() {
    return CPF;
  }

  /**
   * Sets the cpf.
   *
   * @param cPF the new cpf
   */
  public void setCPF(BigDecimal cPF) {
    CPF = cPF;
  }

  /**
   * # iD: E03a — idEstrangeiro (C, até 20). Número de passaporte ou documento válido para comprador estrangeiro. Aceita algarismos, letras (maiúsculas/minúsculas) e os caracteres [: . + - / ( )].
   *
   * @return the iD: E03a — idEstrangeiro (C, até 20)
   */
  public String getIdEstrangeiro() {
    return idEstrangeiro;
  }

  /**
   * # iD: E03a — idEstrangeiro (C, até 20). Número de passaporte ou documento válido para comprador estrangeiro. Aceita algarismos, letras (maiúsculas/minúsculas) e os caracteres [: . + - / ( )].
   *
   * @param idEstrangeiro the new iD: E03a — idEstrangeiro (C, até 20)
   */
  public void setIdEstrangeiro(String idEstrangeiro) {
    this.idEstrangeiro = idEstrangeiro;
  }

  /**
   * # iD: E04 — Razão Social ou nome do destinatário (C, 2–60). Obrigatório para NF-e (modelo 55) e opcional para NFC-e.
   *
   * @return the iD: E04 — Razão Social ou nome do destinatário (C, 2–60)
   */
  public String getXNome() {
    return xNome;
  }

  /**
   * # iD: E04 — Razão Social ou nome do destinatário (C, 2–60). Obrigatório para NF-e (modelo 55) e opcional para NFC-e.
   *
   * @param xNome the new iD: E04 — Razão Social ou nome do destinatário (C, 2–60)
   */
  public void setXNome(String xNome) {
    this.xNome = xNome;
  }

  /**
   * # iD: E16a — Indicador da IE do Destinatário (N, 1). 1=Contribuinte; 2=Isento; 9=Não contribuinte.
   *
   * @return the iD: E16a — Indicador da IE do Destinatário (N, 1)
   */
  public SEFAZ_indIEDest getIndIEDest() {
    return indIEDest;
  }

  /**
   * # iD: E16a — Indicador da IE do Destinatário (N, 1). 1=Contribuinte; 2=Isento; 9=Não contribuinte.
   *
   * @param indIEDest the new iD: E16a — Indicador da IE do Destinatário (N, 1)
   */
  public void setIndIEDest(SEFAZ_indIEDest indIEDest) {
    this.indIEDest = indIEDest;
  }

  /**
   * Gets the ie.
   *
   * @return the ie
   */
  public String getIE() {
    return IE;
  }

  /**
   * Sets the ie.
   *
   * @param iE the new ie
   */
  public void setIE(String iE) {
    IE = iE;
  }

  /**
   * Gets the isuf.
   *
   * @return the isuf
   */
  public BigDecimal getISUF() {
    return ISUF;
  }

  /**
   * Sets the isuf.
   *
   * @param iSUF the new isuf
   */
  public void setISUF(BigDecimal iSUF) {
    ISUF = iSUF;
  }

  /**
   * Gets the im.
   *
   * @return the im
   */
  public String getIM() {
    return IM;
  }

  /**
   * Sets the im.
   *
   * @param iM the new im
   */
  public void setIM(String iM) {
    IM = iM;
  }

  /**
   * # iD: E19 — email (C, 1–60). E-mail de recepção da NF-e informado pelo destinatário (v2.0).
   *
   * @return the iD: E19 — email (C, 1–60)
   */
  public String getEmail() {
    return email;
  }

  /**
   * # iD: E19 — email (C, 1–60). E-mail de recepção da NF-e informado pelo destinatário (v2.0).
   *
   * @param email the new iD: E19 — email (C, 1–60)
   */
  public void setEmail(String email) {
    this.email = email;
  }

}
