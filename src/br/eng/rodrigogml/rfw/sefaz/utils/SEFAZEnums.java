package br.eng.rodrigogml.rfw.sefaz.utils;

/**
 * Classe utilitária que concentra as Enums SEFAZ utilizadas em VOs.
 * <p>
 * Todas as enums expõem:
 * <ul>
 * <li>{@link #getXmlData()} — valor exato gravado/lido no XML;</li>
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
   * Contrato comum de todas as enums SEFAZ para facilitar a serializacao entre VO e XML.
   *
   * @param <T> tipo concreto da enumeracao.
   */
  public interface SEFAZEnum<T extends Enum<T> & SEFAZEnum<T>> {

    /**
     * Retorna o valor textual exatamente como deve aparecer no XML.
     *
     * @return representacao textual oficial do campo.
     */
    String getXmlData();

    /**
     * Converte o valor textual proveniente do XML na instancia concreta da enum.
     *
     * @param xmlData valor obtido do XML.
     * @return enum correspondente ao texto informado.
     */
    @SuppressWarnings("unchecked")
    default T valueOfXMLData(String xmlData) {
      Class<T> enumType = (Class<T>) ((Enum<?>) this).getDeclaringClass();
      return resolveEnumValue(xmlData, enumType);
    }
  }

  /**
   * Parser generico que permite resolver o valor de qualquer enum que implemente {@link SEFAZEnum} a partir do texto XML.
   *
   * @param <E> tipo concreto da enumeracao.
   * @param enumType classe da enum.
   * @param xmlValue valor textual proveniente do XML.
   * @return enum correspondente ao valor informado.
   */
  public static <E extends Enum<E> & SEFAZEnum<E>> E valueOfXMLData(Class<E> enumType, String xmlValue) {
    return resolveEnumValue(xmlValue, enumType);
  }

  private static <E extends Enum<E> & SEFAZEnum<E>> E resolveEnumValue(String xmlValue, Class<E> enumType) {
    if (enumType == null) {
      throw new IllegalArgumentException("O tipo da enumeracao SEFAZ nao pode ser nulo.");
    }
    if (xmlValue == null) {
      throw new IllegalArgumentException("O valor XML para '" + enumType.getSimpleName() + "' nao pode ser nulo.");
    }
    final String value = xmlValue.trim();
    if (value.isEmpty()) {
      throw new IllegalArgumentException("O valor XML para '" + enumType.getSimpleName() + "' nao pode ser vazio.");
    }
    for (E constant : enumType.getEnumConstants()) {
      if (constant.getXmlData().equals(value)) {
        return constant;
      }
    }
    throw new IllegalArgumentException("Valor XML desconhecido para '" + enumType.getSimpleName() + "': '" + xmlValue + "'.");
  }

  /**
   * Enumeration com as versões da NFe suportadas pelo módulo.
   */
  public enum SEFAZ_versao implements SEFAZEnum<SEFAZ_versao> {
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
    @Override
    public String getXmlData() {
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
  public enum SEFAZ_mod implements SEFAZEnum<SEFAZ_mod> {

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

    /**
     * Gets the XML data.
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Checks if is deprecated.
     *
     * @return true, if is deprecated
     */
    public boolean isDeprecated() {
      return this.deprecated;
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
  public enum SEFAZ_idDest implements SEFAZEnum<SEFAZ_idDest> {

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

    /**
     * Retorna o valor esperado no XML para o campo {@code idDest}.
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o código está obsoleto/descontinuado na especificação.
     *
     * @return true, if is deprecated
     */
    public boolean isDeprecated() {
      return this.deprecated;
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
  public enum SEFAZ_tpNF implements SEFAZEnum<SEFAZ_tpNF> {

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

    /**
     * Retorna o valor esperado no XML para o campo {@code tpNF}.
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o código está obsoleto/descontinuado na especificação.
     *
     * @return true, if is deprecated
     */
    public boolean isDeprecated() {
      return this.deprecated;
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
  public enum SEFAZ_tpImp implements SEFAZEnum<SEFAZ_tpImp> {

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

    /**
     * Retorna o valor esperado no XML para o campo {@code tpImp}.
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o código está obsoleto/descontinuado na especificação.
     *
     * @return true, if is deprecated
     */
    public boolean isDeprecated() {
      return this.deprecated;
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
  public enum SEFAZ_tpEmis implements SEFAZEnum<SEFAZ_tpEmis> {

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

    /**
     * Retorna o valor esperado no XML para o campo {@code tpEmis}.
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o código está obsoleto/descontinuado na especificação.
     *
     * @return true, if is deprecated
     */
    public boolean isDeprecated() {
      return this.deprecated;
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
  public enum SEFAZ_tpAmb implements SEFAZEnum<SEFAZ_tpAmb> {

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

    /**
     * Retorna o valor esperado no XML para o campo {@code tpAmb}.
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o código está obsoleto/descontinuado na especificação.
     *
     * @return true, if is deprecated
     */
    public boolean isDeprecated() {
      return this.deprecated;
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
  public enum SEFAZ_finNFe implements SEFAZEnum<SEFAZ_finNFe> {

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

    /**
     * Retorna o valor esperado no XML para o campo {@code finNFe}.
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o código está obsoleto/descontinuado na especificação.
     *
     * @return true, if is deprecated
     */
    public boolean isDeprecated() {
      return this.deprecated;
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
  public enum SEFAZ_indFinal implements SEFAZEnum<SEFAZ_indFinal> {

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

    /**
     * Retorna o valor esperado no XML para o campo {@code indFinal}.
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o código está obsoleto/descontinuado na especificação.
     *
     * @return true, if is deprecated
     */
    public boolean isDeprecated() {
      return this.deprecated;
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
  public enum SEFAZ_indPres implements SEFAZEnum<SEFAZ_indPres> {

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

    /**
     * Retorna o valor esperado no XML para o campo {@code indPres}.
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o código está obsoleto/descontinuado na especificação.
     *
     * @return true, if is deprecated
     */
    public boolean isDeprecated() {
      return this.deprecated;
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
  public enum SEFAZ_indIntermed implements SEFAZEnum<SEFAZ_indIntermed> {

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

    /**
     * Retorna o valor esperado no XML para o campo {@code indIntermed}.
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o código está obsoleto/descontinuado na especificação.
     *
     * @return true, if is deprecated
     */
    public boolean isDeprecated() {
      return this.deprecated;
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
  public enum SEFAZ_procEmi implements SEFAZEnum<SEFAZ_procEmi> {

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

    /**
     * Retorna o valor esperado no XML para o campo {@code procEmi}.
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o código está obsoleto/descontinuado na especificação.
     *
     * @return true, if is deprecated
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

  }

  /**
   * Enumeration do Código de Regime Tributário (CRT) utilizado no XML da NFe.
   *
   * Valores conforme a especificação do campo CRT: 1 = Simples Nacional 2 = Simples Nacional, excesso sublimite de receita bruta 3 = Regime Normal
   */
  public enum SEFAZ_CRT implements SEFAZEnum<SEFAZ_CRT> {

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
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o tipo está obsoleto.
     *
     * @return the indica se o tipo está obsoleto/descontinuado para uso atual
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

  }

  /**
   * Enumeration do Indicador da IE do Destinatário (indIEDest) utilizado no XML da NFe.
   *
   * Valores conforme especificação: 1 = Contribuinte ICMS 2 = Contribuinte isento de Inscrição no cadastro de Contribuintes 9 = Não Contribuinte
   */
  public enum IndIEDestEnum implements SEFAZEnum<IndIEDestEnum> {

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
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o tipo está obsoleto.
     *
     * @return the indica se o tipo está obsoleto/descontinuado para uso atual
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

  }

  /**
   * Enumeration do Indicador se o valor do item compõe o total da NF-e (indTot) utilizado no XML da NFe.
   *
   * Valores conforme especificação do campo indTot: 0 = não compõe; 1 = compõe.
   */
  public enum SEFAZ_indTot implements SEFAZEnum<SEFAZ_indTot> {

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
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o tipo está obsoleto.
     *
     * @return the indica se o tipo está obsoleto/descontinuado para uso atual
     */
    public boolean isDeprecated() {
      return this.deprecated;
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
  public enum SEFAZ_orig implements SEFAZEnum<SEFAZ_orig> {

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

    /**
     * Retorna o valor utilizado no XML (campo orig).
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o tipo está obsoleto.
     *
     * @return the indica se o tipo está obsoleto/descontinuado para uso atual
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

  }

  /**
   * Enumeration da Modalidade de determinação da BC do ICMS (modBC) utilizada no XML da NFe.
   *
   * Valores conforme especificação do campo modBC: 0 = Margem Valor Agregado (MVA %); 1 = Pauta (valor); 2 = Preço tabelado máximo (valor); 3 = Valor da operação.
   */
  public enum SEFAZ_modBC implements SEFAZEnum<SEFAZ_modBC> {

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

    /**
     * Retorna o valor utilizado no XML (campo modBC).
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o tipo está obsoleto.
     *
     * @return the indica se o tipo está obsoleto/descontinuado para uso atual
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

  }

  /**
   * Enumeration da Tributação do ICMS (CST) utilizada no XML da NFe.
   *
   * Contemplando (até o momento): 00 – Tributado integralmente (ICMS00); 10 – Tributado e com cobrança do ICMS por substituição tributária (ICMS10); 20 – Com redução da base de cálculo (ICMS20); 30 – Isenta ou não tributada e com cobrança do ICMS por substituição tributária (ICMS30); 40 – Isenta (ICMS40); 41 – Não tributada (ICMS40); 50 – Suspensão (ICMS40); 51 – Diferimento (ICMS51); 60 – ICMS
   * cobrado anteriormente por substituição tributária (ICMS60); 70 – Com redução de base de cálculo e cobrança do ICMS por substituição tributária (ICMS70); 90 – Outros (ICMS90).
   */
  public enum SEFAZ_CST_ICMS implements SEFAZEnum<SEFAZ_CST_ICMS> {

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

    /**
     * Retorna o valor utilizado no XML (campo CST).
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o tipo está obsoleto.
     *
     * @return the indica se o tipo está obsoleto/descontinuado para uso atual
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

  }

  /**
   * Enumeration da Modalidade de determinação da BC do ICMS ST (modBCST) utilizada no XML da NFe.
   *
   * Valores conforme especificação do campo modBCST: 0 = Preço tabelado ou máximo sugerido; 1 = Lista Negativa (valor); 2 = Lista Positiva (valor); 3 = Lista Neutra (valor); 4 = Margem Valor Agregado (%); 5 = Pauta (Valor); 6 = Valor da Operação (NT 2019.001).
   */
  public enum SEFAZ_modBCST implements SEFAZEnum<SEFAZ_modBCST> {

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

    /**
     * Retorna o valor utilizado no XML (campo modBCST).
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o tipo está obsoleto.
     *
     * @return the indica se o tipo está obsoleto/descontinuado para uso atual
     */
    public boolean isDeprecated() {
      return this.deprecated;
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
  public enum SEFAZ_motDesICMS implements SEFAZEnum<SEFAZ_motDesICMS> {

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

    /**
     * Retorna o valor utilizado no XML (campo motDesICMS).
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o tipo está obsoleto.
     *
     * @return the indica se o tipo está obsoleto/descontinuado para uso atual
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

  }

  /**
   * Enumeration do Código de Situação da Operação – Simples Nacional (CSOSN) utilizado no XML da NF-e.
   *
   * Contempla até o momento: 101 – Tributada com permissão de crédito; 102 – Tributada sem permissão de crédito; 103 – Isenção do ICMS no Simples Nacional para faixa de receita bruta; 201 – Tributada com permissão de crédito e com ICMS ST; 202 – Tributada sem permissão de crédito e com ICMS ST; 203 – Isenção do ICMS no Simples Nacional para faixa de receita bruta e com ICMS ST; 300 – Imune; 400 –
   * Não tributada pelo Simples Nacional; 500 – ICMS cobrado anteriormente por substituição tributária ou por antecipação; 900 – Outros (Simples Nacional).
   */
  public enum SEFAZ_CSOSN implements SEFAZEnum<SEFAZ_CSOSN> {

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

    /**
     * Retorna o valor utilizado no XML (campo CSOSN).
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o tipo está obsoleto.
     *
     * @return the indica se o tipo está obsoleto/descontinuado para uso atual
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

  }

  /**
   * Enumeração da Tributação do IPI (CST) utilizada no XML da NF-e.
   * <p>
   * Contempla os códigos do campo CST do IPI para os grupos:
   * <ul>
   * <li>O09 (grupo O07 - IPITrib): 00, 49, 50, 99;</li>
   * <li>O09b (grupo O08 - IPINT): 01, 02, 03, 04, 05, 51, 52, 53, 54, 55.</li>
   * </ul>
   */
  public enum SEFAZ_CST_IPI implements SEFAZEnum<SEFAZ_CST_IPI> {

    /** 00 = Entrada com recuperação de crédito. */
    CST_00_ENTRADA_RECUPERACAO_CREDITO("00", false),

    /** 49 = Outras entradas. */
    CST_49_OUTRAS_ENTRADAS("49", false),

    /** 50 = Saída tributada. */
    CST_50_SAIDA_TRIBUTADA("50", false),

    /** 99 = Outras saídas. */
    CST_99_OUTRAS_SAIDAS("99", false),

    /** 01 = Entrada tributada com alíquota zero. */
    CST_01_ENTRADA_TRIBUTADA_ALIQUOTA_ZERO("01", false),

    /** 02 = Entrada isenta. */
    CST_02_ENTRADA_ISENTA("02", false),

    /** 03 = Entrada não-tributada. */
    CST_03_ENTRADA_NAO_TRIBUTADA("03", false),

    /** 04 = Entrada imune. */
    CST_04_ENTRADA_IMUNE("04", false),

    /** 05 = Entrada com suspensão. */
    CST_05_ENTRADA_COM_SUSPENSAO("05", false),

    /** 51 = Saída tributada com alíquota zero. */
    CST_51_SAIDA_TRIBUTADA_ALIQUOTA_ZERO("51", false),

    /** 52 = Saída isenta. */
    CST_52_SAIDA_ISENTA("52", false),

    /** 53 = Saída não tributada. */
    CST_53_SAIDA_NAO_TRIBUTADA("53", false),

    /** 54 = Saída imune. */
    CST_54_SAIDA_IMUNE("54", false),

    /** 55 = Saída com suspensão. */
    CST_55_SAIDA_COM_SUSPENSAO("55", false);

    /** Valor exato gravado/lido no XML (campo CST). */
    private final String xmlData;

    /** Indica se o tipo está obsoleto/descontinuado para uso atual. */
    private final boolean deprecated;

    SEFAZ_CST_IPI(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /**
     * Retorna o valor utilizado no XML (campo CST).
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o tipo está obsoleto.
     *
     * @return the indica se o tipo está obsoleto/descontinuado para uso atual
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

  }

  /**
   * Enumeração da Tributação do PIS (CST) utilizada no XML da NF-e.
   * <p>
   * Contempla todos os códigos do campo CST do PIS nos grupos:
   * <ul>
   * <li>Q02 - PISAliq (CST 01, 02);</li>
   * <li>Q03 - PISQtde (CST 03);</li>
   * <li>Q04 - PISNT (CST 04, 05, 06, 07, 08, 09);</li>
   * <li>Q05 - PISOutr (CST 49, 50–56, 60–67, 70–75, 98, 99).</li>
   * </ul>
   */
  public enum SEFAZ_CST_PIS implements SEFAZEnum<SEFAZ_CST_PIS> {

    /** 01 = Operação Tributável (base de cálculo = valor da operação, alíquota normal). */
    CST_01_OPERACAO_TRIBUTAVEL_BC_VALOR_ALIQUOTA_NORMAL("01", false),

    /** 02 = Operação Tributável (base de cálculo = valor da operação, alíquota diferenciada). */
    CST_02_OPERACAO_TRIBUTAVEL_BC_VALOR_ALIQUOTA_DIFERENCIADA("02", false),

    /** 03 = Operação Tributável (base de cálculo = quantidade vendida × alíquota por unidade de produto). */
    CST_03_OPERACAO_TRIBUTAVEL_BC_QTDE_ALIQUOTA_POR_UNIDADE("03", false),

    /** 04 = Operação Tributável (tributação monofásica, alíquota zero). */
    CST_04_OPERACAO_TRIBUTAVEL_MONOFASICA_ALIQUOTA_ZERO("04", false),

    /** 05 = Operação Tributável (Substituição Tributária). */
    CST_05_OPERACAO_TRIBUTAVEL_SUBSTITUICAO_TRIBUTARIA("05", false),

    /** 06 = Operação Tributável (alíquota zero). */
    CST_06_OPERACAO_TRIBUTAVEL_ALIQUOTA_ZERO("06", false),

    /** 07 = Operação Isenta da Contribuição. */
    CST_07_OPERACAO_ISENTA("07", false),

    /** 08 = Operação Sem Incidência da Contribuição. */
    CST_08_OPERACAO_SEM_INCIDENCIA("08", false),

    /** 09 = Operação com Suspensão da Contribuição. */
    CST_09_OPERACAO_COM_SUSPENSAO("09", false),

    /** 49 = Outras Operações de Saída. */
    CST_49_OUTRAS_OPERACOES_SAIDA("49", false),

    /** 50 = Operação com Direito a Crédito – Vinculada Exclusivamente a Receita Tributada no Mercado Interno. */
    CST_50_DIREITO_CREDITO_VINCULADA_EXCLUSIVA_RECEITA_TRIBUTADA_INTERNA("50", false),

    /** 51 = Operação com Direito a Crédito – Vinculada Exclusivamente a Receita Não Tributada no Mercado Interno. */
    CST_51_DIREITO_CREDITO_VINCULADA_EXCLUSIVA_RECEITA_NAO_TRIBUTADA_INTERNA("51", false),

    /** 52 = Operação com Direito a Crédito – Vinculada Exclusivamente a Receita de Exportação. */
    CST_52_DIREITO_CREDITO_VINCULADA_EXCLUSIVA_RECEITA_EXPORTACAO("52", false),

    /** 53 = Operação com Direito a Crédito – Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno. */
    CST_53_DIREITO_CREDITO_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_INTERNA("53", false),

    /** 54 = Operação com Direito a Crédito – Vinculada a Receitas Tributadas no Mercado Interno e de Exportação. */
    CST_54_DIREITO_CREDITO_RECEITAS_TRIBUTADAS_INTERNA_E_EXPORTACAO("54", false),

    /** 55 = Operação com Direito a Crédito – Vinculada a Receitas Não-Tributadas no Mercado Interno e de Exportação. */
    CST_55_DIREITO_CREDITO_RECEITAS_NAO_TRIBUTADAS_INTERNA_E_EXPORTACAO("55", false),

    /** 56 = Operação com Direito a Crédito – Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno e de Exportação. */
    CST_56_DIREITO_CREDITO_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_INTERNA_E_EXPORTACAO("56", false),

    /** 60 = Crédito Presumido – Operação de Aquisição Vinculada Exclusivamente a Receita Tributada no Mercado Interno. */
    CST_60_CREDITO_PRESUMIDO_AQUISICAO_EXCLUSIVA_RECEITA_TRIBUTADA_INTERNA("60", false),

    /** 61 = Crédito Presumido – Operação de Aquisição Exclusivamente Receita Não-Tributada Mercado Interno. */
    CST_61_CREDITO_PRESUMIDO_AQUISICAO_EXCLUSIVA_RECEITA_NAO_TRIBUTADA_INTERNA("61", false),

    /** 62 = Crédito Presumido – Aquisição Vinculada Exclusivamente a Receita de Exportação. */
    CST_62_CREDITO_PRESUMIDO_AQUISICAO_EXCLUSIVA_RECEITA_EXPORTACAO("62", false),

    /** 63 = Crédito Presumido – Operação de Aquisição Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno. */
    CST_63_CREDITO_PRESUMIDO_AQUISICAO_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_INTERNA("63", false),

    /** 64 = Crédito Presumido – Operação de Aquisição Vinculada a Receitas Tributadas no Mercado Interno e de Exportação. */
    CST_64_CREDITO_PRESUMIDO_AQUISICAO_RECEITAS_TRIBUTADAS_INTERNA_E_EXPORTACAO("64", false),

    /** 65 = Crédito Presumido – Operação de Aquisição Vinculada a Receitas Não-Tributadas no Mercado Interno e de Exportação. */
    CST_65_CREDITO_PRESUMIDO_AQUISICAO_RECEITAS_NAO_TRIBUTADAS_INTERNA_E_EXPORTACAO("65", false),

    /** 66 = Crédito Presumido – Operação de Aquisição Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno. */
    CST_66_CREDITO_PRESUMIDO_AQUISICAO_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_INTERNA("66", false),

    /** 67 = Crédito Presumido – Outras Operações. */
    CST_67_CREDITO_PRESUMIDO_OUTRAS_OPERACOES("67", false),

    /** 70 = Operação de Aquisição com Direito a Crédito. */
    CST_70_AQUISICAO_COM_DIREITO_A_CREDITO("70", false),

    /** 71 = Operação de Aquisição com Isenção. */
    CST_71_AQUISICAO_COM_ISENCAO("71", false),

    /** 72 = Operação de Aquisição com Suspensão. */
    CST_72_AQUISICAO_COM_SUSPENSAO("72", false),

    /** 73 = Operação de Aquisição – Alíquota Zero. */
    CST_73_AQUISICAO_ALIQUOTA_ZERO("73", false),

    /** 74 = Operação de Aquisição – Sem Incidência da Contribuição. */
    CST_74_AQUISICAO_SEM_INCIDENCIA("74", false),

    /** 75 = Operação de Aquisição por Substituição Tributária. */
    CST_75_AQUISICAO_POR_SUBSTITUICAO_TRIBUTARIA("75", false),

    /** 98 = Outras Operações de Entrada. */
    CST_98_OUTRAS_OPERACOES_ENTRADA("98", false),

    /** 99 = Outras Operações. */
    CST_99_OUTRAS_OPERACOES("99", false);

    /** Valor exato gravado/lido no XML (campo CST). */
    private final String xmlData;

    /** Indica se o tipo está obsoleto/descontinuado para uso atual. */
    private final boolean deprecated;

    SEFAZ_CST_PIS(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /**
     * Retorna o valor utilizado no XML (campo CST).
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o tipo está obsoleto.
     *
     * @return the indica se o tipo está obsoleto/descontinuado para uso atual
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

  }

  /**
   * Enumeração da Tributação da COFINS (CST) utilizada no XML da NF-e.
   *
   * Contempla todos os códigos do campo CST da COFINS nos grupos: - S02 - COFINSAliq (CST 01, 02); - S03 - COFINSQtde (CST 03); - S04 - COFINSNT (CST 04, 05, 06, 07, 08, 09); - S05 - COFINSOutr (CST 49, 50, 51, 52, 53, 54, 55, 56, 61–67, 70–73, 98, 99).
   */
  public enum SEFAZ_CST_COFINS implements SEFAZEnum<SEFAZ_CST_COFINS> {

    /** 01 = Operação Tributável (base de cálculo = valor da operação alíquota normal (cumulativo/não cumulativo)). */
    CST_01_OPERACAO_TRIBUTAVEL_BC_VALOR_ALIQUOTA_NORMAL("01", false),

    /** 02 = Operação Tributável (base de cálculo = valor da operação (alíquota diferenciada)). */
    CST_02_OPERACAO_TRIBUTAVEL_BC_VALOR_ALIQUOTA_DIFERENCIADA("02", false),

    /** 03 = Operação Tributável (base de cálculo = quantidade vendida × alíquota por unidade de produto). */
    CST_03_OPERACAO_TRIBUTAVEL_BC_QTDE_ALIQUOTA_POR_UNIDADE("03", false),

    /** 04 = Operação Tributável (tributação monofásica, alíquota zero). */
    CST_04_OPERACAO_TRIBUTAVEL_MONOFASICA_ALIQUOTA_ZERO("04", false),

    /** 05 = Operação Tributável (Substituição Tributária). */
    CST_05_OPERACAO_TRIBUTAVEL_SUBSTITUICAO_TRIBUTARIA("05", false),

    /** 06 = Operação Tributável (alíquota zero). */
    CST_06_OPERACAO_TRIBUTAVEL_ALIQUOTA_ZERO("06", false),

    /** 07 = Operação Isenta da Contribuição. */
    CST_07_OPERACAO_ISENTA("07", false),

    /** 08 = Operação Sem Incidência da Contribuição. */
    CST_08_OPERACAO_SEM_INCIDENCIA("08", false),

    /** 09 = Operação com Suspensão da Contribuição. */
    CST_09_OPERACAO_COM_SUSPENSAO("09", false),

    /** 49 = Outras Operações de Saída. */
    CST_49_OUTRAS_OPERACOES_SAIDA("49", false),

    /** 50 = Operação com Direito a Crédito – Vinculada exclusivamente a Receita Tributada no Mercado Interno. */
    CST_50_DIREITO_CREDITO_VINCULADA_EXCLUSIVA_RECEITA_TRIBUTADA_INTERNA("50", false),

    /** 51 = Operação com Direito a Crédito – Vinculada exclusivamente a Receita Não-Tributada no Mercado Interno. */
    CST_51_DIREITO_CREDITO_VINCULADA_EXCLUSIVA_RECEITA_NAO_TRIBUTADA_INTERNA("51", false),

    /** 52 = Operação com Direito a Crédito – Vinculada exclusivamente a Receita de Exportação. */
    CST_52_DIREITO_CREDITO_VINCULADA_EXCLUSIVA_RECEITA_EXPORTACAO("52", false),

    /** 53 = Operação com Direito a Crédito – Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno. */
    CST_53_DIREITO_CREDITO_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_INTERNA("53", false),

    /** 54 = Operação com Direito a Crédito – Vinculada a Receitas Tributadas no Mercado Interno e de Exportação. */
    CST_54_DIREITO_CREDITO_RECEITAS_TRIBUTADAS_INTERNA_E_EXPORTACAO("54", false),

    /** 55 = Operação com Direito a Crédito – Vinculada a Receitas Não-Tributadas no Mercado Interno e de Exportação. */
    CST_55_DIREITO_CREDITO_RECEITAS_NAO_TRIBUTADAS_INTERNA_E_EXPORTACAO("55", false),

    /** 56 = Crédito Presumido – Operação de Aquisição Vinculada exclusivamente a Receita Tributada no Mercado Interno. */
    CST_56_CREDITO_PRESUMIDO_AQUISICAO_EXCLUSIVA_RECEITA_TRIBUTADA_INTERNA("56", false),

    /** 61 = Crédito Presumido – Operação de Aquisição Vinculada exclusivamente a Receita Não-Tributada no Mercado Interno. */
    CST_61_CREDITO_PRESUMIDO_AQUISICAO_EXCLUSIVA_RECEITA_NAO_TRIBUTADA_INTERNA("61", false),

    /** 62 = Crédito Presumido – Operação de Aquisição Vinculada exclusivamente a Receita de Exportação. */
    CST_62_CREDITO_PRESUMIDO_AQUISICAO_EXCLUSIVA_RECEITA_EXPORTACAO("62", false),

    /** 63 = Crédito Presumido – Operação Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno. */
    CST_63_CREDITO_PRESUMIDO_OPERACAO_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_INTERNA("63", false),

    /** 64 = Crédito Presumido – Operação de Aquisição Vinculada a Receitas Tributadas no Mercado Interno e de Exportação. */
    CST_64_CREDITO_PRESUMIDO_AQUISICAO_RECEITAS_TRIBUTADAS_INTERNA_E_EXPORTACAO("64", false),

    /** 65 = Crédito Presumido – Operação de Aquisição Vinculada a Receitas Não-Tributadas no Mercado Interno e de Exportação. */
    CST_65_CREDITO_PRESUMIDO_AQUISICAO_RECEITAS_NAO_TRIBUTADAS_INTERNA_E_EXPORTACAO("65", false),

    /** 66 = Crédito Presumido – Operação de Aquisição Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno e de Exportação. */
    CST_66_CREDITO_PRESUMIDO_AQUISICAO_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_INTERNA_E_EXPORTACAO("66", false),

    /** 67 = Crédito Presumido – Outras Operações. */
    CST_67_CREDITO_PRESUMIDO_OUTRAS_OPERACOES("67", false),

    /** 70 = Operação de Aquisição com Suspensão. */
    CST_70_AQUISICAO_COM_SUSPENSAO("70", false),

    /** 71 = Operação de Aquisição com Alíquota Zero. */
    CST_71_AQUISICAO_ALIQUOTA_ZERO("71", false),

    /** 72 = Operação de Aquisição sem Incidência da Contribuição. */
    CST_72_AQUISICAO_SEM_INCIDENCIA("72", false),

    /** 73 = Operação de Aquisição por Substituição Tributária. */
    CST_73_AQUISICAO_POR_SUBSTITUICAO_TRIBUTARIA("73", false),

    /** 98 = Outras Operações de Entrada. */
    CST_98_OUTRAS_OPERACOES_ENTRADA("98", false),

    /** 99 = Outras Operações. */
    CST_99_OUTRAS_OPERACOES("99", false);

    /** Valor exato gravado/lido no XML (campo CST). */
    private final String xmlData;

    /** Indica se o tipo está obsoleto/descontinuado para uso atual. */
    private final boolean deprecated;

    SEFAZ_CST_COFINS(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /**
     * Retorna o valor utilizado no XML (campo CST).
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o tipo está obsoleto.
     *
     * @return the indica se o tipo está obsoleto/descontinuado para uso atual
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

  }

  /**
   * Enumeração do Código do Regime Especial de Tributação (cRegTrib) do ISSQN no grupo W17 - ISSQNtot da NF-e.
   *
   * Valores: 1 = Microempresa Municipal 2 = Estimativa 3 = Sociedade de Profissionais 4 = Cooperativa 5 = Microempresário Individual (MEI) 6 = Microempresário e Empresa de Pequeno Porte
   */
  public enum SEFAZ_cRegTrib implements SEFAZEnum<SEFAZ_cRegTrib> {

    /** 1 = Microempresa Municipal. */
    MICROEMPRESA_MUNICIPAL("1", false),

    /** 2 = Estimativa. */
    ESTIMATIVA("2", false),

    /** 3 = Sociedade de Profissionais. */
    SOCIEDADE_PROFISSIONAIS("3", false),

    /** 4 = Cooperativa. */
    COOPERATIVA("4", false),

    /** 5 = Microempresário Individual (MEI). */
    MEI("5", false),

    /** 6 = Microempresário e Empresa de Pequeno Porte. */
    ME_EPP("6", false);

    /** Valor exato gravado/lido no XML (campo cRegTrib). */
    private final String xmlData;

    /** Indica se o tipo está obsoleto/descontinuado para uso atual. */
    private final boolean deprecated;

    SEFAZ_cRegTrib(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /**
     * Retorna o valor utilizado no XML (campo cRegTrib).
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o tipo está obsoleto.
     *
     * @return the indica se o tipo está obsoleto/descontinuado para uso atual
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

  }

  /**
   * Enumeração da Modalidade do Frete (modFrete) utilizada no XML da NF-e.
   *
   * Valores: 0 = Contratação do Frete por conta do Remetente (CIF) 1 = Contratação do Frete por conta do Destinatário (FOB) 2 = Contratação do Frete por conta de Terceiros 3 = Transporte Próprio por conta do Remetente 4 = Transporte Próprio por conta do Destinatário 9 = Sem Ocorrência de Transporte
   */
  public enum SEFAZ_modFrete implements SEFAZEnum<SEFAZ_modFrete> {

    /** 0 = Contratação do Frete por conta do Remetente (CIF). */
    REMETENTE_CIF("0", false),

    /** 1 = Contratação do Frete por conta do Destinatário (FOB). */
    DESTINATARIO_FOB("1", false),

    /** 2 = Contratação do Frete por conta de Terceiros. */
    TERCEIROS("2", false),

    /** 3 = Transporte Próprio por conta do Remetente. */
    TRANSP_PROPRIO_REMETENTE("3", false),

    /** 4 = Transporte Próprio por conta do Destinatário. */
    TRANSP_PROPRIO_DESTINATARIO("4", false),

    /** 9 = Sem Ocorrência de Transporte. */
    SEM_OCORRENCIA("9", false);

    /** Valor exato gravado/lido no XML (campo modFrete). */
    private final String xmlData;

    /** Indica se o tipo está obsoleto/descontinuado para uso atual. */
    private final boolean deprecated;

    SEFAZ_modFrete(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /**
     * Retorna o valor utilizado no XML (campo modFrete).
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o tipo está obsoleto.
     *
     * @return the indica se o tipo está obsoleto/descontinuado para uso atual
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

  }

  /**
   * Enumeração do Indicador da Forma de Pagamento (indPag).
   *
   * Valores: 0 = Pagamento à Vista 1 = Pagamento à Prazo
   */
  public enum SEFAZ_indPag implements SEFAZEnum<SEFAZ_indPag> {

    /** 0 = Pagamento à Vista. */
    A_VISTA("0", false),

    /** 1 = Pagamento à Prazo. */
    A_PRAZO("1", false);

    /** Valor exato gravado/lido no XML (campo indPag). */
    private final String xmlData;

    /** Indica se o tipo está obsoleto/descontinuado para uso atual. */
    private final boolean deprecated;

    SEFAZ_indPag(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /**
     * Retorna o valor utilizado no XML (campo indPag).
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o tipo está obsoleto.
     *
     * @return the indica se o tipo está obsoleto/descontinuado para uso atual
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

  }

  /**
   * Enumeração do Meio de Pagamento (tPag).
   *
   * Valores: 01 = Dinheiro 02 = Cheque 03 = Cartão de Crédito 04 = Cartão de Débito 05 = Crédito Loja 10 = Vale Alimentação 11 = Vale Refeição 12 = Vale Presente 13 = Vale Combustível 15 = Boleto Bancário 16 = Depósito Bancário 17 = Pagamento Instantâneo (PIX) 18 = Transferência bancária, Carteira Digital 19 = Programa de fidelidade, Cashback, Crédito Virtual 90 = Sem pagamento 99 = Outros
   */
  public enum SEFAZ_tPag implements SEFAZEnum<SEFAZ_tPag> {

    /** 01 = Dinheiro. */
    DINHEIRO("01", false),

    /** 02 = Cheque. */
    CHEQUE("02", false),

    /** 03 = Cartão de Crédito. */
    CARTAO_CREDITO("03", false),

    /** 04 = Cartão de Débito. */
    CARTAO_DEBITO("04", false),

    /** 05 = Crédito Loja. */
    CREDITO_LOJA("05", false),

    /** 10 = Vale Alimentação. */
    VALE_ALIMENTACAO("10", false),

    /** 11 = Vale Refeição. */
    VALE_REFEICAO("11", false),

    /** 12 = Vale Presente. */
    VALE_PRESENTE("12", false),

    /** 13 = Vale Combustível. */
    VALE_COMBUSTIVEL("13", false),

    /** 15 = Boleto Bancário. */
    BOLETO_BANCARIO("15", false),

    /** 16 = Depósito Bancário. */
    DEPOSITO_BANCARIO("16", false),

    /** 17 = Pagamento Instantâneo (PIX). */
    PIX("17", false),

    /** 18 = Transferência bancária, Carteira Digital. */
    TRANSFERENCIA_OU_CARTEIRA_DIGITAL("18", false),

    /** 19 = Programa de fidelidade, Cashback, Crédito Virtual. */
    FIDELIDADE_CASHBACK_CREDITO_VIRTUAL("19", false),

    /** 90 = Sem pagamento. */
    SEM_PAGAMENTO("90", false),

    /** 99 = Outros. */
    OUTROS("99", false);

    /** Valor exato gravado/lido no XML (campo tPag). */
    private final String xmlData;

    /** Indica se o tipo está obsoleto/descontinuado para uso atual. */
    private final boolean deprecated;

    SEFAZ_tPag(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /**
     * Retorna o valor utilizado no XML (campo tPag).
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o tipo está obsoleto.
     *
     * @return the indica se o tipo está obsoleto/descontinuado para uso atual
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

  }

  /**
   * Enumeração do Tipo de Integração para pagamento (tpIntegra).
   *
   * Valores: 1 = Pagamento integrado com o sistema de automação da empresa 2 = Pagamento não integrado com o sistema de automação da empresa
   */
  public enum SEFAZ_tpIntegra implements SEFAZEnum<SEFAZ_tpIntegra> {

    /** 1 = Pagamento integrado com o sistema de automação da empresa. */
    INTEGRADO_AUTOMACAO("1", false),

    /** 2 = Pagamento não integrado com o sistema de automação da empresa. */
    NAO_INTEGRADO_AUTOMACAO("2", false);

    /** Valor exato gravado/lido no XML (campo tpIntegra). */
    private final String xmlData;

    /** Indica se o tipo está obsoleto/descontinuado para uso atual. */
    private final boolean deprecated;

    SEFAZ_tpIntegra(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /**
     * Retorna o valor utilizado no XML (campo tpIntegra).
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o tipo está obsoleto.
     *
     * @return the indica se o tipo está obsoleto/descontinuado para uso atual
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

  }

  /**
   * Enumeração da Bandeira da operadora de cartão (tBand).
   *
   * Valores: 01 = Visa 02 = Mastercard 03 = American Express 04 = Sorocred 05 = Diners Club 06 = Elo 07 = Hipercard 08 = Aura 09 = Cabal 99 = Outros
   */
  public enum SEFAZ_tBand implements SEFAZEnum<SEFAZ_tBand> {

    /** 01 = Visa. */
    VISA("01", false),

    /** 02 = Mastercard. */
    MASTERCARD("02", false),

    /** 03 = American Express. */
    AMERICAN_EXPRESS("03", false),

    /** 04 = Sorocred. */
    SOROCRED("04", false),

    /** 05 = Diners Club. */
    DINERS_CLUB("05", false),

    /** 06 = Elo. */
    ELO("06", false),

    /** 07 = Hipercard. */
    HIPERCARD("07", false),

    /** 08 = Aura. */
    AURA("08", false),

    /** 09 = Cabal. */
    CABAL("09", false),

    /** 99 = Outros. */
    OUTROS("99", false);

    /** Valor exato gravado/lido no XML (campo tBand). */
    private final String xmlData;

    /** Indica se o tipo está obsoleto/descontinuado para uso atual. */
    private final boolean deprecated;

    SEFAZ_tBand(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /**
     * Retorna o valor utilizado no XML (campo tBand).
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o tipo está obsoleto.
     *
     * @return the indica se o tipo está obsoleto/descontinuado para uso atual
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

  }

  /**
   * Enumeração SEFAZ_indProc — Indicador da Origem do Processo (campo Z12 da NF-e).
   *
   * <p>
   * Esta enumeração representa os valores aceitos no campo {@code indProc} do grupo Z10 - procRef (Processo Referenciado), conforme especificação oficial da NF-e.
   * </p>
   *
   * <p>
   * <b>Origem do Processo (Z12 – indProc):</b>
   * </p>
   * <ul>
   * <li><b>0 – SEFAZ:</b> Processo originado na Secretaria da Fazenda estadual.</li>
   * <li><b>1 – Justiça Federal:</b> Processo administrativo ou judicial originado em órgão federal.</li>
   * <li><b>2 – Justiça Estadual:</b> Processo originado no âmbito judicial estadual.</li>
   * <li><b>3 – Secex/RFB:</b> Processo originado na Secretaria de Comércio Exterior ou Receita Federal do Brasil.</li>
   * <li><b>9 – Outros:</b> Qualquer outra origem não contemplada nos códigos anteriores.</li>
   * </ul>
   *
   * <p>
   * Tamanho: 1 dígito numérico. Ocorrência: 1-1 dentro de {@code procRef}.
   * </p>
   *
   * <p>
   * A enum segue o padrão geral do sistema, contendo:
   * </p>
   * <ul>
   * <li>valor exato gravado/lido no XML ({@code xmlData});</li>
   * <li>indicador de descontinuação ({@code deprecated});</li>
   * <li>métodos: {@code getXMLData()}, {@code isDeprecated()}, {@code valueOfXMLData()}.</li>
   * </ul>
   */
  public enum SEFAZ_indProc implements SEFAZEnum<SEFAZ_indProc> {

    /**
     * 0 – SEFAZ.
     * <p>
     * Indica que o processo ou ato concessório foi originado na Secretaria da Fazenda estadual.
     * </p>
     */
    SEFAZ("0", false),

    /**
     * 1 – Justiça Federal.
     * <p>
     * Processo administrativo ou judicial cuja origem está no âmbito da Justiça Federal.
     * </p>
     */
    JUSTICA_FEDERAL("1", false),

    /**
     * 2 – Justiça Estadual.
     * <p>
     * Processo administrativo ou judicial de origem na Justiça Estadual.
     * </p>
     */
    JUSTICA_ESTADUAL("2", false),

    /**
     * 3 – Secex/RFB.
     * <p>
     * Processo originado na Secretaria de Comércio Exterior (Secex) ou na Receita Federal do Brasil (RFB).
     * </p>
     */
    SECEX_RFB("3", false),

    /**
     * 9 – Outros.
     * <p>
     * Qualquer outra origem não contemplada nas opções anteriores.
     * </p>
     */
    OUTROS("9", false);

    /** Valor gravado/lido exatamente como aparece no XML. */
    private final String xmlData;

    /** Indica se este código está obsoleto/descontinuado. */
    private final boolean deprecated;

    SEFAZ_indProc(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /**
     * Retorna o valor exato utilizado no XML, conforme o leiaute da NF-e.
     *
     * @return String contendo o valor correspondente no XML.
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Informa se o código está obsoleto ou descontinuado para uso atual.
     *
     * @return {@code true} se o código estiver obsoleto; {@code false} caso contrário.
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

  }

  /**
   * Enumeração SEFAZ_indIncentivo — Indicador de Incentivo Fiscal (campo U17).
   *
   * <p>
   * Campo U17 – indIncentivo (Indicador de Incentivo Fiscal) pertencente ao grupo U01.
   * </p>
   *
   * <p>
   * <b>Valores permitidos:</b>
   * </p>
   * <ul>
   * <li><b>1 = Sim</b> — Existe incentivo fiscal vinculado ao item.</li>
   * <li><b>2 = Não</b> — Não há incentivo fiscal associado.</li>
   * </ul>
   *
   * <p>
   * Tipo: N Tamanho: 1 Ocorrência: 1-1
   * </p>
   *
   * <p>
   * Segue o padrão geral das enumerações do sistema, contendo:
   * </p>
   * <ul>
   * <li>valor XML exato ({@code xmlData});</li>
   * <li>indicador de descontinuação ({@code deprecated});</li>
   * <li>métodos utilitários: {@code getXMLData()}, {@code isDeprecated()}, {@code valueOfXMLData()}.</li>
   * </ul>
   */
  public enum SEFAZ_indIncentivo implements SEFAZEnum<SEFAZ_indIncentivo> {

    /**
     * 1 – Sim.
     * <p>
     * Indica que o item possui incentivo fiscal.
     * </p>
     */
    SIM("1", false),

    /**
     * 2 – Não.
     * <p>
     * Indica que não há incentivo fiscal relacionado ao item.
     * </p>
     */
    NAO("2", false);

    /** Valor gravado/lido exatamente como aparece no XML. */
    private final String xmlData;

    /** Indica se o código está obsoleto ou descontinuado. */
    private final boolean deprecated;

    SEFAZ_indIncentivo(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /**
     * Retorna o valor exato utilizado no XML.
     *
     * @return valor XML correspondente ao código da enum.
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Retorna se este código está obsoleto/descontinuado.
     *
     * @return true se obsoleto; false caso contrário.
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

  }

  /**
   * Enumeração SEFAZ_indISS — Indicador da Exigibilidade do ISS (campo U12).
   *
   * <p>
   * Campo U12 – indISS (Indicador da Exigibilidade do ISS) pertencente ao grupo U01.
   * </p>
   *
   * <p>
   * <b>Valores permitidos:</b>
   * </p>
   * <ul>
   * <li><b>1 = Exigível</b></li>
   * <li><b>2 = Não incidência</b></li>
   * <li><b>3 = Isenção</b></li>
   * <li><b>4 = Exportação</b></li>
   * <li><b>5 = Imunidade</b></li>
   * <li><b>6 = Exigibilidade suspensa por decisão judicial</b></li>
   * <li><b>7 = Exigibilidade suspensa por processo administrativo</b></li>
   * </ul>
   *
   * <p>
   * Tipo: N Tamanho: 2 Ocorrência: 1-1
   * </p>
   *
   * <p>
   * Implementada conforme o padrão das enumerações SEFAZ do sistema, contendo:
   * </p>
   * <ul>
   * <li>valor XML exato ({@code xmlData});</li>
   * <li>flag de descontinuação ({@code deprecated});</li>
   * <li>métodos obrigatórios: {@code getXMLData()}, {@code isDeprecated()}, {@code valueOfXMLData()}.</li>
   * </ul>
   */
  public enum SEFAZ_indISS implements SEFAZEnum<SEFAZ_indISS> {

    /** 1 – Exigível. */
    EXIGIVEL("1", false),

    /** 2 – Não incidência. */
    NAO_INCIDENCIA("2", false),

    /** 3 – Isenção. */
    ISENCAO("3", false),

    /** 4 – Exportação. */
    EXPORTACAO("4", false),

    /** 5 – Imunidade. */
    IMUNIDADE("5", false),

    /** 6 – Exigibilidade suspensa por decisão judicial. */
    SUSPENSA_DECISAO_JUDICIAL("6", false),

    /** 7 – Exigibilidade suspensa por processo administrativo. */
    SUSPENSA_PROCESSO_ADMINISTRATIVO("7", false);

    /** Valor utilizado exatamente no XML. */
    private final String xmlData;

    /** Indica se o valor está obsoleto/descontinuado. */
    private final boolean deprecated;

    SEFAZ_indISS(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /**
     * Retorna o valor utilizado no XML.
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o valor está obsoleto/descontinuado.
     *
     * @return the indica se o valor está obsoleto/descontinuado
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

  }

  /**
   * Enumeração SEFAZ_indSinc — Indicador de Processamento Síncrono do Lote (campo AP03a).
   *
   * <p>
   * Campo AP03a – indSinc, pertencente ao grupo AP01 (Identificação do Lote).
   * </p>
   *
   * <p>
   * <b>Valores permitidos:</b>
   * </p>
   * <ul>
   * <li><b>0 = Não</b></li>
   * <li><b>1 = Empresa solicita processamento síncrono do lote</b></li>
   * </ul>
   *
   * <p>
   * Tipo: N Tamanho: 1 Ocorrência: 1-1
   * </p>
   *
   * <p>
   * Observações importantes segundo a NT:
   * </p>
   * <ul>
   * <li>O processamento síncrono corresponde ao retorno imediato da autorização da NF-e, sem geração de recibo.</li>
   * <li>A SEFAZ somente retornará de forma síncrona se:
   * <ul>
   * <li>a empresa solicitar (valor = 1);</li>
   * <li>houver somente uma NF-e no lote;</li>
   * <li>a SEFAZ autorizadora implementar esse modo de processamento.</li>
   * </ul>
   * </li>
   * </ul>
   *
   * <p>
   * Implementado conforme padrão das enums SEFAZ:
   * </p>
   * <ul>
   * <li>valor XML exato ({@code xmlData});</li>
   * <li>flag {@code deprecated};</li>
   * <li>métodos padrão: {@code getXMLData()}, {@code isDeprecated()}, {@code valueOfXMLData()}.</li>
   * </ul>
   */
  public enum SEFAZ_indSinc implements SEFAZEnum<SEFAZ_indSinc> {

    /** 0 – Não solicita processamento síncrono. */
    NAO("0", false),

    /** 1 – Solicita processamento síncrono do lote. */
    SOLICITA_SINCRONO("1", false);

    /** Valor utilizado exatamente no XML. */
    private final String xmlData;

    /** Indica se o valor está obsoleto/descontinuado. */
    private final boolean deprecated;

    SEFAZ_indSinc(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /**
     * Retorna o valor utilizado no XML.
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }

    /**
     * Indica se o valor está obsoleto/descontinuado.
     *
     * @return the indica se o valor está obsoleto/descontinuado
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

  }

  /**
   * Enumeration com as UF e mais alguns códigos extras que são aceitos em alguns campos de UF do XML da SEFAZ.<br>
   * <br>
   * Cada constante contém:
   * <ul>
   * <li><b>ibgeCode</b> – código IBGE da UF, usado em campos como {@code cUF} e na chave de acesso;</li>
   * <li><b>qrCodeProdUrl</b> – URL base do QR-Code NFC-e em produção (pode iniciar como {@code null});</li>
   * <li><b>qrCodeHomUrl</b> – URL base do QR-Code NFC-e em homologação (pode iniciar como {@code null});</li>
   * <li><b>consultaProdUrl</b> – URL de consulta pública da NFC-e em produção (pode iniciar como {@code null});</li>
   * <li><b>consultaHomUrl</b> – URL de consulta pública da NFC-e em homologação (pode iniciar como {@code null}).</li>
   * </ul>
   *
   * <p>
   * Os campos de URL são deliberadamente inicializados com {@code null} nas constantes, para que sejam preenchidos manualmente conforme as URLs oficiais confirmadas para cada UF e ambiente.
   * </p>
   *
   * <p>
   * A constante {@link #EX} representa o código utilizado em alguns campos de UF para endereços no exterior, e por isso não possui código IBGE nem URLs de NFC-e.
   * </p>
   */
  public enum SEFAZ_uf implements SEFAZEnum<SEFAZ_uf> {
    AC("12", null, null, null, null),
    AL("27", null, null, null, null),
    AP("16", null, null, null, null),
    AM("13", null, null, null, null),
    BA("29", null, null, null, null),
    CE("23", null, null, null, null),
    DF("53", null, null, null, null),
    ES("32", null, null, null, null),
    GO("52", null, null, null, null),
    MA("21", null, null, null, null),
    MG("31", null, null, null, null),
    MS("50", null, null, null, null),
    MT("51", null, null, null, null),
    PA("15", null, null, null, null),
    PB("25", null, null, null, null),
    PE("26", null, null, null, null),
    PI("22", null, null, null, null),
    PR("41", null, null, null, null),
    RJ("33", null, null, null, null),
    RN("24", null, null, null, null),
    RO("11", null, null, null, null),
    RR("14", null, null, null, null),
    RS("43", null, null, null, null),
    SC("42", null, null, null, null),
    SE("28", null, null, null, null),
    SP("35", "https://www.nfce.fazenda.sp.gov.br/qrcode", "https://www.homologacao.nfce.fazenda.sp.gov.br/qrcode", "https://www.nfce.fazenda.sp.gov.br/NFCeConsultaPublica", "https://www.homologacao.nfce.fazenda.sp.gov.br/consulta"),
    TO("17", null, null, null, null),

    /**
     * Exterior (EX).<br>
     * Usado em alguns campos de UF/município do XML quando o endereço está fora do Brasil. Não possui código IBGE, nem URLs de NFC-e.
     */
    EX(null, null, null, null, null);

    /** Código IBGE da UF (ou {@code null} para EX). */
    private final String xmlData;

    /** URL base do QR-Code NFC-e em produção (pode ser {@code null}). */
    private final String qrCodeProdUrl;

    /** URL base do QR-Code NFC-e em homologação (pode ser {@code null}). */
    private final String qrCodeHomUrl;

    /** URL de consulta pública da NFC-e em produção (pode ser {@code null}). */
    private final String consultaProdUrl;

    /** URL de consulta pública da NFC-e em homologação (pode ser {@code null}). */
    private final String consultaHomUrl;

    /**
     * Construtor principal da enum.
     *
     * <p>
     * Parâmetros:
     * </p>
     * <ul>
     * <li><b>ibgeCode</b> – código IBGE da UF, usado em {@code cUF}, chave de acesso e outros campos numéricos que identificam a UF. Para {@link #EX}, este valor deve ser {@code null}, pois não há código IBGE para o exterior.</li>
     *
     * <li><b>qrCodeProdUrl</b> – URL base do QR-Code NFC-e no ambiente de produção da UF. Corresponde ao endpoint onde o parâmetro {@code p=} (ou demais parâmetros da versão do QR-Code) será anexado. Inicialmente pode ser passado {@code null} e preenchido posteriormente, conforme confirmação da documentação oficial da SEFAZ.</li>
     *
     * <li><b>qrCodeHomUrl</b> – URL base do QR-Code NFC-e no ambiente de homologação. Mesmo uso da {@code qrCodeProdUrl}, porém apontando para o ambiente de testes. Também pode ser inicializado como {@code null} até que a URL seja confirmada e ajustada manualmente.</li>
     *
     * <li><b>consultaProdUrl</b> – URL da página de consulta pública da NFC-e em produção, normalmente usada para permitir ao consumidor verificar a autenticidade do documento pela chave de acesso. Pode ser {@code null} se ainda não definida ou não aplicável para a UF.</li>
     *
     * <li><b>consultaHomUrl</b> – URL da página de consulta pública da NFC-e em homologação. Também pode ser mantida como {@code null} até confirmação da URL oficial da UF.</li>
     * </ul>
     *
     * <p>
     * A ideia é que, em um primeiro momento, as constantes sejam declaradas com {@code null} para todas as URLs, e o integrador vá preenchendo essas informações aos poucos, à medida que confirmar os endereços corretos diretamente na documentação de cada SEFAZ estadual.
     * </p>
     *
     * @param xmlData Código IBGE da UF, ou {@code null} para EX.
     * @param qrCodeProdUrl URL base do QR-Code NFC-e em produção (pode ser {@code null}).
     * @param qrCodeHomUrl URL base do QR-Code NFC-e em homologação (pode ser {@code null}).
     * @param consultaProdUrl URL de consulta pública da NFC-e em produção (pode ser {@code null}).
     * @param consultaHomUrl URL de consulta pública da NFC-e em homologação (pode ser {@code null}).
     */
    SEFAZ_uf(String xmlData, String qrCodeProdUrl, String qrCodeHomUrl, String consultaProdUrl, String consultaHomUrl) {
      this.xmlData = xmlData;
      this.qrCodeProdUrl = qrCodeProdUrl;
      this.qrCodeHomUrl = qrCodeHomUrl;
      this.consultaProdUrl = consultaProdUrl;
      this.consultaHomUrl = consultaHomUrl;
    }

    /**
     * # uRL base do QR-Code NFC-e em produção (pode ser {@code null}).
     *
     * @return the uRL base do QR-Code NFC-e em produção (pode ser {@code null})
     */
    public String getQrCodeProdUrl() {
      return qrCodeProdUrl;
    }

    /**
     * # uRL base do QR-Code NFC-e em homologação (pode ser {@code null}).
     *
     * @return the uRL base do QR-Code NFC-e em homologação (pode ser {@code null})
     */
    public String getQrCodeHomUrl() {
      return qrCodeHomUrl;
    }

    /**
     * # uRL de consulta pública da NFC-e em produção (pode ser {@code null}).
     *
     * @return the uRL de consulta pública da NFC-e em produção (pode ser {@code null})
     */
    public String getConsultaProdUrl() {
      return consultaProdUrl;
    }

    /**
     * # uRL de consulta pública da NFC-e em homologação (pode ser {@code null}).
     *
     * @return the uRL de consulta pública da NFC-e em homologação (pode ser {@code null})
     */
    public String getConsultaHomUrl() {
      return consultaHomUrl;
    }

    /**
     * Sigla da UF (AC, AL, SP, EX, etc.).
     *
     * @return the acronym
     */
    public String getAcronym() {
      return name();
    }

    /**
     * Gets the XML data.
     *
     * @return the XML data
     */
    @Override
    public String getXmlData() {
      return this.xmlData;
    }
  }

  /**
   * Enumeration dos autorizadores de WebServices da SEFAZ para NF-e/NFC-e.
   *
   * <p>
   * Cada constante representa um “servidor autorizador”, que pode ser:
   * </p>
   * <ul>
   * <li>Uma SEFAZ estadual (ex.: {@code SP}, {@code PR}, {@code RS});</li>
   * <li>Um autorizador virtual (ex.: {@code SVRS}, {@code SVAN}, {@code SVCAN}, {@code SVCRS});</li>
   * <li>O Ambiente Nacional ({@code AN}) para alguns serviços centralizados.</li>
   * </ul>
   *
   * <p>
   * Para UFs “reais”, o {@code ibgeCode} é o código numérico da UF (como em {@code cUF} e chave de acesso). Para autorizadores virtuais e para o Ambiente Nacional, o {@code ibgeCode} é {@code null}. O mapeamento cUF - autorizador deve ser feito em outra lógica da aplicação.
   * </p>
   *
   * <p>
   * Cada autorizador tem espaço para armazenar as URLs principais dos serviços de autorização de NF-e e NFC-e, em produção e homologação. Inicialmente, muitas delas podem ser {@code null} e devem ser preenchidas manualmente conforme a documentação oficial de cada autorizador.
   * </p>
   */
  public enum SEFAZ_WebServices implements SEFAZEnum<SEFAZ_WebServices> {

    AM("13"),
    BA("29"),
    GO("52"),
    MG("31"),
    MS("50"),
    MT("51"),
    PE("26"),
    PR("41"),
    RS("43"),
    SP("35"),

    /**
     * SVAN – Sefaz Virtual do Ambiente Nacional.
     *
     * <p>
     * Autorizador virtual mantido pelo Ambiente Nacional para alguns estados que não possuem infraestrutura própria de autorização em determinados momentos da evolução da NF-e.
     * </p>
     *
     * <p>
     * Não possui código IBGE próprio (não é uma UF). O uso é definido por tabela de mapeamento cUF - autorizador.
     * </p>
     */
    SVAN(null),

    /**
     * SVRS – Sefaz Virtual do Rio Grande do Sul.
     *
     * <p>
     * Autorizador virtual que atende diversas UFs (principalmente da região Sul, Sudeste e Nordeste), conforme tabela oficial de “Autorizadores”.
     * </p>
     *
     * <p>
     * Não é uma UF: o cUF permanece o da UF do contribuinte, mas o WebService chamado é o do SVRS. Por isso, {@code ibgeCode} é {@code null}.
     * </p>
     */
    SVRS(null),

    /**
     * SVCAN – Sefaz Virtual de Contingência – Ambiente Nacional.
     *
     * <p>
     * Utilizado em cenários de contingência, quando a SEFAZ da UF e/ou o autorizador principal não estiverem disponíveis.
     * </p>
     *
     * <p>
     * Atende um conjunto de UFs definido em NT específica. O XML continua com o cUF da UF de origem; apenas o endpoint muda para o SVCAN.
     * </p>
     */
    SVCAN(null),

    /**
     * SVCRS – Sefaz Virtual de Contingência – Rio Grande do Sul.
     *
     * <p>
     * Similar ao SVCAN, mas operado pela SEFAZ-RS. Também utilizado em contingência para um conjunto definido de UFs.
     * </p>
     */
    SVCRS(null),

    /**
     * AN – Ambiente Nacional.
     *
     * <p>
     * Representa o Ambiente Nacional para serviços centralizados (ex.: distribuição de DF-e, manifestação do destinatário, etc.), que não se vinculam diretamente a uma única UF.
     * </p>
     *
     * <p>
     * Usado mais como código lógico de agrupamento de WebServices nacionais do que como “UF/autorizador” em si.
     * </p>
     */
    AN(null);

    /**
     * Código do IBGE utilizado no XML.
     */
    private final String xmlData;

    /**
     * Construtor da enum de autorizadores de WebService.
     *
     * @param xmlData Código IBGE da UF quando o autorizador é estadual (ex.: "35" para SP) ou {@code null} para autorizadores virtuais / Ambiente Nacional (SVAN, SVRS, SVCAN, SVCRS, AN).
     */
    SEFAZ_WebServices(String xmlData) {
      this.xmlData = xmlData;
    }

    /**
     * Gets the acronym.
     *
     * @return the acronym
     */
    public String getAcronym() {
      return this.name();
    }

    public static SEFAZ_WebServices valueOfIBGECode(String ibgeCode) {
      if (ibgeCode == null) return null;
      for (SEFAZ_WebServices service : SEFAZ_WebServices.values()) {
        if (ibgeCode.equals(service.getXmlData())) {
          return service;
        }
      }
      return null;
    }

    /**
     * # código do IBGE utilizado no XML.
     *
     * @return the código do IBGE utilizado no XML
     */
    @Override
    public String getXmlData() {
      return xmlData;
    }
  }

}