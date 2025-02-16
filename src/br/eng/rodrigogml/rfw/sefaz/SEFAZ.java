package br.eng.rodrigogml.rfw.sefaz;

import java.rmi.RemoteException;
import java.security.KeyStore;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

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

import br.eng.rodrigogml.rfw.kernel.RFW;
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
import br.eng.rodrigogml.rfw.sefaz.SEFAZDefinitions.SefazWebServices;
import br.eng.rodrigogml.rfw.sefaz.SEFAZDefinitions.SefazXMLtpAmb;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZUtils;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZXMLValidator;

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
  private final SefazWebServices ws;

  /**
   * Definição do ambiente de comunicação (Homologação/Produção).
   */
  private final SefazXMLtpAmb env;

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
  public SEFAZ(RFWCertificate cert, SefazWebServices ws, SefazXMLtpAmb env) throws RFWException {
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
  public SEFAZ(RFWCertificate cert, RFWCertificate trustCert, SefazWebServices ws, SefazXMLtpAmb env) throws RFWException {
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
   * Chama o método "nfeAutorizacaoLote v4.00" disponibilizado no WebSerice da SEFAZ para consultar o contribuinte. <Br>
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
   * Chama o método "nfeAutorizacaoLote v4.00" disponibilizado no WebSerice da SEFAZ para consultar o contribuinte. <Br>
   *
   * @param root Objeto representando o XML para envio da requisição.
   * @return String[] com 2 posições onde: 0 - XML enviado como msg para a SEFAZ, tag raiz &lt;enviNFe&gt; cm todas as NFes assinadas dentro (para arquivamento do sistema ou conferência); 1 - XML de retorno da SEFAZ.
   * @throws RFWException
   */
  public String[] nfeAutorizacaoLoteV400asXML(TEnviNFe root) throws RFWException {
    NfeDadosMsgDocument nfeDadosMsg = NfeDadosMsgDocument.Factory.newInstance();
    NfeDadosMsgDocument.NfeDadosMsg req = nfeDadosMsg.addNewNfeDadosMsg();

    String msg = SEFAZUtils.signNfeAutorizacaoLoteV400Message(cert, root);
    SEFAZXMLValidator.validateEnviNFeV400(msg);

    if (RFW.getDevProperty("rfw.sefaz.pathToLogCommunicationXML") != null) {
      RUFile.writeFileContent(RFW.getDevProperty("rfw.sefaz.pathToLogCommunicationXML") + "\\enviNFe.xml", msg);
    }
    try {
      req.set(XmlObject.Factory.parse(msg));
    } catch (Exception e) {
      throw new RFWCriticalException("Falha ao criar mensagem para enviar pelo WebService da SEFAZ.", new String[] { msg }, e);
    }

    NFeAutorizacao4Stub stub = createNFeAutorizacao4Stub(env, ws, contingency);
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
   * Chama o método "nfeRetAutorizacao v4.00" disponibilizado no WebSerice da SEFAZ para consultar o contribuinte passando um recibo de consulta.<Br>
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
   * Chama o método "nfeRetAutorizacao v4.00" disponibilizado no WebSerice da SEFAZ para consultar o contribuinte passando um recibo de consulta.<Br>
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
   * Chama o método "nfeRetAutorizacao v4.00" disponibilizado no WebSerice da SEFAZ para consultar o contribuinte. <Br>
   *
   * @param root Objeto representando o XML para envio da requisição.
   * @return Objeto do XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public TRetConsReciNFe nfeRetAutorizacaoV400(TConsReciNFe root) throws RFWException {
    return SEFAZUtils.readXMLToObject(nfeRetAutorizacaoV400asXML(root), TRetConsReciNFe.class);
  }

  /**
   * Chama o método "nfeRetAutorizacao v4.00" disponibilizado no WebSerice da SEFAZ para consultar o contribuinte. <Br>
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
  private CadConsultaCadastro4Stub createCadConsultaCadastro4Stub(SefazXMLtpAmb env, SefazWebServices ws, SefazContingency contingency) throws RFWException {
    CadConsultaCadastro4Stub stub = null;
    try {
      if (env.equals(SefazXMLtpAmb.PRODUCTION)) {
        if (ws.equals(SefazWebServices.SP)) {
          if (contingency == null) {
            stub = new CadConsultaCadastro4Stub(SEFAZDefinitions.SP_PRODUCTION_V400_CADCONSULTACADASTRO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), ws.toString(), "" + contingency });
          }
        }
      } else if (env.equals(SefazXMLtpAmb.TEST)) {
        if (ws.equals(SefazWebServices.SP)) {
          if (contingency == null) {
            stub = new CadConsultaCadastro4Stub(SEFAZDefinitions.SP_TEST_V400_CADCONSULTACADASTRO4);
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
  private NFeStatusServico4Stub createNfeStatusServicoNFStub(SefazXMLtpAmb env, SefazWebServices ws, SefazContingency contingency) throws RFWException {
    NFeStatusServico4Stub stub = null;
    try {
      if (env.equals(SefazXMLtpAmb.PRODUCTION)) {
        if (ws.equals(SefazWebServices.SP)) {
          if (contingency == null) {
            stub = new NFeStatusServico4Stub(SEFAZDefinitions.SP_PRODUCTION_V400_NFESTATUSSERVICO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), ws.toString(), "" + contingency });
          }
        }
      } else if (env.equals(SefazXMLtpAmb.TEST)) {
        if (ws.equals(SefazWebServices.SP)) {
          if (contingency == null) {
            stub = new NFeStatusServico4Stub(SEFAZDefinitions.SP_TEST_V400_NFESTATUSSERVICO4);
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
   * @param env ambiente de conexão.
   * @param ws Servidor para conexão.
   * @param contingency Método de contingência ou null para nenhuma contingência.
   * @return Stub pronto para conexão.
   * @throws RFWException
   */
  private NFeAutorizacao4Stub createNFeAutorizacao4Stub(SefazXMLtpAmb env, SefazWebServices ws, SefazContingency contingency) throws RFWException {
    NFeAutorizacao4Stub stub = null;
    try {
      if (env.equals(SefazXMLtpAmb.PRODUCTION)) {
        if (ws.equals(SefazWebServices.SP)) {
          if (contingency == null) {
            stub = new NFeAutorizacao4Stub(SEFAZDefinitions.SP_PRODUCTION_V400_NFEAUTORIZACAO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), ws.toString(), "" + contingency });
          }
        }
      } else if (env.equals(SefazXMLtpAmb.TEST)) {
        if (ws.equals(SefazWebServices.SP)) {
          if (contingency == null) {
            stub = new NFeAutorizacao4Stub(SEFAZDefinitions.SP_TEST_V400_NFEAUTORIZACAO4);
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
   * Cria o STUB de conexão para o serviço NfeRetAutorizacao.
   *
   * @param env ambiente de conexão.
   * @param ws Servidor para conexão.
   * @param contingency Método de contingência ou null para nenhuma contingência.
   * @return Stub pronto para conexão.
   * @throws RFWException
   */
  private NFeRetAutorizacao4Stub createNFeRetAutorizacao4Stub(SefazXMLtpAmb env, SefazWebServices ws, SefazContingency contingency) throws RFWException {
    NFeRetAutorizacao4Stub stub = null;
    try {
      if (env.equals(SefazXMLtpAmb.PRODUCTION)) {
        if (ws.equals(SefazWebServices.SP)) {
          if (contingency == null) {
            stub = new NFeRetAutorizacao4Stub(SEFAZDefinitions.SP_PRODUCTION_V400_NFERETAUTORIZACAO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), ws.toString(), "" + contingency });
          }
        }
      } else if (env.equals(SefazXMLtpAmb.TEST)) {
        if (ws.equals(SefazWebServices.SP)) {
          if (contingency == null) {
            stub = new NFeRetAutorizacao4Stub(SEFAZDefinitions.SP_TEST_V400_NFERETAUTORIZACAO4);
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
  private NFeInutilizacao4Stub createNFeInutilizacao4Stub(SefazXMLtpAmb env, SefazWebServices ws, SefazContingency contingency) throws RFWException {
    NFeInutilizacao4Stub stub = null;
    try {
      if (env.equals(SefazXMLtpAmb.PRODUCTION)) {
        if (ws.equals(SefazWebServices.SP)) {
          if (contingency == null) {
            stub = new NFeInutilizacao4Stub(SEFAZDefinitions.SP_PRODUCTION_V400_NFEINUTILIZACAO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] {
                env.toString(), ws.toString(), "" + contingency
            });
          }
        }
      } else if (env.equals(SefazXMLtpAmb.TEST)) {
        if (ws.equals(SefazWebServices.SP)) {
          if (contingency == null) {
            stub = new NFeInutilizacao4Stub(SEFAZDefinitions.SP_TEST_V400_NFEINUTILIZACAO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] {
                env.toString(), ws.toString(), "" + contingency
            });
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
  private NFeRecepcaoEvento4Stub createNFeRecepcaoEvento4Stub(SefazXMLtpAmb env, SefazWebServices ws, SefazContingency contingency) throws RFWException {
    NFeRecepcaoEvento4Stub stub = null;
    try {
      if (env.equals(SefazXMLtpAmb.PRODUCTION)) {
        if (ws.equals(SefazWebServices.SP)) {
          if (contingency == null) {
            stub = new NFeRecepcaoEvento4Stub(SEFAZDefinitions.SP_PRODUCTION_V400_NFERECEPCAOEVENTO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), ws.toString(), "" + contingency });
          }
        }
      } else if (env.equals(SefazXMLtpAmb.TEST)) {
        if (ws.equals(SefazWebServices.SP)) {
          if (contingency == null) {
            stub = new NFeRecepcaoEvento4Stub(SEFAZDefinitions.SP_TEST_V400_NFERECEPCAOEVENTO4);
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
    root.setTpAmb(this.env.getXmlCode());
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
    root.setTpAmb(this.env.getXmlCode());
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
  private NFeConsultaProtocolo4Stub createNFeConsultaProtocolo4Stub(SefazXMLtpAmb env, SefazWebServices ws, SefazContingency contingency) throws RFWException {
    NFeConsultaProtocolo4Stub stub = null;
    try {
      if (env.equals(SefazXMLtpAmb.PRODUCTION)) {
        if (ws.equals(SefazWebServices.SP)) {
          if (contingency == null) {
            stub = new NFeConsultaProtocolo4Stub(SEFAZDefinitions.SP_PRODUCTION_V400_NFECONSULTAPROTOCOLO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), ws.toString(), "" + contingency });
          }
        }
      } else if (env.equals(SefazXMLtpAmb.TEST)) {
        if (ws.equals(SefazWebServices.SP)) {
          if (contingency == null) {
            stub = new NFeConsultaProtocolo4Stub(SEFAZDefinitions.SP_TEST_V400_NFECONSULTAPROTOCOLO4);
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
