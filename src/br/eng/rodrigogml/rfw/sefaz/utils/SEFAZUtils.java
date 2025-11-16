package br.eng.rodrigogml.rfw.sefaz.utils;

import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

import br.eng.rodrigogml.rfw.kernel.RFW;
import br.eng.rodrigogml.rfw.kernel.exceptions.RFWCriticalException;
import br.eng.rodrigogml.rfw.kernel.exceptions.RFWException;
import br.eng.rodrigogml.rfw.kernel.exceptions.RFWValidationException;
import br.eng.rodrigogml.rfw.kernel.interfaces.RFWCertificate;
import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess;
import br.eng.rodrigogml.rfw.kernel.utils.RUString;
import br.eng.rodrigogml.rfw.kernel.utils.RUTypes;
import br.eng.rodrigogml.rfw.kernel.utils.RUXML;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_WebServices;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tpAmb;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_uf;

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

      Object element = um.unmarshal(new StringReader(xml));
      if (element instanceof JAXBElement) {
        return ((JAXBElement<T>) element).getValue();
      } else {
        return rootClass.cast(element);
      }
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
   * Faz o parser de um valor decimal encontrado na NFe para BigDecimal.<Br>
   * Faz o mesmo que 'new BigDecimal(value)', porém já trata o conteúdo entre nulo e vazio, e valida se o conteúdo é válido com mensagem personalizada.
   *
   * @param value Valor a ser transformado em BigDecimal
   * @return BigDecimal com o valor encontrato, ou nulo caso a string esteja vazia/nula.
   * @throws RFWException
   * @TODO Refatorar esse método para um prefixo 'parse', mais comum
   */
  public static BigDecimal convertBigDecimalToJava(String value) throws RFWException {
    value = PreProcess.processStringToNull(value);
    if (value != null) {
      if (!value.matches("[0-9]+((\\.)?[0-9]+)?")) {
        throw new RFWValidationException("RFW_000051", new String[] { value });
      }
      return new BigDecimal(value);
    }
    return null;
  }

  /**
   * Faz o parser de um valor decimal encontrado na NFe para BigDecimal.<Br>
   * Faz o mesmo que 'new BigDecimal(value)', porém já trata o conteúdo entre nulo e vazio, e valida se o conteúdo é válido com mensagem personalizada. <br>
   * Permite definir o BigDecimal com um número exato de casas decimais.
   *
   * @param value Valor a ser transformado em BigDecimal
   * @param decimals Quantidade de casas decimais.
   * @return BigDecimal com o valor encontrato, ou nulo caso a string esteja vazia/nula.
   * @throws RFWException
   * @TODO Refatorar esse método para um prefixo 'parse', mais comum
   */
  public static BigDecimal convertBigDecimalToJava(String value, Integer decimals) throws RFWException {
    BigDecimal v = convertBigDecimalToJava(value);
    if (v != null) v = v.setScale(decimals, RFW.getRoundingMode());
    return v;
  }

  /**
   * Este método junta todas as informações necessárias para montar a linha de informação ser usada para gerar o QRCode da NFCe.
   *
   * @param uf Estado do webservice usado para emitir a NFCe
   * @param env Ambiente usado para emitir a NFCe
   * @param chave chave de acesso da NFCe. (44 Bytes)
   * @param destCPFCNPJ Documento CPF/CNPJ de identificação do cliente. Passar nulo caso o consumidor não seja identificado.
   * @param dhEmi Data e Hora de emissão da NFCe.
   * @param vNF Valor total da NFCe. BigDecimal já com escala correta de 2 dígitos.
   * @param vICMS Valor total do ICMS da NFCe. BigDecimal já com escala correta de 2 dígitos.
   * @param digestValue DigestValue da NFCe, retornado da SEFAZ após autorização. É espero um byte array em base 64. Esse padrão foi escolhido pois é assim que ele é retornado da SEFAZ.
   * @param tokenID ID do token (código de segurança) sendo utilizado. Normalmente o identificador é "000001" ou "000002" dependendo do token gerado pelo estado.
   * @param token Token (código de segurança) de conhecimento apenas da empresa e da Receita Federal Estadual. Obtido pelo site ou diretamente da aplicação pelo webservice.
   *
   * @return
   */
  public static String generateQRCodeData(SEFAZ_uf uf, SEFAZ_tpAmb env, String chave, String destCPFCNPJ, LocalDateTime dhEmi, BigDecimal vNF, BigDecimal vICMS, byte[] digestValue, String tokenID, String token) throws RFWException {
    return generateQRCodeData(uf, env, chave, destCPFCNPJ, RUTypes.formatToyyyy_MM_dd_T_HH_mm_ssXXX(dhEmi), vNF, vICMS, digestValue, tokenID, token);
  }

  /**
   * Este método junta todas as informações necessárias para montar a linha de informação ser usada para gerar o QRCode da NFCe.
   *
   * @param uf Estado do webservice usado para emitir a NFCe
   * @param env Ambiente usado para emitir a NFCe
   * @param chave chave de acesso da NFCe. (44 Bytes)
   * @param destCPFCNPJ Documento CPF/CNPJ de identificação do cliente. Passar nulo caso o consumidor não seja identificado.
   * @param dhEmi Data e Hora de emissão da NFCe.
   * @param vNF Valor total da NFCe. BigDecimal já com escala correta de 2 dígitos.
   * @param vICMS Valor total do ICMS da NFCe. BigDecimal já com escala correta de 2 dígitos.
   * @param digestValue DigestValue da NFCe, retornado da SEFAZ após autorização. É espero um byte array em base 64. Esse padrão foi escolhido pois é assim que ele é retornado da SEFAZ.
   * @param tokenID ID do token (código de segurança) sendo utilizado. Normalmente o identificador é "000001" ou "000002" dependendo do token gerado pelo estado.
   * @param token Token (código de segurança) de conhecimento apenas da empresa e da Receita Federal Estadual. Obtido pelo site ou diretamente da aplicação pelo webservice.
   *
   * @return
   */
  public static String generateQRCodeData(SEFAZ_uf uf, SEFAZ_tpAmb env, String chave, String destCPFCNPJ, Date dhEmi, BigDecimal vNF, BigDecimal vICMS, byte[] digestValue, String tokenID, String token) throws RFWException {
    return generateQRCodeData(uf, env, chave, destCPFCNPJ, RUTypes.formatToyyyy_MM_dd_T_HH_mm_ssXXX(dhEmi), vNF, vICMS, digestValue, tokenID, token);
  }

  /**
   * Este método junta todas as informações necessárias para montar a linha de informação ser usada para gerar o QRCode da NFCe.
   *
   * @param uf Estado do webservice usado para emitir a NFCe
   * @param env Ambiente usado para emitir a NFCe
   * @param chave chave de acesso da NFCe. (44 Bytes)
   * @param destCPFCNPJ Documento CPF/CNPJ de identificação do cliente. Passar nulo caso o consumidor não seja identificado.
   * @param dhEmi Data e Hora de emissão da NFCe no formato UTC utilizado no XML.
   * @param vNF Valor total da NFCe. BigDecimal já com escala correta de 2 dígitos.
   * @param vICMS Valor total do ICMS da NFCe. BigDecimal já com escala correta de 2 dígitos.
   * @param digestValue DigestValue da NFCe, retornado da SEFAZ após autorização. É espero um byte array em base 64. Esse padrão foi escolhido pois é assim que ele é retornado da SEFAZ.
   * @param tokenID ID do token (código de segurança) sendo utilizado. Normalmente o identificador é "000001" ou "000002" dependendo do token gerado pelo estado.
   * @param token Token (código de segurança) de conhecimento apenas da empresa e da Receita Federal Estadual. Obtido pelo site ou diretamente da aplicação pelo webservice.
   *
   * @return
   */
  public static String generateQRCodeData(SEFAZ_uf uf, SEFAZ_tpAmb env, String chave, String destCPFCNPJ, String dhEmi, BigDecimal vNF, BigDecimal vICMS, byte[] digestValue, String tokenID, String token) throws RFWException {
    // Parte 1: Endereço de consulta
    String address = null;
    if (uf == SEFAZ_uf.SP) {
      if (env == SEFAZ_tpAmb.HOMOLOGACAO) {
        address = "https://www.homologacao.nfce.fazenda.sp.gov.br/NFCeConsultaPublica/Paginas/ConsultaQRCode.aspx?";
      } else if (env == SEFAZ_tpAmb.PRODUCAO) {
        address = "https://www.nfce.fazenda.sp.gov.br/NFCeConsultaPublica/Paginas/ConsultaQRCode.aspx?";
      }
    } else if (uf == SEFAZ_uf.RS) {
      if (env == SEFAZ_tpAmb.HOMOLOGACAO) {
        address = "https://www.sefaz.rs.gov.br/NFCE/NFCE-COM.aspx?";
      } else if (env == SEFAZ_tpAmb.PRODUCAO) {
        address = "https://www.sefaz.rs.gov.br/NFCE/NFCE-COM.aspx?";
      }
    }

    // Valida se temos um endereço
    if (address == null) {
      throw new RFWCriticalException("BISModules_000095", new String[] { "" + uf, "" + env });
    }

    // Parte 2: Parametros
    final StringBuilder buff = new StringBuilder();
    buff.append("chNFe=").append(chave);
    buff.append("&nVersao=100");
    buff.append("&tpAmb=").append(env.getXmlData());
    if (destCPFCNPJ != null) buff.append("&cDest=").append(destCPFCNPJ);
    buff.append("&dhEmi=").append(RUString.toHex(dhEmi));
    buff.append("&vNF=").append(vNF.toString());
    buff.append("&vICMS=").append(vICMS.toString());
    buff.append("&digVal=").append(RUString.toHexFromBase64(digestValue));
    buff.append("&cIdToken=").append(tokenID);

    // Parte 3 - Calculamos a Hash com base nos parametros concatenados na parte 2 e a chave de segurança. Do resultado é criado o parmetro hashQRCode e concatenado no final.
    String tosha = buff.toString() + token; // String da qual precisamos calcular a hash sha1
    String hash = RUString.calcSHA1ToHex(tosha);
    buff.append("&cHashQRCode=").append(hash);

    // Por fim retornamos o endereço base, os parametros da parte 2 (e 3 que foi includo no buffer da parte 2)
    return address + buff.toString();
  }

  /**
   * Este método interpreta todos os formatos já encontrados de datas que podem vir na NFe para o formato do Java. Atualmente os formatos reconhecidos são:<br>
   * <li>"yyyy-MM-dd'T'HH:mm:ssXXX" (Padrão UTC)</li>
   * <li>"yyyy-MM-dd'T'HH:mm:ss" (Padrão UTC Sem TimeZone)</li>
   * <li>"yyyy-MM-dd"</li>
   *
   * @param date
   * @return
   * @throws RFWException
   */
  public static Date parseDate(String date) throws RFWException {
    return RUTypes.parseDate(date);
  }

  /**
   * Interpreta diversos formatos de data encontrados na NF-e e os converte para {@link LocalDateTime}.
   * <p>
   * Os formatos suportados são:
   * <ul>
   * <li>"yyyy-MM-dd'T'HH:mm:ssXXX" Exemplo: "2024-02-20T15:30:00-07:00" (UTC com timezone)</li>
   * <li>"yyyy-MM-dd'T'HH:mm:ssZ" Exemplo: "2024-02-20T15:30:00-0700" (UTC com timezone)</li>
   * <li>"yyyy-MM-dd'T'HH:mm:ss" Exemplo: "2024-02-20T15:30:00" (UTC sem timezone)</li>
   * <li>"yyyy-MM-dd" Exemplo: "2024-02-20"</li>
   * <li>"dd/MM/yyyy" Exemplo: "20/02/2024"</li>
   * </ul>
   * <p>
   * Quando o timezone está ausente, assume-se o fuso horário do sistema.
   *
   * @param date String representando a data.
   * @return {@link LocalDateTime} correspondente.
   * @throws RFWException Se o formato da data não for reconhecido ou se ocorrer um erro de conversão.
   */
  public static LocalDateTime parseLocalDateTime(String date) throws RFWException {
    return RUTypes.parseLocalDateTime(date);
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
}
