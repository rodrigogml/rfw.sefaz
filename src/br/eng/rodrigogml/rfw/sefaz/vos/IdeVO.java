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
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integra��o com o framework, pertindo a valida��o e at� a persist�ncia se o sistema assim desejar. N�o h� preocupa��o de gerar JavaDOC nestas classes pois ela deve representar exatamente a documenta��o da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Valida��o da NF-e.
 */
public class IdeVO extends RFWVO {

  private static final long serialVersionUID = 5173082771993218096L;

  /**
   * B02 cUF C�digo da UF do emitente do Documento Fiscal E B01 N 1-1 2<br>
   * C�digo da UF do emitente do Documento Fiscal. Utilizar a Tabela do IBGE de c�digo de unidades da federa��o (Se��o 8.1 do MOC � Vis�o Geral, Tabela de UF, Munic�pio e Pa�s).
   */
  @RFWMetaIntegerField(caption = "cUF", minvalue = 0, maxvalue = 99, required = true)
  private Integer cuf = null;

  /**
   * B03 cNF C�digo Num�rico que comp�e a Chave de Acesso E B01 N 1-1 8<br>
   * C�digo num�rico que comp�e a Chave de Acesso. N�mero aleat�rio gerado pelo emitente para cada NF-e para evitar acessos indevidos da NF-e. (v2.0)
   */
  @RFWMetaIntegerField(caption = "C�digo Num�rico", minvalue = 0, maxvalue = 99999999, required = true)
  private Integer cnf = null;

  /**
   * natOp Descri��o da Natureza da Opera��o E B01 C 1-1 1 - 60<Br>
   * Informar a natureza da opera��o de que decorrer a sa�da ou a entrada, tais como: venda, compra, transfer�ncia, devolu��o, importa��o, consigna��o, remessa (para fins de demonstra��o, de industrializa��o ou outra), conforme previsto na al�nea 'i', inciso I, art. 19 do CONV�NIO S/N�, de 15 de dezembro de 1970.
   */
  @RFWMetaStringField(caption = "Natureza da Opera��o", minlength = 1, maxlength = 60, required = true)
  private String natOp = null;

  /**
   * B05 indPag Indicador da forma de pagamento E B01 N 1-1 1<br>
   * <li>0=Pagamento � vista;
   * <li>1=Pagamento a prazo;
   * <li>2=Outros. (Exclu�do no leiaute 4.0 - NT2016.002)
   *
   * @deprecated Deixou de existir desde a NT2016.002. Mas ainda presente para que seja poss�vel l�r o conte�do de notas anteriores ao layout 4.
   */
  @Deprecated
  @RFWMetaStringField(caption = "Forma de Pagamento", minlength = 1, maxlength = 1, required = false, pattern = "^(0|1|2)$")
  private String indPag = null;

  /**
   * B06 mod C�digo do Modelo do Documento Fiscal E B01 N 1-1 2
   * <li>55=NF-e emitida em substitui��o ao modelo 1 ou 1A;
   * <li>65=NFC-e, utilizada nas opera��es de venda no varejo (a crit�rio da UF aceitar este modelo de documento).
   */
  @RFWMetaStringField(caption = "Modelo do Documento Fiscal", minlength = 2, maxlength = 2, required = true, pattern = "^(55|65)$")
  private String mod = null;

  /**
   * B07 serie S�rie do Documento Fiscal E B01 N 1-1 1 - 3<br>
   * S�rie do Documento Fiscal, preencher com zeros na hip�tese de a NF-e n�o possuir s�rie. S�rie na faixa:
   * <li>[000-889]: Aplicativo do Contribuinte; Emitente=CNPJ; Assinatura pelo e-CNPJ do contribuinte (procEmi<>1,2);
   * <li>[890-899]: Emiss�o no site do Fisco (NFA-e - Avulsa); Emitente= CNPJ / CPF; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1);
   * <li>[900-909]: Emiss�o no site do Fisco (NFA-e); Emitente= CNPJ; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1), ou Assinatura pelo e-CNPJ do contribuinte (procEmi=2);
   * <li>[910-919]: Emiss�o no site do Fisco (NFA-e); Emitente= CPF; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1), ou Assinatura pelo e-CPF do contribuinte (procEmi=2);
   * <li>[920-969]: Aplicativo do Contribuinte; Emitente=CPF; Assinatura pelo e-CPF do contribuinte (procEmi<>1,2); (Atualizado NT 2018/001)
   *
   */
  @RFWMetaIntegerField(caption = "S�rie", minvalue = 0, maxvalue = 969, required = true)
  private Integer serie = null;

  /**
   * B08 nNF N�mero do Documento Fiscal E B01 N 1-1 1 - 9<br>
   * N�mero do Documento Fiscal.
   */
  @RFWMetaIntegerField(caption = "N�mero", minvalue = 1, maxvalue = 999999999, required = true)
  private Integer nnf = null;

  /**
   * B09 dhEmi Data e hora de emiss�o do Documento Fiscal E B01 D 1-1<br>
   * Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD
   */
  @RFWMetaDateField(caption = "Data e Hora Emiss�o", required = true, resolution = DateResolution.SECOND)
  private LocalDateTime dhEmi = null;

  /**
   * B10 dhSaiEnt Data e hora de Sa�da ou da Entrada da Mercadoria/Produto E B01 D 0-1<Br>
   * Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD. <br>
   * Observa��o: N�o informar este campo para a NFC-e.
   */
  @RFWMetaDateField(caption = "Data e Hora Entrada/Sa�da", required = true, resolution = DateResolution.SECOND)
  private LocalDateTime dhSaiEnt = null;

  /**
   * B11 tpNF Tipo de Opera��o E B01 N 1-1 1
   * <li>0=Entrada;
   * <li>1=Sa�da
   */
  @RFWMetaStringField(caption = "Tipo de Opera��o", minlength = 1, maxlength = 1, required = true, pattern = "^(0|1)$")
  private String tpNF = null;

  /**
   * B11a idDest Identificador de local de destino da opera��o E B01 N 1-1 1
   * <li>1=Opera��o interna;
   * <li>2=Opera��o interestadual;
   * <li>3=Opera��o com exterior
   */
  @RFWMetaStringField(caption = "Destino da Opera��o", minlength = 1, maxlength = 1, required = true, pattern = "^(0|1|2)$")
  private String idDist = null;

  /**
   * B12 cMunFG C�digo do Munic�pio de Ocorr�ncia do Fato Gerador E B01 N 1-1 7<br>
   * Informar o munic�pio de ocorr�ncia do fato gerador do ICMS. Utilizar a Tabela do IBGE (Se��o 8.2 do MOC � Vis�o Geral, Tabela de UF, Munic�pio e Pa�s)
   */
  @RFWMetaIntegerField(caption = "C�digo do Munic�pio do Fato Gerador", minvalue = 0, maxvalue = 9999999, required = true)
  private Integer cMunFG = null;

  /**
   * B21 tpImp Formato de Impress�o do DANFE E B01 N 1-1 1
   * <li>0=Sem gera��o de DANFE;
   * <li>1=DANFE normal, Retrato;
   * <li>2=DANFE normal, Paisagem;
   * <li>3=DANFE Simplificado; 4=DANFE NFC-e;
   * <li>5=DANFE NFC-e em mensagem eletr�nica (o envio de mensagem eletr�nica pode ser feita de forma simult�nea com a impress�o do DANFE; usar o tpImp=5 quando esta for a �nica forma de disponibiliza��o do DANFE)
   */
  @RFWMetaStringField(caption = "Formato de Impress�o", minlength = 1, maxlength = 1, required = true)
  private String tpImp = null;

  /**
   * B22 tpEmis Tipo de Emiss�o da NF-e E B01 N 1-1 1
   * <li>1=Emiss�o normal (n�o em conting�ncia);
   * <li>2=Conting�ncia FS-IA, com impress�o do DANFE em Formul�rio de Seguran�a - Impressor Aut�nomo;
   * <li>3=Conting�ncia SCAN (Sistema de Conting�ncia do Ambiente Nacional); *Desativado * NT 2015/002
   * <li>4=Conting�ncia EPEC (Evento Pr�vio da Emiss�o em Conting�ncia);
   * <li>5=Conting�ncia FS-DA, com impress�o do DANFE em Formul�rio de Seguran�a - Documento Auxiliar;
   * <li>6=Conting�ncia SVC-AN (SEFAZ Virtual de Conting�ncia do AN);
   * <li>7=Conting�ncia SVC-RS (SEFAZ Virtual de Conting�ncia do RS);
   * <li>9=Conting�ncia off-line da NFC-e; <br>
   * Observa��o: Para a NFC-e somente � v�lida a op��o de conting�ncia: 9-Conting�ncia Off-Line e, a crit�rio da UF, op��o 4-Conting�ncia EPEC. (NT 2015/002)
   *
   */
  @RFWMetaStringField(caption = "Tipo de Emiss�o", minlength = 1, maxlength = 1, required = true, pattern = "^(1|2|3|4|5|7|9)$")
  private String tpEmis = null;

  /**
   * B23 cDV D�gito Verificador da Chave de Acesso da NF-e E B01 N 1-1 1<br>
   * Informar o DV da Chave de Acesso da NF-e, o DV ser� calculado com a aplica��o do algoritmo m�dulo 11 (base 2,9) da Chave de Acesso. (vide item 5.4 do MOC � Vis�o Geral)
   */
  @RFWMetaIntegerField(caption = "D�gito Verificador", minvalue = 0, maxvalue = 9, required = true)
  private Integer cdv = null;

  /**
   * B24 tpAmb Identifica��o do Ambiente E B01 N 1-1 1
   * <li>1=Produ��o;
   * <li>2=Homologa��o
   */
  @RFWMetaStringField(caption = "Identifica��o do Ambiente", minlength = 1, maxlength = 1, required = true, pattern = "^(1|2)$")
  private String tpAmb = null;

  /**
   * B25 finNFe Finalidade de emiss�o da NF-e E B01 N 1-1 1
   * <li>1=NF-e normal;
   * <li>2=NF-e complementar;
   * <li>3=NF-e de ajuste;
   * <li>4=Devolu��o de mercadoria
   */
  @RFWMetaStringField(caption = "Finalidade de Emiss�o", minlength = 1, maxlength = 1, required = true, pattern = "^(1|2|3|4)$")
  private String finNFe = null;

  /**
   * B25a indFinal Indica opera��o com Consumidor final E B01 N 1-1 1
   * <li>0=Normal;
   * <li>1=Consumidor final;
   */
  @RFWMetaStringField(caption = "Consumidor Final", minlength = 1, maxlength = 1, required = true, pattern = "^(0|1)$")
  private String indFinal = null;

  /**
   * B25b indPres Indicador de presen�a do comprador no estabelecimento comercial no momento da opera��o E B01 N 1-1 1
   * <li>0=N�o se aplica (por exemplo, Nota Fiscal complementar ou de ajuste);
   * <li>1=Opera��o presencial;
   * <li>2=Opera��o n�o presencial, pela Internet;
   * <li>3=Opera��o n�o presencial, Teleatendimento;
   * <li>4=NFC-e em opera��o com entrega a domic�lio;
   * <li>5=Opera��o presencial, fora do estabelecimento; (inclu�do NT2016.002)
   * <li>9=Opera��o n�o presencial, outros.
   */
  @RFWMetaStringField(caption = "Indicador de Presen�a", minlength = 1, maxlength = 1, required = true, pattern = "^(0|1|2|3|4|5|9)$")
  private String indPres = null;

  /**
   * B25c indIntermed Indicador de intermediador/marketplace E B01 N 0-1 1
   * <li>0=Opera��o sem intermediador (em site ou plataforma pr�pria)
   * <li>1=Opera��o em site ou plataforma de terceiros (intermediadores/marketplace) <br>
   * <br>
   * <li>Considera-se intermediador/marketplace os prestadores de servi�os e de neg�cios referentes �s transa��es comerciais ou de presta��o de servi�os intermediadas, realizadas por pessoas jur�dicas inscritas no Cadastro Nacional de Pessoa Jur�dica - CNPJ ou pessoas f�sicas inscritas no Cadastro de Pessoa F�sica - CPF, ainda que n�o inscritas no cadastro de contribuintes do ICMS. <br>
   * <li>Considera-se site/plataforma pr�pria as vendas que n�o foram intermediadas (por marketplace), como venda em site pr�prio, teleatendimento. (Criado na NT 2020.006)
   */
  @RFWMetaStringField(caption = "Intermediador/Marketplace", minlength = 1, maxlength = 1, required = false, pattern = "^(0|1)$")
  private String indIntermid = null;

  /**
   * B26 procEmi Processo de emiss�o da NF-e E B01 N 1-1 1
   * <li>0=Emiss�o de NF-e com aplicativo do contribuinte;
   * <li>1=Emiss�o de NF-e avulsa pelo Fisco;
   * <li>2=Emiss�o de NF-e avulsa, pelo contribuinte com seu certificado digital, atrav�s do site do Fisco;
   * <li>3=Emiss�o NF-e pelo contribuinte com aplicativo fornecido pelo Fisco.
   */
  @RFWMetaStringField(caption = "Processo de Emiss�o", minlength = 1, maxlength = 1, required = true, pattern = "^(0|1|2|3)$")
  private String procEmi = null;

  /**
   * B27 verProc Vers�o do Processo de emiss�o da NF-e E B01 C 1-1 1- 20<Br>
   * Informar a vers�o do aplicativo emissor de NF-e
   */
  @RFWMetaStringField(caption = "Vers�o Processo Emiss�o", minlength = 1, maxlength = 20, required = true, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String verProc = null;

  /**
   * B28 dhCont Data e Hora da entrada em conting�ncia E B27.1 D 1-1
   * <li>Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD
   */
  @RFWMetaDateField(caption = "Data/Hora Entrada Contig�ncia", required = false, resolution = DateResolution.SECOND)
  private LocalDateTime dhCont = null;

  /**
   * B29 xJust Justificativa da entrada em conting�ncia E B27.1 C 1-1 15 - 256 (v2.0)
   */
  @RFWMetaStringField(caption = "Justificativa Entrada Contig�ncia", minlength = 15, maxlength = 256, required = false)
  private String xjust = null;

  /**
   * BA01 NFref Informa��o de Documentos Fiscais referenciados G B01 0-500<br>
   * Grupo com informa��es de Documentos Fiscais referenciados. Informa��o utilizada nas hip�teses previstas na legisla��o. (Ex.: Devolu��o de mercadorias, Substitui��o de NF cancelada, Complementa��o de NF, etc.).
   */
  @RFWMetaRelationshipField(caption = "Documentos Referenciados", relationship = RelationshipTypes.ASSOCIATION, required = false, targetRelationship = NFrefVO.class)
  private List<NFrefVO> nfref = null;

  /**
   * # b02 cUF C�digo da UF do emitente do Documento Fiscal E B01 N 1-1 2<br>
   * C�digo da UF do emitente do Documento Fiscal. Utilizar a Tabela do IBGE de c�digo de unidades da federa��o (Se��o 8.1 do MOC � Vis�o Geral, Tabela de UF, Munic�pio e Pa�s).
   *
   * @return # b02 cUF C�digo da UF do emitente do Documento Fiscal E B01 N 1-1 2<br>
   *         C�digo da UF do emitente do Documento Fiscal
   */
  public Integer getCuf() {
    return cuf;
  }

  /**
   * # b02 cUF C�digo da UF do emitente do Documento Fiscal E B01 N 1-1 2<br>
   * C�digo da UF do emitente do Documento Fiscal. Utilizar a Tabela do IBGE de c�digo de unidades da federa��o (Se��o 8.1 do MOC � Vis�o Geral, Tabela de UF, Munic�pio e Pa�s).
   *
   * @param cuf # b02 cUF C�digo da UF do emitente do Documento Fiscal E B01 N 1-1 2<br>
   *          C�digo da UF do emitente do Documento Fiscal
   */
  public void setCuf(Integer cuf) {
    this.cuf = cuf;
  }

  /**
   * # b03 cNF C�digo Num�rico que comp�e a Chave de Acesso E B01 N 1-1 8<br>
   * C�digo num�rico que comp�e a Chave de Acesso. N�mero aleat�rio gerado pelo emitente para cada NF-e para evitar acessos indevidos da NF-e. (v2.0).
   *
   * @return # b03 cNF C�digo Num�rico que comp�e a Chave de Acesso E B01 N 1-1 8<br>
   *         C�digo num�rico que comp�e a Chave de Acesso
   */
  public Integer getCnf() {
    return cnf;
  }

  /**
   * # b03 cNF C�digo Num�rico que comp�e a Chave de Acesso E B01 N 1-1 8<br>
   * C�digo num�rico que comp�e a Chave de Acesso. N�mero aleat�rio gerado pelo emitente para cada NF-e para evitar acessos indevidos da NF-e. (v2.0).
   *
   * @param cnf # b03 cNF C�digo Num�rico que comp�e a Chave de Acesso E B01 N 1-1 8<br>
   *          C�digo num�rico que comp�e a Chave de Acesso
   */
  public void setCnf(Integer cnf) {
    this.cnf = cnf;
  }

  /**
   * # natOp Descri��o da Natureza da Opera��o E B01 C 1-1 1 - 60<Br>
   * Informar a natureza da opera��o de que decorrer a sa�da ou a entrada, tais como: venda, compra, transfer�ncia, devolu��o, importa��o, consigna��o, remessa (para fins de demonstra��o, de industrializa��o ou outra), conforme previsto na al�nea 'i', inciso I, art. 19 do CONV�NIO S/N�, de 15 de dezembro de 1970.
   *
   * @return # natOp Descri��o da Natureza da Opera��o E B01 C 1-1 1 - 60<Br>
   *         Informar a natureza da opera��o de que decorrer a sa�da ou a entrada, tais como: venda, compra, transfer�ncia, devolu��o, importa��o, consigna��o, remessa (para fins de demonstra��o, de industrializa��o ou outra), conforme previsto na al�nea 'i', inciso I, art
   */
  public String getNatOp() {
    return natOp;
  }

  /**
   * # natOp Descri��o da Natureza da Opera��o E B01 C 1-1 1 - 60<Br>
   * Informar a natureza da opera��o de que decorrer a sa�da ou a entrada, tais como: venda, compra, transfer�ncia, devolu��o, importa��o, consigna��o, remessa (para fins de demonstra��o, de industrializa��o ou outra), conforme previsto na al�nea 'i', inciso I, art. 19 do CONV�NIO S/N�, de 15 de dezembro de 1970.
   *
   * @param natOp # natOp Descri��o da Natureza da Opera��o E B01 C 1-1 1 - 60<Br>
   *          Informar a natureza da opera��o de que decorrer a sa�da ou a entrada, tais como: venda, compra, transfer�ncia, devolu��o, importa��o, consigna��o, remessa (para fins de demonstra��o, de industrializa��o ou outra), conforme previsto na al�nea 'i', inciso I, art
   */
  public void setNatOp(String natOp) {
    this.natOp = natOp;
  }

  /**
   * # b05 indPag Indicador da forma de pagamento E B01 N 1-1 1<br>
   * <li>0=Pagamento � vista;
   * <li>1=Pagamento a prazo;
   * <li>2=Outros. (Exclu�do no leiaute 4.0 - NT2016.002).
   *
   * @return # b05 indPag Indicador da forma de pagamento E B01 N 1-1 1<br>
   *         <li>0=Pagamento � vista;
   *         <li>1=Pagamento a prazo;
   *         <li>2=Outros
   */
  public String getIndPag() {
    return indPag;
  }

  /**
   * # b05 indPag Indicador da forma de pagamento E B01 N 1-1 1<br>
   * <li>0=Pagamento � vista;
   * <li>1=Pagamento a prazo;
   * <li>2=Outros. (Exclu�do no leiaute 4.0 - NT2016.002).
   *
   * @param indPag # b05 indPag Indicador da forma de pagamento E B01 N 1-1 1<br>
   *          <li>0=Pagamento � vista;
   *          <li>1=Pagamento a prazo;
   *          <li>2=Outros
   */
  public void setIndPag(String indPag) {
    this.indPag = indPag;
  }

  /**
   * # b06 mod C�digo do Modelo do Documento Fiscal E B01 N 1-1 2
   * <li>55=NF-e emitida em substitui��o ao modelo 1 ou 1A;
   * <li>65=NFC-e, utilizada nas opera��es de venda no varejo (a crit�rio da UF aceitar este modelo de documento).
   *
   * @return # b06 mod C�digo do Modelo do Documento Fiscal E B01 N 1-1 2
   *         <li>55=NF-e emitida em substitui��o ao modelo 1 ou 1A;
   *         <li>65=NFC-e, utilizada nas opera��es de venda no varejo (a crit�rio da UF aceitar este modelo de documento)
   */
  public String getMod() {
    return mod;
  }

  /**
   * # b06 mod C�digo do Modelo do Documento Fiscal E B01 N 1-1 2
   * <li>55=NF-e emitida em substitui��o ao modelo 1 ou 1A;
   * <li>65=NFC-e, utilizada nas opera��es de venda no varejo (a crit�rio da UF aceitar este modelo de documento).
   *
   * @param mod # b06 mod C�digo do Modelo do Documento Fiscal E B01 N 1-1 2
   *          <li>55=NF-e emitida em substitui��o ao modelo 1 ou 1A;
   *          <li>65=NFC-e, utilizada nas opera��es de venda no varejo (a crit�rio da UF aceitar este modelo de documento)
   */
  public void setMod(String mod) {
    this.mod = mod;
  }

  /**
   * # b07 serie S�rie do Documento Fiscal E B01 N 1-1 1 - 3<br>
   * S�rie do Documento Fiscal, preencher com zeros na hip�tese de a NF-e n�o possuir s�rie. S�rie na faixa:
   * <li>[000-889]: Aplicativo do Contribuinte; Emitente=CNPJ; Assinatura pelo e-CNPJ do contribuinte (procEmi<>1,2);
   * <li>[890-899]: Emiss�o no site do Fisco (NFA-e - Avulsa); Emitente= CNPJ / CPF; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1);
   * <li>[900-909]: Emiss�o no site do Fisco (NFA-e); Emitente= CNPJ; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1), ou Assinatura pelo e-CNPJ do contribuinte (procEmi=2);
   * <li>[910-919]: Emiss�o no site do Fisco (NFA-e); Emitente= CPF; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1), ou Assinatura pelo e-CPF do contribuinte (procEmi=2);
   * <li>[920-969]: Aplicativo do Contribuinte; Emitente=CPF; Assinatura pelo e-CPF do contribuinte (procEmi<>1,2); (Atualizado NT 2018/001).
   *
   * @return # b07 serie S�rie do Documento Fiscal E B01 N 1-1 1 - 3<br>
   *         S�rie do Documento Fiscal, preencher com zeros na hip�tese de a NF-e n�o possuir s�rie
   */
  public Integer getSerie() {
    return serie;
  }

  /**
   * # b07 serie S�rie do Documento Fiscal E B01 N 1-1 1 - 3<br>
   * S�rie do Documento Fiscal, preencher com zeros na hip�tese de a NF-e n�o possuir s�rie. S�rie na faixa:
   * <li>[000-889]: Aplicativo do Contribuinte; Emitente=CNPJ; Assinatura pelo e-CNPJ do contribuinte (procEmi<>1,2);
   * <li>[890-899]: Emiss�o no site do Fisco (NFA-e - Avulsa); Emitente= CNPJ / CPF; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1);
   * <li>[900-909]: Emiss�o no site do Fisco (NFA-e); Emitente= CNPJ; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1), ou Assinatura pelo e-CNPJ do contribuinte (procEmi=2);
   * <li>[910-919]: Emiss�o no site do Fisco (NFA-e); Emitente= CPF; Assinatura pelo e-CNPJ da SEFAZ (procEmi=1), ou Assinatura pelo e-CPF do contribuinte (procEmi=2);
   * <li>[920-969]: Aplicativo do Contribuinte; Emitente=CPF; Assinatura pelo e-CPF do contribuinte (procEmi<>1,2); (Atualizado NT 2018/001).
   *
   * @param serie # b07 serie S�rie do Documento Fiscal E B01 N 1-1 1 - 3<br>
   *          S�rie do Documento Fiscal, preencher com zeros na hip�tese de a NF-e n�o possuir s�rie
   */
  public void setSerie(Integer serie) {
    this.serie = serie;
  }

  /**
   * # b08 nNF N�mero do Documento Fiscal E B01 N 1-1 1 - 9<br>
   * N�mero do Documento Fiscal.
   *
   * @return # b08 nNF N�mero do Documento Fiscal E B01 N 1-1 1 - 9<br>
   *         N�mero do Documento Fiscal
   */
  public Integer getNnf() {
    return nnf;
  }

  /**
   * # b08 nNF N�mero do Documento Fiscal E B01 N 1-1 1 - 9<br>
   * N�mero do Documento Fiscal.
   *
   * @param nnf # b08 nNF N�mero do Documento Fiscal E B01 N 1-1 1 - 9<br>
   *          N�mero do Documento Fiscal
   */
  public void setNnf(Integer nnf) {
    this.nnf = nnf;
  }

  /**
   * # b09 dhEmi Data e hora de emiss�o do Documento Fiscal E B01 D 1-1<br>
   * Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD.
   *
   * @return # b09 dhEmi Data e hora de emiss�o do Documento Fiscal E B01 D 1-1<br>
   *         Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD
   */
  public LocalDateTime getDhEmi() {
    return dhEmi;
  }

  /**
   * # b09 dhEmi Data e hora de emiss�o do Documento Fiscal E B01 D 1-1<br>
   * Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD.
   *
   * @param dhEmi # b09 dhEmi Data e hora de emiss�o do Documento Fiscal E B01 D 1-1<br>
   *          Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD
   */
  public void setDhEmi(LocalDateTime dhEmi) {
    this.dhEmi = dhEmi;
  }

  /**
   * # b10 dhSaiEnt Data e hora de Sa�da ou da Entrada da Mercadoria/Produto E B01 D 0-1<Br>
   * Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD. <br>
   * Observa��o: N�o informar este campo para a NFC-e.
   *
   * @return # b10 dhSaiEnt Data e hora de Sa�da ou da Entrada da Mercadoria/Produto E B01 D 0-1<Br>
   *         Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD
   */
  public LocalDateTime getDhSaiEnt() {
    return dhSaiEnt;
  }

  /**
   * # b10 dhSaiEnt Data e hora de Sa�da ou da Entrada da Mercadoria/Produto E B01 D 0-1<Br>
   * Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD. <br>
   * Observa��o: N�o informar este campo para a NFC-e.
   *
   * @param dhSaiEnt # b10 dhSaiEnt Data e hora de Sa�da ou da Entrada da Mercadoria/Produto E B01 D 0-1<Br>
   *          Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD
   */
  public void setDhSaiEnt(LocalDateTime dhSaiEnt) {
    this.dhSaiEnt = dhSaiEnt;
  }

  /**
   * # b11 tpNF Tipo de Opera��o E B01 N 1-1 1
   * <li>0=Entrada;
   * <li>1=Sa�da.
   *
   * @return # b11 tpNF Tipo de Opera��o E B01 N 1-1 1
   *         <li>0=Entrada;
   *         <li>1=Sa�da
   */
  public String getTpNF() {
    return tpNF;
  }

  /**
   * # b11 tpNF Tipo de Opera��o E B01 N 1-1 1
   * <li>0=Entrada;
   * <li>1=Sa�da.
   *
   * @param tpNF # b11 tpNF Tipo de Opera��o E B01 N 1-1 1
   *          <li>0=Entrada;
   *          <li>1=Sa�da
   */
  public void setTpNF(String tpNF) {
    this.tpNF = tpNF;
  }

  /**
   * # b11a idDest Identificador de local de destino da opera��o E B01 N 1-1 1
   * <li>1=Opera��o interna;
   * <li>2=Opera��o interestadual;
   * <li>3=Opera��o com exterior.
   *
   * @return # b11a idDest Identificador de local de destino da opera��o E B01 N 1-1 1
   *         <li>1=Opera��o interna;
   *         <li>2=Opera��o interestadual;
   *         <li>3=Opera��o com exterior
   */
  public String getIdDist() {
    return idDist;
  }

  /**
   * # b11a idDest Identificador de local de destino da opera��o E B01 N 1-1 1
   * <li>1=Opera��o interna;
   * <li>2=Opera��o interestadual;
   * <li>3=Opera��o com exterior.
   *
   * @param idDist # b11a idDest Identificador de local de destino da opera��o E B01 N 1-1 1
   *          <li>1=Opera��o interna;
   *          <li>2=Opera��o interestadual;
   *          <li>3=Opera��o com exterior
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
   * # b21 tpImp Formato de Impress�o do DANFE E B01 N 1-1 1
   * <li>0=Sem gera��o de DANFE;
   * <li>1=DANFE normal, Retrato;
   * <li>2=DANFE normal, Paisagem;
   * <li>3=DANFE Simplificado; 4=DANFE NFC-e;
   * <li>5=DANFE NFC-e em mensagem eletr�nica (o envio de mensagem eletr�nica pode ser feita de forma simult�nea com a impress�o do DANFE; usar o tpImp=5 quando esta for a �nica forma de disponibiliza��o do DANFE).
   *
   * @return # b21 tpImp Formato de Impress�o do DANFE E B01 N 1-1 1
   *         <li>0=Sem gera��o de DANFE;
   *         <li>1=DANFE normal, Retrato;
   *         <li>2=DANFE normal, Paisagem;
   *         <li>3=DANFE Simplificado; 4=DANFE NFC-e;
   *         <li>5=DANFE NFC-e em mensagem eletr�nica (o envio de mensagem eletr�nica pode ser feita de forma simult�nea com a impress�o do DANFE; usar o tpImp=5 quando esta for a �nica forma de disponibiliza��o do DANFE)
   */
  public String getTpImp() {
    return tpImp;
  }

  /**
   * # b21 tpImp Formato de Impress�o do DANFE E B01 N 1-1 1
   * <li>0=Sem gera��o de DANFE;
   * <li>1=DANFE normal, Retrato;
   * <li>2=DANFE normal, Paisagem;
   * <li>3=DANFE Simplificado; 4=DANFE NFC-e;
   * <li>5=DANFE NFC-e em mensagem eletr�nica (o envio de mensagem eletr�nica pode ser feita de forma simult�nea com a impress�o do DANFE; usar o tpImp=5 quando esta for a �nica forma de disponibiliza��o do DANFE).
   *
   * @param tpImp # b21 tpImp Formato de Impress�o do DANFE E B01 N 1-1 1
   *          <li>0=Sem gera��o de DANFE;
   *          <li>1=DANFE normal, Retrato;
   *          <li>2=DANFE normal, Paisagem;
   *          <li>3=DANFE Simplificado; 4=DANFE NFC-e;
   *          <li>5=DANFE NFC-e em mensagem eletr�nica (o envio de mensagem eletr�nica pode ser feita de forma simult�nea com a impress�o do DANFE; usar o tpImp=5 quando esta for a �nica forma de disponibiliza��o do DANFE)
   */
  public void setTpImp(String tpImp) {
    this.tpImp = tpImp;
  }

  /**
   * # b22 tpEmis Tipo de Emiss�o da NF-e E B01 N 1-1 1
   * <li>1=Emiss�o normal (n�o em conting�ncia);
   * <li>2=Conting�ncia FS-IA, com impress�o do DANFE em Formul�rio de Seguran�a - Impressor Aut�nomo;
   * <li>3=Conting�ncia SCAN (Sistema de Conting�ncia do Ambiente Nacional); *Desativado * NT 2015/002
   * <li>4=Conting�ncia EPEC (Evento Pr�vio da Emiss�o em Conting�ncia);
   * <li>5=Conting�ncia FS-DA, com impress�o do DANFE em Formul�rio de Seguran�a - Documento Auxiliar;
   * <li>6=Conting�ncia SVC-AN (SEFAZ Virtual de Conting�ncia do AN);
   * <li>7=Conting�ncia SVC-RS (SEFAZ Virtual de Conting�ncia do RS);
   * <li>9=Conting�ncia off-line da NFC-e; <br>
   * Observa��o: Para a NFC-e somente � v�lida a op��o de conting�ncia: 9-Conting�ncia Off-Line e, a crit�rio da UF, op��o 4-Conting�ncia EPEC. (NT 2015/002).
   *
   * @return # b22 tpEmis Tipo de Emiss�o da NF-e E B01 N 1-1 1
   *         <li>1=Emiss�o normal (n�o em conting�ncia);
   *         <li>2=Conting�ncia FS-IA, com impress�o do DANFE em Formul�rio de Seguran�a - Impressor Aut�nomo;
   *         <li>3=Conting�ncia SCAN (Sistema de Conting�ncia do Ambiente Nacional); *Desativado * NT 2015/002
   *         <li>4=Conting�ncia EPEC (Evento Pr�vio da Emiss�o em Conting�ncia);
   *         <li>5=Conting�ncia FS-DA, com impress�o do DANFE em Formul�rio de Seguran�a - Documento Auxiliar;
   *         <li>6=Conting�ncia SVC-AN (SEFAZ Virtual de Conting�ncia do AN);
   *         <li>7=Conting�ncia SVC-RS (SEFAZ Virtual de Conting�ncia do RS);
   *         <li>9=Conting�ncia off-line da NFC-e; <br>
   *         Observa��o: Para a NFC-e somente � v�lida a op��o de conting�ncia: 9-Conting�ncia Off-Line e, a crit�rio da UF, op��o 4-Conting�ncia EPEC
   */
  public String getTpEmis() {
    return tpEmis;
  }

  /**
   * # b22 tpEmis Tipo de Emiss�o da NF-e E B01 N 1-1 1
   * <li>1=Emiss�o normal (n�o em conting�ncia);
   * <li>2=Conting�ncia FS-IA, com impress�o do DANFE em Formul�rio de Seguran�a - Impressor Aut�nomo;
   * <li>3=Conting�ncia SCAN (Sistema de Conting�ncia do Ambiente Nacional); *Desativado * NT 2015/002
   * <li>4=Conting�ncia EPEC (Evento Pr�vio da Emiss�o em Conting�ncia);
   * <li>5=Conting�ncia FS-DA, com impress�o do DANFE em Formul�rio de Seguran�a - Documento Auxiliar;
   * <li>6=Conting�ncia SVC-AN (SEFAZ Virtual de Conting�ncia do AN);
   * <li>7=Conting�ncia SVC-RS (SEFAZ Virtual de Conting�ncia do RS);
   * <li>9=Conting�ncia off-line da NFC-e; <br>
   * Observa��o: Para a NFC-e somente � v�lida a op��o de conting�ncia: 9-Conting�ncia Off-Line e, a crit�rio da UF, op��o 4-Conting�ncia EPEC. (NT 2015/002).
   *
   * @param tpEmis # b22 tpEmis Tipo de Emiss�o da NF-e E B01 N 1-1 1
   *          <li>1=Emiss�o normal (n�o em conting�ncia);
   *          <li>2=Conting�ncia FS-IA, com impress�o do DANFE em Formul�rio de Seguran�a - Impressor Aut�nomo;
   *          <li>3=Conting�ncia SCAN (Sistema de Conting�ncia do Ambiente Nacional); *Desativado * NT 2015/002
   *          <li>4=Conting�ncia EPEC (Evento Pr�vio da Emiss�o em Conting�ncia);
   *          <li>5=Conting�ncia FS-DA, com impress�o do DANFE em Formul�rio de Seguran�a - Documento Auxiliar;
   *          <li>6=Conting�ncia SVC-AN (SEFAZ Virtual de Conting�ncia do AN);
   *          <li>7=Conting�ncia SVC-RS (SEFAZ Virtual de Conting�ncia do RS);
   *          <li>9=Conting�ncia off-line da NFC-e; <br>
   *          Observa��o: Para a NFC-e somente � v�lida a op��o de conting�ncia: 9-Conting�ncia Off-Line e, a crit�rio da UF, op��o 4-Conting�ncia EPEC
   */
  public void setTpEmis(String tpEmis) {
    this.tpEmis = tpEmis;
  }

  /**
   * # b23 cDV D�gito Verificador da Chave de Acesso da NF-e E B01 N 1-1 1<br>
   * Informar o DV da Chave de Acesso da NF-e, o DV ser� calculado com a aplica��o do algoritmo m�dulo 11 (base 2,9) da Chave de Acesso. (vide item 5.4 do MOC � Vis�o Geral).
   *
   * @return # b23 cDV D�gito Verificador da Chave de Acesso da NF-e E B01 N 1-1 1<br>
   *         Informar o DV da Chave de Acesso da NF-e, o DV ser� calculado com a aplica��o do algoritmo m�dulo 11 (base 2,9) da Chave de Acesso
   */
  public Integer getCdv() {
    return cdv;
  }

  /**
   * # b23 cDV D�gito Verificador da Chave de Acesso da NF-e E B01 N 1-1 1<br>
   * Informar o DV da Chave de Acesso da NF-e, o DV ser� calculado com a aplica��o do algoritmo m�dulo 11 (base 2,9) da Chave de Acesso. (vide item 5.4 do MOC � Vis�o Geral).
   *
   * @param cdv # b23 cDV D�gito Verificador da Chave de Acesso da NF-e E B01 N 1-1 1<br>
   *          Informar o DV da Chave de Acesso da NF-e, o DV ser� calculado com a aplica��o do algoritmo m�dulo 11 (base 2,9) da Chave de Acesso
   */
  public void setCdv(Integer cdv) {
    this.cdv = cdv;
  }

  /**
   * # b24 tpAmb Identifica��o do Ambiente E B01 N 1-1 1
   * <li>1=Produ��o;
   * <li>2=Homologa��o.
   *
   * @return # b24 tpAmb Identifica��o do Ambiente E B01 N 1-1 1
   *         <li>1=Produ��o;
   *         <li>2=Homologa��o
   */
  public String getTpAmb() {
    return tpAmb;
  }

  /**
   * # b24 tpAmb Identifica��o do Ambiente E B01 N 1-1 1
   * <li>1=Produ��o;
   * <li>2=Homologa��o.
   *
   * @param tpAmb # b24 tpAmb Identifica��o do Ambiente E B01 N 1-1 1
   *          <li>1=Produ��o;
   *          <li>2=Homologa��o
   */
  public void setTpAmb(String tpAmb) {
    this.tpAmb = tpAmb;
  }

  /**
   * # b25 finNFe Finalidade de emiss�o da NF-e E B01 N 1-1 1
   * <li>1=NF-e normal;
   * <li>2=NF-e complementar;
   * <li>3=NF-e de ajuste;
   * <li>4=Devolu��o de mercadoria.
   *
   * @return # b25 finNFe Finalidade de emiss�o da NF-e E B01 N 1-1 1
   *         <li>1=NF-e normal;
   *         <li>2=NF-e complementar;
   *         <li>3=NF-e de ajuste;
   *         <li>4=Devolu��o de mercadoria
   */
  public String getFinNFe() {
    return finNFe;
  }

  /**
   * # b25 finNFe Finalidade de emiss�o da NF-e E B01 N 1-1 1
   * <li>1=NF-e normal;
   * <li>2=NF-e complementar;
   * <li>3=NF-e de ajuste;
   * <li>4=Devolu��o de mercadoria.
   *
   * @param finNFe # b25 finNFe Finalidade de emiss�o da NF-e E B01 N 1-1 1
   *          <li>1=NF-e normal;
   *          <li>2=NF-e complementar;
   *          <li>3=NF-e de ajuste;
   *          <li>4=Devolu��o de mercadoria
   */
  public void setFinNFe(String finNFe) {
    this.finNFe = finNFe;
  }

  /**
   * # b25a indFinal Indica opera��o com Consumidor final E B01 N 1-1 1
   * <li>0=Normal;
   * <li>1=Consumidor final;.
   *
   * @return # b25a indFinal Indica opera��o com Consumidor final E B01 N 1-1 1
   *         <li>0=Normal;
   *         <li>1=Consumidor final;
   */
  public String getIndFinal() {
    return indFinal;
  }

  /**
   * # b25a indFinal Indica opera��o com Consumidor final E B01 N 1-1 1
   * <li>0=Normal;
   * <li>1=Consumidor final;.
   *
   * @param indFinal # b25a indFinal Indica opera��o com Consumidor final E B01 N 1-1 1
   *          <li>0=Normal;
   *          <li>1=Consumidor final;
   */
  public void setIndFinal(String indFinal) {
    this.indFinal = indFinal;
  }

  /**
   * # b25b indPres Indicador de presen�a do comprador no estabelecimento comercial no momento da opera��o E B01 N 1-1 1
   * <li>0=N�o se aplica (por exemplo, Nota Fiscal complementar ou de ajuste);
   * <li>1=Opera��o presencial;
   * <li>2=Opera��o n�o presencial, pela Internet;
   * <li>3=Opera��o n�o presencial, Teleatendimento;
   * <li>4=NFC-e em opera��o com entrega a domic�lio;
   * <li>5=Opera��o presencial, fora do estabelecimento; (inclu�do NT2016.002)
   * <li>9=Opera��o n�o presencial, outros.
   *
   * @return # b25b indPres Indicador de presen�a do comprador no estabelecimento comercial no momento da opera��o E B01 N 1-1 1
   *         <li>0=N�o se aplica (por exemplo, Nota Fiscal complementar ou de ajuste);
   *         <li>1=Opera��o presencial;
   *         <li>2=Opera��o n�o presencial, pela Internet;
   *         <li>3=Opera��o n�o presencial, Teleatendimento;
   *         <li>4=NFC-e em opera��o com entrega a domic�lio;
   *         <li>5=Opera��o presencial, fora do estabelecimento; (inclu�do NT2016
   */
  public String getIndPres() {
    return indPres;
  }

  /**
   * # b25b indPres Indicador de presen�a do comprador no estabelecimento comercial no momento da opera��o E B01 N 1-1 1
   * <li>0=N�o se aplica (por exemplo, Nota Fiscal complementar ou de ajuste);
   * <li>1=Opera��o presencial;
   * <li>2=Opera��o n�o presencial, pela Internet;
   * <li>3=Opera��o n�o presencial, Teleatendimento;
   * <li>4=NFC-e em opera��o com entrega a domic�lio;
   * <li>5=Opera��o presencial, fora do estabelecimento; (inclu�do NT2016.002)
   * <li>9=Opera��o n�o presencial, outros.
   *
   * @param indPres # b25b indPres Indicador de presen�a do comprador no estabelecimento comercial no momento da opera��o E B01 N 1-1 1
   *          <li>0=N�o se aplica (por exemplo, Nota Fiscal complementar ou de ajuste);
   *          <li>1=Opera��o presencial;
   *          <li>2=Opera��o n�o presencial, pela Internet;
   *          <li>3=Opera��o n�o presencial, Teleatendimento;
   *          <li>4=NFC-e em opera��o com entrega a domic�lio;
   *          <li>5=Opera��o presencial, fora do estabelecimento; (inclu�do NT2016
   */
  public void setIndPres(String indPres) {
    this.indPres = indPres;
  }

  /**
   * # b25c indIntermed Indicador de intermediador/marketplace E B01 N 0-1 1
   * <li>0=Opera��o sem intermediador (em site ou plataforma pr�pria)
   * <li>1=Opera��o em site ou plataforma de terceiros (intermediadores/marketplace) <br>
   * <br>
   * <li>Considera-se intermediador/marketplace os prestadores de servi�os e de neg�cios referentes �s transa��es comerciais ou de presta��o de servi�os intermediadas, realizadas por pessoas jur�dicas inscritas no Cadastro Nacional de Pessoa Jur�dica - CNPJ ou pessoas f�sicas inscritas no Cadastro de Pessoa F�sica - CPF, ainda que n�o inscritas no cadastro de contribuintes do ICMS. <br>
   * <li>Considera-se site/plataforma pr�pria as vendas que n�o foram intermediadas (por marketplace), como venda em site pr�prio, teleatendimento. (Criado na NT 2020.006).
   *
   * @return # b25c indIntermed Indicador de intermediador/marketplace E B01 N 0-1 1
   *         <li>0=Opera��o sem intermediador (em site ou plataforma pr�pria)
   *         <li>1=Opera��o em site ou plataforma de terceiros (intermediadores/marketplace) <br>
   *         <br>
   *         <li>Considera-se intermediador/marketplace os prestadores de servi�os e de neg�cios referentes �s transa��es comerciais ou de presta��o de servi�os intermediadas, realizadas por pessoas jur�dicas inscritas no Cadastro Nacional de Pessoa Jur�dica - CNPJ ou pessoas f�sicas inscritas no Cadastro de Pessoa F�sica - CPF, ainda que n�o inscritas no cadastro de contribuintes do ICMS
   */
  public String getIndIntermid() {
    return indIntermid;
  }

  /**
   * # b25c indIntermed Indicador de intermediador/marketplace E B01 N 0-1 1
   * <li>0=Opera��o sem intermediador (em site ou plataforma pr�pria)
   * <li>1=Opera��o em site ou plataforma de terceiros (intermediadores/marketplace) <br>
   * <br>
   * <li>Considera-se intermediador/marketplace os prestadores de servi�os e de neg�cios referentes �s transa��es comerciais ou de presta��o de servi�os intermediadas, realizadas por pessoas jur�dicas inscritas no Cadastro Nacional de Pessoa Jur�dica - CNPJ ou pessoas f�sicas inscritas no Cadastro de Pessoa F�sica - CPF, ainda que n�o inscritas no cadastro de contribuintes do ICMS. <br>
   * <li>Considera-se site/plataforma pr�pria as vendas que n�o foram intermediadas (por marketplace), como venda em site pr�prio, teleatendimento. (Criado na NT 2020.006).
   *
   * @param indIntermid # b25c indIntermed Indicador de intermediador/marketplace E B01 N 0-1 1
   *          <li>0=Opera��o sem intermediador (em site ou plataforma pr�pria)
   *          <li>1=Opera��o em site ou plataforma de terceiros (intermediadores/marketplace) <br>
   *          <br>
   *          <li>Considera-se intermediador/marketplace os prestadores de servi�os e de neg�cios referentes �s transa��es comerciais ou de presta��o de servi�os intermediadas, realizadas por pessoas jur�dicas inscritas no Cadastro Nacional de Pessoa Jur�dica - CNPJ ou pessoas f�sicas inscritas no Cadastro de Pessoa F�sica - CPF, ainda que n�o inscritas no cadastro de contribuintes do ICMS
   */
  public void setIndIntermid(String indIntermid) {
    this.indIntermid = indIntermid;
  }

  /**
   * # b26 procEmi Processo de emiss�o da NF-e E B01 N 1-1 1
   * <li>0=Emiss�o de NF-e com aplicativo do contribuinte;
   * <li>1=Emiss�o de NF-e avulsa pelo Fisco;
   * <li>2=Emiss�o de NF-e avulsa, pelo contribuinte com seu certificado digital, atrav�s do site do Fisco;
   * <li>3=Emiss�o NF-e pelo contribuinte com aplicativo fornecido pelo Fisco.
   *
   * @return # b26 procEmi Processo de emiss�o da NF-e E B01 N 1-1 1
   *         <li>0=Emiss�o de NF-e com aplicativo do contribuinte;
   *         <li>1=Emiss�o de NF-e avulsa pelo Fisco;
   *         <li>2=Emiss�o de NF-e avulsa, pelo contribuinte com seu certificado digital, atrav�s do site do Fisco;
   *         <li>3=Emiss�o NF-e pelo contribuinte com aplicativo fornecido pelo Fisco
   */
  public String getProcEmi() {
    return procEmi;
  }

  /**
   * # b26 procEmi Processo de emiss�o da NF-e E B01 N 1-1 1
   * <li>0=Emiss�o de NF-e com aplicativo do contribuinte;
   * <li>1=Emiss�o de NF-e avulsa pelo Fisco;
   * <li>2=Emiss�o de NF-e avulsa, pelo contribuinte com seu certificado digital, atrav�s do site do Fisco;
   * <li>3=Emiss�o NF-e pelo contribuinte com aplicativo fornecido pelo Fisco.
   *
   * @param procEmi # b26 procEmi Processo de emiss�o da NF-e E B01 N 1-1 1
   *          <li>0=Emiss�o de NF-e com aplicativo do contribuinte;
   *          <li>1=Emiss�o de NF-e avulsa pelo Fisco;
   *          <li>2=Emiss�o de NF-e avulsa, pelo contribuinte com seu certificado digital, atrav�s do site do Fisco;
   *          <li>3=Emiss�o NF-e pelo contribuinte com aplicativo fornecido pelo Fisco
   */
  public void setProcEmi(String procEmi) {
    this.procEmi = procEmi;
  }

  /**
   * # b27 verProc Vers�o do Processo de emiss�o da NF-e E B01 C 1-1 1- 20<Br>
   * Informar a vers�o do aplicativo emissor de NF-e.
   *
   * @return # b27 verProc Vers�o do Processo de emiss�o da NF-e E B01 C 1-1 1- 20<Br>
   *         Informar a vers�o do aplicativo emissor de NF-e
   */
  public String getVerProc() {
    return verProc;
  }

  /**
   * # b27 verProc Vers�o do Processo de emiss�o da NF-e E B01 C 1-1 1- 20<Br>
   * Informar a vers�o do aplicativo emissor de NF-e.
   *
   * @param verProc # b27 verProc Vers�o do Processo de emiss�o da NF-e E B01 C 1-1 1- 20<Br>
   *          Informar a vers�o do aplicativo emissor de NF-e
   */
  public void setVerProc(String verProc) {
    this.verProc = verProc;
  }

  /**
   * # b28 dhCont Data e Hora da entrada em conting�ncia E B27.1 D 1-1
   * <li>Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD.
   *
   * @return # b28 dhCont Data e Hora da entrada em conting�ncia E B27
   */
  public LocalDateTime getDhCont() {
    return dhCont;
  }

  /**
   * # b28 dhCont Data e Hora da entrada em conting�ncia E B27.1 D 1-1
   * <li>Data e hora no formato UTC (Universal Coordinated Time): AAAA-MM-DDThh:mm:ssTZD.
   *
   * @param dhCont # b28 dhCont Data e Hora da entrada em conting�ncia E B27
   */
  public void setDhCont(LocalDateTime dhCont) {
    this.dhCont = dhCont;
  }

  /**
   * # b29 xJust Justificativa da entrada em conting�ncia E B27.1 C 1-1 15 - 256 (v2.0).
   *
   * @return # b29 xJust Justificativa da entrada em conting�ncia E B27
   */
  public String getXjust() {
    return xjust;
  }

  /**
   * # b29 xJust Justificativa da entrada em conting�ncia E B27.1 C 1-1 15 - 256 (v2.0).
   *
   * @param xjust # b29 xJust Justificativa da entrada em conting�ncia E B27
   */
  public void setXjust(String xjust) {
    this.xjust = xjust;
  }

  /**
   * # bA01 NFref Informa��o de Documentos Fiscais referenciados G B01 0-500<br>
   * Grupo com informa��es de Documentos Fiscais referenciados. Informa��o utilizada nas hip�teses previstas na legisla��o. (Ex.: Devolu��o de mercadorias, Substitui��o de NF cancelada, Complementa��o de NF, etc.).
   *
   * @return # bA01 NFref Informa��o de Documentos Fiscais referenciados G B01 0-500<br>
   *         Grupo com informa��es de Documentos Fiscais referenciados
   */
  public List<NFrefVO> getNfref() {
    return nfref;
  }

  /**
   * # bA01 NFref Informa��o de Documentos Fiscais referenciados G B01 0-500<br>
   * Grupo com informa��es de Documentos Fiscais referenciados. Informa��o utilizada nas hip�teses previstas na legisla��o. (Ex.: Devolu��o de mercadorias, Substitui��o de NF cancelada, Complementa��o de NF, etc.).
   *
   * @param nfref # bA01 NFref Informa��o de Documentos Fiscais referenciados G B01 0-500<br>
   *          Grupo com informa��es de Documentos Fiscais referenciados
   */
  public void setNfref(List<NFrefVO> nfref) {
    this.nfref = nfref;
  }

}
