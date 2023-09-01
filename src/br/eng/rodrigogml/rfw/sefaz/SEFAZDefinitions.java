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
   * Define o ambiente em que a classe SESFAZWS vai trabalhar.<br>
   */
  public static enum SefazEnvironment {
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

  // /**
  // * Enum que representa os servidores de comunica��o da SEFAZ.<br>
  // * <li>Cada estado e DF cont�m o c�digo do IBGE usado no XML;</li><br>
  // */
  // public static enum SefazServer {
  // AC("12"), AL("27"), AP("16"), AM("13"), BA("29"), CE("23"), DF("53"), ES("32"), GO("52"), MA("21"), MG("31"), MS("50"), MT("51"), PA("15"), PB("25"), PE("26"), PI("22"), PR("41"), RJ("33"), RN("24"), RO("11"), RR("14"), RS("43"), SC("42"), SE("28"), SP("35"), TO("17"),
  // /**
  // * Sigla do "Ambiente Nacional", c�digo 91<br>
  // * C�digo especial utilizado para alguns casos espec�ficos.
  // */
  // AN("91");
  //
  // private String ibgeCode = "";
  //
  // SefazServer(String value) {
  // this.ibgeCode = value;
  // }
  //
  // /**
  // * Gets the IBGE code.
  // *
  // * @return the IBGE code
  // */
  // public String getIBGECode() {
  // return this.ibgeCode;
  // }
  //
  // /**
  // * Recupera a Sigla do estado brasileiro de acordo com o c�digo do IBGE utilizado no XML, ou {@link #AN} para ambienda nacional (utilizado em casos especiais).
  // *
  // * @param ibgeCode
  // * @return
  // */
  // public static SefazServer valueFromIBGECode(String ibgeCode) {
  // for (int i = 0; i < SefazServer.values().length; i++)
  // if (ibgeCode.equalsIgnoreCase(SefazServer.values()[i].getIBGECode())) return SefazServer.values()[i];
  // return null;
  // }
  //
  // /**
  // * Gets the acronym.
  // *
  // * @return the acronym
  // */
  // public String getAcronym() {
  // // Como as enumera��es tem o nome do acronym, s� chamamos o .toString(). Mas este m�todo existe para que n�o chamemos o .toString() em v�rios lugares diferentes do c�digo
  // return toString();
  // }
  // }

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

}
