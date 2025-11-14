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
public class VolVO extends RFWVO {

  private static final long serialVersionUID = 8872217857806306495L;

  /**
   * {@link TranspVO}
   */
  @RFWMetaRelationshipField(caption = "Transp", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_transp")
  private TranspVO transpVO = null;

  /**
   * {@link LacresVO}
   */
  @RFWMetaRelationshipField(caption = "Lacres", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_lacres", minSize = 0, maxSize = 5000)
  private List<LacresVO> lacresVO = null;

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

}
