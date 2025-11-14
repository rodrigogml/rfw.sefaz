package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Grupo de lacres dos volumes transportados (TAG {@code lacres}, ID X33).<br>
 * Cada ocorrência representa um lacre físico aplicado ao volume de carga.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_lacres")
public class LacresVO extends RFWVO {

  private static final long serialVersionUID = -4940798871506592073L;

  /**
   * ID: X34 – Campo {@code nLacre}.<br>
   * Número identificador do lacre afixado no volume de transporte.<br>
   * Ocorrência 1-1 em cada grupo de lacres, tamanho 1-60 caracteres.
   */
  @RFWMetaStringField(caption = "Número do lacre", required = false, maxLength = 60)
  private String nLacre = null;

  /**
   * # iD: X34 – Campo {@code nLacre}.<br>
   * Número identificador do lacre afixado no volume de transporte.<br>
   * Ocorrência 1-1 em cada grupo de lacres, tamanho 1-60 caracteres.
   *
   * @return the iD: X34 – Campo {@code nLacre}
   */
  public String getNLacre() {
    return nLacre;
  }

  /**
   * # iD: X34 – Campo {@code nLacre}.<br>
   * Número identificador do lacre afixado no volume de transporte.<br>
   * Ocorrência 1-1 em cada grupo de lacres, tamanho 1-60 caracteres.
   *
   * @param nLacre the new iD: X34 – Campo {@code nLacre}
   */
  public void setNLacre(String nLacre) {
    this.nLacre = nLacre;
  }

}