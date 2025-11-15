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
public class SEFAZInfNFeVO extends RFWVO {

  private static final long serialVersionUID = -8323509530326069450L;

  /**
   * {@link SEFAZNFeVO}
   */
  @RFWMetaRelationshipField(caption = "NFe", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_nfe")
  private SEFAZNFeVO nfeVO = null;

  /**
   * {@link SEFAZIdeVO}
   */
  @RFWMetaRelationshipField(caption = "Ide", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_infnfe")
  private SEFAZIdeVO ideVO = null;

  /**
   * {@link SEFAZEmitVO}
   */
  @RFWMetaRelationshipField(caption = "Emit", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_infnfe")
  private SEFAZEmitVO emitVO = null;

  /**
   * {@link SEFAZDetVO}
   */
  @RFWMetaRelationshipField(caption = "Det", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_infnfe")
  private SEFAZDetVO detVO = null;

  /**
   * {@link SEFAZTranspVO}
   */
  @RFWMetaRelationshipField(caption = "Transp", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_transp")
  private SEFAZTranspVO transpVO = null;

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
   * # tAG SEFAZNFeVO.
   *
   * @return the tAG SEFAZNFeVO
   */
  public SEFAZNFeVO getNfeVO() {
    return nfeVO;
  }

  /**
   * # tAG SEFAZNFeVO.
   *
   * @param nfeVO the new tAG SEFAZNFeVO
   */
  public void setNfeVO(SEFAZNFeVO nfeVO) {
    this.nfeVO = nfeVO;
  }

  /**
   * # {@link SEFAZIdeVO}.
   *
   * @return the {@link SEFAZIdeVO}
   */
  public SEFAZIdeVO getIdeVO() {
    return ideVO;
  }

  /**
   * # {@link SEFAZIdeVO}.
   *
   * @param ideVO the new {@link SEFAZIdeVO}
   */
  public void setIdeVO(SEFAZIdeVO ideVO) {
    this.ideVO = ideVO;
  }

  /**
   * # {@link SEFAZEmitVO}.
   *
   * @return the {@link SEFAZEmitVO}
   */
  public SEFAZEmitVO getEmitVO() {
    return emitVO;
  }

  /**
   * # {@link SEFAZEmitVO}.
   *
   * @param emitVO the new {@link SEFAZEmitVO}
   */
  public void setEmitVO(SEFAZEmitVO emitVO) {
    this.emitVO = emitVO;
  }

  /**
   * # {@link SEFAZDetVO}.
   *
   * @return the {@link SEFAZDetVO}
   */
  public SEFAZDetVO getDetVO() {
    return detVO;
  }

  /**
   * # {@link SEFAZDetVO}.
   *
   * @param detVO the new {@link SEFAZDetVO}
   */
  public void setDetVO(SEFAZDetVO detVO) {
    this.detVO = detVO;
  }

  /**
   * # {@link SEFAZTranspVO}.
   *
   * @return the {@link SEFAZTranspVO}
   */
  public SEFAZTranspVO getTranspVO() {
    return transpVO;
  }

  /**
   * # {@link SEFAZTranspVO}.
   *
   * @param transpVO the new {@link SEFAZTranspVO}
   */
  public void setTranspVO(SEFAZTranspVO transpVO) {
    this.transpVO = transpVO;
  }

}
