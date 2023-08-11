package br.eng.rodrigogml.rfw.sefaz;

import br.eng.rodrigogml.rfw.kernel.RFW;

/**
 * Description: Classe de definições do módulo. Apresenta funcionalidade similar a CLasse {@link RFW} do módulo principal.<br>
 *
 * @author Rodrigo GML
 * @since 10.0 (29 de out de 2020)
 */
public class SEFAZDefinitions {

  /**
   * Construtor privado para classe totalmente estática.
   */
  private SEFAZDefinitions() {
  }

  /**
   * Define o ambiente em que a classe SESFAZWS vai trabalhar.<br>
   */
  public static enum SefazEnvironment {
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

    SefazEnvironment(String value) {
      this.xmlCode = value;
    }

    /**
     * Recupera o valor a ser utilizado no XML da NFe.
     *
     * @return the valor a ser utilizado no XML da NFe
     */
    public String getXmlCode() {
      return xmlCode;
    }

    public static SefazEnvironment valueOfXmlCode(String xmlCode) {
      for (SefazEnvironment env : SefazEnvironment.values()) {
        if (env.getXmlCode().equals(xmlCode)) return env;
      }
      return null;
    }
  }

  /**
   * Define o Status da manifestação do destinatário com a SEFAZ.
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
   * Estados e DF para comunicação com o WS. Também incluí códigos para os ambientes auxíliares e contingência.<br>
   * <li>Cada estado e DF contém o código do distrito usado no XML;</li><br>
   * <li>Cada estado incluí também o endereço que o consumidor utilizará para consultar sua NFCe.
   */
  public static enum CUF {
    AC("12", null), AL("27", null), AP("16", null), AM("13", null), BA("29", null), CE("23", null), DF("53", null), ES("32", null), GO("52", null), MA("21", null), MG("31", null), MS("50", null), MT("51", null), PA("15", null), PB("25", null), PE("26", null), PI("22", null), PR("41", null), RJ("33", null), RN("24", null), RO("11", null), RR("14", null), RS("43", null), SC("42", null), SE("28", null), SP("35", "www.nfce.fazenda.sp.gov.br"), TO("17", null), AN("91", null);

    private String ibgeCode = "";
    private String checkurl = "";

    CUF(String value, String checkurl) {
      this.ibgeCode = value;
      this.checkurl = checkurl;
    }

    /**
     * Gets the IBGE code.
     *
     * @return the IBGE code
     */
    public String getIBGECode() {
      return this.ibgeCode;
    }

    /**
     * Gets the check URL.
     *
     * @return the check URL
     */
    public String getCheckURL() {
      return checkurl;
    }

    public static CUF valueOfIBGECode(String ibgeCode) {
      for (int i = 0; i < CUF.values().length; i++)
        if (ibgeCode.equalsIgnoreCase(CUF.values()[i].getIBGECode())) return CUF.values()[i];
      return null;
    }

    /**
     * Gets the acronym.
     *
     * @return the acronym
     */
    public String getAcronym() {
      // Como as enumerações tem o nome do acronym, só chamamos o .toString(). Mas este método existe para que não chamemos o .toString() em vários lugares diferentes do código
      return toString();
    }
  }

  /**
   * Define o Regime Tributário da empresa para qual a regra se aplica.<br>
   */
  public static enum SefazTaxSystem {
    SIMPLESNACIONAL, SIMPLESNACIONAL_EXCESSOSUBLIME, LUCROPRESUMIDO, LUCROREAL
  }
}
