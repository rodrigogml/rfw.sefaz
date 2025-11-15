package br.eng.rodrigogml.rfw.sefaz.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CSOSN;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CST_ICMS;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_modBC;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_modBCST;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_motDesICMS;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_orig;

/**
 * Grupo N - Informações do ICMS da Operação própria e ST (tag ICMS / N01).
 *
 * Nesta etapa, os campos do grupo ICMS00 (N02) são mapeados diretamente neste VO: orig, CST, modBC, vBC, pICMS, vICMS, pFCP, vFCP.
 *
 * Informar apenas um dos grupos de tributação do ICMS (ICMS00, ICMS10, …) (v2.0).
 *
 * Observação: nas annotations o atributo {@code required} é sempre definido como false conforme solicitado, mesmo que o MOC defina obrigatoriedade.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_icms")
public class SEFAZICMSVO extends RFWVO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * {@link SEFAZImpostoVO}
   */
  @RFWMetaRelationshipField(caption = "Imposto", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_imposto")
  private SEFAZImpostoVO impostoVO = null;

  /**
   * {@link SEFAZICMSPartVO}
   */
  @RFWMetaRelationshipField(caption = "ICMSPart", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_icms")
  private SEFAZICMSPartVO icmsPartVO = null;

  /**
   * {@link SEFAZICMSSTVO}
   */
  @RFWMetaRelationshipField(caption = "ICMSST", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_icms")
  private SEFAZICMSSTVO icmsSTVO = null;

  /**
   * N11 - orig. Origem da mercadoria. Ocor.: 1–1 / Tam.: 1 / Tipo: N. Ver valores em {@link SEFAZ_orig}. <br>
   * ICMS00: origem da mercadoria para operações tributadas integralmente. <br>
   * ICMS10: origem da mercadoria para operações tributadas com ICMS e ICMS ST. <br>
   * ICMS20: origem da mercadoria para operações com redução de base de cálculo. <br>
   * ICMS30: origem da mercadoria para operações isentas/não tributadas com cobrança de ICMS ST. <br>
   * ICMS40: origem da mercadoria para operações isentas, não tributadas ou com suspensão de ICMS. <br>
   * ICMS51: origem da mercadoria para operações com diferimento do ICMS. <br>
   * ICMS60: origem da mercadoria em operações com ICMS cobrado anteriormente por ST. <br>
   * ICMS70: origem da mercadoria em operações com redução de BC e cobrança de ICMS ST. <br>
   * ICMS90: origem da mercadoria em operações enquadradas no grupo “Outros” (CST 90). <br>
   * ICMSSN101: origem da mercadoria em operações do Simples Nacional com CSOSN=101. <br>
   * ICMSSN102: origem da mercadoria em operações do Simples Nacional com CSOSN=102, 103, 300 ou 400. <br>
   * ICMSSN201: origem da mercadoria em operações do Simples Nacional com CSOSN=201 (permite crédito e tem ICMS ST). <br>
   * ICMSSN202: origem da mercadoria em operações do Simples Nacional com CSOSN=202 ou 203 (sem crédito ou com isenção, ambas com ST). <br>
   * ICMSSN500: origem da mercadoria em operações do Simples Nacional com CSOSN=500, nas quais o ICMS foi cobrado anteriormente por substituição tributária ou antecipação. <br>
   * ICMSSN900: origem da mercadoria em operações do Simples Nacional enquadradas como “Outros” (CSOSN=900), tanto para ICMS próprio quanto, quando aplicável, para ICMS ST.
   */
  @RFWMetaEnumField(caption = "Origem da mercadoria", required = false)
  private SEFAZ_orig orig;

  /**
   * N12a - CSOSN. Código de Situação da Operação – Simples Nacional. Ocor.: 1–1 / Tam.: 3 / Tipo: N. <br>
   * ICMSSN101: CSOSN = 101 – Tributada pelo Simples Nacional com permissão de crédito. <br>
   * ICMSSN102: CSOSN = 102 – Tributada pelo Simples Nacional sem permissão de crédito. <br>
   * ICMSSN102: CSOSN = 103 – Isenção do ICMS no Simples Nacional para faixa de receita bruta. <br>
   * ICMSSN102: CSOSN = 300 – Imune. <br>
   * ICMSSN102: CSOSN = 400 – Não tributada pelo Simples Nacional. <br>
   * ICMSSN201: CSOSN = 201 – Tributada pelo Simples Nacional com permissão de crédito e com cobrança do ICMS por substituição tributária. <br>
   * ICMSSN202: CSOSN = 202 – Tributada pelo Simples Nacional sem permissão de crédito e com cobrança do ICMS por substituição tributária. <br>
   * ICMSSN202: CSOSN = 203 – Isenção do ICMS no Simples Nacional para faixa de receita bruta e com cobrança do ICMS por substituição tributária. <br>
   * ICMSSN500: CSOSN = 500 – ICMS cobrado anteriormente por substituição tributária (substituído) ou por antecipação. <br>
   * ICMSSN900: CSOSN = 900 – Outros, para operações do Simples Nacional com regras específicas de ICMS próprio, redução de base, ST e crédito conforme a legislação estadual. <br>
   * Mapeado para {@link SEFAZ_CSOSN}. Outros códigos poderão ser utilizados por outros grupos ICMSSN* conforme forem implementados.
   */
  @RFWMetaEnumField(caption = "CSOSN (Simples Nacional)", required = false)
  private SEFAZ_CSOSN csosn;

  /**
   * N13 - modBC. Modalidade de determinação da BC do ICMS. 0 = Margem Valor Agregado (%); 1 = Pauta (valor); 2 = Preço tabelado máximo (valor); 3 = Valor da operação. Ocor.: 1–1 (ou 0–1 no ICMS51) / Tam.: 1 / Tipo: N. Ver valores em {@link SEFAZ_modBC}. <br>
   * ICMS00: modalidade para cálculo da BC do ICMS próprio. <br>
   * ICMS10: modalidade para cálculo da BC do ICMS próprio (antes da ST). <br>
   * ICMS20: modalidade para cálculo da BC do ICMS em operações com redução de BC. <br>
   * ICMS51: modalidade da BC do ICMS em operações com diferimento (campo opcional, a critério da UF). <br>
   * ICMS70: modalidade para cálculo da BC do ICMS próprio em operação com redução de BC e com ST. <br>
   * ICMS90: modalidade para cálculo da BC do ICMS próprio em operações enquadradas como “Outros”. <br>
   * ICMSSN900: modalidade para determinação da BC do ICMS próprio em operações do Simples Nacional com CSOSN=900, seguindo as mesmas modalidades 0–3 previstas no MOC.
   */
  @RFWMetaEnumField(caption = "Modalidade de determinação da BC do ICMS", required = false)
  private SEFAZ_modBC modBC;

  /**
   * N15 - vBC. Valor da base de cálculo do ICMS. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS00: valor da BC do ICMS próprio. <br>
   * ICMS10: valor da BC do ICMS próprio (antes da substituição tributária). <br>
   * ICMS20: valor da BC do ICMS após a aplicação da redução de base de cálculo. <br>
   * ICMS51: valor da BC do ICMS utilizada para cálculo do ICMS da operação com diferimento. <br>
   * ICMS70: valor da BC do ICMS próprio, já considerando a redução de base de cálculo. <br>
   * ICMS90: valor da BC do ICMS próprio nas operações do grupo “Outros”. <br>
   * ICMSSN900: valor da BC do ICMS próprio nas operações do Simples Nacional com CSOSN=900, de acordo com a modalidade de cálculo definida em modBC.
   */
  @RFWMetaBigDecimalField(caption = "Valor da BC do ICMS", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vbc;

  /**
   * N14 (ICMS20 / ICMS51 / ICMS70 / ICMSSN900) - pRedBC. Percentual de redução da base de cálculo do ICMS. <br>
   * Ocor.: ICMS20: 1–1 / Tam.: 3v2–4; ICMS51: 0–1 / Tam.: 3v2–4; demais conforme a UF. Tipo: N. <br>
   * ICMS20: percentual de redução da BC do ICMS. <br>
   * ICMS51: percentual de redução da BC do ICMS quando aplicável ao diferimento. <br>
   * ICMS70: percentual de redução da BC do ICMS próprio (antes da ST). <br>
   * ICMSSN900: percentual de redução da BC do ICMS próprio em operações do Simples Nacional com CSOSN=900, quando a legislação estadual prever redução de base.
   */
  @RFWMetaBigDecimalField(caption = "Percentual de redução da BC do ICMS", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal predBC;
  /**
   * N16 - pICMS. Alíquota do imposto ICMS. <br>
   * Ocor.: ICMS00/ICMS20: 1–1 / Tam.: 3v2–4; ICMS51: 0–1 / Tam.: 3v2–4; demais conforme grupo. Tipo: N. <br>
   * ICMS00: alíquota do ICMS próprio. <br>
   * ICMS10: alíquota do ICMS próprio (sem incluir ICMS ST). <br>
   * ICMS20: alíquota do ICMS próprio sem o FCP, aplicada sobre a base reduzida. <br>
   * ICMS51: alíquota do ICMS da operação (sem FCP) para cálculo do ICMS da operação e do diferimento. <br>
   * ICMS70: alíquota do ICMS próprio aplicada sobre a base reduzida da operação com ST. <br>
   * ICMS90: alíquota do ICMS próprio nas operações do grupo “Outros”. <br>
   * ICMSSN900: alíquota do ICMS próprio em operações do Simples Nacional com CSOSN=900, utilizada na apuração do débito normal dentro do regime do Simples (quando aplicável).
   */
  @RFWMetaBigDecimalField(caption = "Alíquota do ICMS", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal picms;

  /**
   * N18 - modBCST. Modalidade de determinação da BC do ICMS ST. Ocor.: 1–1 / Tam.: 1 / Tipo: N. <br>
   * 0 = Preço tabelado ou máximo sugerido; <br>
   * 1 = Lista Negativa (valor); <br>
   * 2 = Lista Positiva (valor); <br>
   * 3 = Lista Neutra (valor); <br>
   * 4 = Margem Valor Agregado (%); <br>
   * 5 = Pauta (valor). <br>
   * Ver {@link SEFAZ_modBCST}. <br>
   * ICMS10: modalidade da BC ST em operações tributadas com ICMS e ICMS ST. <br>
   * ICMS30: modalidade da BC ST em operações isentas/não tributadas com ICMS ST. <br>
   * ICMS70: modalidade da BC do ICMS ST em operações com redução de BC e cobrança de ICMS ST. <br>
   * ICMS90: modalidade da BC do ICMS ST no grupo ICMS90 (quando houver ST). <br>
   * ICMSSN201: modalidade de determinação da BC do ICMS ST nas operações do Simples Nacional com CSOSN=201 (com crédito e ST). <br>
   * ICMSSN202: modalidade de determinação da BC do ICMS ST nas operações do Simples Nacional com CSOSN=202 ou 203 (sem crédito ou com isenção, ambas com ST). <br>
   * ICMSSN900: modalidade de determinação da BC do ICMS ST nas operações do Simples Nacional com CSOSN=900, quando houver incidência de substituição tributária.
   */
  @RFWMetaEnumField(caption = "Modalidade de determinação da BC do ICMS ST", required = false)
  private SEFAZ_modBCST modBCST;

  /**
   * N19 - pMVAST. Percentual da margem de valor adicionado do ICMS ST. <br>
   * Ocor.: 0–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * ICMS10: MVA utilizada para formação da BC do ICMS ST em operações tributadas com ST. <br>
   * ICMS30: MVA utilizada em operações isentas/não tributadas com ST. <br>
   * ICMS70: MVA aplicada na BC do ICMS ST em operações com redução de BC e ST. <br>
   * ICMS90: MVA em operações do grupo “Outros” quando houver ST. <br>
   * ICMSSN201: MVA utilizada na formação da BC do ICMS ST para operações do Simples Nacional com CSOSN=201. <br>
   * ICMSSN202: MVA utilizada na formação da BC do ICMS ST para operações do Simples Nacional com CSOSN=202 ou 203. <br>
   * ICMSSN900: MVA utilizada na formação da BC do ICMS ST em operações do Simples Nacional com CSOSN=900, quando houver ST.
   */
  @RFWMetaBigDecimalField(caption = "Percentual da MVA do ICMS ST", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal pmvaST;

  /**
   * N20 - pRedBCST. Percentual da redução da base de cálculo do ICMS ST. <br>
   * Ocor.: 0–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * ICMS10: redução aplicada sobre a BC do ICMS ST. <br>
   * ICMS30: redução da BC do ICMS ST em operações isentas/não tributadas com ST. <br>
   * ICMS70: redução da BC do ICMS ST em operações com redução de BC e ST. <br>
   * ICMS90: redução da BC do ICMS ST em operações do grupo “Outros” (quando aplicável). <br>
   * ICMSSN201: redução da BC do ICMS ST nas operações do Simples Nacional com CSOSN=201. <br>
   * ICMSSN202: redução da BC do ICMS ST nas operações do Simples Nacional com CSOSN=202 ou 203. <br>
   * ICMSSN900: redução da BC do ICMS ST nas operações do Simples Nacional com CSOSN=900, quando legislado pela UF.
   */
  @RFWMetaBigDecimalField(caption = "Percentual de redução da BC do ICMS ST", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal predBCST;

  /**
   * N21 - vBCST. Valor da base de cálculo do ICMS ST. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS10: BC do ICMS ST em operações tributadas com ST. <br>
   * ICMS30: BC do ICMS ST em operações isentas/não tributadas com ST. <br>
   * ICMS70: BC do ICMS ST em operações com redução de BC e ST. <br>
   * ICMS90: BC do ICMS ST no grupo ICMS90 (quando houver ST). <br>
   * ICMSSN201: BC do ICMS ST nas operações do Simples Nacional com CSOSN=201. <br>
   * ICMSSN202: BC do ICMS ST nas operações do Simples Nacional com CSOSN=202 ou 203. <br>
   * ICMSSN900: BC do ICMS ST nas operações do Simples Nacional com CSOSN=900 quando houver substituição tributária.
   */
  @RFWMetaBigDecimalField(caption = "Valor da BC do ICMS ST", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vbcST;

  /**
   * N22 - pICMSST. Alíquota do imposto do ICMS ST. Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * Alíquota do ICMS ST sem o FCP; quando houver FCP, informar a alíquota do FCP em pFCPST. <br>
   * ICMS10: alíquota do ICMS ST em operações tributadas com ST. <br>
   * ICMS30: alíquota do ICMS ST em operações isentas/não tributadas com ST. <br>
   * ICMS70: alíquota do ICMS ST em operações com redução de BC e ST. <br>
   * ICMS90: alíquota do ICMS ST no grupo ICMS90 (quando houver ST). <br>
   * ICMSSN201: alíquota do ICMS ST nas operações do Simples Nacional com CSOSN=201. <br>
   * ICMSSN202: alíquota do ICMS ST nas operações do Simples Nacional com CSOSN=202 ou 203. <br>
   * ICMSSN900: alíquota do ICMS ST nas operações do Simples Nacional com CSOSN=900, quando houver retenção ST para o item.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota do ICMS ST", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal picmsST;

  /**
   * N23 - vICMSST. Valor do ICMS ST. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS10: valor do ICMS ST retido. <br>
   * ICMS30: valor do ICMS ST em operações isentas/não tributadas com ST. <br>
   * ICMS70: valor do ICMS ST em operações com redução de BC e ST. <br>
   * ICMS90: valor do ICMS ST no grupo ICMS90 (quando houver ST). <br>
   * ICMSSN201: valor do ICMS ST retido nas operações do Simples Nacional com CSOSN=201. <br>
   * ICMSSN202: valor do ICMS ST retido nas operações do Simples Nacional com CSOSN=202 ou 203. <br>
   * ICMSSN900: valor do ICMS ST retido nas operações do Simples Nacional com CSOSN=900 sempre que houver substituição tributária aplicável ao item.
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS ST", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vicmsST;

  /**
   * N23a - vBCFCPST. Valor da base de cálculo do FCP retido por substituição tributária. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N (quando o grupo FCP ST estiver presente). <br>
   * ICMS10: base de cálculo do FCP-ST em operações tributadas com ST. <br>
   * ICMS30: base de cálculo do FCP-ST em operações isentas/não tributadas com ST. <br>
   * ICMS70: base de cálculo do FCP-ST em operações com redução de BC e ST. <br>
   * ICMS90: base de cálculo do FCP-ST no grupo ICMS90 (quando houver ST). <br>
   * ICMSSN201: base de cálculo do FCP-ST nas operações do Simples Nacional com CSOSN=201. <br>
   * ICMSSN202: base de cálculo do FCP-ST nas operações do Simples Nacional com CSOSN=202 ou 203. <br>
   * ICMSSN900: base de cálculo do FCP-ST nas operações do Simples Nacional com CSOSN=900, quando houver FCP retido por ST.
   */
  @RFWMetaBigDecimalField(caption = "Base de cálculo do FCP ST", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vbcFCPST;

  /**
   * N23b/N23c - pFCPST. Percentual do FCP retido por substituição tributária. <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * ICMS10: percentual do FCP-ST em operações tributadas com ST. <br>
   * ICMS30: percentual do FCP-ST em operações isentas/não tributadas com ST. <br>
   * ICMS70: percentual do FCP-ST em operações com redução de BC e ST. <br>
   * ICMS90: percentual do FCP-ST no grupo ICMS90 (quando houver ST). <br>
   * ICMSSN201: percentual do FCP-ST nas operações do Simples Nacional com CSOSN=201. <br>
   * ICMSSN202: percentual do FCP-ST nas operações do Simples Nacional com CSOSN=202 ou 203, respeitando o limite legal de FCP. <br>
   * ICMSSN900: percentual do FCP-ST nas operações do Simples Nacional com CSOSN=900, quando houver FCP retido por substituição tributária.
   */
  @RFWMetaBigDecimalField(caption = "Percentual FCP ST", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal pfcpST;

  /**
   * N23c/N23d - vFCPST. Valor do FCP retido por substituição tributária. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS10: valor do FCP-ST em operações tributadas com ST. <br>
   * ICMS30: valor do FCP-ST em operações isentas/não tributadas com ST. <br>
   * ICMS70: valor do FCP-ST em operações com redução de BC e ST. <br>
   * ICMS90: valor do FCP-ST no grupo ICMS90 (quando houver ST). <br>
   * ICMSSN201: valor do FCP-ST nas operações do Simples Nacional com CSOSN=201. <br>
   * ICMSSN202: valor do FCP-ST nas operações do Simples Nacional com CSOSN=202 ou 203. <br>
   * ICMSSN900: valor do FCP-ST nas operações do Simples Nacional com CSOSN=900, quando houver FCP retido por substituição tributária.
   */
  @RFWMetaBigDecimalField(caption = "Valor do FCP ST", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vfcpST;

  /**
   * N29 - pCredSN. Alíquota aplicável de cálculo do crédito (Simples Nacional). Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * ICMSSN101: alíquota utilizada para cálculo do crédito de ICMS permitido pelo art. 23 da LC 123/2006. <br>
   * ICMSSN201: alíquota de crédito nas operações do Simples Nacional com CSOSN=201 (com permissão de crédito e ICMS ST). <br>
   * ICMSSN900: alíquota de crédito aplicável nas operações do Simples Nacional com CSOSN=900, quando a legislação estadual permitir crédito de ICMS ao destinatário conforme art. 23 da LC 123.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota de crédito (Simples Nacional)", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal pcredSN;

  /**
   * N30 - vCredICMSSN. Valor do crédito do ICMS que pode ser aproveitado nos termos do art. 23 da LC 123/2006 (Simples Nacional). Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMSSN101: valor do crédito de ICMS calculado a partir de pCredSN e da base definida para o regime do Simples Nacional. <br>
   * ICMSSN201: valor de crédito de ICMS aproveitável em operações com CSOSN=201 (com crédito e ICMS ST), conforme pCredSN e legislação da UF. <br>
   * ICMSSN900: valor de crédito de ICMS em operações do Simples Nacional com CSOSN=900, quando a operação se enquadrar nas hipóteses de crédito previstas no art. 23 da LC 123/2006 e na legislação estadual.
   */
  @RFWMetaBigDecimalField(caption = "Valor do crédito de ICMS (Simples Nacional)", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vcredICMSSN;

  /**
   * N26 - vBCSTRet (ICMS60 / ICMSSN500). Valor da BC do ICMS ST retido. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS60: valor da base de cálculo do ICMS ST cobrado anteriormente por substituição tributária; pode ser omitido quando a legislação não exigir sua informação. <br>
   * ICMSSN500: valor da base de cálculo do ICMS ST cobrado anteriormente por substituição tributária ou por antecipação, na UF de origem, podendo ser omitido quando a legislação não exigir.
   */
  @RFWMetaBigDecimalField(caption = "BC do ICMS ST retido anteriormente", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vbcSTRet;

  /**
   * N26a - pST (ICMS60 / ICMSSN500). Alíquota suportada pelo consumidor final, utilizada no cálculo da retenção de ICMS ST. <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * Deve ser informada a alíquota efetiva usada na retenção, já incluindo o FCP quando aplicável. Exemplo: 18% + 2% FCP = 20%. <br>
   * ICMS60: alíquota efetiva da retenção de ICMS ST em operação anterior. <br>
   * ICMSSN500: alíquota efetiva suportada pelo consumidor final para cálculo do ICMS-ST cobrado anteriormente por substituição tributária ou antecipação.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota suportada pelo consumidor final (pST)", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal pst;

  /**
   * N26b - vICMSSubstituto (ICMS60 / ICMSSN500). Valor do ICMS próprio do Substituto cobrado em operação anterior. <br>
   * Ocor.: 0–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS60: valor do ICMS próprio do contribuinte substituto referente à retenção anterior. <br>
   * ICMSSN500: valor do ICMS próprio do substituto cobrado em operação anterior, em cenários de ICMS-ST já recolhido (substituído ou antecipado).
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS próprio do substituto", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vicmsSubstituto;

  /**
   * N27 - vICMSSTRet (ICMS60 / ICMSSN500). Valor do ICMS ST retido anteriormente. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS60: valor do ICMS ST cobrado anteriormente por substituição tributária; pode ser omitido se a legislação não exigir. <br>
   * ICMSSN500: valor do ICMS ST cobrado anteriormente por substituição tributária ou por antecipação, cujo destaque/repasse está sendo informado pelo contribuinte enquadrado no Simples Nacional.
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS ST retido anteriormente", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vicmsSTRet;

  /**
   * N27a - vBCFCPSTRet (ICMS60 / ICMSSN500). Valor da base de cálculo do FCP retido anteriormente por substituição tributária. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS60: valor da base do FCP-ST retido anteriormente. <br>
   * ICMSSN500: valor da base de cálculo do FCP relativo ao ICMS-ST retido anteriormente (substituição tributária ou antecipação) em operações do Simples Nacional com CSOSN=500.
   */
  @RFWMetaBigDecimalField(caption = "BC do FCP ST retido anteriormente", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vbcFCPSTRet;

  /**
   * N27b - pFCPSTRet (ICMS60 / ICMSSN500). Percentual do FCP retido anteriormente por substituição tributária. <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * ICMS60: percentual aplicado ao FCP-ST retido anteriormente. <br>
   * ICMSSN500: percentual do FCP-ST retido anteriormente em operações do Simples Nacional com CSOSN=500, normalmente limitado ao percentual máximo de FCP definido em lei.
   */
  @RFWMetaBigDecimalField(caption = "Percentual do FCP ST retido anteriormente", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal pfcpSTRet;

  /**
   * N27d - vFCPSTRet (ICMS60 / ICMSSN500). Valor do FCP retido anteriormente por substituição tributária. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS60: valor do ICMS relativo ao FCP-ST retido anteriormente. <br>
   * ICMSSN500: valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP) retido anteriormente por substituição tributária em operações do Simples Nacional (CSOSN=500).
   */
  @RFWMetaBigDecimalField(caption = "Valor do FCP ST retido anteriormente", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vfcpSTRet;

  /**
   * N34 - pRedBCEfet (ICMS60 / ICMSSN500). Percentual de redução da base de cálculo efetiva. <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. Campo opcional, a critério da UF. <br>
   * ICMS60: percentual de redução que seria aplicado caso o contribuinte estivesse no regime comum, para obtenção da base de cálculo efetiva (vBCEfet). <br>
   * ICMSSN500: percentual de redução da base de cálculo efetiva em operações do Simples Nacional com CSOSN=500, para fins de cálculo de ICMS efetivo em simulações de regime comum.
   */
  @RFWMetaBigDecimalField(caption = "Percentual de redução da BC efetiva (ICMS60 / ICMSSN500)", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal predBCEfet;

  /**
   * N35 - vBCEfet (ICMS60 / ICMSSN500). Valor da base de cálculo efetiva do ICMS. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. Campo opcional, a critério da UF. <br>
   * Fórmula sugerida: vBCEfet = vProd × (1 - pRedBCEfet). <br>
   * ICMS60: base de cálculo que seria utilizada caso a operação estivesse no regime comum. <br>
   * ICMSSN500: base de cálculo efetiva simulada para operações de contribuinte do Simples Nacional com CSOSN=500, considerando o regime comum (para cálculo de ICMS efetivo).
   */
  @RFWMetaBigDecimalField(caption = "Base de cálculo efetiva do ICMS (ICMS60 / ICMSSN500)", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vbcEfet;

  /**
   * N36 - pICMSEfet (ICMS60 / ICMSSN500). Alíquota efetiva do ICMS. <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. Campo opcional, a critério da UF. <br>
   * ICMS60: alíquota que seria aplicada no regime comum para obtenção do ICMS efetivo. <br>
   * ICMSSN500: alíquota efetiva do ICMS em operações do Simples Nacional com CSOSN=500, simulando a tributação no regime comum para cálculo de vICMSEfet.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota efetiva do ICMS (ICMS60 / ICMSSN500)", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal picmsEfet;

  /**
   * N37 - vICMSEfet (ICMS60 / ICMSSN500). Valor do ICMS efetivo. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. Campo opcional, a critério da UF. <br>
   * Fórmula sugerida: vICMSEfet = vBCEfet × pICMSEfet. <br>
   * ICMS60: valor do ICMS efetivo que seria devido no regime comum, calculado a partir da base e alíquota efetivas. <br>
   * ICMSSN500: valor do ICMS efetivo estimado para operações do Simples Nacional com CSOSN=500, considerando o cenário de regime comum (usado para controles e análises fiscais específicas definidas pela UF).
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS efetivo (ICMS60 / ICMSSN500)", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vicmsEfet;

  /**
   * N17c - vFCP. Valor do Fundo de Combate à Pobreza (FCP). Ocor.: 1–1 / Tam.: 13v2 / Tipo: N (quando o grupo FCP estiver presente). <br>
   * ICMS00: valor do FCP relativo ao ICMS próprio. <br>
   * ICMS10: valor do FCP relativo ao ICMS próprio (quando aplicável). <br>
   * ICMS20: valor do FCP calculado sobre a base de cálculo do FCP do ICMS com redução de BC. <br>
   * ICMS51: valor do FCP relativo à operação com diferimento (quando aplicável). <br>
   * ICMS70: valor do FCP relativo ao ICMS próprio em operação com redução de BC e ST. <br>
   * ICMS90: valor do FCP relativo ao ICMS próprio no grupo ICMS90.
   */
  @RFWMetaBigDecimalField(caption = "Valor do FCP", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vfcp;

  /**
   * N28a - vICMSDeson (ICMS20, ICMS30, ICMS40, ICMS70, ICMS90). Valor do ICMS desonerado. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS20: valor do ICMS desonerado conforme motivo de desoneração. <br>
   * ICMS30: valor do ICMS desonerado aplicado a operações isentas/não tributadas com ICMS ST. <br>
   * ICMS40: valor do ICMS que seria devido se não houvesse isenção/não tributação/suspensão, de acordo com o motivo de desoneração informado. <br>
   * ICMS70: valor do ICMS desonerado em operações com redução de BC e ICMS ST, conforme motivo informado em motDesICMS. <br>
   * ICMS90: valor do ICMS desonerado nas operações “Outros”, quando houver motivo de desoneração informado.
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS desonerado", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vicmsDeson;
  /**
   * N28 - motDesICMS (ICMS20, ICMS30, ICMS40, ICMS70, ICMS90). Motivo da desoneração do ICMS. Ver {@link SEFAZ_motDesICMS}. <br>
   * ICMS20: motivos de desoneração aplicáveis às operações com redução de BC. <br>
   * ICMS30: motivos aplicáveis às operações isentas/não tributadas com ICMS ST. <br>
   * ICMS40: motivos aplicáveis às operações isentas, não tributadas ou com suspensão (incluindo SUFRAMA, venda a órgão público, Olimpíadas Rio 2016, solicitado pelo Fisco, etc.). <br>
   * ICMS70: motivos de desoneração aplicáveis ao grupo ICMS70, utilizando os códigos 1, 3, 4, 5, 6, 7, 8, 9, 10, 11 e 12 conforme tabela do MOC. <br>
   * ICMS90: motivos de desoneração aplicáveis ao grupo ICMS90, utilizando os códigos 3 (Uso na agropecuária), 9 (Outros) e 12 (Órgão de fomento e desenvolvimento agropecuário).
   */
  @RFWMetaEnumField(caption = "Motivo da desoneração do ICMS", required = false)
  private SEFAZ_motDesICMS motDesICMS;

  /**
   * N12 - CST. Tributação do ICMS. Ocor.: 1–1 / Tam.: 2 / Tipo: N. Ver valores em {@link SEFAZ_CST_ICMS}. <br>
   * ICMS00: CST = 00 – Tributado integralmente. <br>
   * ICMS10: CST = 10 – Tributado e com cobrança do ICMS por substituição tributária. <br>
   * ICMS20: CST = 20 – Com redução da base de cálculo. <br>
   * ICMS30: CST = 30 – Isenta ou não tributada e com cobrança do ICMS por substituição tributária. <br>
   * ICMS40: CST = 40 (Isenta), 41 (Não tributada) ou 50 (Suspensão). <br>
   * ICMS51: CST = 51 – Diferimento. <br>
   * ICMS60: CST = 60 – ICMS cobrado anteriormente por substituição tributária. <br>
   * ICMS70: CST = 70 – Com redução de base de cálculo e cobrança do ICMS por substituição tributária. <br>
   * ICMS90: CST = 90 – Outros.
   */
  @RFWMetaEnumField(caption = "CST do ICMS", required = false)
  private SEFAZ_CST_ICMS cst;

  /**
   * N16a - vICMSOp (ICMS51). Valor do ICMS da operação como se não houvesse diferimento. Ocor.: 0–1 / Tam.: 13v2 / Tipo: N.
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS da operação", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vicmsOp;

  /**
   * N16b - pDif (ICMS51). Percentual do diferimento. No caso de diferimento total, informar “100”. Ocor.: 0–1 / Tam.: 3v2–4 / Tipo: N.
   */
  @RFWMetaBigDecimalField(caption = "Percentual do diferimento", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal pdif;

  /**
   * N16c - vICMSDif (ICMS51). Valor do ICMS diferido. Ocor.: 0–1 / Tam.: 13v2 / Tipo: N.
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS diferido", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vicmsDif;

  /**
   * N17 - vICMS. Valor do ICMS. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS00: valor do ICMS próprio devido. <br>
   * ICMS10: valor do ICMS próprio (sem considerar o ICMS ST). <br>
   * ICMS20: valor do ICMS calculado sobre a base reduzida. <br>
   * ICMS51: valor do ICMS realmente devido após o diferimento (por exemplo, vICMSOp - vICMSDif, conforme regra da UF). <br>
   * ICMS70: valor do ICMS próprio calculado sobre a BC reduzida (antes da ST). <br>
   * ICMS90: valor do ICMS próprio devido no grupo ICMS90 (Tributação “Outros”).
   */
  @RFWMetaBigDecimalField(caption = "Valor do ICMS", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vicms;

  /**
   * N17a/N17b (ICMS10, ICMS20, ICMS51, ICMS70, ICMS90) - vBCFCP. Valor da Base de Cálculo do FCP. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N (quando o grupo FCP estiver presente). <br>
   * ICMS10: valor da base de cálculo do FCP do ICMS próprio. <br>
   * ICMS20: valor da base de cálculo do FCP em operações com redução de BC. <br>
   * ICMS51: base de cálculo do FCP nas operações com diferimento (quando exigido pela UF). <br>
   * ICMS70: base de cálculo do FCP relativo ao ICMS próprio em operação com redução de BC e ST. <br>
   * ICMS90: base de cálculo do FCP relativo ao ICMS próprio no grupo ICMS90.
   */
  @RFWMetaBigDecimalField(caption = "Base de cálculo do FCP", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vbcFCP;

  /**
   * N17b - pFCP. Percentual do ICMS relativo ao Fundo de Combate à Pobreza (FCP). <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N (quando o grupo FCP estiver presente). <br>
   * ICMS00: percentual aplicado sobre a BC do ICMS para cálculo do FCP. <br>
   * ICMS10: percentual aplicado sobre vBCFCP e/ou vBCFCPST, conforme o caso. <br>
   * ICMS20: percentual aplicado sobre a base de cálculo do FCP em operações com redução de BC. <br>
   * ICMS51: percentual do FCP aplicado sobre a base de cálculo do FCP na operação com diferimento. <br>
   * ICMS70: percentual do FCP relativo ao ICMS próprio em operação com redução de BC e ST. <br>
   * ICMS90: percentual do FCP relativo ao ICMS próprio em operações “Outros”.
   */
  @RFWMetaBigDecimalField(caption = "Percentual FCP", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal pfcp;

  /**
   * # {@link SEFAZICMSSTVO}.
   *
   * @return the {@link SEFAZICMSSTVO}
   */
  public SEFAZICMSSTVO getIcmsSTVO() {
    return icmsSTVO;
  }

  /**
   * # {@link SEFAZICMSSTVO}.
   *
   * @param icmsSTVO the new {@link SEFAZICMSSTVO}
   */
  public void setIcmsSTVO(SEFAZICMSSTVO icmsSTVO) {
    this.icmsSTVO = icmsSTVO;
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

  /**
   * # {@link SEFAZICMSPartVO}.
   *
   * @return the {@link SEFAZICMSPartVO}
   */
  public SEFAZICMSPartVO getIcmsPartVO() {
    return icmsPartVO;
  }

  /**
   * # {@link SEFAZICMSPartVO}.
   *
   * @param icmsPartVO the new {@link SEFAZICMSPartVO}
   */
  public void setIcmsPartVO(SEFAZICMSPartVO icmsPartVO) {
    this.icmsPartVO = icmsPartVO;
  }

  /**
   * # n11 - orig. Origem da mercadoria. Ocor.: 1–1 / Tam.: 1 / Tipo: N. Ver valores em {@link SEFAZ_orig}. <br>
   * ICMS00: origem da mercadoria para operações tributadas integralmente. <br>
   * ICMS10: origem da mercadoria para operações tributadas com ICMS e ICMS ST. <br>
   * ICMS20: origem da mercadoria para operações com redução de base de cálculo. <br>
   * ICMS30: origem da mercadoria para operações isentas/não tributadas com cobrança de ICMS ST. <br>
   * ICMS40: origem da mercadoria para operações isentas, não tributadas ou com suspensão de ICMS. <br>
   * ICMS51: origem da mercadoria para operações com diferimento do ICMS. <br>
   * ICMS60: origem da mercadoria em operações com ICMS cobrado anteriormente por ST. <br>
   * ICMS70: origem da mercadoria em operações com redução de BC e cobrança de ICMS ST. <br>
   * ICMS90: origem da mercadoria em operações enquadradas no grupo “Outros” (CST 90). <br>
   * ICMSSN101: origem da mercadoria em operações do Simples Nacional com CSOSN=101. <br>
   * ICMSSN102: origem da mercadoria em operações do Simples Nacional com CSOSN=102, 103, 300 ou 400. <br>
   * ICMSSN201: origem da mercadoria em operações do Simples Nacional com CSOSN=201 (permite crédito e tem ICMS ST). <br>
   * ICMSSN202: origem da mercadoria em operações do Simples Nacional com CSOSN=202 ou 203 (sem crédito ou com isenção, ambas com ST). <br>
   * ICMSSN500: origem da mercadoria em operações do Simples Nacional com CSOSN=500, nas quais o ICMS foi cobrado anteriormente por substituição tributária ou antecipação. <br>
   * ICMSSN900: origem da mercadoria em operações do Simples Nacional enquadradas como “Outros” (CSOSN=900), tanto para ICMS próprio quanto, quando aplicável, para ICMS ST.
   *
   * @return the n11 - orig
   */
  public SEFAZ_orig getOrig() {
    return orig;
  }

  /**
   * # n11 - orig. Origem da mercadoria. Ocor.: 1–1 / Tam.: 1 / Tipo: N. Ver valores em {@link SEFAZ_orig}. <br>
   * ICMS00: origem da mercadoria para operações tributadas integralmente. <br>
   * ICMS10: origem da mercadoria para operações tributadas com ICMS e ICMS ST. <br>
   * ICMS20: origem da mercadoria para operações com redução de base de cálculo. <br>
   * ICMS30: origem da mercadoria para operações isentas/não tributadas com cobrança de ICMS ST. <br>
   * ICMS40: origem da mercadoria para operações isentas, não tributadas ou com suspensão de ICMS. <br>
   * ICMS51: origem da mercadoria para operações com diferimento do ICMS. <br>
   * ICMS60: origem da mercadoria em operações com ICMS cobrado anteriormente por ST. <br>
   * ICMS70: origem da mercadoria em operações com redução de BC e cobrança de ICMS ST. <br>
   * ICMS90: origem da mercadoria em operações enquadradas no grupo “Outros” (CST 90). <br>
   * ICMSSN101: origem da mercadoria em operações do Simples Nacional com CSOSN=101. <br>
   * ICMSSN102: origem da mercadoria em operações do Simples Nacional com CSOSN=102, 103, 300 ou 400. <br>
   * ICMSSN201: origem da mercadoria em operações do Simples Nacional com CSOSN=201 (permite crédito e tem ICMS ST). <br>
   * ICMSSN202: origem da mercadoria em operações do Simples Nacional com CSOSN=202 ou 203 (sem crédito ou com isenção, ambas com ST). <br>
   * ICMSSN500: origem da mercadoria em operações do Simples Nacional com CSOSN=500, nas quais o ICMS foi cobrado anteriormente por substituição tributária ou antecipação. <br>
   * ICMSSN900: origem da mercadoria em operações do Simples Nacional enquadradas como “Outros” (CSOSN=900), tanto para ICMS próprio quanto, quando aplicável, para ICMS ST.
   *
   * @param orig the new n11 - orig
   */
  public void setOrig(SEFAZ_orig orig) {
    this.orig = orig;
  }

  /**
   * # n12a - CSOSN. Código de Situação da Operação – Simples Nacional. Ocor.: 1–1 / Tam.: 3 / Tipo: N. <br>
   * ICMSSN101: CSOSN = 101 – Tributada pelo Simples Nacional com permissão de crédito. <br>
   * ICMSSN102: CSOSN = 102 – Tributada pelo Simples Nacional sem permissão de crédito. <br>
   * ICMSSN102: CSOSN = 103 – Isenção do ICMS no Simples Nacional para faixa de receita bruta. <br>
   * ICMSSN102: CSOSN = 300 – Imune. <br>
   * ICMSSN102: CSOSN = 400 – Não tributada pelo Simples Nacional. <br>
   * ICMSSN201: CSOSN = 201 – Tributada pelo Simples Nacional com permissão de crédito e com cobrança do ICMS por substituição tributária. <br>
   * ICMSSN202: CSOSN = 202 – Tributada pelo Simples Nacional sem permissão de crédito e com cobrança do ICMS por substituição tributária. <br>
   * ICMSSN202: CSOSN = 203 – Isenção do ICMS no Simples Nacional para faixa de receita bruta e com cobrança do ICMS por substituição tributária. <br>
   * ICMSSN500: CSOSN = 500 – ICMS cobrado anteriormente por substituição tributária (substituído) ou por antecipação. <br>
   * ICMSSN900: CSOSN = 900 – Outros, para operações do Simples Nacional com regras específicas de ICMS próprio, redução de base, ST e crédito conforme a legislação estadual. <br>
   * Mapeado para {@link SEFAZ_CSOSN}. Outros códigos poderão ser utilizados por outros grupos ICMSSN* conforme forem implementados.
   *
   * @return the n12a - CSOSN
   */
  public SEFAZ_CSOSN getCsosn() {
    return csosn;
  }

  /**
   * # n12a - CSOSN. Código de Situação da Operação – Simples Nacional. Ocor.: 1–1 / Tam.: 3 / Tipo: N. <br>
   * ICMSSN101: CSOSN = 101 – Tributada pelo Simples Nacional com permissão de crédito. <br>
   * ICMSSN102: CSOSN = 102 – Tributada pelo Simples Nacional sem permissão de crédito. <br>
   * ICMSSN102: CSOSN = 103 – Isenção do ICMS no Simples Nacional para faixa de receita bruta. <br>
   * ICMSSN102: CSOSN = 300 – Imune. <br>
   * ICMSSN102: CSOSN = 400 – Não tributada pelo Simples Nacional. <br>
   * ICMSSN201: CSOSN = 201 – Tributada pelo Simples Nacional com permissão de crédito e com cobrança do ICMS por substituição tributária. <br>
   * ICMSSN202: CSOSN = 202 – Tributada pelo Simples Nacional sem permissão de crédito e com cobrança do ICMS por substituição tributária. <br>
   * ICMSSN202: CSOSN = 203 – Isenção do ICMS no Simples Nacional para faixa de receita bruta e com cobrança do ICMS por substituição tributária. <br>
   * ICMSSN500: CSOSN = 500 – ICMS cobrado anteriormente por substituição tributária (substituído) ou por antecipação. <br>
   * ICMSSN900: CSOSN = 900 – Outros, para operações do Simples Nacional com regras específicas de ICMS próprio, redução de base, ST e crédito conforme a legislação estadual. <br>
   * Mapeado para {@link SEFAZ_CSOSN}. Outros códigos poderão ser utilizados por outros grupos ICMSSN* conforme forem implementados.
   *
   * @param csosn the new n12a - CSOSN
   */
  public void setCsosn(SEFAZ_CSOSN csosn) {
    this.csosn = csosn;
  }

  /**
   * # n13 - modBC. Modalidade de determinação da BC do ICMS. 0 = Margem Valor Agregado (%); 1 = Pauta (valor); 2 = Preço tabelado máximo (valor); 3 = Valor da operação. Ocor.: 1–1 (ou 0–1 no ICMS51) / Tam.: 1 / Tipo: N. Ver valores em {@link SEFAZ_modBC}. <br>
   * ICMS00: modalidade para cálculo da BC do ICMS próprio. <br>
   * ICMS10: modalidade para cálculo da BC do ICMS próprio (antes da ST). <br>
   * ICMS20: modalidade para cálculo da BC do ICMS em operações com redução de BC. <br>
   * ICMS51: modalidade da BC do ICMS em operações com diferimento (campo opcional, a critério da UF). <br>
   * ICMS70: modalidade para cálculo da BC do ICMS próprio em operação com redução de BC e com ST. <br>
   * ICMS90: modalidade para cálculo da BC do ICMS próprio em operações enquadradas como “Outros”. <br>
   * ICMSSN900: modalidade para determinação da BC do ICMS próprio em operações do Simples Nacional com CSOSN=900, seguindo as mesmas modalidades 0–3 previstas no MOC.
   *
   * @return the n13 - modBC
   */
  public SEFAZ_modBC getModBC() {
    return modBC;
  }

  /**
   * # n13 - modBC. Modalidade de determinação da BC do ICMS. 0 = Margem Valor Agregado (%); 1 = Pauta (valor); 2 = Preço tabelado máximo (valor); 3 = Valor da operação. Ocor.: 1–1 (ou 0–1 no ICMS51) / Tam.: 1 / Tipo: N. Ver valores em {@link SEFAZ_modBC}. <br>
   * ICMS00: modalidade para cálculo da BC do ICMS próprio. <br>
   * ICMS10: modalidade para cálculo da BC do ICMS próprio (antes da ST). <br>
   * ICMS20: modalidade para cálculo da BC do ICMS em operações com redução de BC. <br>
   * ICMS51: modalidade da BC do ICMS em operações com diferimento (campo opcional, a critério da UF). <br>
   * ICMS70: modalidade para cálculo da BC do ICMS próprio em operação com redução de BC e com ST. <br>
   * ICMS90: modalidade para cálculo da BC do ICMS próprio em operações enquadradas como “Outros”. <br>
   * ICMSSN900: modalidade para determinação da BC do ICMS próprio em operações do Simples Nacional com CSOSN=900, seguindo as mesmas modalidades 0–3 previstas no MOC.
   *
   * @param modBC the new n13 - modBC
   */
  public void setModBC(SEFAZ_modBC modBC) {
    this.modBC = modBC;
  }

  /**
   * # n15 - vBC. Valor da base de cálculo do ICMS. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS00: valor da BC do ICMS próprio. <br>
   * ICMS10: valor da BC do ICMS próprio (antes da substituição tributária). <br>
   * ICMS20: valor da BC do ICMS após a aplicação da redução de base de cálculo. <br>
   * ICMS51: valor da BC do ICMS utilizada para cálculo do ICMS da operação com diferimento. <br>
   * ICMS70: valor da BC do ICMS próprio, já considerando a redução de base de cálculo. <br>
   * ICMS90: valor da BC do ICMS próprio nas operações do grupo “Outros”. <br>
   * ICMSSN900: valor da BC do ICMS próprio nas operações do Simples Nacional com CSOSN=900, de acordo com a modalidade de cálculo definida em modBC.
   *
   * @return the n15 - vBC
   */
  public BigDecimal getVbc() {
    return vbc;
  }

  /**
   * # n15 - vBC. Valor da base de cálculo do ICMS. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS00: valor da BC do ICMS próprio. <br>
   * ICMS10: valor da BC do ICMS próprio (antes da substituição tributária). <br>
   * ICMS20: valor da BC do ICMS após a aplicação da redução de base de cálculo. <br>
   * ICMS51: valor da BC do ICMS utilizada para cálculo do ICMS da operação com diferimento. <br>
   * ICMS70: valor da BC do ICMS próprio, já considerando a redução de base de cálculo. <br>
   * ICMS90: valor da BC do ICMS próprio nas operações do grupo “Outros”. <br>
   * ICMSSN900: valor da BC do ICMS próprio nas operações do Simples Nacional com CSOSN=900, de acordo com a modalidade de cálculo definida em modBC.
   *
   * @param vbc the new n15 - vBC
   */
  public void setVbc(BigDecimal vbc) {
    this.vbc = vbc;
  }

  /**
   * # n14 (ICMS20 / ICMS51 / ICMS70 / ICMSSN900) - pRedBC. Percentual de redução da base de cálculo do ICMS. <br>
   * Ocor.: ICMS20: 1–1 / Tam.: 3v2–4; ICMS51: 0–1 / Tam.: 3v2–4; demais conforme a UF. Tipo: N. <br>
   * ICMS20: percentual de redução da BC do ICMS. <br>
   * ICMS51: percentual de redução da BC do ICMS quando aplicável ao diferimento. <br>
   * ICMS70: percentual de redução da BC do ICMS próprio (antes da ST). <br>
   * ICMSSN900: percentual de redução da BC do ICMS próprio em operações do Simples Nacional com CSOSN=900, quando a legislação estadual prever redução de base.
   *
   * @return the n14 (ICMS20 / ICMS51 / ICMS70 / ICMSSN900) - pRedBC
   */
  public BigDecimal getPredBC() {
    return predBC;
  }

  /**
   * # n14 (ICMS20 / ICMS51 / ICMS70 / ICMSSN900) - pRedBC. Percentual de redução da base de cálculo do ICMS. <br>
   * Ocor.: ICMS20: 1–1 / Tam.: 3v2–4; ICMS51: 0–1 / Tam.: 3v2–4; demais conforme a UF. Tipo: N. <br>
   * ICMS20: percentual de redução da BC do ICMS. <br>
   * ICMS51: percentual de redução da BC do ICMS quando aplicável ao diferimento. <br>
   * ICMS70: percentual de redução da BC do ICMS próprio (antes da ST). <br>
   * ICMSSN900: percentual de redução da BC do ICMS próprio em operações do Simples Nacional com CSOSN=900, quando a legislação estadual prever redução de base.
   *
   * @param predBC the new n14 (ICMS20 / ICMS51 / ICMS70 / ICMSSN900) - pRedBC
   */
  public void setPredBC(BigDecimal predBC) {
    this.predBC = predBC;
  }

  /**
   * # n16 - pICMS. Alíquota do imposto ICMS. <br>
   * Ocor.: ICMS00/ICMS20: 1–1 / Tam.: 3v2–4; ICMS51: 0–1 / Tam.: 3v2–4; demais conforme grupo. Tipo: N. <br>
   * ICMS00: alíquota do ICMS próprio. <br>
   * ICMS10: alíquota do ICMS próprio (sem incluir ICMS ST). <br>
   * ICMS20: alíquota do ICMS próprio sem o FCP, aplicada sobre a base reduzida. <br>
   * ICMS51: alíquota do ICMS da operação (sem FCP) para cálculo do ICMS da operação e do diferimento. <br>
   * ICMS70: alíquota do ICMS próprio aplicada sobre a base reduzida da operação com ST. <br>
   * ICMS90: alíquota do ICMS próprio nas operações do grupo “Outros”. <br>
   * ICMSSN900: alíquota do ICMS próprio em operações do Simples Nacional com CSOSN=900, utilizada na apuração do débito normal dentro do regime do Simples (quando aplicável).
   *
   * @return the n16 - pICMS
   */
  public BigDecimal getPicms() {
    return picms;
  }

  /**
   * # n16 - pICMS. Alíquota do imposto ICMS. <br>
   * Ocor.: ICMS00/ICMS20: 1–1 / Tam.: 3v2–4; ICMS51: 0–1 / Tam.: 3v2–4; demais conforme grupo. Tipo: N. <br>
   * ICMS00: alíquota do ICMS próprio. <br>
   * ICMS10: alíquota do ICMS próprio (sem incluir ICMS ST). <br>
   * ICMS20: alíquota do ICMS próprio sem o FCP, aplicada sobre a base reduzida. <br>
   * ICMS51: alíquota do ICMS da operação (sem FCP) para cálculo do ICMS da operação e do diferimento. <br>
   * ICMS70: alíquota do ICMS próprio aplicada sobre a base reduzida da operação com ST. <br>
   * ICMS90: alíquota do ICMS próprio nas operações do grupo “Outros”. <br>
   * ICMSSN900: alíquota do ICMS próprio em operações do Simples Nacional com CSOSN=900, utilizada na apuração do débito normal dentro do regime do Simples (quando aplicável).
   *
   * @param picms the new n16 - pICMS
   */
  public void setPicms(BigDecimal picms) {
    this.picms = picms;
  }

  /**
   * # n18 - modBCST. Modalidade de determinação da BC do ICMS ST. Ocor.: 1–1 / Tam.: 1 / Tipo: N. <br>
   * 0 = Preço tabelado ou máximo sugerido; <br>
   * 1 = Lista Negativa (valor); <br>
   * 2 = Lista Positiva (valor); <br>
   * 3 = Lista Neutra (valor); <br>
   * 4 = Margem Valor Agregado (%); <br>
   * 5 = Pauta (valor). <br>
   * Ver {@link SEFAZ_modBCST}. <br>
   * ICMS10: modalidade da BC ST em operações tributadas com ICMS e ICMS ST. <br>
   * ICMS30: modalidade da BC ST em operações isentas/não tributadas com ICMS ST. <br>
   * ICMS70: modalidade da BC do ICMS ST em operações com redução de BC e cobrança de ICMS ST. <br>
   * ICMS90: modalidade da BC do ICMS ST no grupo ICMS90 (quando houver ST). <br>
   * ICMSSN201: modalidade de determinação da BC do ICMS ST nas operações do Simples Nacional com CSOSN=201 (com crédito e ST). <br>
   * ICMSSN202: modalidade de determinação da BC do ICMS ST nas operações do Simples Nacional com CSOSN=202 ou 203 (sem crédito ou com isenção, ambas com ST). <br>
   * ICMSSN900: modalidade de determinação da BC do ICMS ST nas operações do Simples Nacional com CSOSN=900, quando houver incidência de substituição tributária.
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
   * Ver {@link SEFAZ_modBCST}. <br>
   * ICMS10: modalidade da BC ST em operações tributadas com ICMS e ICMS ST. <br>
   * ICMS30: modalidade da BC ST em operações isentas/não tributadas com ICMS ST. <br>
   * ICMS70: modalidade da BC do ICMS ST em operações com redução de BC e cobrança de ICMS ST. <br>
   * ICMS90: modalidade da BC do ICMS ST no grupo ICMS90 (quando houver ST). <br>
   * ICMSSN201: modalidade de determinação da BC do ICMS ST nas operações do Simples Nacional com CSOSN=201 (com crédito e ST). <br>
   * ICMSSN202: modalidade de determinação da BC do ICMS ST nas operações do Simples Nacional com CSOSN=202 ou 203 (sem crédito ou com isenção, ambas com ST). <br>
   * ICMSSN900: modalidade de determinação da BC do ICMS ST nas operações do Simples Nacional com CSOSN=900, quando houver incidência de substituição tributária.
   *
   * @param modBCST the new n18 - modBCST
   */
  public void setModBCST(SEFAZ_modBCST modBCST) {
    this.modBCST = modBCST;
  }

  /**
   * # n19 - pMVAST. Percentual da margem de valor adicionado do ICMS ST. <br>
   * Ocor.: 0–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * ICMS10: MVA utilizada para formação da BC do ICMS ST em operações tributadas com ST. <br>
   * ICMS30: MVA utilizada em operações isentas/não tributadas com ST. <br>
   * ICMS70: MVA aplicada na BC do ICMS ST em operações com redução de BC e ST. <br>
   * ICMS90: MVA em operações do grupo “Outros” quando houver ST. <br>
   * ICMSSN201: MVA utilizada na formação da BC do ICMS ST para operações do Simples Nacional com CSOSN=201. <br>
   * ICMSSN202: MVA utilizada na formação da BC do ICMS ST para operações do Simples Nacional com CSOSN=202 ou 203. <br>
   * ICMSSN900: MVA utilizada na formação da BC do ICMS ST em operações do Simples Nacional com CSOSN=900, quando houver ST.
   *
   * @return the n19 - pMVAST
   */
  public BigDecimal getPmvaST() {
    return pmvaST;
  }

  /**
   * # n19 - pMVAST. Percentual da margem de valor adicionado do ICMS ST. <br>
   * Ocor.: 0–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * ICMS10: MVA utilizada para formação da BC do ICMS ST em operações tributadas com ST. <br>
   * ICMS30: MVA utilizada em operações isentas/não tributadas com ST. <br>
   * ICMS70: MVA aplicada na BC do ICMS ST em operações com redução de BC e ST. <br>
   * ICMS90: MVA em operações do grupo “Outros” quando houver ST. <br>
   * ICMSSN201: MVA utilizada na formação da BC do ICMS ST para operações do Simples Nacional com CSOSN=201. <br>
   * ICMSSN202: MVA utilizada na formação da BC do ICMS ST para operações do Simples Nacional com CSOSN=202 ou 203. <br>
   * ICMSSN900: MVA utilizada na formação da BC do ICMS ST em operações do Simples Nacional com CSOSN=900, quando houver ST.
   *
   * @param pmvaST the new n19 - pMVAST
   */
  public void setPmvaST(BigDecimal pmvaST) {
    this.pmvaST = pmvaST;
  }

  /**
   * # n20 - pRedBCST. Percentual da redução da base de cálculo do ICMS ST. <br>
   * Ocor.: 0–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * ICMS10: redução aplicada sobre a BC do ICMS ST. <br>
   * ICMS30: redução da BC do ICMS ST em operações isentas/não tributadas com ST. <br>
   * ICMS70: redução da BC do ICMS ST em operações com redução de BC e ST. <br>
   * ICMS90: redução da BC do ICMS ST em operações do grupo “Outros” (quando aplicável). <br>
   * ICMSSN201: redução da BC do ICMS ST nas operações do Simples Nacional com CSOSN=201. <br>
   * ICMSSN202: redução da BC do ICMS ST nas operações do Simples Nacional com CSOSN=202 ou 203. <br>
   * ICMSSN900: redução da BC do ICMS ST nas operações do Simples Nacional com CSOSN=900, quando legislado pela UF.
   *
   * @return the n20 - pRedBCST
   */
  public BigDecimal getPredBCST() {
    return predBCST;
  }

  /**
   * # n20 - pRedBCST. Percentual da redução da base de cálculo do ICMS ST. <br>
   * Ocor.: 0–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * ICMS10: redução aplicada sobre a BC do ICMS ST. <br>
   * ICMS30: redução da BC do ICMS ST em operações isentas/não tributadas com ST. <br>
   * ICMS70: redução da BC do ICMS ST em operações com redução de BC e ST. <br>
   * ICMS90: redução da BC do ICMS ST em operações do grupo “Outros” (quando aplicável). <br>
   * ICMSSN201: redução da BC do ICMS ST nas operações do Simples Nacional com CSOSN=201. <br>
   * ICMSSN202: redução da BC do ICMS ST nas operações do Simples Nacional com CSOSN=202 ou 203. <br>
   * ICMSSN900: redução da BC do ICMS ST nas operações do Simples Nacional com CSOSN=900, quando legislado pela UF.
   *
   * @param predBCST the new n20 - pRedBCST
   */
  public void setPredBCST(BigDecimal predBCST) {
    this.predBCST = predBCST;
  }

  /**
   * # n21 - vBCST. Valor da base de cálculo do ICMS ST. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS10: BC do ICMS ST em operações tributadas com ST. <br>
   * ICMS30: BC do ICMS ST em operações isentas/não tributadas com ST. <br>
   * ICMS70: BC do ICMS ST em operações com redução de BC e ST. <br>
   * ICMS90: BC do ICMS ST no grupo ICMS90 (quando houver ST). <br>
   * ICMSSN201: BC do ICMS ST nas operações do Simples Nacional com CSOSN=201. <br>
   * ICMSSN202: BC do ICMS ST nas operações do Simples Nacional com CSOSN=202 ou 203. <br>
   * ICMSSN900: BC do ICMS ST nas operações do Simples Nacional com CSOSN=900 quando houver substituição tributária.
   *
   * @return the n21 - vBCST
   */
  public BigDecimal getVbcST() {
    return vbcST;
  }

  /**
   * # n21 - vBCST. Valor da base de cálculo do ICMS ST. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS10: BC do ICMS ST em operações tributadas com ST. <br>
   * ICMS30: BC do ICMS ST em operações isentas/não tributadas com ST. <br>
   * ICMS70: BC do ICMS ST em operações com redução de BC e ST. <br>
   * ICMS90: BC do ICMS ST no grupo ICMS90 (quando houver ST). <br>
   * ICMSSN201: BC do ICMS ST nas operações do Simples Nacional com CSOSN=201. <br>
   * ICMSSN202: BC do ICMS ST nas operações do Simples Nacional com CSOSN=202 ou 203. <br>
   * ICMSSN900: BC do ICMS ST nas operações do Simples Nacional com CSOSN=900 quando houver substituição tributária.
   *
   * @param vbcST the new n21 - vBCST
   */
  public void setVbcST(BigDecimal vbcST) {
    this.vbcST = vbcST;
  }

  /**
   * # n22 - pICMSST. Alíquota do imposto do ICMS ST. Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * Alíquota do ICMS ST sem o FCP; quando houver FCP, informar a alíquota do FCP em pFCPST. <br>
   * ICMS10: alíquota do ICMS ST em operações tributadas com ST. <br>
   * ICMS30: alíquota do ICMS ST em operações isentas/não tributadas com ST. <br>
   * ICMS70: alíquota do ICMS ST em operações com redução de BC e ST. <br>
   * ICMS90: alíquota do ICMS ST no grupo ICMS90 (quando houver ST). <br>
   * ICMSSN201: alíquota do ICMS ST nas operações do Simples Nacional com CSOSN=201. <br>
   * ICMSSN202: alíquota do ICMS ST nas operações do Simples Nacional com CSOSN=202 ou 203. <br>
   * ICMSSN900: alíquota do ICMS ST nas operações do Simples Nacional com CSOSN=900, quando houver retenção ST para o item.
   *
   * @return the n22 - pICMSST
   */
  public BigDecimal getPicmsST() {
    return picmsST;
  }

  /**
   * # n22 - pICMSST. Alíquota do imposto do ICMS ST. Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * Alíquota do ICMS ST sem o FCP; quando houver FCP, informar a alíquota do FCP em pFCPST. <br>
   * ICMS10: alíquota do ICMS ST em operações tributadas com ST. <br>
   * ICMS30: alíquota do ICMS ST em operações isentas/não tributadas com ST. <br>
   * ICMS70: alíquota do ICMS ST em operações com redução de BC e ST. <br>
   * ICMS90: alíquota do ICMS ST no grupo ICMS90 (quando houver ST). <br>
   * ICMSSN201: alíquota do ICMS ST nas operações do Simples Nacional com CSOSN=201. <br>
   * ICMSSN202: alíquota do ICMS ST nas operações do Simples Nacional com CSOSN=202 ou 203. <br>
   * ICMSSN900: alíquota do ICMS ST nas operações do Simples Nacional com CSOSN=900, quando houver retenção ST para o item.
   *
   * @param picmsST the new n22 - pICMSST
   */
  public void setPicmsST(BigDecimal picmsST) {
    this.picmsST = picmsST;
  }

  /**
   * # n23 - vICMSST. Valor do ICMS ST. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS10: valor do ICMS ST retido. <br>
   * ICMS30: valor do ICMS ST em operações isentas/não tributadas com ST. <br>
   * ICMS70: valor do ICMS ST em operações com redução de BC e ST. <br>
   * ICMS90: valor do ICMS ST no grupo ICMS90 (quando houver ST). <br>
   * ICMSSN201: valor do ICMS ST retido nas operações do Simples Nacional com CSOSN=201. <br>
   * ICMSSN202: valor do ICMS ST retido nas operações do Simples Nacional com CSOSN=202 ou 203. <br>
   * ICMSSN900: valor do ICMS ST retido nas operações do Simples Nacional com CSOSN=900 sempre que houver substituição tributária aplicável ao item.
   *
   * @return the n23 - vICMSST
   */
  public BigDecimal getVicmsST() {
    return vicmsST;
  }

  /**
   * # n23 - vICMSST. Valor do ICMS ST. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS10: valor do ICMS ST retido. <br>
   * ICMS30: valor do ICMS ST em operações isentas/não tributadas com ST. <br>
   * ICMS70: valor do ICMS ST em operações com redução de BC e ST. <br>
   * ICMS90: valor do ICMS ST no grupo ICMS90 (quando houver ST). <br>
   * ICMSSN201: valor do ICMS ST retido nas operações do Simples Nacional com CSOSN=201. <br>
   * ICMSSN202: valor do ICMS ST retido nas operações do Simples Nacional com CSOSN=202 ou 203. <br>
   * ICMSSN900: valor do ICMS ST retido nas operações do Simples Nacional com CSOSN=900 sempre que houver substituição tributária aplicável ao item.
   *
   * @param vicmsST the new n23 - vICMSST
   */
  public void setVicmsST(BigDecimal vicmsST) {
    this.vicmsST = vicmsST;
  }

  /**
   * # n23a - vBCFCPST. Valor da base de cálculo do FCP retido por substituição tributária. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N (quando o grupo FCP ST estiver presente). <br>
   * ICMS10: base de cálculo do FCP-ST em operações tributadas com ST. <br>
   * ICMS30: base de cálculo do FCP-ST em operações isentas/não tributadas com ST. <br>
   * ICMS70: base de cálculo do FCP-ST em operações com redução de BC e ST. <br>
   * ICMS90: base de cálculo do FCP-ST no grupo ICMS90 (quando houver ST). <br>
   * ICMSSN201: base de cálculo do FCP-ST nas operações do Simples Nacional com CSOSN=201. <br>
   * ICMSSN202: base de cálculo do FCP-ST nas operações do Simples Nacional com CSOSN=202 ou 203. <br>
   * ICMSSN900: base de cálculo do FCP-ST nas operações do Simples Nacional com CSOSN=900, quando houver FCP retido por ST.
   *
   * @return the n23a - vBCFCPST
   */
  public BigDecimal getVbcFCPST() {
    return vbcFCPST;
  }

  /**
   * # n23a - vBCFCPST. Valor da base de cálculo do FCP retido por substituição tributária. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N (quando o grupo FCP ST estiver presente). <br>
   * ICMS10: base de cálculo do FCP-ST em operações tributadas com ST. <br>
   * ICMS30: base de cálculo do FCP-ST em operações isentas/não tributadas com ST. <br>
   * ICMS70: base de cálculo do FCP-ST em operações com redução de BC e ST. <br>
   * ICMS90: base de cálculo do FCP-ST no grupo ICMS90 (quando houver ST). <br>
   * ICMSSN201: base de cálculo do FCP-ST nas operações do Simples Nacional com CSOSN=201. <br>
   * ICMSSN202: base de cálculo do FCP-ST nas operações do Simples Nacional com CSOSN=202 ou 203. <br>
   * ICMSSN900: base de cálculo do FCP-ST nas operações do Simples Nacional com CSOSN=900, quando houver FCP retido por ST.
   *
   * @param vbcFCPST the new n23a - vBCFCPST
   */
  public void setVbcFCPST(BigDecimal vbcFCPST) {
    this.vbcFCPST = vbcFCPST;
  }

  /**
   * # n23b/N23c - pFCPST. Percentual do FCP retido por substituição tributária. <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * ICMS10: percentual do FCP-ST em operações tributadas com ST. <br>
   * ICMS30: percentual do FCP-ST em operações isentas/não tributadas com ST. <br>
   * ICMS70: percentual do FCP-ST em operações com redução de BC e ST. <br>
   * ICMS90: percentual do FCP-ST no grupo ICMS90 (quando houver ST). <br>
   * ICMSSN201: percentual do FCP-ST nas operações do Simples Nacional com CSOSN=201. <br>
   * ICMSSN202: percentual do FCP-ST nas operações do Simples Nacional com CSOSN=202 ou 203, respeitando o limite legal de FCP. <br>
   * ICMSSN900: percentual do FCP-ST nas operações do Simples Nacional com CSOSN=900, quando houver FCP retido por substituição tributária.
   *
   * @return the n23b/N23c - pFCPST
   */
  public BigDecimal getPfcpST() {
    return pfcpST;
  }

  /**
   * # n23b/N23c - pFCPST. Percentual do FCP retido por substituição tributária. <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * ICMS10: percentual do FCP-ST em operações tributadas com ST. <br>
   * ICMS30: percentual do FCP-ST em operações isentas/não tributadas com ST. <br>
   * ICMS70: percentual do FCP-ST em operações com redução de BC e ST. <br>
   * ICMS90: percentual do FCP-ST no grupo ICMS90 (quando houver ST). <br>
   * ICMSSN201: percentual do FCP-ST nas operações do Simples Nacional com CSOSN=201. <br>
   * ICMSSN202: percentual do FCP-ST nas operações do Simples Nacional com CSOSN=202 ou 203, respeitando o limite legal de FCP. <br>
   * ICMSSN900: percentual do FCP-ST nas operações do Simples Nacional com CSOSN=900, quando houver FCP retido por substituição tributária.
   *
   * @param pfcpST the new n23b/N23c - pFCPST
   */
  public void setPfcpST(BigDecimal pfcpST) {
    this.pfcpST = pfcpST;
  }

  /**
   * # n23c/N23d - vFCPST. Valor do FCP retido por substituição tributária. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS10: valor do FCP-ST em operações tributadas com ST. <br>
   * ICMS30: valor do FCP-ST em operações isentas/não tributadas com ST. <br>
   * ICMS70: valor do FCP-ST em operações com redução de BC e ST. <br>
   * ICMS90: valor do FCP-ST no grupo ICMS90 (quando houver ST). <br>
   * ICMSSN201: valor do FCP-ST nas operações do Simples Nacional com CSOSN=201. <br>
   * ICMSSN202: valor do FCP-ST nas operações do Simples Nacional com CSOSN=202 ou 203. <br>
   * ICMSSN900: valor do FCP-ST nas operações do Simples Nacional com CSOSN=900, quando houver FCP retido por substituição tributária.
   *
   * @return the n23c/N23d - vFCPST
   */
  public BigDecimal getVfcpST() {
    return vfcpST;
  }

  /**
   * # n23c/N23d - vFCPST. Valor do FCP retido por substituição tributária. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS10: valor do FCP-ST em operações tributadas com ST. <br>
   * ICMS30: valor do FCP-ST em operações isentas/não tributadas com ST. <br>
   * ICMS70: valor do FCP-ST em operações com redução de BC e ST. <br>
   * ICMS90: valor do FCP-ST no grupo ICMS90 (quando houver ST). <br>
   * ICMSSN201: valor do FCP-ST nas operações do Simples Nacional com CSOSN=201. <br>
   * ICMSSN202: valor do FCP-ST nas operações do Simples Nacional com CSOSN=202 ou 203. <br>
   * ICMSSN900: valor do FCP-ST nas operações do Simples Nacional com CSOSN=900, quando houver FCP retido por substituição tributária.
   *
   * @param vfcpST the new n23c/N23d - vFCPST
   */
  public void setVfcpST(BigDecimal vfcpST) {
    this.vfcpST = vfcpST;
  }

  /**
   * # n26 - vBCSTRet (ICMS60 / ICMSSN500). Valor da BC do ICMS ST retido. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS60: valor da base de cálculo do ICMS ST cobrado anteriormente por substituição tributária; pode ser omitido quando a legislação não exigir sua informação. <br>
   * ICMSSN500: valor da base de cálculo do ICMS ST cobrado anteriormente por substituição tributária ou por antecipação, na UF de origem, podendo ser omitido quando a legislação não exigir.
   *
   * @return the n26 - vBCSTRet (ICMS60 / ICMSSN500)
   */
  public BigDecimal getVbcSTRet() {
    return vbcSTRet;
  }

  /**
   * # n26 - vBCSTRet (ICMS60 / ICMSSN500). Valor da BC do ICMS ST retido. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS60: valor da base de cálculo do ICMS ST cobrado anteriormente por substituição tributária; pode ser omitido quando a legislação não exigir sua informação. <br>
   * ICMSSN500: valor da base de cálculo do ICMS ST cobrado anteriormente por substituição tributária ou por antecipação, na UF de origem, podendo ser omitido quando a legislação não exigir.
   *
   * @param vbcSTRet the new n26 - vBCSTRet (ICMS60 / ICMSSN500)
   */
  public void setVbcSTRet(BigDecimal vbcSTRet) {
    this.vbcSTRet = vbcSTRet;
  }

  /**
   * # n26a - pST (ICMS60 / ICMSSN500). Alíquota suportada pelo consumidor final, utilizada no cálculo da retenção de ICMS ST. <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * Deve ser informada a alíquota efetiva usada na retenção, já incluindo o FCP quando aplicável. Exemplo: 18% + 2% FCP = 20%. <br>
   * ICMS60: alíquota efetiva da retenção de ICMS ST em operação anterior. <br>
   * ICMSSN500: alíquota efetiva suportada pelo consumidor final para cálculo do ICMS-ST cobrado anteriormente por substituição tributária ou antecipação.
   *
   * @return the n26a - pST (ICMS60 / ICMSSN500)
   */
  public BigDecimal getPst() {
    return pst;
  }

  /**
   * # n26a - pST (ICMS60 / ICMSSN500). Alíquota suportada pelo consumidor final, utilizada no cálculo da retenção de ICMS ST. <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * Deve ser informada a alíquota efetiva usada na retenção, já incluindo o FCP quando aplicável. Exemplo: 18% + 2% FCP = 20%. <br>
   * ICMS60: alíquota efetiva da retenção de ICMS ST em operação anterior. <br>
   * ICMSSN500: alíquota efetiva suportada pelo consumidor final para cálculo do ICMS-ST cobrado anteriormente por substituição tributária ou antecipação.
   *
   * @param pst the new n26a - pST (ICMS60 / ICMSSN500)
   */
  public void setPst(BigDecimal pst) {
    this.pst = pst;
  }

  /**
   * # n26b - vICMSSubstituto (ICMS60 / ICMSSN500). Valor do ICMS próprio do Substituto cobrado em operação anterior. <br>
   * Ocor.: 0–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS60: valor do ICMS próprio do contribuinte substituto referente à retenção anterior. <br>
   * ICMSSN500: valor do ICMS próprio do substituto cobrado em operação anterior, em cenários de ICMS-ST já recolhido (substituído ou antecipado).
   *
   * @return the n26b - vICMSSubstituto (ICMS60 / ICMSSN500)
   */
  public BigDecimal getVicmsSubstituto() {
    return vicmsSubstituto;
  }

  /**
   * # n26b - vICMSSubstituto (ICMS60 / ICMSSN500). Valor do ICMS próprio do Substituto cobrado em operação anterior. <br>
   * Ocor.: 0–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS60: valor do ICMS próprio do contribuinte substituto referente à retenção anterior. <br>
   * ICMSSN500: valor do ICMS próprio do substituto cobrado em operação anterior, em cenários de ICMS-ST já recolhido (substituído ou antecipado).
   *
   * @param vicmsSubstituto the new n26b - vICMSSubstituto (ICMS60 / ICMSSN500)
   */
  public void setVicmsSubstituto(BigDecimal vicmsSubstituto) {
    this.vicmsSubstituto = vicmsSubstituto;
  }

  /**
   * # n27 - vICMSSTRet (ICMS60 / ICMSSN500). Valor do ICMS ST retido anteriormente. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS60: valor do ICMS ST cobrado anteriormente por substituição tributária; pode ser omitido se a legislação não exigir. <br>
   * ICMSSN500: valor do ICMS ST cobrado anteriormente por substituição tributária ou por antecipação, cujo destaque/repasse está sendo informado pelo contribuinte enquadrado no Simples Nacional.
   *
   * @return the n27 - vICMSSTRet (ICMS60 / ICMSSN500)
   */
  public BigDecimal getVicmsSTRet() {
    return vicmsSTRet;
  }

  /**
   * # n27 - vICMSSTRet (ICMS60 / ICMSSN500). Valor do ICMS ST retido anteriormente. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS60: valor do ICMS ST cobrado anteriormente por substituição tributária; pode ser omitido se a legislação não exigir. <br>
   * ICMSSN500: valor do ICMS ST cobrado anteriormente por substituição tributária ou por antecipação, cujo destaque/repasse está sendo informado pelo contribuinte enquadrado no Simples Nacional.
   *
   * @param vicmsSTRet the new n27 - vICMSSTRet (ICMS60 / ICMSSN500)
   */
  public void setVicmsSTRet(BigDecimal vicmsSTRet) {
    this.vicmsSTRet = vicmsSTRet;
  }

  /**
   * # n27a - vBCFCPSTRet (ICMS60 / ICMSSN500). Valor da base de cálculo do FCP retido anteriormente por substituição tributária. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS60: valor da base do FCP-ST retido anteriormente. <br>
   * ICMSSN500: valor da base de cálculo do FCP relativo ao ICMS-ST retido anteriormente (substituição tributária ou antecipação) em operações do Simples Nacional com CSOSN=500.
   *
   * @return the n27a - vBCFCPSTRet (ICMS60 / ICMSSN500)
   */
  public BigDecimal getVbcFCPSTRet() {
    return vbcFCPSTRet;
  }

  /**
   * # n27a - vBCFCPSTRet (ICMS60 / ICMSSN500). Valor da base de cálculo do FCP retido anteriormente por substituição tributária. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS60: valor da base do FCP-ST retido anteriormente. <br>
   * ICMSSN500: valor da base de cálculo do FCP relativo ao ICMS-ST retido anteriormente (substituição tributária ou antecipação) em operações do Simples Nacional com CSOSN=500.
   *
   * @param vbcFCPSTRet the new n27a - vBCFCPSTRet (ICMS60 / ICMSSN500)
   */
  public void setVbcFCPSTRet(BigDecimal vbcFCPSTRet) {
    this.vbcFCPSTRet = vbcFCPSTRet;
  }

  /**
   * # n27b - pFCPSTRet (ICMS60 / ICMSSN500). Percentual do FCP retido anteriormente por substituição tributária. <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * ICMS60: percentual aplicado ao FCP-ST retido anteriormente. <br>
   * ICMSSN500: percentual do FCP-ST retido anteriormente em operações do Simples Nacional com CSOSN=500, normalmente limitado ao percentual máximo de FCP definido em lei.
   *
   * @return the n27b - pFCPSTRet (ICMS60 / ICMSSN500)
   */
  public BigDecimal getPfcpSTRet() {
    return pfcpSTRet;
  }

  /**
   * # n27b - pFCPSTRet (ICMS60 / ICMSSN500). Percentual do FCP retido anteriormente por substituição tributária. <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. <br>
   * ICMS60: percentual aplicado ao FCP-ST retido anteriormente. <br>
   * ICMSSN500: percentual do FCP-ST retido anteriormente em operações do Simples Nacional com CSOSN=500, normalmente limitado ao percentual máximo de FCP definido em lei.
   *
   * @param pfcpSTRet the new n27b - pFCPSTRet (ICMS60 / ICMSSN500)
   */
  public void setPfcpSTRet(BigDecimal pfcpSTRet) {
    this.pfcpSTRet = pfcpSTRet;
  }

  /**
   * # n27d - vFCPSTRet (ICMS60 / ICMSSN500). Valor do FCP retido anteriormente por substituição tributária. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS60: valor do ICMS relativo ao FCP-ST retido anteriormente. <br>
   * ICMSSN500: valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP) retido anteriormente por substituição tributária em operações do Simples Nacional (CSOSN=500).
   *
   * @return the n27d - vFCPSTRet (ICMS60 / ICMSSN500)
   */
  public BigDecimal getVfcpSTRet() {
    return vfcpSTRet;
  }

  /**
   * # n27d - vFCPSTRet (ICMS60 / ICMSSN500). Valor do FCP retido anteriormente por substituição tributária. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS60: valor do ICMS relativo ao FCP-ST retido anteriormente. <br>
   * ICMSSN500: valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP) retido anteriormente por substituição tributária em operações do Simples Nacional (CSOSN=500).
   *
   * @param vfcpSTRet the new n27d - vFCPSTRet (ICMS60 / ICMSSN500)
   */
  public void setVfcpSTRet(BigDecimal vfcpSTRet) {
    this.vfcpSTRet = vfcpSTRet;
  }

  /**
   * # n34 - pRedBCEfet (ICMS60 / ICMSSN500). Percentual de redução da base de cálculo efetiva. <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. Campo opcional, a critério da UF. <br>
   * ICMS60: percentual de redução que seria aplicado caso o contribuinte estivesse no regime comum, para obtenção da base de cálculo efetiva (vBCEfet). <br>
   * ICMSSN500: percentual de redução da base de cálculo efetiva em operações do Simples Nacional com CSOSN=500, para fins de cálculo de ICMS efetivo em simulações de regime comum.
   *
   * @return the n34 - pRedBCEfet (ICMS60 / ICMSSN500)
   */
  public BigDecimal getPredBCEfet() {
    return predBCEfet;
  }

  /**
   * # n34 - pRedBCEfet (ICMS60 / ICMSSN500). Percentual de redução da base de cálculo efetiva. <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. Campo opcional, a critério da UF. <br>
   * ICMS60: percentual de redução que seria aplicado caso o contribuinte estivesse no regime comum, para obtenção da base de cálculo efetiva (vBCEfet). <br>
   * ICMSSN500: percentual de redução da base de cálculo efetiva em operações do Simples Nacional com CSOSN=500, para fins de cálculo de ICMS efetivo em simulações de regime comum.
   *
   * @param predBCEfet the new n34 - pRedBCEfet (ICMS60 / ICMSSN500)
   */
  public void setPredBCEfet(BigDecimal predBCEfet) {
    this.predBCEfet = predBCEfet;
  }

  /**
   * # n35 - vBCEfet (ICMS60 / ICMSSN500). Valor da base de cálculo efetiva do ICMS. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. Campo opcional, a critério da UF. <br>
   * Fórmula sugerida: vBCEfet = vProd × (1 - pRedBCEfet). <br>
   * ICMS60: base de cálculo que seria utilizada caso a operação estivesse no regime comum. <br>
   * ICMSSN500: base de cálculo efetiva simulada para operações de contribuinte do Simples Nacional com CSOSN=500, considerando o regime comum (para cálculo de ICMS efetivo).
   *
   * @return the n35 - vBCEfet (ICMS60 / ICMSSN500)
   */
  public BigDecimal getVbcEfet() {
    return vbcEfet;
  }

  /**
   * # n35 - vBCEfet (ICMS60 / ICMSSN500). Valor da base de cálculo efetiva do ICMS. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. Campo opcional, a critério da UF. <br>
   * Fórmula sugerida: vBCEfet = vProd × (1 - pRedBCEfet). <br>
   * ICMS60: base de cálculo que seria utilizada caso a operação estivesse no regime comum. <br>
   * ICMSSN500: base de cálculo efetiva simulada para operações de contribuinte do Simples Nacional com CSOSN=500, considerando o regime comum (para cálculo de ICMS efetivo).
   *
   * @param vbcEfet the new n35 - vBCEfet (ICMS60 / ICMSSN500)
   */
  public void setVbcEfet(BigDecimal vbcEfet) {
    this.vbcEfet = vbcEfet;
  }

  /**
   * # n36 - pICMSEfet (ICMS60 / ICMSSN500). Alíquota efetiva do ICMS. <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. Campo opcional, a critério da UF. <br>
   * ICMS60: alíquota que seria aplicada no regime comum para obtenção do ICMS efetivo. <br>
   * ICMSSN500: alíquota efetiva do ICMS em operações do Simples Nacional com CSOSN=500, simulando a tributação no regime comum para cálculo de vICMSEfet.
   *
   * @return the n36 - pICMSEfet (ICMS60 / ICMSSN500)
   */
  public BigDecimal getPicmsEfet() {
    return picmsEfet;
  }

  /**
   * # n36 - pICMSEfet (ICMS60 / ICMSSN500). Alíquota efetiva do ICMS. <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. Campo opcional, a critério da UF. <br>
   * ICMS60: alíquota que seria aplicada no regime comum para obtenção do ICMS efetivo. <br>
   * ICMSSN500: alíquota efetiva do ICMS em operações do Simples Nacional com CSOSN=500, simulando a tributação no regime comum para cálculo de vICMSEfet.
   *
   * @param picmsEfet the new n36 - pICMSEfet (ICMS60 / ICMSSN500)
   */
  public void setPicmsEfet(BigDecimal picmsEfet) {
    this.picmsEfet = picmsEfet;
  }

  /**
   * # n37 - vICMSEfet (ICMS60 / ICMSSN500). Valor do ICMS efetivo. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. Campo opcional, a critério da UF. <br>
   * Fórmula sugerida: vICMSEfet = vBCEfet × pICMSEfet. <br>
   * ICMS60: valor do ICMS efetivo que seria devido no regime comum, calculado a partir da base e alíquota efetivas. <br>
   * ICMSSN500: valor do ICMS efetivo estimado para operações do Simples Nacional com CSOSN=500, considerando o cenário de regime comum (usado para controles e análises fiscais específicas definidas pela UF).
   *
   * @return the n37 - vICMSEfet (ICMS60 / ICMSSN500)
   */
  public BigDecimal getVicmsEfet() {
    return vicmsEfet;
  }

  /**
   * # n37 - vICMSEfet (ICMS60 / ICMSSN500). Valor do ICMS efetivo. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. Campo opcional, a critério da UF. <br>
   * Fórmula sugerida: vICMSEfet = vBCEfet × pICMSEfet. <br>
   * ICMS60: valor do ICMS efetivo que seria devido no regime comum, calculado a partir da base e alíquota efetivas. <br>
   * ICMSSN500: valor do ICMS efetivo estimado para operações do Simples Nacional com CSOSN=500, considerando o cenário de regime comum (usado para controles e análises fiscais específicas definidas pela UF).
   *
   * @param vicmsEfet the new n37 - vICMSEfet (ICMS60 / ICMSSN500)
   */
  public void setVicmsEfet(BigDecimal vicmsEfet) {
    this.vicmsEfet = vicmsEfet;
  }

  /**
   * # n29 - pCredSN. Alíquota aplicável de cálculo do crédito (Simples Nacional). <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. (v2.0) <br>
   * ICMSSN101: percentual utilizado para cálculo do crédito de ICMS permitido nos termos do art. 23 da LC 123.
   *
   * @return the n29 - pCredSN
   */
  public BigDecimal getPcredSN() {
    return pcredSN;
  }

  /**
   * # n29 - pCredSN. Alíquota aplicável de cálculo do crédito (Simples Nacional). <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N. (v2.0) <br>
   * ICMSSN101: percentual utilizado para cálculo do crédito de ICMS permitido nos termos do art. 23 da LC 123.
   *
   * @param pcredSN the new n29 - pCredSN
   */
  public void setPcredSN(BigDecimal pcredSN) {
    this.pcredSN = pcredSN;
  }

  /**
   * # n30 - vCredICMSSN. Valor do crédito do ICMS que pode ser aproveitado nos termos do art. 23 da LC 123 (Simples Nacional). <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. (v2.0) <br>
   * ICMSSN101: valor do crédito de ICMS calculado com base em pCredSN aplicado sobre a base correspondente, conforme regras do Simples Nacional.
   *
   * @return the n30 - vCredICMSSN
   */
  public BigDecimal getVcredICMSSN() {
    return vcredICMSSN;
  }

  /**
   * # n30 - vCredICMSSN. Valor do crédito do ICMS que pode ser aproveitado nos termos do art. 23 da LC 123 (Simples Nacional). <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. (v2.0) <br>
   * ICMSSN101: valor do crédito de ICMS calculado com base em pCredSN aplicado sobre a base correspondente, conforme regras do Simples Nacional.
   *
   * @param vcredICMSSN the new n30 - vCredICMSSN
   */
  public void setVcredICMSSN(BigDecimal vcredICMSSN) {
    this.vcredICMSSN = vcredICMSSN;
  }

  /**
   * # n17c - vFCP. Valor do Fundo de Combate à Pobreza (FCP). Ocor.: 1–1 / Tam.: 13v2 / Tipo: N (quando o grupo FCP estiver presente). <br>
   * ICMS00: valor do FCP relativo ao ICMS próprio. <br>
   * ICMS10: valor do FCP relativo ao ICMS próprio (quando aplicável). <br>
   * ICMS20: valor do FCP calculado sobre a base de cálculo do FCP do ICMS com redução de BC. <br>
   * ICMS51: valor do FCP relativo à operação com diferimento (quando aplicável). <br>
   * ICMS70: valor do FCP relativo ao ICMS próprio em operação com redução de BC e ST. <br>
   * ICMS90: valor do FCP relativo ao ICMS próprio no grupo ICMS90.
   *
   * @return the n17c - vFCP
   */
  public BigDecimal getVfcp() {
    return vfcp;
  }

  /**
   * # n17c - vFCP. Valor do Fundo de Combate à Pobreza (FCP). Ocor.: 1–1 / Tam.: 13v2 / Tipo: N (quando o grupo FCP estiver presente). <br>
   * ICMS00: valor do FCP relativo ao ICMS próprio. <br>
   * ICMS10: valor do FCP relativo ao ICMS próprio (quando aplicável). <br>
   * ICMS20: valor do FCP calculado sobre a base de cálculo do FCP do ICMS com redução de BC. <br>
   * ICMS51: valor do FCP relativo à operação com diferimento (quando aplicável). <br>
   * ICMS70: valor do FCP relativo ao ICMS próprio em operação com redução de BC e ST. <br>
   * ICMS90: valor do FCP relativo ao ICMS próprio no grupo ICMS90.
   *
   * @param vfcp the new n17c - vFCP
   */
  public void setVfcp(BigDecimal vfcp) {
    this.vfcp = vfcp;
  }

  /**
   * # n28a - vICMSDeson (ICMS20, ICMS30, ICMS40, ICMS70, ICMS90). Valor do ICMS desonerado. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS20: valor do ICMS desonerado conforme motivo de desoneração. <br>
   * ICMS30: valor do ICMS desonerado aplicado a operações isentas/não tributadas com ICMS ST. <br>
   * ICMS40: valor do ICMS que seria devido se não houvesse isenção/não tributação/suspensão, de acordo com o motivo de desoneração informado. <br>
   * ICMS70: valor do ICMS desonerado em operações com redução de BC e ICMS ST, conforme motivo informado em motDesICMS. <br>
   * ICMS90: valor do ICMS desonerado nas operações “Outros”, quando houver motivo de desoneração informado.
   *
   * @return the n28a - vICMSDeson (ICMS20, ICMS30, ICMS40, ICMS70, ICMS90)
   */
  public BigDecimal getVicmsDeson() {
    return vicmsDeson;
  }

  /**
   * # n28a - vICMSDeson (ICMS20, ICMS30, ICMS40, ICMS70, ICMS90). Valor do ICMS desonerado. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS20: valor do ICMS desonerado conforme motivo de desoneração. <br>
   * ICMS30: valor do ICMS desonerado aplicado a operações isentas/não tributadas com ICMS ST. <br>
   * ICMS40: valor do ICMS que seria devido se não houvesse isenção/não tributação/suspensão, de acordo com o motivo de desoneração informado. <br>
   * ICMS70: valor do ICMS desonerado em operações com redução de BC e ICMS ST, conforme motivo informado em motDesICMS. <br>
   * ICMS90: valor do ICMS desonerado nas operações “Outros”, quando houver motivo de desoneração informado.
   *
   * @param vicmsDeson the new n28a - vICMSDeson (ICMS20, ICMS30, ICMS40, ICMS70, ICMS90)
   */
  public void setVicmsDeson(BigDecimal vicmsDeson) {
    this.vicmsDeson = vicmsDeson;
  }

  /**
   * # n28 - motDesICMS (ICMS20, ICMS30, ICMS40, ICMS70, ICMS90). Motivo da desoneração do ICMS. Ver {@link SEFAZ_motDesICMS}. <br>
   * ICMS20: motivos de desoneração aplicáveis às operações com redução de BC. <br>
   * ICMS30: motivos aplicáveis às operações isentas/não tributadas com ICMS ST. <br>
   * ICMS40: motivos aplicáveis às operações isentas, não tributadas ou com suspensão (incluindo SUFRAMA, venda a órgão público, Olimpíadas Rio 2016, solicitado pelo Fisco, etc.). <br>
   * ICMS70: motivos de desoneração aplicáveis ao grupo ICMS70, utilizando os códigos 1, 3, 4, 5, 6, 7, 8, 9, 10, 11 e 12 conforme tabela do MOC. <br>
   * ICMS90: motivos de desoneração aplicáveis ao grupo ICMS90, utilizando os códigos 3 (Uso na agropecuária), 9 (Outros) e 12 (Órgão de fomento e desenvolvimento agropecuário).
   *
   * @return the n28 - motDesICMS (ICMS20, ICMS30, ICMS40, ICMS70, ICMS90)
   */
  public SEFAZ_motDesICMS getMotDesICMS() {
    return motDesICMS;
  }

  /**
   * # n28 - motDesICMS (ICMS20, ICMS30, ICMS40, ICMS70, ICMS90). Motivo da desoneração do ICMS. Ver {@link SEFAZ_motDesICMS}. <br>
   * ICMS20: motivos de desoneração aplicáveis às operações com redução de BC. <br>
   * ICMS30: motivos aplicáveis às operações isentas/não tributadas com ICMS ST. <br>
   * ICMS40: motivos aplicáveis às operações isentas, não tributadas ou com suspensão (incluindo SUFRAMA, venda a órgão público, Olimpíadas Rio 2016, solicitado pelo Fisco, etc.). <br>
   * ICMS70: motivos de desoneração aplicáveis ao grupo ICMS70, utilizando os códigos 1, 3, 4, 5, 6, 7, 8, 9, 10, 11 e 12 conforme tabela do MOC. <br>
   * ICMS90: motivos de desoneração aplicáveis ao grupo ICMS90, utilizando os códigos 3 (Uso na agropecuária), 9 (Outros) e 12 (Órgão de fomento e desenvolvimento agropecuário).
   *
   * @param motDesICMS the new n28 - motDesICMS (ICMS20, ICMS30, ICMS40, ICMS70, ICMS90)
   */
  public void setMotDesICMS(SEFAZ_motDesICMS motDesICMS) {
    this.motDesICMS = motDesICMS;
  }

  /**
   * # n12 - CST. Tributação do ICMS. Ocor.: 1–1 / Tam.: 2 / Tipo: N. Ver valores em {@link SEFAZ_CST_ICMS}. <br>
   * ICMS00: CST = 00 – Tributado integralmente. <br>
   * ICMS10: CST = 10 – Tributado e com cobrança do ICMS por substituição tributária. <br>
   * ICMS20: CST = 20 – Com redução da base de cálculo. <br>
   * ICMS30: CST = 30 – Isenta ou não tributada e com cobrança do ICMS por substituição tributária. <br>
   * ICMS40: CST = 40 (Isenta), 41 (Não tributada) ou 50 (Suspensão). <br>
   * ICMS51: CST = 51 – Diferimento. <br>
   * ICMS60: CST = 60 – ICMS cobrado anteriormente por substituição tributária. <br>
   * ICMS70: CST = 70 – Com redução de base de cálculo e cobrança do ICMS por substituição tributária. <br>
   * ICMS90: CST = 90 – Outros.
   *
   * @return the n12 - CST
   */
  public SEFAZ_CST_ICMS getCst() {
    return cst;
  }

  /**
   * # n12 - CST. Tributação do ICMS. Ocor.: 1–1 / Tam.: 2 / Tipo: N. Ver valores em {@link SEFAZ_CST_ICMS}. <br>
   * ICMS00: CST = 00 – Tributado integralmente. <br>
   * ICMS10: CST = 10 – Tributado e com cobrança do ICMS por substituição tributária. <br>
   * ICMS20: CST = 20 – Com redução da base de cálculo. <br>
   * ICMS30: CST = 30 – Isenta ou não tributada e com cobrança do ICMS por substituição tributária. <br>
   * ICMS40: CST = 40 (Isenta), 41 (Não tributada) ou 50 (Suspensão). <br>
   * ICMS51: CST = 51 – Diferimento. <br>
   * ICMS60: CST = 60 – ICMS cobrado anteriormente por substituição tributária. <br>
   * ICMS70: CST = 70 – Com redução de base de cálculo e cobrança do ICMS por substituição tributária. <br>
   * ICMS90: CST = 90 – Outros.
   *
   * @param cst the new n12 - CST
   */
  public void setCst(SEFAZ_CST_ICMS cst) {
    this.cst = cst;
  }

  /**
   * # n16a - vICMSOp (ICMS51). Valor do ICMS da operação como se não houvesse diferimento. Ocor.: 0–1 / Tam.: 13v2 / Tipo: N.
   *
   * @return the n16a - vICMSOp (ICMS51)
   */
  public BigDecimal getVicmsOp() {
    return vicmsOp;
  }

  /**
   * # n16a - vICMSOp (ICMS51). Valor do ICMS da operação como se não houvesse diferimento. Ocor.: 0–1 / Tam.: 13v2 / Tipo: N.
   *
   * @param vicmsOp the new n16a - vICMSOp (ICMS51)
   */
  public void setVicmsOp(BigDecimal vicmsOp) {
    this.vicmsOp = vicmsOp;
  }

  /**
   * # n16b - pDif (ICMS51). Percentual do diferimento. No caso de diferimento total, informar “100”. Ocor.: 0–1 / Tam.: 3v2–4 / Tipo: N.
   *
   * @return the n16b - pDif (ICMS51)
   */
  public BigDecimal getPdif() {
    return pdif;
  }

  /**
   * # n16b - pDif (ICMS51). Percentual do diferimento. No caso de diferimento total, informar “100”. Ocor.: 0–1 / Tam.: 3v2–4 / Tipo: N.
   *
   * @param pdif the new n16b - pDif (ICMS51)
   */
  public void setPdif(BigDecimal pdif) {
    this.pdif = pdif;
  }

  /**
   * # n16c - vICMSDif (ICMS51). Valor do ICMS diferido. Ocor.: 0–1 / Tam.: 13v2 / Tipo: N.
   *
   * @return the n16c - vICMSDif (ICMS51)
   */
  public BigDecimal getVicmsDif() {
    return vicmsDif;
  }

  /**
   * # n16c - vICMSDif (ICMS51). Valor do ICMS diferido. Ocor.: 0–1 / Tam.: 13v2 / Tipo: N.
   *
   * @param vicmsDif the new n16c - vICMSDif (ICMS51)
   */
  public void setVicmsDif(BigDecimal vicmsDif) {
    this.vicmsDif = vicmsDif;
  }

  /**
   * # n17 - vICMS. Valor do ICMS. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS00: valor do ICMS próprio devido. <br>
   * ICMS10: valor do ICMS próprio (sem considerar o ICMS ST). <br>
   * ICMS20: valor do ICMS calculado sobre a base reduzida. <br>
   * ICMS51: valor do ICMS realmente devido após o diferimento (por exemplo, vICMSOp - vICMSDif, conforme regra da UF). <br>
   * ICMS70: valor do ICMS próprio calculado sobre a BC reduzida (antes da ST). <br>
   * ICMS90: valor do ICMS próprio devido no grupo ICMS90 (Tributação “Outros”).
   *
   * @return the n17 - vICMS
   */
  public BigDecimal getVicms() {
    return vicms;
  }

  /**
   * # n17 - vICMS. Valor do ICMS. Ocor.: 1–1 / Tam.: 13v2 / Tipo: N. <br>
   * ICMS00: valor do ICMS próprio devido. <br>
   * ICMS10: valor do ICMS próprio (sem considerar o ICMS ST). <br>
   * ICMS20: valor do ICMS calculado sobre a base reduzida. <br>
   * ICMS51: valor do ICMS realmente devido após o diferimento (por exemplo, vICMSOp - vICMSDif, conforme regra da UF). <br>
   * ICMS70: valor do ICMS próprio calculado sobre a BC reduzida (antes da ST). <br>
   * ICMS90: valor do ICMS próprio devido no grupo ICMS90 (Tributação “Outros”).
   *
   * @param vicms the new n17 - vICMS
   */
  public void setVicms(BigDecimal vicms) {
    this.vicms = vicms;
  }

  /**
   * # n17a/N17b (ICMS10, ICMS20, ICMS51, ICMS70, ICMS90) - vBCFCP. Valor da Base de Cálculo do FCP. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N (quando o grupo FCP estiver presente). <br>
   * ICMS10: valor da base de cálculo do FCP do ICMS próprio. <br>
   * ICMS20: valor da base de cálculo do FCP em operações com redução de BC. <br>
   * ICMS51: base de cálculo do FCP nas operações com diferimento (quando exigido pela UF). <br>
   * ICMS70: base de cálculo do FCP relativo ao ICMS próprio em operação com redução de BC e ST. <br>
   * ICMS90: base de cálculo do FCP relativo ao ICMS próprio no grupo ICMS90.
   *
   * @return the n17a/N17b (ICMS10, ICMS20, ICMS51, ICMS70, ICMS90) - vBCFCP
   */
  public BigDecimal getVbcFCP() {
    return vbcFCP;
  }

  /**
   * # n17a/N17b (ICMS10, ICMS20, ICMS51, ICMS70, ICMS90) - vBCFCP. Valor da Base de Cálculo do FCP. <br>
   * Ocor.: 1–1 / Tam.: 13v2 / Tipo: N (quando o grupo FCP estiver presente). <br>
   * ICMS10: valor da base de cálculo do FCP do ICMS próprio. <br>
   * ICMS20: valor da base de cálculo do FCP em operações com redução de BC. <br>
   * ICMS51: base de cálculo do FCP nas operações com diferimento (quando exigido pela UF). <br>
   * ICMS70: base de cálculo do FCP relativo ao ICMS próprio em operação com redução de BC e ST. <br>
   * ICMS90: base de cálculo do FCP relativo ao ICMS próprio no grupo ICMS90.
   *
   * @param vbcFCP the new n17a/N17b (ICMS10, ICMS20, ICMS51, ICMS70, ICMS90) - vBCFCP
   */
  public void setVbcFCP(BigDecimal vbcFCP) {
    this.vbcFCP = vbcFCP;
  }

  /**
   * # n17b - pFCP. Percentual do ICMS relativo ao Fundo de Combate à Pobreza (FCP). <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N (quando o grupo FCP estiver presente). <br>
   * ICMS00: percentual aplicado sobre a BC do ICMS para cálculo do FCP. <br>
   * ICMS10: percentual aplicado sobre vBCFCP e/ou vBCFCPST, conforme o caso. <br>
   * ICMS20: percentual aplicado sobre a base de cálculo do FCP em operações com redução de BC. <br>
   * ICMS51: percentual do FCP aplicado sobre a base de cálculo do FCP na operação com diferimento. <br>
   * ICMS70: percentual do FCP relativo ao ICMS próprio em operação com redução de BC e ST. <br>
   * ICMS90: percentual do FCP relativo ao ICMS próprio em operações “Outros”.
   *
   * @return the n17b - pFCP
   */
  public BigDecimal getPfcp() {
    return pfcp;
  }

  /**
   * # n17b - pFCP. Percentual do ICMS relativo ao Fundo de Combate à Pobreza (FCP). <br>
   * Ocor.: 1–1 / Tam.: 3v2–4 / Tipo: N (quando o grupo FCP estiver presente). <br>
   * ICMS00: percentual aplicado sobre a BC do ICMS para cálculo do FCP. <br>
   * ICMS10: percentual aplicado sobre vBCFCP e/ou vBCFCPST, conforme o caso. <br>
   * ICMS20: percentual aplicado sobre a base de cálculo do FCP em operações com redução de BC. <br>
   * ICMS51: percentual do FCP aplicado sobre a base de cálculo do FCP na operação com diferimento. <br>
   * ICMS70: percentual do FCP relativo ao ICMS próprio em operação com redução de BC e ST. <br>
   * ICMS90: percentual do FCP relativo ao ICMS próprio em operações “Outros”.
   *
   * @param pfcp the new n17b - pFCP
   */
  public void setPfcp(BigDecimal pfcp) {
    this.pfcp = pfcp;
  }

}