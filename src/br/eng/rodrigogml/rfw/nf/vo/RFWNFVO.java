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
 * A maior parte dos campos são marcados como não obrigatórios para que seja possível realizar a persistência do objeto em modo de reascunho. A validação de emissão e conssitência será feitar por métodos específicos e não apenas pelas Meta Annotations.
 *
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Rodrigo GML - Criação do objeto seguindo as instruções do MOC 7.0 - Layout disponível no Anexo I - Layout e Regras de Validação da NF-e e NFC-e.<br>
 *          Nem todos os campos foram adicionados para otimizar à necessidade atual. Campos remanescentes devem ser acrescidos em versões futuras.
 */
public class RFWNFVO extends RFWVO {

  private static final long serialVersionUID = -6396799029642499019L;

  /**
   * Enum para definir o tipo de indicador de presença do comprador no estabelecimento comercial no momento da operação.
   */
  public enum NFAttendanceType {
    /**
     * Não se aplica para o tipo de operação da NF.
     */
    NOTAPPLICABLE("0"),

    /** Atendimento presencial. */
    PRESENTIAL("1"),

    /** Pela internet. */
    INTERNET("2"),

    /** Televendas/telemarketing. */
    TELEMARKETING("3"),
    /**
     * NFC-e em operação com entrega a domicílio.
     */
    NFCe_DELIVERY("4"),

    /** Operação presencial, fora do estabelecimento;. */
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
   * Define a finalidade da emissão da nota: Normal, Complementar, devolução, etc.
   */
  public static enum NFEmissionGoal {

    /** NF Normal. */
    NORMAL("1"),

    /** NF Complementar. */
    COMPLEMENT("2"),

    /** NF de Ajuste. */
    ADJUSTMENT("3"),

    /** Devolução de Mercadoria. */
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
   * Enum que define o tipo da NFe conforme definido pela SEFAZ entre notas de entrada ou saída. De acordo com o fluxo da marcadoria no fluxo do emitente da NF.
   */
  public static enum NFType {
    /**
     * Define que é uma nota de entrada de mercadorias em relação ao emitente da NFe.
     */
    ENTRY("0"),
    /**
     * Define que é uma nota de saída de mercadorias em relação ao emitente da NFe.
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
    // * Modelo de Notas Fiscais de talão.
    // */
    // MODEL01(null), //Desliguei na migração para o RFW.SEFAZ
    /**
     * Modelo de Nota Fiscal Eletrônica (NFe).
     */
    MODEL55("55"),
    /**
     * Modelo de Nota Fiscal de Consumidor Eletrônica (NFCe).
     */
    MODEL65("65");

    /**
     * Código de identificação do modelo do documento. (Catálogo utilizado na NFe.)
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
     * # código de identificação do modelo do documento. (Catálogo utilizado na NFe.).
     *
     * @return the código de identificação do modelo do documento
     */
    public String getXmlCode() {
      return xmlCode;
    }
  }

  /**
   * Define a forma de pagamento da nota fiscal.
   */
  public static enum NFPaymentMethod {

    /** Pagamento à Vista. */
    CASHPAYMENT("0"),

    /** Pagamento à Prazo. */
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
   * Versão do leiaute<Br>
   * TAG: NFe/infNFe/@versao
   */
  @RFWMetaStringField(caption = "Versão do Layout", maxLength = 10, pattern = "[0-9]+\\.[0-9]+", required = true)
  private String layoutVersion = null;

  /**
   * Chave de acesso da nota. Tamanho 44 Dígitos.<Br>
   * Tag: NFe/infNFe/@Id - Nesta tag, informar a Chave de Acesso precedida do literal ‘NFe’ (total 47 dígitos)
   */
  @RFWMetaStringField(caption = "Chave", maxLength = 44, minlength = 44, pattern = "[0-9]{44}", required = false, unique = true)
  private String chave = null;

  /**
   * Número aleatório com a finalidade de mascarar a chave da NFe. Normalmente gerado automaticamente pelo sistema durante a emissão da NFe.<br>
   * Alguma aplicações podem não querer gerar esse número aleatoriamente toda nota, mas por empresa. Embora menos seguro e quebrando o objetido deste código, permite que em caso de perda do documento/informações da NFe seja possível reobter as NFes a partir do site da SEFAZ.<br>
   * <br>
   * Código Numérico que compõe a Chave de Acesso<br>
   * Número aleatório gerado pelo emitente para cada NF-e para evitar acessos indevidos da NF-e. (v2.0)<br>
   * TAG: NFe/infNFe/ide/cNF<br>
   */
  @RFWMetaIntegerField(caption = "Código Numérico", minvalue = 0, required = false)
  private Integer randomKey = null;

  /**
   * Descrição da Natureza da Operaçã.<br>
   * Informar a natureza da operação de que decorrer a saída ou a entrada, tais como: venda, compra, transferência, devolução, importação, consignação, remessa (para fins de demonstração, de industrialização ou outra), conforme previsto na alínea 'i', inciso I, art. 19 do CONVÊNIO S/Nº, de 15 de dezembro de 1970.<br>
   * TAG: NFe/infNFe/ide/natOp
   */
  @RFWMetaStringField(caption = "Natureza da Operação", maxLength = 200, required = false)
  private String operationNature = null;

  /**
   * Método de pagamento conforme definido no documento fiscal.<br>
   * TAG: NFe/infNFe/ide/indPag
   *
   * @deprecated <b>Deixou de existir na versão 4.00</b>
   */
  @Deprecated
  @RFWMetaEnumField(caption = "Forma de Pagamento", required = false)
  private NFPaymentMethod payment = null;

  /**
   * Código do Modelo do Documento Fiscal<br>
   * <li>55=NF-e emitida em substituição ao modelo 1 ou 1A;
   * <li>65=NFC-e, utilizada nas operações de venda no varejo (a critério da UF aceitar este modelo de documento). <Br>
   * TAG: NFe/infNFe/ide/mod
   */
  @RFWMetaEnumField(caption = "Modelo", required = true)
  private NFModel model = null;

  /**
   * Série do Documento Fiscal <br>
   * Série do Documento Fiscal, preencher com zeros na hipótese de a NF-e não possuir série. Série na faixa:
   * <li>[000-889]: Aplicativo do Contribuinte; Emitente=CNPJ; Assinatura pelo e-CNPJ do contribuinte (procEmi<>1,2);
   * <li>[890-899]: Emissão no site do Fisco (NFA-e - Avulsa); Emitente= CNPJ / CPF; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1);
   * <li>[900-909]: Emissão no site do Fisco (NFA-e); Emitente= CNPJ; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1), ou Assinatura pelo e-CNPJ do contribuinte (procEmi=2);
   * <li>[910-919]: Emissão no site do Fisco (NFA-e); Emitente= CPF; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1), ou Assinatura pelo e-CPF do contribuinte (procEmi=2);
   * <li>[920-969]: Aplicativo do Contribuinte; Emitente=CPF; Assinatura pelo e-CPF do contribuinte (procEmi<>1,2); (Atualizado NT 2018/001) <Br>
   * <br>
   * TAG: NFe/infNFe/ide/serie
   */
  @RFWMetaIntegerField(caption = "Série", required = false, maxvalue = 999, minvalue = 0)
  private Integer serie = null;

  /**
   * Número do Documento Fiscal<br>
   * TAG: NFe/infNFe/ide/nNF
   */
  @RFWMetaLongField(caption = "Número", required = false, minvalue = 1, maxvalue = 999999999L)
  private Long number = null;

  /**
   * Data e hora de emissão do Documento Fiscal <br>
   * Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD<Br>
   * <br>
   * Nota Técnica 2013.005:
   * <li>As tags dhEmi e dhSaiEnt foram alteradas para dEmi e dSaiEnt.
   * <li>O formato dos campos de data e hora foi alterado para o formato UTC (Universal Coordinated Time).
   * <li>O campo hSaiEnt foi eliminado.
   *
   * <br>
   * TAG: NFe/infNFe/ide/dhEmi
   */
  @RFWMetaDateField(caption = "Data Emissão", required = false, resolution = DateResolution.SECOND)
  private LocalDateTime emission = null;

  /**
   * Data e hora de Saída ou da Entrada da Mercadoria/Produto<br>
   * Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD. <br>
   * Observação: Não informar este campo para a NFC-e.<br>
   *
   * <br>
   * Nota Técnica 2013.005:
   * <li>As tags dhEmi e dhSaiEnt foram alteradas para dEmi e dSaiEnt.
   * <li>O formato dos campos de data e hora foi alterado para o formato UTC (Universal Coordinated Time).
   * <li>O campo hSaiEnt foi eliminado.
   *
   * <br>
   * TAG: NFe/infNFe/ide/dhSaiEnt
   *
   */
  @RFWMetaDateField(caption = "Data Entrada/Saída", required = false, resolution = DateResolution.SECOND)
  private LocalDateTime entryDate = null;

  /**
   * Tipo de Operação<br>
   * <li>0=Entrada;
   * <li>1=Saída <br>
   *
   * Indica o tipo da NFe (Fluxo das mercadorias) em relação ao emitente da NFe.<br>
   * Por exemplo, se um fornecedor emite uma nota de venda contra nossa empresa, o atributo {@link #nfType} indicará que é uma nota de Saída, pois refere-se ao tipo da nota. Já {@link #nfProductFlow} inficará que é do tipo Entrada, pois em relação à empresa é uma nota que gerou um fluxo de entrada de mercadorias. <br>
   * <br>
   * TAG: NFe/infNFe/ide/tpNF
   */
  @RFWMetaEnumField(caption = "Tipo da NF", required = false)
  private NFType nfType = null;

  /**
   * Código do Município de Ocorrência do Fato Gerador <br>
   * Informar o município de ocorrência do fato gerador do ICMS. Utilizar a Tabela do IBGE (Seção 8.2 do MOC – Visão Geral, Tabela de UF, Município e País)<br>
   * <br>
   * TAG: NFe/infNFe/ide/cMunFG
   */
  @RFWMetaStringField(caption = "Código Município do Fato Gerador", maxLength = 7, pattern = "[0-9]{0,7}", required = false, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cityCodeTaxEvent = null;

  /**
   * Tipo de Emissão da NF-e <br>
   * <li>1=Emissão normal (não em contingência);
   * <li>2=Contingência FS-IA, com impressão do DANFE em Formulário de Segurança - Impressor Autônomo;
   * <li>3=Contingência SCAN (Sistema de Contingência do Ambiente Nacional); *Desativado * NT 2015/002
   * <li>4=Contingência EPEC (Evento Prévio da Emissão em Contingência);
   * <li>5=Contingência FS-DA, com impressão do DANFE em Formulário de Segurança - Documento Auxiliar;
   * <li>6=Contingência SVC-AN (SEFAZ Virtual de Contingência do AN);
   * <li>7=Contingência SVC-RS (SEFAZ Virtual de Contingência do RS);
   * <li>9=Contingência off-line da NFC-e; <br>
   * Observação: Para a NFC-e somente é válida a opção de contingência: 9-Contingência Off-Line e, a critério da UF, opção 4-Contingência EPEC. (NT 2015/002)
   *
   * <br>
   * TAG: NFe/infNFe/ide/finNFe
   */
  @RFWMetaEnumField(caption = "Finalidade de Emissão", required = false)
  private NFEmissionGoal emissionGoal = null;

  /**
   * Indica operação com Consumidor final<br>
   * <li>0=Normal;
   * <li>1=Consumidor final;<br>
   * <Br>
   * TAG:NFe/infNFe/ide/indFinal
   */
  @RFWMetaBooleanField(caption = "Consumidor Final", required = false, trueCaption = "Sim", falseCaption = "Não")
  private Boolean finalCostumer = null;

  /**
   * Indicador de presença do comprador no estabelecimento comercial no momento da operação<br>
   * <li>0=Não se aplica (por exemplo, Nota Fiscal complementar ou de ajuste);
   * <li>1=Operação presencial;
   * <li>2=Operação não presencial, pela Internet;
   * <li>3=Operação não presencial, Teleatendimento;
   * <li>4=NFC-e em operação com entrega a domicílio;
   * <li>5=Operação presencial, fora do estabelecimento; (incluído NT2016.002)
   * <li>9=Operação não presencial, outros. <br>
   * <br>
   * TAG: NFe/infNFe/ide/indPres
   */
  @RFWMetaEnumField(caption = "Tipo Atendimento", required = false)
  private NFAttendanceType attendanceType = null;

  /**
   * # versão do leiaute<Br>
   * TAG: NFe/infNFe/@versao.
   *
   * @return # versão do leiaute<Br>
   *         TAG: NFe/infNFe/@versao
   */
  public String getLayoutVersion() {
    return layoutVersion;
  }

  /**
   * # versão do leiaute<Br>
   * TAG: NFe/infNFe/@versao.
   *
   * @param layoutVersion # versão do leiaute<Br>
   *          TAG: NFe/infNFe/@versao
   */
  public void setLayoutVersion(String layoutVersion) {
    this.layoutVersion = layoutVersion;
  }

  /**
   * # chave de acesso da nota. Tamanho 44 Dígitos.<Br>
   * Tag: NFe/infNFe/@Id - Nesta tag, informar a Chave de Acesso precedida do literal ‘NFe’ (total 47 dígitos).
   *
   * @return # chave de acesso da nota
   */
  public String getChave() {
    return chave;
  }

  /**
   * # chave de acesso da nota. Tamanho 44 Dígitos.<Br>
   * Tag: NFe/infNFe/@Id - Nesta tag, informar a Chave de Acesso precedida do literal ‘NFe’ (total 47 dígitos).
   *
   * @param chave # chave de acesso da nota
   */
  public void setChave(String chave) {
    this.chave = chave;
  }

  /**
   * # número aleatório com a finalidade de mascarar a chave da NFe. Normalmente gerado automaticamente pelo sistema durante a emissão da NFe.<br>
   * Alguma aplicações podem não querer gerar esse número aleatoriamente toda nota, mas por empresa. Embora menos seguro e quebrando o objetido deste código, permite que em caso de perda do documento/informações da NFe seja possível reobter as NFes a partir do site da SEFAZ.<br>
   * <br>
   * Código Numérico que compõe a Chave de Acesso<br>
   * Número aleatório gerado pelo emitente para cada NF-e para evitar acessos indevidos da NF-e. (v2.0)<br>
   * TAG: NFe/infNFe/ide/cNF<br>
   * .
   *
   * @return # número aleatório com a finalidade de mascarar a chave da NFe
   */
  public Integer getRandomKey() {
    return randomKey;
  }

  /**
   * # número aleatório com a finalidade de mascarar a chave da NFe. Normalmente gerado automaticamente pelo sistema durante a emissão da NFe.<br>
   * Alguma aplicações podem não querer gerar esse número aleatoriamente toda nota, mas por empresa. Embora menos seguro e quebrando o objetido deste código, permite que em caso de perda do documento/informações da NFe seja possível reobter as NFes a partir do site da SEFAZ.<br>
   * <br>
   * Código Numérico que compõe a Chave de Acesso<br>
   * Número aleatório gerado pelo emitente para cada NF-e para evitar acessos indevidos da NF-e. (v2.0)<br>
   * TAG: NFe/infNFe/ide/cNF<br>
   * .
   *
   * @param randomKey # número aleatório com a finalidade de mascarar a chave da NFe
   */
  public void setRandomKey(Integer randomKey) {
    this.randomKey = randomKey;
  }

  /**
   * # descrição da Natureza da Operaçã.<br>
   * Informar a natureza da operação de que decorrer a saída ou a entrada, tais como: venda, compra, transferência, devolução, importação, consignação, remessa (para fins de demonstração, de industrialização ou outra), conforme previsto na alínea 'i', inciso I, art. 19 do CONVÊNIO S/Nº, de 15 de dezembro de 1970.<br>
   * TAG: NFe/infNFe/ide/natOp.
   *
   * @return # descrição da Natureza da Operaçã
   */
  public String getOperationNature() {
    return operationNature;
  }

  /**
   * # descrição da Natureza da Operaçã.<br>
   * Informar a natureza da operação de que decorrer a saída ou a entrada, tais como: venda, compra, transferência, devolução, importação, consignação, remessa (para fins de demonstração, de industrialização ou outra), conforme previsto na alínea 'i', inciso I, art. 19 do CONVÊNIO S/Nº, de 15 de dezembro de 1970.<br>
   * TAG: NFe/infNFe/ide/natOp.
   *
   * @param operationNature # descrição da Natureza da Operaçã
   */
  public void setOperationNature(String operationNature) {
    this.operationNature = operationNature;
  }

  /**
   * # método de pagamento conforme definido no documento fiscal.<br>
   * TAG: NFe/infNFe/ide/indPag.
   *
   * @return # método de pagamento conforme definido no documento fiscal
   */
  public NFPaymentMethod getPayment() {
    return payment;
  }

  /**
   * # método de pagamento conforme definido no documento fiscal.<br>
   * TAG: NFe/infNFe/ide/indPag.
   *
   * @param payment # método de pagamento conforme definido no documento fiscal
   */
  public void setPayment(NFPaymentMethod payment) {
    this.payment = payment;
  }

  /**
   * # código do Modelo do Documento Fiscal<br>
   * <li>55=NF-e emitida em substituição ao modelo 1 ou 1A;
   * <li>65=NFC-e, utilizada nas operações de venda no varejo (a critério da UF aceitar este modelo de documento). <Br>
   * TAG: NFe/infNFe/ide/mod.
   *
   * @return # código do Modelo do Documento Fiscal<br>
   *         <li>55=NF-e emitida em substituição ao modelo 1 ou 1A;
   *         <li>65=NFC-e, utilizada nas operações de venda no varejo (a critério da UF aceitar este modelo de documento)
   */
  public NFModel getModel() {
    return model;
  }

  /**
   * # código do Modelo do Documento Fiscal<br>
   * <li>55=NF-e emitida em substituição ao modelo 1 ou 1A;
   * <li>65=NFC-e, utilizada nas operações de venda no varejo (a critério da UF aceitar este modelo de documento). <Br>
   * TAG: NFe/infNFe/ide/mod.
   *
   * @param model # código do Modelo do Documento Fiscal<br>
   *          <li>55=NF-e emitida em substituição ao modelo 1 ou 1A;
   *          <li>65=NFC-e, utilizada nas operações de venda no varejo (a critério da UF aceitar este modelo de documento)
   */
  public void setModel(NFModel model) {
    this.model = model;
  }

  /**
   * # série do Documento Fiscal <br>
   * Série do Documento Fiscal, preencher com zeros na hipótese de a NF-e não possuir série. Série na faixa:
   * <li>[000-889]: Aplicativo do Contribuinte; Emitente=CNPJ; Assinatura pelo e-CNPJ do contribuinte (procEmi<>1,2);
   * <li>[890-899]: Emissão no site do Fisco (NFA-e - Avulsa); Emitente= CNPJ / CPF; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1);
   * <li>[900-909]: Emissão no site do Fisco (NFA-e); Emitente= CNPJ; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1), ou Assinatura pelo e-CNPJ do contribuinte (procEmi=2);
   * <li>[910-919]: Emissão no site do Fisco (NFA-e); Emitente= CPF; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1), ou Assinatura pelo e-CPF do contribuinte (procEmi=2);
   * <li>[920-969]: Aplicativo do Contribuinte; Emitente=CPF; Assinatura pelo e-CPF do contribuinte (procEmi<>1,2); (Atualizado NT 2018/001) <Br>
   * <br>
   * TAG: NFe/infNFe/ide/serie.
   *
   * @return # série do Documento Fiscal <br>
   *         Série do Documento Fiscal, preencher com zeros na hipótese de a NF-e não possuir série
   */
  public Integer getSerie() {
    return serie;
  }

  /**
   * # série do Documento Fiscal <br>
   * Série do Documento Fiscal, preencher com zeros na hipótese de a NF-e não possuir série. Série na faixa:
   * <li>[000-889]: Aplicativo do Contribuinte; Emitente=CNPJ; Assinatura pelo e-CNPJ do contribuinte (procEmi<>1,2);
   * <li>[890-899]: Emissão no site do Fisco (NFA-e - Avulsa); Emitente= CNPJ / CPF; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1);
   * <li>[900-909]: Emissão no site do Fisco (NFA-e); Emitente= CNPJ; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1), ou Assinatura pelo e-CNPJ do contribuinte (procEmi=2);
   * <li>[910-919]: Emissão no site do Fisco (NFA-e); Emitente= CPF; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1), ou Assinatura pelo e-CPF do contribuinte (procEmi=2);
   * <li>[920-969]: Aplicativo do Contribuinte; Emitente=CPF; Assinatura pelo e-CPF do contribuinte (procEmi<>1,2); (Atualizado NT 2018/001) <Br>
   * <br>
   * TAG: NFe/infNFe/ide/serie.
   *
   * @param serie # série do Documento Fiscal <br>
   *          Série do Documento Fiscal, preencher com zeros na hipótese de a NF-e não possuir série
   */
  public void setSerie(Integer serie) {
    this.serie = serie;
  }

  /**
   * # número do Documento Fiscal<br>
   * TAG: NFe/infNFe/ide/nNF.
   *
   * @return # número do Documento Fiscal<br>
   *         TAG: NFe/infNFe/ide/nNF
   */
  public Long getNumber() {
    return number;
  }

  /**
   * # número do Documento Fiscal<br>
   * TAG: NFe/infNFe/ide/nNF.
   *
   * @param number # número do Documento Fiscal<br>
   *          TAG: NFe/infNFe/ide/nNF
   */
  public void setNumber(Long number) {
    this.number = number;
  }

  /**
   * # data e hora de emissão do Documento Fiscal <br>
   * Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD<Br>
   * <br>
   * Nota Técnica 2013.005:
   * <li>As tags dhEmi e dhSaiEnt foram alteradas para dEmi e dSaiEnt.
   * <li>O formato dos campos de data e hora foi alterado para o formato UTC (Universal Coordinated Time).
   * <li>O campo hSaiEnt foi eliminado. <br>
   * TAG: NFe/infNFe/ide/dhEmi.
   *
   * @return # data e hora de emissão do Documento Fiscal <br>
   *         Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD<Br>
   *         <br>
   *         Nota Técnica 2013
   */
  public LocalDateTime getEmission() {
    return emission;
  }

  /**
   * # data e hora de emissão do Documento Fiscal <br>
   * Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD<Br>
   * <br>
   * Nota Técnica 2013.005:
   * <li>As tags dhEmi e dhSaiEnt foram alteradas para dEmi e dSaiEnt.
   * <li>O formato dos campos de data e hora foi alterado para o formato UTC (Universal Coordinated Time).
   * <li>O campo hSaiEnt foi eliminado. <br>
   * TAG: NFe/infNFe/ide/dhEmi.
   *
   * @param emission # data e hora de emissão do Documento Fiscal <br>
   *          Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD<Br>
   *          <br>
   *          Nota Técnica 2013
   */
  public void setEmission(LocalDateTime emission) {
    this.emission = emission;
  }

  /**
   * # data e hora de Saída ou da Entrada da Mercadoria/Produto<br>
   * Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD. <br>
   * Observação: Não informar este campo para a NFC-e.<br>
   * <br>
   * Nota Técnica 2013.005:
   * <li>As tags dhEmi e dhSaiEnt foram alteradas para dEmi e dSaiEnt.
   * <li>O formato dos campos de data e hora foi alterado para o formato UTC (Universal Coordinated Time).
   * <li>O campo hSaiEnt foi eliminado. <br>
   * TAG: NFe/infNFe/ide/dhSaiEnt.
   *
   * @return # data e hora de Saída ou da Entrada da Mercadoria/Produto<br>
   *         Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD
   */
  public LocalDateTime getEntryDate() {
    return entryDate;
  }

  /**
   * # data e hora de Saída ou da Entrada da Mercadoria/Produto<br>
   * Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD. <br>
   * Observação: Não informar este campo para a NFC-e.<br>
   * <br>
   * Nota Técnica 2013.005:
   * <li>As tags dhEmi e dhSaiEnt foram alteradas para dEmi e dSaiEnt.
   * <li>O formato dos campos de data e hora foi alterado para o formato UTC (Universal Coordinated Time).
   * <li>O campo hSaiEnt foi eliminado. <br>
   * TAG: NFe/infNFe/ide/dhSaiEnt.
   *
   * @param entryDate # data e hora de Saída ou da Entrada da Mercadoria/Produto<br>
   *          Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD
   */
  public void setEntryDate(LocalDateTime entryDate) {
    this.entryDate = entryDate;
  }

  /**
   * # tipo de Operação<br>
   * <li>0=Entrada;
   * <li>1=Saída <br>
   * Indica o tipo da NFe (Fluxo das mercadorias) em relação ao emitente da NFe.<br>
   * Por exemplo, se um fornecedor emite uma nota de venda contra nossa empresa, o atributo {@link #nfType} indicará que é uma nota de Saída, pois refere-se ao tipo da nota. Já {@link #nfProductFlow} inficará que é do tipo Entrada, pois em relação à empresa é uma nota que gerou um fluxo de entrada de mercadorias. <br>
   * <br>
   * TAG: NFe/infNFe/ide/tpNF.
   *
   * @return # tipo de Operação<br>
   *         <li>0=Entrada;
   *         <li>1=Saída <br>
   *         Indica o tipo da NFe (Fluxo das mercadorias) em relação ao emitente da NFe
   */
  public NFType getNfType() {
    return nfType;
  }

  /**
   * # tipo de Operação<br>
   * <li>0=Entrada;
   * <li>1=Saída <br>
   * Indica o tipo da NFe (Fluxo das mercadorias) em relação ao emitente da NFe.<br>
   * Por exemplo, se um fornecedor emite uma nota de venda contra nossa empresa, o atributo {@link #nfType} indicará que é uma nota de Saída, pois refere-se ao tipo da nota. Já {@link #nfProductFlow} inficará que é do tipo Entrada, pois em relação à empresa é uma nota que gerou um fluxo de entrada de mercadorias. <br>
   * <br>
   * TAG: NFe/infNFe/ide/tpNF.
   *
   * @param nfType # tipo de Operação<br>
   *          <li>0=Entrada;
   *          <li>1=Saída <br>
   *          Indica o tipo da NFe (Fluxo das mercadorias) em relação ao emitente da NFe
   */
  public void setNfType(NFType nfType) {
    this.nfType = nfType;
  }

  /**
   * # código do Município de Ocorrência do Fato Gerador <br>
   * Informar o município de ocorrência do fato gerador do ICMS. Utilizar a Tabela do IBGE (Seção 8.2 do MOC – Visão Geral, Tabela de UF, Município e País)<br>
   * <br>
   * TAG: NFe/infNFe/ide/cMunFG.
   *
   * @return # código do Município de Ocorrência do Fato Gerador <br>
   *         Informar o município de ocorrência do fato gerador do ICMS
   */
  public String getCityCodeTaxEvent() {
    return cityCodeTaxEvent;
  }

  /**
   * # código do Município de Ocorrência do Fato Gerador <br>
   * Informar o município de ocorrência do fato gerador do ICMS. Utilizar a Tabela do IBGE (Seção 8.2 do MOC – Visão Geral, Tabela de UF, Município e País)<br>
   * <br>
   * TAG: NFe/infNFe/ide/cMunFG.
   *
   * @param cityCodeTaxEvent # código do Município de Ocorrência do Fato Gerador <br>
   *          Informar o município de ocorrência do fato gerador do ICMS
   */
  public void setCityCodeTaxEvent(String cityCodeTaxEvent) {
    this.cityCodeTaxEvent = cityCodeTaxEvent;
  }

  /**
   * # tipo de Emissão da NF-e <br>
   * <li>1=Emissão normal (não em contingência);
   * <li>2=Contingência FS-IA, com impressão do DANFE em Formulário de Segurança - Impressor Autônomo;
   * <li>3=Contingência SCAN (Sistema de Contingência do Ambiente Nacional); *Desativado * NT 2015/002
   * <li>4=Contingência EPEC (Evento Prévio da Emissão em Contingência);
   * <li>5=Contingência FS-DA, com impressão do DANFE em Formulário de Segurança - Documento Auxiliar;
   * <li>6=Contingência SVC-AN (SEFAZ Virtual de Contingência do AN);
   * <li>7=Contingência SVC-RS (SEFAZ Virtual de Contingência do RS);
   * <li>9=Contingência off-line da NFC-e; <br>
   * Observação: Para a NFC-e somente é válida a opção de contingência: 9-Contingência Off-Line e, a critério da UF, opção 4-Contingência EPEC. (NT 2015/002) <br>
   * TAG: NFe/infNFe/ide/finNFe.
   *
   * @return # tipo de Emissão da NF-e <br>
   *         <li>1=Emissão normal (não em contingência);
   *         <li>2=Contingência FS-IA, com impressão do DANFE em Formulário de Segurança - Impressor Autônomo;
   *         <li>3=Contingência SCAN (Sistema de Contingência do Ambiente Nacional); *Desativado * NT 2015/002
   *         <li>4=Contingência EPEC (Evento Prévio da Emissão em Contingência);
   *         <li>5=Contingência FS-DA, com impressão do DANFE em Formulário de Segurança - Documento Auxiliar;
   *         <li>6=Contingência SVC-AN (SEFAZ Virtual de Contingência do AN);
   *         <li>7=Contingência SVC-RS (SEFAZ Virtual de Contingência do RS);
   *         <li>9=Contingência off-line da NFC-e; <br>
   *         Observação: Para a NFC-e somente é válida a opção de contingência: 9-Contingência Off-Line e, a critério da UF, opção 4-Contingência EPEC
   */
  public NFEmissionGoal getEmissionGoal() {
    return emissionGoal;
  }

  /**
   * # tipo de Emissão da NF-e <br>
   * <li>1=Emissão normal (não em contingência);
   * <li>2=Contingência FS-IA, com impressão do DANFE em Formulário de Segurança - Impressor Autônomo;
   * <li>3=Contingência SCAN (Sistema de Contingência do Ambiente Nacional); *Desativado * NT 2015/002
   * <li>4=Contingência EPEC (Evento Prévio da Emissão em Contingência);
   * <li>5=Contingência FS-DA, com impressão do DANFE em Formulário de Segurança - Documento Auxiliar;
   * <li>6=Contingência SVC-AN (SEFAZ Virtual de Contingência do AN);
   * <li>7=Contingência SVC-RS (SEFAZ Virtual de Contingência do RS);
   * <li>9=Contingência off-line da NFC-e; <br>
   * Observação: Para a NFC-e somente é válida a opção de contingência: 9-Contingência Off-Line e, a critério da UF, opção 4-Contingência EPEC. (NT 2015/002) <br>
   * TAG: NFe/infNFe/ide/finNFe.
   *
   * @param emissionGoal # tipo de Emissão da NF-e <br>
   *          <li>1=Emissão normal (não em contingência);
   *          <li>2=Contingência FS-IA, com impressão do DANFE em Formulário de Segurança - Impressor Autônomo;
   *          <li>3=Contingência SCAN (Sistema de Contingência do Ambiente Nacional); *Desativado * NT 2015/002
   *          <li>4=Contingência EPEC (Evento Prévio da Emissão em Contingência);
   *          <li>5=Contingência FS-DA, com impressão do DANFE em Formulário de Segurança - Documento Auxiliar;
   *          <li>6=Contingência SVC-AN (SEFAZ Virtual de Contingência do AN);
   *          <li>7=Contingência SVC-RS (SEFAZ Virtual de Contingência do RS);
   *          <li>9=Contingência off-line da NFC-e; <br>
   *          Observação: Para a NFC-e somente é válida a opção de contingência: 9-Contingência Off-Line e, a critério da UF, opção 4-Contingência EPEC
   */
  public void setEmissionGoal(NFEmissionGoal emissionGoal) {
    this.emissionGoal = emissionGoal;
  }

  /**
   * # indica operação com Consumidor final<br>
   * <li>0=Normal;
   * <li>1=Consumidor final;<br>
   * <Br>
   * TAG:NFe/infNFe/ide/indFinal.
   *
   * @return # indica operação com Consumidor final<br>
   *         <li>0=Normal;
   *         <li>1=Consumidor final;<br>
   *         <Br>
   *         TAG:NFe/infNFe/ide/indFinal
   */
  public Boolean getFinalCostumer() {
    return finalCostumer;
  }

  /**
   * # indica operação com Consumidor final<br>
   * <li>0=Normal;
   * <li>1=Consumidor final;<br>
   * <Br>
   * TAG:NFe/infNFe/ide/indFinal.
   *
   * @param finalCostumer # indica operação com Consumidor final<br>
   *          <li>0=Normal;
   *          <li>1=Consumidor final;<br>
   *          <Br>
   *          TAG:NFe/infNFe/ide/indFinal
   */
  public void setFinalCostumer(Boolean finalCostumer) {
    this.finalCostumer = finalCostumer;
  }

  /**
   * # indicador de presença do comprador no estabelecimento comercial no momento da operação<br>
   * <li>0=Não se aplica (por exemplo, Nota Fiscal complementar ou de ajuste);
   * <li>1=Operação presencial;
   * <li>2=Operação não presencial, pela Internet;
   * <li>3=Operação não presencial, Teleatendimento;
   * <li>4=NFC-e em operação com entrega a domicílio;
   * <li>5=Operação presencial, fora do estabelecimento; (incluído NT2016.002)
   * <li>9=Operação não presencial, outros. <br>
   * <br>
   * TAG: NFe/infNFe/ide/indPres.
   *
   * @return # indicador de presença do comprador no estabelecimento comercial no momento da operação<br>
   *         <li>0=Não se aplica (por exemplo, Nota Fiscal complementar ou de ajuste);
   *         <li>1=Operação presencial;
   *         <li>2=Operação não presencial, pela Internet;
   *         <li>3=Operação não presencial, Teleatendimento;
   *         <li>4=NFC-e em operação com entrega a domicílio;
   *         <li>5=Operação presencial, fora do estabelecimento; (incluído NT2016
   */
  public NFAttendanceType getAttendanceType() {
    return attendanceType;
  }

  /**
   * # indicador de presença do comprador no estabelecimento comercial no momento da operação<br>
   * <li>0=Não se aplica (por exemplo, Nota Fiscal complementar ou de ajuste);
   * <li>1=Operação presencial;
   * <li>2=Operação não presencial, pela Internet;
   * <li>3=Operação não presencial, Teleatendimento;
   * <li>4=NFC-e em operação com entrega a domicílio;
   * <li>5=Operação presencial, fora do estabelecimento; (incluído NT2016.002)
   * <li>9=Operação não presencial, outros. <br>
   * <br>
   * TAG: NFe/infNFe/ide/indPres.
   *
   * @param attendanceType # indicador de presença do comprador no estabelecimento comercial no momento da operação<br>
   *          <li>0=Não se aplica (por exemplo, Nota Fiscal complementar ou de ajuste);
   *          <li>1=Operação presencial;
   *          <li>2=Operação não presencial, pela Internet;
   *          <li>3=Operação não presencial, Teleatendimento;
   *          <li>4=NFC-e em operação com entrega a domicílio;
   *          <li>5=Operação presencial, fora do estabelecimento; (incluído NT2016
   */
  public void setAttendanceType(NFAttendanceType attendanceType) {
    this.attendanceType = attendanceType;
  }

}