package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Grupo NA01 - ICMSUFDest: Informação do ICMS Interestadual.
 * <p>
 * Ocorre 0-1 dentro do grupo M01 (ICMS do item). Deve ser informado nas vendas interestaduais para consumidor final, não contribuinte do ICMS.
 * <p>
 * Observação: este grupo não deve ser utilizado nas operações com veículos automotores novos efetuadas por meio de faturamento direto para o consumidor (Convênio ICMS 51/00), que utilizam o grupo específico ICMSPart.
 * <p>
 * Grupo criado na NT 2015/003. Campos relativos ao FCP incluídos/atualizados na NT 2016/002.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_icmsufdest")
public class ICMSUFDestVO extends RFWVO {

  private static final long serialVersionUID = 7072708775854053977L;

  /**
   * {@link ImpostoVO}
   */
  @RFWMetaRelationshipField(caption = "Imposto", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_imposto")
  private ImpostoVO impostoVO = null;

  /**
   * NA03 - Valor da BC do ICMS na UF de destino (vBCUFDest). Tipo: N, Tamanho: 13v2. Ocorrência: 1-1 (campo obrigatório dentro de ICMSUFDest). Descrição: Valor da Base de Cálculo do ICMS na UF de destino.
   */
  @RFWMetaBigDecimalField(caption = "vBCUFDest", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vbcUFDest;

  /**
   * NA04 - Valor da BC FCP na UF de destino (vBCFCPUFDest). Tipo: N, Tamanho: 13v2. Ocorrência: 1-1 (campo obrigatório dentro de ICMSUFDest). Descrição: Valor da Base de Cálculo do FCP na UF de destino. Observação: Campo incluído na NT 2016.002.
   */
  @RFWMetaBigDecimalField(caption = "vBCFCPUFDest", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vbcFCPIFDest;

  /**
   * NA05 - Percentual do ICMS relativo ao Fundo de Combate à Pobreza (FCP) na UF de destino (pFCPUFDest). Tipo: N, Tamanho: 3v2-4. Ocorrência: 0-1 (campo opcional dentro de ICMSUFDest). Descrição: Percentual adicional inserido na alíquota interna da UF de destino, relativo ao FCP naquela UF. Observação: percentual máximo de 2%, conforme legislação.
   */
  @RFWMetaBigDecimalField(caption = "pFCPUFDest", required = false, unique = false, maxValue = "", minValue = "", scale = 2, scaleMax = 4, absolute = false)
  private BigDecimal pfcpUFDest;

  /**
   * NA07 - Alíquota interna da UF de destino (pICMSUFDest). Tipo: N, Tamanho: 3v2-4. Ocorrência: 1-1 (campo obrigatório dentro de ICMSUFDest). Descrição: Alíquota adotada nas operações internas na UF de destino para o produto/mercadoria. Observação: a alíquota do FCP, se existente, deve ser informada em pFCPUFDest, não sendo somada a esta alíquota interna.
   */
  @RFWMetaBigDecimalField(caption = "pICMSUFDest", required = false, unique = false, maxValue = "", minValue = "", scale = 2, scaleMax = 4, absolute = false)
  private BigDecimal picmsUFDest;

  /**
   * NA09 - Alíquota interestadual das UF envolvidas (pICMSInter). Tipo: N, Tamanho: 2v2. Ocorrência: 1-1 (campo obrigatório dentro de ICMSUFDest). Descrição: Alíquota interestadual aplicável conforme legislação: - 4% para produtos importados; - 7% para operações de Estados do Sul e Sudeste (exceto ES) para Estados do Norte, Nordeste, Centro-Oeste e Espírito Santo; - 12% para as demais operações.
   */
  @RFWMetaBigDecimalField(caption = "pICMSInter", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal picmsInter;

  /**
   * NA11 - Percentual provisório de partilha do ICMS Interestadual (pICMSInterPart). Tipo: N, Tamanho: 3v2-4. Ocorrência: 1-1 (campo obrigatório dentro de ICMSUFDest). Descrição: Percentual provisório de partilha do ICMS Interestadual entre UF de origem e UF de destino, conforme período de transição: - 40% em 2016; - 60% em 2017; - 80% em 2018; - 100% a partir de 2019.
   */
  @RFWMetaBigDecimalField(caption = "pICMSInterPart", required = false, unique = false, maxValue = "", minValue = "", scale = 2, scaleMax = 4, absolute = false)
  private BigDecimal picmsInterPart;

  /**
   * NA13 - Valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP) da UF de destino (vFCPUFDest). Tipo: N, Tamanho: 13v2. Ocorrência: 0-1 (campo opcional dentro de ICMSUFDest). Descrição: Valor do ICMS relativo ao FCP da UF de destino. Observação: campo atualizado na NT 2016.002.
   */
  @RFWMetaBigDecimalField(caption = "vFCPUFDest", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vfcpUFDest;

  /**
   * NA15 - Valor do ICMS Interestadual para a UF de destino (vICMSUFDest). Tipo: N, Tamanho: 13v2. Ocorrência: 1-1 (campo obrigatório dentro de ICMSUFDest). Descrição: Valor do ICMS Interestadual para a UF de destino, já considerando o valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP) naquela UF.
   */
  @RFWMetaBigDecimalField(caption = "vICMSUFDest", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vicmsUFDest;

  /**
   * NA17 - Valor do ICMS Interestadual para a UF do remetente (vICMSUFRemet). Tipo: N, Tamanho: 13v2. Ocorrência: 1-1 (campo obrigatório dentro de ICMSUFDest). Descrição: Valor do ICMS Interestadual para a UF do remetente. Observação: a partir de 2019, este valor será zero.
   */
  @RFWMetaBigDecimalField(caption = "vICMSUFRemet", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vicmsUFRemet;

  /**
   * # {@link ImpostoVO}.
   *
   * @return the {@link ImpostoVO}
   */
  public ImpostoVO getImpostoVO() {
    return impostoVO;
  }

  /**
   * # {@link ImpostoVO}.
   *
   * @param impostoVO the new {@link ImpostoVO}
   */
  public void setImpostoVO(ImpostoVO impostoVO) {
    this.impostoVO = impostoVO;
  }

  /**
   * # nA03 - Valor da BC do ICMS na UF de destino (vBCUFDest). Tipo: N, Tamanho: 13v2. Ocorrência: 1-1 (campo obrigatório dentro de ICMSUFDest). Descrição: Valor da Base de Cálculo do ICMS na UF de destino.
   *
   * @return the nA03 - Valor da BC do ICMS na UF de destino (vBCUFDest)
   */
  public BigDecimal getVbcUFDest() {
    return vbcUFDest;
  }

  /**
   * # nA03 - Valor da BC do ICMS na UF de destino (vBCUFDest). Tipo: N, Tamanho: 13v2. Ocorrência: 1-1 (campo obrigatório dentro de ICMSUFDest). Descrição: Valor da Base de Cálculo do ICMS na UF de destino.
   *
   * @param vbcUFDest the new nA03 - Valor da BC do ICMS na UF de destino (vBCUFDest)
   */
  public void setVbcUFDest(BigDecimal vbcUFDest) {
    this.vbcUFDest = vbcUFDest;
  }

  /**
   * # nA04 - Valor da BC FCP na UF de destino (vBCFCPUFDest). Tipo: N, Tamanho: 13v2. Ocorrência: 1-1 (campo obrigatório dentro de ICMSUFDest). Descrição: Valor da Base de Cálculo do FCP na UF de destino. Observação: Campo incluído na NT 2016.002.
   *
   * @return the nA04 - Valor da BC FCP na UF de destino (vBCFCPUFDest)
   */
  public BigDecimal getVbcFCPIFDest() {
    return vbcFCPIFDest;
  }

  /**
   * # nA04 - Valor da BC FCP na UF de destino (vBCFCPUFDest). Tipo: N, Tamanho: 13v2. Ocorrência: 1-1 (campo obrigatório dentro de ICMSUFDest). Descrição: Valor da Base de Cálculo do FCP na UF de destino. Observação: Campo incluído na NT 2016.002.
   *
   * @param vbcFCPIFDest the new nA04 - Valor da BC FCP na UF de destino (vBCFCPUFDest)
   */
  public void setVbcFCPIFDest(BigDecimal vbcFCPIFDest) {
    this.vbcFCPIFDest = vbcFCPIFDest;
  }

  /**
   * # nA05 - Percentual do ICMS relativo ao Fundo de Combate à Pobreza (FCP) na UF de destino (pFCPUFDest). Tipo: N, Tamanho: 3v2-4. Ocorrência: 0-1 (campo opcional dentro de ICMSUFDest). Descrição: Percentual adicional inserido na alíquota interna da UF de destino, relativo ao FCP naquela UF. Observação: percentual máximo de 2%, conforme legislação.
   *
   * @return the nA05 - Percentual do ICMS relativo ao Fundo de Combate à Pobreza (FCP) na UF de destino (pFCPUFDest)
   */
  public BigDecimal getPfcpUFDest() {
    return pfcpUFDest;
  }

  /**
   * # nA05 - Percentual do ICMS relativo ao Fundo de Combate à Pobreza (FCP) na UF de destino (pFCPUFDest). Tipo: N, Tamanho: 3v2-4. Ocorrência: 0-1 (campo opcional dentro de ICMSUFDest). Descrição: Percentual adicional inserido na alíquota interna da UF de destino, relativo ao FCP naquela UF. Observação: percentual máximo de 2%, conforme legislação.
   *
   * @param pfcpUFDest the new nA05 - Percentual do ICMS relativo ao Fundo de Combate à Pobreza (FCP) na UF de destino (pFCPUFDest)
   */
  public void setPfcpUFDest(BigDecimal pfcpUFDest) {
    this.pfcpUFDest = pfcpUFDest;
  }

  /**
   * # nA07 - Alíquota interna da UF de destino (pICMSUFDest). Tipo: N, Tamanho: 3v2-4. Ocorrência: 1-1 (campo obrigatório dentro de ICMSUFDest). Descrição: Alíquota adotada nas operações internas na UF de destino para o produto/mercadoria. Observação: a alíquota do FCP, se existente, deve ser informada em pFCPUFDest, não sendo somada a esta alíquota interna.
   *
   * @return the nA07 - Alíquota interna da UF de destino (pICMSUFDest)
   */
  public BigDecimal getPicmsUFDest() {
    return picmsUFDest;
  }

  /**
   * # nA07 - Alíquota interna da UF de destino (pICMSUFDest). Tipo: N, Tamanho: 3v2-4. Ocorrência: 1-1 (campo obrigatório dentro de ICMSUFDest). Descrição: Alíquota adotada nas operações internas na UF de destino para o produto/mercadoria. Observação: a alíquota do FCP, se existente, deve ser informada em pFCPUFDest, não sendo somada a esta alíquota interna.
   *
   * @param picmsUFDest the new nA07 - Alíquota interna da UF de destino (pICMSUFDest)
   */
  public void setPicmsUFDest(BigDecimal picmsUFDest) {
    this.picmsUFDest = picmsUFDest;
  }

  /**
   * # nA09 - Alíquota interestadual das UF envolvidas (pICMSInter). Tipo: N, Tamanho: 2v2. Ocorrência: 1-1 (campo obrigatório dentro de ICMSUFDest). Descrição: Alíquota interestadual aplicável conforme legislação: - 4% para produtos importados; - 7% para operações de Estados do Sul e Sudeste (exceto ES) para Estados do Norte, Nordeste, Centro-Oeste e Espírito Santo; - 12% para as demais
   * operações.
   *
   * @return the nA09 - Alíquota interestadual das UF envolvidas (pICMSInter)
   */
  public BigDecimal getPicmsInter() {
    return picmsInter;
  }

  /**
   * # nA09 - Alíquota interestadual das UF envolvidas (pICMSInter). Tipo: N, Tamanho: 2v2. Ocorrência: 1-1 (campo obrigatório dentro de ICMSUFDest). Descrição: Alíquota interestadual aplicável conforme legislação: - 4% para produtos importados; - 7% para operações de Estados do Sul e Sudeste (exceto ES) para Estados do Norte, Nordeste, Centro-Oeste e Espírito Santo; - 12% para as demais
   * operações.
   *
   * @param picmsInter the new nA09 - Alíquota interestadual das UF envolvidas (pICMSInter)
   */
  public void setPicmsInter(BigDecimal picmsInter) {
    this.picmsInter = picmsInter;
  }

  /**
   * # nA11 - Percentual provisório de partilha do ICMS Interestadual (pICMSInterPart). Tipo: N, Tamanho: 3v2-4. Ocorrência: 1-1 (campo obrigatório dentro de ICMSUFDest). Descrição: Percentual provisório de partilha do ICMS Interestadual entre UF de origem e UF de destino, conforme período de transição: - 40% em 2016; - 60% em 2017; - 80% em 2018; - 100% a partir de 2019.
   *
   * @return the nA11 - Percentual provisório de partilha do ICMS Interestadual (pICMSInterPart)
   */
  public BigDecimal getPicmsInterPart() {
    return picmsInterPart;
  }

  /**
   * # nA11 - Percentual provisório de partilha do ICMS Interestadual (pICMSInterPart). Tipo: N, Tamanho: 3v2-4. Ocorrência: 1-1 (campo obrigatório dentro de ICMSUFDest). Descrição: Percentual provisório de partilha do ICMS Interestadual entre UF de origem e UF de destino, conforme período de transição: - 40% em 2016; - 60% em 2017; - 80% em 2018; - 100% a partir de 2019.
   *
   * @param picmsInterPart the new nA11 - Percentual provisório de partilha do ICMS Interestadual (pICMSInterPart)
   */
  public void setPicmsInterPart(BigDecimal picmsInterPart) {
    this.picmsInterPart = picmsInterPart;
  }

  /**
   * # nA13 - Valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP) da UF de destino (vFCPUFDest). Tipo: N, Tamanho: 13v2. Ocorrência: 0-1 (campo opcional dentro de ICMSUFDest). Descrição: Valor do ICMS relativo ao FCP da UF de destino. Observação: campo atualizado na NT 2016.002.
   *
   * @return the nA13 - Valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP) da UF de destino (vFCPUFDest)
   */
  public BigDecimal getVfcpUFDest() {
    return vfcpUFDest;
  }

  /**
   * # nA13 - Valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP) da UF de destino (vFCPUFDest). Tipo: N, Tamanho: 13v2. Ocorrência: 0-1 (campo opcional dentro de ICMSUFDest). Descrição: Valor do ICMS relativo ao FCP da UF de destino. Observação: campo atualizado na NT 2016.002.
   *
   * @param vfcpUFDest the new nA13 - Valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP) da UF de destino (vFCPUFDest)
   */
  public void setVfcpUFDest(BigDecimal vfcpUFDest) {
    this.vfcpUFDest = vfcpUFDest;
  }

  /**
   * # nA15 - Valor do ICMS Interestadual para a UF de destino (vICMSUFDest). Tipo: N, Tamanho: 13v2. Ocorrência: 1-1 (campo obrigatório dentro de ICMSUFDest). Descrição: Valor do ICMS Interestadual para a UF de destino, já considerando o valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP) naquela UF.
   *
   * @return the nA15 - Valor do ICMS Interestadual para a UF de destino (vICMSUFDest)
   */
  public BigDecimal getVicmsUFDest() {
    return vicmsUFDest;
  }

  /**
   * # nA15 - Valor do ICMS Interestadual para a UF de destino (vICMSUFDest). Tipo: N, Tamanho: 13v2. Ocorrência: 1-1 (campo obrigatório dentro de ICMSUFDest). Descrição: Valor do ICMS Interestadual para a UF de destino, já considerando o valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP) naquela UF.
   *
   * @param vicmsUFDest the new nA15 - Valor do ICMS Interestadual para a UF de destino (vICMSUFDest)
   */
  public void setVicmsUFDest(BigDecimal vicmsUFDest) {
    this.vicmsUFDest = vicmsUFDest;
  }

  /**
   * # nA17 - Valor do ICMS Interestadual para a UF do remetente (vICMSUFRemet). Tipo: N, Tamanho: 13v2. Ocorrência: 1-1 (campo obrigatório dentro de ICMSUFDest). Descrição: Valor do ICMS Interestadual para a UF do remetente. Observação: a partir de 2019, este valor será zero.
   *
   * @return the nA17 - Valor do ICMS Interestadual para a UF do remetente (vICMSUFRemet)
   */
  public BigDecimal getVicmsUFRemet() {
    return vicmsUFRemet;
  }

  /**
   * # nA17 - Valor do ICMS Interestadual para a UF do remetente (vICMSUFRemet). Tipo: N, Tamanho: 13v2. Ocorrência: 1-1 (campo obrigatório dentro de ICMSUFDest). Descrição: Valor do ICMS Interestadual para a UF do remetente. Observação: a partir de 2019, este valor será zero.
   *
   * @param vicmsUFRemet the new nA17 - Valor do ICMS Interestadual para a UF do remetente (vICMSUFRemet)
   */
  public void setVicmsUFRemet(BigDecimal vicmsUFRemet) {
    this.vicmsUFRemet = vicmsUFRemet;
  }
}
