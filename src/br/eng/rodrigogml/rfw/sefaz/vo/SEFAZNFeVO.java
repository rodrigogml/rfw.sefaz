package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZEnviNFeVO;

/**
 * Description: Classe que representa a estrutura da tag NFe (TAG raiz da NF-e).<br>
 * Tabela: Campo=NFe | Ele=G | Pai=- | Tipo=- | Ocor.=1-1 | Tam.=- | ObservaÃ§Ã£o=TAG raiz da NF-e.
 *
 * NÃ£o possui atributos diretos nesta tabela; elementos filhos serÃ£o modelados em VOs prÃ³prios.
 *
 * @author Rodrigo LeitÃ£o
 * @since (11 de nov. de 2025)
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_nfe")
public class SEFAZNFeVO extends RFWVO {

  private static final long serialVersionUID = 4806153254587565490L;

  /**
   * {@link SEFAZNFeProcVO}.
   */
  @RFWMetaRelationshipField(caption = "nfeProc", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = false, column = "idsefaz_nfeproc")
  private SEFAZNFeProcVO nfeProcVO = null;

  /**
   * {@link SEFAZEnviNFeVO}.
   */
  @RFWMetaRelationshipField(caption = "enviNFe", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = false, column = "idsefaz_envinfe")
  private SEFAZEnviNFeVO enviNFeVO = null;

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
   * # tAG enviNFe.
   *
   * @return the tAG enviNFe
   */
  public SEFAZEnviNFeVO getEnviNFeVO() {
    return enviNFeVO;
  }

  /**
   * # tAG enviNFe.
   *
   * @param enviNFeVO the new tAG enviNFe
   */
  public void setEnviNFeVO(SEFAZEnviNFeVO enviNFeVO) {
    this.enviNFeVO = enviNFeVO;
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
