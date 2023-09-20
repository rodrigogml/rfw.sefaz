package br.eng.rodrigogml.rfw.sefaz;

import br.eng.rodrigogml.rfw.kernel.RFW;

/**
 * Description: Classe de defini��es do m�dulo. Apresenta funcionalidade similar a CLasse {@link RFW} do m�dulo principal.<br>
 *
 * @author Rodrigo GML
 * @since 10.0 (29 de out de 2020)
 */
public class SEFAZDefinitions {

  // Ambientes de Produ��o
  public static final String SP_PRODUCTION_V4_00_CADCONSULTACADASTRO4 = "https://nfe.fazenda.sp.gov.br/ws/cadconsultacadastro4.asmx";
  public static final String SP_PRODUCTION_V4_00_NFEAUTORIZACAO4 = "https://nfe.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao4.asmx";
  public static final String SP_PRODUCTION_V4_00_NFERETAUTORIZACAO4 = "https://nfe.fazenda.sp.gov.br/ws/nferetautorizacao4.asmx";

  // Ambientes de Homologa��o
  public static final String SP_TEST_V4_00_CADCONSULTACADASTRO4 = "https://homologacao.nfe.fazenda.sp.gov.br/ws/cadconsultacadastro4.asmx";
  public static final String SP_TEST_V4_00_NFEAUTORIZACAO4 = "https://homologacao.nfe.fazenda.sp.gov.br/ws/NFeAutorizacao4.asmx";
  public static final String SP_TEST_V4_00_NFERETAUTORIZACAO4 = "https://homologacao.nfe.fazenda.sp.gov.br/ws/nferetautorizacao4.asmx";

  /**
   * Construtor privado para classe totalmente est�tica.
   */
  private SEFAZDefinitions() {
  }

  /**
   * Define o Status poss�veis da manifesta��o do destinat�rio com a SEFAZ.<br>
   * N�o � utilizada no XML, mas representa todos os estados poss�vels.
   */
  public static enum SefazRecipientManifestation {
    /**
     * Indica que nenhuma minisfesta��o foi dada ao SEFAZ.
     */
    NONE,
    /**
     * Indica que o documento foi sinalizado na SEFAZ como "Conhecimento da Emiss�o".
     */
    EMISSION_KNOWLEDGE,
    /**
     * Infica que a opera��o foi sinalizada como n�o realizada. Por devolu��o ou qualquer outro motivo.
     */
    UNFINISHED,
    /**
     * Indica que a manifesta��o foi feita indicando a conclus�o da opera��o.
     */
    FINISHED,
    /**
     * Indica que a nota � desconhecida pela empresa. Ou seja, a empresa n�o tem conhecimento desta opera��o.
     */
    UNKNOW
  }

  /**
   * Define os tipos de conting�ncias que o sistema pode adotar.<br>
   * Esta enumeration � utilizada no momento de cria��o do Objeto SEFAZ para indicar o ambiente de conting�ncia.
   */
  public static enum SefazContingency {
    /**
     * Define o uso da conting�ncia SVC (SEFAZ Virtual de Conting�ncia). Pode ser usado apenas para NFe.
     */
    SVC,
    /**
     * Define a conting�ncia em Evento Pr�vio de Emiss�o em Conting�ncia.
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
     * Modelo de Notas Fiscais de tal�o.<br>
     * Este modelo n�o por ser emitido de forma eletr�nica, mas pode ser referenciado por notas eletr�nicas.
     */
    MODEL01("01"),
    /**
     * Este modelo foi inclu�do na (inclu�do na NT2016.002).<br>
     * Modelo de Notas Fiscais de tal�o.<br>
     * Este modelo n�o por ser emitido de forma eletr�nica, mas pode ser referenciado por notas eletr�nicas.
     */
    MODEL02("02"),
    /**
     * Modelo de Notas Fiscais de Produtor.<br>
     * Este modelo n�o por ser emitido de forma eletr�nica, mas pode ser referenciado por notas eletr�nicas.
     */
    MODEL04("04"),
    /**
     * Modelo de Cupom Fiscal emitido por m�quina registradora (n�o ECF).<br>
     * Este modelo n�o por ser emitido de forma eletr�nica, mas pode ser referenciado por notas eletr�nicas.
     */
    MODEL2B("2B"),
    /**
     * Modelo de Cupom Fiscal PDV.<br>
     * Este modelo n�o por ser emitido de forma eletr�nica, mas pode ser referenciado por notas eletr�nicas.
     */
    MODEL2C("2C"),
    /**
     * Modelo de Cupom Fiscal (Emitido por ECF).<br>
     * Este modelo n�o por ser emitido de forma eletr�nica, mas pode ser referenciado por notas eletr�nicas.
     */
    MODEL2D("2D"),
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
    SefazXMLmod(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * Recupera o item da Enumeration de acordo com o c�digo no XML.
     *
     * @param xmlCode Valor encontrado no XML
     * @return Item da enumera��o encontrato, null caso o valor n�o seja encontrado.
     */
    public static SefazXMLmod valueOfXmlCode(String xmlCode) {
      for (SefazXMLmod v : values())
        if (v.getXmlCode() != null && v.getXmlCode().equals(xmlCode)) return v;
      return null;
    }

    /**
     * # c�digo de identifica��o do modelo do documento. (Cat�logo utilizado na NFe.).
     *
     * @return # c�digo de identifica��o do modelo do documento
     */
    public String getXmlCode() {
      return xmlCode;
    }

    /**
     * Retorna os valores atualmente v�lidos, n�o retorna os valores que foram removidos da vers�o mais atual.<br>
     *
     * @return valores aceitos na tag nfe\infNFe\ide\mod.
     */
    public SefazXMLmod[] values_nfe_infNFe_ide_mod() {
      return new SefazXMLmod[] { MODEL55, MODEL65 };
    }

    /**
     * Retorna os valores atualmente v�lidos, n�o retorna os valores que foram removidos da vers�o mais atual.<br>
     *
     * @return valores aceitos na tag nfe\infNFe\ide\refECF\mod.
     */
    public SefazXMLmod[] values_nfe_infNFe_ide_NFref_refECF_mod() {
      return new SefazXMLmod[] { MODEL2B, MODEL2C, MODEL2D };
    }

    /**
     * Retorna os valores atualmente v�lidos, n�o retorna os valores que foram removidos da vers�o mais atual.<br>
     *
     * @return valores aceitos na tag nfe\infNFe\ide\NFref\mod.
     */
    public SefazXMLmod[] values_nfe_infNFe_ide_NFref_refNFP_mod() {
      return new SefazXMLmod[] { MODEL01, MODEL04 };
    }

    /**
     * Retorna os valores atualmente v�lidos, n�o retorna os valores que foram removidos da vers�o mais atual.<br>
     *
     * @return valores aceitos na tag nfe\infNFe\ide\NFref\mod.
     */
    public SefazXMLmod[] values_nfe_infNFe_ide_NFref_refNF_mod() {
      return new SefazXMLmod[] { MODEL01, MODEL02 };
    }

  }

  /**
   * Define o Regime Tribut�rio da empresa para qual a regra se aplica.<br>
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
     * C�digo de identifica��o do modelo do documento. (Cat�logo utilizado na NFe.)
     */
    private final String xmlCode;

    SefazXMLCRT(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * # c�digo de identifica��o do modelo do documento. (Cat�logo utilizado na NFe.).
     *
     * @return # c�digo de identifica��o do modelo do documento
     */
    public String getXmlCode() {
      return xmlCode;
    }

    /**
     * Recupera o item da Enumeration de acordo com o c�digo no XML.
     *
     * @param xmlCode Valor encontrado no XML
     * @return Item da enumera��o encontrato, null caso o valor n�o seja encontrado.
     */
    public static SefazXMLCRT valueOfXmlCode(String xmlCode) {
      for (SefazXMLCRT v : values())
        if (v.getXmlCode() != null && v.getXmlCode().equals(xmlCode)) return v;
      return null;
    }
  }

  /**
   * Define a finalidade da emiss�o da nota: Normal, Complementar, devolu��o, etc.<Br>
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
     * Devolu��o de Mercadoria.
     */
    RETURNGOODS("4");

    /**
     * C�digo de identifica��o do modelo do documento. (Cat�logo utilizado na NFe.)
     */
    private final String xmlCode;

    SefazXMLfinNFe(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * Recupera o item da Enumeration de acordo com o c�digo no XML.
     *
     * @param xmlCode Valor encontrado no XML
     * @return Item da enumera��o encontrato, null caso o valor n�o seja encontrado.
     */
    public static SefazXMLfinNFe valueOfXmlCode(String xmlCode) {
      for (SefazXMLfinNFe v : values())
        if (v.getXmlCode().equals(xmlCode)) return v;
      return null;
    }

    /**
     * # c�digo de identifica��o do modelo do documento. (Cat�logo utilizado na NFe.).
     *
     * @return # c�digo de identifica��o do modelo do documento
     */
    public String getXmlCode() {
      return xmlCode;
    }
  }

  /**
   * Enum que define o tipo da Opera��o da NFe conforme definido pela SEFAZ entre notas de entrada ou sa�da.<br>
   * De acordo com o fluxo da marcadoria no fluxo do emitente da NF.<br>
   * Usado em:
   * <li>nfe\infNFe\ide\tpNF
   */
  public static enum SefazXMLtpNF {
    /**
     * Define que � uma nota de entrada de mercadorias em rela��o ao emitente da NFe.
     */
    ENTRY("0"),
    /**
     * Define que � uma nota de sa�da de mercadorias em rela��o ao emitente da NFe.
     */
    EXIT("1");

    /**
     * C�digo de identifica��o do modelo do documento. (Cat�logo utilizado na NFe.)
     */
    private final String xmlCode;

    SefazXMLtpNF(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * Recupera o item da Enumeration de acordo com o c�digo no XML.
     *
     * @param xmlCode Valor encontrado no XML
     * @return Item da enumera��o encontrato, null caso o valor n�o seja encontrado.
     */
    public static SefazXMLtpNF valueOfXmlCode(String xmlCode) {
      for (SefazXMLtpNF v : values())
        if (v.getXmlCode().equals(xmlCode)) return v;
      return null;
    }

    /**
     * # c�digo de identifica��o do modelo do documento. (Cat�logo utilizado na NFe.).
     *
     * @return # c�digo de identifica��o do modelo do documento
     */
    public String getXmlCode() {
      return xmlCode;
    }
  }

  /**
   * Enumeration com as UF e mais alguns c�digos extras que s�o aceitos em alguns campos de UF do XML da SEFAZ.<br>
   * Veja detalhes de onde os c�digos adicionais s�o aceitos na documenta��o de cada Enum.<br>
   * <li>Cada estado e DF cont�m o c�digo do IBGE usado no XML;</li><br>
   *
   * <Br>
   * Usada nas Tags:
   * <li>ICMSPart\UFST
   */
  public static enum SefazXMLUF {
    AC("12"), AL("27"), AP("16"), AM("13"), BA("29"), CE("23"), DF("53"), ES("32"), GO("52"), MA("21"), MG("31"), MS("50"), MT("51"), PA("15"), PB("25"), PE("26"), PI("22"), PR("41"), RJ("33"), RN("24"), RO("11"), RR("14"), RS("43"), SC("42"), SE("28"), SP("35"), TO("17"),
    /**
     * Utilizado na Tag ICMSPart\UFST para indicar para qual estado � devido o ICMSST no caso de Exterior.
     */
    EX(null);

    /**
     * C�digo da UF pelo IBGE.
     */
    private String ibgeCode = "";

    SefazXMLUF(String value) {
      this.ibgeCode = value;
    }

    /**
     * C�digo da UF pelo IBGE.
     *
     * @return C�digo num�rico de 2 d�gitos.
     */
    public String getIBGECode() {
      return this.ibgeCode;
    }

    /**
     * Recupera a Sigla do estado brasileiro de acordo com o c�digo do IBGE passado.
     *
     * @param ibgeCode C�digo da UF ou DF, sempre em String com 2 d�gitos e zeros n�o significativos.
     * @return Enumeration do estado equivalente, ou null caso n�o seja reconhecido o c�digo.
     */
    public static SefazXMLUF valueOfIBGECode(String ibgeCode) {
      for (int i = 0; i < SefazXMLUF.values().length; i++)
        if (ibgeCode.equalsIgnoreCase(SefazXMLUF.values()[i].getIBGECode())) return SefazXMLUF.values()[i];
      return null;
    }

    /**
     * Acr�nimo da UF do Estado.
     *
     * @return Sigla que representa o estado.
     */
    public String getAcronym() {
      // Como as enumera��es tem o nome do acronym, s� chamamos o .toString(). Mas este m�todo existe para que n�o chamemos o .toString() em v�rios lugares diferentes do c�digo
      return toString();
    }

    /**
     * Mesmo que o m�todo {@link #values()}, mas contento apenas os valores do enumeraion que representam uma UF (Estados e DF).
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
     * Ambiente de teste de desenvolvimento e emiss�o de documentos. Sem valor juridico/fiscal.
     */
    TEST("2"),

    /**
     * Servidores do ambiente de produ��o. Ambiente com valor juridico/fiscal.<br>
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
     * # c�digo de identifica��o do modelo do documento. (Cat�logo utilizado na NFe.).
     *
     * @return # c�digo de identifica��o do modelo do documento
     */
    public String getXmlCode() {
      return xmlCode;
    }

    /**
     * Recupera o item da Enumeration de acordo com o c�digo no XML.
     *
     * @param xmlCode Valor encontrado no XML
     * @return Item da enumera��o encontrato, null caso o valor n�o seja encontrado.
     */
    public static SefazXMLtpAmb valueOfXmlCode(String xmlCode) {
      for (SefazXMLtpAmb env : SefazXMLtpAmb.values()) {
        if (env.getXmlCode().equals(xmlCode)) return env;
      }
      return null;
    }
  }

  /**
   * Indicador de presen�a do comprador no estabelecimento comercial no momento da opera��o.<br>
   * Utilizado em:<br>
   * <li>nfe\infNFe\ide\indPres
   */
  public enum SefazXMLindPres {
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
    /**
     * Opera��o presencial, fora do estabelecimento; NT2016.002.
     */
    PRESENTIAL_OUTSIDE("5"),
    /**
     * Outro tipo de atendimento.
     */
    OTHER("9");

    /**
     * C�digo de identifica��o do modelo do documento. (Cat�logo utilizado na NFe.)
     */
    private final String xmlCode;

    SefazXMLindPres(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * Recupera o item da Enumeration de acordo com o c�digo no XML.
     *
     * @param xmlCode Valor encontrado no XML
     * @return Item da enumera��o encontrato, null caso o valor n�o seja encontrado.
     */
    public static SefazXMLindPres valueOfXmlCode(String xmlCode) {
      for (SefazXMLindPres v : values())
        if (v.getXmlCode().equals(xmlCode)) return v;
      return null;
    }

    /**
     * # c�digo de identifica��o do modelo do documento. (Cat�logo utilizado na NFe.).
     *
     * @return # c�digo de identifica��o do modelo do documento
     */
    public String getXmlCode() {
      return xmlCode;
    }
  }

  /**
   * Define o tipo de opera��o desta NF. Utilizado em:<br>
   * <li>nfe\infNFe\ide\idDest
   */
  public enum SefazXMLidDest {
    /**
     * Opera��o interna (ao estado).
     */
    INTERNAL("1"),

    /**
     * Opera��o Interestadual.
     */
    INTERSTATE("2"),

    /**
     * Opera��o com o exterior.
     */
    FOREIGN("3");

    /**
     * C�digo de identifica��o do modelo do documento. (Cat�logo utilizado na NFe.)
     */
    private final String xmlCode;

    SefazXMLidDest(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * Recupera o item da Enumeration de acordo com o c�digo no XML.
     *
     * @param xmlCode Valor encontrado no XML
     * @return Item da enumera��o encontrato, null caso o valor n�o seja encontrado.
     */
    public static SefazXMLidDest valueOfXmlCode(String xmlCode) {
      for (SefazXMLidDest v : values())
        if (v.getXmlCode().equals(xmlCode)) return v;
      return null;
    }

    /**
     * # c�digo de identifica��o do modelo do documento. (Cat�logo utilizado na NFe.).
     *
     * @return # c�digo de identifica��o do modelo do documento
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
     * 0 - Produto de origem nacional, exceto as indicadas nos c�digos 3 a 5.
     */
    NATIONAL(true, "0"),
    /**
     * 1 - Produto de origem importada, sendo adiquirida diretamente por importa��o, exceto a indicada no c�digo 6.
     */
    IMPORTED_DIRECTED(false, "1"),
    /**
     * 2 - Produto de origem importada, sendo adiquirida no mercado interno, exceto a indicada no c�digo 7.
     */
    IMPORTED_INDIRECTED(false, "2"),
    /**
     * 3 - Nacional, mercadoria ou bem com Conte�do de Importa��o superior a 40% (quarenta por cento) e inferior ou igual a 70%.
     */
    NATIONAL_IMPORTEDCOMPOSED_MORETHAN40_LESSEQUALTHAN70(true, "3"),
    /**
     * 4 - Nacional, cuja produ��o tenha sido feita em conformidade com os processos produtivos b�sicos de que tratam o Decreto-Lei n� 288/67, e as Leis n�s 8.248/91, 8.387/91, 10.176/01 e 11 . 4 8 4 / 0 7
     */
    NATIONAL_BASICPRODUCTIONPROCESS(true, "4"),
    /**
     * 5 - Nacional, mercadoria ou bem com Conte�do de Importa��o superior a 40% (quarenta por cento).
     */
    NATIONAL_IMPORTEDCOMPOSED_LESSTHAN40(true, "5"),
    /**
     * 6 - Estrangeira - Importa��o direta, sem similar nacional, constante em lista de Resolu��o CAMEX.
     */
    IMPORTED_DIRECTED_NONATIONALSIMILAR(false, "6"),
    /**
     * 7 - Estrangeira - Adquirida no mercado interno, sem similar nacional, constante em lista de Resolu��o CAMEX�.
     */
    IMPORTED_INDIRECTED_NONATIONALSIMILAR(false, "7"),
    /**
     * 8 - Nacional, mercadoria ou bem com Conte�do de Importa��o superior a 70%;
     */
    NATIONAL_IMPORTEDCOMPOSED_MORETHAN70(true, "8");

    /**
     * Retorna se o item � nacional, ou n�o.
     */
    private final boolean national;

    /**
     * C�digo a ser utilizado no XML da NFe.
     */
    private final String xmlCode;

    /**
     * Instantiates a new item origin.
     *
     * @param national retorna se o item � nacional, ou n�o.
     * @param xmlCode c�digo a ser utilizado no XML da NFe.
     */
    SefazXMLorig(boolean national, String xmlCode) {
      this.national = national;
      this.xmlCode = xmlCode;
    }

    /**
     * # retorna se o item � nacional, ou n�o.
     *
     * @return the retorna se o item � nacional, ou n�o
     */
    public boolean isNational() {
      return this.national;
    }

    /**
     * # c�digo a ser utilizado no XML da NFe.
     *
     * @return the c�digo a ser utilizado no XML da NFe
     */
    public String getXmlCode() {
      return xmlCode;
    }

    /**
     * Retorna o ITEMORIGIN correspondente ao c�digo.
     *
     * @param xmlCode passar apenas o c�digo referente a origem do item, n�o incluir o c�digo de tributa��o do ICMS.
     * @return {@link SefazXMLorig} com base no c�digo do XML.
     */
    public static SefazXMLorig valueOfXmlCode(String xmlCode) {
      for (SefazXMLorig v : values())
        if (v.getXmlCode().equals(xmlCode))
          return v;
      return null;
    }
  }

  /**
   * Defini��es dos c�digos de CST que podem ser utilizados para preenchimento de documento fiscal.
   */
  public static enum SefazXMLCST {
    /**
     * Tributada integralmente
     */
    ICMS_CST_00("00", false, false, false),
    /**
     * Tributada e com cobran�a do ICMS por substitui��o tribut�ria
     */
    ICMS_CST_10("10", false, true, false),
    /**
     * Com redu��o de base de c�lculo
     */
    ICMS_CST_20("20", false, false, true),
    /**
     * Isenta ou n�o tributada e com cobran�a do ICMS por substitui��o tribut�ria
     */
    ICMS_CST_30("30", false, true, false),
    /**
     * Isenta
     */
    ICMS_CST_40("40", false, false, false),
    /**
     * N�o tributada
     */
    ICMS_CST_41("41", false, false, false),
    /**
     * Suspens�o
     */
    ICMS_CST_50("50", false, false, false),
    /**
     * Diferimento
     */
    ICMS_CST_51("51", false, false, false),
    /**
     * ICMS cobrado anteriormente por substitui��o tribut�ria
     */
    ICMS_CST_60("60", false, true, false),
    /**
     * Com redu��o de base de c�lculo e cobran�a do ICMS por substitui��o tribut�ria
     */
    ICMS_CST_70("70", false, true, true),
    /**
     * Outras
     */
    ICMS_CST_90("90", false, false, false),

    ICMS_CSOSN_101("101", true, false, false), ICMS_CSOSN_102("102", true, false, false), ICMS_CSOSN_103("103", true, false, false), ICMS_CSOSN_201("201", true, true, false), ICMS_CSOSN_202("202", true, true, false), ICMS_CSOSN_203("203", true, true, false), ICMS_CSOSN_300("300", true, false, false), ICMS_CSOSN_400("400", true, false, false), ICMS_CSOSN_500("500", true, true, false), ICMS_CSOSN_900("900", true, false, false);

    /**
     * C�digo da Situa��o Tribut�ria que representa o
     */
    private final String cst;
    /**
     * Indicador se o c�digo � do Simples Nacional (CSOSN)
     */
    private final boolean simplesNacional;
    /**
     * Indicador se o c�digo � referente a Substitui��o Tribut�ria de ICMS
     */
    private final boolean st;
    /**
     * Indicador se o c�digo � referente a Redu��o na Base de C�lculo.
     */
    private final boolean redBC;

    SefazXMLCST(String cst, boolean simplesNacional, boolean st, boolean redBC) {
      this.cst = cst;
      this.simplesNacional = simplesNacional;
      this.st = st;
      this.redBC = redBC;
    }

    /**
     * # indicador se o c�digo � referente a Substitui��o Tribut�ria de ICMS.
     *
     * @return # indicador se o c�digo � referente a Substitui��o Tribut�ria de ICMS
     */
    public boolean isSt() {
      return st;
    }

    /**
     * # indicador se o c�digo � referente a Redu��o na Base de C�lculo.
     *
     * @return # indicador se o c�digo � referente a Redu��o na Base de C�lculo
     */
    public boolean isRedBC() {
      return redBC;
    }

    /**
     * Recupera o ICMSCST pelo c�digo da tabela.
     *
     * @param cst c�digo da tabela a ser procurao. Ex: "00", "10", "30". Ou CSOSN: "101", "202", "500"
     * @return
     */
    public static SefazXMLCST valueOfCode(String cst) {
      for (int i = 0; i < SefazXMLCST.values().length; i++)
        if (SefazXMLCST.values()[i].getCst().equals(cst)) return SefazXMLCST.values()[i];
      return null;
    }

    /**
     * # c�digo da Situa��o Tribut�ria que representa o.
     *
     * @return # c�digo da Situa��o Tribut�ria que representa o
     */
    public String getCst() {
      return cst;
    }

    /**
     * # indicador se o c�digo � do Simples Nacional (CSOSN).
     *
     * @return # indicador se o c�digo � do Simples Nacional (CSOSN)
     */
    public boolean isSimplesNacional() {
      return simplesNacional;
    }
  }

  /**
   * Enumera��o da Modalidade de determina��o da BC do ICMS
   */
  public static enum SefazXMLmodBC {
    MVA("0"), PAUTA("1"), FIXED_SHEET("2"), OPERATION_VALUE("3");

    /**
     * C�digo que � atribu�do na TAG XML da NFe
     */
    String xmlCode;

    private SefazXMLmodBC(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * # c�digo que � atribu�do na TAG XML da NFe.
     *
     * @return the c�digo que � atribu�do na TAG XML da NFe
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
   * Enumera��o da Modalidade de determina��o da BC do ICMS ST.
   */
  public static enum SefazXMLmodBCST {
    FIXED_SHEET("0"), LIST_NEGATIVE("1"), LIST_POSITIVE("2"), LIST_NEUTRAL("3"), MVA("4"), PAUTA("5");

    /**
     * C�digo que � atribu�do na TAG XML da NFe.
     */
    private final String xmlCode;

    SefazXMLmodBCST(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * # c�digo que � atribu�do na TAG XML da NFe.
     *
     * @return the c�digo que � atribu�do na TAG XML da NFe
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
   * Define o motivo da desonera��o do ICMS
   */
  public static enum SefazXMLmotDesICMS {
    /**
     * Define o motivo da desonera��o por: 1 - T�xi
     */
    TAXI("1"),
    /**
     * Define o motivo da desonera��o por: 2 - Deficiente<br>
     * Desde a vers�o 3.1 esse motivo n�o pode mais ser utilizado, deve ser especificado o 10 {@link #DEFICIENT_NOTCONDUCTOR} ou 11 {@link #DEFICIENT_NOTCONDUCTOR}.
     */
    DEFICIENT("2"),
    /**
     * Define o motivo da desonera��o por: 3 - Uso na agropecu�ria
     */
    AGROPECUARIA("3"),
    /**
     * Define o motivo da desonera��o por: 4 - Frotista/Locadora
     */
    FLEETOWNER("4"),
    /**
     * Define o motivo da desonera��o por: 5 - Diplom�tico/Consular
     */
    DIPLOMATIC("5"),
    /**
     * Define o motivo de desonera��o por: 6 - Utilit�rios e Motocicletas da Amaz�nia Ocidental e �reas de Livre Com�rcio (Resolu��o 714/88 e 790/94 � CONTRAN e suas altera��es)
     */
    UTILITARIOSLIVRECOMERCIO("6"),
    /**
     * Define o motivo de desonera��o por: 7 - SUFRAM
     */
    SUFRAM("7"),
    /**
     * Define o motivo de desonera��o por: 8 - Venda a �rg�o P�blico
     */
    ORGAOPULICO("8"),
    /**
     * Define o motivo da desonera��o por: 9 - Outros
     */
    OTHERS("9"),
    /**
     * Define o motivo da desonera��o por: 10 - Deficiente condutor (Conv�nio ICMS 38/12)
     */
    DEFICIENT_CONDUCTOR("10"),
    /**
     * Define o motivo da desonera��o por: 11 - Deficiente N�O condutor (Conv�nio ICMS 38/12)
     */
    DEFICIENT_NOTCONDUCTOR("11"),
    /**
     * Define o motivo da desonera��o por: 12 - �rg�o de fomento e desenvolvimento agropecu�rio
     */
    ORGAODEFOMENTO("12");

    /**
     * C�digo que � atribu�do na TAG XML da NFe
     */
    private final String xmlCode;

    SefazXMLmotDesICMS(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * # c�digo que � atribu�do na TAG XML da NFe.
     *
     * @return the c�digo que � atribu�do na TAG XML da NFe
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

    /** Frete Contratado Pelo Destinat�rio da Nota. */
    BYRECIPIENT("1"),

    /** Frete Contratado Por terceiros. */
    BYOTHERS("2"),
    /**
     * Transporte Pr�prio por conta do Remetente.
     */
    OWNFREIGHTAGE_BYEMITTER("3"),
    /**
     * Transporte Pr�prio por conta do Destinat�rio.
     */
    OWNFREIGHTAGE_BYRECIPIENT("4"),

    /** Sem Frete. */
    NO_FREIGHTAGE("9");

    /**
     * C�digo de identifica��o do modelo do documento. (Cat�logo utilizado na NFe.)
     */
    final String xmlCode;

    SefazXMLmodFrete(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * # c�digo de identifica��o do modelo do documento. (Cat�logo utilizado na NFe.).
     *
     * @return # c�digo de identifica��o do modelo do documento
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
