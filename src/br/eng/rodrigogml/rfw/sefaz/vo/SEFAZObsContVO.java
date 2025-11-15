package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Z04 - obsCont: Grupo Campo de uso livre do contribuinte. Ocorrência: 0-10.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_obscont")
public class SEFAZObsContVO extends RFWVO {

  private static final long serialVersionUID = -1540925517446947564L;

  /**
   * {@link SEFAZInfAdicVO}
   */
  @RFWMetaRelationshipField(caption = "InfAdic", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_infadic")
  private SEFAZInfAdicVO infAdicVO = null;

  /**
   * Z05 - xCampo: Identificação do campo. Tipo C, tamanho 1-20, ocorrência 1-1.
   */
  @RFWMetaStringField(caption = "xCampo", required = false, unique = false, maxLength = 20, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xcampo;

  /**
   * Z06 - xTexto: Conteúdo do campo. Tipo C, tamanho 1-60, ocorrência 1-1.
   */
  @RFWMetaStringField(caption = "xTexto", required = false, unique = false, maxLength = 60, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xtexto;

  /**
   * # {@link SEFAZInfAdicVO}.
   *
   * @return the {@link SEFAZInfAdicVO}
   */
  public SEFAZInfAdicVO getInfAdicVO() {
    return infAdicVO;
  }

  /**
   * # {@link SEFAZInfAdicVO}.
   *
   * @param infAdicVO the new {@link SEFAZInfAdicVO}
   */
  public void setInfAdicVO(SEFAZInfAdicVO infAdicVO) {
    this.infAdicVO = infAdicVO;
  }

  /**
   * # z05 - xCampo: Identificação do campo. Tipo C, tamanho 1-20, ocorrência 1-1.
   *
   * @return the z05 - xCampo: Identificação do campo
   */
  public String getXcampo() {
    return xcampo;
  }

  /**
   * # z05 - xCampo: Identificação do campo. Tipo C, tamanho 1-20, ocorrência 1-1.
   *
   * @param xcampo the new z05 - xCampo: Identificação do campo
   */
  public void setXcampo(String xcampo) {
    this.xcampo = xcampo;
  }

  /**
   * # z06 - xTexto: Conteúdo do campo. Tipo C, tamanho 1-60, ocorrência 1-1.
   *
   * @return the z06 - xTexto: Conteúdo do campo
   */
  public String getXtexto() {
    return xtexto;
  }

  /**
   * # z06 - xTexto: Conteúdo do campo. Tipo C, tamanho 1-60, ocorrência 1-1.
   *
   * @param xtexto the new z06 - xTexto: Conteúdo do campo
   */
  public void setXtexto(String xtexto) {
    this.xtexto = xtexto;
  }
}
