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
public class SEFAZTranspVO extends RFWVO {

  private static final long serialVersionUID = 5963477727326563159L;

  /**
   * {@link SEFAZInfNFeVO}
   */
  @RFWMetaRelationshipField(caption = "InfNFe", relationship = RelationshipTypes.PARENT_ASSOCIATION, required = true, column = "idsefaz_infnfe")
  private SEFAZInfNFeVO infNFeVO = null;

  /**
   * {@link SEFAZTransportaVO}
   */
  @RFWMetaRelationshipField(caption = "Transporta", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_transp")
  private SEFAZTransportaVO transportaVO = null;

  /**
   * {@link SEFAZRetTranspVO}
   */
  @RFWMetaRelationshipField(caption = "RetTransp", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_transp")
  private SEFAZRetTranspVO retTranspVO = null;

  /**
   * {@link SEFAZVeicTranspVO}
   */
  @RFWMetaRelationshipField(caption = "VeicTransp", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_transp")
  private SEFAZVeicTranspVO veicTranspVO = null;

  /**
   * {@link SEFAZReboqueVO}
   */
  @RFWMetaRelationshipField(caption = "Reboque", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_transp", minSize = 0, maxSize = 5)
  private List<SEFAZReboqueVO> reboqueVO = null;

  /**
   * {@link SEFAZVolVO}
   */
  @RFWMetaRelationshipField(caption = "Vol", relationship = RelationshipTypes.COMPOSITION, required = false, columnMapped = "idsefaz_vol", minSize = 0, maxSize = 5000)
  private List<SEFAZVolVO> volVO = null;

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
   * # {@link SEFAZInfNFeVO}.
   *
   * @return the {@link SEFAZInfNFeVO}
   */
  public SEFAZInfNFeVO getInfNFeVO() {
    return infNFeVO;
  }

  /**
   * # {@link SEFAZInfNFeVO}.
   *
   * @param infNFeVO the new {@link SEFAZInfNFeVO}
   */
  public void setInfNFeVO(SEFAZInfNFeVO infNFeVO) {
    this.infNFeVO = infNFeVO;
  }

  /**
   * # {@link SEFAZTransportaVO}.
   *
   * @return the {@link SEFAZTransportaVO}
   */
  public SEFAZTransportaVO getTransportaVO() {
    return transportaVO;
  }

  /**
   * # {@link SEFAZTransportaVO}.
   *
   * @param transportaVO the new {@link SEFAZTransportaVO}
   */
  public void setTransportaVO(SEFAZTransportaVO transportaVO) {
    this.transportaVO = transportaVO;
  }

  /**
   * # {@link SEFAZRetTranspVO}.
   *
   * @return the {@link SEFAZRetTranspVO}
   */
  public SEFAZRetTranspVO getRetTranspVO() {
    return retTranspVO;
  }

  /**
   * # {@link SEFAZRetTranspVO}.
   *
   * @param retTranspVO the new {@link SEFAZRetTranspVO}
   */
  public void setRetTranspVO(SEFAZRetTranspVO retTranspVO) {
    this.retTranspVO = retTranspVO;
  }

  /**
   * # {@link SEFAZVeicTranspVO}.
   *
   * @return the {@link SEFAZVeicTranspVO}
   */
  public SEFAZVeicTranspVO getVeicTranspVO() {
    return veicTranspVO;
  }

  /**
   * # {@link SEFAZVeicTranspVO}.
   *
   * @param veicTranspVO the new {@link SEFAZVeicTranspVO}
   */
  public void setVeicTranspVO(SEFAZVeicTranspVO veicTranspVO) {
    this.veicTranspVO = veicTranspVO;
  }

  /**
   * # {@link SEFAZReboqueVO}.
   *
   * @return the {@link SEFAZReboqueVO}
   */
  public List<SEFAZReboqueVO> getReboqueVO() {
    return reboqueVO;
  }

  /**
   * # {@link SEFAZReboqueVO}.
   *
   * @param reboqueVO the new {@link SEFAZReboqueVO}
   */
  public void setReboqueVO(List<SEFAZReboqueVO> reboqueVO) {
    this.reboqueVO = reboqueVO;
  }

  /**
   * # {@link SEFAZVolVO}.
   *
   * @return the {@link SEFAZVolVO}
   */
  public List<SEFAZVolVO> getVolVO() {
    return volVO;
  }

  /**
   * # {@link SEFAZVolVO}.
   *
   * @param volVO the new {@link SEFAZVolVO}
   */
  public void setVolVO(List<SEFAZVolVO> volVO) {
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
