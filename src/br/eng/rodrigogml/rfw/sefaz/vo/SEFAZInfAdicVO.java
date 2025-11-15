package br.eng.rodrigogml.rfw.sefaz.vo;

import java.util.List;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Z01 - infAdic: Grupo de Informações Adicionais.
 * <p>
 * Ocorrência: 0-1 no grupo A01.
 * </p>
 * <p>
 * Contém:
 * </p>
 * <ul>
 * <li>Z02 - infAdFisco</li>
 * <li>Z03 - infCpl</li>
 * <li>Z04 - obsCont (0-10)</li>
 * <li>Z07 - obsFisco (0-10)</li>
 * <li>Z10 - procRef (0-100)</li>
 * </ul>
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_infadic")
public class SEFAZInfAdicVO extends RFWVO {

  private static final long serialVersionUID = -913086371030786562L;

  /**
   * {@link SEFAZInfNFeVO}
   */
  @RFWMetaRelationshipField(caption = "InfNFe", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_infnfe")
  private SEFAZInfNFeVO infNFeVO = null;

  /**
   * Z04 - obsCont: Grupo Campo de uso livre do contribuinte. Ocorrência 0-10.
   */
  @RFWMetaRelationshipField(caption = "ObsCont", relationship = RelationshipTypes.COMPOSITION, required = false, column = "idsefaz_infadic", minSize = 0, maxSize = 10)
  private List<SEFAZObsContVO> obsCont;

  /**
   * Z07 - obsFisco: Grupo Campo de uso livre do Fisco. Ocorrência 0-10.
   */
  @RFWMetaRelationshipField(caption = "ObsFisco", relationship = RelationshipTypes.COMPOSITION, required = false, column = "idsefaz_infadic", minSize = 0, maxSize = 10)
  private List<SEFAZObsFiscoVO> obsFisco;

  /**
   * Z10 - procRef: Grupo Processo Referenciado. Ocorrência 0-100.
   */
  @RFWMetaRelationshipField(caption = "ProcRef", relationship = RelationshipTypes.COMPOSITION, required = false, column = "idsefaz_infadic", minSize = 0, maxSize = 100)
  private List<SEFAZProcRefVO> procRef;

  /**
   * Z02 - infAdFisco: Informações Adicionais de Interesse do Fisco. Tipo C, tamanho 1-2000, ocorrência 0-1.
   */
  @RFWMetaStringField(caption = "infAdFisco", required = false, unique = false, maxLength = 2000, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String infAdFisco;

  /**
   * Z03 - infCpl: Informações Complementares de interesse do contribuinte. Tipo C, tamanho 1-5000, ocorrência 0-1.
   */
  @RFWMetaStringField(caption = "infCpl", required = false, unique = false, maxLength = 5000, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String infCpl;

  /**
   * # {@link SEFAZInfNFeVO}.
   *
   * @return the {@link SEFAZInfNFeVO}
   */
  public SEFAZInfNFeVO getInfNFeVO() {
    return infNFeVO;
  }

  /**
   * # {@link SEFAZInfNFeVO}.
   *
   * @param infNFeVO the new {@link SEFAZInfNFeVO}
   */
  public void setInfNFeVO(SEFAZInfNFeVO infNFeVO) {
    this.infNFeVO = infNFeVO;
  }

  /**
   * # z04 - obsCont: Grupo Campo de uso livre do contribuinte. Ocorrência 0-10.
   *
   * @return the z04 - obsCont: Grupo Campo de uso livre do contribuinte
   */
  public List<SEFAZObsContVO> getObsCont() {
    return obsCont;
  }

  /**
   * # z04 - obsCont: Grupo Campo de uso livre do contribuinte. Ocorrência 0-10.
   *
   * @param obsCont the new z04 - obsCont: Grupo Campo de uso livre do contribuinte
   */
  public void setObsCont(List<SEFAZObsContVO> obsCont) {
    this.obsCont = obsCont;
  }

  /**
   * # z07 - obsFisco: Grupo Campo de uso livre do Fisco. Ocorrência 0-10.
   *
   * @return the z07 - obsFisco: Grupo Campo de uso livre do Fisco
   */
  public List<SEFAZObsFiscoVO> getObsFisco() {
    return obsFisco;
  }

  /**
   * # z07 - obsFisco: Grupo Campo de uso livre do Fisco. Ocorrência 0-10.
   *
   * @param obsFisco the new z07 - obsFisco: Grupo Campo de uso livre do Fisco
   */
  public void setObsFisco(List<SEFAZObsFiscoVO> obsFisco) {
    this.obsFisco = obsFisco;
  }

  /**
   * # z10 - procRef: Grupo Processo Referenciado. Ocorrência 0-100.
   *
   * @return the z10 - procRef: Grupo Processo Referenciado
   */
  public List<SEFAZProcRefVO> getProcRef() {
    return procRef;
  }

  /**
   * # z10 - procRef: Grupo Processo Referenciado. Ocorrência 0-100.
   *
   * @param procRef the new z10 - procRef: Grupo Processo Referenciado
   */
  public void setProcRef(List<SEFAZProcRefVO> procRef) {
    this.procRef = procRef;
  }

  /**
   * # z02 - infAdFisco: Informações Adicionais de Interesse do Fisco. Tipo C, tamanho 1-2000, ocorrência 0-1.
   *
   * @return the z02 - infAdFisco: Informações Adicionais de Interesse do Fisco
   */
  public String getInfAdFisco() {
    return infAdFisco;
  }

  /**
   * # z02 - infAdFisco: Informações Adicionais de Interesse do Fisco. Tipo C, tamanho 1-2000, ocorrência 0-1.
   *
   * @param infAdFisco the new z02 - infAdFisco: Informações Adicionais de Interesse do Fisco
   */
  public void setInfAdFisco(String infAdFisco) {
    this.infAdFisco = infAdFisco;
  }

  /**
   * # z03 - infCpl: Informações Complementares de interesse do contribuinte. Tipo C, tamanho 1-5000, ocorrência 0-1.
   *
   * @return the z03 - infCpl: Informações Complementares de interesse do contribuinte
   */
  public String getInfCpl() {
    return infCpl;
  }

  /**
   * # z03 - infCpl: Informações Complementares de interesse do contribuinte. Tipo C, tamanho 1-5000, ocorrência 0-1.
   *
   * @param infCpl the new z03 - infCpl: Informações Complementares de interesse do contribuinte
   */
  public void setInfCpl(String infCpl) {
    this.infCpl = infCpl;
  }

}
