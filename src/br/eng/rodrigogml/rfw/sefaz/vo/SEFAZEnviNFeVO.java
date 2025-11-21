package br.eng.rodrigogml.rfw.sefaz.vo;

import java.util.List;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indSinc;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_versao;

/**
 * AP01 - enviNFe: Grupo Identificao do Lote de NF-e transmitido via WebService.<br>
 * <br>
 * Estrutura oficial (Manual de Orientao do Contribuinte - MOC):
 * <ul>
 * <li>AP02 - {@code versao}: Atributo (tipo {@code N}, tamanho 1-1, ocorrncia 1-1). Indica a verso do leiaute utilizado.</li>
 * <li>AP03 - {@code idLote}: Elemento numrico (tipo {@code N}, tamanho 1-15, ocorrncia 1-1). Identificador sequencial do lote g erado pelo emissor.</li>
 * <li>AP03a - {@code indSinc}: Elemento numrico (tipo {@code N}, tamanho 1, ocorrncia 0-1). Indicador de processamento sncrono (0 = No, 1 = Empresa solicita modo sncrono).</li>
 * <li>AP04 - {@code NFe}: Conjunto das NF-e (tipo {@code xml}, ocorrncia 1-50) que compem o lote.</li>
 * </ul>
 *
 * <p>
 * Este VO modela as informaes necessrias para persistir/compartilhar o payload {@code <enviNFe>} antes do envio SEFAZ, manten do aderente documentao oficial e fornecendo campos ricos em metadados para os conversores VO &lt;-&gt; JAXB.
 * </p>
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_envinfe")
public class SEFAZEnviNFeVO extends RFWVO {

  private static final long serialVersionUID = 9053060198806530623L;

  /**
   * Lista de NF-e que compem o lote (AP04). Ocorrncia mnima/mxima oficial: 1-50.
   *
   * <p>
  * Relacionamento por associao com {@link SEFAZNFeVO}, uma vez que a NF-e pode ser tratada fora do contexto estrito do lote, mas deve ser vinculada ao enviNFe no momento do envio. O relacionamento inverso no necessrio.
  * </p>
  */
  @RFWMetaRelationshipField(caption = "NFe", relationship = RelationshipTypes.ASSOCIATION, required = true, columnMapped = "idsefaz_envinfe", minSize = 1, maxSize = 50)
  private List<SEFAZNFeVO> nfeList;

  /**
   * AP02 - {@code versao}. Define a verso do leiaute utilizado no lote.
   *
   * <p>
   * Tipo: {@code N}; Tamanho: 1-2v2; Ocorrncia: 1-1.
   * </p>
   */
  @RFWMetaEnumField(caption = "Verso do leiaute do lote", required = true)
  private SEFAZ_versao versao;

  /**
   * AP03 - {@code idLote}. Identificador sequencial do lote gerado pelo emissor.
   *
   * <p>
   * Tipo: {@code N}; Tamanho: 1-15; Ocorrncia: 1-1. Deve conter apenas algarismos e ser controlado pela aplicao emissora.
   * </p>
   */
  @RFWMetaStringField(caption = "Identificador do lote", required = true, unique = false, maxLength = 15, minLength = 1, preProcess = { PreProcessOption.STRING_SPACESCLEAN_TO_NULL })
  private String idLote;

  /**
   * AP03a - {@code indSinc}. Indicador de processamento sncrono do lote, conforme NT 2013/005.
   *
   * <p>
   * Tipo: {@code N}; Tamanho: 1; Ocorrncia: 0-1. Valores possveis:
   * </p>
   * <ul>
   * <li>{@link SEFAZ_indSinc#NAO} ({@code 0}) no solicita processamento sncrono.</li>
   * <li>{@link SEFAZ_indSinc#SOLICITA_SINCRONO} ({@code 1}) requisita que a SEFAZ processe imediatamente o lote.</li>
   * </ul>
   */
  @RFWMetaEnumField(caption = "Indicador de processamento sncrono", required = false)
  private SEFAZ_indSinc indSinc;

  /**
   * # Lista de NF-e do lote (AP04).
   *
   * @return Lista contendo de 1 a 50 {@link SEFAZNFeVO} associados ao enviNFe.
   */
  public List<SEFAZNFeVO> getNfeList() {
    return nfeList;
  }

  /**
   * # Lista de NF-e do lote (AP04).
   *
   * @param nfeList nova lista com 1-50 {@link SEFAZNFeVO} para compor o lote.
   */
  public void setNfeList(List<SEFAZNFeVO> nfeList) {
    this.nfeList = nfeList;
  }

  /**
   * # AP02 - {@code versao}. Define a verso do leiaute utilizado no lote.
   *
   * @return {@link SEFAZ_versao} configurada.
   */
  public SEFAZ_versao getVersao() {
    return versao;
  }

  /**
   * # AP02 - {@code versao}. Define a verso do leiaute utilizado no lote.
   *
   * @param versao nova verso do leiaute do lote.
   */
  public void setVersao(SEFAZ_versao versao) {
    this.versao = versao;
  }

  /**
   * # AP03 - {@code idLote}. Identificador sequencial do lote gerado pelo emissor.
   *
   * @return identificador atualmente atribudo ao lote.
   */
  public String getIdLote() {
    return idLote;
  }

  /**
   * # AP03 - {@code idLote}. Identificador sequencial do lote gerado pelo emissor.
   *
   * @param idLote novo identificador do lote (1-15 caracteres numricos).
   */
  public void setIdLote(String idLote) {
    this.idLote = idLote;
  }

  /**
   * # AP03a - {@code indSinc}. Indicador de processamento sncrono do lote.
   *
   * @return {@link SEFAZ_indSinc} informado para o lote (ou {@code null} para comportamento assncrono).
   */
  public SEFAZ_indSinc getIndSinc() {
    return indSinc;
  }

  /**
   * # AP03a - {@code indSinc}. Indicador de processamento sncrono do lote.
   *
   * @param indSinc configurao desejada para processamento sncrono/assncrono.
   */
  public void setIndSinc(SEFAZ_indSinc indSinc) {
    this.indSinc = indSinc;
  }
}
