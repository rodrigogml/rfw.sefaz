package br.eng.rodrigogml.rfw.sefaz.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import br.eng.rodrigogml.rfw.kernel.exceptions.RFWException;
import br.eng.rodrigogml.rfw.kernel.interfaces.RFWCertificate;
import br.eng.rodrigogml.rfw.kernel.logger.RFWLogger;
import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess;
import br.eng.rodrigogml.rfw.kernel.utils.RUSerializer;
import br.eng.rodrigogml.rfw.kernel.utils.RUString;
import br.eng.rodrigogml.rfw.kernel.utils.RUXML;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_WebServices;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tpAmb;

import xsdobjects.consCad200.TConsCad;
import xsdobjects.consCad200.TConsCad.InfCons;
import xsdobjects.consCad200.TUfCons;
import xsdobjects.consReciNFe400.TConsReciNFe;
import xsdobjects.consReciNFe400.TNfeProc;
import xsdobjects.consStatServ400.TConsStatServ;
import xsdobjects.enviNFe400.TEnviNFe;

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
   * Faz o parser de um XML convertendo-o em objeto compatível utilizando o Unmarshaller do JAXB.<br>
   * <br>
   * Utilizar as classes {@link RUXML#removeXmlFragmentTag(String)} e {@link RUSerializer#desserializeFromXML(String, Class)} em conjunto para garantir o objeto esperado.
   *
   * @param xml XML para ser lido.
   * @param rootClass Classe do objeto que repreta a tag rais do XML.
   * @return Objeto da Classe
   * @throws RFWException
   */
  @SuppressWarnings("unchecked")
  public static <T> T readXMLToObject(String xml, Class<T> rootClass) throws RFWException {
    PreProcess.requiredNonNull(xml);
    PreProcess.requiredNonNull(rootClass);
    xml = RUXML.removeXmlFragmentTag(xml);

    Object element = RUSerializer.desserializeFromXML(xml, rootClass);
    // JAXB pode retornar JAXBElement dependendo da classe
    if (element instanceof JAXBElement) {
      return ((JAXBElement<T>) element).getValue();
    } else {
      return rootClass.cast(element);
    }
  }

  /**
   * Converte um objeto em XML utilizando o Marshal do JAXB.
   *
   * @param root Objeto
   * @return XML serializado
   * @throws RFWException
   * @Deprecated Este método passou a ser apenas um relay, utilizar o acesso direto ao {@link RUSerializer}
   */
  @Deprecated
  public static String writeXMLFromObject(Object root) throws RFWException {
    return RUSerializer.serializeToXML(root, root.getClass(), false);
  }

  /**
   * Monta o objeto de mensagem para o serviço nfeRetAutorizacao utilizando o layout v4.00 a partir do número do recibo de consulta.
   *
   * @param env Ambiente a ser consultado
   * @param nRec Número do recbido a ser consultado, obtido durente a chamada de AutorizaçãoLote.
   * @return
   * @throws RFWException
   */
  public static TConsReciNFe mountNFeRetAutorizacaoV400MessageFromNRec(SEFAZ_tpAmb env, String nRec) throws RFWException {
    TConsReciNFe root = new TConsReciNFe();
    root.setVersao("4.00");
    root.setTpAmb(env.getXmlData());
    root.setNRec(nRec);
    return root;
  }

  /**
   * Monta o objeto de mensagem utilizado no serviço "NfeStatusServicoNF".<Br>
   *
   * @param env Ambiente a ser consultado
   * @param ws Servidor de WebService a ser consultado
   * @return XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public static TConsStatServ mountNfeStatusServicoNFV400Message(SEFAZ_tpAmb env, SEFAZ_WebServices ws) throws RFWException {
    TConsStatServ root = new TConsStatServ();
    root.setVersao("4.00");
    root.setTpAmb(env.getXmlData());
    root.setCUF(ws.getXmlData());
    root.setXServ("STATUS");
    return root;
  }

  /**
   * Monta o objeto de mensagem utilizado no serviço "NfeConsultaCadastro" a partir dos XML da NFe<Br>
   * Apenas um dos parâmetros deve ser informado. Ao informar múltipls apenas um deles será utilizado, na mesma ordem de preferência em que estão definidos na assinatura do método.
   *
   * @param ws Servidor de WebService a ser consultado
   * @param cpf CPF a ser consultado.
   * @param cnpj CNPJ a ser consultado.
   * @param ie IE a ser consultado
   * @return XML da mensagem de retorno do WebService.
   * @throws RFWException
   */
  public static TConsCad mountConsCadV200Message(SEFAZ_WebServices ws, String cpf, String cnpj, String ie) throws RFWException {
    TConsCad root = new TConsCad();
    root.setVersao("2.00");
    root.setInfCons(new InfCons());
    root.getInfCons().setXServ("CONS-CAD");
    root.getInfCons().setUF(TUfCons.valueOf(ws.getAcronym()));
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
   * Faz a leitura de um XML para o objeto {@link TNfeProc}<br>
   * Este método é apenas um facilitador de chamada do método {@link #readTNfeProcXML(String)}.<br>
   *
   * @param xml XML a ser lido
   * @return objeto com o conteúdo do XML
   * @throws RFWException
   */
  public static TNfeProc readTNfeProcXML(String xml) throws RFWException {
    return readXMLToObject(xml, TNfeProc.class);
  }

  /**
   * Extrai o valor da versão da tag &ltnfeProc&gt; encontrada no XML.<br>
   * Procura o valor utilizando expressão regular, sem realizar qualquer parser ou conversão do XML, o que tente a ser mais rápido.<Br>
   * O objetivo deste método é ajudar a identificar a versão do layout sem passar por processos mais lentos de parser do XML.<Br>
   * A implementação leva em conta que a tag pode estar em qualquer parte do XML (contendo ou não cabeçalhos ou tags pais), mas que a tag seja única. Em caso de conter várias, retorna o valor da primeira encontrada.
   *
   * @param xml XML a ser ser analisado.
   * @return valor do atributo versao se a tag for encontrada, ou null caso a tag não seja encontrada.
   */
  public static String extractNFeProcVersion(String xml) {
    Pattern pattern = Pattern.compile("<nfeProc[^>]+versao=\"([^\"]+)\"");
    Matcher matcher = pattern.matcher(xml);

    String versao = null;
    if (matcher.find()) {
      versao = matcher.group(1);
    }
    return versao;
  }

  /**
   * A partir de um objeto {@link TEnviNFe} cria o XML como esperado para enviar para o WebService e assina as tags "infNFe" como solicitado pelo padrão NFe.<br>
   *
   * @param cert Certificado utilizado para assinar o documento. Deve conter chave privada.
   * @param root Tag Raiz completamente preenchida para ser convertida em XML e assinada para transmissão.
   * @return XML com a tag raiz enviNFe com os XMLs dentro já assinados e prontos para serem transmitidos.
   * @throws RFWException
   */
  public static String signNfeAutorizacaoLoteV400Message(RFWCertificate cert, TEnviNFe root) throws RFWException {
    String rawMsg = SEFAZUtils.writeXMLFromObject(root);
    rawMsg = rawMsg.replaceAll(" xmlns:ns2=\"http://www.w3.org/2000/09/xmldsig#\"", ""); // Se houver outro namespace além do xmlns="http://www.portalfiscal.inf.br/nfe" a assinatura falha, pois a receita retira o namespace antes de validar a assinatura
    rawMsg = RUString.removeAccents(rawMsg); // Remove os acentos que o sistema possa ter escrito nos campos, pois o charset da NFe não suporta.
    String xml = RUXML.signXmlDocument(rawMsg, "infNFe", cert);
    return xml;
  }

  /**
   * Método auxiliar genérico para simplificar a criação de um JAXBElement de qualquer tipo (String, BigDecimal, ICMS, IPI, etc.) para os elemebtos genéricos.
   *
   * @param tagName Nome da tag XML (ex: "vTotTrib", "ICMS", "IPI").
   * @param value Objeto a ser inserido dentro do JAXBElement (String, BigDecimal, ICMS, etc.).
   * @param <T> Tipo do objeto a ser encapsulado.
   * @return JAXBElement contendo o valor ou objeto formatado corretamente para o JAXB.
   */
  @SuppressWarnings("unchecked")
  public static <T> JAXBElement<T> auxCreateJAXBElement(String tagName, T value) {
    return new JAXBElement<>(new QName("http://www.portalfiscal.inf.br/nfe", tagName), (Class<T>) value.getClass(), value);
  }

  /**
   * Método utilizado para concentrar a lógica dos Status da NFe/NFCe para saber se o documento foi autorizado ou não.
   *
   * @param cStat Código do status retornado para a NFe (não para o lote, para avaliação do Lote verifique o método: {@link SEFAZUtils#isLoteCStatAuthorized(Integer)} )
   * @return true caso seja um status que retorne o documento emitido, false caso contrário.
   * @throws RFWException Lançado em caso de valor nulo, o método dá preferência a retornar true/false, ainda que o código recebido seja desconhecido.
   */
  public static boolean isNFCStatAuthorized(Integer cStat) throws RFWException {
    PreProcess.requiredNonNullCritical(cStat);
    switch (cStat) {
      case 100: // Autorizado o uso da NFC-e
      case 150:// Autorizado o uso da NFC-e fora de prazo
        return true;
      case 539: // Duplicidade de NF-e com diferença na Chave de Acesso
      default:
        RFWLogger.logDev("A Autorização da NFe/NFCe retornou um status desconhecido pelo sistema: '${0}'.", new String[] { "" + cStat });
        return false;
    }
  }

  /**
   * Método utilizado para concentrar a lógica dos Status do processamento do LOTE da SEFAZ para saber se o lote foi procesado ou não.
   *
   * @param cStat Código do status retornado para o LOTE (não para a NF, para avaliação do Lote verifique o método: {@link SEFAZUtils#isNFCStatAuthorized(Integer)} )
   * @return true caso seja um status que retorne o lote foi processado (e temos as tags de protocolo da NFe), false caso contrário.
   * @throws RFWException Lançado em caso de valor nulo, o método dá preferência a retornar true/false, ainda que o código recebido seja desconhecido.
   */
  public static boolean isLoteCStatAuthorized(Integer cStat) throws RFWException {
    PreProcess.requiredNonNullCritical(cStat);
    switch (cStat) {
      case 104: // Lote processado com sucesso
        return true;
      default:
        RFWLogger.logDev("O processamento do Lote da SEFAZ retornou um status desconhecido pelo sistema: '${0}'.", new String[] { "" + cStat });
        return false;
    }
  }
}
