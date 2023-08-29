package br.eng.rodrigogml.rfw.sefaz.utils;

import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.eng.rodrigogml.rfw.kernel.RFW;
import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess;
import br.eng.rodrigogml.rfw.kernel.utils.RUFile;

import xsdobjects.consrecinfev400.TNfeProc;

/**
 * Description: Classe de testes da classe {@link SEFAZUtils}.<br>
 *
 * @author Rodrigo GML
 * @since 1.0.0 (28 de ago. de 2023)
 * @version 1.0.0 - Rodrigo GML-(...)
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SEFAZUtilsTest {

  @Test
  public void t00_testUnmarsahllerXMLs() throws Exception {
    String pathToXML = RFW.getDevProperty("rfw.sefaz.pathToNFeXMLToTest");
    PreProcess.requiredNonNull(pathToXML);

    File[] files = RUFile.getFilesFromDirectory(pathToXML);

    for (int i = 0; i < files.length; i++) {
      File file = files[i];
      String xml = RUFile.readFileContentToString(file);
      TNfeProc bean = SEFAZUtils.readXMLToObject(xml, TNfeProc.class);
      assertNotNull(bean);
      assertNotNull(bean.getNFe());
      assertNotNull(bean.getNFe().getInfNFe());
      assertNotNull(bean.getNFe().getInfNFe().getId());
      // System.out.println(file.getAbsolutePath());
      // System.out.println(bean.getNFe().getInfNFe().getId());
    }

  }

  public static void main(String[] args) throws Exception {
    String xml = RUFile.readFileContentToString("c:\\t\\NFesDEV\\nfe31220930698882000171550010000146861909298286.xml");
    TNfeProc tNfe = SEFAZUtils.readXMLToObject(xml, TNfeProc.class);

    System.out.println(tNfe.getNFe().getInfNFe().getIde().getCMunFG());
  }
}