package br.eng.rodrigogml.rfw.nf.vo;

import java.time.LocalDateTime;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBooleanField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaDateField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaDateField.DateResolution;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaIntegerField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaLongField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: VO para representar um documento fiscal (NFe/NFCe).<br>
 * A maior parte dos campos s�o marcados como n�o obrigat�rios para que seja poss�vel realizar a persist�ncia do objeto em modo de reascunho. A valida��o de emiss�o e conssit�ncia ser� feitar por m�todos espec�ficos e n�o apenas pelas Meta Annotations.
 *
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Rodrigo GML - Cria��o do objeto seguindo as instru��es do MOC 7.0 - Layout dispon�vel no Anexo I - Layout e Regras de Valida��o da NF-e e NFC-e.<br>
 *          Nem todos os campos foram adicionados para otimizar � necessidade atual. Campos remanescentes devem ser acrescidos em vers�es futuras.
 */
public class RFWNFVO extends RFWVO {

  private static final long serialVersionUID = -6396799029642499019L;

  /**
   * Enum para definir o tipo de indicador de presen�a do comprador no estabelecimento comercial no momento da opera��o.
   */
  public enum NFAttendanceType {
    /**
     * N�o se aplica para o tipo de opera��o da NF.
     */
    NOTAPPLICABLE("0"),

    /** Atendimento presencial. */
    PRESENTIAL("1"),

    /** Pela internet. */
    INTERNET("2"),

    /** Televendas/telemarketing. */
    TELEMARKETING("3"),
    /**
     * NFC-e em opera��o com entrega a domic�lio.
     */
    NFCe_DELIVERY("4"),

    /** Opera��o presencial, fora do estabelecimento;. */
    PRESENTIAL_OUTSIDE("5"),
    /**
     * Outro tipo de atendimento.
     */
    OTHER("9");

    /** The xml code. */
    final String xmlCode;

    /**
     * Instantiates a new NF attendance type.
     *
     * @param xmlCode the xml code
     */
    NFAttendanceType(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * Value of xml code.
     *
     * @param xmlCode the xml code
     * @return the NF attendance type
     */
    public static NFAttendanceType valueOfXmlCode(String xmlCode) {
      for (NFAttendanceType v : values())
        if (v.getXmlCode().equals(xmlCode)) return v;
      return null;
    }

    /**
     * Gets the xml code.
     *
     * @return the xml code
     */
    public String getXmlCode() {
      return xmlCode;
    }
  }

  /**
   * Define a finalidade da emiss�o da nota: Normal, Complementar, devolu��o, etc.
   */
  public static enum NFEmissionGoal {

    /** NF Normal. */
    NORMAL("1"),

    /** NF Complementar. */
    COMPLEMENT("2"),

    /** NF de Ajuste. */
    ADJUSTMENT("3"),

    /** Devolu��o de Mercadoria. */
    RETURNGOODS("4");

    /** The xml code. */
    final String xmlCode;

    /**
     * Instantiates a new NF emission goal.
     *
     * @param xmlCode the xml code
     */
    NFEmissionGoal(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * Value of xml code.
     *
     * @param xmlCode the xml code
     * @return the NF emission goal
     */
    public static NFEmissionGoal valueOfXmlCode(String xmlCode) {
      for (NFEmissionGoal v : values())
        if (v.getXmlCode().equals(xmlCode)) return v;
      return null;
    }

    /**
     * Gets the xml code.
     *
     * @return the xml code
     */
    public String getXmlCode() {
      return xmlCode;
    }
  }

  /**
   * Enum que define o tipo da NFe conforme definido pela SEFAZ entre notas de entrada ou sa�da. De acordo com o fluxo da marcadoria no fluxo do emitente da NF.
   */
  public static enum NFType {
    /**
     * Define que � uma nota de entrada de mercadorias em rela��o ao emitente da NFe.
     */
    ENTRY("0"),
    /**
     * Define que � uma nota de sa�da de mercadorias em rela��o ao emitente da NFe.
     */
    EXIT("1");

    /** The xml code. */
    final String xmlCode;

    /**
     * Instantiates a new NF type.
     *
     * @param xmlCode the xml code
     */
    NFType(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * Value of xml code.
     *
     * @param xmlCode the xml code
     * @return the NF type
     */
    public static NFType valueOfXmlCode(String xmlCode) {
      for (NFType v : values())
        if (v.getXmlCode().equals(xmlCode)) return v;
      return null;
    }

    /**
     * Gets the xml code.
     *
     * @return the xml code
     */
    public String getXmlCode() {
      return xmlCode;
    }
  }

  /**
   * Modelos de Notas Fiscais.
   */
  public static enum NFModel {
    // /**
    // * Modelo de Notas Fiscais de tal�o.
    // */
    // MODEL01(null), //Desliguei na migra��o para o RFW.SEFAZ
    /**
     * Modelo de Nota Fiscal Eletr�nica (NFe).
     */
    MODEL55("55"),
    /**
     * Modelo de Nota Fiscal de Consumidor Eletr�nica (NFCe).
     */
    MODEL65("65");

    /**
     * C�digo de identifica��o do modelo do documento. (Cat�logo utilizado na NFe.)
     */
    private final String xmlCode;

    /**
     * Instantiates a new NF model.
     *
     * @param xmlCode the xml code
     */
    NFModel(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * Value of xml code.
     *
     * @param xmlCode the xml code
     * @return the NF model
     */
    public static NFModel valueOfXmlCode(String xmlCode) {
      for (NFModel v : values())
        if (v.getXmlCode() != null && v.getXmlCode().equals(xmlCode)) return v;
      return null;
    }

    /**
     * # c�digo de identifica��o do modelo do documento. (Cat�logo utilizado na NFe.).
     *
     * @return the c�digo de identifica��o do modelo do documento
     */
    public String getXmlCode() {
      return xmlCode;
    }
  }

  /**
   * Define a forma de pagamento da nota fiscal.
   */
  public static enum NFPaymentMethod {

    /** Pagamento � Vista. */
    CASHPAYMENT("0"),

    /** Pagamento � Prazo. */
    DEFERREDPAYMENT("1"),

    /** Outros. */
    OTHERS("2");

    /** The xml code. */
    private final String xmlCode;

    /**
     * Instantiates a new NF payment method.
     *
     * @param xmlCode the xml code
     */
    NFPaymentMethod(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * Value of xml code.
     *
     * @param xmlCode the xml code
     * @return the NF payment method
     */
    public static NFPaymentMethod valueOfXmlCode(String xmlCode) {
      for (NFPaymentMethod v : values())
        if (v.getXmlCode().equals(xmlCode)) return v;
      return null;
    }

    /**
     * Gets the xml code.
     *
     * @return the xml code
     */
    public String getXmlCode() {
      return xmlCode;
    }
  }

  /**
   * Vers�o do leiaute<Br>
   * TAG: NFe/infNFe/@versao
   */
  @RFWMetaStringField(caption = "Vers�o do Layout", maxLength = 10, pattern = "[0-9]+\\.[0-9]+", required = true)
  private String layoutVersion = null;

  /**
   * Chave de acesso da nota. Tamanho 44 D�gitos.<Br>
   * Tag: NFe/infNFe/@Id - Nesta tag, informar a Chave de Acesso precedida do literal �NFe� (total 47 d�gitos)
   */
  @RFWMetaStringField(caption = "Chave", maxLength = 44, minlength = 44, pattern = "[0-9]{44}", required = false, unique = true)
  private String chave = null;

  /**
   * N�mero aleat�rio com a finalidade de mascarar a chave da NFe. Normalmente gerado automaticamente pelo sistema durante a emiss�o da NFe.<br>
   * Alguma aplica��es podem n�o querer gerar esse n�mero aleatoriamente toda nota, mas por empresa. Embora menos seguro e quebrando o objetido deste c�digo, permite que em caso de perda do documento/informa��es da NFe seja poss�vel reobter as NFes a partir do site da SEFAZ.<br>
   * <br>
   * C�digo Num�rico que comp�e a Chave de Acesso<br>
   * N�mero aleat�rio gerado pelo emitente para cada NF-e para evitar acessos indevidos da NF-e. (v2.0)<br>
   * TAG: NFe/infNFe/ide/cNF<br>
   */
  @RFWMetaIntegerField(caption = "C�digo Num�rico", minvalue = 0, required = false)
  private Integer randomKey = null;

  /**
   * Descri��o da Natureza da Opera��.<br>
   * Informar a natureza da opera��o de que decorrer a sa�da ou a entrada, tais como: venda, compra, transfer�ncia, devolu��o, importa��o, consigna��o, remessa (para fins de demonstra��o, de industrializa��o ou outra), conforme previsto na al�nea 'i', inciso I, art. 19 do CONV�NIO S/N�, de 15 de dezembro de 1970.<br>
   * TAG: NFe/infNFe/ide/natOp
   */
  @RFWMetaStringField(caption = "Natureza da Opera��o", maxLength = 200, required = false)
  private String operationNature = null;

  /**
   * M�todo de pagamento conforme definido no documento fiscal.<br>
   * TAG: NFe/infNFe/ide/indPag
   *
   * @deprecated <b>Deixou de existir na vers�o 4.00</b>
   */
  @Deprecated
  @RFWMetaEnumField(caption = "Forma de Pagamento", required = false)
  private NFPaymentMethod payment = null;

  /**
   * C�digo do Modelo do Documento Fiscal<br>
   * <li>55=NF-e emitida em substitui��o ao modelo 1 ou 1A;
   * <li>65=NFC-e, utilizada nas opera��es de venda no varejo (a crit�rio da UF aceitar este modelo de documento). <Br>
   * TAG: NFe/infNFe/ide/mod
   */
  @RFWMetaEnumField(caption = "Modelo", required = true)
  private NFModel model = null;

  /**
   * S�rie do Documento Fiscal <br>
   * S�rie do Documento Fiscal, preencher com zeros na hip�tese de a NF-e n�o possuir s�rie. S�rie na faixa:
   * <li>[000-889]: Aplicativo do Contribuinte; Emitente=CNPJ; Assinatura pelo e-CNPJ do contribuinte (procEmi<>1,2);
   * <li>[890-899]: Emiss�o no site do Fisco (NFA-e - Avulsa); Emitente= CNPJ / CPF; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1);
   * <li>[900-909]: Emiss�o no site do Fisco (NFA-e); Emitente= CNPJ; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1), ou Assinatura pelo e-CNPJ do contribuinte (procEmi=2);
   * <li>[910-919]: Emiss�o no site do Fisco (NFA-e); Emitente= CPF; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1), ou Assinatura pelo e-CPF do contribuinte (procEmi=2);
   * <li>[920-969]: Aplicativo do Contribuinte; Emitente=CPF; Assinatura pelo e-CPF do contribuinte (procEmi<>1,2); (Atualizado NT 2018/001) <Br>
   * <br>
   * TAG: NFe/infNFe/ide/serie
   */
  @RFWMetaIntegerField(caption = "S�rie", required = false, maxvalue = 999, minvalue = 0)
  private Integer serie = null;

  /**
   * N�mero do Documento Fiscal<br>
   * TAG: NFe/infNFe/ide/nNF
   */
  @RFWMetaLongField(caption = "N�mero", required = false, minvalue = 1, maxvalue = 999999999L)
  private Long number = null;

  /**
   * Data e hora de emiss�o do Documento Fiscal <br>
   * Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD<Br>
   * <br>
   * Nota T�cnica 2013.005:
   * <li>As tags dhEmi e dhSaiEnt foram alteradas para dEmi e dSaiEnt.
   * <li>O formato dos campos de data e hora foi alterado para o formato UTC (Universal Coordinated Time).
   * <li>O campo hSaiEnt foi eliminado.
   *
   * <br>
   * TAG: NFe/infNFe/ide/dhEmi
   */
  @RFWMetaDateField(caption = "Data Emiss�o", required = false, resolution = DateResolution.SECOND)
  private LocalDateTime emission = null;

  /**
   * Data e hora de Sa�da ou da Entrada da Mercadoria/Produto<br>
   * Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD. <br>
   * Observa��o: N�o informar este campo para a NFC-e.<br>
   *
   * <br>
   * Nota T�cnica 2013.005:
   * <li>As tags dhEmi e dhSaiEnt foram alteradas para dEmi e dSaiEnt.
   * <li>O formato dos campos de data e hora foi alterado para o formato UTC (Universal Coordinated Time).
   * <li>O campo hSaiEnt foi eliminado.
   *
   * <br>
   * TAG: NFe/infNFe/ide/dhSaiEnt
   *
   */
  @RFWMetaDateField(caption = "Data Entrada/Sa�da", required = false, resolution = DateResolution.SECOND)
  private LocalDateTime entryDate = null;

  /**
   * Tipo de Opera��o<br>
   * <li>0=Entrada;
   * <li>1=Sa�da <br>
   *
   * Indica o tipo da NFe (Fluxo das mercadorias) em rela��o ao emitente da NFe.<br>
   * Por exemplo, se um fornecedor emite uma nota de venda contra nossa empresa, o atributo {@link #nfType} indicar� que � uma nota de Sa�da, pois refere-se ao tipo da nota. J� {@link #nfProductFlow} inficar� que � do tipo Entrada, pois em rela��o � empresa � uma nota que gerou um fluxo de entrada de mercadorias. <br>
   * <br>
   * TAG: NFe/infNFe/ide/tpNF
   */
  @RFWMetaEnumField(caption = "Tipo da NF", required = false)
  private NFType nfType = null;

  /**
   * C�digo do Munic�pio de Ocorr�ncia do Fato Gerador <br>
   * Informar o munic�pio de ocorr�ncia do fato gerador do ICMS. Utilizar a Tabela do IBGE (Se��o 8.2 do MOC � Vis�o Geral, Tabela de UF, Munic�pio e Pa�s)<br>
   * <br>
   * TAG: NFe/infNFe/ide/cMunFG
   */
  @RFWMetaStringField(caption = "C�digo Munic�pio do Fato Gerador", maxLength = 7, pattern = "[0-9]{0,7}", required = false, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cityCodeTaxEvent = null;

  /**
   * Tipo de Emiss�o da NF-e <br>
   * <li>1=Emiss�o normal (n�o em conting�ncia);
   * <li>2=Conting�ncia FS-IA, com impress�o do DANFE em Formul�rio de Seguran�a - Impressor Aut�nomo;
   * <li>3=Conting�ncia SCAN (Sistema de Conting�ncia do Ambiente Nacional); *Desativado * NT 2015/002
   * <li>4=Conting�ncia EPEC (Evento Pr�vio da Emiss�o em Conting�ncia);
   * <li>5=Conting�ncia FS-DA, com impress�o do DANFE em Formul�rio de Seguran�a - Documento Auxiliar;
   * <li>6=Conting�ncia SVC-AN (SEFAZ Virtual de Conting�ncia do AN);
   * <li>7=Conting�ncia SVC-RS (SEFAZ Virtual de Conting�ncia do RS);
   * <li>9=Conting�ncia off-line da NFC-e; <br>
   * Observa��o: Para a NFC-e somente � v�lida a op��o de conting�ncia: 9-Conting�ncia Off-Line e, a crit�rio da UF, op��o 4-Conting�ncia EPEC. (NT 2015/002)
   *
   * <br>
   * TAG: NFe/infNFe/ide/finNFe
   */
  @RFWMetaEnumField(caption = "Finalidade de Emiss�o", required = false)
  private NFEmissionGoal emissionGoal = null;

  /**
   * Indica opera��o com Consumidor final<br>
   * <li>0=Normal;
   * <li>1=Consumidor final;<br>
   * <Br>
   * TAG:NFe/infNFe/ide/indFinal
   */
  @RFWMetaBooleanField(caption = "Consumidor Final", required = false, trueCaption = "Sim", falseCaption = "N�o")
  private Boolean finalCostumer = null;

  /**
   * Indicador de presen�a do comprador no estabelecimento comercial no momento da opera��o<br>
   * <li>0=N�o se aplica (por exemplo, Nota Fiscal complementar ou de ajuste);
   * <li>1=Opera��o presencial;
   * <li>2=Opera��o n�o presencial, pela Internet;
   * <li>3=Opera��o n�o presencial, Teleatendimento;
   * <li>4=NFC-e em opera��o com entrega a domic�lio;
   * <li>5=Opera��o presencial, fora do estabelecimento; (inclu�do NT2016.002)
   * <li>9=Opera��o n�o presencial, outros. <br>
   * <br>
   * TAG: NFe/infNFe/ide/indPres
   */
  @RFWMetaEnumField(caption = "Tipo Atendimento", required = false)
  private NFAttendanceType attendanceType = null;

  /**
   * # vers�o do leiaute<Br>
   * TAG: NFe/infNFe/@versao.
   *
   * @return # vers�o do leiaute<Br>
   *         TAG: NFe/infNFe/@versao
   */
  public String getLayoutVersion() {
    return layoutVersion;
  }

  /**
   * # vers�o do leiaute<Br>
   * TAG: NFe/infNFe/@versao.
   *
   * @param layoutVersion # vers�o do leiaute<Br>
   *          TAG: NFe/infNFe/@versao
   */
  public void setLayoutVersion(String layoutVersion) {
    this.layoutVersion = layoutVersion;
  }

  /**
   * # chave de acesso da nota. Tamanho 44 D�gitos.<Br>
   * Tag: NFe/infNFe/@Id - Nesta tag, informar a Chave de Acesso precedida do literal �NFe� (total 47 d�gitos).
   *
   * @return # chave de acesso da nota
   */
  public String getChave() {
    return chave;
  }

  /**
   * # chave de acesso da nota. Tamanho 44 D�gitos.<Br>
   * Tag: NFe/infNFe/@Id - Nesta tag, informar a Chave de Acesso precedida do literal �NFe� (total 47 d�gitos).
   *
   * @param chave # chave de acesso da nota
   */
  public void setChave(String chave) {
    this.chave = chave;
  }

  /**
   * # n�mero aleat�rio com a finalidade de mascarar a chave da NFe. Normalmente gerado automaticamente pelo sistema durante a emiss�o da NFe.<br>
   * Alguma aplica��es podem n�o querer gerar esse n�mero aleatoriamente toda nota, mas por empresa. Embora menos seguro e quebrando o objetido deste c�digo, permite que em caso de perda do documento/informa��es da NFe seja poss�vel reobter as NFes a partir do site da SEFAZ.<br>
   * <br>
   * C�digo Num�rico que comp�e a Chave de Acesso<br>
   * N�mero aleat�rio gerado pelo emitente para cada NF-e para evitar acessos indevidos da NF-e. (v2.0)<br>
   * TAG: NFe/infNFe/ide/cNF<br>
   * .
   *
   * @return # n�mero aleat�rio com a finalidade de mascarar a chave da NFe
   */
  public Integer getRandomKey() {
    return randomKey;
  }

  /**
   * # n�mero aleat�rio com a finalidade de mascarar a chave da NFe. Normalmente gerado automaticamente pelo sistema durante a emiss�o da NFe.<br>
   * Alguma aplica��es podem n�o querer gerar esse n�mero aleatoriamente toda nota, mas por empresa. Embora menos seguro e quebrando o objetido deste c�digo, permite que em caso de perda do documento/informa��es da NFe seja poss�vel reobter as NFes a partir do site da SEFAZ.<br>
   * <br>
   * C�digo Num�rico que comp�e a Chave de Acesso<br>
   * N�mero aleat�rio gerado pelo emitente para cada NF-e para evitar acessos indevidos da NF-e. (v2.0)<br>
   * TAG: NFe/infNFe/ide/cNF<br>
   * .
   *
   * @param randomKey # n�mero aleat�rio com a finalidade de mascarar a chave da NFe
   */
  public void setRandomKey(Integer randomKey) {
    this.randomKey = randomKey;
  }

  /**
   * # descri��o da Natureza da Opera��.<br>
   * Informar a natureza da opera��o de que decorrer a sa�da ou a entrada, tais como: venda, compra, transfer�ncia, devolu��o, importa��o, consigna��o, remessa (para fins de demonstra��o, de industrializa��o ou outra), conforme previsto na al�nea 'i', inciso I, art. 19 do CONV�NIO S/N�, de 15 de dezembro de 1970.<br>
   * TAG: NFe/infNFe/ide/natOp.
   *
   * @return # descri��o da Natureza da Opera��
   */
  public String getOperationNature() {
    return operationNature;
  }

  /**
   * # descri��o da Natureza da Opera��.<br>
   * Informar a natureza da opera��o de que decorrer a sa�da ou a entrada, tais como: venda, compra, transfer�ncia, devolu��o, importa��o, consigna��o, remessa (para fins de demonstra��o, de industrializa��o ou outra), conforme previsto na al�nea 'i', inciso I, art. 19 do CONV�NIO S/N�, de 15 de dezembro de 1970.<br>
   * TAG: NFe/infNFe/ide/natOp.
   *
   * @param operationNature # descri��o da Natureza da Opera��
   */
  public void setOperationNature(String operationNature) {
    this.operationNature = operationNature;
  }

  /**
   * # m�todo de pagamento conforme definido no documento fiscal.<br>
   * TAG: NFe/infNFe/ide/indPag.
   *
   * @return # m�todo de pagamento conforme definido no documento fiscal
   */
  public NFPaymentMethod getPayment() {
    return payment;
  }

  /**
   * # m�todo de pagamento conforme definido no documento fiscal.<br>
   * TAG: NFe/infNFe/ide/indPag.
   *
   * @param payment # m�todo de pagamento conforme definido no documento fiscal
   */
  public void setPayment(NFPaymentMethod payment) {
    this.payment = payment;
  }

  /**
   * # c�digo do Modelo do Documento Fiscal<br>
   * <li>55=NF-e emitida em substitui��o ao modelo 1 ou 1A;
   * <li>65=NFC-e, utilizada nas opera��es de venda no varejo (a crit�rio da UF aceitar este modelo de documento). <Br>
   * TAG: NFe/infNFe/ide/mod.
   *
   * @return # c�digo do Modelo do Documento Fiscal<br>
   *         <li>55=NF-e emitida em substitui��o ao modelo 1 ou 1A;
   *         <li>65=NFC-e, utilizada nas opera��es de venda no varejo (a crit�rio da UF aceitar este modelo de documento)
   */
  public NFModel getModel() {
    return model;
  }

  /**
   * # c�digo do Modelo do Documento Fiscal<br>
   * <li>55=NF-e emitida em substitui��o ao modelo 1 ou 1A;
   * <li>65=NFC-e, utilizada nas opera��es de venda no varejo (a crit�rio da UF aceitar este modelo de documento). <Br>
   * TAG: NFe/infNFe/ide/mod.
   *
   * @param model # c�digo do Modelo do Documento Fiscal<br>
   *          <li>55=NF-e emitida em substitui��o ao modelo 1 ou 1A;
   *          <li>65=NFC-e, utilizada nas opera��es de venda no varejo (a crit�rio da UF aceitar este modelo de documento)
   */
  public void setModel(NFModel model) {
    this.model = model;
  }

  /**
   * # s�rie do Documento Fiscal <br>
   * S�rie do Documento Fiscal, preencher com zeros na hip�tese de a NF-e n�o possuir s�rie. S�rie na faixa:
   * <li>[000-889]: Aplicativo do Contribuinte; Emitente=CNPJ; Assinatura pelo e-CNPJ do contribuinte (procEmi<>1,2);
   * <li>[890-899]: Emiss�o no site do Fisco (NFA-e - Avulsa); Emitente= CNPJ / CPF; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1);
   * <li>[900-909]: Emiss�o no site do Fisco (NFA-e); Emitente= CNPJ; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1), ou Assinatura pelo e-CNPJ do contribuinte (procEmi=2);
   * <li>[910-919]: Emiss�o no site do Fisco (NFA-e); Emitente= CPF; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1), ou Assinatura pelo e-CPF do contribuinte (procEmi=2);
   * <li>[920-969]: Aplicativo do Contribuinte; Emitente=CPF; Assinatura pelo e-CPF do contribuinte (procEmi<>1,2); (Atualizado NT 2018/001) <Br>
   * <br>
   * TAG: NFe/infNFe/ide/serie.
   *
   * @return # s�rie do Documento Fiscal <br>
   *         S�rie do Documento Fiscal, preencher com zeros na hip�tese de a NF-e n�o possuir s�rie
   */
  public Integer getSerie() {
    return serie;
  }

  /**
   * # s�rie do Documento Fiscal <br>
   * S�rie do Documento Fiscal, preencher com zeros na hip�tese de a NF-e n�o possuir s�rie. S�rie na faixa:
   * <li>[000-889]: Aplicativo do Contribuinte; Emitente=CNPJ; Assinatura pelo e-CNPJ do contribuinte (procEmi<>1,2);
   * <li>[890-899]: Emiss�o no site do Fisco (NFA-e - Avulsa); Emitente= CNPJ / CPF; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1);
   * <li>[900-909]: Emiss�o no site do Fisco (NFA-e); Emitente= CNPJ; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1), ou Assinatura pelo e-CNPJ do contribuinte (procEmi=2);
   * <li>[910-919]: Emiss�o no site do Fisco (NFA-e); Emitente= CPF; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1), ou Assinatura pelo e-CPF do contribuinte (procEmi=2);
   * <li>[920-969]: Aplicativo do Contribuinte; Emitente=CPF; Assinatura pelo e-CPF do contribuinte (procEmi<>1,2); (Atualizado NT 2018/001) <Br>
   * <br>
   * TAG: NFe/infNFe/ide/serie.
   *
   * @param serie # s�rie do Documento Fiscal <br>
   *          S�rie do Documento Fiscal, preencher com zeros na hip�tese de a NF-e n�o possuir s�rie
   */
  public void setSerie(Integer serie) {
    this.serie = serie;
  }

  /**
   * # n�mero do Documento Fiscal<br>
   * TAG: NFe/infNFe/ide/nNF.
   *
   * @return # n�mero do Documento Fiscal<br>
   *         TAG: NFe/infNFe/ide/nNF
   */
  public Long getNumber() {
    return number;
  }

  /**
   * # n�mero do Documento Fiscal<br>
   * TAG: NFe/infNFe/ide/nNF.
   *
   * @param number # n�mero do Documento Fiscal<br>
   *          TAG: NFe/infNFe/ide/nNF
   */
  public void setNumber(Long number) {
    this.number = number;
  }

  /**
   * # data e hora de emiss�o do Documento Fiscal <br>
   * Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD<Br>
   * <br>
   * Nota T�cnica 2013.005:
   * <li>As tags dhEmi e dhSaiEnt foram alteradas para dEmi e dSaiEnt.
   * <li>O formato dos campos de data e hora foi alterado para o formato UTC (Universal Coordinated Time).
   * <li>O campo hSaiEnt foi eliminado. <br>
   * TAG: NFe/infNFe/ide/dhEmi.
   *
   * @return # data e hora de emiss�o do Documento Fiscal <br>
   *         Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD<Br>
   *         <br>
   *         Nota T�cnica 2013
   */
  public LocalDateTime getEmission() {
    return emission;
  }

  /**
   * # data e hora de emiss�o do Documento Fiscal <br>
   * Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD<Br>
   * <br>
   * Nota T�cnica 2013.005:
   * <li>As tags dhEmi e dhSaiEnt foram alteradas para dEmi e dSaiEnt.
   * <li>O formato dos campos de data e hora foi alterado para o formato UTC (Universal Coordinated Time).
   * <li>O campo hSaiEnt foi eliminado. <br>
   * TAG: NFe/infNFe/ide/dhEmi.
   *
   * @param emission # data e hora de emiss�o do Documento Fiscal <br>
   *          Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD<Br>
   *          <br>
   *          Nota T�cnica 2013
   */
  public void setEmission(LocalDateTime emission) {
    this.emission = emission;
  }

  /**
   * # data e hora de Sa�da ou da Entrada da Mercadoria/Produto<br>
   * Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD. <br>
   * Observa��o: N�o informar este campo para a NFC-e.<br>
   * <br>
   * Nota T�cnica 2013.005:
   * <li>As tags dhEmi e dhSaiEnt foram alteradas para dEmi e dSaiEnt.
   * <li>O formato dos campos de data e hora foi alterado para o formato UTC (Universal Coordinated Time).
   * <li>O campo hSaiEnt foi eliminado. <br>
   * TAG: NFe/infNFe/ide/dhSaiEnt.
   *
   * @return # data e hora de Sa�da ou da Entrada da Mercadoria/Produto<br>
   *         Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD
   */
  public LocalDateTime getEntryDate() {
    return entryDate;
  }

  /**
   * # data e hora de Sa�da ou da Entrada da Mercadoria/Produto<br>
   * Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD. <br>
   * Observa��o: N�o informar este campo para a NFC-e.<br>
   * <br>
   * Nota T�cnica 2013.005:
   * <li>As tags dhEmi e dhSaiEnt foram alteradas para dEmi e dSaiEnt.
   * <li>O formato dos campos de data e hora foi alterado para o formato UTC (Universal Coordinated Time).
   * <li>O campo hSaiEnt foi eliminado. <br>
   * TAG: NFe/infNFe/ide/dhSaiEnt.
   *
   * @param entryDate # data e hora de Sa�da ou da Entrada da Mercadoria/Produto<br>
   *          Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD
   */
  public void setEntryDate(LocalDateTime entryDate) {
    this.entryDate = entryDate;
  }

  /**
   * # tipo de Opera��o<br>
   * <li>0=Entrada;
   * <li>1=Sa�da <br>
   * Indica o tipo da NFe (Fluxo das mercadorias) em rela��o ao emitente da NFe.<br>
   * Por exemplo, se um fornecedor emite uma nota de venda contra nossa empresa, o atributo {@link #nfType} indicar� que � uma nota de Sa�da, pois refere-se ao tipo da nota. J� {@link #nfProductFlow} inficar� que � do tipo Entrada, pois em rela��o � empresa � uma nota que gerou um fluxo de entrada de mercadorias. <br>
   * <br>
   * TAG: NFe/infNFe/ide/tpNF.
   *
   * @return # tipo de Opera��o<br>
   *         <li>0=Entrada;
   *         <li>1=Sa�da <br>
   *         Indica o tipo da NFe (Fluxo das mercadorias) em rela��o ao emitente da NFe
   */
  public NFType getNfType() {
    return nfType;
  }

  /**
   * # tipo de Opera��o<br>
   * <li>0=Entrada;
   * <li>1=Sa�da <br>
   * Indica o tipo da NFe (Fluxo das mercadorias) em rela��o ao emitente da NFe.<br>
   * Por exemplo, se um fornecedor emite uma nota de venda contra nossa empresa, o atributo {@link #nfType} indicar� que � uma nota de Sa�da, pois refere-se ao tipo da nota. J� {@link #nfProductFlow} inficar� que � do tipo Entrada, pois em rela��o � empresa � uma nota que gerou um fluxo de entrada de mercadorias. <br>
   * <br>
   * TAG: NFe/infNFe/ide/tpNF.
   *
   * @param nfType # tipo de Opera��o<br>
   *          <li>0=Entrada;
   *          <li>1=Sa�da <br>
   *          Indica o tipo da NFe (Fluxo das mercadorias) em rela��o ao emitente da NFe
   */
  public void setNfType(NFType nfType) {
    this.nfType = nfType;
  }

  /**
   * # c�digo do Munic�pio de Ocorr�ncia do Fato Gerador <br>
   * Informar o munic�pio de ocorr�ncia do fato gerador do ICMS. Utilizar a Tabela do IBGE (Se��o 8.2 do MOC � Vis�o Geral, Tabela de UF, Munic�pio e Pa�s)<br>
   * <br>
   * TAG: NFe/infNFe/ide/cMunFG.
   *
   * @return # c�digo do Munic�pio de Ocorr�ncia do Fato Gerador <br>
   *         Informar o munic�pio de ocorr�ncia do fato gerador do ICMS
   */
  public String getCityCodeTaxEvent() {
    return cityCodeTaxEvent;
  }

  /**
   * # c�digo do Munic�pio de Ocorr�ncia do Fato Gerador <br>
   * Informar o munic�pio de ocorr�ncia do fato gerador do ICMS. Utilizar a Tabela do IBGE (Se��o 8.2 do MOC � Vis�o Geral, Tabela de UF, Munic�pio e Pa�s)<br>
   * <br>
   * TAG: NFe/infNFe/ide/cMunFG.
   *
   * @param cityCodeTaxEvent # c�digo do Munic�pio de Ocorr�ncia do Fato Gerador <br>
   *          Informar o munic�pio de ocorr�ncia do fato gerador do ICMS
   */
  public void setCityCodeTaxEvent(String cityCodeTaxEvent) {
    this.cityCodeTaxEvent = cityCodeTaxEvent;
  }

  /**
   * # tipo de Emiss�o da NF-e <br>
   * <li>1=Emiss�o normal (n�o em conting�ncia);
   * <li>2=Conting�ncia FS-IA, com impress�o do DANFE em Formul�rio de Seguran�a - Impressor Aut�nomo;
   * <li>3=Conting�ncia SCAN (Sistema de Conting�ncia do Ambiente Nacional); *Desativado * NT 2015/002
   * <li>4=Conting�ncia EPEC (Evento Pr�vio da Emiss�o em Conting�ncia);
   * <li>5=Conting�ncia FS-DA, com impress�o do DANFE em Formul�rio de Seguran�a - Documento Auxiliar;
   * <li>6=Conting�ncia SVC-AN (SEFAZ Virtual de Conting�ncia do AN);
   * <li>7=Conting�ncia SVC-RS (SEFAZ Virtual de Conting�ncia do RS);
   * <li>9=Conting�ncia off-line da NFC-e; <br>
   * Observa��o: Para a NFC-e somente � v�lida a op��o de conting�ncia: 9-Conting�ncia Off-Line e, a crit�rio da UF, op��o 4-Conting�ncia EPEC. (NT 2015/002) <br>
   * TAG: NFe/infNFe/ide/finNFe.
   *
   * @return # tipo de Emiss�o da NF-e <br>
   *         <li>1=Emiss�o normal (n�o em conting�ncia);
   *         <li>2=Conting�ncia FS-IA, com impress�o do DANFE em Formul�rio de Seguran�a - Impressor Aut�nomo;
   *         <li>3=Conting�ncia SCAN (Sistema de Conting�ncia do Ambiente Nacional); *Desativado * NT 2015/002
   *         <li>4=Conting�ncia EPEC (Evento Pr�vio da Emiss�o em Conting�ncia);
   *         <li>5=Conting�ncia FS-DA, com impress�o do DANFE em Formul�rio de Seguran�a - Documento Auxiliar;
   *         <li>6=Conting�ncia SVC-AN (SEFAZ Virtual de Conting�ncia do AN);
   *         <li>7=Conting�ncia SVC-RS (SEFAZ Virtual de Conting�ncia do RS);
   *         <li>9=Conting�ncia off-line da NFC-e; <br>
   *         Observa��o: Para a NFC-e somente � v�lida a op��o de conting�ncia: 9-Conting�ncia Off-Line e, a crit�rio da UF, op��o 4-Conting�ncia EPEC
   */
  public NFEmissionGoal getEmissionGoal() {
    return emissionGoal;
  }

  /**
   * # tipo de Emiss�o da NF-e <br>
   * <li>1=Emiss�o normal (n�o em conting�ncia);
   * <li>2=Conting�ncia FS-IA, com impress�o do DANFE em Formul�rio de Seguran�a - Impressor Aut�nomo;
   * <li>3=Conting�ncia SCAN (Sistema de Conting�ncia do Ambiente Nacional); *Desativado * NT 2015/002
   * <li>4=Conting�ncia EPEC (Evento Pr�vio da Emiss�o em Conting�ncia);
   * <li>5=Conting�ncia FS-DA, com impress�o do DANFE em Formul�rio de Seguran�a - Documento Auxiliar;
   * <li>6=Conting�ncia SVC-AN (SEFAZ Virtual de Conting�ncia do AN);
   * <li>7=Conting�ncia SVC-RS (SEFAZ Virtual de Conting�ncia do RS);
   * <li>9=Conting�ncia off-line da NFC-e; <br>
   * Observa��o: Para a NFC-e somente � v�lida a op��o de conting�ncia: 9-Conting�ncia Off-Line e, a crit�rio da UF, op��o 4-Conting�ncia EPEC. (NT 2015/002) <br>
   * TAG: NFe/infNFe/ide/finNFe.
   *
   * @param emissionGoal # tipo de Emiss�o da NF-e <br>
   *          <li>1=Emiss�o normal (n�o em conting�ncia);
   *          <li>2=Conting�ncia FS-IA, com impress�o do DANFE em Formul�rio de Seguran�a - Impressor Aut�nomo;
   *          <li>3=Conting�ncia SCAN (Sistema de Conting�ncia do Ambiente Nacional); *Desativado * NT 2015/002
   *          <li>4=Conting�ncia EPEC (Evento Pr�vio da Emiss�o em Conting�ncia);
   *          <li>5=Conting�ncia FS-DA, com impress�o do DANFE em Formul�rio de Seguran�a - Documento Auxiliar;
   *          <li>6=Conting�ncia SVC-AN (SEFAZ Virtual de Conting�ncia do AN);
   *          <li>7=Conting�ncia SVC-RS (SEFAZ Virtual de Conting�ncia do RS);
   *          <li>9=Conting�ncia off-line da NFC-e; <br>
   *          Observa��o: Para a NFC-e somente � v�lida a op��o de conting�ncia: 9-Conting�ncia Off-Line e, a crit�rio da UF, op��o 4-Conting�ncia EPEC
   */
  public void setEmissionGoal(NFEmissionGoal emissionGoal) {
    this.emissionGoal = emissionGoal;
  }

  /**
   * # indica opera��o com Consumidor final<br>
   * <li>0=Normal;
   * <li>1=Consumidor final;<br>
   * <Br>
   * TAG:NFe/infNFe/ide/indFinal.
   *
   * @return # indica opera��o com Consumidor final<br>
   *         <li>0=Normal;
   *         <li>1=Consumidor final;<br>
   *         <Br>
   *         TAG:NFe/infNFe/ide/indFinal
   */
  public Boolean getFinalCostumer() {
    return finalCostumer;
  }

  /**
   * # indica opera��o com Consumidor final<br>
   * <li>0=Normal;
   * <li>1=Consumidor final;<br>
   * <Br>
   * TAG:NFe/infNFe/ide/indFinal.
   *
   * @param finalCostumer # indica opera��o com Consumidor final<br>
   *          <li>0=Normal;
   *          <li>1=Consumidor final;<br>
   *          <Br>
   *          TAG:NFe/infNFe/ide/indFinal
   */
  public void setFinalCostumer(Boolean finalCostumer) {
    this.finalCostumer = finalCostumer;
  }

  /**
   * # indicador de presen�a do comprador no estabelecimento comercial no momento da opera��o<br>
   * <li>0=N�o se aplica (por exemplo, Nota Fiscal complementar ou de ajuste);
   * <li>1=Opera��o presencial;
   * <li>2=Opera��o n�o presencial, pela Internet;
   * <li>3=Opera��o n�o presencial, Teleatendimento;
   * <li>4=NFC-e em opera��o com entrega a domic�lio;
   * <li>5=Opera��o presencial, fora do estabelecimento; (inclu�do NT2016.002)
   * <li>9=Opera��o n�o presencial, outros. <br>
   * <br>
   * TAG: NFe/infNFe/ide/indPres.
   *
   * @return # indicador de presen�a do comprador no estabelecimento comercial no momento da opera��o<br>
   *         <li>0=N�o se aplica (por exemplo, Nota Fiscal complementar ou de ajuste);
   *         <li>1=Opera��o presencial;
   *         <li>2=Opera��o n�o presencial, pela Internet;
   *         <li>3=Opera��o n�o presencial, Teleatendimento;
   *         <li>4=NFC-e em opera��o com entrega a domic�lio;
   *         <li>5=Opera��o presencial, fora do estabelecimento; (inclu�do NT2016
   */
  public NFAttendanceType getAttendanceType() {
    return attendanceType;
  }

  /**
   * # indicador de presen�a do comprador no estabelecimento comercial no momento da opera��o<br>
   * <li>0=N�o se aplica (por exemplo, Nota Fiscal complementar ou de ajuste);
   * <li>1=Opera��o presencial;
   * <li>2=Opera��o n�o presencial, pela Internet;
   * <li>3=Opera��o n�o presencial, Teleatendimento;
   * <li>4=NFC-e em opera��o com entrega a domic�lio;
   * <li>5=Opera��o presencial, fora do estabelecimento; (inclu�do NT2016.002)
   * <li>9=Opera��o n�o presencial, outros. <br>
   * <br>
   * TAG: NFe/infNFe/ide/indPres.
   *
   * @param attendanceType # indicador de presen�a do comprador no estabelecimento comercial no momento da opera��o<br>
   *          <li>0=N�o se aplica (por exemplo, Nota Fiscal complementar ou de ajuste);
   *          <li>1=Opera��o presencial;
   *          <li>2=Opera��o n�o presencial, pela Internet;
   *          <li>3=Opera��o n�o presencial, Teleatendimento;
   *          <li>4=NFC-e em opera��o com entrega a domic�lio;
   *          <li>5=Opera��o presencial, fora do estabelecimento; (inclu�do NT2016
   */
  public void setAttendanceType(NFAttendanceType attendanceType) {
    this.attendanceType = attendanceType;
  }

}