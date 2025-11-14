package br.eng.rodrigogml.rfw.sefaz.vo;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_modFrete;

/**
 * Description: Informações de Transporte da NF-e (TAG {@code transp}, ID X01).<br>
 * Agrupa as informações gerais de frete, transportador, retenção de ICMS no transporte, veículos, reboques, vagão/balsa e volumes.
 *
 * Este VO representa o grupo X01 e contém apenas a modalidade de frete; os demais subgrupos (transporta, retTransp, veicTransp, reboque, vol, lacres) são modelados em VOs específicos.
 *
 * Tabela de origem (MOC 7.0 – Grupo X):
 * <ul>
 * <li>X02 – {@code modFrete}: Modalidade do frete, vide {@link SEFAZ_modFrete}.</li>
 * </ul>
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_transp")
public class TranspVO extends RFWVO {

  private static final long serialVersionUID = -6315934325458711318L;

  /**
   * ID: X02 – {@code modFrete}.<br>
   * Modalidade de frete aplicada à operação.<br>
   * Valores conforme {@link SEFAZ_modFrete}.<br>
   * Ocorrência: 1-1.
   */
  @RFWMetaEnumField(caption = "Modalidade do frete", required = false)
  private SEFAZ_modFrete modFrete = null;

  /**
   * # iD: X02 – {@code modFrete}.<br>
   * Modalidade de frete aplicada à operação.<br>
   * Valores conforme {@link SEFAZ_modFrete}.<br>
   * Ocorrência: 1-1.
   *
   * @return the iD: X02 – {@code modFrete}
   */
  public SEFAZ_modFrete getModFrete() {
    return modFrete;
  }

  /**
   * # iD: X02 – {@code modFrete}.<br>
   * Modalidade de frete aplicada à operação.<br>
   * Valores conforme {@link SEFAZ_modFrete}.<br>
   * Ocorrência: 1-1.
   *
   * @param modFrete the new iD: X02 – {@code modFrete}
   */
  public void setModFrete(SEFAZ_modFrete modFrete) {
    this.modFrete = modFrete;
  }

}
