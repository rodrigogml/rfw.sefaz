package br.eng.rodrigogml.rfw.sefaz.vos;

import java.time.LocalDateTime;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaDateField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.sefaz.jaxbadapters.LocalDateTimeAdapter;

/**
 * Description: Este bean representa a tag "infCons" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
@XmlRootElement(name = "infCons")
public class InfConsVO extends RFWVO {

  private static final long serialVersionUID = -8748556680775875712L;

  /**
   * GR04 verAplic E GR03 C 1-1 1-20<br>
   * Versão do Aplicativo que processou a consulta. <Br>
   * A versão deve ser iniciada com a sigla da UF nos casos de WS próprio ou a sigla SVAN ou SVRS nos demais casos.
   */
  @RFWMetaStringField(caption = "Versão do Aplicativo", minlength = 1, maxLength = 20, required = true)
  private String verAplic = null;

  /**
   * GR05 cStat E GR03 N 1-1 3<br>
   * Código do status da resposta (conforme item 4.4.1 do documento MOC – Anexo I – Leiaute NF-e/NFC-e)
   */
  @RFWMetaStringField(caption = "Código do Status", minlength = 3, maxLength = 3, required = true)
  private String cStat = null;

  /**
   * GR06 xMotivo E GR03 C 1-1 1-255<br>
   * Descrição do Status da resposta
   */
  @RFWMetaStringField(caption = "Motivo", minlength = 1, maxLength = 255, required = true)
  private String xMotivo = null;

  /**
   * GR06a UF E GP03 C 1-1 2<br>
   * Sigla da UF consultada
   */
  @RFWMetaStringField(caption = "UF", minlength = 2, maxLength = 2, required = true)
  private String uf = null;

  /**
   * GR06b IE CE GP03 C 1-1 2-14<br>
   * Inscrição estadual consultada
   */
  @RFWMetaStringField(caption = "IE", minlength = 2, maxLength = 14, required = false)
  private String ie = null;

  /**
   * GR06c CNPJ CE GP03 N 1-1 3-14<br>
   * CNPJ consultado
   */
  @RFWMetaStringField(caption = "CNPJ", minlength = 3, maxLength = 14, required = false)
  private String cnpj = null;

  /**
   * GR06d CPF CE GP03 N 1-1 3-11<br>
   * CPF consultado
   */
  @RFWMetaStringField(caption = "CPF", minlength = 3, maxLength = 11, required = false)
  private String cpf = null;

  /**
   * GR06e dhCons E GR03 D 1-1<br>
   * Data e hora de processamento da consulta Formato = AAAA-MM-DDTHH:MM:SS
   */
  @RFWMetaDateField(caption = "Data/Hora da Consulta", required = true)
  private LocalDateTime dhCons = null;

  /**
   * GR06f cUF E GR03 N 1-1 2<br>
   * Código da UF que atendeu a solicitação.
   */
  @RFWMetaStringField(caption = "Código da UF", minlength = 2, maxLength = 2, required = true)
  private String cuf = null;

  /**
   * GR07 infCad G GR03 - 0-N -<Br>
   * Dados da situação cadastral <br>
   * Esta estrutura existe somente para as consultas realizadas com sucesso cStat=111, com possibilidade de múltiplas ocorrências (Ex.: consulta por IE de contribuinte com Inscrição Única – retorno de todos os estabelecimentos do contribuinte).
   */
  @RFWMetaRelationshipField(caption = "Dados da Situação Cadastral", required = true, relationship = RelationshipTypes.COMPOSITION)
  private List<InfCadVO> infCad = null;

  /**
   * # gR04 verAplic E GR03 C 1-1 1-20<br>
   * Versão do Aplicativo que processou a consulta. <Br>
   * A versão deve ser iniciada com a sigla da UF nos casos de WS próprio ou a sigla SVAN ou SVRS nos demais casos.
   *
   * @return # gR04 verAplic E GR03 C 1-1 1-20<br>
   *         Versão do Aplicativo que processou a consulta
   */
  public String getVerAplic() {
    return verAplic;
  }

  /**
   * # gR04 verAplic E GR03 C 1-1 1-20<br>
   * Versão do Aplicativo que processou a consulta. <Br>
   * A versão deve ser iniciada com a sigla da UF nos casos de WS próprio ou a sigla SVAN ou SVRS nos demais casos.
   *
   * @param verAplic # gR04 verAplic E GR03 C 1-1 1-20<br>
   *          Versão do Aplicativo que processou a consulta
   */
  public void setVerAplic(String verAplic) {
    this.verAplic = verAplic;
  }

  public String getcStat() {
    return cStat;
  }

  public void setcStat(String cStat) {
    this.cStat = cStat;
  }

  public String getxMotivo() {
    return xMotivo;
  }

  public void setxMotivo(String xMotivo) {
    this.xMotivo = xMotivo;
  }

  /**
   * # gR06a UF E GP03 C 1-1 2<br>
   * Sigla da UF consultada.
   *
   * @return # gR06a UF E GP03 C 1-1 2<br>
   *         Sigla da UF consultada
   */
  public String getUf() {
    return uf;
  }

  /**
   * # gR06a UF E GP03 C 1-1 2<br>
   * Sigla da UF consultada.
   *
   * @param uf # gR06a UF E GP03 C 1-1 2<br>
   *          Sigla da UF consultada
   */
  public void setUf(String uf) {
    this.uf = uf;
  }

  /**
   * # gR06b IE CE GP03 C 1-1 2-14<br>
   * Inscrição estadual consultada.
   *
   * @return # gR06b IE CE GP03 C 1-1 2-14<br>
   *         Inscrição estadual consultada
   */
  public String getIe() {
    return ie;
  }

  /**
   * # gR06b IE CE GP03 C 1-1 2-14<br>
   * Inscrição estadual consultada.
   *
   * @param ie # gR06b IE CE GP03 C 1-1 2-14<br>
   *          Inscrição estadual consultada
   */
  public void setIe(String ie) {
    this.ie = ie;
  }

  /**
   * # gR06c CNPJ CE GP03 N 1-1 3-14<br>
   * CNPJ consultado.
   *
   * @return # gR06c CNPJ CE GP03 N 1-1 3-14<br>
   *         CNPJ consultado
   */
  public String getCnpj() {
    return cnpj;
  }

  /**
   * # gR06c CNPJ CE GP03 N 1-1 3-14<br>
   * CNPJ consultado.
   *
   * @param cnpj # gR06c CNPJ CE GP03 N 1-1 3-14<br>
   *          CNPJ consultado
   */
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  /**
   * # gR06d CPF CE GP03 N 1-1 3-11<br>
   * CPF consultado.
   *
   * @return # gR06d CPF CE GP03 N 1-1 3-11<br>
   *         CPF consultado
   */
  public String getCpf() {
    return cpf;
  }

  /**
   * # gR06d CPF CE GP03 N 1-1 3-11<br>
   * CPF consultado.
   *
   * @param cpf # gR06d CPF CE GP03 N 1-1 3-11<br>
   *          CPF consultado
   */
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  /**
   * # gR06e dhCons E GR03 D 1-1<br>
   * Data e hora de processamento da consulta Formato = AAAA-MM-DDTHH:MM:SS.
   *
   * @return # gR06e dhCons E GR03 D 1-1<br>
   *         Data e hora de processamento da consulta Formato = AAAA-MM-DDTHH:MM:SS
   */
  @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
  public LocalDateTime getDhCons() {
    return dhCons;
  }

  /**
   * # gR06e dhCons E GR03 D 1-1<br>
   * Data e hora de processamento da consulta Formato = AAAA-MM-DDTHH:MM:SS.
   *
   * @param dhCons # gR06e dhCons E GR03 D 1-1<br>
   *          Data e hora de processamento da consulta Formato = AAAA-MM-DDTHH:MM:SS
   */
  public void setDhCons(LocalDateTime dhCons) {
    this.dhCons = dhCons;
  }

  /**
   * # gR06f cUF E GR03 N 1-1 2<br>
   * Código da UF que atendeu a solicitação.
   *
   * @return # gR06f cUF E GR03 N 1-1 2<br>
   *         Código da UF que atendeu a solicitação
   */
  public String getCuf() {
    return cuf;
  }

  /**
   * # gR06f cUF E GR03 N 1-1 2<br>
   * Código da UF que atendeu a solicitação.
   *
   * @param cuf # gR06f cUF E GR03 N 1-1 2<br>
   *          Código da UF que atendeu a solicitação
   */
  public void setCuf(String cuf) {
    this.cuf = cuf;
  }

  /**
   * # gR07 infCad G GR03 - 0-N -<Br>
   * Dados da situação cadastral <br>
   * Esta estrutura existe somente para as consultas realizadas com sucesso cStat=111, com possibilidade de múltiplas ocorrências (Ex.: consulta por IE de contribuinte com Inscrição Única – retorno de todos os estabelecimentos do contribuinte).
   *
   * @return # gR07 infCad G GR03 - 0-N -<Br>
   *         Dados da situação cadastral <br>
   *         Esta estrutura existe somente para as consultas realizadas com sucesso cStat=111, com possibilidade de múltiplas ocorrências (Ex
   */
  public List<InfCadVO> getInfCad() {
    return infCad;
  }

  /**
   * # gR07 infCad G GR03 - 0-N -<Br>
   * Dados da situação cadastral <br>
   * Esta estrutura existe somente para as consultas realizadas com sucesso cStat=111, com possibilidade de múltiplas ocorrências (Ex.: consulta por IE de contribuinte com Inscrição Única – retorno de todos os estabelecimentos do contribuinte).
   *
   * @param infCad # gR07 infCad G GR03 - 0-N -<Br>
   *          Dados da situação cadastral <br>
   *          Esta estrutura existe somente para as consultas realizadas com sucesso cStat=111, com possibilidade de múltiplas ocorrências (Ex
   */
  public void setInfCad(List<InfCadVO> infCad) {
    this.infCad = infCad;
  }

}
