package br.eng.rodrigogml.rfw.sefaz.utils;

import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.eng.rodrigogml.rfw.kernel.RFW;
import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess;
import br.eng.rodrigogml.rfw.kernel.utils.RUFile;

import xsdobjects.consReciNFe400.TNfeProc;

/**
 * Description: Classe de testes da classe {@link SEFAZUtils}.<br>
 *
 * @author Rodrigo GML
 * @since 1.0.0 (28 de ago. de 2023)
 * @version 1.0.0 - Rodrigo GML-(...)
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SEFAZUtilsTest {

  /**
   * Se n�o houver arquivos na pasta indicada pela propriedade de desenvolvimento, o teste n�o testa nenhum arquivo. Por�m a pasta precisa existir e ser v�lida para que o teste funciona. Foi mantido desta forma para for�ar que ao menos o desenvolvedor tenha ci�ncia de que o teste ser� anulado se ele criar a pasta e mantiv�-la vazia.
   *
   * @throws Exception
   */
  @Test
  public void t00_testUnmarsahllerXMLs() throws Exception {
    String pathToXML = RFW.getDevProperty("rfw.sefaz.pathToNFeXMLToTest");
    PreProcess.requiredNonNull(pathToXML);

    File[] files = RUFile.getFilesFromDirectory(pathToXML);

    for (int i = (int) (Math.random() * files.length * 0.1); i < files.length; i += (Math.random() * files.length * 0.1)) {
      File file = files[i];
      String xml = RUFile.readFileContentToString(file);
      System.out.println("Testando Arquivo (Incremento Aleat�rio) [" + i + "/" + files.length + "]: " + xml);
      TNfeProc bean = SEFAZUtils.readXMLToObject(xml, TNfeProc.class);
      assertNotNull(bean);
      assertNotNull(bean.getNFe());
      assertNotNull(bean.getNFe().getInfNFe());
      assertNotNull(bean.getNFe().getInfNFe().getId());
    }
  }
}
