package br.eng.rodrigogml.rfw.sefaz.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CST_ICMS;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_modBC;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_modBCST;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_orig;

/**
 * Grupo N10a - ICMSPart.
 *
 * Grupo de Partilha do ICMS entre a UF de origem e a UF de destino ou a UF definida na legislação (tag ICMSPart / N10a).
 *
 * Operação interestadual para consumidor final com partilha do ICMS devido na operação entre a UF de origem e a do destinatário, ou a UF definida na legislação (ex.: UF da concessionária de entrega do veículo).
 *
 * Observação: nas annotations o atributo {@code required} é sempre definido como false conforme solicitado, mesmo que o MOC defina obrigatoriedade.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_icmspart")
public class ICMSPartVO extends RFWVO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * Relação com o ICMS da operação (tag ICMS / N01).
   */
  @RFWMetaRelationshipField(caption = "ICMS", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_icms")
  private ICMSVO icmsVO = null;

  /**
   * N11 - orig. Origem da mercadoria. Ocor.: 1–1 / Tam.: 1 / Tipo: N. Ver valores em {@link SEFAZ_orig}. <br>
   * Utilizada no contexto de operações interestaduais para consumidor final com partilha do ICMS entre a UF de origem e a UF de destino (ou UF definida na legislação).
   */
  @RFWMetaEnumField(caption = "Origem da mercadoria", required = false)
  private SEFAZ_orig orig;

  /**
   * N12 - CST. Tributação do ICMS. Ocor.: 1–1 / Tam.: 2 / Tipo: N. <br>
   * Valores permitidos para ICMSPart: <br>
   * 10 – Tributada e com cobrança do ICMS por substituição tributária; <br>
   * 90 – Outros. <br>
   * Mapeado para {@link SEFAZ_CST_ICMS}.
   */
  @RFWMetaEnumField(caption = "CST do ICMS (partilha)", required = false)
  private SEFAZ_CST_ICMS cst;

  /**
   * N13 - modBC. Modalidade de determinação da BC do ICMS. Ocor.: 1–1 / Tam.: 1 / Tipo: N. <br>
   * 0 = Margem Valor Agregado (%); <br>
   * 1 = Pauta (Valor); <br>
   * 2 = Preço Tabelado Máx. (valor); <br>
   * 3 = Valor da operação. <br>
   * Mapeado para {@link SEFAZ_modBC}.
   */
  @RFWMetaEnumField(caption = "Modalidade de determinação da BC do ICMS", required = false)
  private SEFAZ_modBC modBC;

  /**
   * N15 - vBC. Valor da base de cálculo do ICMS. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. (v2.0) <br>
   * Base de cálculo do ICMS próprio utilizada para a partilha entre as UFs.
   */
  @RFWMetaBigDecimalField(caption = "Valor da BC do ICMS (partilha)", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vbc;

  /**
   * N14 - pRedBC. Percentual da redução da base de cálculo do ICMS. Ocor.: 0–1 / Tam.: 3v2–4 / Tipo: N. (v2.0) <br>
   * Percentual utilizado para redução da BC do ICMS próprio antes da partilha.
   */
  @RFWMetaBigDecimalField(caption = "Percentual de redução da BC do ICMS (partilha)", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal predBC;

  /**
   * N16 - pICMS. Alíquota do imposto ICMS. Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. (v2.0) <br>
   * Alíquota do ICMS próprio utilizada para cálculo do ICMS devido na operação objeto de partilha (sem considerar FCP; quando houver FCP, utilizar campos específicos).
   */
  @RFWMetaBigDecimalField(caption = "Alíquota do ICMS (partilha)", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal picms;

  /**
   * N17 - vICMS. Valor do ICMS. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. (v2.0) <br>
   * Valor do ICMS próprio calculado sobre vBC com a alíquota pICMS, referente à operação na qual haverá partilha do ICMS entre as UFs.
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS (partilha)", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vicms;

  /**
   * N18 - modBCST. Modalidade de determinação da BC do ICMS ST. Ocor.: 1–1 / Tam.: 1 / Tipo: N. <br>
   * 0 = Preço tabelado ou máximo sugerido; <br>
   * 1 = Lista Negativa (valor); <br>
   * 2 = Lista Positiva (valor); <br>
   * 3 = Lista Neutra (valor); <br>
   * 4 = Margem Valor Agregado (%); <br>
   * 5 = Pauta (valor). <br>
   * Mapeado para {@link SEFAZ_modBCST}.
   */
  @RFWMetaEnumField(caption = "Modalidade de determinação da BC do ICMS ST (partilha)", required = false)
  private SEFAZ_modBCST modBCST;

  /**
   * N19 - pMVAST. Percentual da margem de valor adicionado do ICMS ST. Ocor.: 0–1 / Tam.: 3v2–4 / Tipo: N. (v2.0) <br>
   * Percentual de MVA utilizado na formação da base de cálculo do ICMS ST no contexto da partilha.
   */
  @RFWMetaBigDecimalField(caption = "Percentual da MVA do ICMS ST (partilha)", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal pmvaST;

  /**
   * N20 - pRedBCST. Percentual da redução da base de cálculo do ICMS ST. Ocor.: 0–1 / Tam.: 3v2–4 / Tipo: N. (v2.0) <br>
   * Percentual utilizado para reduzir a BC do ICMS ST no cálculo da partilha.
   */
  @RFWMetaBigDecimalField(caption = "Percentual de redução da BC do ICMS ST (partilha)", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal predBCST;

  /**
   * N21 - vBCST. Valor da base de cálculo do ICMS ST. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. (v2.0) <br>
   * Base de cálculo do ICMS ST utilizada para apuração do valor do ICMS ST devido na operação com partilha.
   */
  @RFWMetaBigDecimalField(caption = "Valor da BC do ICMS ST (partilha)", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vbcST;

  /**
   * N22 - pICMSST. Alíquota do imposto do ICMS ST. Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. (v2.0) <br>
   * Alíquota do ICMS ST utilizada para cálculo do ICMS ST devido na operação objeto de partilha.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota do ICMS ST (partilha)", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal picmsST;

  /**
   * N23 - vICMSST. Valor do ICMS ST. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. (v2.0) <br>
   * Valor do ICMS ST calculado sobre vBCST com a alíquota pICMSST, referente à operação com partilha do ICMS entre as UFs.
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS ST (partilha)", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vicmsST;

  /**
   * N25 - pBCOp. Percentual da BC operação própria. Ocor.: 0–1 / Tam.: 3v2–4 / Tipo: N. (v2.0) <br>
   * Percentual utilizado para determinação do valor da base de cálculo da operação própria na partilha do ICMS.
   */
  @RFWMetaBigDecimalField(caption = "Percentual da BC da operação própria (partilha)", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal pbcOp;

  /**
   * N24 - UFST. UF para qual é devido o ICMS ST. Ocor.: 1–1 / Tam.: 2 / Tipo: C. (v2.0) <br>
   * Sigla da UF para qual é devido o ICMS ST da operação. Informar "EX" para Exterior. <br>
   * Exemplos: "SP", "RJ", "MG", "EX".
   */
  @RFWMetaStringField(caption = "UF de destino do ICMS ST (partilha)", required = false, unique = false, maxLength = 2, minLength = 2, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String ufST;

  /**
   * # relação com o ICMS da operação (tag ICMS / N01).
   *
   * @return the relação com o ICMS da operação (tag ICMS / N01)
   */
  public ICMSVO getIcmsVO() {
    return icmsVO;
  }

  /**
   * # relação com o ICMS da operação (tag ICMS / N01).
   *
   * @param icmsVO the new relação com o ICMS da operação (tag ICMS / N01)
   */
  public void setIcmsVO(ICMSVO icmsVO) {
    this.icmsVO = icmsVO;
  }

  /**
   * # n11 - orig. Origem da mercadoria. Ocor.: 1–1 / Tam.: 1 / Tipo: N. Ver valores em {@link SEFAZ_orig}. <br>
   * Utilizada no contexto de operações interestaduais para consumidor final com partilha do ICMS entre a UF de origem e a UF de destino (ou UF definida na legislação).
   *
   * @return the n11 - orig
   */
  public SEFAZ_orig getOrig() {
    return orig;
  }

  /**
   * # n11 - orig. Origem da mercadoria. Ocor.: 1–1 / Tam.: 1 / Tipo: N. Ver valores em {@link SEFAZ_orig}. <br>
   * Utilizada no contexto de operações interestaduais para consumidor final com partilha do ICMS entre a UF de origem e a UF de destino (ou UF definida na legislação).
   *
   * @param orig the new n11 - orig
   */
  public void setOrig(SEFAZ_orig orig) {
    this.orig = orig;
  }

  /**
   * # n12 - CST. Tributação do ICMS. Ocor.: 1–1 / Tam.: 2 / Tipo: N. <br>
   * Valores permitidos para ICMSPart: <br>
   * 10 – Tributada e com cobrança do ICMS por substituição tributária; <br>
   * 90 – Outros. <br>
   * Mapeado para {@link SEFAZ_CST_ICMS}.
   *
   * @return the n12 - CST
   */
  public SEFAZ_CST_ICMS getCst() {
    return cst;
  }

  /**
   * # n12 - CST. Tributação do ICMS. Ocor.: 1–1 / Tam.: 2 / Tipo: N. <br>
   * Valores permitidos para ICMSPart: <br>
   * 10 – Tributada e com cobrança do ICMS por substituição tributária; <br>
   * 90 – Outros. <br>
   * Mapeado para {@link SEFAZ_CST_ICMS}.
   *
   * @param cst the new n12 - CST
   */
  public void setCst(SEFAZ_CST_ICMS cst) {
    this.cst = cst;
  }

  /**
   * # n13 - modBC. Modalidade de determinação da BC do ICMS. Ocor.: 1–1 / Tam.: 1 / Tipo: N. <br>
   * 0 = Margem Valor Agregado (%); <br>
   * 1 = Pauta (Valor); <br>
   * 2 = Preço Tabelado Máx. (valor); <br>
   * 3 = Valor da operação. <br>
   * Mapeado para {@link SEFAZ_modBC}.
   *
   * @return the n13 - modBC
   */
  public SEFAZ_modBC getModBC() {
    return modBC;
  }

  /**
   * # n13 - modBC. Modalidade de determinação da BC do ICMS. Ocor.: 1–1 / Tam.: 1 / Tipo: N. <br>
   * 0 = Margem Valor Agregado (%); <br>
   * 1 = Pauta (Valor); <br>
   * 2 = Preço Tabelado Máx. (valor); <br>
   * 3 = Valor da operação. <br>
   * Mapeado para {@link SEFAZ_modBC}.
   *
   * @param modBC the new n13 - modBC
   */
  public void setModBC(SEFAZ_modBC modBC) {
    this.modBC = modBC;
  }

  /**
   * # n15 - vBC. Valor da base de cálculo do ICMS. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. (v2.0) <br>
   * Base de cálculo do ICMS próprio utilizada para a partilha entre as UFs.
   *
   * @return the n15 - vBC
   */
  public BigDecimal getVbc() {
    return vbc;
  }

  /**
   * # n15 - vBC. Valor da base de cálculo do ICMS. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. (v2.0) <br>
   * Base de cálculo do ICMS próprio utilizada para a partilha entre as UFs.
   *
   * @param vbc the new n15 - vBC
   */
  public void setVbc(BigDecimal vbc) {
    this.vbc = vbc;
  }

  /**
   * # n14 - pRedBC. Percentual da redução da base de cálculo do ICMS. Ocor.: 0–1 / Tam.: 3v2–4 / Tipo: N. (v2.0) <br>
   * Percentual utilizado para redução da BC do ICMS próprio antes da partilha.
   *
   * @return the n14 - pRedBC
   */
  public BigDecimal getPredBC() {
    return predBC;
  }

  /**
   * # n14 - pRedBC. Percentual da redução da base de cálculo do ICMS. Ocor.: 0–1 / Tam.: 3v2–4 / Tipo: N. (v2.0) <br>
   * Percentual utilizado para redução da BC do ICMS próprio antes da partilha.
   *
   * @param predBC the new n14 - pRedBC
   */
  public void setPredBC(BigDecimal predBC) {
    this.predBC = predBC;
  }

  /**
   * # n16 - pICMS. Alíquota do imposto ICMS. Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. (v2.0) <br>
   * Alíquota do ICMS próprio utilizada para cálculo do ICMS devido na operação objeto de partilha (sem considerar FCP; quando houver FCP, utilizar campos específicos).
   *
   * @return the n16 - pICMS
   */
  public BigDecimal getPicms() {
    return picms;
  }

  /**
   * # n16 - pICMS. Alíquota do imposto ICMS. Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. (v2.0) <br>
   * Alíquota do ICMS próprio utilizada para cálculo do ICMS devido na operação objeto de partilha (sem considerar FCP; quando houver FCP, utilizar campos específicos).
   *
   * @param picms the new n16 - pICMS
   */
  public void setPicms(BigDecimal picms) {
    this.picms = picms;
  }

  /**
   * # n17 - vICMS. Valor do ICMS. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. (v2.0) <br>
   * Valor do ICMS próprio calculado sobre vBC com a alíquota pICMS, referente à operação na qual haverá partilha do ICMS entre as UFs.
   *
   * @return the n17 - vICMS
   */
  public BigDecimal getVicms() {
    return vicms;
  }

  /**
   * # n17 - vICMS. Valor do ICMS. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. (v2.0) <br>
   * Valor do ICMS próprio calculado sobre vBC com a alíquota pICMS, referente à operação na qual haverá partilha do ICMS entre as UFs.
   *
   * @param vicms the new n17 - vICMS
   */
  public void setVicms(BigDecimal vicms) {
    this.vicms = vicms;
  }

  /**
   * # n18 - modBCST. Modalidade de determinação da BC do ICMS ST. Ocor.: 1–1 / Tam.: 1 / Tipo: N. <br>
   * 0 = Preço tabelado ou máximo sugerido; <br>
   * 1 = Lista Negativa (valor); <br>
   * 2 = Lista Positiva (valor); <br>
   * 3 = Lista Neutra (valor); <br>
   * 4 = Margem Valor Agregado (%); <br>
   * 5 = Pauta (valor). <br>
   * Mapeado para {@link SEFAZ_modBCST}.
   *
   * @return the n18 - modBCST
   */
  public SEFAZ_modBCST getModBCST() {
    return modBCST;
  }

  /**
   * # n18 - modBCST. Modalidade de determinação da BC do ICMS ST. Ocor.: 1–1 / Tam.: 1 / Tipo: N. <br>
   * 0 = Preço tabelado ou máximo sugerido; <br>
   * 1 = Lista Negativa (valor); <br>
   * 2 = Lista Positiva (valor); <br>
   * 3 = Lista Neutra (valor); <br>
   * 4 = Margem Valor Agregado (%); <br>
   * 5 = Pauta (valor). <br>
   * Mapeado para {@link SEFAZ_modBCST}.
   *
   * @param modBCST the new n18 - modBCST
   */
  public void setModBCST(SEFAZ_modBCST modBCST) {
    this.modBCST = modBCST;
  }

  /**
   * # n19 - pMVAST. Percentual da margem de valor adicionado do ICMS ST. Ocor.: 0–1 / Tam.: 3v2–4 / Tipo: N. (v2.0) <br>
   * Percentual de MVA utilizado na formação da base de cálculo do ICMS ST no contexto da partilha.
   *
   * @return the n19 - pMVAST
   */
  public BigDecimal getPmvaST() {
    return pmvaST;
  }

  /**
   * # n19 - pMVAST. Percentual da margem de valor adicionado do ICMS ST. Ocor.: 0–1 / Tam.: 3v2–4 / Tipo: N. (v2.0) <br>
   * Percentual de MVA utilizado na formação da base de cálculo do ICMS ST no contexto da partilha.
   *
   * @param pmvaST the new n19 - pMVAST
   */
  public void setPmvaST(BigDecimal pmvaST) {
    this.pmvaST = pmvaST;
  }

  /**
   * # n20 - pRedBCST. Percentual da redução da base de cálculo do ICMS ST. Ocor.: 0–1 / Tam.: 3v2–4 / Tipo: N. (v2.0) <br>
   * Percentual utilizado para reduzir a BC do ICMS ST no cálculo da partilha.
   *
   * @return the n20 - pRedBCST
   */
  public BigDecimal getPredBCST() {
    return predBCST;
  }

  /**
   * # n20 - pRedBCST. Percentual da redução da base de cálculo do ICMS ST. Ocor.: 0–1 / Tam.: 3v2–4 / Tipo: N. (v2.0) <br>
   * Percentual utilizado para reduzir a BC do ICMS ST no cálculo da partilha.
   *
   * @param predBCST the new n20 - pRedBCST
   */
  public void setPredBCST(BigDecimal predBCST) {
    this.predBCST = predBCST;
  }

  /**
   * # n21 - vBCST. Valor da base de cálculo do ICMS ST. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. (v2.0) <br>
   * Base de cálculo do ICMS ST utilizada para apuração do valor do ICMS ST devido na operação com partilha.
   *
   * @return the n21 - vBCST
   */
  public BigDecimal getVbcST() {
    return vbcST;
  }

  /**
   * # n21 - vBCST. Valor da base de cálculo do ICMS ST. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. (v2.0) <br>
   * Base de cálculo do ICMS ST utilizada para apuração do valor do ICMS ST devido na operação com partilha.
   *
   * @param vbcST the new n21 - vBCST
   */
  public void setVbcST(BigDecimal vbcST) {
    this.vbcST = vbcST;
  }

  /**
   * # n22 - pICMSST. Alíquota do imposto do ICMS ST. Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. (v2.0) <br>
   * Alíquota do ICMS ST utilizada para cálculo do ICMS ST devido na operação objeto de partilha.
   *
   * @return the n22 - pICMSST
   */
  public BigDecimal getPicmsST() {
    return picmsST;
  }

  /**
   * # n22 - pICMSST. Alíquota do imposto do ICMS ST. Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. (v2.0) <br>
   * Alíquota do ICMS ST utilizada para cálculo do ICMS ST devido na operação objeto de partilha.
   *
   * @param picmsST the new n22 - pICMSST
   */
  public void setPicmsST(BigDecimal picmsST) {
    this.picmsST = picmsST;
  }

  /**
   * # n23 - vICMSST. Valor do ICMS ST. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. (v2.0) <br>
   * Valor do ICMS ST calculado sobre vBCST com a alíquota pICMSST, referente à operação com partilha do ICMS entre as UFs.
   *
   * @return the n23 - vICMSST
   */
  public BigDecimal getVicmsST() {
    return vicmsST;
  }

  /**
   * # n23 - vICMSST. Valor do ICMS ST. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. (v2.0) <br>
   * Valor do ICMS ST calculado sobre vBCST com a alíquota pICMSST, referente à operação com partilha do ICMS entre as UFs.
   *
   * @param vicmsST the new n23 - vICMSST
   */
  public void setVicmsST(BigDecimal vicmsST) {
    this.vicmsST = vicmsST;
  }

  /**
   * # n25 - pBCOp. Percentual da BC operação própria. Ocor.: 0–1 / Tam.: 3v2–4 / Tipo: N. (v2.0) <br>
   * Percentual utilizado para determinação do valor da base de cálculo da operação própria na partilha do ICMS.
   *
   * @return the n25 - pBCOp
   */
  public BigDecimal getPbcOp() {
    return pbcOp;
  }

  /**
   * # n25 - pBCOp. Percentual da BC operação própria. Ocor.: 0–1 / Tam.: 3v2–4 / Tipo: N. (v2.0) <br>
   * Percentual utilizado para determinação do valor da base de cálculo da operação própria na partilha do ICMS.
   *
   * @param pbcOp the new n25 - pBCOp
   */
  public void setPbcOp(BigDecimal pbcOp) {
    this.pbcOp = pbcOp;
  }

  /**
   * # n24 - UFST. UF para qual é devido o ICMS ST. Ocor.: 1–1 / Tam.: 2 / Tipo: C. (v2.0) <br>
   * Sigla da UF para qual é devido o ICMS ST da operação. Informar "EX" para Exterior. <br>
   * Exemplos: "SP", "RJ", "MG", "EX".
   *
   * @return the n24 - UFST
   */
  public String getUfST() {
    return ufST;
  }

  /**
   * # n24 - UFST. UF para qual é devido o ICMS ST. Ocor.: 1–1 / Tam.: 2 / Tipo: C. (v2.0) <br>
   * Sigla da UF para qual é devido o ICMS ST da operação. Informar "EX" para Exterior. <br>
   * Exemplos: "SP", "RJ", "MG", "EX".
   *
   * @param ufST the new n24 - UFST
   */
  public void setUfST(String ufST) {
    this.ufST = ufST;
  }

}
