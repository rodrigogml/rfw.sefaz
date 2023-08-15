package br.eng.rodrigogml.rfw.nf.vo;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBooleanField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaIntegerField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaLongField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCNPJField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCPFField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringIEField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.sefaz.SEFAZDefinitions.CUF;

/**
 * Description: Representação do grupo BA - Documento Fiscal Referenciado (TAG NFref).<br>
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Rodrigo GML-(...)
 */
public class RFWNFReferencedDocVO extends RFWVO {

  private static final long serialVersionUID = 7692136612659550139L;

  public static enum NFReferencedDocType {
    /**
     * Referencia uma NFe (modelo 55) u NFCe (Modelo 65).<br>
     */
    NFeOrNFCe,
    /**
     * Referencia um Cupom Fiscal do SAT na NFe
     */
    SAT,
    /**
     * Informação da NF modelo 1/1A referenciada.
     */
    NFMODEL01,
    /**
     * Informação da NF modelo 2 referenciada.
     */
    NFMODEL02,
    /**
     * Referencia uma Nota de produtor Rual
     */
    NFRURALPRODUCTOR,
    /**
     * Referencia um Cupom Fiscal Modelos:<bR>
     * "2B"=Cupom Fiscal emitido por máquina registradora (não ECF);<br>
     * "2C"=Cupom Fiscal PDV;<bR>
     * "2D"=Cupom Fiscal (emitido por ECF) (v2.0)
     */
    CF
  }

  /**
   * Tipo de documento que este objeto representa.<br>
   * De acordo com o tipo de documentos alguns conjuntos de campos tornam-se obrigatórios na NFe.<br>
   * <br>
   * De acordo com o valor deste campo o XML conterá um dos grupos de tags filhas:
   * <li>refNFe - Chave de acesso da NF-e referenciada. Neste caso não será um grupo de tags, apenas esta com o valor da chave da NFe.
   * <li>rfeNF - Informação da NF modelo 1/1A ou NF modelo 2 referenciada (alterado pela NT2016.002).
   * <li>rfeNFP - Informações da NF de produtor rural referenciada.
   * <li>refECF - Informações do Cupom Fiscal referenciado.
   */
  @RFWMetaEnumField(caption = "Tipo Documento", required = true)
  private NFReferencedDocType type = null;

  /**
   * Chave de acesso da NF-e referenciada.<br>
   * Obrigatória para {@link NFReferencedDocType#NFeOrNFCe} e {@link NFReferencedDocType#SAT}<br>
   *
   * <br>
   * Referencia uma NF-e (modelo 55) emitida anteriormente, vinculada a NF-e atual, ou uma NFC-e (modelo 65)<Br>
   * <Br>
   * TAG: NFe/infNFe/ide/NFref/refNFe
   */
  @RFWMetaStringField(caption = "Chave NFe", maxLength = 44, minlength = 44, pattern = "[0-9]{44}", required = false)
  private String chave = null;

  /**
   * Código da UF do emitente.<br>
   * Obrigatória para {@link NFReferencedDocType#NFRURALPRODUCTOR} e {@link NFReferencedDocType#NFMODEL01} <Br>
   * TAG: NFe/infNFe/ide/refNF/cUF, ou<Br>
   * TAG: NFe/infNFe/ide/refNFP/cUF
   */
  @RFWMetaEnumField(caption = "UF do Emitente", required = false)
  private CUF cuf = null;

  /**
   * Ano e Mês de emissão da NF <bR>
   * Obrigatória para {@link NFReferencedDocType#NFRURALPRODUCTOR} e {@link NFReferencedDocType#NFMODEL01} <br>
   * TAG: NFe/infNFe/ide/refNF/AAMM, ou<Br>
   * TAG: NFe/infNFe/ide/refNFP/AAMM
   */
  @RFWMetaStringField(caption = "Ano/Mês de Emissão", maxLength = 4, pattern = "[0-9]{4}", required = false)
  private String aamm = null;

  /**
   * CNPJ do Emissor<br>
   * Obrigatória para {@link NFReferencedDocType#NFMODEL01} e para {@link NFReferencedDocType#NFRURALPRODUCTOR}. Na nota de Produtos pode ser substituída pela tag do CPF.<br>
   * TAG: NFe/infNFe/ide/refNF/CNPJ, ou<Br>
   * TAG: NFe/infNFe/ide/refNFP/CNPJ
   */
  @RFWMetaStringCNPJField(caption = "CNPJ", required = false)
  private String cnpj = null;

  /**
   * CPF do Emissor<br>
   * Obrigatória para {@link NFReferencedDocType#NFRURALPRODUCTOR}, caso a tag CNPJ não esteja presente.<br>
   * TAG: NFe/infNFe/ide/refNFP/CPF
   */
  @RFWMetaStringCPFField(caption = "CPF", required = false)
  private String cpf = null;

  /**
   * Define o modelo do documento:<br>
   * Obrigatória para:<br>
   * <li>{@link NFReferencedDocType#NFRURALPRODUCTOR}:
   * <ul>
   * <li>04=NF de Produtor; 01=NF (v2.0)
   * </ul>
   * <li>{@link NFReferencedDocType#NFMODEL01}
   * <ul>
   * <li>01=modelo 01
   * </ul>
   * <li>{@link NFReferencedDocType#CF}
   * <ul>
   * <li>"2B"=Cupom Fiscal emitido por máquina registradora (não ECF)
   * <li>"2C"=Cupom Fiscal PDV
   * <li>"2D"=Cupom Fiscal (emitido por ECF) (v2.0)
   * </ul>
   * <br>
   * <Br>
   * TAG: NFe/infNFe/ide/refNF/mod, ou<Br>
   * TAG: NFe/infNFe/ide/refNFP/mod, ou<Br>
   * TAG: NFe/infNFe/ide/refECF/mod
   */
  @RFWMetaStringField(caption = "Modelo Documento", maxLength = 2, minlength = 2, required = false)
  private String modelo = null;

  /**
   * Série do documento fiscal<br>
   * Obrigatória para {@link NFReferencedDocType#NFRURALPRODUCTOR} e {@link NFReferencedDocType#NFMODEL01} <br>
   * <Br>
   * TAG: NFe/infNFe/ide/refNF/serie, ou<Br>
   * TAG: NFe/infNFe/ide/refNFP/serie
   */
  @RFWMetaIntegerField(caption = "Série", required = false, maxvalue = 999, minvalue = 0)
  private Integer serie = null;

  /**
   * Nùmero do documento fiscal<br>
   * Obrigatória para {@link NFReferencedDocType#NFRURALPRODUCTOR} e {@link NFReferencedDocType#NFMODEL01} <br>
   * <Br>
   * TAG: NFe/infNFe/ide/refNF/nNF, ou<Br>
   * TAG: NFe/infNFe/ide/refNFP/nNF
   */
  @RFWMetaLongField(caption = "Número", required = false, minvalue = 1, maxvalue = 999999999L)
  private Long number = null;

  /**
   * IE do Emissor<br>
   * Obrigatória para {@link NFReferencedDocType#NFRURALPRODUCTOR}<br>
   * Descrição da TAG no XML: Informar a IE do emitente da NF de Produtor ou o literal “ISENTO” (v2.0)<Br>
   * <bR>
   * Aqui no VO a tag deve conter apenas o IE do emitente da NF. No caso do IE ser isento, o atributo {@link #ieIsento} deve ser definido como nulo e este atributo deixado nulo. <br>
   * <Br>
   * TAG: NFe/infNFe/ide/refNFP/IE
   */
  @RFWMetaStringIEField(caption = "IE", required = false)
  private String ie = null;

  /**
   * Quando o conrtibuinte emissor for Isento de IE, deixar o {@link #ie} como <code>null</code> e definir esta flag como TRUE.<br>
   * Quando não for preencher {@link #ie} e definir esta flag como FALSE.<br>
   * Obrigatória para {@link NFReferencedDocType#NFRURALPRODUCTOR}
   */
  @RFWMetaBooleanField(caption = "IE Isento", required = false)
  private Boolean ieIsento = null;

  /**
   * Nota de transporte referênciada. (Chave de acesso do CT-e referenciada)<br>
   * Utilizar esta TAG para referenciar um CT-e emitido anteriormente, vinculada a NF-e atual - (v2.0).<br>
   * Obrigatória para {@link NFReferencedDocType#NFRURALPRODUCTOR}<br>
   * <Br>
   * TAG: NFe/infNFe/ide/refNFP/refCTe
   */
  @RFWMetaStringField(caption = "CTe Referenciada", maxLength = 44, pattern = "[0-9]{44}", required = false)
  private String refCTe = null;

  /**
   * Número sequêncial do ECF.<br>
   * Obrigatória para {@link NFReferencedDocType#CF} <br>
   * <Br>
   * TAG: NFe/infNFe/ide/refECF/nECF
   */
  @RFWMetaIntegerField(caption = "Número ECF", required = false, maxvalue = 999, minvalue = 0)
  private Integer numECF = null;

  /**
   * Número do COO do CF referenciado.<br>
   * Obrigatória para {@link NFReferencedDocType#CF} <br>
   * <Br>
   * TAG: NFe/infNFe/ide/refECF/nCOO
   */
  @RFWMetaLongField(caption = "COO", minvalue = 0, required = false)
  private Long coo = null;

  public NFReferencedDocType getType() {
    return type;
  }

  public void setType(NFReferencedDocType type) {
    this.type = type;
  }

  public String getChave() {
    return chave;
  }

  public void setChave(String chave) {
    this.chave = chave;
  }

  public CUF getCuf() {
    return cuf;
  }

  public void setCuf(CUF cuf) {
    this.cuf = cuf;
  }

  public String getAamm() {
    return aamm;
  }

  public void setAamm(String aamm) {
    this.aamm = aamm;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public Integer getSerie() {
    return serie;
  }

  public void setSerie(Integer serie) {
    this.serie = serie;
  }

  public Long getNumber() {
    return number;
  }

  public void setNumber(Long number) {
    this.number = number;
  }

  public String getIe() {
    return ie;
  }

  public void setIe(String ie) {
    this.ie = ie;
  }

  public Boolean getIeIsento() {
    return ieIsento;
  }

  public void setIeIsento(Boolean ieIsento) {
    this.ieIsento = ieIsento;
  }

  public String getRefCTe() {
    return refCTe;
  }

  public void setRefCTe(String refCTe) {
    this.refCTe = refCTe;
  }

  public Integer getNumECF() {
    return numECF;
  }

  public void setNumECF(Integer numECF) {
    this.numECF = numECF;
  }

  public Long getCoo() {
    return coo;
  }

  public void setCoo(Long coo) {
    this.coo = coo;
  }
}