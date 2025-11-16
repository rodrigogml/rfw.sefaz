package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;
import java.util.List;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Grupo X26 - vol: Volumes.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_vol")
public class SEFAZVolVO extends RFWVO {

  private static final long serialVersionUID = 8872217857806306495L;

  /**
   * {@link SEFAZTranspVO}
   */
  @RFWMetaRelationshipField(caption = "Transp", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_transp")
  private SEFAZTranspVO transpVO = null;

  /**
   * {@link SEFAZLacresVO}
   */
  @RFWMetaRelationshipField(caption = "Lacres", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_lacres", minSize = 0, maxSize = 5000)
  private List<SEFAZLacresVO> lacresVO = null;

  /**
   * X27 - qVol: Quantidade de volumes transportados. Tipo: N, Tamanho: 1-15, Ocorrência: 0-1.
   */
  @RFWMetaBigDecimalField(caption = "qVol", required = false, unique = false, maxValue = "", minValue = "", scale = 0, absolute = false)
  private BigDecimal qvol;

  /**
   * X28 - esp: Espécie dos volumes transportados. Tipo: C, Tamanho: 1-60, Ocorrência: 0-1.
   */
  @RFWMetaStringField(caption = "esp", required = false, unique = false, maxLength = 60, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String esp;

  /**
   * X29 - marca: Marca dos volumes transportados. Tipo: C, Tamanho: 1-60, Ocorrência: 0-1.
   */
  @RFWMetaStringField(caption = "marca", required = false, unique = false, maxLength = 60, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String marca;

  /**
   * X30 - nVol: Numeração dos volumes transportados. Tipo: C, Tamanho: 1-60, Ocorrência: 0-1.
   */
  @RFWMetaStringField(caption = "nVol", required = false, unique = false, maxLength = 60, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String nvol;

  /**
   * X31 - pesoL: Peso Líquido (em kg). Tipo: N, Tamanho: 12v3, Ocorrência: 0-1.
   */
  @RFWMetaBigDecimalField(caption = "pesoL", required = false, unique = false, maxValue = "", minValue = "", scale = 3, absolute = false)
  private BigDecimal pesoL;

  /**
   * X32 - pesoB: Peso Bruto (em kg). Tipo: N, Tamanho: 12v3, Ocorrência: 0-1.
   */
  @RFWMetaBigDecimalField(caption = "pesoB", required = false, unique = false, maxValue = "", minValue = "", scale = 3, absolute = false)
  private BigDecimal pesoB;

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
   * # {@link SEFAZLacresVO}.
   *
   * @return the {@link SEFAZLacresVO}
   */
  public List<SEFAZLacresVO> getLacresVO() {
    return lacresVO;
  }

  /**
   * # {@link SEFAZLacresVO}.
   *
   * @param lacresVO the new {@link SEFAZLacresVO}
   */
  public void setLacresVO(List<SEFAZLacresVO> lacresVO) {
    this.lacresVO = lacresVO;
  }

  /**
   * # x27 - qVol: Quantidade de volumes transportados. Tipo: N, Tamanho: 1-15, Ocorrência: 0-1.
   *
   * @return the x27 - qVol: Quantidade de volumes transportados
   */
  public BigDecimal getQvol() {
    return qvol;
  }

  /**
   * # x27 - qVol: Quantidade de volumes transportados. Tipo: N, Tamanho: 1-15, Ocorrência: 0-1.
   *
   * @param qvol the new x27 - qVol: Quantidade de volumes transportados
   */
  public void setQvol(BigDecimal qvol) {
    this.qvol = qvol;
  }

  /**
   * # x28 - esp: Espécie dos volumes transportados. Tipo: C, Tamanho: 1-60, Ocorrência: 0-1.
   *
   * @return the x28 - esp: Espécie dos volumes transportados
   */
  public String getEsp() {
    return esp;
  }

  /**
   * # x28 - esp: Espécie dos volumes transportados. Tipo: C, Tamanho: 1-60, Ocorrência: 0-1.
   *
   * @param esp the new x28 - esp: Espécie dos volumes transportados
   */
  public void setEsp(String esp) {
    this.esp = esp;
  }

  /**
   * # x29 - marca: Marca dos volumes transportados. Tipo: C, Tamanho: 1-60, Ocorrência: 0-1.
   *
   * @return the x29 - marca: Marca dos volumes transportados
   */
  public String getMarca() {
    return marca;
  }

  /**
   * # x29 - marca: Marca dos volumes transportados. Tipo: C, Tamanho: 1-60, Ocorrência: 0-1.
   *
   * @param marca the new x29 - marca: Marca dos volumes transportados
   */
  public void setMarca(String marca) {
    this.marca = marca;
  }

  /**
   * # x30 - nVol: Numeração dos volumes transportados. Tipo: C, Tamanho: 1-60, Ocorrência: 0-1.
   *
   * @return the x30 - nVol: Numeração dos volumes transportados
   */
  public String getNvol() {
    return nvol;
  }

  /**
   * # x30 - nVol: Numeração dos volumes transportados. Tipo: C, Tamanho: 1-60, Ocorrência: 0-1.
   *
   * @param nvol the new x30 - nVol: Numeração dos volumes transportados
   */
  public void setNvol(String nvol) {
    this.nvol = nvol;
  }

  /**
   * # x31 - pesoL: Peso Líquido (em kg). Tipo: N, Tamanho: 12v3, Ocorrência: 0-1.
   *
   * @return the x31 - pesoL: Peso Líquido (em kg)
   */
  public BigDecimal getPesoL() {
    return pesoL;
  }

  /**
   * # x31 - pesoL: Peso Líquido (em kg). Tipo: N, Tamanho: 12v3, Ocorrência: 0-1.
   *
   * @param pesoL the new x31 - pesoL: Peso Líquido (em kg)
   */
  public void setPesoL(BigDecimal pesoL) {
    this.pesoL = pesoL;
  }

  /**
   * # x32 - pesoB: Peso Bruto (em kg). Tipo: N, Tamanho: 12v3, Ocorrência: 0-1.
   *
   * @return the x32 - pesoB: Peso Bruto (em kg)
   */
  public BigDecimal getPesoB() {
    return pesoB;
  }

  /**
   * # x32 - pesoB: Peso Bruto (em kg). Tipo: N, Tamanho: 12v3, Ocorrência: 0-1.
   *
   * @param pesoB the new x32 - pesoB: Peso Bruto (em kg)
   */
  public void setPesoB(BigDecimal pesoB) {
    this.pesoB = pesoB;
  }

}
