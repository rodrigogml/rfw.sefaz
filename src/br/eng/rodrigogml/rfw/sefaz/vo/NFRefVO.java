package br.eng.rodrigogml.rfw.sefaz.vo;

import java.io.Serializable;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * VO para o grupo BA01 (NRef) – Informação de Documentos Fiscais referenciados. Utilizado nas hipóteses previstas na legislação (ex.: devolução de mercadorias, substituição de NF cancelada, complementação de NF etc.), para vincular a NF-e atual a documentos fiscais anteriormente emitidos.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_nfref")
public class NFRefVO extends RFWVO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * {@link IdeVO}
   */
  @RFWMetaRelationshipField(caption = "ide", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_ide")
  private IdeVO ideVO = null;

  /**
   * {@link RefNFVO}
   */
  @RFWMetaRelationshipField(caption = "RefNF", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_nfref")
  private RefNFVO refNFVO = null;

  /**
   * {@link RefNFPVO}
   */
  @RFWMetaRelationshipField(caption = "RefNFP", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_nfref")
  private RefECFVO refECFVO = null;

  /**
   * {@link RefECFVO}
   */
  @RFWMetaRelationshipField(caption = "RefECF", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_nfref")
  private RefNFPVO refNFPVO = null;

  /**
   * BA02 - Chave de acesso da NF-e ou NFC-e referenciada. Referencia uma NF-e (modelo 55) emitida anteriormente, ou uma NFC-e (modelo 65), vinculada à NF-e atual. Ocorrência: 0-1 dentro do grupo NRef.
   */
  @RFWMetaStringField(caption = "Chave de acesso da NF-e ou NFC-e referenciada", required = false, unique = false, maxLength = 44, minLength = 44, pattern = "", preProcess = { PreProcessOption.NONE })
  private String refNFe;

  /**
   * BA19 - Chave de acesso do CT-e referenciado. Utilizada para referenciar um CT-e emitido anteriormente, vinculado à NF-e atual. Ocorrência: 0-1 dentro do grupo NRef.
   */
  @RFWMetaStringField(caption = "Chave de acesso do CT-e referenciado", required = false, unique = false, maxLength = 44, minLength = 44, pattern = "", preProcess = { PreProcessOption.NONE })
  private String refCte;

  /**
   * # bA02 - Chave de acesso da NF-e ou NFC-e referenciada. Referencia uma NF-e (modelo 55) emitida anteriormente, ou uma NFC-e (modelo 65), vinculada à NF-e atual. Ocorrência: 0-1 dentro do grupo NRef.
   *
   * @return the bA02 - Chave de acesso da NF-e ou NFC-e referenciada
   */
  public String getRefNFe() {
    return refNFe;
  }

  /**
   * # bA02 - Chave de acesso da NF-e ou NFC-e referenciada. Referencia uma NF-e (modelo 55) emitida anteriormente, ou uma NFC-e (modelo 65), vinculada à NF-e atual. Ocorrência: 0-1 dentro do grupo NRef.
   *
   * @param refNFe the new bA02 - Chave de acesso da NF-e ou NFC-e referenciada
   */
  public void setRefNFe(String refNFe) {
    this.refNFe = refNFe;
  }

  /**
   * # bA19 - Chave de acesso do CT-e referenciado. Utilizada para referenciar um CT-e emitido anteriormente, vinculado à NF-e atual. Ocorrência: 0-1 dentro do grupo NRef.
   *
   * @return the bA19 - Chave de acesso do CT-e referenciado
   */
  public String getRefCte() {
    return refCte;
  }

  /**
   * # bA19 - Chave de acesso do CT-e referenciado. Utilizada para referenciar um CT-e emitido anteriormente, vinculado à NF-e atual. Ocorrência: 0-1 dentro do grupo NRef.
   *
   * @param refCte the new bA19 - Chave de acesso do CT-e referenciado
   */
  public void setRefCte(String refCte) {
    this.refCte = refCte;
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
   * # {@link RefNFVO}.
   *
   * @return the {@link RefNFVO}
   */
  public RefNFVO getRefNFVO() {
    return refNFVO;
  }

  /**
   * # {@link RefNFVO}.
   *
   * @param refNFVO the new {@link RefNFVO}
   */
  public void setRefNFVO(RefNFVO refNFVO) {
    this.refNFVO = refNFVO;
  }

  /**
   * # {@link RefNFPVO}.
   *
   * @return the {@link RefNFPVO}
   */
  public RefNFPVO getRefNFPVO() {
    return refNFPVO;
  }

  /**
   * # {@link RefNFPVO}.
   *
   * @param refNFPVO the new {@link RefNFPVO}
   */
  public void setRefNFPVO(RefNFPVO refNFPVO) {
    this.refNFPVO = refNFPVO;
  }

  /**
   * # {@link RefNFPVO}.
   *
   * @return the {@link RefNFPVO}
   */
  public RefECFVO getRefECFVO() {
    return refECFVO;
  }

  /**
   * # {@link RefNFPVO}.
   *
   * @param refECFVO the new {@link RefNFPVO}
   */
  public void setRefECFVO(RefECFVO refECFVO) {
    this.refECFVO = refECFVO;
  }

}
