package br.eng.rodrigogml.rfw.sefaz.utils;

import br.eng.rodrigogml.rfw.kernel.exceptions.RFWException;
import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess;
import br.eng.rodrigogml.rfw.kernel.utils.RUGenerators;
import br.eng.rodrigogml.rfw.kernel.utils.RUString;
import br.eng.rodrigogml.rfw.kernel.utils.RUTypes;
import br.eng.rodrigogml.rfw.kernel.utils.RUValueValidation;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZNFeVO;

/**
 * Description: Classe utilitária com métodos de manupilação dos VOs do módulo.<br>
 *
 * @author Rodrigo Leitão
 * @since (21 de nov. de 2025)
 */
public class SEFAZVOManager {

  /**
   * Construtor privado para classe estática.
   */
  public SEFAZVOManager() {
  }

  public static void fillSEFAZNFeVO(SEFAZNFeVO nfeVO) throws RFWException {
  }

  /**
   * Completa a chave do documento.<bR>
   * <br>
   *
   * Para adequado funcionamento este método requer as seguintes informações:
   * <li>ide/cUF</li>
   * <li>ide/dhEmi</li>
   * <li>ide/mod</li>
   * <li>ide/serie</li>
   * <li>ide/nnf</li>
   * <li>ide/tpEmis</li>
   * <li>emit/cnpj</li> <br>
   * <br>
   * Já os campos abaixo se não fierem pré-informados serão gerados automaticamente:
   * <li>ide/cnnf</li>
   *
   * <br>
   * <br>
   * Serão preenchidas as tags:
   * <li>infNFe/id</li>
   *
   * @param nfeVO Objeto a ser preenchido
   * @throws RFWException Lançado se alguma informação obrigatórioa não vier preenchida.
   */
  public static void fillSEFAZNFeVOChave(SEFAZNFeVO nfeVO) throws RFWException {
    PreProcess.requiredNonNull(nfeVO);
    PreProcess.requiredNonNull(nfeVO.getInfNFeVO());
    PreProcess.requiredNonNull(nfeVO.getInfNFeVO().getIdeVO());
    PreProcess.requiredNonNull(nfeVO.getInfNFeVO().getIdeVO().getCuf());
    PreProcess.requiredNonNull(nfeVO.getInfNFeVO().getIdeVO().getDhEmi());
    PreProcess.requiredNonNull(nfeVO.getInfNFeVO().getIdeVO().getMod());
    PreProcess.requiredNonNull(nfeVO.getInfNFeVO().getIdeVO().getSerie());
    PreProcess.requiredNonNull(nfeVO.getInfNFeVO().getIdeVO().getNnf());
    PreProcess.requiredNonNull(nfeVO.getInfNFeVO().getIdeVO().getTpEmis());
    PreProcess.requiredNonNull(nfeVO.getInfNFeVO().getEmitVO());
    PreProcess.requiredNonNull(nfeVO.getInfNFeVO().getEmitVO().getCnpj());

    StringBuilder chave = new StringBuilder();
    chave.append(nfeVO.getInfNFeVO().getIdeVO().getCuf()); // 1 Código da UF do emitente do Documento Fiscal 02 cUF B02
    chave.append(RUTypes.formatLocalDateTime(nfeVO.getInfNFeVO().getIdeVO().getDhEmi(), "yyMM")); // 2 Ano e Mês de emissão da NF-e 04 AAMM Extraídos de B09
    chave.append(nfeVO.getInfNFeVO().getEmitVO().getCnpj()); // 3 CNPJ/CPF do emitente 14 CNPJ/CPF C02/C02a
    chave.append(nfeVO.getInfNFeVO().getIdeVO().getMod().getXmlData()); // 4 Modelo do Documento Fiscal 02 mod B06
    chave.append(RUString.completeUntilLengthLeft("0", "" + nfeVO.getInfNFeVO().getIdeVO().getSerie(), 3)); // 5 Série do Documento Fiscal 03 serie B07
    chave.append(RUString.completeUntilLengthLeft("0", "" + nfeVO.getInfNFeVO().getIdeVO().getNnf(), 3)); // 6 Número do Documento Fiscal 09 nNF B08
    chave.append(nfeVO.getInfNFeVO().getIdeVO().getTpEmis().getXmlData()); // 7 forma de emissão da NF-e 01 tpEmis B22

    if (nfeVO.getInfNFeVO().getIdeVO().getCnf() == null) nfeVO.getInfNFeVO().getIdeVO().setCnf(new Integer(RUGenerators.generateNumericSequence(8)));
    chave.append(nfeVO.getInfNFeVO().getIdeVO().getCnf()); // 8 Código Numérico que compõe a Chave de Acesso 08 cNF B03

    if (nfeVO.getInfNFeVO().getIdeVO().getCdv() == null) nfeVO.getInfNFeVO().getIdeVO().setCdv(RUValueValidation.calcDVDANFeV400(chave.toString()));
    chave.append(nfeVO.getInfNFeVO().getIdeVO().getCdv()); // 9 Dígito Verificador da Chave de Acesso 01 cDV B23

    nfeVO.getInfNFeVO().setIdXML("NFe" + chave);
  }

}
