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
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import br.eng.rodrigogml.rfw.kernel.exceptions.RFWCriticalException;
import br.eng.rodrigogml.rfw.kernel.exceptions.RFWException;
import br.eng.rodrigogml.rfw.kernel.exceptions.RFWWarningException;
import br.eng.rodrigogml.rfw.kernel.interfaces.RFWCertificate;
import br.eng.rodrigogml.rfw.kernel.logger.RFWLogger;
import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess;
import br.eng.rodrigogml.rfw.kernel.utils.RUCert;
import br.eng.rodrigogml.rfw.kernel.utils.RUXML;
import br.eng.rodrigogml.rfw.sefaz.SEFAZDefinitions.SefazContingency;
import br.eng.rodrigogml.rfw.sefaz.SEFAZDefinitions.SefazEnvironment;
import br.eng.rodrigogml.rfw.sefaz.SEFAZDefinitions.SefazServer;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZXMLValidator;

import br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.CadConsultaCadastro4Stub;

/**
 * Description: Objeto utilizado para abstrair toda a comunica��o com o servidor da SEFAZ.<br>
 * Devemos expor os m�todos nesta classe como se fossem uma chamada direta nos servi�os disponibilizados pela SEFAZ.
 *
 * @author Rodrigo GML
 * @since 1.0.0 (24 de ago. de 2023)
 * @version 1.0.0 - Rodrigo GML-(...)
 */
public class SEFAZ {

  /**
   * Defini��o do estado/servidor de comunica��o
   */
  private final SefazServer server;

  /**
   * Defini��o do ambiente de comunica��o (Homologa��o/Produ��o).
   */
  private final SefazEnvironment env;

  /**
   * Define o tipo de conting�ncia que o sistema est� usando no momento.<br>
   * NULL indica que n�o estamos em conting�ncia, e estamos usando o ambiente normal.
   */
  private SefazContingency contingency = null;

  /**
   * HttpClient criado com o SSLContext personalizado com o certificado de assinatura do cliente e os certificados confi�veis do servidor da SEFAZ.
   */
  private final CloseableHttpClient httpClientCustom;

  /**
   * Instancia o objeto para comunica��o com o WS da SEFAZ
   *
   * @param cert Certificado a ser utilizado nas opera��es de assinatura e transmiss�o. Se passado nulo faremos a conex�o sem a identifica��o do certificado cliente. Geralmente um Certificado do Tipo A1.
   * @param trustCert Certificados aceitos como assinatura do servidor da SEFAZ. Geralmente um JKS com os certificados p�blicos das CAs atuais da SEFAZ.
   * @param server UF do emitente do documento, utilizado para determinar o ambiente e outros parametros de comunica��o.
   * @param env Ambiente a ser utilizado na emiss�o de documentos e comunica��o.
   * @throws RFWException
   */
  public SEFAZ(RFWCertificate cert, RFWCertificate trustCert, SefazServer server, SefazEnvironment env) throws RFWException {
    PreProcess.requiredNonNull(server);
    PreProcess.requiredNonNull(env);

    this.server = server;
    this.env = env;

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

    // Inicializa o Contexto SSL que ser� utilizado nos Stubs do axis para autenticar e validar a conex�o com a SEFAZ.
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
      throw new RFWCriticalException("Falha ao inicializar o contexto de seguran�a para conex�o!", e);
    }

  }

  /**
   * Chama o m�todo "consultaCadastro" disponibilizado no WebSerice da SEFAZ para consultar o contribuinte.
   *
   * @param cpf N�mero do CPF a ser consultado.
   * @return XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public String consultaCadastroByCPF_v2_00(String cpf) throws RFWException {
    return this.consultaCadastro_v2_00(cpf, null, null);
  }

  /**
   * Chama o m�todo "consultaCadastro" disponibilizado no WebSerice da SEFAZ para consultar o contribuinte.
   *
   * @param cnpj N�mero do CNPJ a ser consultado.
   * @return XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public String consultaCadastroByCNPJ_v2_00(String cnpj) throws RFWException {
    return this.consultaCadastro_v2_00(null, cnpj, null);
  }

  /**
   * Chama o m�todo "consultaCadastro" disponibilizado no WebSerice da SEFAZ para consultar o contribuinte. <Br>
   * Apenas um dos par�metros deve ser informado. Ao informar m�ltipls apenas um deles ser� utilizado, mas mesma ordem em que est�o definidos no m�todo.
   *
   * @param cpf CPF a ser consultado.
   * @param cnpj CNPJ a ser consultado.
   * @param ie IE a ser consultado
   * @return XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  private String consultaCadastro_v2_00(String cpf, String cnpj, String ie) throws RFWException {
    br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeDadosMsgDocument nfeDadosMsg = br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeDadosMsgDocument.Factory.newInstance();
    br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeDadosMsgDocument.NfeDadosMsg req = nfeDadosMsg.addNewNfeDadosMsg();

    String msg = createConsCad_v2_00(cpf, cnpj, ie);
    try {
      req.set(XmlObject.Factory.parse(msg));
    } catch (Exception e) {
      throw new RFWCriticalException("Falha ao criar mensagem para enviar pelo WebService da SEFAZ.", new String[] { msg }, e);
    }

    CadConsultaCadastro4Stub stub = createCadConsultaCadastro4Stub(env, server, contingency);
    br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeResultMsgDocument result = null;

    try {
      result = stub.consultaCadastro(nfeDadosMsg);
      return result.getNfeResultMsg().toString();
    } catch (RemoteException e) {
      if ("Transport error: 403 Error: Forbidden".equals(e.getMessage())) {
        throw new RFWWarningException("N�o foi poss�vel comunicar com o servidor da SEFAZ.", e);
      } else if ("Read timed out".equals(e.getMessage())) {
        throw new RFWWarningException("N�o foi poss�vel comunicar com o servidor da SEFAZ.", e);
      } else {
        RFWLogger.logError("Mensagem n�o mapeada de erro durante comunica��o com a SEFAZ: " + e.getMessage());
      }
      throw new RFWWarningException("N�o foi poss�vel comunicar com o servidor da SEFAZ.", e);
    }
  }

  /**
   * Este m�todo cria o XML utilizado no servi�o "NfeConsultaCadastro" a partir dos XML da NFe<Br>
   * Apenas um dos par�metros deve ser informado. Ao informar m�ltipls apenas um deles ser� utilizado, mas mesma ordem em que est�o definidos no m�todo.
   *
   * @param cpf CPF a ser consultado.
   * @param cnpj CNPJ a ser consultado.
   * @param ie IE a ser consultado
   * @return XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  private String createConsCad_v2_00(String cpf, String cnpj, String ie) throws RFWException {
    final Document doc = RUXML.createNewDocument();

    final Element root = RUXML.createElementTag(doc, "ConsCad", "http://www.portalfiscal.inf.br/nfe");
    root.setAttribute("versao", "2.00");

    final Element infCons = RUXML.createElementTag(doc, root, "infCons");
    RUXML.createElementTagWithTextContent(doc, infCons, "xServ", "CONS-CAD");
    RUXML.createElementTagWithTextContent(doc, infCons, "UF", server.getAcronym());

    if (cpf != null) {
      RUXML.createElementTagWithTextContent(doc, infCons, "CPF", cpf);
    } else if (cnpj != null) {
      RUXML.createElementTagWithTextContent(doc, infCons, "CNPJ", cnpj);
    } else if (ie != null) {
      RUXML.createElementTagWithTextContent(doc, infCons, "IE", ie);
    }

    String xml = RUXML.writeDOMToString(doc, true);
    SEFAZXMLValidator.validateConsCad_v2_00(xml);

    return xml;
  }

  /**
   * Cria o STUB de conex�o para o servi�o NfeConsultaCadastro (m�todo: consultaCadastro).
   *
   * @param env ambiente de conex�o.
   * @param server Servidor para conex�o.
   * @param contingency M�todo de conting�ncia ou null para nenhuma conting�ncia.
   * @return Stub pronto para conex�o.
   * @throws RFWException
   */
  private CadConsultaCadastro4Stub createCadConsultaCadastro4Stub(SefazEnvironment env, SefazServer server, SefazContingency contingency) throws RFWException {
    CadConsultaCadastro4Stub stub = null;
    try {
      if (env.equals(SefazEnvironment.PRODUCTION)) {
        if (server.equals(SefazServer.SP)) {
          if (contingency == null) {
            stub = new CadConsultaCadastro4Stub(SEFAZDefinitions.SP_PRODUCTION_V4_00_CADCONSULTACADASTRO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), server.toString(), "" + contingency });
          }
        }
      } else if (env.equals(SefazEnvironment.TEST)) {
        if (server.equals(SefazServer.SP)) {
          if (contingency == null) {
            stub = new CadConsultaCadastro4Stub(SEFAZDefinitions.SP_TEST_V4_00_CADCONSULTACADASTRO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), server.toString(), "" + contingency });
          }
        }
      }
    } catch (AxisFault e) {
      throw new RFWCriticalException("Falha ao criar Stub para o ambiente '${0}', UF '${1}', conting�ncia: '${2}'.", new String[] { env.toString(), server.toString(), "" + contingency }, e);
    }
    if (stub == null) {
      throw new RFWCriticalException("Falha ao criar Stub para o ambiente '${0}', UF '${1}', conting�ncia: '${2}'.", new String[] { env.toString(), server.toString(), "" + contingency });
    }
    stub._getServiceClient().getOptions().setProperty(HTTPConstants.CACHED_HTTP_CLIENT, this.httpClientCustom);
    return stub;
  }
}
