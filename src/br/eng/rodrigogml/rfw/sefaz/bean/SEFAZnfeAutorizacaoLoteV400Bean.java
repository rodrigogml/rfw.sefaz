/*
 *
 */
package br.eng.rodrigogml.rfw.sefaz.bean;

import java.io.Serializable;

import br.eng.rodrigogml.rfw.sefaz.SEFAZ;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZEnviNFeVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZRetEnviNFeVO;

/**
 * Description: Bean para retorno das informações do método {@link SEFAZ#nfeAutorizacaoLoteV400(br.eng.rodrigogml.rfw.sefaz.vo.SEFAZEnviNFeVO)} .<br>
 *
 * @author Rodrigo Leitão
 * @since (26 de nov. de 2025)
 */
public class SEFAZnfeAutorizacaoLoteV400Bean implements Serializable {

  private static final long serialVersionUID = 5909342659395200788L;

  /**
   * Mesmo objeto recebido na assinatura do método.
   */
  private SEFAZEnviNFeVO enviNFeVO = null;

  /**
   * Objeto montado a partir do XML retornado pela SEFAZ
   */
  private SEFAZRetEnviNFeVO retEnviNFeVO = null;

  /**
   * XML exatamente como transmitido para a SEFAZ, com assinatura, tag raiz 'enviNFe'.
   */
  private String enviNFeXML = null;

  /**
   * XML exatamente como retornado da SEFAZ.
   */
  private String retEnviNFeXML = null;

  /**
   * Quando emitido em processo síncrono o {@link SEFAZ} já monta o xml para distribuição com a tag raiz <nfeProc>.
   */
  private String nfeProcXML = null;

  /**
   * # mesmo objeto recebido na assinatura do método.
   *
   * @return the mesmo objeto recebido na assinatura do método
   */
  public SEFAZEnviNFeVO getEnviNFeVO() {
    return enviNFeVO;
  }

  /**
   * # mesmo objeto recebido na assinatura do método.
   *
   * @param enviNFeVO the new mesmo objeto recebido na assinatura do método
   */
  public void setEnviNFeVO(SEFAZEnviNFeVO enviNFeVO) {
    this.enviNFeVO = enviNFeVO;
  }

  /**
   * # objeto montado a partir do XML retornado pela SEFAZ.
   *
   * @return the objeto montado a partir do XML retornado pela SEFAZ
   */
  public SEFAZRetEnviNFeVO getRetEnviNFeVO() {
    return retEnviNFeVO;
  }

  /**
   * # objeto montado a partir do XML retornado pela SEFAZ.
   *
   * @param retEnviNFeVO the new objeto montado a partir do XML retornado pela SEFAZ
   */
  public void setRetEnviNFeVO(SEFAZRetEnviNFeVO retEnviNFeVO) {
    this.retEnviNFeVO = retEnviNFeVO;
  }

  /**
   * # xML exatamente como transmitido para a SEFAZ, com assinatura, tag raiz 'enviNFe'.
   *
   * @return the xML exatamente como transmitido para a SEFAZ, com assinatura, tag raiz 'enviNFe'
   */
  public String getEnviNFeXML() {
    return enviNFeXML;
  }

  /**
   * # xML exatamente como transmitido para a SEFAZ, com assinatura, tag raiz 'enviNFe'.
   *
   * @param enviNFeXML the new xML exatamente como transmitido para a SEFAZ, com assinatura, tag raiz 'enviNFe'
   */
  public void setEnviNFeXML(String enviNFeXML) {
    this.enviNFeXML = enviNFeXML;
  }

  /**
   * # xML exatamente como retornado da SEFAZ.
   *
   * @return the xML exatamente como retornado da SEFAZ
   */
  public String getRetEnviNFeXML() {
    return retEnviNFeXML;
  }

  /**
   * # xML exatamente como retornado da SEFAZ.
   *
   * @param retEnviNFeXML the new xML exatamente como retornado da SEFAZ
   */
  public void setRetEnviNFeXML(String retEnviNFeXML) {
    this.retEnviNFeXML = retEnviNFeXML;
  }

  /**
   * # quando emitido em processo síncrono o {@link SEFAZ} já monta o xml para distribuição com a tag raiz <nfeProc>.
   *
   * @return the quando emitido em processo síncrono o {@link SEFAZ} já monta o xml para distribuição com a tag raiz <nfeProc>
   */
  public String getNfeProcXML() {
    return nfeProcXML;
  }

  /**
   * # quando emitido em processo síncrono o {@link SEFAZ} já monta o xml para distribuição com a tag raiz <nfeProc>.
   *
   * @param nfeProcXML the new quando emitido em processo síncrono o {@link SEFAZ} já monta o xml para distribuição com a tag raiz <nfeProc>
   */
  public void setNfeProcXML(String nfeProcXML) {
    this.nfeProcXML = nfeProcXML;
  }

}
