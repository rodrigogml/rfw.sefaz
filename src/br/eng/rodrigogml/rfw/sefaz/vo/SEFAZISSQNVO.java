package br.eng.rodrigogml.rfw.sefaz.vo;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.orm.dao.annotations.dao.RFWDAOAnnotation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indISS;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indIncentivo;

/**
 * Description: Informações do ISSQN do item da NF-e (TAG {@code ISSQN}, ID U01).<br>
 * Consolida todos os campos do grupo ISSQN, incluindo base, alíquota, valores, local da ocorrência do fato gerador e indicadores de exigibilidade/incentivo.
 *
 * @author BIS DEVil
 * @since (11 de nov. de 2025)
 */
@RFWDAOAnnotation(schema = "_RFW.SEFAZ", table = "sefaz_issqn")
public class SEFAZISSQNVO extends RFWVO {

  private static final long serialVersionUID = -734958273495872359L;

  /**
   * ID: U02<br>
   * Valor da base de cálculo do ISSQN (vBC).<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Base de cálculo ISSQN", required = false, scale = 2, absolute = true, minValue = "0")
  private BigDecimal vBC = null;

  /**
   * ID: U03<br>
   * Alíquota do ISSQN (vAliq), em percentual.<br>
   * Tamanho 3v2-4.
   */
  @RFWMetaBigDecimalField(caption = "Alíquota ISSQN", required = false, scale = 2, scaleMax = 4, absolute = true, minValue = "0")
  private BigDecimal vAliq = null;

  /**
   * ID: U04<br>
   * Valor do ISSQN (vISSQN).<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor do ISSQN", required = false, scale = 2, absolute = true, minValue = "0")
  private BigDecimal vISSQN = null;

  /**
   * ID: U05<br>
   * Código do município de ocorrência do fato gerador do ISSQN (cMunFG).<br>
   * Tabela do IBGE, 7 dígitos.
   */
  @RFWMetaStringField(caption = "Município do fato gerador", required = false, maxLength = 7, pattern = "[0-9]{7}")
  private String cMunFG = null;

  /**
   * ID: U06<br>
   * Item da Lista de Serviços (cListServ).<br>
   * Formato NN.NN (padrão ABRASF).
   */
  @RFWMetaStringField(caption = "Item da lista de serviços", required = false, maxLength = 5, pattern = "[0-9]{2}\\.[0-9]{2}")
  private String cListServ = null;

  /**
   * ID: U07<br>
   * Valor da dedução para redução da base de cálculo (vDeducao).<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Valor da dedução", required = false, scale = 2, absolute = true, minValue = "0")
  private BigDecimal vDeducao = null;

  /**
   * ID: U08<br>
   * Valor de outras retenções de ISS (vOutro).<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Outras retenções", required = false, scale = 2, absolute = true, minValue = "0")
  private BigDecimal vOutro = null;

  /**
   * ID: U09<br>
   * Valor de desconto incondicionado (vDescIncond).<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Desconto incondicionado", required = false, scale = 2, absolute = true, minValue = "0")
  private BigDecimal vDescIncond = null;

  /**
   * ID: U10<br>
   * Valor de desconto condicionado (vDescCond).<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "Desconto condicionado", required = false, scale = 2, absolute = true, minValue = "0")
  private BigDecimal vDescCond = null;

  /**
   * ID: U11<br>
   * Valor da retenção de ISS (vISSRet).<br>
   * Tamanho 13v2.
   */
  @RFWMetaBigDecimalField(caption = "ISS retido", required = false, scale = 2, absolute = true, minValue = "0")
  private BigDecimal vISSRet = null;

  /**
   * ID: U12<br>
   * Indicador da exigibilidade do ISS (indISS).<br>
   * Valores conforme {@link SEFAZ_indISS}.
   */
  @RFWMetaEnumField(caption = "Exigibilidade do ISS", required = false)
  private SEFAZ_indISS indISS = null;

  /**
   * ID: U13<br>
   * Código do serviço prestado dentro do município (cServico).<br>
   * Definido pela legislação municipal, tamanho 1-20.
   */
  @RFWMetaStringField(caption = "Código do serviço", required = false, maxLength = 20)
  private String cServico = null;

  /**
   * ID: U14<br>
   * Código do município de incidência do imposto (cMun).<br>
   * Tabela do IBGE, 7 dígitos. Utilizar "9999999" para serviço fora do País.
   */
  @RFWMetaStringField(caption = "Município do imposto", required = false, maxLength = 7, pattern = "[0-9]{7}")
  private String cMun = null;

  /**
   * ID: U15<br>
   * Código do país onde o serviço foi prestado (cPais).<br>
   * Tabela do BACEN, 4 dígitos. Obrigatório quando cMun = "9999999".
   */
  @RFWMetaStringField(caption = "País do serviço", required = false, maxLength = 4, pattern = "[0-9]{4}")
  private String cPais = null;

  /**
   * ID: U16<br>
   * Número do processo judicial ou administrativo de suspensão da exigibilidade (nProcesso).<br>
   * Tamanho 1-30.
   */
  @RFWMetaStringField(caption = "Processo de suspensão", required = false, maxLength = 30)
  private String nProcesso = null;

  /**
   * ID: U17<br>
   * Indicador de incentivo fiscal (indIncentivo).<br>
   * Valores conforme {@link SEFAZ_indIncentivo}.
   */
  @RFWMetaEnumField(caption = "Incentivo fiscal", required = false)
  private SEFAZ_indIncentivo indIncentivo = null;

  /**
   * # iD: U02<br>
   * Valor da base de cálculo do ISSQN (vBC).<br>
   * Tamanho 13v2.
   *
   * @return the iD: U02<br>
   *         Valor da base de cálculo do ISSQN (vBC)
   */
  public BigDecimal getVBC() {
    return vBC;
  }

  /**
   * # iD: U02<br>
   * Valor da base de cálculo do ISSQN (vBC).<br>
   * Tamanho 13v2.
   *
   * @param vBC the new iD: U02<br>
   *          Valor da base de cálculo do ISSQN (vBC)
   */
  public void setVBC(BigDecimal vBC) {
    this.vBC = vBC;
  }

  /**
   * # iD: U03<br>
   * Alíquota do ISSQN (vAliq), em percentual.<br>
   * Tamanho 3v2-4.
   *
   * @return the iD: U03<br>
   *         Alíquota do ISSQN (vAliq), em percentual
   */
  public BigDecimal getVAliq() {
    return vAliq;
  }

  /**
   * # iD: U03<br>
   * Alíquota do ISSQN (vAliq), em percentual.<br>
   * Tamanho 3v2-4.
   *
   * @param vAliq the new iD: U03<br>
   *          Alíquota do ISSQN (vAliq), em percentual
   */
  public void setVAliq(BigDecimal vAliq) {
    this.vAliq = vAliq;
  }

  /**
   * # iD: U04<br>
   * Valor do ISSQN (vISSQN).<br>
   * Tamanho 13v2.
   *
   * @return the iD: U04<br>
   *         Valor do ISSQN (vISSQN)
   */
  public BigDecimal getVISSQN() {
    return vISSQN;
  }

  /**
   * # iD: U04<br>
   * Valor do ISSQN (vISSQN).<br>
   * Tamanho 13v2.
   *
   * @param vISSQN the new iD: U04<br>
   *          Valor do ISSQN (vISSQN)
   */
  public void setVISSQN(BigDecimal vISSQN) {
    this.vISSQN = vISSQN;
  }

  /**
   * # iD: U05<br>
   * Código do município de ocorrência do fato gerador do ISSQN (cMunFG).<br>
   * Tabela do IBGE, 7 dígitos.
   *
   * @return the iD: U05<br>
   *         Código do município de ocorrência do fato gerador do ISSQN (cMunFG)
   */
  public String getCMunFG() {
    return cMunFG;
  }

  /**
   * # iD: U05<br>
   * Código do município de ocorrência do fato gerador do ISSQN (cMunFG).<br>
   * Tabela do IBGE, 7 dígitos.
   *
   * @param cMunFG the new iD: U05<br>
   *          Código do município de ocorrência do fato gerador do ISSQN (cMunFG)
   */
  public void setCMunFG(String cMunFG) {
    this.cMunFG = cMunFG;
  }

  /**
   * # iD: U06<br>
   * Item da Lista de Serviços (cListServ).<br>
   * Formato NN.NN (padrão ABRASF).
   *
   * @return the iD: U06<br>
   *         Item da Lista de Serviços (cListServ)
   */
  public String getCListServ() {
    return cListServ;
  }

  /**
   * # iD: U06<br>
   * Item da Lista de Serviços (cListServ).<br>
   * Formato NN.NN (padrão ABRASF).
   *
   * @param cListServ the new iD: U06<br>
   *          Item da Lista de Serviços (cListServ)
   */
  public void setCListServ(String cListServ) {
    this.cListServ = cListServ;
  }

  /**
   * # iD: U07<br>
   * Valor da dedução para redução da base de cálculo (vDeducao).<br>
   * Tamanho 13v2.
   *
   * @return the iD: U07<br>
   *         Valor da dedução para redução da base de cálculo (vDeducao)
   */
  public BigDecimal getVDeducao() {
    return vDeducao;
  }

  /**
   * # iD: U07<br>
   * Valor da dedução para redução da base de cálculo (vDeducao).<br>
   * Tamanho 13v2.
   *
   * @param vDeducao the new iD: U07<br>
   *          Valor da dedução para redução da base de cálculo (vDeducao)
   */
  public void setVDeducao(BigDecimal vDeducao) {
    this.vDeducao = vDeducao;
  }

  /**
   * # iD: U08<br>
   * Valor de outras retenções de ISS (vOutro).<br>
   * Tamanho 13v2.
   *
   * @return the iD: U08<br>
   *         Valor de outras retenções de ISS (vOutro)
   */
  public BigDecimal getVOutro() {
    return vOutro;
  }

  /**
   * # iD: U08<br>
   * Valor de outras retenções de ISS (vOutro).<br>
   * Tamanho 13v2.
   *
   * @param vOutro the new iD: U08<br>
   *          Valor de outras retenções de ISS (vOutro)
   */
  public void setVOutro(BigDecimal vOutro) {
    this.vOutro = vOutro;
  }

  /**
   * # iD: U09<br>
   * Valor de desconto incondicionado (vDescIncond).<br>
   * Tamanho 13v2.
   *
   * @return the iD: U09<br>
   *         Valor de desconto incondicionado (vDescIncond)
   */
  public BigDecimal getVDescIncond() {
    return vDescIncond;
  }

  /**
   * # iD: U09<br>
   * Valor de desconto incondicionado (vDescIncond).<br>
   * Tamanho 13v2.
   *
   * @param vDescIncond the new iD: U09<br>
   *          Valor de desconto incondicionado (vDescIncond)
   */
  public void setVDescIncond(BigDecimal vDescIncond) {
    this.vDescIncond = vDescIncond;
  }

  /**
   * # iD: U10<br>
   * Valor de desconto condicionado (vDescCond).<br>
   * Tamanho 13v2.
   *
   * @return the iD: U10<br>
   *         Valor de desconto condicionado (vDescCond)
   */
  public BigDecimal getVDescCond() {
    return vDescCond;
  }

  /**
   * # iD: U10<br>
   * Valor de desconto condicionado (vDescCond).<br>
   * Tamanho 13v2.
   *
   * @param vDescCond the new iD: U10<br>
   *          Valor de desconto condicionado (vDescCond)
   */
  public void setVDescCond(BigDecimal vDescCond) {
    this.vDescCond = vDescCond;
  }

  /**
   * # iD: U11<br>
   * Valor da retenção de ISS (vISSRet).<br>
   * Tamanho 13v2.
   *
   * @return the iD: U11<br>
   *         Valor da retenção de ISS (vISSRet)
   */
  public BigDecimal getVISSRet() {
    return vISSRet;
  }

  /**
   * # iD: U11<br>
   * Valor da retenção de ISS (vISSRet).<br>
   * Tamanho 13v2.
   *
   * @param vISSRet the new iD: U11<br>
   *          Valor da retenção de ISS (vISSRet)
   */
  public void setVISSRet(BigDecimal vISSRet) {
    this.vISSRet = vISSRet;
  }

  /**
   * # iD: U12<br>
   * Indicador da exigibilidade do ISS (indISS).<br>
   * Valores conforme {@link SEFAZ_indISS}.
   *
   * @return the iD: U12<br>
   *         Indicador da exigibilidade do ISS (indISS)
   */
  public SEFAZ_indISS getIndISS() {
    return indISS;
  }

  /**
   * # iD: U12<br>
   * Indicador da exigibilidade do ISS (indISS).<br>
   * Valores conforme {@link SEFAZ_indISS}.
   *
   * @param indISS the new iD: U12<br>
   *          Indicador da exigibilidade do ISS (indISS)
   */
  public void setIndISS(SEFAZ_indISS indISS) {
    this.indISS = indISS;
  }

  /**
   * # iD: U13<br>
   * Código do serviço prestado dentro do município (cServico).<br>
   * Definido pela legislação municipal, tamanho 1-20.
   *
   * @return the iD: U13<br>
   *         Código do serviço prestado dentro do município (cServico)
   */
  public String getCServico() {
    return cServico;
  }

  /**
   * # iD: U13<br>
   * Código do serviço prestado dentro do município (cServico).<br>
   * Definido pela legislação municipal, tamanho 1-20.
   *
   * @param cServico the new iD: U13<br>
   *          Código do serviço prestado dentro do município (cServico)
   */
  public void setCServico(String cServico) {
    this.cServico = cServico;
  }

  /**
   * # iD: U14<br>
   * Código do município de incidência do imposto (cMun).<br>
   * Tabela do IBGE, 7 dígitos. Utilizar "9999999" para serviço fora do País.
   *
   * @return the iD: U14<br>
   *         Código do município de incidência do imposto (cMun)
   */
  public String getCMun() {
    return cMun;
  }

  /**
   * # iD: U14<br>
   * Código do município de incidência do imposto (cMun).<br>
   * Tabela do IBGE, 7 dígitos. Utilizar "9999999" para serviço fora do País.
   *
   * @param cMun the new iD: U14<br>
   *          Código do município de incidência do imposto (cMun)
   */
  public void setCMun(String cMun) {
    this.cMun = cMun;
  }

  /**
   * # iD: U15<br>
   * Código do país onde o serviço foi prestado (cPais).<br>
   * Tabela do BACEN, 4 dígitos. Obrigatório quando cMun = "9999999".
   *
   * @return the iD: U15<br>
   *         Código do país onde o serviço foi prestado (cPais)
   */
  public String getCPais() {
    return cPais;
  }

  /**
   * # iD: U15<br>
   * Código do país onde o serviço foi prestado (cPais).<br>
   * Tabela do BACEN, 4 dígitos. Obrigatório quando cMun = "9999999".
   *
   * @param cPais the new iD: U15<br>
   *          Código do país onde o serviço foi prestado (cPais)
   */
  public void setCPais(String cPais) {
    this.cPais = cPais;
  }

  /**
   * # iD: U16<br>
   * Número do processo judicial ou administrativo de suspensão da exigibilidade (nProcesso).<br>
   * Tamanho 1-30.
   *
   * @return the iD: U16<br>
   *         Número do processo judicial ou administrativo de suspensão da exigibilidade (nProcesso)
   */
  public String getNProcesso() {
    return nProcesso;
  }

  /**
   * # iD: U16<br>
   * Número do processo judicial ou administrativo de suspensão da exigibilidade (nProcesso).<br>
   * Tamanho 1-30.
   *
   * @param nProcesso the new iD: U16<br>
   *          Número do processo judicial ou administrativo de suspensão da exigibilidade (nProcesso)
   */
  public void setNProcesso(String nProcesso) {
    this.nProcesso = nProcesso;
  }

  /**
   * # iD: U17<br>
   * Indicador de incentivo fiscal (indIncentivo).<br>
   * Valores conforme {@link SEFAZ_indIncentivo}.
   *
   * @return the iD: U17<br>
   *         Indicador de incentivo fiscal (indIncentivo)
   */
  public SEFAZ_indIncentivo getIndIncentivo() {
    return indIncentivo;
  }

  /**
   * # iD: U17<br>
   * Indicador de incentivo fiscal (indIncentivo).<br>
   * Valores conforme {@link SEFAZ_indIncentivo}.
   *
   * @param indIncentivo the new iD: U17<br>
   *          Indicador de incentivo fiscal (indIncentivo)
   */
  public void setIndIncentivo(SEFAZ_indIncentivo indIncentivo) {
    this.indIncentivo = indIncentivo;
  }

}
