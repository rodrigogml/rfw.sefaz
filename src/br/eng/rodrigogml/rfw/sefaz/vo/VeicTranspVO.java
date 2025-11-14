package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Informação do veículo de transporte (TAG {@code veicTransp}, ID X18).<br>
 * Grupo utilizado para identificação do veículo transportador principal (veículo trator) da NF-e.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_veic_transp")
class VeicTranspVO extends RFWVO {

  private static final long serialVersionUID = -6698407146508327413L;

  /**
   * ID: X19 – Campo {@code placa}.<br>
   * Placa do veículo de transporte, no formato exigido pela legislação de trânsito.<br>
   * Ocorrência 0-1, tamanho 7 (complementações podem ser informadas nas observações da NF-e quando necessário).
   */
  @RFWMetaStringField(caption = "Placa do veículo", required = false, maxLength = 7)
  private String placa = null;

  /**
   * ID: X20 – Campo {@code UF}.<br>
   * Sigla da UF onde o veículo está licenciado.<br>
   * Ocorrência 0-1, tamanho 2 (tabela de UF). Deve ser preenchida com "EX" para exterior.
   */
  @RFWMetaStringField(caption = "UF do veículo", required = false, maxLength = 2)
  private String uf = null;

  /**
   * ID: X21 – Campo {@code RNTC}.<br>
   * Registro Nacional de Transportador de Carga (ANTT) do veículo trator.<br>
   * Ocorrência 0-1, tamanho 20.
   */
  @RFWMetaStringField(caption = "RNTC (ANTT) veículo", required = false, maxLength = 20)
  private String rntc = null;

  /**
   * # iD: X19 – Campo {@code placa}.<br>
   * Placa do veículo de transporte, no formato exigido pela legislação de trânsito.<br>
   * Ocorrência 0-1, tamanho 7 (complementações podem ser informadas nas observações da NF-e quando necessário).
   *
   * @return the iD: X19 – Campo {@code placa}
   */
  public String getPlaca() {
    return placa;
  }

  /**
   * # iD: X19 – Campo {@code placa}.<br>
   * Placa do veículo de transporte, no formato exigido pela legislação de trânsito.<br>
   * Ocorrência 0-1, tamanho 7 (complementações podem ser informadas nas observações da NF-e quando necessário).
   *
   * @param placa the new iD: X19 – Campo {@code placa}
   */
  public void setPlaca(String placa) {
    this.placa = placa;
  }

  /**
   * # iD: X20 – Campo {@code UF}.<br>
   * Sigla da UF onde o veículo está licenciado.<br>
   * Ocorrência 0-1, tamanho 2 (tabela de UF). Deve ser preenchida com "EX" para exterior.
   *
   * @return the iD: X20 – Campo {@code UF}
   */
  public String getUf() {
    return uf;
  }

  /**
   * # iD: X20 – Campo {@code UF}.<br>
   * Sigla da UF onde o veículo está licenciado.<br>
   * Ocorrência 0-1, tamanho 2 (tabela de UF). Deve ser preenchida com "EX" para exterior.
   *
   * @param uf the new iD: X20 – Campo {@code UF}
   */
  public void setUf(String uf) {
    this.uf = uf;
  }

  /**
   * # iD: X21 – Campo {@code RNTC}.<br>
   * Registro Nacional de Transportador de Carga (ANTT) do veículo trator.<br>
   * Ocorrência 0-1, tamanho 20.
   *
   * @return the iD: X21 – Campo {@code RNTC}
   */
  public String getRntc() {
    return rntc;
  }

  /**
   * # iD: X21 – Campo {@code RNTC}.<br>
   * Registro Nacional de Transportador de Carga (ANTT) do veículo trator.<br>
   * Ocorrência 0-1, tamanho 20.
   *
   * @param rntc the new iD: X21 – Campo {@code RNTC}
   */
  public void setRntc(String rntc) {
    this.rntc = rntc;
  }

}