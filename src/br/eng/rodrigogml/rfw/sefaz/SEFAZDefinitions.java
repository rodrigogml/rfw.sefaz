package br.eng.rodrigogml.rfw.sefaz;

import br.eng.rodrigogml.rfw.kernel.RFW;

/**
 * Description: Classe de definições do módulo. Apresenta funcionalidade similar a CLasse {@link RFW} do módulo principal.<br>
 *
 * @author Rodrigo GML
 * @since 10.0 (29 de out de 2020)
 */
public class SEFAZDefinitions {

  // Ambientes de Produção
  public static final String SP_PRODUCTION_V4_00_CADCONSULTACADASTRO4 = "https://nfe.fazenda.sp.gov.br/ws/cadconsultacadastro4.asmx";
  public static final String SP_PRODUCTION_V4_00_NFEAUTORIZACAO4 = "https://nfe.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx";
  public static final String SP_PRODUCTION_V4_00_NFERETAUTORIZACAO4 = "https://nfe.fazenda.sp.gov.br/ws/nferetautorizacao4.asmx";

  // Ambientes de Homologação
  public static final String SP_TEST_V4_00_CADCONSULTACADASTRO4 = "https://homologacao.nfe.fazenda.sp.gov.br/ws/cadconsultacadastro4.asmx";
  public static final String SP_TEST_V4_00_NFEAUTORIZACAO4 = "https://homologacao.nfe.fazenda.sp.gov.br/ws/NFeAutorizacao4.asmx";
  public static final String SP_TEST_V4_00_NFERETAUTORIZACAO4 = "https://homologacao.nfe.fazenda.sp.gov.br/ws/nferetautorizacao4.asmx";

  /**
   * Construtor privado para classe totalmente estática.
   */
  private SEFAZDefinitions() {
  }

  /**
   * Define o Status possíveis da manifestação do destinatário com a SEFAZ.<br>
   * Não é utilizada no XML, mas representa todos os estados possívels.
   */
  public static enum SefazRecipientManifestation {
    /**
     * Indica que nenhuma minisfestação foi dada ao SEFAZ.
     */
    NONE,
    /**
     * Indica que o documento foi sinalizado na SEFAZ como "Conhecimento da Emissão".
     */
    EMISSION_KNOWLEDGE,
    /**
     * Infica que a operação foi sinalizada como não realizada. Por devolução ou qualquer outro motivo.
     */
    UNFINISHED,
    /**
     * Indica que a manifestação foi feita indicando a conclusão da operação.
     */
    FINISHED,
    /**
     * Indica que a nota é desconhecida pela empresa. Ou seja, a empresa não tem conhecimento desta operação.
     */
    UNKNOW
  }

  /**
   * Define os tipos de contingências que o sistema pode adotar.<br>
   * Esta enumeration é utilizada no momento de criação do Objeto SEFAZ para indicar o ambiente de contingência.
   */
  public static enum SefazContingency {
    /**
     * Define o uso da contingência SVC (SEFAZ Virtual de Contingência). Pode ser usado apenas para NFe.
     */
    SVC,
    /**
     * Define a contingência em Evento Prévio de Emissão em Contingência.
     */
    EPEC,
  }

  /**
   * Modelos de Documentos Fiscais. Utilizado nas Tags:<br>
   * <li>nfe\infNFe\ide\mod
   * <li>nfe\infNFe\ide\NFref\refNF\mod
   * <li>nfe\infNFe\ide\NFref\refNFP\mod
   * <li>nfe\infNFe\ide\NFref\refECF\mod
   */
  public static enum SefazXMLmod {
    /**
     * Modelo de Notas Fiscais de talão.<br>
     * Este modelo não por ser emitido de forma eletrônica, mas pode ser referenciado por notas eletrônicas.
     */
    MODEL01("01"),
    /**
     * Este modelo foi incluído na (incluído na NT2016.002).<br>
     * Modelo de Notas Fiscais de talão.<br>
     * Este modelo não por ser emitido de forma eletrônica, mas pode ser referenciado por notas eletrônicas.
     */
    MODEL02("02"),
    /**
     * Modelo de Notas Fiscais de Produtor.<br>
     * Este modelo não por ser emitido de forma eletrônica, mas pode ser referenciado por notas eletrônicas.
     */
    MODEL04("04"),
    /**
     * Modelo de Cupom Fiscal emitido por máquina registradora (não ECF).<br>
     * Este modelo não por ser emitido de forma eletrônica, mas pode ser referenciado por notas eletrônicas.
     */
    MODEL2B("2B"),
    /**
     * Modelo de Cupom Fiscal PDV.<br>
     * Este modelo não por ser emitido de forma eletrônica, mas pode ser referenciado por notas eletrônicas.
     */
    MODEL2C("2C"),
    /**
     * Modelo de Cupom Fiscal (Emitido por ECF).<br>
     * Este modelo não por ser emitido de forma eletrônica, mas pode ser referenciado por notas eletrônicas.
     */
    MODEL2D("2D"),
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
    SefazXMLmod(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * Recupera o item da Enumeration de acordo com o código no XML.
     *
     * @param xmlCode Valor encontrado no XML
     * @return Item da enumeração encontrato, null caso o valor não seja encontrado.
     */
    public static SefazXMLmod valueOfXmlCode(String xmlCode) {
      for (SefazXMLmod v : values())
        if (v.getXmlCode() != null && v.getXmlCode().equals(xmlCode)) return v;
      return null;
    }

    /**
     * # código de identificação do modelo do documento. (Catálogo utilizado na NFe.).
     *
     * @return # código de identificação do modelo do documento
     */
    public String getXmlCode() {
      return xmlCode;
    }

    /**
     * Retorna os valores atualmente válidos, não retorna os valores que foram removidos da versão mais atual.<br>
     *
     * @return valores aceitos na tag nfe\infNFe\ide\mod.
     */
    public SefazXMLmod[] values_nfe_infNFe_ide_mod() {
      return new SefazXMLmod[] { MODEL55, MODEL65 };
    }

    /**
     * Retorna os valores atualmente válidos, não retorna os valores que foram removidos da versão mais atual.<br>
     *
     * @return valores aceitos na tag nfe\infNFe\ide\refECF\mod.
     */
    public SefazXMLmod[] values_nfe_infNFe_ide_NFref_refECF_mod() {
      return new SefazXMLmod[] { MODEL2B, MODEL2C, MODEL2D };
    }

    /**
     * Retorna os valores atualmente válidos, não retorna os valores que foram removidos da versão mais atual.<br>
     *
     * @return valores aceitos na tag nfe\infNFe\ide\NFref\mod.
     */
    public SefazXMLmod[] values_nfe_infNFe_ide_NFref_refNFP_mod() {
      return new SefazXMLmod[] { MODEL01, MODEL04 };
    }

    /**
     * Retorna os valores atualmente válidos, não retorna os valores que foram removidos da versão mais atual.<br>
     *
     * @return valores aceitos na tag nfe\infNFe\ide\NFref\mod.
     */
    public SefazXMLmod[] values_nfe_infNFe_ide_NFref_refNF_mod() {
      return new SefazXMLmod[] { MODEL01, MODEL02 };
    }

  }

  /**
   * Define o Regime Tributário da empresa para qual a regra se aplica.<br>
   * Utilizado nas Tags:<br>
   * <li>nfe\infNFe\emit\CRT
   */
  public static enum SefazXMLCRT {
    /**
     * Simples Nacional
     */
    SIMPLESNACIONAL("1"),
    /**
     * Simples Nacional, excesso sublimite de receita bruta
     */
    SIMPLESNACIONAL_EXCESSOSUBLIME("2"),
    /**
     * Regime Normal. (v2.0).
     */
    REGIMENORMAL("3");

    /**
     * Código de identificação do modelo do documento. (Catálogo utilizado na NFe.)
     */
    private final String xmlCode;

    SefazXMLCRT(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * # código de identificação do modelo do documento. (Catálogo utilizado na NFe.).
     *
     * @return # código de identificação do modelo do documento
     */
    public String getXmlCode() {
      return xmlCode;
    }

    /**
     * Recupera o item da Enumeration de acordo com o código no XML.
     *
     * @param xmlCode Valor encontrado no XML
     * @return Item da enumeração encontrato, null caso o valor não seja encontrado.
     */
    public static SefazXMLCRT valueOfXmlCode(String xmlCode) {
      for (SefazXMLCRT v : values())
        if (v.getXmlCode() != null && v.getXmlCode().equals(xmlCode)) return v;
      return null;
    }
  }

  /**
   * Define a finalidade da emissão da nota: Normal, Complementar, devolução, etc.<Br>
   * <br>
   * Usado em:
   * <li>nfe\infNFe\ide\finNFe
   */
  public static enum SefazXMLfinNFe {

    /**
     * NF Normal.
     */
    NORMAL("1"),

    /**
     * NF Complementar.
     */
    COMPLEMENT("2"),
    /**
     * NF de Ajuste.
     */
    ADJUSTMENT("3"),

    /**
     * Devolução de Mercadoria.
     */
    RETURNGOODS("4");

    /**
     * Código de identificação do modelo do documento. (Catálogo utilizado na NFe.)
     */
    private final String xmlCode;

    SefazXMLfinNFe(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * Recupera o item da Enumeration de acordo com o código no XML.
     *
     * @param xmlCode Valor encontrado no XML
     * @return Item da enumeração encontrato, null caso o valor não seja encontrado.
     */
    public static SefazXMLfinNFe valueOfXmlCode(String xmlCode) {
      for (SefazXMLfinNFe v : values())
        if (v.getXmlCode().equals(xmlCode)) return v;
      return null;
    }

    /**
     * # código de identificação do modelo do documento. (Catálogo utilizado na NFe.).
     *
     * @return # código de identificação do modelo do documento
     */
    public String getXmlCode() {
      return xmlCode;
    }
  }

  /**
   * Enum que define o tipo da Operação da NFe conforme definido pela SEFAZ entre notas de entrada ou saída.<br>
   * De acordo com o fluxo da marcadoria no fluxo do emitente da NF.<br>
   * Usado em:
   * <li>nfe\infNFe\ide\tpNF
   */
  public static enum SefazXMLtpNF {
    /**
     * Define que é uma nota de entrada de mercadorias em relação ao emitente da NFe.
     */
    ENTRY("0"),
    /**
     * Define que é uma nota de saída de mercadorias em relação ao emitente da NFe.
     */
    EXIT("1");

    /**
     * Código de identificação do modelo do documento. (Catálogo utilizado na NFe.)
     */
    private final String xmlCode;

    SefazXMLtpNF(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * Recupera o item da Enumeration de acordo com o código no XML.
     *
     * @param xmlCode Valor encontrado no XML
     * @return Item da enumeração encontrato, null caso o valor não seja encontrado.
     */
    public static SefazXMLtpNF valueOfXmlCode(String xmlCode) {
      for (SefazXMLtpNF v : values())
        if (v.getXmlCode().equals(xmlCode)) return v;
      return null;
    }

    /**
     * # código de identificação do modelo do documento. (Catálogo utilizado na NFe.).
     *
     * @return # código de identificação do modelo do documento
     */
    public String getXmlCode() {
      return xmlCode;
    }
  }

  /**
   * Enumeration com as UF e mais alguns códigos extras que são aceitos em alguns campos de UF do XML da SEFAZ.<br>
   * Veja detalhes de onde os códigos adicionais são aceitos na documentação de cada Enum.<br>
   * <li>Cada estado e DF contém o código do IBGE usado no XML;</li><br>
   *
   * <Br>
   * Usada nas Tags:
   * <li>ICMSPart\UFST
   */
  public static enum SefazXMLUF {
    AC("12"), AL("27"), AP("16"), AM("13"), BA("29"), CE("23"), DF("53"), ES("32"), GO("52"), MA("21"), MG("31"), MS("50"), MT("51"), PA("15"), PB("25"), PE("26"), PI("22"), PR("41"), RJ("33"), RN("24"), RO("11"), RR("14"), RS("43"), SC("42"), SE("28"), SP("35"), TO("17"),
    /**
     * Utilizado na Tag ICMSPart\UFST para indicar para qual estado é devido o ICMSST no caso de Exterior.
     */
    EX(null);

    /**
     * Código da UF pelo IBGE.
     */
    private String ibgeCode = "";

    SefazXMLUF(String value) {
      this.ibgeCode = value;
    }

    /**
     * Código da UF pelo IBGE.
     *
     * @return Código numérico de 2 dígitos.
     */
    public String getIBGECode() {
      return this.ibgeCode;
    }

    /**
     * Recupera a Sigla do estado brasileiro de acordo com o código do IBGE passado.
     *
     * @param ibgeCode Código da UF ou DF, sempre em String com 2 dígitos e zeros não significativos.
     * @return Enumeration do estado equivalente, ou null caso não seja reconhecido o código.
     */
    public static SefazXMLUF valueOfIBGECode(String ibgeCode) {
      for (int i = 0; i < SefazXMLUF.values().length; i++)
        if (ibgeCode.equalsIgnoreCase(SefazXMLUF.values()[i].getIBGECode())) return SefazXMLUF.values()[i];
      return null;
    }

    /**
     * Acrônimo da UF do Estado.
     *
     * @return Sigla que representa o estado.
     */
    public String getAcronym() {
      // Como as enumerações tem o nome do acronym, só chamamos o .toString(). Mas este método existe para que não chamemos o .toString() em vários lugares diferentes do código
      return toString();
    }

    /**
     * Mesmo que o método {@link #values()}, mas contento apenas os valores do enumeraion que representam uma UF (Estados e DF).
     *
     * @return Array somente com as UFs
     */
    public SefazXMLUF[] valuesUFOnly() {
      return new SefazXMLUF[] {
          AC, AL, AP, AM, BA, CE, DF, ES, GO, MA, MG, MS, MT, PA, PB, PE, PI, PR, RJ, RN, RO, RR, RS, SC, SE, SP, TO
      };
    }
  }

  /**
   * Define o ambiente em que a classe SESFAZWS vai trabalhar.<br>
   * Utilizado em:<br>
   * <li>nfe\infNFe\ide\tpAmb
   */
  public static enum SefazXMLtpAmb {
    /**
     * Ambiente de teste de desenvolvimento e emissão de documentos. Sem valor juridico/fiscal.
     */
    TEST("2"),

    /**
     * Servidores do ambiente de produção. Ambiente com valor juridico/fiscal.<br>
     * CUIDADO AO USAR ESTE AMBIENTE.
     */
    PRODUCTION("1");

    /**
     * Valor a ser utilizado no XML da NFe.
     */
    private String xmlCode;

    SefazXMLtpAmb(String value) {
      this.xmlCode = value;
    }

    /**
     * # código de identificação do modelo do documento. (Catálogo utilizado na NFe.).
     *
     * @return # código de identificação do modelo do documento
     */
    public String getXmlCode() {
      return xmlCode;
    }

    /**
     * Recupera o item da Enumeration de acordo com o código no XML.
     *
     * @param xmlCode Valor encontrado no XML
     * @return Item da enumeração encontrato, null caso o valor não seja encontrado.
     */
    public static SefazXMLtpAmb valueOfXmlCode(String xmlCode) {
      for (SefazXMLtpAmb env : SefazXMLtpAmb.values()) {
        if (env.getXmlCode().equals(xmlCode)) return env;
      }
      return null;
    }
  }

  /**
   * Indicador de presença do comprador no estabelecimento comercial no momento da operação.<br>
   * Utilizado em:<br>
   * <li>nfe\infNFe\ide\indPres
   */
  public enum SefazXMLindPres {
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
    /**
     * Operação presencial, fora do estabelecimento; NT2016.002.
     */
    PRESENTIAL_OUTSIDE("5"),
    /**
     * Outro tipo de atendimento.
     */
    OTHER("9");

    /**
     * Código de identificação do modelo do documento. (Catálogo utilizado na NFe.)
     */
    private final String xmlCode;

    SefazXMLindPres(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * Recupera o item da Enumeration de acordo com o código no XML.
     *
     * @param xmlCode Valor encontrado no XML
     * @return Item da enumeração encontrato, null caso o valor não seja encontrado.
     */
    public static SefazXMLindPres valueOfXmlCode(String xmlCode) {
      for (SefazXMLindPres v : values())
        if (v.getXmlCode().equals(xmlCode)) return v;
      return null;
    }

    /**
     * # código de identificação do modelo do documento. (Catálogo utilizado na NFe.).
     *
     * @return # código de identificação do modelo do documento
     */
    public String getXmlCode() {
      return xmlCode;
    }
  }

  /**
   * Define o tipo de operação desta NF. Utilizado em:<br>
   * <li>nfe\infNFe\ide\idDest
   */
  public enum SefazXMLidDest {
    /**
     * Operação interna (ao estado).
     */
    INTERNAL("1"),

    /**
     * Operação Interestadual.
     */
    INTERSTATE("2"),

    /**
     * Operação com o exterior.
     */
    FOREIGN("3");

    /**
     * Código de identificação do modelo do documento. (Catálogo utilizado na NFe.)
     */
    private final String xmlCode;

    SefazXMLidDest(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * Recupera o item da Enumeration de acordo com o código no XML.
     *
     * @param xmlCode Valor encontrado no XML
     * @return Item da enumeração encontrato, null caso o valor não seja encontrado.
     */
    public static SefazXMLidDest valueOfXmlCode(String xmlCode) {
      for (SefazXMLidDest v : values())
        if (v.getXmlCode().equals(xmlCode)) return v;
      return null;
    }

    /**
     * # código de identificação do modelo do documento. (Catálogo utilizado na NFe.).
     *
     * @return # código de identificação do modelo do documento
     */
    public String getXmlCode() {
      return xmlCode;
    }
  }

  /**
   * Define a origem da mercadoria.<br>
   * Utilizado nas tags:
   * <li>ICMS\**\orig
   */
  public static enum SefazXMLorig {
    /**
     * 0 - Produto de origem nacional, exceto as indicadas nos códigos 3 a 5.
     */
    NATIONAL(true, "0"),
    /**
     * 1 - Produto de origem importada, sendo adiquirida diretamente por importação, exceto a indicada no código 6.
     */
    IMPORTED_DIRECTED(false, "1"),
    /**
     * 2 - Produto de origem importada, sendo adiquirida no mercado interno, exceto a indicada no código 7.
     */
    IMPORTED_INDIRECTED(false, "2"),
    /**
     * 3 - Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% (quarenta por cento) e inferior ou igual a 70%.
     */
    NATIONAL_IMPORTEDCOMPOSED_MORETHAN40_LESSEQUALTHAN70(true, "3"),
    /**
     * 4 - Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam o Decreto-Lei nº 288/67, e as Leis nºs 8.248/91, 8.387/91, 10.176/01 e 11 . 4 8 4 / 0 7
     */
    NATIONAL_BASICPRODUCTIONPROCESS(true, "4"),
    /**
     * 5 - Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% (quarenta por cento).
     */
    NATIONAL_IMPORTEDCOMPOSED_LESSTHAN40(true, "5"),
    /**
     * 6 - Estrangeira - Importação direta, sem similar nacional, constante em lista de Resolução CAMEX.
     */
    IMPORTED_DIRECTED_NONATIONALSIMILAR(false, "6"),
    /**
     * 7 - Estrangeira - Adquirida no mercado interno, sem similar nacional, constante em lista de Resolução CAMEX”.
     */
    IMPORTED_INDIRECTED_NONATIONALSIMILAR(false, "7"),
    /**
     * 8 - Nacional, mercadoria ou bem com Conteúdo de Importação superior a 70%;
     */
    NATIONAL_IMPORTEDCOMPOSED_MORETHAN70(true, "8");

    /**
     * Retorna se o item é nacional, ou não.
     */
    private final boolean national;

    /**
     * Código a ser utilizado no XML da NFe.
     */
    private final String xmlCode;

    /**
     * Instantiates a new item origin.
     *
     * @param national retorna se o item é nacional, ou não.
     * @param xmlCode código a ser utilizado no XML da NFe.
     */
    SefazXMLorig(boolean national, String xmlCode) {
      this.national = national;
      this.xmlCode = xmlCode;
    }

    /**
     * # retorna se o item é nacional, ou não.
     *
     * @return the retorna se o item é nacional, ou não
     */
    public boolean isNational() {
      return this.national;
    }

    /**
     * # código a ser utilizado no XML da NFe.
     *
     * @return the código a ser utilizado no XML da NFe
     */
    public String getXmlCode() {
      return xmlCode;
    }

    /**
     * Retorna o ITEMORIGIN correspondente ao código.
     *
     * @param xmlCode passar apenas o código referente a origem do item, não incluir o código de tributação do ICMS.
     * @return {@link SefazXMLorig} com base no código do XML.
     */
    public static SefazXMLorig valueOfXmlCode(String xmlCode) {
      for (SefazXMLorig v : values())
        if (v.getXmlCode().equals(xmlCode))
          return v;
      return null;
    }
  }

  /**
   * Definições dos códigos de CST que podem ser utilizados para preenchimento de documento fiscal.
   */
  public static enum SefazXMLCST {
    /**
     * Tributada integralmente
     */
    ICMS_CST_00("00", false, false, false),
    /**
     * Tributada e com cobrança do ICMS por substituição tributária
     */
    ICMS_CST_10("10", false, true, false),
    /**
     * Com redução de base de cálculo
     */
    ICMS_CST_20("20", false, false, true),
    /**
     * Isenta ou não tributada e com cobrança do ICMS por substituição tributária
     */
    ICMS_CST_30("30", false, true, false),
    /**
     * Isenta
     */
    ICMS_CST_40("40", false, false, false),
    /**
     * Não tributada
     */
    ICMS_CST_41("41", false, false, false),
    /**
     * Suspensão
     */
    ICMS_CST_50("50", false, false, false),
    /**
     * Diferimento
     */
    ICMS_CST_51("51", false, false, false),
    /**
     * ICMS cobrado anteriormente por substituição tributária
     */
    ICMS_CST_60("60", false, true, false),
    /**
     * Com redução de base de cálculo e cobrança do ICMS por substituição tributária
     */
    ICMS_CST_70("70", false, true, true),
    /**
     * Outras
     */
    ICMS_CST_90("90", false, false, false),

    ICMS_CSOSN_101("101", true, false, false), ICMS_CSOSN_102("102", true, false, false), ICMS_CSOSN_103("103", true, false, false), ICMS_CSOSN_201("201", true, true, false), ICMS_CSOSN_202("202", true, true, false), ICMS_CSOSN_203("203", true, true, false), ICMS_CSOSN_300("300", true, false, false), ICMS_CSOSN_400("400", true, false, false), ICMS_CSOSN_500("500", true, true, false), ICMS_CSOSN_900("900", true, false, false);

    /**
     * Código da Situação Tributária que representa o
     */
    private final String cst;
    /**
     * Indicador se o código é do Simples Nacional (CSOSN)
     */
    private final boolean simplesNacional;
    /**
     * Indicador se o código é referente a Substituição Tributária de ICMS
     */
    private final boolean st;
    /**
     * Indicador se o código é referente a Redução na Base de Cálculo.
     */
    private final boolean redBC;

    SefazXMLCST(String cst, boolean simplesNacional, boolean st, boolean redBC) {
      this.cst = cst;
      this.simplesNacional = simplesNacional;
      this.st = st;
      this.redBC = redBC;
    }

    /**
     * # indicador se o código é referente a Substituição Tributária de ICMS.
     *
     * @return # indicador se o código é referente a Substituição Tributária de ICMS
     */
    public boolean isSt() {
      return st;
    }

    /**
     * # indicador se o código é referente a Redução na Base de Cálculo.
     *
     * @return # indicador se o código é referente a Redução na Base de Cálculo
     */
    public boolean isRedBC() {
      return redBC;
    }

    /**
     * Recupera o ICMSCST pelo código da tabela.
     *
     * @param cst código da tabela a ser procurao. Ex: "00", "10", "30". Ou CSOSN: "101", "202", "500"
     * @return
     */
    public static SefazXMLCST valueOfCode(String cst) {
      for (int i = 0; i < SefazXMLCST.values().length; i++)
        if (SefazXMLCST.values()[i].getCst().equals(cst)) return SefazXMLCST.values()[i];
      return null;
    }

    /**
     * # código da Situação Tributária que representa o.
     *
     * @return # código da Situação Tributária que representa o
     */
    public String getCst() {
      return cst;
    }

    /**
     * # indicador se o código é do Simples Nacional (CSOSN).
     *
     * @return # indicador se o código é do Simples Nacional (CSOSN)
     */
    public boolean isSimplesNacional() {
      return simplesNacional;
    }
  }

  /**
   * Enumeração da Modalidade de determinação da BC do ICMS
   */
  public static enum SefazXMLmodBC {
    MVA("0"), PAUTA("1"), FIXED_SHEET("2"), OPERATION_VALUE("3");

    /**
     * Código que é atribuído na TAG XML da NFe
     */
    String xmlCode;

    private SefazXMLmodBC(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * # código que é atribuído na TAG XML da NFe.
     *
     * @return the código que é atribuído na TAG XML da NFe
     */
    public String getXmlCode() {
      return xmlCode;
    }

    public static SefazXMLmodBC valueOfXmlCode(String xmlCode) {
      for (SefazXMLmodBC v : values())
        if (v.getXmlCode().equals(xmlCode)) return v;
      return null;
    }
  }

  /**
   * Enumeração da Modalidade de determinação da BC do ICMS ST.
   */
  public static enum SefazXMLmodBCST {
    FIXED_SHEET("0"), LIST_NEGATIVE("1"), LIST_POSITIVE("2"), LIST_NEUTRAL("3"), MVA("4"), PAUTA("5");

    /**
     * Código que é atribuído na TAG XML da NFe.
     */
    private final String xmlCode;

    SefazXMLmodBCST(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * # código que é atribuído na TAG XML da NFe.
     *
     * @return the código que é atribuído na TAG XML da NFe
     */
    public String getXmlCode() {
      return xmlCode;
    }

    public static SefazXMLmodBCST valueOfXmlCode(String xmlCode) {
      for (SefazXMLmodBCST v : values())
        if (v.getXmlCode().equals(xmlCode)) return v;
      return null;
    }
  }

  /**
   * Define o motivo da desoneração do ICMS
   */
  public static enum SefazXMLmotDesICMS {
    /**
     * Define o motivo da desoneração por: 1 - Táxi
     */
    TAXI("1"),
    /**
     * Define o motivo da desoneração por: 2 - Deficiente<br>
     * Desde a versão 3.1 esse motivo não pode mais ser utilizado, deve ser especificado o 10 {@link #DEFICIENT_NOTCONDUCTOR} ou 11 {@link #DEFICIENT_NOTCONDUCTOR}.
     */
    DEFICIENT("2"),
    /**
     * Define o motivo da desoneração por: 3 - Uso na agropecuária
     */
    AGROPECUARIA("3"),
    /**
     * Define o motivo da desoneração por: 4 - Frotista/Locadora
     */
    FLEETOWNER("4"),
    /**
     * Define o motivo da desoneração por: 5 - Diplomático/Consular
     */
    DIPLOMATIC("5"),
    /**
     * Define o motivo de desoneração por: 6 - Utilitários e Motocicletas da Amazônia Ocidental e Áreas de Livre Comércio (Resolução 714/88 e 790/94 – CONTRAN e suas alterações)
     */
    UTILITARIOSLIVRECOMERCIO("6"),
    /**
     * Define o motivo de desoneração por: 7 - SUFRAM
     */
    SUFRAM("7"),
    /**
     * Define o motivo de desoneração por: 8 - Venda a Órgão Público
     */
    ORGAOPULICO("8"),
    /**
     * Define o motivo da desoneração por: 9 - Outros
     */
    OTHERS("9"),
    /**
     * Define o motivo da desoneração por: 10 - Deficiente condutor (Convênio ICMS 38/12)
     */
    DEFICIENT_CONDUCTOR("10"),
    /**
     * Define o motivo da desoneração por: 11 - Deficiente NÃO condutor (Convênio ICMS 38/12)
     */
    DEFICIENT_NOTCONDUCTOR("11"),
    /**
     * Define o motivo da desoneração por: 12 - Órgão de fomento e desenvolvimento agropecuário
     */
    ORGAODEFOMENTO("12");

    /**
     * Código que é atribuído na TAG XML da NFe
     */
    private final String xmlCode;

    SefazXMLmotDesICMS(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * # código que é atribuído na TAG XML da NFe.
     *
     * @return the código que é atribuído na TAG XML da NFe
     */
    public String getXmlCode() {
      return xmlCode;
    }

    public static SefazXMLmotDesICMS valueOfXmlCode(String xmlCode) {
      for (SefazXMLmotDesICMS v : values())
        if (v.getXmlCode().equals(xmlCode)) return v;
      return null;
    }
  }

  /**
   * Modalidade do Frete.
   */
  public static enum SefazXMLmodFrete {

    /** Frete Contratado Pelo Emitente da NFe. */
    BYEMITTER("0"),

    /** Frete Contratado Pelo Destinatário da Nota. */
    BYRECIPIENT("1"),

    /** Frete Contratado Por terceiros. */
    BYOTHERS("2"),
    /**
     * Transporte Próprio por conta do Remetente.
     */
    OWNFREIGHTAGE_BYEMITTER("3"),
    /**
     * Transporte Próprio por conta do Destinatário.
     */
    OWNFREIGHTAGE_BYRECIPIENT("4"),

    /** Sem Frete. */
    NO_FREIGHTAGE("9");

    /**
     * Código de identificação do modelo do documento. (Catálogo utilizado na NFe.)
     */
    final String xmlCode;

    SefazXMLmodFrete(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * # código de identificação do modelo do documento. (Catálogo utilizado na NFe.).
     *
     * @return # código de identificação do modelo do documento
     */
    public String getXmlCode() {
      return xmlCode;
    }

    public static SefazXMLmodFrete valueOfXmlCode(String xmlCode) {
      for (SefazXMLmodFrete v : values())
        if (v.getXmlCode().equals(xmlCode)) return v;
      return null;
    }
  }
}
