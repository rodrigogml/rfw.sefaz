/*
 *
 */
package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;
import java.util.Date;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaDateField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_cRegTrib;

/**
 * Grupo W17 - ISSQNtot: Totais referentes ao ISSQN.
 * <p>
 * Ocorre 0-1 dentro do grupo W01 (total da NF-e).
 * <p>
 * Campos de totais de serviços não sujeitos ao ICMS, base de cálculo, ISS, PIS/COFINS sobre serviços, descontos, deduções, retenções e regime especial de tributação.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_issqntot")
public class SEFAZISSQNTotVO extends RFWVO {

  private static final long serialVersionUID = 2572495866482114588L;

  /**
   * {@link SEFAZTotalVO}
   */
  @RFWMetaRelationshipField(caption = "Total", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_total")
  private SEFAZTotalVO totalVO = null;

  /**
   * W18 - vServ: Valor total dos serviços sob não incidência ou não tributados pelo ICMS. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   */
  @RFWMetaBigDecimalField(caption = "vServ", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vserv;

  /**
   * W19 - vBC: Valor total da Base de Cálculo do ISS. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   */
  @RFWMetaBigDecimalField(caption = "vBC", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vbc;

  /**
   * W20 - vISS: Valor total do ISS. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   */
  @RFWMetaBigDecimalField(caption = "vISS", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal viss;

  /**
   * W21 - vPIS: Valor total do PIS sobre serviços. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   */
  @RFWMetaBigDecimalField(caption = "vPIS", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vpis;

  /**
   * W22 - vCOFINS: Valor total da COFINS sobre serviços. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   */
  @RFWMetaBigDecimalField(caption = "vCOFINS", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vcofins;

  /**
   * W22a - dCompet: Data da prestação do serviço. Tipo: N (data AAAA-MM-DD), Tamanho: 8, Ocorrência: 1-1 (obrigatório na estrutura).
   */
  @RFWMetaDateField(caption = "dCompet", required = false, unique = false)
  private Date dcompet;

  /**
   * W22b - vDeducao: Valor total dedução para redução da Base de Cálculo. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   */
  @RFWMetaBigDecimalField(caption = "vDeducao", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vdeducao;

  /**
   * W22c - vOutro: Valor total outras retenções (valor declaratório). Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   */
  @RFWMetaBigDecimalField(caption = "vOutro", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal voutro;

  /**
   * W22d - vDescIncond: Valor total desconto incondicionado. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   */
  @RFWMetaBigDecimalField(caption = "vDescIncond", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vdescIncond;

  /**
   * W22e - vDescCond: Valor total desconto condicionado. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   */
  @RFWMetaBigDecimalField(caption = "vDescCond", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vdescCond;

  /**
   * W22f - vISSRet: Valor total retenção ISS. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   */
  @RFWMetaBigDecimalField(caption = "vISSRet", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vissRet;

  /**
   * W22g - cRegTrib: Código do Regime Especial de Tributação. Tipo: N, Tamanho: 2, Ocorrência: 0-1 (campo opcional).
   * <p>
   * Valores: 1 = Microempresa Municipal<br>
   * 2 = Estimativa<br>
   * 3 = Sociedade de Profissionais<br>
   * 4 = Cooperativa<br>
   * 5 = Microempresário Individual (MEI)<br>
   * 6 = Microempresário e Empresa de Pequeno Porte.
   */
  @RFWMetaEnumField(caption = "cRegTrib", required = false)
  private SEFAZ_cRegTrib cregTrib;

  /**
   * # {@link SEFAZTotalVO}.
   *
   * @return the {@link SEFAZTotalVO}
   */
  public SEFAZTotalVO getTotalVO() {
    return totalVO;
  }

  /**
   * # {@link SEFAZTotalVO}.
   *
   * @param totalVO the new {@link SEFAZTotalVO}
   */
  public void setTotalVO(SEFAZTotalVO totalVO) {
    this.totalVO = totalVO;
  }

  /**
   * # w18 - vServ: Valor total dos serviços sob não incidência ou não tributados pelo ICMS. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @return the w18 - vServ: Valor total dos serviços sob não incidência ou não tributados pelo ICMS
   */
  public BigDecimal getVserv() {
    return vserv;
  }

  /**
   * # w18 - vServ: Valor total dos serviços sob não incidência ou não tributados pelo ICMS. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @param vserv the new w18 - vServ: Valor total dos serviços sob não incidência ou não tributados pelo ICMS
   */
  public void setVserv(BigDecimal vserv) {
    this.vserv = vserv;
  }

  /**
   * # w19 - vBC: Valor total da Base de Cálculo do ISS. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @return the w19 - vBC: Valor total da Base de Cálculo do ISS
   */
  public BigDecimal getVbc() {
    return vbc;
  }

  /**
   * # w19 - vBC: Valor total da Base de Cálculo do ISS. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @param vbc the new w19 - vBC: Valor total da Base de Cálculo do ISS
   */
  public void setVbc(BigDecimal vbc) {
    this.vbc = vbc;
  }

  /**
   * # w20 - vISS: Valor total do ISS. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @return the w20 - vISS: Valor total do ISS
   */
  public BigDecimal getViss() {
    return viss;
  }

  /**
   * # w20 - vISS: Valor total do ISS. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @param viss the new w20 - vISS: Valor total do ISS
   */
  public void setViss(BigDecimal viss) {
    this.viss = viss;
  }

  /**
   * # w21 - vPIS: Valor total do PIS sobre serviços. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @return the w21 - vPIS: Valor total do PIS sobre serviços
   */
  public BigDecimal getVpis() {
    return vpis;
  }

  /**
   * # w21 - vPIS: Valor total do PIS sobre serviços. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @param vpis the new w21 - vPIS: Valor total do PIS sobre serviços
   */
  public void setVpis(BigDecimal vpis) {
    this.vpis = vpis;
  }

  /**
   * # w22 - vCOFINS: Valor total da COFINS sobre serviços. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @return the w22 - vCOFINS: Valor total da COFINS sobre serviços
   */
  public BigDecimal getVcofins() {
    return vcofins;
  }

  /**
   * # w22 - vCOFINS: Valor total da COFINS sobre serviços. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @param vcofins the new w22 - vCOFINS: Valor total da COFINS sobre serviços
   */
  public void setVcofins(BigDecimal vcofins) {
    this.vcofins = vcofins;
  }

  /**
   * # w22a - dCompet: Data da prestação do serviço. Tipo: N (data AAAA-MM-DD), Tamanho: 8, Ocorrência: 1-1 (obrigatório na estrutura).
   *
   * @return the w22a - dCompet: Data da prestação do serviço
   */
  public Date getDcompet() {
    return dcompet;
  }

  /**
   * # w22a - dCompet: Data da prestação do serviço. Tipo: N (data AAAA-MM-DD), Tamanho: 8, Ocorrência: 1-1 (obrigatório na estrutura).
   *
   * @param dcompet the new w22a - dCompet: Data da prestação do serviço
   */
  public void setDcompet(Date dcompet) {
    this.dcompet = dcompet;
  }

  /**
   * # w22b - vDeducao: Valor total dedução para redução da Base de Cálculo. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @return the w22b - vDeducao: Valor total dedução para redução da Base de Cálculo
   */
  public BigDecimal getVdeducao() {
    return vdeducao;
  }

  /**
   * # w22b - vDeducao: Valor total dedução para redução da Base de Cálculo. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @param vdeducao the new w22b - vDeducao: Valor total dedução para redução da Base de Cálculo
   */
  public void setVdeducao(BigDecimal vdeducao) {
    this.vdeducao = vdeducao;
  }

  /**
   * # w22c - vOutro: Valor total outras retenções (valor declaratório). Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @return the w22c - vOutro: Valor total outras retenções (valor declaratório)
   */
  public BigDecimal getVoutro() {
    return voutro;
  }

  /**
   * # w22c - vOutro: Valor total outras retenções (valor declaratório). Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @param voutro the new w22c - vOutro: Valor total outras retenções (valor declaratório)
   */
  public void setVoutro(BigDecimal voutro) {
    this.voutro = voutro;
  }

  /**
   * # w22d - vDescIncond: Valor total desconto incondicionado. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @return the w22d - vDescIncond: Valor total desconto incondicionado
   */
  public BigDecimal getVdescIncond() {
    return vdescIncond;
  }

  /**
   * # w22d - vDescIncond: Valor total desconto incondicionado. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @param vdescIncond the new w22d - vDescIncond: Valor total desconto incondicionado
   */
  public void setVdescIncond(BigDecimal vdescIncond) {
    this.vdescIncond = vdescIncond;
  }

  /**
   * # w22e - vDescCond: Valor total desconto condicionado. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @return the w22e - vDescCond: Valor total desconto condicionado
   */
  public BigDecimal getVdescCond() {
    return vdescCond;
  }

  /**
   * # w22e - vDescCond: Valor total desconto condicionado. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @param vdescCond the new w22e - vDescCond: Valor total desconto condicionado
   */
  public void setVdescCond(BigDecimal vdescCond) {
    this.vdescCond = vdescCond;
  }

  /**
   * # w22f - vISSRet: Valor total retenção ISS. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @return the w22f - vISSRet: Valor total retenção ISS
   */
  public BigDecimal getVissRet() {
    return vissRet;
  }

  /**
   * # w22f - vISSRet: Valor total retenção ISS. Tipo: N, Tamanho: 13v2, Ocorrência: 0-1 (campo opcional).
   *
   * @param vissRet the new w22f - vISSRet: Valor total retenção ISS
   */
  public void setVissRet(BigDecimal vissRet) {
    this.vissRet = vissRet;
  }

  /**
   * # w22g - cRegTrib: Código do Regime Especial de Tributação. Tipo: N, Tamanho: 2, Ocorrência: 0-1 (campo opcional).
   * <p>
   * Valores: 1 = Microempresa Municipal<br>
   * 2 = Estimativa<br>
   * 3 = Sociedade de Profissionais<br>
   * 4 = Cooperativa<br>
   * 5 = Microempresário Individual (MEI)<br>
   * 6 = Microempresário e Empresa de Pequeno Porte.
   *
   * @return the w22g - cRegTrib: Código do Regime Especial de Tributação
   */
  public SEFAZ_cRegTrib getCregTrib() {
    return cregTrib;
  }

  /**
   * # w22g - cRegTrib: Código do Regime Especial de Tributação. Tipo: N, Tamanho: 2, Ocorrência: 0-1 (campo opcional).
   * <p>
   * Valores: 1 = Microempresa Municipal<br>
   * 2 = Estimativa<br>
   * 3 = Sociedade de Profissionais<br>
   * 4 = Cooperativa<br>
   * 5 = Microempresário Individual (MEI)<br>
   * 6 = Microempresário e Empresa de Pequeno Porte.
   *
   * @param cregTrib the new w22g - cRegTrib: Código do Regime Especial de Tributação
   */
  public void setCregTrib(SEFAZ_cRegTrib cregTrib) {
    this.cregTrib = cregTrib;
  }
}
