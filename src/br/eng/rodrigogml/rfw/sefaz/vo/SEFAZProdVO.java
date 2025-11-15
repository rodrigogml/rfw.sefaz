package br.eng.rodrigogml.rfw.sefaz.vo;

import java.io.Serializable;
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
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indTot;

/**
 * Grupo I - Detalhamento de Produtos e Serviços (tag prod / I01). Detalhamento de Produtos e Serviços do item da NF-e.
 *
 * Observação: a obrigatoriedade dos campos segue o MOC, mas nas annotations o atributo {@code required} é sempre definido como false conforme solicitado.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_prod")
public class SEFAZProdVO extends RFWVO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * {@link SEFAZDetVO}
   */
  @RFWMetaRelationshipField(caption = "Det", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_det")
  private SEFAZDetVO detVO = null;

  /**
   * I02 - cProd. Código do produto ou serviço. Quando itens não relacionados com mercadorias/produtos e sem codificação própria, preencher com CFOP no formato: "CFOP9999". Ocor.: 1–1 / Tam.: 1–60 / Tipo: C.
   */
  @RFWMetaStringField(caption = "Código do produto ou serviço", required = false, unique = false, maxLength = 60, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cprod;

  /**
   * I03 - cEAN. GTIN (Global Trade Item Number) do produto, antigo código EAN ou código de barras. Preencher com GTIN-8, GTIN-12, GTIN-13 ou GTIN-14. Produtos sem GTIN: informar “SEM GTIN”. Ocor.: 1–1 / Tam.: 0, 8, 12, 13, 14 / Tipo: N (campo pode conter texto “SEM GTIN”).
   */
  @RFWMetaStringField(caption = "GTIN do produto (cEAN)", required = false, unique = false, maxLength = 14, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cean;

  /**
   * I04 - xProd. Descrição do produto ou serviço. Ocor.: 1–1 / Tam.: 1–120 / Tipo: C.
   */
  @RFWMetaStringField(caption = "Descrição do produto ou serviço", required = false, unique = false, maxLength = 120, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xprod;

  /**
   * I05 - NCM. Código NCM com 8 dígitos. Obrigatória para produtos; para serviços, informar “00”. Ocor.: 1–1 / Tam.: 8 / Tipo: N.
   */
  @RFWMetaStringField(caption = "Código NCM", required = false, unique = false, maxLength = 8, pattern = "^[0-9]{2}([0-9]{6}|0{6})$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String ncm;

  /**
   * I05a - NVE. Codificação NVE – Nomenclatura de Valor Aduaneiro e Estatística. Codificação opcional que detalha alguns NCM. Ocor.: 0–8 / Tam.: 6 / Tipo: C.
   */
  @RFWMetaStringField(caption = "Codificação NVE", required = false, unique = false, maxLength = 6, minLength = 6, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String nve;

  /**
   * I05c - CEST. Código CEST (ICMS-ST). Ocor.: 1–1 / Tam.: 7 / Tipo: N. Campo originalmente em grupo de sequência XML (I05b), aqui trazido para o VO principal.
   */
  @RFWMetaStringField(caption = "Código CEST", required = false, unique = false, maxLength = 7, pattern = "^[0-9]{7}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cest;

  /**
   * I05d - indEscala. Indicador de Escala Relevante, conforme Ajuste SINIEF 23/2016. Ocor.: 0–1 / Tam.: 1 / Tipo: C. Campo originalmente em grupo de sequência XML (I05b), aqui trazido para o VO principal.
   */
  @RFWMetaStringField(caption = "Indicador de Escala Relevante", required = false, unique = false, maxLength = 1, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String indescala;

  /**
   * I05e - CNPJFab. CNPJ do Fabricante da Mercadoria. Informar quando indEscala = "S". Ocor.: 0–1 / Tam.: 14 / Tipo: C (CNPJ somente dígitos). Campo originalmente em grupo de sequência XML (I05b), aqui trazido para o VO principal.
   */
  @RFWMetaStringCNPJField(caption = "CNPJ do fabricante da mercadoria", required = false, unique = false)
  private String cnpjFab;

  /**
   * I05f - cBenef. Código de Benefício Fiscal na UF aplicado ao item. Código do benefício fiscal. Ocor.: 0–1 / Tam.: 8 / Tipo: C. Campo originalmente em grupo de sequência XML (I05b), aqui trazido para o VO principal.
   */
  @RFWMetaStringField(caption = "Código de benefício fiscal (UF)", required = false, unique = false, maxLength = 8, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cbenef;

  /**
   * I06 - EXTIPI. EX_TIPI. Ocor.: 0–1 / Tam.: 3 / Tipo: N.
   */
  @RFWMetaStringField(caption = "EX TIPI", required = false, unique = false, maxLength = 3, minLength = 3, pattern = "^[0-9]{3}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String extipi;

  /**
   * I07 - CFOP. Código Fiscal de Operações e Prestações. Utilizar tabela de CFOP. Ocor.: 1–1 / Tam.: 4 / Tipo: N.
   */
  @RFWMetaStringField(caption = "CFOP", required = false, unique = false, maxLength = 4, minLength = 4, pattern = "^[0-9]{4}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cfop;

  /**
   * I08 - uCom. Unidade Comercial. Unidade de comercialização. Ocor.: 1–1 / Tam.: 1–6 / Tipo: C.
   */
  @RFWMetaStringField(caption = "Unidade comercial", required = false, unique = false, maxLength = 6, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String ucom;

  /**
   * I09 - qCom. Quantidade Comercial. Quantidade comercializada. Ocor.: 1–1 / Tam.: 11v0–4 / Tipo: N.
   */
  @RFWMetaBigDecimalField(caption = "Quantidade comercial", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal qcom;

  /**
   * I10 - vUnCom. Valor Unitário de Comercialização. Valor unitário. Ocor.: 1–1 / Tam.: 11v0–10 / Tipo: N.
   */
  @RFWMetaBigDecimalField(caption = "Valor unitário de comercialização", required = false, unique = false, scaleMax = 10, absolute = true)
  private BigDecimal vunCom;

  /**
   * I11 - vProd. Valor Total Bruto dos Produtos ou Serviços. Ocor.: 1–1 / Tam.: 13v2 (conforme MOC) / Tipo: N.
   */
  @RFWMetaBigDecimalField(caption = "Valor total bruto dos produtos/serviços", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vprod;

  /**
   * I12 - cEANTrib. GTIN tributável da unidade tributável; se inexistente: “SEM GTIN”. Ocor.: 1–1 / Tam.: 0, 8, 12, 13, 14 / Tipo: C.
   */
  @RFWMetaStringField(caption = "GTIN tributável (cEANTrib)", required = false, unique = false, maxLength = 14, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String ceanTrib;

  /**
   * I13 - uTrib. Unidade Tributável. Unidade tributável. Ocor.: 1–1 / Tam.: 1–6 / Tipo: C.
   */
  @RFWMetaStringField(caption = "Unidade tributável", required = false, unique = false, maxLength = 6, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String utrib;

  /**
   * I14 - qTrib. Quantidade Tributável. Quantidade tributável. Ocor.: 1–1 / Tam.: 11v0–4 / Tipo: N.
   */
  @RFWMetaBigDecimalField(caption = "Quantidade tributável", required = false, unique = false, scaleMax = 4, absolute = true)
  private BigDecimal qtrib;

  /**
   * I14a - vUnTrib. Valor Unitário de Tributação. Valor unitário tributável. Ocor.: 1–1 / Tam.: 11v0–10 / Tipo: N.
   */
  @RFWMetaBigDecimalField(caption = "Valor unitário de tributação", required = false, unique = false, scaleMax = 10, absolute = true)
  private BigDecimal vunTrib;

  /**
   * I15 - vFrete. Valor Total do Frete. Ocor.: 0–1 / Tam.: 13v2 / Tipo: N.
   */
  @RFWMetaBigDecimalField(caption = "Valor total do frete", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vfrete;

  /**
   * I16 - vSeg. Valor Total do Seguro. Ocor.: 0–1 / Tam.: 13v2 / Tipo: N.
   */
  @RFWMetaBigDecimalField(caption = "Valor total do seguro", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vseg;

  /**
   * I17 - vDesc. Valor do Desconto. Ocor.: 0–1 / Tam.: 13v2 / Tipo: N.
   */
  @RFWMetaBigDecimalField(caption = "Valor do desconto", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal vdesc;

  /**
   * I17a - vOutro. Outras despesas acessórias. Ocor.: 0–1 / Tam.: 13v2 / Tipo: N.
   */
  @RFWMetaBigDecimalField(caption = "Outras despesas acessórias", required = false, unique = false, scale = 2, absolute = true)
  private BigDecimal voutro;

  /**
   * I17b - indTot. Indica se valor do item compõe o total da NF-e (vProd). 0 = não compõe; 1 = compõe. Ocor.: 1–1 / Tam.: 1 / Tipo: N.
   */
  @RFWMetaEnumField(caption = "Indicador se compõe o total da NF-e", required = false)
  private SEFAZ_indTot indTot;

  /**
   * # i02 - cProd. Código do produto ou serviço. Quando itens não relacionados com mercadorias/produtos e sem codificação própria, preencher com CFOP no formato: "CFOP9999". Ocor.: 1–1 / Tam.: 1–60 / Tipo: C.
   *
   * @return the i02 - cProd
   */
  public String getCprod() {
    return cprod;
  }

  /**
   * # i02 - cProd. Código do produto ou serviço. Quando itens não relacionados com mercadorias/produtos e sem codificação própria, preencher com CFOP no formato: "CFOP9999". Ocor.: 1–1 / Tam.: 1–60 / Tipo: C.
   *
   * @param cprod the new i02 - cProd
   */
  public void setCprod(String cprod) {
    this.cprod = cprod;
  }

  /**
   * # i03 - cEAN. GTIN (Global Trade Item Number) do produto, antigo código EAN ou código de barras. Preencher com GTIN-8, GTIN-12, GTIN-13 ou GTIN-14. Produtos sem GTIN: informar “SEM GTIN”. Ocor.: 1–1 / Tam.: 0, 8, 12, 13, 14 / Tipo: N (campo pode conter texto “SEM GTIN”).
   *
   * @return the i03 - cEAN
   */
  public String getCean() {
    return cean;
  }

  /**
   * # i03 - cEAN. GTIN (Global Trade Item Number) do produto, antigo código EAN ou código de barras. Preencher com GTIN-8, GTIN-12, GTIN-13 ou GTIN-14. Produtos sem GTIN: informar “SEM GTIN”. Ocor.: 1–1 / Tam.: 0, 8, 12, 13, 14 / Tipo: N (campo pode conter texto “SEM GTIN”).
   *
   * @param cean the new i03 - cEAN
   */
  public void setCean(String cean) {
    this.cean = cean;
  }

  /**
   * # i04 - xProd. Descrição do produto ou serviço. Ocor.: 1–1 / Tam.: 1–120 / Tipo: C.
   *
   * @return the i04 - xProd
   */
  public String getXprod() {
    return xprod;
  }

  /**
   * # i04 - xProd. Descrição do produto ou serviço. Ocor.: 1–1 / Tam.: 1–120 / Tipo: C.
   *
   * @param xprod the new i04 - xProd
   */
  public void setXprod(String xprod) {
    this.xprod = xprod;
  }

  /**
   * # i05 - NCM. Código NCM com 8 dígitos. Obrigatória para produtos; para serviços, informar “00”. Ocor.: 1–1 / Tam.: 8 / Tipo: N.
   *
   * @return the i05 - NCM
   */
  public String getNcm() {
    return ncm;
  }

  /**
   * # i05 - NCM. Código NCM com 8 dígitos. Obrigatória para produtos; para serviços, informar “00”. Ocor.: 1–1 / Tam.: 8 / Tipo: N.
   *
   * @param ncm the new i05 - NCM
   */
  public void setNcm(String ncm) {
    this.ncm = ncm;
  }

  /**
   * # i05a - NVE. Codificação NVE – Nomenclatura de Valor Aduaneiro e Estatística. Codificação opcional que detalha alguns NCM. Ocor.: 0–8 / Tam.: 6 / Tipo: C.
   *
   * @return the i05a - NVE
   */
  public String getNve() {
    return nve;
  }

  /**
   * # i05a - NVE. Codificação NVE – Nomenclatura de Valor Aduaneiro e Estatística. Codificação opcional que detalha alguns NCM. Ocor.: 0–8 / Tam.: 6 / Tipo: C.
   *
   * @param nve the new i05a - NVE
   */
  public void setNve(String nve) {
    this.nve = nve;
  }

  /**
   * # i05c - CEST. Código CEST (ICMS-ST). Ocor.: 1–1 / Tam.: 7 / Tipo: N. Campo originalmente em grupo de sequência XML (I05b), aqui trazido para o VO principal.
   *
   * @return the i05c - CEST
   */
  public String getCest() {
    return cest;
  }

  /**
   * # i05c - CEST. Código CEST (ICMS-ST). Ocor.: 1–1 / Tam.: 7 / Tipo: N. Campo originalmente em grupo de sequência XML (I05b), aqui trazido para o VO principal.
   *
   * @param cest the new i05c - CEST
   */
  public void setCest(String cest) {
    this.cest = cest;
  }

  /**
   * # i05d - indEscala. Indicador de Escala Relevante, conforme Ajuste SINIEF 23/2016. Ocor.: 0–1 / Tam.: 1 / Tipo: C. Campo originalmente em grupo de sequência XML (I05b), aqui trazido para o VO principal.
   *
   * @return the i05d - indEscala
   */
  public String getIndescala() {
    return indescala;
  }

  /**
   * # i05d - indEscala. Indicador de Escala Relevante, conforme Ajuste SINIEF 23/2016. Ocor.: 0–1 / Tam.: 1 / Tipo: C. Campo originalmente em grupo de sequência XML (I05b), aqui trazido para o VO principal.
   *
   * @param indescala the new i05d - indEscala
   */
  public void setIndescala(String indescala) {
    this.indescala = indescala;
  }

  /**
   * # i05e - CNPJFab. CNPJ do Fabricante da Mercadoria. Informar quando indEscala = "S". Ocor.: 0–1 / Tam.: 14 / Tipo: C (CNPJ somente dígitos). Campo originalmente em grupo de sequência XML (I05b), aqui trazido para o VO principal.
   *
   * @return the i05e - CNPJFab
   */
  public String getCnpjFab() {
    return cnpjFab;
  }

  /**
   * # i05e - CNPJFab. CNPJ do Fabricante da Mercadoria. Informar quando indEscala = "S". Ocor.: 0–1 / Tam.: 14 / Tipo: C (CNPJ somente dígitos). Campo originalmente em grupo de sequência XML (I05b), aqui trazido para o VO principal.
   *
   * @param cnpjFab the new i05e - CNPJFab
   */
  public void setCnpjFab(String cnpjFab) {
    this.cnpjFab = cnpjFab;
  }

  /**
   * # i05f - cBenef. Código de Benefício Fiscal na UF aplicado ao item. Código do benefício fiscal. Ocor.: 0–1 / Tam.: 8 / Tipo: C. Campo originalmente em grupo de sequência XML (I05b), aqui trazido para o VO principal.
   *
   * @return the i05f - cBenef
   */
  public String getCbenef() {
    return cbenef;
  }

  /**
   * # i05f - cBenef. Código de Benefício Fiscal na UF aplicado ao item. Código do benefício fiscal. Ocor.: 0–1 / Tam.: 8 / Tipo: C. Campo originalmente em grupo de sequência XML (I05b), aqui trazido para o VO principal.
   *
   * @param cbenef the new i05f - cBenef
   */
  public void setCbenef(String cbenef) {
    this.cbenef = cbenef;
  }

  /**
   * # i06 - EXTIPI. EX_TIPI. Ocor.: 0–1 / Tam.: 3 / Tipo: N.
   *
   * @return the i06 - EXTIPI
   */
  public String getExtipi() {
    return extipi;
  }

  /**
   * # i06 - EXTIPI. EX_TIPI. Ocor.: 0–1 / Tam.: 3 / Tipo: N.
   *
   * @param extipi the new i06 - EXTIPI
   */
  public void setExtipi(String extipi) {
    this.extipi = extipi;
  }

  /**
   * # i07 - CFOP. Código Fiscal de Operações e Prestações. Utilizar tabela de CFOP. Ocor.: 1–1 / Tam.: 4 / Tipo: N.
   *
   * @return the i07 - CFOP
   */
  public String getCfop() {
    return cfop;
  }

  /**
   * # i07 - CFOP. Código Fiscal de Operações e Prestações. Utilizar tabela de CFOP. Ocor.: 1–1 / Tam.: 4 / Tipo: N.
   *
   * @param cfop the new i07 - CFOP
   */
  public void setCfop(String cfop) {
    this.cfop = cfop;
  }

  /**
   * # i08 - uCom. Unidade Comercial. Unidade de comercialização. Ocor.: 1–1 / Tam.: 1–6 / Tipo: C.
   *
   * @return the i08 - uCom
   */
  public String getUcom() {
    return ucom;
  }

  /**
   * # i08 - uCom. Unidade Comercial. Unidade de comercialização. Ocor.: 1–1 / Tam.: 1–6 / Tipo: C.
   *
   * @param ucom the new i08 - uCom
   */
  public void setUcom(String ucom) {
    this.ucom = ucom;
  }

  /**
   * # i09 - qCom. Quantidade Comercial. Quantidade comercializada. Ocor.: 1–1 / Tam.: 11v0–4 / Tipo: N.
   *
   * @return the i09 - qCom
   */
  public BigDecimal getQcom() {
    return qcom;
  }

  /**
   * # i09 - qCom. Quantidade Comercial. Quantidade comercializada. Ocor.: 1–1 / Tam.: 11v0–4 / Tipo: N.
   *
   * @param qcom the new i09 - qCom
   */
  public void setQcom(BigDecimal qcom) {
    this.qcom = qcom;
  }

  /**
   * # i10 - vUnCom. Valor Unitário de Comercialização. Valor unitário. Ocor.: 1–1 / Tam.: 11v0–10 / Tipo: N.
   *
   * @return the i10 - vUnCom
   */
  public BigDecimal getVunCom() {
    return vunCom;
  }

  /**
   * # i10 - vUnCom. Valor Unitário de Comercialização. Valor unitário. Ocor.: 1–1 / Tam.: 11v0–10 / Tipo: N.
   *
   * @param vunCom the new i10 - vUnCom
   */
  public void setVunCom(BigDecimal vunCom) {
    this.vunCom = vunCom;
  }

  /**
   * # i11 - vProd. Valor Total Bruto dos Produtos ou Serviços. Ocor.: 1–1 / Tam.: 13v2 (conforme MOC) / Tipo: N.
   *
   * @return the i11 - vProd
   */
  public BigDecimal getVprod() {
    return vprod;
  }

  /**
   * # i11 - vProd. Valor Total Bruto dos Produtos ou Serviços. Ocor.: 1–1 / Tam.: 13v2 (conforme MOC) / Tipo: N.
   *
   * @param vprod the new i11 - vProd
   */
  public void setVprod(BigDecimal vprod) {
    this.vprod = vprod;
  }

  /**
   * # i12 - cEANTrib. GTIN tributável da unidade tributável; se inexistente: “SEM GTIN”. Ocor.: 1–1 / Tam.: 0, 8, 12, 13, 14 / Tipo: C.
   *
   * @return the i12 - cEANTrib
   */
  public String getCeanTrib() {
    return ceanTrib;
  }

  /**
   * # i12 - cEANTrib. GTIN tributável da unidade tributável; se inexistente: “SEM GTIN”. Ocor.: 1–1 / Tam.: 0, 8, 12, 13, 14 / Tipo: C.
   *
   * @param ceanTrib the new i12 - cEANTrib
   */
  public void setCeanTrib(String ceanTrib) {
    this.ceanTrib = ceanTrib;
  }

  /**
   * # i13 - uTrib. Unidade Tributável. Unidade tributável. Ocor.: 1–1 / Tam.: 1–6 / Tipo: C.
   *
   * @return the i13 - uTrib
   */
  public String getUtrib() {
    return utrib;
  }

  /**
   * # i13 - uTrib. Unidade Tributável. Unidade tributável. Ocor.: 1–1 / Tam.: 1–6 / Tipo: C.
   *
   * @param utrib the new i13 - uTrib
   */
  public void setUtrib(String utrib) {
    this.utrib = utrib;
  }

  /**
   * # i14 - qTrib. Quantidade Tributável. Quantidade tributável. Ocor.: 1–1 / Tam.: 11v0–4 / Tipo: N.
   *
   * @return the i14 - qTrib
   */
  public BigDecimal getQtrib() {
    return qtrib;
  }

  /**
   * # i14 - qTrib. Quantidade Tributável. Quantidade tributável. Ocor.: 1–1 / Tam.: 11v0–4 / Tipo: N.
   *
   * @param qtrib the new i14 - qTrib
   */
  public void setQtrib(BigDecimal qtrib) {
    this.qtrib = qtrib;
  }

  /**
   * # i14a - vUnTrib. Valor Unitário de Tributação. Valor unitário tributável. Ocor.: 1–1 / Tam.: 11v0–10 / Tipo: N.
   *
   * @return the i14a - vUnTrib
   */
  public BigDecimal getVunTrib() {
    return vunTrib;
  }

  /**
   * # i14a - vUnTrib. Valor Unitário de Tributação. Valor unitário tributável. Ocor.: 1–1 / Tam.: 11v0–10 / Tipo: N.
   *
   * @param vunTrib the new i14a - vUnTrib
   */
  public void setVunTrib(BigDecimal vunTrib) {
    this.vunTrib = vunTrib;
  }

  /**
   * # i15 - vFrete. Valor Total do Frete. Ocor.: 0–1 / Tam.: 13v2 / Tipo: N.
   *
   * @return the i15 - vFrete
   */
  public BigDecimal getVfrete() {
    return vfrete;
  }

  /**
   * # i15 - vFrete. Valor Total do Frete. Ocor.: 0–1 / Tam.: 13v2 / Tipo: N.
   *
   * @param vfrete the new i15 - vFrete
   */
  public void setVfrete(BigDecimal vfrete) {
    this.vfrete = vfrete;
  }

  /**
   * # i16 - vSeg. Valor Total do Seguro. Ocor.: 0–1 / Tam.: 13v2 / Tipo: N.
   *
   * @return the i16 - vSeg
   */
  public BigDecimal getVseg() {
    return vseg;
  }

  /**
   * # i16 - vSeg. Valor Total do Seguro. Ocor.: 0–1 / Tam.: 13v2 / Tipo: N.
   *
   * @param vseg the new i16 - vSeg
   */
  public void setVseg(BigDecimal vseg) {
    this.vseg = vseg;
  }

  /**
   * # i17 - vDesc. Valor do Desconto. Ocor.: 0–1 / Tam.: 13v2 / Tipo: N.
   *
   * @return the i17 - vDesc
   */
  public BigDecimal getVdesc() {
    return vdesc;
  }

  /**
   * # i17 - vDesc. Valor do Desconto. Ocor.: 0–1 / Tam.: 13v2 / Tipo: N.
   *
   * @param vdesc the new i17 - vDesc
   */
  public void setVdesc(BigDecimal vdesc) {
    this.vdesc = vdesc;
  }

  /**
   * # i17a - vOutro. Outras despesas acessórias. Ocor.: 0–1 / Tam.: 13v2 / Tipo: N.
   *
   * @return the i17a - vOutro
   */
  public BigDecimal getVoutro() {
    return voutro;
  }

  /**
   * # i17a - vOutro. Outras despesas acessórias. Ocor.: 0–1 / Tam.: 13v2 / Tipo: N.
   *
   * @param voutro the new i17a - vOutro
   */
  public void setVoutro(BigDecimal voutro) {
    this.voutro = voutro;
  }

  /**
   * # i17b - indTot. Indica se valor do item compõe o total da NF-e (vProd). 0 = não compõe; 1 = compõe. Ocor.: 1–1 / Tam.: 1 / Tipo: N.
   *
   * @return the i17b - indTot
   */
  public SEFAZ_indTot getIndTot() {
    return indTot;
  }

  /**
   * # i17b - indTot. Indica se valor do item compõe o total da NF-e (vProd). 0 = não compõe; 1 = compõe. Ocor.: 1–1 / Tam.: 1 / Tipo: N.
   *
   * @param indTot the new i17b - indTot
   */
  public void setIndTot(SEFAZ_indTot indTot) {
    this.indTot = indTot;
  }

  /**
   * # {@link SEFAZDetVO}.
   *
   * @return the {@link SEFAZDetVO}
   */
  public SEFAZDetVO getDetVO() {
    return detVO;
  }

  /**
   * # {@link SEFAZDetVO}.
   *
   * @param detVO the new {@link SEFAZDetVO}
   */
  public void setDetVO(SEFAZDetVO detVO) {
    this.detVO = detVO;
  }

}
