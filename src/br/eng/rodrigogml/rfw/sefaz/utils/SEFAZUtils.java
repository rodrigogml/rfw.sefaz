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
import br.eng.rodrigogml.rfw.sefaz.xsdobjects.conscadv200.TConsCad;

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
        throw new RFWCriticalException("Tag <XML-Fragment> não encontrada na resposta!");
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
      JAXBContext context = JAXBContext.newInstance(TConsCad.class);
      StringWriter stringWriter = new StringWriter();
      final Marshaller marshaller = context.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
      marshaller.marshal(root, stringWriter);
      return stringWriter.toString();
    } catch (JAXBException e) {
      throw new RFWCriticalException("Falha o criar o XML a partir do Objeto!", new String[] { root.getClass().getCanonicalName() }, e);
    }
  }
}
