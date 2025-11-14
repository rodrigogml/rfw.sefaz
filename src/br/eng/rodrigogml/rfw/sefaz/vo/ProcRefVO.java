package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indProc;

/**
 * Z10 - procRef: Grupo Processo Referenciado. Ocorrência: 0-100.
 * <p>
 * Contém:
 * </p>
 * <ul>
 * <li>Z11 - nProc: Identificador do processo ou ato concessório;</li>
 * <li>Z12 - indProc: Indicador da origem do processo (enum SEFAZ_indProc).</li>
 * </ul>
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_procref")
public class ProcRefVO extends RFWVO {

  private static final long serialVersionUID = -7440798937076304978L;

  /**
   * {@link InfAdicVO}
   */
  @RFWMetaRelationshipField(caption = "InfAdic", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_infadic")
  private InfAdicVO infAdicVO = null;

  /**
   * Z11 - nProc: Identificador do processo ou ato concessório. Tipo C, tamanho 1-60, ocorrência 1-1.
   */
  @RFWMetaStringField(caption = "nProc", required = false, unique = false, maxLength = 60, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String nproc;

  /**
   * Z12 - indProc: Indicador da origem do processo. Tipo N, tamanho 1, ocorrência 1-1. Valores: 0 = SEFAZ, 1 = Justiça Federal, 2 = Justiça Estadual, 3 = Secex/RFB, 9 = Outros.
   */
  @RFWMetaEnumField(caption = "indProc", required = false)
  private SEFAZ_indProc indProc;

  /**
   * # {@link InfAdicVO}.
   *
   * @return the {@link InfAdicVO}
   */
  public InfAdicVO getInfAdicVO() {
    return infAdicVO;
  }

  /**
   * # {@link InfAdicVO}.
   *
   * @param infAdicVO the new {@link InfAdicVO}
   */
  public void setInfAdicVO(InfAdicVO infAdicVO) {
    this.infAdicVO = infAdicVO;
  }

  /**
   * # z11 - nProc: Identificador do processo ou ato concessório. Tipo C, tamanho 1-60, ocorrência 1-1.
   *
   * @return the z11 - nProc: Identificador do processo ou ato concessório
   */
  public String getNproc() {
    return nproc;
  }

  /**
   * # z11 - nProc: Identificador do processo ou ato concessório. Tipo C, tamanho 1-60, ocorrência 1-1.
   *
   * @param nproc the new z11 - nProc: Identificador do processo ou ato concessório
   */
  public void setNproc(String nproc) {
    this.nproc = nproc;
  }

  /**
   * # z12 - indProc: Indicador da origem do processo. Tipo N, tamanho 1, ocorrência 1-1. Valores: 0 = SEFAZ, 1 = Justiça Federal, 2 = Justiça Estadual, 3 = Secex/RFB, 9 = Outros.
   *
   * @return the z12 - indProc: Indicador da origem do processo
   */
  public SEFAZ_indProc getIndProc() {
    return indProc;
  }

  /**
   * # z12 - indProc: Indicador da origem do processo. Tipo N, tamanho 1, ocorrência 1-1. Valores: 0 = SEFAZ, 1 = Justiça Federal, 2 = Justiça Estadual, 3 = Secex/RFB, 9 = Outros.
   *
   * @param indProc the new z12 - indProc: Indicador da origem do processo
   */
  public void setIndProc(SEFAZ_indProc indProc) {
    this.indProc = indProc;
  }

}
