package br.eng.rodrigogml.rfw.sefaz.vos;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaIntegerField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "NFref" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class RefECFVO extends RFWVO {

  private static final long serialVersionUID = 813216150002840351L;

  /**
   * BA07 mod Modelo do Documento Fiscal E BA03 N 1-1 2
   * <li>01=modelo 01
   * <li>02=modelo 02 (incluído na NT2016.002)
   */
  @RFWMetaStringField(caption = "Modelo do Documento Fiscal", minlength = 2, maxLength = 2, required = true, pattern = "^(01|02)$")
  private String mod = null;

  /**
   * BA22 nECF Número de ordem sequencial do ECF E BA20 N 1-1 3<br>
   * Informar o número de ordem sequencial do ECF que emitiu o Cupom Fiscal vinculado à NF-e (v2.0)
   */
  @RFWMetaIntegerField(caption = "Número do ECF", minvalue = 1, maxvalue = 999, required = true)
  private Integer necf = null;

  /**
   * BA23 nCOO Número do Contador de Ordem de Operação - COO E BA20 N 1-1 6<br>
   * Informar o Número do Contador de Ordem de Operação - COO vinculado à NF-e (v2.0).
   */
  @RFWMetaIntegerField(caption = "Número do COO do Cupom", minvalue = 1, maxvalue = 999999, required = true)
  private Integer ncoo = null;

  /**
   * # bA07 mod Modelo do Documento Fiscal E BA03 N 1-1 2
   * <li>01=modelo 01
   * <li>02=modelo 02 (incluído na NT2016.002).
   *
   * @return # bA07 mod Modelo do Documento Fiscal E BA03 N 1-1 2
   *         <li>01=modelo 01
   *         <li>02=modelo 02 (incluído na NT2016
   */
  public String getMod() {
    return mod;
  }

  /**
   * # bA07 mod Modelo do Documento Fiscal E BA03 N 1-1 2
   * <li>01=modelo 01
   * <li>02=modelo 02 (incluído na NT2016.002).
   *
   * @param mod # bA07 mod Modelo do Documento Fiscal E BA03 N 1-1 2
   *          <li>01=modelo 01
   *          <li>02=modelo 02 (incluído na NT2016
   */
  public void setMod(String mod) {
    this.mod = mod;
  }

  /**
   * # bA22 nECF Número de ordem sequencial do ECF E BA20 N 1-1 3<br>
   * Informar o número de ordem sequencial do ECF que emitiu o Cupom Fiscal vinculado à NF-e (v2.0).
   *
   * @return # bA22 nECF Número de ordem sequencial do ECF E BA20 N 1-1 3<br>
   *         Informar o número de ordem sequencial do ECF que emitiu o Cupom Fiscal vinculado à NF-e (v2
   */
  public Integer getNecf() {
    return necf;
  }

  /**
   * # bA22 nECF Número de ordem sequencial do ECF E BA20 N 1-1 3<br>
   * Informar o número de ordem sequencial do ECF que emitiu o Cupom Fiscal vinculado à NF-e (v2.0).
   *
   * @param necf # bA22 nECF Número de ordem sequencial do ECF E BA20 N 1-1 3<br>
   *          Informar o número de ordem sequencial do ECF que emitiu o Cupom Fiscal vinculado à NF-e (v2
   */
  public void setNecf(Integer necf) {
    this.necf = necf;
  }

  /**
   * # bA23 nCOO Número do Contador de Ordem de Operação - COO E BA20 N 1-1 6<br>
   * Informar o Número do Contador de Ordem de Operação - COO vinculado à NF-e (v2.0).
   *
   * @return # bA23 nCOO Número do Contador de Ordem de Operação - COO E BA20 N 1-1 6<br>
   *         Informar o Número do Contador de Ordem de Operação - COO vinculado à NF-e (v2
   */
  public Integer getNcoo() {
    return ncoo;
  }

  /**
   * # bA23 nCOO Número do Contador de Ordem de Operação - COO E BA20 N 1-1 6<br>
   * Informar o Número do Contador de Ordem de Operação - COO vinculado à NF-e (v2.0).
   *
   * @param ncoo # bA23 nCOO Número do Contador de Ordem de Operação - COO E BA20 N 1-1 6<br>
   *          Informar o Número do Contador de Ordem de Operação - COO vinculado à NF-e (v2
   */
  public void setNcoo(Integer ncoo) {
    this.ncoo = ncoo;
  }
}
