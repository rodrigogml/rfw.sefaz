package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCNPJField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCPFField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringIEField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CRT;

/**
 * VO da tag {@code <emit>} (Grupo C - Identificação do Emitente da NF-e).
 * <p>
 * Representa os dados cadastrais do emitente/remetente da NF-e, incluindo CNPJ/CPF, razão social, inscrições estadual/municipal e regime tributário.
 * <p>
 * Observação sobre obrigatoriedade: embora a documentação da NF-e indique a obrigatoriedade de vários campos (através das colunas "Ele" e "Ocor."), neste VO todos os atributos estão marcados com {@code required = false} nas anotações de metadados, por solicitação explícita.
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_emit")
public class EmitVO extends RFWVO {

  private static final long serialVersionUID = 6617711221629429771L;

  /**
   * {@link InfNFeVO}
   */
  @RFWMetaRelationshipField(caption = "InfNFe", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_infnfe")
  private InfNFeVO infNFeVO = null;

  /**
   * {@link EnderEmitVO}
   */
  @RFWMetaRelationshipField(caption = "EnderEmit", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_enderemit")
  private EnderEmitVO enderEmitVO = null;

  /**
   * CNPJ do emitente (id: C02).
   * <p>
   * Tipo: N, tamanho: 14, ocorrência: 1-1, Ele: CE (condicional). Informar o CNPJ do emitente com zeros não significativos. Na emissão de NF-e avulsa pelo Fisco, as informações do remetente são informadas neste grupo.
   */
  @RFWMetaStringCNPJField(caption = "CNPJ do emitente", required = false)
  private String cnpj;

  /**
   * CPF do remetente (id: C02a).
   * <p>
   * Tipo: N, tamanho: 11, ocorrência: 1-1, Ele: CE (condicional). CPF somente com dígitos e zeros não significativos quando aplicável.
   */
  @RFWMetaStringCPFField(caption = "CPF do remetente", required = false)
  private String cpf;

  /**
   * Razão Social ou Nome do emitente (id: C03).
   * <p>
   * Tipo: C, tamanho: 2-60, ocorrência: 1-1, Ele: E (obrigatório).
   */
  @RFWMetaStringField(caption = "Razão social ou nome do emitente", required = false, maxLength = 60, minLength = 2, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xnome;

  /**
   * Nome fantasia do emitente (id: C04).
   * <p>
   * Tipo: C, tamanho: 2-60, ocorrência: 0-1, Ele: E (obrigatório quando existir).
   */
  @RFWMetaStringField(caption = "Nome fantasia do emitente", required = false, maxLength = 60, minLength = 2, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String xfant;

  /**
   * Inscrição Estadual do emitente (id: C17).
   * <p>
   * Tipo: C, tamanho: 2-14, ocorrência: 1-1, Ele: E (obrigatório).
   */
  @RFWMetaStringIEField(caption = "Inscrição Estadual do emitente", required = false)
  private String ie;

  /**
   * Inscrição Estadual do Substituto Tributário (id: C18).
   * <p>
   * Tipo: N, tamanho: 2-14, ocorrência: 0-1, Ele: E (obrigatório quando houver retenção de ICMS-ST para UF de destino). Representa a IE do Substituto Tributário da UF de destino da mercadoria.
   */
  @RFWMetaStringIEField(caption = "IE do Substituto Tributário", required = false)
  private String iest;

  /**
   * Inscrição Municipal do prestador de serviço (id: C19).
   * <p>
   * Tipo: C, tamanho: 1-15, ocorrência: 1-1 dentro do grupo opcional -x- (id: C18.1), Ele: E (obrigatório quando o grupo for informado).
   * <p>
   * Campo do grupo "-x-" definido diretamente na classe pai, conforme instrução.
   */
  @RFWMetaStringField(caption = "Inscrição Municipal do prestador de serviço", required = false, maxLength = 15, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String im;

  /**
   * CNAE fiscal (id: C20). Agora representado como String.
   */
  @RFWMetaStringField(caption = "CNAE fiscal", required = false, maxLength = 8, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String cnae;

  /**
   * Código de Regime Tributário (CRT) (id: C21).
   * <p>
   * Tipo: N (1 dígito), ocorrência: 1-1, Ele: E (obrigatório).
   * <ul>
   * <li>1 = Simples Nacional</li>
   * <li>2 = Simples Nacional, excesso sublimite de receita bruta</li>
   * <li>3 = Regime Normal</li>
   * </ul>
   * Representado pela enumeração {@link SEFAZ_CRT}.
   */
  @RFWMetaEnumField(caption = "Código de regime tributário", required = false)
  private SEFAZ_CRT crt;

  /**
   * # {@link InfNFeVO}.
   *
   * @return the {@link InfNFeVO}
   */
  public InfNFeVO getInfNFeVO() {
    return infNFeVO;
  }

  /**
   * # {@link InfNFeVO}.
   *
   * @param infNFeVO the new {@link InfNFeVO}
   */
  public void setInfNFeVO(InfNFeVO infNFeVO) {
    this.infNFeVO = infNFeVO;
  }

  /**
   * # cNPJ do emitente (id: C02).
   * <p>
   * Tipo: N, tamanho: 14, ocorrência: 1-1, Ele: CE (condicional). Informar o CNPJ do emitente com zeros não significativos. Na emissão de NF-e avulsa pelo Fisco, as informações do remetente são informadas neste grupo.
   *
   * @return the cNPJ do emitente (id: C02)
   */
  public String getCnpj() {
    return cnpj;
  }

  /**
   * # cNPJ do emitente (id: C02).
   * <p>
   * Tipo: N, tamanho: 14, ocorrência: 1-1, Ele: CE (condicional). Informar o CNPJ do emitente com zeros não significativos. Na emissão de NF-e avulsa pelo Fisco, as informações do remetente são informadas neste grupo.
   *
   * @param cnpj the new cNPJ do emitente (id: C02)
   */
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  /**
   * # cPF do remetente (id: C02a).
   * <p>
   * Tipo: N, tamanho: 11, ocorrência: 1-1, Ele: CE (condicional). CPF somente com dígitos e zeros não significativos quando aplicável.
   *
   * @return the cPF do remetente (id: C02a)
   */
  public String getCpf() {
    return cpf;
  }

  /**
   * # cPF do remetente (id: C02a).
   * <p>
   * Tipo: N, tamanho: 11, ocorrência: 1-1, Ele: CE (condicional). CPF somente com dígitos e zeros não significativos quando aplicável.
   *
   * @param cpf the new cPF do remetente (id: C02a)
   */
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  /**
   * # razão Social ou Nome do emitente (id: C03).
   * <p>
   * Tipo: C, tamanho: 2-60, ocorrência: 1-1, Ele: E (obrigatório).
   *
   * @return the razão Social ou Nome do emitente (id: C03)
   */
  public String getXnome() {
    return xnome;
  }

  /**
   * # razão Social ou Nome do emitente (id: C03).
   * <p>
   * Tipo: C, tamanho: 2-60, ocorrência: 1-1, Ele: E (obrigatório).
   *
   * @param xnome the new razão Social ou Nome do emitente (id: C03)
   */
  public void setXnome(String xnome) {
    this.xnome = xnome;
  }

  /**
   * # nome fantasia do emitente (id: C04).
   * <p>
   * Tipo: C, tamanho: 2-60, ocorrência: 0-1, Ele: E (obrigatório quando existir).
   *
   * @return the nome fantasia do emitente (id: C04)
   */
  public String getXfant() {
    return xfant;
  }

  /**
   * # nome fantasia do emitente (id: C04).
   * <p>
   * Tipo: C, tamanho: 2-60, ocorrência: 0-1, Ele: E (obrigatório quando existir).
   *
   * @param xfant the new nome fantasia do emitente (id: C04)
   */
  public void setXfant(String xfant) {
    this.xfant = xfant;
  }

  /**
   * # inscrição Estadual do emitente (id: C17).
   * <p>
   * Tipo: C, tamanho: 2-14, ocorrência: 1-1, Ele: E (obrigatório).
   *
   * @return the inscrição Estadual do emitente (id: C17)
   */
  public String getIe() {
    return ie;
  }

  /**
   * # inscrição Estadual do emitente (id: C17).
   * <p>
   * Tipo: C, tamanho: 2-14, ocorrência: 1-1, Ele: E (obrigatório).
   *
   * @param ie the new inscrição Estadual do emitente (id: C17)
   */
  public void setIe(String ie) {
    this.ie = ie;
  }

  /**
   * # inscrição Estadual do Substituto Tributário (id: C18).
   * <p>
   * Tipo: N, tamanho: 2-14, ocorrência: 0-1, Ele: E (obrigatório quando houver retenção de ICMS-ST para UF de destino). Representa a IE do Substituto Tributário da UF de destino da mercadoria.
   *
   * @return the inscrição Estadual do Substituto Tributário (id: C18)
   */
  public String getIest() {
    return iest;
  }

  /**
   * # inscrição Estadual do Substituto Tributário (id: C18).
   * <p>
   * Tipo: N, tamanho: 2-14, ocorrência: 0-1, Ele: E (obrigatório quando houver retenção de ICMS-ST para UF de destino). Representa a IE do Substituto Tributário da UF de destino da mercadoria.
   *
   * @param iest the new inscrição Estadual do Substituto Tributário (id: C18)
   */
  public void setIest(String iest) {
    this.iest = iest;
  }

  /**
   * # inscrição Municipal do prestador de serviço (id: C19).
   * <p>
   * Tipo: C, tamanho: 1-15, ocorrência: 1-1 dentro do grupo opcional -x- (id: C18.1), Ele: E (obrigatório quando o grupo for informado).
   * <p>
   * Campo do grupo "-x-" definido diretamente na classe pai, conforme instrução.
   *
   * @return the inscrição Municipal do prestador de serviço (id: C19)
   */
  public String getIm() {
    return im;
  }

  /**
   * # inscrição Municipal do prestador de serviço (id: C19).
   * <p>
   * Tipo: C, tamanho: 1-15, ocorrência: 1-1 dentro do grupo opcional -x- (id: C18.1), Ele: E (obrigatório quando o grupo for informado).
   * <p>
   * Campo do grupo "-x-" definido diretamente na classe pai, conforme instrução.
   *
   * @param im the new inscrição Municipal do prestador de serviço (id: C19)
   */
  public void setIm(String im) {
    this.im = im;
  }

  /**
   * # cNAE fiscal (id: C20). Agora representado como String.
   *
   * @return the cNAE fiscal (id: C20)
   */
  public String getCnae() {
    return cnae;
  }

  /**
   * # cNAE fiscal (id: C20). Agora representado como String.
   *
   * @param cnae the new cNAE fiscal (id: C20)
   */
  public void setCnae(String cnae) {
    this.cnae = cnae;
  }

  /**
   * # código de Regime Tributário (CRT) (id: C21).
   * <p>
   * Tipo: N (1 dígito), ocorrência: 1-1, Ele: E (obrigatório).
   * <ul>
   * <li>1 = Simples Nacional</li>
   * <li>2 = Simples Nacional, excesso sublimite de receita bruta</li>
   * <li>3 = Regime Normal</li>
   * </ul>
   * Representado pela enumeração {@link SEFAZ_CRT}.
   *
   * @return the código de Regime Tributário (CRT) (id: C21)
   */
  public SEFAZ_CRT getCrt() {
    return crt;
  }

  /**
   * # código de Regime Tributário (CRT) (id: C21).
   * <p>
   * Tipo: N (1 dígito), ocorrência: 1-1, Ele: E (obrigatório).
   * <ul>
   * <li>1 = Simples Nacional</li>
   * <li>2 = Simples Nacional, excesso sublimite de receita bruta</li>
   * <li>3 = Regime Normal</li>
   * </ul>
   * Representado pela enumeração {@link SEFAZ_CRT}.
   *
   * @param crt the new código de Regime Tributário (CRT) (id: C21)
   */
  public void setCrt(SEFAZ_CRT crt) {
    this.crt = crt;
  }

  /**
   * # {@link EnderEmitVO}.
   *
   * @return the {@link EnderEmitVO}
   */
  public EnderEmitVO getEnderEmitVO() {
    return enderEmitVO;
  }

  /**
   * # {@link EnderEmitVO}.
   *
   * @param enderEmitVO the new {@link EnderEmitVO}
   */
  public void setEnderEmitVO(EnderEmitVO enderEmitVO) {
    this.enderEmitVO = enderEmitVO;
  }

}
