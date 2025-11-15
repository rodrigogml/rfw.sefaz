package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Grupo X11 - retTransp: Retenção ICMS transporte.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_rettransp")
public class SEFAZRetTranspVO extends RFWVO {

  private static final long serialVersionUID = -1036600007842468280L;

  /**
   * {@link SEFAZTranspVO}
   */
  @RFWMetaRelationshipField(caption = "Transp", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_transp")
  private SEFAZTranspVO transpVO = null;

  /**
   * X12 - vServ: Valor do Serviço. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1.
   */
  @RFWMetaBigDecimalField(caption = "vServ", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vserv;

  /**
   * X13 - vBCRet: BC da Retenção do ICMS. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1.
   */
  @RFWMetaBigDecimalField(caption = "vBCRet", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vbcret;

  /**
   * X14 - pICMSRet: Alíquota da Retenção. Tipo: N, Tamanho: 3v2-4, Ocorrência: 1-1.
   */
  @RFWMetaBigDecimalField(caption = "pICMSRet", required = false, unique = false, maxValue = "", minValue = "", scale = 2, scaleMax = 4, absolute = false)
  private BigDecimal picmsRet;

  /**
   * X15 - vICMSRet: Valor do ICMS Retido. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1.
   */
  @RFWMetaBigDecimalField(caption = "vICMSRet", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vicmsRet;

  /**
   * X16 - CFOP: CFOP de Serviço de Transporte. Tipo: N, Tamanho: 4, Ocorrência: 1-1.
   */
  @RFWMetaStringField(caption = "CFOP", required = false, unique = false, maxLength = 4, minLength = 4, pattern = "^[0-9]{4}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cfop;

  /**
   * X17 - cMunFG: Código do município do fato gerador do ICMS do transporte. Tipo: N, Tamanho: 7, Ocorrência: 1-1. Utilizar tabela IBGE.
   */
  @RFWMetaStringField(caption = "cMunFG", required = false, unique = false, maxLength = 7, minLength = 7, pattern = "^[0-9]{7}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cmunFg;

  /**
   * # {@link SEFAZTranspVO}.
   *
   * @return the {@link SEFAZTranspVO}
   */
  public SEFAZTranspVO getTranspVO() {
    return transpVO;
  }

  /**
   * # {@link SEFAZTranspVO}.
   *
   * @param transpVO the new {@link SEFAZTranspVO}
   */
  public void setTranspVO(SEFAZTranspVO transpVO) {
    this.transpVO = transpVO;
  }

  /**
   * # x12 - vServ: Valor do Serviço. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1.
   *
   * @return the x12 - vServ: Valor do Serviço
   */
  public BigDecimal getVserv() {
    return vserv;
  }

  /**
   * # x12 - vServ: Valor do Serviço. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1.
   *
   * @param vserv the new x12 - vServ: Valor do Serviço
   */
  public void setVserv(BigDecimal vserv) {
    this.vserv = vserv;
  }

  /**
   * # x13 - vBCRet: BC da Retenção do ICMS. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1.
   *
   * @return the x13 - vBCRet: BC da Retenção do ICMS
   */
  public BigDecimal getVbcret() {
    return vbcret;
  }

  /**
   * # x13 - vBCRet: BC da Retenção do ICMS. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1.
   *
   * @param vbcret the new x13 - vBCRet: BC da Retenção do ICMS
   */
  public void setVbcret(BigDecimal vbcret) {
    this.vbcret = vbcret;
  }

  /**
   * # x14 - pICMSRet: Alíquota da Retenção. Tipo: N, Tamanho: 3v2-4, Ocorrência: 1-1.
   *
   * @return the x14 - pICMSRet: Alíquota da Retenção
   */
  public BigDecimal getPicmsRet() {
    return picmsRet;
  }

  /**
   * # x14 - pICMSRet: Alíquota da Retenção. Tipo: N, Tamanho: 3v2-4, Ocorrência: 1-1.
   *
   * @param picmsRet the new x14 - pICMSRet: Alíquota da Retenção
   */
  public void setPicmsRet(BigDecimal picmsRet) {
    this.picmsRet = picmsRet;
  }

  /**
   * # x15 - vICMSRet: Valor do ICMS Retido. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1.
   *
   * @return the x15 - vICMSRet: Valor do ICMS Retido
   */
  public BigDecimal getVicmsRet() {
    return vicmsRet;
  }

  /**
   * # x15 - vICMSRet: Valor do ICMS Retido. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1.
   *
   * @param vicmsRet the new x15 - vICMSRet: Valor do ICMS Retido
   */
  public void setVicmsRet(BigDecimal vicmsRet) {
    this.vicmsRet = vicmsRet;
  }

  /**
   * # x16 - CFOP: CFOP de Serviço de Transporte. Tipo: N, Tamanho: 4, Ocorrência: 1-1.
   *
   * @return the x16 - CFOP: CFOP de Serviço de Transporte
   */
  public String getCfop() {
    return cfop;
  }

  /**
   * # x16 - CFOP: CFOP de Serviço de Transporte. Tipo: N, Tamanho: 4, Ocorrência: 1-1.
   *
   * @param cfop the new x16 - CFOP: CFOP de Serviço de Transporte
   */
  public void setCfop(String cfop) {
    this.cfop = cfop;
  }

  /**
   * # x17 - cMunFG: Código do município do fato gerador do ICMS do transporte. Tipo: N, Tamanho: 7, Ocorrência: 1-1. Utilizar tabela IBGE.
   *
   * @return the x17 - cMunFG: Código do município do fato gerador do ICMS do transporte
   */
  public String getCmunFg() {
    return cmunFg;
  }

  /**
   * # x17 - cMunFG: Código do município do fato gerador do ICMS do transporte. Tipo: N, Tamanho: 7, Ocorrência: 1-1. Utilizar tabela IBGE.
   *
   * @param cmunFg the new x17 - cMunFG: Código do município do fato gerador do ICMS do transporte
   */
  public void setCmunFg(String cmunFg) {
    this.cmunFg = cmunFg;
  }

}
