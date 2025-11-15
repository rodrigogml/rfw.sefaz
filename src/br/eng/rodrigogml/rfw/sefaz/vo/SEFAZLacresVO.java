package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Grupo X33 - lacres: Lacres dos volumes.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_lacres")
public class SEFAZLacresVO extends RFWVO {

  private static final long serialVersionUID = 3543883415579643907L;

  /**
   * {@link SEFAZVolVO}
   */
  @RFWMetaRelationshipField(caption = "Vol", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_vol")
  private SEFAZVolVO volVO = null;

  /**
   * X34 - nLacre: Número dos Lacres. Tipo: C, Tamanho: 1-60, Ocorrência: 1-1.
   */
  @RFWMetaStringField(caption = "nLacre", required = false, unique = false, maxLength = 60, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String nlacre;

  /**
   * # {@link SEFAZVolVO}.
   *
   * @return the {@link SEFAZVolVO}
   */
  public SEFAZVolVO getVolVO() {
    return volVO;
  }

  /**
   * # {@link SEFAZVolVO}.
   *
   * @param volVO the new {@link SEFAZVolVO}
   */
  public void setVolVO(SEFAZVolVO volVO) {
    this.volVO = volVO;
  }

  /**
   * # x34 - nLacre: Número dos Lacres. Tipo: C, Tamanho: 1-60, Ocorrência: 1-1.
   *
   * @return the x34 - nLacre: Número dos Lacres
   */
  public String getNlacre() {
    return nlacre;
  }

  /**
   * # x34 - nLacre: Número dos Lacres. Tipo: C, Tamanho: 1-60, Ocorrência: 1-1.
   *
   * @param nlacre the new x34 - nLacre: Número dos Lacres
   */
  public void setNlacre(String nlacre) {
    this.nlacre = nlacre;
  }

}
