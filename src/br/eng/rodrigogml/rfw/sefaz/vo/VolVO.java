package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Grupo de informações de volumes transportados (TAG {@code vol}, ID X26).<br>
 * Representa os volumes físicos (caixas, paletes, etc.) vinculados ao transporte da NF-e.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_vol")
class VolVO extends RFWVO {

  private static final long serialVersionUID = -7912083453262433411L;

  /**
   * ID: X27 – Campo {@code qVol}.<br>
   * Quantidade de volumes transportados (caixas, pacotes, etc.).<br>
   * Ocorrência 0-1, tamanho numérico 1-15, sem casas decimais.
   */
  @RFWMetaBigDecimalField(caption = "Quantidade de volumes", required = false, scale = 0, absolute = true)
  private BigDecimal qVol = null;

  /**
   * ID: X28 – Campo {@code esp}.<br>
   * Espécie dos volumes (ex.: CX, PAC, PAL, etc.).<br>
   * Ocorrência 0-1, tamanho 1-60 caracteres.
   */
  @RFWMetaStringField(caption = "Espécie dos volumes", required = false, maxLength = 60)
  private String esp = null;

  /**
   * ID: X29 – Campo {@code marca}.<br>
   * Marca dos volumes transportados (identificação textual impressa nas embalagens).<br>
   * Ocorrência 0-1, tamanho 1-60 caracteres.
   */
  @RFWMetaStringField(caption = "Marca dos volumes", required = false, maxLength = 60)
  private String marca = null;

  /**
   * ID: X30 – Campo {@code nVol}.<br>
   * Numeração dos volumes (faixa ou códigos de identificação física).<br>
   * Ocorrência 0-1, tamanho 1-60 caracteres.
   */
  @RFWMetaStringField(caption = "Numeração dos volumes", required = false, maxLength = 60)
  private String nVol = null;

  /**
   * ID: X31 – Campo {@code pesoL}.<br>
   * Peso líquido total dos volumes transportados, em quilogramas (kg).<br>
   * Ocorrência 0-1, tamanho 11v3.
   */
  @RFWMetaBigDecimalField(caption = "Peso líquido (kg)", required = false, scale = 3, absolute = true)
  private BigDecimal pesoL = null;

  /**
   * ID: X32 – Campo {@code pesoB}.<br>
   * Peso bruto total dos volumes transportados, em quilogramas (kg).<br>
   * Ocorrência 0-1, tamanho 11v3.
   */
  @RFWMetaBigDecimalField(caption = "Peso bruto (kg)", required = false, scale = 3, absolute = true)
  private BigDecimal pesoB = null;

  /**
   * # iD: X27 – Campo {@code qVol}.<br>
   * Quantidade de volumes transportados (caixas, pacotes, etc.).<br>
   * Ocorrência 0-1, tamanho numérico 1-15, sem casas decimais.
   *
   * @return the iD: X27 – Campo {@code qVol}
   */
  public BigDecimal getQVol() {
    return qVol;
  }

  /**
   * # iD: X27 – Campo {@code qVol}.<br>
   * Quantidade de volumes transportados (caixas, pacotes, etc.).<br>
   * Ocorrência 0-1, tamanho numérico 1-15, sem casas decimais.
   *
   * @param qVol the new iD: X27 – Campo {@code qVol}
   */
  public void setQVol(BigDecimal qVol) {
    this.qVol = qVol;
  }

  /**
   * # iD: X28 – Campo {@code esp}.<br>
   * Espécie dos volumes (ex.: CX, PAC, PAL, etc.).<br>
   * Ocorrência 0-1, tamanho 1-60 caracteres.
   *
   * @return the iD: X28 – Campo {@code esp}
   */
  public String getEsp() {
    return esp;
  }

  /**
   * # iD: X28 – Campo {@code esp}.<br>
   * Espécie dos volumes (ex.: CX, PAC, PAL, etc.).<br>
   * Ocorrência 0-1, tamanho 1-60 caracteres.
   *
   * @param esp the new iD: X28 – Campo {@code esp}
   */
  public void setEsp(String esp) {
    this.esp = esp;
  }

  /**
   * # iD: X29 – Campo {@code marca}.<br>
   * Marca dos volumes transportados (identificação textual impressa nas embalagens).<br>
   * Ocorrência 0-1, tamanho 1-60 caracteres.
   *
   * @return the iD: X29 – Campo {@code marca}
   */
  public String getMarca() {
    return marca;
  }

  /**
   * # iD: X29 – Campo {@code marca}.<br>
   * Marca dos volumes transportados (identificação textual impressa nas embalagens).<br>
   * Ocorrência 0-1, tamanho 1-60 caracteres.
   *
   * @param marca the new iD: X29 – Campo {@code marca}
   */
  public void setMarca(String marca) {
    this.marca = marca;
  }

  /**
   * # iD: X30 – Campo {@code nVol}.<br>
   * Numeração dos volumes (faixa ou códigos de identificação física).<br>
   * Ocorrência 0-1, tamanho 1-60 caracteres.
   *
   * @return the iD: X30 – Campo {@code nVol}
   */
  public String getNVol() {
    return nVol;
  }

  /**
   * # iD: X30 – Campo {@code nVol}.<br>
   * Numeração dos volumes (faixa ou códigos de identificação física).<br>
   * Ocorrência 0-1, tamanho 1-60 caracteres.
   *
   * @param nVol the new iD: X30 – Campo {@code nVol}
   */
  public void setNVol(String nVol) {
    this.nVol = nVol;
  }

  /**
   * # iD: X31 – Campo {@code pesoL}.<br>
   * Peso líquido total dos volumes transportados, em quilogramas (kg).<br>
   * Ocorrência 0-1, tamanho 11v3.
   *
   * @return the iD: X31 – Campo {@code pesoL}
   */
  public BigDecimal getPesoL() {
    return pesoL;
  }

  /**
   * # iD: X31 – Campo {@code pesoL}.<br>
   * Peso líquido total dos volumes transportados, em quilogramas (kg).<br>
   * Ocorrência 0-1, tamanho 11v3.
   *
   * @param pesoL the new iD: X31 – Campo {@code pesoL}
   */
  public void setPesoL(BigDecimal pesoL) {
    this.pesoL = pesoL;
  }

  /**
   * # iD: X32 – Campo {@code pesoB}.<br>
   * Peso bruto total dos volumes transportados, em quilogramas (kg).<br>
   * Ocorrência 0-1, tamanho 11v3.
   *
   * @return the iD: X32 – Campo {@code pesoB}
   */
  public BigDecimal getPesoB() {
    return pesoB;
  }

  /**
   * # iD: X32 – Campo {@code pesoB}.<br>
   * Peso bruto total dos volumes transportados, em quilogramas (kg).<br>
   * Ocorrência 0-1, tamanho 11v3.
   *
   * @param pesoB the new iD: X32 – Campo {@code pesoB}
   */
  public void setPesoB(BigDecimal pesoB) {
    this.pesoB = pesoB;
  }

}