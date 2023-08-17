package br.eng.rodrigogml.rfw.sefaz.vos;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "COFINS" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integra��o com o framework, pertindo a valida��o e at� a persist�ncia se o sistema assim desejar. N�o h� preocupa��o de gerar JavaDOC nestas classes pois ela deve representar exatamente a documenta��o da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Valida��o da NF-e.
 */
public class COFINSVO extends RFWVO {

  private static final long serialVersionUID = 7652424072280408245L;

  /**
   * S06 CST C�digo de Situa��o Tribut�ria da COFINS E S02 N 1-1 2<br>
   * <li>01=Opera��o Tribut�vel (base de c�lculo = valor da opera��o al�quota normal (cumulativo/n�o cumulativo));
   * <li>02=Opera��o Tribut�vel (base de c�lculo = valor da opera��o (al�quota diferenciada)); <br>
   * <Br>
   * S06 CST C�digo de Situa��o Tribut�ria da COFINS E S03 N 1-1 2<br>
   * <li>03=Opera��o Tribut�vel (base de c�lculo = quantidade vendida x al�quota por unidade de produto); <br>
   * <br>
   * S06 CST C�digo de Situa��o Tribut�ria da COFINS E S04 N 1-1 2<br>
   * <li>04=Opera��o Tribut�vel (tributa��o monof�sica, al�quota zero);
   * <li>05=Opera��o Tribut�vel (Substitui��o Tribut�ria);
   * <li>06=Opera��o Tribut�vel (al�quota zero);
   * <li>07=Opera��o Isenta da Contribui��o;
   * <li>08=Opera��o Sem Incid�ncia da Contribui��o;
   * <li>09=Opera��o com Suspens�o da Contribui��o; S06 CST C�digo de Situa��o Tribut�ria da COFINS E S05 N 1-1 2<br>
   * <li>49=Outras Opera��es de Sa�da;
   * <li>50=Opera��o com Direito a Cr�dito - Vinculada Exclusivamente a Receita Tributada no Mercado Interno;
   * <li>51=Opera��o com Direito a Cr�dito - Vinculada Exclusivamente a Receita N�o Tributada no Mercado Interno;
   * <li>52=Opera��o com Direito a Cr�dito � Vinculada Exclusivamente a Receita de Exporta��o;
   * <li>53=Opera��o com Direito a Cr�dito - Vinculada a Receitas Tributadas e N�o-Tributadas no Mercado Interno;
   * <li>54=Opera��o com Direito a Cr�dito - Vinculada a Receitas Tributadas no Mercado Interno e de Exporta��o;
   * <li>55=Opera��o com Direito a Cr�dito - Vinculada a Receitas N�o-Tributadas no Mercado Interno e de Exporta��o;
   * <li>56=Opera��o com Direito a Cr�dito - Vinculada a Receitas Tributadas e N�o-Tributadas no Mercado Interno, e de Exporta��o;
   * <li>60=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada Exclusivamente a Receita Tributada no Mercado Interno;
   * <li>61=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada Exclusivamente a Receita N�o-Tributada no Mercado Interno;
   * <li>62=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada Exclusivamente a Receita de Exporta��o;
   * <li>63=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada a Receitas Tributadas e N�o-Tributadas no Mercado Interno;
   * <li>64=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada a Receitas Tributadas no Mercado Interno e de Exporta��o;
   * <li>65=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada a Receitas N�o-Tributadas no Mercado Interno e de Exporta��o;
   * <li>66=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada a Receitas Tributadas e N�o-Tributadas no Mercado Interno, e de Exporta��o;
   * <li>67=Cr�dito Presumido - Outras Opera��es;
   * <li>70=Opera��o de Aquisi��o sem Direito a Cr�dito;
   * <li>71=Opera��o de Aquisi��o com Isen��o;
   * <li>72=Opera��o de Aquisi��o com Suspens�o;
   * <li>73=Opera��o de Aquisi��o a Al�quota Zero;
   * <li>74=Opera��o de Aquisi��o; sem Incid�ncia da Contribui��o;
   * <li>75=Opera��o de Aquisi��o por Substitui��o Tribut�ria;
   * <li>98=Outras Opera��es de Entrada;
   * <li>99=Outras Opera��es;
   */
  @RFWMetaStringField(caption = "CST", minlength = 2, maxLength = 2, required = true, pattern = "^(01|02|03|04|05|06|07|08|09|49|50|51|52|53|54|55|56|60|61|62|63|64|65|66|67|70|71|72|73|74|75|98|99)$")
  private String cst = null;

  /**
   * S07 vBC Valor da Base de C�lculo da COFINS E S02 N 1-1 13v2 <Br>
   * <Br>
   * S07 vBC Valor da Base de C�lculo da COFINS E S06.1 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor da Base de C�lculo", minValue = "0", maxValue = "9999999999999.99", scale = 2, required = false)
  private BigDecimal vbc = null;

  /**
   * S08 pCOFINS Al�quota da COFINS (em percentual) E S02 N 1-1 3v2-4 <Br>
   * <Br>
   * S08 pCOFINS Al�quota da COFINS (em percentual) E S06.1 N 1-1 3v2-4
   */
  @RFWMetaBigDecimalField(caption = "Al�quota(%)", minValue = "0", maxValue = "999.9999", scale = 2, scaleMax = 4, required = false)
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
   * vAliqProd Al�quota da COFINS (em reais) E S03 N 1-1 11v0-4 <br>
   * <Br>
   * S10 vAliqProd Al�quota da COFINS (em reais) E S08.1 N 1-1 11v0-4
   */
  @RFWMetaBigDecimalField(caption = "Al�quota ($)", minValue = "0", maxValue = "99999999999.9999", scale = 0, scaleMax = 4, required = false)
  private BigDecimal valiqProd = null;

  /**
   * # s06 CST C�digo de Situa��o Tribut�ria da COFINS E S02 N 1-1 2<br>
   * <li>01=Opera��o Tribut�vel (base de c�lculo = valor da opera��o al�quota normal (cumulativo/n�o cumulativo));
   * <li>02=Opera��o Tribut�vel (base de c�lculo = valor da opera��o (al�quota diferenciada)); <br>
   * <Br>
   * S06 CST C�digo de Situa��o Tribut�ria da COFINS E S03 N 1-1 2<br>
   * <li>03=Opera��o Tribut�vel (base de c�lculo = quantidade vendida x al�quota por unidade de produto); <br>
   * <br>
   * S06 CST C�digo de Situa��o Tribut�ria da COFINS E S04 N 1-1 2<br>
   * <li>04=Opera��o Tribut�vel (tributa��o monof�sica, al�quota zero);
   * <li>05=Opera��o Tribut�vel (Substitui��o Tribut�ria);
   * <li>06=Opera��o Tribut�vel (al�quota zero);
   * <li>07=Opera��o Isenta da Contribui��o;
   * <li>08=Opera��o Sem Incid�ncia da Contribui��o;
   * <li>09=Opera��o com Suspens�o da Contribui��o; S06 CST C�digo de Situa��o Tribut�ria da COFINS E S05 N 1-1 2<br>
   * <li>49=Outras Opera��es de Sa�da;
   * <li>50=Opera��o com Direito a Cr�dito - Vinculada Exclusivamente a Receita Tributada no Mercado Interno;
   * <li>51=Opera��o com Direito a Cr�dito - Vinculada Exclusivamente a Receita N�o Tributada no Mercado Interno;
   * <li>52=Opera��o com Direito a Cr�dito � Vinculada Exclusivamente a Receita de Exporta��o;
   * <li>53=Opera��o com Direito a Cr�dito - Vinculada a Receitas Tributadas e N�o-Tributadas no Mercado Interno;
   * <li>54=Opera��o com Direito a Cr�dito - Vinculada a Receitas Tributadas no Mercado Interno e de Exporta��o;
   * <li>55=Opera��o com Direito a Cr�dito - Vinculada a Receitas N�o-Tributadas no Mercado Interno e de Exporta��o;
   * <li>56=Opera��o com Direito a Cr�dito - Vinculada a Receitas Tributadas e N�o-Tributadas no Mercado Interno, e de Exporta��o;
   * <li>60=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada Exclusivamente a Receita Tributada no Mercado Interno;
   * <li>61=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada Exclusivamente a Receita N�o-Tributada no Mercado Interno;
   * <li>62=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada Exclusivamente a Receita de Exporta��o;
   * <li>63=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada a Receitas Tributadas e N�o-Tributadas no Mercado Interno;
   * <li>64=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada a Receitas Tributadas no Mercado Interno e de Exporta��o;
   * <li>65=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada a Receitas N�o-Tributadas no Mercado Interno e de Exporta��o;
   * <li>66=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada a Receitas Tributadas e N�o-Tributadas no Mercado Interno, e de Exporta��o;
   * <li>67=Cr�dito Presumido - Outras Opera��es;
   * <li>70=Opera��o de Aquisi��o sem Direito a Cr�dito;
   * <li>71=Opera��o de Aquisi��o com Isen��o;
   * <li>72=Opera��o de Aquisi��o com Suspens�o;
   * <li>73=Opera��o de Aquisi��o a Al�quota Zero;
   * <li>74=Opera��o de Aquisi��o; sem Incid�ncia da Contribui��o;
   * <li>75=Opera��o de Aquisi��o por Substitui��o Tribut�ria;
   * <li>98=Outras Opera��es de Entrada;
   * <li>99=Outras Opera��es;.
   *
   * @return # s06 CST C�digo de Situa��o Tribut�ria da COFINS E S02 N 1-1 2<br>
   *         <li>01=Opera��o Tribut�vel (base de c�lculo = valor da opera��o al�quota normal (cumulativo/n�o cumulativo));
   *         <li>02=Opera��o Tribut�vel (base de c�lculo = valor da opera��o (al�quota diferenciada)); <br>
   *         <Br>
   *         S06 CST C�digo de Situa��o Tribut�ria da COFINS E S03 N 1-1 2<br>
   *         <li>03=Opera��o Tribut�vel (base de c�lculo = quantidade vendida x al�quota por unidade de produto); <br>
   *         <br>
   *         S06 CST C�digo de Situa��o Tribut�ria da COFINS E S04 N 1-1 2<br>
   *         <li>04=Opera��o Tribut�vel (tributa��o monof�sica, al�quota zero);
   *         <li>05=Opera��o Tribut�vel (Substitui��o Tribut�ria);
   *         <li>06=Opera��o Tribut�vel (al�quota zero);
   *         <li>07=Opera��o Isenta da Contribui��o;
   *         <li>08=Opera��o Sem Incid�ncia da Contribui��o;
   *         <li>09=Opera��o com Suspens�o da Contribui��o; S06 CST C�digo de Situa��o Tribut�ria da COFINS E S05 N 1-1 2<br>
   *         <li>49=Outras Opera��es de Sa�da;
   *         <li>50=Opera��o com Direito a Cr�dito - Vinculada Exclusivamente a Receita Tributada no Mercado Interno;
   *         <li>51=Opera��o com Direito a Cr�dito - Vinculada Exclusivamente a Receita N�o Tributada no Mercado Interno;
   *         <li>52=Opera��o com Direito a Cr�dito � Vinculada Exclusivamente a Receita de Exporta��o;
   *         <li>53=Opera��o com Direito a Cr�dito - Vinculada a Receitas Tributadas e N�o-Tributadas no Mercado Interno;
   *         <li>54=Opera��o com Direito a Cr�dito - Vinculada a Receitas Tributadas no Mercado Interno e de Exporta��o;
   *         <li>55=Opera��o com Direito a Cr�dito - Vinculada a Receitas N�o-Tributadas no Mercado Interno e de Exporta��o;
   *         <li>56=Opera��o com Direito a Cr�dito - Vinculada a Receitas Tributadas e N�o-Tributadas no Mercado Interno, e de Exporta��o;
   *         <li>60=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada Exclusivamente a Receita Tributada no Mercado Interno;
   *         <li>61=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada Exclusivamente a Receita N�o-Tributada no Mercado Interno;
   *         <li>62=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada Exclusivamente a Receita de Exporta��o;
   *         <li>63=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada a Receitas Tributadas e N�o-Tributadas no Mercado Interno;
   *         <li>64=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada a Receitas Tributadas no Mercado Interno e de Exporta��o;
   *         <li>65=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada a Receitas N�o-Tributadas no Mercado Interno e de Exporta��o;
   *         <li>66=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada a Receitas Tributadas e N�o-Tributadas no Mercado Interno, e de Exporta��o;
   *         <li>67=Cr�dito Presumido - Outras Opera��es;
   *         <li>70=Opera��o de Aquisi��o sem Direito a Cr�dito;
   *         <li>71=Opera��o de Aquisi��o com Isen��o;
   *         <li>72=Opera��o de Aquisi��o com Suspens�o;
   *         <li>73=Opera��o de Aquisi��o a Al�quota Zero;
   *         <li>74=Opera��o de Aquisi��o; sem Incid�ncia da Contribui��o;
   *         <li>75=Opera��o de Aquisi��o por Substitui��o Tribut�ria;
   *         <li>98=Outras Opera��es de Entrada;
   *         <li>99=Outras Opera��es;
   */
  public String getCst() {
    return cst;
  }

  /**
   * # s06 CST C�digo de Situa��o Tribut�ria da COFINS E S02 N 1-1 2<br>
   * <li>01=Opera��o Tribut�vel (base de c�lculo = valor da opera��o al�quota normal (cumulativo/n�o cumulativo));
   * <li>02=Opera��o Tribut�vel (base de c�lculo = valor da opera��o (al�quota diferenciada)); <br>
   * <Br>
   * S06 CST C�digo de Situa��o Tribut�ria da COFINS E S03 N 1-1 2<br>
   * <li>03=Opera��o Tribut�vel (base de c�lculo = quantidade vendida x al�quota por unidade de produto); <br>
   * <br>
   * S06 CST C�digo de Situa��o Tribut�ria da COFINS E S04 N 1-1 2<br>
   * <li>04=Opera��o Tribut�vel (tributa��o monof�sica, al�quota zero);
   * <li>05=Opera��o Tribut�vel (Substitui��o Tribut�ria);
   * <li>06=Opera��o Tribut�vel (al�quota zero);
   * <li>07=Opera��o Isenta da Contribui��o;
   * <li>08=Opera��o Sem Incid�ncia da Contribui��o;
   * <li>09=Opera��o com Suspens�o da Contribui��o; S06 CST C�digo de Situa��o Tribut�ria da COFINS E S05 N 1-1 2<br>
   * <li>49=Outras Opera��es de Sa�da;
   * <li>50=Opera��o com Direito a Cr�dito - Vinculada Exclusivamente a Receita Tributada no Mercado Interno;
   * <li>51=Opera��o com Direito a Cr�dito - Vinculada Exclusivamente a Receita N�o Tributada no Mercado Interno;
   * <li>52=Opera��o com Direito a Cr�dito � Vinculada Exclusivamente a Receita de Exporta��o;
   * <li>53=Opera��o com Direito a Cr�dito - Vinculada a Receitas Tributadas e N�o-Tributadas no Mercado Interno;
   * <li>54=Opera��o com Direito a Cr�dito - Vinculada a Receitas Tributadas no Mercado Interno e de Exporta��o;
   * <li>55=Opera��o com Direito a Cr�dito - Vinculada a Receitas N�o-Tributadas no Mercado Interno e de Exporta��o;
   * <li>56=Opera��o com Direito a Cr�dito - Vinculada a Receitas Tributadas e N�o-Tributadas no Mercado Interno, e de Exporta��o;
   * <li>60=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada Exclusivamente a Receita Tributada no Mercado Interno;
   * <li>61=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada Exclusivamente a Receita N�o-Tributada no Mercado Interno;
   * <li>62=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada Exclusivamente a Receita de Exporta��o;
   * <li>63=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada a Receitas Tributadas e N�o-Tributadas no Mercado Interno;
   * <li>64=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada a Receitas Tributadas no Mercado Interno e de Exporta��o;
   * <li>65=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada a Receitas N�o-Tributadas no Mercado Interno e de Exporta��o;
   * <li>66=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada a Receitas Tributadas e N�o-Tributadas no Mercado Interno, e de Exporta��o;
   * <li>67=Cr�dito Presumido - Outras Opera��es;
   * <li>70=Opera��o de Aquisi��o sem Direito a Cr�dito;
   * <li>71=Opera��o de Aquisi��o com Isen��o;
   * <li>72=Opera��o de Aquisi��o com Suspens�o;
   * <li>73=Opera��o de Aquisi��o a Al�quota Zero;
   * <li>74=Opera��o de Aquisi��o; sem Incid�ncia da Contribui��o;
   * <li>75=Opera��o de Aquisi��o por Substitui��o Tribut�ria;
   * <li>98=Outras Opera��es de Entrada;
   * <li>99=Outras Opera��es;.
   *
   * @param cst # s06 CST C�digo de Situa��o Tribut�ria da COFINS E S02 N 1-1 2<br>
   *          <li>01=Opera��o Tribut�vel (base de c�lculo = valor da opera��o al�quota normal (cumulativo/n�o cumulativo));
   *          <li>02=Opera��o Tribut�vel (base de c�lculo = valor da opera��o (al�quota diferenciada)); <br>
   *          <Br>
   *          S06 CST C�digo de Situa��o Tribut�ria da COFINS E S03 N 1-1 2<br>
   *          <li>03=Opera��o Tribut�vel (base de c�lculo = quantidade vendida x al�quota por unidade de produto); <br>
   *          <br>
   *          S06 CST C�digo de Situa��o Tribut�ria da COFINS E S04 N 1-1 2<br>
   *          <li>04=Opera��o Tribut�vel (tributa��o monof�sica, al�quota zero);
   *          <li>05=Opera��o Tribut�vel (Substitui��o Tribut�ria);
   *          <li>06=Opera��o Tribut�vel (al�quota zero);
   *          <li>07=Opera��o Isenta da Contribui��o;
   *          <li>08=Opera��o Sem Incid�ncia da Contribui��o;
   *          <li>09=Opera��o com Suspens�o da Contribui��o; S06 CST C�digo de Situa��o Tribut�ria da COFINS E S05 N 1-1 2<br>
   *          <li>49=Outras Opera��es de Sa�da;
   *          <li>50=Opera��o com Direito a Cr�dito - Vinculada Exclusivamente a Receita Tributada no Mercado Interno;
   *          <li>51=Opera��o com Direito a Cr�dito - Vinculada Exclusivamente a Receita N�o Tributada no Mercado Interno;
   *          <li>52=Opera��o com Direito a Cr�dito � Vinculada Exclusivamente a Receita de Exporta��o;
   *          <li>53=Opera��o com Direito a Cr�dito - Vinculada a Receitas Tributadas e N�o-Tributadas no Mercado Interno;
   *          <li>54=Opera��o com Direito a Cr�dito - Vinculada a Receitas Tributadas no Mercado Interno e de Exporta��o;
   *          <li>55=Opera��o com Direito a Cr�dito - Vinculada a Receitas N�o-Tributadas no Mercado Interno e de Exporta��o;
   *          <li>56=Opera��o com Direito a Cr�dito - Vinculada a Receitas Tributadas e N�o-Tributadas no Mercado Interno, e de Exporta��o;
   *          <li>60=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada Exclusivamente a Receita Tributada no Mercado Interno;
   *          <li>61=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada Exclusivamente a Receita N�o-Tributada no Mercado Interno;
   *          <li>62=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada Exclusivamente a Receita de Exporta��o;
   *          <li>63=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada a Receitas Tributadas e N�o-Tributadas no Mercado Interno;
   *          <li>64=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada a Receitas Tributadas no Mercado Interno e de Exporta��o;
   *          <li>65=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada a Receitas N�o-Tributadas no Mercado Interno e de Exporta��o;
   *          <li>66=Cr�dito Presumido - Opera��o de Aquisi��o Vinculada a Receitas Tributadas e N�o-Tributadas no Mercado Interno, e de Exporta��o;
   *          <li>67=Cr�dito Presumido - Outras Opera��es;
   *          <li>70=Opera��o de Aquisi��o sem Direito a Cr�dito;
   *          <li>71=Opera��o de Aquisi��o com Isen��o;
   *          <li>72=Opera��o de Aquisi��o com Suspens�o;
   *          <li>73=Opera��o de Aquisi��o a Al�quota Zero;
   *          <li>74=Opera��o de Aquisi��o; sem Incid�ncia da Contribui��o;
   *          <li>75=Opera��o de Aquisi��o por Substitui��o Tribut�ria;
   *          <li>98=Outras Opera��es de Entrada;
   *          <li>99=Outras Opera��es;
   */
  public void setCst(String cst) {
    this.cst = cst;
  }

  /**
   * # s07 vBC Valor da Base de C�lculo da COFINS E S02 N 1-1 13v2 <Br>
   * <Br>
   * S07 vBC Valor da Base de C�lculo da COFINS E S06.1 N 1-1 13v2.
   *
   * @return # s07 vBC Valor da Base de C�lculo da COFINS E S02 N 1-1 13v2 <Br>
   *         <Br>
   *         S07 vBC Valor da Base de C�lculo da COFINS E S06
   */
  public BigDecimal getVbc() {
    return vbc;
  }

  /**
   * # s07 vBC Valor da Base de C�lculo da COFINS E S02 N 1-1 13v2 <Br>
   * <Br>
   * S07 vBC Valor da Base de C�lculo da COFINS E S06.1 N 1-1 13v2.
   *
   * @param vbc # s07 vBC Valor da Base de C�lculo da COFINS E S02 N 1-1 13v2 <Br>
   *          <Br>
   *          S07 vBC Valor da Base de C�lculo da COFINS E S06
   */
  public void setVbc(BigDecimal vbc) {
    this.vbc = vbc;
  }

  /**
   * # s08 pCOFINS Al�quota da COFINS (em percentual) E S02 N 1-1 3v2-4 <Br>
   * <Br>
   * S08 pCOFINS Al�quota da COFINS (em percentual) E S06.1 N 1-1 3v2-4.
   *
   * @return # s08 pCOFINS Al�quota da COFINS (em percentual) E S02 N 1-1 3v2-4 <Br>
   *         <Br>
   *         S08 pCOFINS Al�quota da COFINS (em percentual) E S06
   */
  public BigDecimal getPcofins() {
    return pcofins;
  }

  /**
   * # s08 pCOFINS Al�quota da COFINS (em percentual) E S02 N 1-1 3v2-4 <Br>
   * <Br>
   * S08 pCOFINS Al�quota da COFINS (em percentual) E S06.1 N 1-1 3v2-4.
   *
   * @param pcofins # s08 pCOFINS Al�quota da COFINS (em percentual) E S02 N 1-1 3v2-4 <Br>
   *          <Br>
   *          S08 pCOFINS Al�quota da COFINS (em percentual) E S06
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
   * # vAliqProd Al�quota da COFINS (em reais) E S03 N 1-1 11v0-4 <br>
   * <Br>
   * S10 vAliqProd Al�quota da COFINS (em reais) E S08.1 N 1-1 11v0-4.
   *
   * @return # vAliqProd Al�quota da COFINS (em reais) E S03 N 1-1 11v0-4 <br>
   *         <Br>
   *         S10 vAliqProd Al�quota da COFINS (em reais) E S08
   */
  public BigDecimal getValiqProd() {
    return valiqProd;
  }

  /**
   * # vAliqProd Al�quota da COFINS (em reais) E S03 N 1-1 11v0-4 <br>
   * <Br>
   * S10 vAliqProd Al�quota da COFINS (em reais) E S08.1 N 1-1 11v0-4.
   *
   * @param valiqProd # vAliqProd Al�quota da COFINS (em reais) E S03 N 1-1 11v0-4 <br>
   *          <Br>
   *          S10 vAliqProd Al�quota da COFINS (em reais) E S08
   */
  public void setValiqProd(BigDecimal valiqProd) {
    this.valiqProd = valiqProd;
  }

}