package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Dados de reboque do transporte (TAG {@code reboque}, ID X22).<br>
 * Grupo repetível para identificação de veículos reboque ligados ao veículo principal no transporte da NF-e.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_reboque")
class ReboqueVO extends RFWVO {

  private static final long serialVersionUID = 7405187342578914352L;

  /**
   * ID: X23 – Campo {@code placa}.<br>
   * Placa do veículo reboque, no formato previsto na legislação de trânsito.<br>
   * Ocorrência 0-1, tamanho 7.
   */
  @RFWMetaStringField(caption = "Placa do reboque", required = false, maxLength = 7)
  private String placa = null;

  /**
   * ID: X24 – Campo {@code UF}.<br>
   * Sigla da UF de licenciamento do reboque.<br>
   * Ocorrência 0-1, tamanho 2, podendo ser "EX" para exterior.
   */
  @RFWMetaStringField(caption = "UF do reboque", required = false, maxLength = 2)
  private String uf = null;

  /**
   * ID: X25 – Campo {@code RNTC}.<br>
   * Registro Nacional de Transportador de Carga (ANTT) do veículo reboque, quando exigido.<br>
   * Ocorrência 0-1, tamanho 20.
   */
  @RFWMetaStringField(caption = "RNTC (ANTT) reboque", required = false, maxLength = 20)
  private String rntc = null;

  /**
   * # iD: X23 – Campo {@code placa}.<br>
   * Placa do veículo reboque, no formato previsto na legislação de trânsito.<br>
   * Ocorrência 0-1, tamanho 7.
   *
   * @return the iD: X23 – Campo {@code placa}
   */
  public String getPlaca() {
    return placa;
  }

  /**
   * # iD: X23 – Campo {@code placa}.<br>
   * Placa do veículo reboque, no formato previsto na legislação de trânsito.<br>
   * Ocorrência 0-1, tamanho 7.
   *
   * @param placa the new iD: X23 – Campo {@code placa}
   */
  public void setPlaca(String placa) {
    this.placa = placa;
  }

  /**
   * # iD: X24 – Campo {@code UF}.<br>
   * Sigla da UF de licenciamento do reboque.<br>
   * Ocorrência 0-1, tamanho 2, podendo ser "EX" para exterior.
   *
   * @return the iD: X24 – Campo {@code UF}
   */
  public String getUf() {
    return uf;
  }

  /**
   * # iD: X24 – Campo {@code UF}.<br>
   * Sigla da UF de licenciamento do reboque.<br>
   * Ocorrência 0-1, tamanho 2, podendo ser "EX" para exterior.
   *
   * @param uf the new iD: X24 – Campo {@code UF}
   */
  public void setUf(String uf) {
    this.uf = uf;
  }

  /**
   * # iD: X25 – Campo {@code RNTC}.<br>
   * Registro Nacional de Transportador de Carga (ANTT) do veículo reboque, quando exigido.<br>
   * Ocorrência 0-1, tamanho 20.
   *
   * @return the iD: X25 – Campo {@code RNTC}
   */
  public String getRntc() {
    return rntc;
  }

  /**
   * # iD: X25 – Campo {@code RNTC}.<br>
   * Registro Nacional de Transportador de Carga (ANTT) do veículo reboque, quando exigido.<br>
   * Ocorrência 0-1, tamanho 20.
   *
   * @param rntc the new iD: X25 – Campo {@code RNTC}
   */
  public void setRntc(String rntc) {
    this.rntc = rntc;
  }

}