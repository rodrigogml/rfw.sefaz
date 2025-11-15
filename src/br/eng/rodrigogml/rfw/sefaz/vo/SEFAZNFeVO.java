package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Description: Classe que representa a estrutura da tag NFe (TAG raiz da NF-e).<br>
 * Tabela: Campo=NFe | Ele=G | Pai=- | Tipo=- | Ocor.=1-1 | Tam.=- | Observação=TAG raiz da NF-e.
 *
 * Não possui atributos diretos nesta tabela; elementos filhos serão modelados em VOs próprios.
 *
 * @author Rodrigo Leitão
 * @since (11 de nov. de 2025)
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_nfe")
public class SEFAZNFeVO extends RFWVO {

  private static final long serialVersionUID = 4806153254587565490L;

  /**
   * {@link SEFAZNFeProcVO}.
   */
  @RFWMetaRelationshipField(caption = "nfeProc", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_nfeproc")
  private SEFAZNFeProcVO nfeProcVO = null;

  /**
   * {@link SEFAZInfNFeVO}
   */
  @RFWMetaRelationshipField(caption = "infNFe", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_nfe")
  private SEFAZInfNFeVO infNFeVO = null;

  /**
   * # tAG nfeProc.
   *
   * @return the tAG nfeProc
   */
  public SEFAZNFeProcVO getNfeProcVO() {
    return nfeProcVO;
  }

  /**
   * # tAG nfeProc.
   *
   * @param nfeProcVO the new tAG nfeProc
   */
  public void setNfeProcVO(SEFAZNFeProcVO nfeProcVO) {
    this.nfeProcVO = nfeProcVO;
  }

  /**
   * # tAG infNFe.
   *
   * @return the tAG infNFe
   */
  public SEFAZInfNFeVO getInfNFeVO() {
    return infNFeVO;
  }

  /**
   * # tAG infNFe.
   *
   * @param infNFeVO the new tAG infNFe
   */
  public void setInfNFeVO(SEFAZInfNFeVO infNFeVO) {
    this.infNFeVO = infNFeVO;
  }

}
