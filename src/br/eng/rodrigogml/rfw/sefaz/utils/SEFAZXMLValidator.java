package br.eng.rodrigogml.rfw.sefaz.utils;

import br.eng.rodrigogml.rfw.kernel.exceptions.RFWCriticalException;
import br.eng.rodrigogml.rfw.kernel.exceptions.RFWException;
import br.eng.rodrigogml.rfw.kernel.logger.RFWLogger;
import br.eng.rodrigogml.rfw.kernel.utils.RUXML;

/**
 * Description: Classe com métodos de validação dos XMLs enviados e recebidos do SEFAZ contra seu schema de definição.<br>
 *
 * @author Rodrigo Leit?o
 * @since 4.0.0 (27/01/2011)
 */
public class SEFAZXMLValidator {

  private SEFAZXMLValidator() {
  }

  public static void validateNfeStatusServicoNFV400(String xml) throws RFWException {
    SEFAZXMLValidator.validateXMLAgainstSchema(xml, "consStatServ_v4.00.xsd", "/xsd/PL_009p_NT2024_003_v1.02/");
  }

  public static void validateConsCadV200(String xml) throws RFWException {
    SEFAZXMLValidator.validateXMLAgainstSchema(xml, "consCad_v2.00.xsd", "/xsd/PL_009k_NT2023_001_v120/");
  }

  public static void validateEnviNFeV400(String xml) throws RFWException {
    // SEFAZXMLValidator.validateXMLAgainstSchema(xml, "enviNFe_v4.00.xsd", "/xsd/PL_009p_NT2024_003_v1.02/");
    SEFAZXMLValidator.validateXMLAgainstSchema(xml, "enviNFe_v4.00.xsd", "/xsd/PL_009q_NT2025_001_v1.00_PL_010b_NT2025_002_v1.30/");
  }

  public static void validateConsReciNFeV400(String xml) throws RFWException {
    SEFAZXMLValidator.validateXMLAgainstSchema(xml, "consReciNFe_v4.00.xsd", "/xsd/PL_009p_NT2024_003_v1.02/");
  }

  public static void validateInutNFeV400(String xml) throws RFWException {
    SEFAZXMLValidator.validateXMLAgainstSchema(xml, "inutNFe_v4.00.xsd", "/xsd/PL_009p_NT2024_003_v1.02/");
  }

  public static void validateEnvEventoV100(String xml) throws RFWException {
    SEFAZXMLValidator.validateXMLAgainstSchema(xml, "envEvento_v1.00.xsd", "/xsd/Evento_Generico_PL_v1.01/");
  }

  public static void validateConsSitNFeV400(String xml) throws RFWException {
    SEFAZXMLValidator.validateXMLAgainstSchema(xml, "consSitNFe_v4.00.xsd", "/xsd/PL_009p_NT2024_003_v1.02/");
  }

  /**
   * Valida uma mensagem contra um schema.
   *
   * @param xml XML da mensagem a ser validada
   * @param schemapath Schema que valida a mensagem
   * @param basepath Caminho base para encontrar os arquivos cujo schema principal referencia. Sempre temine argumento com "/". Por exemplo "/XSD/". O caminho começando com "/" referencia a raiz da pasta de classes (bin) ou fontes (src), ou rais do JAR.
   * @throws RFWException
   */
  private static void validateXMLAgainstSchema(String xml, String schemapath, String basepath) throws RFWException {
    try {
      RUXML.validateXMLAgainstSchema2(xml, schemapath, basepath);
    } catch (Exception e) {
      RFWLogger.logDebug("Logando falha de validação do XML para possível consulta do desenvolvedor...");
      RFWLogger.logDebug("XML: " + xml);
      RFWLogger.logDebug("schemaPath: " + schemapath);
      RFWLogger.logDebug("basePath: " + basepath);
      RFWCriticalException ex = new RFWCriticalException("RFW_000035", new String[] { schemapath }, e);
      RFWLogger.logException(ex);
      throw ex;
    }
  }

}