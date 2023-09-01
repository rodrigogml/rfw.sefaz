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

  // /**
  // * Enum que representa os servidores de comunicação da SEFAZ.<br>
  // * <li>Cada estado e DF contém o código do IBGE usado no XML;</li><br>
  // */
  // public static enum SefazServer {
  // AC("12"), AL("27"), AP("16"), AM("13"), BA("29"), CE("23"), DF("53"), ES("32"), GO("52"), MA("21"), MG("31"), MS("50"), MT("51"), PA("15"), PB("25"), PE("26"), PI("22"), PR("41"), RJ("33"), RN("24"), RO("11"), RR("14"), RS("43"), SC("42"), SE("28"), SP("35"), TO("17"),
  // /**
  // * Sigla do "Ambiente Nacional", código 91<br>
  // * Código especial utilizado para alguns casos específicos.
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
  // * Recupera a Sigla do estado brasileiro de acordo com o código do IBGE utilizado no XML, ou {@link #AN} para ambienda nacional (utilizado em casos especiais).
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
  // // Como as enumerações tem o nome do acronym, só chamamos o .toString(). Mas este método existe para que não chamemos o .toString() em vários lugares diferentes do código
  // return toString();
  // }
  // }

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

}
