package br.eng.rodrigogml.rfw.sefaz;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.eng.rodrigogml.rfw.kernel.RFW;
import br.eng.rodrigogml.rfw.kernel.exceptions.RFWException;
import br.eng.rodrigogml.rfw.kernel.exceptions.RFWRunTimeException;
import br.eng.rodrigogml.rfw.kernel.interfaces.RFWCertificate;
import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess;
import br.eng.rodrigogml.rfw.kernel.utils.RUFile;
import br.eng.rodrigogml.rfw.kernel.utils.RUReflex;
import br.eng.rodrigogml.rfw.sefaz.SEFAZDefinitions.SefazEnvironment;
import br.eng.rodrigogml.rfw.sefaz.SEFAZDefinitions.SefazServer;
import br.eng.rodrigogml.rfw.sefaz.vos.RetConsCadVO;

/**
 * Description: Classe de teste da {@link SEFAZ}.<br>
 *
 * @author Rodrigo GML
 * @since 1.0.0 (24 de ago. de 2023)
 * @version 1.0.0 - Rodrigo GML-(...)
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SEFAZTest {

  private RFWCertificate cert = null;

  private RFWCertificate trust = null;

  @Before
  public void initialize() throws RFWException {
    String certPath = RFW.getDevProperty("rfw.sefaz.cert.path");
    String certPass = RFW.getDevProperty("rfw.sefaz.cert.pass");
    PreProcess.requiredNonNull(certPath);
    PreProcess.requiredNonNull(certPass);

    String trustPath = RFW.getDevProperty("rfw.sefaz.trust.path");
    String trustPass = RFW.getDevProperty("rfw.sefaz.trust.pass");
    PreProcess.requiredNonNull(trustPath);
    PreProcess.requiredNonNull(trustPass);

    cert = new RFWCertificate() {
      @Override
      public CertificateType getType() {
        return CertificateType.A1;
      }

      @Override
      public String getCertificateFilePassword() {
        return certPass;
      }

      @Override
      public byte[] getCertificateFileContent() {
        try {
          return RUFile.readFileContent(certPath);
        } catch (RFWException e) {
          throw new RFWRunTimeException(e);
        }
      }
    };

    trust = new RFWCertificate() {
      @Override
      public CertificateType getType() {
        return CertificateType.KeyStore;
      }

      @Override
      public String getCertificateFilePassword() {
        return trustPass;
      }

      @Override
      public byte[] getCertificateFileContent() {
        try {
          return RUFile.readFileContent(trustPath);
        } catch (RFWException e) {
          throw new RFWRunTimeException(e);
        }
      }
    };

  }

  @Test
  public void t00_consultaCadastroCPF() throws RFWException {
    SEFAZ sefaz = new SEFAZ(cert, trust, SefazServer.SP, SefazEnvironment.TEST);

    String ret = sefaz.consultaCadastroByCPF_v2_00("12345678910");
    System.out.println(ret);
  }

  @Test
  public void t01_consultaCadastroCNPJ() throws RFWException {
    SEFAZ sefaz = new SEFAZ(cert, trust, SefazServer.SP, SefazEnvironment.TEST);

    String ret = sefaz.consultaCadastroByCNPJ_v2_00("45990181000189");
    System.out.println(ret);
  }

  @Test
  public void t02_JAXBTest() throws Exception {
    // String xml = "<retConsCad versao=\"2.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><infCons><verAplic>SP_NFE_PL009_V4</verAplic><cStat>262</cStat><xMotivo>Rejeição: UF não fornece consulta por CPF</xMotivo><UF>SP</UF><CPF>12345678910</CPF><dhCons>2023-08-25T14:46:34-03:00</dhCons><cUF>35</cUF></infCons></retConsCad>";
    String xml = "<retConsCad versao=\"2.00\"><infCons><verAplic>SP_NFE_PL009_V4</verAplic><cStat>262</cStat><xMotivo>Rejeição: UF não fornece consulta por CPF</xMotivo><UF>SP</UF><CPF>12345678910</CPF><dhCons>2023-08-25T18:25:21-03:00</dhCons><cUF>35</cUF></infCons></retConsCad>";

    JAXBContext context = JAXBContext.newInstance(RetConsCadVO.class);
    Unmarshaller um = context.createUnmarshaller();
    StringReader reader = new StringReader(xml);

    RetConsCadVO vo = (RetConsCadVO) um.unmarshal(reader);

    System.out.println(vo.getInfCons().getcStat());
    System.out.println(RUReflex.printObject(vo));
  }

}
