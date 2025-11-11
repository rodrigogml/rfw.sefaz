package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Description: Classe que representa a estrutura da tag infNFe (Informações da NF-e).<br>
 * Tabela de referência (SEFAZ):
 * <ul>
 * <li>#A01 | Campo: infNFe | Ele: G | Pai: Raiz | Ocor.: 1-1 | Grupo que contém as informações da NF-e</li>
 * <li>#A02 | Campo: versao | Ele: A | Pai: A01 | Tipo: C | Ocor.: 1-1 | Tam.: 1-4 | Versão do leiaute (4.00)</li>
 * <li>#A03 | Campo: Id | Ele: ID| Pai: A01 | Tipo: C | Ocor.: 1-1 | Tam.: 47 | Identificador da TAG a ser assinada (prefixo 'NFe' + chave de 44 dígitos)</li>
 * <li>#A04 | Campo: pk_nItem | Ele: RC | (regra de controle do Schema; não é campo a ser modelado)</li>
 * </ul>
 * Observação: elementos/grupos filhos serão modelados em VOs próprios.
 *
 * @author Rodrigo Leitão
 * @since (11 de nov. de 2025)
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_infnfe")
public class InfNFeVO extends RFWVO {

  private static final long serialVersionUID = 1L;

  /**
   * ID: #A02 | Campo: versao | Ele: A | Pai: A01 | Tipo: C | Ocor.: 1-1 | Tam.: 1-4 <br>
   * Descrição: Versão do leiaute (ex.: "4.00").
   */
  @RFWMetaStringField(caption = "Versão do Leiaute", maxLength = 4, minlength = 1, required = false)
  private String versao;

  /**
   * ID: #A03 | Campo: Id | Ele: ID | Pai: A01 | Tipo: C | Ocor.: 1-1 | Tam.: 47 <br>
   * Descrição: Identificador da TAG a ser assinada. Informar a Chave de Acesso precedida do literal 'NFe'. <br>
   * Exemplo de formato: NFe + 44 dígitos (regex: {@code NFe\\d{44}}).
   *
   * <br>
   * <b>Observação:</b> o nome do atributo no XML é apenas Id, mas por conflitos com o id herdado de RFWVO, foi rebatizado como idTag.
   */
  @RFWMetaStringField(caption = "Identificador da TAG (Id)", maxLength = 47, minlength = 47, pattern = "NFe\\d{44}", required = false, unique = true)
  private String idTag;

  /**
   * TAG: EmitVO
   */
  @RFWMetaRelationshipField(caption = "emit", relationship = RelationshipTypes.COMPOSITION, columnMapped = "idsefaz_infnfe", required = false)
  private EmitVO emitVO = null;

  /**
   * # iD: #A02 | Campo: versao | Ele: A | Pai: A01 | Tipo: C | Ocor.: 1-1 | Tam.: 1-4 <br>
   * Descrição: Versão do leiaute (ex.: "4.00").
   *
   * @return the iD: #A02 | Campo: versao | Ele: A | Pai: A01 | Tipo: C | Ocor
   */
  public String getVersao() {
    return versao;
  }

  /**
   * # iD: #A02 | Campo: versao | Ele: A | Pai: A01 | Tipo: C | Ocor.: 1-1 | Tam.: 1-4 <br>
   * Descrição: Versão do leiaute (ex.: "4.00").
   *
   * @param versao the new iD: #A02 | Campo: versao | Ele: A | Pai: A01 | Tipo: C | Ocor
   */
  public void setVersao(String versao) {
    this.versao = versao;
  }

  /**
   * # iD: #A03 | Campo: Id | Ele: ID | Pai: A01 | Tipo: C | Ocor.: 1-1 | Tam.: 47 <br>
   * Descrição: Identificador da TAG a ser assinada. Informar a Chave de Acesso precedida do literal 'NFe'. <br>
   * Exemplo de formato: NFe + 44 dígitos (regex: {@code NFe\\d{44}}). <br>
   * <b>Observação:</b> o nome do atributo no XML é apenas Id, mas por conflitos com o id herdado de RFWVO, foi rebatizado como idTag.
   *
   * @return the iD: #A03 | Campo: Id | Ele: ID | Pai: A01 | Tipo: C | Ocor
   */
  public String getIdTag() {
    return idTag;
  }

  /**
   * # iD: #A03 | Campo: Id | Ele: ID | Pai: A01 | Tipo: C | Ocor.: 1-1 | Tam.: 47 <br>
   * Descrição: Identificador da TAG a ser assinada. Informar a Chave de Acesso precedida do literal 'NFe'. <br>
   * Exemplo de formato: NFe + 44 dígitos (regex: {@code NFe\\d{44}}). <br>
   * <b>Observação:</b> o nome do atributo no XML é apenas Id, mas por conflitos com o id herdado de RFWVO, foi rebatizado como idTag.
   *
   * @param idTag the new iD: #A03 | Campo: Id | Ele: ID | Pai: A01 | Tipo: C | Ocor
   */
  public void setIdTag(String idTag) {
    this.idTag = idTag;
  }

  /**
   * # tAG: EmitVO.
   *
   * @return the tAG: EmitVO
   */
  public EmitVO getEmitVO() {
    return emitVO;
  }

  /**
   * # tAG: EmitVO.
   *
   * @param emitVO the new tAG: EmitVO
   */
  public void setEmitVO(EmitVO emitVO) {
    this.emitVO = emitVO;
  }

}
