package br.eng.rodrigogml.rfw.sefaz.vo;

import java.io.Serializable;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaIntegerField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Grupo H - Detalhamento de Produtos e Serviços (tag det / H01). Detalhamento de Produtos e Serviços da NF-e. Múltiplas ocorrências (1–990) para cada NF-e.
 *
 * Observação: a obrigatoriedade dos campos segue o MOC, mas nas annotations o atributo {@code required} é sempre definido como false conforme solicitado.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_det")
public class SEFAZDetVO extends RFWVO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * {@link SEFAZInfNFeVO}
   */
  @RFWMetaRelationshipField(caption = "InfNFe", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_infnfe")
  private SEFAZInfNFeVO infNFeVO = null;

  /**
   * {@link SEFAZProdVO}
   */
  @RFWMetaRelationshipField(caption = "Prod", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_det")
  private SEFAZProdVO prodVO = null;

  /**
   * {@link SEFAZImpostoVO}
   */
  @RFWMetaRelationshipField(caption = "Imposto", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_det")
  private SEFAZImpostoVO impostoVO = null;

  /**
   * H02 - nItem. Número do item na NF-e. Contador sequencial do item (1–990). Ocor.: 1–1 / Tam.: 1–3 / Tipo: N.
   */
  @RFWMetaIntegerField(caption = "Número do item", required = false, unique = false, minValue = 1, maxValue = 990)
  private Integer nitem;

  /**
   * V01 infAdProd Informações Adicionais do Produto E H01 C 0-1 1-500 Norma referenciada, informações complementares, etc.
   */
  @RFWMetaStringField(caption = "Informação Adicional Produto", required = false, minLength = 1, maxLength = 500, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String infAdProd = null;

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
   * # {@link SEFAZImpostoVO}.
   *
   * @return the {@link SEFAZImpostoVO}
   */
  public SEFAZImpostoVO getImpostoVO() {
    return impostoVO;
  }

  /**
   * # {@link SEFAZImpostoVO}.
   *
   * @param impostoVO the new {@link SEFAZImpostoVO}
   */
  public void setImpostoVO(SEFAZImpostoVO impostoVO) {
    this.impostoVO = impostoVO;
  }

  /**
   * # {@link SEFAZInfNFeVO}.
   *
   * @return the {@link SEFAZInfNFeVO}
   */
  public SEFAZInfNFeVO getInfNFeVO() {
    return infNFeVO;
  }

  /**
   * # {@link SEFAZInfNFeVO}.
   *
   * @param infNFeVO the new {@link SEFAZInfNFeVO}
   */
  public void setInfNFeVO(SEFAZInfNFeVO infNFeVO) {
    this.infNFeVO = infNFeVO;
  }

  /**
   * # {@link SEFAZProdVO}.
   *
   * @return the {@link SEFAZProdVO}
   */
  public SEFAZProdVO getProdVO() {
    return prodVO;
  }

  /**
   * # {@link SEFAZProdVO}.
   *
   * @param prodVO the new {@link SEFAZProdVO}
   */
  public void setProdVO(SEFAZProdVO prodVO) {
    this.prodVO = prodVO;
  }

  /**
   * # v01 infAdProd Informações Adicionais do Produto E H01 C 0-1 1-500 Norma referenciada, informações complementares, etc.
   *
   * @return the v01 infAdProd Informações Adicionais do Produto E H01 C 0-1 1-500 Norma referenciada, informações complementares, etc
   */
  public String getInfAdProd() {
    return infAdProd;
  }

  /**
   * # v01 infAdProd Informações Adicionais do Produto E H01 C 0-1 1-500 Norma referenciada, informações complementares, etc.
   *
   * @param infAdProd the new v01 infAdProd Informações Adicionais do Produto E H01 C 0-1 1-500 Norma referenciada, informações complementares, etc
   */
  public void setInfAdProd(String infAdProd) {
    this.infAdProd = infAdProd;
  }

}
