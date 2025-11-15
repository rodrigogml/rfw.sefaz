package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCNPJField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCPFField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringIEField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Grupo X03 - transporta: Transportador.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_transporta")
public class SEFAZTransportaVO extends RFWVO {

  private static final long serialVersionUID = 97092921533698272L;

  /**
   * {@link SEFAZTranspVO}
   */
  @RFWMetaRelationshipField(caption = "Transp", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_transp")
  private SEFAZTranspVO transpVO = null;

  /**
   * X04 - CNPJ: CNPJ do Transportador. Tipo: N, Tamanho: 14, Ocorrência: 0-1. Preencher com zeros não significativos.
   */
  @RFWMetaStringCNPJField(caption = "CNPJ", required = false, unique = false)
  private String cnpj;

  /**
   * X05 - CPF: CPF do Transportador. Tipo: N, Tamanho: 11, Ocorrência: 0-1.
   */
  @RFWMetaStringCPFField(caption = "CPF", required = false, unique = false)
  private String cpf;

  /**
   * X06 - xNome: Razão Social ou nome. Tipo: C, Tamanho: 2-60, Ocorrência: 0-1.
   */
  @RFWMetaStringField(caption = "xNome", required = false, unique = false, maxLength = 60, minLength = 2, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xnome;

  /**
   * X07 - IE: Inscrição Estadual do Transportador. Tipo: C, Tamanho: 2-14, Ocorrência: 0-1. Informar “ISENTO” se isento. A UF deve ser informada se informada uma IE.
   */
  @RFWMetaStringIEField(caption = "IE", required = false, unique = false)
  private String ie;

  /**
   * X08 - xEnder: Endereço completo. Tipo: C, Tamanho: 1-60, Ocorrência: 0-1.
   */
  @RFWMetaStringField(caption = "xEnder", required = false, unique = false, maxLength = 60, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xender;

  /**
   * X09 - xMun: Nome do município. Tipo: C, Tamanho: 1-60, Ocorrência: 0-1.
   */
  @RFWMetaStringField(caption = "xMun", required = false, unique = false, maxLength = 60, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xmun;

  /**
   * X10 - UF: Sigla da UF. Tipo: C, Tamanho: 2, Ocorrência: 0-1. Informar "EX" para exterior.
   */
  @RFWMetaStringField(caption = "UF", required = false, unique = false, maxLength = 2, minLength = 2, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String uf;

  /**
   * # {@link SEFAZTranspVO}.
   *
   * @return the {@link SEFAZTranspVO}
   */
  public SEFAZTranspVO getTranspVO() {
    return transpVO;
  }

  /**
   * # {@link SEFAZTranspVO}.
   *
   * @param transpVO the new {@link SEFAZTranspVO}
   */
  public void setTranspVO(SEFAZTranspVO transpVO) {
    this.transpVO = transpVO;
  }

  /**
   * # x04 - CNPJ: CNPJ do Transportador. Tipo: N, Tamanho: 14, Ocorrência: 0-1. Preencher com zeros não significativos.
   *
   * @return the x04 - CNPJ: CNPJ do Transportador
   */
  public String getCnpj() {
    return cnpj;
  }

  /**
   * # x04 - CNPJ: CNPJ do Transportador. Tipo: N, Tamanho: 14, Ocorrência: 0-1. Preencher com zeros não significativos.
   *
   * @param cnpj the new x04 - CNPJ: CNPJ do Transportador
   */
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  /**
   * # x05 - CPF: CPF do Transportador. Tipo: N, Tamanho: 11, Ocorrência: 0-1.
   *
   * @return the x05 - CPF: CPF do Transportador
   */
  public String getCpf() {
    return cpf;
  }

  /**
   * # x05 - CPF: CPF do Transportador. Tipo: N, Tamanho: 11, Ocorrência: 0-1.
   *
   * @param cpf the new x05 - CPF: CPF do Transportador
   */
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  /**
   * # x06 - xNome: Razão Social ou nome. Tipo: C, Tamanho: 2-60, Ocorrência: 0-1.
   *
   * @return the x06 - xNome: Razão Social ou nome
   */
  public String getXnome() {
    return xnome;
  }

  /**
   * # x06 - xNome: Razão Social ou nome. Tipo: C, Tamanho: 2-60, Ocorrência: 0-1.
   *
   * @param xnome the new x06 - xNome: Razão Social ou nome
   */
  public void setXnome(String xnome) {
    this.xnome = xnome;
  }

  /**
   * # x07 - IE: Inscrição Estadual do Transportador. Tipo: C, Tamanho: 2-14, Ocorrência: 0-1. Informar “ISENTO” se isento. A UF deve ser informada se informada uma IE.
   *
   * @return the x07 - IE: Inscrição Estadual do Transportador
   */
  public String getIe() {
    return ie;
  }

  /**
   * # x07 - IE: Inscrição Estadual do Transportador. Tipo: C, Tamanho: 2-14, Ocorrência: 0-1. Informar “ISENTO” se isento. A UF deve ser informada se informada uma IE.
   *
   * @param ie the new x07 - IE: Inscrição Estadual do Transportador
   */
  public void setIe(String ie) {
    this.ie = ie;
  }

  /**
   * # x08 - xEnder: Endereço completo. Tipo: C, Tamanho: 1-60, Ocorrência: 0-1.
   *
   * @return the x08 - xEnder: Endereço completo
   */
  public String getXender() {
    return xender;
  }

  /**
   * # x08 - xEnder: Endereço completo. Tipo: C, Tamanho: 1-60, Ocorrência: 0-1.
   *
   * @param xender the new x08 - xEnder: Endereço completo
   */
  public void setXender(String xender) {
    this.xender = xender;
  }

  /**
   * # x09 - xMun: Nome do município. Tipo: C, Tamanho: 1-60, Ocorrência: 0-1.
   *
   * @return the x09 - xMun: Nome do município
   */
  public String getXmun() {
    return xmun;
  }

  /**
   * # x09 - xMun: Nome do município. Tipo: C, Tamanho: 1-60, Ocorrência: 0-1.
   *
   * @param xmun the new x09 - xMun: Nome do município
   */
  public void setXmun(String xmun) {
    this.xmun = xmun;
  }

  /**
   * # x10 - UF: Sigla da UF. Tipo: C, Tamanho: 2, Ocorrência: 0-1. Informar "EX" para exterior.
   *
   * @return the x10 - UF: Sigla da UF
   */
  public String getUf() {
    return uf;
  }

  /**
   * # x10 - UF: Sigla da UF. Tipo: C, Tamanho: 2, Ocorrência: 0-1. Informar "EX" para exterior.
   *
   * @param uf the new x10 - UF: Sigla da UF
   */
  public void setUf(String uf) {
    this.uf = uf;
  }
}
