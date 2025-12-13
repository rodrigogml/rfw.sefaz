package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * gIBSCBSMono - Grupo de Informações do IBS e CBS em operações com imposto monofásico.
 * <p>
 * A obrigatoriedade ou vedação do preenchimento deste grupo está condicionada ao indicador "ind_gIBSCBSMono" da tabela de CST do IBS e da CBS.
 */
public class SEFAZGIBSCBSMonoVO extends RFWVO {

  private static final long serialVersionUID = 7426608084673934333L;

  /**
   * {@link SEFAZGIBSCBSVO}
   */
  @RFWMetaRelationshipField(caption = "IBSCBS", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true)
  private SEFAZGIBSCBSVO gibsCBSVO = null;

  /**
   * gMonoPadrao - Grupo de informações da Tributação Monofásica Padrão.
   */
  private SEFAZGMonoPadraoVO gmonoPadrao;

  /**
   * gMonoReten - Grupo de informações da Tributação Monofásica Sujeita à Retenção.
   */
  private SEFAZGMonoRetenVO gmonoReten;

  /**
   * gMonoRet - Grupo de informações da Tributação Monofásica Retida Anteriormente.
   */
  private SEFAZGMonoRetVO gmonoRet;

  /**
   * gMonoDif - Grupo de informações do Diferimento da Tributação Monofásica.
   */
  private SEFAZGMonoDifVO gmonoDif;

  /**
   * vTotIBSMonoItem - Total do IBS Monofásico do item.
   */
  @RFWMetaBigDecimalField(caption = "Total do IBS Monofásico", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vtotIbsMonoItem;

  /**
   * vTotCBSMonoItem - Total da CBS Monofásica do item.
   */
  @RFWMetaBigDecimalField(caption = "Total da CBS Monofásica", required = true, scale = 2, scaleMax = 2, absolute = true)
  private BigDecimal vtotCbsMonoItem;

}
