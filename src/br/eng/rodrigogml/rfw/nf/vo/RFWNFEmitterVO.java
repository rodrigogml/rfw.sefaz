package br.eng.rodrigogml.rfw.nf.vo;

import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaBooleanField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaEnumField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaIntegerField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCEPField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringCPFOrCNPJField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringField;
import br.eng.rodrigogml.rfw.kernel.rfwmeta.RFWMetaStringIEField;
import br.eng.rodrigogml.rfw.kernel.vo.RFWVO;
import br.eng.rodrigogml.rfw.nf.vo.RFWNFReferencedDocVO.NFReferencedDocType;
import br.eng.rodrigogml.rfw.sefaz.SEFAZDefinitions.SefazTaxSystem;

/**
 * Description: VO para identificar o emissor da Nota Fiscal Eletr�nica.<br>
 *
 * @author Rodrigo GML
 * @since 1.0.0 (11 de ago. de 2023)
 * @version 1.0.0 - Rodrigo GML-(...)
 */
public class RFWNFEmitterVO extends RFWVO {

  private static final long serialVersionUID = 1271952553549861696L;

  /**
   * CPF ou CNPJ do emitente.<br>
   * Informar o CPF/CNPJ do emitente.<br>
   * Na emiss�o de NF-e avulsa pelo Fisco, as informa��es do remetente ser�o informadas neste grupo. O CNPJ ou CPF dever�o ser informados com os zeros n�o significativos. <br>
   * TAG: /nfeProc/NFe/infNFe/emit/CNPJ, ou<br>
   * TAG: /nfeProc/NFe/infNFe/emit/CPF
   */
  @RFWMetaStringCPFOrCNPJField(caption = "CPF/CNPJ Emissor", required = false)
  private String cpfCnpj = null;

  /**
   * Raz�o Social ou Nome do emitente<br>
   * <br>
   * TAG: NFe/infNFe/emit/xNome
   */
  @RFWMetaStringField(caption = "Nome/Raz�o Social do Emissor", required = false, minlength = 2, maxlength = 60)
  private String name = null;

  /**
   * Nome fantasia<br>
   * <Br>
   * TAG: NFe/infNFe/emit/xFant
   */
  @RFWMetaStringField(caption = "Nome Fantasia", required = false, maxlength = 60)
  private String brandName = null;

  /**
   * Inscri��o Estadual do Emitente<br>
   * Informar somente os algarismos, sem os caracteres de formata��o (ponto, barra, h�fen, etc.).<Br>
   * Descri��o da TAG no XML: Informar a IE do emitente da NF de Produtor ou o literal �ISENTO� (v2.0)<Br>
   * <bR>
   * Aqui no VO a tag deve conter apenas o IE do emitente da NF. No caso do IE ser isento, o atributo {@link #ieIsento} deve ser definido como nulo e este atributo deixado nulo. <br>
   * <Br>
   * TAG: NFe/infNFe/emit/IE
   */
  @RFWMetaStringIEField(caption = "IE", required = false)
  private String ie = null;

  /**
   * Quando o conrtibuinte emissor for Isento de IE, deixar o {@link #ie} como <code>null</code> e definir esta flag como TRUE.<br>
   * Quando n�o for preencher {@link #ie} e definir esta flag como FALSE.<br>
   * Obrigat�ria para {@link NFReferencedDocType#NFRURALPRODUCTOR}
   */
  @RFWMetaBooleanField(caption = "IE Isento", required = false)
  private Boolean ieIsento = null;

  /**
   * IE do Substituto Tribut�rio<br>
   * IE do Substituto Tribut�rio da UF de destino da mercadoria, quando houver a reten��o do ICMS ST para a UF de destino. <br>
   * <br>
   * TAG: NFe/infNFe/emit/IEST
   */
  @RFWMetaStringField(caption = "IEST", required = false, maxlength = 14, minlength = 2)
  private String iest = null;

  /**
   * Inscri��o Municipal do Prestador de Servi�o<br>
   * Informado na emiss�o de NF-e conjugada, com itens de produtos sujeitos ao ICMS e itens de servi�os sujeitos ao ISSQN.<br>
   * <br>
   * TAG: NFe/infNFe/emit/IM
   */
  @RFWMetaStringField(caption = "IM", required = false, maxlength = 15, minlength = 1)
  private String im = null;

  /**
   * CNAE fiscal<Br>
   * Campo Opcional. Pode ser informado quando a Inscri��o Municipal (id:C19) for informada.
   */
  @RFWMetaStringField(caption = "CNAE", required = false, maxlength = 7)
  private String cnae = null;

  /**
   * C�digo de Regime Tribut�rio.<Br>
   * <li>1=Simples Nacional;
   * <li>2=Simples Nacional, excesso sublimite de receita bruta;
   * <li>3=Regime Normal. (v2.0).
   */
  @RFWMetaEnumField(caption = "CRT", required = false)
  private SefazTaxSystem crt = null;

  /**
   * Logradouro <br>
   * <br>
   * TAG: NFe/infNFe/emit/enderEmit/xLgr
   */
  @RFWMetaStringField(caption = "Endere�o", required = false, minlength = 2, maxlength = 60)
  private String addressStreet = null;

  /**
   * N�mero do Endere�o<br>
   * <br>
   * TAG: NFe/infNFe/emit/enderEmit/nro
   */
  @RFWMetaStringField(caption = "N�mero", required = false, maxlength = 60)
  private String addressNumber = null;

  /**
   * Complemento <br>
   * <br>
   * TAG: NFe/infNFe/emit/enderEmit/xCpl
   */
  @RFWMetaStringField(caption = "Complemento", required = false, maxlength = 60)
  private String addressComplement = null;

  /**
   * Bairro<br>
   * <br>
   * TAG: NFe/infNFe/emit/enderEmit/xBairro
   */
  @RFWMetaStringField(caption = "Bairro", required = false, maxlength = 60)
  private String addressNeighborhood = null;

  /**
   * Nome do munic�pio<br>
   * <br>
   * TAG: NFe/infNFe/emit/enderEmit/xMun
   */
  @RFWMetaStringField(caption = "Cidade", required = false, maxlength = 60)
  private String addressCity = null;

  /**
   * C�digo do munic�pio<br>
   * Utilizar a Tabela do IBGE (Se��o 8.2 do MOC � Vis�o Geral, Tabela de UF, Munic�pio e Pa�s).<br>
   * <br>
   * TAG: NFe/infNFe/emit/enderEmit/cMun
   */
  @RFWMetaIntegerField(caption = "Cidade (Cod. IBGE)", required = false)
  private Integer addressCityCode = null;

  /**
   * UF - Sigla da UF<br>
   * <br>
   * TAG: NFe/infNFe/emit/enderEmit/UF
   */
  @RFWMetaStringField(caption = "UF", required = false, maxlength = 2, minlength = 2, pattern = "[a-zA-Z]{2}")
  private String addressUF = null;

  /**
   * C�digo CEP do endere�o<br>
   * Informar os zeros n�o significativos. (NT 2011/004)<br>
   * <br>
   * TAG: NFe/infNFe/emit/enderEmit/CEP
   */
  @RFWMetaStringCEPField(caption = "CEP", required = false)
  private String addressCEP = null;

  /**
   * Nome do Pa�s<br>
   * <br>
   * TAG: NFe/infNFe/emit/enderEmit/xPais
   */
  @RFWMetaStringField(caption = "Pa�s", required = false, maxlength = 60)
  private String addressCountry = null;

  /**
   * C�digo do Pa�s<br>
   * <br>
   * TAG: NFe/infNFe/emit/enderEmit/cPais
   */
  @RFWMetaIntegerField(caption = "Pa�s (Cod. IBGE)", required = false)
  private Integer addressCountryCode = null;

}