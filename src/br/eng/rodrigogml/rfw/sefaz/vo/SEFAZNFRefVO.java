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
public class SEFAZNFRefVO extends RFWVO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * {@link SEFAZIdeVO}
   */
  @RFWMetaRelationshipField(caption = "ide", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_ide")
  private SEFAZIdeVO ideVO = null;

  /**
   * {@link SEFAZRefNFVO}
   */
  @RFWMetaRelationshipField(caption = "RefNF", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_nfref")
  private SEFAZRefNFVO refNFVO = null;

  /**
   * {@link SEFAZRefECFVO}
   */
  @RFWMetaRelationshipField(caption = "RefECF", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_nfref")
  private SEFAZRefNFPVO refNFPVO = null;

  /**
   * {@link SEFAZRefNFPVO}
   */
  @RFWMetaRelationshipField(caption = "RefNFP", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_nfref")
  private SEFAZRefECFVO refECFVO = null;

  /**
   * BA02 - Chave de acesso da NF-e ou NFC-e referenciada. Referencia uma NF-e (modelo 55) emitida anteriormente, ou uma NFC-e (modelo 65), vinculada à NF-e atual. Ocorrência: 0-1 dentro do grupo NRef.
   */
  @RFWMetaStringField(caption = "Chave de acesso da NF-e ou NFC-e referenciada", required = false, unique = false, maxLength = 44, minLength = 44, pattern = "", preProcess = { PreProcessOption.NONE })
  private String refNFe;

  /**
   * BA19 - Chave de acesso do CT-e referenciado. Utilizada para referenciar um CT-e emitido anteriormente, vinculado à NF-e atual. Ocorrência: 0-1 dentro do grupo NRef.
   */
  @RFWMetaStringField(caption = "Chave de acesso do CT-e referenciado", required = false, unique = false, maxLength = 44, minLength = 44, pattern = "", preProcess = { PreProcessOption.NONE })
  private String refCTe;

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
  public String getRefCTe() {
    return refCTe;
  }

  /**
   * # bA19 - Chave de acesso do CT-e referenciado. Utilizada para referenciar um CT-e emitido anteriormente, vinculado à NF-e atual. Ocorrência: 0-1 dentro do grupo NRef.
   *
   * @param refCTe the new bA19 - Chave de acesso do CT-e referenciado
   */
  public void setRefCTe(String refCte) {
    this.refCTe = refCte;
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
   * # {@link SEFAZRefNFVO}.
   *
   * @return the {@link SEFAZRefNFVO}
   */
  public SEFAZRefNFVO getRefNFVO() {
    return refNFVO;
  }

  /**
   * # {@link SEFAZRefNFVO}.
   *
   * @param refNFVO the new {@link SEFAZRefNFVO}
   */
  public void setRefNFVO(SEFAZRefNFVO refNFVO) {
    this.refNFVO = refNFVO;
  }

  /**
   * # {@link SEFAZRefNFPVO}.
   *
   * @return the {@link SEFAZRefNFPVO}
   */
  public SEFAZRefNFPVO getRefNFPVO() {
    return refNFPVO;
  }

  /**
   * # {@link SEFAZRefNFPVO}.
   *
   * @param refNFPVO the new {@link SEFAZRefNFPVO}
   */
  public void setRefNFPVO(SEFAZRefNFPVO refNFPVO) {
    this.refNFPVO = refNFPVO;
  }

  /**
   * # {@link SEFAZRefNFPVO}.
   *
   * @return the {@link SEFAZRefNFPVO}
   */
  public SEFAZRefECFVO getRefECFVO() {
    return refECFVO;
  }

  /**
   * # {@link SEFAZRefNFPVO}.
   *
   * @param refECFVO the new {@link SEFAZRefNFPVO}
   */
  public void setRefECFVO(SEFAZRefECFVO refECFVO) {
    this.refECFVO = refECFVO;
  }

}
