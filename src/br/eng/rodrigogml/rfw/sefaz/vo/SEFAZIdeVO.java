package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaDateField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaDateField.DateResolution;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_finNFe;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_idDest;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indFinal;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indIntermed;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indPres;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_mod;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_procEmi;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tpAmb;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tpEmis;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tpImp;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tpNF;

/**
 * Informações de identificação da NF-e ({@code ide}).
 *
 * <p>
 * Este VO representa o Grupo B da NF-e, contendo os principais dados de identificação do documento fiscal eletrônico, como UF do emitente, modelo, série, número, datas de emissão/saída, tipo de operação, ambiente, finalidade, presença do comprador, processo de emissão e dados de contingência.
 */
public class SEFAZIdeVO extends RFWVO {

  private static final long serialVersionUID = 5198906244636934594L;

  /**
   * {@link SEFAZInfNFeVO}
   */
  @RFWMetaRelationshipField(caption = "InfNFe", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_infnfe")
  private SEFAZInfNFeVO infNFeVO = null;

  /**
   * {@link SEFAZNFRefVO}
   */
  @RFWMetaRelationshipField(caption = "NFRef", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_nfref", minSize = 0, maxSize = 500)
  private List<SEFAZNFRefVO> nfRefList = null;

  /**
   * Código da UF do emitente do Documento Fiscal ({@code cUF}).
   *
   * <p>
   * Obrigatório na especificação. Utilizar a Tabela do IBGE de código de unidades da federação (MOC – Visão Geral, Tabela de UF, Município e País).
   */
  @RFWMetaStringField(caption = "Código da UF do emitente", required = false, minLength = 2, maxLength = 2, pattern = "\\d\\d", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cuf;

  /**
   * Código numérico que compõe a Chave de Acesso ({@code cNF}).
   *
   * <p>
   * Obrigatório na especificação. Número aleatório gerado pelo emitente para cada NF-e, utilizado na composição da chave de acesso para evitar acessos indevidos ao documento.
   */
  @RFWMetaBigDecimalField(caption = "Código numérico da chave de acesso", required = false)
  private BigDecimal cnf;

  /**
   * Descrição da Natureza da Operação ({@code natOp}).
   *
   * <p>
   * Obrigatório na especificação. Informar a natureza da operação que deve decorrer da saída ou da entrada, tais como: venda, compra, transferência, devolução, importação, consignação, remessa (para demonstração, industrialização ou outra), conforme previsto na legislação (CONVÊNIO/SINIEF de 15 de dezembro de 1970).
   */
  @RFWMetaStringField(caption = "Natureza da operação", required = false, maxLength = 60)
  private String natOp;

  /**
   * Indicador da forma de pagamento ({@code indPag}).
   *
   * <p>
   * Campo obrigatório nas versões antigas da especificação, mas excluído no leiaute 4.0 (NT 2016.002). Mantido aqui apenas para compatibilidade com documentos antigos.
   */
  @RFWMetaBigDecimalField(caption = "Indicador da forma de pagamento (obsoleto)", required = false)
  private BigDecimal indPag;

  /**
   * Código do Modelo do Documento Fiscal ({@code mod}).
   *
   * <p>
   * Obrigatório na especificação. Exemplos:
   * <ul>
   * <li>{@code 55} = NF-e emitida em substituição ao modelo 1 ou 1A</li>
   * <li>{@code 65} = NFC-e, utilizada em operações de venda no varejo</li>
   * </ul>
   */
  @RFWMetaEnumField(caption = "Modelo do documento fiscal", required = false)
  private SEFAZ_mod mod;

  /**
   * Série do Documento Fiscal ({@code serie}).
   *
   * <p>
   * Obrigatório na especificação. Preencher com zeros na hipótese de a NF-e não possuir série.
   * <ul>
   * <li>{@code 000–899}: Aplicativo do contribuinte</li>
   * <li>{@code 900–999}: Emissão no site do Fisco (NFA-e e outros cenários conforme NT 2018/001)</li>
   * </ul>
   */
  @RFWMetaBigDecimalField(caption = "Série do documento fiscal", required = false)
  private BigDecimal serie;

  /**
   * Número do Documento Fiscal ({@code nNF}).
   *
   * <p>
   * Obrigatório na especificação. Identifica a numeração do documento fiscal dentro da série.
   */
  @RFWMetaBigDecimalField(caption = "Número do documento fiscal", required = false)
  private BigDecimal nnf;

  /**
   * Data e hora de emissão do Documento Fiscal ({@code dhEmi}).
   *
   * <p>
   * Obrigatório na especificação. Data e hora no formato UTC {@code AAAA-MM-DDThh:mm:ssTZD}.
   */
  @RFWMetaDateField(caption = "Data e hora de emissão", required = false, resolution = DateResolution.SECOND)
  private LocalDateTime dhEmi;

  /**
   * Data e hora de saída ou da entrada da mercadoria/produto ({@code dhSaiEnt}).
   *
   * <p>
   * Opcional na especificação. Data e hora no formato UTC {@code AAAA-MM-DDThh:mm:ssTZD}. Não deve ser informado para NFC-e.
   */
  @RFWMetaDateField(caption = "Data e hora de saída/entrada", required = false, resolution = DateResolution.SECOND)
  private LocalDateTime dhSaiEnt;

  /**
   * Tipo de operação ({@code tpNF}).
   *
   * <p>
   * Obrigatório na especificação. Valores:
   * <ul>
   * <li>{@code 0} = Entrada</li>
   * <li>{@code 1} = Saída</li>
   * </ul>
   */
  @RFWMetaEnumField(caption = "Tipo de operação (entrada/saída)", required = false)
  private SEFAZ_tpNF tpNF;

  /**
   * Identificador de local de destino da operação ({@code idDest}).
   *
   * <p>
   * Obrigatório na especificação. Valores:
   * <ul>
   * <li>{@code 1} = Operação interna</li>
   * <li>{@code 2} = Operação interestadual</li>
   * <li>{@code 3} = Operação com exterior</li>
   * </ul>
   */
  @RFWMetaEnumField(caption = "Destino da operação", required = false)
  private SEFAZ_idDest idDest;

  /**
   * Código do município de ocorrência do fato gerador do ICMS ({@code cMunFG}).
   *
   * <p>
   * Obrigatório na especificação. Informar o município de ocorrência do fato gerador do ICMS. Utilizar a tabela de municípios do IBGE (MOC, Seção 8.2).
   */
  @RFWMetaBigDecimalField(caption = "Município do fato gerador", required = false)
  private BigDecimal cmunFG;

  /**
   * Formato de impressão do DANFE ({@code tpImp}).
   *
   * <p>
   * Obrigatório na especificação. Valores:
   * <ul>
   * <li>{@code 0} = Sem geração de DANFE</li>
   * <li>{@code 1} = DANFE normal, retrato</li>
   * <li>{@code 2} = DANFE normal, paisagem</li>
   * <li>{@code 3} = DANFE simplificado</li>
   * <li>{@code 4} = DANFE NFC-e</li>
   * <li>{@code 5} = DANFE NFC-e mensagem eletrônica</li>
   * </ul>
   */
  @RFWMetaEnumField(caption = "Formato de impressão do DANFE", required = false)
  private SEFAZ_tpImp tpImp;

  /**
   * Tipo de emissão da NF-e ({@code tpEmis}).
   *
   * <p>
   * Obrigatório na especificação. Inclui emissão normal e diversos tipos de contingência: FS-IA, SCAN, EPEC, FS-DA, SVC-AN, SVC-RS e off-line NFC-e.
   */
  @RFWMetaEnumField(caption = "Tipo de emissão da NF-e", required = false)
  private SEFAZ_tpEmis tpEmis;

  /**
   * Dígito verificador da chave de acesso da NF-e ({@code cDV}).
   *
   * <p>
   * Obrigatório na especificação. Informar o DV da chave de acesso, calculado pelo algoritmo módulo 11 (base 2,9) sobre os demais campos da chave.
   */
  @RFWMetaBigDecimalField(caption = "Dígito verificador da chave de acesso", required = false)
  private BigDecimal cdv;

  /**
   * Identificação do ambiente de autorização da NF-e ({@code tpAmb}).
   *
   * <p>
   * Obrigatório na especificação. Valores:
   * <ul>
   * <li>{@code 1} = Produção</li>
   * <li>{@code 2} = Homologação</li>
   * </ul>
   */
  @RFWMetaEnumField(caption = "Ambiente de autorização", required = false)
  private SEFAZ_tpAmb tpAmb;

  /**
   * Finalidade de emissão da NF-e ({@code finNFe}).
   *
   * <p>
   * Obrigatório na especificação. Valores:
   * <ul>
   * <li>{@code 1} = NF-e normal</li>
   * <li>{@code 2} = NF-e complementar</li>
   * <li>{@code 3} = NF-e de ajuste</li>
   * <li>{@code 4} = Devolução de mercadoria</li>
   * </ul>
   */
  @RFWMetaEnumField(caption = "Finalidade de emissão", required = false)
  private SEFAZ_finNFe finNFe;

  /**
   * Indicador de operação com consumidor final ({@code indFinal}).
   *
   * <p>
   * Obrigatório na especificação. Valores:
   * <ul>
   * <li>{@code 0} = Normal</li>
   * <li>{@code 1} = Consumidor final</li>
   * </ul>
   */
  @RFWMetaEnumField(caption = "Indicador de consumidor final", required = false)
  private SEFAZ_indFinal indFinal;

  /**
   * Indicador de presença do comprador no estabelecimento comercial ({@code indPres}).
   *
   * <p>
   * Obrigatório na especificação. Valores:
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
  @RFWMetaEnumField(caption = "Indicador de presença do comprador", required = false)
  private SEFAZ_indPres indPres;

  /**
   * Indicador de intermediador/marketplace ({@code indIntermed}).
   *
   * <p>
   * Opcional na especificação. Valores:
   * <ul>
   * <li>{@code 0} = Operação sem intermediador</li>
   * <li>{@code 1} = Operação com plataforma de terceiros</li>
   * </ul>
   */
  @RFWMetaEnumField(caption = "Indicador de intermediador/marketplace", required = false)
  private SEFAZ_indIntermed indIntermed;

  /**
   * Processo de emissão da NF-e ({@code procEmi}).
   *
   * <p>
   * Obrigatório na especificação. Valores:
   * <ul>
   * <li>{@code 0} = Emissão pelo contribuinte</li>
   * <li>{@code 1} = Emissão avulsa pelo Fisco</li>
   * <li>{@code 2} = Emissão avulsa com certificado digital pelo contribuinte</li>
   * <li>{@code 3} = Emissão pelo aplicativo do Fisco</li>
   * </ul>
   */
  @RFWMetaEnumField(caption = "Processo de emissão da NF-e", required = false)
  private SEFAZ_procEmi procEmi;

  /**
   * Versão do processo de emissão da NF-e ({@code verProc}).
   *
   * <p>
   * Obrigatório na especificação. Informar a versão do aplicativo emissor da NF-e (versão do sistema ou componente responsável pela geração da NF-e).
   */
  @RFWMetaStringField(caption = "Versão do processo de emissão", required = false, maxLength = 20)
  private String verProc;

  /**
   * Data e hora da entrada em contingência ({@code dhCont}).
   *
   * <p>
   * Obrigatório na especificação quando o grupo de contingência é informado. Data e hora no formato UTC {@code AAAA-MM-DDThh:mm:ssTZD}, indicando o momento em que o contribuinte entrou em contingência.
   */
  @RFWMetaDateField(caption = "Data e hora de entrada em contingência", required = false, resolution = DateResolution.SECOND)
  private LocalDateTime dhCont;

  /**
   * Justificativa da entrada em contingência ({@code xJust}).
   *
   * <p>
   * Obrigatório na especificação quando o grupo de contingência é informado. Deve conter um texto explicando o motivo da entrada em contingência, com comprimento mínimo de 15 e máximo de 256 caracteres.
   */
  @RFWMetaStringField(caption = "Justificativa da contingência", required = false, maxLength = 256, minLength = 15)
  private String xjust;

  /**
   * # código da UF do emitente do Documento Fiscal ({@code cUF}).
   * <p>
   * Obrigatório na especificação. Utilizar a Tabela do IBGE de código de unidades da federação (MOC – Visão Geral, Tabela de UF, Município e País).
   *
   * @return the código da UF do emitente do Documento Fiscal ({@code cUF})
   */
  public String getCuf() {
    return cuf;
  }

  /**
   * # código da UF do emitente do Documento Fiscal ({@code cUF}).
   * <p>
   * Obrigatório na especificação. Utilizar a Tabela do IBGE de código de unidades da federação (MOC – Visão Geral, Tabela de UF, Município e País).
   *
   * @param cuf the new código da UF do emitente do Documento Fiscal ({@code cUF})
   */
  public void setCuf(String cuf) {
    this.cuf = cuf;
  }

  /**
   * # código numérico que compõe a Chave de Acesso ({@code cNF}).
   * <p>
   * Obrigatório na especificação. Número aleatório gerado pelo emitente para cada NF-e, utilizado na composição da chave de acesso para evitar acessos indevidos ao documento.
   *
   * @return the código numérico que compõe a Chave de Acesso ({@code cNF})
   */
  public BigDecimal getCnf() {
    return cnf;
  }

  /**
   * # código numérico que compõe a Chave de Acesso ({@code cNF}).
   * <p>
   * Obrigatório na especificação. Número aleatório gerado pelo emitente para cada NF-e, utilizado na composição da chave de acesso para evitar acessos indevidos ao documento.
   *
   * @param cnf the new código numérico que compõe a Chave de Acesso ({@code cNF})
   */
  public void setCnf(BigDecimal cnf) {
    this.cnf = cnf;
  }

  /**
   * # descrição da Natureza da Operação ({@code natOp}).
   * <p>
   * Obrigatório na especificação. Informar a natureza da operação que deve decorrer da saída ou da entrada, tais como: venda, compra, transferência, devolução, importação, consignação, remessa (para demonstração, industrialização ou outra), conforme previsto na legislação (CONVÊNIO/SINIEF de 15 de dezembro de 1970).
   *
   * @return the descrição da Natureza da Operação ({@code natOp})
   */
  public String getNatOp() {
    return natOp;
  }

  /**
   * # descrição da Natureza da Operação ({@code natOp}).
   * <p>
   * Obrigatório na especificação. Informar a natureza da operação que deve decorrer da saída ou da entrada, tais como: venda, compra, transferência, devolução, importação, consignação, remessa (para demonstração, industrialização ou outra), conforme previsto na legislação (CONVÊNIO/SINIEF de 15 de dezembro de 1970).
   *
   * @param natOp the new descrição da Natureza da Operação ({@code natOp})
   */
  public void setNatOp(String natOp) {
    this.natOp = natOp;
  }

  /**
   * # indicador da forma de pagamento ({@code indPag}).
   * <p>
   * Campo obrigatório nas versões antigas da especificação, mas excluído no leiaute 4.0 (NT 2016.002). Mantido aqui apenas para compatibilidade com documentos antigos.
   *
   * @return the indicador da forma de pagamento ({@code indPag})
   */
  public BigDecimal getIndPag() {
    return indPag;
  }

  /**
   * # indicador da forma de pagamento ({@code indPag}).
   * <p>
   * Campo obrigatório nas versões antigas da especificação, mas excluído no leiaute 4.0 (NT 2016.002). Mantido aqui apenas para compatibilidade com documentos antigos.
   *
   * @param indPag the new indicador da forma de pagamento ({@code indPag})
   */
  public void setIndPag(BigDecimal indPag) {
    this.indPag = indPag;
  }

  /**
   * # código do Modelo do Documento Fiscal ({@code mod}).
   * <p>
   * Obrigatório na especificação. Exemplos:
   * <ul>
   * <li>{@code 55} = NF-e emitida em substituição ao modelo 1 ou 1A</li>
   * <li>{@code 65} = NFC-e, utilizada em operações de venda no varejo</li>
   * </ul>
   * .
   *
   * @return the código do Modelo do Documento Fiscal ({@code mod})
   */
  public SEFAZ_mod getMod() {
    return mod;
  }

  /**
   * # código do Modelo do Documento Fiscal ({@code mod}).
   * <p>
   * Obrigatório na especificação. Exemplos:
   * <ul>
   * <li>{@code 55} = NF-e emitida em substituição ao modelo 1 ou 1A</li>
   * <li>{@code 65} = NFC-e, utilizada em operações de venda no varejo</li>
   * </ul>
   * .
   *
   * @param mod the new código do Modelo do Documento Fiscal ({@code mod})
   */
  public void setMod(SEFAZ_mod mod) {
    this.mod = mod;
  }

  /**
   * # série do Documento Fiscal ({@code serie}).
   * <p>
   * Obrigatório na especificação. Preencher com zeros na hipótese de a NF-e não possuir série.
   * <ul>
   * <li>{@code 000–899}: Aplicativo do contribuinte</li>
   * <li>{@code 900–999}: Emissão no site do Fisco (NFA-e e outros cenários conforme NT 2018/001)</li>
   * </ul>
   * .
   *
   * @return the série do Documento Fiscal ({@code serie})
   */
  public BigDecimal getSerie() {
    return serie;
  }

  /**
   * # série do Documento Fiscal ({@code serie}).
   * <p>
   * Obrigatório na especificação. Preencher com zeros na hipótese de a NF-e não possuir série.
   * <ul>
   * <li>{@code 000–899}: Aplicativo do contribuinte</li>
   * <li>{@code 900–999}: Emissão no site do Fisco (NFA-e e outros cenários conforme NT 2018/001)</li>
   * </ul>
   * .
   *
   * @param serie the new série do Documento Fiscal ({@code serie})
   */
  public void setSerie(BigDecimal serie) {
    this.serie = serie;
  }

  /**
   * # número do Documento Fiscal ({@code nNF}).
   * <p>
   * Obrigatório na especificação. Identifica a numeração do documento fiscal dentro da série.
   *
   * @return the número do Documento Fiscal ({@code nNF})
   */
  public BigDecimal getNnf() {
    return nnf;
  }

  /**
   * # número do Documento Fiscal ({@code nNF}).
   * <p>
   * Obrigatório na especificação. Identifica a numeração do documento fiscal dentro da série.
   *
   * @param nnf the new número do Documento Fiscal ({@code nNF})
   */
  public void setNnf(BigDecimal nnf) {
    this.nnf = nnf;
  }

  /**
   * # data e hora de emissão do Documento Fiscal ({@code dhEmi}).
   * <p>
   * Obrigatório na especificação. Data e hora no formato UTC {@code AAAA-MM-DDThh:mm:ssTZD}.
   *
   * @return the data e hora de emissão do Documento Fiscal ({@code dhEmi})
   */
  public LocalDateTime getDhEmi() {
    return dhEmi;
  }

  /**
   * # data e hora de emissão do Documento Fiscal ({@code dhEmi}).
   * <p>
   * Obrigatório na especificação. Data e hora no formato UTC {@code AAAA-MM-DDThh:mm:ssTZD}.
   *
   * @param dhEmi the new data e hora de emissão do Documento Fiscal ({@code dhEmi})
   */
  public void setDhEmi(LocalDateTime dhEmi) {
    this.dhEmi = dhEmi;
  }

  /**
   * # data e hora de saída ou da entrada da mercadoria/produto ({@code dhSaiEnt}).
   * <p>
   * Opcional na especificação. Data e hora no formato UTC {@code AAAA-MM-DDThh:mm:ssTZD}. Não deve ser informado para NFC-e.
   *
   * @return the data e hora de saída ou da entrada da mercadoria/produto ({@code dhSaiEnt})
   */
  public LocalDateTime getDhSaiEnt() {
    return dhSaiEnt;
  }

  /**
   * # data e hora de saída ou da entrada da mercadoria/produto ({@code dhSaiEnt}).
   * <p>
   * Opcional na especificação. Data e hora no formato UTC {@code AAAA-MM-DDThh:mm:ssTZD}. Não deve ser informado para NFC-e.
   *
   * @param dhSaiEnt the new data e hora de saída ou da entrada da mercadoria/produto ({@code dhSaiEnt})
   */
  public void setDhSaiEnt(LocalDateTime dhSaiEnt) {
    this.dhSaiEnt = dhSaiEnt;
  }

  /**
   * # tipo de operação ({@code tpNF}).
   * <p>
   * Obrigatório na especificação. Valores:
   * <ul>
   * <li>{@code 0} = Entrada</li>
   * <li>{@code 1} = Saída</li>
   * </ul>
   * .
   *
   * @return the tipo de operação ({@code tpNF})
   */
  public SEFAZ_tpNF getTpNF() {
    return tpNF;
  }

  /**
   * # tipo de operação ({@code tpNF}).
   * <p>
   * Obrigatório na especificação. Valores:
   * <ul>
   * <li>{@code 0} = Entrada</li>
   * <li>{@code 1} = Saída</li>
   * </ul>
   * .
   *
   * @param tpNF the new tipo de operação ({@code tpNF})
   */
  public void setTpNF(SEFAZ_tpNF tpNF) {
    this.tpNF = tpNF;
  }

  /**
   * # identificador de local de destino da operação ({@code idDest}).
   * <p>
   * Obrigatório na especificação. Valores:
   * <ul>
   * <li>{@code 1} = Operação interna</li>
   * <li>{@code 2} = Operação interestadual</li>
   * <li>{@code 3} = Operação com exterior</li>
   * </ul>
   * .
   *
   * @return the identificador de local de destino da operação ({@code idDest})
   */
  public SEFAZ_idDest getIdDest() {
    return idDest;
  }

  /**
   * # identificador de local de destino da operação ({@code idDest}).
   * <p>
   * Obrigatório na especificação. Valores:
   * <ul>
   * <li>{@code 1} = Operação interna</li>
   * <li>{@code 2} = Operação interestadual</li>
   * <li>{@code 3} = Operação com exterior</li>
   * </ul>
   * .
   *
   * @param idDest the new identificador de local de destino da operação ({@code idDest})
   */
  public void setIdDest(SEFAZ_idDest idDest) {
    this.idDest = idDest;
  }

  /**
   * # código do município de ocorrência do fato gerador do ICMS ({@code cMunFG}).
   * <p>
   * Obrigatório na especificação. Informar o município de ocorrência do fato gerador do ICMS. Utilizar a tabela de municípios do IBGE (MOC, Seção 8.2).
   *
   * @return the código do município de ocorrência do fato gerador do ICMS ({@code cMunFG})
   */
  public BigDecimal getCmunFG() {
    return cmunFG;
  }

  /**
   * # código do município de ocorrência do fato gerador do ICMS ({@code cMunFG}).
   * <p>
   * Obrigatório na especificação. Informar o município de ocorrência do fato gerador do ICMS. Utilizar a tabela de municípios do IBGE (MOC, Seção 8.2).
   *
   * @param cmunFG the new código do município de ocorrência do fato gerador do ICMS ({@code cMunFG})
   */
  public void setCmunFG(BigDecimal cmunFG) {
    this.cmunFG = cmunFG;
  }

  /**
   * # formato de impressão do DANFE ({@code tpImp}).
   * <p>
   * Obrigatório na especificação. Valores:
   * <ul>
   * <li>{@code 0} = Sem geração de DANFE</li>
   * <li>{@code 1} = DANFE normal, retrato</li>
   * <li>{@code 2} = DANFE normal, paisagem</li>
   * <li>{@code 3} = DANFE simplificado</li>
   * <li>{@code 4} = DANFE NFC-e</li>
   * <li>{@code 5} = DANFE NFC-e mensagem eletrônica</li>
   * </ul>
   * .
   *
   * @return the formato de impressão do DANFE ({@code tpImp})
   */
  public SEFAZ_tpImp getTpImp() {
    return tpImp;
  }

  /**
   * # formato de impressão do DANFE ({@code tpImp}).
   * <p>
   * Obrigatório na especificação. Valores:
   * <ul>
   * <li>{@code 0} = Sem geração de DANFE</li>
   * <li>{@code 1} = DANFE normal, retrato</li>
   * <li>{@code 2} = DANFE normal, paisagem</li>
   * <li>{@code 3} = DANFE simplificado</li>
   * <li>{@code 4} = DANFE NFC-e</li>
   * <li>{@code 5} = DANFE NFC-e mensagem eletrônica</li>
   * </ul>
   * .
   *
   * @param tpImp the new formato de impressão do DANFE ({@code tpImp})
   */
  public void setTpImp(SEFAZ_tpImp tpImp) {
    this.tpImp = tpImp;
  }

  /**
   * # tipo de emissão da NF-e ({@code tpEmis}).
   * <p>
   * Obrigatório na especificação. Inclui emissão normal e diversos tipos de contingência: FS-IA, SCAN, EPEC, FS-DA, SVC-AN, SVC-RS e off-line NFC-e.
   *
   * @return the tipo de emissão da NF-e ({@code tpEmis})
   */
  public SEFAZ_tpEmis getTpEmis() {
    return tpEmis;
  }

  /**
   * # tipo de emissão da NF-e ({@code tpEmis}).
   * <p>
   * Obrigatório na especificação. Inclui emissão normal e diversos tipos de contingência: FS-IA, SCAN, EPEC, FS-DA, SVC-AN, SVC-RS e off-line NFC-e.
   *
   * @param tpEmis the new tipo de emissão da NF-e ({@code tpEmis})
   */
  public void setTpEmis(SEFAZ_tpEmis tpEmis) {
    this.tpEmis = tpEmis;
  }

  /**
   * # dígito verificador da chave de acesso da NF-e ({@code cDV}).
   * <p>
   * Obrigatório na especificação. Informar o DV da chave de acesso, calculado pelo algoritmo módulo 11 (base 2,9) sobre os demais campos da chave.
   *
   * @return the dígito verificador da chave de acesso da NF-e ({@code cDV})
   */
  public BigDecimal getCdv() {
    return cdv;
  }

  /**
   * # dígito verificador da chave de acesso da NF-e ({@code cDV}).
   * <p>
   * Obrigatório na especificação. Informar o DV da chave de acesso, calculado pelo algoritmo módulo 11 (base 2,9) sobre os demais campos da chave.
   *
   * @param cdv the new dígito verificador da chave de acesso da NF-e ({@code cDV})
   */
  public void setCdv(BigDecimal cdv) {
    this.cdv = cdv;
  }

  /**
   * # identificação do ambiente de autorização da NF-e ({@code tpAmb}).
   * <p>
   * Obrigatório na especificação. Valores:
   * <ul>
   * <li>{@code 1} = Produção</li>
   * <li>{@code 2} = Homologação</li>
   * </ul>
   * .
   *
   * @return the identificação do ambiente de autorização da NF-e ({@code tpAmb})
   */
  public SEFAZ_tpAmb getTpAmb() {
    return tpAmb;
  }

  /**
   * # identificação do ambiente de autorização da NF-e ({@code tpAmb}).
   * <p>
   * Obrigatório na especificação. Valores:
   * <ul>
   * <li>{@code 1} = Produção</li>
   * <li>{@code 2} = Homologação</li>
   * </ul>
   * .
   *
   * @param tpAmb the new identificação do ambiente de autorização da NF-e ({@code tpAmb})
   */
  public void setTpAmb(SEFAZ_tpAmb tpAmb) {
    this.tpAmb = tpAmb;
  }

  /**
   * # finalidade de emissão da NF-e ({@code finNFe}).
   * <p>
   * Obrigatório na especificação. Valores:
   * <ul>
   * <li>{@code 1} = NF-e normal</li>
   * <li>{@code 2} = NF-e complementar</li>
   * <li>{@code 3} = NF-e de ajuste</li>
   * <li>{@code 4} = Devolução de mercadoria</li>
   * </ul>
   * .
   *
   * @return the finalidade de emissão da NF-e ({@code finNFe})
   */
  public SEFAZ_finNFe getFinNFe() {
    return finNFe;
  }

  /**
   * # finalidade de emissão da NF-e ({@code finNFe}).
   * <p>
   * Obrigatório na especificação. Valores:
   * <ul>
   * <li>{@code 1} = NF-e normal</li>
   * <li>{@code 2} = NF-e complementar</li>
   * <li>{@code 3} = NF-e de ajuste</li>
   * <li>{@code 4} = Devolução de mercadoria</li>
   * </ul>
   * .
   *
   * @param finNFe the new finalidade de emissão da NF-e ({@code finNFe})
   */
  public void setFinNFe(SEFAZ_finNFe finNFe) {
    this.finNFe = finNFe;
  }

  /**
   * # indicador de operação com consumidor final ({@code indFinal}).
   * <p>
   * Obrigatório na especificação. Valores:
   * <ul>
   * <li>{@code 0} = Normal</li>
   * <li>{@code 1} = Consumidor final</li>
   * </ul>
   * .
   *
   * @return the indicador de operação com consumidor final ({@code indFinal})
   */
  public SEFAZ_indFinal getIndFinal() {
    return indFinal;
  }

  /**
   * # indicador de operação com consumidor final ({@code indFinal}).
   * <p>
   * Obrigatório na especificação. Valores:
   * <ul>
   * <li>{@code 0} = Normal</li>
   * <li>{@code 1} = Consumidor final</li>
   * </ul>
   * .
   *
   * @param indFinal the new indicador de operação com consumidor final ({@code indFinal})
   */
  public void setIndFinal(SEFAZ_indFinal indFinal) {
    this.indFinal = indFinal;
  }

  /**
   * # indicador de presença do comprador no estabelecimento comercial ({@code indPres}).
   * <p>
   * Obrigatório na especificação. Valores:
   * <ul>
   * <li>{@code 0} = Não se aplica</li>
   * <li>{@code 1} = Operação presencial</li>
   * <li>{@code 2} = Operação não presencial, internet</li>
   * <li>{@code 3} = Operação não presencial, teleatendimento</li>
   * <li>{@code 4} = Operação com entrega a domicílio</li>
   * <li>{@code 5} = Operação presencial, fora do estabelecimento</li>
   * <li>{@code 9} = Operação não presencial, outros</li>
   * </ul>
   * .
   *
   * @return the indicador de presença do comprador no estabelecimento comercial ({@code indPres})
   */
  public SEFAZ_indPres getIndPres() {
    return indPres;
  }

  /**
   * # indicador de presença do comprador no estabelecimento comercial ({@code indPres}).
   * <p>
   * Obrigatório na especificação. Valores:
   * <ul>
   * <li>{@code 0} = Não se aplica</li>
   * <li>{@code 1} = Operação presencial</li>
   * <li>{@code 2} = Operação não presencial, internet</li>
   * <li>{@code 3} = Operação não presencial, teleatendimento</li>
   * <li>{@code 4} = Operação com entrega a domicílio</li>
   * <li>{@code 5} = Operação presencial, fora do estabelecimento</li>
   * <li>{@code 9} = Operação não presencial, outros</li>
   * </ul>
   * .
   *
   * @param indPres the new indicador de presença do comprador no estabelecimento comercial ({@code indPres})
   */
  public void setIndPres(SEFAZ_indPres indPres) {
    this.indPres = indPres;
  }

  /**
   * # indicador de intermediador/marketplace ({@code indIntermed}).
   * <p>
   * Opcional na especificação. Valores:
   * <ul>
   * <li>{@code 0} = Operação sem intermediador</li>
   * <li>{@code 1} = Operação com plataforma de terceiros</li>
   * </ul>
   * .
   *
   * @return the indicador de intermediador/marketplace ({@code indIntermed})
   */
  public SEFAZ_indIntermed getIndIntermed() {
    return indIntermed;
  }

  /**
   * # indicador de intermediador/marketplace ({@code indIntermed}).
   * <p>
   * Opcional na especificação. Valores:
   * <ul>
   * <li>{@code 0} = Operação sem intermediador</li>
   * <li>{@code 1} = Operação com plataforma de terceiros</li>
   * </ul>
   * .
   *
   * @param indIntermed the new indicador de intermediador/marketplace ({@code indIntermed})
   */
  public void setIndIntermed(SEFAZ_indIntermed indIntermed) {
    this.indIntermed = indIntermed;
  }

  /**
   * # processo de emissão da NF-e ({@code procEmi}).
   * <p>
   * Obrigatório na especificação. Valores:
   * <ul>
   * <li>{@code 0} = Emissão pelo contribuinte</li>
   * <li>{@code 1} = Emissão avulsa pelo Fisco</li>
   * <li>{@code 2} = Emissão avulsa com certificado digital pelo contribuinte</li>
   * <li>{@code 3} = Emissão pelo aplicativo do Fisco</li>
   * </ul>
   * .
   *
   * @return the processo de emissão da NF-e ({@code procEmi})
   */
  public SEFAZ_procEmi getProcEmi() {
    return procEmi;
  }

  /**
   * # processo de emissão da NF-e ({@code procEmi}).
   * <p>
   * Obrigatório na especificação. Valores:
   * <ul>
   * <li>{@code 0} = Emissão pelo contribuinte</li>
   * <li>{@code 1} = Emissão avulsa pelo Fisco</li>
   * <li>{@code 2} = Emissão avulsa com certificado digital pelo contribuinte</li>
   * <li>{@code 3} = Emissão pelo aplicativo do Fisco</li>
   * </ul>
   * .
   *
   * @param procEmi the new processo de emissão da NF-e ({@code procEmi})
   */
  public void setProcEmi(SEFAZ_procEmi procEmi) {
    this.procEmi = procEmi;
  }

  /**
   * # versão do processo de emissão da NF-e ({@code verProc}).
   * <p>
   * Obrigatório na especificação. Informar a versão do aplicativo emissor da NF-e (versão do sistema ou componente responsável pela geração da NF-e).
   *
   * @return the versão do processo de emissão da NF-e ({@code verProc})
   */
  public String getVerProc() {
    return verProc;
  }

  /**
   * # versão do processo de emissão da NF-e ({@code verProc}).
   * <p>
   * Obrigatório na especificação. Informar a versão do aplicativo emissor da NF-e (versão do sistema ou componente responsável pela geração da NF-e).
   *
   * @param verProc the new versão do processo de emissão da NF-e ({@code verProc})
   */
  public void setVerProc(String verProc) {
    this.verProc = verProc;
  }

  /**
   * # data e hora da entrada em contingência ({@code dhCont}).
   * <p>
   * Obrigatório na especificação quando o grupo de contingência é informado. Data e hora no formato UTC {@code AAAA-MM-DDThh:mm:ssTZD}, indicando o momento em que o contribuinte entrou em contingência.
   *
   * @return the data e hora da entrada em contingência ({@code dhCont})
   */
  public LocalDateTime getDhCont() {
    return dhCont;
  }

  /**
   * # data e hora da entrada em contingência ({@code dhCont}).
   * <p>
   * Obrigatório na especificação quando o grupo de contingência é informado. Data e hora no formato UTC {@code AAAA-MM-DDThh:mm:ssTZD}, indicando o momento em que o contribuinte entrou em contingência.
   *
   * @param dhCont the new data e hora da entrada em contingência ({@code dhCont})
   */
  public void setDhCont(LocalDateTime dhCont) {
    this.dhCont = dhCont;
  }

  /**
   * # justificativa da entrada em contingência ({@code xJust}).
   * <p>
   * Obrigatório na especificação quando o grupo de contingência é informado. Deve conter um texto explicando o motivo da entrada em contingência, com comprimento mínimo de 15 e máximo de 256 caracteres.
   *
   * @return the justificativa da entrada em contingência ({@code xJust})
   */
  public String getXjust() {
    return xjust;
  }

  /**
   * # justificativa da entrada em contingência ({@code xJust}).
   * <p>
   * Obrigatório na especificação quando o grupo de contingência é informado. Deve conter um texto explicando o motivo da entrada em contingência, com comprimento mínimo de 15 e máximo de 256 caracteres.
   *
   * @param xjust the new justificativa da entrada em contingência ({@code xJust})
   */
  public void setXjust(String xjust) {
    this.xjust = xjust;
  }

  /**
   * # tAG SEFAZNFeVO.
   *
   * @return the tAG SEFAZNFeVO
   */
  public SEFAZInfNFeVO getInfNFeVO() {
    return infNFeVO;
  }

  /**
   * # tAG SEFAZNFeVO.
   *
   * @param infNFeVO the new tAG SEFAZNFeVO
   */
  public void setInfNFeVO(SEFAZInfNFeVO infNFeVO) {
    this.infNFeVO = infNFeVO;
  }

  /**
   * # {@link SEFAZNFRefVO}.
   *
   * @return the {@link SEFAZNFRefVO}
   */
  public List<SEFAZNFRefVO> getNfRefList() {
    return nfRefList;
  }

  /**
   * # {@link SEFAZNFRefVO}.
   *
   * @param nfRefList the new {@link SEFAZNFRefVO}
   */
  public void setNfRefList(List<SEFAZNFRefVO> nfRefList) {
    this.nfRefList = nfRefList;
  }

}
