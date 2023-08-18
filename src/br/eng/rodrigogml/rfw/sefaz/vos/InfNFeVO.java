package br.eng.rodrigogml.rfw.sefaz.vos;

import java.util.List;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "infNFe" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integra��o com o framework, pertindo a valida��o e at� a persist�ncia se o sistema assim desejar. N�o h� preocupa��o de gerar JavaDOC nestas classes pois ela deve representar exatamente a documenta��o da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Valida��o da NF-e.
 */
public class InfNFeVO extends RFWVO {

  private static final long serialVersionUID = 5158903694543076637L;

  /**
   * A02 versao Vers�o do leiaute A A01 C 1-1 1 - 4 Vers�o do leiaute (4.00)
   */
  @RFWMetaStringField(caption = "Vers�o do Leiaute", maxLength = 4, minlength = 1, required = true)
  private String versao = null;

  /**
   * A03 Id Identificador da TAG a ser assinada ID A01 C 1-1 47 Informar a Chave de Acesso precedida do literal �NFe�,<Br>
   * <b>Note que este atributo no XML � "id", mas foi chamado de idAttribute para evitar o conflito com o ID herdado de {@link RFWVO}
   */
  @RFWMetaStringField(caption = "Id", maxLength = 47, minlength = 47, required = true, pattern = "NFe[0-9]{44}")
  private String idAttribute = null;

  /**
   * B01 ide Informa��es de identifica��o da NF-e G A01 1-1
   */
  @RFWMetaRelationshipField(caption = "Informa��es de Identifica��o da NFe", required = true, relationship = RelationshipTypes.COMPOSITION)
  private IdeVO ide = null;

  /**
   * C01 emit Identifica��o do emitente da NF-e G A01 1-1
   */
  @RFWMetaRelationshipField(caption = "Identifica��o do Emitente da NFe", required = true, relationship = RelationshipTypes.COMPOSITION)
  private EmitVO emit = null;

  /**
   * E01 dest Identifica��o do Destinat�rio da NF-e G A01 0-1<br>
   * Grupo Obrig.at�rio para a NF-e (modelo 55).
   */
  @RFWMetaRelationshipField(caption = "Identifica��o do Destinat�rio da NFe", required = false, relationship = RelationshipTypes.COMPOSITION)
  private DestVO dest = null;

  /**
   * H01 det Detalhamento de Produtos e Servi�os G A01 1-990<br>
   * M�ltiplas ocorr�ncias (m�ximo = 990)
   */
  @RFWMetaRelationshipField(caption = "Detalhamento de Produtos e Servi�os", minSize = 1, required = true, relationship = RelationshipTypes.COMPOSITION)
  public List<DetVO> det = null;

  /**
   * W01 total Grupo Totais da NF-e G A01 1-1<br>
   * O grupo de valores totais da NF-e deve ser informado com o somat�rio do campo correspondente dos itens.
   */
  @RFWMetaRelationshipField(caption = "Grupo de Totais da NFe", required = true, relationship = RelationshipTypes.COMPOSITION)
  private TotalVO total = null;

  /**
   * X01 transp Grupo Informa��es do Transporte G A01 1-1
   */
  @RFWMetaRelationshipField(caption = "Grupo de Informa��es de Transporte", required = true, relationship = RelationshipTypes.COMPOSITION)
  private TranspVO transp = null;

  /**
   * Y01 cobr Grupo Cobran�a G A01 0-1
   */
  @RFWMetaRelationshipField(caption = "Grupo Cobran�a", required = false, relationship = RelationshipTypes.COMPOSITION)
  private CobrVO cobr = null;

  /**
   * YA01 pag Grupo de Informa��es de Pagamento G A01 1-1<br>
   * Obrig.at�rio o preenchimento do Grupo Informa��es de Pagamento para NF-e e NFC-e. Para as notas com finalidade de Ajuste ou Devolu��o o campo Meio de Pagamento deve ser preenchido com
   * <li>90=Sem Pagamento.
   */
  @RFWMetaRelationshipField(caption = "Grupo Informa��es de Pagamento", required = true, relationship = RelationshipTypes.COMPOSITION)
  private PagVO pag = null;

  /**
   * Z01 infAdic Grupo de Informa��es Adicionais G A01 0-1
   */
  @RFWMetaRelationshipField(caption = "Grupo Informa��es Adicionais", required = false, relationship = RelationshipTypes.COMPOSITION)
  private InfAdicVO infAdic = null;

  /**
   * # a02 versao Vers�o do leiaute A A01 C 1-1 1 - 4 Vers�o do leiaute (4.00).
   *
   * @return # a02 versao Vers�o do leiaute A A01 C 1-1 1 - 4 Vers�o do leiaute (4
   */
  public String getVersao() {
    return versao;
  }

  /**
   * # a02 versao Vers�o do leiaute A A01 C 1-1 1 - 4 Vers�o do leiaute (4.00).
   *
   * @param versao # a02 versao Vers�o do leiaute A A01 C 1-1 1 - 4 Vers�o do leiaute (4
   */
  public void setVersao(String versao) {
    this.versao = versao;
  }

  /**
   * # a03 Id Identificador da TAG a ser assinada ID A01 C 1-1 47 Informar a Chave de Acesso precedida do literal �NFe�,<Br>
   * <b>Note que este atributo no XML � "id", mas foi chamado de idAttribute para evitar o conflito com o ID herdado de {@link RFWVO}.
   *
   * @return # a03 Id Identificador da TAG a ser assinada ID A01 C 1-1 47 Informar a Chave de Acesso precedida do literal �NFe�,<Br>
   *         <b>Note que este atributo no XML � "id", mas foi chamado de idAttribute para evitar o conflito com o ID herdado de {@link RFWVO}
   */
  public String getIdAttribute() {
    return idAttribute;
  }

  /**
   * # a03 Id Identificador da TAG a ser assinada ID A01 C 1-1 47 Informar a Chave de Acesso precedida do literal �NFe�,<Br>
   * <b>Note que este atributo no XML � "id", mas foi chamado de idAttribute para evitar o conflito com o ID herdado de {@link RFWVO}.
   *
   * @param idAttribute # a03 Id Identificador da TAG a ser assinada ID A01 C 1-1 47 Informar a Chave de Acesso precedida do literal �NFe�,<Br>
   *          <b>Note que este atributo no XML � "id", mas foi chamado de idAttribute para evitar o conflito com o ID herdado de {@link RFWVO}
   */
  public void setIdAttribute(String idAttribute) {
    this.idAttribute = idAttribute;
  }

  /**
   * # b01 ide Informa��es de identifica��o da NF-e G A01 1-1.
   *
   * @return # b01 ide Informa��es de identifica��o da NF-e G A01 1-1
   */
  public IdeVO getIde() {
    return ide;
  }

  /**
   * # b01 ide Informa��es de identifica��o da NF-e G A01 1-1.
   *
   * @param ide # b01 ide Informa��es de identifica��o da NF-e G A01 1-1
   */
  public void setIde(IdeVO ide) {
    this.ide = ide;
  }

  /**
   * # c01 emit Identifica��o do emitente da NF-e G A01 1-1.
   *
   * @return # c01 emit Identifica��o do emitente da NF-e G A01 1-1
   */
  public EmitVO getEmit() {
    return emit;
  }

  /**
   * # c01 emit Identifica��o do emitente da NF-e G A01 1-1.
   *
   * @param emit # c01 emit Identifica��o do emitente da NF-e G A01 1-1
   */
  public void setEmit(EmitVO emit) {
    this.emit = emit;
  }

  /**
   * # h01 det Detalhamento de Produtos e Servi�os G A01 1-990<br>
   * M�ltiplas ocorr�ncias (m�ximo = 990).
   *
   * @return # h01 det Detalhamento de Produtos e Servi�os G A01 1-990<br>
   *         M�ltiplas ocorr�ncias (m�ximo = 990)
   */
  public List<DetVO> getDet() {
    return det;
  }

  /**
   * # h01 det Detalhamento de Produtos e Servi�os G A01 1-990<br>
   * M�ltiplas ocorr�ncias (m�ximo = 990).
   *
   * @param det # h01 det Detalhamento de Produtos e Servi�os G A01 1-990<br>
   *          M�ltiplas ocorr�ncias (m�ximo = 990)
   */
  public void setDet(List<DetVO> det) {
    this.det = det;
  }

  /**
   * # e01 dest Identifica��o do Destinat�rio da NF-e G A01 0-1 Grupo Obrig.at�rio para a NF-e (modelo 55).
   *
   * @return # e01 dest Identifica��o do Destinat�rio da NF-e G A01 0-1 Grupo Obrig
   */
  public DestVO getDest() {
    return dest;
  }

  /**
   * # e01 dest Identifica��o do Destinat�rio da NF-e G A01 0-1 Grupo Obrig.at�rio para a NF-e (modelo 55).
   *
   * @param dest # e01 dest Identifica��o do Destinat�rio da NF-e G A01 0-1 Grupo Obrig
   */
  public void setDest(DestVO dest) {
    this.dest = dest;
  }

  /**
   * # w01 total Grupo Totais da NF-e G A01 1-1<br>
   * O grupo de valores totais da NF-e deve ser informado com o somat�rio do campo correspondente dos itens.
   *
   * @return # w01 total Grupo Totais da NF-e G A01 1-1<br>
   *         O grupo de valores totais da NF-e deve ser informado com o somat�rio do campo correspondente dos itens
   */
  public TotalVO getTotal() {
    return total;
  }

  /**
   * # w01 total Grupo Totais da NF-e G A01 1-1<br>
   * O grupo de valores totais da NF-e deve ser informado com o somat�rio do campo correspondente dos itens.
   *
   * @param total # w01 total Grupo Totais da NF-e G A01 1-1<br>
   *          O grupo de valores totais da NF-e deve ser informado com o somat�rio do campo correspondente dos itens
   */
  public void setTotal(TotalVO total) {
    this.total = total;
  }

  /**
   * # x01 transp Grupo Informa��es do Transporte G A01 1-1.
   *
   * @return # x01 transp Grupo Informa��es do Transporte G A01 1-1
   */
  public TranspVO getTransp() {
    return transp;
  }

  /**
   * # x01 transp Grupo Informa��es do Transporte G A01 1-1.
   *
   * @param transp # x01 transp Grupo Informa��es do Transporte G A01 1-1
   */
  public void setTransp(TranspVO transp) {
    this.transp = transp;
  }

  /**
   * # y01 cobr Grupo Cobran�a G A01 0-1.
   *
   * @return # y01 cobr Grupo Cobran�a G A01 0-1
   */
  public CobrVO getCobr() {
    return cobr;
  }

  /**
   * # y01 cobr Grupo Cobran�a G A01 0-1.
   *
   * @param cobr # y01 cobr Grupo Cobran�a G A01 0-1
   */
  public void setCobr(CobrVO cobr) {
    this.cobr = cobr;
  }

  /**
   * # yA01 pag Grupo de Informa��es de Pagamento G A01 1-1<br>
   * Obrig.at�rio o preenchimento do Grupo Informa��es de Pagamento para NF-e e NFC-e. Para as notas com finalidade de Ajuste ou Devolu��o o campo Meio de Pagamento deve ser preenchido com
   * <li>90=Sem Pagamento.
   *
   * @return # yA01 pag Grupo de Informa��es de Pagamento G A01 1-1<br>
   *         Obrig
   */
  public PagVO getPag() {
    return pag;
  }

  /**
   * # yA01 pag Grupo de Informa��es de Pagamento G A01 1-1<br>
   * Obrig.at�rio o preenchimento do Grupo Informa��es de Pagamento para NF-e e NFC-e. Para as notas com finalidade de Ajuste ou Devolu��o o campo Meio de Pagamento deve ser preenchido com
   * <li>90=Sem Pagamento.
   *
   * @param pag # yA01 pag Grupo de Informa��es de Pagamento G A01 1-1<br>
   *          Obrig
   */
  public void setPag(PagVO pag) {
    this.pag = pag;
  }

  /**
   * # z01 infAdic Grupo de Informa��es Adicionais G A01 0-1.
   *
   * @return # z01 infAdic Grupo de Informa��es Adicionais G A01 0-1
   */
  public InfAdicVO getInfAdic() {
    return infAdic;
  }

  /**
   * # z01 infAdic Grupo de Informa��es Adicionais G A01 0-1.
   *
   * @param infAdic # z01 infAdic Grupo de Informa��es Adicionais G A01 0-1
   */
  public void setInfAdic(InfAdicVO infAdic) {
    this.infAdic = infAdic;
  }

}
