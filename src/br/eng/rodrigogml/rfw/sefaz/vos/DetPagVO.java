package br.eng.rodrigogml.rfw.sefaz.vos;

import java.math.BigDecimal;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBigDecimalField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCNPJField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;

/**
 * Description: Este bean representa a tag "detPag" do layout de XML.<br>
 * A estrutura foi toda montada com base no {@link RFWVO} para aproveitar a integração com o framework, pertindo a validação e até a persistência se o sistema assim desejar. Não há preocupação de gerar JavaDOC nestas classes pois ela deve representar exatamente a documentação da NFe.
 *
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Criado a partir do documento MOC 7.0, ANexo I - Layout e Regras de Validação da NF-e.
 */
public class DetPagVO extends RFWVO {

  private static final long serialVersionUID = -3849585851784413452L;

  /**
   * YA01b indPag Indicador da Forma de Pagamento E YA01a N 0-1 1<br>
   * <li>0= Pagamento à Vista
   * <li>1= Pagamento à Prazo (Incluído na NT2016.002)
   */
  @RFWMetaStringField(caption = "Indicador da Forma de Pagamento", minlength = 1, maxLength = 1, required = false, pattern = "^(0|1)$")
  private String indPag = null;

  /**
   * YA02 tPag Meio de pagamento E YA01a N 1-1 2<br>
   * <li>01=Dinheiro
   * <li>02=Cheque
   * <li>03=Cartão de Crédito
   * <li>04=Cartão de Débito
   * <li>05=Crédito Loja
   * <li>10=Vale Alimentação
   * <li>11=Vale Refeição
   * <li>12=Vale Presente
   * <li>13=Vale Combustível
   * <li><s>14=Duplicata Mercantil</s> - Excluído na NT2016.002
   * <li>15=Boleto Bancário
   * <li>16=Depósito Bancário
   * <li>17=Pagamento Instantâneo (PIX)
   * <li>18=Transferência bancária, Carteira Digital
   * <li>19=Programa de fidelidade, Cashback, Crédito Virtual
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
   * YA04a tpIntegra Tipo de Integração para pagamento E YA04 N 1-1 1<br>
   * Tipo de Integração do processo de pagamento com o sistema de automação da empresa: <br>
   * 1=Pagamento integrado com o sistema de automação da empresa (Ex.: equipamento TEF, Comércio Eletrônico); <br>
   * 2= Pagamento não integrado com o sistema de automação da empresa (Ex.: equipamento POS);
   */
  @RFWMetaStringField(caption = "Tipo de Integração para Pagamento", minlength = 1, maxLength = 1, required = false, pattern = "^(1|2)$")
  private String tpIntegra = null;

  /**
   * YA05 CNPJ CNPJ da instituição de pagamento E YA04 C 0-1 14<br>
   * Informar o CNPJ da instituição de pagamento, adquirente ou subadquirente.<br>
   * Caso o pagamento seja processado pelo intermediador da transação, informar o CNPJ deste (Atualizado na NT 2020.006)<Br>
   * <Br>
   * <b>ATENÇÃO</b>: Deixei de validar o CNPJ com o {@link RFWMetaStringCNPJField} por ter encontrado notas autorizadas pela sefaz com o valor do campo definido apenas com zeros.
   */
  @RFWMetaStringField(caption = "CNPJ", minlength = 14, maxLength = 14, required = false, pattern = "\\d{14}")
  private String cnpj = null;

  /**
   * YA06 tBand Bandeira da operadora de cartão de crédito e/ou débito E YA04 N 0-1 2<br>
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
  @RFWMetaStringField(caption = "Bandeira do Cartão", minlength = 2, maxLength = 2, required = false, pattern = "^(01|02|03|04|05|06|07|08|09|99)$")
  private String tband = null;

  /**
   * YA07 cAut Número de autorização da operação cartão de crédito e/ou débito E YA04 C 0-1 1-20<br>
   * Identifica o número da autorização da transação da operação com cartão de crédito e/ou débito
   */
  @RFWMetaStringField(caption = "Número de Autorização", minlength = 1, maxLength = 20, required = false)
  private String caut = null;

  /**
   * # yA01b indPag Indicador da Forma de Pagamento E YA01a N 0-1 1<br>
   * <li>0= Pagamento à Vista
   * <li>1= Pagamento à Prazo (Incluído na NT2016.002).
   *
   * @return # yA01b indPag Indicador da Forma de Pagamento E YA01a N 0-1 1<br>
   *         <li>0= Pagamento à Vista
   *         <li>1= Pagamento à Prazo (Incluído na NT2016
   */
  public String getIndPag() {
    return indPag;
  }

  /**
   * # yA01b indPag Indicador da Forma de Pagamento E YA01a N 0-1 1<br>
   * <li>0= Pagamento à Vista
   * <li>1= Pagamento à Prazo (Incluído na NT2016.002).
   *
   * @param indPag # yA01b indPag Indicador da Forma de Pagamento E YA01a N 0-1 1<br>
   *          <li>0= Pagamento à Vista
   *          <li>1= Pagamento à Prazo (Incluído na NT2016
   */
  public void setIndPag(String indPag) {
    this.indPag = indPag;
  }

  /**
   * # yA02 tPag Meio de pagamento E YA01a N 1-1 2<br>
   * <li>01=Dinheiro
   * <li>02=Cheque
   * <li>03=Cartão de Crédito
   * <li>04=Cartão de Débito
   * <li>05=Crédito Loja
   * <li>10=Vale Alimentação
   * <li>11=Vale Refeição
   * <li>12=Vale Presente
   * <li>13=Vale Combustível
   * <li>15=Boleto Bancário
   * <li>16=Depósito Bancário
   * <li>17=Pagamento Instantâneo (PIX)
   * <li>18=Transferência bancária, Carteira Digital
   * <li>19=Programa de fidelidade, Cashback, Crédito Virtual
   * <li>90= Sem pagamento
   * <li>99=Outros<Br>
   * (Atualizado na NT2016.002, NT2020.006).
   *
   * @return # yA02 tPag Meio de pagamento E YA01a N 1-1 2<br>
   *         <li>01=Dinheiro
   *         <li>02=Cheque
   *         <li>03=Cartão de Crédito
   *         <li>04=Cartão de Débito
   *         <li>05=Crédito Loja
   *         <li>10=Vale Alimentação
   *         <li>11=Vale Refeição
   *         <li>12=Vale Presente
   *         <li>13=Vale Combustível
   *         <li>15=Boleto Bancário
   *         <li>16=Depósito Bancário
   *         <li>17=Pagamento Instantâneo (PIX)
   *         <li>18=Transferência bancária, Carteira Digital
   *         <li>19=Programa de fidelidade, Cashback, Crédito Virtual
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
   * <li>03=Cartão de Crédito
   * <li>04=Cartão de Débito
   * <li>05=Crédito Loja
   * <li>10=Vale Alimentação
   * <li>11=Vale Refeição
   * <li>12=Vale Presente
   * <li>13=Vale Combustível
   * <li>15=Boleto Bancário
   * <li>16=Depósito Bancário
   * <li>17=Pagamento Instantâneo (PIX)
   * <li>18=Transferência bancária, Carteira Digital
   * <li>19=Programa de fidelidade, Cashback, Crédito Virtual
   * <li>90= Sem pagamento
   * <li>99=Outros<Br>
   * (Atualizado na NT2016.002, NT2020.006).
   *
   * @param tpag # yA02 tPag Meio de pagamento E YA01a N 1-1 2<br>
   *          <li>01=Dinheiro
   *          <li>02=Cheque
   *          <li>03=Cartão de Crédito
   *          <li>04=Cartão de Débito
   *          <li>05=Crédito Loja
   *          <li>10=Vale Alimentação
   *          <li>11=Vale Refeição
   *          <li>12=Vale Presente
   *          <li>13=Vale Combustível
   *          <li>15=Boleto Bancário
   *          <li>16=Depósito Bancário
   *          <li>17=Pagamento Instantâneo (PIX)
   *          <li>18=Transferência bancária, Carteira Digital
   *          <li>19=Programa de fidelidade, Cashback, Crédito Virtual
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
   * # yA04a tpIntegra Tipo de Integração para pagamento E YA04 N 1-1 1<br>
   * Tipo de Integração do processo de pagamento com o sistema de automação da empresa: <br>
   * 1=Pagamento integrado com o sistema de automação da empresa (Ex.: equipamento TEF, Comércio Eletrônico); <br>
   * 2= Pagamento não integrado com o sistema de automação da empresa (Ex.: equipamento POS);.
   *
   * @return # yA04a tpIntegra Tipo de Integração para pagamento E YA04 N 1-1 1<br>
   *         Tipo de Integração do processo de pagamento com o sistema de automação da empresa: <br>
   *         1=Pagamento integrado com o sistema de automação da empresa (Ex
   */
  public String getTpIntegra() {
    return tpIntegra;
  }

  /**
   * # yA04a tpIntegra Tipo de Integração para pagamento E YA04 N 1-1 1<br>
   * Tipo de Integração do processo de pagamento com o sistema de automação da empresa: <br>
   * 1=Pagamento integrado com o sistema de automação da empresa (Ex.: equipamento TEF, Comércio Eletrônico); <br>
   * 2= Pagamento não integrado com o sistema de automação da empresa (Ex.: equipamento POS);.
   *
   * @param tpIntegra # yA04a tpIntegra Tipo de Integração para pagamento E YA04 N 1-1 1<br>
   *          Tipo de Integração do processo de pagamento com o sistema de automação da empresa: <br>
   *          1=Pagamento integrado com o sistema de automação da empresa (Ex
   */
  public void setTpIntegra(String tpIntegra) {
    this.tpIntegra = tpIntegra;
  }

  /**
   * # yA05 CNPJ CNPJ da instituição de pagamento E YA04 C 0-1 14<br>
   * Informar o CNPJ da instituição de pagamento, adquirente ou subadquirente.<br>
   * Caso o pagamento seja processado pelo intermediador da transação, informar o CNPJ deste (Atualizado na NT 2020.006).
   *
   * @return # yA05 CNPJ CNPJ da instituição de pagamento E YA04 C 0-1 14<br>
   *         Informar o CNPJ da instituição de pagamento, adquirente ou subadquirente
   */
  public String getCnpj() {
    return cnpj;
  }

  /**
   * # yA05 CNPJ CNPJ da instituição de pagamento E YA04 C 0-1 14<br>
   * Informar o CNPJ da instituição de pagamento, adquirente ou subadquirente.<br>
   * Caso o pagamento seja processado pelo intermediador da transação, informar o CNPJ deste (Atualizado na NT 2020.006).
   *
   * @param cnpj # yA05 CNPJ CNPJ da instituição de pagamento E YA04 C 0-1 14<br>
   *          Informar o CNPJ da instituição de pagamento, adquirente ou subadquirente
   */
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  /**
   * # yA07 cAut Número de autorização da operação cartão de crédito e/ou débito E YA04 C 0-1 1-20<br>
   * Identifica o número da autorização da transação da operação com cartão de crédito e/ou débito.
   *
   * @return # yA07 cAut Número de autorização da operação cartão de crédito e/ou débito E YA04 C 0-1 1-20<br>
   *         Identifica o número da autorização da transação da operação com cartão de crédito e/ou débito
   */
  public String getCaut() {
    return caut;
  }

  /**
   * # yA07 cAut Número de autorização da operação cartão de crédito e/ou débito E YA04 C 0-1 1-20<br>
   * Identifica o número da autorização da transação da operação com cartão de crédito e/ou débito.
   *
   * @param caut # yA07 cAut Número de autorização da operação cartão de crédito e/ou débito E YA04 C 0-1 1-20<br>
   *          Identifica o número da autorização da transação da operação com cartão de crédito e/ou débito
   */
  public void setCaut(String caut) {
    this.caut = caut;
  }

  /**
   * # yA06 tBand Bandeira da operadora de cartão de crédito e/ou débito E YA04 N 0-1 2<br>
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
   * @return # yA06 tBand Bandeira da operadora de cartão de crédito e/ou débito E YA04 N 0-1 2<br>
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
   * # yA06 tBand Bandeira da operadora de cartão de crédito e/ou débito E YA04 N 0-1 2<br>
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
   * @param tband # yA06 tBand Bandeira da operadora de cartão de crédito e/ou débito E YA04 N 0-1 2<br>
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
