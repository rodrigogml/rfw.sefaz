package br.eng.rodrigogml.rfw.sefaz.vos;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCNPJField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "detPag" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integra��o com o framework, pertindo a valida��o e at� a persist�ncia se o sistema assim desejar. N�o h� preocupa��o de gerar JavaDOC nestas classes pois ela deve representar exatamente a documenta��o da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Valida��o da NF-e.
 */
public class DetPagVO extends RFWVO {

  private static final long serialVersionUID = -3849585851784413452L;

  /**
   * YA01b indPag Indicador da Forma de Pagamento E YA01a N 0-1 1<br>
   * <li>0= Pagamento � Vista
   * <li>1= Pagamento � Prazo (Inclu�do na NT2016.002)
   */
  @RFWMetaStringField(caption = "Indicador da Forma de Pagamento", minlength = 1, maxLength = 1, required = false, pattern = "^(0|1)$")
  private String indPag = null;

  /**
   * YA02 tPag Meio de pagamento E YA01a N 1-1 2<br>
   * <li>01=Dinheiro
   * <li>02=Cheque
   * <li>03=Cart�o de Cr�dito
   * <li>04=Cart�o de D�bito
   * <li>05=Cr�dito Loja
   * <li>10=Vale Alimenta��o
   * <li>11=Vale Refei��o
   * <li>12=Vale Presente
   * <li>13=Vale Combust�vel
   * <li><s>14=Duplicata Mercantil</s> - Exclu�do na NT2016.002
   * <li>15=Boleto Banc�rio
   * <li>16=Dep�sito Banc�rio
   * <li>17=Pagamento Instant�neo (PIX)
   * <li>18=Transfer�ncia banc�ria, Carteira Digital
   * <li>19=Programa de fidelidade, Cashback, Cr�dito Virtual
   * <li>90= Sem pagamento
   * <li>99=Outros<Br>
   * (Atualizado na NT2016.002, NT2020.006)
   */
  @RFWMetaStringField(caption = "Meio de Pagamento", minlength = 2, maxLength = 2, required = true, pattern = "^(01|02|03|04|05|10|11|12|13|14|15|16|17|18|19|90|99)$")
  private String tpag = null;

  /**
   * YA03 vPag Valor do Pagamento E YA01a N 1-1 13v2
   */
  @RFWMetaBigDecimalField(caption = "Valor do Pagamento", minValue = "0", maxValue = "9999999999999.99", scale = 0, scaleMax = 2, required = true)
  private BigDecimal vpag = null;

  /**
   * YA04a tpIntegra Tipo de Integra��o para pagamento E YA04 N 1-1 1<br>
   * Tipo de Integra��o do processo de pagamento com o sistema de automa��o da empresa: <br>
   * 1=Pagamento integrado com o sistema de automa��o da empresa (Ex.: equipamento TEF, Com�rcio Eletr�nico); <br>
   * 2= Pagamento n�o integrado com o sistema de automa��o da empresa (Ex.: equipamento POS);
   */
  @RFWMetaStringField(caption = "Tipo de Integra��o para Pagamento", minlength = 1, maxLength = 1, required = false, pattern = "^(1|2)$")
  private String tpIntegra = null;

  /**
   * YA05 CNPJ CNPJ da institui��o de pagamento E YA04 C 0-1 14<br>
   * Informar o CNPJ da institui��o de pagamento, adquirente ou subadquirente.<br>
   * Caso o pagamento seja processado pelo intermediador da transa��o, informar o CNPJ deste (Atualizado na NT 2020.006)<Br>
   * <Br>
   * <b>ATEN��O</b>: Deixei de validar o CNPJ com o {@link RFWMetaStringCNPJField} por ter encontrado notas autorizadas pela sefaz com o valor do campo definido apenas com zeros.
   */
  @RFWMetaStringField(caption = "CNPJ", minlength = 14, maxLength = 14, required = false, pattern = "\\d{14}")
  private String cnpj = null;

  /**
   * YA06 tBand Bandeira da operadora de cart�o de cr�dito e/ou d�bito E YA04 N 0-1 2<br>
   * <li>01=Visa
   * <li>02=Mastercard
   * <li>03=American Express
   * <li>04=Sorocred
   * <li>05=Diners Club
   * <li>06=Elo
   * <li>07=Hipercard
   * <li>08=Aura
   * <li>09=Cabal
   * <li>99=Outros <br>
   * (Atualizado na NT2016.002)
   */
  @RFWMetaStringField(caption = "Bandeira do Cart�o", minlength = 2, maxLength = 2, required = false, pattern = "^(01|02|03|04|05|06|07|08|09|99)$")
  private String tband = null;

  /**
   * YA07 cAut N�mero de autoriza��o da opera��o cart�o de cr�dito e/ou d�bito E YA04 C 0-1 1-20<br>
   * Identifica o n�mero da autoriza��o da transa��o da opera��o com cart�o de cr�dito e/ou d�bito
   */
  @RFWMetaStringField(caption = "N�mero de Autoriza��o", minlength = 1, maxLength = 20, required = false)
  private String caut = null;

  /**
   * # yA01b indPag Indicador da Forma de Pagamento E YA01a N 0-1 1<br>
   * <li>0= Pagamento � Vista
   * <li>1= Pagamento � Prazo (Inclu�do na NT2016.002).
   *
   * @return # yA01b indPag Indicador da Forma de Pagamento E YA01a N 0-1 1<br>
   *         <li>0= Pagamento � Vista
   *         <li>1= Pagamento � Prazo (Inclu�do na NT2016
   */
  public String getIndPag() {
    return indPag;
  }

  /**
   * # yA01b indPag Indicador da Forma de Pagamento E YA01a N 0-1 1<br>
   * <li>0= Pagamento � Vista
   * <li>1= Pagamento � Prazo (Inclu�do na NT2016.002).
   *
   * @param indPag # yA01b indPag Indicador da Forma de Pagamento E YA01a N 0-1 1<br>
   *          <li>0= Pagamento � Vista
   *          <li>1= Pagamento � Prazo (Inclu�do na NT2016
   */
  public void setIndPag(String indPag) {
    this.indPag = indPag;
  }

  /**
   * # yA02 tPag Meio de pagamento E YA01a N 1-1 2<br>
   * <li>01=Dinheiro
   * <li>02=Cheque
   * <li>03=Cart�o de Cr�dito
   * <li>04=Cart�o de D�bito
   * <li>05=Cr�dito Loja
   * <li>10=Vale Alimenta��o
   * <li>11=Vale Refei��o
   * <li>12=Vale Presente
   * <li>13=Vale Combust�vel
   * <li>15=Boleto Banc�rio
   * <li>16=Dep�sito Banc�rio
   * <li>17=Pagamento Instant�neo (PIX)
   * <li>18=Transfer�ncia banc�ria, Carteira Digital
   * <li>19=Programa de fidelidade, Cashback, Cr�dito Virtual
   * <li>90= Sem pagamento
   * <li>99=Outros<Br>
   * (Atualizado na NT2016.002, NT2020.006).
   *
   * @return # yA02 tPag Meio de pagamento E YA01a N 1-1 2<br>
   *         <li>01=Dinheiro
   *         <li>02=Cheque
   *         <li>03=Cart�o de Cr�dito
   *         <li>04=Cart�o de D�bito
   *         <li>05=Cr�dito Loja
   *         <li>10=Vale Alimenta��o
   *         <li>11=Vale Refei��o
   *         <li>12=Vale Presente
   *         <li>13=Vale Combust�vel
   *         <li>15=Boleto Banc�rio
   *         <li>16=Dep�sito Banc�rio
   *         <li>17=Pagamento Instant�neo (PIX)
   *         <li>18=Transfer�ncia banc�ria, Carteira Digital
   *         <li>19=Programa de fidelidade, Cashback, Cr�dito Virtual
   *         <li>90= Sem pagamento
   *         <li>99=Outros<Br>
   *         (Atualizado na NT2016
   */
  public String getTpag() {
    return tpag;
  }

  /**
   * # yA02 tPag Meio de pagamento E YA01a N 1-1 2<br>
   * <li>01=Dinheiro
   * <li>02=Cheque
   * <li>03=Cart�o de Cr�dito
   * <li>04=Cart�o de D�bito
   * <li>05=Cr�dito Loja
   * <li>10=Vale Alimenta��o
   * <li>11=Vale Refei��o
   * <li>12=Vale Presente
   * <li>13=Vale Combust�vel
   * <li>15=Boleto Banc�rio
   * <li>16=Dep�sito Banc�rio
   * <li>17=Pagamento Instant�neo (PIX)
   * <li>18=Transfer�ncia banc�ria, Carteira Digital
   * <li>19=Programa de fidelidade, Cashback, Cr�dito Virtual
   * <li>90= Sem pagamento
   * <li>99=Outros<Br>
   * (Atualizado na NT2016.002, NT2020.006).
   *
   * @param tpag # yA02 tPag Meio de pagamento E YA01a N 1-1 2<br>
   *          <li>01=Dinheiro
   *          <li>02=Cheque
   *          <li>03=Cart�o de Cr�dito
   *          <li>04=Cart�o de D�bito
   *          <li>05=Cr�dito Loja
   *          <li>10=Vale Alimenta��o
   *          <li>11=Vale Refei��o
   *          <li>12=Vale Presente
   *          <li>13=Vale Combust�vel
   *          <li>15=Boleto Banc�rio
   *          <li>16=Dep�sito Banc�rio
   *          <li>17=Pagamento Instant�neo (PIX)
   *          <li>18=Transfer�ncia banc�ria, Carteira Digital
   *          <li>19=Programa de fidelidade, Cashback, Cr�dito Virtual
   *          <li>90= Sem pagamento
   *          <li>99=Outros<Br>
   *          (Atualizado na NT2016
   */
  public void setTpag(String tpag) {
    this.tpag = tpag;
  }

  /**
   * # yA03 vPag Valor do Pagamento E YA01a N 1-1 13v2.
   *
   * @return # yA03 vPag Valor do Pagamento E YA01a N 1-1 13v2
   */
  public BigDecimal getVpag() {
    return vpag;
  }

  /**
   * # yA03 vPag Valor do Pagamento E YA01a N 1-1 13v2.
   *
   * @param vpag # yA03 vPag Valor do Pagamento E YA01a N 1-1 13v2
   */
  public void setVpag(BigDecimal vpag) {
    this.vpag = vpag;
  }

  /**
   * # yA04a tpIntegra Tipo de Integra��o para pagamento E YA04 N 1-1 1<br>
   * Tipo de Integra��o do processo de pagamento com o sistema de automa��o da empresa: <br>
   * 1=Pagamento integrado com o sistema de automa��o da empresa (Ex.: equipamento TEF, Com�rcio Eletr�nico); <br>
   * 2= Pagamento n�o integrado com o sistema de automa��o da empresa (Ex.: equipamento POS);.
   *
   * @return # yA04a tpIntegra Tipo de Integra��o para pagamento E YA04 N 1-1 1<br>
   *         Tipo de Integra��o do processo de pagamento com o sistema de automa��o da empresa: <br>
   *         1=Pagamento integrado com o sistema de automa��o da empresa (Ex
   */
  public String getTpIntegra() {
    return tpIntegra;
  }

  /**
   * # yA04a tpIntegra Tipo de Integra��o para pagamento E YA04 N 1-1 1<br>
   * Tipo de Integra��o do processo de pagamento com o sistema de automa��o da empresa: <br>
   * 1=Pagamento integrado com o sistema de automa��o da empresa (Ex.: equipamento TEF, Com�rcio Eletr�nico); <br>
   * 2= Pagamento n�o integrado com o sistema de automa��o da empresa (Ex.: equipamento POS);.
   *
   * @param tpIntegra # yA04a tpIntegra Tipo de Integra��o para pagamento E YA04 N 1-1 1<br>
   *          Tipo de Integra��o do processo de pagamento com o sistema de automa��o da empresa: <br>
   *          1=Pagamento integrado com o sistema de automa��o da empresa (Ex
   */
  public void setTpIntegra(String tpIntegra) {
    this.tpIntegra = tpIntegra;
  }

  /**
   * # yA05 CNPJ CNPJ da institui��o de pagamento E YA04 C 0-1 14<br>
   * Informar o CNPJ da institui��o de pagamento, adquirente ou subadquirente.<br>
   * Caso o pagamento seja processado pelo intermediador da transa��o, informar o CNPJ deste (Atualizado na NT 2020.006).
   *
   * @return # yA05 CNPJ CNPJ da institui��o de pagamento E YA04 C 0-1 14<br>
   *         Informar o CNPJ da institui��o de pagamento, adquirente ou subadquirente
   */
  public String getCnpj() {
    return cnpj;
  }

  /**
   * # yA05 CNPJ CNPJ da institui��o de pagamento E YA04 C 0-1 14<br>
   * Informar o CNPJ da institui��o de pagamento, adquirente ou subadquirente.<br>
   * Caso o pagamento seja processado pelo intermediador da transa��o, informar o CNPJ deste (Atualizado na NT 2020.006).
   *
   * @param cnpj # yA05 CNPJ CNPJ da institui��o de pagamento E YA04 C 0-1 14<br>
   *          Informar o CNPJ da institui��o de pagamento, adquirente ou subadquirente
   */
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  /**
   * # yA07 cAut N�mero de autoriza��o da opera��o cart�o de cr�dito e/ou d�bito E YA04 C 0-1 1-20<br>
   * Identifica o n�mero da autoriza��o da transa��o da opera��o com cart�o de cr�dito e/ou d�bito.
   *
   * @return # yA07 cAut N�mero de autoriza��o da opera��o cart�o de cr�dito e/ou d�bito E YA04 C 0-1 1-20<br>
   *         Identifica o n�mero da autoriza��o da transa��o da opera��o com cart�o de cr�dito e/ou d�bito
   */
  public String getCaut() {
    return caut;
  }

  /**
   * # yA07 cAut N�mero de autoriza��o da opera��o cart�o de cr�dito e/ou d�bito E YA04 C 0-1 1-20<br>
   * Identifica o n�mero da autoriza��o da transa��o da opera��o com cart�o de cr�dito e/ou d�bito.
   *
   * @param caut # yA07 cAut N�mero de autoriza��o da opera��o cart�o de cr�dito e/ou d�bito E YA04 C 0-1 1-20<br>
   *          Identifica o n�mero da autoriza��o da transa��o da opera��o com cart�o de cr�dito e/ou d�bito
   */
  public void setCaut(String caut) {
    this.caut = caut;
  }

  /**
   * # yA06 tBand Bandeira da operadora de cart�o de cr�dito e/ou d�bito E YA04 N 0-1 2<br>
   * <li>01=Visa
   * <li>02=Mastercard
   * <li>03=American Express
   * <li>04=Sorocred
   * <li>05=Diners Club
   * <li>06=Elo
   * <li>07=Hipercard
   * <li>08=Aura
   * <li>09=Cabal
   * <li>99=Outros <br>
   * (Atualizado na NT2016.002).
   *
   * @return # yA06 tBand Bandeira da operadora de cart�o de cr�dito e/ou d�bito E YA04 N 0-1 2<br>
   *         <li>01=Visa
   *         <li>02=Mastercard
   *         <li>03=American Express
   *         <li>04=Sorocred
   *         <li>05=Diners Club
   *         <li>06=Elo
   *         <li>07=Hipercard
   *         <li>08=Aura
   *         <li>09=Cabal
   *         <li>99=Outros <br>
   *         (Atualizado na NT2016
   */
  public String getTband() {
    return tband;
  }

  /**
   * # yA06 tBand Bandeira da operadora de cart�o de cr�dito e/ou d�bito E YA04 N 0-1 2<br>
   * <li>01=Visa
   * <li>02=Mastercard
   * <li>03=American Express
   * <li>04=Sorocred
   * <li>05=Diners Club
   * <li>06=Elo
   * <li>07=Hipercard
   * <li>08=Aura
   * <li>09=Cabal
   * <li>99=Outros <br>
   * (Atualizado na NT2016.002).
   *
   * @param tband # yA06 tBand Bandeira da operadora de cart�o de cr�dito e/ou d�bito E YA04 N 0-1 2<br>
   *          <li>01=Visa
   *          <li>02=Mastercard
   *          <li>03=American Express
   *          <li>04=Sorocred
   *          <li>05=Diners Club
   *          <li>06=Elo
   *          <li>07=Hipercard
   *          <li>08=Aura
   *          <li>09=Cabal
   *          <li>99=Outros <br>
   *          (Atualizado na NT2016
   */
  public void setTband(String tband) {
    this.tband = tband;
  }

}
