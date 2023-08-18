package br.eng.rodrigogml.rfw.sefaz.vos;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaIntegerField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaLongField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCNPJField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "IPI" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class IPIVO extends RFWVO {

  private static final long serialVersionUID = -1879713906927236507L;

  /**
   * O02 clEnq Classe de enquadramento do IPI para Cigarros e Bebidas E O01 C 0-1 1 - 5<br>
   * Preenchimento conforme Atos Normativos editados pela Receita Federal (Observação 2)<br>
   * (Excluído no leiaute 4.0 - NT2016.002)<br>
   */
  @RFWMetaStringField(caption = "Classe de Enquadramento do IPI", minlength = 1, maxLength = 5, required = false)
  private String clEnq = null;

  /**
   * O03 CNPJProd CNPJ do produtor da mercadoria, quando diferente do emitente. Somente para os casos de exportação direta ou indireta. E O01 N 0-1 14<br>
   * Informar os zeros não significativos <Br>
   * <Br>
   * <B>ATENÇÃO:</B> Não esou validando o campo cnpj com o {@link RFWMetaStringCNPJField} por já ter encontrado notas autorizadas pela sefaz com 14 zeros neste campo.
   */
  @RFWMetaStringField(caption = "CNPJ do Produtor", minlength = 14, maxLength = 14, required = false, pattern = "\\d{14}")
  private String cnpjProd = null;

  /**
   * O04 cSelo Código do selo de controle IPI E O01 C 0-1 1 - 60<br>
   * Preenchimento conforme Anexo II-A da Instrução Normativa RFB Nº 770/2007:<br>
   * <br>
   * <b>TIPO DE SELO / CÓDIGO / COR DO SELO</b><br>
   * <li>Produto Nacional / 9710-01 / Verde combinado com marrom
   * <li>Produto Nacional para Exportação - Tipo "1" / 9710-10 / Verde Escuro combinado com marrom
   * <li>Produto Nacional para Exportação - Tipo "2" / 9710-11 / Verde Escuro combinado com marrom
   * <li>Produto Nacional para Exportação - Tipo "3" / 9710-12 / Verde Escuro combinado com marrom
   * <li>Produto Estrangeiro / 8610-09 / Vermelho combinado com azul <br>
   * (Atualizado na NT2016.002)
   */
  @RFWMetaStringField(caption = "Código do Selo de Controle", minlength = 1, maxLength = 60, required = false)
  private String cselo = null;

  /**
   * O05 qSelo Quantidade de selo de controle E O01 N 0-1 1 - 12
   */
  @RFWMetaLongField(caption = "Quandidade de Selo de Controle", minvalue = 0, maxvalue = 999999999999L, required = false)
  private Long qselo = null;

  /**
   * O06 cEnq Código de Enquadramento Legal do IPI E O01 N 1-1 1 - 3<br>
   * Preenchimento conforme seção 8.9 do MOC – Visão Geral (Tabela do Código de Enquadramento do IPI)
   */
  @RFWMetaIntegerField(caption = "Código de Enquadramento", minvalue = 0, maxvalue = 999, required = false)
  private Integer cenq = null;

  /**
   * O09 CST Código da situação tributária do IPI E O07 N 1-1 2<br>
   * <li>00=Entrada com recuperação de crédito
   * <li>49=Outras entradas
   * <li>50=Saída tributada
   * <li>99=Outras saídas <Br>
   * <Br>
   * <br>
   * O09 CST Código da situação tributária do IPI E O08 C 1-1 2<br>
   * Código da situação tributária do IPI:
   * <li>01=Entrada tributada com alíquota zero
   * <li>02=Entrada isenta
   * <li>03=Entrada não-tributada
   * <li>04=Entrada imune
   * <li>05=Entrada com suspensão
   * <li>51=Saída tributada com alíquota zero
   * <li>52=Saída isenta
   * <li>53=Saída não-tributada
   * <li>54=Saída imune
   * <li>55=Saída com suspensão
   */
  @RFWMetaStringField(caption = "CST", minlength = 2, maxLength = 2, required = false, pattern = "^(00|01|02|03|04|05|49|50|51|52|53|54|55|99)$")
  private String cst = null;

  /**
   * O10 vBC Valor da BC do IPI E O09.1 N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor da BC do IPI", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = false)
  private BigDecimal vbc = null;

  /**
   * O13 pIPI Alíquota do IPI E O09.1 N 1-1 3v2-4
   */
  @RFWMetaBigDecimalField(caption = "Alíquota do IPI", minValue = "0", maxValue = "999.9999", scale = 0, scaleMax = 4, required = false)
  private BigDecimal pipi = null;

  /**
   * O11 qUnid Quantidade total na unidade padrão para tributação (somente para os produtos tributados por unidade) E O13.1 N 1-1 12v0-4<br>
   * Informar os campos O11 e O12 se o cálculo do IPI for de valor por unidade
   */
  @RFWMetaBigDecimalField(caption = "Quantidade Total da Unidade Padrão", minValue = "0", maxValue = "999999999999.9999", scale = 0, scaleMax = 4, required = false)
  private BigDecimal qunid = null;

  /**
   * O12 vUnid Valor por Unidade Tributável E O13.1 N 1-1 11v0-4<br>
   * Informar os campos O11 e O12 se o cálculo do IPI for de valor por unidade.
   */
  @RFWMetaBigDecimalField(caption = "Valor por Unidade Tributável", minValue = "0", maxValue = "99999999999.9999", scale = 0, scaleMax = 4, required = false)
  private BigDecimal vunid = null;

  /**
   * O14 vIPI Valor do IPI E O07 N 1-1 13v2<br>
   * Informar os campos O11 e O12 se o cálculo do IPI for de valor por unidade.
   */
  @RFWMetaBigDecimalField(caption = "Valor do IPI", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = false)
  private BigDecimal vipi = null;

  /**
   * # o02 clEnq Classe de enquadramento do IPI para Cigarros e Bebidas E O01 C 0-1 1 - 5<br>
   * Preenchimento conforme Atos Normativos editados pela Receita Federal (Observação 2)<br>
   * (Excluído no leiaute 4.0 - NT2016.002)<br>
   * .
   *
   * @return # o02 clEnq Classe de enquadramento do IPI para Cigarros e Bebidas E O01 C 0-1 1 - 5<br>
   *         Preenchimento conforme Atos Normativos editados pela Receita Federal (Observação 2)<br>
   *         (Excluído no leiaute 4
   */
  public String getClEnq() {
    return clEnq;
  }

  /**
   * # o02 clEnq Classe de enquadramento do IPI para Cigarros e Bebidas E O01 C 0-1 1 - 5<br>
   * Preenchimento conforme Atos Normativos editados pela Receita Federal (Observação 2)<br>
   * (Excluído no leiaute 4.0 - NT2016.002)<br>
   * .
   *
   * @param clEnq # o02 clEnq Classe de enquadramento do IPI para Cigarros e Bebidas E O01 C 0-1 1 - 5<br>
   *          Preenchimento conforme Atos Normativos editados pela Receita Federal (Observação 2)<br>
   *          (Excluído no leiaute 4
   */
  public void setClEnq(String clEnq) {
    this.clEnq = clEnq;
  }

  /**
   * # o03 CNPJProd CNPJ do produtor da mercadoria, quando diferente do emitente. Somente para os casos de exportação direta ou indireta. E O01 N 0-1 14<br>
   * Informar os zeros não significativos.
   *
   * @return # o03 CNPJProd CNPJ do produtor da mercadoria, quando diferente do emitente
   */
  public String getCnpjProd() {
    return cnpjProd;
  }

  /**
   * # o03 CNPJProd CNPJ do produtor da mercadoria, quando diferente do emitente. Somente para os casos de exportação direta ou indireta. E O01 N 0-1 14<br>
   * Informar os zeros não significativos.
   *
   * @param cnpjProd # o03 CNPJProd CNPJ do produtor da mercadoria, quando diferente do emitente
   */
  public void setCnpjProd(String cnpjProd) {
    this.cnpjProd = cnpjProd;
  }

  /**
   * # o04 cSelo Código do selo de controle IPI E O01 C 0-1 1 - 60<br>
   * Preenchimento conforme Anexo II-A da Instrução Normativa RFB Nº 770/2007:<br>
   * <br>
   * <b>TIPO DE SELO / CÓDIGO / COR DO SELO</b><br>
   * <li>Produto Nacional / 9710-01 / Verde combinado com marrom
   * <li>Produto Nacional para Exportação - Tipo "1" / 9710-10 / Verde Escuro combinado com marrom
   * <li>Produto Nacional para Exportação - Tipo "2" / 9710-11 / Verde Escuro combinado com marrom
   * <li>Produto Nacional para Exportação - Tipo "3" / 9710-12 / Verde Escuro combinado com marrom
   * <li>Produto Estrangeiro / 8610-09 / Vermelho combinado com azul <br>
   * (Atualizado na NT2016.002).
   *
   * @return # o04 cSelo Código do selo de controle IPI E O01 C 0-1 1 - 60<br>
   *         Preenchimento conforme Anexo II-A da Instrução Normativa RFB Nº 770/2007:<br>
   *         <br>
   *         <b>TIPO DE SELO / CÓDIGO / COR DO SELO</b><br>
   *         <li>Produto Nacional / 9710-01 / Verde combinado com marrom
   *         <li>Produto Nacional para Exportação - Tipo "1" / 9710-10 / Verde Escuro combinado com marrom
   *         <li>Produto Nacional para Exportação - Tipo "2" / 9710-11 / Verde Escuro combinado com marrom
   *         <li>Produto Nacional para Exportação - Tipo "3" / 9710-12 / Verde Escuro combinado com marrom
   *         <li>Produto Estrangeiro / 8610-09 / Vermelho combinado com azul <br>
   *         (Atualizado na NT2016
   */
  public String getCselo() {
    return cselo;
  }

  /**
   * # o04 cSelo Código do selo de controle IPI E O01 C 0-1 1 - 60<br>
   * Preenchimento conforme Anexo II-A da Instrução Normativa RFB Nº 770/2007:<br>
   * <br>
   * <b>TIPO DE SELO / CÓDIGO / COR DO SELO</b><br>
   * <li>Produto Nacional / 9710-01 / Verde combinado com marrom
   * <li>Produto Nacional para Exportação - Tipo "1" / 9710-10 / Verde Escuro combinado com marrom
   * <li>Produto Nacional para Exportação - Tipo "2" / 9710-11 / Verde Escuro combinado com marrom
   * <li>Produto Nacional para Exportação - Tipo "3" / 9710-12 / Verde Escuro combinado com marrom
   * <li>Produto Estrangeiro / 8610-09 / Vermelho combinado com azul <br>
   * (Atualizado na NT2016.002).
   *
   * @param cselo # o04 cSelo Código do selo de controle IPI E O01 C 0-1 1 - 60<br>
   *          Preenchimento conforme Anexo II-A da Instrução Normativa RFB Nº 770/2007:<br>
   *          <br>
   *          <b>TIPO DE SELO / CÓDIGO / COR DO SELO</b><br>
   *          <li>Produto Nacional / 9710-01 / Verde combinado com marrom
   *          <li>Produto Nacional para Exportação - Tipo "1" / 9710-10 / Verde Escuro combinado com marrom
   *          <li>Produto Nacional para Exportação - Tipo "2" / 9710-11 / Verde Escuro combinado com marrom
   *          <li>Produto Nacional para Exportação - Tipo "3" / 9710-12 / Verde Escuro combinado com marrom
   *          <li>Produto Estrangeiro / 8610-09 / Vermelho combinado com azul <br>
   *          (Atualizado na NT2016
   */
  public void setCselo(String cselo) {
    this.cselo = cselo;
  }

  /**
   * # o05 qSelo Quantidade de selo de controle E O01 N 0-1 1 - 12.
   *
   * @return # o05 qSelo Quantidade de selo de controle E O01 N 0-1 1 - 12
   */
  public Long getQselo() {
    return qselo;
  }

  /**
   * # o05 qSelo Quantidade de selo de controle E O01 N 0-1 1 - 12.
   *
   * @param qselo # o05 qSelo Quantidade de selo de controle E O01 N 0-1 1 - 12
   */
  public void setQselo(Long qselo) {
    this.qselo = qselo;
  }

  /**
   * # o09 CST Código da situação tributária do IPI E O07 N 1-1 2<br>
   * <li>00=Entrada com recuperação de crédito
   * <li>49=Outras entradas
   * <li>50=Saída tributada
   * <li>99=Outras saídas.
   *
   * @return # o09 CST Código da situação tributária do IPI E O07 N 1-1 2<br>
   *         <li>00=Entrada com recuperação de crédito
   *         <li>49=Outras entradas
   *         <li>50=Saída tributada
   *         <li>99=Outras saídas
   */
  public String getCst() {
    return cst;
  }

  /**
   * # o09 CST Código da situação tributária do IPI E O07 N 1-1 2<br>
   * <li>00=Entrada com recuperação de crédito
   * <li>49=Outras entradas
   * <li>50=Saída tributada
   * <li>99=Outras saídas.
   *
   * @param cst # o09 CST Código da situação tributária do IPI E O07 N 1-1 2<br>
   *          <li>00=Entrada com recuperação de crédito
   *          <li>49=Outras entradas
   *          <li>50=Saída tributada
   *          <li>99=Outras saídas
   */
  public void setCst(String cst) {
    this.cst = cst;
  }

  /**
   * # o10 vBC Valor da BC do IPI E O09.1 N 1-1 13v2.
   *
   * @return # o10 vBC Valor da BC do IPI E O09
   */
  public BigDecimal getVbc() {
    return vbc;
  }

  /**
   * # o10 vBC Valor da BC do IPI E O09.1 N 1-1 13v2.
   *
   * @param vbc # o10 vBC Valor da BC do IPI E O09
   */
  public void setVbc(BigDecimal vbc) {
    this.vbc = vbc;
  }

  /**
   * # o13 pIPI Alíquota do IPI E O09.1 N 1-1 3v2-4.
   *
   * @return # o13 pIPI Alíquota do IPI E O09
   */
  public BigDecimal getPipi() {
    return pipi;
  }

  /**
   * # o13 pIPI Alíquota do IPI E O09.1 N 1-1 3v2-4.
   *
   * @param pipi # o13 pIPI Alíquota do IPI E O09
   */
  public void setPipi(BigDecimal pipi) {
    this.pipi = pipi;
  }

  /**
   * # o11 qUnid Quantidade total na unidade padrão para tributação (somente para os produtos tributados por unidade) E O13.1 N 1-1 12v0-4<br>
   * Informar os campos O11 e O12 se o cálculo do IPI for de valor por unidade.
   *
   * @return # o11 qUnid Quantidade total na unidade padrão para tributação (somente para os produtos tributados por unidade) E O13
   */
  public BigDecimal getQunid() {
    return qunid;
  }

  /**
   * # o11 qUnid Quantidade total na unidade padrão para tributação (somente para os produtos tributados por unidade) E O13.1 N 1-1 12v0-4<br>
   * Informar os campos O11 e O12 se o cálculo do IPI for de valor por unidade.
   *
   * @param qunid # o11 qUnid Quantidade total na unidade padrão para tributação (somente para os produtos tributados por unidade) E O13
   */
  public void setQunid(BigDecimal qunid) {
    this.qunid = qunid;
  }

  /**
   * # o12 vUnid Valor por Unidade Tributável E O13.1 N 1-1 11v0-4<br>
   * Informar os campos O11 e O12 se o cálculo do IPI for de valor por unidade.
   *
   * @return # o12 vUnid Valor por Unidade Tributável E O13
   */
  public BigDecimal getVunid() {
    return vunid;
  }

  /**
   * # o12 vUnid Valor por Unidade Tributável E O13.1 N 1-1 11v0-4<br>
   * Informar os campos O11 e O12 se o cálculo do IPI for de valor por unidade.
   *
   * @param vunid # o12 vUnid Valor por Unidade Tributável E O13
   */
  public void setVunid(BigDecimal vunid) {
    this.vunid = vunid;
  }

  /**
   * # o14 vIPI Valor do IPI E O07 N 1-1 13v2<br>
   * Informar os campos O11 e O12 se o cálculo do IPI for de valor por unidade.
   *
   * @return # o14 vIPI Valor do IPI E O07 N 1-1 13v2<br>
   *         Informar os campos O11 e O12 se o cálculo do IPI for de valor por unidade
   */
  public BigDecimal getVipi() {
    return vipi;
  }

  /**
   * # o14 vIPI Valor do IPI E O07 N 1-1 13v2<br>
   * Informar os campos O11 e O12 se o cálculo do IPI for de valor por unidade.
   *
   * @param vipi # o14 vIPI Valor do IPI E O07 N 1-1 13v2<br>
   *          Informar os campos O11 e O12 se o cálculo do IPI for de valor por unidade
   */
  public void setVipi(BigDecimal vipi) {
    this.vipi = vipi;
  }

  /**
   * # o06 cEnq Código de Enquadramento Legal do IPI E O01 N 1-1 1 - 3<br>
   * Preenchimento conforme seção 8.9 do MOC – Visão Geral (Tabela do Código de Enquadramento do IPI).
   *
   * @return # o06 cEnq Código de Enquadramento Legal do IPI E O01 N 1-1 1 - 3<br>
   *         Preenchimento conforme seção 8
   */
  public Integer getCenq() {
    return cenq;
  }

  /**
   * # o06 cEnq Código de Enquadramento Legal do IPI E O01 N 1-1 1 - 3<br>
   * Preenchimento conforme seção 8.9 do MOC – Visão Geral (Tabela do Código de Enquadramento do IPI).
   *
   * @param cenq # o06 cEnq Código de Enquadramento Legal do IPI E O01 N 1-1 1 - 3<br>
   *          Preenchimento conforme seção 8
   */
  public void setCenq(Integer cenq) {
    this.cenq = cenq;
  }

}