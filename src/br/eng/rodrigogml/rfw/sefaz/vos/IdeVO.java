package br.eng.rodrigogml.rfw.sefaz.vos;

import java.time.LocalDateTime;
import java.util.List;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaDateField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaDateField.DateResolution;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaIntegerField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "ide" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class IdeVO extends RFWVO {

  private static final long serialVersionUID = 5173082771993218096L;

  /**
   * B02 cUF Código da UF do emitente do Documento Fiscal E B01 N 1-1 2<br>
   * Código da UF do emitente do Documento Fiscal. Utilizar a Tabela do IBGE de código de unidades da federação (Seção 8.1 do MOC – Visão Geral, Tabela de UF, Município e País).
   */
  @RFWMetaIntegerField(caption = "cUF", minvalue = 0, maxvalue = 99, required = true)
  private Integer cuf = null;

  /**
   * B03 cNF Código Numérico que compõe a Chave de Acesso E B01 N 1-1 8<br>
   * Código numérico que compõe a Chave de Acesso. Número aleatório gerado pelo emitente para cada NF-e para evitar acessos indevidos da NF-e. (v2.0)
   */
  @RFWMetaIntegerField(caption = "Código Numérico", minvalue = 0, maxvalue = 99999999, required = true)
  private Integer cnf = null;

  /**
   * natOp Descrição da Natureza da Operação E B01 C 1-1 1 - 60<Br>
   * Informar a natureza da operação de que decorrer a saída ou a entrada, tais como: venda, compra, transferência, devolução, importação, consignação, remessa (para fins de demonstração, de industrialização ou outra), conforme previsto na alínea 'i', inciso I, art. 19 do CONVÊNIO S/Nº, de 15 de dezembro de 1970.
   */
  @RFWMetaStringField(caption = "Natureza da Operação", minlength = 1, maxlength = 60, required = true)
  private String natOp = null;

  /**
   * B05 indPag Indicador da forma de pagamento E B01 N 1-1 1<br>
   * <li>0=Pagamento à vista;
   * <li>1=Pagamento a prazo;
   * <li>2=Outros. (Excluído no leiaute 4.0 - NT2016.002)
   *
   * @deprecated Deixou de existir desde a NT2016.002. Mas ainda presente para que seja possível lêr o conteúdo de notas anteriores ao layout 4.
   */
  @Deprecated
  @RFWMetaStringField(caption = "Forma de Pagamento", minlength = 1, maxlength = 1, required = false, pattern = "^(0|1|2)$")
  private String indPag = null;

  /**
   * B06 mod Código do Modelo do Documento Fiscal E B01 N 1-1 2
   * <li>55=NF-e emitida em substituição ao modelo 1 ou 1A;
   * <li>65=NFC-e, utilizada nas operações de venda no varejo (a critério da UF aceitar este modelo de documento).
   */
  @RFWMetaStringField(caption = "Modelo do Documento Fiscal", minlength = 2, maxlength = 2, required = true, pattern = "^(55|65)$")
  private String mod = null;

  /**
   * B07 serie Série do Documento Fiscal E B01 N 1-1 1 - 3<br>
   * Série do Documento Fiscal, preencher com zeros na hipótese de a NF-e não possuir série. Série na faixa:
   * <li>[000-889]: Aplicativo do Contribuinte; Emitente=CNPJ; Assinatura pelo e-CNPJ do contribuinte (procEmi<>1,2);
   * <li>[890-899]: Emissão no site do Fisco (NFA-e - Avulsa); Emitente= CNPJ / CPF; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1);
   * <li>[900-909]: Emissão no site do Fisco (NFA-e); Emitente= CNPJ; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1), ou Assinatura pelo e-CNPJ do contribuinte (procEmi=2);
   * <li>[910-919]: Emissão no site do Fisco (NFA-e); Emitente= CPF; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1), ou Assinatura pelo e-CPF do contribuinte (procEmi=2);
   * <li>[920-969]: Aplicativo do Contribuinte; Emitente=CPF; Assinatura pelo e-CPF do contribuinte (procEmi<>1,2); (Atualizado NT 2018/001)
   *
   */
  @RFWMetaIntegerField(caption = "Série", minvalue = 0, maxvalue = 969, required = true)
  private Integer serie = null;

  /**
   * B08 nNF Número do Documento Fiscal E B01 N 1-1 1 - 9<br>
   * Número do Documento Fiscal.
   */
  @RFWMetaIntegerField(caption = "Número", minvalue = 1, maxvalue = 999999999, required = true)
  private Integer nnf = null;

  /**
   * B09 dhEmi Data e hora de emissão do Documento Fiscal E B01 D 1-1<br>
   * Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD
   */
  @RFWMetaDateField(caption = "Data e Hora Emissão", required = true, resolution = DateResolution.SECOND)
  private LocalDateTime dhEmi = null;

  /**
   * B10 dhSaiEnt Data e hora de Saída ou da Entrada da Mercadoria/Produto E B01 D 0-1<Br>
   * Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD. <br>
   * Observação: Não informar este campo para a NFC-e.
   */
  @RFWMetaDateField(caption = "Data e Hora Entrada/Saída", required = true, resolution = DateResolution.SECOND)
  private LocalDateTime dhSaiEnt = null;

  /**
   * B11 tpNF Tipo de Operação E B01 N 1-1 1
   * <li>0=Entrada;
   * <li>1=Saída
   */
  @RFWMetaStringField(caption = "Tipo de Operação", minlength = 1, maxlength = 1, required = true, pattern = "^(0|1)$")
  private String tpNF = null;

  /**
   * B11a idDest Identificador de local de destino da operação E B01 N 1-1 1
   * <li>1=Operação interna;
   * <li>2=Operação interestadual;
   * <li>3=Operação com exterior
   */
  @RFWMetaStringField(caption = "Destino da Operação", minlength = 1, maxlength = 1, required = true, pattern = "^(0|1|2)$")
  private String idDist = null;

  /**
   * B12 cMunFG Código do Município de Ocorrência do Fato Gerador E B01 N 1-1 7<br>
   * Informar o município de ocorrência do fato gerador do ICMS. Utilizar a Tabela do IBGE (Seção 8.2 do MOC – Visão Geral, Tabela de UF, Município e País)
   */
  @RFWMetaIntegerField(caption = "Código do Município do Fato Gerador", minvalue = 0, maxvalue = 9999999, required = true)
  private Integer cMunFG = null;

  /**
   * B21 tpImp Formato de Impressão do DANFE E B01 N 1-1 1
   * <li>0=Sem geração de DANFE;
   * <li>1=DANFE normal, Retrato;
   * <li>2=DANFE normal, Paisagem;
   * <li>3=DANFE Simplificado; 4=DANFE NFC-e;
   * <li>5=DANFE NFC-e em mensagem eletrônica (o envio de mensagem eletrônica pode ser feita de forma simultânea com a impressão do DANFE; usar o tpImp=5 quando esta for a única forma de disponibilização do DANFE)
   */
  @RFWMetaStringField(caption = "Formato de Impressão", minlength = 1, maxlength = 1, required = true)
  private String tpImp = null;

  /**
   * B22 tpEmis Tipo de Emissão da NF-e E B01 N 1-1 1
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
   */
  @RFWMetaStringField(caption = "Tipo de Emissão", minlength = 1, maxlength = 1, required = true, pattern = "^(1|2|3|4|5|7|9)$")
  private String tpEmis = null;

  /**
   * B23 cDV Dígito Verificador da Chave de Acesso da NF-e E B01 N 1-1 1<br>
   * Informar o DV da Chave de Acesso da NF-e, o DV será calculado com a aplicação do algoritmo módulo 11 (base 2,9) da Chave de Acesso. (vide item 5.4 do MOC – Visão Geral)
   */
  @RFWMetaIntegerField(caption = "Dígito Verificador", minvalue = 0, maxvalue = 9, required = true)
  private Integer cdv = null;

  /**
   * B24 tpAmb Identificação do Ambiente E B01 N 1-1 1
   * <li>1=Produção;
   * <li>2=Homologação
   */
  @RFWMetaStringField(caption = "Identificação do Ambiente", minlength = 1, maxlength = 1, required = true, pattern = "^(1|2)$")
  private String tpAmb = null;

  /**
   * B25 finNFe Finalidade de emissão da NF-e E B01 N 1-1 1
   * <li>1=NF-e normal;
   * <li>2=NF-e complementar;
   * <li>3=NF-e de ajuste;
   * <li>4=Devolução de mercadoria
   */
  @RFWMetaStringField(caption = "Finalidade de Emissão", minlength = 1, maxlength = 1, required = true, pattern = "^(1|2|3|4)$")
  private String finNFe = null;

  /**
   * B25a indFinal Indica operação com Consumidor final E B01 N 1-1 1
   * <li>0=Normal;
   * <li>1=Consumidor final;
   */
  @RFWMetaStringField(caption = "Consumidor Final", minlength = 1, maxlength = 1, required = true, pattern = "^(0|1)$")
  private String indFinal = null;

  /**
   * B25b indPres Indicador de presença do comprador no estabelecimento comercial no momento da operação E B01 N 1-1 1
   * <li>0=Não se aplica (por exemplo, Nota Fiscal complementar ou de ajuste);
   * <li>1=Operação presencial;
   * <li>2=Operação não presencial, pela Internet;
   * <li>3=Operação não presencial, Teleatendimento;
   * <li>4=NFC-e em operação com entrega a domicílio;
   * <li>5=Operação presencial, fora do estabelecimento; (incluído NT2016.002)
   * <li>9=Operação não presencial, outros.
   */
  @RFWMetaStringField(caption = "Indicador de Presença", minlength = 1, maxlength = 1, required = true, pattern = "^(0|1|2|3|4|5|9)$")
  private String indPres = null;

  /**
   * B25c indIntermed Indicador de intermediador/marketplace E B01 N 0-1 1
   * <li>0=Operação sem intermediador (em site ou plataforma própria)
   * <li>1=Operação em site ou plataforma de terceiros (intermediadores/marketplace) <br>
   * <br>
   * <li>Considera-se intermediador/marketplace os prestadores de serviços e de negócios referentes às transações comerciais ou de prestação de serviços intermediadas, realizadas por pessoas jurídicas inscritas no Cadastro Nacional de Pessoa Jurídica - CNPJ ou pessoas físicas inscritas no Cadastro de Pessoa Física - CPF, ainda que não inscritas no cadastro de contribuintes do ICMS. <br>
   * <li>Considera-se site/plataforma própria as vendas que não foram intermediadas (por marketplace), como venda em site próprio, teleatendimento. (Criado na NT 2020.006)
   */
  @RFWMetaStringField(caption = "Intermediador/Marketplace", minlength = 1, maxlength = 1, required = false, pattern = "^(0|1)$")
  private String indIntermid = null;

  /**
   * B26 procEmi Processo de emissão da NF-e E B01 N 1-1 1
   * <li>0=Emissão de NF-e com aplicativo do contribuinte;
   * <li>1=Emissão de NF-e avulsa pelo Fisco;
   * <li>2=Emissão de NF-e avulsa, pelo contribuinte com seu certificado digital, através do site do Fisco;
   * <li>3=Emissão NF-e pelo contribuinte com aplicativo fornecido pelo Fisco.
   */
  @RFWMetaStringField(caption = "Processo de Emissão", minlength = 1, maxlength = 1, required = true, pattern = "^(0|1|2|3)$")
  private String procEmi = null;

  /**
   * B27 verProc Versão do Processo de emissão da NF-e E B01 C 1-1 1- 20<Br>
   * Informar a versão do aplicativo emissor de NF-e
   */
  @RFWMetaStringField(caption = "Versão Processo Emissão", minlength = 1, maxlength = 20, required = true, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String verProc = null;

  /**
   * B28 dhCont Data e Hora da entrada em contingência E B27.1 D 1-1
   * <li>Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD
   */
  @RFWMetaDateField(caption = "Data/Hora Entrada Contigência", required = false, resolution = DateResolution.SECOND)
  private LocalDateTime dhCont = null;

  /**
   * B29 xJust Justificativa da entrada em contingência E B27.1 C 1-1 15 - 256 (v2.0)
   */
  @RFWMetaStringField(caption = "Justificativa Entrada Contigência", minlength = 15, maxlength = 256, required = false)
  private String xjust = null;

  /**
   * BA01 NFref Informação de Documentos Fiscais referenciados G B01 0-500<br>
   * Grupo com informações de Documentos Fiscais referenciados. Informação utilizada nas hipóteses previstas na legislação. (Ex.: Devolução de mercadorias, Substituição de NF cancelada, Complementação de NF, etc.).
   */
  @RFWMetaRelationshipField(caption = "Documentos Referenciados", relationship = RelationshipTypes.ASSOCIATION, required = false, targetRelationship = NFrefVO.class)
  private List<NFrefVO> nfref = null;

  /**
   * # b02 cUF Código da UF do emitente do Documento Fiscal E B01 N 1-1 2<br>
   * Código da UF do emitente do Documento Fiscal. Utilizar a Tabela do IBGE de código de unidades da federação (Seção 8.1 do MOC – Visão Geral, Tabela de UF, Município e País).
   *
   * @return # b02 cUF Código da UF do emitente do Documento Fiscal E B01 N 1-1 2<br>
   *         Código da UF do emitente do Documento Fiscal
   */
  public Integer getCuf() {
    return cuf;
  }

  /**
   * # b02 cUF Código da UF do emitente do Documento Fiscal E B01 N 1-1 2<br>
   * Código da UF do emitente do Documento Fiscal. Utilizar a Tabela do IBGE de código de unidades da federação (Seção 8.1 do MOC – Visão Geral, Tabela de UF, Município e País).
   *
   * @param cuf # b02 cUF Código da UF do emitente do Documento Fiscal E B01 N 1-1 2<br>
   *          Código da UF do emitente do Documento Fiscal
   */
  public void setCuf(Integer cuf) {
    this.cuf = cuf;
  }

  /**
   * # b03 cNF Código Numérico que compõe a Chave de Acesso E B01 N 1-1 8<br>
   * Código numérico que compõe a Chave de Acesso. Número aleatório gerado pelo emitente para cada NF-e para evitar acessos indevidos da NF-e. (v2.0).
   *
   * @return # b03 cNF Código Numérico que compõe a Chave de Acesso E B01 N 1-1 8<br>
   *         Código numérico que compõe a Chave de Acesso
   */
  public Integer getCnf() {
    return cnf;
  }

  /**
   * # b03 cNF Código Numérico que compõe a Chave de Acesso E B01 N 1-1 8<br>
   * Código numérico que compõe a Chave de Acesso. Número aleatório gerado pelo emitente para cada NF-e para evitar acessos indevidos da NF-e. (v2.0).
   *
   * @param cnf # b03 cNF Código Numérico que compõe a Chave de Acesso E B01 N 1-1 8<br>
   *          Código numérico que compõe a Chave de Acesso
   */
  public void setCnf(Integer cnf) {
    this.cnf = cnf;
  }

  /**
   * # natOp Descrição da Natureza da Operação E B01 C 1-1 1 - 60<Br>
   * Informar a natureza da operação de que decorrer a saída ou a entrada, tais como: venda, compra, transferência, devolução, importação, consignação, remessa (para fins de demonstração, de industrialização ou outra), conforme previsto na alínea 'i', inciso I, art. 19 do CONVÊNIO S/Nº, de 15 de dezembro de 1970.
   *
   * @return # natOp Descrição da Natureza da Operação E B01 C 1-1 1 - 60<Br>
   *         Informar a natureza da operação de que decorrer a saída ou a entrada, tais como: venda, compra, transferência, devolução, importação, consignação, remessa (para fins de demonstração, de industrialização ou outra), conforme previsto na alínea 'i', inciso I, art
   */
  public String getNatOp() {
    return natOp;
  }

  /**
   * # natOp Descrição da Natureza da Operação E B01 C 1-1 1 - 60<Br>
   * Informar a natureza da operação de que decorrer a saída ou a entrada, tais como: venda, compra, transferência, devolução, importação, consignação, remessa (para fins de demonstração, de industrialização ou outra), conforme previsto na alínea 'i', inciso I, art. 19 do CONVÊNIO S/Nº, de 15 de dezembro de 1970.
   *
   * @param natOp # natOp Descrição da Natureza da Operação E B01 C 1-1 1 - 60<Br>
   *          Informar a natureza da operação de que decorrer a saída ou a entrada, tais como: venda, compra, transferência, devolução, importação, consignação, remessa (para fins de demonstração, de industrialização ou outra), conforme previsto na alínea 'i', inciso I, art
   */
  public void setNatOp(String natOp) {
    this.natOp = natOp;
  }

  /**
   * # b05 indPag Indicador da forma de pagamento E B01 N 1-1 1<br>
   * <li>0=Pagamento à vista;
   * <li>1=Pagamento a prazo;
   * <li>2=Outros. (Excluído no leiaute 4.0 - NT2016.002).
   *
   * @return # b05 indPag Indicador da forma de pagamento E B01 N 1-1 1<br>
   *         <li>0=Pagamento à vista;
   *         <li>1=Pagamento a prazo;
   *         <li>2=Outros
   */
  public String getIndPag() {
    return indPag;
  }

  /**
   * # b05 indPag Indicador da forma de pagamento E B01 N 1-1 1<br>
   * <li>0=Pagamento à vista;
   * <li>1=Pagamento a prazo;
   * <li>2=Outros. (Excluído no leiaute 4.0 - NT2016.002).
   *
   * @param indPag # b05 indPag Indicador da forma de pagamento E B01 N 1-1 1<br>
   *          <li>0=Pagamento à vista;
   *          <li>1=Pagamento a prazo;
   *          <li>2=Outros
   */
  public void setIndPag(String indPag) {
    this.indPag = indPag;
  }

  /**
   * # b06 mod Código do Modelo do Documento Fiscal E B01 N 1-1 2
   * <li>55=NF-e emitida em substituição ao modelo 1 ou 1A;
   * <li>65=NFC-e, utilizada nas operações de venda no varejo (a critério da UF aceitar este modelo de documento).
   *
   * @return # b06 mod Código do Modelo do Documento Fiscal E B01 N 1-1 2
   *         <li>55=NF-e emitida em substituição ao modelo 1 ou 1A;
   *         <li>65=NFC-e, utilizada nas operações de venda no varejo (a critério da UF aceitar este modelo de documento)
   */
  public String getMod() {
    return mod;
  }

  /**
   * # b06 mod Código do Modelo do Documento Fiscal E B01 N 1-1 2
   * <li>55=NF-e emitida em substituição ao modelo 1 ou 1A;
   * <li>65=NFC-e, utilizada nas operações de venda no varejo (a critério da UF aceitar este modelo de documento).
   *
   * @param mod # b06 mod Código do Modelo do Documento Fiscal E B01 N 1-1 2
   *          <li>55=NF-e emitida em substituição ao modelo 1 ou 1A;
   *          <li>65=NFC-e, utilizada nas operações de venda no varejo (a critério da UF aceitar este modelo de documento)
   */
  public void setMod(String mod) {
    this.mod = mod;
  }

  /**
   * # b07 serie Série do Documento Fiscal E B01 N 1-1 1 - 3<br>
   * Série do Documento Fiscal, preencher com zeros na hipótese de a NF-e não possuir série. Série na faixa:
   * <li>[000-889]: Aplicativo do Contribuinte; Emitente=CNPJ; Assinatura pelo e-CNPJ do contribuinte (procEmi<>1,2);
   * <li>[890-899]: Emissão no site do Fisco (NFA-e - Avulsa); Emitente= CNPJ / CPF; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1);
   * <li>[900-909]: Emissão no site do Fisco (NFA-e); Emitente= CNPJ; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1), ou Assinatura pelo e-CNPJ do contribuinte (procEmi=2);
   * <li>[910-919]: Emissão no site do Fisco (NFA-e); Emitente= CPF; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1), ou Assinatura pelo e-CPF do contribuinte (procEmi=2);
   * <li>[920-969]: Aplicativo do Contribuinte; Emitente=CPF; Assinatura pelo e-CPF do contribuinte (procEmi<>1,2); (Atualizado NT 2018/001).
   *
   * @return # b07 serie Série do Documento Fiscal E B01 N 1-1 1 - 3<br>
   *         Série do Documento Fiscal, preencher com zeros na hipótese de a NF-e não possuir série
   */
  public Integer getSerie() {
    return serie;
  }

  /**
   * # b07 serie Série do Documento Fiscal E B01 N 1-1 1 - 3<br>
   * Série do Documento Fiscal, preencher com zeros na hipótese de a NF-e não possuir série. Série na faixa:
   * <li>[000-889]: Aplicativo do Contribuinte; Emitente=CNPJ; Assinatura pelo e-CNPJ do contribuinte (procEmi<>1,2);
   * <li>[890-899]: Emissão no site do Fisco (NFA-e - Avulsa); Emitente= CNPJ / CPF; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1);
   * <li>[900-909]: Emissão no site do Fisco (NFA-e); Emitente= CNPJ; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1), ou Assinatura pelo e-CNPJ do contribuinte (procEmi=2);
   * <li>[910-919]: Emissão no site do Fisco (NFA-e); Emitente= CPF; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1), ou Assinatura pelo e-CPF do contribuinte (procEmi=2);
   * <li>[920-969]: Aplicativo do Contribuinte; Emitente=CPF; Assinatura pelo e-CPF do contribuinte (procEmi<>1,2); (Atualizado NT 2018/001).
   *
   * @param serie # b07 serie Série do Documento Fiscal E B01 N 1-1 1 - 3<br>
   *          Série do Documento Fiscal, preencher com zeros na hipótese de a NF-e não possuir série
   */
  public void setSerie(Integer serie) {
    this.serie = serie;
  }

  /**
   * # b08 nNF Número do Documento Fiscal E B01 N 1-1 1 - 9<br>
   * Número do Documento Fiscal.
   *
   * @return # b08 nNF Número do Documento Fiscal E B01 N 1-1 1 - 9<br>
   *         Número do Documento Fiscal
   */
  public Integer getNnf() {
    return nnf;
  }

  /**
   * # b08 nNF Número do Documento Fiscal E B01 N 1-1 1 - 9<br>
   * Número do Documento Fiscal.
   *
   * @param nnf # b08 nNF Número do Documento Fiscal E B01 N 1-1 1 - 9<br>
   *          Número do Documento Fiscal
   */
  public void setNnf(Integer nnf) {
    this.nnf = nnf;
  }

  /**
   * # b09 dhEmi Data e hora de emissão do Documento Fiscal E B01 D 1-1<br>
   * Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD.
   *
   * @return # b09 dhEmi Data e hora de emissão do Documento Fiscal E B01 D 1-1<br>
   *         Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD
   */
  public LocalDateTime getDhEmi() {
    return dhEmi;
  }

  /**
   * # b09 dhEmi Data e hora de emissão do Documento Fiscal E B01 D 1-1<br>
   * Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD.
   *
   * @param dhEmi # b09 dhEmi Data e hora de emissão do Documento Fiscal E B01 D 1-1<br>
   *          Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD
   */
  public void setDhEmi(LocalDateTime dhEmi) {
    this.dhEmi = dhEmi;
  }

  /**
   * # b10 dhSaiEnt Data e hora de Saída ou da Entrada da Mercadoria/Produto E B01 D 0-1<Br>
   * Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD. <br>
   * Observação: Não informar este campo para a NFC-e.
   *
   * @return # b10 dhSaiEnt Data e hora de Saída ou da Entrada da Mercadoria/Produto E B01 D 0-1<Br>
   *         Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD
   */
  public LocalDateTime getDhSaiEnt() {
    return dhSaiEnt;
  }

  /**
   * # b10 dhSaiEnt Data e hora de Saída ou da Entrada da Mercadoria/Produto E B01 D 0-1<Br>
   * Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD. <br>
   * Observação: Não informar este campo para a NFC-e.
   *
   * @param dhSaiEnt # b10 dhSaiEnt Data e hora de Saída ou da Entrada da Mercadoria/Produto E B01 D 0-1<Br>
   *          Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD
   */
  public void setDhSaiEnt(LocalDateTime dhSaiEnt) {
    this.dhSaiEnt = dhSaiEnt;
  }

  /**
   * # b11 tpNF Tipo de Operação E B01 N 1-1 1
   * <li>0=Entrada;
   * <li>1=Saída.
   *
   * @return # b11 tpNF Tipo de Operação E B01 N 1-1 1
   *         <li>0=Entrada;
   *         <li>1=Saída
   */
  public String getTpNF() {
    return tpNF;
  }

  /**
   * # b11 tpNF Tipo de Operação E B01 N 1-1 1
   * <li>0=Entrada;
   * <li>1=Saída.
   *
   * @param tpNF # b11 tpNF Tipo de Operação E B01 N 1-1 1
   *          <li>0=Entrada;
   *          <li>1=Saída
   */
  public void setTpNF(String tpNF) {
    this.tpNF = tpNF;
  }

  /**
   * # b11a idDest Identificador de local de destino da operação E B01 N 1-1 1
   * <li>1=Operação interna;
   * <li>2=Operação interestadual;
   * <li>3=Operação com exterior.
   *
   * @return # b11a idDest Identificador de local de destino da operação E B01 N 1-1 1
   *         <li>1=Operação interna;
   *         <li>2=Operação interestadual;
   *         <li>3=Operação com exterior
   */
  public String getIdDist() {
    return idDist;
  }

  /**
   * # b11a idDest Identificador de local de destino da operação E B01 N 1-1 1
   * <li>1=Operação interna;
   * <li>2=Operação interestadual;
   * <li>3=Operação com exterior.
   *
   * @param idDist # b11a idDest Identificador de local de destino da operação E B01 N 1-1 1
   *          <li>1=Operação interna;
   *          <li>2=Operação interestadual;
   *          <li>3=Operação com exterior
   */
  public void setIdDist(String idDist) {
    this.idDist = idDist;
  }

  public Integer getcMunFG() {
    return cMunFG;
  }

  public void setcMunFG(Integer cMunFG) {
    this.cMunFG = cMunFG;
  }

  /**
   * # b21 tpImp Formato de Impressão do DANFE E B01 N 1-1 1
   * <li>0=Sem geração de DANFE;
   * <li>1=DANFE normal, Retrato;
   * <li>2=DANFE normal, Paisagem;
   * <li>3=DANFE Simplificado; 4=DANFE NFC-e;
   * <li>5=DANFE NFC-e em mensagem eletrônica (o envio de mensagem eletrônica pode ser feita de forma simultânea com a impressão do DANFE; usar o tpImp=5 quando esta for a única forma de disponibilização do DANFE).
   *
   * @return # b21 tpImp Formato de Impressão do DANFE E B01 N 1-1 1
   *         <li>0=Sem geração de DANFE;
   *         <li>1=DANFE normal, Retrato;
   *         <li>2=DANFE normal, Paisagem;
   *         <li>3=DANFE Simplificado; 4=DANFE NFC-e;
   *         <li>5=DANFE NFC-e em mensagem eletrônica (o envio de mensagem eletrônica pode ser feita de forma simultânea com a impressão do DANFE; usar o tpImp=5 quando esta for a única forma de disponibilização do DANFE)
   */
  public String getTpImp() {
    return tpImp;
  }

  /**
   * # b21 tpImp Formato de Impressão do DANFE E B01 N 1-1 1
   * <li>0=Sem geração de DANFE;
   * <li>1=DANFE normal, Retrato;
   * <li>2=DANFE normal, Paisagem;
   * <li>3=DANFE Simplificado; 4=DANFE NFC-e;
   * <li>5=DANFE NFC-e em mensagem eletrônica (o envio de mensagem eletrônica pode ser feita de forma simultânea com a impressão do DANFE; usar o tpImp=5 quando esta for a única forma de disponibilização do DANFE).
   *
   * @param tpImp # b21 tpImp Formato de Impressão do DANFE E B01 N 1-1 1
   *          <li>0=Sem geração de DANFE;
   *          <li>1=DANFE normal, Retrato;
   *          <li>2=DANFE normal, Paisagem;
   *          <li>3=DANFE Simplificado; 4=DANFE NFC-e;
   *          <li>5=DANFE NFC-e em mensagem eletrônica (o envio de mensagem eletrônica pode ser feita de forma simultânea com a impressão do DANFE; usar o tpImp=5 quando esta for a única forma de disponibilização do DANFE)
   */
  public void setTpImp(String tpImp) {
    this.tpImp = tpImp;
  }

  /**
   * # b22 tpEmis Tipo de Emissão da NF-e E B01 N 1-1 1
   * <li>1=Emissão normal (não em contingência);
   * <li>2=Contingência FS-IA, com impressão do DANFE em Formulário de Segurança - Impressor Autônomo;
   * <li>3=Contingência SCAN (Sistema de Contingência do Ambiente Nacional); *Desativado * NT 2015/002
   * <li>4=Contingência EPEC (Evento Prévio da Emissão em Contingência);
   * <li>5=Contingência FS-DA, com impressão do DANFE em Formulário de Segurança - Documento Auxiliar;
   * <li>6=Contingência SVC-AN (SEFAZ Virtual de Contingência do AN);
   * <li>7=Contingência SVC-RS (SEFAZ Virtual de Contingência do RS);
   * <li>9=Contingência off-line da NFC-e; <br>
   * Observação: Para a NFC-e somente é válida a opção de contingência: 9-Contingência Off-Line e, a critério da UF, opção 4-Contingência EPEC. (NT 2015/002).
   *
   * @return # b22 tpEmis Tipo de Emissão da NF-e E B01 N 1-1 1
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
  public String getTpEmis() {
    return tpEmis;
  }

  /**
   * # b22 tpEmis Tipo de Emissão da NF-e E B01 N 1-1 1
   * <li>1=Emissão normal (não em contingência);
   * <li>2=Contingência FS-IA, com impressão do DANFE em Formulário de Segurança - Impressor Autônomo;
   * <li>3=Contingência SCAN (Sistema de Contingência do Ambiente Nacional); *Desativado * NT 2015/002
   * <li>4=Contingência EPEC (Evento Prévio da Emissão em Contingência);
   * <li>5=Contingência FS-DA, com impressão do DANFE em Formulário de Segurança - Documento Auxiliar;
   * <li>6=Contingência SVC-AN (SEFAZ Virtual de Contingência do AN);
   * <li>7=Contingência SVC-RS (SEFAZ Virtual de Contingência do RS);
   * <li>9=Contingência off-line da NFC-e; <br>
   * Observação: Para a NFC-e somente é válida a opção de contingência: 9-Contingência Off-Line e, a critério da UF, opção 4-Contingência EPEC. (NT 2015/002).
   *
   * @param tpEmis # b22 tpEmis Tipo de Emissão da NF-e E B01 N 1-1 1
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
  public void setTpEmis(String tpEmis) {
    this.tpEmis = tpEmis;
  }

  /**
   * # b23 cDV Dígito Verificador da Chave de Acesso da NF-e E B01 N 1-1 1<br>
   * Informar o DV da Chave de Acesso da NF-e, o DV será calculado com a aplicação do algoritmo módulo 11 (base 2,9) da Chave de Acesso. (vide item 5.4 do MOC – Visão Geral).
   *
   * @return # b23 cDV Dígito Verificador da Chave de Acesso da NF-e E B01 N 1-1 1<br>
   *         Informar o DV da Chave de Acesso da NF-e, o DV será calculado com a aplicação do algoritmo módulo 11 (base 2,9) da Chave de Acesso
   */
  public Integer getCdv() {
    return cdv;
  }

  /**
   * # b23 cDV Dígito Verificador da Chave de Acesso da NF-e E B01 N 1-1 1<br>
   * Informar o DV da Chave de Acesso da NF-e, o DV será calculado com a aplicação do algoritmo módulo 11 (base 2,9) da Chave de Acesso. (vide item 5.4 do MOC – Visão Geral).
   *
   * @param cdv # b23 cDV Dígito Verificador da Chave de Acesso da NF-e E B01 N 1-1 1<br>
   *          Informar o DV da Chave de Acesso da NF-e, o DV será calculado com a aplicação do algoritmo módulo 11 (base 2,9) da Chave de Acesso
   */
  public void setCdv(Integer cdv) {
    this.cdv = cdv;
  }

  /**
   * # b24 tpAmb Identificação do Ambiente E B01 N 1-1 1
   * <li>1=Produção;
   * <li>2=Homologação.
   *
   * @return # b24 tpAmb Identificação do Ambiente E B01 N 1-1 1
   *         <li>1=Produção;
   *         <li>2=Homologação
   */
  public String getTpAmb() {
    return tpAmb;
  }

  /**
   * # b24 tpAmb Identificação do Ambiente E B01 N 1-1 1
   * <li>1=Produção;
   * <li>2=Homologação.
   *
   * @param tpAmb # b24 tpAmb Identificação do Ambiente E B01 N 1-1 1
   *          <li>1=Produção;
   *          <li>2=Homologação
   */
  public void setTpAmb(String tpAmb) {
    this.tpAmb = tpAmb;
  }

  /**
   * # b25 finNFe Finalidade de emissão da NF-e E B01 N 1-1 1
   * <li>1=NF-e normal;
   * <li>2=NF-e complementar;
   * <li>3=NF-e de ajuste;
   * <li>4=Devolução de mercadoria.
   *
   * @return # b25 finNFe Finalidade de emissão da NF-e E B01 N 1-1 1
   *         <li>1=NF-e normal;
   *         <li>2=NF-e complementar;
   *         <li>3=NF-e de ajuste;
   *         <li>4=Devolução de mercadoria
   */
  public String getFinNFe() {
    return finNFe;
  }

  /**
   * # b25 finNFe Finalidade de emissão da NF-e E B01 N 1-1 1
   * <li>1=NF-e normal;
   * <li>2=NF-e complementar;
   * <li>3=NF-e de ajuste;
   * <li>4=Devolução de mercadoria.
   *
   * @param finNFe # b25 finNFe Finalidade de emissão da NF-e E B01 N 1-1 1
   *          <li>1=NF-e normal;
   *          <li>2=NF-e complementar;
   *          <li>3=NF-e de ajuste;
   *          <li>4=Devolução de mercadoria
   */
  public void setFinNFe(String finNFe) {
    this.finNFe = finNFe;
  }

  /**
   * # b25a indFinal Indica operação com Consumidor final E B01 N 1-1 1
   * <li>0=Normal;
   * <li>1=Consumidor final;.
   *
   * @return # b25a indFinal Indica operação com Consumidor final E B01 N 1-1 1
   *         <li>0=Normal;
   *         <li>1=Consumidor final;
   */
  public String getIndFinal() {
    return indFinal;
  }

  /**
   * # b25a indFinal Indica operação com Consumidor final E B01 N 1-1 1
   * <li>0=Normal;
   * <li>1=Consumidor final;.
   *
   * @param indFinal # b25a indFinal Indica operação com Consumidor final E B01 N 1-1 1
   *          <li>0=Normal;
   *          <li>1=Consumidor final;
   */
  public void setIndFinal(String indFinal) {
    this.indFinal = indFinal;
  }

  /**
   * # b25b indPres Indicador de presença do comprador no estabelecimento comercial no momento da operação E B01 N 1-1 1
   * <li>0=Não se aplica (por exemplo, Nota Fiscal complementar ou de ajuste);
   * <li>1=Operação presencial;
   * <li>2=Operação não presencial, pela Internet;
   * <li>3=Operação não presencial, Teleatendimento;
   * <li>4=NFC-e em operação com entrega a domicílio;
   * <li>5=Operação presencial, fora do estabelecimento; (incluído NT2016.002)
   * <li>9=Operação não presencial, outros.
   *
   * @return # b25b indPres Indicador de presença do comprador no estabelecimento comercial no momento da operação E B01 N 1-1 1
   *         <li>0=Não se aplica (por exemplo, Nota Fiscal complementar ou de ajuste);
   *         <li>1=Operação presencial;
   *         <li>2=Operação não presencial, pela Internet;
   *         <li>3=Operação não presencial, Teleatendimento;
   *         <li>4=NFC-e em operação com entrega a domicílio;
   *         <li>5=Operação presencial, fora do estabelecimento; (incluído NT2016
   */
  public String getIndPres() {
    return indPres;
  }

  /**
   * # b25b indPres Indicador de presença do comprador no estabelecimento comercial no momento da operação E B01 N 1-1 1
   * <li>0=Não se aplica (por exemplo, Nota Fiscal complementar ou de ajuste);
   * <li>1=Operação presencial;
   * <li>2=Operação não presencial, pela Internet;
   * <li>3=Operação não presencial, Teleatendimento;
   * <li>4=NFC-e em operação com entrega a domicílio;
   * <li>5=Operação presencial, fora do estabelecimento; (incluído NT2016.002)
   * <li>9=Operação não presencial, outros.
   *
   * @param indPres # b25b indPres Indicador de presença do comprador no estabelecimento comercial no momento da operação E B01 N 1-1 1
   *          <li>0=Não se aplica (por exemplo, Nota Fiscal complementar ou de ajuste);
   *          <li>1=Operação presencial;
   *          <li>2=Operação não presencial, pela Internet;
   *          <li>3=Operação não presencial, Teleatendimento;
   *          <li>4=NFC-e em operação com entrega a domicílio;
   *          <li>5=Operação presencial, fora do estabelecimento; (incluído NT2016
   */
  public void setIndPres(String indPres) {
    this.indPres = indPres;
  }

  /**
   * # b25c indIntermed Indicador de intermediador/marketplace E B01 N 0-1 1
   * <li>0=Operação sem intermediador (em site ou plataforma própria)
   * <li>1=Operação em site ou plataforma de terceiros (intermediadores/marketplace) <br>
   * <br>
   * <li>Considera-se intermediador/marketplace os prestadores de serviços e de negócios referentes às transações comerciais ou de prestação de serviços intermediadas, realizadas por pessoas jurídicas inscritas no Cadastro Nacional de Pessoa Jurídica - CNPJ ou pessoas físicas inscritas no Cadastro de Pessoa Física - CPF, ainda que não inscritas no cadastro de contribuintes do ICMS. <br>
   * <li>Considera-se site/plataforma própria as vendas que não foram intermediadas (por marketplace), como venda em site próprio, teleatendimento. (Criado na NT 2020.006).
   *
   * @return # b25c indIntermed Indicador de intermediador/marketplace E B01 N 0-1 1
   *         <li>0=Operação sem intermediador (em site ou plataforma própria)
   *         <li>1=Operação em site ou plataforma de terceiros (intermediadores/marketplace) <br>
   *         <br>
   *         <li>Considera-se intermediador/marketplace os prestadores de serviços e de negócios referentes às transações comerciais ou de prestação de serviços intermediadas, realizadas por pessoas jurídicas inscritas no Cadastro Nacional de Pessoa Jurídica - CNPJ ou pessoas físicas inscritas no Cadastro de Pessoa Física - CPF, ainda que não inscritas no cadastro de contribuintes do ICMS
   */
  public String getIndIntermid() {
    return indIntermid;
  }

  /**
   * # b25c indIntermed Indicador de intermediador/marketplace E B01 N 0-1 1
   * <li>0=Operação sem intermediador (em site ou plataforma própria)
   * <li>1=Operação em site ou plataforma de terceiros (intermediadores/marketplace) <br>
   * <br>
   * <li>Considera-se intermediador/marketplace os prestadores de serviços e de negócios referentes às transações comerciais ou de prestação de serviços intermediadas, realizadas por pessoas jurídicas inscritas no Cadastro Nacional de Pessoa Jurídica - CNPJ ou pessoas físicas inscritas no Cadastro de Pessoa Física - CPF, ainda que não inscritas no cadastro de contribuintes do ICMS. <br>
   * <li>Considera-se site/plataforma própria as vendas que não foram intermediadas (por marketplace), como venda em site próprio, teleatendimento. (Criado na NT 2020.006).
   *
   * @param indIntermid # b25c indIntermed Indicador de intermediador/marketplace E B01 N 0-1 1
   *          <li>0=Operação sem intermediador (em site ou plataforma própria)
   *          <li>1=Operação em site ou plataforma de terceiros (intermediadores/marketplace) <br>
   *          <br>
   *          <li>Considera-se intermediador/marketplace os prestadores de serviços e de negócios referentes às transações comerciais ou de prestação de serviços intermediadas, realizadas por pessoas jurídicas inscritas no Cadastro Nacional de Pessoa Jurídica - CNPJ ou pessoas físicas inscritas no Cadastro de Pessoa Física - CPF, ainda que não inscritas no cadastro de contribuintes do ICMS
   */
  public void setIndIntermid(String indIntermid) {
    this.indIntermid = indIntermid;
  }

  /**
   * # b26 procEmi Processo de emissão da NF-e E B01 N 1-1 1
   * <li>0=Emissão de NF-e com aplicativo do contribuinte;
   * <li>1=Emissão de NF-e avulsa pelo Fisco;
   * <li>2=Emissão de NF-e avulsa, pelo contribuinte com seu certificado digital, através do site do Fisco;
   * <li>3=Emissão NF-e pelo contribuinte com aplicativo fornecido pelo Fisco.
   *
   * @return # b26 procEmi Processo de emissão da NF-e E B01 N 1-1 1
   *         <li>0=Emissão de NF-e com aplicativo do contribuinte;
   *         <li>1=Emissão de NF-e avulsa pelo Fisco;
   *         <li>2=Emissão de NF-e avulsa, pelo contribuinte com seu certificado digital, através do site do Fisco;
   *         <li>3=Emissão NF-e pelo contribuinte com aplicativo fornecido pelo Fisco
   */
  public String getProcEmi() {
    return procEmi;
  }

  /**
   * # b26 procEmi Processo de emissão da NF-e E B01 N 1-1 1
   * <li>0=Emissão de NF-e com aplicativo do contribuinte;
   * <li>1=Emissão de NF-e avulsa pelo Fisco;
   * <li>2=Emissão de NF-e avulsa, pelo contribuinte com seu certificado digital, através do site do Fisco;
   * <li>3=Emissão NF-e pelo contribuinte com aplicativo fornecido pelo Fisco.
   *
   * @param procEmi # b26 procEmi Processo de emissão da NF-e E B01 N 1-1 1
   *          <li>0=Emissão de NF-e com aplicativo do contribuinte;
   *          <li>1=Emissão de NF-e avulsa pelo Fisco;
   *          <li>2=Emissão de NF-e avulsa, pelo contribuinte com seu certificado digital, através do site do Fisco;
   *          <li>3=Emissão NF-e pelo contribuinte com aplicativo fornecido pelo Fisco
   */
  public void setProcEmi(String procEmi) {
    this.procEmi = procEmi;
  }

  /**
   * # b27 verProc Versão do Processo de emissão da NF-e E B01 C 1-1 1- 20<Br>
   * Informar a versão do aplicativo emissor de NF-e.
   *
   * @return # b27 verProc Versão do Processo de emissão da NF-e E B01 C 1-1 1- 20<Br>
   *         Informar a versão do aplicativo emissor de NF-e
   */
  public String getVerProc() {
    return verProc;
  }

  /**
   * # b27 verProc Versão do Processo de emissão da NF-e E B01 C 1-1 1- 20<Br>
   * Informar a versão do aplicativo emissor de NF-e.
   *
   * @param verProc # b27 verProc Versão do Processo de emissão da NF-e E B01 C 1-1 1- 20<Br>
   *          Informar a versão do aplicativo emissor de NF-e
   */
  public void setVerProc(String verProc) {
    this.verProc = verProc;
  }

  /**
   * # b28 dhCont Data e Hora da entrada em contingência E B27.1 D 1-1
   * <li>Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD.
   *
   * @return # b28 dhCont Data e Hora da entrada em contingência E B27
   */
  public LocalDateTime getDhCont() {
    return dhCont;
  }

  /**
   * # b28 dhCont Data e Hora da entrada em contingência E B27.1 D 1-1
   * <li>Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD.
   *
   * @param dhCont # b28 dhCont Data e Hora da entrada em contingência E B27
   */
  public void setDhCont(LocalDateTime dhCont) {
    this.dhCont = dhCont;
  }

  /**
   * # b29 xJust Justificativa da entrada em contingência E B27.1 C 1-1 15 - 256 (v2.0).
   *
   * @return # b29 xJust Justificativa da entrada em contingência E B27
   */
  public String getXjust() {
    return xjust;
  }

  /**
   * # b29 xJust Justificativa da entrada em contingência E B27.1 C 1-1 15 - 256 (v2.0).
   *
   * @param xjust # b29 xJust Justificativa da entrada em contingência E B27
   */
  public void setXjust(String xjust) {
    this.xjust = xjust;
  }

  /**
   * # bA01 NFref Informação de Documentos Fiscais referenciados G B01 0-500<br>
   * Grupo com informações de Documentos Fiscais referenciados. Informação utilizada nas hipóteses previstas na legislação. (Ex.: Devolução de mercadorias, Substituição de NF cancelada, Complementação de NF, etc.).
   *
   * @return # bA01 NFref Informação de Documentos Fiscais referenciados G B01 0-500<br>
   *         Grupo com informações de Documentos Fiscais referenciados
   */
  public List<NFrefVO> getNfref() {
    return nfref;
  }

  /**
   * # bA01 NFref Informação de Documentos Fiscais referenciados G B01 0-500<br>
   * Grupo com informações de Documentos Fiscais referenciados. Informação utilizada nas hipóteses previstas na legislação. (Ex.: Devolução de mercadorias, Substituição de NF cancelada, Complementação de NF, etc.).
   *
   * @param nfref # bA01 NFref Informação de Documentos Fiscais referenciados G B01 0-500<br>
   *          Grupo com informações de Documentos Fiscais referenciados
   */
  public void setNfref(List<NFrefVO> nfref) {
    this.nfref = nfref;
  }

}
