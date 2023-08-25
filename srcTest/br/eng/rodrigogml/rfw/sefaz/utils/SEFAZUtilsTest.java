package br.eng.rodrigogml.rfw.sefaz.utils;

import java.io.File;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.eng.rodrigogml.rfw.kernel.RFW;
import br.eng.rodrigogml.rfw.kernel.exceptions.RFWException;
import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess;
import br.eng.rodrigogml.rfw.kernel.utils.RUFile;
import br.eng.rodrigogml.rfw.sefaz.vos.NfeProcVO;

/**
 * Description: Classe de testes da classe {@link SEFAZUtils}.<br>
 *
 * @author Rodrigo GML
 * @since 1.0.0 (18 de ago. de 2023)
 * @version 1.0.0 - Rodrigo GML-(...)
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SEFAZUtilsTest {

  @Test
  public void t01_importXMLToObjetct() throws RFWException {
    String pathToXML = RFW.getDevProperty("rfw.sefaz.pathToNFeXMLToTest");
    PreProcess.requiredNonNullCritical(pathToXML, "O caminho para os arquivos XML de NFe não foi definido! Teste falhou!");

    File[] files = RUFile.getFilesFromDirectory(pathToXML);
    // final RFWValidator validator = new RFWValidator();

    int count = 1;
    for (File file : files) {
      System.out.println("Validando " + count + "/" + files.length + ": " + file.getAbsolutePath());
      if (file.length() == 1) {
        System.out.println("Excluindo!");
        file.delete();
        count++;
        continue;
      }
      NfeProcVO nfvo = SEFAZUtils.readXML(RUFile.readFileContentToString(file));
      SEFAZValidator.validateNFeVO(nfvo.getNfe());
      // file.delete();
      count++;
    }

  }

}
