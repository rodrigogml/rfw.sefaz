package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CST_PIS;

/**
 * Grupo Q01 - PIS (Grupo PIS).
 * <p>
 * Ocorre 0-1 dentro do grupo M01 (imposto do item). Deve ser informado apenas quando o item for sujeito ao PIS.
 * <p>
 * Estrutura que concentra todos os campos dos subgrupos de PIS do leiaute da NF-e:
 * <ul>
 * <li>Q02 - PISAliq: PIS tributado pela alíquota (CST 01, 02, com base em valor e alíquota percentual);</li>
 * <li>Q03 - PISQtde: PIS tributado por quantidade (CST 03, com base em quantidade × alíquota em reais);</li>
 * <li>Q04 - PISNT: PIS não tributado (CST 04, 05, 06, 07, 08, 09);</li>
 * <li>Q05 - PISOutr: PIS outras operações (CST 49, 50–56, 60–67, 70–75, 98, 99).</li>
 * </ul>
 * Na estrutura XML original apenas um dos grupos Q02, Q03, Q04 ou Q05 é informado por item, conforme o valor atribuído ao campo Q06 – CST do PIS. Neste VO, os campos necessários para todos os cenários foram unificados.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_pis")
public class SEFAZPISVO extends RFWVO {

  private static final long serialVersionUID = 6234263367530348602L;

  /**
   * {@link SEFAZImpostoVO}
   */
  @RFWMetaRelationshipField(caption = "Imposto", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_imposto")
  private SEFAZImpostoVO impostoVO = null;

  /**
   * Q06 - Código de Situação Tributária do PIS (CST). Tipo: N, Tamanho: 2, Ocorrência: 1-1 (campo obrigatório na estrutura da NF-e).
   * <p>
   * Utiliza a enumeração SEFAZ_CST_PIS, contemplando os códigos das situações tributáveis por alíquota, por quantidade, não tributadas e outras operações (PISAliq, PISQtde, PISNT, PISOutr).
   */
  @RFWMetaEnumField(caption = "CST", required = false)
  private SEFAZ_CST_PIS cst;

  /**
   * Q07 - Valor da Base de Cálculo do PIS (vBC). Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 nos cenários em que o cálculo do PIS é em percentual.
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo Q02 - PISAliq (PIS tributado pela alíquota em percentual);</li>
   * <li>Grupo Q05 - PISOutr, quando o cálculo for em percentual (sequência Q06.1).</li>
   * </ul>
   */
  @RFWMetaBigDecimalField(caption = "vBC", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vbc;

  /**
   * Q08 - Alíquota do PIS em percentual (pPIS). Tipo: N, Tamanho: 3v2-4, Ocorrência: 1-1 nos cenários em que o cálculo do PIS é em percentual.
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo Q02 - PISAliq;</li>
   * <li>Grupo Q05 - PISOutr, quando o cálculo for em percentual (sequência Q06.1).</li>
   * </ul>
   */
  @RFWMetaBigDecimalField(caption = "pPIS", required = false, unique = false, maxValue = "", minValue = "", scale = 2, scaleMax = 4, absolute = false)
  private BigDecimal ppis;

  /**
   * Q09 - Valor do PIS (vPIS). Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 nos grupos de PIS com cálculo de imposto.
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo Q02 - PISAliq (Q09 - vPIS);</li>
   * <li>Grupo Q03 - PISQtde (Q09 - vPIS).</li>
   * </ul>
   * No caso do grupo PISOutr (Q05), o valor do PIS também é determinado a partir da base e alíquota (percentual ou em valor) e gravado neste mesmo campo vPIS no XML.
   */
  @RFWMetaBigDecimalField(caption = "vPIS", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vpis;

  /**
   * Q10 - Quantidade Vendida (qBCProd). Tipo: N, Tamanho: 12v0-4, Ocorrência: 1-1 nos cenários em que o cálculo do PIS é por quantidade.
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo Q03 - PISQtde (PIS tributado por quantidade);</li>
   * <li>Grupo Q05 - PISOutr, quando o cálculo for em valor por unidade (sequência Q08.1).</li>
   * </ul>
   */
  @RFWMetaBigDecimalField(caption = "qBCProd", required = false, unique = false, maxValue = "", minValue = "", scale = 0, scaleMax = 4, absolute = false)
  private BigDecimal qbcProd;

  /**
   * Q11 - Alíquota do PIS em reais (vAliqProd). Tipo: N, Tamanho: 11v0-4, Ocorrência: 1-1 nos cenários em que o cálculo do PIS é por quantidade (valor por unidade).
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo Q03 - PISQtde;</li>
   * <li>Grupo Q05 - PISOutr, quando o cálculo for em valor por unidade (sequência Q08.1).</li>
   * </ul>
   */
  @RFWMetaBigDecimalField(caption = "vAliqProd", required = false, unique = false, maxValue = "", minValue = "", scale = 0, scaleMax = 4, absolute = false)
  private BigDecimal valiqProd;

  /**
   * # q06 - Código de Situação Tributária do PIS (CST). Tipo: N, Tamanho: 2, Ocorrência: 1-1 (campo obrigatório na estrutura da NF-e).
   * <p>
   * Utiliza a enumeração SEFAZ_CST_PIS, contemplando os códigos das situações tributáveis por alíquota, por quantidade, não tributadas e outras operações (PISAliq, PISQtde, PISNT, PISOutr).
   *
   * @return the q06 - Código de Situação Tributária do PIS (CST)
   */
  public SEFAZ_CST_PIS getCst() {
    return cst;
  }

  /**
   * # q06 - Código de Situação Tributária do PIS (CST). Tipo: N, Tamanho: 2, Ocorrência: 1-1 (campo obrigatório na estrutura da NF-e).
   * <p>
   * Utiliza a enumeração SEFAZ_CST_PIS, contemplando os códigos das situações tributáveis por alíquota, por quantidade, não tributadas e outras operações (PISAliq, PISQtde, PISNT, PISOutr).
   *
   * @param cst the new q06 - Código de Situação Tributária do PIS (CST)
   */
  public void setCst(SEFAZ_CST_PIS cst) {
    this.cst = cst;
  }

  /**
   * # q07 - Valor da Base de Cálculo do PIS (vBC). Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 nos cenários em que o cálculo do PIS é em percentual.
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo Q02 - PISAliq (PIS tributado pela alíquota em percentual);</li>
   * <li>Grupo Q05 - PISOutr, quando o cálculo for em percentual (sequência Q06.1).</li>
   * </ul>
   * .
   *
   * @return the q07 - Valor da Base de Cálculo do PIS (vBC)
   */
  public BigDecimal getVbc() {
    return vbc;
  }

  /**
   * # q07 - Valor da Base de Cálculo do PIS (vBC). Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 nos cenários em que o cálculo do PIS é em percentual.
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo Q02 - PISAliq (PIS tributado pela alíquota em percentual);</li>
   * <li>Grupo Q05 - PISOutr, quando o cálculo for em percentual (sequência Q06.1).</li>
   * </ul>
   * .
   *
   * @param vbc the new q07 - Valor da Base de Cálculo do PIS (vBC)
   */
  public void setVbc(BigDecimal vbc) {
    this.vbc = vbc;
  }

  /**
   * # q08 - Alíquota do PIS em percentual (pPIS). Tipo: N, Tamanho: 3v2-4, Ocorrência: 1-1 nos cenários em que o cálculo do PIS é em percentual.
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo Q02 - PISAliq;</li>
   * <li>Grupo Q05 - PISOutr, quando o cálculo for em percentual (sequência Q06.1).</li>
   * </ul>
   * .
   *
   * @return the q08 - Alíquota do PIS em percentual (pPIS)
   */
  public BigDecimal getPpis() {
    return ppis;
  }

  /**
   * # q08 - Alíquota do PIS em percentual (pPIS). Tipo: N, Tamanho: 3v2-4, Ocorrência: 1-1 nos cenários em que o cálculo do PIS é em percentual.
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo Q02 - PISAliq;</li>
   * <li>Grupo Q05 - PISOutr, quando o cálculo for em percentual (sequência Q06.1).</li>
   * </ul>
   * .
   *
   * @param ppis the new q08 - Alíquota do PIS em percentual (pPIS)
   */
  public void setPpis(BigDecimal ppis) {
    this.ppis = ppis;
  }

  /**
   * # q09 - Valor do PIS (vPIS). Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 nos grupos de PIS com cálculo de imposto.
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo Q02 - PISAliq (Q09 - vPIS);</li>
   * <li>Grupo Q03 - PISQtde (Q09 - vPIS).</li>
   * </ul>
   * No caso do grupo PISOutr (Q05), o valor do PIS também é determinado a partir da base e alíquota (percentual ou em valor) e gravado neste mesmo campo vPIS no XML.
   *
   * @return the q09 - Valor do PIS (vPIS)
   */
  public BigDecimal getVpis() {
    return vpis;
  }

  /**
   * # q09 - Valor do PIS (vPIS). Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 nos grupos de PIS com cálculo de imposto.
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo Q02 - PISAliq (Q09 - vPIS);</li>
   * <li>Grupo Q03 - PISQtde (Q09 - vPIS).</li>
   * </ul>
   * No caso do grupo PISOutr (Q05), o valor do PIS também é determinado a partir da base e alíquota (percentual ou em valor) e gravado neste mesmo campo vPIS no XML.
   *
   * @param vpis the new q09 - Valor do PIS (vPIS)
   */
  public void setVpis(BigDecimal vpis) {
    this.vpis = vpis;
  }

  /**
   * # q10 - Quantidade Vendida (qBCProd). Tipo: N, Tamanho: 12v0-4, Ocorrência: 1-1 nos cenários em que o cálculo do PIS é por quantidade.
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo Q03 - PISQtde (PIS tributado por quantidade);</li>
   * <li>Grupo Q05 - PISOutr, quando o cálculo for em valor por unidade (sequência Q08.1).</li>
   * </ul>
   * .
   *
   * @return the q10 - Quantidade Vendida (qBCProd)
   */
  public BigDecimal getQbcProd() {
    return qbcProd;
  }

  /**
   * # q10 - Quantidade Vendida (qBCProd). Tipo: N, Tamanho: 12v0-4, Ocorrência: 1-1 nos cenários em que o cálculo do PIS é por quantidade.
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo Q03 - PISQtde (PIS tributado por quantidade);</li>
   * <li>Grupo Q05 - PISOutr, quando o cálculo for em valor por unidade (sequência Q08.1).</li>
   * </ul>
   * .
   *
   * @param qbcProd the new q10 - Quantidade Vendida (qBCProd)
   */
  public void setQbcProd(BigDecimal qbcProd) {
    this.qbcProd = qbcProd;
  }

  /**
   * # q11 - Alíquota do PIS em reais (vAliqProd). Tipo: N, Tamanho: 11v0-4, Ocorrência: 1-1 nos cenários em que o cálculo do PIS é por quantidade (valor por unidade).
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo Q03 - PISQtde;</li>
   * <li>Grupo Q05 - PISOutr, quando o cálculo for em valor por unidade (sequência Q08.1).</li>
   * </ul>
   * .
   *
   * @return the q11 - Alíquota do PIS em reais (vAliqProd)
   */
  public BigDecimal getValiqProd() {
    return valiqProd;
  }

  /**
   * # q11 - Alíquota do PIS em reais (vAliqProd). Tipo: N, Tamanho: 11v0-4, Ocorrência: 1-1 nos cenários em que o cálculo do PIS é por quantidade (valor por unidade).
   * <p>
   * Utilização na estrutura XML:
   * <ul>
   * <li>Grupo Q03 - PISQtde;</li>
   * <li>Grupo Q05 - PISOutr, quando o cálculo for em valor por unidade (sequência Q08.1).</li>
   * </ul>
   * .
   *
   * @param valiqProd the new q11 - Alíquota do PIS em reais (vAliqProd)
   */
  public void setValiqProd(BigDecimal valiqProd) {
    this.valiqProd = valiqProd;
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