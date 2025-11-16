package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Grupo X22 - reboque: Reboque/Dolly.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_reboque")
public class SEFAZReboqueVO extends RFWVO {

  private static final long serialVersionUID = -1278985381808176642L;

  /**
   * {@link SEFAZTranspVO}
   */
  @RFWMetaRelationshipField(caption = "Transp", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_transp")
  private SEFAZTranspVO transpVO = null;

  /**
   * X23 - placa: Placa do Veículo. Tipo: C, Tamanho: 7, Ocorrência: 1-1.
   */
  @RFWMetaStringField(caption = "placa", required = false, unique = false, maxLength = 7, minLength = 7, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String placa;

  /**
   * X24 - UF: Sigla da UF. Tipo: C, Tamanho: 2, Ocorrência: 1-1. Informar "EX" se exterior.
   */
  @RFWMetaStringField(caption = "UF", required = false, unique = false, maxLength = 2, minLength = 2, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String uf;

  /**
   * X25 - RNTC: Registro Nacional do Transportador de Carga (ANTT). Tipo: C, Tamanho: 1-20, Ocorrência: 0-1.
   */
  @RFWMetaStringField(caption = "RNTC", required = false, unique = false, maxLength = 20, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String rntc;

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

  /**
   * # x23 - placa: Placa do Veículo. Tipo: C, Tamanho: 7, Ocorrência: 1-1.
   *
   * @return the x23 - placa: Placa do Veículo
   */
  public String getPlaca() {
    return placa;
  }

  /**
   * # x23 - placa: Placa do Veículo. Tipo: C, Tamanho: 7, Ocorrência: 1-1.
   *
   * @param placa the new x23 - placa: Placa do Veículo
   */
  public void setPlaca(String placa) {
    this.placa = placa;
  }

  /**
   * # x24 - UF: Sigla da UF. Tipo: C, Tamanho: 2, Ocorrência: 1-1. Informar "EX" se exterior.
   *
   * @return the x24 - UF: Sigla da UF
   */
  public String getUf() {
    return uf;
  }

  /**
   * # x24 - UF: Sigla da UF. Tipo: C, Tamanho: 2, Ocorrência: 1-1. Informar "EX" se exterior.
   *
   * @param uf the new x24 - UF: Sigla da UF
   */
  public void setUf(String uf) {
    this.uf = uf;
  }

  /**
   * # x25 - RNTC: Registro Nacional do Transportador de Carga (ANTT). Tipo: C, Tamanho: 1-20, Ocorrência: 0-1.
   *
   * @return the x25 - RNTC: Registro Nacional do Transportador de Carga (ANTT)
   */
  public String getRntc() {
    return rntc;
  }

  /**
   * # x25 - RNTC: Registro Nacional do Transportador de Carga (ANTT). Tipo: C, Tamanho: 1-20, Ocorrência: 0-1.
   *
   * @param rntc the new x25 - RNTC: Registro Nacional do Transportador de Carga (ANTT)
   */
  public void setRntc(String rntc) {
    this.rntc = rntc;
  }
}
