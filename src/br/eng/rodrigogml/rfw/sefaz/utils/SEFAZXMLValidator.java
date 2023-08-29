package br.eng.rodrigogml.rfw.sefaz.utils;

import br.eng.rodrigogml.rfw.kernel.exceptions.RFWCriticalException;
import br.eng.rodrigogml.rfw.kernel.exceptions.RFWException;
import br.eng.rodrigogml.rfw.kernel.logger.RFWLogger;
import br.eng.rodrigogml.rfw.kernel.utils.RUXML;

/**
 * Description: Classe com m�todos de valida��o dos XMLs enviados e recebidos do SEFAZ contra seu schema de defini��o.<br>
 *
 * @author Rodrigo Leit?o
 * @since 4.0.0 (27/01/2011)
 */
public class SEFAZXMLValidator {

  private SEFAZXMLValidator() {
  }

  public static void validateConsCadV200(String xml) throws RFWException {
    SEFAZXMLValidator.validateXMLAgainstSchema(xml, "consCad_v2.00.xsd", "/xsd/");
  }

  public static void validateEnviNFeV400(String xml) throws RFWException {
    SEFAZXMLValidator.validateXMLAgainstSchema(xml, "enviNFe_v4.00.xsd", "/xsd/");
  }

  /**
   * Valida uma mensagem contra um schema.
   *
   * @param xml XML da mensagem a ser validada
   * @param schemapath Schema que valida a mensagem
   * @param basepath Caminho base para encontrar os arquivos cujo schema principal referencia. Sempre temine argumento com "/". Por exemplo "/XSD/". O caminho come�ando com "/" referencia a raiz da pasta de classes (bin) ou fontes (src), ou rais do JAR.
   * @throws RFWException
   */
  private static void validateXMLAgainstSchema(String xml, String schemapath, String basepath) throws RFWException {
    try {
      RUXML.validateXMLAgainstSchema2(xml, schemapath, basepath);
    } catch (Exception e) {
      RFWLogger.logDebug("Logando falha de valida��o do XML para poss�vel consulta do desenvolvedor...");
      RFWLogger.logDebug("XML: " + xml);
      RFWLogger.logDebug("schemaPath: " + schemapath);
      RFWLogger.logDebug("basePath: " + basepath);
      RFWCriticalException ex = new RFWCriticalException("RFW_000035", new String[] { schemapath }, e);
      RFWLogger.logException(ex);
      throw ex;
    }
  }
}