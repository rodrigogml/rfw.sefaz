package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCNPJField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CST_IPI;

/**
 * Grupo O01 - IPI (Grupo IPI).
 * <p>
 * Ocorre 0-1 dentro do grupo M01 (imposto do item). Deve ser informado apenas quando o item for sujeito ao IPI.
 * <p>
 * Estrutura principal do IPI no item da NF-e, contemplando os dados gerais de enquadramento (cEnq), identificação do produtor (CNPJProd), selo de controle (cSelo/qSelo) e os campos de tributação/cálculo do imposto (CST, vBC, pIPI, qUnid, vUnid, vIPI).
 * <p>
 * Observação: apenas um dos cenários de cálculo é utilizado por item:
 * <ul>
 * <li>Cálculo por alíquota: uso de vBC (O10) e pIPI (O13);</li>
 * <li>Cálculo por valor por unidade: uso de qUnid (O11) e vUnid (O12).</li>
 * </ul>
 * O CST do IPI (campo CST – O09/O09b) determina se a tributação será feita pelo grupo "IPITrib" (CST 00, 49, 50, 99) ou "IPINT" (CST 01, 02, 03, 04, 05, 51, 52, 53, 54, 55).
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_ipi")
public class SEFAZIPIVO extends RFWVO {

  private static final long serialVersionUID = 5182194075322257638L;

  /**
   * {@link SEFAZImpostoVO}
   */
  @RFWMetaRelationshipField(caption = "Imposto", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_imposto")
  private SEFAZImpostoVO impostoVO = null;

  /**
   * O02 - Classe de enquadramento do IPI (cIEnq). Tipo: C, Tamanho: 1-5, Ocorrência: 0-1 (campo opcional na estrutura).
   * <p>
   * Observação: campo excluído no leiaute 4.0 – NT2016.002, mantido aqui apenas para compatibilidade com versões anteriores.
   */
  @RFWMetaStringField(caption = "cIEnq", required = false, unique = false, maxLength = 5, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String ciEnq;

  /**
   * O03 - CNPJ do produtor da mercadoria (CNPJProd), quando diferente do emitente. Tipo: N, Tamanho: 14, Ocorrência: 0-1 (campo opcional na estrutura).
   * <p>
   * Utilizado somente para os casos de exportação direta ou indireta. Devem ser informados os zeros não significativos.
   */
  @RFWMetaStringCNPJField(caption = "CNPJProd", required = false, unique = false)
  private String cnpjProd;

  /**
   * O04 - Código do selo de controle IPI (cSelo). Tipo: C, Tamanho: 1–60, Ocorrência: 0-1 (campo opcional na estrutura).
   * <p>
   * Preenchimento conforme Anexo II-A da Instrução Normativa RFB nº 770/2007, com códigos específicos para produto nacional, exportação e produto estrangeiro. Campo atualizado na NT2016.002.
   */
  @RFWMetaStringField(caption = "cSelo", required = false, unique = false, maxLength = 60, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cselo;

  /**
   * O05 - Quantidade de selo de controle (qSelo). Tipo: N, Tamanho: 1–12 (inteiro), Ocorrência: 0-1 (campo opcional na estrutura).
   */
  @RFWMetaBigDecimalField(caption = "qSelo", required = false, unique = false, maxValue = "", minValue = "", scale = 0, absolute = false)
  private BigDecimal qselo;

  /**
   * O06 - Código de Enquadramento Legal do IPI (cEnq). Tipo: N, Tamanho: 1–3, Ocorrência: 1-1 (campo obrigatório na estrutura da NF-e).
   * <p>
   * Preenchimento conforme seção 8.9 do Manual de Orientação do Contribuinte (MOC) – Visão Geral (Tabela de Código de Enquadramento do IPI).
   */
  @RFWMetaStringField(caption = "cEnq", required = false, unique = false, maxLength = 3, minLength = 1, pattern = "^[0-9]{1,3}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cenq;

  /**
   * O09 / O09b - Código da situação tributária do IPI (CST). Tipo: N, Tamanho: 2, Ocorrência: 1-1 (campo obrigatório na estrutura da NF-e).
   * <p>
   * Utiliza a enumeração SEFAZ_CST_IPI, contemplando os códigos dos grupos:
   * <ul>
   * <li>O07 - IPITrib (CST 00, 49, 50, 99);</li>
   * <li>O08 - IPINT (CST 01, 02, 03, 04, 05, 51, 52, 53, 54, 55).</li>
   * </ul>
   */
  @RFWMetaEnumField(caption = "CST", required = false)
  private SEFAZ_CST_IPI cstIpi;

  /**
   * O10 - Valor da BC do IPI (vBC). Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 quando o cálculo do IPI for por alíquota (sequência O09.1).
   */
  @RFWMetaBigDecimalField(caption = "vBC", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vbcIpi;

  /**
   * O13 - Alíquota do IPI (pIPI). Tipo: N, Tamanho: 3v2–4, Ocorrência: 1-1 quando o cálculo do IPI for por alíquota (sequência O09.1).
   */
  @RFWMetaBigDecimalField(caption = "pIPI", required = false, unique = false, maxValue = "", minValue = "", scale = 2, scaleMax = 4, absolute = false)
  private BigDecimal pipi;

  /**
   * O11 - Quantidade total na unidade padrão para tributação (qUnid). Tipo: N, Tamanho: 12v0–4, Ocorrência: 1-1 quando o cálculo do IPI for de valor por unidade (sequência O13.1). Utilizado somente para produtos tributados por unidade.
   */
  @RFWMetaBigDecimalField(caption = "qUnid", required = false, unique = false, maxValue = "", minValue = "", scale = 0, scaleMax = 4, absolute = false)
  private BigDecimal qunidIpi;

  /**
   * O12 - Valor por Unidade Tributável (vUnid). Tipo: N, Tamanho: 11v0–4, Ocorrência: 1-1 quando o cálculo do IPI for de valor por unidade (sequência O13.1).
   */
  @RFWMetaBigDecimalField(caption = "vUnid", required = false, unique = false, maxValue = "", minValue = "", scale = 0, scaleMax = 4, absolute = false)
  private BigDecimal vunidIpi;

  /**
   * O14 - Valor do IPI (vIPI). Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (campo obrigatório dentro do grupo de IPI para o item).
   * <p>
   * Quando o cálculo do IPI for de valor por unidade, devem ser informados também os campos O11 (qUnid) e O12 (vUnid).
   */
  @RFWMetaBigDecimalField(caption = "vIPI", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vipi;

  /**
   * # o02 - Classe de enquadramento do IPI (cIEnq). Tipo: C, Tamanho: 1-5, Ocorrência: 0-1 (campo opcional na estrutura).
   * <p>
   * Observação: campo excluído no leiaute 4.0 – NT2016.002, mantido aqui apenas para compatibilidade com versões anteriores.
   *
   * @return the o02 - Classe de enquadramento do IPI (cIEnq)
   */
  public String getCiEnq() {
    return ciEnq;
  }

  /**
   * # o02 - Classe de enquadramento do IPI (cIEnq). Tipo: C, Tamanho: 1-5, Ocorrência: 0-1 (campo opcional na estrutura).
   * <p>
   * Observação: campo excluído no leiaute 4.0 – NT2016.002, mantido aqui apenas para compatibilidade com versões anteriores.
   *
   * @param ciEnq the new o02 - Classe de enquadramento do IPI (cIEnq)
   */
  public void setCiEnq(String ciEnq) {
    this.ciEnq = ciEnq;
  }

  /**
   * # o03 - CNPJ do produtor da mercadoria (CNPJProd), quando diferente do emitente. Tipo: N, Tamanho: 14, Ocorrência: 0-1 (campo opcional na estrutura).
   * <p>
   * Utilizado somente para os casos de exportação direta ou indireta. Devem ser informados os zeros não significativos.
   *
   * @return the o03 - CNPJ do produtor da mercadoria (CNPJProd), quando diferente do emitente
   */
  public String getCnpjProd() {
    return cnpjProd;
  }

  /**
   * # o03 - CNPJ do produtor da mercadoria (CNPJProd), quando diferente do emitente. Tipo: N, Tamanho: 14, Ocorrência: 0-1 (campo opcional na estrutura).
   * <p>
   * Utilizado somente para os casos de exportação direta ou indireta. Devem ser informados os zeros não significativos.
   *
   * @param cnpjProd the new o03 - CNPJ do produtor da mercadoria (CNPJProd), quando diferente do emitente
   */
  public void setCnpjProd(String cnpjProd) {
    this.cnpjProd = cnpjProd;
  }

  /**
   * # o04 - Código do selo de controle IPI (cSelo). Tipo: C, Tamanho: 1–60, Ocorrência: 0-1 (campo opcional na estrutura).
   * <p>
   * Preenchimento conforme Anexo II-A da Instrução Normativa RFB nº 770/2007, com códigos específicos para produto nacional, exportação e produto estrangeiro. Campo atualizado na NT2016.002.
   *
   * @return the o04 - Código do selo de controle IPI (cSelo)
   */
  public String getCselo() {
    return cselo;
  }

  /**
   * # o04 - Código do selo de controle IPI (cSelo). Tipo: C, Tamanho: 1–60, Ocorrência: 0-1 (campo opcional na estrutura).
   * <p>
   * Preenchimento conforme Anexo II-A da Instrução Normativa RFB nº 770/2007, com códigos específicos para produto nacional, exportação e produto estrangeiro. Campo atualizado na NT2016.002.
   *
   * @param cselo the new o04 - Código do selo de controle IPI (cSelo)
   */
  public void setCselo(String cselo) {
    this.cselo = cselo;
  }

  /**
   * # o05 - Quantidade de selo de controle (qSelo). Tipo: N, Tamanho: 1–12 (inteiro), Ocorrência: 0-1 (campo opcional na estrutura).
   *
   * @return the o05 - Quantidade de selo de controle (qSelo)
   */
  public BigDecimal getQselo() {
    return qselo;
  }

  /**
   * # o05 - Quantidade de selo de controle (qSelo). Tipo: N, Tamanho: 1–12 (inteiro), Ocorrência: 0-1 (campo opcional na estrutura).
   *
   * @param qselo the new o05 - Quantidade de selo de controle (qSelo)
   */
  public void setQselo(BigDecimal qselo) {
    this.qselo = qselo;
  }

  /**
   * # o06 - Código de Enquadramento Legal do IPI (cEnq). Tipo: N, Tamanho: 1–3, Ocorrência: 1-1 (campo obrigatório na estrutura da NF-e).
   * <p>
   * Preenchimento conforme seção 8.9 do Manual de Orientação do Contribuinte (MOC) – Visão Geral (Tabela de Código de Enquadramento do IPI).
   *
   * @return the o06 - Código de Enquadramento Legal do IPI (cEnq)
   */
  public String getCenq() {
    return cenq;
  }

  /**
   * # o06 - Código de Enquadramento Legal do IPI (cEnq). Tipo: N, Tamanho: 1–3, Ocorrência: 1-1 (campo obrigatório na estrutura da NF-e).
   * <p>
   * Preenchimento conforme seção 8.9 do Manual de Orientação do Contribuinte (MOC) – Visão Geral (Tabela de Código de Enquadramento do IPI).
   *
   * @param cenq the new o06 - Código de Enquadramento Legal do IPI (cEnq)
   */
  public void setCenq(String cenq) {
    this.cenq = cenq;
  }

  /**
   * # o09 / O09b - Código da situação tributária do IPI (CST). Tipo: N, Tamanho: 2, Ocorrência: 1-1 (campo obrigatório na estrutura da NF-e).
   * <p>
   * Utiliza a enumeração SEFAZ_CST_IPI, contemplando os códigos dos grupos:
   * <ul>
   * <li>O07 - IPITrib (CST 00, 49, 50, 99);</li>
   * <li>O08 - IPINT (CST 01, 02, 03, 04, 05, 51, 52, 53, 54, 55).</li>
   * </ul>
   * .
   *
   * @return the o09 / O09b - Código da situação tributária do IPI (CST)
   */
  public SEFAZ_CST_IPI getCstIpi() {
    return cstIpi;
  }

  /**
   * # o09 / O09b - Código da situação tributária do IPI (CST). Tipo: N, Tamanho: 2, Ocorrência: 1-1 (campo obrigatório na estrutura da NF-e).
   * <p>
   * Utiliza a enumeração SEFAZ_CST_IPI, contemplando os códigos dos grupos:
   * <ul>
   * <li>O07 - IPITrib (CST 00, 49, 50, 99);</li>
   * <li>O08 - IPINT (CST 01, 02, 03, 04, 05, 51, 52, 53, 54, 55).</li>
   * </ul>
   * .
   *
   * @param cstIpi the new o09 / O09b - Código da situação tributária do IPI (CST)
   */
  public void setCstIpi(SEFAZ_CST_IPI cstIpi) {
    this.cstIpi = cstIpi;
  }

  /**
   * # o10 - Valor da BC do IPI (vBC). Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 quando o cálculo do IPI for por alíquota (sequência O09.1).
   *
   * @return the o10 - Valor da BC do IPI (vBC)
   */
  public BigDecimal getVbcIpi() {
    return vbcIpi;
  }

  /**
   * # o10 - Valor da BC do IPI (vBC). Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 quando o cálculo do IPI for por alíquota (sequência O09.1).
   *
   * @param vbcIpi the new o10 - Valor da BC do IPI (vBC)
   */
  public void setVbcIpi(BigDecimal vbcIpi) {
    this.vbcIpi = vbcIpi;
  }

  /**
   * # o13 - Alíquota do IPI (pIPI). Tipo: N, Tamanho: 3v2–4, Ocorrência: 1-1 quando o cálculo do IPI for por alíquota (sequência O09.1).
   *
   * @return the o13 - Alíquota do IPI (pIPI)
   */
  public BigDecimal getPipi() {
    return pipi;
  }

  /**
   * # o13 - Alíquota do IPI (pIPI). Tipo: N, Tamanho: 3v2–4, Ocorrência: 1-1 quando o cálculo do IPI for por alíquota (sequência O09.1).
   *
   * @param pipi the new o13 - Alíquota do IPI (pIPI)
   */
  public void setPipi(BigDecimal pipi) {
    this.pipi = pipi;
  }

  /**
   * # o11 - Quantidade total na unidade padrão para tributação (qUnid). Tipo: N, Tamanho: 12v0–4, Ocorrência: 1-1 quando o cálculo do IPI for de valor por unidade (sequência O13.1). Utilizado somente para produtos tributados por unidade.
   *
   * @return the o11 - Quantidade total na unidade padrão para tributação (qUnid)
   */
  public BigDecimal getQunidIpi() {
    return qunidIpi;
  }

  /**
   * # o11 - Quantidade total na unidade padrão para tributação (qUnid). Tipo: N, Tamanho: 12v0–4, Ocorrência: 1-1 quando o cálculo do IPI for de valor por unidade (sequência O13.1). Utilizado somente para produtos tributados por unidade.
   *
   * @param qunidIpi the new o11 - Quantidade total na unidade padrão para tributação (qUnid)
   */
  public void setQunidIpi(BigDecimal qunidIpi) {
    this.qunidIpi = qunidIpi;
  }

  /**
   * # o12 - Valor por Unidade Tributável (vUnid). Tipo: N, Tamanho: 11v0–4, Ocorrência: 1-1 quando o cálculo do IPI for de valor por unidade (sequência O13.1).
   *
   * @return the o12 - Valor por Unidade Tributável (vUnid)
   */
  public BigDecimal getVunidIpi() {
    return vunidIpi;
  }

  /**
   * # o12 - Valor por Unidade Tributável (vUnid). Tipo: N, Tamanho: 11v0–4, Ocorrência: 1-1 quando o cálculo do IPI for de valor por unidade (sequência O13.1).
   *
   * @param vunidIpi the new o12 - Valor por Unidade Tributável (vUnid)
   */
  public void setVunidIpi(BigDecimal vunidIpi) {
    this.vunidIpi = vunidIpi;
  }

  /**
   * # o14 - Valor do IPI (vIPI). Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (campo obrigatório dentro do grupo de IPI para o item).
   * <p>
   * Quando o cálculo do IPI for de valor por unidade, devem ser informados também os campos O11 (qUnid) e O12 (vUnid).
   *
   * @return the o14 - Valor do IPI (vIPI)
   */
  public BigDecimal getVipi() {
    return vipi;
  }

  /**
   * # o14 - Valor do IPI (vIPI). Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (campo obrigatório dentro do grupo de IPI para o item).
   * <p>
   * Quando o cálculo do IPI for de valor por unidade, devem ser informados também os campos O11 (qUnid) e O12 (vUnid).
   *
   * @param vipi the new o14 - Valor do IPI (vIPI)
   */
  public void setVipi(BigDecimal vipi) {
    this.vipi = vipi;
  }

  /**
   * # {@link SEFAZImpostoVO}.
   *
   * @return the {@link SEFAZImpostoVO}
   */
  public SEFAZImpostoVO getImpostoVO() {
    return impostoVO;
  }

  /**
   * # {@link SEFAZImpostoVO}.
   *
   * @param impostoVO the new {@link SEFAZImpostoVO}
   */
  public void setImpostoVO(SEFAZImpostoVO impostoVO) {
    this.impostoVO = impostoVO;
  }

}
