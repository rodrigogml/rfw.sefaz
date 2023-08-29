package br.eng.rodrigogml.rfw.sefaz.utils;

import java.io.Serializable;

/**
 * Description: Classe est�tica apenas para declara��o das enumerations de valores da Sefaz / NFe para converter os valores e c�digos da SEFAZ em enums para melhorar a programabilidade do sistema.<br>
 *
 * @author Rodrigo GML
 * @since 10.0.0 (28 de ago. de 2023)
 * @version 10.0.0 - Rodrigo GML-(...)
 */
public class SEFAZEnums implements Serializable {

  private static final long serialVersionUID = 8861266746208095396L;

  /**
   * Construtor privado para evitar instancializa��o
   */
  private SEFAZEnums() {
  }

  /**
   * Define o Regime Tribut�rio da empresa para qual a regra se aplica.<br>
   * Utilizado nas Tags:<br>
   * <li>nfe\infNFe\emit\CRT
   */
  public static enum SefazCRT {
    SIMPLESNACIONAL("1"), SIMPLESNACIONAL_EXCESSOSUBLIME("2"), REGIMENORMAL("3");

    /**
     * C�digo do XML para esta enumeration.
     */
    final String xmlCode;

    SefazCRT(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * # c�digo do XML para esta enumeration.
     *
     * @return # c�digo do XML para esta enumeration
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
    public static SefazCRT valueOfXmlCode(String xmlCode) {
      for (SefazCRT v : values())
        if (v.getXmlCode() != null && v.getXmlCode().equals(xmlCode)) return v;
      return null;
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
  public static enum SefazUF {
    AC("12"), AL("27"), AP("16"), AM("13"), BA("29"), CE("23"), DF("53"), ES("32"), GO("52"), MA("21"), MG("31"), MS("50"), MT("51"), PA("15"), PB("25"), PE("26"), PI("22"), PR("41"), RJ("33"), RN("24"), RO("11"), RR("14"), RS("43"), SC("42"), SE("28"), SP("35"), TO("17"),
    /**
     * Utilizado na Tag ICMSPart\UFST para indicar para qual estado � devido o ICMSST no caso de Exterior.
     */
    EX(null);

    /**
     * C�digo da UF pelo IBGE.
     */
    private String ibgeCode = "";

    SefazUF(String value) {
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
    public static SefazUF valueOfIBGECode(String ibgeCode) {
      for (int i = 0; i < SefazUF.values().length; i++)
        if (ibgeCode.equalsIgnoreCase(SefazUF.values()[i].getIBGECode())) return SefazUF.values()[i];
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
    public SefazUF[] valuesUFOnly() {
      return new SefazUF[] {
          SefazUF.AC, SefazUF.AL, SefazUF.AP, SefazUF.AM, SefazUF.BA, SefazUF.CE, SefazUF.DF, SefazUF.ES, SefazUF.GO, SefazUF.MA, SefazUF.MG, SefazUF.MS, SefazUF.MT, SefazUF.PA, SefazUF.PB, SefazUF.PE, SefazUF.PI, SefazUF.PR, SefazUF.RJ, SefazUF.RN, SefazUF.RO, SefazUF.RR, SefazUF.RS, SefazUF.SC, SefazUF.SE, SefazUF.SP, SefazUF.TO
      };
    }
  }

  /**
   * Enum que define o tipo da Opera��o da NFe conforme definido pela SEFAZ entre notas de entrada ou sa�da. De acordo com o fluxo da marcadoria no fluxo do emitente da NF.
   */
  public static enum SefazTipoOperacao {
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
    SefazTipoOperacao(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * Value of xml code.
     *
     * @param xmlCode the xml code
     * @return the NF type
     */
    public static SefazTipoOperacao valueOfXmlCode(String xmlCode) {
      for (SefazTipoOperacao v : values())
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
   * Define a finalidade da emiss�o da nota: Normal, Complementar, devolu��o, etc.<Br>
   * <br>
   * Usado em:
   * <li>
   *
   */
  public static enum SefazFinalidadeEmissao {

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
    SefazFinalidadeEmissao(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * Value of xml code.
     *
     * @param xmlCode the xml code
     * @return the NF emission goal
     */
    public static SefazFinalidadeEmissao valueOfXmlCode(String xmlCode) {
      for (SefazFinalidadeEmissao v : values())
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
   * Define o tipo de opera��o desta NF.
   */
  public enum SefazDestinoDaOperacao {
    /**
     * Opera��o interna (ao estado).
     */
    INTERNAL("1"),

    /** Opera��o Interestadual. */
    INTERSTATE("2"),

    /** Opera��o com o exterior. */
    FOREIGN("3");

    /** The xml code. */
    final String xmlCode;

    /**
     * Instantiates a new NF emission goal.
     *
     * @param xmlCode the xml code
     */
    SefazDestinoDaOperacao(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * Value of xml code.
     *
     * @param xmlCode the xml code
     * @return the NF emission goal
     */
    public static SefazDestinoDaOperacao valueOfXmlCode(String xmlCode) {
      for (SefazDestinoDaOperacao v : values())
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

  public enum SefazTipoDeAtendimento {
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

    /** Opera��o presencial, fora do estabelecimento; NT2016.002. */
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
    SefazTipoDeAtendimento(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * Value of xml code.
     *
     * @param xmlCode the xml code
     * @return the NF attendance type
     */
    public static SefazTipoDeAtendimento valueOfXmlCode(String xmlCode) {
      for (SefazTipoDeAtendimento v : values())
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
   * Define o Status da manifesta��o do destinat�rio com a SEFAZ.
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
   * Modelos de Notas Fiscais.
   */
  public static enum SefazNFModel {
    /**
     * Modelo de Notas Fiscais de tal�o.
     */
    MODEL01(null),
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
    SefazNFModel(String xmlCode) {
      this.xmlCode = xmlCode;
    }

    /**
     * Value of xml code.
     *
     * @param xmlCode the xml code
     * @return the NF model
     */
    public static SefazNFModel valueOfXmlCode(String xmlCode) {
      for (SefazNFModel v : values())
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

}
