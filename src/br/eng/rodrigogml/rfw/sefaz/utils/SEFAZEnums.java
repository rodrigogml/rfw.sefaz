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
   * Description: Tipos de emissão (tpEmis) conforme SEFAZ para NFe/NFC-e (modelo 55/65).<br>
   * Cada enumeration possui o valor exato a ser utilizado/interpretado no XML (campo tpEmis) e um indicador de descontinuidade (deprecated) para sinalizar usos proibidos/obsoletos.
   *
   * Observações importantes:
   * <ul>
   * <li>Para NFC-e (modelo 65) somente é válida a contingência: <b>9 - Off-line</b> e, a critério da UF, <b>4 - EPEC</b> (NT 2015/002).</li>
   * <li>O modo <b>3 - SCAN</b> está desativado (NT 2015/002) e marcado como {@code deprecated=true}.</li>
   * </ul>
   *
   * @author BIS DEVil
   * @since 1.0.0
   */
  public enum SEFAZTipoEmissao {

    /**
     * 1 = Emissão normal (não em contingência).
     */
    NORMAL("1", false),

    /**
     * 2 = Contingência FS-IA (Formulário de Segurança - Impressor Autônomo).
     */
    CONTINGENCIA_FS_IA("2", false),

    /**
     * 3 = Contingência SCAN (Sistema de Contingência do Ambiente Nacional).<br>
     * <b>Desativado - NT 2015/002.</b>
     */
    CONTINGENCIA_SCAN("3", true),

    /**
     * 4 = Contingência EPEC (Evento Prévio da Emissão em Contingência).
     */
    CONTINGENCIA_EPEC("4", false),

    /**
     * 5 = Contingência FS-DA (Formulário de Segurança - Documento Auxiliar).
     */
    CONTINGENCIA_FS_DA("5", false),

    /**
     * 6 = Contingência SVC-AN (SEFAZ Virtual de Contingência do Ambiente Nacional).
     */
    CONTINGENCIA_SVC_AN("6", false),

    /**
     * 7 = Contingência SVC-RS (SEFAZ Virtual de Contingência do RS).
     */
    CONTINGENCIA_SVC_RS("7", false),

    /**
     * 9 = Contingência Off-line da NFC-e.
     */
    CONTINGENCIA_OFFLINE_NFCE("9", false);

    /**
     * Valor exato gravado/lido no XML (campo tpEmis).
     */
    private final String xmlData;
    /**
     * Indica se o tipo está obsoleto/descontinuado para uso atual.
     */
    private final boolean deprecated;

    SEFAZTipoEmissao(String xmlData, boolean deprecated) {
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
     * Interpreta o valor recebido do XML (campo tpEmis) e retorna a enumeration correspondente.
     *
     * @param xmlValue Valor vindo do XML (por exemplo: "1", "4", "9").
     * @return Enumeration correspondente ao valor informado.
     * @throws IllegalArgumentException Caso o valor seja nulo/vazio ou não exista mapeamento.
     */
    public static SEFAZTipoEmissao valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'tpEmis' no XML não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'tpEmis' no XML não pode ser vazio.");
      }
      for (SEFAZTipoEmissao e : SEFAZTipoEmissao.values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Valor XML desconhecido para 'tpEmis': '" + xmlValue + "'.");
    }
  }

  /**
   * Description: Formato de Impressão (tpImp) do DANFE/DANFCe conforme SEFAZ para NFe/NFC-e (modelo 55/65).<br>
   * Cada enumeration possui o valor exato a ser utilizado/interpretado no XML (campo tpImp) e um indicador de descontinuidade (deprecated) para futura sinalização de modos obsoletos.
   *
   * Valores oficiais:
   * <ul>
   * <li>0 = Sem geração de DANFE;</li>
   * <li>1 = DANFE normal, Retrato;</li>
   * <li>2 = DANFE normal, Paisagem;</li>
   * <li>3 = DANFE Simplificado;</li>
   * <li>4 = DANFE NFC-e;</li>
   * <li>5 = DANFE NFC-e em mensagem eletrônica (quando for a única forma de disponibilização);</li>
   * </ul>
   *
   * Observação: para NFC-e o mais comum é utilizar 4 (impresso) ou 5 (mensagem eletrônica).
   *
   * @author BIS DEVil
   * @since 1.0.0
   */
  public enum SEFAZFormatoImpressao {

    /**
     * 0 = Sem geração de DANFE.
     */
    SEM_DANFE("0", false),

    /**
     * 1 = DANFE normal, Retrato.
     */
    DANFE_RETRATO("1", false),

    /**
     * 2 = DANFE normal, Paisagem.
     */
    DANFE_PAISAGEM("2", false),

    /**
     * 3 = DANFE Simplificado.
     */
    DANFE_SIMPLIFICADO("3", false),

    /**
     * 4 = DANFE NFC-e (impresso).
     */
    DANFE_NFCE("4", false),

    /**
     * 5 = DANFE NFC-e em mensagem eletrônica (quando for a única forma de disponibilização).
     */
    DANFE_NFCE_MENSAGEM_ELETRONICA("5", false);

    /**
     * Valor exato gravado/lido no XML (campo tpImp).
     */
    private final String xmlData;
    /**
     * Indica se o formato está obsoleto/descontinuado para uso atual.
     */
    private final boolean deprecated;

    SEFAZFormatoImpressao(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /**
     * Recupera o valor a ser utilizado no XML (campo tpImp) a partir da enumeration.
     *
     * @return String com o valor XML correspondente.
     */
    public String getXMLData() {
      return this.xmlData;
    }

    /**
     * Indica se o formato está obsoleto e não deve ser utilizado nas emissões atuais.
     *
     * @return {@code true} se o formato estiver obsoleto; {@code false} caso contrário.
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Interpreta o valor recebido do XML (campo tpImp) e retorna a enumeration correspondente.
     *
     * @param xmlValue Valor vindo do XML (por exemplo: "0", "1", "4", "5").
     * @return Enumeration correspondente ao valor informado.
     * @throws IllegalArgumentException Caso o valor seja nulo/vazio ou não exista mapeamento.
     */
    public static SEFAZFormatoImpressao valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'tpImp' no XML não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'tpImp' no XML não pode ser vazio.");
      }
      for (SEFAZFormatoImpressao e : SEFAZFormatoImpressao.values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Valor XML desconhecido para 'tpImp': '" + xmlValue + "'.");
    }
  }

  /**
   * Modelo do Documento Fiscal — <b>tag B06: {@code mod}</b>.<br>
   * Usado para indicar o modelo da NF: 55 (NF-e) ou 65 (NFC-e).<br>
   * O valor retornado por {@link #getXMLData()} é gravado/lido diretamente do XML.
   * <p>
   * Modelos de Documentos Fiscais. Utilizado nas Tags:<br>
   * <li>nfe\infNFe\ide\mod
   * <li>nfe\infNFe\ide\NFref\refNF\mod
   * <li>nfe\infNFe\ide\NFref\refNFP\mod
   * <li>nfe\infNFe\ide\NFref\refECF\mod
   */
  public enum SEFAZModeloDocumento {
    /**
     * Modelo de Notas Fiscais de talão.<br>
     * Este modelo não por ser emitido de forma eletrônica, mas pode ser referenciado por notas eletrônicas.
     */
    TALAO_01("01", false),
    /**
     * Este modelo foi incluído na (incluído na NT2016.002).<br>
     * Modelo de Notas Fiscais de talão.<br>
     * Este modelo não por ser emitido de forma eletrônica, mas pode ser referenciado por notas eletrônicas.
     */
    TALAO_02("02", false),
    /**
     * Modelo de Notas Fiscais de Produtor.<br>
     * Este modelo não por ser emitido de forma eletrônica, mas pode ser referenciado por notas eletrônicas.
     */
    PRODUTOR_04("04", false),
    /**
     * Modelo de Cupom Fiscal emitido por máquina registradora (não ECF).<br>
     * Este modelo não por ser emitido de forma eletrônica, mas pode ser referenciado por notas eletrônicas.
     */
    MAQUINAREGISTRADORA_MODEL2B("2B", false),
    /**
     * Modelo de Cupom Fiscal PDV.<br>
     * Este modelo não por ser emitido de forma eletrônica, mas pode ser referenciado por notas eletrônicas.
     */
    PDV_2C("2C", false),
    /**
     * Modelo de Cupom Fiscal (Emitido por ECF).<br>
     * Este modelo não por ser emitido de forma eletrônica, mas pode ser referenciado por notas eletrônicas.
     */
    ECF_2D("2D", false),

    /**
     * <b>55</b> – NF-e (modelo 55).<br>
     * Utilizado para Nota Fiscal Eletrônica de mercadorias (modelo 55).
     */
    NFE_55("55", false),

    /**
     * <b>65</b> – NFC-e (modelo 65).<br>
     * Utilizado para Nota Fiscal de Consumidor Eletrônica (varejo).
     */
    NFCE_65("65", false);

    private final String xmlData;
    private final boolean deprecated;

    SEFAZModeloDocumento(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /**
     * Valor exato a ser gravado/lido no XML do campo <b>B06 mod</b>.
     */
    public String getXMLData() {
      return xmlData;
    }

    /**
     * Indica se o valor está descontinuado/obsoleto.
     */
    public boolean isDeprecated() {
      return deprecated;
    }

    /**
     * Converte o conteúdo do XML do campo <b>B06 mod</b> para a enum correspondente.
     *
     * @param v valor textual do XML (ex.: {@code "55"}, {@code "65"})
     * @return enum correspondente
     * @throws IllegalArgumentException se nulo/vazio ou não mapeado
     */
    public static SEFAZModeloDocumento valueOfXMLData(String v) {
      if (v == null || (v = v.trim()).isEmpty()) throw new IllegalArgumentException("Valor de 'mod' inválido.");
      for (SEFAZModeloDocumento e : values())
        if (e.xmlData.equals(v)) return e;
      throw new IllegalArgumentException("Valor XML desconhecido para 'mod': '" + v + "'.");
    }

    /**
     * Retorna os valores atualmente válidos, não retorna os valores que foram removidos da versão mais atual.<br>
     *
     * @return valores aceitos na tag nfe\infNFe\ide\mod.
     */
    public SEFAZModeloDocumento[] values_nfe_infNFe_ide_mod() {
      return new SEFAZModeloDocumento[] { NFE_55, NFCE_65 };
    }

    /**
     * Retorna os valores atualmente válidos, não retorna os valores que foram removidos da versão mais atual.<br>
     *
     * @return valores aceitos na tag nfe\infNFe\ide\refECF\mod.
     */
    public SEFAZModeloDocumento[] values_nfe_infNFe_ide_NFref_refECF_mod() {
      return new SEFAZModeloDocumento[] { MAQUINAREGISTRADORA_MODEL2B, PDV_2C, ECF_2D };
    }

    /**
     * Retorna os valores atualmente válidos, não retorna os valores que foram removidos da versão mais atual.<br>
     *
     * @return valores aceitos na tag nfe\infNFe\ide\NFref\mod.
     */
    public SEFAZModeloDocumento[] values_nfe_infNFe_ide_NFref_refNFP_mod() {
      return new SEFAZModeloDocumento[] { TALAO_01, PRODUTOR_04 };
    }

    /**
     * Retorna os valores atualmente válidos, não retorna os valores que foram removidos da versão mais atual.<br>
     *
     * @return valores aceitos na tag nfe\infNFe\ide\NFref\mod.
     */
    public SEFAZModeloDocumento[] values_nfe_infNFe_ide_NFref_refNF_mod() {
      return new SEFAZModeloDocumento[] { TALAO_01, TALAO_02 };
    }
  }

  /**
   * Tipo de Operação — <b>tag B11: {@code tpNF}</b>.<br>
   * Define o sentido da operação: entrada (0) ou saída (1).
   */
  public enum SEFAZTipoOperacao {
    /** <b>0</b> – Entrada. */
    ENTRADA("0", false),

    /** <b>1</b> – Saída. */
    SAIDA("1", false);

    private final String xmlData;
    private final boolean deprecated;

    SEFAZTipoOperacao(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Valor exato do XML para <b>B11 tpNF</b>. */
    public String getXMLData() {
      return xmlData;
    }

    /** Indicador de descontinuidade/obsolescência. */
    public boolean isDeprecated() {
      return deprecated;
    }

    /**
     * Converte o valor do XML do campo <b>B11 tpNF</b>.
     */
    public static SEFAZTipoOperacao valueOfXMLData(String v) {
      if (v == null || (v = v.trim()).isEmpty()) throw new IllegalArgumentException("Valor de 'tpNF' inválido.");
      for (SEFAZTipoOperacao e : values())
        if (e.xmlData.equals(v)) return e;
      throw new IllegalArgumentException("Valor XML desconhecido para 'tpNF': '" + v + "'.");
    }
  }

  /**
   * Destino da Operação — <b>tag B11a: {@code idDest}</b>.<br>
   * Indica se a operação é interna, interestadual ou com o exterior.
   */
  public enum SEFAZDestinoOperacao {
    /** <b>1</b> – Operação interna (dentro da UF). */
    INTERNA("1", false),
    /** <b>2</b> – Operação interestadual (entre UFs). */
    INTERESTADUAL("2", false),
    /** <b>3</b> – Operação com o exterior. */
    EXTERIOR("3", false);

    private final String xmlData;
    private final boolean deprecated;

    SEFAZDestinoOperacao(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Valor exato do XML para <b>B11a idDest</b>. */
    public String getXMLData() {
      return xmlData;
    }

    /** Indicador de descontinuidade/obsolescência. */
    public boolean isDeprecated() {
      return deprecated;
    }

    /**
     * Converte o valor do XML do campo <b>B11a idDest</b>.
     */
    public static SEFAZDestinoOperacao valueOfXMLData(String v) {
      if (v == null || (v = v.trim()).isEmpty()) throw new IllegalArgumentException("Valor de 'idDest' inválido.");
      for (SEFAZDestinoOperacao e : values())
        if (e.xmlData.equals(v)) return e;
      throw new IllegalArgumentException("Valor XML desconhecido para 'idDest': '" + v + "'.");
    }
  }

  /**
   * Ambiente de autorização — <b>tag B24: {@code tpAmb}</b>.<br>
   * Define se a emissão ocorre em Produção (1) ou Homologação (2).
   */
  public enum SEFAZAmbiente {
    /** <b>1</b> – Produção. */
    PRODUCAO("1", false),
    /** <b>2</b> – Homologação. */
    HOMOLOGACAO("2", false);

    private final String xmlData;
    private final boolean deprecated;

    SEFAZAmbiente(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Valor exato do XML para <b>B24 tpAmb</b>. */
    public String getXMLData() {
      return xmlData;
    }

    /** Indicador de descontinuidade/obsolescência. */
    public boolean isDeprecated() {
      return deprecated;
    }

    /**
     * Converte o valor do XML do campo <b>B24 tpAmb</b>.
     */
    public static SEFAZAmbiente valueOfXMLData(String v) {
      if (v == null || (v = v.trim()).isEmpty()) throw new IllegalArgumentException("Valor de 'tpAmb' inválido.");
      for (SEFAZAmbiente e : values())
        if (e.xmlData.equals(v)) return e;
      throw new IllegalArgumentException("Valor XML desconhecido para 'tpAmb': '" + v + "'.");
    }
  }

  /**
   * Finalidade da NF-e — <b>tag B25: {@code finNFe}</b>.<br>
   * Determina a natureza da emissão (normal, complementar, ajuste, devolução).
   */
  public enum SEFAZFinalidadeNFe {
    /** <b>1</b> – NF-e normal. */
    NORMAL("1", false),
    /** <b>2</b> – NF-e complementar. */
    COMPLEMENTAR("2", false),
    /** <b>3</b> – NF-e de ajuste. */
    AJUSTE("3", false),
    /** <b>4</b> – Devolução de mercadoria. */
    DEVOLUCAO("4", false);

    private final String xmlData;
    private final boolean deprecated;

    SEFAZFinalidadeNFe(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Valor exato do XML para <b>B25 finNFe</b>. */
    public String getXMLData() {
      return xmlData;
    }

    /** Indicador de descontinuidade/obsolescência. */
    public boolean isDeprecated() {
      return deprecated;
    }

    /**
     * Converte o valor do XML do campo <b>B25 finNFe</b>.
     */
    public static SEFAZFinalidadeNFe valueOfXMLData(String v) {
      if (v == null || (v = v.trim()).isEmpty()) throw new IllegalArgumentException("Valor de 'finNFe' inválido.");
      for (SEFAZFinalidadeNFe e : values())
        if (e.xmlData.equals(v)) return e;
      throw new IllegalArgumentException("Valor XML desconhecido para 'finNFe': '" + v + "'.");
    }
  }

  /**
   * Indicador de operação com consumidor final — <b>tag B25a: {@code indFinal}</b>.<br>
   * Sinaliza se a operação atende consumidor final (1) ou não (0).
   */
  public enum SEFAZIndicadorConsumidorFinal {
    /** <b>0</b> – Operação NÃO é com consumidor final. */
    NAO("0", false),
    /** <b>1</b> – Operação com consumidor final. */
    SIM("1", false);

    private final String xmlData;
    private final boolean deprecated;

    SEFAZIndicadorConsumidorFinal(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Valor exato do XML para <b>B25a indFinal</b>. */
    public String getXMLData() {
      return xmlData;
    }

    /** Indicador de descontinuidade/obsolescência. */
    public boolean isDeprecated() {
      return deprecated;
    }

    /**
     * Converte o valor do XML do campo <b>B25a indFinal</b>.
     */
    public static SEFAZIndicadorConsumidorFinal valueOfXMLData(String v) {
      if (v == null || (v = v.trim()).isEmpty()) throw new IllegalArgumentException("Valor de 'indFinal' inválido.");
      for (SEFAZIndicadorConsumidorFinal e : values())
        if (e.xmlData.equals(v)) return e;
      throw new IllegalArgumentException("Valor XML desconhecido para 'indFinal': '" + v + "'.");
    }
  }

  /**
   * Indicador de presença do comprador — <b>tag B25b: {@code indPres}</b>.<br>
   * Classifica como se deu a presença do adquirente no momento da operação (presencial, internet, teleatendimento, entrega em domicílio, etc.).<br>
   * Alguns valores têm aplicabilidade predominante à NFC-e.
   */
  public enum SEFAZIndicadorPresenca {
    /** <b>0</b> – Não se aplica (ex.: NF complementar/ajuste). */
    NAO_SE_APLICA("0", false),
    /** <b>1</b> – Operação presencial. */
    PRESENCIAL("1", false),
    /** <b>2</b> – Não presencial, pela Internet. */
    INTERNET("2", false),
    /** <b>3</b> – Não presencial, por teleatendimento. */
    TELEATENDIMENTO("3", false),
    /** <b>4</b> – NFC-e com entrega em domicílio. */
    ENTREGA_DOMICILIO("4", false),
    /** <b>5</b> – Presencial, fora do estabelecimento. */
    PRESENCIAL_FORA_ESTAB("5", false),
    /** <b>9</b> – Não presencial, outros. */
    NAO_PRESENCIAL_OUTROS("9", false);

    private final String xmlData;
    private final boolean deprecated;

    SEFAZIndicadorPresenca(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Valor exato do XML para <b>B25b indPres</b>. */
    public String getXMLData() {
      return xmlData;
    }

    /** Indicador de descontinuidade/obsolescência. */
    public boolean isDeprecated() {
      return deprecated;
    }

    /**
     * Converte o valor do XML do campo <b>B25b indPres</b>.
     */
    public static SEFAZIndicadorPresenca valueOfXMLData(String v) {
      if (v == null || (v = v.trim()).isEmpty()) throw new IllegalArgumentException("Valor de 'indPres' inválido.");
      for (SEFAZIndicadorPresenca e : values())
        if (e.xmlData.equals(v)) return e;
      throw new IllegalArgumentException("Valor XML desconhecido para 'indPres': '" + v + "'.");
    }
  }

  /**
   * Indicador de intermediação/marketplace — <b>tag B25c: {@code indIntermed}</b>.<br>
   * Criado na NT 2020.006. Informa se a operação foi realizada sem ou com intermediador/marketplace (plataforma de terceiros).
   */
  public enum SEFAZIndicadorIntermediador {
    /** <b>0</b> – Operação sem intermediador (site/plataforma própria). */
    SEM_INTERMEDIADOR("0", false),
    /** <b>1</b> – Operação com intermediador/marketplace. */
    COM_INTERMEDIADOR("1", false);

    private final String xmlData;
    private final boolean deprecated;

    SEFAZIndicadorIntermediador(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Valor exato do XML para <b>B25c indIntermed</b>. */
    public String getXMLData() {
      return xmlData;
    }

    /** Indicador de descontinuidade/obsolescência. */
    public boolean isDeprecated() {
      return deprecated;
    }

    /**
     * Converte o valor do XML do campo <b>B25c indIntermed</b>.
     */
    public static SEFAZIndicadorIntermediador valueOfXMLData(String v) {
      if (v == null || (v = v.trim()).isEmpty()) throw new IllegalArgumentException("Valor de 'indIntermed' inválido.");
      for (SEFAZIndicadorIntermediador e : values())
        if (e.xmlData.equals(v)) return e;
      throw new IllegalArgumentException("Valor XML desconhecido para 'indIntermed': '" + v + "'.");
    }
  }

  /**
   * Processo de emissão da NF-e — <b>tag B26: {@code procEmi}</b>.<br>
   * Identifica como a NF foi emitida: aplicativo do contribuinte, emissão avulsa pelo Fisco, emissão avulsa pelo contribuinte no site do Fisco, ou aplicativo fornecido pelo Fisco.
   */
  public enum SEFAZProcessoEmissao {
    /**
     * <b>0</b> – Emissão de NF-e com aplicativo do contribuinte.
     */
    CONTRIBUINTE_APLICATIVO_PROPRIO("0", false),

    /**
     * <b>1</b> – Emissão de NF-e avulsa pelo Fisco.
     */
    AVULSA_FISCO("1", false),

    /**
     * <b>2</b> – Emissão de NF-e avulsa, pelo contribuinte com seu certificado digital, através do site do Fisco.
     */
    AVULSA_SITE_FISCO_CERT_CONTRIBUINTE("2", false),

    /**
     * <b>3</b> – Emissão de NF-e pelo contribuinte com aplicativo fornecido pelo Fisco.
     */
    APLICATIVO_FORNECIDO_PELO_FISCO("3", false);

    private final String xmlData;
    private final boolean deprecated;

    SEFAZProcessoEmissao(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Valor exato do XML para <b>B26 procEmi</b>. */
    public String getXMLData() {
      return xmlData;
    }

    /** Indicador de descontinuidade/obsolescência. */
    public boolean isDeprecated() {
      return deprecated;
    }

    /**
     * Converte o valor do XML do campo <b>B26 procEmi</b>.
     */
    public static SEFAZProcessoEmissao valueOfXMLData(String v) {
      if (v == null || (v = v.trim()).isEmpty()) throw new IllegalArgumentException("Valor de 'procEmi' inválido.");
      for (SEFAZProcessoEmissao e : values())
        if (e.xmlData.equals(v)) return e;
      throw new IllegalArgumentException("Valor XML desconhecido para 'procEmi': '" + v + "'.");
    }
  }

  /**
   * Indicador da IE do Destinatário — <b>tag E16a: indIEDest</b>.<br>
   * Define a situação do destinatário perante o cadastro de contribuintes do ICMS.
   * <ul>
   * <li><b>1</b> – Contribuinte do ICMS (informar a tag IE do destinatário).</li>
   * <li><b>2</b> – Contribuinte isento de IE (não informar a tag IE).</li>
   * <li><b>9</b> – Não contribuinte, podendo ou não possuir IE no cadastro (para NFC-e informar 9; em operações com o exterior informar 9 e não informar a tag IE).</li>
   * </ul>
   */
  public enum SEFAZIndicadorIEDest {
    CONTRIBUINTE_ICMS("1", false), CONTRIBUINTE_ISENTO_IE("2", false), NAO_CONTRIBUINTE("9", false);

    private final String xmlData;
    private final boolean deprecated;

    SEFAZIndicadorIEDest(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Valor exato do XML para <b>E16a indIEDest</b>. */
    public String getXMLData() {
      return xmlData;
    }

    /** Indicador de descontinuidade. */
    public boolean isDeprecated() {
      return deprecated;
    }

    /**
     * Converte o valor do XML do campo <b>E16a indIEDest</b>.
     *
     * @param v valor textual do XML (ex.: "1","2","9")
     */
    public static SEFAZIndicadorIEDest valueOfXMLData(String v) {
      if (v == null || (v = v.trim()).isEmpty()) throw new IllegalArgumentException("Valor de 'indIEDest' inválido.");
      for (SEFAZIndicadorIEDest e : values())
        if (e.xmlData.equals(v)) return e;
      throw new IllegalArgumentException("Valor XML desconhecido para 'indIEDest': '" + v + "'.");
    }
  }

  /**
   * Indicador de Escala Relevante — <b>tag I05d: indEscala</b>.<br>
   * Utilizado para informar se o produto é fabricado em escala relevante, conforme Cláusula 23 do Convênio ICMS 52/2017.<br>
   * Obrigatório para produtos com NCM relacionado no Anexo XXVII do Convênio 52/2017.
   *
   * Valores XML:
   * <ul>
   * <li><b>S</b> – Produzido em Escala Relevante;</li>
   * <li><b>N</b> – Produzido em Escala NÃO Relevante.</li>
   * </ul>
   */
  public enum SEFAZIndicadorEscalaRelevante {

    /**
     * S – Produzido em Escala Relevante.
     */
    PRODUZIDO_EM_ESCALA_RELEVANTE("S", false),

    /**
     * N – Produzido em Escala NÃO Relevante.
     */
    PRODUZIDO_EM_ESCALA_NAO_RELEVANTE("N", false);

    /**
     * Valor exato gravado/lido no XML para a tag I05d indEscala.
     */
    private final String xmlData;

    /**
     * Indica se o valor se encontra obsoleto/descontinuado.
     */
    private final boolean deprecated;

    SEFAZIndicadorEscalaRelevante(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /**
     * Recupera o valor a ser utilizado no XML (campo I05d indEscala).
     *
     * @return String com o valor XML correspondente ("S" ou "N").
     */
    public String getXMLData() {
      return this.xmlData;
    }

    /**
     * Informa se o valor está obsoleto para uso em novas emissões.
     *
     * @return {@code true} se obsoleto; {@code false} caso contrário.
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Converte o valor de XML da tag I05d indEscala para a enumeração correspondente.
     *
     * @param xmlValue Valor vindo do XML (por exemplo: "S" ou "N").
     * @return Enum correspondente ao valor informado.
     * @throws IllegalArgumentException Caso o valor seja nulo, vazio ou não mapeado.
     */
    public static SEFAZIndicadorEscalaRelevante valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'indEscala' no XML não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'indEscala' no XML não pode ser vazio.");
      }
      for (SEFAZIndicadorEscalaRelevante e : SEFAZIndicadorEscalaRelevante.values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Valor XML desconhecido para 'indEscala': '" + xmlValue + "'.");
    }
  }

  /**
   * Indicador de Totalização do Item — <b>tag I17b: indTot</b>.<br>
   * Define se o valor do item (campo vProd) compõe o valor total da NF-e (vProd).<br>
   * Campo utilizado para controle de inclusão ou exclusão de itens na somatória total da nota fiscal eletrônica. (Versão 2.0 do layout da NF-e).
   *
   * Valores XML:
   * <ul>
   * <li><b>0</b> – Valor do item NÃO compõe o valor total da NF-e.</li>
   * <li><b>1</b> – Valor do item compõe o valor total da NF-e.</li>
   * </ul>
   */
  public enum SEFAZIndicadorTotalItem {

    /**
     * 0 – Valor do item não compõe o valor total da NF-e.
     */
    NAO_COMPÕE_TOTAL("0", false),

    /**
     * 1 – Valor do item compõe o valor total da NF-e.
     */
    COMPÕE_TOTAL("1", false);

    /**
     * Valor exato gravado/lido no XML para a tag I17b indTot.
     */
    private final String xmlData;

    /**
     * Indica se o valor está obsoleto/descontinuado para uso atual.
     */
    private final boolean deprecated;

    SEFAZIndicadorTotalItem(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /**
     * Retorna o valor XML correspondente à enumeração (campo I17b indTot).
     *
     * @return String com o valor XML ("0" ou "1").
     */
    public String getXMLData() {
      return this.xmlData;
    }

    /**
     * Informa se o valor está obsoleto para uso atual.
     *
     * @return {@code true} se estiver obsoleto; {@code false} caso contrário.
     */
    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Converte o valor recebido do XML (campo I17b indTot) para a enumeração correspondente.
     *
     * @param xmlValue Valor vindo do XML ("0" ou "1").
     * @return Enum correspondente.
     * @throws IllegalArgumentException Caso o valor seja nulo, vazio ou não mapeado.
     */
    public static SEFAZIndicadorTotalItem valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'indTot' no XML não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'indTot' no XML não pode ser vazio.");
      }
      for (SEFAZIndicadorTotalItem e : SEFAZIndicadorTotalItem.values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Valor XML desconhecido para 'indTot': '" + xmlValue + "'.");
    }
  }

  /**
   * Description: Origem da mercadoria (campo {@code orig}, ID N11) usada nos grupos de ICMS do item (ICMS00 – N02, ICMS10 – N03, ICMS20 – N04, ICMS30 – N05 e ICMS40 – N06).<br>
   * Cada valor possui o código exato utilizado no XML e a descrição resumida do tipo de origem.
   *
   * <p>
   * Códigos oficiais:
   * </p>
   * <ul>
   * <li>0 – Nacional, exceto as indicadas nos códigos 3, 4, 5 e 8;</li>
   * <li>1 – Estrangeira, importação direta, exceto a indicada no código 6;</li>
   * <li>2 – Estrangeira, adquirida no mercado interno, exceto a indicada no código 7;</li>
   * <li>3 – Nacional, mercadoria ou bem com Conteúdo de Importação &gt; 40% e <= 70%;</li>
   * <li>4 – Nacional, cuja produção siga processos produtivos básicos previstos em legislação;</li>
   * <li>5 – Nacional, mercadoria ou bem com Conteúdo de Importação <= 40%;</li>
   * <li>6 – Estrangeira, importação direta, sem similar nacional, em lista CAMEX, e gás natural;</li>
   * <li>7 – Estrangeira, adquirida no mercado interno, sem similar nacional, em lista CAMEX, e gás natural;</li>
   * <li>8 – Nacional, mercadoria ou bem com Conteúdo de Importação &gt; 70%.</li>
   * </ul>
   *
   * @author BIS DEVil
   * @since 1.0.0
   */
  public enum SEFAZOrigemMercadoria {

    NACIONAL_EXCETO_3_4_5_8("0", false), ESTRANGEIRA_IMPORTACAO_DIRETA_EXCETO_6("1", false), ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO_EXCETO_7("2", false), NACIONAL_CONTEUDO_IMPORTACAO_40_ATE_70("3", false), NACIONAL_PROCESSO_PRODUTIVO_BASICO("4", false), NACIONAL_CONTEUDO_IMPORTACAO_ATE_40("5",
        false), ESTRANGEIRA_IMPORTACAO_DIRETA_SEM_SIMILAR_CAMEX_GAS("6", false), ESTRANGEIRA_MERCADO_INTERNO_SEM_SIMILAR_CAMEX_GAS("7", false), NACIONAL_CONTEUDO_IMPORTACAO_ACIMA_70("8", false);

    private final String xmlData;
    private final boolean deprecated;

    SEFAZOrigemMercadoria(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Valor a ser gravado/lido no XML (campo {@code orig}). */
    public String getXMLData() {
      return this.xmlData;
    }

    /** Indica se o código está obsoleto para novas emissões. */
    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Converte o valor do XML em enum.
     *
     * @param xmlValue código numérico do campo {@code orig}.
     * @return enum correspondente
     */
    public static SEFAZOrigemMercadoria valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'orig' no XML não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'orig' no XML não pode ser vazio.");
      }
      for (SEFAZOrigemMercadoria e : SEFAZOrigemMercadoria.values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Valor XML desconhecido para 'orig': '" + xmlValue + "'.");
    }
  }

  /**
   * Description: Código de Situação Tributária do ICMS (campo {@code CST}, ID N12) utilizado nos grupos de ICMS do item (ICMS00, ICMS10, ICMS20, ICMS30, ICMS40).<br>
   * Esta enum consolida os códigos presentes nos grupos N02/N03/N04/N05/N06.
   *
   * <p>
   * Códigos mapeados neste estágio:
   * </p>
   * <ul>
   * <li>00 – Tributada integralmente (ICMS00 – N02);</li>
   * <li>10 – Tributada e com cobrança do ICMS por substituição tributária (ICMS10 – N03);</li>
   * <li>20 – Com redução de base de cálculo (ICMS20 – N04);</li>
   * <li>30 – Isenta ou não tributada e com cobrança do ICMS por substituição tributária (ICMS30 – N05);</li>
   * <li>40 – Isenta (ICMS40 – N06);</li>
   * <li>41 – Não tributada (ICMS40 – N06);</li>
   * <li>50 – Suspensão (ICMS40 – N06).</li>
   * </ul>
   */
  public enum SEFAZICMSCST {

    /**
     *
     */
    TRIBUTADA_INTEGRALMENTE_00("00", false),
    /**
     *
     */
    TRIBUTADA_COM_ST_10("10", false),
    /**
     *
     */
    REDUCAO_BASE_CALCULO_20("20", false),
    /**
     *
     */
    ISENTA_OU_NAO_TRIBUTADA_COM_ST_30("30", false),
    /**
     * 40 - Isenta. Utilizado nos grupos ICMS40/41/50.
     */
    ISENTA_40("40", false),

    /**
     * 41 - Não tributada. Utilizado nos grupos ICMS40/41/50.
     */
    NAO_TRIBUTADA_41("41", false),

    /**
     * 50 - Suspensão. Utilizado nos grupos ICMS40/41/50.
     */
    SUSPENSAO_50("50", false),

    /**
     * 51 - Diferimento. Utilizado no grupo ICMS51.
     */
    DIFERIMENTO_51("51", false),

    /**
     * 60 - ICMS cobrado anteriormente por substituição tributária. Utilizado no grupo ICMS60.
     */
    ICMS_ST_COBRADO_ANTERIORMENTE_60("60", false),

    /**
     * 70 - Redução da base de cálculo e cobrança do ICMS por substituição tributária. Utilizado no grupo ICMS70.
     */
    REDUCAO_BC_COM_ST_70("70", false),

    /**
     * 90 - Outros. Utilizado no grupo ICMS90.
     */
    OUTROS_90("90", false);

    private final String xmlData;
    private final boolean deprecated;

    SEFAZICMSCST(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Valor a ser gravado/lido no XML (campo {@code CST}). */
    public String getXMLData() {
      return this.xmlData;
    }

    public boolean isDeprecated() {
      return this.deprecated;
    }

    /**
     * Converte o valor do XML em enum.
     *
     * @param xmlValue código numérico do campo {@code CST}.
     * @return enum correspondente
     */
    public static SEFAZICMSCST valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'CST' no XML não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'CST' no XML não pode ser vazio.");
      }
      for (SEFAZICMSCST e : SEFAZICMSCST.values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Valor XML desconhecido para 'CST': '" + xmlValue + "'.");
    }
  }

  /**
   * Description: Modalidade de determinação da Base de Cálculo do ICMS (campo {@code modBC}, ID N13) para os grupos ICMS00 (N02), ICMS10 (N03) e ICMS20 (N04).<br>
   * Consolida as modalidades presentes nas tabelas:
   *
   * <ul>
   * <li>0 – Margem de Valor Agregado (%);</li>
   * <li>1 – Pauta (valor);</li>
   * <li>2 – Preço tabelado máximo (valor);</li>
   * <li>3 – Valor da operação.</li>
   * </ul>
   */
  public enum SEFAZModalidadeBaseCalculoICMS {

    MARGEM_VALOR_AGREGADO("0", false), PAUTA_VALOR("1", false), PRECO_TABELADO_MAXIMO("2", false), VALOR_OPERACAO("3", false);

    private final String xmlData;
    private final boolean deprecated;

    SEFAZModalidadeBaseCalculoICMS(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Valor a ser gravado/lido no XML (campo {@code modBC}). */
    public String getXMLData() {
      return this.xmlData;
    }

    public boolean isDeprecated() {
      return this.deprecated;
    }

    public static SEFAZModalidadeBaseCalculoICMS valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'modBC' no XML não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'modBC' no XML não pode ser vazio.");
      }
      for (SEFAZModalidadeBaseCalculoICMS e : SEFAZModalidadeBaseCalculoICMS.values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Valor XML desconhecido para 'modBC': '" + xmlValue + "'.");
    }
  }

  /**
   * Description: Modalidade de determinação da Base de Cálculo do ICMS ST (campo {@code modBCST}, ID N18) usada nos grupos ICMS10 (N03) e ICMS30 (N05).<br>
   * A enum consolida todos os códigos descritos nas tabelas:
   *
   * <ul>
   * <li>0 – Preço tabelado ou máximo sugerido;</li>
   * <li>1 – Lista Negativa (valor);</li>
   * <li>2 – Lista Positiva (valor);</li>
   * <li>3 – Lista Neutra (valor);</li>
   * <li>4 – Margem de Valor Agregado (%);</li>
   * <li>5 – Pauta (valor);</li>
   * <li>6 – Valor da operação (NT 2019.001).</li>
   * </ul>
   */
  public enum SEFAZModalidadeBaseCalculoICMSST {

    PRECO_TABELADO_MAX_SUGERIDO("0", false), LISTA_NEGATIVA("1", false), LISTA_POSITIVA("2", false), LISTA_NEUTRA("3", false), MARGEM_VALOR_AGREGADO("4", false), PAUTA_VALOR("5", false), VALOR_OPERACAO("6", false);

    private final String xmlData;
    private final boolean deprecated;

    SEFAZModalidadeBaseCalculoICMSST(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Valor a ser gravado/lido no XML (campo {@code modBCST}). */
    public String getXMLData() {
      return this.xmlData;
    }

    public boolean isDeprecated() {
      return this.deprecated;
    }

    public static SEFAZModalidadeBaseCalculoICMSST valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'modBCST' no XML não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'modBCST' no XML não pode ser vazio.");
      }
      for (SEFAZModalidadeBaseCalculoICMSST e : SEFAZModalidadeBaseCalculoICMSST.values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Valor XML desconhecido para 'modBCST': '" + xmlValue + "'.");
    }
  }

  /**
   * Description: Motivo da desoneração do ICMS (campo {@code motDesICMS}, ID N28) utilizado nos grupos ICMS20 (N04), ICMS30 (N05) e ICMS40 (N06).<br>
   * Esta enum unifica os códigos listados nas tabelas de N04/N27.1 e N05/N27.1.
   *
   * <p>
   * Códigos consolidados:
   * </p>
   * <ul>
   * <li>3 – Uso na agropecuária;</li>
   * <li>6 – Utilitários e motocicletas da Amazônia Ocidental e Áreas de Livre Comércio;</li>
   * <li>7 – SUFRAMA;</li>
   * <li>9 – Outros;</li>
   * <li>12 – Órgão de fomento e desenvolvimento agropecuário.</li>
   * </ul>
   */
  public enum SEFAZMotivoDesoneracaoICMS {

    /**
     * 1 = Táxi. Utilizado para desoneração de ICMS em operações com veículos destinados a táxi.
     */
    TAXI("1", false),

    /**
     * 2 = Motivo revogado. Motivo "Outros" revogado a partir de 01/01/2016. Mantido apenas para leitura de XMLs antigos.
     */
    OUTROS_REVOGADO("2", true),

    /**
     *
     */
    USO_AGROPECUARIA("3", false),

    /**
     * 4 = Frotista / Locadora. Desoneração para operações com veículos destinados a frotistas ou locadoras.
     */
    FROTISTA_LOCADORA("4", false),

    /**
     * 5 = Diplomático / Consular. Desoneração para representações diplomáticas ou consulares.
     */
    DIPLOMATICO_CONSULAR("5", false),

    /**
     * 6 = Utilitários e motocicletas da Amazônia Ocidental e Áreas de Livre Comércio.
     */
    UTILITARIOS_MOTOCICLETAS_AMAZONIA("6", false),

    /**
     * 7 = SUFRAMA. Desoneração nas operações beneficiadas pela SUFRAMA.
     */
    SUFRAMA("7", false),

    /**
     * 8 = Venda a órgão público.
     */
    VENDA_ORGAO_PUBLICO("8", false),

    /**
     *
     */
    OUTROS("9", false),

    /**
     * 10 = Deficiente físico.
     */
    DEFICIENTE_FISICO("10", false),

    /**
     * 11 = Deficiente visual.
     */
    DEFICIENTE_VISUAL("11", false),
    /**
     *
     */
    ORGAO_FOMENTO_DESENVOLVIMENTO_AGROPECUARIO("12", false);

    private final String xmlData;
    private final boolean deprecated;

    SEFAZMotivoDesoneracaoICMS(String xmlData, boolean deprecated) {
      this.xmlData = xmlData;
      this.deprecated = deprecated;
    }

    /** Valor a ser gravado/lido no XML (campo {@code motDesICMS}). */
    public String getXMLData() {
      return this.xmlData;
    }

    public boolean isDeprecated() {
      return this.deprecated;
    }

    public static SEFAZMotivoDesoneracaoICMS valueOfXMLData(String xmlValue) {
      if (xmlValue == null) {
        throw new IllegalArgumentException("O valor de 'motDesICMS' no XML não pode ser nulo.");
      }
      final String v = xmlValue.trim();
      if (v.isEmpty()) {
        throw new IllegalArgumentException("O valor de 'motDesICMS' no XML não pode ser vazio.");
      }
      for (SEFAZMotivoDesoneracaoICMS e : SEFAZMotivoDesoneracaoICMS.values()) {
        if (e.xmlData.equals(v)) {
          return e;
        }
      }
      throw new IllegalArgumentException("Valor XML desconhecido para 'motDesICMS': '" + xmlValue + "'.");
    }
  }
}