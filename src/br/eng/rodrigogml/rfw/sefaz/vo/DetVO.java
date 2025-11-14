package br.eng.rodrigogml.rfw.sefaz.vo;

import java.io.Serializable;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaIntegerField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Grupo H - Detalhamento de Produtos e Serviços (tag det / H01). Detalhamento de Produtos e Serviços da NF-e. Múltiplas ocorrências (1–990) para cada NF-e.
 *
 * Observação: a obrigatoriedade dos campos segue o MOC, mas nas annotations o atributo {@code required} é sempre definido como false conforme solicitado.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_det")
public class DetVO extends RFWVO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * {@link InfNFeVO}
   */
  @RFWMetaRelationshipField(caption = "InfNFe", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_infnfe")
  private InfNFeVO infNFeVO = null;

  /**
   * {@link ProdVO}
   */
  @RFWMetaRelationshipField(caption = "Prod", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_det")
  private ProdVO prodVO = null;

  /**
   * {@link ImpostoVO}
   */
  @RFWMetaRelationshipField(caption = "Imposto", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_det")
  private ImpostoVO impostoVO = null;

  /**
   * H02 - nItem. Número do item na NF-e. Contador sequencial do item (1–990). Ocor.: 1–1 / Tam.: 1–3 / Tipo: N.
   */
  @RFWMetaIntegerField(caption = "Número do item", required = false, unique = false, minValue = 1, maxValue = 990)
  private Integer nitem;

  /**
   * # h02 - nItem. Número do item na NF-e. Contador sequencial do item (1–990). Ocor.: 1–1 / Tam.: 1–3 / Tipo: N.
   *
   * @return the h02 - nItem
   */
  public Integer getNitem() {
    return nitem;
  }

  /**
   * # h02 - nItem. Número do item na NF-e. Contador sequencial do item (1–990). Ocor.: 1–1 / Tam.: 1–3 / Tipo: N.
   *
   * @param nitem the new h02 - nItem
   */
  public void setNitem(Integer nitem) {
    this.nitem = nitem;
  }

  /**
   * # {@link ImpostoVO}.
   *
   * @return the {@link ImpostoVO}
   */
  public ImpostoVO getImpostoVO() {
    return impostoVO;
  }

  /**
   * # {@link ImpostoVO}.
   *
   * @param impostoVO the new {@link ImpostoVO}
   */
  public void setImpostoVO(ImpostoVO impostoVO) {
    this.impostoVO = impostoVO;
  }

}
