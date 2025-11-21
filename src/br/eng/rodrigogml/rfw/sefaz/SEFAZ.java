package br.eng.rodrigogml.rfw.sefaz;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.security.KeyStore;
import java.util.Iterator;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.axis2.AxisFault;
import org.apache.axis2.kernel.http.HTTPConstants;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.xmlbeans.XmlObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import br.eng.rodrigogml.rfw.kernel.RFW;
import br.eng.rodrigogml.rfw.kernel.bundle.RFWBundle;
import br.eng.rodrigogml.rfw.kernel.exceptions.RFWCriticalException;
import br.eng.rodrigogml.rfw.kernel.exceptions.RFWException;
import br.eng.rodrigogml.rfw.kernel.exceptions.RFWRunTimeException;
import br.eng.rodrigogml.rfw.kernel.exceptions.RFWWarningException;
import br.eng.rodrigogml.rfw.kernel.interfaces.RFWCertificate;
import br.eng.rodrigogml.rfw.kernel.logger.RFWLogger;
import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess;
import br.eng.rodrigogml.rfw.kernel.utils.RUCert;
import br.eng.rodrigogml.rfw.kernel.utils.RUFile;
import br.eng.rodrigogml.rfw.kernel.utils.RUIO;
import br.eng.rodrigogml.rfw.sefaz.SEFAZDefinitions.SefazContingency;
import br.eng.rodrigogml.rfw.sefaz.mapper.MapperForNfeAutorizacaoLoteV400;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_WebServices;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_mod;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tpAmb;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_uf;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZUtils;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZXMLValidator;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZEnviNFeVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZRetEnviNFeVO;

import br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.CadConsultaCadastro4Stub;
import br.inf.portalfiscal.www.nfe.wsdl.nfeautorizacao4.NFeAutorizacao4Stub;
import br.inf.portalfiscal.www.nfe.wsdl.nfeautorizacao4.NfeDadosMsgDocument;
import br.inf.portalfiscal.www.nfe.wsdl.nfeautorizacao4.NfeResultMsgDocument;
import br.inf.portalfiscal.www.nfe.wsdl.nfeconsultaprotocolo4.NFeConsultaProtocolo4Stub;
import br.inf.portalfiscal.www.nfe.wsdl.nfeinutilizacao4.NFeInutilizacao4Stub;
import br.inf.portalfiscal.www.nfe.wsdl.nferecepcaoevento4.NFeRecepcaoEvento4Stub;
import br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NFeRetAutorizacao4Stub;
import br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico4.NFeStatusServico4Stub;
import xsdobjects.consCad200.TConsCad;
import xsdobjects.consCad200.TRetConsCad;
import xsdobjects.consReciNFe400.TConsReciNFe;
import xsdobjects.consReciNFe400.TRetConsReciNFe;
import xsdobjects.consSitNFe400.TConsSitNFe;
import xsdobjects.consSitNFe400.TRetConsSitNFe;
import xsdobjects.consStatServ400.TConsStatServ;
import xsdobjects.consStatServ400.TRetConsStatServ;
import xsdobjects.envEvento100.TEnvEvento;
import xsdobjects.envEvento100.TRetEnvEvento;
import xsdobjects.enviNFe400.TEnviNFe;
import xsdobjects.enviNFe400.TNFe;
import xsdobjects.enviNFe400.TRetEnviNFe;
import xsdobjects.inutNFe400.TInutNFe;
import xsdobjects.inutNFe400.TRetInutNFe;

/**
 * Description: Objeto utilizado para abstrair toda a comunicação com o servidor da SEFAZ.<br>
 * Devemos expor os métodos nesta classe como se fossem uma chamada direta nos serviços disponibilizados pela SEFAZ.
 *
 * @author Rodrigo GML
 * @since 1.0.0 (24 de ago. de 2023)
 * @version 1.0.0 - Rodrigo GML-(...)
 */
public class SEFAZ {

  /**
   * Definição do estado/servidor de comunicação
   */
  private final SEFAZ_WebServices ws;

  /**
   * Definição do ambiente de comunicação (Homologação/Produção).
   */
  private final SEFAZ_tpAmb env;

  /**
   * Mantém a referência para o certificado para assinar os documentos necessários em alguns métodos
   */
  private final RFWCertificate cert;

  /**
   * Define o tipo de contingência que o sistema está usando no momento.<br>
   * NULL indica que não estamos em contingência, e estamos usando o ambiente normal.
   */
  private SefazContingency contingency = null;

  /**
   * HttpClient criado com o SSLContext personalizado com o certificado de assinatura do cliente e os certificados confiáveis do servidor da SEFAZ.
   */
  private final CloseableHttpClient httpClientCustom;

  /**
   * Instancia o objeto para comunicação com o WS da SEFAZ.<br>
   * Carrega o trustCert inserido na distribuição do módulo RFW.SEFAZ, a depender da versão pode conter certificados vencidos e causar problemas de comunicação.<br>
   *
   * @param cert Certificado a ser utilizado nas operações de assinatura e transmissão. Se passado nulo faremos a conexão sem a identificação do certificado cliente. Geralmente um Certificado do Tipo A1.
   * @param uf UF do emitente do documento, utilizado para determinar o ambiente e outros parametros de comunicação.
   * @param env Ambiente a ser utilizado na emissão de documentos e comunicação.
   * @throws RFWException
   */
  public SEFAZ(RFWCertificate cert, SEFAZ_WebServices ws, SEFAZ_tpAmb env) throws RFWException {
    this(cert, new RFWCertificate() {
      @Override
      public CertificateType getType() {
        return CertificateType.KeyStore;
      }

      @Override
      public String getCertificateFilePassword() {
        return "sefazca";
      }

      @Override
      public byte[] getCertificateFileContent() {
        try {
          return RUIO.toByteArray(SEFAZ.class.getResourceAsStream("/keystores/sefazca.jks"));
        } catch (RFWException e) {
          throw new RFWRunTimeException(e);
        }
      }
    }, ws, env);
  }

  /**
   * Instancia o objeto para comunicação com o WS da SEFAZ
   *
   * @param cert Certificado a ser utilizado nas operações de assinatura e transmissão. Se passado nulo faremos a conexão sem a identificação do certificado cliente. Geralmente um Certificado do Tipo A1.
   * @param trustCert Certificados aceitos como assinatura do servidor da SEFAZ. Geralmente um JKS com os certificados públicos das CAs atuais da SEFAZ.
   * @param ws WebService a ser utilizado na comunicação.
   * @param env Ambiente a ser utilizado na emissão de documentos e comunicação.
   * @throws RFWException
   */
  public SEFAZ(RFWCertificate cert, RFWCertificate trustCert, SEFAZ_WebServices ws, SEFAZ_tpAmb env) throws RFWException {
    PreProcess.requiredNonNull(ws);
    PreProcess.requiredNonNull(env);

    this.ws = ws;
    this.env = env;
    this.cert = cert;

    // Inicializa o Certificado do cliente se passado
    KeyManager[] km = null;
    if (cert != null) {
      KeyStore clientKeyStore = RUCert.loadKeyStore(cert);
      km = RUCert.createKeyManager(clientKeyStore, cert.getCertificateFilePassword());
    }

    // Inicializa o TrustManager para incluir os servificados aceitos dos servidores da SEFAZ
    TrustManager[] tm = null;
    if (trustCert != null) {
      KeyStore trustKStore = RUCert.loadKeyStore(trustCert);
      tm = RUCert.createTrustManager(trustKStore);
    }

    // Inicializa o Contexto SSL que será utilizado nos Stubs do axis para autenticar e validar a conexão com a SEFAZ.
    try {
      if (km != null || tm != null) {
        final SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(km, tm, null);

        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sc);
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create().register("https", sslsf).build();
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        this.httpClientCustom = HttpClients.custom().setConnectionManager(cm).build();
      } else {
        this.httpClientCustom = null;
      }
    } catch (Exception e) {
      throw new RFWCriticalException("Falha ao inicializar o contexto de segurança para conexão!", e);
    }
  }

  /**
   * Chama o método "consultaCadastro v2.00" disponibilizado no WebSerice da SEFAZ para consultar o contribuinte. <Br>
   *
   * @param root Objeto representando o XML para envio da requisição.
   * @return Objeto do XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public TRetConsStatServ nfeStatusServicoNFV400() throws RFWException {
    // Removemos o namespace do XML para facilitar o trabalho com o JAXB. Mais simples do que configurar filtros ou todos os elementos manualmente.
    return SEFAZUtils.readXMLToObject(nfeStatusServicoNFV400asXML(), TRetConsStatServ.class);
  }

  /**
   * Chama o método "consultaCadastro v2.00" disponibilizado no WebSerice da SEFAZ para consultar o contribuinte. <Br>
   *
   * @param root Objeto representando o XML para envio da requisição.
   * @return XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public String nfeStatusServicoNFV400asXML() throws RFWException {
    br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico4.NfeDadosMsgDocument nfeDadosMsg = br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico4.NfeDadosMsgDocument.Factory.newInstance();
    br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico4.NfeDadosMsgDocument.NfeDadosMsg req = nfeDadosMsg.addNewNfeDadosMsg();

    TConsStatServ root = SEFAZUtils.mountNfeStatusServicoNFV400Message(env, ws);

    String msg = SEFAZUtils.writeXMLFromObject(root);
    try {

      // Valida o XML com o schema antes de tentar a conexão
      SEFAZXMLValidator.validateNfeStatusServicoNFV400(msg);

      req.set(XmlObject.Factory.parse(msg));
    } catch (Exception e) {
      throw new RFWCriticalException("Falha ao criar mensagem para enviar pelo WebService da SEFAZ.", new String[] { msg }, e);
    }

    NFeStatusServico4Stub stub = createNfeStatusServicoNFStub(env, ws, contingency);
    br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico4.NfeResultMsgDocument result = null;

    try {
      result = stub.nfeStatusServicoNF(nfeDadosMsg);
      return result.getNfeResultMsg().toString();
    } catch (RemoteException e) {
      if ("Transport error: 403 Error: Forbidden".equals(e.getMessage())) {
        throw new RFWWarningException("Não foi possível comunicar com o servidor da SEFAZ.", e);
      } else if ("Read timed out".equals(e.getMessage())) {
        throw new RFWWarningException("Não foi possível comunicar com o servidor da SEFAZ.", e);
      } else {
        RFWLogger.logError("Mensagem não mapeada de erro durante comunicação com a SEFAZ: " + e.getMessage());
        throw new RFWWarningException("Não foi possível comunicar com o servidor da SEFAZ.", e);
      }
    }
  }

  /**
   * Chama o método "consultaCadastro" disponibilizado no WebSerice da SEFAZ para consultar o contribuinte.
   *
   * @param cpf Número do CPF a ser consultado.
   * @return XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public TRetConsCad consultaCadastroV200byCPF(String cpf) throws RFWException {
    final TConsCad root = SEFAZUtils.mountConsCadV200Message(ws, cpf, null, null);
    return this.consultaCadastroV200(root);
  }

  /**
   * Chama o método "consultaCadastro" disponibilizado no WebSerice da SEFAZ para consultar o contribuinte.
   *
   * @param cnpj Número do CNPJ a ser consultado.
   * @return XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public TRetConsCad consultaCadastroV200byCNPJ(String cnpj) throws RFWException {
    final TConsCad root = SEFAZUtils.mountConsCadV200Message(ws, null, cnpj, null);
    return this.consultaCadastroV200(root);
  }

  /**
   * Chama o método "consultaCadastro" disponibilizado no WebSerice da SEFAZ para consultar o contribuinte.
   *
   * @param ie Número da Inscrução Estadual a ser consultada.
   * @return XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public TRetConsCad consultaCadastroV200byIE(String ie) throws RFWException {
    final TConsCad root = SEFAZUtils.mountConsCadV200Message(ws, null, null, ie);
    return this.consultaCadastroV200(root);
  }

  /**
   * Chama o método "consultaCadastro v2.00" disponibilizado no WebSerice da SEFAZ para consultar o contribuinte. <Br>
   *
   * @param root Objeto representando o XML para envio da requisição.
   * @return Objeto do XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public TRetConsCad consultaCadastroV200(TConsCad root) throws RFWException {
    return SEFAZUtils.readXMLToObject(consultaCadastroV200asXML(root), TRetConsCad.class);
  }

  /**
   * Chama o método "consultaCadastro v2.00" disponibilizado no WebSerice da SEFAZ para consultar o contribuinte. <Br>
   *
   * @param root Objeto representando o XML para envio da requisição.
   * @return XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public String consultaCadastroV200asXML(TConsCad root) throws RFWException {
    br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeDadosMsgDocument nfeDadosMsg = br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeDadosMsgDocument.Factory.newInstance();
    br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeDadosMsgDocument.NfeDadosMsg req = nfeDadosMsg.addNewNfeDadosMsg();

    String msg = SEFAZUtils.writeXMLFromObject(root);
    SEFAZXMLValidator.validateConsCadV200(msg);
    try {
      req.set(XmlObject.Factory.parse(msg));
    } catch (Exception e) {
      throw new RFWCriticalException("Falha ao criar mensagem para enviar pelo WebService da SEFAZ.", new String[] { msg }, e);
    }

    CadConsultaCadastro4Stub stub = createCadConsultaCadastro4Stub(env, ws, contingency);

    try {
      br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeResultMsgDocument result = stub.consultaCadastro(nfeDadosMsg);
      return result.getNfeResultMsg().toString();
    } catch (RemoteException e) {
      if ("Transport error: 403 Error: Forbidden".equals(e.getMessage())) {
        throw new RFWWarningException("Não foi possível comunicar com o servidor da SEFAZ.", e);
      } else if ("Read timed out".equals(e.getMessage())) {
        throw new RFWWarningException("Não foi possível comunicar com o servidor da SEFAZ.", e);
      } else {
        RFWLogger.logError("Mensagem não mapeada de erro durante comunicação com a SEFAZ: " + e.getMessage());
        throw new RFWWarningException("Não foi possível comunicar com o servidor da SEFAZ.", e);
      }
    }
  }

  /**
   * Chama o método "nfeAutorizacaoLote v4.00" disponibilizado no WebSerice da SEFAZ para autorização de NFe/NFCe. <Br>
   *
   * @param root Objeto representando o XML para envio da requisição.
   * @return Object[] com 2 posições onde: <br>
   *         <li>0 - {@link SEFAZEnviNFeVO} completado com dados automáticos e com o arquivo XML do jeito que foi enviado para a SEFAZ;<br>
   *         <li>1 - {@link SEFAZRetEnviNFeVO} equivalente ao XML de retorno da SEFAZ.
   * @throws RFWException
   */
  public Object[] nfeAutorizacaoLoteV400(SEFAZEnviNFeVO enviNFeVO) throws RFWException {
    TEnviNFe root = MapperForNfeAutorizacaoLoteV400.toJaxb(enviNFeVO);
    String[] ret = nfeAutorizacaoLoteV400asXML(root);
    SEFAZRetEnviNFeVO retEnviNFeVO = MapperForNfeAutorizacaoLoteV400.toVO(SEFAZUtils.readXMLToObject(ret[1], TRetEnviNFe.class));
    return new Object[] { ret[0], retEnviNFeVO };
  }

  /**
   * Chama o método "nfeAutorizacaoLote v4.00" disponibilizado no WebSerice da SEFAZ para autorização de NFe/NFCe. <Br>
   *
   * @param root Objeto representando o XML para envio da requisição.
   * @return Object[] com 2 posições onde: 0 - String com o XML enviado como msg para a SEFAZ, tag raiz &lt;enviNFe&gt; cm todas as NFes assinadas dentro (para arquivamento do sistema ou conferência); 1 - TRetEnviNFe equivalente ao XML de retorno da SEFAZ.
   * @throws RFWException
   */
  public Object[] nfeAutorizacaoLoteV400(TEnviNFe root) throws RFWException {
    String[] ret = nfeAutorizacaoLoteV400asXML(root);
    return new Object[] { ret[0], SEFAZUtils.readXMLToObject(ret[1], TRetEnviNFe.class) };
  }

  /**
   * Chama o método "nfeAutorizacaoLote v4.00" disponibilizado no WebSerice da SEFAZ para autorização de NFe/NFCe. <Br>
   *
   * @param root Objeto representando o XML para envio da requisição.
   * @return String[] com 2 posições onde: 0 - XML enviado como msg para a SEFAZ, tag raiz &lt;enviNFe&gt; cm todas as NFes assinadas dentro (para arquivamento do sistema ou conferência); 1 - XML de retorno da SEFAZ.
   * @throws RFWException
   */
  public String[] nfeAutorizacaoLoteV400asXML(TEnviNFe root) throws RFWException {
    SEFAZ_mod mod = null;
    try {
      String value = root.getNFe().get(0).getInfNFe().getIde().getMod();
      mod = SEFAZEnums.valueOfXMLData(SEFAZ_mod.class, value);
    } catch (Exception e) {
    }
    if (mod == null) throw new RFWCriticalException("Falha ao detectar o modelo da NF!");

    if (!SEFAZ_mod.NFE_MODELO_55.equals(mod) && !SEFAZ_mod.NFCE_MODELO_65.equals(mod)) {
      throw new RFWCriticalException("Este método só permite a emissão de documentos fo tipo NFe ou NFCe (não simultâneamente). Documento inválido: '${0}'.", new String[] { RFWBundle.get(mod) });
    }

    for (int i = 1; i < root.getNFe().size(); i++) {
      TNFe tNFe = root.getNFe().get(i);
      try {
        if (!mod.getXmlData().equals(tNFe.getInfNFe().getIde().getMod())) {
          throw new RFWCriticalException("Não é permitido misturar diferentes modelos de documentos no mesmo Lote para Autorização! Modelo do primeiro documento: '${0}'.", new String[] { RFWBundle.get(mod) });
        }
      } catch (Exception e) {
        throw new RFWCriticalException("Falha ao identificar o modelo do documento. Index: '${0}'.", new String[] { "" + i }, e);
      }
    }

    NfeDadosMsgDocument nfeDadosMsg = NfeDadosMsgDocument.Factory.newInstance();
    NfeDadosMsgDocument.NfeDadosMsg req = nfeDadosMsg.addNewNfeDadosMsg();

    String msg = SEFAZUtils.signNfeAutorizacaoLoteV400Message(cert, root);

    if (mod == SEFAZ_mod.NFCE_MODELO_65) {
      // Inserir tag infNFeSupl diretamente no XML "msg" (enviNFe assinado)
      msg = preencherInfNFeSuplComQRCode(msg);
    }

    SEFAZXMLValidator.validateEnviNFeV400(msg);

    if (RFW.getDevProperty("rfw.sefaz.pathToLogCommunicationXML") != null) {
      RUFile.writeFileContent(RFW.getDevProperty("rfw.sefaz.pathToLogCommunicationXML") + "\\enviNFe.xml", msg);
    }
    try {
      req.set(XmlObject.Factory.parse(msg));
    } catch (Exception e) {
      throw new RFWCriticalException("Falha ao criar mensagem para enviar pelo WebService da SEFAZ.", new String[] { msg }, e);
    }

    NFeAutorizacao4Stub stub = createNFeAutorizacao4Stub(mod, env, ws, contingency);
    try {
      NfeResultMsgDocument result = stub.nfeAutorizacaoLote(nfeDadosMsg);
      String xmlRet = result.getNfeResultMsg().toString();
      if (RFW.getDevProperty("rfw.sefaz.pathToLogCommunicationXML") != null) {
        RUFile.writeFileContent(RFW.getDevProperty("rfw.sefaz.pathToLogCommunicationXML") + "\\retEnviNFe.xml", xmlRet);
      }
      return new String[] { msg, xmlRet };
    } catch (RemoteException e) {
      if ("Transport error: 403 Error: Forbidden".equals(e.getMessage())) {
        throw new RFWWarningException("Não foi possível comunicar com o servidor da SEFAZ.", e);
      } else if ("Read timed out".equals(e.getMessage())) {
        throw new RFWWarningException("Não foi possível comunicar com o servidor da SEFAZ.", e);
      } else {
        RFWLogger.logError("Mensagem não mapeada de erro durante comunicação com a SEFAZ: " + e.getMessage());
        throw new RFWWarningException("Não foi possível comunicar com o servidor da SEFAZ.", e);
      }
    }
  }

  /**
   * Gera e insere a tag <infNFeSupl> com o QR-Code versão 3 da NFC-e diretamente no XML já assinado (tag <Signature> já presente).
   *
   * - Emissão normal (tpEmis = "1"): QR-Code v3 ONLINE: p = <chave_acesso>|3|<tpAmb>
   *
   * - Emissão em contingência offline (tpEmis = "9"): QR-Code v3 OFFLINE: p = <chave_acesso>|3|<tpAmb>|<dia_data_emissao>|<vNF>|<tp_idDest>|<idDest>|<assinatura> A assinatura é RSA-SHA1 em Base64 da concatenação dos parâmetros de 1 a 7, mantendo os separadores "|", usando o mesmo certificado que assina a NFC-e.
   *
   * A <infNFeSupl> é inserida logo após <infNFe> e antes de <Signature>.
   *
   * @param msg XML de envio (<enviNFe>) já assinado.
   * @return XML com as tags <infNFeSupl> preenchidas para cada NFC-e (modelo 65).
   * @throws RFWException Em caso de falha na montagem ou manipulação do XML.
   */
  private String preencherInfNFeSuplComQRCode(String msg) throws RFWException {
    final String NFE_NS = "http://www.portalfiscal.inf.br/nfe";
    final String DS_NS = "http://www.w3.org/2000/09/xmldsig#";

    try {
      // Parse do XML assinado
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      dbf.setNamespaceAware(true);
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document doc = db.parse(new ByteArrayInputStream(msg.getBytes(StandardCharsets.UTF_8)));

      // XPath com namespaces
      XPathFactory xpf = XPathFactory.newInstance();
      XPath xpath = xpf.newXPath();
      xpath.setNamespaceContext(new NamespaceContext() {
        @Override
        public String getNamespaceURI(String prefix) {
          if ("nfe".equals(prefix)) return NFE_NS;
          if ("ds".equals(prefix)) return DS_NS;
          return XMLConstants.NULL_NS_URI;
        }

        @Override
        public String getPrefix(String namespaceURI) {
          return null;
        }

        @Override
        public Iterator<String> getPrefixes(String namespaceURI) {
          return null;
        }
      });

      // Percorre todas as <NFe> dentro de <enviNFe>
      NodeList nfeList = doc.getElementsByTagNameNS(NFE_NS, "NFe");
      for (int i = 0; i < nfeList.getLength(); i++) {
        Element nfeEl = (Element) nfeList.item(i);

        // Não aceitar infNFeSupl pré-preenchida
        Element existingSupl = (Element) nfeEl.getElementsByTagNameNS(NFE_NS, "infNFeSupl").item(0);
        if (existingSupl != null) {
          throw new RFWCriticalException("Não é esperado que a tag 'infNFeSupl' esteja preenchida na NFCe. Ela será gerada automaticamente após a assinatura do XML.");
        }

        // <infNFe>
        Element infNFeEl = (Element) nfeEl.getElementsByTagNameNS(NFE_NS, "infNFe").item(0);
        if (infNFeEl == null) {
          throw new RFWCriticalException("Falha ao encontrar a tag 'infNFe' no XML para montagem do QR-Code.");
        }

        // Id -> chave
        String id = infNFeEl.getAttribute("Id"); // ex: NFe3525...
        if (id == null || id.isEmpty()) {
          throw new RFWCriticalException("Tag infNFe sem atributo 'Id' para montagem do QR-Code.");
        }
        String chave = id.startsWith("NFe") ? id.substring(3) : id;

        // Ambiente
        String tpAmb = getTextContent(xpath, infNFeEl, "nfe:ide/nfe:tpAmb");
        if (tpAmb == null || tpAmb.isEmpty()) {
          throw new RFWCriticalException("Campo tpAmb não encontrado na NFCe para montagem do QR-Code.");
        }

        // Tipo de emissão
        String tpEmis = getTextContent(xpath, infNFeEl, "nfe:ide/nfe:tpEmis");
        if (tpEmis == null || tpEmis.isEmpty()) {
          throw new RFWCriticalException("Campo tpEmis não encontrado na NFCe para montagem do QR-Code.");
        }

        // Versão do QR-Code
        final String versaoQR = "3";

        // URL base de consulta do QR-Code e da chave, por ambiente (SP)
        final String baseQrUrl;
        final String urlChave;

        // Recupera a UF a partir do ambiente que estamos utilizando, para recuperar as URLs do QRcode e consulta.
        // TODO Quando entender melhor quando os ambientes SVN forrem utilizados, melhor esse código, pois os valores de WS não estão 100% como UFs.
        SEFAZ_uf uf = SEFAZ_uf.valueOf(this.ws.toString());

        if ("2".equals(tpAmb)) {
          // Homologação
          baseQrUrl = uf.getQrCodeHomUrl();
          urlChave = uf.getConsultaHomUrl();
        } else {
          // Produção
          baseQrUrl = uf.getQrCodeProdUrl();
          urlChave = uf.getConsultaProdUrl();
        }

        final String p;
        if ("1".equals(tpEmis)) {
          // -----------------------------
          // EMISSÃO NORMAL – ONLINE (v3)
          // p = chave|3|tpAmb
          // -----------------------------
          StringBuilder sb = new StringBuilder();
          sb.append(chave).append('|').append(versaoQR).append('|').append(tpAmb);
          p = sb.toString();
        } else if ("9".equals(tpEmis)) {
          // ----------------------------------------
          // CONTINGÊNCIA OFFLINE – v3
          // p = chave|3|tpAmb|dia|vNF|tp_idDest|idDest|assinatura
          // ----------------------------------------

          // dhEmi (ISO 8601) – usamos apenas o dia (dois dígitos)
          String dhEmi = getTextContent(xpath, infNFeEl, "nfe:ide/nfe:dhEmi");
          if (dhEmi == null || dhEmi.length() < 10) {
            throw new RFWCriticalException("Campo dhEmi inválido para emissão em contingência (QR-Code v3).");
          }
          String diaEmissao = dhEmi.substring(8, 10); // yyyy-MM-dd...

          // vNF total
          String vNF = getTextContent(xpath, infNFeEl, "nfe:total/nfe:ICMSTot/nfe:vNF");
          if (vNF == null || vNF.isEmpty()) {
            throw new RFWCriticalException("Campo vNF não encontrado para montagem do QR-Code v3 offline.");
          }

          // Destinatário
          String tpIdDest = "";
          String idDest = "";
          Element destEl = (Element) infNFeEl.getElementsByTagNameNS(NFE_NS, "dest").item(0);
          if (destEl != null) {
            String cnpj = null;
            String cpf = null;
            String idEstrangeiro = null;

            NodeList cnpjList = destEl.getElementsByTagNameNS(NFE_NS, "CNPJ");
            if (cnpjList != null && cnpjList.getLength() > 0) {
              cnpj = cnpjList.item(0).getTextContent();
            }
            NodeList cpfList = destEl.getElementsByTagNameNS(NFE_NS, "CPF");
            if (cpfList != null && cpfList.getLength() > 0) {
              cpf = cpfList.item(0).getTextContent();
            }
            NodeList idEstList = destEl.getElementsByTagNameNS(NFE_NS, "idEstrangeiro");
            if (idEstList != null && idEstList.getLength() > 0) {
              idEstrangeiro = idEstList.item(0).getTextContent();
            }

            if (cnpj != null && !cnpj.isEmpty()) {
              tpIdDest = "1";
              idDest = cnpj.replaceAll("\\D", "");
            } else if (cpf != null && !cpf.isEmpty()) {
              tpIdDest = "2";
              idDest = cpf.replaceAll("\\D", "");
            } else if (idEstrangeiro != null && !idEstrangeiro.isEmpty()) {
              tpIdDest = "3";
              idDest = idEstrangeiro.trim();
            }
          }

          // Monta string base (parâmetros 1..7)
          StringBuilder payload = new StringBuilder();
          payload.append(chave).append('|').append(versaoQR).append('|').append(tpAmb).append('|').append(diaEmissao).append('|').append(vNF).append('|');

          if (tpIdDest.isEmpty() || idDest.isEmpty()) {
            // Destinatário não identificado -> apenas separadores
            payload.append('|').append('|');
          } else {
            payload.append(tpIdDest).append('|').append(idDest);
          }

          // Assinatura digital RSA-SHA1 em Base64 do payload (1..7)
          String assinatura = null;
          try {
            assinatura = RUCert.signTextSHA1withRSA(payload.toString(), this.cert);
          } catch (Exception e) {
            throw new RFWCriticalException("Falha ao assinar o payload do QR-Code v3 OFFLINE da NFC-e.", e);
          }

          // Monta p completo (1..8)
          payload.append('|').append(assinatura);
          p = payload.toString();
        } else {
          // Outros tipos de emissão não tratados ainda para QR-Code v3
          throw new RFWCriticalException("tpEmis '" + tpEmis + "' não suportado para geração do QR-Code v3 da NFC-e.");
        }

        // Monta URL final do QR-Code
        String qrCode = baseQrUrl + "?p=" + p;

        // Cria <infNFeSupl>
        Element infNFeSuplEl = doc.createElementNS(NFE_NS, "infNFeSupl");

        Element qrCodeEl = doc.createElementNS(NFE_NS, "qrCode");
        qrCodeEl.setTextContent(qrCode);
        infNFeSuplEl.appendChild(qrCodeEl);

        Element urlChaveEl = doc.createElementNS(NFE_NS, "urlChave");
        urlChaveEl.setTextContent(urlChave);
        infNFeSuplEl.appendChild(urlChaveEl);

        // Inserir ANTES de <Signature>
        Node signatureChild = null;
        NodeList children = nfeEl.getChildNodes();
        for (int c = 0; c < children.getLength(); c++) {
          Node n = children.item(c);
          if (n.getNodeType() == Node.ELEMENT_NODE) {
            String local = n.getLocalName();
            String ns = n.getNamespaceURI();
            if ("Signature".equals(local) && DS_NS.equals(ns)) {
              signatureChild = n;
              break;
            }
          }
        }

        if (signatureChild != null) {
          nfeEl.insertBefore(infNFeSuplEl, signatureChild);
        } else {
          // fallback: não achou Signature (caso anormal)
          nfeEl.appendChild(infNFeSuplEl);
        }
      }

      // Serializa de volta para String
      TransformerFactory tf = TransformerFactory.newInstance();
      Transformer transformer = tf.newTransformer();
      transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
      transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
      transformer.setOutputProperty(OutputKeys.INDENT, "no");

      StringWriter sw = new StringWriter();
      transformer.transform(new DOMSource(doc), new StreamResult(sw));
      return sw.toString();

    } catch (RFWException e) {
      throw e;
    } catch (Exception e) {
      throw new RFWCriticalException("Falha ao incluir a tag infNFeSupl com o QR-Code v3 na NFCe.", e);
    }
  }

  /**
   * Helper simples para ler texto via XPath relativo ao nó de contexto.
   */
  private String getTextContent(XPath xpath, Element context, String expr) throws XPathExpressionException {
    String value = (String) xpath.evaluate(expr, context, XPathConstants.STRING);
    return (value != null) ? value.trim() : null;
  }

  // private String preencherInfNFeSuplComQRCode(String msg) throws RFWException {
  // try {
  // // Parse do XML assinado
  // DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
  // dbf.setNamespaceAware(true);
  // DocumentBuilder db = dbf.newDocumentBuilder();
  // Document doc = db.parse(new ByteArrayInputStream(msg.getBytes(StandardCharsets.UTF_8)));
  //
  // XPathFactory xpf = XPathFactory.newInstance();
  // XPath xpath = xpf.newXPath();
  // xpath.setNamespaceContext(new NamespaceContext() {
  // @Override
  // public String getNamespaceURI(String prefix) {
  // if ("ds".equals(prefix)) return "http://www.w3.org/2000/09/xmldsig#";
  // if ("nfe".equals(prefix)) return "http://www.portalfiscal.inf.br/nfe";
  // return XMLConstants.NULL_NS_URI;
  // }
  //
  // @Override
  // public String getPrefix(String namespaceURI) {
  // return null;
  // }
  //
  // @Override
  // public Iterator<String> getPrefixes(String namespaceURI) {
  // return null;
  // }
  // });
  //
  // final String NFE_NS = "http://www.portalfiscal.inf.br/nfe";
  // final String DS_NS = "http://www.w3.org/2000/09/xmldsig#";
  //
  // // Lista de NFe dentro do enviNFe
  // NodeList nfeList = doc.getElementsByTagNameNS(NFE_NS, "NFe");
  // for (int i = 0; i < nfeList.getLength(); i++) {
  // Element nfeEl = (Element) nfeList.item(i);
  //
  // // infNFe
  // Element infNFeEl = (Element) nfeEl.getElementsByTagNameNS(NFE_NS, "infNFe").item(0);
  // if (infNFeEl == null) continue;
  //
  // // tpEMis
  // String tpEmis = getTextContent(xpath, infNFeEl, "nfe:ide/nfe:tpEmis");
  // // Somente layout ONLINE (tpEmis = 1). Offline é outro layout.
  // if (!SEFAZ_tpEmis.EMISSAO_NORMAL.getXMLData().equals(tpEmis)) {
  // throw new RFWCriticalException("Tipo de emissão não suportada para NFCe!");
  // }
  //
  // // tpAmb
  // String tpAmb = getTextContent(xpath, infNFeEl, "nfe:ide/nfe:tpAmb");
  //
  // String id = infNFeEl.getAttribute("Id"); // ex: "NFe3525..."
  // if (id == null || id.isEmpty()) continue;
  // String chave = id.startsWith("NFe") ? id.substring(3) : id;
  //
  // String versaoQR = "2";
  //
  // // Passo 1: concatena campos com "|"
  // StringBuilder sb = new StringBuilder();
  // sb.append(chave).append('|').append(versaoQR).append('|').append(tpAmb).append('|').append(getCscId());
  //
  // // Passo 2: adiciona CSC no final
  // String conteudoHash = sb.toString() + getCsc();
  //
  // // Passo 3: SHA-1 em hexa (40 caracteres)
  // String cHashQRCode = RUString.calcSHA1ToHex(conteudoHash, StandardCharsets.UTF_8);
  //
  // // Parâmetro "p"
  // String p = chave + "|" + versaoQR + "|" + tpAmb + "|" + getCscId() + "|" + cHashQRCode;
  //
  // // URLs por ambiente
  // String baseQrUrl;
  // String urlChave;
  // if ("2".equals(tpAmb)) {
  // // Homologação SP
  // // baseQrUrl = "https://www.homologacao.nfce.fazenda.sp.gov.br/NFCeConsultaPublica/Paginas/ConsultaQRCode.aspx";
  // baseQrUrl = "https://www.homologacao.nfce.fazenda.sp.gov.br/qrcode";
  // // urlChave = "https://www.homologacao.nfce.fazenda.sp.gov.br/NFCeConsultaPublica";
  // urlChave = "https://www.homologacao.nfce.fazenda.sp.gov.br/consulta";
  // } else {
  // // Produção SP
  // // baseQrUrl = "https://www.nfce.fazenda.sp.gov.br/NFCeConsultaPublica/Paginas/ConsultaQRCode.aspx";
  // baseQrUrl = "https://www.nfce.fazenda.sp.gov.br/qrcode";
  // // urlChave = "https://www.nfce.fazenda.sp.gov.br/NFCeConsultaPublica/Paginas/ConsultaNFCe.aspx";
  // urlChave = "https://www.nfce.fazenda.sp.gov.br/NFCeConsultaPublica";
  // }
  //
  // String qrCode = baseQrUrl + "?p=" + p;
  //
  // // --------- Cria infNFeSupl / qrCode / urlChave -----------
  // Element infNFeSuplEl = doc.createElementNS(NFE_NS, "infNFeSupl");
  //
  // Element qrCodeEl = doc.createElementNS(NFE_NS, "qrCode");
  // qrCodeEl.setTextContent(qrCode);
  // infNFeSuplEl.appendChild(qrCodeEl);
  //
  // Element urlChaveEl = doc.createElementNS(NFE_NS, "urlChave");
  // urlChaveEl.setTextContent(urlChave);
  // infNFeSuplEl.appendChild(urlChaveEl);
  //
  // // --------- Inserir infNFeSupl ANTES de <Signature> ---------
  // // Ordem correta no NFe: infNFe, infNFeSupl (NFC-e), Signature
  // Node signatureChild = null;
  // NodeList children = nfeEl.getChildNodes();
  // for (int c = 0; c < children.getLength(); c++) {
  // Node n = children.item(c);
  // if (n.getNodeType() == Node.ELEMENT_NODE) {
  // String local = n.getLocalName();
  // String ns = n.getNamespaceURI();
  // if ("Signature".equals(local) && DS_NS.equals(ns)) {
  // signatureChild = n;
  // break;
  // }
  // }
  // }
  //
  // if (signatureChild != null) {
  // // Insere imediatamente antes da assinatura
  // nfeEl.insertBefore(infNFeSuplEl, signatureChild);
  // } else {
  // // Caso improvável: ainda não exista Signature
  // nfeEl.appendChild(infNFeSuplEl);
  // }
  // }
  //
  // // Transformar de volta para String
  // TransformerFactory tf = TransformerFactory.newInstance();
  // Transformer transformer = tf.newTransformer();
  // transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
  // transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
  // transformer.setOutputProperty(OutputKeys.INDENT, "no");
  //
  // StringWriter sw = new StringWriter();
  // transformer.transform(new DOMSource(doc), new StreamResult(sw));
  // return sw.toString();
  //
  // } catch (RFWException e) {
  // throw e;
  // } catch (Exception e) {
  // throw new RFWCriticalException("Falha ao incluir a tag infNFeSupl com o QRCode na NFCe.", e);
  // }
  // }

  // private String getTextContent(XPath xpath, Element context, String expr) throws XPathExpressionException {
  // String v = (String) xpath.evaluate(expr, context, XPathConstants.STRING);
  // return (v != null) ? v.trim() : null;
  // }

  /**
   * Chama o método "nfeRetAutorizacao v4.00" disponibilizado no WebSerice da SEFAZ para consultar autorização de NFe/NFCe passando um recibo de consulta.<Br>
   *
   * @param nRec Número do recibo obtido na entrega do documento para realizar a consulta.
   * @return Objeto do XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public TRetConsReciNFe nfeRetAutorizacaoV400byNRec(String nRec) throws RFWException {
    TConsReciNFe root = SEFAZUtils.mountNFeRetAutorizacaoV400MessageFromNRec(env, nRec);
    return nfeRetAutorizacaoV400(root);
  }

  /**
   * Chama o método "nfeRetAutorizacao v4.00" disponibilizado no WebSerice da SEFAZ para consultar autorização de NFe/NFCe passando um recibo de consulta.<Br>
   *
   * @param nRec Número do recibo obtido na entrega do documento para realizar a consulta.
   * @return XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public String nfeRetAutorizacaoV400byNRecasXML(String nRec) throws RFWException {
    TConsReciNFe root = SEFAZUtils.mountNFeRetAutorizacaoV400MessageFromNRec(env, nRec);
    return nfeRetAutorizacaoV400asXML(root);
  }

  /**
   * Chama o método "nfeRetAutorizacao v4.00" disponibilizado no WebSerice da SEFAZ para consultar autorização de NFe/NFCe. <Br>
   *
   * @param root Objeto representando o XML para envio da requisição.
   * @return Objeto do XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public TRetConsReciNFe nfeRetAutorizacaoV400(TConsReciNFe root) throws RFWException {
    return SEFAZUtils.readXMLToObject(nfeRetAutorizacaoV400asXML(root), TRetConsReciNFe.class);
  }

  /**
   * Chama o método "nfeRetAutorizacao v4.00" disponibilizado no WebSerice da SEFAZ para consultar autorização de NFe/NFCe. <Br>
   *
   * @param root Objeto representando o XML para envio da requisição.
   * @return XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public String nfeRetAutorizacaoV400asXML(TConsReciNFe root) throws RFWException {
    br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeDadosMsgDocument nfeDadosMsg = br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeDadosMsgDocument.Factory.newInstance();
    br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeDadosMsgDocument.NfeDadosMsg req = nfeDadosMsg.addNewNfeDadosMsg();
    NFeRetAutorizacao4Stub stub = createNFeRetAutorizacao4Stub(env, ws, contingency);

    String msg = SEFAZUtils.writeXMLFromObject(root);
    SEFAZXMLValidator.validateConsReciNFeV400(msg);
    if (RFW.getDevProperty("rfw.sefaz.pathToLogCommunicationXML") != null) {
      RUFile.writeFileContent(RFW.getDevProperty("rfw.sefaz.pathToLogCommunicationXML") + "\\consReciNFe.xml", msg);
    }
    try {
      req.set(XmlObject.Factory.parse(msg));
    } catch (Exception e) {
      throw new RFWCriticalException("Falha ao criar mensagem para enviar pelo WebService da SEFAZ.", new String[] { msg }, e);
    }

    try {
      br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument result = stub.nfeRetAutorizacaoLote(nfeDadosMsg);
      String xmlRet = result.getNfeResultMsg().toString();
      if (RFW.getDevProperty("rfw.sefaz.pathToLogCommunicationXML") != null) {
        RUFile.writeFileContent(RFW.getDevProperty("rfw.sefaz.pathToLogCommunicationXML") + "\\retConsReciNFe.xml", xmlRet);
      }
      return xmlRet;
    } catch (RemoteException e) {
      if ("Transport error: 403 Error: Forbidden".equals(e.getMessage())) {
        throw new RFWWarningException("Não foi possível comunicar com o servidor da SEFAZ.", e);
      } else if ("Read timed out".equals(e.getMessage())) {
        throw new RFWWarningException("Não foi possível comunicar com o servidor da SEFAZ.", e);
      } else {
        RFWLogger.logError("Mensagem não mapeada de erro durante comunicação com a SEFAZ: " + e.getMessage());
        throw new RFWWarningException("Não foi possível comunicar com o servidor da SEFAZ.", e);
      }
    }
  }

  /**
   * Cria o STUB de conexão para o serviço NfeConsultaCadastro.
   *
   * @param env ambiente de conexão.
   * @param ws Servidor para conexão.
   * @param contingency Método de contingência ou null para nenhuma contingência.
   * @return Stub pronto para conexão.
   * @throws RFWException
   */
  private CadConsultaCadastro4Stub createCadConsultaCadastro4Stub(SEFAZ_tpAmb env, SEFAZ_WebServices ws, SefazContingency contingency) throws RFWException {
    CadConsultaCadastro4Stub stub = null;
    try {
      if (env.equals(SEFAZ_tpAmb.PRODUCAO)) {
        if (ws.equals(SEFAZ_WebServices.SP)) {
          if (contingency == null) {
            stub = new CadConsultaCadastro4Stub(SEFAZDefinitions.NFE_SP_PRODUCTION_V400_CADCONSULTACADASTRO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), ws.toString(), "" + contingency });
          }
        }
      } else if (env.equals(SEFAZ_tpAmb.HOMOLOGACAO)) {
        if (ws.equals(SEFAZ_WebServices.SP)) {
          if (contingency == null) {
            stub = new CadConsultaCadastro4Stub(SEFAZDefinitions.NFE_SP_TEST_V400_CADCONSULTACADASTRO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), ws.toString(), "" + contingency });
          }
        }
      }
    } catch (AxisFault e) {
      throw new RFWCriticalException("Falha ao criar Stub para o ambiente '${0}', UF '${1}', contingência: '${2}'.", new String[] { env.toString(), ws.toString(), "" + contingency }, e);
    }
    if (stub == null) {
      throw new RFWCriticalException("Falha ao criar Stub para o ambiente '${0}', UF '${1}', contingência: '${2}'.", new String[] { env.toString(), ws.toString(), "" + contingency });
    }
    stub._getServiceClient().getOptions().setProperty(HTTPConstants.CACHED_HTTP_CLIENT, this.httpClientCustom);
    return stub;
  }

  /**
   * Cria o STUB de conexão para o serviço nfeStatusServicoNF.
   *
   * @param env ambiente de conexão.
   * @param ws Servidor para conexão.
   * @param contingency Método de contingência ou null para nenhuma contingência.
   * @return Stub pronto para conexão.
   * @throws RFWException
   */
  private NFeStatusServico4Stub createNfeStatusServicoNFStub(SEFAZ_tpAmb env, SEFAZ_WebServices ws, SefazContingency contingency) throws RFWException {
    NFeStatusServico4Stub stub = null;
    try {
      if (env.equals(SEFAZ_tpAmb.PRODUCAO)) {
        if (ws.equals(SEFAZ_WebServices.SP)) {
          if (contingency == null) {
            stub = new NFeStatusServico4Stub(SEFAZDefinitions.NFE_SP_PRODUCTION_V400_NFESTATUSSERVICO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), ws.toString(), "" + contingency });
          }
        }
      } else if (env.equals(SEFAZ_tpAmb.HOMOLOGACAO)) {
        if (ws.equals(SEFAZ_WebServices.SP)) {
          if (contingency == null) {
            stub = new NFeStatusServico4Stub(SEFAZDefinitions.NFE_SP_TEST_V400_NFESTATUSSERVICO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), ws.toString(), "" + contingency });
          }
        }
      }
    } catch (AxisFault e) {
      throw new RFWCriticalException("Falha ao criar Stub para o ambiente '${0}', UF '${1}', contingência: '${2}'.", new String[] { env.toString(), ws.toString(), "" + contingency }, e);
    }
    if (stub == null) {
      throw new RFWCriticalException("Falha ao criar Stub para o ambiente '${0}', UF '${1}', contingência: '${2}'.", new String[] { env.toString(), ws.toString(), "" + contingency });
    }
    stub._getServiceClient().getOptions().setProperty(HTTPConstants.CACHED_HTTP_CLIENT, this.httpClientCustom);
    return stub;
  }

  /**
   * Cria o STUB de conexão para o serviço NfeAutorizacao.
   *
   * @param mod Define o modelo do Stub a ser criado, aceita NFe e NFCe, cada um utiliza um endereço de endpoint diferente.
   * @param env ambiente de conexão.
   * @param ws Servidor para conexão.
   * @param contingency Método de contingência ou null para nenhuma contingência.
   * @return Stub pronto para conexão.
   * @throws RFWException
   */
  private NFeAutorizacao4Stub createNFeAutorizacao4Stub(SEFAZ_mod mod, SEFAZ_tpAmb env, SEFAZ_WebServices ws, SefazContingency contingency) throws RFWException {
    NFeAutorizacao4Stub stub = null;
    try {
      if (mod.equals(SEFAZ_mod.NFE_MODELO_55)) {
        if (env.equals(SEFAZ_tpAmb.PRODUCAO)) {
          if (ws.equals(SEFAZ_WebServices.SP)) {
            if (contingency == null) {
              stub = new NFeAutorizacao4Stub(SEFAZDefinitions.NFE_SP_PRODUCTION_V400_NFEAUTORIZACAO4);
            } else {
              throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), ws.toString(), "" + contingency });
            }
          }
        } else if (env.equals(SEFAZ_tpAmb.HOMOLOGACAO)) {
          if (ws.equals(SEFAZ_WebServices.SP)) {
            if (contingency == null) {
              stub = new NFeAutorizacao4Stub(SEFAZDefinitions.NFE_SP_TEST_V400_NFEAUTORIZACAO4);
            } else {
              throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), ws.toString(), "" + contingency });
            }
          }
        }
      } else if (mod.equals(SEFAZ_mod.NFCE_MODELO_65)) {
        if (env.equals(SEFAZ_tpAmb.PRODUCAO)) {
          if (ws.equals(SEFAZ_WebServices.SP)) {
            if (contingency == null) {
              stub = new NFeAutorizacao4Stub(SEFAZDefinitions.NFCE_SP_PRODUCTION_V400_NFEAUTORIZACAO4);
            } else {
              throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), ws.toString(), "" + contingency });
            }
          }
        } else if (env.equals(SEFAZ_tpAmb.HOMOLOGACAO)) {
          if (ws.equals(SEFAZ_WebServices.SP)) {
            if (contingency == null) {
              stub = new NFeAutorizacao4Stub(SEFAZDefinitions.NFCE_SP_TEST_V400_NFEAUTORIZACAO4);
            } else {
              throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), ws.toString(), "" + contingency });
            }
          }
        }
      }
    } catch (AxisFault e) {
      throw new RFWCriticalException("Falha ao criar Stub para o ambiente '${0}', UF '${1}', contingência: '${2}', modelo '${3}'.", new String[] { env.toString(), ws.toString(), "" + contingency, "" + mod.toString() }, e);
    }
    if (stub == null) {
      throw new RFWCriticalException("Falha ao criar Stub para o ambiente '${0}', UF '${1}', contingência: '${2}', modelo '${3}'.", new String[] { env.toString(), ws.toString(), "" + contingency, "" + mod.toString() });
    }
    stub._getServiceClient().getOptions().setProperty(HTTPConstants.CACHED_HTTP_CLIENT, this.httpClientCustom);
    return stub;
  }

  /**
   * Cria o STUB de conexão para o serviço NfeRetAutorizacao.
   *
   * @param env ambiente de conexão.
   * @param ws Servidor para conexão.
   * @param contingency Método de contingência ou null para nenhuma contingência.
   * @return Stub pronto para conexão.
   * @throws RFWException
   */
  private NFeRetAutorizacao4Stub createNFeRetAutorizacao4Stub(SEFAZ_tpAmb env, SEFAZ_WebServices ws, SefazContingency contingency) throws RFWException {
    NFeRetAutorizacao4Stub stub = null;
    try {
      if (env.equals(SEFAZ_tpAmb.PRODUCAO)) {
        if (ws.equals(SEFAZ_WebServices.SP)) {
          if (contingency == null) {
            stub = new NFeRetAutorizacao4Stub(SEFAZDefinitions.NFE_SP_PRODUCTION_V400_NFERETAUTORIZACAO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), ws.toString(), "" + contingency });
          }
        }
      } else if (env.equals(SEFAZ_tpAmb.HOMOLOGACAO)) {
        if (ws.equals(SEFAZ_WebServices.SP)) {
          if (contingency == null) {
            stub = new NFeRetAutorizacao4Stub(SEFAZDefinitions.NFE_SP_TEST_V400_NFERETAUTORIZACAO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), ws.toString(), "" + contingency });
          }
        }
      }
    } catch (AxisFault e) {
      throw new RFWCriticalException("Falha ao criar Stub para o ambiente '${0}', UF '${1}', contingência: '${2}'.", new String[] { env.toString(), ws.toString(), "" + contingency }, e);
    }
    if (stub == null) {
      throw new RFWCriticalException("Falha ao criar Stub para o ambiente '${0}', UF '${1}', contingência: '${2}'.", new String[] { env.toString(), ws.toString(), "" + contingency });
    }
    stub._getServiceClient().getOptions().setProperty(HTTPConstants.CACHED_HTTP_CLIENT, this.httpClientCustom);
    return stub;
  }

  /**
   * Chama o método "consultaCadastro v2.00" disponibilizado no WebSerice da SEFAZ para consultar o contribuinte. <Br>
   *
   * @param root Objeto representando o XML para envio da requisição.
   * @return Objeto do XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public TRetInutNFe nfeInutilizacaoNFV400(TInutNFe root) throws RFWException {
    return SEFAZUtils.readXMLToObject(nfeInutilizacaoNFV400asXML(root), TRetInutNFe.class);
  }

  /**
   * Chama o método "consultaCadastro v2.00" disponibilizado no WebSerice da SEFAZ para consultar o contribuinte. <Br>
   *
   * @param root Objeto representando o XML para envio da requisição.
   * @return XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public String nfeInutilizacaoNFV400asXML(TInutNFe root) throws RFWException {
    br.inf.portalfiscal.www.nfe.wsdl.nfeinutilizacao4.NfeDadosMsgDocument nfeDadosMsg = br.inf.portalfiscal.www.nfe.wsdl.nfeinutilizacao4.NfeDadosMsgDocument.Factory.newInstance();
    br.inf.portalfiscal.www.nfe.wsdl.nfeinutilizacao4.NfeDadosMsgDocument.NfeDadosMsg req = nfeDadosMsg.addNewNfeDadosMsg();

    String msg = SEFAZUtils.writeXMLFromObject(root);
    SEFAZXMLValidator.validateInutNFeV400(msg);
    try {
      req.set(XmlObject.Factory.parse(msg));
    } catch (Exception e) {
      throw new RFWCriticalException("Falha ao criar mensagem para enviar pelo WebService da SEFAZ.", new String[] { msg }, e);
    }

    NFeInutilizacao4Stub stub = createNFeInutilizacao4Stub(env, ws, contingency);

    try {
      br.inf.portalfiscal.www.nfe.wsdl.nfeinutilizacao4.NfeResultMsgDocument result = stub.nfeInutilizacaoNF(nfeDadosMsg);
      return result.getNfeResultMsg().toString();
    } catch (RemoteException e) {
      if ("Transport error: 403 Error: Forbidden".equals(e.getMessage())) {
        throw new RFWWarningException("Não foi possível comunicar com o servidor da SEFAZ.", e);
      } else if ("Read timed out".equals(e.getMessage())) {
        throw new RFWWarningException("Não foi possível comunicar com o servidor da SEFAZ.", e);
      } else {
        RFWLogger.logError("Mensagem não mapeada de erro durante comunicação com a SEFAZ: " + e.getMessage());
        throw new RFWWarningException("Não foi possível comunicar com o servidor da SEFAZ.", e);
      }
    }
  }

  /**
   * Cria o STUB de conexão para o serviço nfeInutilizacaoNFV400.
   *
   * @param env ambiente de conexão.
   * @param ws Servidor para conexão.
   * @param contingency Método de contingência ou null para nenhuma contingência.
   * @return Stub pronto para conexão.
   * @throws RFWException
   */
  private NFeInutilizacao4Stub createNFeInutilizacao4Stub(SEFAZ_tpAmb env, SEFAZ_WebServices ws, SefazContingency contingency) throws RFWException {
    NFeInutilizacao4Stub stub = null;
    try {
      if (env.equals(SEFAZ_tpAmb.PRODUCAO)) {
        if (ws.equals(SEFAZ_WebServices.SP)) {
          if (contingency == null) {
            stub = new NFeInutilizacao4Stub(SEFAZDefinitions.NFE_SP_PRODUCTION_V400_NFEINUTILIZACAO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), ws.toString(), "" + contingency });
          }
        }
      } else if (env.equals(SEFAZ_tpAmb.HOMOLOGACAO)) {
        if (ws.equals(SEFAZ_WebServices.SP)) {
          if (contingency == null) {
            stub = new NFeInutilizacao4Stub(SEFAZDefinitions.NFE_SP_TEST_V400_NFEINUTILIZACAO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), ws.toString(), "" + contingency });
          }
        }
      }
    } catch (AxisFault e) {
      throw new RFWCriticalException("Falha ao criar Stub para o ambiente '${0}', UF '${1}', contingência: '${2}'.", new String[] { env.toString(), ws.toString(), "" + contingency }, e);
    }
    if (stub == null) {
      throw new RFWCriticalException("Falha ao criar Stub para o ambiente '${0}', UF '${1}', contingência: '${2}'.", new String[] { env.toString(), ws.toString(), "" + contingency });
    }
    stub._getServiceClient().getOptions().setProperty(HTTPConstants.CACHED_HTTP_CLIENT, this.httpClientCustom);
    return stub;
  }

  /**
   * Chama o método "nfeRecepcaoEventoV400asXML v4.00" disponibilizado no WebSerice da SEFAZ para consultar o contribuinte. <Br>
   *
   * @param root Objeto representando o XML para envio da requisição.
   * @return Objeto do XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public TRetEnvEvento nfeRecepcaoEventoV400(TEnvEvento root) throws RFWException {
    return SEFAZUtils.readXMLToObject(nfeRecepcaoEventoV400asXML(root), TRetEnvEvento.class);
  }

  /**
   * Chama o método "nfeRecepcaoEventoV400asXML v4.00" disponibilizado no WebSerice da SEFAZ para consultar o contribuinte. <Br>
   *
   * @param root Objeto representando o XML para envio da requisição.
   * @return XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public String nfeRecepcaoEventoV400asXML(TEnvEvento root) throws RFWException {
    br.inf.portalfiscal.www.nfe.wsdl.nferecepcaoevento4.NfeDadosMsgDocument nfeDadosMsg = br.inf.portalfiscal.www.nfe.wsdl.nferecepcaoevento4.NfeDadosMsgDocument.Factory.newInstance();
    br.inf.portalfiscal.www.nfe.wsdl.nferecepcaoevento4.NfeDadosMsgDocument.NfeDadosMsg req = nfeDadosMsg.addNewNfeDadosMsg();

    String msg = SEFAZUtils.writeXMLFromObject(root);
    SEFAZXMLValidator.validateEnvEventoV100(msg);
    try {
      req.set(XmlObject.Factory.parse(msg));
    } catch (Exception e) {
      throw new RFWCriticalException("Falha ao criar mensagem para enviar pelo WebService da SEFAZ.", new String[] { msg }, e);
    }

    NFeRecepcaoEvento4Stub stub = createNFeRecepcaoEvento4Stub(env, ws, contingency);

    try {
      br.inf.portalfiscal.www.nfe.wsdl.nferecepcaoevento4.NfeResultMsgDocument result = stub.nfeRecepcaoEvento(nfeDadosMsg);
      return result.getNfeResultMsg().toString();
    } catch (RemoteException e) {
      if ("Transport error: 403 Error: Forbidden".equals(e.getMessage())) {
        throw new RFWWarningException("Não foi possível comunicar com o servidor da SEFAZ.", e);
      } else if ("Read timed out".equals(e.getMessage())) {
        throw new RFWWarningException("Não foi possível comunicar com o servidor da SEFAZ.", e);
      } else {
        RFWLogger.logError("Mensagem não mapeada de erro durante comunicação com a SEFAZ: " + e.getMessage());
        throw new RFWWarningException("Não foi possível comunicar com o servidor da SEFAZ.", e);
      }
    }
  }

  /**
   * Cria o STUB de conexão para o serviço nfeRecepcaoEventoV400.
   *
   * @param env ambiente de conexão.
   * @param ws Servidor para conexão.
   * @param contingency Método de contingência ou null para nenhuma contingência.
   * @return Stub pronto para conexão.
   * @throws RFWException
   */
  private NFeRecepcaoEvento4Stub createNFeRecepcaoEvento4Stub(SEFAZ_tpAmb env, SEFAZ_WebServices ws, SefazContingency contingency) throws RFWException {
    NFeRecepcaoEvento4Stub stub = null;
    try {
      if (env.equals(SEFAZ_tpAmb.PRODUCAO)) {
        if (ws.equals(SEFAZ_WebServices.SP)) {
          if (contingency == null) {
            stub = new NFeRecepcaoEvento4Stub(SEFAZDefinitions.NFE_SP_PRODUCTION_V400_NFERECEPCAOEVENTO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), ws.toString(), "" + contingency });
          }
        }
      } else if (env.equals(SEFAZ_tpAmb.HOMOLOGACAO)) {
        if (ws.equals(SEFAZ_WebServices.SP)) {
          if (contingency == null) {
            stub = new NFeRecepcaoEvento4Stub(SEFAZDefinitions.NFE_SP_TEST_V400_NFERECEPCAOEVENTO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), ws.toString(), "" + contingency });
          }
        }
      }
    } catch (AxisFault e) {
      throw new RFWCriticalException("Falha ao criar Stub para o ambiente '${0}', UF '${1}', contingência: '${2}'.", new String[] { env.toString(), ws.toString(), "" + contingency }, e);
    }
    if (stub == null) {
      throw new RFWCriticalException("Falha ao criar Stub para o ambiente '${0}', UF '${1}', contingência: '${2}'.", new String[] { env.toString(), ws.toString(), "" + contingency });
    }
    stub._getServiceClient().getOptions().setProperty(HTTPConstants.CACHED_HTTP_CLIENT, this.httpClientCustom);
    return stub;
  }

  /**
   * Chama o método "nfeConsulta" do Web Service "NfeConsultaProtocolo v4.00".<Br>
   * <b>Função:</b> serviço destinado ao atendimento de solicitações de consulta da situação atual da NF-e na Base de Dados do Portal da Secretaria de Fazenda Estadual.
   *
   * @param chaveNF Chave da NFe para consulta.
   * @return XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public TRetConsSitNFe nfeConsultaNFV400byChaveNF(String chaveNF) throws RFWException {
    PreProcess.requiredNonNullMatch(chaveNF, "\\d{44}", "É esperada uma chave da NFe válida com 44 dígitos, sem pontuação");
    TConsSitNFe root = new TConsSitNFe();
    root.setVersao("4.00");
    root.setTpAmb(this.env.getXmlData());
    root.setChNFe(chaveNF);
    root.setXServ("CONSULTAR");
    return SEFAZUtils.readXMLToObject(nfeConsultaNFV400asXML(root), TRetConsSitNFe.class);
  }

  /**
   * Chama o método "nfeConsulta" do Web Service "NfeConsultaProtocolo v4.00".<Br>
   * <b>Função:</b> serviço destinado ao atendimento de solicitações de consulta da situação atual da NF-e na Base de Dados do Portal da Secretaria de Fazenda Estadual.
   *
   * @param chaveNF Chave da NFe para consulta.
   * @return XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public String nfeConsultaNFV400byChaveNFasXML(String chaveNF) throws RFWException {
    PreProcess.requiredNonNullMatch(chaveNF, "\\d{44}", "É esperada uma chave da NFe válida com 44 dígitos, sem pontuação");
    TConsSitNFe root = new TConsSitNFe();
    root.setVersao("4.00");
    root.setTpAmb(this.env.getXmlData());
    root.setChNFe(chaveNF);
    root.setXServ("CONSULTAR");
    return nfeConsultaNFV400asXML(root);
  }

  /**
   * Chama o método "nfeConsulta" do Web Service "NfeConsultaProtocolo v4.00". <Br>
   * <b>Função:</b> serviço destinado ao atendimento de solicitações de consulta da situação atual da NF-e na Base de Dados do Portal da Secretaria de Fazenda Estadual.
   *
   * @param root Objeto representando o XML para envio da requisição.
   * @return Objeto JAXB representando o XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public TRetConsSitNFe nfeConsultaNFV400(TConsSitNFe root) throws RFWException {
    return SEFAZUtils.readXMLToObject(nfeConsultaNFV400asXML(root), TRetConsSitNFe.class);
  }

  /**
   * Chama o método "nfeConsulta" do Web Service "NfeConsultaProtocolo v4.00". <Br>
   * <b>Função:</b> serviço destinado ao atendimento de solicitações de consulta da situação atual da NF-e na Base de Dados do Portal da Secretaria de Fazenda Estadual.
   *
   * @param root Objeto representando o XML para envio da requisição.
   * @return XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public String nfeConsultaNFV400asXML(TConsSitNFe root) throws RFWException {
    br.inf.portalfiscal.www.nfe.wsdl.nfeconsultaprotocolo4.NfeDadosMsgDocument nfeDadosMsg = br.inf.portalfiscal.www.nfe.wsdl.nfeconsultaprotocolo4.NfeDadosMsgDocument.Factory.newInstance();
    br.inf.portalfiscal.www.nfe.wsdl.nfeconsultaprotocolo4.NfeDadosMsgDocument.NfeDadosMsg req = nfeDadosMsg.addNewNfeDadosMsg();

    String msg = SEFAZUtils.writeXMLFromObject(root);
    SEFAZXMLValidator.validateConsSitNFeV400(msg);
    try {
      req.set(XmlObject.Factory.parse(msg));
    } catch (Exception e) {
      throw new RFWCriticalException("Falha ao criar mensagem para enviar pelo WebService da SEFAZ.", new String[] { msg }, e);
    }

    NFeConsultaProtocolo4Stub stub = createNFeConsultaProtocolo4Stub(env, ws, contingency);

    try {
      br.inf.portalfiscal.www.nfe.wsdl.nfeconsultaprotocolo4.NfeResultMsgDocument result = stub.nfeConsultaNF(nfeDadosMsg);
      return result.getNfeResultMsg().toString();
    } catch (RemoteException e) {
      if ("Transport error: 403 Error: Forbidden".equals(e.getMessage())) {
        throw new RFWWarningException("Não foi possível comunicar com o servidor da SEFAZ.", e);
      } else if ("Read timed out".equals(e.getMessage())) {
        throw new RFWWarningException("Não foi possível comunicar com o servidor da SEFAZ.", e);
      } else {
        RFWLogger.logError("Mensagem não mapeada de erro durante comunicação com a SEFAZ: " + e.getMessage());
        throw new RFWWarningException("Não foi possível comunicar com o servidor da SEFAZ.", e);
      }
    }
  }

  /**
   * Cria o STUB de conexão para o serviço "NfeConsultaProtocolo".
   *
   * @param env ambiente de conexão.
   * @param ws Servidor para conexão.
   * @param contingency Método de contingência ou null para nenhuma contingência.
   * @return Stub pronto para conexão.
   * @throws RFWException
   */
  private NFeConsultaProtocolo4Stub createNFeConsultaProtocolo4Stub(SEFAZ_tpAmb env, SEFAZ_WebServices ws, SefazContingency contingency) throws RFWException {
    NFeConsultaProtocolo4Stub stub = null;
    try {
      if (env.equals(SEFAZ_tpAmb.PRODUCAO)) {
        if (ws.equals(SEFAZ_WebServices.SP)) {
          if (contingency == null) {
            stub = new NFeConsultaProtocolo4Stub(SEFAZDefinitions.NFE_SP_PRODUCTION_V400_NFECONSULTAPROTOCOLO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), ws.toString(), "" + contingency });
          }
        }
      } else if (env.equals(SEFAZ_tpAmb.HOMOLOGACAO)) {
        if (ws.equals(SEFAZ_WebServices.SP)) {
          if (contingency == null) {
            stub = new NFeConsultaProtocolo4Stub(SEFAZDefinitions.NFE_SP_TEST_V400_NFECONSULTAPROTOCOLO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), ws.toString(), "" + contingency });
          }
        }
      }
    } catch (AxisFault e) {
      throw new RFWCriticalException("Falha ao criar Stub para o ambiente '${0}', UF '${1}', contingência: '${2}'.", new String[] { env.toString(), ws.toString(), "" + contingency }, e);
    }
    if (stub == null) {
      throw new RFWCriticalException("Falha ao criar Stub para o ambiente '${0}', UF '${1}', contingência: '${2}'.", new String[] { env.toString(), ws.toString(), "" + contingency });
    }
    stub._getServiceClient().getOptions().setProperty(HTTPConstants.CACHED_HTTP_CLIENT, this.httpClientCustom);
    return stub;
  }

}
