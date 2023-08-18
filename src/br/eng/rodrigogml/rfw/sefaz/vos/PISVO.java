package br.eng.rodrigogml.rfw.sefaz.vos;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "PIS" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integra��o com o framework, pertindo a valida��o e at� a persist�ncia se o sistema assim desejar. N�o h� preocupa��o de gerar JavaDOC nestas classes pois ela deve representar exatamente a documenta��o da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Valida��o da NF-e.
 */
public class PISVO extends RFWVO {

  private static final long serialVersionUID = 7652424072280408245L;

  /**
   * Q06 CST C�digo de Situa��o Tribut�ria do PIS E Q02 N 1-1 2<br>
   * <li>01=Opera��o Tribut�vel (base de c�lculo = valor da opera��o al�quota normal (cumulativo/n�o cumulativo));
   * <li>02=Opera��o Tribut�vel (base de c�lculo = valor da opera��o (al�quota diferenciada));<br>
   * <br>
   * Q06 CST C�digo de Situa��o Tribut�ria do PIS E Q03 N 1-1 2<br>
   * <li>03=Opera��o Tribut�vel (base de c�lculo = = quantidade vendida x al�quota por unidade de produto);<br>
   * <br>
   * Q06 CST C�digo de Situa��o Tribut�ria do PIS E Q04 N 1-1 2<br>
   * <li>04=Opera��o Tribut�vel (tributa��o monof�sica (al�quota zero));
   * <li>05=Opera��o Tribut�vel (Substitui��o Tribut�ria);
   * <li>06=Opera��o Tribut�vel (al�quota zero);
   * <li>07=Opera��o Isenta da Contribui��o;
   * <li>08=Opera��o Sem Incid�ncia da Contribui��o;
   * <li>09=Opera��o com Suspens�o da Contribui��o;<br>
   * <br>
   * Q06 CST C�digo de Situa��o Tribut�ria do PIS E Q05 N 1-1 2<br>
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
   * Q07 vBC Valor da Base de C�lculo do PIS E Q02 N 1-1 13v2<br>
   * <br>
   * Q07 vBC Valor da Base de C�lculo do PIS E Q06.1 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor da Base de C�lculo", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = false)
  private BigDecimal vbc = null;

  /**
   * Q08 pPIS Al�quota do PIS (em percentual) E Q02 N 1-1 3v2-4<br>
   * <br>
   * Q08 pPIS Al�quota do PIS (em percentual) E Q06.1 N 1-1 3v2-4
   */
  @RFWMetaBigDecimalField(caption = "Al�quota(%)", minValue = "0", maxValue = "999.9999", scale = 0, scaleMax = 4, required = false)
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
   * Q11 vAliqProd Al�quota do PIS (em reais) E Q03 N 1-1 11v0-4
   */
  @RFWMetaBigDecimalField(caption = "Al�quota ($)", minValue = "0", maxValue = "99999999999.9999", scale = 0, scaleMax = 4, required = false)
  private BigDecimal valiqProd = null;

  /**
   * # q06 CST C�digo de Situa��o Tribut�ria do PIS E Q02 N 1-1 2<br>
   * <li>01=Opera��o Tribut�vel (base de c�lculo = valor da opera��o al�quota normal (cumulativo/n�o cumulativo));
   * <li>02=Opera��o Tribut�vel (base de c�lculo = valor da opera��o (al�quota diferenciada));<br>
   * <br>
   * Q06 CST C�digo de Situa��o Tribut�ria do PIS E Q03 N 1-1 2<br>
   * <li>03=Opera��o Tribut�vel (base de c�lculo = = quantidade vendida x al�quota por unidade de produto);<br>
   * <br>
   * Q06 CST C�digo de Situa��o Tribut�ria do PIS E Q04 N 1-1 2<br>
   * <li>04=Opera��o Tribut�vel (tributa��o monof�sica (al�quota zero));
   * <li>05=Opera��o Tribut�vel (Substitui��o Tribut�ria);
   * <li>06=Opera��o Tribut�vel (al�quota zero);
   * <li>07=Opera��o Isenta da Contribui��o;
   * <li>08=Opera��o Sem Incid�ncia da Contribui��o;
   * <li>09=Opera��o com Suspens�o da Contribui��o;<br>
   * <br>
   * Q06 CST C�digo de Situa��o Tribut�ria do PIS E Q05 N 1-1 2<br>
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
   * @return # q06 CST C�digo de Situa��o Tribut�ria do PIS E Q02 N 1-1 2<br>
   *         <li>01=Opera��o Tribut�vel (base de c�lculo = valor da opera��o al�quota normal (cumulativo/n�o cumulativo));
   *         <li>02=Opera��o Tribut�vel (base de c�lculo = valor da opera��o (al�quota diferenciada));<br>
   *         <br>
   *         Q06 CST C�digo de Situa��o Tribut�ria do PIS E Q03 N 1-1 2<br>
   *         <li>03=Opera��o Tribut�vel (base de c�lculo = = quantidade vendida x al�quota por unidade de produto);<br>
   *         <br>
   *         Q06 CST C�digo de Situa��o Tribut�ria do PIS E Q04 N 1-1 2<br>
   *         <li>04=Opera��o Tribut�vel (tributa��o monof�sica (al�quota zero));
   *         <li>05=Opera��o Tribut�vel (Substitui��o Tribut�ria);
   *         <li>06=Opera��o Tribut�vel (al�quota zero);
   *         <li>07=Opera��o Isenta da Contribui��o;
   *         <li>08=Opera��o Sem Incid�ncia da Contribui��o;
   *         <li>09=Opera��o com Suspens�o da Contribui��o;<br>
   *         <br>
   *         Q06 CST C�digo de Situa��o Tribut�ria do PIS E Q05 N 1-1 2<br>
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
   * # q06 CST C�digo de Situa��o Tribut�ria do PIS E Q02 N 1-1 2<br>
   * <li>01=Opera��o Tribut�vel (base de c�lculo = valor da opera��o al�quota normal (cumulativo/n�o cumulativo));
   * <li>02=Opera��o Tribut�vel (base de c�lculo = valor da opera��o (al�quota diferenciada));<br>
   * <br>
   * Q06 CST C�digo de Situa��o Tribut�ria do PIS E Q03 N 1-1 2<br>
   * <li>03=Opera��o Tribut�vel (base de c�lculo = = quantidade vendida x al�quota por unidade de produto);<br>
   * <br>
   * Q06 CST C�digo de Situa��o Tribut�ria do PIS E Q04 N 1-1 2<br>
   * <li>04=Opera��o Tribut�vel (tributa��o monof�sica (al�quota zero));
   * <li>05=Opera��o Tribut�vel (Substitui��o Tribut�ria);
   * <li>06=Opera��o Tribut�vel (al�quota zero);
   * <li>07=Opera��o Isenta da Contribui��o;
   * <li>08=Opera��o Sem Incid�ncia da Contribui��o;
   * <li>09=Opera��o com Suspens�o da Contribui��o;<br>
   * <br>
   * Q06 CST C�digo de Situa��o Tribut�ria do PIS E Q05 N 1-1 2<br>
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
   * @param cst # q06 CST C�digo de Situa��o Tribut�ria do PIS E Q02 N 1-1 2<br>
   *          <li>01=Opera��o Tribut�vel (base de c�lculo = valor da opera��o al�quota normal (cumulativo/n�o cumulativo));
   *          <li>02=Opera��o Tribut�vel (base de c�lculo = valor da opera��o (al�quota diferenciada));<br>
   *          <br>
   *          Q06 CST C�digo de Situa��o Tribut�ria do PIS E Q03 N 1-1 2<br>
   *          <li>03=Opera��o Tribut�vel (base de c�lculo = = quantidade vendida x al�quota por unidade de produto);<br>
   *          <br>
   *          Q06 CST C�digo de Situa��o Tribut�ria do PIS E Q04 N 1-1 2<br>
   *          <li>04=Opera��o Tribut�vel (tributa��o monof�sica (al�quota zero));
   *          <li>05=Opera��o Tribut�vel (Substitui��o Tribut�ria);
   *          <li>06=Opera��o Tribut�vel (al�quota zero);
   *          <li>07=Opera��o Isenta da Contribui��o;
   *          <li>08=Opera��o Sem Incid�ncia da Contribui��o;
   *          <li>09=Opera��o com Suspens�o da Contribui��o;<br>
   *          <br>
   *          Q06 CST C�digo de Situa��o Tribut�ria do PIS E Q05 N 1-1 2<br>
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
   * # q07 vBC Valor da Base de C�lculo do PIS E Q02 N 1-1 13v2<br>
   * <br>
   * Q07 vBC Valor da Base de C�lculo do PIS E Q06.1 N 1-1 13v2.
   *
   * @return # q07 vBC Valor da Base de C�lculo do PIS E Q02 N 1-1 13v2<br>
   *         <br>
   *         Q07 vBC Valor da Base de C�lculo do PIS E Q06
   */
  public BigDecimal getVbc() {
    return vbc;
  }

  /**
   * # q07 vBC Valor da Base de C�lculo do PIS E Q02 N 1-1 13v2<br>
   * <br>
   * Q07 vBC Valor da Base de C�lculo do PIS E Q06.1 N 1-1 13v2.
   *
   * @param vbc # q07 vBC Valor da Base de C�lculo do PIS E Q02 N 1-1 13v2<br>
   *          <br>
   *          Q07 vBC Valor da Base de C�lculo do PIS E Q06
   */
  public void setVbc(BigDecimal vbc) {
    this.vbc = vbc;
  }

  /**
   * # q08 pPIS Al�quota do PIS (em percentual) E Q02 N 1-1 3v2-4<br>
   * <br>
   * Q08 pPIS Al�quota do PIS (em percentual) E Q06.1 N 1-1 3v2-4.
   *
   * @return # q08 pPIS Al�quota do PIS (em percentual) E Q02 N 1-1 3v2-4<br>
   *         <br>
   *         Q08 pPIS Al�quota do PIS (em percentual) E Q06
   */
  public BigDecimal getPpis() {
    return ppis;
  }

  /**
   * # q08 pPIS Al�quota do PIS (em percentual) E Q02 N 1-1 3v2-4<br>
   * <br>
   * Q08 pPIS Al�quota do PIS (em percentual) E Q06.1 N 1-1 3v2-4.
   *
   * @param ppis # q08 pPIS Al�quota do PIS (em percentual) E Q02 N 1-1 3v2-4<br>
   *          <br>
   *          Q08 pPIS Al�quota do PIS (em percentual) E Q06
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
   * # q11 vAliqProd Al�quota do PIS (em reais) E Q03 N 1-1 11v0-4.
   *
   * @return # q11 vAliqProd Al�quota do PIS (em reais) E Q03 N 1-1 11v0-4
   */
  public BigDecimal getValiqProd() {
    return valiqProd;
  }

  /**
   * # q11 vAliqProd Al�quota do PIS (em reais) E Q03 N 1-1 11v0-4.
   *
   * @param valiqProd # q11 vAliqProd Al�quota do PIS (em reais) E Q03 N 1-1 11v0-4
   */
  public void setValiqProd(BigDecimal valiqProd) {
    this.valiqProd = valiqProd;
  }

}
