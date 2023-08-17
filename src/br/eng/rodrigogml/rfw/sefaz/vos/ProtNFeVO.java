package br.eng.rodrigogml.rfw.sefaz.vos;

import java.time.LocalDateTime;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaDateField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "protNFe" do layout de XML de Distribuição da NFe.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class ProtNFeVO extends RFWVO {

  private static final long serialVersionUID = -6384711805067141824L;

  /**
   * PR02 versao A PR01 N 1-1 2v2 Versão do leiaute das informações de Protocolo.
   */
  @RFWMetaStringField(caption = "Versão do Protocolo", minlength = 4, maxLength = 5, required = true, pattern = "\\d{1,2}\\.\\d{2}")
  private String versao = null;

  /**
   * PR04 Id ID PR03 C 0-1 -<br>
   * Identificador da TAG a ser assinada, somente precisa ser informado se a UF assinar a resposta. Em caso de assinatura da resposta pela SEFAZ preencher o campo com o Número do Protocolo, precedido com o literal “ID” <Br>
   * <br>
   * <b>Note que este atributo no XML é "id", mas foi chamado de idAttribute para evitar o conflito com o ID herdado de {@link RFWVO}
   */
  @RFWMetaStringField(caption = "Id", maxLength = 47, minlength = 47, required = true, pattern = "NFe[0-9]{44}")
  private String idAttribute = null;

  /**
   * PR05 tpAmb E PR03 N 1-1 1 Identificação do Ambiente:<br>
   * <li>1=Produção
   * <li>2=Homologação
   */
  @RFWMetaStringField(caption = "Identificação do Ambiente", minlength = 1, maxLength = 1, required = true, pattern = "^(1|2)$")
  private String tpAmb = null;

  /**
   * PR06 verAplic E PR03 C 1-1 1-20<br>
   * Versão do Aplicativo que processou o Lote.<br>
   * A versão deve ser iniciada com a sigla da UF nos casos de WS próprio ou a sigla SVAN ou SVRS nos demais casos.
   */
  @RFWMetaStringField(caption = "Versão do Aplicativo", minlength = 1, maxLength = 20, required = true)
  private String verAplic = null;

  /**
   * PR07 chNFe E PR03 N 1-1 44 Chave de Acesso da NF-e
   */
  @RFWMetaStringField(caption = "Chave de Acesso da NFe", minlength = 44, maxLength = 44, required = true, pattern = "^\\d{44}$")
  private String chNFe = null;

  /**
   * PR08 dhRecbto E PR03 D 1-1 - Preenchido com a data e hora do processamento (informado também no caso de rejeição).<br>
   * Formato: “AAAA-MM-DDThh:mm:ssTZD” (UTC – Universal Coordinated Time).
   */
  @RFWMetaDateField(caption = "Data/Hora do Processamento", required = true)
  private LocalDateTime dhRecbto = null;

  /**
   * PR09 nProt E PR03 N 0-1 15 Número do Protocolo da NF-e, conforme item 4.3.5
   */
  @RFWMetaStringField(caption = "Número do Protocolo", minlength = 15, maxLength = 15, required = false)
  private String nprot = null;

  /**
   * PR10 digVal E PR03 C 0-1 28<br>
   * Digest Value da NF-e processada Utilizado para conferir a integridade da NFe original.
   */
  @RFWMetaStringField(caption = "Digest Value", minlength = 28, maxLength = 28, required = false)
  private String digVal = null;

  /**
   * PR11 cStat E PR03 N 1-1 3<br>
   * Código do status da resposta (conforme item 4.4.1 do documento MOC – Anexo I – Leiaute NF-e/NFC-e)
   */
  @RFWMetaStringField(caption = "Código do Status da Resposta", minlength = 3, maxLength = 3, required = true)
  private String cstat = null;

  /**
   * PR12 xMotivo E PR03 C 1-1 1-255 Descrição literal do status da resposta para a NF-e.
   */
  @RFWMetaStringField(caption = "Motivo", minlength = 1, maxLength = 255, required = true)
  private String xmotivo = null;

  /**
   * PR14 cMsg E PR13 N 0-1 1-4<br>
   * Código da Mensagem. (Criado na NT 2018.005)
   */
  @RFWMetaStringField(caption = "Código da Mensagem", minlength = 1, maxLength = 4, required = false)
  private String cmsg = null;

  /**
   * PR15 xMsg E PR13 C 1-1 1-200<br>
   * Mensagem da SEFAZ para o emissor. (Criado na NT 2018.005)
   */
  @RFWMetaStringField(caption = "Mensagem da Sefaz para o Emissor", minlength = 1, maxLength = 200, required = false)
  private String xmsg = null;

  /**
   * # pR02 versao A PR01 N 1-1 2v2 Versão do leiaute das informações de Protocolo.
   *
   * @return # pR02 versao A PR01 N 1-1 2v2 Versão do leiaute das informações de Protocolo
   */
  public String getVersao() {
    return versao;
  }

  /**
   * # pR02 versao A PR01 N 1-1 2v2 Versão do leiaute das informações de Protocolo.
   *
   * @param versao # pR02 versao A PR01 N 1-1 2v2 Versão do leiaute das informações de Protocolo
   */
  public void setVersao(String versao) {
    this.versao = versao;
  }

  /**
   * # pR04 Id ID PR03 C 0-1 -<br>
   * Identificador da TAG a ser assinada, somente precisa ser informado se a UF assinar a resposta. Em caso de assinatura da resposta pela SEFAZ preencher o campo com o Número do Protocolo, precedido com o literal “ID” <Br>
   * <br>
   * <b>Note que este atributo no XML é "id", mas foi chamado de idAttribute para evitar o conflito com o ID herdado de {@link RFWVO}.
   *
   * @return # pR04 Id ID PR03 C 0-1 -<br>
   *         Identificador da TAG a ser assinada, somente precisa ser informado se a UF assinar a resposta
   */
  public String getIdAttribute() {
    return idAttribute;
  }

  /**
   * # pR04 Id ID PR03 C 0-1 -<br>
   * Identificador da TAG a ser assinada, somente precisa ser informado se a UF assinar a resposta. Em caso de assinatura da resposta pela SEFAZ preencher o campo com o Número do Protocolo, precedido com o literal “ID” <Br>
   * <br>
   * <b>Note que este atributo no XML é "id", mas foi chamado de idAttribute para evitar o conflito com o ID herdado de {@link RFWVO}.
   *
   * @param idAttribute # pR04 Id ID PR03 C 0-1 -<br>
   *          Identificador da TAG a ser assinada, somente precisa ser informado se a UF assinar a resposta
   */
  public void setIdAttribute(String idAttribute) {
    this.idAttribute = idAttribute;
  }

  /**
   * # pR05 tpAmb E PR03 N 1-1 1 Identificação do Ambiente:<br>
   * <li>1=Produção
   * <li>2=Homologação.
   *
   * @return # pR05 tpAmb E PR03 N 1-1 1 Identificação do Ambiente:<br>
   *         <li>1=Produção
   *         <li>2=Homologação
   */
  public String getTpAmb() {
    return tpAmb;
  }

  /**
   * # pR05 tpAmb E PR03 N 1-1 1 Identificação do Ambiente:<br>
   * <li>1=Produção
   * <li>2=Homologação.
   *
   * @param tpAmb # pR05 tpAmb E PR03 N 1-1 1 Identificação do Ambiente:<br>
   *          <li>1=Produção
   *          <li>2=Homologação
   */
  public void setTpAmb(String tpAmb) {
    this.tpAmb = tpAmb;
  }

  /**
   * # pR06 verAplic E PR03 C 1-1 1-20<br>
   * Versão do Aplicativo que processou o Lote.<br>
   * A versão deve ser iniciada com a sigla da UF nos casos de WS próprio ou a sigla SVAN ou SVRS nos demais casos.
   *
   * @return # pR06 verAplic E PR03 C 1-1 1-20<br>
   *         Versão do Aplicativo que processou o Lote
   */
  public String getVerAplic() {
    return verAplic;
  }

  /**
   * # pR06 verAplic E PR03 C 1-1 1-20<br>
   * Versão do Aplicativo que processou o Lote.<br>
   * A versão deve ser iniciada com a sigla da UF nos casos de WS próprio ou a sigla SVAN ou SVRS nos demais casos.
   *
   * @param verAplic # pR06 verAplic E PR03 C 1-1 1-20<br>
   *          Versão do Aplicativo que processou o Lote
   */
  public void setVerAplic(String verAplic) {
    this.verAplic = verAplic;
  }

  /**
   * # pR07 chNFe E PR03 N 1-1 44 Chave de Acesso da NF-e.
   *
   * @return # pR07 chNFe E PR03 N 1-1 44 Chave de Acesso da NF-e
   */
  public String getChNFe() {
    return chNFe;
  }

  /**
   * # pR07 chNFe E PR03 N 1-1 44 Chave de Acesso da NF-e.
   *
   * @param chNFe # pR07 chNFe E PR03 N 1-1 44 Chave de Acesso da NF-e
   */
  public void setChNFe(String chNFe) {
    this.chNFe = chNFe;
  }

  /**
   * # pR08 dhRecbto E PR03 D 1-1 - Preenchido com a data e hora do processamento (informado também no caso de rejeição).<br>
   * Formato: “AAAA-MM-DDThh:mm:ssTZD” (UTC – Universal Coordinated Time).
   *
   * @return # pR08 dhRecbto E PR03 D 1-1 - Preenchido com a data e hora do processamento (informado também no caso de rejeição)
   */
  public LocalDateTime getDhRecbto() {
    return dhRecbto;
  }

  /**
   * # pR08 dhRecbto E PR03 D 1-1 - Preenchido com a data e hora do processamento (informado também no caso de rejeição).<br>
   * Formato: “AAAA-MM-DDThh:mm:ssTZD” (UTC – Universal Coordinated Time).
   *
   * @param dhRecbto # pR08 dhRecbto E PR03 D 1-1 - Preenchido com a data e hora do processamento (informado também no caso de rejeição)
   */
  public void setDhRecbto(LocalDateTime dhRecbto) {
    this.dhRecbto = dhRecbto;
  }

  /**
   * # pR09 nProt E PR03 N 0-1 15 Número do Protocolo da NF-e, conforme item 4.3.5.
   *
   * @return # pR09 nProt E PR03 N 0-1 15 Número do Protocolo da NF-e, conforme item 4
   */
  public String getNprot() {
    return nprot;
  }

  /**
   * # pR09 nProt E PR03 N 0-1 15 Número do Protocolo da NF-e, conforme item 4.3.5.
   *
   * @param nprot # pR09 nProt E PR03 N 0-1 15 Número do Protocolo da NF-e, conforme item 4
   */
  public void setNprot(String nprot) {
    this.nprot = nprot;
  }

  /**
   * # pR10 digVal E PR03 C 0-1 28<br>
   * Digest Value da NF-e processada Utilizado para conferir a integridade da NFe original.
   *
   * @return # pR10 digVal E PR03 C 0-1 28<br>
   *         Digest Value da NF-e processada Utilizado para conferir a integridade da NFe original
   */
  public String getDigVal() {
    return digVal;
  }

  /**
   * # pR10 digVal E PR03 C 0-1 28<br>
   * Digest Value da NF-e processada Utilizado para conferir a integridade da NFe original.
   *
   * @param digVal # pR10 digVal E PR03 C 0-1 28<br>
   *          Digest Value da NF-e processada Utilizado para conferir a integridade da NFe original
   */
  public void setDigVal(String digVal) {
    this.digVal = digVal;
  }

  /**
   * # pR11 cStat E PR03 N 1-1 3<br>
   * Código do status da resposta (conforme item 4.4.1 do documento MOC – Anexo I – Leiaute NF-e/NFC-e).
   *
   * @return # pR11 cStat E PR03 N 1-1 3<br>
   *         Código do status da resposta (conforme item 4
   */
  public String getCstat() {
    return cstat;
  }

  /**
   * # pR11 cStat E PR03 N 1-1 3<br>
   * Código do status da resposta (conforme item 4.4.1 do documento MOC – Anexo I – Leiaute NF-e/NFC-e).
   *
   * @param cstat # pR11 cStat E PR03 N 1-1 3<br>
   *          Código do status da resposta (conforme item 4
   */
  public void setCstat(String cstat) {
    this.cstat = cstat;
  }

  /**
   * # pR12 xMotivo E PR03 C 1-1 1-255 Descrição literal do status da resposta para a NF-e.
   *
   * @return # pR12 xMotivo E PR03 C 1-1 1-255 Descrição literal do status da resposta para a NF-e
   */
  public String getXmotivo() {
    return xmotivo;
  }

  /**
   * # pR12 xMotivo E PR03 C 1-1 1-255 Descrição literal do status da resposta para a NF-e.
   *
   * @param xmotivo # pR12 xMotivo E PR03 C 1-1 1-255 Descrição literal do status da resposta para a NF-e
   */
  public void setXmotivo(String xmotivo) {
    this.xmotivo = xmotivo;
  }

  /**
   * # pR14 cMsg E PR13 N 0-1 1-4<br>
   * Código da Mensagem. (Criado na NT 2018.005).
   *
   * @return # pR14 cMsg E PR13 N 0-1 1-4<br>
   *         Código da Mensagem
   */
  public String getCmsg() {
    return cmsg;
  }

  /**
   * # pR14 cMsg E PR13 N 0-1 1-4<br>
   * Código da Mensagem. (Criado na NT 2018.005).
   *
   * @param cmsg # pR14 cMsg E PR13 N 0-1 1-4<br>
   *          Código da Mensagem
   */
  public void setCmsg(String cmsg) {
    this.cmsg = cmsg;
  }

  /**
   * # pR15 xMsg E PR13 C 1-1 1-200<br>
   * Mensagem da SEFAZ para o emissor. (Criado na NT 2018.005).
   *
   * @return # pR15 xMsg E PR13 C 1-1 1-200<br>
   *         Mensagem da SEFAZ para o emissor
   */
  public String getXmsg() {
    return xmsg;
  }

  /**
   * # pR15 xMsg E PR13 C 1-1 1-200<br>
   * Mensagem da SEFAZ para o emissor. (Criado na NT 2018.005).
   *
   * @param xmsg # pR15 xMsg E PR13 C 1-1 1-200<br>
   *          Mensagem da SEFAZ para o emissor
   */
  public void setXmsg(String xmsg) {
    this.xmsg = xmsg;
  }

}
