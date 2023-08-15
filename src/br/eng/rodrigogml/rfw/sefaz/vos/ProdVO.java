package br.eng.rodrigogml.rfw.sefaz.vos;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCNPJField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "prodFe" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integra��o com o framework, pertindo a valida��o e at� a persist�ncia se o sistema assim desejar. N�o h� preocupa��o de gerar JavaDOC nestas classes pois ela deve representar exatamente a documenta��o da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Valida��o da NF-e.
 */
public class ProdVO extends RFWVO {

  private static final long serialVersionUID = 8862454938214955919L;

  /**
   * I02 cProd C�digo do produto ou servi�o E I01 C 1-1 1 - 60<br>
   * Preencher com CFOP, caso se trate de itens n�o relacionados com mercadorias/produtos e que o contribuinte n�o possua codifica��o pr�pria. <br>
   * Formato: �CFOP9999�
   */
  @RFWMetaStringField(caption = "C�digo do Produto/Servi�o", minlength = 1, maxLength = 60, required = true, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cprod = null;

  /**
   * I03 cEAN GTIN (Global Trade Item Number) do produto, antigo c�digo EAN ou c�digo de barras E I01 C 1-1 0,8,12, 13, 14 <br>
   * Preencher com o c�digo GTIN-8, GTIN-12, GTIN-13 ou GTIN-14 (antigos c�digos EAN, UPC e DUN-14) <br>
   * Para produtos que n�o possuem c�digo de barras com GTIN, deve ser informado o literal �SEM GTIN�; (atualizado NT 2017/001)
   */
  @RFWMetaStringField(caption = "EAN/GTIN", minlength = 0, maxLength = 14, required = true, pattern = "^(SEM GTIN|\\d{0,14})$")
  private String cean = null;

  /**
   * I04 xProd Descri��o do produto ou servi�o E I01 C 1-1 1 - 120
   */
  @RFWMetaStringField(caption = "Descri��o do Produto/Servi�o", minlength = 1, maxLength = 120, required = true, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xprod = null;

  /**
   * I05 NCM C�digo NCM com 8 d�gitos E I01 N 1-1 2, 8<br>
   * Obrigat�ria informa��o do NCM completo (8 d�gitos). <BR>
   * Nota: Em caso de item de servi�o ou item que n�o tenham produto (ex. transfer�ncia de cr�dito, cr�dito do ativo imobilizado, etc.), informar o valor 00 (dois zeros). (NT 2014/004)
   */
  @RFWMetaStringField(caption = "NCM", minlength = 2, maxLength = 8, required = true, pattern = "\\d{2,8}")
  private String ncm = null;

  /**
   * I05c CEST C�digo CEST E I05b N 1-1 7<BR>
   * Campo CEST (C�digo Especificador da Substitui��o Tribut�ria), que estabelece a sistem�tica de uniformiza��o e identifica��o das mercadorias e bens pass�veis de sujei��o aos regimes de substitui��o tribut�ria e de antecipa��o de recolhimento do ICMS. <BR>
   * (Inclu�do na NT 2015/003. Atualizado NT2016.002)
   */
  @RFWMetaStringField(caption = "CEST", minlength = 7, maxLength = 7, required = true, pattern = "\\d{7}")
  private String cest = null;

  /**
   * I05d indEscala Indicador de Escala Relevante E I05b C 0-1 1<br>
   * Indicador de Produ��o em escala relevante, conforme Cl�usula 23 do Convenio ICMS 52/2017:
   * <LI>S - Produzido em Escala Relevante;
   * <LI>N � Produzido em Escala N�O Relevante. <BR>
   * Nota: preenchimento Obrig.at�rio para produtos com NCM relacionado no Anexo XXVII do Convenio 52/2017 (Inclu�do na NT2016.002)
   */
  @RFWMetaStringField(caption = "Indicador de Escala", minlength = 1, maxLength = 1, required = false, pattern = "^(S|N)$")
  private String indEscala = null;

  /**
   * I05e CNPJFab CNPJ do Fabricante da Mercadoria E I05b N 0-1 14<BR>
   * CNPJ do Fabricante da Mercadoria, obrigat�rio para produto em escala N�O relevante. <br>
   * (Inclu�do na NT2016.002)
   */
  @RFWMetaStringCNPJField(caption = "CNPJ do Fabricante", required = false)
  private String cnpjFab = null;

  /**
   * I06 EXTIPI EX_TIPI E I01 N 0-1 2 - 3<BR>
   * Preencher de acordo com o c�digo EX da TIPI. Em caso de servi�o, n�o incluir a TAG.
   */
  @RFWMetaStringField(caption = "ExTIPI", minlength = 2, maxLength = 3, required = false, pattern = "\\d+")
  private String extIPI = null;

  /**
   * I08 CFOP C�digo Fiscal de Opera��es e Presta��es E I01 N 1-1 4<br>
   * Utilizar Tabela de CFOP.
   */
  @RFWMetaStringField(caption = "CFOP", minlength = 4, maxLength = 4, required = true, pattern = "\\d{4}")
  private String cfop = null;

  /**
   * I09 uCom Unidade Comercial E I01 C 1-1 1 - 6<BR>
   * Informar a unidade de comercializa��o do produto.
   */
  @RFWMetaStringField(caption = "Unidade Comercial", minlength = 1, maxLength = 6, required = true, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String ucom = null;

  /**
   * I10 qCom Quantidade Comercial E I01 N 1-1 11v0-4<br>
   * Informar a quantidade de comercializa��o do produto (v2.0).
   */
  @RFWMetaBigDecimalField(caption = "Quantidade Comercial", minValue = "0", maxValue = "99999999999.9999", scale = 0, scaleMax = 4, required = true)
  private BigDecimal qcom = null;

  /**
   * I10a vUnCom Valor Unit�rio de Comercializa��o E I01 N 1-1 11v0-10<br>
   * Informar o valor unit�rio de comercializa��o do produto, campo meramente informativo, o contribuinte pode utilizar a precis�o desejada (0-10 decimais).<br>
   * Para efeitos de c�lculo, o valor unit�rio ser� obtido pela divis�o do valor do produto pela quantidade comercial. (v2.0)
   */
  @RFWMetaBigDecimalField(caption = "Valor Unit�rio de Comercializa��o", minValue = "0", maxValue = "99999999999.9999999999", scale = 0, scaleMax = 10, required = true)
  private BigDecimal vunCom = null;

  /**
   * I11 vProd Valor Total Bruto dos Produtos ou Servi�os. E I01 N 1-1 13v2<br>
   * O valor do ICMS faz parte do Valor Total Bruto
   */
  @RFWMetaBigDecimalField(caption = "Valor Total Bruto dos Produtos ou Servi�os", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = true)
  private BigDecimal vprod = null;

  /**
   * I12 cEANTrib GTIN (Global Trade Item Number) da unidade tribut�vel, antigo c�digo EAN ou c�digo de barras E I01 C 1-1 0,8,12, 13, 14 <Br>
   * Preencher com o c�digo GTIN-8, GTIN-12, GTIN-13 ou GTIN-14 (antigos c�digos EAN, UPC e DUN-14) da unidade tribut�vel do produto. <br>
   * O GTIN da unidade tribut�vel deve corresponder �quele da menor unidade comercializ�vel identificada por c�digo GTIN. <br>
   * Para produtos que n�o possuem c�digo de barras com GTIN, deve ser informado o literal "SEM GTIN�; <br>
   * (Atualizado NT 2017.001)
   */
  @RFWMetaStringField(caption = "EAN/GTIN da Unidade Tribut�vel", minlength = 0, maxLength = 14, pattern = "\\d*", required = true)
  private String ceanTrib = null;

  /**
   * I13 uTrib Unidade Tribut�vel E I01 C 1-1 1 - 6
   */
  @RFWMetaStringField(caption = "Unidade Tribut�vel", minlength = 1, maxLength = 6, required = true)
  private String utrib = null;

  /**
   * I14 qTrib Quantidade Tribut�vel E I01 N 1-1 11v0-4<br>
   * O GTIN da unidade tribut�vel deve corresponder �quele da menor unidade comercializ�vel identificada por c�digo GTIN.
   */
  @RFWMetaBigDecimalField(caption = "Quantidade Tribut�vel", minValue = "0", maxValue = "99999999999.9999", scale = 0, scaleMax = 4, required = true)
  private BigDecimal qTrib = null;

  /**
   * I14a vUnTrib Valor Unit�rio de tributa��o E I01 N 1-1 11v0-10
   */
  @RFWMetaBigDecimalField(caption = "Valor Unit�rio de Tributa��o", minValue = "0", maxValue = "99999999999.9999999999", scale = 0, scaleMax = 10, required = true)
  private BigDecimal vunTrib = null;

  /**
   * I15 vFrete Valor Total do Frete E I01 N 0-1 13v2<br>
   * Para produtos que n�o possuem c�digo de barras com GTIN, deve ser informado o literal "SEM GTIN�;<br>
   * <b>A linha de descri��o acima foi tirada do manual da NFe, porem acredito que seja um erro, pois o campo � do tipo num�rico.</b>
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
   * I17a vOutro Outras despesas acess�rias E I01 N 0-1 13v2 (v2.0)
   */
  @RFWMetaBigDecimalField(caption = "Outras Despesas Acess�rias", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal voutro = null;

  /**
   * I17b indTot Indica se valor do Item (vProd) entra no valor total da NF-e (vProd) E I01 N 1-1 1<br>
   * <li>0=Valor do item (vProd) n�o comp�e o valor total da NF-e
   * <li>1=Valor do item (vProd) comp�e o valor total da NFe (vProd) (v2.0)
   */
  @RFWMetaStringField(caption = "Indicador de Composi��o do Valor Total da NFe", minlength = 1, maxLength = 1, required = true, pattern = "^(0|1)$")
  private String indTot = null;

  /**
   * # i02 cProd C�digo do produto ou servi�o E I01 C 1-1 1 - 60<br>
   * Preencher com CFOP, caso se trate de itens n�o relacionados com mercadorias/produtos e que o contribuinte n�o possua codifica��o pr�pria. <br>
   * Formato: �CFOP9999�.
   *
   * @return # i02 cProd C�digo do produto ou servi�o E I01 C 1-1 1 - 60<br>
   *         Preencher com CFOP, caso se trate de itens n�o relacionados com mercadorias/produtos e que o contribuinte n�o possua codifica��o pr�pria
   */
  public String getCprod() {
    return cprod;
  }

  /**
   * # i02 cProd C�digo do produto ou servi�o E I01 C 1-1 1 - 60<br>
   * Preencher com CFOP, caso se trate de itens n�o relacionados com mercadorias/produtos e que o contribuinte n�o possua codifica��o pr�pria. <br>
   * Formato: �CFOP9999�.
   *
   * @param cprod # i02 cProd C�digo do produto ou servi�o E I01 C 1-1 1 - 60<br>
   *          Preencher com CFOP, caso se trate de itens n�o relacionados com mercadorias/produtos e que o contribuinte n�o possua codifica��o pr�pria
   */
  public void setCprod(String cprod) {
    this.cprod = cprod;
  }

  /**
   * # i03 cEAN GTIN (Global Trade Item Number) do produto, antigo c�digo EAN ou c�digo de barras E I01 C 1-1 0,8,12, 13, 14 <br>
   * Preencher com o c�digo GTIN-8, GTIN-12, GTIN-13 ou GTIN-14 (antigos c�digos EAN, UPC e DUN-14) <br>
   * Para produtos que n�o possuem c�digo de barras com GTIN, deve ser informado o literal �SEM GTIN�; (atualizado NT 2017/001).
   *
   * @return # i03 cEAN GTIN (Global Trade Item Number) do produto, antigo c�digo EAN ou c�digo de barras E I01 C 1-1 0,8,12, 13, 14 <br>
   *         Preencher com o c�digo GTIN-8, GTIN-12, GTIN-13 ou GTIN-14 (antigos c�digos EAN, UPC e DUN-14) <br>
   *         Para produtos que n�o possuem c�digo de barras com GTIN, deve ser informado o literal �SEM GTIN�; (atualizado NT 2017/001)
   */
  public String getCean() {
    return cean;
  }

  /**
   * # i03 cEAN GTIN (Global Trade Item Number) do produto, antigo c�digo EAN ou c�digo de barras E I01 C 1-1 0,8,12, 13, 14 <br>
   * Preencher com o c�digo GTIN-8, GTIN-12, GTIN-13 ou GTIN-14 (antigos c�digos EAN, UPC e DUN-14) <br>
   * Para produtos que n�o possuem c�digo de barras com GTIN, deve ser informado o literal �SEM GTIN�; (atualizado NT 2017/001).
   *
   * @param cean # i03 cEAN GTIN (Global Trade Item Number) do produto, antigo c�digo EAN ou c�digo de barras E I01 C 1-1 0,8,12, 13, 14 <br>
   *          Preencher com o c�digo GTIN-8, GTIN-12, GTIN-13 ou GTIN-14 (antigos c�digos EAN, UPC e DUN-14) <br>
   *          Para produtos que n�o possuem c�digo de barras com GTIN, deve ser informado o literal �SEM GTIN�; (atualizado NT 2017/001)
   */
  public void setCean(String cean) {
    this.cean = cean;
  }

  /**
   * # i04 xProd Descri��o do produto ou servi�o E I01 C 1-1 1 - 120.
   *
   * @return # i04 xProd Descri��o do produto ou servi�o E I01 C 1-1 1 - 120
   */
  public String getXprod() {
    return xprod;
  }

  /**
   * # i04 xProd Descri��o do produto ou servi�o E I01 C 1-1 1 - 120.
   *
   * @param xprod # i04 xProd Descri��o do produto ou servi�o E I01 C 1-1 1 - 120
   */
  public void setXprod(String xprod) {
    this.xprod = xprod;
  }

  /**
   * # i05 NCM C�digo NCM com 8 d�gitos E I01 N 1-1 2, 8<br>
   * Obrigat�ria informa��o do NCM completo (8 d�gitos). <BR>
   * Nota: Em caso de item de servi�o ou item que n�o tenham produto (ex. transfer�ncia de cr�dito, cr�dito do ativo imobilizado, etc.), informar o valor 00 (dois zeros). (NT 2014/004).
   *
   * @return # i05 NCM C�digo NCM com 8 d�gitos E I01 N 1-1 2, 8<br>
   *         Obrigat�ria informa��o do NCM completo (8 d�gitos)
   */
  public String getNcm() {
    return ncm;
  }

  /**
   * # i05 NCM C�digo NCM com 8 d�gitos E I01 N 1-1 2, 8<br>
   * Obrigat�ria informa��o do NCM completo (8 d�gitos). <BR>
   * Nota: Em caso de item de servi�o ou item que n�o tenham produto (ex. transfer�ncia de cr�dito, cr�dito do ativo imobilizado, etc.), informar o valor 00 (dois zeros). (NT 2014/004).
   *
   * @param ncm # i05 NCM C�digo NCM com 8 d�gitos E I01 N 1-1 2, 8<br>
   *          Obrigat�ria informa��o do NCM completo (8 d�gitos)
   */
  public void setNcm(String ncm) {
    this.ncm = ncm;
  }

  /**
   * # i05c CEST C�digo CEST E I05b N 1-1 7<BR>
   * Campo CEST (C�digo Especificador da Substitui��o Tribut�ria), que estabelece a sistem�tica de uniformiza��o e identifica��o das mercadorias e bens pass�veis de sujei��o aos regimes de substitui��o tribut�ria e de antecipa��o de recolhimento do ICMS. <BR>
   * (Inclu�do na NT 2015/003. Atualizado NT2016.002).
   *
   * @return # i05c CEST C�digo CEST E I05b N 1-1 7<BR>
   *         Campo CEST (C�digo Especificador da Substitui��o Tribut�ria), que estabelece a sistem�tica de uniformiza��o e identifica��o das mercadorias e bens pass�veis de sujei��o aos regimes de substitui��o tribut�ria e de antecipa��o de recolhimento do ICMS
   */
  public String getCest() {
    return cest;
  }

  /**
   * # i05c CEST C�digo CEST E I05b N 1-1 7<BR>
   * Campo CEST (C�digo Especificador da Substitui��o Tribut�ria), que estabelece a sistem�tica de uniformiza��o e identifica��o das mercadorias e bens pass�veis de sujei��o aos regimes de substitui��o tribut�ria e de antecipa��o de recolhimento do ICMS. <BR>
   * (Inclu�do na NT 2015/003. Atualizado NT2016.002).
   *
   * @param cest # i05c CEST C�digo CEST E I05b N 1-1 7<BR>
   *          Campo CEST (C�digo Especificador da Substitui��o Tribut�ria), que estabelece a sistem�tica de uniformiza��o e identifica��o das mercadorias e bens pass�veis de sujei��o aos regimes de substitui��o tribut�ria e de antecipa��o de recolhimento do ICMS
   */
  public void setCest(String cest) {
    this.cest = cest;
  }

  /**
   * # i05d indEscala Indicador de Escala Relevante E I05b C 0-1 1<br>
   * Indicador de Produ��o em escala relevante, conforme Cl�usula 23 do Convenio ICMS 52/2017:
   * <LI>S - Produzido em Escala Relevante;
   * <LI>N � Produzido em Escala N�O Relevante. <BR>
   * Nota: preenchimento Obrig.at�rio para produtos com NCM relacionado no Anexo XXVII do Convenio 52/2017 (Inclu�do na NT2016.002).
   *
   * @return # i05d indEscala Indicador de Escala Relevante E I05b C 0-1 1<br>
   *         Indicador de Produ��o em escala relevante, conforme Cl�usula 23 do Convenio ICMS 52/2017:
   *         <LI>S - Produzido em Escala Relevante;
   *         <LI>N � Produzido em Escala N�O Relevante
   */
  public String getIndEscala() {
    return indEscala;
  }

  /**
   * # i05d indEscala Indicador de Escala Relevante E I05b C 0-1 1<br>
   * Indicador de Produ��o em escala relevante, conforme Cl�usula 23 do Convenio ICMS 52/2017:
   * <LI>S - Produzido em Escala Relevante;
   * <LI>N � Produzido em Escala N�O Relevante. <BR>
   * Nota: preenchimento Obrig.at�rio para produtos com NCM relacionado no Anexo XXVII do Convenio 52/2017 (Inclu�do na NT2016.002).
   *
   * @param indEscala # i05d indEscala Indicador de Escala Relevante E I05b C 0-1 1<br>
   *          Indicador de Produ��o em escala relevante, conforme Cl�usula 23 do Convenio ICMS 52/2017:
   *          <LI>S - Produzido em Escala Relevante;
   *          <LI>N � Produzido em Escala N�O Relevante
   */
  public void setIndEscala(String indEscala) {
    this.indEscala = indEscala;
  }

  /**
   * # i05e CNPJFab CNPJ do Fabricante da Mercadoria E I05b N 0-1 14<BR>
   * CNPJ do Fabricante da Mercadoria, obrigat�rio para produto em escala N�O relevante. <br>
   * (Inclu�do na NT2016.002).
   *
   * @return # i05e CNPJFab CNPJ do Fabricante da Mercadoria E I05b N 0-1 14<BR>
   *         CNPJ do Fabricante da Mercadoria, obrigat�rio para produto em escala N�O relevante
   */
  public String getCnpjFab() {
    return cnpjFab;
  }

  /**
   * # i05e CNPJFab CNPJ do Fabricante da Mercadoria E I05b N 0-1 14<BR>
   * CNPJ do Fabricante da Mercadoria, obrigat�rio para produto em escala N�O relevante. <br>
   * (Inclu�do na NT2016.002).
   *
   * @param cnpjFab # i05e CNPJFab CNPJ do Fabricante da Mercadoria E I05b N 0-1 14<BR>
   *          CNPJ do Fabricante da Mercadoria, obrigat�rio para produto em escala N�O relevante
   */
  public void setCnpjFab(String cnpjFab) {
    this.cnpjFab = cnpjFab;
  }

  /**
   * # i06 EXTIPI EX_TIPI E I01 N 0-1 2 - 3<BR>
   * Preencher de acordo com o c�digo EX da TIPI. Em caso de servi�o, n�o incluir a TAG.
   *
   * @return # i06 EXTIPI EX_TIPI E I01 N 0-1 2 - 3<BR>
   *         Preencher de acordo com o c�digo EX da TIPI
   */
  public String getExtIPI() {
    return extIPI;
  }

  /**
   * # i06 EXTIPI EX_TIPI E I01 N 0-1 2 - 3<BR>
   * Preencher de acordo com o c�digo EX da TIPI. Em caso de servi�o, n�o incluir a TAG.
   *
   * @param extIPI # i06 EXTIPI EX_TIPI E I01 N 0-1 2 - 3<BR>
   *          Preencher de acordo com o c�digo EX da TIPI
   */
  public void setExtIPI(String extIPI) {
    this.extIPI = extIPI;
  }

  /**
   * # i08 CFOP C�digo Fiscal de Opera��es e Presta��es E I01 N 1-1 4<br>
   * Utilizar Tabela de CFOP.
   *
   * @return # i08 CFOP C�digo Fiscal de Opera��es e Presta��es E I01 N 1-1 4<br>
   *         Utilizar Tabela de CFOP
   */
  public String getCfop() {
    return cfop;
  }

  /**
   * # i08 CFOP C�digo Fiscal de Opera��es e Presta��es E I01 N 1-1 4<br>
   * Utilizar Tabela de CFOP.
   *
   * @param cfop # i08 CFOP C�digo Fiscal de Opera��es e Presta��es E I01 N 1-1 4<br>
   *          Utilizar Tabela de CFOP
   */
  public void setCfop(String cfop) {
    this.cfop = cfop;
  }

  /**
   * # i09 uCom Unidade Comercial E I01 C 1-1 1 - 6<BR>
   * Informar a unidade de comercializa��o do produto.
   *
   * @return # i09 uCom Unidade Comercial E I01 C 1-1 1 - 6<BR>
   *         Informar a unidade de comercializa��o do produto
   */
  public String getUcom() {
    return ucom;
  }

  /**
   * # i09 uCom Unidade Comercial E I01 C 1-1 1 - 6<BR>
   * Informar a unidade de comercializa��o do produto.
   *
   * @param ucom # i09 uCom Unidade Comercial E I01 C 1-1 1 - 6<BR>
   *          Informar a unidade de comercializa��o do produto
   */
  public void setUcom(String ucom) {
    this.ucom = ucom;
  }

  /**
   * # i10 qCom Quantidade Comercial E I01 N 1-1 11v0-4<br>
   * Informar a quantidade de comercializa��o do produto (v2.0).
   *
   * @return # i10 qCom Quantidade Comercial E I01 N 1-1 11v0-4<br>
   *         Informar a quantidade de comercializa��o do produto (v2
   */
  public BigDecimal getQcom() {
    return qcom;
  }

  /**
   * # i10 qCom Quantidade Comercial E I01 N 1-1 11v0-4<br>
   * Informar a quantidade de comercializa��o do produto (v2.0).
   *
   * @param qcom # i10 qCom Quantidade Comercial E I01 N 1-1 11v0-4<br>
   *          Informar a quantidade de comercializa��o do produto (v2
   */
  public void setQcom(BigDecimal qcom) {
    this.qcom = qcom;
  }

  /**
   * # i10a vUnCom Valor Unit�rio de Comercializa��o E I01 N 1-1 11v0-10<br>
   * Informar o valor unit�rio de comercializa��o do produto, campo meramente informativo, o contribuinte pode utilizar a precis�o desejada (0-10 decimais).<br>
   * Para efeitos de c�lculo, o valor unit�rio ser� obtido pela divis�o do valor do produto pela quantidade comercial. (v2.0).
   *
   * @return # i10a vUnCom Valor Unit�rio de Comercializa��o E I01 N 1-1 11v0-10<br>
   *         Informar o valor unit�rio de comercializa��o do produto, campo meramente informativo, o contribuinte pode utilizar a precis�o desejada (0-10 decimais)
   */
  public BigDecimal getVunCom() {
    return vunCom;
  }

  /**
   * # i10a vUnCom Valor Unit�rio de Comercializa��o E I01 N 1-1 11v0-10<br>
   * Informar o valor unit�rio de comercializa��o do produto, campo meramente informativo, o contribuinte pode utilizar a precis�o desejada (0-10 decimais).<br>
   * Para efeitos de c�lculo, o valor unit�rio ser� obtido pela divis�o do valor do produto pela quantidade comercial. (v2.0).
   *
   * @param vunCom # i10a vUnCom Valor Unit�rio de Comercializa��o E I01 N 1-1 11v0-10<br>
   *          Informar o valor unit�rio de comercializa��o do produto, campo meramente informativo, o contribuinte pode utilizar a precis�o desejada (0-10 decimais)
   */
  public void setVunCom(BigDecimal vunCom) {
    this.vunCom = vunCom;
  }

  /**
   * # i11 vProd Valor Total Bruto dos Produtos ou Servi�os. E I01 N 1-1 13v2<br>
   * O valor do ICMS faz parte do Valor Total Bruto.
   *
   * @return # i11 vProd Valor Total Bruto dos Produtos ou Servi�os
   */
  public BigDecimal getVprod() {
    return vprod;
  }

  /**
   * # i11 vProd Valor Total Bruto dos Produtos ou Servi�os. E I01 N 1-1 13v2<br>
   * O valor do ICMS faz parte do Valor Total Bruto.
   *
   * @param vprod # i11 vProd Valor Total Bruto dos Produtos ou Servi�os
   */
  public void setVprod(BigDecimal vprod) {
    this.vprod = vprod;
  }

  /**
   * # i12 cEANTrib GTIN (Global Trade Item Number) da unidade tribut�vel, antigo c�digo EAN ou c�digo de barras E I01 C 1-1 0,8,12, 13, 14 <Br>
   * Preencher com o c�digo GTIN-8, GTIN-12, GTIN-13 ou GTIN-14 (antigos c�digos EAN, UPC e DUN-14) da unidade tribut�vel do produto. <br>
   * O GTIN da unidade tribut�vel deve corresponder �quele da menor unidade comercializ�vel identificada por c�digo GTIN. <br>
   * Para produtos que n�o possuem c�digo de barras com GTIN, deve ser informado o literal "SEM GTIN�; <br>
   * (Atualizado NT 2017.001).
   *
   * @return # i12 cEANTrib GTIN (Global Trade Item Number) da unidade tribut�vel, antigo c�digo EAN ou c�digo de barras E I01 C 1-1 0,8,12, 13, 14 <Br>
   *         Preencher com o c�digo GTIN-8, GTIN-12, GTIN-13 ou GTIN-14 (antigos c�digos EAN, UPC e DUN-14) da unidade tribut�vel do produto
   */
  public String getCeanTrib() {
    return ceanTrib;
  }

  /**
   * # i12 cEANTrib GTIN (Global Trade Item Number) da unidade tribut�vel, antigo c�digo EAN ou c�digo de barras E I01 C 1-1 0,8,12, 13, 14 <Br>
   * Preencher com o c�digo GTIN-8, GTIN-12, GTIN-13 ou GTIN-14 (antigos c�digos EAN, UPC e DUN-14) da unidade tribut�vel do produto. <br>
   * O GTIN da unidade tribut�vel deve corresponder �quele da menor unidade comercializ�vel identificada por c�digo GTIN. <br>
   * Para produtos que n�o possuem c�digo de barras com GTIN, deve ser informado o literal "SEM GTIN�; <br>
   * (Atualizado NT 2017.001).
   *
   * @param ceanTrib # i12 cEANTrib GTIN (Global Trade Item Number) da unidade tribut�vel, antigo c�digo EAN ou c�digo de barras E I01 C 1-1 0,8,12, 13, 14 <Br>
   *          Preencher com o c�digo GTIN-8, GTIN-12, GTIN-13 ou GTIN-14 (antigos c�digos EAN, UPC e DUN-14) da unidade tribut�vel do produto
   */
  public void setCeanTrib(String ceanTrib) {
    this.ceanTrib = ceanTrib;
  }

  /**
   * # i13 uTrib Unidade Tribut�vel E I01 C 1-1 1 - 6.
   *
   * @return # i13 uTrib Unidade Tribut�vel E I01 C 1-1 1 - 6
   */
  public String getUtrib() {
    return utrib;
  }

  /**
   * # i13 uTrib Unidade Tribut�vel E I01 C 1-1 1 - 6.
   *
   * @param utrib # i13 uTrib Unidade Tribut�vel E I01 C 1-1 1 - 6
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
   * # i14a vUnTrib Valor Unit�rio de tributa��o E I01 N 1-1 11v0-10.
   *
   * @return # i14a vUnTrib Valor Unit�rio de tributa��o E I01 N 1-1 11v0-10
   */
  public BigDecimal getVunTrib() {
    return vunTrib;
  }

  /**
   * # i14a vUnTrib Valor Unit�rio de tributa��o E I01 N 1-1 11v0-10.
   *
   * @param vunTrib # i14a vUnTrib Valor Unit�rio de tributa��o E I01 N 1-1 11v0-10
   */
  public void setVunTrib(BigDecimal vunTrib) {
    this.vunTrib = vunTrib;
  }

  /**
   * # i15 vFrete Valor Total do Frete E I01 N 0-1 13v2<br>
   * Para produtos que n�o possuem c�digo de barras com GTIN, deve ser informado o literal "SEM GTIN�;<br>
   * <b>A linha de descri��o acima foi tirada do manual da NFe, porem acredito que seja um erro, pois o campo � do tipo num�rico.</b>.
   *
   * @return # i15 vFrete Valor Total do Frete E I01 N 0-1 13v2<br>
   *         Para produtos que n�o possuem c�digo de barras com GTIN, deve ser informado o literal "SEM GTIN�;<br>
   *         <b>A linha de descri��o acima foi tirada do manual da NFe, porem acredito que seja um erro, pois o campo � do tipo num�rico
   */
  public BigDecimal getVfrete() {
    return vfrete;
  }

  /**
   * # i15 vFrete Valor Total do Frete E I01 N 0-1 13v2<br>
   * Para produtos que n�o possuem c�digo de barras com GTIN, deve ser informado o literal "SEM GTIN�;<br>
   * <b>A linha de descri��o acima foi tirada do manual da NFe, porem acredito que seja um erro, pois o campo � do tipo num�rico.</b>.
   *
   * @param vfrete # i15 vFrete Valor Total do Frete E I01 N 0-1 13v2<br>
   *          Para produtos que n�o possuem c�digo de barras com GTIN, deve ser informado o literal "SEM GTIN�;<br>
   *          <b>A linha de descri��o acima foi tirada do manual da NFe, porem acredito que seja um erro, pois o campo � do tipo num�rico
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
   * # i17a vOutro Outras despesas acess�rias E I01 N 0-1 13v2 (v2.0).
   *
   * @return # i17a vOutro Outras despesas acess�rias E I01 N 0-1 13v2 (v2
   */
  public BigDecimal getVoutro() {
    return voutro;
  }

  /**
   * # i17a vOutro Outras despesas acess�rias E I01 N 0-1 13v2 (v2.0).
   *
   * @param voutro # i17a vOutro Outras despesas acess�rias E I01 N 0-1 13v2 (v2
   */
  public void setVoutro(BigDecimal voutro) {
    this.voutro = voutro;
  }

  /**
   * # i17b indTot Indica se valor do Item (vProd) entra no valor total da NF-e (vProd) E I01 N 1-1 1<br>
   * <li>0=Valor do item (vProd) n�o comp�e o valor total da NF-e
   * <li>1=Valor do item (vProd) comp�e o valor total da NFe (vProd) (v2.0).
   *
   * @return # i17b indTot Indica se valor do Item (vProd) entra no valor total da NF-e (vProd) E I01 N 1-1 1<br>
   *         <li>0=Valor do item (vProd) n�o comp�e o valor total da NF-e
   *         <li>1=Valor do item (vProd) comp�e o valor total da NFe (vProd) (v2
   */
  public String getIndTot() {
    return indTot;
  }

  /**
   * # i17b indTot Indica se valor do Item (vProd) entra no valor total da NF-e (vProd) E I01 N 1-1 1<br>
   * <li>0=Valor do item (vProd) n�o comp�e o valor total da NF-e
   * <li>1=Valor do item (vProd) comp�e o valor total da NFe (vProd) (v2.0).
   *
   * @param indTot # i17b indTot Indica se valor do Item (vProd) entra no valor total da NF-e (vProd) E I01 N 1-1 1<br>
   *          <li>0=Valor do item (vProd) n�o comp�e o valor total da NF-e
   *          <li>1=Valor do item (vProd) comp�e o valor total da NFe (vProd) (v2
   */
  public void setIndTot(String indTot) {
    this.indTot = indTot;
  }

}
