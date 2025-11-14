package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_cRegTrib;

/**
 * Description: Totais referentes ao ISSQN da NF-e (TAG {@code ISSQNtot}, ID W17).<br>
 * O grupo é opcional (ocorrência 0-1) e deve ser informado quando houver retenção ou apuração de ISSQN na nota, consolidando os valores dos serviços prestados e dos tributos incidentes sobre ISS.
 *
 * Campos mapeados (MOC 7.0 – Anexo I):
 * <ul>
 * <li>W18 – {@code vServ}: Valor total dos serviços sob não incidência ou não tributados pelo ICMS.</li>
 * <li>W19 – {@code vBC}: Valor total da base de cálculo do ISS.</li>
 * <li>W20 – {@code vISS}: Valor total do ISS.</li>
 * <li>W21 – {@code vPIS}: Valor total do PIS sobre serviços.</li>
 * <li>W22 – {@code vCOFINS}: Valor total da COFINS sobre serviços.</li>
 * <li>W22a – {@code dCompet}: Data de competência / prestação do serviço (formato AAAA-MM-DD).</li>
 * <li>W22b – {@code vDeducao}: Valor total da dedução para redução da base de cálculo do ISS.</li>
 * <li>W22c – {@code vOutro}: Valor total de outras retenções.</li>
 * <li>W22d – {@code vDescIncond}: Valor total de descontos incondicionados.</li>
 * <li>W22e – {@code vDescCond}: Valor total de descontos condicionados.</li>
 * <li>W22f – {@code vISSRet}: Valor total do ISS retido.</li>
 * <li>W22g – {@code cRegTrib}: Código do Regime Especial de Tributação do ISSQN, conforme {@link SEFAZ_cRegTrib}.</li>
 * </ul>
 *
 * @author BIS DEVil
 * @since (11 de nov. de 2025)
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_issqn_tot")
public class ISSQNTotVO extends RFWVO {

  private static final long serialVersionUID = 8183923063568799912L;

  /**
   * ID: W18 – {@code vServ}.<br>
   * Valor total dos serviços sob não incidência ou não tributados pelo ICMS.<br>
   * Tamanho: 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor total serviços (ISSQN)", required = false, scale = 2, absolute = true)
  private BigDecimal vServ = null;

  /**
   * ID: W19 – {@code vBC}.<br>
   * Valor total da base de cálculo do ISS.<br>
   * Tamanho: 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Base de cálculo total ISS", required = false, scale = 2, absolute = true)
  private BigDecimal vBC = null;

  /**
   * ID: W20 – {@code vISS}.<br>
   * Valor total do ISS.<br>
   * Tamanho: 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor total ISS", required = false, scale = 2, absolute = true)
  private BigDecimal vISS = null;

  /**
   * ID: W21 – {@code vPIS}.<br>
   * Valor total do PIS incidente sobre os serviços (quando houver).<br>
   * Tamanho: 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor total PIS sobre serviços", required = false, scale = 2, absolute = true)
  private BigDecimal vPIS = null;

  /**
   * ID: W22 – {@code vCOFINS}.<br>
   * Valor total da COFINS incidente sobre os serviços (quando houver).<br>
   * Tamanho: 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor total COFINS sobre serviços", required = false, scale = 2, absolute = true)
  private BigDecimal vCOFINS = null;

  /**
   * ID: W22a – {@code dCompet}.<br>
   * Data da prestação do serviço / competência do ISSQN.<br>
   * Formato: {@code AAAA-MM-DD}. Tamanho: 8 (no MOC) – aqui armazenado como string com 10 caracteres incluindo separadores.<br>
   * Recomenda-se seguir o padrão ISO {@code yyyy-MM-dd}.
   */
  @RFWMetaStringField(caption = "Data de competência ISSQN", required = false, maxLength = 10, pattern = "\\d{4}-\\d{2}-\\d{2}")
  private String dCompet = null;

  /**
   * ID: W22b – {@code vDeducao}.<br>
   * Valor total das deduções utilizadas para redução da base de cálculo do ISS.<br>
   * Tamanho: 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor total dedução BC ISS", required = false, scale = 2, absolute = true)
  private BigDecimal vDeducao = null;

  /**
   * ID: W22c – {@code vOutro}.<br>
   * Valor total de outras retenções relacionadas ao ISSQN.<br>
   * Tamanho: 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor total outras retenções ISS", required = false, scale = 2, absolute = true)
  private BigDecimal vOutro = null;

  /**
   * ID: W22d – {@code vDescIncond}.<br>
   * Valor total de descontos incondicionados sobre os serviços.<br>
   * Tamanho: 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Descontos incondicionados ISS", required = false, scale = 2, absolute = true)
  private BigDecimal vDescIncond = null;

  /**
   * ID: W22e – {@code vDescCond}.<br>
   * Valor total de descontos condicionados sobre os serviços.<br>
   * Tamanho: 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Descontos condicionados ISS", required = false, scale = 2, absolute = true)
  private BigDecimal vDescCond = null;

  /**
   * ID: W22f – {@code vISSRet}.<br>
   * Valor total do ISS retido na fonte (quando aplicável).<br>
   * Tamanho: 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor total ISS retido", required = false, scale = 2, absolute = true)
  private BigDecimal vISSRet = null;

  /**
   * ID: W22g – {@code cRegTrib}.<br>
   * Código do Regime Especial de Tributação do ISSQN, conforme enumeração {@link SEFAZ_cRegTrib}.<br>
   * Tamanho: 2.
   */
  @RFWMetaEnumField(caption = "Regime especial de tributação ISS", required = false)
  private SEFAZ_cRegTrib cRegTrib = null;

  /**
   * # iD: W18 – {@code vServ}.<br>
   * Valor total dos serviços sob não incidência ou não tributados pelo ICMS.<br>
   * Tamanho: 13v2.
   *
   * @return the iD: W18 – {@code vServ}
   */
  public BigDecimal getVServ() {
    return vServ;
  }

  /**
   * # iD: W18 – {@code vServ}.<br>
   * Valor total dos serviços sob não incidência ou não tributados pelo ICMS.<br>
   * Tamanho: 13v2.
   *
   * @param vServ the new iD: W18 – {@code vServ}
   */
  public void setVServ(BigDecimal vServ) {
    this.vServ = vServ;
  }

  /**
   * # iD: W19 – {@code vBC}.<br>
   * Valor total da base de cálculo do ISS.<br>
   * Tamanho: 13v2.
   *
   * @return the iD: W19 – {@code vBC}
   */
  public BigDecimal getVBC() {
    return vBC;
  }

  /**
   * # iD: W19 – {@code vBC}.<br>
   * Valor total da base de cálculo do ISS.<br>
   * Tamanho: 13v2.
   *
   * @param vBC the new iD: W19 – {@code vBC}
   */
  public void setVBC(BigDecimal vBC) {
    this.vBC = vBC;
  }

  /**
   * # iD: W20 – {@code vISS}.<br>
   * Valor total do ISS.<br>
   * Tamanho: 13v2.
   *
   * @return the iD: W20 – {@code vISS}
   */
  public BigDecimal getVISS() {
    return vISS;
  }

  /**
   * # iD: W20 – {@code vISS}.<br>
   * Valor total do ISS.<br>
   * Tamanho: 13v2.
   *
   * @param vISS the new iD: W20 – {@code vISS}
   */
  public void setVISS(BigDecimal vISS) {
    this.vISS = vISS;
  }

  /**
   * # iD: W21 – {@code vPIS}.<br>
   * Valor total do PIS incidente sobre os serviços (quando houver).<br>
   * Tamanho: 13v2.
   *
   * @return the iD: W21 – {@code vPIS}
   */
  public BigDecimal getVPIS() {
    return vPIS;
  }

  /**
   * # iD: W21 – {@code vPIS}.<br>
   * Valor total do PIS incidente sobre os serviços (quando houver).<br>
   * Tamanho: 13v2.
   *
   * @param vPIS the new iD: W21 – {@code vPIS}
   */
  public void setVPIS(BigDecimal vPIS) {
    this.vPIS = vPIS;
  }

  /**
   * # iD: W22 – {@code vCOFINS}.<br>
   * Valor total da COFINS incidente sobre os serviços (quando houver).<br>
   * Tamanho: 13v2.
   *
   * @return the iD: W22 – {@code vCOFINS}
   */
  public BigDecimal getVCOFINS() {
    return vCOFINS;
  }

  /**
   * # iD: W22 – {@code vCOFINS}.<br>
   * Valor total da COFINS incidente sobre os serviços (quando houver).<br>
   * Tamanho: 13v2.
   *
   * @param vCOFINS the new iD: W22 – {@code vCOFINS}
   */
  public void setVCOFINS(BigDecimal vCOFINS) {
    this.vCOFINS = vCOFINS;
  }

  /**
   * # iD: W22a – {@code dCompet}.<br>
   * Data da prestação do serviço / competência do ISSQN.<br>
   * Formato: {@code AAAA-MM-DD}. Tamanho: 8 (no MOC) – aqui armazenado como string com 10 caracteres incluindo separadores.<br>
   * Recomenda-se seguir o padrão ISO {@code yyyy-MM-dd}.
   *
   * @return the iD: W22a – {@code dCompet}
   */
  public String getDCompet() {
    return dCompet;
  }

  /**
   * # iD: W22a – {@code dCompet}.<br>
   * Data da prestação do serviço / competência do ISSQN.<br>
   * Formato: {@code AAAA-MM-DD}. Tamanho: 8 (no MOC) – aqui armazenado como string com 10 caracteres incluindo separadores.<br>
   * Recomenda-se seguir o padrão ISO {@code yyyy-MM-dd}.
   *
   * @param dCompet the new iD: W22a – {@code dCompet}
   */
  public void setDCompet(String dCompet) {
    this.dCompet = dCompet;
  }

  /**
   * # iD: W22b – {@code vDeducao}.<br>
   * Valor total das deduções utilizadas para redução da base de cálculo do ISS.<br>
   * Tamanho: 13v2.
   *
   * @return the iD: W22b – {@code vDeducao}
   */
  public BigDecimal getVDeducao() {
    return vDeducao;
  }

  /**
   * # iD: W22b – {@code vDeducao}.<br>
   * Valor total das deduções utilizadas para redução da base de cálculo do ISS.<br>
   * Tamanho: 13v2.
   *
   * @param vDeducao the new iD: W22b – {@code vDeducao}
   */
  public void setVDeducao(BigDecimal vDeducao) {
    this.vDeducao = vDeducao;
  }

  /**
   * # iD: W22c – {@code vOutro}.<br>
   * Valor total de outras retenções relacionadas ao ISSQN.<br>
   * Tamanho: 13v2.
   *
   * @return the iD: W22c – {@code vOutro}
   */
  public BigDecimal getVOutro() {
    return vOutro;
  }

  /**
   * # iD: W22c – {@code vOutro}.<br>
   * Valor total de outras retenções relacionadas ao ISSQN.<br>
   * Tamanho: 13v2.
   *
   * @param vOutro the new iD: W22c – {@code vOutro}
   */
  public void setVOutro(BigDecimal vOutro) {
    this.vOutro = vOutro;
  }

  /**
   * # iD: W22d – {@code vDescIncond}.<br>
   * Valor total de descontos incondicionados sobre os serviços.<br>
   * Tamanho: 13v2.
   *
   * @return the iD: W22d – {@code vDescIncond}
   */
  public BigDecimal getVDescIncond() {
    return vDescIncond;
  }

  /**
   * # iD: W22d – {@code vDescIncond}.<br>
   * Valor total de descontos incondicionados sobre os serviços.<br>
   * Tamanho: 13v2.
   *
   * @param vDescIncond the new iD: W22d – {@code vDescIncond}
   */
  public void setVDescIncond(BigDecimal vDescIncond) {
    this.vDescIncond = vDescIncond;
  }

  /**
   * Gets the desc cond.
   *
   * @return the desc cond
   */
  public BigDecimal getDescCond() {
    return vDescCond;
  }

  /**
   * # iD: W22e – {@code vDescCond}.<br>
   * Valor total de descontos condicionados sobre os serviços.<br>
   * Tamanho: 13v2.
   *
   * @param vDescCond the new iD: W22e – {@code vDescCond}
   */
  public void setVDescCond(BigDecimal vDescCond) {
    this.vDescCond = vDescCond;
  }

  /**
   * # iD: W22f – {@code vISSRet}.<br>
   * Valor total do ISS retido na fonte (quando aplicável).<br>
   * Tamanho: 13v2.
   *
   * @return the iD: W22f – {@code vISSRet}
   */
  public BigDecimal getVISSRet() {
    return vISSRet;
  }

  /**
   * # iD: W22f – {@code vISSRet}.<br>
   * Valor total do ISS retido na fonte (quando aplicável).<br>
   * Tamanho: 13v2.
   *
   * @param vISSRet the new iD: W22f – {@code vISSRet}
   */
  public void setVISSRet(BigDecimal vISSRet) {
    this.vISSRet = vISSRet;
  }

  /**
   * # iD: W22g – {@code cRegTrib}.<br>
   * Código do Regime Especial de Tributação do ISSQN, conforme enumeração {@link SEFAZ_cRegTrib}.<br>
   * Tamanho: 2.
   *
   * @return the iD: W22g – {@code cRegTrib}
   */
  public SEFAZ_cRegTrib getCRegTrib() {
    return cRegTrib;
  }

  /**
   * # iD: W22g – {@code cRegTrib}.<br>
   * Código do Regime Especial de Tributação do ISSQN, conforme enumeração {@link SEFAZ_cRegTrib}.<br>
   * Tamanho: 2.
   *
   * @param cRegTrib the new iD: W22g – {@code cRegTrib}
   */
  public void setCRegTrib(SEFAZ_cRegTrib cRegTrib) {
    this.cRegTrib = cRegTrib;
  }

}
