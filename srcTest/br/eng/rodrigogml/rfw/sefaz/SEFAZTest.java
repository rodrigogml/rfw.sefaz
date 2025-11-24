package br.eng.rodrigogml.rfw.sefaz;

// Codificação UTF-8 – caracteres de exemplo: á, é, í, ó, ú, ç.

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.eng.rodrigogml.rfw.kernel.RFW;
import br.eng.rodrigogml.rfw.kernel.exceptions.RFWException;
import br.eng.rodrigogml.rfw.kernel.exceptions.RFWRunTimeException;
import br.eng.rodrigogml.rfw.kernel.interfaces.RFWCertificate;
import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess;
import br.eng.rodrigogml.rfw.kernel.utils.RUFile;
import br.eng.rodrigogml.rfw.kernel.utils.RUTypes;
import br.eng.rodrigogml.rfw.kernel.utils.RUValueValidation;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CRT;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CST_COFINS;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CST_PIS;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_WebServices;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_finNFe;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_idDest;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indFinal;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indIntermed;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indPres;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indSinc;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_mod;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_procEmi;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tpAmb;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tpEmis;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tpImp;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tpNF;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_versao;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZUtils;

import xsdobjects.consCad200.TRetConsCad;
import xsdobjects.consStatServ400.TRetConsStatServ;
import xsdobjects.enviNFe400.TEnderEmi;
import xsdobjects.enviNFe400.TEnviNFe;
import xsdobjects.enviNFe400.TNFe;
import xsdobjects.enviNFe400.TRetEnviNFe;
import xsdobjects.enviNFe400.TUfEmi;

/**
 * Description: Classe de teste da {@link SEFAZ}.<br>
 *
 * @author Rodrigo GML
 * @since 1.0.0 (24 de ago. de 2023)
 * @version 1.0.0 - Rodrigo GML-(...)
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SEFAZTest {

  private RFWCertificate cert = null;

  // private RFWCertificate trust = null;

  @Before
  public void initialize() throws RFWException {
    String certPath = RFW.getDevProperty("rfw.sefaz.cert.path");
    String certPass = RFW.getDevProperty("rfw.sefaz.cert.pass");
    PreProcess.requiredNonNull(certPath);
    PreProcess.requiredNonNull(certPass);

    String trustPath = RFW.getDevProperty("rfw.sefaz.trust.path");
    String trustPass = RFW.getDevProperty("rfw.sefaz.trust.pass");
    PreProcess.requiredNonNull(trustPath);
    PreProcess.requiredNonNull(trustPass);

    cert = new RFWCertificate() {
      @Override
      public CertificateType getType() {
        return CertificateType.A1;
      }

      @Override
      public String getCertificateFilePassword() {
        return certPass;
      }

      @Override
      public byte[] getCertificateFileContent() {
        try {
          return RUFile.readFileContent(certPath);
        } catch (RFWException e) {
          throw new RFWRunTimeException(e);
        }
      }
    };
  }

  @Test
  public void t00_consultaCadastroCPF() throws RFWException {
    SEFAZ sefaz = new SEFAZ(cert, SEFAZ_WebServices.SP, SEFAZ_tpAmb.PRODUCAO, SEFAZ_tpEmis.EMISSAO_NORMAL);

    final String cpf = "12345678910";
    TRetConsCad root = sefaz.consultaCadastroV200byCPF(cpf);

    assertEquals(root.getInfCons().getCPF(), cpf);
  }

  @Test
  public void t01_consultaCadastroCNPJ() throws RFWException {
    SEFAZ sefaz = new SEFAZ(cert, SEFAZ_WebServices.SP, SEFAZ_tpAmb.PRODUCAO, SEFAZ_tpEmis.EMISSAO_NORMAL);

    final String cnpj = "45990181000189";
    TRetConsCad root = sefaz.consultaCadastroV200byCNPJ(cnpj);
    assertEquals(root.getInfCons().getCNPJ(), cnpj);
    assertEquals(root.getInfCons().getInfCad().get(0).getXNome(), "ROBERT BOSCH LIMITADA");
  }

  @Test
  public void t03_enviaNFCe_Homologacao_SP() throws RFWException {
    SEFAZ sefaz = new SEFAZ(cert, SEFAZ_WebServices.SP, SEFAZ_tpAmb.HOMOLOGACAO, SEFAZ_tpEmis.EMISSAO_NORMAL);
    TEnviNFe tNFe = mountSampleNFCeHomologationMessage();

    Object[] ret = sefaz.nfeAutorizacaoLoteV400(tNFe);
    TRetEnviNFe retEnvi = (TRetEnviNFe) ret[1];
    assertEquals("100", retEnvi.getCStat());
  }

  @Test
  public void t04_nfeStatusServicoNFV400() throws RFWException {
    SEFAZ sefaz = new SEFAZ(cert, SEFAZ_WebServices.SP, SEFAZ_tpAmb.HOMOLOGACAO, SEFAZ_tpEmis.EMISSAO_NORMAL);

    TRetConsStatServ ret = sefaz.nfeStatusServicoNFV400(SEFAZ_mod.NFCE_MODELO_65);
    System.out.println(ret.getCStat());
    System.out.println(ret.getXMotivo());
    assertEquals("107", ret.getCStat());

    ret = sefaz.nfeStatusServicoNFV400(SEFAZ_mod.NFE_MODELO_55);
    System.out.println(ret.getCStat());
    System.out.println(ret.getXMotivo());
    assertEquals("107", ret.getCStat());
  }

  /**
   * Monta um objeto de exemplo de NFC-e vlida para ambiente de homologao.
   *
   * @return Objeto pronto para assinatura e envio ao webservice de autorizao.
   * @throws RFWException Caso ocorra falha ao calcular informaes derivadas (ex.: hashes).
   */
  // TODO Me apague
  public static TEnviNFe mountSampleNFCeHomologationMessage() throws RFWException {
    final String cUF = RFW.getDevProperty("rfw.sefaz.nfce.cuf");
    final String emitCnpj = RFW.getDevProperty("rfw.sefaz.nfce.cnpj");
    final int serie = Integer.parseInt(RFW.getDevProperty("rfw.sefaz.nfce.serie"));
    final int numero = Integer.parseInt(RFW.getDevProperty("rfw.sefaz.nfce.number"));
    final String emitXNome = RFW.getDevProperty("rfw.sefaz.nfce.xnome");
    final String emitXFant = RFW.getDevProperty("rfw.sefaz.nfce.xfant");
    final String emitIE = RFW.getDevProperty("rfw.sefaz.nfce.ie");
    final String emitCRT = SEFAZ_CRT.REGIME_NORMAL.getXmlData();

    // Dados de preenchimento do documento
    final LocalDateTime emissionDate = RFW.getDateTime();
    final String cNF = "87654321";
    final SEFAZ_tpAmb tpAmb = SEFAZ_tpAmb.HOMOLOGACAO;
    final String tpEmis = SEFAZ_tpEmis.EMISSAO_NORMAL.getXmlData();
    final DateTimeFormatter aammFormatter = DateTimeFormatter.ofPattern("yyMM", RFW.getLocale());
    final String aamm = emissionDate.atZone(RFW.getZoneId()).format(aammFormatter);
    final String chaveSemDV = cUF + aamm + emitCnpj + SEFAZ_mod.NFCE_MODELO_65.getXmlData() + String.format(RFW.getLocale(), "%03d", serie) + String.format(Locale.ROOT, "%09d", numero) + tpEmis + cNF;
    final String dv = "" + RUValueValidation.calcDVDANFeV400(chaveSemDV);
    final String chave = chaveSemDV + dv;
    final String cMunFG = "3509502";

    TEnviNFe enviNFe = new TEnviNFe();
    enviNFe.setVersao(SEFAZ_versao.VERSAO_4_00.getXmlData());
    enviNFe.setIdLote("000000000000001");
    enviNFe.setIndSinc(SEFAZ_indSinc.SOLICITA_SINCRONO.getXmlData());

    TNFe nfe = new TNFe();
    enviNFe.getNFe().add(nfe);

    TNFe.InfNFe infNFe = new TNFe.InfNFe();
    infNFe.setVersao(SEFAZ_versao.VERSAO_4_00.getXmlData());
    infNFe.setId("NFe" + chave);
    nfe.setInfNFe(infNFe);

    String dhEmiUtc = RUTypes.formatToyyyy_MM_dd_T_HH_mm_ssXXX(emissionDate, RFW.getZoneId());

    TNFe.InfNFe.Ide ide = new TNFe.InfNFe.Ide();
    ide.setCUF(cUF);
    ide.setCNF(cNF);
    ide.setNatOp("VENDA AO CONSUMIDOR");
    ide.setMod(SEFAZ_mod.NFCE_MODELO_65.getXmlData());
    ide.setSerie(Integer.toString(serie));
    ide.setNNF(Integer.toString(numero));
    ide.setDhEmi(dhEmiUtc);
    ide.setTpNF(SEFAZ_tpNF.SAIDA.getXmlData());
    ide.setIdDest(SEFAZ_idDest.OPERACAO_INTERNA.getXmlData());
    ide.setCMunFG(cMunFG);
    ide.setTpImp(SEFAZ_tpImp.DANFE_NFCE.getXmlData());
    ide.setTpEmis(tpEmis);
    ide.setCDV(dv);
    ide.setTpAmb(tpAmb.getXmlData());
    ide.setFinNFe(SEFAZ_finNFe.NFE_NORMAL.getXmlData());
    ide.setIndFinal(SEFAZ_indFinal.CONSUMIDOR_FINAL.getXmlData());
    ide.setIndPres(SEFAZ_indPres.OPERACAO_PRESENCIAL.getXmlData());
    ide.setIndIntermed(SEFAZ_indIntermed.SEM_INTERMEDIADOR.getXmlData());
    ide.setProcEmi(SEFAZ_procEmi.EMISSAO_CONTRIBUINTE.getXmlData());
    ide.setVerProc("RFW-TESTE 1.0.0");
    infNFe.setIde(ide);

    TEnderEmi emitAddress = new TEnderEmi();
    emitAddress.setXLgr("Rua das Flores");
    emitAddress.setNro("100");
    emitAddress.setXBairro("Centro");
    emitAddress.setCMun(cMunFG);
    emitAddress.setXMun("Campinas");
    emitAddress.setUF(TUfEmi.SP);
    emitAddress.setCEP("13013177");
    emitAddress.setCPais("1058");
    emitAddress.setXPais("Brasil");
    emitAddress.setFone("1130000000");

    TNFe.InfNFe.Emit emit = new TNFe.InfNFe.Emit();
    emit.setCNPJ(emitCnpj);
    emit.setXNome(emitXNome);
    emit.setXFant(emitXFant);
    emit.setEnderEmit(emitAddress);
    emit.setIE(emitIE);
    emit.setCRT(emitCRT);
    infNFe.setEmit(emit);

    // TNFe.InfNFe.Dest dest = new TNFe.InfNFe.Dest();
    // final String destCpf = "01234567890";
    // dest.setCPF(destCpf);
    // dest.setXNome("Consumidor de Teste");
    // dest.setIndIEDest("9");
    // dest.setEmail("cliente@exemplo.com");
    // infNFe.setDest(dest);

    // TEndereco destAddress = new TEndereco();
    // destAddress.setXLgr("Rua Exemplo");
    // destAddress.setNro("200");
    // destAddress.setXBairro("Bairro Centro");
    // destAddress.setCMun(cMunFG);
    // destAddress.setXMun("Sao Paulo");
    // destAddress.setUF(TUf.SP);
    // destAddress.setCEP("01001000");
    // destAddress.setCPais("1058");
    // destAddress.setXPais("Brasil");
    // destAddress.setFone("11999999999");
    // dest.setEnderDest(destAddress);

    TNFe.InfNFe.Det det = new TNFe.InfNFe.Det();
    det.setNItem("1");

    TNFe.InfNFe.Det.Prod prod = new TNFe.InfNFe.Det.Prod();
    prod.setCProd("SKU001");
    prod.setCEAN("SEM GTIN");
    prod.setXProd("NOTA FISCAL EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL");
    prod.setNCM("61091000");
    prod.setCFOP("5102");
    prod.setUCom("UN");
    prod.setQCom("1.0000");
    prod.setVUnCom("10.00");
    prod.setVProd("10.00");
    prod.setCEANTrib("SEM GTIN");
    prod.setUTrib("UN");
    prod.setQTrib("1.0000");
    prod.setVUnTrib("10.00");
    prod.setIndTot("1");
    det.setProd(prod);

    TNFe.InfNFe.Det.Imposto imposto = new TNFe.InfNFe.Det.Imposto();
    imposto.getContent().add(SEFAZUtils.auxCreateJAXBElement("vTotTrib", "0.00"));

    TNFe.InfNFe.Det.Imposto.ICMS icms = new TNFe.InfNFe.Det.Imposto.ICMS();
    TNFe.InfNFe.Det.Imposto.ICMS.ICMS00 icms00 = new TNFe.InfNFe.Det.Imposto.ICMS.ICMS00();
    icms00.setOrig("0");
    icms00.setCST("00");
    icms00.setModBC("3");
    icms00.setVBC("10.00");
    icms00.setPICMS("4.20");
    icms00.setVICMS("0.42");
    icms.setICMS00(icms00);

    // icmssn102.setCSOSN("102");
    // icms.setICMSSN102(icmssn102);
    imposto.getContent().add(SEFAZUtils.auxCreateJAXBElement("ICMS", icms));

    TNFe.InfNFe.Det.Imposto.PIS pis = new TNFe.InfNFe.Det.Imposto.PIS();
    TNFe.InfNFe.Det.Imposto.PIS.PISNT pisnt = new TNFe.InfNFe.Det.Imposto.PIS.PISNT();
    pisnt.setCST(SEFAZ_CST_PIS.CST_04_OPERACAO_TRIBUTAVEL_MONOFASICA_ALIQUOTA_ZERO.getXmlData());
    pis.setPISNT(pisnt);
    imposto.getContent().add(SEFAZUtils.auxCreateJAXBElement("PIS", pis));

    TNFe.InfNFe.Det.Imposto.COFINS cofins = new TNFe.InfNFe.Det.Imposto.COFINS();
    TNFe.InfNFe.Det.Imposto.COFINS.COFINSNT cofinsnt = new TNFe.InfNFe.Det.Imposto.COFINS.COFINSNT();
    cofinsnt.setCST(SEFAZ_CST_COFINS.CST_04_OPERACAO_TRIBUTAVEL_MONOFASICA_ALIQUOTA_ZERO.getXmlData());
    cofins.setCOFINSNT(cofinsnt);
    imposto.getContent().add(SEFAZUtils.auxCreateJAXBElement("COFINS", cofins));
    det.setImposto(imposto);

    infNFe.getDet().add(det);

    TNFe.InfNFe.Total total = new TNFe.InfNFe.Total();
    TNFe.InfNFe.Total.ICMSTot icmsTot = new TNFe.InfNFe.Total.ICMSTot();
    icmsTot.setVBC("10.00");
    icmsTot.setVICMS("0.42");
    icmsTot.setVICMSDeson("0.00");
    icmsTot.setVFCP("0.00");
    icmsTot.setVBCST("0.00");
    icmsTot.setVST("0.00");
    icmsTot.setVFCPST("0.00");
    icmsTot.setVFCPSTRet("0.00");
    icmsTot.setVProd("10.00");
    icmsTot.setVFrete("0.00");
    icmsTot.setVSeg("0.00");
    icmsTot.setVDesc("0.00");
    icmsTot.setVII("0.00");
    icmsTot.setVIPI("0.00");
    icmsTot.setVIPIDevol("0.00");
    icmsTot.setVPIS("0.00");
    icmsTot.setVCOFINS("0.00");
    icmsTot.setVOutro("0.00");
    icmsTot.setVNF("10.00");
    icmsTot.setVTotTrib("0.00");
    total.setICMSTot(icmsTot);
    infNFe.setTotal(total);

    TNFe.InfNFe.Transp transp = new TNFe.InfNFe.Transp();
    transp.setModFrete("9");
    infNFe.setTransp(transp);

    TNFe.InfNFe.Pag pag = new TNFe.InfNFe.Pag();
    TNFe.InfNFe.Pag.DetPag detPag = new TNFe.InfNFe.Pag.DetPag();
    detPag.setIndPag("0");
    detPag.setTPag("01");
    detPag.setVPag("10.00");
    pag.getDetPag().add(detPag);
    pag.setVTroco("0.00");
    infNFe.setPag(pag);

    TNFe.InfNFe.InfAdic infAdic = new TNFe.InfNFe.InfAdic();
    infAdic.setInfCpl("DOCUMENTO EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL");
    infNFe.setInfAdic(infAdic);

    // final String digVal = RUString.calcSHA1ToHex("NFe" + chave, StandardCharsets.UTF_8);
    // // final String digVal2 = sha1Hex("NFe" + chave);
    // //
    // String qrParams = "chNFe=" + chave;
    // qrParams += "&nVersao=100";
    // qrParams += "&tpAmb=" + tpAmb.getXMLData();
    // // qrParams += "&cDest=" + destCpf;
    // qrParams += "&dhEmi=" + RUString.toHex(dhEmiUtc, StandardCharsets.UTF_8);
    // qrParams += "&vNF=10.00";
    // qrParams += "&vICMS=0.42";
    // qrParams += "&digVal=" + digVal;
    // qrParams += "&cIdToken=" + cscId;
    //
    // final String cHashQRCode = RUString.calcSHA1ToHex(qrParams + csc, StandardCharsets.UTF_8);
    // // final String cHashQRCode = sha1Hex(qrParams + csc);
    // final String qrCode = "https://www.homologacao.nfce.fazenda.sp.gov.br/NFCeConsultaPublica/Paginas/ConsultaQRCode.aspx?" + qrParams + "&cHashQRCode=" + cHashQRCode;
    //
    // TNFe.InfNFeSupl supl = new TNFe.InfNFeSupl();
    // supl.setQrCode(qrCode);
    // supl.setUrlChave("https://www.homologacao.nfce.fazenda.sp.gov.br/NFCeConsultaPublica/Paginas/ConsultaNFCe.aspx");
    // nfe.setInfNFeSupl(supl);

    return enviNFe;
  }

  // private static String sha1Hex(String value) throws RFWException {
  // try {
  // MessageDigest digest = MessageDigest.getInstance("SHA-1");
  // byte[] hash = digest.digest(value.getBytes(StandardCharsets.UTF_8));
  // return toHex(hash);
  // } catch (NoSuchAlgorithmException e) {
  // throw new RFWCriticalException("Algoritmo SHA-1 indisponvel no ambiente atual.", new String[] { value }, e);
  // }
  // }
  //
  // private static String toHex(String value) {
  // return toHex(value.getBytes(StandardCharsets.UTF_8));
  // }
  //
  // private static String toHex(byte[] bytes) {
  // StringBuilder builder = new StringBuilder(bytes.length * 2);
  // for (byte b : bytes) {
  // builder.append(String.format(Locale.ROOT, "%02X", b));
  // }
  // return builder.toString();
  // }
}
