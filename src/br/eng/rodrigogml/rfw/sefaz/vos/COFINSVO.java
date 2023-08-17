package br.eng.rodrigogml.rfw.sefaz.vos;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "COFINS" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class COFINSVO extends RFWVO {

  private static final long serialVersionUID = 7652424072280408245L;

  /**
   * S06 CST Código de Situação Tributária da COFINS E S02 N 1-1 2<br>
   * <li>01=Operação Tributável (base de cálculo = valor da operação alíquota normal (cumulativo/não cumulativo));
   * <li>02=Operação Tributável (base de cálculo = valor da operação (alíquota diferenciada)); <br>
   * <Br>
   * S06 CST Código de Situação Tributária da COFINS E S03 N 1-1 2<br>
   * <li>03=Operação Tributável (base de cálculo = quantidade vendida x alíquota por unidade de produto); <br>
   * <br>
   * S06 CST Código de Situação Tributária da COFINS E S04 N 1-1 2<br>
   * <li>04=Operação Tributável (tributação monofásica, alíquota zero);
   * <li>05=Operação Tributável (Substituição Tributária);
   * <li>06=Operação Tributável (alíquota zero);
   * <li>07=Operação Isenta da Contribuição;
   * <li>08=Operação Sem Incidência da Contribuição;
   * <li>09=Operação com Suspensão da Contribuição; S06 CST Código de Situação Tributária da COFINS E S05 N 1-1 2<br>
   * <li>49=Outras Operações de Saída;
   * <li>50=Operação com Direito a Crédito - Vinculada Exclusivamente a Receita Tributada no Mercado Interno;
   * <li>51=Operação com Direito a Crédito - Vinculada Exclusivamente a Receita Não Tributada no Mercado Interno;
   * <li>52=Operação com Direito a Crédito – Vinculada Exclusivamente a Receita de Exportação;
   * <li>53=Operação com Direito a Crédito - Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno;
   * <li>54=Operação com Direito a Crédito - Vinculada a Receitas Tributadas no Mercado Interno e de Exportação;
   * <li>55=Operação com Direito a Crédito - Vinculada a Receitas Não-Tributadas no Mercado Interno e de Exportação;
   * <li>56=Operação com Direito a Crédito - Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno, e de Exportação;
   * <li>60=Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita Tributada no Mercado Interno;
   * <li>61=Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita Não-Tributada no Mercado Interno;
   * <li>62=Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita de Exportação;
   * <li>63=Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno;
   * <li>64=Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas no Mercado Interno e de Exportação;
   * <li>65=Crédito Presumido - Operação de Aquisição Vinculada a Receitas Não-Tributadas no Mercado Interno e de Exportação;
   * <li>66=Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno, e de Exportação;
   * <li>67=Crédito Presumido - Outras Operações;
   * <li>70=Operação de Aquisição sem Direito a Crédito;
   * <li>71=Operação de Aquisição com Isenção;
   * <li>72=Operação de Aquisição com Suspensão;
   * <li>73=Operação de Aquisição a Alíquota Zero;
   * <li>74=Operação de Aquisição; sem Incidência da Contribuição;
   * <li>75=Operação de Aquisição por Substituição Tributária;
   * <li>98=Outras Operações de Entrada;
   * <li>99=Outras Operações;
   */
  @RFWMetaStringField(caption = "CST", minlength = 2, maxLength = 2, required = true, pattern = "^(01|02|03|04|05|06|07|08|09|49|50|51|52|53|54|55|56|60|61|62|63|64|65|66|67|70|71|72|73|74|75|98|99)$")
  private String cst = null;

  /**
   * S07 vBC Valor da Base de Cálculo da COFINS E S02 N 1-1 13v2 <Br>
   * <Br>
   * S07 vBC Valor da Base de Cálculo da COFINS E S06.1 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor da Base de Cálculo", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vbc = null;

  /**
   * S08 pCOFINS Alíquota da COFINS (em percentual) E S02 N 1-1 3v2-4 <Br>
   * <Br>
   * S08 pCOFINS Alíquota da COFINS (em percentual) E S06.1 N 1-1 3v2-4
   */
  @RFWMetaBigDecimalField(caption = "Alíquota(%)", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = false)
  private BigDecimal pcofins = null;

  /**
   * vCOFINS Valor da COFINS E S02 N 1-1 13v2 <br>
   * <Br>
   * vCOFINS Valor da COFINS E S03 N 1-1 13v2 <br>
   * <Br>
   * S11 vCOFINS Valor da COFINS E S05 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vcofins = null;

  /**
   * S09 qBCProd Quantidade Vendida E S03 N 1-1 12v0-4 <br>
   * <Br>
   * S09 qBCProd Quantidade Vendida E S08.1 N 1-1 12v0-4
   */
  @RFWMetaBigDecimalField(caption = "Quantidade Vendida", minValue = "0", maxValue = "999999999999.9999", scale = 0, scaleMax = 4, required = false)
  private BigDecimal qbcProd = null;

  /**
   * vAliqProd Alíquota da COFINS (em reais) E S03 N 1-1 11v0-4 <br>
   * <Br>
   * S10 vAliqProd Alíquota da COFINS (em reais) E S08.1 N 1-1 11v0-4
   */
  @RFWMetaBigDecimalField(caption = "Alíquota ($)", minValue = "0", maxValue = "99999999999.9999", scale = 0, scaleMax = 4, required = false)
  private BigDecimal valiqProd = null;

  /**
   * # s06 CST Código de Situação Tributária da COFINS E S02 N 1-1 2<br>
   * <li>01=Operação Tributável (base de cálculo = valor da operação alíquota normal (cumulativo/não cumulativo));
   * <li>02=Operação Tributável (base de cálculo = valor da operação (alíquota diferenciada)); <br>
   * <Br>
   * S06 CST Código de Situação Tributária da COFINS E S03 N 1-1 2<br>
   * <li>03=Operação Tributável (base de cálculo = quantidade vendida x alíquota por unidade de produto); <br>
   * <br>
   * S06 CST Código de Situação Tributária da COFINS E S04 N 1-1 2<br>
   * <li>04=Operação Tributável (tributação monofásica, alíquota zero);
   * <li>05=Operação Tributável (Substituição Tributária);
   * <li>06=Operação Tributável (alíquota zero);
   * <li>07=Operação Isenta da Contribuição;
   * <li>08=Operação Sem Incidência da Contribuição;
   * <li>09=Operação com Suspensão da Contribuição; S06 CST Código de Situação Tributária da COFINS E S05 N 1-1 2<br>
   * <li>49=Outras Operações de Saída;
   * <li>50=Operação com Direito a Crédito - Vinculada Exclusivamente a Receita Tributada no Mercado Interno;
   * <li>51=Operação com Direito a Crédito - Vinculada Exclusivamente a Receita Não Tributada no Mercado Interno;
   * <li>52=Operação com Direito a Crédito – Vinculada Exclusivamente a Receita de Exportação;
   * <li>53=Operação com Direito a Crédito - Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno;
   * <li>54=Operação com Direito a Crédito - Vinculada a Receitas Tributadas no Mercado Interno e de Exportação;
   * <li>55=Operação com Direito a Crédito - Vinculada a Receitas Não-Tributadas no Mercado Interno e de Exportação;
   * <li>56=Operação com Direito a Crédito - Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno, e de Exportação;
   * <li>60=Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita Tributada no Mercado Interno;
   * <li>61=Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita Não-Tributada no Mercado Interno;
   * <li>62=Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita de Exportação;
   * <li>63=Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno;
   * <li>64=Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas no Mercado Interno e de Exportação;
   * <li>65=Crédito Presumido - Operação de Aquisição Vinculada a Receitas Não-Tributadas no Mercado Interno e de Exportação;
   * <li>66=Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno, e de Exportação;
   * <li>67=Crédito Presumido - Outras Operações;
   * <li>70=Operação de Aquisição sem Direito a Crédito;
   * <li>71=Operação de Aquisição com Isenção;
   * <li>72=Operação de Aquisição com Suspensão;
   * <li>73=Operação de Aquisição a Alíquota Zero;
   * <li>74=Operação de Aquisição; sem Incidência da Contribuição;
   * <li>75=Operação de Aquisição por Substituição Tributária;
   * <li>98=Outras Operações de Entrada;
   * <li>99=Outras Operações;.
   *
   * @return # s06 CST Código de Situação Tributária da COFINS E S02 N 1-1 2<br>
   *         <li>01=Operação Tributável (base de cálculo = valor da operação alíquota normal (cumulativo/não cumulativo));
   *         <li>02=Operação Tributável (base de cálculo = valor da operação (alíquota diferenciada)); <br>
   *         <Br>
   *         S06 CST Código de Situação Tributária da COFINS E S03 N 1-1 2<br>
   *         <li>03=Operação Tributável (base de cálculo = quantidade vendida x alíquota por unidade de produto); <br>
   *         <br>
   *         S06 CST Código de Situação Tributária da COFINS E S04 N 1-1 2<br>
   *         <li>04=Operação Tributável (tributação monofásica, alíquota zero);
   *         <li>05=Operação Tributável (Substituição Tributária);
   *         <li>06=Operação Tributável (alíquota zero);
   *         <li>07=Operação Isenta da Contribuição;
   *         <li>08=Operação Sem Incidência da Contribuição;
   *         <li>09=Operação com Suspensão da Contribuição; S06 CST Código de Situação Tributária da COFINS E S05 N 1-1 2<br>
   *         <li>49=Outras Operações de Saída;
   *         <li>50=Operação com Direito a Crédito - Vinculada Exclusivamente a Receita Tributada no Mercado Interno;
   *         <li>51=Operação com Direito a Crédito - Vinculada Exclusivamente a Receita Não Tributada no Mercado Interno;
   *         <li>52=Operação com Direito a Crédito – Vinculada Exclusivamente a Receita de Exportação;
   *         <li>53=Operação com Direito a Crédito - Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno;
   *         <li>54=Operação com Direito a Crédito - Vinculada a Receitas Tributadas no Mercado Interno e de Exportação;
   *         <li>55=Operação com Direito a Crédito - Vinculada a Receitas Não-Tributadas no Mercado Interno e de Exportação;
   *         <li>56=Operação com Direito a Crédito - Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno, e de Exportação;
   *         <li>60=Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita Tributada no Mercado Interno;
   *         <li>61=Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita Não-Tributada no Mercado Interno;
   *         <li>62=Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita de Exportação;
   *         <li>63=Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno;
   *         <li>64=Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas no Mercado Interno e de Exportação;
   *         <li>65=Crédito Presumido - Operação de Aquisição Vinculada a Receitas Não-Tributadas no Mercado Interno e de Exportação;
   *         <li>66=Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno, e de Exportação;
   *         <li>67=Crédito Presumido - Outras Operações;
   *         <li>70=Operação de Aquisição sem Direito a Crédito;
   *         <li>71=Operação de Aquisição com Isenção;
   *         <li>72=Operação de Aquisição com Suspensão;
   *         <li>73=Operação de Aquisição a Alíquota Zero;
   *         <li>74=Operação de Aquisição; sem Incidência da Contribuição;
   *         <li>75=Operação de Aquisição por Substituição Tributária;
   *         <li>98=Outras Operações de Entrada;
   *         <li>99=Outras Operações;
   */
  public String getCst() {
    return cst;
  }

  /**
   * # s06 CST Código de Situação Tributária da COFINS E S02 N 1-1 2<br>
   * <li>01=Operação Tributável (base de cálculo = valor da operação alíquota normal (cumulativo/não cumulativo));
   * <li>02=Operação Tributável (base de cálculo = valor da operação (alíquota diferenciada)); <br>
   * <Br>
   * S06 CST Código de Situação Tributária da COFINS E S03 N 1-1 2<br>
   * <li>03=Operação Tributável (base de cálculo = quantidade vendida x alíquota por unidade de produto); <br>
   * <br>
   * S06 CST Código de Situação Tributária da COFINS E S04 N 1-1 2<br>
   * <li>04=Operação Tributável (tributação monofásica, alíquota zero);
   * <li>05=Operação Tributável (Substituição Tributária);
   * <li>06=Operação Tributável (alíquota zero);
   * <li>07=Operação Isenta da Contribuição;
   * <li>08=Operação Sem Incidência da Contribuição;
   * <li>09=Operação com Suspensão da Contribuição; S06 CST Código de Situação Tributária da COFINS E S05 N 1-1 2<br>
   * <li>49=Outras Operações de Saída;
   * <li>50=Operação com Direito a Crédito - Vinculada Exclusivamente a Receita Tributada no Mercado Interno;
   * <li>51=Operação com Direito a Crédito - Vinculada Exclusivamente a Receita Não Tributada no Mercado Interno;
   * <li>52=Operação com Direito a Crédito – Vinculada Exclusivamente a Receita de Exportação;
   * <li>53=Operação com Direito a Crédito - Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno;
   * <li>54=Operação com Direito a Crédito - Vinculada a Receitas Tributadas no Mercado Interno e de Exportação;
   * <li>55=Operação com Direito a Crédito - Vinculada a Receitas Não-Tributadas no Mercado Interno e de Exportação;
   * <li>56=Operação com Direito a Crédito - Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno, e de Exportação;
   * <li>60=Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita Tributada no Mercado Interno;
   * <li>61=Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita Não-Tributada no Mercado Interno;
   * <li>62=Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita de Exportação;
   * <li>63=Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno;
   * <li>64=Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas no Mercado Interno e de Exportação;
   * <li>65=Crédito Presumido - Operação de Aquisição Vinculada a Receitas Não-Tributadas no Mercado Interno e de Exportação;
   * <li>66=Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno, e de Exportação;
   * <li>67=Crédito Presumido - Outras Operações;
   * <li>70=Operação de Aquisição sem Direito a Crédito;
   * <li>71=Operação de Aquisição com Isenção;
   * <li>72=Operação de Aquisição com Suspensão;
   * <li>73=Operação de Aquisição a Alíquota Zero;
   * <li>74=Operação de Aquisição; sem Incidência da Contribuição;
   * <li>75=Operação de Aquisição por Substituição Tributária;
   * <li>98=Outras Operações de Entrada;
   * <li>99=Outras Operações;.
   *
   * @param cst # s06 CST Código de Situação Tributária da COFINS E S02 N 1-1 2<br>
   *          <li>01=Operação Tributável (base de cálculo = valor da operação alíquota normal (cumulativo/não cumulativo));
   *          <li>02=Operação Tributável (base de cálculo = valor da operação (alíquota diferenciada)); <br>
   *          <Br>
   *          S06 CST Código de Situação Tributária da COFINS E S03 N 1-1 2<br>
   *          <li>03=Operação Tributável (base de cálculo = quantidade vendida x alíquota por unidade de produto); <br>
   *          <br>
   *          S06 CST Código de Situação Tributária da COFINS E S04 N 1-1 2<br>
   *          <li>04=Operação Tributável (tributação monofásica, alíquota zero);
   *          <li>05=Operação Tributável (Substituição Tributária);
   *          <li>06=Operação Tributável (alíquota zero);
   *          <li>07=Operação Isenta da Contribuição;
   *          <li>08=Operação Sem Incidência da Contribuição;
   *          <li>09=Operação com Suspensão da Contribuição; S06 CST Código de Situação Tributária da COFINS E S05 N 1-1 2<br>
   *          <li>49=Outras Operações de Saída;
   *          <li>50=Operação com Direito a Crédito - Vinculada Exclusivamente a Receita Tributada no Mercado Interno;
   *          <li>51=Operação com Direito a Crédito - Vinculada Exclusivamente a Receita Não Tributada no Mercado Interno;
   *          <li>52=Operação com Direito a Crédito – Vinculada Exclusivamente a Receita de Exportação;
   *          <li>53=Operação com Direito a Crédito - Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno;
   *          <li>54=Operação com Direito a Crédito - Vinculada a Receitas Tributadas no Mercado Interno e de Exportação;
   *          <li>55=Operação com Direito a Crédito - Vinculada a Receitas Não-Tributadas no Mercado Interno e de Exportação;
   *          <li>56=Operação com Direito a Crédito - Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno, e de Exportação;
   *          <li>60=Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita Tributada no Mercado Interno;
   *          <li>61=Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita Não-Tributada no Mercado Interno;
   *          <li>62=Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita de Exportação;
   *          <li>63=Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno;
   *          <li>64=Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas no Mercado Interno e de Exportação;
   *          <li>65=Crédito Presumido - Operação de Aquisição Vinculada a Receitas Não-Tributadas no Mercado Interno e de Exportação;
   *          <li>66=Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno, e de Exportação;
   *          <li>67=Crédito Presumido - Outras Operações;
   *          <li>70=Operação de Aquisição sem Direito a Crédito;
   *          <li>71=Operação de Aquisição com Isenção;
   *          <li>72=Operação de Aquisição com Suspensão;
   *          <li>73=Operação de Aquisição a Alíquota Zero;
   *          <li>74=Operação de Aquisição; sem Incidência da Contribuição;
   *          <li>75=Operação de Aquisição por Substituição Tributária;
   *          <li>98=Outras Operações de Entrada;
   *          <li>99=Outras Operações;
   */
  public void setCst(String cst) {
    this.cst = cst;
  }

  /**
   * # s07 vBC Valor da Base de Cálculo da COFINS E S02 N 1-1 13v2 <Br>
   * <Br>
   * S07 vBC Valor da Base de Cálculo da COFINS E S06.1 N 1-1 13v2.
   *
   * @return # s07 vBC Valor da Base de Cálculo da COFINS E S02 N 1-1 13v2 <Br>
   *         <Br>
   *         S07 vBC Valor da Base de Cálculo da COFINS E S06
   */
  public BigDecimal getVbc() {
    return vbc;
  }

  /**
   * # s07 vBC Valor da Base de Cálculo da COFINS E S02 N 1-1 13v2 <Br>
   * <Br>
   * S07 vBC Valor da Base de Cálculo da COFINS E S06.1 N 1-1 13v2.
   *
   * @param vbc # s07 vBC Valor da Base de Cálculo da COFINS E S02 N 1-1 13v2 <Br>
   *          <Br>
   *          S07 vBC Valor da Base de Cálculo da COFINS E S06
   */
  public void setVbc(BigDecimal vbc) {
    this.vbc = vbc;
  }

  /**
   * # s08 pCOFINS Alíquota da COFINS (em percentual) E S02 N 1-1 3v2-4 <Br>
   * <Br>
   * S08 pCOFINS Alíquota da COFINS (em percentual) E S06.1 N 1-1 3v2-4.
   *
   * @return # s08 pCOFINS Alíquota da COFINS (em percentual) E S02 N 1-1 3v2-4 <Br>
   *         <Br>
   *         S08 pCOFINS Alíquota da COFINS (em percentual) E S06
   */
  public BigDecimal getPcofins() {
    return pcofins;
  }

  /**
   * # s08 pCOFINS Alíquota da COFINS (em percentual) E S02 N 1-1 3v2-4 <Br>
   * <Br>
   * S08 pCOFINS Alíquota da COFINS (em percentual) E S06.1 N 1-1 3v2-4.
   *
   * @param pcofins # s08 pCOFINS Alíquota da COFINS (em percentual) E S02 N 1-1 3v2-4 <Br>
   *          <Br>
   *          S08 pCOFINS Alíquota da COFINS (em percentual) E S06
   */
  public void setPcofins(BigDecimal pcofins) {
    this.pcofins = pcofins;
  }

  /**
   * # vCOFINS Valor da COFINS E S02 N 1-1 13v2 <br>
   * <Br>
   * vCOFINS Valor da COFINS E S03 N 1-1 13v2 <br>
   * <Br>
   * S11 vCOFINS Valor da COFINS E S05 N 1-1 13v2.
   *
   * @return # vCOFINS Valor da COFINS E S02 N 1-1 13v2 <br>
   *         <Br>
   *         vCOFINS Valor da COFINS E S03 N 1-1 13v2 <br>
   *         <Br>
   *         S11 vCOFINS Valor da COFINS E S05 N 1-1 13v2
   */
  public BigDecimal getVcofins() {
    return vcofins;
  }

  /**
   * # vCOFINS Valor da COFINS E S02 N 1-1 13v2 <br>
   * <Br>
   * vCOFINS Valor da COFINS E S03 N 1-1 13v2 <br>
   * <Br>
   * S11 vCOFINS Valor da COFINS E S05 N 1-1 13v2.
   *
   * @param vcofins # vCOFINS Valor da COFINS E S02 N 1-1 13v2 <br>
   *          <Br>
   *          vCOFINS Valor da COFINS E S03 N 1-1 13v2 <br>
   *          <Br>
   *          S11 vCOFINS Valor da COFINS E S05 N 1-1 13v2
   */
  public void setVcofins(BigDecimal vcofins) {
    this.vcofins = vcofins;
  }

  /**
   * # s09 qBCProd Quantidade Vendida E S03 N 1-1 12v0-4 <br>
   * <Br>
   * S09 qBCProd Quantidade Vendida E S08.1 N 1-1 12v0-4.
   *
   * @return # s09 qBCProd Quantidade Vendida E S03 N 1-1 12v0-4 <br>
   *         <Br>
   *         S09 qBCProd Quantidade Vendida E S08
   */
  public BigDecimal getQbcProd() {
    return qbcProd;
  }

  /**
   * # s09 qBCProd Quantidade Vendida E S03 N 1-1 12v0-4 <br>
   * <Br>
   * S09 qBCProd Quantidade Vendida E S08.1 N 1-1 12v0-4.
   *
   * @param qbcProd # s09 qBCProd Quantidade Vendida E S03 N 1-1 12v0-4 <br>
   *          <Br>
   *          S09 qBCProd Quantidade Vendida E S08
   */
  public void setQbcProd(BigDecimal qbcProd) {
    this.qbcProd = qbcProd;
  }

  /**
   * # vAliqProd Alíquota da COFINS (em reais) E S03 N 1-1 11v0-4 <br>
   * <Br>
   * S10 vAliqProd Alíquota da COFINS (em reais) E S08.1 N 1-1 11v0-4.
   *
   * @return # vAliqProd Alíquota da COFINS (em reais) E S03 N 1-1 11v0-4 <br>
   *         <Br>
   *         S10 vAliqProd Alíquota da COFINS (em reais) E S08
   */
  public BigDecimal getValiqProd() {
    return valiqProd;
  }

  /**
   * # vAliqProd Alíquota da COFINS (em reais) E S03 N 1-1 11v0-4 <br>
   * <Br>
   * S10 vAliqProd Alíquota da COFINS (em reais) E S08.1 N 1-1 11v0-4.
   *
   * @param valiqProd # vAliqProd Alíquota da COFINS (em reais) E S03 N 1-1 11v0-4 <br>
   *          <Br>
   *          S10 vAliqProd Alíquota da COFINS (em reais) E S08
   */
  public void setValiqProd(BigDecimal valiqProd) {
    this.valiqProd = valiqProd;
  }

}