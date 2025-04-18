package br.eng.rodrigogml.rfw.sefaz;

import static org.junit.Assert.assertEquals;

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
import br.eng.rodrigogml.rfw.sefaz.SEFAZDefinitions.SefazWebServices;
import br.eng.rodrigogml.rfw.sefaz.SEFAZDefinitions.SefazXMLtpAmb;

import xsdobjects.consCad200.TRetConsCad;
import xsdobjects.consStatServ400.TRetConsStatServ;

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

  // private RFWCertificate trust = null;

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
  }

  @Test
  public void t00_consultaCadastroCPF() throws RFWException {
    SEFAZ sefaz = new SEFAZ(cert, SefazWebServices.SP, SefazXMLtpAmb.TEST);

    final String cpf = "12345678910";
    TRetConsCad root = sefaz.consultaCadastroV200byCPF(cpf);

    assertEquals(root.getInfCons().getCPF(), cpf);
  }

  @Test
  public void t01_consultaCadastroCNPJ() throws RFWException {
    SEFAZ sefaz = new SEFAZ(cert, SefazWebServices.SP, SefazXMLtpAmb.TEST);

    final String cnpj = "45990181000189";
    TRetConsCad root = sefaz.consultaCadastroV200byCNPJ(cnpj);
    assertEquals(root.getInfCons().getCNPJ(), cnpj);
    assertEquals(root.getInfCons().getInfCad().get(0).getXNome(), "ROBERT BOSCH LIMITADA");
  }

  @Test
  public void t02_consultaCadastroCPF() throws RFWException {
    SEFAZ sefaz = new SEFAZ(cert, SefazWebServices.SP, SefazXMLtpAmb.TEST);

    TRetConsStatServ root = sefaz.nfeStatusServicoNFV400();
    assertEquals("107", root.getCStat());
  }
}
