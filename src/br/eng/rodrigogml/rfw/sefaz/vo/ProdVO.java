package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indEscala;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indTot;

/**
 * Classe que representa a tag <b>prod</b> (Detalhamento de Produtos e Serviços) do XML da SEFAZ.<br>
 * Grupo I01 — informações comerciais e tributárias do item da NF-e/NFC-e.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_prod")
public class ProdVO extends RFWVO {

  private static final long serialVersionUID = 1905057902132069425L;

  /**
   * ID: I02 — cProd.<br>
   * Código do produto ou serviço. Quando não houver codificação própria, utilizar o CFOP para itens não relacionados a mercadorias/produtos. Tamanho: 1–60.
   */
  @RFWMetaStringField(caption = "Código do produto", maxLength = 60, minlength = 1, required = false)
  private String cProd = null;

  /**
   * ID: I03 — cEAN.<br>
   * GTIN (código de barras) do produto. Preencher com GTIN-8, GTIN-12, GTIN-13 ou GTIN-14. Para produtos sem GTIN, informar o literal “SEM GTIN”. Tamanhos permitidos: 0, 8, 12, 13 ou 14.
   */
  @RFWMetaStringField(caption = "GTIN do produto", maxLength = 14, minlength = 0, required = false, pattern = "(^$)|(^[0-9]{8}$)|(^[0-9]{12}$)|(^[0-9]{13}$)|(^[0-9]{14}$)|(^SEM GTIN$)")
  private String cEAN = null;

  /**
   * ID: I04 — xProd.<br>
   * Descrição do produto ou serviço. Tamanho: 1–120.
   */
  @RFWMetaStringField(caption = "Descrição do produto", maxLength = 120, minlength = 1, required = false)
  private String xProd = null;

  /**
   * ID: I05 — NCM.<br>
   * Código NCM (8 dígitos). Em alguns casos de serviço ou itens sem produto, pode ser utilizado “00”. Tamanho: 2 ou 8.
   */
  @RFWMetaBigDecimalField(caption = "NCM", maxValue = "99999999", minValue = "0", scale = 0, required = false, absolute = true)
  private BigDecimal ncm = null;

  /**
   * ID: I05a — NVE.<br>
   * Codificação NVE (Nomenclatura de Valor Aduaneiro e Estatística).<br>
   * Formato: duas letras maiúsculas e quatro algarismos (ex.: "AB1234").<br>
   * Tamanho: 6. Ocorrência: até 8 repetições (tratado aqui como um único valor).
   */
  @RFWMetaStringField(caption = "NVE", maxLength = 6, minlength = 6, required = false, pattern = "[A-Z]{2}[0-9]{4}")
  private String nve = null;

  /**
   * ID: I05c — CEST.<br>
   * Código Especificador da Substituição Tributária (CEST).<br>
   * Tamanho: 7.
   */
  @RFWMetaBigDecimalField(caption = "CEST", maxValue = "9999999", minValue = "0", scale = 0, required = false, absolute = true)
  private BigDecimal cest = null;

  /**
   * ID: I05d — indEscala.<br>
   * Indicador de Produção em Escala Relevante, conforme Cláusula 23 do Convênio ICMS 52/2017.<br>
   * Valores: S=Produzido em Escala Relevante; N=Produzido em Escala NÃO Relevante.<br>
   * Preenchimento obrigatório para produtos com NCM relacionado no Anexo XXVII do Convênio 52/2017.
   */
  @RFWMetaEnumField(caption = "Escala relevante", required = false)
  private SEFAZ_indEscala indEscala = null;

  /**
   * ID: I05e — CNPJFab.<br>
   * CNPJ do fabricante da mercadoria, obrigatório para produto em escala NÃO relevante. Tamanho: 14.
   */
  @RFWMetaBigDecimalField(caption = "CNPJ do fabricante", maxValue = "99999999999999", minValue = "0", scale = 0, required = false, absolute = true)
  private BigDecimal cnpjFab = null;

  /**
   * ID: I05f — cBenef.<br>
   * Código de Benefício Fiscal na UF aplicado ao item, conforme legislação estadual. Tamanho: 8 ou 10.
   */
  @RFWMetaStringField(caption = "Benefício fiscal", maxLength = 10, minlength = 8, required = false)
  private String cBenef = null;

  /**
   * ID: I06 — EXTIPI.<br>
   * Código EX-TIPI conforme legislação. Tamanho: 2–3.
   */
  @RFWMetaBigDecimalField(caption = "EX-TIPI", maxValue = "999", minValue = "0", scale = 0, required = false, absolute = true)
  private BigDecimal extipi = null;

  /**
   * ID: I08 — CFOP.<br>
   * Código Fiscal de Operações e Prestações. Tamanho: 4.
   */
  @RFWMetaBigDecimalField(caption = "CFOP", maxValue = "9999", minValue = "0", scale = 0, required = false, absolute = true)
  private BigDecimal CFOP = null;

  /**
   * ID: I09 — uCom.<br>
   * Unidade comercial do produto. Tamanho: 1–6.
   */
  @RFWMetaStringField(caption = "Unidade comercial", maxLength = 6, minlength = 1, required = false)
  private String uCom = null;

  /**
   * ID: I10 — qCom.<br>
   * Quantidade comercial. Formato: até 11 dígitos com 0–4 casas decimais (11v0–4).
   */
  @RFWMetaBigDecimalField(caption = "Quantidade comercial", maxValue = "99999999999.9999", minValue = "0", scaleMax = 4, required = false, absolute = true)
  private BigDecimal qCom = null;

  /**
   * ID: I10a — vUnCom.<br>
   * Valor unitário de comercialização do produto. Formato: até 11 dígitos com 0–10 casas decimais (11v0–10).
   */
  @RFWMetaBigDecimalField(caption = "Valor unitário", maxValue = "99999999999.9999999999", minValue = "0", scaleMax = 10, required = false, absolute = true)
  private BigDecimal vUnCom = null;

  /**
   * ID: I11 — vProd.<br>
   * Valor total bruto dos produtos ou serviços. Formato: 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor bruto do item", maxValue = "9999999999999.99", minValue = "0", scale = 2, scaleMax = 2, required = false, absolute = true)
  private BigDecimal vProd = null;

  /**
   * ID: I12 — cEANTrib.<br>
   * GTIN da unidade tributável. Mesmos critérios do cEAN (I03).<br>
   * Para produtos sem GTIN, informar “SEM GTIN”.
   */
  @RFWMetaStringField(caption = "GTIN tributável", maxLength = 14, minlength = 0, required = false, pattern = "(^$)|(^[0-9]{8}$)|(^[0-9]{12}$)|(^[0-9]{13}$)|(^[0-9]{14}$)|(^SEM GTIN$)")
  private String cEANTrib = null;

  /**
   * ID: I13 — uTrib.<br>
   * Unidade tributável. Tamanho: 1–6.
   */
  @RFWMetaStringField(caption = "Unidade tributável", maxLength = 6, minlength = 1, required = false)
  private String uTrib = null;

  /**
   * ID: I14 — qTrib.<br>
   * Quantidade tributável. Formato: até 11 dígitos com 0–4 casas decimais (11v0–4).
   */
  @RFWMetaBigDecimalField(caption = "Quantidade tributável", maxValue = "99999999999.9999", minValue = "0", scaleMax = 4, required = false, absolute = true)
  private BigDecimal qTrib = null;

  /**
   * ID: I14a — vUnTrib.<br>
   * Valor unitário de tributação da unidade tributável. Formato: 11v0–10.
   */
  @RFWMetaBigDecimalField(caption = "Valor unitário tributação", maxValue = "99999999999.9999999999", minValue = "0", scaleMax = 10, required = false, absolute = true)
  private BigDecimal vUnTrib = null;

  /**
   * ID: I15 — vFrete.<br>
   * Valor total do frete do item. Formato: 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor do frete", maxValue = "9999999999999.99", minValue = "0", scale = 2, scaleMax = 2, required = false, absolute = true)
  private BigDecimal vFrete = null;

  /**
   * ID: I16 — vSeg.<br>
   * Valor total do seguro do item. Formato: 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor do seguro", maxValue = "9999999999999.99", minValue = "0", scale = 2, scaleMax = 2, required = false, absolute = true)
  private BigDecimal vSeg = null;

  /**
   * ID: I17 — vDesc.<br>
   * Valor do desconto do item. Formato: 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor do desconto", maxValue = "9999999999999.99", minValue = "0", scale = 2, scaleMax = 2, required = false, absolute = true)
  private BigDecimal vDesc = null;

  /**
   * ID: I17a — vOutro.<br>
   * Outras despesas acessórias do item. Formato: 13v2 (v2.0).
   */
  @RFWMetaBigDecimalField(caption = "Outras despesas", maxValue = "9999999999999.99", minValue = "0", scale = 2, scaleMax = 2, required = false, absolute = true)
  private BigDecimal vOutro = null;

  /**
   * ID: I17b — indTot.<br>
   * Indica se o valor do item (vProd) compõe o valor total da NF-e (vProd).<br>
   * Valores: 0=Não compõe; 1=Compõe. (Versão 2.0)
   */
  @RFWMetaEnumField(caption = "Totaliza NF-e", required = false)
  private SEFAZ_indTot indTot = null;

  /**
   * # iD: I02 — cProd.<br>
   * Código do produto ou serviço. Quando não houver codificação própria, utilizar o CFOP para itens não relacionados a mercadorias/produtos. Tamanho: 1–60.
   *
   * @return the iD: I02 — cProd
   */
  public String getCProd() {
    return cProd;
  }

  /**
   * # iD: I02 — cProd.<br>
   * Código do produto ou serviço. Quando não houver codificação própria, utilizar o CFOP para itens não relacionados a mercadorias/produtos. Tamanho: 1–60.
   *
   * @param cProd the new iD: I02 — cProd
   */
  public void setCProd(String cProd) {
    this.cProd = cProd;
  }

  /**
   * # iD: I03 — cEAN.<br>
   * GTIN (código de barras) do produto. Preencher com GTIN-8, GTIN-12, GTIN-13 ou GTIN-14. Para produtos sem GTIN, informar o literal “SEM GTIN”. Tamanhos permitidos: 0, 8, 12, 13 ou 14.
   *
   * @return the iD: I03 — cEAN
   */
  public String getCEAN() {
    return cEAN;
  }

  /**
   * # iD: I03 — cEAN.<br>
   * GTIN (código de barras) do produto. Preencher com GTIN-8, GTIN-12, GTIN-13 ou GTIN-14. Para produtos sem GTIN, informar o literal “SEM GTIN”. Tamanhos permitidos: 0, 8, 12, 13 ou 14.
   *
   * @param cEAN the new iD: I03 — cEAN
   */
  public void setCEAN(String cEAN) {
    this.cEAN = cEAN;
  }

  /**
   * # iD: I04 — xProd.<br>
   * Descrição do produto ou serviço. Tamanho: 1–120.
   *
   * @return the iD: I04 — xProd
   */
  public String getXProd() {
    return xProd;
  }

  /**
   * # iD: I04 — xProd.<br>
   * Descrição do produto ou serviço. Tamanho: 1–120.
   *
   * @param xProd the new iD: I04 — xProd
   */
  public void setXProd(String xProd) {
    this.xProd = xProd;
  }

  /**
   * # iD: I05 — NCM.<br>
   * Código NCM (8 dígitos). Em alguns casos de serviço ou itens sem produto, pode ser utilizado “00”. Tamanho: 2 ou 8.
   *
   * @return the iD: I05 — NCM
   */
  public BigDecimal getNcm() {
    return ncm;
  }

  /**
   * # iD: I05 — NCM.<br>
   * Código NCM (8 dígitos). Em alguns casos de serviço ou itens sem produto, pode ser utilizado “00”. Tamanho: 2 ou 8.
   *
   * @param ncm the new iD: I05 — NCM
   */
  public void setNcm(BigDecimal ncm) {
    this.ncm = ncm;
  }

  /**
   * # iD: I05a — NVE.<br>
   * Codificação NVE (Nomenclatura de Valor Aduaneiro e Estatística).<br>
   * Formato: duas letras maiúsculas e quatro algarismos (ex.: "AB1234").<br>
   * Tamanho: 6. Ocorrência: até 8 repetições (tratado aqui como um único valor).
   *
   * @return the iD: I05a — NVE
   */
  public String getNve() {
    return nve;
  }

  /**
   * # iD: I05a — NVE.<br>
   * Codificação NVE (Nomenclatura de Valor Aduaneiro e Estatística).<br>
   * Formato: duas letras maiúsculas e quatro algarismos (ex.: "AB1234").<br>
   * Tamanho: 6. Ocorrência: até 8 repetições (tratado aqui como um único valor).
   *
   * @param nve the new iD: I05a — NVE
   */
  public void setNve(String nve) {
    this.nve = nve;
  }

  /**
   * # iD: I05c — CEST.<br>
   * Código Especificador da Substituição Tributária (CEST).<br>
   * Tamanho: 7.
   *
   * @return the iD: I05c — CEST
   */
  public BigDecimal getCest() {
    return cest;
  }

  /**
   * # iD: I05c — CEST.<br>
   * Código Especificador da Substituição Tributária (CEST).<br>
   * Tamanho: 7.
   *
   * @param cest the new iD: I05c — CEST
   */
  public void setCest(BigDecimal cest) {
    this.cest = cest;
  }

  /**
   * # iD: I05d — indEscala.<br>
   * Indicador de Produção em Escala Relevante, conforme Cláusula 23 do Convênio ICMS 52/2017.<br>
   * Valores: S=Produzido em Escala Relevante; N=Produzido em Escala NÃO Relevante.<br>
   * Preenchimento obrigatório para produtos com NCM relacionado no Anexo XXVII do Convênio 52/2017.
   *
   * @return the iD: I05d — indEscala
   */
  public SEFAZ_indEscala getIndEscala() {
    return indEscala;
  }

  /**
   * # iD: I05d — indEscala.<br>
   * Indicador de Produção em Escala Relevante, conforme Cláusula 23 do Convênio ICMS 52/2017.<br>
   * Valores: S=Produzido em Escala Relevante; N=Produzido em Escala NÃO Relevante.<br>
   * Preenchimento obrigatório para produtos com NCM relacionado no Anexo XXVII do Convênio 52/2017.
   *
   * @param indEscala the new iD: I05d — indEscala
   */
  public void setIndEscala(SEFAZ_indEscala indEscala) {
    this.indEscala = indEscala;
  }

  /**
   * # iD: I05e — CNPJFab.<br>
   * CNPJ do fabricante da mercadoria, obrigatório para produto em escala NÃO relevante. Tamanho: 14.
   *
   * @return the iD: I05e — CNPJFab
   */
  public BigDecimal getCnpjFab() {
    return cnpjFab;
  }

  /**
   * # iD: I05e — CNPJFab.<br>
   * CNPJ do fabricante da mercadoria, obrigatório para produto em escala NÃO relevante. Tamanho: 14.
   *
   * @param cnpjFab the new iD: I05e — CNPJFab
   */
  public void setCnpjFab(BigDecimal cnpjFab) {
    this.cnpjFab = cnpjFab;
  }

  /**
   * # iD: I05f — cBenef.<br>
   * Código de Benefício Fiscal na UF aplicado ao item, conforme legislação estadual. Tamanho: 8 ou 10.
   *
   * @return the iD: I05f — cBenef
   */
  public String getCBenef() {
    return cBenef;
  }

  /**
   * # iD: I05f — cBenef.<br>
   * Código de Benefício Fiscal na UF aplicado ao item, conforme legislação estadual. Tamanho: 8 ou 10.
   *
   * @param cBenef the new iD: I05f — cBenef
   */
  public void setCBenef(String cBenef) {
    this.cBenef = cBenef;
  }

  /**
   * # iD: I06 — EXTIPI.<br>
   * Código EX-TIPI conforme legislação. Tamanho: 2–3.
   *
   * @return the iD: I06 — EXTIPI
   */
  public BigDecimal getExtipi() {
    return extipi;
  }

  /**
   * # iD: I06 — EXTIPI.<br>
   * Código EX-TIPI conforme legislação. Tamanho: 2–3.
   *
   * @param extipi the new iD: I06 — EXTIPI
   */
  public void setExtipi(BigDecimal extipi) {
    this.extipi = extipi;
  }

  /**
   * Gets the cfop.
   *
   * @return the cfop
   */
  public BigDecimal getCFOP() {
    return CFOP;
  }

  /**
   * Sets the cfop.
   *
   * @param cFOP the new cfop
   */
  public void setCFOP(BigDecimal cFOP) {
    CFOP = cFOP;
  }

  /**
   * # iD: I09 — uCom.<br>
   * Unidade comercial do produto. Tamanho: 1–6.
   *
   * @return the iD: I09 — uCom
   */
  public String getUCom() {
    return uCom;
  }

  /**
   * # iD: I09 — uCom.<br>
   * Unidade comercial do produto. Tamanho: 1–6.
   *
   * @param uCom the new iD: I09 — uCom
   */
  public void setUCom(String uCom) {
    this.uCom = uCom;
  }

  /**
   * # iD: I10 — qCom.<br>
   * Quantidade comercial. Formato: até 11 dígitos com 0–4 casas decimais (11v0–4).
   *
   * @return the iD: I10 — qCom
   */
  public BigDecimal getQCom() {
    return qCom;
  }

  /**
   * # iD: I10 — qCom.<br>
   * Quantidade comercial. Formato: até 11 dígitos com 0–4 casas decimais (11v0–4).
   *
   * @param qCom the new iD: I10 — qCom
   */
  public void setQCom(BigDecimal qCom) {
    this.qCom = qCom;
  }

  /**
   * # iD: I10a — vUnCom.<br>
   * Valor unitário de comercialização do produto. Formato: até 11 dígitos com 0–10 casas decimais (11v0–10).
   *
   * @return the iD: I10a — vUnCom
   */
  public BigDecimal getVUnCom() {
    return vUnCom;
  }

  /**
   * # iD: I10a — vUnCom.<br>
   * Valor unitário de comercialização do produto. Formato: até 11 dígitos com 0–10 casas decimais (11v0–10).
   *
   * @param vUnCom the new iD: I10a — vUnCom
   */
  public void setVUnCom(BigDecimal vUnCom) {
    this.vUnCom = vUnCom;
  }

  /**
   * # iD: I11 — vProd.<br>
   * Valor total bruto dos produtos ou serviços. Formato: 13v2.
   *
   * @return the iD: I11 — vProd
   */
  public BigDecimal getVProd() {
    return vProd;
  }

  /**
   * # iD: I11 — vProd.<br>
   * Valor total bruto dos produtos ou serviços. Formato: 13v2.
   *
   * @param vProd the new iD: I11 — vProd
   */
  public void setVProd(BigDecimal vProd) {
    this.vProd = vProd;
  }

  /**
   * # iD: I12 — cEANTrib.<br>
   * GTIN da unidade tributável. Mesmos critérios do cEAN (I03).<br>
   * Para produtos sem GTIN, informar “SEM GTIN”.
   *
   * @return the iD: I12 — cEANTrib
   */
  public String getCEANTrib() {
    return cEANTrib;
  }

  /**
   * # iD: I12 — cEANTrib.<br>
   * GTIN da unidade tributável. Mesmos critérios do cEAN (I03).<br>
   * Para produtos sem GTIN, informar “SEM GTIN”.
   *
   * @param cEANTrib the new iD: I12 — cEANTrib
   */
  public void setCEANTrib(String cEANTrib) {
    this.cEANTrib = cEANTrib;
  }

  /**
   * # iD: I13 — uTrib.<br>
   * Unidade tributável. Tamanho: 1–6.
   *
   * @return the iD: I13 — uTrib
   */
  public String getUTrib() {
    return uTrib;
  }

  /**
   * # iD: I13 — uTrib.<br>
   * Unidade tributável. Tamanho: 1–6.
   *
   * @param uTrib the new iD: I13 — uTrib
   */
  public void setUTrib(String uTrib) {
    this.uTrib = uTrib;
  }

  /**
   * # iD: I14 — qTrib.<br>
   * Quantidade tributável. Formato: até 11 dígitos com 0–4 casas decimais (11v0–4).
   *
   * @return the iD: I14 — qTrib
   */
  public BigDecimal getQTrib() {
    return qTrib;
  }

  /**
   * # iD: I14 — qTrib.<br>
   * Quantidade tributável. Formato: até 11 dígitos com 0–4 casas decimais (11v0–4).
   *
   * @param qTrib the new iD: I14 — qTrib
   */
  public void setQTrib(BigDecimal qTrib) {
    this.qTrib = qTrib;
  }

  /**
   * # iD: I14a — vUnTrib.<br>
   * Valor unitário de tributação da unidade tributável. Formato: 11v0–10.
   *
   * @return the iD: I14a — vUnTrib
   */
  public BigDecimal getVUnTrib() {
    return vUnTrib;
  }

  /**
   * # iD: I14a — vUnTrib.<br>
   * Valor unitário de tributação da unidade tributável. Formato: 11v0–10.
   *
   * @param vUnTrib the new iD: I14a — vUnTrib
   */
  public void setVUnTrib(BigDecimal vUnTrib) {
    this.vUnTrib = vUnTrib;
  }

  /**
   * # iD: I15 — vFrete.<br>
   * Valor total do frete do item. Formato: 13v2.
   *
   * @return the iD: I15 — vFrete
   */
  public BigDecimal getVFrete() {
    return vFrete;
  }

  /**
   * # iD: I15 — vFrete.<br>
   * Valor total do frete do item. Formato: 13v2.
   *
   * @param vFrete the new iD: I15 — vFrete
   */
  public void setVFrete(BigDecimal vFrete) {
    this.vFrete = vFrete;
  }

  /**
   * # iD: I16 — vSeg.<br>
   * Valor total do seguro do item. Formato: 13v2.
   *
   * @return the iD: I16 — vSeg
   */
  public BigDecimal getVSeg() {
    return vSeg;
  }

  /**
   * # iD: I16 — vSeg.<br>
   * Valor total do seguro do item. Formato: 13v2.
   *
   * @param vSeg the new iD: I16 — vSeg
   */
  public void setVSeg(BigDecimal vSeg) {
    this.vSeg = vSeg;
  }

  /**
   * # iD: I17 — vDesc.<br>
   * Valor do desconto do item. Formato: 13v2.
   *
   * @return the iD: I17 — vDesc
   */
  public BigDecimal getVDesc() {
    return vDesc;
  }

  /**
   * # iD: I17 — vDesc.<br>
   * Valor do desconto do item. Formato: 13v2.
   *
   * @param vDesc the new iD: I17 — vDesc
   */
  public void setVDesc(BigDecimal vDesc) {
    this.vDesc = vDesc;
  }

  /**
   * # iD: I17a — vOutro.<br>
   * Outras despesas acessórias do item. Formato: 13v2 (v2.0).
   *
   * @return the iD: I17a — vOutro
   */
  public BigDecimal getVOutro() {
    return vOutro;
  }

  /**
   * # iD: I17a — vOutro.<br>
   * Outras despesas acessórias do item. Formato: 13v2 (v2.0).
   *
   * @param vOutro the new iD: I17a — vOutro
   */
  public void setVOutro(BigDecimal vOutro) {
    this.vOutro = vOutro;
  }

  /**
   * # iD: I17b — indTot.<br>
   * Indica se o valor do item (vProd) compõe o valor total da NF-e (vProd).<br>
   * Valores: 0=Não compõe; 1=Compõe. (Versão 2.0).
   *
   * @return the iD: I17b — indTot
   */
  public SEFAZ_indTot getIndTot() {
    return indTot;
  }

  /**
   * # iD: I17b — indTot.<br>
   * Indica se o valor do item (vProd) compõe o valor total da NF-e (vProd).<br>
   * Valores: 0=Não compõe; 1=Compõe. (Versão 2.0).
   *
   * @param indTot the new iD: I17b — indTot
   */
  public void setIndTot(SEFAZ_indTot indTot) {
    this.indTot = indTot;
  }

}
