package br.eng.rodrigogml.rfw.sefaz.vo;

import java.util.List;

import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess.PreProcessOption;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaRelationshipField.RelationshipTypes;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_modFrete;

/**
 * Grupo X01 - transp: Informações do Transporte.
 * <p>
 * Ocorre 1-1 dentro do grupo A01 (infNFe).
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_transp")
public class TranspVO extends RFWVO {

  private static final long serialVersionUID = 5963477727326563159L;

  /**
   * {@link InfNFeVO}
   */
  @RFWMetaRelationshipField(caption = "InfNFe", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_infnfe")
  private InfNFeVO infNFeVO = null;

  /**
   * {@link TransportaVO}
   */
  @RFWMetaRelationshipField(caption = "Transporta", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_transp")
  private TransportaVO transportaVO = null;

  /**
   * {@link RetTranspVO}
   */
  @RFWMetaRelationshipField(caption = "RetTransp", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_transp")
  private RetTranspVO retTranspVO = null;

  /**
   * {@link VeicTranspVO}
   */
  @RFWMetaRelationshipField(caption = "VeicTransp", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_transp")
  private VeicTranspVO veicTranspVO = null;

  /**
   * {@link ReboqueVO}
   */
  @RFWMetaRelationshipField(caption = "Reboque", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_transp", minSize = 0, maxSize = 5)
  private List<ReboqueVO> reboqueVO = null;

  /**
   * {@link VolVO}
   */
  @RFWMetaRelationshipField(caption = "Vol", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_vol", minSize = 0, maxSize = 5000)
  private List<VolVO> volVO = null;

  /**
   * X02 - modFrete: Modalidade do frete. Tipo: N, Tamanho: 1, Ocorrência: 1-1 (obrigatório na estrutura). Valores: 0=Remetente (CIF), 1=Destinatário (FOB), 2=Terceiros, 3=Transporte próprio remetente, 4=Transporte próprio destinatário, 9=Sem ocorrência de transporte.
   */
  @RFWMetaEnumField(caption = "modFrete", required = false)
  private SEFAZ_modFrete modFrete;

  /**
   * X25a - vagao: Identificação do vagão. Tipo: C, Tamanho: 1-20, Ocorrência: 0-1.
   */
  @RFWMetaStringField(caption = "vagao", required = false, unique = false, maxLength = 20, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String vagao;

  /**
   * X25b - balsa: Identificação da balsa. Tipo: C, Tamanho: 1-20, Ocorrência: 0-1.
   */
  @RFWMetaStringField(caption = "balsa", required = false, unique = false, maxLength = 20, minLength = 1, preProcess = PreProcessOption.STRING_SPACESCLEAN_TO_NULL)
  private String balsa;

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
   * # {@link TransportaVO}.
   *
   * @return the {@link TransportaVO}
   */
  public TransportaVO getTransportaVO() {
    return transportaVO;
  }

  /**
   * # {@link TransportaVO}.
   *
   * @param transportaVO the new {@link TransportaVO}
   */
  public void setTransportaVO(TransportaVO transportaVO) {
    this.transportaVO = transportaVO;
  }

  /**
   * # {@link RetTranspVO}.
   *
   * @return the {@link RetTranspVO}
   */
  public RetTranspVO getRetTranspVO() {
    return retTranspVO;
  }

  /**
   * # {@link RetTranspVO}.
   *
   * @param retTranspVO the new {@link RetTranspVO}
   */
  public void setRetTranspVO(RetTranspVO retTranspVO) {
    this.retTranspVO = retTranspVO;
  }

  /**
   * # {@link VeicTranspVO}.
   *
   * @return the {@link VeicTranspVO}
   */
  public VeicTranspVO getVeicTranspVO() {
    return veicTranspVO;
  }

  /**
   * # {@link VeicTranspVO}.
   *
   * @param veicTranspVO the new {@link VeicTranspVO}
   */
  public void setVeicTranspVO(VeicTranspVO veicTranspVO) {
    this.veicTranspVO = veicTranspVO;
  }

  /**
   * # {@link ReboqueVO}.
   *
   * @return the {@link ReboqueVO}
   */
  public List<ReboqueVO> getReboqueVO() {
    return reboqueVO;
  }

  /**
   * # {@link ReboqueVO}.
   *
   * @param reboqueVO the new {@link ReboqueVO}
   */
  public void setReboqueVO(List<ReboqueVO> reboqueVO) {
    this.reboqueVO = reboqueVO;
  }

  /**
   * # {@link VolVO}.
   *
   * @return the {@link VolVO}
   */
  public List<VolVO> getVolVO() {
    return volVO;
  }

  /**
   * # {@link VolVO}.
   *
   * @param volVO the new {@link VolVO}
   */
  public void setVolVO(List<VolVO> volVO) {
    this.volVO = volVO;
  }

  /**
   * # x02 - modFrete: Modalidade do frete. Tipo: N, Tamanho: 1, Ocorrência: 1-1 (obrigatório na estrutura). Valores: 0=Remetente (CIF), 1=Destinatário (FOB), 2=Terceiros, 3=Transporte próprio remetente, 4=Transporte próprio destinatário, 9=Sem ocorrência de transporte.
   *
   * @return the x02 - modFrete: Modalidade do frete
   */
  public SEFAZ_modFrete getModFrete() {
    return modFrete;
  }

  /**
   * # x02 - modFrete: Modalidade do frete. Tipo: N, Tamanho: 1, Ocorrência: 1-1 (obrigatório na estrutura). Valores: 0=Remetente (CIF), 1=Destinatário (FOB), 2=Terceiros, 3=Transporte próprio remetente, 4=Transporte próprio destinatário, 9=Sem ocorrência de transporte.
   *
   * @param modFrete the new x02 - modFrete: Modalidade do frete
   */
  public void setModFrete(SEFAZ_modFrete modFrete) {
    this.modFrete = modFrete;
  }

  /**
   * # x25a - vagao: Identificação do vagão. Tipo: C, Tamanho: 1-20, Ocorrência: 0-1.
   *
   * @return the x25a - vagao: Identificação do vagão
   */
  public String getVagao() {
    return vagao;
  }

  /**
   * # x25a - vagao: Identificação do vagão. Tipo: C, Tamanho: 1-20, Ocorrência: 0-1.
   *
   * @param vagao the new x25a - vagao: Identificação do vagão
   */
  public void setVagao(String vagao) {
    this.vagao = vagao;
  }

  /**
   * # x25b - balsa: Identificação da balsa. Tipo: C, Tamanho: 1-20, Ocorrência: 0-1.
   *
   * @return the x25b - balsa: Identificação da balsa
   */
  public String getBalsa() {
    return balsa;
  }

  /**
   * # x25b - balsa: Identificação da balsa. Tipo: C, Tamanho: 1-20, Ocorrência: 0-1.
   *
   * @param balsa the new x25b - balsa: Identificação da balsa
   */
  public void setBalsa(String balsa) {
    this.balsa = balsa;
  }

}
