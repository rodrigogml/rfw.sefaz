package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Classe que representa a tag <b>emit</b> (Identificação do emitente da NF-e) do XML da SEFAZ.
 * <p>
 * Grupo C01 — campos principais do emitente. O endereço (C05: {@code enderEmit}) é um subgrupo e não deve ser implementado aqui.
 * </p>
 *
 * <ul>
 * <li><b>C01 emit</b> — Grupo de identificação do emitente (ocorrência 1-1).</li>
 * <li><b>C02 CNPJ</b> — CNPJ do emitente (N, 14). Em NF-e avulsa, usar dados do remetente. Informar com zeros não significativos.</li>
 * <li><b>C02a CPF</b> — CPF do remetente (N, 11). Alternativo ao CNPJ em casos específicos previstos no MOC.</li>
 * <li><b>C03 xNome</b> — Razão Social ou Nome do emitente (C, 2–60).</li>
 * <li><b>C04 xFant</b> — Nome fantasia (C, 1–60) — opcional.</li>
 * <li><b>C17 IE</b> — Inscrição Estadual do Emitente (C, 2–14).</li>
 * <li><b>C18 IEST</b> — IE do Substituto Tributário (N, 2–14) — opcional.</li>
 * </ul>
 *
 * <p>
 * <b>Observações:</b> CNPJ/CPF são excludentes conforme o cenário fiscal; este VO não realiza validação cruzada entre eles.
 * </p>
 *
 * @author BIS DEVil
 * @since (11 de nov. de 2025)
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_emit")
public class EmitVO extends RFWVO {

  private static final long serialVersionUID = 4862178032097446409L;

  /**
   * ID: C02<br>
   * CNPJ do emitente (N, 14). Informar com zeros não significativos. Em emissão avulsa pelo Fisco, os dados do remetente são informados neste grupo. Ocorrência: 1-1.
   */
  @RFWMetaBigDecimalField(caption = "CNPJ", maxValue = "99999999999999", minValue = "0", scale = 0, required = false, absolute = true)
  private BigDecimal cnpj = null;

  /**
   * ID: C02a<br>
   * CPF do remetente (N, 11). Alternativo ao CNPJ em cenários específicos. Ocorrência: 1-1.
   */
  @RFWMetaBigDecimalField(caption = "CPF", maxValue = "99999999999", minValue = "0", scale = 0, required = false, absolute = true)
  private BigDecimal cpf = null;

  /**
   * ID: C03<br>
   * Razão Social ou Nome do emitente (C, 2–60). Ocorrência: 1-1.
   */
  @RFWMetaStringField(caption = "Razão Social / Nome", maxLength = 60, minlength = 2, required = false)
  private String xNome = null;

  /**
   * ID: C04<br>
   * Nome fantasia (C, 1–60). Ocorrência: 0-1.
   */
  @RFWMetaStringField(caption = "Nome Fantasia", maxLength = 60, minlength = 1, required = false)
  private String xFant = null;

  /**
   * ID: C17<br>
   * Inscrição Estadual do Emitente (C, 2–14). Ocorrência: 1-1.
   */
  @RFWMetaStringField(caption = "Inscrição Estadual", maxLength = 14, minlength = 2, required = false)
  private String ie = null;

  /**
   * ID: C18<br>
   * IE do Substituto Tributário (N, 2–14). Ocorrência: 0-1.
   */
  @RFWMetaBigDecimalField(caption = "IE do Substituto Tributário", maxValue = "99999999999999", minValue = "0", scale = 0, required = false, absolute = true)
  private BigDecimal iest = null;

  /**
   * # iD: C02<br>
   * CNPJ do emitente (N, 14). Informar com zeros não significativos. Em emissão avulsa pelo Fisco, os dados do remetente são informados neste grupo. Ocorrência: 1-1.
   *
   * @return the iD: C02<br>
   *         CNPJ do emitente (N, 14)
   */
  public BigDecimal getCnpj() {
    return cnpj;
  }

  /**
   * # iD: C02<br>
   * CNPJ do emitente (N, 14). Informar com zeros não significativos. Em emissão avulsa pelo Fisco, os dados do remetente são informados neste grupo. Ocorrência: 1-1.
   *
   * @param cnpj the new iD: C02<br>
   *          CNPJ do emitente (N, 14)
   */
  public void setCnpj(BigDecimal cnpj) {
    this.cnpj = cnpj;
  }

  /**
   * # iD: C02a<br>
   * CPF do remetente (N, 11). Alternativo ao CNPJ em cenários específicos. Ocorrência: 1-1.
   *
   * @return the iD: C02a<br>
   *         CPF do remetente (N, 11)
   */
  public BigDecimal getCpf() {
    return cpf;
  }

  /**
   * # iD: C02a<br>
   * CPF do remetente (N, 11). Alternativo ao CNPJ em cenários específicos. Ocorrência: 1-1.
   *
   * @param cpf the new iD: C02a<br>
   *          CPF do remetente (N, 11)
   */
  public void setCpf(BigDecimal cpf) {
    this.cpf = cpf;
  }

  /**
   * # iD: C03<br>
   * Razão Social ou Nome do emitente (C, 2–60). Ocorrência: 1-1.
   *
   * @return the iD: C03<br>
   *         Razão Social ou Nome do emitente (C, 2–60)
   */
  public String getXNome() {
    return xNome;
  }

  /**
   * # iD: C03<br>
   * Razão Social ou Nome do emitente (C, 2–60). Ocorrência: 1-1.
   *
   * @param xNome the new iD: C03<br>
   *          Razão Social ou Nome do emitente (C, 2–60)
   */
  public void setXNome(String xNome) {
    this.xNome = xNome;
  }

  /**
   * # iD: C04<br>
   * Nome fantasia (C, 1–60). Ocorrência: 0-1.
   *
   * @return the iD: C04<br>
   *         Nome fantasia (C, 1–60)
   */
  public String getXFant() {
    return xFant;
  }

  /**
   * # iD: C04<br>
   * Nome fantasia (C, 1–60). Ocorrência: 0-1.
   *
   * @param xFant the new iD: C04<br>
   *          Nome fantasia (C, 1–60)
   */
  public void setXFant(String xFant) {
    this.xFant = xFant;
  }

  /**
   * # iD: C17<br>
   * Inscrição Estadual do Emitente (C, 2–14). Ocorrência: 1-1.
   *
   * @return the iD: C17<br>
   *         Inscrição Estadual do Emitente (C, 2–14)
   */
  public String getIe() {
    return ie;
  }

  /**
   * # iD: C17<br>
   * Inscrição Estadual do Emitente (C, 2–14). Ocorrência: 1-1.
   *
   * @param ie the new iD: C17<br>
   *          Inscrição Estadual do Emitente (C, 2–14)
   */
  public void setIe(String ie) {
    this.ie = ie;
  }

  /**
   * # iD: C18<br>
   * IE do Substituto Tributário (N, 2–14). Ocorrência: 0-1.
   *
   * @return the iD: C18<br>
   *         IE do Substituto Tributário (N, 2–14)
   */
  public BigDecimal getIest() {
    return iest;
  }

  /**
   * # iD: C18<br>
   * IE do Substituto Tributário (N, 2–14). Ocorrência: 0-1.
   *
   * @param iest the new iD: C18<br>
   *          IE do Substituto Tributário (N, 2–14)
   */
  public void setIest(BigDecimal iest) {
    this.iest = iest;
  }

}
