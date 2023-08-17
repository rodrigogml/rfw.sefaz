package br.eng.rodrigogml.rfw.sefaz;

import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import br.eng.rodrigogml.rfw.kernel.exceptions.RFWCriticalException;
import br.eng.rodrigogml.rfw.kernel.exceptions.RFWException;
import br.eng.rodrigogml.rfw.kernel.exceptions.RFWValidationException;
import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess;
import br.eng.rodrigogml.rfw.kernel.utils.RUDateTime;
import br.eng.rodrigogml.rfw.kernel.utils.RUXML;
import br.eng.rodrigogml.rfw.sefaz.vos.COFINSSTVO;
import br.eng.rodrigogml.rfw.sefaz.vos.COFINSVO;
import br.eng.rodrigogml.rfw.sefaz.vos.CobrVO;
import br.eng.rodrigogml.rfw.sefaz.vos.DestVO;
import br.eng.rodrigogml.rfw.sefaz.vos.DetVO;
import br.eng.rodrigogml.rfw.sefaz.vos.DupVO;
import br.eng.rodrigogml.rfw.sefaz.vos.EmitVO;
import br.eng.rodrigogml.rfw.sefaz.vos.EnderDestVO;
import br.eng.rodrigogml.rfw.sefaz.vos.EnderEmitVO;
import br.eng.rodrigogml.rfw.sefaz.vos.ICMSVO;
import br.eng.rodrigogml.rfw.sefaz.vos.IPIVO;
import br.eng.rodrigogml.rfw.sefaz.vos.IdeVO;
import br.eng.rodrigogml.rfw.sefaz.vos.ImpostoVO;
import br.eng.rodrigogml.rfw.sefaz.vos.InfNFeVO;
import br.eng.rodrigogml.rfw.sefaz.vos.NFeVO;
import br.eng.rodrigogml.rfw.sefaz.vos.NFrefVO;
import br.eng.rodrigogml.rfw.sefaz.vos.NfeProcVO;
import br.eng.rodrigogml.rfw.sefaz.vos.PISSTVO;
import br.eng.rodrigogml.rfw.sefaz.vos.PISVO;
import br.eng.rodrigogml.rfw.sefaz.vos.ProdVO;
import br.eng.rodrigogml.rfw.sefaz.vos.ProtNFeVO;
import br.eng.rodrigogml.rfw.sefaz.vos.RefECFVO;
import br.eng.rodrigogml.rfw.sefaz.vos.RefNFPVO;
import br.eng.rodrigogml.rfw.sefaz.vos.RefNFVO;
import br.eng.rodrigogml.rfw.sefaz.vos.TotalVO;
import br.eng.rodrigogml.rfw.sefaz.vos.TranspVO;

/**
 * Description: Esta classe contém métodos utilitários para processar e trabalhar com o XML (ou objeto) da NFe.<br>
 *
 * @author Rodrigo GML
 * @since 1.0.0 (17 de ago. de 2023)
 * @version 1.0.0 - Rodrigo GML-(...)
 */
public class SEFAZUtils {

  /**
   * Construtor privado para garantir métodos exclusivamente estáticos.
   */
  public SEFAZUtils() {
  }

  /**
   * Lê um arquivo XML de NFe e retorna o objeto NFeVO.
   *
   * @param xml XML da NFe já assinado, iniciando pela tag <nfeProc>
   * @return Objeto com o conteúdo do XML "parseado".
   * @throws RFWException
   */
  public NfeProcVO readXML(String xml) throws RFWException {
    final int indexOfNFeProc = xml.indexOf("<nfeProc");
    if (indexOfNFeProc == -1) {
      throw new RFWValidationException("RFW_000025");
    }
    // pula o conteúdo até a tag <nfeProc, alguns arquivos tem aparecido com caracteres no início ou até algum cabeçalho "errado" no arquivo.
    if (indexOfNFeProc > 0) xml = xml.substring(indexOfNFeProc);

    final Document doc = RUXML.parseXMLToDOMDocumentNormalized(xml);
    final String versionInfNFe = RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/@versao");

    switch (versionInfNFe) {
      case "4.00":
        break;
      default:
        throw new RFWCriticalException("RFW_000026", new String[] { versionInfNFe });
    }

    final NfeProcVO nfeProcVO = new NfeProcVO();
    nfeProcVO.setVersao(RUXML.getTextContent(doc, "/nfeProc/protNFe/@versao"));

    // Recupera os valores do protocolo de Autorização da NFe
    final ProtNFeVO protNFe = new ProtNFeVO();
    nfeProcVO.setProtNFe(protNFe);
    protNFe.setTpAmb(RUXML.getTextContent(doc, "/nfeProc/protNFe/infProt/tpAmb"));
    protNFe.setVerAplic(RUXML.getTextContent(doc, "/nfeProc/protNFe/infProt/verAplic"));
    protNFe.setDhRecbto(RUDateTime.parseLocalDateTime(RUXML.getTextContent(doc, "/nfeProc/protNFe/infProt/dhRecbto")));
    protNFe.setNprot(RUXML.getTextContent(doc, "/nfeProc/protNFe/infProt/nProt"));
    protNFe.setDigVal(RUXML.getTextContent(doc, "/nfeProc/protNFe/infProt/digVal"));
    protNFe.setCstat(RUXML.getTextContent(doc, "/nfeProc/protNFe/infProt/cStat"));
    protNFe.setXmotivo(RUXML.getTextContent(doc, "/nfeProc/protNFe/infProt/xMotivo"));

    final NFeVO nfe = new NFeVO();
    nfeProcVO.setNfe(nfe);

    /*
     * A. Dados da Nota Fiscal Eletrônica
     */
    final InfNFeVO infNFe = new InfNFeVO();
    nfe.setInfNFe(infNFe);
    {
      infNFe.setVersao(versionInfNFe);
      infNFe.setIdAttribute(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/@Id"));
    }

    /*
     * B. Identificação da Nota Fiscal eletrônica
     */
    {
      final IdeVO ide = new IdeVO();
      infNFe.setIde(ide);
      ide.setCuf(PreProcess.toInteger(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/ide/cUF")));
      ide.setCnf(PreProcess.toInteger(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/ide/cNF")));
      ide.setNatOp(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/ide/natOp"));
      ide.setIndPag(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/ide/indPag"));
      ide.setMod(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/ide/mod"));
      ide.setSerie(PreProcess.toInteger(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/ide/serie")));
      ide.setNnf(PreProcess.toInteger(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/ide/nNF")));
      ide.setDhEmi(RUDateTime.parseLocalDateTime(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/ide/dhEmi")));
      ide.setDhSaiEnt(RUDateTime.parseLocalDateTime(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/ide/dhSaiEnt")));
      ide.setIdDest(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/ide/idDest"));
      ide.setcMunFG(PreProcess.toInteger(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/ide/cMunFG")));
      ide.setTpImp(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/ide/tpImp"));
      ide.setTpEmis(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/ide/tpEmis"));
      ide.setCdv(PreProcess.toInteger(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/ide/cDV")));
      ide.setTpAmb(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/ide/tpAmb"));
      ide.setFinNFe(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/ide/finNFe"));
      ide.setIndFinal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/ide/indFinal"));
      ide.setIndPres(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/ide/indPres"));
      ide.setIndIntermid(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/ide/indIntermed"));
      ide.setProcEmi(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/ide/procEmi"));
      ide.setVerProc(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/ide/verProc"));
      ide.setDhCont(RUDateTime.parseLocalDateTime(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/ide/dhCont")));
      ide.setXjust(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/ide/xJust"));

      /*
       * Grupo BA. Documento Fiscal Referenciado
       */
      {
        final NodeList nodeList = RUXML.getNodeList(doc, "/nfeProc/NFe/infNFe/ide/NFref");
        if (nodeList.getLength() > 0) {
          List<NFrefVO> nfrefList = new LinkedList<>();
          ide.setNfref(nfrefList);

          for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            // Lemos alguns valores para identificar o tipo de documento
            final String refNFeContent = RUXML.getTextContent(node, "refNFe");
            final Node refNFNode = RUXML.getFirstNode(node, "refNF");
            final Node refNFPNode = RUXML.getFirstNode(node, "refNFP");
            final Node refECFNode = RUXML.getFirstNode(node, "refECF");

            NFrefVO refVO = new NFrefVO();
            nfrefList.add(refVO);

            if (refNFeContent != null) {
              // Documento referenciado é uma NFe
              refVO.setRefNFe(refNFeContent);
            } else if (refNFNode != null) {
              // Documento referenciado é uma NF
              RefNFVO refNF = new RefNFVO();
              refVO.setRefNF(refNF);

              refNF.setCuf(PreProcess.toInteger(RUXML.getTextContent(refNFNode, "cUF")));
              refNF.setAamm(RUXML.getTextContent(refNFNode, "AAMM"));
              refNF.setCnpj(RUXML.getTextContent(refNFNode, "CNPJ"));
              refNF.setMod(RUXML.getTextContent(refNFNode, "mod"));
              refNF.setSerie(PreProcess.toInteger(RUXML.getTextContent(refNFNode, "serie")));
              refNF.setNnf(PreProcess.toInteger(RUXML.getTextContent(refNFNode, "nNF")));
            } else if (refNFPNode != null) {
              // Nota fiscal de Produtor
              RefNFPVO refNFP = new RefNFPVO();
              refVO.setRefNFP(refNFP);

              refNFP.setCuf(PreProcess.toInteger(RUXML.getTextContent(refNFPNode, "cUF")));
              refNFP.setAamm(RUXML.getTextContent(refNFPNode, "AAMM"));
              refNFP.setCnpj(RUXML.getTextContent(refNFPNode, "CNPJ"));
              refNFP.setCpf(RUXML.getTextContent(refNFPNode, "CPF"));
              refNFP.setIe(RUXML.getTextContent(refNFPNode, "IE"));
              refNFP.setMod(RUXML.getTextContent(refNFPNode, "mod"));
              refNFP.setSerie(PreProcess.toInteger(RUXML.getTextContent(refNFPNode, "serie")));
              refNFP.setNnf(PreProcess.toInteger(RUXML.getTextContent(refNFPNode, "nNF")));
              refNFP.setRefCTe(RUXML.getTextContent(refNFPNode, "refCTe"));
            } else if (refECFNode != null) {
              // Modelo de Cupom Fiscal
              RefECFVO refECF = new RefECFVO();
              refVO.setRefECF(refECF);

              refECF.setMod(RUXML.getTextContent(refECFNode, "mod"));
              refECF.setNecf(PreProcess.toInteger(RUXML.getTextContent(refECFNode, "nECF")));
              refECF.setNcoo(PreProcess.toInteger(RUXML.getTextContent(refECFNode, "nCOO")));
            }
          }
        }
      }
    }

    /*
     * Grupo C. Identificação do Emitente da Nota Fiscal eletrônica
     */
    {
      EmitVO emit = new EmitVO();
      infNFe.setEmit(emit);

      emit.setCnpj(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/emit/CNPJ"));
      emit.setCpf(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/emit/CPF"));
      emit.setXnome(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/emit/xNome"));
      emit.setXfant(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/emit/xFant"));

      EnderEmitVO enderEmit = new EnderEmitVO();
      emit.setEnderEmit(enderEmit);
      enderEmit.setxLgr(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/emit/enderEmit/xLgr"));
      enderEmit.setNro(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/emit/enderEmit/nro"));
      enderEmit.setXcpl(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/emit/enderEmit/xCpl"));
      enderEmit.setXbairro(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/emit/enderEmit/xBairro"));
      enderEmit.setCmun(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/emit/enderEmit/cMun"));
      enderEmit.setXmun(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/emit/enderEmit/xMun"));
      enderEmit.setUf(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/emit/enderEmit/UF"));
      enderEmit.setCep(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/emit/enderEmit/CEP"));
      enderEmit.setCpais(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/emit/enderEmit/cPais"));
      enderEmit.setXpais(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/emit/enderEmit/xPais"));
      enderEmit.setFone(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/emit/enderEmit/fone"));

      emit.setIe(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/emit/IE"));
      emit.setIeST(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/emit/IEST"));
      emit.setIm(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/emit/IM"));
      emit.setCnae(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/emit/CNAE"));
      emit.setCrt(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/emit/CRT"));
    }

    /*
     * Grupo E. Identificação do Destinatário da Nota Fiscal eletrônica
     */
    {
      DestVO dest = new DestVO();
      infNFe.setDest(dest);

      dest.setCnpj(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/dest/CNPJ"));
      dest.setCpf(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/dest/CPF"));
      dest.setIdEstrangeiro(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/dest/idEstrangeiro"));
      dest.setXnome(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/dest/xNome"));

      EnderDestVO enderDest = new EnderDestVO();
      dest.setEnderDest(enderDest);
      enderDest.setXlgr(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/dest/enderDest/xLgr"));
      enderDest.setNro(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/dest/enderDest/nro"));
      enderDest.setXcpl(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/dest/enderDest/xCpl"));
      enderDest.setXbairro(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/dest/enderDest/xBairro"));
      enderDest.setCmun(PreProcess.toInteger(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/dest/enderDest/cMun")));
      enderDest.setXmun(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/dest/enderDest/xMun"));
      enderDest.setUf(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/dest/enderDest/UF"));
      enderDest.setCep(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/dest/enderDest/CEP"));
      enderDest.setCpais(PreProcess.toInteger(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/dest/enderDest/cPais")));
      enderDest.setXpais(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/dest/enderDest/xPais"));
      enderDest.setFone(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/dest/enderDest/fone"));

      dest.setIndIEDest(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/dest/indIEDest"));
      dest.setIe(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/dest/IE"));
      dest.setIsuf(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/dest/ISUF"));
      dest.setIm(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/dest/IM"));
      dest.setEmail(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/dest/email"));
    }

    /*
     * Grupo H. Detalhamento de Produtos e Serviços da NF-e
     */
    {
      final NodeList nodeList = RUXML.getNodeList(doc, "/nfeProc/NFe/infNFe/det");
      if (nodeList.getLength() > 0) {
        List<DetVO> detList = new LinkedList<>();
        infNFe.setDet(detList);

        for (int i = 0; i < nodeList.getLength(); i++) {
          Node node = nodeList.item(i);
          DetVO det = new DetVO();
          detList.add(det);

          det.setNitem(PreProcess.toInteger(RUXML.getTextContent(node, "@nItem")));

          /*
           * Grupo I. Produtos e Serviços da NF-e
           */
          {
            ProdVO prod = new ProdVO();
            det.setProd(prod);

            prod.setCprod(RUXML.getTextContent(node, "prod/cProd"));
            prod.setCean(RUXML.getTextContent(node, "prod/cEAN"));
            prod.setXprod(RUXML.getTextContent(node, "prod/xProd"));
            prod.setNcm(RUXML.getTextContent(node, "prod/NCM"));
            prod.setCest(RUXML.getTextContent(node, "prod/CEST"));
            prod.setIndEscala(RUXML.getTextContent(node, "prod/indEscala"));
            prod.setCnpjFab(RUXML.getTextContent(node, "prod/CNPJFab"));
            prod.setExtIPI(RUXML.getTextContent(node, "prod/EXTIPI"));
            prod.setCfop(RUXML.getTextContent(node, "prod/CFOP"));
            prod.setUcom(RUXML.getTextContent(node, "prod/uCom"));
            prod.setQcom(PreProcess.toBigDecimal(RUXML.getTextContent(node, "prod/qCom")));
            prod.setVunCom(PreProcess.toBigDecimal(RUXML.getTextContent(node, "prod/vUnCom")));
            prod.setVprod(PreProcess.toBigDecimal(RUXML.getTextContent(node, "prod/vProd")));
            prod.setCeanTrib(RUXML.getTextContent(node, "prod/cEANTrib"));
            prod.setUtrib(RUXML.getTextContent(node, "prod/uTrib"));
            prod.setqTrib(PreProcess.toBigDecimal(RUXML.getTextContent(node, "prod/qTrib")));
            prod.setVunTrib(PreProcess.toBigDecimal(RUXML.getTextContent(node, "prod/vUnTrib")));
            prod.setVfrete(PreProcess.toBigDecimal(RUXML.getTextContent(node, "prod/vFrete")));
            prod.setVseg(PreProcess.toBigDecimal(RUXML.getTextContent(node, "prod/vSeg")));
            prod.setVdesc(PreProcess.toBigDecimal(RUXML.getTextContent(node, "prod/vDesc")));
            prod.setVoutro(PreProcess.toBigDecimal(RUXML.getTextContent(node, "prod/vOutro")));
            prod.setIndTot(RUXML.getTextContent(node, "prod/indTot"));

          }

          /*
           * Grupo M. Tributos incidentes no Produto ou Serviço
           */
          {
            ImpostoVO imposto = new ImpostoVO();
            det.setImposto(imposto);

            imposto.setVtotTrib(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/vTotTrib")));

            {
              ICMSVO icms = new ICMSVO();
              imposto.setIcms(icms);

              // Como não foram criados VOs para cada tag do ICMS (ICMS00, ICMS10, etc.) tentamos ler todas as tags independente do CST definido
              // O código a seguir abrange os seguintes grupos:
              // Grupo N01. ICMS Normal e ST
              // Grupo N02. Grupo Tributação do ICMS= 00
              // Grupo N03. Grupo Tributação do ICMS= 10
              // Grupo N04. Grupo Tributação do ICMS= 20
              // Grupo N05. Grupo Tributação do ICMS= 30
              // Grupo N06. Grupo Tributação do ICMS= 40, 41, 50
              // Grupo N07. Grupo Tributação do ICMS= 51
              // Grupo N08. Grupo Tributação do ICMS= 60
              // Grupo N09. Grupo Tributação do ICMS= 70
              // Grupo N10. Grupo Tributação do ICMS= 90
              // Grupo N10a. Grupo de Partilha do ICMS
              // Grupo N10b. Grupo de Repasse do ICMS ST
              // Grupo N10c. Grupo CRT=1 (CSON 101)
              // Grupo N10d. Grupo CRT=1 (CSON 102, 103, 300 ou 400)
              // Grupo N10e. Grupo CRT=1 (CSON 201)
              // Grupo N10f. Grupo CRT=1 (CSON 202 ou 203)
              // Grupo N10g. Grupo CRT=1 (CSON 500)
              // Grupo N10h. Grupo CRT=1 (CSON 900)

              icms.setOrig(RUXML.getTextContent(node, "imposto/ICMS/*/orig"));
              icms.setCst(RUXML.getTextContent(node, "imposto/ICMS/*/CST"));

              // ICMS
              icms.setModBC(RUXML.getTextContent(node, "imposto/ICMS/*/modBC"));
              icms.setPredBC(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/pRedBC")));
              icms.setVbc(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/vBC")));
              icms.setPicms(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/pICMS")));
              icms.setVicms(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/vICMS")));

              // ICMS Difal
              icms.setVicmsOp(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/vICMSOp")));
              icms.setPdif(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/pDif")));
              icms.setVicmsDif(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/vICMSDif")));

              // ICMS ST
              icms.setModBCST(RUXML.getTextContent(node, "imposto/ICMS/*/modBCST"));
              icms.setPmvaST(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/pMVAST")));
              icms.setPredBCST(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/pRedBCST")));
              icms.setVbcST(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/vBCST")));
              icms.setPicmsST(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/pICMSST")));
              icms.setVicmsST(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/vICMSST")));

              // ICMS Retenção
              icms.setVbcSTRet(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/vBCSTRet")));
              icms.setPst(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/pST")));
              icms.setVicmsSubstituto(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/vICMSSubstituto")));
              icms.setVicmsSTRet(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/vICMSSTRet")));

              // ICMS Destino
              icms.setVbcSTDest(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/vBCSTDest")));
              icms.setVicmsSTDest(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/vICMSSTDest")));

              // ICMS Desonerado
              icms.setVicmsDeson(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/vICMSDeson")));
              icms.setMotDesICMS(RUXML.getTextContent(node, "imposto/ICMS/*/motDesICMS"));

              // ICMS Efetivo
              icms.setPredBCEfet(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/pRedBCEfet")));
              icms.setVbcEfet(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/vBCEfet")));
              icms.setPicmsEfet(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/pICMSEfet")));
              icms.setVicmsEfet(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/vICMSEfet")));

              // ICMS Operação Própria
              icms.setPbcOp(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/pBCOp")));
              icms.setUfst(RUXML.getTextContent(node, "imposto/ICMS/*/UFST"));

              // FCP
              icms.setVbcFCP(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/vBCFCP")));
              icms.setPfcp(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/pFCP")));
              icms.setVfcp(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/vFCP")));

              // FCP ST
              icms.setVbcFCPST(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/vBCFCPST")));
              icms.setPfcpST(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/pFCPST")));
              icms.setVfcpST(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/vFCPST")));

              // FCP Retenção
              icms.setVbcFCPSTRet(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/vBCFCPSTRet")));
              icms.setPfcpSTRet(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/pFCPSTRet")));
              icms.setVfcpSTRet(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/vFCPSTRet")));

              // CSON
              icms.setCsosn(RUXML.getTextContent(node, "imposto/ICMS/*/CSOSN"));
              icms.setPcredSN(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/pCredSN")));
              icms.setVcredICMSSN(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/vCredICMSSN")));
              icms.setPcredSN(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/ICMS/*/pCredSN")));
            }

            /*
             * Grupo O. Imposto sobre Produtos Industrializados
             */
            {
              IPIVO ipi = new IPIVO();
              imposto.setIpi(ipi);

              ipi.setClEnq(RUXML.getTextContent(node, "imposto/IPI/clEnq"));
              ipi.setCnpjProd(RUXML.getTextContent(node, "imposto/IPI/CNPJProd"));
              ipi.setCselo(RUXML.getTextContent(node, "imposto/IPI/cSelo"));
              ipi.setQselo(PreProcess.toLong(RUXML.getTextContent(node, "imposto/IPI/qSelo")));
              ipi.setcEnq(PreProcess.toInteger(RUXML.getTextContent(node, "imposto/IPI/cEnq")));

              ipi.setCst(RUXML.getTextContent(node, "imposto/IPI/*/CST"));
              ipi.setVbc(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/IPI/*/vBC")));
              ipi.setPipi(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/IPI/*/pIPI")));
              ipi.setQunid(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/IPI/*/qUnid")));
              ipi.setVunid(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/IPI/*/vUnid")));
              ipi.setVipi(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/IPI/*/vIPI")));
            }

            /*
             * Grupo Q. PIS
             */
            {
              PISVO pis = new PISVO();
              imposto.setPis(pis);

              pis.setCst(RUXML.getTextContent(node, "imposto/PIS/*/CST"));
              pis.setVbc(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/PIS/*/vBC")));
              pis.setPpis(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/PIS/*/pPIS")));
              pis.setVpis(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/PIS/*/vPIS")));
              pis.setQbcProd(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/PIS/*/qBCProd")));
              pis.setValiqProd(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/PIS/*/vAliqProd")));
              pis.setVpis(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/PIS/*/vPIS")));
            }

            /*
             * Grupo R. PIS ST
             */
            {
              PISSTVO pisST = new PISSTVO();
              imposto.setPisST(pisST);

              pisST.setVbc(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/PISST/*/vBC")));
              pisST.setPpis(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/PISST/*/pPIS")));
              pisST.setQbcProd(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/PISST/*/qBCProd")));
              pisST.setValiqProd(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/PISST/*/vAliqProd")));
              pisST.setVpis(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/PISST/*/vPIS")));
            }

            /*
             * Grupo S. COFINS
             */
            {
              COFINSVO cofins = new COFINSVO();
              imposto.setCofins(cofins);

              cofins.setCst(RUXML.getTextContent(node, "imposto/COFINS/*/CST"));
              cofins.setVbc(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/COFINS/*/vBC")));
              cofins.setPcofins(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/COFINS/*/pCOFINS")));
              cofins.setVcofins(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/COFINS/*/vCOFINS")));
              cofins.setQbcProd(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/COFINS/*/qBCProd")));
              cofins.setValiqProd(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/COFINS/*/vAliqProd")));
              cofins.setVcofins(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/COFINS/*/vCOFINS")));
            }

            /*
             * Grupo T. COFINS ST
             */
            {
              COFINSSTVO cofinsST = new COFINSSTVO();
              imposto.setCofinsST(cofinsST);

              cofinsST.setVbc(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/COFINSST/*/vBC")));
              cofinsST.setPcofins(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/COFINSST/*/pCOFINS")));
              cofinsST.setQbcProd(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/COFINSST/*/qBCProd")));
              cofinsST.setValiqProd(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/COFINSST/*/vAliqProd")));
              cofinsST.setVcofins(PreProcess.toBigDecimal(RUXML.getTextContent(node, "imposto/COFINSST/*/vCOFINS")));
            }
          }

          /*
           * Grupo V. Informações adicionais (para o item da NF-e)
           */
          {
            det.setInfAddProd(RUXML.getTextContent(node, "infAdProd"));
          }
        }
      }
    }

    /*
     * Grupo W. Total da NF-e
     */
    {
      TotalVO total = new TotalVO();
      infNFe.setTotal(total);

      total.setVbc(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/total/ICMSTot/vBC")));
      total.setVicms(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/total/ICMSTot/vICMS")));
      total.setVicmsDeson(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/total/ICMSTot/vICMSDeson")));
      total.setVfcpUFDest(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/total/ICMSTot/vFCPUFDest")));
      total.setVicmsUFDest(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/total/ICMSTot/vICMSUFDest")));
      total.setVicmsUFRemet(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/total/ICMSTot/vICMSUFRemet")));
      total.setVfcp(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/total/ICMSTot/vFCP")));
      total.setVbcST(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/total/ICMSTot/vBCST")));
      total.setVst(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/total/ICMSTot/vST")));
      total.setVfcpST(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/total/ICMSTot/vFCPST")));
      total.setVfcpSTRet(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/total/ICMSTot/vFCPSTRet")));
      total.setVprod(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/total/ICMSTot/vProd")));
      total.setVfrete(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/total/ICMSTot/vFrete")));
      total.setVseg(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/total/ICMSTot/vSeg")));
      total.setVdesc(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/total/ICMSTot/vDesc")));
      total.setVii(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/total/ICMSTot/vII")));
      total.setVipi(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/total/ICMSTot/vIPI")));
      total.setVipiDevol(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/total/ICMSTot/vIPIDevol")));
      total.setVpis(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/total/ICMSTot/vPIS")));
      total.setVcofins(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/total/ICMSTot/vCOFINS")));
      total.setVoutro(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/total/ICMSTot/vOutro")));
      total.setVnf(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/total/ICMSTot/vNF")));
      total.setVtotTrib(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/total/ICMSTot/vTotTrib")));
    }

    /*
     * Grupo X. Informações do Transporte da NF-e
     */
    {
      TranspVO transp = new TranspVO();
      infNFe.setTransp(transp);

      transp.setModFrete(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/transp/modFrete"));
    }

    /*
     * Grupo Y. Dados da Cobrança
     */
    {
      CobrVO cobr = new CobrVO();
      infNFe.setCobr(cobr);

      cobr.setNfat(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/cobr/fat/nFat"));
      cobr.setVorig(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/cobr/fat/vOrig")));
      cobr.setVdesc(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/cobr/fat/vDesc")));
      cobr.setVliq(PreProcess.toBigDecimal(RUXML.getTextContent(doc, "/nfeProc/NFe/infNFe/cobr/fat/vLiq")));

      NodeList nodeList = RUXML.getNodeList(doc, "/nfeProc/NFe/infNFe/cobr/dup");
      if (nodeList.getLength() > 0) {
        List<DupVO> dupList = new LinkedList<>();
        cobr.setDup(dupList);

        for (int i = 0; i < nodeList.getLength(); i++) {
          Node node = nodeList.item(i);

          DupVO dup = new DupVO();
          dupList.add(dup);

          dup.setNdup(RUXML.getTextContent(node, "nDup"));
          dup.setDvenc(RUDateTime.parseLocalDate(RUXML.getTextContent(node, "dVenc")));
          dup.setVdup(PreProcess.toBigDecimal(RUXML.getTextContent(node, "vDup")));
        }
      }
    }

    return nfeProcVO;
  }

}
