package br.eng.rodrigogml.rfw.sefaz.utils;

/**
 * Classe utilitária que concentra as Enums SEFAZ utilizadas em VOs.
 * <p>
 * Todas as enums expõem:
 * <ul>
 * <li>{@link #getXMLData()} — valor exato gravado/lido no XML;</li>
 * <li>{@link #isDeprecated()} — indica obsolescência;</li>
 * <li>{@code valueOfXMLData(String)} — parser seguro do valor do XML.</li>
 * </ul>
 *
 * @author Rodrigo Leitão
 * @since (11 de nov. de 2025)
 */
public class SEFAZEnums {

  /**
   * Construtor privado para classe utilitária/estática
   */
  private SEFAZEnums() {
  }

  /**
   * Enumeration com as versões da NFe suportadas pelo módulo.
   */
  public enum SEFAZ_versao {
    VERSAO_4_00("4.00", false);

    /**
     * Valor exato gravado/lido no XML (campo tpEmis).
     */
    private final String xmlData;
    /**
     * Indica se o tipo está obsoleto/descontinuado para uso atual.
     */
    private final boolean deprecated;

    SEFAZ_versao(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /**
     * Recupera o valor a ser utilizado no XML (campo tpEmis) a partir da enumeration.
     *
     * @return String com o valor XML correspondente.
     */
    public String getXMLData() {
      return this.xmlData;
    }

    /**
     * Indica se o tipo está obsoleto e não deve ser utilizado nas emissões atuais.
     *
     * @return {@code true} se o tipo estiver obsoleto; {@code false} caso contrário.
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Interpreta o valor recebido do XML (campo versao) e retorna a enumeration correspondente.
     *
     * @param xmlValue Valor vindo do XML (por exemplo: "4.00").
     * @return Enumeration correspondente ao valor informado.
     * @throws IllegalArgumentException Caso o valor seja nulo/vazio ou não exista mapeamento.
     */
    public static SEFAZ_versao valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'versao' no XML não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'versao' no XML não pode ser vazio.");
      }
      for (SEFAZ_versao e : SEFAZ_versao.values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Valor XML desconhecido para 'versao': '" + xmlValue + "'.");
    }
  }

  /**
   * Código do Modelo do Documento Fiscal ({@code mod}) utilizado na NF-e.
   *
   * <p>
   * Valores possíveis conforme especificação (incluindo modelos usados em documentos referenciados):
   * <ul>
   * <li>{@code 55} = NF-e</li>
   * <li>{@code 65} = NFC-e</li>
   * <li>{@code 01} = NF modelo 1</li>
   * <li>{@code 02} = NF modelo 2</li>
   * <li>{@code 04} = NF de Produtor</li>
   * <li>{@code 2B} = Cupom Fiscal emitido por máquina registradora (não ECF)</li>
   * <li>{@code 2C} = Cupom Fiscal PDV</li>
   * <li>{@code 2D} = Cupom Fiscal emitido por ECF</li>
   * </ul>
   */
  public enum SEFAZ_mod {

    /** NF-e ({@code 55}). */
    NFE_MODELO_55("55", false),

    /** NFC-e ({@code 65}). */
    NFCE_MODELO_65("65", false),

    /** NF modelo 1 ({@code 01}). */
    NF_MODELO_01("01", false),

    /** NF modelo 2 ({@code 02}). */
    NF_MODELO_02("02", false),

    /** NF de Produtor ({@code 04}). */
    NF_PRODUTOR_04("04", false),

    /** Cupom Fiscal máquina registradora ({@code 2B}). */
    CUPOM_FISCAL_2B("2B", false),

    /** Cupom Fiscal PDV ({@code 2C}). */
    CUPOM_FISCAL_2C("2C", false),

    /** Cupom Fiscal emitido por ECF ({@code 2D}). */
    CUPOM_FISCAL_ECF_2D("2D", false);

    private final String xmlData;
    private final boolean deprecated;

    private SEFAZ_mod(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    public String getXMLData() {
      return this.xmlData;
    }

    public boolean isDeprecated() {
      return this.deprecated;
    }

    public static SEFAZ_mod valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'mod' não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'mod' não pode ser vazio.");
      }
      for (SEFAZ_mod e : values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Modelo de documento fiscal desconhecido para 'mod': '" + xmlValue + "'.");
    }
  }

  /**
   * Identificador de local de destino da operação ({@code idDest}) na NF-e.
   *
   * <p>
   * Valores possíveis:
   * <ul>
   * <li>{@code 1} = Operação interna</li>
   * <li>{@code 2} = Operação interestadual</li>
   * <li>{@code 3} = Operação com exterior</li>
   * </ul>
   */
  public enum SEFAZ_idDest {

    /** Operação interna ({@code 1}). */
    OPERACAO_INTERNA("1", false),

    /** Operação interestadual ({@code 2}). */
    OPERACAO_INTERESTADUAL("2", false),

    /** Operação com exterior ({@code 3}). */
    OPERACAO_EXTERIOR("3", false);

    private final String xmlData;
    private final boolean deprecated;

    private SEFAZ_idDest(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Retorna o valor esperado no XML para o campo {@code idDest}. */
    public String getXMLData() {
      return this.xmlData;
    }

    /** Indica se o código está obsoleto/descontinuado na especificação. */
    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Converte o valor textual do XML para a constante correspondente.
     *
     * @param xmlValue valor do campo {@code idDest} no XML
     * @return constante correspondente
     * @throws IllegalArgumentException se o valor for nulo, vazio ou não mapeado
     */
    public static SEFAZ_idDest valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'idDest' não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'idDest' não pode ser vazio.");
      }
      for (SEFAZ_idDest e : values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Identificador de destino da operação desconhecido para 'idDest': '" + xmlValue + "'.");
    }
  }

  /**
   * Tipo de operação ({@code tpNF}) na NF-e.
   *
   * <p>
   * Valores possíveis:
   * <ul>
   * <li>{@code 0} = Entrada</li>
   * <li>{@code 1} = Saída</li>
   * </ul>
   */
  public enum SEFAZ_tpNF {

    /** Operação de entrada ({@code 0}). */
    ENTRADA("0", false),

    /** Operação de saída ({@code 1}). */
    SAIDA("1", false);

    private final String xmlData;
    private final boolean deprecated;

    private SEFAZ_tpNF(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Retorna o valor esperado no XML para o campo {@code tpNF}. */
    public String getXMLData() {
      return this.xmlData;
    }

    /** Indica se o código está obsoleto/descontinuado na especificação. */
    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Converte o valor textual do XML para a constante correspondente.
     *
     * @param xmlValue valor do campo {@code tpNF} no XML
     * @return constante correspondente
     * @throws IllegalArgumentException se o valor for nulo, vazio ou não mapeado
     */
    public static SEFAZ_tpNF valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'tpNF' não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'tpNF' não pode ser vazio.");
      }
      for (SEFAZ_tpNF e : values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Tipo de operação desconhecido para 'tpNF': '" + xmlValue + "'.");
    }
  }

  /**
   * Formato de impressão do DANFE ({@code tpImp}) da NF-e.
   *
   * <p>
   * Valores possíveis:
   * <ul>
   * <li>{@code 0} = Sem geração de DANFE</li>
   * <li>{@code 1} = DANFE normal, Retrato</li>
   * <li>{@code 2} = DANFE normal, Paisagem</li>
   * <li>{@code 3} = DANFE Simplificado</li>
   * <li>{@code 4} = DANFE NFC-e</li>
   * <li>{@code 5} = DANFE NFC-e mensagem eletrônica</li>
   * </ul>
   */
  public enum SEFAZ_tpImp {

    /** Sem geração de DANFE ({@code 0}). */
    SEM_DANFE("0", false),

    /** DANFE normal em formato retrato ({@code 1}). */
    DANFE_NORMAL_RETRATO("1", false),

    /** DANFE normal em formato paisagem ({@code 2}). */
    DANFE_NORMAL_PAISAGEM("2", false),

    /** DANFE simplificado ({@code 3}). */
    DANFE_SIMPLIFICADO("3", false),

    /** DANFE específico da NFC-e ({@code 4}). */
    DANFE_NFCE("4", false),

    /** DANFE NFC-e em formato de mensagem eletrônica ({@code 5}). */
    DANFE_NFCE_MENSAGEM_ELETRONICA("5", false);

    private final String xmlData;
    private final boolean deprecated;

    private SEFAZ_tpImp(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Retorna o valor esperado no XML para o campo {@code tpImp}. */
    public String getXMLData() {
      return this.xmlData;
    }

    /** Indica se o código está obsoleto/descontinuado na especificação. */
    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Converte o valor textual do XML para a constante correspondente.
     *
     * @param xmlValue valor do campo {@code tpImp} no XML
     * @return constante correspondente
     * @throws IllegalArgumentException se o valor for nulo, vazio ou não mapeado
     */
    public static SEFAZ_tpImp valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'tpImp' não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'tpImp' não pode ser vazio.");
      }
      for (SEFAZ_tpImp e : values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Formato de impressão de DANFE desconhecido para 'tpImp': '" + xmlValue + "'.");
    }
  }

  /**
   * Tipo de emissão da NF-e ({@code tpEmis}).
   *
   * <p>
   * Valores possíveis:
   * <ul>
   * <li>{@code 1} = Emissão normal</li>
   * <li>{@code 2} = Contingência FS-IA</li>
   * <li>{@code 3} = Contingência SCAN</li>
   * <li>{@code 4} = Contingência EPEC</li>
   * <li>{@code 5} = Contingência FS-DA</li>
   * <li>{@code 6} = Contingência SVC-AN</li>
   * <li>{@code 7} = Contingência SVC-RS</li>
   * <li>{@code 9} = Contingência off-line NFC-e</li>
   * </ul>
   */
  public enum SEFAZ_tpEmis {

    /** Emissão normal da NF-e ({@code 1}). */
    EMISSAO_NORMAL("1", false),

    /** Emissão em contingência FS-IA ({@code 2}). */
    CONTINGENCIA_FS_IA("2", false),

    /** Emissão em contingência SCAN ({@code 3}). */
    CONTINGENCIA_SCAN("3", false),

    /** Emissão em contingência EPEC ({@code 4}). */
    CONTINGENCIA_EPEC("4", false),

    /** Emissão em contingência FS-DA ({@code 5}). */
    CONTINGENCIA_FS_DA("5", false),

    /** Emissão em contingência SVC-AN ({@code 6}). */
    CONTINGENCIA_SVC_AN("6", false),

    /** Emissão em contingência SVC-RS ({@code 7}). */
    CONTINGENCIA_SVC_RS("7", false),

    /** Emissão em contingência off-line NFC-e ({@code 9}). */
    CONTINGENCIA_OFFLINE_NFCE("9", false);

    private final String xmlData;
    private final boolean deprecated;

    private SEFAZ_tpEmis(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Retorna o valor esperado no XML para o campo {@code tpEmis}. */
    public String getXMLData() {
      return this.xmlData;
    }

    /** Indica se o código está obsoleto/descontinuado na especificação. */
    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Converte o valor textual do XML para a constante correspondente.
     *
     * @param xmlValue valor do campo {@code tpEmis} no XML
     * @return constante correspondente
     * @throws IllegalArgumentException se o valor for nulo, vazio ou não mapeado
     */
    public static SEFAZ_tpEmis valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'tpEmis' não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'tpEmis' não pode ser vazio.");
      }
      for (SEFAZ_tpEmis e : values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Tipo de emissão desconhecido para 'tpEmis': '" + xmlValue + "'.");
    }
  }

  /**
   * Identificação do ambiente de autorização da NF-e ({@code tpAmb}).
   *
   * <p>
   * Valores possíveis:
   * <ul>
   * <li>{@code 1} = Produção</li>
   * <li>{@code 2} = Homologação</li>
   * </ul>
   */
  public enum SEFAZ_tpAmb {

    /** Ambiente de produção ({@code 1}). */
    PRODUCAO("1", false),

    /** Ambiente de homologação ({@code 2}). */
    HOMOLOGACAO("2", false);

    private final String xmlData;
    private final boolean deprecated;

    private SEFAZ_tpAmb(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Retorna o valor esperado no XML para o campo {@code tpAmb}. */
    public String getXMLData() {
      return this.xmlData;
    }

    /** Indica se o código está obsoleto/descontinuado na especificação. */
    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Converte o valor textual do XML para a constante correspondente.
     *
     * @param xmlValue valor do campo {@code tpAmb} no XML
     * @return constante correspondente
     * @throws IllegalArgumentException se o valor for nulo, vazio ou não mapeado
     */
    public static SEFAZ_tpAmb valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'tpAmb' não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'tpAmb' não pode ser vazio.");
      }
      for (SEFAZ_tpAmb e : values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Ambiente de autorização desconhecido para 'tpAmb': '" + xmlValue + "'.");
    }
  }

  /**
   * Finalidade de emissão da NF-e ({@code finNFe}).
   *
   * <p>
   * Valores possíveis:
   * <ul>
   * <li>{@code 1} = NF-e normal</li>
   * <li>{@code 2} = NF-e complementar</li>
   * <li>{@code 3} = NF-e de ajuste</li>
   * <li>{@code 4} = Devolução de mercadoria</li>
   * </ul>
   */
  public enum SEFAZ_finNFe {

    /** NF-e normal ({@code 1}). */
    NFE_NORMAL("1", false),

    /** NF-e complementar ({@code 2}). */
    NFE_COMPLEMENTAR("2", false),

    /** NF-e de ajuste ({@code 3}). */
    NFE_AJUSTE("3", false),

    /** NF-e de devolução de mercadoria ({@code 4}). */
    DEVOLUCAO_MERCADORIA("4", false);

    private final String xmlData;
    private final boolean deprecated;

    private SEFAZ_finNFe(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Retorna o valor esperado no XML para o campo {@code finNFe}. */
    public String getXMLData() {
      return this.xmlData;
    }

    /** Indica se o código está obsoleto/descontinuado na especificação. */
    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Converte o valor textual do XML para a constante correspondente.
     *
     * @param xmlValue valor do campo {@code finNFe} no XML
     * @return constante correspondente
     * @throws IllegalArgumentException se o valor for nulo, vazio ou não mapeado
     */
    public static SEFAZ_finNFe valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'finNFe' não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'finNFe' não pode ser vazio.");
      }
      for (SEFAZ_finNFe e : values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Finalidade de emissão desconhecida para 'finNFe': '" + xmlValue + "'.");
    }
  }

  /**
   * Indicador de operação com consumidor final ({@code indFinal}).
   *
   * <p>
   * Valores possíveis:
   * <ul>
   * <li>{@code 0} = Normal</li>
   * <li>{@code 1} = Consumidor final</li>
   * </ul>
   */
  public enum SEFAZ_indFinal {

    /** Operação normal, não direcionada a consumidor final ({@code 0}). */
    OPERACAO_NORMAL("0", false),

    /** Operação destinada a consumidor final ({@code 1}). */
    CONSUMIDOR_FINAL("1", false);

    private final String xmlData;
    private final boolean deprecated;

    private SEFAZ_indFinal(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Retorna o valor esperado no XML para o campo {@code indFinal}. */
    public String getXMLData() {
      return this.xmlData;
    }

    /** Indica se o código está obsoleto/descontinuado na especificação. */
    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Converte o valor textual do XML para a constante correspondente.
     *
     * @param xmlValue valor do campo {@code indFinal} no XML
     * @return constante correspondente
     * @throws IllegalArgumentException se o valor for nulo, vazio ou não mapeado
     */
    public static SEFAZ_indFinal valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'indFinal' não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'indFinal' não pode ser vazio.");
      }
      for (SEFAZ_indFinal e : values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Indicador de consumidor final desconhecido para 'indFinal': '" + xmlValue + "'.");
    }
  }

  /**
   * Indicador de presença do comprador no estabelecimento comercial ({@code indPres}).
   *
   * <p>
   * Valores possíveis:
   * <ul>
   * <li>{@code 0} = Não se aplica</li>
   * <li>{@code 1} = Operação presencial</li>
   * <li>{@code 2} = Operação não presencial, internet</li>
   * <li>{@code 3} = Operação não presencial, teleatendimento</li>
   * <li>{@code 4} = Operação com entrega a domicílio</li>
   * <li>{@code 5} = Operação presencial, fora do estabelecimento</li>
   * <li>{@code 9} = Operação não presencial, outros</li>
   * </ul>
   */
  public enum SEFAZ_indPres {

    /** Situação em que o indicador de presença não se aplica ({@code 0}). */
    NAO_SE_APLICA("0", false),

    /** Operação presencial no estabelecimento ({@code 1}). */
    OPERACAO_PRESENCIAL("1", false),

    /** Operação não presencial realizada via internet ({@code 2}). */
    OPERACAO_NAO_PRESENCIAL_INTERNET("2", false),

    /** Operação não presencial realizada via teleatendimento ({@code 3}). */
    OPERACAO_NAO_PRESENCIAL_TELEATENDIMENTO("3", false),

    /** Operação com entrega a domicílio ({@code 4}). */
    OPERACAO_ENTREGA_DOMICILIO("4", false),

    /** Operação presencial realizada fora do estabelecimento ({@code 5}). */
    OPERACAO_PRESENCIAL_FORA_ESTABELECIMENTO("5", false),

    /** Operação não presencial em outras modalidades ({@code 9}). */
    OPERACAO_NAO_PRESENCIAL_OUTROS("9", false);

    private final String xmlData;
    private final boolean deprecated;

    private SEFAZ_indPres(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Retorna o valor esperado no XML para o campo {@code indPres}. */
    public String getXMLData() {
      return this.xmlData;
    }

    /** Indica se o código está obsoleto/descontinuado na especificação. */
    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Converte o valor textual do XML para a constante correspondente.
     *
     * @param xmlValue valor do campo {@code indPres} no XML
     * @return constante correspondente
     * @throws IllegalArgumentException se o valor for nulo, vazio ou não mapeado
     */
    public static SEFAZ_indPres valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'indPres' não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'indPres' não pode ser vazio.");
      }
      for (SEFAZ_indPres e : values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Indicador de presença desconhecido para 'indPres': '" + xmlValue + "'.");
    }
  }

  /**
   * Indicador de intermediador/marketplace ({@code indIntermed}).
   *
   * <p>
   * Valores possíveis:
   * <ul>
   * <li>{@code 0} = Operação sem intermediador</li>
   * <li>{@code 1} = Operação com plataforma de terceiros</li>
   * </ul>
   */
  public enum SEFAZ_indIntermed {

    /** Operação realizada sem intermediador ou marketplace ({@code 0}). */
    SEM_INTERMEDIADOR("0", false),

    /** Operação intermediada por plataforma de terceiros ({@code 1}). */
    PLATAFORMA_TERCEIROS("1", false);

    private final String xmlData;
    private final boolean deprecated;

    private SEFAZ_indIntermed(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Retorna o valor esperado no XML para o campo {@code indIntermed}. */
    public String getXMLData() {
      return this.xmlData;
    }

    /** Indica se o código está obsoleto/descontinuado na especificação. */
    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Converte o valor textual do XML para a constante correspondente.
     *
     * @param xmlValue valor do campo {@code indIntermed} no XML
     * @return constante correspondente
     * @throws IllegalArgumentException se o valor for nulo, vazio ou não mapeado
     */
    public static SEFAZ_indIntermed valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'indIntermed' não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'indIntermed' não pode ser vazio.");
      }
      for (SEFAZ_indIntermed e : values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Indicador de intermediador desconhecido para 'indIntermed': '" + xmlValue + "'.");
    }
  }

  /**
   * Processo de emissão da NF-e ({@code procEmi}).
   *
   * <p>
   * Valores possíveis:
   * <ul>
   * <li>{@code 0} = Emissão pelo contribuinte</li>
   * <li>{@code 1} = Emissão avulsa pelo Fisco</li>
   * <li>{@code 2} = Emissão avulsa com certificado digital pelo contribuinte</li>
   * <li>{@code 3} = Emissão pelo aplicativo do Fisco</li>
   * </ul>
   */
  public enum SEFAZ_procEmi {

    /** Emissão da NF-e diretamente pelo contribuinte ({@code 0}). */
    EMISSAO_CONTRIBUINTE("0", false),

    /** Emissão avulsa realizada pelo Fisco ({@code 1}). */
    EMISSAO_AVULSA_FISCO("1", false),

    /** Emissão avulsa com certificado digital pelo contribuinte ({@code 2}). */
    EMISSAO_AVULSA_CERTIFICADO_CONTRIBUINTE("2", false),

    /** Emissão por aplicativo fornecido pelo Fisco ({@code 3}). */
    EMISSAO_APLICATIVO_FISCO("3", false);

    private final String xmlData;
    private final boolean deprecated;

    private SEFAZ_procEmi(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Retorna o valor esperado no XML para o campo {@code procEmi}. */
    public String getXMLData() {
      return this.xmlData;
    }

    /** Indica se o código está obsoleto/descontinuado na especificação. */
    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Converte o valor textual do XML para a constante correspondente.
     *
     * @param xmlValue valor do campo {@code procEmi} no XML
     * @return constante correspondente
     * @throws IllegalArgumentException se o valor for nulo, vazio ou não mapeado
     */
    public static SEFAZ_procEmi valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'procEmi' não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'procEmi' não pode ser vazio.");
      }
      for (SEFAZ_procEmi e : values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Processo de emissão desconhecido para 'procEmi': '" + xmlValue + "'.");
    }
  }

  /**
   * Enumeration do Código de Regime Tributário (CRT) utilizado no XML da NFe.
   *
   * Valores conforme a especificação do campo CRT: 1 = Simples Nacional 2 = Simples Nacional, excesso sublimite de receita bruta 3 = Regime Normal
   */
  public enum SEFAZ_CRT {

    /**
     * 1 = Simples Nacional.
     */
    SIMPLES_NACIONAL("1", false),

    /**
     * 2 = Simples Nacional, excesso sublimite de receita bruta.
     */
    SIMPLES_NACIONAL_EXCESSO_SUBLIMITE("2", false),

    /**
     * 3 = Regime Normal.
     */
    REGIME_NORMAL("3", false);

    /** Valor exato gravado/lido no XML (campo CRT). */
    private final String xmlData;

    /** Indica se o tipo está obsoleto/descontinuado para uso atual. */
    private final boolean deprecated;

    SEFAZ_CRT(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /**
     * Retorna o valor utilizado no XML (campo CRT).
     */
    public String getXMLData() {
      return this.xmlData;
    }

    /**
     * Indica se o tipo está obsoleto.
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Converte o valor do XML para a enum correspondente.
     *
     * @param xmlValue Valor do XML (ex.: "1", "2", "3").
     * @return Enum correspondente.
     * @throws IllegalArgumentException Se for nulo, vazio ou desconhecido.
     */
    public static SEFAZ_CRT valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'CRT' no XML não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'CRT' no XML não pode ser vazio.");
      }
      for (SEFAZ_CRT e : SEFAZ_CRT.values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Valor XML desconhecido para 'CRT': '" + xmlValue + "'.");
    }
  }

  /**
   * Enumeration do Indicador da IE do Destinatário (indIEDest) utilizado no XML da NFe.
   *
   * Valores conforme especificação: 1 = Contribuinte ICMS 2 = Contribuinte isento de Inscrição no cadastro de Contribuintes 9 = Não Contribuinte
   */
  public enum IndIEDestEnum {

    /**
     * 1 = Contribuinte ICMS.
     */
    CONTRIBUINTE_ICMS("1", false),

    /**
     * 2 = Contribuinte isento de Inscrição.
     */
    CONTRIBUINTE_ISENTO("2", false),

    /**
     * 9 = Não Contribuinte.
     */
    NAO_CONTRIBUINTE("9", false);

    /** Valor exato gravado/lido no XML (campo indIEDest). */
    private final String xmlData;

    /** Indica se o tipo está obsoleto/descontinuado para uso atual. */
    private final boolean deprecated;

    IndIEDestEnum(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /**
     * Retorna o valor utilizado no XML (campo indIEDest).
     */
    public String getXMLData() {
      return this.xmlData;
    }

    /**
     * Indica se o tipo está obsoleto.
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Converte o valor do XML para a enum correspondente.
     *
     * @param xmlValue Valor do XML (ex.: "1", "2", "9").
     * @return Enum correspondente.
     * @throws IllegalArgumentException Se for nulo, vazio ou desconhecido.
     */
    public static IndIEDestEnum valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'indIEDest' no XML não pode ser nulo.");
      }

      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'indIEDest' no XML não pode ser vazio.");
      }

      for (IndIEDestEnum e : IndIEDestEnum.values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }

      throw new IllegalArgumentException("Valor XML desconhecido para 'indIEDest': '" + xmlValue + "'.");
    }
  }

  /**
   * Enumeration do Indicador se o valor do item compõe o total da NF-e (indTot) utilizado no XML da NFe.
   *
   * Valores conforme especificação do campo indTot: 0 = não compõe; 1 = compõe.
   */
  public enum SEFAZ_indTot {

    /**
     * 0 = não compõe o total da NF-e.
     */
    NAO_COMPOE_TOTAL("0", false),

    /**
     * 1 = compõe o total da NF-e.
     */
    COMPOE_TOTAL("1", false);

    /** Valor exato gravado/lido no XML (campo indTot). */
    private final String xmlData;

    /** Indica se o tipo está obsoleto/descontinuado para uso atual. */
    private final boolean deprecated;

    SEFAZ_indTot(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /**
     * Retorna o valor utilizado no XML (campo indTot).
     */
    public String getXMLData() {
      return this.xmlData;
    }

    /**
     * Indica se o tipo está obsoleto.
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Converte o valor do XML para a enum correspondente.
     *
     * @param xmlValue Valor do XML (ex.: "0", "1").
     * @return Enum correspondente.
     * @throws IllegalArgumentException Se for nulo, vazio ou desconhecido.
     */
    public static SEFAZ_indTot valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'indTot' no XML não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'indTot' no XML não pode ser vazio.");
      }
      for (SEFAZ_indTot e : SEFAZ_indTot.values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Valor XML desconhecido para 'indTot': '" + xmlValue + "'.");
    }
  }

  /**
   * Enumeration da Origem da mercadoria (orig) utilizada no XML da NFe.
   *
   * Utilizada nos grupos de ICMS (ex.: ICMS00, ICMS10).
   *
   * Valores conforme a especificação do campo orig: 0 – Nacional, exceto as indicadas nos códigos 3, 4, 5 e 8; 1 – Estrangeira – Importação direta, exceto a indicada no código 6; 2 – Estrangeira – Adquirida no mercado interno, exceto a indicada no código 7; 3 – Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% e inferior ou igual a 70%; 4 – Nacional, cuja produção tenha sido
   * feita em conformidade com os processos produtivos básicos (PPB) previstos na legislação aplicável; 5 – Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40%; 6 – Estrangeira – Importação direta, sem similar nacional, constante em lista da CAMEX (inclui gás natural); 7 – Estrangeira – Adquirida no mercado interno, sem similar nacional, constante em lista CAMEX (inclui
   * gás natural); 8 – Nacional, mercadoria ou bem com Conteúdo de Importação superior a 70%.
   */
  public enum SEFAZ_orig {

    /** 0 – Nacional, exceto as indicadas nos códigos 3, 4, 5 e 8. */
    NACIONAL_EXCETO_3_4_5_8("0", false),

    /** 1 – Estrangeira – Importação direta, exceto a indicada no código 6. */
    ESTRANGEIRA_IMPORTACAO_DIRETA_EXCETO_6("1", false),

    /** 2 – Estrangeira – Adquirida no mercado interno, exceto a indicada no código 7. */
    ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO_EXCETO_7("2", false),

    /** 3 – Nacional, mercadoria ou bem com Conteúdo de Importação > 40% e <= 70%. */
    NACIONAL_CONTEUDO_IMPORTACAO_MAIOR_40_MENOR_IGUAL_70("3", false),

    /** 4 – Nacional, produção em conformidade com processos produtivos básicos (PPB). */
    NACIONAL_PROCESSO_PRODUTIVO_PPB("4", false),

    /** 5 – Nacional, mercadoria ou bem com Conteúdo de Importação <= 40%. */
    NACIONAL_CONTEUDO_IMPORTACAO_MENOR_IGUAL_40("5", false),

    /**
     * 6 – Estrangeira – Importação direta, sem similar nacional, constante em lista da CAMEX (inclui gás natural).
     */
    ESTRANGEIRA_IMPORTACAO_DIRETA_SEM_SIMILAR_CAMEX_GAS("6", false),

    /**
     * 7 – Estrangeira – Adquirida no mercado interno, sem similar nacional, constante em lista CAMEX (inclui gás natural).
     */
    ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO_SEM_SIMILAR_CAMEX_GAS("7", false),

    /** 8 – Nacional, mercadoria ou bem com Conteúdo de Importação > 70%. */
    NACIONAL_CONTEUDO_IMPORTACAO_MAIOR_70("8", false);

    /** Valor exato gravado/lido no XML (campo orig). */
    private final String xmlData;

    /** Indica se o tipo está obsoleto/descontinuado para uso atual. */
    private final boolean deprecated;

    SEFAZ_orig(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Retorna o valor utilizado no XML (campo orig). */
    public String getXMLData() {
      return this.xmlData;
    }

    /** Indica se o tipo está obsoleto. */
    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Converte o valor do XML para a enum correspondente.
     *
     * @param xmlValue Valor do XML (ex.: "0" a "8").
     * @return Enum correspondente.
     * @throws IllegalArgumentException Se for nulo, vazio ou desconhecido.
     */
    public static SEFAZ_orig valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'orig' no XML não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'orig' no XML não pode ser vazio.");
      }
      for (SEFAZ_orig e : SEFAZ_orig.values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Valor XML desconhecido para 'orig': '" + xmlValue + "'.");
    }
  }

  /**
   * Enumeration da Modalidade de determinação da BC do ICMS (modBC) utilizada no XML da NFe.
   *
   * Valores conforme especificação do campo modBC: 0 = Margem Valor Agregado (MVA %); 1 = Pauta (valor); 2 = Preço tabelado máximo (valor); 3 = Valor da operação.
   */
  public enum SEFAZ_modBC {

    /** 0 = Margem Valor Agregado (MVA %). */
    MARGEM_VALOR_AGREGADO("0", false),

    /** 1 = Pauta (valor). */
    PAUTA_VALOR("1", false),

    /** 2 = Preço tabelado máximo (valor). */
    PRECO_TABELADO_MAX("2", false),

    /** 3 = Valor da operação. */
    VALOR_OPERACAO("3", false);

    /** Valor exato gravado/lido no XML (campo modBC). */
    private final String xmlData;

    /** Indica se o tipo está obsoleto/descontinuado para uso atual. */
    private final boolean deprecated;

    SEFAZ_modBC(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Retorna o valor utilizado no XML (campo modBC). */
    public String getXMLData() {
      return this.xmlData;
    }

    /** Indica se o tipo está obsoleto. */
    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Converte o valor do XML para a enum correspondente.
     *
     * @param xmlValue Valor do XML (ex.: "0", "1", "2", "3").
     * @return Enum correspondente.
     * @throws IllegalArgumentException Se for nulo, vazio ou desconhecido.
     */
    public static SEFAZ_modBC valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'modBC' no XML não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'modBC' no XML não pode ser vazio.");
      }
      for (SEFAZ_modBC e : SEFAZ_modBC.values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Valor XML desconhecido para 'modBC': '" + xmlValue + "'.");
    }
  }

  /**
   * Enumeration da Tributação do ICMS (CST) utilizada no XML da NFe.
   *
   * Contemplando (até o momento): 00 – Tributado integralmente (ICMS00); 10 – Tributado e com cobrança do ICMS por substituição tributária (ICMS10); 20 – Com redução da base de cálculo (ICMS20); 30 – Isenta ou não tributada e com cobrança do ICMS por substituição tributária (ICMS30); 40 – Isenta (ICMS40); 41 – Não tributada (ICMS40); 50 – Suspensão (ICMS40); 51 – Diferimento (ICMS51); 60 – ICMS
   * cobrado anteriormente por substituição tributária (ICMS60); 70 – Com redução de base de cálculo e cobrança do ICMS por substituição tributária (ICMS70); 90 – Outros (ICMS90).
   */
  public enum SEFAZ_CST_ICMS {

    /** 00 – Tributado integralmente (ICMS00). */
    CST_00_TRIBUTADO_INTEGRALMENTE("00", false),

    /** 10 – Tributado e com cobrança do ICMS por substituição tributária (ICMS10). */
    CST_10_TRIBUTADO_COM_ICMS_ST("10", false),

    /** 20 – Com redução da base de cálculo (ICMS20). */
    CST_20_REDUCAO_BASE_CALCULO("20", false),

    /** 30 – Isenta ou não tributada e com cobrança do ICMS por substituição tributária (ICMS30). */
    CST_30_ISENTA_OU_NAO_TRIBUTADA_COM_ST("30", false),

    /** 40 – Isenta (ICMS40). */
    CST_40_ISENTA("40", false),

    /** 41 – Não tributada (ICMS40). */
    CST_41_NAO_TRIBUTADA("41", false),

    /** 50 – Suspensão (ICMS40). */
    CST_50_SUSPENSAO("50", false),

    /** 51 – Diferimento (ICMS51). */
    CST_51_DIFERIMENTO("51", false),

    /** 60 – ICMS cobrado anteriormente por substituição tributária (ICMS60). */
    CST_60_COBRADO_ANTERIOR_ST("60", false),

    /** 70 – Com redução de BC e cobrança de ICMS ST (ICMS70). */
    CST_70_REDUCAO_BC_COM_ST("70", false),

    /** 90 – Outros (ICMS90). */
    CST_90_OUTROS("90", false);

    /** Valor exato gravado/lido no XML (campo CST). */
    private final String xmlData;

    /** Indica se o tipo está obsoleto/descontinuado para uso atual. */
    private final boolean deprecated;

    SEFAZ_CST_ICMS(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Retorna o valor utilizado no XML (campo CST). */
    public String getXMLData() {
      return this.xmlData;
    }

    /** Indica se o tipo está obsoleto. */
    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Converte o valor do XML para a enum correspondente.
     *
     * @param xmlValue Valor do XML (ex.: "00", "10", "20", "30", "40", "41", "50", "51", "60", "70", "90").
     * @return Enum correspondente.
     * @throws IllegalArgumentException Se for nulo, vazio ou desconhecido.
     */
    public static SEFAZ_CST_ICMS valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'CST' no XML não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'CST' no XML não pode ser vazio.");
      }
      for (SEFAZ_CST_ICMS e : SEFAZ_CST_ICMS.values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Valor XML desconhecido para 'CST': '" + xmlValue + "'.");
    }
  }

  /**
   * Enumeration da Modalidade de determinação da BC do ICMS ST (modBCST) utilizada no XML da NFe.
   *
   * Valores conforme especificação do campo modBCST: 0 = Preço tabelado ou máximo sugerido; 1 = Lista Negativa (valor); 2 = Lista Positiva (valor); 3 = Lista Neutra (valor); 4 = Margem Valor Agregado (%); 5 = Pauta (Valor); 6 = Valor da Operação (NT 2019.001).
   */
  public enum SEFAZ_modBCST {

    /** 0 = Preço tabelado ou máximo sugerido. */
    PRECO_TABELADO_MAX_SUGERIDO("0", false),

    /** 1 = Lista Negativa (valor). */
    LISTA_NEGATIVA_VALOR("1", false),

    /** 2 = Lista Positiva (valor). */
    LISTA_POSITIVA_VALOR("2", false),

    /** 3 = Lista Neutra (valor). */
    LISTA_NEUTRA_VALOR("3", false),

    /** 4 = Margem Valor Agregado (%). */
    MARGEM_VALOR_AGREGADO("4", false),

    /** 5 = Pauta (Valor). */
    PAUTA_VALOR("5", false),

    /** 6 = Valor da Operação (NT 2019.001). */
    VALOR_OPERACAO("6", false);

    /** Valor exato gravado/lido no XML (campo modBCST). */
    private final String xmlData;

    /** Indica se o tipo está obsoleto/descontinuado para uso atual. */
    private final boolean deprecated;

    SEFAZ_modBCST(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Retorna o valor utilizado no XML (campo modBCST). */
    public String getXMLData() {
      return this.xmlData;
    }

    /** Indica se o tipo está obsoleto. */
    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Converte o valor do XML para a enum correspondente.
     *
     * @param xmlValue Valor do XML (ex.: "0" a "6").
     * @return Enum correspondente.
     * @throws IllegalArgumentException Se for nulo, vazio ou desconhecido.
     */
    public static SEFAZ_modBCST valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'modBCST' no XML não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'modBCST' no XML não pode ser vazio.");
      }
      for (SEFAZ_modBCST e : SEFAZ_modBCST.values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Valor XML desconhecido para 'modBCST': '" + xmlValue + "'.");
    }
  }

  /**
   * Enumeration do Motivo da desoneração do ICMS (motDesICMS) utilizado no XML da NFe.
   *
   * Valores conforme especificações (ICMS20, ICMS30, ICMS40): 1 – Táxi 3 – Uso na agropecuária / Produtor Agropecuário 4 – Frotista/locadora 5 – Diplomático/consular 6 – Utilitários e motocicletas da Amazônia Ocidental e Áreas de Livre Comércio 7 – SUFRAMA 8 – Venda a órgãos públicos 9 – Outros 10 – Deficiente Condutor 11 – Deficiente Não Condutor 12 – Órgão de fomento e desenvolvimento
   * agropecuário 16 – Olimpíadas Rio 2016 90 – Solicitado pelo Fisco
   *
   * Observação: motivo 2 (Deficiente Físico) foi revogado e não é utilizado.
   */
  public enum SEFAZ_motDesICMS {

    /** 1 – Táxi. */
    TAXI("1", false),

    /** 3 – Uso na agropecuária / Produtor Agropecuário. */
    USO_AGROPECUARIA("3", false),

    /** 4 – Frotista/locadora. */
    FROTISTA_LOCADORA("4", false),

    /** 5 – Diplomático/consular. */
    DIPLOMATICO_CONSULAR("5", false),

    /**
     * 6 – Utilitários/motocicletas da Amazônia Ocidental e Áreas de Livre Comércio ou Produtor Primário (conforme grupo ICMS da NF-e).
     */
    UTILITARIOS_MOTOS_AMAZONIA_ALC("6", false),

    /** 7 – SUFRAMA. */
    SUFRAMA("7", false),

    /** 8 – Venda a órgãos públicos. */
    VENDA_ORGAOS_PUBLICOS("8", false),

    /** 9 – Outros. */
    OUTROS("9", false),

    /** 10 – Deficiente Condutor. */
    DEFICIENTE_CONDUTOR("10", false),

    /** 11 – Deficiente Não Condutor. */
    DEFICIENTE_NAO_CONDUTOR("11", false),

    /** 12 – Órgão de fomento e desenvolvimento agropecuário. */
    ORGAO_FOMENTO_DESENVOLVIMENTO_AGROPECUARIO("12", false),

    /** 16 – Olimpíadas Rio 2016. */
    OLIMPIADAS_RIO_2016("16", false),

    /** 90 – Solicitado pelo Fisco. */
    SOLICITADO_PELO_FISCO("90", false);

    /** Valor exato gravado/lido no XML (campo motDesICMS). */
    private final String xmlData;

    /** Indica se o tipo está obsoleto/descontinuado para uso atual. */
    private final boolean deprecated;

    SEFAZ_motDesICMS(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Retorna o valor utilizado no XML (campo motDesICMS). */
    public String getXMLData() {
      return this.xmlData;
    }

    /** Indica se o tipo está obsoleto. */
    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Converte o valor do XML para a enum correspondente.
     *
     * @param xmlValue Valor do XML (ex.: "1", "3", "4", ..., "16", "90").
     * @return Enum correspondente.
     * @throws IllegalArgumentException Se for nulo, vazio ou desconhecido.
     */
    public static SEFAZ_motDesICMS valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'motDesICMS' no XML não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'motDesICMS' no XML não pode ser vazio.");
      }
      for (SEFAZ_motDesICMS e : SEFAZ_motDesICMS.values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Valor XML desconhecido para 'motDesICMS': '" + xmlValue + "'.");
    }
  }

  /**
   * Enumeration do Código de Situação da Operação – Simples Nacional (CSOSN) utilizado no XML da NF-e.
   *
   * Contempla até o momento: 101 – Tributada com permissão de crédito; 102 – Tributada sem permissão de crédito; 103 – Isenção do ICMS no Simples Nacional para faixa de receita bruta; 201 – Tributada com permissão de crédito e com ICMS ST; 202 – Tributada sem permissão de crédito e com ICMS ST; 203 – Isenção do ICMS no Simples Nacional para faixa de receita bruta e com ICMS ST; 300 – Imune; 400 –
   * Não tributada pelo Simples Nacional; 500 – ICMS cobrado anteriormente por substituição tributária ou por antecipação; 900 – Outros (Simples Nacional).
   */
  public enum SEFAZ_CSOSN {

    /** 101 – Tributada pelo Simples Nacional com permissão de crédito. */
    CSOSN_101_TRIBUTADA_COM_PERMISSAO_CREDITO("101", false),

    /** 102 – Tributada pelo Simples Nacional sem permissão de crédito. */
    CSOSN_102_TRIBUTADA_SEM_CREDITO("102", false),

    /** 103 – Isenção do ICMS no Simples Nacional para faixa de receita bruta. */
    CSOSN_103_ISENCAO_FAIXA_RECEITA("103", false),

    /** 201 – Tributada pelo Simples Nacional com permissão de crédito e com ICMS ST. */
    CSOSN_201_TRIBUTADA_COM_CREDITO_E_ST("201", false),

    /** 202 – Tributada pelo Simples Nacional sem permissão de crédito e com ICMS ST. */
    CSOSN_202_TRIBUTADA_SEM_CREDITO_COM_ST("202", false),

    /** 203 – Isenção do ICMS no Simples Nacional para faixa de receita bruta e com ICMS ST. */
    CSOSN_203_ISENCAO_FAIXA_RECEITA_COM_ST("203", false),

    /** 300 – Imune. */
    CSOSN_300_IMUNE("300", false),

    /** 400 – Não tributada pelo Simples Nacional. */
    CSOSN_400_NAO_TRIBUTADA("400", false),

    /** 500 – ICMS cobrado anteriormente por substituição tributária ou por antecipação. */
    CSOSN_500_ST_OU_ANTECIPACAO("500", false),

    /** 900 – Outros (Simples Nacional). */
    CSOSN_900_OUTROS("900", false);

    /** Valor exato gravado/lido no XML (campo CSOSN). */
    private final String xmlData;

    /** Indica se o tipo está obsoleto/descontinuado para uso atual. */
    private final boolean deprecated;

    SEFAZ_CSOSN(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Retorna o valor utilizado no XML (campo CSOSN). */
    public String getXMLData() {
      return this.xmlData;
    }

    /** Indica se o tipo está obsoleto. */
    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Converte o valor do XML para a enum correspondente.
     *
     * @param xmlValue Valor do XML (ex.: "101", "102", "103", "201", "202", "203", "300", "400", "500", "900").
     * @return Enum correspondente.
     * @throws IllegalArgumentException Se for nulo, vazio ou desconhecido.
     */
    public static SEFAZ_CSOSN valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'CSOSN' no XML não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'CSOSN' no XML não pode ser vazio.");
      }
      for (SEFAZ_CSOSN e : SEFAZ_CSOSN.values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Valor XML desconhecido para 'CSOSN': '" + xmlValue + "'.");
    }
  }

}