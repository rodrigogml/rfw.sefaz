package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * IS - Informações do Imposto Seletivo.
 * <p>
 * Grupo de informações relativas ao Imposto Seletivo incidente no item da NF-e, conforme definido pela SEFAZ.
 *
 * @author Rodrigo Leitão
 * @since (13 de dez. de 2025)
 */
public class SEFAZISVO extends RFWVO {

  private static final long serialVersionUID = 2379888772464161042L;

  /**
   * {@link SEFAZImpostoVO}
   */
  @RFWMetaRelationshipField(caption = "Imposto", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_imposto")
  private SEFAZImpostoVO impostoVO = null;

  /**
   * CSTIS - Código de Situação Tributária do Imposto Seletivo.
   * <p>
   * Código que identifica a situação tributária do Imposto Seletivo, conforme tabela CST do Imposto Seletivo.
   */
  @RFWMetaStringField(caption = "CST do Imposto Seletivo", required = false, maxLength = 3, pattern = "^[0-9]{3}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cstis;

  /**
   * cClassTribIS - Código de Classificação Tributária do Imposto Seletivo.
   * <p>
   * Código utilizado para classificar a tributação do Imposto Seletivo, conforme tabela cClassTribIS.
   */
  @RFWMetaStringField(caption = "Classificação Tributária do Imposto Seletivo", required = false, maxLength = 6, pattern = "^[0-9]{6}$", preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cclassTribIs;

  /**
   * vBCIS - Valor da Base de Cálculo do Imposto Seletivo.
   */
  @RFWMetaBigDecimalField(caption = "Base de Cálculo do Imposto Seletivo", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vbcis;

  /**
   * pIS - Alíquota do Imposto Seletivo em percentual.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota do Imposto Seletivo", required = true, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pis;

  /**
   * pISEspec - Alíquota específica do Imposto Seletivo por unidade de medida apropriada.
   * <p>
   * Campo opcional.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota Específica do Imposto Seletivo", required = false, scale = 2, scaleMax = 4, absolute = true)
  private BigDecimal pisEspec;

  /**
   * uTrib - Unidade de Medida Tributável.
   */
  @RFWMetaStringField(caption = "Unidade de Medida Tributável", required = true, maxLength = 6, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String utrib;

  /**
   * qTrib - Quantidade Tributável.
   */
  @RFWMetaBigDecimalField(caption = "Quantidade Tributável", required = true, scale = 0, scaleMax = 4, absolute = true)
  private BigDecimal qtrib;

  /**
   * vIS - Valor do Imposto Seletivo.
   */
  @RFWMetaBigDecimalField(caption = "Valor do Imposto Seletivo", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vis;
}
