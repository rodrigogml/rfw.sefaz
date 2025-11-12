package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaDateField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaDateField.DateResolution;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tpAmb;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_finNFe;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indFinal;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indIntermed;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indPres;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_mod;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_procEmi;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tpNF;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_idDest;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tpEmis;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tpImp;

/**
 * Classe que representa a estrutura da tag <b>ide</b> (Grupo de Identificação da NF-e) do XML da SEFAZ.<br>
 * Tabelas de origem: blocos B01..B29 do MOC (modelo 4.0).
 *
 * <p>
 * <b>Observação</b>: subgrupos/elementos filhos (ex.: B27.1 Sequência XML) serão modelados em VOs próprios.
 * </p>
 *
 * @author Rodrigo
 * @since (11 de nov. de 2025)
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_ide")
public class IdeVO extends RFWVO {

  private static final long serialVersionUID = -8293421193485571306L;

  /**
   * ID: <b>B02</b> – Código da UF do emitente (cUF).<br>
   * Tamanho: 2 dígitos (IBGE).<br>
   * Dica: utilize a Tabela IBGE de UF para validar o conteúdo.
   */
  @RFWMetaBigDecimalField(caption = "UF do emitente", required = false, absolute = true, scale = 0, minValue = "0", maxValue = "99")
  private BigDecimal cUF = null;

  /**
   * ID: <b>B03</b> – Código numérico que compõe a chave (cNF).<br>
   * Tamanho: 8 dígitos. Valor aleatório por NF-e/NFC-e.
   */
  @RFWMetaBigDecimalField(caption = "Código aleatório", required = false, absolute = true, scale = 0, minValue = "0", maxValue = "99999999")
  private BigDecimal cNF = null;

  /**
   * ID: <b>B04</b> – Descrição da natureza da operação (natOp).<br>
   * Tamanho: 1–60 caracteres.
   */
  @RFWMetaStringField(caption = "Natureza da operação", required = false, maxLength = 60, minlength = 1)
  private String natOp = null;

  /**
   * ID: <b>B06</b> – Modelo do Documento Fiscal (mod).<br>
   * Valores: 55=NF-e; 65=NFC-e.
   */
  @RFWMetaEnumField(caption = "Modelo", required = false)
  private SEFAZ_mod mod = null;

  /**
   * ID: <b>B07</b> – Série do documento (serie).<br>
   * Tamanho: 1–3 dígitos. Preencher com zeros quando não houver série.
   */
  @RFWMetaBigDecimalField(caption = "Série", required = false, absolute = true, scale = 0, minValue = "0", maxValue = "999")
  private BigDecimal serie = null;

  /**
   * ID: <b>B08</b> – Número do documento (nNF).<br>
   * Tamanho: 1–9 dígitos.
   */
  @RFWMetaBigDecimalField(caption = "Número", required = false, absolute = true, scale = 0, minValue = "0", maxValue = "999999999")
  private BigDecimal nNF = null;

  /**
   * ID: <b>B09</b> – Data/hora de emissão (dhEmi).<br>
   * Formato: UTC (AAAA-MM-DDThh:mm:ssTZD).
   */
  @RFWMetaDateField(caption = "Emissão (UTC)", required = false, resolution = DateResolution.SECOND)
  private LocalDateTime dhEmi = null;

  /**
   * ID: <b>B10</b> – Data/hora de saída/entrada (dhSaiEnt).<br>
   * Formato: UTC (AAAA-MM-DDThh:mm:ssTZD).<br>
   * Observação: para NFC-e não informar.
   */
  @RFWMetaDateField(caption = "Saída/Entrada (UTC)", required = false, resolution = DateResolution.SECOND)
  private LocalDateTime dhSaiEnt = null;

  /**
   * ID: <b>B11</b> – Tipo de operação (tpNF).<br>
   * 0=Entrada; 1=Saída.
   */
  @RFWMetaEnumField(caption = "Tipo de operação", required = false)
  private SEFAZ_tpNF tpNF = null;

  /**
   * ID: <b>B11a</b> – Destino da operação (idDest).<br>
   * 1=Interna; 2=Interestadual; 3=Exterior.
   */
  @RFWMetaEnumField(caption = "Destino", required = false)
  private SEFAZ_idDest idDest = null;

  /**
   * ID: <b>B12</b> – Município do fato gerador (cMunFG).<br>
   * Tamanho: 7 dígitos (IBGE).
   */
  @RFWMetaBigDecimalField(caption = "Município do fato gerador", required = false, absolute = true, scale = 0, minValue = "0", maxValue = "9999999")
  private BigDecimal cMunFG = null;

  /**
   * ID: <b>B21</b> – Formato de impressão do DANFE (tpImp).<br>
   * 0=Sem DANFE; 1=Retrato; 2=Paisagem; 3=Simplificado; 4=NFC-e; 5=NFC-e por mensagem eletrônica.
   */
  @RFWMetaEnumField(caption = "Formato de impressão", required = false)
  private SEFAZ_tpImp tpImp = null;

  /**
   * ID: <b>B22</b> – Tipo de emissão (tpEmis).<br>
   * Para NFC-e: válida a 9 (Off-line) e, a critério da UF, 4 (EPEC).
   */
  @RFWMetaEnumField(caption = "Tipo de emissão", required = false)
  private SEFAZ_tpEmis tpEmis = null;

  /**
   * ID: <b>B23</b> – Dígito verificador da chave (cDV).<br>
   * Tamanho: 1 dígito (módulo 11 da chave).
   */
  @RFWMetaBigDecimalField(caption = "DV da chave", required = false, absolute = true, scale = 0, minValue = "0", maxValue = "9")
  private BigDecimal cDV = null;

  /**
   * ID: <b>B24</b> – Ambiente (tpAmb).<br>
   * 1=Produção; 2=Homologação.
   */
  @RFWMetaEnumField(caption = "Ambiente", required = false)
  private SEFAZ_tpAmb tpAmb = null;

  /**
   * ID: <b>B25</b> – Finalidade da emissão (finNFe).<br>
   * 1=Normal; 2=Complementar; 3=Ajuste; 4=Devolução.
   */
  @RFWMetaEnumField(caption = "Finalidade", required = false)
  private SEFAZ_finNFe finNFe = null;

  /**
   * ID: <b>B25a</b> – Indicador de consumidor final (indFinal).<br>
   * 0=Não; 1=Sim.
   */
  @RFWMetaEnumField(caption = "Consumidor final", required = false)
  private SEFAZ_indFinal indFinal = null;

  /**
   * ID: <b>B25b</b> – Indicador de presença do comprador (indPres).<br>
   * 0=Não se aplica; 1=Presencial; 2=Internet; 3=Teleatendimento; 4=Entrega a domicílio; 5=Presencial fora do estabelecimento; 9=Outros.
   */
  @RFWMetaEnumField(caption = "Presença do comprador", required = false)
  private SEFAZ_indPres indPres = null;

  /**
   * ID: <b>B25c</b> – Indicador de intermediador/marketplace (indIntermed).<br>
   * 0=Sem intermediador; 1=Com intermediador.
   */
  @RFWMetaEnumField(caption = "Intermediador", required = false)
  private SEFAZ_indIntermed indIntermed = null;

  /**
   * ID: <b>B26</b> – Processo de emissão (procEmi).<br>
   * 0=Aplicativo do contribuinte; 1=Avulsa pelo Fisco; 2=Avulsa pelo contribuinte no site do Fisco; 3=Aplicativo do Fisco.
   */
  @RFWMetaEnumField(caption = "Processo de emissão", required = false)
  private SEFAZ_procEmi procEmi = null;

  /**
   * ID: <b>B27</b> – Versão do aplicativo emissor (verProc).<br>
   * Tamanho: 1–20 caracteres.
   */
  @RFWMetaStringField(caption = "Versão do app emissor", required = false, maxLength = 20, minlength = 1)
  private String verProc = null;

  /**
   * ID: <b>B28</b> – Data e hora da entrada em contingência (dhCont). Formato UTC: AAAA-MM-DDThh:mm:ssTZD.
   */
  @RFWMetaDateField(caption = "Entrada em contingência (UTC)", required = false, resolution = DateResolution.SECOND)
  private LocalDateTime dhCont = null;

  /**
   * ID: <b>B29</b> – Justificativa da entrada em contingência (xJust). Tamanho: 15–256.
   */
  @RFWMetaStringField(caption = "Justificativa de contingência", required = false, maxLength = 256, minlength = 15)
  private String xJust = null;

  /**
   * # iD: <b>B02</b> – Código da UF do emitente (cUF).<br>
   * Tamanho: 2 dígitos (IBGE).<br>
   * Dica: utilize a Tabela IBGE de UF para validar o conteúdo.
   *
   * @return the iD: <b>B02</b> – Código da UF do emitente (cUF)
   */
  public BigDecimal getCUF() {
    return cUF;
  }

  /**
   * # iD: <b>B02</b> – Código da UF do emitente (cUF).<br>
   * Tamanho: 2 dígitos (IBGE).<br>
   * Dica: utilize a Tabela IBGE de UF para validar o conteúdo.
   *
   * @param cUF the new iD: <b>B02</b> – Código da UF do emitente (cUF)
   */
  public void setCUF(BigDecimal cUF) {
    this.cUF = cUF;
  }

  /**
   * # iD: <b>B03</b> – Código numérico que compõe a chave (cNF).<br>
   * Tamanho: 8 dígitos. Valor aleatório por NF-e/NFC-e.
   *
   * @return the iD: <b>B03</b> – Código numérico que compõe a chave (cNF)
   */
  public BigDecimal getCNF() {
    return cNF;
  }

  /**
   * # iD: <b>B03</b> – Código numérico que compõe a chave (cNF).<br>
   * Tamanho: 8 dígitos. Valor aleatório por NF-e/NFC-e.
   *
   * @param cNF the new iD: <b>B03</b> – Código numérico que compõe a chave (cNF)
   */
  public void setCNF(BigDecimal cNF) {
    this.cNF = cNF;
  }

  /**
   * # iD: <b>B04</b> – Descrição da natureza da operação (natOp).<br>
   * Tamanho: 1–60 caracteres.
   *
   * @return the iD: <b>B04</b> – Descrição da natureza da operação (natOp)
   */
  public String getNatOp() {
    return natOp;
  }

  /**
   * # iD: <b>B04</b> – Descrição da natureza da operação (natOp).<br>
   * Tamanho: 1–60 caracteres.
   *
   * @param natOp the new iD: <b>B04</b> – Descrição da natureza da operação (natOp)
   */
  public void setNatOp(String natOp) {
    this.natOp = natOp;
  }

  /**
   * # iD: <b>B06</b> – Modelo do Documento Fiscal (mod).<br>
   * Valores: 55=NF-e; 65=NFC-e.
   *
   * @return the iD: <b>B06</b> – Modelo do Documento Fiscal (mod)
   */
  public SEFAZ_mod getMod() {
    return mod;
  }

  /**
   * # iD: <b>B06</b> – Modelo do Documento Fiscal (mod).<br>
   * Valores: 55=NF-e; 65=NFC-e.
   *
   * @param mod the new iD: <b>B06</b> – Modelo do Documento Fiscal (mod)
   */
  public void setMod(SEFAZ_mod mod) {
    this.mod = mod;
  }

  /**
   * # iD: <b>B07</b> – Série do documento (serie).<br>
   * Tamanho: 1–3 dígitos. Preencher com zeros quando não houver série.
   *
   * @return the iD: <b>B07</b> – Série do documento (serie)
   */
  public BigDecimal getSerie() {
    return serie;
  }

  /**
   * # iD: <b>B07</b> – Série do documento (serie).<br>
   * Tamanho: 1–3 dígitos. Preencher com zeros quando não houver série.
   *
   * @param serie the new iD: <b>B07</b> – Série do documento (serie)
   */
  public void setSerie(BigDecimal serie) {
    this.serie = serie;
  }

  /**
   * # iD: <b>B08</b> – Número do documento (nNF).<br>
   * Tamanho: 1–9 dígitos.
   *
   * @return the iD: <b>B08</b> – Número do documento (nNF)
   */
  public BigDecimal getNNF() {
    return nNF;
  }

  /**
   * # iD: <b>B08</b> – Número do documento (nNF).<br>
   * Tamanho: 1–9 dígitos.
   *
   * @param nNF the new iD: <b>B08</b> – Número do documento (nNF)
   */
  public void setNNF(BigDecimal nNF) {
    this.nNF = nNF;
  }

  /**
   * # iD: <b>B09</b> – Data/hora de emissão (dhEmi).<br>
   * Formato: UTC (AAAA-MM-DDThh:mm:ssTZD).
   *
   * @return the iD: <b>B09</b> – Data/hora de emissão (dhEmi)
   */
  public LocalDateTime getDhEmi() {
    return dhEmi;
  }

  /**
   * # iD: <b>B09</b> – Data/hora de emissão (dhEmi).<br>
   * Formato: UTC (AAAA-MM-DDThh:mm:ssTZD).
   *
   * @param dhEmi the new iD: <b>B09</b> – Data/hora de emissão (dhEmi)
   */
  public void setDhEmi(LocalDateTime dhEmi) {
    this.dhEmi = dhEmi;
  }

  /**
   * # iD: <b>B10</b> – Data/hora de saída/entrada (dhSaiEnt).<br>
   * Formato: UTC (AAAA-MM-DDThh:mm:ssTZD).<br>
   * Observação: para NFC-e não informar.
   *
   * @return the iD: <b>B10</b> – Data/hora de saída/entrada (dhSaiEnt)
   */
  public LocalDateTime getDhSaiEnt() {
    return dhSaiEnt;
  }

  /**
   * # iD: <b>B10</b> – Data/hora de saída/entrada (dhSaiEnt).<br>
   * Formato: UTC (AAAA-MM-DDThh:mm:ssTZD).<br>
   * Observação: para NFC-e não informar.
   *
   * @param dhSaiEnt the new iD: <b>B10</b> – Data/hora de saída/entrada (dhSaiEnt)
   */
  public void setDhSaiEnt(LocalDateTime dhSaiEnt) {
    this.dhSaiEnt = dhSaiEnt;
  }

  /**
   * # iD: <b>B11</b> – Tipo de operação (tpNF).<br>
   * 0=Entrada; 1=Saída.
   *
   * @return the iD: <b>B11</b> – Tipo de operação (tpNF)
   */
  public SEFAZ_tpNF getTpNF() {
    return tpNF;
  }

  /**
   * # iD: <b>B11</b> – Tipo de operação (tpNF).<br>
   * 0=Entrada; 1=Saída.
   *
   * @param tpNF the new iD: <b>B11</b> – Tipo de operação (tpNF)
   */
  public void setTpNF(SEFAZ_tpNF tpNF) {
    this.tpNF = tpNF;
  }

  /**
   * # iD: <b>B11a</b> – Destino da operação (idDest).<br>
   * 1=Interna; 2=Interestadual; 3=Exterior.
   *
   * @return the iD: <b>B11a</b> – Destino da operação (idDest)
   */
  public SEFAZ_idDest getIdDest() {
    return idDest;
  }

  /**
   * # iD: <b>B11a</b> – Destino da operação (idDest).<br>
   * 1=Interna; 2=Interestadual; 3=Exterior.
   *
   * @param idDest the new iD: <b>B11a</b> – Destino da operação (idDest)
   */
  public void setIdDest(SEFAZ_idDest idDest) {
    this.idDest = idDest;
  }

  /**
   * # iD: <b>B12</b> – Município do fato gerador (cMunFG).<br>
   * Tamanho: 7 dígitos (IBGE).
   *
   * @return the iD: <b>B12</b> – Município do fato gerador (cMunFG)
   */
  public BigDecimal getCMunFG() {
    return cMunFG;
  }

  /**
   * # iD: <b>B12</b> – Município do fato gerador (cMunFG).<br>
   * Tamanho: 7 dígitos (IBGE).
   *
   * @param cMunFG the new iD: <b>B12</b> – Município do fato gerador (cMunFG)
   */
  public void setCMunFG(BigDecimal cMunFG) {
    this.cMunFG = cMunFG;
  }

  /**
   * # iD: <b>B21</b> – Formato de impressão do DANFE (tpImp).<br>
   * 0=Sem DANFE; 1=Retrato; 2=Paisagem; 3=Simplificado; 4=NFC-e; 5=NFC-e por mensagem eletrônica.
   *
   * @return the iD: <b>B21</b> – Formato de impressão do DANFE (tpImp)
   */
  public SEFAZ_tpImp getTpImp() {
    return tpImp;
  }

  /**
   * # iD: <b>B21</b> – Formato de impressão do DANFE (tpImp).<br>
   * 0=Sem DANFE; 1=Retrato; 2=Paisagem; 3=Simplificado; 4=NFC-e; 5=NFC-e por mensagem eletrônica.
   *
   * @param tpImp the new iD: <b>B21</b> – Formato de impressão do DANFE (tpImp)
   */
  public void setTpImp(SEFAZ_tpImp tpImp) {
    this.tpImp = tpImp;
  }

  /**
   * # iD: <b>B22</b> – Tipo de emissão (tpEmis).<br>
   * Para NFC-e: válida a 9 (Off-line) e, a critério da UF, 4 (EPEC).
   *
   * @return the iD: <b>B22</b> – Tipo de emissão (tpEmis)
   */
  public SEFAZ_tpEmis getTpEmis() {
    return tpEmis;
  }

  /**
   * # iD: <b>B22</b> – Tipo de emissão (tpEmis).<br>
   * Para NFC-e: válida a 9 (Off-line) e, a critério da UF, 4 (EPEC).
   *
   * @param tpEmis the new iD: <b>B22</b> – Tipo de emissão (tpEmis)
   */
  public void setTpEmis(SEFAZ_tpEmis tpEmis) {
    this.tpEmis = tpEmis;
  }

  /**
   * # iD: <b>B23</b> – Dígito verificador da chave (cDV).<br>
   * Tamanho: 1 dígito (módulo 11 da chave).
   *
   * @return the iD: <b>B23</b> – Dígito verificador da chave (cDV)
   */
  public BigDecimal getCDV() {
    return cDV;
  }

  /**
   * # iD: <b>B23</b> – Dígito verificador da chave (cDV).<br>
   * Tamanho: 1 dígito (módulo 11 da chave).
   *
   * @param cDV the new iD: <b>B23</b> – Dígito verificador da chave (cDV)
   */
  public void setCDV(BigDecimal cDV) {
    this.cDV = cDV;
  }

  /**
   * # iD: <b>B24</b> – Ambiente (tpAmb).<br>
   * 1=Produção; 2=Homologação.
   *
   * @return the iD: <b>B24</b> – Ambiente (tpAmb)
   */
  public SEFAZ_tpAmb getTpAmb() {
    return tpAmb;
  }

  /**
   * # iD: <b>B24</b> – Ambiente (tpAmb).<br>
   * 1=Produção; 2=Homologação.
   *
   * @param tpAmb the new iD: <b>B24</b> – Ambiente (tpAmb)
   */
  public void setTpAmb(SEFAZ_tpAmb tpAmb) {
    this.tpAmb = tpAmb;
  }

  /**
   * # iD: <b>B25</b> – Finalidade da emissão (finNFe).<br>
   * 1=Normal; 2=Complementar; 3=Ajuste; 4=Devolução.
   *
   * @return the iD: <b>B25</b> – Finalidade da emissão (finNFe)
   */
  public SEFAZ_finNFe getFinNFe() {
    return finNFe;
  }

  /**
   * # iD: <b>B25</b> – Finalidade da emissão (finNFe).<br>
   * 1=Normal; 2=Complementar; 3=Ajuste; 4=Devolução.
   *
   * @param finNFe the new iD: <b>B25</b> – Finalidade da emissão (finNFe)
   */
  public void setFinNFe(SEFAZ_finNFe finNFe) {
    this.finNFe = finNFe;
  }

  /**
   * # iD: <b>B25a</b> – Indicador de consumidor final (indFinal).<br>
   * 0=Não; 1=Sim.
   *
   * @return the iD: <b>B25a</b> – Indicador de consumidor final (indFinal)
   */
  public SEFAZ_indFinal getIndFinal() {
    return indFinal;
  }

  /**
   * # iD: <b>B25a</b> – Indicador de consumidor final (indFinal).<br>
   * 0=Não; 1=Sim.
   *
   * @param indFinal the new iD: <b>B25a</b> – Indicador de consumidor final (indFinal)
   */
  public void setIndFinal(SEFAZ_indFinal indFinal) {
    this.indFinal = indFinal;
  }

  /**
   * # iD: <b>B25b</b> – Indicador de presença do comprador (indPres).<br>
   * 0=Não se aplica; 1=Presencial; 2=Internet; 3=Teleatendimento; 4=Entrega a domicílio; 5=Presencial fora do estabelecimento; 9=Outros.
   *
   * @return the iD: <b>B25b</b> – Indicador de presença do comprador (indPres)
   */
  public SEFAZ_indPres getIndPres() {
    return indPres;
  }

  /**
   * # iD: <b>B25b</b> – Indicador de presença do comprador (indPres).<br>
   * 0=Não se aplica; 1=Presencial; 2=Internet; 3=Teleatendimento; 4=Entrega a domicílio; 5=Presencial fora do estabelecimento; 9=Outros.
   *
   * @param indPres the new iD: <b>B25b</b> – Indicador de presença do comprador (indPres)
   */
  public void setIndPres(SEFAZ_indPres indPres) {
    this.indPres = indPres;
  }

  /**
   * # iD: <b>B25c</b> – Indicador de intermediador/marketplace (indIntermed).<br>
   * 0=Sem intermediador; 1=Com intermediador.
   *
   * @return the iD: <b>B25c</b> – Indicador de intermediador/marketplace (indIntermed)
   */
  public SEFAZ_indIntermed getIndIntermed() {
    return indIntermed;
  }

  /**
   * # iD: <b>B25c</b> – Indicador de intermediador/marketplace (indIntermed).<br>
   * 0=Sem intermediador; 1=Com intermediador.
   *
   * @param indIntermed the new iD: <b>B25c</b> – Indicador de intermediador/marketplace (indIntermed)
   */
  public void setIndIntermed(SEFAZ_indIntermed indIntermed) {
    this.indIntermed = indIntermed;
  }

  /**
   * # iD: <b>B26</b> – Processo de emissão (procEmi).<br>
   * 0=Aplicativo do contribuinte; 1=Avulsa pelo Fisco; 2=Avulsa pelo contribuinte no site do Fisco; 3=Aplicativo do Fisco.
   *
   * @return the iD: <b>B26</b> – Processo de emissão (procEmi)
   */
  public SEFAZ_procEmi getProcEmi() {
    return procEmi;
  }

  /**
   * # iD: <b>B26</b> – Processo de emissão (procEmi).<br>
   * 0=Aplicativo do contribuinte; 1=Avulsa pelo Fisco; 2=Avulsa pelo contribuinte no site do Fisco; 3=Aplicativo do Fisco.
   *
   * @param procEmi the new iD: <b>B26</b> – Processo de emissão (procEmi)
   */
  public void setProcEmi(SEFAZ_procEmi procEmi) {
    this.procEmi = procEmi;
  }

  /**
   * # iD: <b>B27</b> – Versão do aplicativo emissor (verProc).<br>
   * Tamanho: 1–20 caracteres.
   *
   * @return the iD: <b>B27</b> – Versão do aplicativo emissor (verProc)
   */
  public String getVerProc() {
    return verProc;
  }

  /**
   * # iD: <b>B27</b> – Versão do aplicativo emissor (verProc).<br>
   * Tamanho: 1–20 caracteres.
   *
   * @param verProc the new iD: <b>B27</b> – Versão do aplicativo emissor (verProc)
   */
  public void setVerProc(String verProc) {
    this.verProc = verProc;
  }

  /**
   * # iD: <b>B28</b> – Data e hora da entrada em contingência (dhCont). Formato UTC: AAAA-MM-DDThh:mm:ssTZD.
   *
   * @return the iD: <b>B28</b> – Data e hora da entrada em contingência (dhCont)
   */
  public LocalDateTime getDhCont() {
    return dhCont;
  }

  /**
   * # iD: <b>B28</b> – Data e hora da entrada em contingência (dhCont). Formato UTC: AAAA-MM-DDThh:mm:ssTZD.
   *
   * @param dhCont the new iD: <b>B28</b> – Data e hora da entrada em contingência (dhCont)
   */
  public void setDhCont(LocalDateTime dhCont) {
    this.dhCont = dhCont;
  }

  /**
   * # iD: <b>B29</b> – Justificativa da entrada em contingência (xJust). Tamanho: 15–256.
   *
   * @return the iD: <b>B29</b> – Justificativa da entrada em contingência (xJust)
   */
  public String getXJust() {
    return xJust;
  }

  /**
   * # iD: <b>B29</b> – Justificativa da entrada em contingência (xJust). Tamanho: 15–256.
   *
   * @param xJust the new iD: <b>B29</b> – Justificativa da entrada em contingência (xJust)
   */
  public void setXJust(String xJust) {
    this.xJust = xJust;
  }

}
