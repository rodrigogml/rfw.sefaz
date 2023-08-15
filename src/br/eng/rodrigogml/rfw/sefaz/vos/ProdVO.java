package br.eng.rodrigogml.rfw.sefaz.vos;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCNPJField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "prodFe" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class ProdVO extends RFWVO {

  private static final long serialVersionUID = 8862454938214955919L;

  /**
   * I02 cProd Código do produto ou serviço E I01 C 1-1 1 - 60<br>
   * Preencher com CFOP, caso se trate de itens não relacionados com mercadorias/produtos e que o contribuinte não possua codificação própria. <br>
   * Formato: ”CFOP9999”
   */
  @RFWMetaStringField(caption = "Código do Produto/Serviço", minlength = 1, maxLength = 60, required = true, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cprod = null;

  /**
   * I03 cEAN GTIN (Global Trade Item Number) do produto, antigo código EAN ou código de barras E I01 C 1-1 0,8,12, 13, 14 <br>
   * Preencher com o código GTIN-8, GTIN-12, GTIN-13 ou GTIN-14 (antigos códigos EAN, UPC e DUN-14) <br>
   * Para produtos que não possuem código de barras com GTIN, deve ser informado o literal “SEM GTIN”; (atualizado NT 2017/001)
   */
  @RFWMetaStringField(caption = "EAN/GTIN", minlength = 0, maxLength = 14, required = true, pattern = "^(SEM GTIN|\\d{0,14})$")
  private String cean = null;

  /**
   * I04 xProd Descrição do produto ou serviço E I01 C 1-1 1 - 120
   */
  @RFWMetaStringField(caption = "Descrição do Produto/Serviço", minlength = 1, maxLength = 120, required = true, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xprod = null;

  /**
   * I05 NCM Código NCM com 8 dígitos E I01 N 1-1 2, 8<br>
   * Obrigatória informação do NCM completo (8 dígitos). <BR>
   * Nota: Em caso de item de serviço ou item que não tenham produto (ex. transferência de crédito, crédito do ativo imobilizado, etc.), informar o valor 00 (dois zeros). (NT 2014/004)
   */
  @RFWMetaStringField(caption = "NCM", minlength = 2, maxLength = 8, required = true, pattern = "\\d{2,8}")
  private String ncm = null;

  /**
   * I05c CEST Código CEST E I05b N 1-1 7<BR>
   * Campo CEST (Código Especificador da Substituição Tributária), que estabelece a sistemática de uniformização e identificação das mercadorias e bens passíveis de sujeição aos regimes de substituição tributária e de antecipação de recolhimento do ICMS. <BR>
   * (Incluído na NT 2015/003. Atualizado NT2016.002)
   */
  @RFWMetaStringField(caption = "CEST", minlength = 7, maxLength = 7, required = true, pattern = "\\d{7}")
  private String cest = null;

  /**
   * I05d indEscala Indicador de Escala Relevante E I05b C 0-1 1<br>
   * Indicador de Produção em escala relevante, conforme Cláusula 23 do Convenio ICMS 52/2017:
   * <LI>S - Produzido em Escala Relevante;
   * <LI>N – Produzido em Escala NÃO Relevante. <BR>
   * Nota: preenchimento Obrig.atório para produtos com NCM relacionado no Anexo XXVII do Convenio 52/2017 (Incluído na NT2016.002)
   */
  @RFWMetaStringField(caption = "Indicador de Escala", minlength = 1, maxLength = 1, required = false, pattern = "^(S|N)$")
  private String indEscala = null;

  /**
   * I05e CNPJFab CNPJ do Fabricante da Mercadoria E I05b N 0-1 14<BR>
   * CNPJ do Fabricante da Mercadoria, obrigatório para produto em escala NÃO relevante. <br>
   * (Incluído na NT2016.002)
   */
  @RFWMetaStringCNPJField(caption = "CNPJ do Fabricante", required = false)
  private String cnpjFab = null;

  /**
   * I06 EXTIPI EX_TIPI E I01 N 0-1 2 - 3<BR>
   * Preencher de acordo com o código EX da TIPI. Em caso de serviço, não incluir a TAG.
   */
  @RFWMetaStringField(caption = "ExTIPI", minlength = 2, maxLength = 3, required = false, pattern = "\\d+")
  private String extIPI = null;

  /**
   * I08 CFOP Código Fiscal de Operações e Prestações E I01 N 1-1 4<br>
   * Utilizar Tabela de CFOP.
   */
  @RFWMetaStringField(caption = "CFOP", minlength = 4, maxLength = 4, required = true, pattern = "\\d{4}")
  private String cfop = null;

  /**
   * I09 uCom Unidade Comercial E I01 C 1-1 1 - 6<BR>
   * Informar a unidade de comercialização do produto.
   */
  @RFWMetaStringField(caption = "Unidade Comercial", minlength = 1, maxLength = 6, required = true, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String ucom = null;

  /**
   * I10 qCom Quantidade Comercial E I01 N 1-1 11v0-4<br>
   * Informar a quantidade de comercialização do produto (v2.0).
   */
  @RFWMetaBigDecimalField(caption = "Quantidade Comercial", minValue = "0", maxValue = "99999999999.9999", scale = 0, scaleMax = 4, required = true)
  private BigDecimal qcom = null;

  /**
   * I10a vUnCom Valor Unitário de Comercialização E I01 N 1-1 11v0-10<br>
   * Informar o valor unitário de comercialização do produto, campo meramente informativo, o contribuinte pode utilizar a precisão desejada (0-10 decimais).<br>
   * Para efeitos de cálculo, o valor unitário será obtido pela divisão do valor do produto pela quantidade comercial. (v2.0)
   */
  @RFWMetaBigDecimalField(caption = "Valor Unitário de Comercialização", minValue = "0", maxValue = "99999999999.9999999999", scale = 0, scaleMax = 10, required = true)
  private BigDecimal vunCom = null;

  /**
   * I11 vProd Valor Total Bruto dos Produtos ou Serviços. E I01 N 1-1 13v2<br>
   * O valor do ICMS faz parte do Valor Total Bruto
   */
  @RFWMetaBigDecimalField(caption = "Valor Total Bruto dos Produtos ou Serviços", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = true)
  private BigDecimal vprod = null;

  /**
   * I12 cEANTrib GTIN (Global Trade Item Number) da unidade tributável, antigo código EAN ou código de barras E I01 C 1-1 0,8,12, 13, 14 <Br>
   * Preencher com o código GTIN-8, GTIN-12, GTIN-13 ou GTIN-14 (antigos códigos EAN, UPC e DUN-14) da unidade tributável do produto. <br>
   * O GTIN da unidade tributável deve corresponder àquele da menor unidade comercializável identificada por código GTIN. <br>
   * Para produtos que não possuem código de barras com GTIN, deve ser informado o literal "SEM GTIN”; <br>
   * (Atualizado NT 2017.001)
   */
  @RFWMetaStringField(caption = "EAN/GTIN da Unidade Tributável", minlength = 0, maxLength = 14, pattern = "\\d*", required = true)
  private String ceanTrib = null;

  /**
   * I13 uTrib Unidade Tributável E I01 C 1-1 1 - 6
   */
  @RFWMetaStringField(caption = "Unidade Tributável", minlength = 1, maxLength = 6, required = true)
  private String utrib = null;

  /**
   * I14 qTrib Quantidade Tributável E I01 N 1-1 11v0-4<br>
   * O GTIN da unidade tributável deve corresponder àquele da menor unidade comercializável identificada por código GTIN.
   */
  @RFWMetaBigDecimalField(caption = "Quantidade Tributável", minValue = "0", maxValue = "99999999999.9999", scale = 0, scaleMax = 4, required = true)
  private BigDecimal qTrib = null;

  /**
   * I14a vUnTrib Valor Unitário de tributação E I01 N 1-1 11v0-10
   */
  @RFWMetaBigDecimalField(caption = "Valor Unitário de Tributação", minValue = "0", maxValue = "99999999999.9999999999", scale = 0, scaleMax = 10, required = true)
  private BigDecimal vunTrib = null;

  /**
   * I15 vFrete Valor Total do Frete E I01 N 0-1 13v2<br>
   * Para produtos que não possuem código de barras com GTIN, deve ser informado o literal "SEM GTIN”;<br>
   * <b>A linha de descrição acima foi tirada do manual da NFe, porem acredito que seja um erro, pois o campo é do tipo numérico.</b>
   */
  @RFWMetaBigDecimalField(caption = "Valor Total do Frete", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vfrete = null;

  /**
   * I16 vSeg Valor Total do Seguro E I01 N 0-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor Total do Seguro", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vseg = null;

  /**
   * I17 vDesc Valor do Desconto E I01 N 0-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor do Desconto", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vdesc = null;

  /**
   * I17a vOutro Outras despesas acessórias E I01 N 0-1 13v2 (v2.0)
   */
  @RFWMetaBigDecimalField(caption = "Outras Despesas Acessórias", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal voutro = null;

  /**
   * I17b indTot Indica se valor do Item (vProd) entra no valor total da NF-e (vProd) E I01 N 1-1 1<br>
   * <li>0=Valor do item (vProd) não compõe o valor total da NF-e
   * <li>1=Valor do item (vProd) compõe o valor total da NFe (vProd) (v2.0)
   */
  @RFWMetaStringField(caption = "Indicador de Composição do Valor Total da NFe", minlength = 1, maxLength = 1, required = true, pattern = "^(0|1)$")
  private String indTot = null;

  /**
   * # i02 cProd Código do produto ou serviço E I01 C 1-1 1 - 60<br>
   * Preencher com CFOP, caso se trate de itens não relacionados com mercadorias/produtos e que o contribuinte não possua codificação própria. <br>
   * Formato: ”CFOP9999”.
   *
   * @return # i02 cProd Código do produto ou serviço E I01 C 1-1 1 - 60<br>
   *         Preencher com CFOP, caso se trate de itens não relacionados com mercadorias/produtos e que o contribuinte não possua codificação própria
   */
  public String getCprod() {
    return cprod;
  }

  /**
   * # i02 cProd Código do produto ou serviço E I01 C 1-1 1 - 60<br>
   * Preencher com CFOP, caso se trate de itens não relacionados com mercadorias/produtos e que o contribuinte não possua codificação própria. <br>
   * Formato: ”CFOP9999”.
   *
   * @param cprod # i02 cProd Código do produto ou serviço E I01 C 1-1 1 - 60<br>
   *          Preencher com CFOP, caso se trate de itens não relacionados com mercadorias/produtos e que o contribuinte não possua codificação própria
   */
  public void setCprod(String cprod) {
    this.cprod = cprod;
  }

  /**
   * # i03 cEAN GTIN (Global Trade Item Number) do produto, antigo código EAN ou código de barras E I01 C 1-1 0,8,12, 13, 14 <br>
   * Preencher com o código GTIN-8, GTIN-12, GTIN-13 ou GTIN-14 (antigos códigos EAN, UPC e DUN-14) <br>
   * Para produtos que não possuem código de barras com GTIN, deve ser informado o literal “SEM GTIN”; (atualizado NT 2017/001).
   *
   * @return # i03 cEAN GTIN (Global Trade Item Number) do produto, antigo código EAN ou código de barras E I01 C 1-1 0,8,12, 13, 14 <br>
   *         Preencher com o código GTIN-8, GTIN-12, GTIN-13 ou GTIN-14 (antigos códigos EAN, UPC e DUN-14) <br>
   *         Para produtos que não possuem código de barras com GTIN, deve ser informado o literal “SEM GTIN”; (atualizado NT 2017/001)
   */
  public String getCean() {
    return cean;
  }

  /**
   * # i03 cEAN GTIN (Global Trade Item Number) do produto, antigo código EAN ou código de barras E I01 C 1-1 0,8,12, 13, 14 <br>
   * Preencher com o código GTIN-8, GTIN-12, GTIN-13 ou GTIN-14 (antigos códigos EAN, UPC e DUN-14) <br>
   * Para produtos que não possuem código de barras com GTIN, deve ser informado o literal “SEM GTIN”; (atualizado NT 2017/001).
   *
   * @param cean # i03 cEAN GTIN (Global Trade Item Number) do produto, antigo código EAN ou código de barras E I01 C 1-1 0,8,12, 13, 14 <br>
   *          Preencher com o código GTIN-8, GTIN-12, GTIN-13 ou GTIN-14 (antigos códigos EAN, UPC e DUN-14) <br>
   *          Para produtos que não possuem código de barras com GTIN, deve ser informado o literal “SEM GTIN”; (atualizado NT 2017/001)
   */
  public void setCean(String cean) {
    this.cean = cean;
  }

  /**
   * # i04 xProd Descrição do produto ou serviço E I01 C 1-1 1 - 120.
   *
   * @return # i04 xProd Descrição do produto ou serviço E I01 C 1-1 1 - 120
   */
  public String getXprod() {
    return xprod;
  }

  /**
   * # i04 xProd Descrição do produto ou serviço E I01 C 1-1 1 - 120.
   *
   * @param xprod # i04 xProd Descrição do produto ou serviço E I01 C 1-1 1 - 120
   */
  public void setXprod(String xprod) {
    this.xprod = xprod;
  }

  /**
   * # i05 NCM Código NCM com 8 dígitos E I01 N 1-1 2, 8<br>
   * Obrigatória informação do NCM completo (8 dígitos). <BR>
   * Nota: Em caso de item de serviço ou item que não tenham produto (ex. transferência de crédito, crédito do ativo imobilizado, etc.), informar o valor 00 (dois zeros). (NT 2014/004).
   *
   * @return # i05 NCM Código NCM com 8 dígitos E I01 N 1-1 2, 8<br>
   *         Obrigatória informação do NCM completo (8 dígitos)
   */
  public String getNcm() {
    return ncm;
  }

  /**
   * # i05 NCM Código NCM com 8 dígitos E I01 N 1-1 2, 8<br>
   * Obrigatória informação do NCM completo (8 dígitos). <BR>
   * Nota: Em caso de item de serviço ou item que não tenham produto (ex. transferência de crédito, crédito do ativo imobilizado, etc.), informar o valor 00 (dois zeros). (NT 2014/004).
   *
   * @param ncm # i05 NCM Código NCM com 8 dígitos E I01 N 1-1 2, 8<br>
   *          Obrigatória informação do NCM completo (8 dígitos)
   */
  public void setNcm(String ncm) {
    this.ncm = ncm;
  }

  /**
   * # i05c CEST Código CEST E I05b N 1-1 7<BR>
   * Campo CEST (Código Especificador da Substituição Tributária), que estabelece a sistemática de uniformização e identificação das mercadorias e bens passíveis de sujeição aos regimes de substituição tributária e de antecipação de recolhimento do ICMS. <BR>
   * (Incluído na NT 2015/003. Atualizado NT2016.002).
   *
   * @return # i05c CEST Código CEST E I05b N 1-1 7<BR>
   *         Campo CEST (Código Especificador da Substituição Tributária), que estabelece a sistemática de uniformização e identificação das mercadorias e bens passíveis de sujeição aos regimes de substituição tributária e de antecipação de recolhimento do ICMS
   */
  public String getCest() {
    return cest;
  }

  /**
   * # i05c CEST Código CEST E I05b N 1-1 7<BR>
   * Campo CEST (Código Especificador da Substituição Tributária), que estabelece a sistemática de uniformização e identificação das mercadorias e bens passíveis de sujeição aos regimes de substituição tributária e de antecipação de recolhimento do ICMS. <BR>
   * (Incluído na NT 2015/003. Atualizado NT2016.002).
   *
   * @param cest # i05c CEST Código CEST E I05b N 1-1 7<BR>
   *          Campo CEST (Código Especificador da Substituição Tributária), que estabelece a sistemática de uniformização e identificação das mercadorias e bens passíveis de sujeição aos regimes de substituição tributária e de antecipação de recolhimento do ICMS
   */
  public void setCest(String cest) {
    this.cest = cest;
  }

  /**
   * # i05d indEscala Indicador de Escala Relevante E I05b C 0-1 1<br>
   * Indicador de Produção em escala relevante, conforme Cláusula 23 do Convenio ICMS 52/2017:
   * <LI>S - Produzido em Escala Relevante;
   * <LI>N – Produzido em Escala NÃO Relevante. <BR>
   * Nota: preenchimento Obrig.atório para produtos com NCM relacionado no Anexo XXVII do Convenio 52/2017 (Incluído na NT2016.002).
   *
   * @return # i05d indEscala Indicador de Escala Relevante E I05b C 0-1 1<br>
   *         Indicador de Produção em escala relevante, conforme Cláusula 23 do Convenio ICMS 52/2017:
   *         <LI>S - Produzido em Escala Relevante;
   *         <LI>N – Produzido em Escala NÃO Relevante
   */
  public String getIndEscala() {
    return indEscala;
  }

  /**
   * # i05d indEscala Indicador de Escala Relevante E I05b C 0-1 1<br>
   * Indicador de Produção em escala relevante, conforme Cláusula 23 do Convenio ICMS 52/2017:
   * <LI>S - Produzido em Escala Relevante;
   * <LI>N – Produzido em Escala NÃO Relevante. <BR>
   * Nota: preenchimento Obrig.atório para produtos com NCM relacionado no Anexo XXVII do Convenio 52/2017 (Incluído na NT2016.002).
   *
   * @param indEscala # i05d indEscala Indicador de Escala Relevante E I05b C 0-1 1<br>
   *          Indicador de Produção em escala relevante, conforme Cláusula 23 do Convenio ICMS 52/2017:
   *          <LI>S - Produzido em Escala Relevante;
   *          <LI>N – Produzido em Escala NÃO Relevante
   */
  public void setIndEscala(String indEscala) {
    this.indEscala = indEscala;
  }

  /**
   * # i05e CNPJFab CNPJ do Fabricante da Mercadoria E I05b N 0-1 14<BR>
   * CNPJ do Fabricante da Mercadoria, obrigatório para produto em escala NÃO relevante. <br>
   * (Incluído na NT2016.002).
   *
   * @return # i05e CNPJFab CNPJ do Fabricante da Mercadoria E I05b N 0-1 14<BR>
   *         CNPJ do Fabricante da Mercadoria, obrigatório para produto em escala NÃO relevante
   */
  public String getCnpjFab() {
    return cnpjFab;
  }

  /**
   * # i05e CNPJFab CNPJ do Fabricante da Mercadoria E I05b N 0-1 14<BR>
   * CNPJ do Fabricante da Mercadoria, obrigatório para produto em escala NÃO relevante. <br>
   * (Incluído na NT2016.002).
   *
   * @param cnpjFab # i05e CNPJFab CNPJ do Fabricante da Mercadoria E I05b N 0-1 14<BR>
   *          CNPJ do Fabricante da Mercadoria, obrigatório para produto em escala NÃO relevante
   */
  public void setCnpjFab(String cnpjFab) {
    this.cnpjFab = cnpjFab;
  }

  /**
   * # i06 EXTIPI EX_TIPI E I01 N 0-1 2 - 3<BR>
   * Preencher de acordo com o código EX da TIPI. Em caso de serviço, não incluir a TAG.
   *
   * @return # i06 EXTIPI EX_TIPI E I01 N 0-1 2 - 3<BR>
   *         Preencher de acordo com o código EX da TIPI
   */
  public String getExtIPI() {
    return extIPI;
  }

  /**
   * # i06 EXTIPI EX_TIPI E I01 N 0-1 2 - 3<BR>
   * Preencher de acordo com o código EX da TIPI. Em caso de serviço, não incluir a TAG.
   *
   * @param extIPI # i06 EXTIPI EX_TIPI E I01 N 0-1 2 - 3<BR>
   *          Preencher de acordo com o código EX da TIPI
   */
  public void setExtIPI(String extIPI) {
    this.extIPI = extIPI;
  }

  /**
   * # i08 CFOP Código Fiscal de Operações e Prestações E I01 N 1-1 4<br>
   * Utilizar Tabela de CFOP.
   *
   * @return # i08 CFOP Código Fiscal de Operações e Prestações E I01 N 1-1 4<br>
   *         Utilizar Tabela de CFOP
   */
  public String getCfop() {
    return cfop;
  }

  /**
   * # i08 CFOP Código Fiscal de Operações e Prestações E I01 N 1-1 4<br>
   * Utilizar Tabela de CFOP.
   *
   * @param cfop # i08 CFOP Código Fiscal de Operações e Prestações E I01 N 1-1 4<br>
   *          Utilizar Tabela de CFOP
   */
  public void setCfop(String cfop) {
    this.cfop = cfop;
  }

  /**
   * # i09 uCom Unidade Comercial E I01 C 1-1 1 - 6<BR>
   * Informar a unidade de comercialização do produto.
   *
   * @return # i09 uCom Unidade Comercial E I01 C 1-1 1 - 6<BR>
   *         Informar a unidade de comercialização do produto
   */
  public String getUcom() {
    return ucom;
  }

  /**
   * # i09 uCom Unidade Comercial E I01 C 1-1 1 - 6<BR>
   * Informar a unidade de comercialização do produto.
   *
   * @param ucom # i09 uCom Unidade Comercial E I01 C 1-1 1 - 6<BR>
   *          Informar a unidade de comercialização do produto
   */
  public void setUcom(String ucom) {
    this.ucom = ucom;
  }

  /**
   * # i10 qCom Quantidade Comercial E I01 N 1-1 11v0-4<br>
   * Informar a quantidade de comercialização do produto (v2.0).
   *
   * @return # i10 qCom Quantidade Comercial E I01 N 1-1 11v0-4<br>
   *         Informar a quantidade de comercialização do produto (v2
   */
  public BigDecimal getQcom() {
    return qcom;
  }

  /**
   * # i10 qCom Quantidade Comercial E I01 N 1-1 11v0-4<br>
   * Informar a quantidade de comercialização do produto (v2.0).
   *
   * @param qcom # i10 qCom Quantidade Comercial E I01 N 1-1 11v0-4<br>
   *          Informar a quantidade de comercialização do produto (v2
   */
  public void setQcom(BigDecimal qcom) {
    this.qcom = qcom;
  }

  /**
   * # i10a vUnCom Valor Unitário de Comercialização E I01 N 1-1 11v0-10<br>
   * Informar o valor unitário de comercialização do produto, campo meramente informativo, o contribuinte pode utilizar a precisão desejada (0-10 decimais).<br>
   * Para efeitos de cálculo, o valor unitário será obtido pela divisão do valor do produto pela quantidade comercial. (v2.0).
   *
   * @return # i10a vUnCom Valor Unitário de Comercialização E I01 N 1-1 11v0-10<br>
   *         Informar o valor unitário de comercialização do produto, campo meramente informativo, o contribuinte pode utilizar a precisão desejada (0-10 decimais)
   */
  public BigDecimal getVunCom() {
    return vunCom;
  }

  /**
   * # i10a vUnCom Valor Unitário de Comercialização E I01 N 1-1 11v0-10<br>
   * Informar o valor unitário de comercialização do produto, campo meramente informativo, o contribuinte pode utilizar a precisão desejada (0-10 decimais).<br>
   * Para efeitos de cálculo, o valor unitário será obtido pela divisão do valor do produto pela quantidade comercial. (v2.0).
   *
   * @param vunCom # i10a vUnCom Valor Unitário de Comercialização E I01 N 1-1 11v0-10<br>
   *          Informar o valor unitário de comercialização do produto, campo meramente informativo, o contribuinte pode utilizar a precisão desejada (0-10 decimais)
   */
  public void setVunCom(BigDecimal vunCom) {
    this.vunCom = vunCom;
  }

  /**
   * # i11 vProd Valor Total Bruto dos Produtos ou Serviços. E I01 N 1-1 13v2<br>
   * O valor do ICMS faz parte do Valor Total Bruto.
   *
   * @return # i11 vProd Valor Total Bruto dos Produtos ou Serviços
   */
  public BigDecimal getVprod() {
    return vprod;
  }

  /**
   * # i11 vProd Valor Total Bruto dos Produtos ou Serviços. E I01 N 1-1 13v2<br>
   * O valor do ICMS faz parte do Valor Total Bruto.
   *
   * @param vprod # i11 vProd Valor Total Bruto dos Produtos ou Serviços
   */
  public void setVprod(BigDecimal vprod) {
    this.vprod = vprod;
  }

  /**
   * # i12 cEANTrib GTIN (Global Trade Item Number) da unidade tributável, antigo código EAN ou código de barras E I01 C 1-1 0,8,12, 13, 14 <Br>
   * Preencher com o código GTIN-8, GTIN-12, GTIN-13 ou GTIN-14 (antigos códigos EAN, UPC e DUN-14) da unidade tributável do produto. <br>
   * O GTIN da unidade tributável deve corresponder àquele da menor unidade comercializável identificada por código GTIN. <br>
   * Para produtos que não possuem código de barras com GTIN, deve ser informado o literal "SEM GTIN”; <br>
   * (Atualizado NT 2017.001).
   *
   * @return # i12 cEANTrib GTIN (Global Trade Item Number) da unidade tributável, antigo código EAN ou código de barras E I01 C 1-1 0,8,12, 13, 14 <Br>
   *         Preencher com o código GTIN-8, GTIN-12, GTIN-13 ou GTIN-14 (antigos códigos EAN, UPC e DUN-14) da unidade tributável do produto
   */
  public String getCeanTrib() {
    return ceanTrib;
  }

  /**
   * # i12 cEANTrib GTIN (Global Trade Item Number) da unidade tributável, antigo código EAN ou código de barras E I01 C 1-1 0,8,12, 13, 14 <Br>
   * Preencher com o código GTIN-8, GTIN-12, GTIN-13 ou GTIN-14 (antigos códigos EAN, UPC e DUN-14) da unidade tributável do produto. <br>
   * O GTIN da unidade tributável deve corresponder àquele da menor unidade comercializável identificada por código GTIN. <br>
   * Para produtos que não possuem código de barras com GTIN, deve ser informado o literal "SEM GTIN”; <br>
   * (Atualizado NT 2017.001).
   *
   * @param ceanTrib # i12 cEANTrib GTIN (Global Trade Item Number) da unidade tributável, antigo código EAN ou código de barras E I01 C 1-1 0,8,12, 13, 14 <Br>
   *          Preencher com o código GTIN-8, GTIN-12, GTIN-13 ou GTIN-14 (antigos códigos EAN, UPC e DUN-14) da unidade tributável do produto
   */
  public void setCeanTrib(String ceanTrib) {
    this.ceanTrib = ceanTrib;
  }

  /**
   * # i13 uTrib Unidade Tributável E I01 C 1-1 1 - 6.
   *
   * @return # i13 uTrib Unidade Tributável E I01 C 1-1 1 - 6
   */
  public String getUtrib() {
    return utrib;
  }

  /**
   * # i13 uTrib Unidade Tributável E I01 C 1-1 1 - 6.
   *
   * @param utrib # i13 uTrib Unidade Tributável E I01 C 1-1 1 - 6
   */
  public void setUtrib(String utrib) {
    this.utrib = utrib;
  }

  public BigDecimal getqTrib() {
    return qTrib;
  }

  public void setqTrib(BigDecimal qTrib) {
    this.qTrib = qTrib;
  }

  /**
   * # i14a vUnTrib Valor Unitário de tributação E I01 N 1-1 11v0-10.
   *
   * @return # i14a vUnTrib Valor Unitário de tributação E I01 N 1-1 11v0-10
   */
  public BigDecimal getVunTrib() {
    return vunTrib;
  }

  /**
   * # i14a vUnTrib Valor Unitário de tributação E I01 N 1-1 11v0-10.
   *
   * @param vunTrib # i14a vUnTrib Valor Unitário de tributação E I01 N 1-1 11v0-10
   */
  public void setVunTrib(BigDecimal vunTrib) {
    this.vunTrib = vunTrib;
  }

  /**
   * # i15 vFrete Valor Total do Frete E I01 N 0-1 13v2<br>
   * Para produtos que não possuem código de barras com GTIN, deve ser informado o literal "SEM GTIN”;<br>
   * <b>A linha de descrição acima foi tirada do manual da NFe, porem acredito que seja um erro, pois o campo é do tipo numérico.</b>.
   *
   * @return # i15 vFrete Valor Total do Frete E I01 N 0-1 13v2<br>
   *         Para produtos que não possuem código de barras com GTIN, deve ser informado o literal "SEM GTIN”;<br>
   *         <b>A linha de descrição acima foi tirada do manual da NFe, porem acredito que seja um erro, pois o campo é do tipo numérico
   */
  public BigDecimal getVfrete() {
    return vfrete;
  }

  /**
   * # i15 vFrete Valor Total do Frete E I01 N 0-1 13v2<br>
   * Para produtos que não possuem código de barras com GTIN, deve ser informado o literal "SEM GTIN”;<br>
   * <b>A linha de descrição acima foi tirada do manual da NFe, porem acredito que seja um erro, pois o campo é do tipo numérico.</b>.
   *
   * @param vfrete # i15 vFrete Valor Total do Frete E I01 N 0-1 13v2<br>
   *          Para produtos que não possuem código de barras com GTIN, deve ser informado o literal "SEM GTIN”;<br>
   *          <b>A linha de descrição acima foi tirada do manual da NFe, porem acredito que seja um erro, pois o campo é do tipo numérico
   */
  public void setVfrete(BigDecimal vfrete) {
    this.vfrete = vfrete;
  }

  /**
   * # i16 vSeg Valor Total do Seguro E I01 N 0-1 13v2.
   *
   * @return # i16 vSeg Valor Total do Seguro E I01 N 0-1 13v2
   */
  public BigDecimal getVseg() {
    return vseg;
  }

  /**
   * # i16 vSeg Valor Total do Seguro E I01 N 0-1 13v2.
   *
   * @param vseg # i16 vSeg Valor Total do Seguro E I01 N 0-1 13v2
   */
  public void setVseg(BigDecimal vseg) {
    this.vseg = vseg;
  }

  /**
   * # i17 vDesc Valor do Desconto E I01 N 0-1 13v2.
   *
   * @return # i17 vDesc Valor do Desconto E I01 N 0-1 13v2
   */
  public BigDecimal getVdesc() {
    return vdesc;
  }

  /**
   * # i17 vDesc Valor do Desconto E I01 N 0-1 13v2.
   *
   * @param vdesc # i17 vDesc Valor do Desconto E I01 N 0-1 13v2
   */
  public void setVdesc(BigDecimal vdesc) {
    this.vdesc = vdesc;
  }

  /**
   * # i17a vOutro Outras despesas acessórias E I01 N 0-1 13v2 (v2.0).
   *
   * @return # i17a vOutro Outras despesas acessórias E I01 N 0-1 13v2 (v2
   */
  public BigDecimal getVoutro() {
    return voutro;
  }

  /**
   * # i17a vOutro Outras despesas acessórias E I01 N 0-1 13v2 (v2.0).
   *
   * @param voutro # i17a vOutro Outras despesas acessórias E I01 N 0-1 13v2 (v2
   */
  public void setVoutro(BigDecimal voutro) {
    this.voutro = voutro;
  }

  /**
   * # i17b indTot Indica se valor do Item (vProd) entra no valor total da NF-e (vProd) E I01 N 1-1 1<br>
   * <li>0=Valor do item (vProd) não compõe o valor total da NF-e
   * <li>1=Valor do item (vProd) compõe o valor total da NFe (vProd) (v2.0).
   *
   * @return # i17b indTot Indica se valor do Item (vProd) entra no valor total da NF-e (vProd) E I01 N 1-1 1<br>
   *         <li>0=Valor do item (vProd) não compõe o valor total da NF-e
   *         <li>1=Valor do item (vProd) compõe o valor total da NFe (vProd) (v2
   */
  public String getIndTot() {
    return indTot;
  }

  /**
   * # i17b indTot Indica se valor do Item (vProd) entra no valor total da NF-e (vProd) E I01 N 1-1 1<br>
   * <li>0=Valor do item (vProd) não compõe o valor total da NF-e
   * <li>1=Valor do item (vProd) compõe o valor total da NFe (vProd) (v2.0).
   *
   * @param indTot # i17b indTot Indica se valor do Item (vProd) entra no valor total da NF-e (vProd) E I01 N 1-1 1<br>
   *          <li>0=Valor do item (vProd) não compõe o valor total da NF-e
   *          <li>1=Valor do item (vProd) compõe o valor total da NFe (vProd) (v2
   */
  public void setIndTot(String indTot) {
    this.indTot = indTot;
  }

}
