package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Grupo de retenção de ICMS no transporte (TAG {@code retTransp}, ID X11).<br>
 * Utilizado para informar valores de retenção do ICMS incidente sobre o serviço de transporte, quando aplicável.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_ret_transp")
class RetTranspVO extends RFWVO {

  private static final long serialVersionUID = -5063432764183925607L;

  /**
   * ID: X12 – Campo {@code vServ}.<br>
   * Valor total do serviço de transporte sobre o qual incidirá o ICMS retido.<br>
   * Ocorrência 0-1, tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor do serviço", required = false, scale = 2, absolute = true)
  private BigDecimal vServ = null;

  /**
   * ID: X13 – Campo {@code vBCRet}.<br>
   * Base de cálculo do ICMS retido na prestação de serviço de transporte.<br>
   * Ocorrência 0-1, tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Base de cálculo ICMS retido", required = false, scale = 2, absolute = true)
  private BigDecimal vBCRet = null;

  /**
   * ID: X14 – Campo {@code pICMSRet}.<br>
   * Alíquota do ICMS aplicada sobre a base de cálculo do serviço de transporte.<br>
   * Ocorrência 0-1, tamanho 3v2-4.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota ICMS retido", required = false, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pICMSRet = null;

  /**
   * ID: X15 – Campo {@code vICMSRet}.<br>
   * Valor do ICMS efetivamente retido do serviço de transporte.<br>
   * Ocorrência 0-1, tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor ICMS retido", required = false, scale = 2, absolute = true)
  private BigDecimal vICMSRet = null;

  /**
   * ID: X16 – Campo {@code CFOP}.<br>
   * Código Fiscal de Operações e Prestações aplicável ao serviço de transporte.<br>
   * Ocorrência 0-1, tamanho 4 (tabela de CFOP específica para serviço de transporte).
   */
  @RFWMetaStringField(caption = "CFOP do transporte", required = false, maxLength = 4)
  private String cfop = null;

  /**
   * ID: X17 – Campo {@code cMunFG}.<br>
   * Código do município de ocorrência do fato gerador do ICMS do transporte.<br>
   * Preenchido com o código IBGE do município (7 dígitos).<br>
   * Ocorrência 0-1.
   */
  @RFWMetaStringField(caption = "Município do fato gerador", required = false, maxLength = 7)
  private String cMunFG = null;

  /**
   * # iD: X12 – Campo {@code vServ}.<br>
   * Valor total do serviço de transporte sobre o qual incidirá o ICMS retido.<br>
   * Ocorrência 0-1, tamanho 13v2.
   *
   * @return the iD: X12 – Campo {@code vServ}
   */
  public BigDecimal getVServ() {
    return vServ;
  }

  /**
   * # iD: X12 – Campo {@code vServ}.<br>
   * Valor total do serviço de transporte sobre o qual incidirá o ICMS retido.<br>
   * Ocorrência 0-1, tamanho 13v2.
   *
   * @param vServ the new iD: X12 – Campo {@code vServ}
   */
  public void setVServ(BigDecimal vServ) {
    this.vServ = vServ;
  }

  /**
   * # iD: X13 – Campo {@code vBCRet}.<br>
   * Base de cálculo do ICMS retido na prestação de serviço de transporte.<br>
   * Ocorrência 0-1, tamanho 13v2.
   *
   * @return the iD: X13 – Campo {@code vBCRet}
   */
  public BigDecimal getVBCRet() {
    return vBCRet;
  }

  /**
   * # iD: X13 – Campo {@code vBCRet}.<br>
   * Base de cálculo do ICMS retido na prestação de serviço de transporte.<br>
   * Ocorrência 0-1, tamanho 13v2.
   *
   * @param vBCRet the new iD: X13 – Campo {@code vBCRet}
   */
  public void setVBCRet(BigDecimal vBCRet) {
    this.vBCRet = vBCRet;
  }

  /**
   * # iD: X14 – Campo {@code pICMSRet}.<br>
   * Alíquota do ICMS aplicada sobre a base de cálculo do serviço de transporte.<br>
   * Ocorrência 0-1, tamanho 3v2-4.
   *
   * @return the iD: X14 – Campo {@code pICMSRet}
   */
  public BigDecimal getPICMSRet() {
    return pICMSRet;
  }

  /**
   * # iD: X14 – Campo {@code pICMSRet}.<br>
   * Alíquota do ICMS aplicada sobre a base de cálculo do serviço de transporte.<br>
   * Ocorrência 0-1, tamanho 3v2-4.
   *
   * @param pICMSRet the new iD: X14 – Campo {@code pICMSRet}
   */
  public void setPICMSRet(BigDecimal pICMSRet) {
    this.pICMSRet = pICMSRet;
  }

  /**
   * # iD: X15 – Campo {@code vICMSRet}.<br>
   * Valor do ICMS efetivamente retido do serviço de transporte.<br>
   * Ocorrência 0-1, tamanho 13v2.
   *
   * @return the iD: X15 – Campo {@code vICMSRet}
   */
  public BigDecimal getVICMSRet() {
    return vICMSRet;
  }

  /**
   * # iD: X15 – Campo {@code vICMSRet}.<br>
   * Valor do ICMS efetivamente retido do serviço de transporte.<br>
   * Ocorrência 0-1, tamanho 13v2.
   *
   * @param vICMSRet the new iD: X15 – Campo {@code vICMSRet}
   */
  public void setVICMSRet(BigDecimal vICMSRet) {
    this.vICMSRet = vICMSRet;
  }

  /**
   * # iD: X16 – Campo {@code CFOP}.<br>
   * Código Fiscal de Operações e Prestações aplicável ao serviço de transporte.<br>
   * Ocorrência 0-1, tamanho 4 (tabela de CFOP específica para serviço de transporte).
   *
   * @return the iD: X16 – Campo {@code CFOP}
   */
  public String getCfop() {
    return cfop;
  }

  /**
   * # iD: X16 – Campo {@code CFOP}.<br>
   * Código Fiscal de Operações e Prestações aplicável ao serviço de transporte.<br>
   * Ocorrência 0-1, tamanho 4 (tabela de CFOP específica para serviço de transporte).
   *
   * @param cfop the new iD: X16 – Campo {@code CFOP}
   */
  public void setCfop(String cfop) {
    this.cfop = cfop;
  }

  /**
   * # iD: X17 – Campo {@code cMunFG}.<br>
   * Código do município de ocorrência do fato gerador do ICMS do transporte.<br>
   * Preenchido com o código IBGE do município (7 dígitos).<br>
   * Ocorrência 0-1.
   *
   * @return the iD: X17 – Campo {@code cMunFG}
   */
  public String getCMunFG() {
    return cMunFG;
  }

  /**
   * # iD: X17 – Campo {@code cMunFG}.<br>
   * Código do município de ocorrência do fato gerador do ICMS do transporte.<br>
   * Preenchido com o código IBGE do município (7 dígitos).<br>
   * Ocorrência 0-1.
   *
   * @param cMunFG the new iD: X17 – Campo {@code cMunFG}
   */
  public void setCMunFG(String cMunFG) {
    this.cMunFG = cMunFG;
  }

}