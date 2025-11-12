package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CST_IPI;

/**
 * Description: Informações do IPI do item (TAG {@code IPI}, ID O01).<br>
 * Esta classe consolida os campos da tag IPI e dos grupos filhos IPITrib (ID O06) e IPIInt (ID O10) diretamente em um único VO.<br>
 * <br>
 * Observação: apenas um conjunto de campos deve ser utilizado por item:
 * <ul>
 * <li>Grupo IPITrib – quando houver tributação de IPI (campos de base, alíquota, valor);</li>
 * <li>Grupo IPIInt – quando o IPI não for tributado (apenas CST).</li>
 * </ul>
 *
 * @author BIS DEVil
 * @since (11 de nov. de 2025)
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_ipi")
public class IPIVO extends RFWVO {

  private static final long serialVersionUID = 7465328745632874563L;

  /**
   * ID: O02<br>
   * CNPJ do produtor da mercadoria, quando diferente do emitente.<br>
   * Preenchido nas operações em que o produtor não é o próprio emitente.<br>
   * Deve ser informado apenas com algarismos, sem máscara.
   */
  @RFWMetaStringField(caption = "CNPJ do produtor", required = false, maxLength = 14, pattern = "[0-9]{14}")
  private String cnpjProd = null;

  /**
   * ID: O03<br>
   * Código do selo de controle do IPI, quando aplicável ao produto.<br>
   * Campo alfanumérico, geralmente informado em operações com bebidas e cigarros.
   */
  @RFWMetaStringField(caption = "Código do selo IPI", required = false, maxLength = 60)
  private String cSelo = null;

  /**
   * ID: O04<br>
   * Quantidade de selos de controle do IPI aplicados ao produto.<br>
   * Quantidade inteira (sem casas decimais).
   */
  @RFWMetaBigDecimalField(caption = "Quantidade de selos IPI", required = false, scale = 0, absolute = true)
  private BigDecimal qSelo = null;

  /**
   * ID: O05<br>
   * Código de enquadramento legal do IPI (cEnq).<br>
   * Código numérico de 3 posições definido pela legislação do IPI.
   */
  @RFWMetaStringField(caption = "Enquadramento legal IPI", required = false, maxLength = 3, pattern = "[0-9]{3}")
  private String cEnq = null;

  /**
   * ID: O07 / O11<br>
   * Situação Tributária do IPI (CST), utilizada tanto para o grupo IPITrib (O06) quanto para o grupo IPIInt (O10).<br>
   * Valores conforme {@link SEFAZ_IPI_CST}.
   */
  @RFWMetaEnumField(caption = "Situação tributária IPI", required = false)
  private SEFAZ_CST_IPI cst = null;

  /**
   * ID: O08 (IPITrib)<br>
   * Valor da Base de Cálculo do IPI (vBC).<br>
   * Utilizado quando o IPI é tributado pela base de cálculo em valor monetário.<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Base de cálculo IPI", required = false, scale = 2, absolute = true)
  private BigDecimal vBC = null;

  /**
   * ID: O09 (IPITrib)<br>
   * Quantidade total na unidade padrão de tributação (qUnid).<br>
   * Utilizado quando o IPI é tributado por unidade de produto em vez de percentual.<br>
   * Tamanho aproximado 11v0-4 (até 4 casas decimais).
   */
  @RFWMetaBigDecimalField(caption = "Quantidade tributável IPI", required = false, scale = 0, scaleMax = 4, absolute = true)
  private BigDecimal qUnid = null;

  /**
   * ID: O10 (IPITrib)<br>
   * Valor por unidade de tributação (vUnid).<br>
   * Utilizado em conjunto com {@link #qUnid} quando o IPI é cobrado por unidade.<br>
   * Tamanho aproximado 11v0-4 (até 4 casas decimais).
   */
  @RFWMetaBigDecimalField(caption = "Valor por unidade IPI", required = false, scale = 0, scaleMax = 4, absolute = true)
  private BigDecimal vUnid = null;

  /**
   * ID: O11 (IPITrib)<br>
   * Alíquota do IPI em percentual (pIPI).<br>
   * Utilizada quando o IPI é tributado ad valorem, sobre a base de cálculo em valor.<br>
   * Tamanho 3v2-4 (duas a quatro casas decimais).
   */
  @RFWMetaBigDecimalField(caption = "Alíquota IPI", required = false, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pIPI = null;

  /**
   * ID: O12 (IPITrib)<br>
   * Valor total do IPI incidente sobre o item (vIPI).<br>
   * Resultado do cálculo pela base de cálculo/quantidade e alíquota informadas.<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor do IPI", required = false, scale = 2, absolute = true)
  private BigDecimal vIPI = null;

  /**
   * # iD: O02<br>
   * CNPJ do produtor da mercadoria, quando diferente do emitente.<br>
   * Preenchido nas operações em que o produtor não é o próprio emitente.<br>
   * Deve ser informado apenas com algarismos, sem máscara.
   *
   * @return the iD: O02<br>
   *         CNPJ do produtor da mercadoria, quando diferente do emitente
   */
  public String getCnpjProd() {
    return cnpjProd;
  }

  /**
   * # iD: O02<br>
   * CNPJ do produtor da mercadoria, quando diferente do emitente.<br>
   * Preenchido nas operações em que o produtor não é o próprio emitente.<br>
   * Deve ser informado apenas com algarismos, sem máscara.
   *
   * @param cnpjProd the new iD: O02<br>
   *          CNPJ do produtor da mercadoria, quando diferente do emitente
   */
  public void setCnpjProd(String cnpjProd) {
    this.cnpjProd = cnpjProd;
  }

  /**
   * # iD: O03<br>
   * Código do selo de controle do IPI, quando aplicável ao produto.<br>
   * Campo alfanumérico, geralmente informado em operações com bebidas e cigarros.
   *
   * @return the iD: O03<br>
   *         Código do selo de controle do IPI, quando aplicável ao produto
   */
  public String getCSelo() {
    return cSelo;
  }

  /**
   * # iD: O03<br>
   * Código do selo de controle do IPI, quando aplicável ao produto.<br>
   * Campo alfanumérico, geralmente informado em operações com bebidas e cigarros.
   *
   * @param cSelo the new iD: O03<br>
   *          Código do selo de controle do IPI, quando aplicável ao produto
   */
  public void setCSelo(String cSelo) {
    this.cSelo = cSelo;
  }

  /**
   * # iD: O04<br>
   * Quantidade de selos de controle do IPI aplicados ao produto.<br>
   * Quantidade inteira (sem casas decimais).
   *
   * @return the iD: O04<br>
   *         Quantidade de selos de controle do IPI aplicados ao produto
   */
  public BigDecimal getQSelo() {
    return qSelo;
  }

  /**
   * # iD: O04<br>
   * Quantidade de selos de controle do IPI aplicados ao produto.<br>
   * Quantidade inteira (sem casas decimais).
   *
   * @param qSelo the new iD: O04<br>
   *          Quantidade de selos de controle do IPI aplicados ao produto
   */
  public void setQSelo(BigDecimal qSelo) {
    this.qSelo = qSelo;
  }

  /**
   * # iD: O05<br>
   * Código de enquadramento legal do IPI (cEnq).<br>
   * Código numérico de 3 posições definido pela legislação do IPI.
   *
   * @return the iD: O05<br>
   *         Código de enquadramento legal do IPI (cEnq)
   */
  public String getCEnq() {
    return cEnq;
  }

  /**
   * # iD: O05<br>
   * Código de enquadramento legal do IPI (cEnq).<br>
   * Código numérico de 3 posições definido pela legislação do IPI.
   *
   * @param cEnq the new iD: O05<br>
   *          Código de enquadramento legal do IPI (cEnq)
   */
  public void setCEnq(String cEnq) {
    this.cEnq = cEnq;
  }

  /**
   * # iD: O07 / O11<br>
   * Situação Tributária do IPI (CST), utilizada tanto para o grupo IPITrib (O06) quanto para o grupo IPIInt (O10).<br>
   * Valores conforme {@link SEFAZ_IPI_CST}.
   *
   * @return the iD: O07 / O11<br>
   *         Situação Tributária do IPI (CST), utilizada tanto para o grupo IPITrib (O06) quanto para o grupo IPIInt (O10)
   */
  public SEFAZ_CST_IPI getCst() {
    return cst;
  }

  /**
   * # iD: O07 / O11<br>
   * Situação Tributária do IPI (CST), utilizada tanto para o grupo IPITrib (O06) quanto para o grupo IPIInt (O10).<br>
   * Valores conforme {@link SEFAZ_IPI_CST}.
   *
   * @param cst the new iD: O07 / O11<br>
   *          Situação Tributária do IPI (CST), utilizada tanto para o grupo IPITrib (O06) quanto para o grupo IPIInt (O10)
   */
  public void setCst(SEFAZ_CST_IPI cst) {
    this.cst = cst;
  }

  /**
   * # iD: O08 (IPITrib)<br>
   * Valor da Base de Cálculo do IPI (vBC).<br>
   * Utilizado quando o IPI é tributado pela base de cálculo em valor monetário.<br>
   * Tamanho 13v2.
   *
   * @return the iD: O08 (IPITrib)<br>
   *         Valor da Base de Cálculo do IPI (vBC)
   */
  public BigDecimal getVBC() {
    return vBC;
  }

  /**
   * # iD: O08 (IPITrib)<br>
   * Valor da Base de Cálculo do IPI (vBC).<br>
   * Utilizado quando o IPI é tributado pela base de cálculo em valor monetário.<br>
   * Tamanho 13v2.
   *
   * @param vBC the new iD: O08 (IPITrib)<br>
   *          Valor da Base de Cálculo do IPI (vBC)
   */
  public void setVBC(BigDecimal vBC) {
    this.vBC = vBC;
  }

  /**
   * # iD: O09 (IPITrib)<br>
   * Quantidade total na unidade padrão de tributação (qUnid).<br>
   * Utilizado quando o IPI é tributado por unidade de produto em vez de percentual.<br>
   * Tamanho aproximado 11v0-4 (até 4 casas decimais).
   *
   * @return the iD: O09 (IPITrib)<br>
   *         Quantidade total na unidade padrão de tributação (qUnid)
   */
  public BigDecimal getQUnid() {
    return qUnid;
  }

  /**
   * # iD: O09 (IPITrib)<br>
   * Quantidade total na unidade padrão de tributação (qUnid).<br>
   * Utilizado quando o IPI é tributado por unidade de produto em vez de percentual.<br>
   * Tamanho aproximado 11v0-4 (até 4 casas decimais).
   *
   * @param qUnid the new iD: O09 (IPITrib)<br>
   *          Quantidade total na unidade padrão de tributação (qUnid)
   */
  public void setQUnid(BigDecimal qUnid) {
    this.qUnid = qUnid;
  }

  /**
   * # iD: O10 (IPITrib)<br>
   * Valor por unidade de tributação (vUnid).<br>
   * Utilizado em conjunto com {@link #qUnid} quando o IPI é cobrado por unidade.<br>
   * Tamanho aproximado 11v0-4 (até 4 casas decimais).
   *
   * @return the iD: O10 (IPITrib)<br>
   *         Valor por unidade de tributação (vUnid)
   */
  public BigDecimal getVUnid() {
    return vUnid;
  }

  /**
   * # iD: O10 (IPITrib)<br>
   * Valor por unidade de tributação (vUnid).<br>
   * Utilizado em conjunto com {@link #qUnid} quando o IPI é cobrado por unidade.<br>
   * Tamanho aproximado 11v0-4 (até 4 casas decimais).
   *
   * @param vUnid the new iD: O10 (IPITrib)<br>
   *          Valor por unidade de tributação (vUnid)
   */
  public void setVUnid(BigDecimal vUnid) {
    this.vUnid = vUnid;
  }

  /**
   * # iD: O11 (IPITrib)<br>
   * Alíquota do IPI em percentual (pIPI).<br>
   * Utilizada quando o IPI é tributado ad valorem, sobre a base de cálculo em valor.<br>
   * Tamanho 3v2-4 (duas a quatro casas decimais).
   *
   * @return the iD: O11 (IPITrib)<br>
   *         Alíquota do IPI em percentual (pIPI)
   */
  public BigDecimal getPIPI() {
    return pIPI;
  }

  /**
   * # iD: O11 (IPITrib)<br>
   * Alíquota do IPI em percentual (pIPI).<br>
   * Utilizada quando o IPI é tributado ad valorem, sobre a base de cálculo em valor.<br>
   * Tamanho 3v2-4 (duas a quatro casas decimais).
   *
   * @param pIPI the new iD: O11 (IPITrib)<br>
   *          Alíquota do IPI em percentual (pIPI)
   */
  public void setPIPI(BigDecimal pIPI) {
    this.pIPI = pIPI;
  }

  /**
   * # iD: O12 (IPITrib)<br>
   * Valor total do IPI incidente sobre o item (vIPI).<br>
   * Resultado do cálculo pela base de cálculo/quantidade e alíquota informadas.<br>
   * Tamanho 13v2.
   *
   * @return the iD: O12 (IPITrib)<br>
   *         Valor total do IPI incidente sobre o item (vIPI)
   */
  public BigDecimal getVIPI() {
    return vIPI;
  }

  /**
   * # iD: O12 (IPITrib)<br>
   * Valor total do IPI incidente sobre o item (vIPI).<br>
   * Resultado do cálculo pela base de cálculo/quantidade e alíquota informadas.<br>
   * Tamanho 13v2.
   *
   * @param vIPI the new iD: O12 (IPITrib)<br>
   *          Valor total do IPI incidente sobre o item (vIPI)
   */
  public void setVIPI(BigDecimal vIPI) {
    this.vIPI = vIPI;
  }

}
