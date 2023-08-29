package br.eng.rodrigogml.rfw.sefaz.utils;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.eng.rodrigogml.rfw.kernel.exceptions.RFWCriticalException;
import br.eng.rodrigogml.rfw.kernel.exceptions.RFWException;
import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess;

import xsdobjects.consrecinfev400.TNfeProc;

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
   * Faz o parser de um XML convertendo-o em objeto compatível utilizando o Unmarshaller do JAXB.
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
    try {
      JAXBContext context = JAXBContext.newInstance(rootClass);
      Unmarshaller um = context.createUnmarshaller();

      Pattern pattern = Pattern.compile("<xml-fragment.*?>(.*?)</xml-fragment>", Pattern.DOTALL);
      Matcher matcher = pattern.matcher(xml);

      if (matcher.find()) {
        xml = matcher.group(1);
      } else {
        // Se não encontrou a tag fragment, utiliza o conteúdo recebido;
      }

      return (T) um.unmarshal(new StringReader(xml));
    } catch (JAXBException e) {
      throw new RFWCriticalException("Falha o ler o XML para restaura o Objeto!", new String[] { xml, rootClass.getCanonicalName() }, e);
    }
  }

  /**
   * Converte um objeto em XML utilizando o Marshal do JAXB.
   *
   * @param root Objecto raiz para ser serializado em XML.
   * @return String xml representando o conteúdo do objeto sem formatação.
   * @throws RFWException Lançado em caso de falha ou dados inválidos.
   */
  public static String writeXMLFromObject(Object root) throws RFWException {
    PreProcess.requiredNonNull(root);
    try {
      JAXBContext context = JAXBContext.newInstance(root.getClass());
      StringWriter stringWriter = new StringWriter();
      final Marshaller marshaller = context.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
      marshaller.marshal(root, stringWriter);
      return stringWriter.toString();
    } catch (JAXBException e) {
      throw new RFWCriticalException("Falha o criar o XML a partir do Objeto!", new String[] { root.getClass().getCanonicalName() }, e);
    }
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
}
