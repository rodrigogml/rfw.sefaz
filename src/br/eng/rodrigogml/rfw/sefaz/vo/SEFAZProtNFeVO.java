package br.eng.rodrigogml.rfw.sefaz.vo;

import java.time.LocalDateTime;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaDateField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaDateField.DateResolution;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaIntegerField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaLongField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tpAmb;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_versao;

/**
 * Description: Classe que representa o protocolo de retorno da NFe.<br>
 *
 * Pode ser retornada pelo objeto {@link SEFAZRetEnviNFeVO} nos casos de resposta síncrona, ou SEFAZRetConsReciNFeVO (ainda não implementado).
 *
 * @author Rodrigo Leitão
 * @since (21 de nov. de 2025)
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_protnfe")
public class SEFAZProtNFeVO extends RFWVO {

  private static final long serialVersionUID = -5696764880595637140L;

  /**
   * PR02 versao A PR01 N 1-1 2v2
   * <p>
   * Versão do leiaute das informações de Protocolo.
   * </p>
   */
  @RFWMetaEnumField(caption = "Versão", required = false)
  private SEFAZ_versao versao = null;

  /**
   * PR05 tpAmb E PR03 N 1-1 1
   * <p>
   * Identificação do Ambiente: 1=Produção/2=Homologação
   * </p>
   */
  @RFWMetaEnumField(caption = "Identificação do Ambiente", required = false)
  private SEFAZ_tpAmb tpAmb = null;

  /**
   * PR06 verAplic E PR03 C 1-1 1-20
   * <p>
   * Versão do Aplicativo que processou o Lote. A versão deve ser iniciada com a sigla da UF nos casos de WS próprio ou a sigla SVAN ou SVRS nos demais casos.
   * </p>
   */
  @RFWMetaStringField(caption = "Versão Aplicação", required = false, maxLength = 20)
  private String verAplic = null;

  /**
   * PR07 chNFe E PR03 N 1-1 44
   * <p>
   * Chave de Acesso da NF-e
   * </p>
   */
  @RFWMetaStringField(caption = "Chave", maxLength = 44, minLength = 44, required = false)
  private String chNFe = null;

  /**
   * PR08 dhRecbto E PR03 D 1-1 -
   * <p>
   * Preenchido com a data e hora do processamento (informado também no caso de rejeição). Formato: “AAAA-MM-DDThh:mm:ssTZD” (UTC – Universal Coordinated Time).
   * </p>
   */
  @RFWMetaDateField(caption = "Horário Processamento", required = false, resolution = DateResolution.SECOND)
  private LocalDateTime dhRecbto = null;

  /**
   * PR09 nProt E PR03 N 0-1 15
   * <p>
   * Número do Protocolo da NF-e, conforme item 4.3.5
   */
  @RFWMetaLongField(caption = "Número do Protocolo", minvalue = 0, maxvalue = 999999999999999L, required = false)
  private Long nprot = null;

  /**
   * PR10 digVal E PR03 C 0-1 28
   * <p>
   * Digest Value da NF-e processada Utilizado para conferir a integridade da NFe original
   * </p>
   */
  @RFWMetaStringField(caption = "Digest Value", maxLength = 28, required = false)
  private String digVal = null;

  /**
   * PR11 cStat E PR03 N 1-1 3
   * <p>
   * Código do status da resposta (conforme item 4.4.1 do documento MOC – Anexo I – Leiaute NF-e/NFC-e)
   * </p>
   */
  @RFWMetaIntegerField(caption = "Código do Status", minValue = 0, maxValue = 999, required = false)
  private Integer cstat = null;

  @RFWMetaStringField(caption = "Motivo", minLength = 1, maxLength = 255, required = false, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xmotivo = null;

  /**
   * PR14 cMsg E PR13 N 0-1 1-4
   * <p>
   * Código da Mensagem. (Criado na NT 2018.005)
   * </p>
   */
  @RFWMetaIntegerField(caption = "Código Mensagem SEFAZ", minValue = 0, maxValue = 9999, required = false)
  private Integer cmsg = null;

  /**
   * PR15 xMsg E PR13 C 1-1 1-200
   * <p>
   * Mensagem da SEFAZ para o emissor. (Criado na NT 2018.005)
   * </p>
   *
   */
  @RFWMetaStringField(caption = "Mensagem Sefaz", minLength = 1, maxLength = 200, required = false)
  private String xmsg = null;

  /**
   * # pR02 versao A PR01 N 1-1 2v2
   * <p>
   * Versão do leiaute das informações de Protocolo.
   * </p>
   * .
   *
   * @return the pR02 versao A PR01 N 1-1 2v2
   *         <p>
   *         Versão do leiaute das informações de Protocolo
   */
  public SEFAZ_versao getVersao() {
    return versao;
  }

  /**
   * # pR02 versao A PR01 N 1-1 2v2
   * <p>
   * Versão do leiaute das informações de Protocolo.
   * </p>
   * .
   *
   * @param versao the new pR02 versao A PR01 N 1-1 2v2
   *          <p>
   *          Versão do leiaute das informações de Protocolo
   */
  public void setVersao(SEFAZ_versao versao) {
    this.versao = versao;
  }

  /**
   * # pR05 tpAmb E PR03 N 1-1 1
   * <p>
   * Identificação do Ambiente: 1=Produção/2=Homologação
   * </p>
   * .
   *
   * @return the pR05 tpAmb E PR03 N 1-1 1
   *         <p>
   *         Identificação do Ambiente: 1=Produção/2=Homologação
   *         </p>
   */
  public SEFAZ_tpAmb getTpAmb() {
    return tpAmb;
  }

  /**
   * # pR05 tpAmb E PR03 N 1-1 1
   * <p>
   * Identificação do Ambiente: 1=Produção/2=Homologação
   * </p>
   * .
   *
   * @param tpAmb the new pR05 tpAmb E PR03 N 1-1 1
   *          <p>
   *          Identificação do Ambiente: 1=Produção/2=Homologação
   *          </p>
   */
  public void setTpAmb(SEFAZ_tpAmb tpAmb) {
    this.tpAmb = tpAmb;
  }

  /**
   * # pR06 verAplic E PR03 C 1-1 1-20
   * <p>
   * Versão do Aplicativo que processou o Lote. A versão deve ser iniciada com a sigla da UF nos casos de WS próprio ou a sigla SVAN ou SVRS nos demais casos.
   * </p>
   * .
   *
   * @return the pR06 verAplic E PR03 C 1-1 1-20
   *         <p>
   *         Versão do Aplicativo que processou o Lote
   */
  public String getVerAplic() {
    return verAplic;
  }

  /**
   * # pR06 verAplic E PR03 C 1-1 1-20
   * <p>
   * Versão do Aplicativo que processou o Lote. A versão deve ser iniciada com a sigla da UF nos casos de WS próprio ou a sigla SVAN ou SVRS nos demais casos.
   * </p>
   * .
   *
   * @param verAplic the new pR06 verAplic E PR03 C 1-1 1-20
   *          <p>
   *          Versão do Aplicativo que processou o Lote
   */
  public void setVerAplic(String verAplic) {
    this.verAplic = verAplic;
  }

  /**
   * # pR07 chNFe E PR03 N 1-1 44
   * <p>
   * Chave de Acesso da NF-e
   * </p>
   * .
   *
   * @return the pR07 chNFe E PR03 N 1-1 44
   *         <p>
   *         Chave de Acesso da NF-e
   *         </p>
   */
  public String getChNFe() {
    return chNFe;
  }

  /**
   * # pR07 chNFe E PR03 N 1-1 44
   * <p>
   * Chave de Acesso da NF-e
   * </p>
   * .
   *
   * @param chNFe the new pR07 chNFe E PR03 N 1-1 44
   *          <p>
   *          Chave de Acesso da NF-e
   *          </p>
   */
  public void setChNFe(String chNFe) {
    this.chNFe = chNFe;
  }

  /**
   * # pR08 dhRecbto E PR03 D 1-1 -
   * <p>
   * Preenchido com a data e hora do processamento (informado também no caso de rejeição). Formato: “AAAA-MM-DDThh:mm:ssTZD” (UTC – Universal Coordinated Time).
   * </p>
   * .
   *
   * @return the pR08 dhRecbto E PR03 D 1-1 -
   *         <p>
   *         Preenchido com a data e hora do processamento (informado também no caso de rejeição)
   */
  public LocalDateTime getDhRecbto() {
    return dhRecbto;
  }

  /**
   * # pR08 dhRecbto E PR03 D 1-1 -
   * <p>
   * Preenchido com a data e hora do processamento (informado também no caso de rejeição). Formato: “AAAA-MM-DDThh:mm:ssTZD” (UTC – Universal Coordinated Time).
   * </p>
   * .
   *
   * @param dhRecbto the new pR08 dhRecbto E PR03 D 1-1 -
   *          <p>
   *          Preenchido com a data e hora do processamento (informado também no caso de rejeição)
   */
  public void setDhRecbto(LocalDateTime dhRecbto) {
    this.dhRecbto = dhRecbto;
  }

  /**
   * # pR09 nProt E PR03 N 0-1 15
   * <p>
   * Número do Protocolo da NF-e, conforme item 4.3.5.
   *
   * @return the pR09 nProt E PR03 N 0-1 15
   *         <p>
   *         Número do Protocolo da NF-e, conforme item 4
   */
  public Long getNprot() {
    return nprot;
  }

  /**
   * # pR09 nProt E PR03 N 0-1 15
   * <p>
   * Número do Protocolo da NF-e, conforme item 4.3.5.
   *
   * @param nprot the new pR09 nProt E PR03 N 0-1 15
   *          <p>
   *          Número do Protocolo da NF-e, conforme item 4
   */
  public void setNprot(Long nprot) {
    this.nprot = nprot;
  }

  /**
   * # pR10 digVal E PR03 C 0-1 28
   * <p>
   * Digest Value da NF-e processada Utilizado para conferir a integridade da NFe original
   * </p>
   * .
   *
   * @return the pR10 digVal E PR03 C 0-1 28
   *         <p>
   *         Digest Value da NF-e processada Utilizado para conferir a integridade da NFe original
   *         </p>
   */
  public String getDigVal() {
    return digVal;
  }

  /**
   * # pR10 digVal E PR03 C 0-1 28
   * <p>
   * Digest Value da NF-e processada Utilizado para conferir a integridade da NFe original
   * </p>
   * .
   *
   * @param digVal the new pR10 digVal E PR03 C 0-1 28
   *          <p>
   *          Digest Value da NF-e processada Utilizado para conferir a integridade da NFe original
   *          </p>
   */
  public void setDigVal(String digVal) {
    this.digVal = digVal;
  }

  /**
   * # pR11 cStat E PR03 N 1-1 3
   * <p>
   * Código do status da resposta (conforme item 4.4.1 do documento MOC – Anexo I – Leiaute NF-e/NFC-e)
   * </p>
   * .
   *
   * @return the pR11 cStat E PR03 N 1-1 3
   *         <p>
   *         Código do status da resposta (conforme item 4
   */
  public Integer getCstat() {
    return cstat;
  }

  /**
   * # pR11 cStat E PR03 N 1-1 3
   * <p>
   * Código do status da resposta (conforme item 4.4.1 do documento MOC – Anexo I – Leiaute NF-e/NFC-e)
   * </p>
   * .
   *
   * @param cstat the new pR11 cStat E PR03 N 1-1 3
   *          <p>
   *          Código do status da resposta (conforme item 4
   */
  public void setCstat(Integer cstat) {
    this.cstat = cstat;
  }

  /**
   * Gets the xmotivo.
   *
   * @return the xmotivo
   */
  public String getXmotivo() {
    return xmotivo;
  }

  /**
   * Sets the xmotivo.
   *
   * @param xmotivo the new xmotivo
   */
  public void setXmotivo(String xmotivo) {
    this.xmotivo = xmotivo;
  }

  /**
   * # pR14 cMsg E PR13 N 0-1 1-4
   * <p>
   * Código da Mensagem. (Criado na NT 2018.005)
   * </p>
   * .
   *
   * @return the pR14 cMsg E PR13 N 0-1 1-4
   *         <p>
   *         Código da Mensagem
   */
  public Integer getCmsg() {
    return cmsg;
  }

  /**
   * # pR14 cMsg E PR13 N 0-1 1-4
   * <p>
   * Código da Mensagem. (Criado na NT 2018.005)
   * </p>
   * .
   *
   * @param cmsg the new pR14 cMsg E PR13 N 0-1 1-4
   *          <p>
   *          Código da Mensagem
   */
  public void setCmsg(Integer cmsg) {
    this.cmsg = cmsg;
  }

  /**
   * # pR15 xMsg E PR13 C 1-1 1-200
   * <p>
   * Mensagem da SEFAZ para o emissor. (Criado na NT 2018.005)
   * </p>
   * .
   *
   * @return the pR15 xMsg E PR13 C 1-1 1-200
   *         <p>
   *         Mensagem da SEFAZ para o emissor
   */
  public String getXmsg() {
    return xmsg;
  }

  /**
   * # pR15 xMsg E PR13 C 1-1 1-200
   * <p>
   * Mensagem da SEFAZ para o emissor. (Criado na NT 2018.005)
   * </p>
   * .
   *
   * @param xmsg the new pR15 xMsg E PR13 C 1-1 1-200
   *          <p>
   *          Mensagem da SEFAZ para o emissor
   */
  public void setXmsg(String xmsg) {
    this.xmsg = xmsg;
  }

}