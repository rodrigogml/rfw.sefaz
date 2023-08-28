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

import br.eng.rodrigogml.rfw.kernel.exceptions.RFWCriticalException;
import br.eng.rodrigogml.rfw.kernel.exceptions.RFWException;
import br.eng.rodrigogml.rfw.kernel.exceptions.RFWWarningException;
import br.eng.rodrigogml.rfw.kernel.interfaces.RFWCertificate;
import br.eng.rodrigogml.rfw.kernel.logger.RFWLogger;
import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess;
import br.eng.rodrigogml.rfw.kernel.utils.RUCert;
import br.eng.rodrigogml.rfw.sefaz.SEFAZDefinitions.SefazContingency;
import br.eng.rodrigogml.rfw.sefaz.SEFAZDefinitions.SefazEnvironment;
import br.eng.rodrigogml.rfw.sefaz.SEFAZDefinitions.SefazServer;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZUtils;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZXMLValidator;
import br.eng.rodrigogml.rfw.sefaz.xsdobjects.conscadv200.TConsCad;
import br.eng.rodrigogml.rfw.sefaz.xsdobjects.conscadv200.TConsCad.InfCons;
import br.eng.rodrigogml.rfw.sefaz.xsdobjects.conscadv200.TRetConsCad;
import br.eng.rodrigogml.rfw.sefaz.xsdobjects.conscadv200.TUfCons;
import br.eng.rodrigogml.rfw.sefaz.xsdobjects.consrecinfev400.TConsReciNFe;
import br.eng.rodrigogml.rfw.sefaz.xsdobjects.consrecinfev400.TRetConsReciNFe;
import br.eng.rodrigogml.rfw.sefaz.xsdobjects.envinfev400.TEnviNFe;
import br.eng.rodrigogml.rfw.sefaz.xsdobjects.envinfev400.TRetEnviNFe;

import br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.CadConsultaCadastro4Stub;
import br.inf.portalfiscal.www.nfe.wsdl.nfeautorizacao4.NFeAutorizacao4Stub;
import br.inf.portalfiscal.www.nfe.wsdl.nfeautorizacao4.NfeDadosMsgDocument;
import br.inf.portalfiscal.www.nfe.wsdl.nfeautorizacao4.NfeResultMsgDocument;
import br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NFeRetAutorizacao4Stub;

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
  private final SefazServer server;

  /**
   * Definição do ambiente de comunicação (Homologação/Produção).
   */
  private final SefazEnvironment env;

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
   * Instancia o objeto para comunicação com o WS da SEFAZ
   *
   * @param cert Certificado a ser utilizado nas operações de assinatura e transmissão. Se passado nulo faremos a conexão sem a identificação do certificado cliente. Geralmente um Certificado do Tipo A1.
   * @param trustCert Certificados aceitos como assinatura do servidor da SEFAZ. Geralmente um JKS com os certificados públicos das CAs atuais da SEFAZ.
   * @param server UF do emitente do documento, utilizado para determinar o ambiente e outros parametros de comunicação.
   * @param env Ambiente a ser utilizado na emissão de documentos e comunicação.
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
   * Chama o método "consultaCadastro" disponibilizado no WebSerice da SEFAZ para consultar o contribuinte.
   *
   * @param cpf Número do CPF a ser consultado.
   * @return XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public TRetConsCad consultaCadastroV200byCPF(String cpf) throws RFWException {
    final TConsCad root = createConsCadV200Message(cpf, null, null);
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
    final TConsCad root = createConsCadV200Message(null, cnpj, null);
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
    br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeDadosMsgDocument nfeDadosMsg = br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeDadosMsgDocument.Factory.newInstance();
    br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeDadosMsgDocument.NfeDadosMsg req = nfeDadosMsg.addNewNfeDadosMsg();

    String msg = SEFAZUtils.writeXMLFromObject(root);
    try {
      req.set(XmlObject.Factory.parse(msg));
    } catch (Exception e) {
      throw new RFWCriticalException("Falha ao criar mensagem para enviar pelo WebService da SEFAZ.", new String[] { msg }, e);
    }

    CadConsultaCadastro4Stub stub = createCadConsultaCadastro4Stub(env, server, contingency);
    br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeResultMsgDocument result = null;

    String xml = null;
    try {
      result = stub.consultaCadastro(nfeDadosMsg);
      xml = result.getNfeResultMsg().toString();

      // Valida o XML com o schema antes de tentar a conexão
      SEFAZXMLValidator.validateConsCadV200(xml);

      // Removemos o namespace do XML para facilitar o trabalho com o JAXB. Mais simples do que configurar filtros ou todos os elementos manualmente.
      return SEFAZUtils.readXMLToObject(xml, TRetConsCad.class);
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
   * @return Objeto do XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public TRetEnviNFe nfeAutorizacaoLoteV400(TEnviNFe root) throws RFWException {
    NfeDadosMsgDocument nfeDadosMsg = NfeDadosMsgDocument.Factory.newInstance();
    NfeDadosMsgDocument.NfeDadosMsg req = nfeDadosMsg.addNewNfeDadosMsg();

    String msg = SEFAZUtils.writeXMLFromObject(root);
    try {
      req.set(XmlObject.Factory.parse(msg));
    } catch (Exception e) {
      throw new RFWCriticalException("Falha ao criar mensagem para enviar pelo WebService da SEFAZ.", new String[] { msg }, e);
    }

    NFeAutorizacao4Stub stub = createNFeAutorizacao4Stub(env, server, contingency);
    NfeResultMsgDocument result = null;

    String xml = null;
    try {
      result = stub.nfeAutorizacaoLote(nfeDadosMsg);
      xml = result.getNfeResultMsg().toString();

      // Valida o XML com o schema antes de tentar a conexão
      SEFAZXMLValidator.validateEnviNFeV400(xml);

      // Removemos o namespace do XML para facilitar o trabalho com o JAXB. Mais simples do que configurar filtros ou todos os elementos manualmente.
      return SEFAZUtils.readXMLToObject(xml, TRetEnviNFe.class);
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
   * Chama o método "nfeRetAutorizacao v4.00" disponibilizado no WebSerice da SEFAZ para consultar o contribuinte. <Br>
   *
   * @param root Objeto representando o XML para envio da requisição.
   * @return Objeto do XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public TRetConsReciNFe nfeRetAutorizacaoV400(TConsReciNFe root) throws RFWException {
    br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeDadosMsgDocument nfeDadosMsg = br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeDadosMsgDocument.Factory.newInstance();
    br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeDadosMsgDocument.NfeDadosMsg req = nfeDadosMsg.addNewNfeDadosMsg();

    String msg = SEFAZUtils.writeXMLFromObject(root);
    try {
      req.set(XmlObject.Factory.parse(msg));
    } catch (Exception e) {
      throw new RFWCriticalException("Falha ao criar mensagem para enviar pelo WebService da SEFAZ.", new String[] { msg }, e);
    }

    NFeRetAutorizacao4Stub stub = createNFeRetAutorizacao4Stub(env, server, contingency);
    br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument result = null;

    String xml = null;
    try {
      result = stub.nfeRetAutorizacaoLote(nfeDadosMsg);
      xml = result.getNfeResultMsg().toString();

      // Valida o XML com o schema antes de tentar a conexão
      SEFAZXMLValidator.validateEnviNFeV400(xml);

      // Removemos o namespace do XML para facilitar o trabalho com o JAXB. Mais simples do que configurar filtros ou todos os elementos manualmente.
      return SEFAZUtils.readXMLToObject(xml, TRetConsReciNFe.class);
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
   * Este método cria o XML utilizado no serviço "NfeConsultaCadastro" a partir dos XML da NFe<Br>
   * Apenas um dos parâmetros deve ser informado. Ao informar múltipls apenas um deles será utilizado, mas mesma ordem em que estão definidos no método.
   *
   * @param cpf CPF a ser consultado.
   * @param cnpj CNPJ a ser consultado.
   * @param ie IE a ser consultado
   * @return XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  private TConsCad createConsCadV200Message(String cpf, String cnpj, String ie) throws RFWException {
    TConsCad root = new TConsCad();
    root.setVersao("2.00");

    root.setInfCons(new InfCons());
    root.getInfCons().setXServ("CONS-CAD");
    root.getInfCons().setUF(TUfCons.valueOf(server.getAcronym()));

    if (cpf != null) {
      root.getInfCons().setCPF(cpf);
    } else if (cnpj != null) {
      root.getInfCons().setCNPJ(cnpj);
    } else if (ie != null) {
      root.getInfCons().setIE(ie);
    }

    return root;
  }

  /**
   * Cria o STUB de conexão para o serviço NfeConsultaCadastro.
   *
   * @param env ambiente de conexão.
   * @param server Servidor para conexão.
   * @param contingency Método de contingência ou null para nenhuma contingência.
   * @return Stub pronto para conexão.
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
      throw new RFWCriticalException("Falha ao criar Stub para o ambiente '${0}', UF '${1}', contingência: '${2}'.", new String[] { env.toString(), server.toString(), "" + contingency }, e);
    }
    if (stub == null) {
      throw new RFWCriticalException("Falha ao criar Stub para o ambiente '${0}', UF '${1}', contingência: '${2}'.", new String[] { env.toString(), server.toString(), "" + contingency });
    }
    stub._getServiceClient().getOptions().setProperty(HTTPConstants.CACHED_HTTP_CLIENT, this.httpClientCustom);
    return stub;
  }

  /**
   * Cria o STUB de conexão para o serviço NfeAutorizacao.
   *
   * @param env ambiente de conexão.
   * @param server Servidor para conexão.
   * @param contingency Método de contingência ou null para nenhuma contingência.
   * @return Stub pronto para conexão.
   * @throws RFWException
   */
  private NFeAutorizacao4Stub createNFeAutorizacao4Stub(SefazEnvironment env, SefazServer server, SefazContingency contingency) throws RFWException {
    NFeAutorizacao4Stub stub = null;
    try {
      if (env.equals(SefazEnvironment.PRODUCTION)) {
        if (server.equals(SefazServer.SP)) {
          if (contingency == null) {
            stub = new NFeAutorizacao4Stub(SEFAZDefinitions.SP_PRODUCTION_V4_00_NFEAUTORIZACAO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), server.toString(), "" + contingency });
          }
        }
      } else if (env.equals(SefazEnvironment.TEST)) {
        if (server.equals(SefazServer.SP)) {
          if (contingency == null) {
            stub = new NFeAutorizacao4Stub(SEFAZDefinitions.SP_TEST_V4_00_NFEAUTORIZACAO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), server.toString(), "" + contingency });
          }
        }
      }
    } catch (AxisFault e) {
      throw new RFWCriticalException("Falha ao criar Stub para o ambiente '${0}', UF '${1}', contingência: '${2}'.", new String[] { env.toString(), server.toString(), "" + contingency }, e);
    }
    if (stub == null) {
      throw new RFWCriticalException("Falha ao criar Stub para o ambiente '${0}', UF '${1}', contingência: '${2}'.", new String[] { env.toString(), server.toString(), "" + contingency });
    }
    stub._getServiceClient().getOptions().setProperty(HTTPConstants.CACHED_HTTP_CLIENT, this.httpClientCustom);
    return stub;
  }

  /**
   * Cria o STUB de conexão para o serviço NfeRetAutorizacao.
   *
   * @param env ambiente de conexão.
   * @param server Servidor para conexão.
   * @param contingency Método de contingência ou null para nenhuma contingência.
   * @return Stub pronto para conexão.
   * @throws RFWException
   */
  private NFeRetAutorizacao4Stub createNFeRetAutorizacao4Stub(SefazEnvironment env, SefazServer server, SefazContingency contingency) throws RFWException {
    NFeRetAutorizacao4Stub stub = null;
    try {
      if (env.equals(SefazEnvironment.PRODUCTION)) {
        if (server.equals(SefazServer.SP)) {
          if (contingency == null) {
            stub = new NFeRetAutorizacao4Stub(SEFAZDefinitions.SP_PRODUCTION_V4_00_NFERETAUTORIZACAO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), server.toString(), "" + contingency });
          }
        }
      } else if (env.equals(SefazEnvironment.TEST)) {
        if (server.equals(SefazServer.SP)) {
          if (contingency == null) {
            stub = new NFeRetAutorizacao4Stub(SEFAZDefinitions.SP_TEST_V4_00_NFERETAUTORIZACAO4);
          } else {
            throw new RFWCriticalException("RFW_000035", new String[] { env.toString(), server.toString(), "" + contingency });
          }
        }
      }
    } catch (AxisFault e) {
      throw new RFWCriticalException("Falha ao criar Stub para o ambiente '${0}', UF '${1}', contingência: '${2}'.", new String[] { env.toString(), server.toString(), "" + contingency }, e);
    }
    if (stub == null) {
      throw new RFWCriticalException("Falha ao criar Stub para o ambiente '${0}', UF '${1}', contingência: '${2}'.", new String[] { env.toString(), server.toString(), "" + contingency });
    }
    stub._getServiceClient().getOptions().setProperty(HTTPConstants.CACHED_HTTP_CLIENT, this.httpClientCustom);
    return stub;
  }
}
