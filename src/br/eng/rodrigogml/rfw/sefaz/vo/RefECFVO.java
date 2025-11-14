package br.eng.rodrigogml.rfw.sefaz.vo;

import java.io.Serializable;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_mod;

/**
 * VO para o grupo BA20 (refECF) – Informações do Cupom Fiscal referenciado. Utilizado para vincular à NF-e um Cupom Fiscal emitido por equipamento ECF/PDV ou máquina registradora.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_refecf")
public class RefECFVO extends RFWVO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * {@link NFRefVO}
   */
  @RFWMetaRelationshipField(caption = "NFRef", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_nfref")
  private NFRefVO nfRefVO = null;

  /**
   * BA21 - Modelo do Documento Fiscal. Valores possíveis: "2B" = Cupom Fiscal emitido por máquina registradora (não ECF) "2C" = Cupom Fiscal PDV "2D" = Cupom Fiscal emitido por ECF. Ocorrência: 1-1 (campo condicional).
   */
  @RFWMetaEnumField(caption = "Modelo do Documento Fiscal (01 ou 02)", required = false)
  private SEFAZ_mod mod;

  /**
   * BA22 - Número de ordem sequencial do ECF. Identifica o equipamento que emitiu o Cupom Fiscal vinculado à NF-e. Tamanho 3 caracteres numéricos. Ocorrência: 1-1.
   */
  @RFWMetaStringField(caption = "Número de ordem sequencial do ECF", required = true, unique = false, maxLength = 3, minLength = 3, pattern = "", preProcess = { PreProcessOption.NONE })
  private String necf;

  /**
   * BA23 - Número do Contador de Ordem de Operação (COO). Número do COO do Cupom Fiscal vinculado à NF-e. Tamanho 6 caracteres numéricos. Ocorrência: 1-1.
   */
  @RFWMetaStringField(caption = "Número do Contador de Ordem de Operação (COO)", required = true, unique = false, maxLength = 6, minLength = 6, pattern = "", preProcess = { PreProcessOption.NONE })
  private String ncoo;

  /**
   * # {@link NFRefVO}.
   *
   * @return the {@link NFRefVO}
   */
  public NFRefVO getNfRefVO() {
    return nfRefVO;
  }

  /**
   * # {@link NFRefVO}.
   *
   * @param nfRefVO the new {@link NFRefVO}
   */
  public void setNfRefVO(NFRefVO nfRefVO) {
    this.nfRefVO = nfRefVO;
  }

  /**
   * # bA21 - Modelo do Documento Fiscal. Valores possíveis: "2B" = Cupom Fiscal emitido por máquina registradora (não ECF) "2C" = Cupom Fiscal PDV "2D" = Cupom Fiscal emitido por ECF. Ocorrência: 1-1 (campo condicional).
   *
   * @return the bA21 - Modelo do Documento Fiscal
   */
  public SEFAZ_mod getMod() {
    return mod;
  }

  /**
   * # bA21 - Modelo do Documento Fiscal. Valores possíveis: "2B" = Cupom Fiscal emitido por máquina registradora (não ECF) "2C" = Cupom Fiscal PDV "2D" = Cupom Fiscal emitido por ECF. Ocorrência: 1-1 (campo condicional).
   *
   * @param mod the new bA21 - Modelo do Documento Fiscal
   */
  public void setMod(SEFAZ_mod mod) {
    this.mod = mod;
  }

  /**
   * # bA22 - Número de ordem sequencial do ECF. Identifica o equipamento que emitiu o Cupom Fiscal vinculado à NF-e. Tamanho 3 caracteres numéricos. Ocorrência: 1-1.
   *
   * @return the bA22 - Número de ordem sequencial do ECF
   */
  public String getNecf() {
    return necf;
  }

  /**
   * # bA22 - Número de ordem sequencial do ECF. Identifica o equipamento que emitiu o Cupom Fiscal vinculado à NF-e. Tamanho 3 caracteres numéricos. Ocorrência: 1-1.
   *
   * @param necf the new bA22 - Número de ordem sequencial do ECF
   */
  public void setNecf(String necf) {
    this.necf = necf;
  }

  /**
   * # bA23 - Número do Contador de Ordem de Operação (COO). Número do COO do Cupom Fiscal vinculado à NF-e. Tamanho 6 caracteres numéricos. Ocorrência: 1-1.
   *
   * @return the bA23 - Número do Contador de Ordem de Operação (COO)
   */
  public String getNcoo() {
    return ncoo;
  }

  /**
   * # bA23 - Número do Contador de Ordem de Operação (COO). Número do COO do Cupom Fiscal vinculado à NF-e. Tamanho 6 caracteres numéricos. Ocorrência: 1-1.
   *
   * @param ncoo the new bA23 - Número do Contador de Ordem de Operação (COO)
   */
  public void setNcoo(String ncoo) {
    this.ncoo = ncoo;
  }
}
