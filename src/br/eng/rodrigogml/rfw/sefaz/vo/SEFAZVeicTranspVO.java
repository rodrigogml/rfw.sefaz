package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Grupo X18 - veicTransp: Veículo de Transporte (veículo trator).
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_veictransp")
public class SEFAZVeicTranspVO extends RFWVO {

  private static final long serialVersionUID = -1958540280138152475L;

  /**
   * {@link SEFAZTranspVO}
   */
  @RFWMetaRelationshipField(caption = "Transp", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_transp")
  private SEFAZTranspVO transpVO = null;

  /**
   * X19 - placa: Placa do Veículo. Tipo: C, Tamanho: 7, Ocorrência: 1-1.
   */
  @RFWMetaStringField(caption = "placa", required = false, unique = false, maxLength = 7, minLength = 7, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String placa;

  /**
   * X20 - UF: Sigla da UF. Tipo: C, Tamanho: 2, Ocorrência: 1-1. Informar "EX" se exterior.
   */
  @RFWMetaStringField(caption = "UF", required = false, unique = false, maxLength = 2, minLength = 2, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String uf;

  /**
   * X21 - RNTC: Registro Nacional de Transportador de Carga (ANTT). Tipo: C, Tamanho: 1-20, Ocorrência: 0-1.
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
   * # x19 - placa: Placa do Veículo. Tipo: C, Tamanho: 7, Ocorrência: 1-1.
   *
   * @return the x19 - placa: Placa do Veículo
   */
  public String getPlaca() {
    return placa;
  }

  /**
   * # x19 - placa: Placa do Veículo. Tipo: C, Tamanho: 7, Ocorrência: 1-1.
   *
   * @param placa the new x19 - placa: Placa do Veículo
   */
  public void setPlaca(String placa) {
    this.placa = placa;
  }

  /**
   * # x20 - UF: Sigla da UF. Tipo: C, Tamanho: 2, Ocorrência: 1-1. Informar "EX" se exterior.
   *
   * @return the x20 - UF: Sigla da UF
   */
  public String getUf() {
    return uf;
  }

  /**
   * # x20 - UF: Sigla da UF. Tipo: C, Tamanho: 2, Ocorrência: 1-1. Informar "EX" se exterior.
   *
   * @param uf the new x20 - UF: Sigla da UF
   */
  public void setUf(String uf) {
    this.uf = uf;
  }

  /**
   * # x21 - RNTC: Registro Nacional de Transportador de Carga (ANTT). Tipo: C, Tamanho: 1-20, Ocorrência: 0-1.
   *
   * @return the x21 - RNTC: Registro Nacional de Transportador de Carga (ANTT)
   */
  public String getRntc() {
    return rntc;
  }

  /**
   * # x21 - RNTC: Registro Nacional de Transportador de Carga (ANTT). Tipo: C, Tamanho: 1-20, Ocorrência: 0-1.
   *
   * @param rntc the new x21 - RNTC: Registro Nacional de Transportador de Carga (ANTT)
   */
  public void setRntc(String rntc) {
    this.rntc = rntc;
  }
}
