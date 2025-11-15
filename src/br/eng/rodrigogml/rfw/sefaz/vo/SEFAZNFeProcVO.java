package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_versao;

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
public class SEFAZNFeProcVO extends RFWVO {

  private static final long serialVersionUID = 1L;

  /**
   * ID: #XR02 | Campo: versao | Ele: A | Pai: XR01 | Tipo: N | Ocor.: 1-1 | Tam.: 1-2v2 <br>
   * Descrição: Define a versão do XML do nfeProc. <br>
   * Mapeamento: Enumeration com as versões suportadas.
   */
  @RFWMetaEnumField(caption = "Versão", required = true)
  private SEFAZ_versao versao;

  /**
   * {@link SEFAZNFeVO}
   */
  @RFWMetaRelationshipField(caption = "NFe", relationship = RelationshipTypes.COMPOSITION, columnMapped = "idsefaz_nfeproc", required = false)
  private SEFAZNFeVO nfeVO = null;

  /**
   * # iD: #XR02 | Campo: versao | Ele: A | Pai: XR01 | Tipo: N | Ocor.: 1-1 | Tam.: 1-2v2 <br>
   * Descrição: Define a versão do XML do nfeProc. <br>
   * Mapeamento: Enumeration com as versões suportadas.
   *
   * @return the iD: #XR02 | Campo: versao | Ele: A | Pai: XR01 | Tipo: N | Ocor
   */
  public SEFAZ_versao getVersao() {
    return versao;
  }

  /**
   * # iD: #XR02 | Campo: versao | Ele: A | Pai: XR01 | Tipo: N | Ocor.: 1-1 | Tam.: 1-2v2 <br>
   * Descrição: Define a versão do XML do nfeProc. <br>
   * Mapeamento: Enumeration com as versões suportadas.
   *
   * @param versao the new iD: #XR02 | Campo: versao | Ele: A | Pai: XR01 | Tipo: N | Ocor
   */
  public void setVersao(SEFAZ_versao versao) {
    this.versao = versao;
  }

  /**
   * # tAG NFe.
   *
   * @return the tAG NFe
   */
  public SEFAZNFeVO getNfeVO() {
    return nfeVO;
  }

  /**
   * # tAG NFe.
   *
   * @param nfeVO the new tAG NFe
   */
  public void setNfeVO(SEFAZNFeVO nfeVO) {
    this.nfeVO = nfeVO;
  }

}
