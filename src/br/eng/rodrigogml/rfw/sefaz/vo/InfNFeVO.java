package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_versao;

/**
 * Grupo A (infNFe) - Informações da NF-e.
 *
 * <p>
 * Grupo que contém as informações da NF-e conforme especificação da NF-e.
 * </p>
 *
 * <p>
 * Elemento: A01 (infNFe) - Pai: Raiz - Ocorrência: 1-1.
 * </p>
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_infnfe")
public class InfNFeVO extends RFWVO {

  private static final long serialVersionUID = -8323509530326069450L;

  /**
   * {@link NFeVO}
   */
  @RFWMetaRelationshipField(caption = "NFe", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_nfe")
  private NFeVO nfeVO = null;

  /**
   * {@link IdeVO}
   */
  @RFWMetaRelationshipField(caption = "Ide", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_infnfe")
  private IdeVO ideVO = null;

  /**
   * {@link EmitVO}
   */
  @RFWMetaRelationshipField(caption = "Emit", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_infnfe")
  private EmitVO emitVO = null;

  /**
   * {@link DetVO}
   */
  @RFWMetaRelationshipField(caption = "Det", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_infnfe")
  private DetVO detVO = null;

  /**
   * Versão do leiaute da NF-e.
   *
   * <p>
   * ID: A02 - Campo: versao - Tipo: C - Ocorrência: 1-1 - Tamanho: 1-4.
   * </p>
   * <p>
   * Descrição: Versão do leiaute.
   * </p>
   * <p>
   * Observação: Versão do leiaute.
   * </p>
   */
  @RFWMetaEnumField(caption = "Versão", required = true)
  private SEFAZ_versao versao;

  /**
   * Identificador da TAG a ser assinada.
   *
   * <p>
   * ID: A03 - Campo: Id - Tipo: C - Ocorrência: 1-1 - Tamanho: 47.
   * </p>
   * <p>
   * Descrição: Identificador da TAG a ser assinada.
   * </p>
   * <p>
   * Observação: Informar a Chave de Acesso precedida do literal 'NFe'.
   * </p>
   */
  @RFWMetaStringField(caption = "Identificador da TAG a ser assinada", required = true, maxLength = 47, minLength = 47)
  private String idXML;

  /**
   * # versão do leiaute da NF-e.
   * <p>
   * ID: A02 - Campo: versao - Tipo: C - Ocorrência: 1-1 - Tamanho: 1-4.
   * </p>
   * <p>
   * Descrição: Versão do leiaute.
   * </p>
   * <p>
   * Observação: Versão do leiaute.
   * </p>
   * .
   *
   * @return the versão do leiaute da NF-e
   */
  public SEFAZ_versao getVersao() {
    return versao;
  }

  /**
   * # versão do leiaute da NF-e.
   * <p>
   * ID: A02 - Campo: versao - Tipo: C - Ocorrência: 1-1 - Tamanho: 1-4.
   * </p>
   * <p>
   * Descrição: Versão do leiaute.
   * </p>
   * <p>
   * Observação: Versão do leiaute.
   * </p>
   * .
   *
   * @param versao the new versão do leiaute da NF-e
   */
  public void setVersao(SEFAZ_versao versao) {
    this.versao = versao;
  }

  /**
   * # identificador da TAG a ser assinada.
   * <p>
   * ID: A03 - Campo: Id - Tipo: C - Ocorrência: 1-1 - Tamanho: 47.
   * </p>
   * <p>
   * Descrição: Identificador da TAG a ser assinada.
   * </p>
   * <p>
   * Observação: Informar a Chave de Acesso precedida do literal 'NFe'.
   * </p>
   * .
   *
   * @return the identificador da TAG a ser assinada
   */
  public String getIdXML() {
    return idXML;
  }

  /**
   * # identificador da TAG a ser assinada.
   * <p>
   * ID: A03 - Campo: Id - Tipo: C - Ocorrência: 1-1 - Tamanho: 47.
   * </p>
   * <p>
   * Descrição: Identificador da TAG a ser assinada.
   * </p>
   * <p>
   * Observação: Informar a Chave de Acesso precedida do literal 'NFe'.
   * </p>
   * .
   *
   * @param idXML the new identificador da TAG a ser assinada
   */
  public void setIdXML(String idXML) {
    this.idXML = idXML;
  }

  /**
   * # tAG NFeVO.
   *
   * @return the tAG NFeVO
   */
  public NFeVO getNfeVO() {
    return nfeVO;
  }

  /**
   * # tAG NFeVO.
   *
   * @param nfeVO the new tAG NFeVO
   */
  public void setNfeVO(NFeVO nfeVO) {
    this.nfeVO = nfeVO;
  }

  /**
   * # {@link IdeVO}.
   *
   * @return the {@link IdeVO}
   */
  public IdeVO getIdeVO() {
    return ideVO;
  }

  /**
   * # {@link IdeVO}.
   *
   * @param ideVO the new {@link IdeVO}
   */
  public void setIdeVO(IdeVO ideVO) {
    this.ideVO = ideVO;
  }

  /**
   * # {@link EmitVO}.
   *
   * @return the {@link EmitVO}
   */
  public EmitVO getEmitVO() {
    return emitVO;
  }

  /**
   * # {@link EmitVO}.
   *
   * @param emitVO the new {@link EmitVO}
   */
  public void setEmitVO(EmitVO emitVO) {
    this.emitVO = emitVO;
  }

  /**
   * # {@link DetVO}.
   *
   * @return the {@link DetVO}
   */
  public DetVO getDetVO() {
    return detVO;
  }

  /**
   * # {@link DetVO}.
   *
   * @param detVO the new {@link DetVO}
   */
  public void setDetVO(DetVO detVO) {
    this.detVO = detVO;
  }

}
