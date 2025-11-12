package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CSOSN;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CST_ICMS;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_modBC;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_modBCST;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_motDesICMS;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_orig;

/**
 * Description: Informações de ICMS da operação própria e ST (TAG {@code ICMS}, ID N01).<br>
 * Este VO consolida os campos dos grupos de tributação ICMS00 (N02), ICMS10 (N03), ICMS20 (N04), ICMS30 (N05) e ICMS40 (N06).<br>
 * Apenas um conjunto de campos deve ser utilizado por item, de acordo com o CST selecionado.
 *
 * @author BIS DEVil
 * @since (11 de nov. de 2025)
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_icms")
public class ICMSVO extends RFWVO {

  private static final long serialVersionUID = 6325469953946075321L;

  /**
   * ID: N11<br>
   * Origem da mercadoria.<br>
   * Utilizado em todos os grupos de ICMS do item (ICMS00, ICMS10, ICMS20, ICMS30 e ICMS40).<br>
   * Valores conforme {@link SEFAZ_orig}.
   */
  @RFWMetaEnumField(caption = "Origem da mercadoria", required = false)
  private SEFAZ_orig orig = null;

  /**
   * ID: N12<br>
   * Código de Situação Tributária do ICMS do item.<br>
   * Determina qual conjunto de campos deste grupo será utilizado (ICMS00, ICMS10, ICMS20, ICMS30 ou ICMS40).<br>
   * Valores conforme {@link SEFAZ_CST_ICMS}.
   */
  @RFWMetaEnumField(caption = "Situação tributária ICMS", required = false)
  private SEFAZ_CST_ICMS cst = null;

  /**
   * ID: N13<br>
   * Modalidade de determinação da Base de Cálculo do ICMS (BC própria).<br>
   * Utilizada nos grupos ICMS00, ICMS10 e ICMS20.<br>
   * Valores conforme {@link SEFAZ_modBC}.
   */
  @RFWMetaEnumField(caption = "Modalidade da BC do ICMS", required = false)
  private SEFAZ_modBC modBC = null;

  /**
   * ID: N18<br>
   * Modalidade de determinação da Base de Cálculo do ICMS ST (BC de substituição).<br>
   * Utilizada principalmente nos grupos ICMS10 e ICMS30.<br>
   * Valores conforme {@link SEFAZ_modBCST}.
   */
  @RFWMetaEnumField(caption = "Modalidade da BC do ICMS ST", required = false)
  private SEFAZ_modBCST modBCST = null;

  /**
   * ID: N15<br>
   * Base de Cálculo do ICMS da operação própria (BC do ICMS).<br>
   * Utilizada nos grupos ICMS00, ICMS10 e ICMS20.<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Base de cálculo ICMS", required = false, scale = 2, absolute = true)
  private BigDecimal vBC = null;

  /**
   * ID: N16<br>
   * Alíquota do ICMS da operação própria.<br>
   * Utilizada nos grupos ICMS00, ICMS10 e ICMS20.<br>
   * Tamanho 3v2-4.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota ICMS", required = false, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pICMS = null;

  /**
   * ID: N17<br>
   * Valor do ICMS da operação própria.<br>
   * Utilizada nos grupos ICMS00, ICMS10 e ICMS20.<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS", required = false, scale = 2, absolute = true)
  private BigDecimal vICMS = null;

  /**
   * ID: N14<br>
   * Percentual de redução da Base de Cálculo do ICMS.<br>
   * Utilizado no grupo ICMS20 (tributação com redução de base de cálculo).<br>
   * Tamanho 3v2-4.
   */
  @RFWMetaBigDecimalField(caption = "Redução da BC do ICMS", required = false, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pRedBC = null;

  /**
   * ID: N19<br>
   * Percentual da margem de valor agregado do ICMS ST (pMVAST).<br>
   * Utilizado principalmente nos grupos ICMS10 e ICMS30.<br>
   * Tamanho 3v2-4.
   */
  @RFWMetaBigDecimalField(caption = "Margem de valor ICMS ST", required = false, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pMVAST = null;

  /**
   * ID: N20<br>
   * Percentual de redução da Base de Cálculo do ICMS ST (pRedBCST).<br>
   * Utilizado nos grupos ICMS10 e ICMS30.<br>
   * Tamanho 3v2-4.
   */
  @RFWMetaBigDecimalField(caption = "Redução da BC ICMS ST", required = false, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pRedBCST = null;

  /**
   * ID: N21<br>
   * Base de Cálculo do ICMS ST (vBCST).<br>
   * Utilizada nos grupos ICMS10 e ICMS30.<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Base de cálculo ICMS ST", required = false, scale = 2, absolute = true)
  private BigDecimal vBCST = null;

  /**
   * ID: N22<br>
   * Alíquota do ICMS ST (pICMSST).<br>
   * Utilizada nos grupos ICMS10 e ICMS30.<br>
   * Tamanho 3v2-4.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota ICMS ST", required = false, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pICMSST = null;

  /**
   * ID: N23<br>
   * Valor do ICMS ST (vICMSST).<br>
   * Utilizado nos grupos ICMS10 e ICMS30.<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS ST", required = false, scale = 2, absolute = true)
  private BigDecimal vICMSST = null;

  /**
   * ID: N17a (grupo N17.1 – ICMS00/ICMS20)<br>
   * Base de cálculo do Fundo de Combate à Pobreza (FCP) – vBCFCP.<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Base de cálculo FCP", required = false, scale = 2, absolute = true)
  private BigDecimal vBCFCP = null;

  /**
   * ID: N17b (grupo N17.1 – ICMS00/ICMS20)<br>
   * Percentual do Fundo de Combate à Pobreza (FCP) – pFCP.<br>
   * Tamanho 3v2-4.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota FCP", required = false, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pFCP = null;

  /**
   * ID: N17c (grupo N17.1 – ICMS00/ICMS20)<br>
   * Valor do Fundo de Combate à Pobreza (FCP) – vFCP.<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor do FCP", required = false, scale = 2, absolute = true)
  private BigDecimal vFCP = null;

  /**
   * ID: N23a (grupo N23.1 – ICMS10/ICMS30)<br>
   * Base de cálculo do FCP retido por substituição tributária – vBCFCPST.<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Base de cálculo FCP ST", required = false, scale = 2, absolute = true)
  private BigDecimal vBCFCPST = null;

  /**
   * ID: N23b (grupo N23.1 – ICMS10/ICMS30)<br>
   * Percentual do FCP retido por substituição tributária – pFCPST.<br>
   * Tamanho 3v2-4.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota FCP ST", required = false, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pFCPST = null;

  /**
   * ID: N23d (grupo N23.1 – ICMS10/ICMS30)<br>
   * Valor do FCP retido por substituição tributária – vFCPST.<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor do FCP ST", required = false, scale = 2, absolute = true)
  private BigDecimal vFCPST = null;

  /**
   * ID: N28a (grupo N27.1 – ICMS20/ICMS30/ICMS40)<br>
   * Valor do ICMS desonerado (vICMSDeson).<br>
   * Utilizado quando houver desoneração, conforme motivo informado em {@link #motDesICMS}.<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS desonerado", required = false, scale = 2, absolute = true)
  private BigDecimal vICMSDeson = null;

  /**
   * ID: N28 (grupo N27.1 – ICMS20/ICMS30/ICMS40)<br>
   * Motivo da desoneração do ICMS (motDesICMS).<br>
   * Valores conforme {@link SEFAZ_motDesICMS}.<br>
   * Preenchido apenas quando houver valor em {@link #vICMSDeson}.
   */
  @RFWMetaEnumField(caption = "Motivo da desoneração", required = false)
  private SEFAZ_motDesICMS motDesICMS = null;

  /**
   * ID: N21 (ICMS51)<br>
   * Valor do ICMS da operação antes do diferimento.
   */
  @RFWMetaBigDecimalField(caption = "ICMS da operação", required = false, minValue = "0", absolute = true)
  private BigDecimal vICMSOp = null;

  /**
   * ID: N21a (ICMS51)<br>
   * Percentual de diferimento do ICMS.
   */
  @RFWMetaBigDecimalField(caption = "Percentual de diferimento", required = false, minValue = "0", absolute = true)
  private BigDecimal pDif = null;

  /**
   * ID: N21b (ICMS51)<br>
   * Valor do ICMS diferido.
   */
  @RFWMetaBigDecimalField(caption = "ICMS diferido", required = false, minValue = "0", absolute = true)
  private BigDecimal vICMSDif = null;

  /**
   * ID: N27a (ICMS60 / ICMS70 / ICMS90)<br>
   * Valor da base de cálculo do FCP retido anteriormente por substituição tributária.
   */
  @RFWMetaBigDecimalField(caption = "BC FCP ST retido ant.", required = false, minValue = "0", absolute = true)
  private BigDecimal vBCFCPSTRet = null;

  /**
   * ID: N27b (ICMS60 / ICMS70 / ICMS90)<br>
   * Percentual do FCP retido anteriormente por substituição tributária.
   */
  @RFWMetaBigDecimalField(caption = "Percentual FCP ST retido ant.", required = false, minValue = "0", absolute = true)
  private BigDecimal pFCPSTRet = null;

  /**
   * ID: N27d (ICMS60 / ICMS70 / ICMS90)<br>
   * Valor do FCP retido anteriormente por substituição tributária.
   */
  @RFWMetaBigDecimalField(caption = "Valor FCP ST retido ant.", required = false, minValue = "0", absolute = true)
  private BigDecimal vFCPSTRet = null;
  /**
   * ID: N33.1 (ICMS60 / ICMS70 / ICMS90)<br>
   * Percentual de redução da base de cálculo efetiva do ICMS.
   */
  @RFWMetaBigDecimalField(caption = "Percentual redução BC efetiva", required = false, minValue = "0", absolute = true)
  private BigDecimal pRedBCEfet = null;

  /**
   * ID: N35 (ICMS60 / ICMS70 / ICMS90)<br>
   * Valor da base de cálculo efetiva do ICMS.
   */
  @RFWMetaBigDecimalField(caption = "BC ICMS efetiva", required = false, minValue = "0", absolute = true)
  private BigDecimal vBCEfet = null;

  /**
   * ID: N36 (ICMS60 / ICMS70 / ICMS90)<br>
   * Alíquota do ICMS efetivo.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota ICMS efetivo", required = false, minValue = "0", absolute = true)
  private BigDecimal pICMSEfet = null;

  /**
   * ID: N37 (ICMS60 / ICMS70 / ICMS90)<br>
   * Valor do ICMS efetivo.
   */
  @RFWMetaBigDecimalField(caption = "ICMS efetivo", required = false, minValue = "0", absolute = true)
  private BigDecimal vICMSEfet = null;

  /**
   * ID: N12a<br>
   * Código de Situação da Operação no Simples Nacional (CSOSN).<br>
   * Utilizado nos grupos ICMSSN* (Simples Nacional), por exemplo ICMSSN102 quando o contribuinte está no CRT=1.<br>
   * Valores conforme {@link SEFAZ_CSOSN}.
   */
  @RFWMetaEnumField(caption = "CSOSN (Simples Nacional)", required = false)
  private SEFAZ_CSOSN csosn = null;

  /**
   * ID: (grupo ICMSSN101/ICMSSN201/ICMSSN900 – pCredSN)<br>
   * Percentual de crédito do ICMS permitido no Simples Nacional.<br>
   * Tamanho: 3v2-4.
   */
  @RFWMetaBigDecimalField(caption = "Percentual de crédito SN", required = false, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pCredSN = null;

  /**
   * ID: (grupo ICMSSN101/ICMSSN201/ICMSSN900 – vCredICMSSN)<br>
   * Valor do crédito de ICMS permitido no Simples Nacional.<br>
   * Tamanho: 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor do crédito ICMS SN", required = false, scale = 2, absolute = true)
  private BigDecimal vCredICMSSN = null;

  /**
   * # iD: N11<br>
   * Origem da mercadoria.<br>
   * Utilizado em todos os grupos de ICMS do item (ICMS00, ICMS10, ICMS20, ICMS30 e ICMS40).<br>
   * Valores conforme {@link SEFAZ_orig}.
   *
   * @return the iD: N11<br>
   *         Origem da mercadoria
   */
  public SEFAZ_orig getOrig() {
    return orig;
  }

  /**
   * # iD: N11<br>
   * Origem da mercadoria.<br>
   * Utilizado em todos os grupos de ICMS do item (ICMS00, ICMS10, ICMS20, ICMS30 e ICMS40).<br>
   * Valores conforme {@link SEFAZ_orig}.
   *
   * @param orig the new iD: N11<br>
   *          Origem da mercadoria
   */
  public void setOrig(SEFAZ_orig orig) {
    this.orig = orig;
  }

  /**
   * # iD: N12<br>
   * Código de Situação Tributária do ICMS do item.<br>
   * Determina qual conjunto de campos deste grupo será utilizado (ICMS00, ICMS10, ICMS20, ICMS30 ou ICMS40).<br>
   * Valores conforme {@link SEFAZ_CST_ICMS}.
   *
   * @return the iD: N12<br>
   *         Código de Situação Tributária do ICMS do item
   */
  public SEFAZ_CST_ICMS getCst() {
    return cst;
  }

  /**
   * # iD: N12<br>
   * Código de Situação Tributária do ICMS do item.<br>
   * Determina qual conjunto de campos deste grupo será utilizado (ICMS00, ICMS10, ICMS20, ICMS30 ou ICMS40).<br>
   * Valores conforme {@link SEFAZ_CST_ICMS}.
   *
   * @param cst the new iD: N12<br>
   *          Código de Situação Tributária do ICMS do item
   */
  public void setCst(SEFAZ_CST_ICMS cst) {
    this.cst = cst;
  }

  /**
   * # iD: N13<br>
   * Modalidade de determinação da Base de Cálculo do ICMS (BC própria).<br>
   * Utilizada nos grupos ICMS00, ICMS10 e ICMS20.<br>
   * Valores conforme {@link SEFAZ_modBC}.
   *
   * @return the iD: N13<br>
   *         Modalidade de determinação da Base de Cálculo do ICMS (BC própria)
   */
  public SEFAZ_modBC getModBC() {
    return modBC;
  }

  /**
   * # iD: N13<br>
   * Modalidade de determinação da Base de Cálculo do ICMS (BC própria).<br>
   * Utilizada nos grupos ICMS00, ICMS10 e ICMS20.<br>
   * Valores conforme {@link SEFAZ_modBC}.
   *
   * @param modBC the new iD: N13<br>
   *          Modalidade de determinação da Base de Cálculo do ICMS (BC própria)
   */
  public void setModBC(SEFAZ_modBC modBC) {
    this.modBC = modBC;
  }

  /**
   * # iD: N18<br>
   * Modalidade de determinação da Base de Cálculo do ICMS ST (BC de substituição).<br>
   * Utilizada principalmente nos grupos ICMS10 e ICMS30.<br>
   * Valores conforme {@link SEFAZ_modBCST}.
   *
   * @return the iD: N18<br>
   *         Modalidade de determinação da Base de Cálculo do ICMS ST (BC de substituição)
   */
  public SEFAZ_modBCST getModBCST() {
    return modBCST;
  }

  /**
   * # iD: N18<br>
   * Modalidade de determinação da Base de Cálculo do ICMS ST (BC de substituição).<br>
   * Utilizada principalmente nos grupos ICMS10 e ICMS30.<br>
   * Valores conforme {@link SEFAZ_modBCST}.
   *
   * @param modBCST the new iD: N18<br>
   *          Modalidade de determinação da Base de Cálculo do ICMS ST (BC de substituição)
   */
  public void setModBCST(SEFAZ_modBCST modBCST) {
    this.modBCST = modBCST;
  }

  /**
   * # iD: N15<br>
   * Base de Cálculo do ICMS da operação própria (BC do ICMS).<br>
   * Utilizada nos grupos ICMS00, ICMS10 e ICMS20.<br>
   * Tamanho 13v2.
   *
   * @return the iD: N15<br>
   *         Base de Cálculo do ICMS da operação própria (BC do ICMS)
   */
  public BigDecimal getVBC() {
    return vBC;
  }

  /**
   * # iD: N15<br>
   * Base de Cálculo do ICMS da operação própria (BC do ICMS).<br>
   * Utilizada nos grupos ICMS00, ICMS10 e ICMS20.<br>
   * Tamanho 13v2.
   *
   * @param vBC the new iD: N15<br>
   *          Base de Cálculo do ICMS da operação própria (BC do ICMS)
   */
  public void setVBC(BigDecimal vBC) {
    this.vBC = vBC;
  }

  /**
   * # iD: N16<br>
   * Alíquota do ICMS da operação própria.<br>
   * Utilizada nos grupos ICMS00, ICMS10 e ICMS20.<br>
   * Tamanho 3v2-4.
   *
   * @return the iD: N16<br>
   *         Alíquota do ICMS da operação própria
   */
  public BigDecimal getPICMS() {
    return pICMS;
  }

  /**
   * # iD: N16<br>
   * Alíquota do ICMS da operação própria.<br>
   * Utilizada nos grupos ICMS00, ICMS10 e ICMS20.<br>
   * Tamanho 3v2-4.
   *
   * @param pICMS the new iD: N16<br>
   *          Alíquota do ICMS da operação própria
   */
  public void setPICMS(BigDecimal pICMS) {
    this.pICMS = pICMS;
  }

  /**
   * # iD: N17<br>
   * Valor do ICMS da operação própria.<br>
   * Utilizada nos grupos ICMS00, ICMS10 e ICMS20.<br>
   * Tamanho 13v2.
   *
   * @return the iD: N17<br>
   *         Valor do ICMS da operação própria
   */
  public BigDecimal getVICMS() {
    return vICMS;
  }

  /**
   * # iD: N17<br>
   * Valor do ICMS da operação própria.<br>
   * Utilizada nos grupos ICMS00, ICMS10 e ICMS20.<br>
   * Tamanho 13v2.
   *
   * @param vICMS the new iD: N17<br>
   *          Valor do ICMS da operação própria
   */
  public void setVICMS(BigDecimal vICMS) {
    this.vICMS = vICMS;
  }

  /**
   * # iD: N14<br>
   * Percentual de redução da Base de Cálculo do ICMS.<br>
   * Utilizado no grupo ICMS20 (tributação com redução de base de cálculo).<br>
   * Tamanho 3v2-4.
   *
   * @return the iD: N14<br>
   *         Percentual de redução da Base de Cálculo do ICMS
   */
  public BigDecimal getPRedBC() {
    return pRedBC;
  }

  /**
   * # iD: N14<br>
   * Percentual de redução da Base de Cálculo do ICMS.<br>
   * Utilizado no grupo ICMS20 (tributação com redução de base de cálculo).<br>
   * Tamanho 3v2-4.
   *
   * @param pRedBC the new iD: N14<br>
   *          Percentual de redução da Base de Cálculo do ICMS
   */
  public void setPRedBC(BigDecimal pRedBC) {
    this.pRedBC = pRedBC;
  }

  /**
   * # iD: N19<br>
   * Percentual da margem de valor agregado do ICMS ST (pMVAST).<br>
   * Utilizado principalmente nos grupos ICMS10 e ICMS30.<br>
   * Tamanho 3v2-4.
   *
   * @return the iD: N19<br>
   *         Percentual da margem de valor agregado do ICMS ST (pMVAST)
   */
  public BigDecimal getPMVAST() {
    return pMVAST;
  }

  /**
   * # iD: N19<br>
   * Percentual da margem de valor agregado do ICMS ST (pMVAST).<br>
   * Utilizado principalmente nos grupos ICMS10 e ICMS30.<br>
   * Tamanho 3v2-4.
   *
   * @param pMVAST the new iD: N19<br>
   *          Percentual da margem de valor agregado do ICMS ST (pMVAST)
   */
  public void setPMVAST(BigDecimal pMVAST) {
    this.pMVAST = pMVAST;
  }

  /**
   * # iD: N20<br>
   * Percentual de redução da Base de Cálculo do ICMS ST (pRedBCST).<br>
   * Utilizado nos grupos ICMS10 e ICMS30.<br>
   * Tamanho 3v2-4.
   *
   * @return the iD: N20<br>
   *         Percentual de redução da Base de Cálculo do ICMS ST (pRedBCST)
   */
  public BigDecimal getPRedBCST() {
    return pRedBCST;
  }

  /**
   * # iD: N20<br>
   * Percentual de redução da Base de Cálculo do ICMS ST (pRedBCST).<br>
   * Utilizado nos grupos ICMS10 e ICMS30.<br>
   * Tamanho 3v2-4.
   *
   * @param pRedBCST the new iD: N20<br>
   *          Percentual de redução da Base de Cálculo do ICMS ST (pRedBCST)
   */
  public void setPRedBCST(BigDecimal pRedBCST) {
    this.pRedBCST = pRedBCST;
  }

  /**
   * # iD: N21<br>
   * Base de Cálculo do ICMS ST (vBCST).<br>
   * Utilizada nos grupos ICMS10 e ICMS30.<br>
   * Tamanho 13v2.
   *
   * @return the iD: N21<br>
   *         Base de Cálculo do ICMS ST (vBCST)
   */
  public BigDecimal getVBCST() {
    return vBCST;
  }

  /**
   * # iD: N21<br>
   * Base de Cálculo do ICMS ST (vBCST).<br>
   * Utilizada nos grupos ICMS10 e ICMS30.<br>
   * Tamanho 13v2.
   *
   * @param vBCST the new iD: N21<br>
   *          Base de Cálculo do ICMS ST (vBCST)
   */
  public void setVBCST(BigDecimal vBCST) {
    this.vBCST = vBCST;
  }

  /**
   * # iD: N22<br>
   * Alíquota do ICMS ST (pICMSST).<br>
   * Utilizada nos grupos ICMS10 e ICMS30.<br>
   * Tamanho 3v2-4.
   *
   * @return the iD: N22<br>
   *         Alíquota do ICMS ST (pICMSST)
   */
  public BigDecimal getPICMSST() {
    return pICMSST;
  }

  /**
   * # iD: N22<br>
   * Alíquota do ICMS ST (pICMSST).<br>
   * Utilizada nos grupos ICMS10 e ICMS30.<br>
   * Tamanho 3v2-4.
   *
   * @param pICMSST the new iD: N22<br>
   *          Alíquota do ICMS ST (pICMSST)
   */
  public void setPICMSST(BigDecimal pICMSST) {
    this.pICMSST = pICMSST;
  }

  /**
   * # iD: N23<br>
   * Valor do ICMS ST (vICMSST).<br>
   * Utilizado nos grupos ICMS10 e ICMS30.<br>
   * Tamanho 13v2.
   *
   * @return the iD: N23<br>
   *         Valor do ICMS ST (vICMSST)
   */
  public BigDecimal getVICMSST() {
    return vICMSST;
  }

  /**
   * # iD: N23<br>
   * Valor do ICMS ST (vICMSST).<br>
   * Utilizado nos grupos ICMS10 e ICMS30.<br>
   * Tamanho 13v2.
   *
   * @param vICMSST the new iD: N23<br>
   *          Valor do ICMS ST (vICMSST)
   */
  public void setVICMSST(BigDecimal vICMSST) {
    this.vICMSST = vICMSST;
  }

  /**
   * # iD: N17a (grupo N17.1 – ICMS00/ICMS20)<br>
   * Base de cálculo do Fundo de Combate à Pobreza (FCP) – vBCFCP.<br>
   * Tamanho 13v2.
   *
   * @return the iD: N17a (grupo N17
   */
  public BigDecimal getVBCFCP() {
    return vBCFCP;
  }

  /**
   * # iD: N17a (grupo N17.1 – ICMS00/ICMS20)<br>
   * Base de cálculo do Fundo de Combate à Pobreza (FCP) – vBCFCP.<br>
   * Tamanho 13v2.
   *
   * @param vBCFCP the new iD: N17a (grupo N17
   */
  public void setVBCFCP(BigDecimal vBCFCP) {
    this.vBCFCP = vBCFCP;
  }

  /**
   * # iD: N17b (grupo N17.1 – ICMS00/ICMS20)<br>
   * Percentual do Fundo de Combate à Pobreza (FCP) – pFCP.<br>
   * Tamanho 3v2-4.
   *
   * @return the iD: N17b (grupo N17
   */
  public BigDecimal getPFCP() {
    return pFCP;
  }

  /**
   * # iD: N17b (grupo N17.1 – ICMS00/ICMS20)<br>
   * Percentual do Fundo de Combate à Pobreza (FCP) – pFCP.<br>
   * Tamanho 3v2-4.
   *
   * @param pFCP the new iD: N17b (grupo N17
   */
  public void setPFCP(BigDecimal pFCP) {
    this.pFCP = pFCP;
  }

  /**
   * # iD: N17c (grupo N17.1 – ICMS00/ICMS20)<br>
   * Valor do Fundo de Combate à Pobreza (FCP) – vFCP.<br>
   * Tamanho 13v2.
   *
   * @return the iD: N17c (grupo N17
   */
  public BigDecimal getVFCP() {
    return vFCP;
  }

  /**
   * # iD: N17c (grupo N17.1 – ICMS00/ICMS20)<br>
   * Valor do Fundo de Combate à Pobreza (FCP) – vFCP.<br>
   * Tamanho 13v2.
   *
   * @param vFCP the new iD: N17c (grupo N17
   */
  public void setVFCP(BigDecimal vFCP) {
    this.vFCP = vFCP;
  }

  /**
   * # iD: N23a (grupo N23.1 – ICMS10/ICMS30)<br>
   * Base de cálculo do FCP retido por substituição tributária – vBCFCPST.<br>
   * Tamanho 13v2.
   *
   * @return the iD: N23a (grupo N23
   */
  public BigDecimal getVBCFCPST() {
    return vBCFCPST;
  }

  /**
   * # iD: N23a (grupo N23.1 – ICMS10/ICMS30)<br>
   * Base de cálculo do FCP retido por substituição tributária – vBCFCPST.<br>
   * Tamanho 13v2.
   *
   * @param vBCFCPST the new iD: N23a (grupo N23
   */
  public void setVBCFCPST(BigDecimal vBCFCPST) {
    this.vBCFCPST = vBCFCPST;
  }

  /**
   * # iD: N23b (grupo N23.1 – ICMS10/ICMS30)<br>
   * Percentual do FCP retido por substituição tributária – pFCPST.<br>
   * Tamanho 3v2-4.
   *
   * @return the iD: N23b (grupo N23
   */
  public BigDecimal getPFCPST() {
    return pFCPST;
  }

  /**
   * # iD: N23b (grupo N23.1 – ICMS10/ICMS30)<br>
   * Percentual do FCP retido por substituição tributária – pFCPST.<br>
   * Tamanho 3v2-4.
   *
   * @param pFCPST the new iD: N23b (grupo N23
   */
  public void setPFCPST(BigDecimal pFCPST) {
    this.pFCPST = pFCPST;
  }

  /**
   * # iD: N23d (grupo N23.1 – ICMS10/ICMS30)<br>
   * Valor do FCP retido por substituição tributária – vFCPST.<br>
   * Tamanho 13v2.
   *
   * @return the iD: N23d (grupo N23
   */
  public BigDecimal getVFCPST() {
    return vFCPST;
  }

  /**
   * # iD: N23d (grupo N23.1 – ICMS10/ICMS30)<br>
   * Valor do FCP retido por substituição tributária – vFCPST.<br>
   * Tamanho 13v2.
   *
   * @param vFCPST the new iD: N23d (grupo N23
   */
  public void setVFCPST(BigDecimal vFCPST) {
    this.vFCPST = vFCPST;
  }

  /**
   * # iD: N28a (grupo N27.1 – ICMS20/ICMS30/ICMS40)<br>
   * Valor do ICMS desonerado (vICMSDeson).<br>
   * Utilizado quando houver desoneração, conforme motivo informado em {@link #motDesICMS}.<br>
   * Tamanho 13v2.
   *
   * @return the iD: N28a (grupo N27
   */
  public BigDecimal getVICMSDeson() {
    return vICMSDeson;
  }

  /**
   * # iD: N28a (grupo N27.1 – ICMS20/ICMS30/ICMS40)<br>
   * Valor do ICMS desonerado (vICMSDeson).<br>
   * Utilizado quando houver desoneração, conforme motivo informado em {@link #motDesICMS}.<br>
   * Tamanho 13v2.
   *
   * @param vICMSDeson the new iD: N28a (grupo N27
   */
  public void setVICMSDeson(BigDecimal vICMSDeson) {
    this.vICMSDeson = vICMSDeson;
  }

  /**
   * # iD: N28 (grupo N27.1 – ICMS20/ICMS30/ICMS40)<br>
   * Motivo da desoneração do ICMS (motDesICMS).<br>
   * Valores conforme {@link SEFAZ_motDesICMS}.<br>
   * Preenchido apenas quando houver valor em {@link #vICMSDeson}.
   *
   * @return the iD: N28 (grupo N27
   */
  public SEFAZ_motDesICMS getMotDesICMS() {
    return motDesICMS;
  }

  /**
   * # iD: N28 (grupo N27.1 – ICMS20/ICMS30/ICMS40)<br>
   * Motivo da desoneração do ICMS (motDesICMS).<br>
   * Valores conforme {@link SEFAZ_motDesICMS}.<br>
   * Preenchido apenas quando houver valor em {@link #vICMSDeson}.
   *
   * @param motDesICMS the new iD: N28 (grupo N27
   */
  public void setMotDesICMS(SEFAZ_motDesICMS motDesICMS) {
    this.motDesICMS = motDesICMS;
  }

  /**
   * # iD: N21 (ICMS51)<br>
   * Valor do ICMS da operação antes do diferimento.
   *
   * @return the iD: N21 (ICMS51)<br>
   *         Valor do ICMS da operação antes do diferimento
   */
  public BigDecimal getVICMSOp() {
    return vICMSOp;
  }

  /**
   * # iD: N21 (ICMS51)<br>
   * Valor do ICMS da operação antes do diferimento.
   *
   * @param vICMSOp the new iD: N21 (ICMS51)<br>
   *          Valor do ICMS da operação antes do diferimento
   */
  public void setVICMSOp(BigDecimal vICMSOp) {
    this.vICMSOp = vICMSOp;
  }

  /**
   * # iD: N21a (ICMS51)<br>
   * Percentual de diferimento do ICMS.
   *
   * @return the iD: N21a (ICMS51)<br>
   *         Percentual de diferimento do ICMS
   */
  public BigDecimal getPDif() {
    return pDif;
  }

  /**
   * # iD: N21a (ICMS51)<br>
   * Percentual de diferimento do ICMS.
   *
   * @param pDif the new iD: N21a (ICMS51)<br>
   *          Percentual de diferimento do ICMS
   */
  public void setPDif(BigDecimal pDif) {
    this.pDif = pDif;
  }

  /**
   * # iD: N21b (ICMS51)<br>
   * Valor do ICMS diferido.
   *
   * @return the iD: N21b (ICMS51)<br>
   *         Valor do ICMS diferido
   */
  public BigDecimal getVICMSDif() {
    return vICMSDif;
  }

  /**
   * # iD: N21b (ICMS51)<br>
   * Valor do ICMS diferido.
   *
   * @param vICMSDif the new iD: N21b (ICMS51)<br>
   *          Valor do ICMS diferido
   */
  public void setVICMSDif(BigDecimal vICMSDif) {
    this.vICMSDif = vICMSDif;
  }

  /**
   * # iD: N27a (ICMS60 / ICMS70 / ICMS90)<br>
   * Valor da base de cálculo do FCP retido anteriormente por substituição tributária.
   *
   * @return the iD: N27a (ICMS60 / ICMS70 / ICMS90)<br>
   *         Valor da base de cálculo do FCP retido anteriormente por substituição tributária
   */
  public BigDecimal getVBCFCPSTRet() {
    return vBCFCPSTRet;
  }

  /**
   * # iD: N27a (ICMS60 / ICMS70 / ICMS90)<br>
   * Valor da base de cálculo do FCP retido anteriormente por substituição tributária.
   *
   * @param vBCFCPSTRet the new iD: N27a (ICMS60 / ICMS70 / ICMS90)<br>
   *          Valor da base de cálculo do FCP retido anteriormente por substituição tributária
   */
  public void setVBCFCPSTRet(BigDecimal vBCFCPSTRet) {
    this.vBCFCPSTRet = vBCFCPSTRet;
  }

  /**
   * # iD: N27b (ICMS60 / ICMS70 / ICMS90)<br>
   * Percentual do FCP retido anteriormente por substituição tributária.
   *
   * @return the iD: N27b (ICMS60 / ICMS70 / ICMS90)<br>
   *         Percentual do FCP retido anteriormente por substituição tributária
   */
  public BigDecimal getPFCPSTRet() {
    return pFCPSTRet;
  }

  /**
   * # iD: N27b (ICMS60 / ICMS70 / ICMS90)<br>
   * Percentual do FCP retido anteriormente por substituição tributária.
   *
   * @param pFCPSTRet the new iD: N27b (ICMS60 / ICMS70 / ICMS90)<br>
   *          Percentual do FCP retido anteriormente por substituição tributária
   */
  public void setPFCPSTRet(BigDecimal pFCPSTRet) {
    this.pFCPSTRet = pFCPSTRet;
  }

  /**
   * # iD: N27d (ICMS60 / ICMS70 / ICMS90)<br>
   * Valor do FCP retido anteriormente por substituição tributária.
   *
   * @return the iD: N27d (ICMS60 / ICMS70 / ICMS90)<br>
   *         Valor do FCP retido anteriormente por substituição tributária
   */
  public BigDecimal getVFCPSTRet() {
    return vFCPSTRet;
  }

  /**
   * # iD: N27d (ICMS60 / ICMS70 / ICMS90)<br>
   * Valor do FCP retido anteriormente por substituição tributária.
   *
   * @param vFCPSTRet the new iD: N27d (ICMS60 / ICMS70 / ICMS90)<br>
   *          Valor do FCP retido anteriormente por substituição tributária
   */
  public void setVFCPSTRet(BigDecimal vFCPSTRet) {
    this.vFCPSTRet = vFCPSTRet;
  }

  /**
   * # iD: N33.1 (ICMS60 / ICMS70 / ICMS90)<br>
   * Percentual de redução da base de cálculo efetiva do ICMS.
   *
   * @return the iD: N33
   */
  public BigDecimal getPRedBCEfet() {
    return pRedBCEfet;
  }

  /**
   * # iD: N33.1 (ICMS60 / ICMS70 / ICMS90)<br>
   * Percentual de redução da base de cálculo efetiva do ICMS.
   *
   * @param pRedBCEfet the new iD: N33
   */
  public void setPRedBCEfet(BigDecimal pRedBCEfet) {
    this.pRedBCEfet = pRedBCEfet;
  }

  /**
   * # iD: N35 (ICMS60 / ICMS70 / ICMS90)<br>
   * Valor da base de cálculo efetiva do ICMS.
   *
   * @return the iD: N35 (ICMS60 / ICMS70 / ICMS90)<br>
   *         Valor da base de cálculo efetiva do ICMS
   */
  public BigDecimal getVBCEfet() {
    return vBCEfet;
  }

  /**
   * # iD: N35 (ICMS60 / ICMS70 / ICMS90)<br>
   * Valor da base de cálculo efetiva do ICMS.
   *
   * @param vBCEfet the new iD: N35 (ICMS60 / ICMS70 / ICMS90)<br>
   *          Valor da base de cálculo efetiva do ICMS
   */
  public void setVBCEfet(BigDecimal vBCEfet) {
    this.vBCEfet = vBCEfet;
  }

  /**
   * # iD: N36 (ICMS60 / ICMS70 / ICMS90)<br>
   * Alíquota do ICMS efetivo.
   *
   * @return the iD: N36 (ICMS60 / ICMS70 / ICMS90)<br>
   *         Alíquota do ICMS efetivo
   */
  public BigDecimal getPICMSEfet() {
    return pICMSEfet;
  }

  /**
   * # iD: N36 (ICMS60 / ICMS70 / ICMS90)<br>
   * Alíquota do ICMS efetivo.
   *
   * @param pICMSEfet the new iD: N36 (ICMS60 / ICMS70 / ICMS90)<br>
   *          Alíquota do ICMS efetivo
   */
  public void setPICMSEfet(BigDecimal pICMSEfet) {
    this.pICMSEfet = pICMSEfet;
  }

  /**
   * # iD: N37 (ICMS60 / ICMS70 / ICMS90)<br>
   * Valor do ICMS efetivo.
   *
   * @return the iD: N37 (ICMS60 / ICMS70 / ICMS90)<br>
   *         Valor do ICMS efetivo
   */
  public BigDecimal getVICMSEfet() {
    return vICMSEfet;
  }

  /**
   * # iD: N37 (ICMS60 / ICMS70 / ICMS90)<br>
   * Valor do ICMS efetivo.
   *
   * @param vICMSEfet the new iD: N37 (ICMS60 / ICMS70 / ICMS90)<br>
   *          Valor do ICMS efetivo
   */
  public void setVICMSEfet(BigDecimal vICMSEfet) {
    this.vICMSEfet = vICMSEfet;
  }

  /**
   * # iD: N12a<br>
   * Código de Situação da Operação no Simples Nacional (CSOSN).<br>
   * Utilizado nos grupos ICMSSN* (Simples Nacional), por exemplo ICMSSN102 quando o contribuinte está no CRT=1.<br>
   * Valores conforme {@link SEFAZ_CSOSN}.
   *
   * @return the iD: N12a<br>
   *         Código de Situação da Operação no Simples Nacional (CSOSN)
   */
  public SEFAZ_CSOSN getCsosn() {
    return csosn;
  }

  /**
   * # iD: N12a<br>
   * Código de Situação da Operação no Simples Nacional (CSOSN).<br>
   * Utilizado nos grupos ICMSSN* (Simples Nacional), por exemplo ICMSSN102 quando o contribuinte está no CRT=1.<br>
   * Valores conforme {@link SEFAZ_CSOSN}.
   *
   * @param csosn the new iD: N12a<br>
   *          Código de Situação da Operação no Simples Nacional (CSOSN)
   */
  public void setCsosn(SEFAZ_CSOSN csosn) {
    this.csosn = csosn;
  }

}