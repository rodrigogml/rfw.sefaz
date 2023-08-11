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
 * Description: VO para identificar o emissor da Nota Fiscal Eletrônica.<br>
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
   * Na emissão de NF-e avulsa pelo Fisco, as informações do remetente serão informadas neste grupo. O CNPJ ou CPF deverão ser informados com os zeros não significativos. <br>
   * TAG: /nfeProc/NFe/infNFe/emit/CNPJ, ou<br>
   * TAG: /nfeProc/NFe/infNFe/emit/CPF
   */
  @RFWMetaStringCPFOrCNPJField(caption = "CPF/CNPJ Emissor", required = false)
  private String cpfCnpj = null;

  /**
   * Razão Social ou Nome do emitente<br>
   * <br>
   * TAG: NFe/infNFe/emit/xNome
   */
  @RFWMetaStringField(caption = "Nome/Razão Social do Emissor", required = false, minlength = 2, maxlength = 60)
  private String name = null;

  /**
   * Nome fantasia<br>
   * <Br>
   * TAG: NFe/infNFe/emit/xFant
   */
  @RFWMetaStringField(caption = "Nome Fantasia", required = false, maxlength = 60)
  private String brandName = null;

  /**
   * Inscrição Estadual do Emitente<br>
   * Informar somente os algarismos, sem os caracteres de formatação (ponto, barra, hífen, etc.).<Br>
   * Descrição da TAG no XML: Informar a IE do emitente da NF de Produtor ou o literal “ISENTO” (v2.0)<Br>
   * <bR>
   * Aqui no VO a tag deve conter apenas o IE do emitente da NF. No caso do IE ser isento, o atributo {@link #ieIsento} deve ser definido como nulo e este atributo deixado nulo. <br>
   * <Br>
   * TAG: NFe/infNFe/emit/IE
   */
  @RFWMetaStringIEField(caption = "IE", required = false)
  private String ie = null;

  /**
   * Quando o conrtibuinte emissor for Isento de IE, deixar o {@link #ie} como <code>null</code> e definir esta flag como TRUE.<br>
   * Quando não for preencher {@link #ie} e definir esta flag como FALSE.<br>
   * Obrigatória para {@link NFReferencedDocType#NFRURALPRODUCTOR}
   */
  @RFWMetaBooleanField(caption = "IE Isento", required = false)
  private Boolean ieIsento = null;

  /**
   * IE do Substituto Tributário<br>
   * IE do Substituto Tributário da UF de destino da mercadoria, quando houver a retenção do ICMS ST para a UF de destino. <br>
   * <br>
   * TAG: NFe/infNFe/emit/IEST
   */
  @RFWMetaStringField(caption = "IEST", required = false, maxlength = 14, minlength = 2)
  private String iest = null;

  /**
   * Inscrição Municipal do Prestador de Serviço<br>
   * Informado na emissão de NF-e conjugada, com itens de produtos sujeitos ao ICMS e itens de serviços sujeitos ao ISSQN.<br>
   * <br>
   * TAG: NFe/infNFe/emit/IM
   */
  @RFWMetaStringField(caption = "IM", required = false, maxlength = 15, minlength = 1)
  private String im = null;

  /**
   * CNAE fiscal<Br>
   * Campo Opcional. Pode ser informado quando a Inscrição Municipal (id:C19) for informada.
   */
  @RFWMetaStringField(caption = "CNAE", required = false, maxlength = 7)
  private String cnae = null;

  /**
   * Código de Regime Tributário.<Br>
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
  @RFWMetaStringField(caption = "Endereço", required = false, minlength = 2, maxlength = 60)
  private String addressStreet = null;

  /**
   * Nùmero do Endereço<br>
   * <br>
   * TAG: NFe/infNFe/emit/enderEmit/nro
   */
  @RFWMetaStringField(caption = "Número", required = false, maxlength = 60)
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
   * Nome do município<br>
   * <br>
   * TAG: NFe/infNFe/emit/enderEmit/xMun
   */
  @RFWMetaStringField(caption = "Cidade", required = false, maxlength = 60)
  private String addressCity = null;

  /**
   * Código do município<br>
   * Utilizar a Tabela do IBGE (Seção 8.2 do MOC – Visão Geral, Tabela de UF, Município e País).<br>
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
   * Código CEP do endereço<br>
   * Informar os zeros não significativos. (NT 2011/004)<br>
   * <br>
   * TAG: NFe/infNFe/emit/enderEmit/CEP
   */
  @RFWMetaStringCEPField(caption = "CEP", required = false)
  private String addressCEP = null;

  /**
   * Nome do País<br>
   * <br>
   * TAG: NFe/infNFe/emit/enderEmit/xPais
   */
  @RFWMetaStringField(caption = "País", required = false, maxlength = 60)
  private String addressCountry = null;

  /**
   * Código do País<br>
   * <br>
   * TAG: NFe/infNFe/emit/enderEmit/cPais
   */
  @RFWMetaIntegerField(caption = "País (Cod. IBGE)", required = false)
  private Integer addressCountryCode = null;

}