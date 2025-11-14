package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indPag;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tPag;

/**
 * Grupo YA01a - detPag: Detalhamento do Pagamento.
 * <p>
 * Ocorre 1-100 dentro do grupo YA01 (pag).
 * <p>
 * Representa um meio de pagamento (tPag), com valor (vPag) e, opcionalmente, detalhes de cartão (card) quando aplicável.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_detpag")
public class DetPagVO extends RFWVO {

  private static final long serialVersionUID = 5666558123175030448L;

  /**
   * {@link PagVO}
   */
  @RFWMetaRelationshipField(caption = "Pag", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_pag")
  private PagVO pagVO = null;

  /**
   * YA04 - card: Grupo de Cartões. Ocorrência: 0-1.
   * <p>
   * Informado quando o meio de pagamento (tPag) envolver cartão de crédito ou débito.
   */
  @RFWMetaRelationshipField(caption = "Card", relationship = RelationshipTypes.COMPOSITION, required = false, column = "idsefaz_detpag")
  private CardVO card;

  /**
   * YA01b - indPag: Indicador da Forma de Pagamento. Tipo: N, Tamanho: 1, Ocorrência: 0-1 (campo opcional). Valores: 0 = Pagamento à Vista, 1 = Pagamento à Prazo.
   */
  @RFWMetaEnumField(caption = "indPag", required = false)
  private SEFAZ_indPag indPag;

  /**
   * YA02 - tPag: Meio de pagamento. Tipo: N, Tamanho: 2, Ocorrência: 1-1 (obrigatório na estrutura). Ex.: 01=Dinheiro, 03=Cartão de Crédito, 17=PIX, 90=Sem pagamento, etc.
   */
  @RFWMetaEnumField(caption = "tPag", required = false)
  private SEFAZ_tPag tpag;

  /**
   * YA03 - vPag: Valor do Pagamento. Tipo: N, Tamanho: 13v2, Ocorrência: 1-1 (obrigatório na estrutura).
   */
  @RFWMetaBigDecimalField(caption = "vPag", required = false, unique = false, maxValue = "", minValue = "", scale = 2, absolute = false)
  private BigDecimal vpag;

}
