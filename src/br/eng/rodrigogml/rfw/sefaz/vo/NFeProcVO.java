package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Description: Classe que representa a estrutura da tag nfeProc (TAG raiz do processo da NF-e). Contém a NFe assinada e o protocolo de autorização/denegação. <br>
 * Tabela de referência (SEFAZ):
 * <ul>
 * <li>#XR01 | Campo: nfeProc | Ele: Raiz | Pai: - | Tipo: - | Ocor.: - | Tam.: - | Descrição: TAG raiz</li>
 * <li>#XR02 | Campo: versao | Ele: A | Pai: XR01 | Tipo: N | Ocor.: 1-1 | Tam.: 1-2v2</li>
 * <li>#XR03 | Campo: NFe | Ele: G | Pai: XR01 | Ocor.: 1-1 | Descrição: Dados da NF-e, inclusive com a assinatura</li>
 * <li>#XR05 | Campo: protNfe | Ele: G | Pai: XR01 | Ocor.: 1-1 | Descrição: Protocolo de autorização/denegação (item 5.2.2)</li>
 * </ul>
 * Observação: elementos filhos (NFe, protNfe) serão modelados em VOs próprios.
 *
 * @author Rodrigo Leitão
 * @since (11 de nov. de 2025)
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_nfeproc")
public class NFeProcVO extends RFWVO {

  private static final long serialVersionUID = 1L;

  /**
   * ID: #XR02 | Campo: versao | Ele: A | Pai: XR01 | Tipo: N | Ocor.: 1-1 | Tam.: 1-2v2 <br>
   * Descrição: Define a versão do XML do nfeProc. <br>
   * Mapeamento: numérico com 2 casas decimais; intervalo 0 a 99,99 (não negativo).
   */
  @RFWMetaBigDecimalField(caption = "Versão", minValue = "0", maxValue = "99.99", scale = 2, absolute = true, required = true)
  private BigDecimal versao;

  /**
   * TAG NFe
   */
  @RFWMetaRelationshipField(caption = "NFe", relationship = RelationshipTypes.COMPOSITION, columnMapped = "idsefaz_nfeproc", required = true)
  private NFeVO nfeVO = null;

  /**
   * # iD: #XR02 | Campo: versao | Ele: A | Pai: XR01 | Tipo: N | Ocor.: 1-1 | Tam.: 1-2v2 <br>
   * Descrição: Define a versão do XML do nfeProc. <br>
   * Mapeamento: numérico com 2 casas decimais; intervalo 0 a 99,99 (não negativo).
   *
   * @return the iD: #XR02 | Campo: versao | Ele: A | Pai: XR01 | Tipo: N | Ocor
   */
  public BigDecimal getVersao() {
    return versao;
  }

  /**
   * # iD: #XR02 | Campo: versao | Ele: A | Pai: XR01 | Tipo: N | Ocor.: 1-1 | Tam.: 1-2v2 <br>
   * Descrição: Define a versão do XML do nfeProc. <br>
   * Mapeamento: numérico com 2 casas decimais; intervalo 0 a 99,99 (não negativo).
   *
   * @param versao the new iD: #XR02 | Campo: versao | Ele: A | Pai: XR01 | Tipo: N | Ocor
   */
  public void setVersao(BigDecimal versao) {
    this.versao = versao;
  }

  /**
   * # tAG NFe.
   *
   * @return the tAG NFe
   */
  public NFeVO getNfeVO() {
    return nfeVO;
  }

  /**
   * # tAG NFe.
   *
   * @param nfeVO the new tAG NFe
   */
  public void setNfeVO(NFeVO nfeVO) {
    this.nfeVO = nfeVO;
  }

}
