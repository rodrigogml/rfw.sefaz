package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaDateField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaDateField.DateResolution;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaIntegerField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaLongField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tpAmb;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_versao;

/**
 * Description: VO para representar a TAG: AR01 - retEnviNFe.<br>
 *
 * @author Rodrigo Leitão
 * @since (21 de nov. de 2025)
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_retenvinfe")
public class SEFAZRetEnviNFeVO extends RFWVO {

  private static final long serialVersionUID = 3350711304793896817L;

  /**
   * AR11 protNFe CG AR01 - 0-1 -
   * <p>
   * Dados do Protocolo de recebimento da NF-e gerado no caso do processamento síncrono do Lote de NFe, conforme descrito no item 5.2.2.
   * </p>
   */
  @RFWMetaRelationshipField(caption = "Protocolo NFe", relationship = RelationshipTypes.COMPOSITION, required = true, columnMapped = "idsefaz_retenvinfe")
  private SEFAZProtNFeVO protNFeVO = null;

  /**
   * AP02 - {@code versao}. Define a verso do leiaute utilizado no lote.
   *
   * <p>
   * Tipo: {@code N}; Tamanho: 1-2v2; Ocorrncia: 1-1.
   * </p>
   */
  @RFWMetaEnumField(caption = "Verso do leiaute do lote", required = false)
  private SEFAZ_versao versao;

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
   * AR04 verAplic E AR01 C 1-1 1-20 Versão do Aplicativo que recebeu o Lote.
   * <p>
   * A versão deve ser iniciada com a sigla da UF nos casos de WS próprio ou a sigla SVAN ou SVRS nos demais casos.
   * </p>
   */
  @RFWMetaStringField(caption = "Versão Aplicação SEFAZ", minLength = 1, maxLength = 20, required = false)
  private String verAplic = null;

  /**
   * AR05 cStat E AR01 N 1-1 3
   * <p>
   * Código do status da resposta (conforme item 4.4.1 do documento MOC – Anexo I – Leiaute NF-e/NFC-e)
   * </p>
   */
  @RFWMetaIntegerField(caption = "Código do Status", required = false, minValue = 0, maxValue = 999)
  private Integer cstat = null;

  /**
   * AR06 xMotivo E AR01 C 1-1 1-255
   * <p>
   * Descrição literal do status da resposta
   * </p>
   */
  @RFWMetaStringField(caption = "Motivo", maxLength = 255, required = false)
  private String xmotivo = null;

  /**
   * AR06a cUF E AR01 N 1-1 2
   * <p>
   * Código da UF que atendeu a solicitação.
   * </p>
   */
  @RFWMetaIntegerField(caption = "Código UF", required = false, minValue = 0, maxValue = 99)
  private Integer cuf = null;

  /**
   * AR06b dhRecbto E AR01 D 1-1 Preenchido com a data e hora do processamento (informado também no caso de rejeição).
   * <p>
   * Formato: “AAAA-MM-DDThh:mm:ssTZD” (UTC – Universal Coordinated Time).
   * </p>
   */
  @RFWMetaDateField(caption = "Data Processamentoi", resolution = DateResolution.SECOND, required = false)
  private LocalDateTime dhRecbto = null;

  /**
   * AR08 nRec E AR07 N 1-1 15
   * <p>
   * Número do Recibo gerado pelo Portal da Secretaria de Fazenda Estadual, conforme descrição do item 4.3.4
   * </p>
   */
  @RFWMetaLongField(caption = "Número do Recibo", minvalue = 0, maxvalue = 999999999999999L, required = false)
  private Long nrec = null;

  /**
   * AR10 tMed E AR07 N 1-1 Nv1-4
   * <p>
   * Tempo médio de resposta do serviço (em segundos) dos últimos 5 minutos, conforme descrição do item 4.3.6<br>
   * Nota: Caso o tempo médio de resposta fique abaixo de 1 (um) segundo, o tempo será informado como 1 segundo. Arredondar as frações de segundos para cima.
   * </p>
   */
  @RFWMetaBigDecimalField(caption = "Tempo Médio Reposta", scale = 1, scaleMax = 4, required = false)
  private BigDecimal tmed = null;

  /**
   * # aP02 - {@code versao}. Define a verso do leiaute utilizado no lote.
   * <p>
   * Tipo: {@code N}; Tamanho: 1-2v2; Ocorrncia: 1-1.
   * </p>
   * .
   *
   * @return the aP02 - {@code versao}
   */
  public SEFAZ_versao getVersao() {
    return versao;
  }

  /**
   * # aP02 - {@code versao}. Define a verso do leiaute utilizado no lote.
   * <p>
   * Tipo: {@code N}; Tamanho: 1-2v2; Ocorrncia: 1-1.
   * </p>
   * .
   *
   * @param versao the new aP02 - {@code versao}
   */
  public void setVersao(SEFAZ_versao versao) {
    this.versao = versao;
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
   * # aR04 verAplic E AR01 C 1-1 1-20 Versão do Aplicativo que recebeu o Lote.
   * <p>
   * A versão deve ser iniciada com a sigla da UF nos casos de WS próprio ou a sigla SVAN ou SVRS nos demais casos.
   * </p>
   * .
   *
   * @return the aR04 verAplic E AR01 C 1-1 1-20 Versão do Aplicativo que recebeu o Lote
   */
  public String getVerAplic() {
    return verAplic;
  }

  /**
   * # aR04 verAplic E AR01 C 1-1 1-20 Versão do Aplicativo que recebeu o Lote.
   * <p>
   * A versão deve ser iniciada com a sigla da UF nos casos de WS próprio ou a sigla SVAN ou SVRS nos demais casos.
   * </p>
   * .
   *
   * @param verAplic the new aR04 verAplic E AR01 C 1-1 1-20 Versão do Aplicativo que recebeu o Lote
   */
  public void setVerAplic(String verAplic) {
    this.verAplic = verAplic;
  }

  /**
   * # aR05 cStat E AR01 N 1-1 3
   * <p>
   * Código do status da resposta (conforme item 4.4.1 do documento MOC – Anexo I – Leiaute NF-e/NFC-e)
   * </p>
   * .
   *
   * @return the aR05 cStat E AR01 N 1-1 3
   *         <p>
   *         Código do status da resposta (conforme item 4
   */
  public Integer getCstat() {
    return cstat;
  }

  /**
   * # aR05 cStat E AR01 N 1-1 3
   * <p>
   * Código do status da resposta (conforme item 4.4.1 do documento MOC – Anexo I – Leiaute NF-e/NFC-e)
   * </p>
   * .
   *
   * @param cstat the new aR05 cStat E AR01 N 1-1 3
   *          <p>
   *          Código do status da resposta (conforme item 4
   */
  public void setCstat(Integer cstat) {
    this.cstat = cstat;
  }

  /**
   * # aR06 xMotivo E AR01 C 1-1 1-255
   * <p>
   * Descrição literal do status da resposta
   * </p>
   * .
   *
   * @return the aR06 xMotivo E AR01 C 1-1 1-255
   *         <p>
   *         Descrição literal do status da resposta
   *         </p>
   */
  public String getXmotivo() {
    return xmotivo;
  }

  /**
   * # aR06 xMotivo E AR01 C 1-1 1-255
   * <p>
   * Descrição literal do status da resposta
   * </p>
   * .
   *
   * @param xmotivo the new aR06 xMotivo E AR01 C 1-1 1-255
   *          <p>
   *          Descrição literal do status da resposta
   *          </p>
   */
  public void setXmotivo(String xmotivo) {
    this.xmotivo = xmotivo;
  }

  /**
   * # aR06a cUF E AR01 N 1-1 2
   * <p>
   * Código da UF que atendeu a solicitação.
   * </p>
   * .
   *
   * @return the aR06a cUF E AR01 N 1-1 2
   *         <p>
   *         Código da UF que atendeu a solicitação
   */
  public Integer getCuf() {
    return cuf;
  }

  /**
   * # aR06a cUF E AR01 N 1-1 2
   * <p>
   * Código da UF que atendeu a solicitação.
   * </p>
   * .
   *
   * @param cuf the new aR06a cUF E AR01 N 1-1 2
   *          <p>
   *          Código da UF que atendeu a solicitação
   */
  public void setCuf(Integer cuf) {
    this.cuf = cuf;
  }

  /**
   * # aR06b dhRecbto E AR01 D 1-1 Preenchido com a data e hora do processamento (informado também no caso de rejeição).
   * <p>
   * Formato: “AAAA-MM-DDThh:mm:ssTZD” (UTC – Universal Coordinated Time).
   * </p>
   * .
   *
   * @return the aR06b dhRecbto E AR01 D 1-1 Preenchido com a data e hora do processamento (informado também no caso de rejeição)
   */
  public LocalDateTime getDhRecbto() {
    return dhRecbto;
  }

  /**
   * # aR06b dhRecbto E AR01 D 1-1 Preenchido com a data e hora do processamento (informado também no caso de rejeição).
   * <p>
   * Formato: “AAAA-MM-DDThh:mm:ssTZD” (UTC – Universal Coordinated Time).
   * </p>
   * .
   *
   * @param dhRecbto the new aR06b dhRecbto E AR01 D 1-1 Preenchido com a data e hora do processamento (informado também no caso de rejeição)
   */
  public void setDhRecbto(LocalDateTime dhRecbto) {
    this.dhRecbto = dhRecbto;
  }

  /**
   * # aR08 nRec E AR07 N 1-1 15
   * <p>
   * Número do Recibo gerado pelo Portal da Secretaria de Fazenda Estadual, conforme descrição do item 4.3.4
   * </p>
   * .
   *
   * @return the aR08 nRec E AR07 N 1-1 15
   *         <p>
   *         Número do Recibo gerado pelo Portal da Secretaria de Fazenda Estadual, conforme descrição do item 4
   */
  public Long getNrec() {
    return nrec;
  }

  /**
   * # aR08 nRec E AR07 N 1-1 15
   * <p>
   * Número do Recibo gerado pelo Portal da Secretaria de Fazenda Estadual, conforme descrição do item 4.3.4
   * </p>
   * .
   *
   * @param nrec the new aR08 nRec E AR07 N 1-1 15
   *          <p>
   *          Número do Recibo gerado pelo Portal da Secretaria de Fazenda Estadual, conforme descrição do item 4
   */
  public void setNrec(Long nrec) {
    this.nrec = nrec;
  }

  /**
   * # aR10 tMed E AR07 N 1-1 Nv1-4
   * <p>
   * Tempo médio de resposta do serviço (em segundos) dos últimos 5 minutos, conforme descrição do item 4.3.6<br>
   * Nota: Caso o tempo médio de resposta fique abaixo de 1 (um) segundo, o tempo será informado como 1 segundo. Arredondar as frações de segundos para cima.
   * </p>
   * .
   *
   * @return the aR10 tMed E AR07 N 1-1 Nv1-4
   *         <p>
   *         Tempo médio de resposta do serviço (em segundos) dos últimos 5 minutos, conforme descrição do item 4
   */
  public BigDecimal getTmed() {
    return tmed;
  }

  /**
   * # aR10 tMed E AR07 N 1-1 Nv1-4
   * <p>
   * Tempo médio de resposta do serviço (em segundos) dos últimos 5 minutos, conforme descrição do item 4.3.6<br>
   * Nota: Caso o tempo médio de resposta fique abaixo de 1 (um) segundo, o tempo será informado como 1 segundo. Arredondar as frações de segundos para cima.
   * </p>
   * .
   *
   * @param tmed the new aR10 tMed E AR07 N 1-1 Nv1-4
   *          <p>
   *          Tempo médio de resposta do serviço (em segundos) dos últimos 5 minutos, conforme descrição do item 4
   */
  public void setTmed(BigDecimal tmed) {
    this.tmed = tmed;
  }

  /**
   * Gets the prot N fe VO.
   *
   * @return the prot N fe VO
   */
  public SEFAZProtNFeVO getProtNFeVO() {
    return protNFeVO;
  }

  /**
   * Sets the prot N fe VO.
   *
   * @param protNFeVO the new prot N fe VO
   */
  public void setProtNFeVO(SEFAZProtNFeVO protNFeVO) {
    this.protNFeVO = protNFeVO;
  }

}
