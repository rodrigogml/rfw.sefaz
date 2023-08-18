package br.eng.rodrigogml.rfw.sefaz.vos;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "PIS" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class PISVO extends RFWVO {

  private static final long serialVersionUID = 7652424072280408245L;

  /**
   * Q06 CST Código de Situação Tributária do PIS E Q02 N 1-1 2<br>
   * <li>01=Operação Tributável (base de cálculo = valor da operação alíquota normal (cumulativo/não cumulativo));
   * <li>02=Operação Tributável (base de cálculo = valor da operação (alíquota diferenciada));<br>
   * <br>
   * Q06 CST Código de Situação Tributária do PIS E Q03 N 1-1 2<br>
   * <li>03=Operação Tributável (base de cálculo = = quantidade vendida x alíquota por unidade de produto);<br>
   * <br>
   * Q06 CST Código de Situação Tributária do PIS E Q04 N 1-1 2<br>
   * <li>04=Operação Tributável (tributação monofásica (alíquota zero));
   * <li>05=Operação Tributável (Substituição Tributária);
   * <li>06=Operação Tributável (alíquota zero);
   * <li>07=Operação Isenta da Contribuição;
   * <li>08=Operação Sem Incidência da Contribuição;
   * <li>09=Operação com Suspensão da Contribuição;<br>
   * <br>
   * Q06 CST Código de Situação Tributária do PIS E Q05 N 1-1 2<br>
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
   * Q07 vBC Valor da Base de Cálculo do PIS E Q02 N 1-1 13v2<br>
   * <br>
   * Q07 vBC Valor da Base de Cálculo do PIS E Q06.1 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor da Base de Cálculo", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = false)
  private BigDecimal vbc = null;

  /**
   * Q08 pPIS Alíquota do PIS (em percentual) E Q02 N 1-1 3v2-4<br>
   * <br>
   * Q08 pPIS Alíquota do PIS (em percentual) E Q06.1 N 1-1 3v2-4
   */
  @RFWMetaBigDecimalField(caption = "Alíquota(%)", minValue = "0", maxValue = "999.9999", scale = 0, scaleMax = 4, required = false)
  private BigDecimal ppis = null;

  /**
   * Q09 vPIS Valor do PIS E Q02 N 1-1 13v2 <br>
   * <br>
   * Q09 vPIS Valor do PIS E Q03 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = false)
  private BigDecimal vpis = null;

  /**
   * Q10 qBCProd Quantidade Vendida E Q03 N 1-1 12v0-4
   */
  @RFWMetaBigDecimalField(caption = "Quantidade Vendida", minValue = "0", maxValue = "999999999999.9999", scale = 0, scaleMax = 4, required = false)
  private BigDecimal qbcProd = null;

  /**
   * Q11 vAliqProd Alíquota do PIS (em reais) E Q03 N 1-1 11v0-4
   */
  @RFWMetaBigDecimalField(caption = "Alíquota ($)", minValue = "0", maxValue = "99999999999.9999", scale = 0, scaleMax = 4, required = false)
  private BigDecimal valiqProd = null;

  /**
   * # q06 CST Código de Situação Tributária do PIS E Q02 N 1-1 2<br>
   * <li>01=Operação Tributável (base de cálculo = valor da operação alíquota normal (cumulativo/não cumulativo));
   * <li>02=Operação Tributável (base de cálculo = valor da operação (alíquota diferenciada));<br>
   * <br>
   * Q06 CST Código de Situação Tributária do PIS E Q03 N 1-1 2<br>
   * <li>03=Operação Tributável (base de cálculo = = quantidade vendida x alíquota por unidade de produto);<br>
   * <br>
   * Q06 CST Código de Situação Tributária do PIS E Q04 N 1-1 2<br>
   * <li>04=Operação Tributável (tributação monofásica (alíquota zero));
   * <li>05=Operação Tributável (Substituição Tributária);
   * <li>06=Operação Tributável (alíquota zero);
   * <li>07=Operação Isenta da Contribuição;
   * <li>08=Operação Sem Incidência da Contribuição;
   * <li>09=Operação com Suspensão da Contribuição;<br>
   * <br>
   * Q06 CST Código de Situação Tributária do PIS E Q05 N 1-1 2<br>
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
   * @return # q06 CST Código de Situação Tributária do PIS E Q02 N 1-1 2<br>
   *         <li>01=Operação Tributável (base de cálculo = valor da operação alíquota normal (cumulativo/não cumulativo));
   *         <li>02=Operação Tributável (base de cálculo = valor da operação (alíquota diferenciada));<br>
   *         <br>
   *         Q06 CST Código de Situação Tributária do PIS E Q03 N 1-1 2<br>
   *         <li>03=Operação Tributável (base de cálculo = = quantidade vendida x alíquota por unidade de produto);<br>
   *         <br>
   *         Q06 CST Código de Situação Tributária do PIS E Q04 N 1-1 2<br>
   *         <li>04=Operação Tributável (tributação monofásica (alíquota zero));
   *         <li>05=Operação Tributável (Substituição Tributária);
   *         <li>06=Operação Tributável (alíquota zero);
   *         <li>07=Operação Isenta da Contribuição;
   *         <li>08=Operação Sem Incidência da Contribuição;
   *         <li>09=Operação com Suspensão da Contribuição;<br>
   *         <br>
   *         Q06 CST Código de Situação Tributária do PIS E Q05 N 1-1 2<br>
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
   * # q06 CST Código de Situação Tributária do PIS E Q02 N 1-1 2<br>
   * <li>01=Operação Tributável (base de cálculo = valor da operação alíquota normal (cumulativo/não cumulativo));
   * <li>02=Operação Tributável (base de cálculo = valor da operação (alíquota diferenciada));<br>
   * <br>
   * Q06 CST Código de Situação Tributária do PIS E Q03 N 1-1 2<br>
   * <li>03=Operação Tributável (base de cálculo = = quantidade vendida x alíquota por unidade de produto);<br>
   * <br>
   * Q06 CST Código de Situação Tributária do PIS E Q04 N 1-1 2<br>
   * <li>04=Operação Tributável (tributação monofásica (alíquota zero));
   * <li>05=Operação Tributável (Substituição Tributária);
   * <li>06=Operação Tributável (alíquota zero);
   * <li>07=Operação Isenta da Contribuição;
   * <li>08=Operação Sem Incidência da Contribuição;
   * <li>09=Operação com Suspensão da Contribuição;<br>
   * <br>
   * Q06 CST Código de Situação Tributária do PIS E Q05 N 1-1 2<br>
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
   * @param cst # q06 CST Código de Situação Tributária do PIS E Q02 N 1-1 2<br>
   *          <li>01=Operação Tributável (base de cálculo = valor da operação alíquota normal (cumulativo/não cumulativo));
   *          <li>02=Operação Tributável (base de cálculo = valor da operação (alíquota diferenciada));<br>
   *          <br>
   *          Q06 CST Código de Situação Tributária do PIS E Q03 N 1-1 2<br>
   *          <li>03=Operação Tributável (base de cálculo = = quantidade vendida x alíquota por unidade de produto);<br>
   *          <br>
   *          Q06 CST Código de Situação Tributária do PIS E Q04 N 1-1 2<br>
   *          <li>04=Operação Tributável (tributação monofásica (alíquota zero));
   *          <li>05=Operação Tributável (Substituição Tributária);
   *          <li>06=Operação Tributável (alíquota zero);
   *          <li>07=Operação Isenta da Contribuição;
   *          <li>08=Operação Sem Incidência da Contribuição;
   *          <li>09=Operação com Suspensão da Contribuição;<br>
   *          <br>
   *          Q06 CST Código de Situação Tributária do PIS E Q05 N 1-1 2<br>
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
   * # q07 vBC Valor da Base de Cálculo do PIS E Q02 N 1-1 13v2<br>
   * <br>
   * Q07 vBC Valor da Base de Cálculo do PIS E Q06.1 N 1-1 13v2.
   *
   * @return # q07 vBC Valor da Base de Cálculo do PIS E Q02 N 1-1 13v2<br>
   *         <br>
   *         Q07 vBC Valor da Base de Cálculo do PIS E Q06
   */
  public BigDecimal getVbc() {
    return vbc;
  }

  /**
   * # q07 vBC Valor da Base de Cálculo do PIS E Q02 N 1-1 13v2<br>
   * <br>
   * Q07 vBC Valor da Base de Cálculo do PIS E Q06.1 N 1-1 13v2.
   *
   * @param vbc # q07 vBC Valor da Base de Cálculo do PIS E Q02 N 1-1 13v2<br>
   *          <br>
   *          Q07 vBC Valor da Base de Cálculo do PIS E Q06
   */
  public void setVbc(BigDecimal vbc) {
    this.vbc = vbc;
  }

  /**
   * # q08 pPIS Alíquota do PIS (em percentual) E Q02 N 1-1 3v2-4<br>
   * <br>
   * Q08 pPIS Alíquota do PIS (em percentual) E Q06.1 N 1-1 3v2-4.
   *
   * @return # q08 pPIS Alíquota do PIS (em percentual) E Q02 N 1-1 3v2-4<br>
   *         <br>
   *         Q08 pPIS Alíquota do PIS (em percentual) E Q06
   */
  public BigDecimal getPpis() {
    return ppis;
  }

  /**
   * # q08 pPIS Alíquota do PIS (em percentual) E Q02 N 1-1 3v2-4<br>
   * <br>
   * Q08 pPIS Alíquota do PIS (em percentual) E Q06.1 N 1-1 3v2-4.
   *
   * @param ppis # q08 pPIS Alíquota do PIS (em percentual) E Q02 N 1-1 3v2-4<br>
   *          <br>
   *          Q08 pPIS Alíquota do PIS (em percentual) E Q06
   */
  public void setPpis(BigDecimal ppis) {
    this.ppis = ppis;
  }

  /**
   * # q09 vPIS Valor do PIS E Q02 N 1-1 13v2 <br>
   * <br>
   * Q09 vPIS Valor do PIS E Q03 N 1-1 13v2.
   *
   * @return # q09 vPIS Valor do PIS E Q02 N 1-1 13v2 <br>
   *         <br>
   *         Q09 vPIS Valor do PIS E Q03 N 1-1 13v2
   */
  public BigDecimal getVpis() {
    return vpis;
  }

  /**
   * # q09 vPIS Valor do PIS E Q02 N 1-1 13v2 <br>
   * <br>
   * Q09 vPIS Valor do PIS E Q03 N 1-1 13v2.
   *
   * @param vpis # q09 vPIS Valor do PIS E Q02 N 1-1 13v2 <br>
   *          <br>
   *          Q09 vPIS Valor do PIS E Q03 N 1-1 13v2
   */
  public void setVpis(BigDecimal vpis) {
    this.vpis = vpis;
  }

  /**
   * # q10 qBCProd Quantidade Vendida E Q03 N 1-1 12v0-4.
   *
   * @return # q10 qBCProd Quantidade Vendida E Q03 N 1-1 12v0-4
   */
  public BigDecimal getQbcProd() {
    return qbcProd;
  }

  /**
   * # q10 qBCProd Quantidade Vendida E Q03 N 1-1 12v0-4.
   *
   * @param qbcProd # q10 qBCProd Quantidade Vendida E Q03 N 1-1 12v0-4
   */
  public void setQbcProd(BigDecimal qbcProd) {
    this.qbcProd = qbcProd;
  }

  /**
   * # q11 vAliqProd Alíquota do PIS (em reais) E Q03 N 1-1 11v0-4.
   *
   * @return # q11 vAliqProd Alíquota do PIS (em reais) E Q03 N 1-1 11v0-4
   */
  public BigDecimal getValiqProd() {
    return valiqProd;
  }

  /**
   * # q11 vAliqProd Alíquota do PIS (em reais) E Q03 N 1-1 11v0-4.
   *
   * @param valiqProd # q11 vAliqProd Alíquota do PIS (em reais) E Q03 N 1-1 11v0-4
   */
  public void setValiqProd(BigDecimal valiqProd) {
    this.valiqProd = valiqProd;
  }

}
