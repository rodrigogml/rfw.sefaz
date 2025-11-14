package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;

/**
 * Dados do transportador da NF-e (TAG {@code transporta}, ID X03).<br>
 * Grupo filho de {@code transp} (X01) contendo a identificação básica do transportador responsável pelo frete.
 *
 * <p>
 * É utilizado tanto para operações em que há transportador externo quanto para transporte próprio por conta do destinatário ou remetente, conforme definido em {@code modFrete}.
 * </p>
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_transporta")
public class TransportaVO extends RFWVO {

  private static final long serialVersionUID = 8598842812365473201L;

  /**
   * ID: X04 – Campo {@code CNPJ}.<br>
   * CNPJ do transportador, quando pessoa jurídica.<br>
   * Preenchido com 14 dígitos numéricos, incluindo zeros não significativos. Ocorrência 0-1 (alternativo ao CPF {@link #cpf}).
   */
  @RFWMetaStringField(caption = "CNPJ do transportador", required = false, maxLength = 14)
  private String cnpj = null;

  /**
   * ID: X05 – Campo {@code CPF}.<br>
   * CPF do transportador, quando pessoa física.<br>
   * Preenchido com 11 dígitos numéricos, incluindo zeros não significativos. Ocorrência 0-1 (alternativo ao CNPJ {@link #cnpj}).
   */
  @RFWMetaStringField(caption = "CPF do transportador", required = false, maxLength = 11)
  private String cpf = null;

  /**
   * ID: X06 – Campo {@code xNome}.<br>
   * Razão social ou nome do transportador informado na NF-e.<br>
   * Ocorrência 0-1, tamanho de 2 a 60 caracteres.
   */
  @RFWMetaStringField(caption = "Nome do transportador", required = false, maxLength = 60)
  private String xNome = null;

  /**
   * ID: X07 – Campo {@code IE}.<br>
   * Inscrição Estadual do transportador contribuinte de ICMS, sem caracteres de formatação.<br>
   * Ocorrência 0-1, tamanho de 2 a 14 caracteres.
   */
  @RFWMetaStringField(caption = "Inscrição estadual", required = false, maxLength = 14)
  private String ie = null;

  /**
   * ID: X08 – Campo {@code xEnder}.<br>
   * Endereço completo (logradouro e complemento) do transportador.<br>
   * Ocorrência 0-1, tamanho de 2 a 60 caracteres.
   */
  @RFWMetaStringField(caption = "Endereço do transportador", required = false, maxLength = 60)
  private String xEnder = null;

  /**
   * ID: X09 – Campo {@code xMun}.<br>
   * Nome do município do transportador.<br>
   * Ocorrência 0-1, tamanho de 2 a 60 caracteres.
   */
  @RFWMetaStringField(caption = "Município do transportador", required = false, maxLength = 60)
  private String xMun = null;

  /**
   * ID: X10 – Campo {@code UF}.<br>
   * Sigla da Unidade da Federação do transportador.<br>
   * Ocorrência 0-1, tamanho 2 (tabela de UF do IBGE).
   */
  @RFWMetaStringField(caption = "UF do transportador", required = false, maxLength = 2)
  private String uf = null;

  /**
   * # iD: X04 – Campo {@code CNPJ}.<br>
   * CNPJ do transportador, quando pessoa jurídica.<br>
   * Preenchido com 14 dígitos numéricos, incluindo zeros não significativos. Ocorrência 0-1 (alternativo ao CPF {@link #cpf}).
   *
   * @return the iD: X04 – Campo {@code CNPJ}
   */
  public String getCnpj() {
    return cnpj;
  }

  /**
   * # iD: X04 – Campo {@code CNPJ}.<br>
   * CNPJ do transportador, quando pessoa jurídica.<br>
   * Preenchido com 14 dígitos numéricos, incluindo zeros não significativos. Ocorrência 0-1 (alternativo ao CPF {@link #cpf}).
   *
   * @param cnpj the new iD: X04 – Campo {@code CNPJ}
   */
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  /**
   * # iD: X05 – Campo {@code CPF}.<br>
   * CPF do transportador, quando pessoa física.<br>
   * Preenchido com 11 dígitos numéricos, incluindo zeros não significativos. Ocorrência 0-1 (alternativo ao CNPJ {@link #cnpj}).
   *
   * @return the iD: X05 – Campo {@code CPF}
   */
  public String getCpf() {
    return cpf;
  }

  /**
   * # iD: X05 – Campo {@code CPF}.<br>
   * CPF do transportador, quando pessoa física.<br>
   * Preenchido com 11 dígitos numéricos, incluindo zeros não significativos. Ocorrência 0-1 (alternativo ao CNPJ {@link #cnpj}).
   *
   * @param cpf the new iD: X05 – Campo {@code CPF}
   */
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  /**
   * # iD: X06 – Campo {@code xNome}.<br>
   * Razão social ou nome do transportador informado na NF-e.<br>
   * Ocorrência 0-1, tamanho de 2 a 60 caracteres.
   *
   * @return the iD: X06 – Campo {@code xNome}
   */
  public String getXNome() {
    return xNome;
  }

  /**
   * # iD: X06 – Campo {@code xNome}.<br>
   * Razão social ou nome do transportador informado na NF-e.<br>
   * Ocorrência 0-1, tamanho de 2 a 60 caracteres.
   *
   * @param xNome the new iD: X06 – Campo {@code xNome}
   */
  public void setXNome(String xNome) {
    this.xNome = xNome;
  }

  /**
   * # iD: X07 – Campo {@code IE}.<br>
   * Inscrição Estadual do transportador contribuinte de ICMS, sem caracteres de formatação.<br>
   * Ocorrência 0-1, tamanho de 2 a 14 caracteres.
   *
   * @return the iD: X07 – Campo {@code IE}
   */
  public String getIe() {
    return ie;
  }

  /**
   * # iD: X07 – Campo {@code IE}.<br>
   * Inscrição Estadual do transportador contribuinte de ICMS, sem caracteres de formatação.<br>
   * Ocorrência 0-1, tamanho de 2 a 14 caracteres.
   *
   * @param ie the new iD: X07 – Campo {@code IE}
   */
  public void setIe(String ie) {
    this.ie = ie;
  }

  /**
   * # iD: X08 – Campo {@code xEnder}.<br>
   * Endereço completo (logradouro e complemento) do transportador.<br>
   * Ocorrência 0-1, tamanho de 2 a 60 caracteres.
   *
   * @return the iD: X08 – Campo {@code xEnder}
   */
  public String getXEnder() {
    return xEnder;
  }

  /**
   * # iD: X08 – Campo {@code xEnder}.<br>
   * Endereço completo (logradouro e complemento) do transportador.<br>
   * Ocorrência 0-1, tamanho de 2 a 60 caracteres.
   *
   * @param xEnder the new iD: X08 – Campo {@code xEnder}
   */
  public void setXEnder(String xEnder) {
    this.xEnder = xEnder;
  }

  /**
   * # iD: X09 – Campo {@code xMun}.<br>
   * Nome do município do transportador.<br>
   * Ocorrência 0-1, tamanho de 2 a 60 caracteres.
   *
   * @return the iD: X09 – Campo {@code xMun}
   */
  public String getXMun() {
    return xMun;
  }

  /**
   * # iD: X09 – Campo {@code xMun}.<br>
   * Nome do município do transportador.<br>
   * Ocorrência 0-1, tamanho de 2 a 60 caracteres.
   *
   * @param xMun the new iD: X09 – Campo {@code xMun}
   */
  public void setXMun(String xMun) {
    this.xMun = xMun;
  }

  /**
   * # iD: X10 – Campo {@code UF}.<br>
   * Sigla da Unidade da Federação do transportador.<br>
   * Ocorrência 0-1, tamanho 2 (tabela de UF do IBGE).
   *
   * @return the iD: X10 – Campo {@code UF}
   */
  public String getUf() {
    return uf;
  }

  /**
   * # iD: X10 – Campo {@code UF}.<br>
   * Sigla da Unidade da Federação do transportador.<br>
   * Ocorrência 0-1, tamanho 2 (tabela de UF do IBGE).
   *
   * @param uf the new iD: X10 – Campo {@code UF}
   */
  public void setUf(String uf) {
    this.uf = uf;
  }

}