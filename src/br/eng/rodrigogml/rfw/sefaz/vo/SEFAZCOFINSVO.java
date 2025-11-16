package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CST_COFINS;

/**
 * Grupo S01 - COFINS (Grupo COFINS).
 * <p>
 * Ocorre 0-1 dentro do grupo M01 (imposto do item). Deve ser informado apenas quando o item for sujeito à COFINS.
 * <p>
 * Estrutura que concentra todos os campos dos subgrupos de COFINS do leiaute da NF-e:
 * <ul>
 * <li>S02 - COFINSAliq: COFINS tributado pela alíquota (CST 01, 02, com base em valor e alíquota percentual);</li>
 * <li>S03 - COFINSQtde: COFINS tributado por quantidade (CST 03, com base em quantidade × alíquota em reais);</li>
 * <li>S04 - COFINSNT: COFINS não tributado (CST 04, 05, 06, 07, 08, 09);</li>
 * <li>S05 - COFINSOutr: COFINS – outras operações (CST 49, 50, 51, 52, 53, 54, 55, 56, 61–67, 70–73, 98, 99).</li>
 * </ul>
 * Na estrutura XML original, apenas um dos grupos S02, S03, S04 ou S05 é informado por item, conforme o valor atribuído ao campo S06 – CST da COFINS. Neste VO, os campos necessários para todos os cenários foram unificados.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_cofins")
public class SEFAZCOFINSVO extends RFWVO {

  /**
   *
   */
  private static final long serialVersionUID = -4755548288956978664L;

  /**
   * {@link SEFAZImpostoVO}
   */
  @RFWMetaRelationshipField(caption = "Imposto", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_imposto")
  private SEFAZImpostoVO impostoVO = null;

  /**
   * S06 - Código de Situação Tributária da COFINS (CST). Tipo: N, Tamanho: 2, Ocorrência: 1-1 (campo obrigatório na estrutura da NF-e).
   * <p>
   * Utiliza a enumeração SEFAZ_CST_COFINS, contemplando os códigos das situações tributáveis por alíquota, por quantidade, não tributadas e outras operações (COFINSAliq, COFINSQtde, COFINSNT, COFINSOutr).
   */
  @RFWMetaEnumField(caption = "CST", required = false)
  private SEFAZ_CST_COFINS cst;

  /**
   * S07 - Valor da Base de Cálculo da COFINS (vBC). Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 nos cenários em que o cálculo da COFINS é em percentual.
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo S02 - COFINSAliq (COFINS tributado pela alíquota em percentual);</li>
   * <li>Grupo S05 - COFINSOutr, quando o cálculo for em percentual (sequência S06.1).</li>
   * </ul>
   */
  @RFWMetaBigDecimalField(caption = "vBC", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vbc;

  /**
   * S08 - Alíquota da COFINS em percentual (pCOFINS). Tipo: N, Tamanho: 3v2-4, Ocorrência: 1-1 nos cenários em que o cálculo da COFINS é em percentual.
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo S02 - COFINSAliq;</li>
   * <li>Grupo S05 - COFINSOutr, quando o cálculo for em percentual (sequência S06.1).</li>
   * </ul>
   */
  @RFWMetaBigDecimalField(caption = "pCOFINS", required = false, unique = false, maxValue = "", minValue = "", scale = 2, scaleMax = 4, absolute = false)
  private BigDecimal pcofins;

  /**
   * S11 - Valor da COFINS (vCOFINS). Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 nos grupos de COFINS com cálculo de imposto.
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo S02 - COFINSAliq (S11 - vCOFINS);</li>
   * <li>Grupo S03 - COFINSQtde (S11 - vCOFINS);</li>
   * <li>Grupo S05 - COFINSOutr (S11 - vCOFINS).</li>
   * </ul>
   */
  @RFWMetaBigDecimalField(caption = "vCOFINS", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vcofins;

  /**
   * S09 - Quantidade Vendida (qBCProd). Tipo: N, Tamanho: 12v0-4, Ocorrência: 1-1 nos cenários em que o cálculo da COFINS é por quantidade.
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo S03 - COFINSQtde (COFINS tributado por quantidade);</li>
   * <li>Grupo S05 - COFINSOutr, quando o cálculo for em valor por unidade (sequência S08.1).</li>
   * </ul>
   */
  @RFWMetaBigDecimalField(caption = "qBCProd", required = false, unique = false, maxValue = "", minValue = "", scale = 0, scaleMax = 4, absolute = false)
  private BigDecimal qbcProd;

  /**
   * S10 - Alíquota da COFINS em reais (vAliqProd). Tipo: N, Tamanho: 11v0-4, Ocorrência: 1-1 nos cenários em que o cálculo da COFINS é por quantidade (valor por unidade).
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo S03 - COFINSQtde;</li>
   * <li>Grupo S05 - COFINSOutr, quando o cálculo for em valor por unidade (sequência S08.1).</li>
   * </ul>
   */
  @RFWMetaBigDecimalField(caption = "vAliqProd", required = false, unique = false, maxValue = "", minValue = "", scale = 0, scaleMax = 4, absolute = false)
  private BigDecimal valiqProd;

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
   * # s06 - Código de Situação Tributária da COFINS (CST). Tipo: N, Tamanho: 2, Ocorrência: 1-1 (campo obrigatório na estrutura da NF-e).
   * <p>
   * Utiliza a enumeração SEFAZ_CST_COFINS, contemplando os códigos das situações tributáveis por alíquota, por quantidade, não tributadas e outras operações (COFINSAliq, COFINSQtde, COFINSNT, COFINSOutr).
   *
   * @return the s06 - Código de Situação Tributária da COFINS (CST)
   */
  public SEFAZ_CST_COFINS getCst() {
    return cst;
  }

  /**
   * # s06 - Código de Situação Tributária da COFINS (CST). Tipo: N, Tamanho: 2, Ocorrência: 1-1 (campo obrigatório na estrutura da NF-e).
   * <p>
   * Utiliza a enumeração SEFAZ_CST_COFINS, contemplando os códigos das situações tributáveis por alíquota, por quantidade, não tributadas e outras operações (COFINSAliq, COFINSQtde, COFINSNT, COFINSOutr).
   *
   * @param cst the new s06 - Código de Situação Tributária da COFINS (CST)
   */
  public void setCst(SEFAZ_CST_COFINS cst) {
    this.cst = cst;
  }

  /**
   * # s07 - Valor da Base de Cálculo da COFINS (vBC). Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 nos cenários em que o cálculo da COFINS é em percentual.
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo S02 - COFINSAliq (COFINS tributado pela alíquota em percentual);</li>
   * <li>Grupo S05 - COFINSOutr, quando o cálculo for em percentual (sequência S06.1).</li>
   * </ul>
   * .
   *
   * @return the s07 - Valor da Base de Cálculo da COFINS (vBC)
   */
  public BigDecimal getVbc() {
    return vbc;
  }

  /**
   * # s07 - Valor da Base de Cálculo da COFINS (vBC). Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 nos cenários em que o cálculo da COFINS é em percentual.
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo S02 - COFINSAliq (COFINS tributado pela alíquota em percentual);</li>
   * <li>Grupo S05 - COFINSOutr, quando o cálculo for em percentual (sequência S06.1).</li>
   * </ul>
   * .
   *
   * @param vbc the new s07 - Valor da Base de Cálculo da COFINS (vBC)
   */
  public void setVbc(BigDecimal vbc) {
    this.vbc = vbc;
  }

  /**
   * # s08 - Alíquota da COFINS em percentual (pCOFINS). Tipo: N, Tamanho: 3v2-4, Ocorrência: 1-1 nos cenários em que o cálculo da COFINS é em percentual.
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo S02 - COFINSAliq;</li>
   * <li>Grupo S05 - COFINSOutr, quando o cálculo for em percentual (sequência S06.1).</li>
   * </ul>
   * .
   *
   * @return the s08 - Alíquota da COFINS em percentual (pCOFINS)
   */
  public BigDecimal getPcofins() {
    return pcofins;
  }

  /**
   * # s08 - Alíquota da COFINS em percentual (pCOFINS). Tipo: N, Tamanho: 3v2-4, Ocorrência: 1-1 nos cenários em que o cálculo da COFINS é em percentual.
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo S02 - COFINSAliq;</li>
   * <li>Grupo S05 - COFINSOutr, quando o cálculo for em percentual (sequência S06.1).</li>
   * </ul>
   * .
   *
   * @param pcofins the new s08 - Alíquota da COFINS em percentual (pCOFINS)
   */
  public void setPcofins(BigDecimal pcofins) {
    this.pcofins = pcofins;
  }

  /**
   * # s11 - Valor da COFINS (vCOFINS). Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 nos grupos de COFINS com cálculo de imposto.
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo S02 - COFINSAliq (S11 - vCOFINS);</li>
   * <li>Grupo S03 - COFINSQtde (S11 - vCOFINS);</li>
   * <li>Grupo S05 - COFINSOutr (S11 - vCOFINS).</li>
   * </ul>
   * .
   *
   * @return the s11 - Valor da COFINS (vCOFINS)
   */
  public BigDecimal getVcofins() {
    return vcofins;
  }

  /**
   * # s11 - Valor da COFINS (vCOFINS). Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 nos grupos de COFINS com cálculo de imposto.
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo S02 - COFINSAliq (S11 - vCOFINS);</li>
   * <li>Grupo S03 - COFINSQtde (S11 - vCOFINS);</li>
   * <li>Grupo S05 - COFINSOutr (S11 - vCOFINS).</li>
   * </ul>
   * .
   *
   * @param vcofins the new s11 - Valor da COFINS (vCOFINS)
   */
  public void setVcofins(BigDecimal vcofins) {
    this.vcofins = vcofins;
  }

  /**
   * # s09 - Quantidade Vendida (qBCProd). Tipo: N, Tamanho: 12v0-4, Ocorrência: 1-1 nos cenários em que o cálculo da COFINS é por quantidade.
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo S03 - COFINSQtde (COFINS tributado por quantidade);</li>
   * <li>Grupo S05 - COFINSOutr, quando o cálculo for em valor por unidade (sequência S08.1).</li>
   * </ul>
   * .
   *
   * @return the s09 - Quantidade Vendida (qBCProd)
   */
  public BigDecimal getQbcProd() {
    return qbcProd;
  }

  /**
   * # s09 - Quantidade Vendida (qBCProd). Tipo: N, Tamanho: 12v0-4, Ocorrência: 1-1 nos cenários em que o cálculo da COFINS é por quantidade.
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo S03 - COFINSQtde (COFINS tributado por quantidade);</li>
   * <li>Grupo S05 - COFINSOutr, quando o cálculo for em valor por unidade (sequência S08.1).</li>
   * </ul>
   * .
   *
   * @param qbcProd the new s09 - Quantidade Vendida (qBCProd)
   */
  public void setQbcProd(BigDecimal qbcProd) {
    this.qbcProd = qbcProd;
  }

  /**
   * # s10 - Alíquota da COFINS em reais (vAliqProd). Tipo: N, Tamanho: 11v0-4, Ocorrência: 1-1 nos cenários em que o cálculo da COFINS é por quantidade (valor por unidade).
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo S03 - COFINSQtde;</li>
   * <li>Grupo S05 - COFINSOutr, quando o cálculo for em valor por unidade (sequência S08.1).</li>
   * </ul>
   * .
   *
   * @return the s10 - Alíquota da COFINS em reais (vAliqProd)
   */
  public BigDecimal getValiqProd() {
    return valiqProd;
  }

  /**
   * # s10 - Alíquota da COFINS em reais (vAliqProd). Tipo: N, Tamanho: 11v0-4, Ocorrência: 1-1 nos cenários em que o cálculo da COFINS é por quantidade (valor por unidade).
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo S03 - COFINSQtde;</li>
   * <li>Grupo S05 - COFINSOutr, quando o cálculo for em valor por unidade (sequência S08.1).</li>
   * </ul>
   * .
   *
   * @param valiqProd the new s10 - Alíquota da COFINS em reais (vAliqProd)
   */
  public void setValiqProd(BigDecimal valiqProd) {
    this.valiqProd = valiqProd;
  }

}
