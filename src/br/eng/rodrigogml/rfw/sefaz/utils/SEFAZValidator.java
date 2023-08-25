package br.eng.rodrigogml.rfw.sefaz.utils;

import br.eng.rodrigogml.rfw.kernel.exceptions.RFWException;
import br.eng.rodrigogml.rfw.kernel.exceptions.RFWValidationException;
import br.eng.rodrigogml.rfw.kernel.exceptions.RFWValidationGroupException;
import br.eng.rodrigogml.rfw.kernel.preprocess.PreProcess;
import br.eng.rodrigogml.rfw.kernel.validator.RFWValidator;
import br.eng.rodrigogml.rfw.sefaz.vos.DetVO;
import br.eng.rodrigogml.rfw.sefaz.vos.ICMSVO;
import br.eng.rodrigogml.rfw.sefaz.vos.ICMSVO_;
import br.eng.rodrigogml.rfw.sefaz.vos.NFeVO;
import br.eng.rodrigogml.rfw.sefaz.vos.NFrefVO;

/**
 * Description: O {@link SEFAZValidator} é uma classe utilizada para validar os objetos de comunicação e de layout da SEFAZ.<br>
 * Para os objetos baseados no RFWVO inicia a validação utilizando o {@link RFWValidator} e as MetaAnnotations dos objetos, se passar nessa validação, começa as validações cruzadas especificadas nos documentos da SEFAZ que não são possíveis de serem validadas apenas com as MetaAnnotations.
 *
 * @author Rodrigo GML
 * @since 1.0.0 (23 de ago. de 2023)
 * @version 1.0.0 - Rodrigo GML-(...)
 */
public class SEFAZValidator {

  /**
   * Construtor privado para classe exclusivamente estática de métos utilitárias.
   */
  private SEFAZValidator() {
  }

  /**
   * Valida o objeto {@link NFeVO} contra as regras de validação definidas nos documentos da SEFAZ.<br>
   *
   * @param nfe Objeto a ser validado.
   * @throws RFWException Lançado em caso de erro crítico ou com as falhas de validações encontradas no objeto.
   */
  public static void validateNFeVO(NFeVO nfe) throws RFWException {
    final RFWValidator rfwValidator = new RFWValidator();
    rfwValidator.validatePersist(NFeVO.class, nfe);

    final RFWValidationGroupException val = new RFWValidationGroupException();
    final double layoutVersion = PreProcess.toDouble(nfe.getInfNFe().getVersao());

    /*
     * Grupo B. Identificação da Nota Fiscal eletrônica
     */

    // Tag indPag removida a partir do layout 4.0 - NT2016.002
    if (layoutVersion >= 4 && nfe.getInfNFe().getIde().getIndPag() != null) val.addValidationException("A TAG 'indPag' não é mais permitida a partir da versão do layout 4.00 (NT2016.002)", new String[] { "" + layoutVersion });

    // Validação do Grupo 29b.1/B27.1
    if (nfe.getInfNFe().getIde().getDhCont() == null ^ nfe.getInfNFe().getIde().getXjust() == null) val.addValidationException("As TAGs 'infNFe/ide/dhCont' e 'infNFe/ide/xJust' devem estar ambas presentes ou ambas ausentes.");

    /*
     * Grupo BA. Documento Fiscal Referenciado
     */
    // Valida a existência apenas de um grupo de referência para cada tag NFRef
    if (nfe.getInfNFe().getIde().getNfref() != null) {
      int countnfRfe = 1;
      for (NFrefVO nfref : nfe.getInfNFe().getIde().getNfref()) {
        int countTags = 0;
        countTags += (nfref.getRefNFe() != null ? 1 : 0);
        countTags += (nfref.getRefNF() != null ? 1 : 0);
        countTags += (nfref.getRefNFP() != null ? 1 : 0);
        countTags += (nfref.getRefECF() != null ? 1 : 0);

        if (countTags > 1) {
          val.addValidationException("Não é permitido ter mais do que uma das TAGs 'refNFe', 'refNF', 'refNFP' e 'refECF' dentro da TAG 'NFref[${0}]'.", new String[] { "" + countnfRfe });
        } else if (countTags == 0) {
          val.addValidationException("É obrigatório conter uma das TAGs 'refNFe', 'refNF', 'refNFP' e 'refECF' dentro da TAG 'NFref[${0}]'.", new String[] { "" + countnfRfe });
        }

        countnfRfe++;
      }
    }

    /*
     * Grupo C. Identificação do Emitente da Nota Fiscal eletrônica
     */

    // Validação do Grupo 47.1/C18.1
    {
      boolean hasAny = false;
      hasAny |= nfe.getInfNFe().getEmit().getIm() != null;
      hasAny |= nfe.getInfNFe().getEmit().getCnae() != null;
      hasAny |= nfe.getInfNFe().getEmit().getCrt() != null;

      if (hasAny && (nfe.getInfNFe().getEmit().getIm() == null || nfe.getInfNFe().getEmit().getCrt() == null)) {
        val.addValidationException("As TAGs 'IM' e 'CRT' da TAG 'emit' são obrigatórias quando alguma do grupo é escrita.");
      }
    }

    /*
     * Grupo I. Produtos e Serviços da NF-e
     */

    int countDet = 0;
    for (DetVO det : nfe.getInfNFe().getDet()) {
      // Validação do Grupo 104b/I05b (Incluído na NT2016.002)
      {
        boolean hasAny = false;
        hasAny |= det.getProd().getCest() != null;
        hasAny |= det.getProd().getIndEscala() != null;
        hasAny |= det.getProd().getCnpjFab() != null;
        if (hasAny && det.getProd().getCest() == null) val.addValidationException("A TAG 'CEST' é obrigatória dentro da TAG 'det[${0}]\\prod' quando uma das TAGs 'indEscala' ou 'CNPJFab' forem informadas.", new String[] { "" + countDet });
      }

      /*
       * Grupo M. Tributos incidentes no Produto ou Serviço
       */

      /*
       * Grupo N01. ICMS Normal e ST
       */
      if (!(det.getImposto().getIcms().getCst() == null ^ det.getImposto().getIcms().getCsosn() == null)) {
        val.addValidationException("Uma das TAGs 'CST' ou 'CSOSN' dentro da TAG ''det[${0}]\\imposto\\ICMS' deve ser informada!", new String[] { "" + countDet });
      }

      if (det.getImposto().getIcms().getCst() != null) {
        if ("00".equals(det.getImposto().getIcms().getCst())) {
          /*
           * Grupo N02. Grupo Tributação do ICMS= 00
           */
          try {
            rfwValidator.validatePersist(ICMSVO.class, det.getImposto().getIcms(), new String[] { ICMSVO_._orig, ICMSVO_._modBC, ICMSVO_._vbc, ICMSVO_._picms, ICMSVO_._vicms });
          } catch (RFWValidationException e) {
            val.addValidationException(e);
          }
          if (det.getImposto().getIcms().getPfcp() == null ^ det.getImposto().getIcms().getVfcp() == null) {
            val.addValidationException("Ambas as TAGs 'pFCP' e 'vFCP' devem ser informadas ou nenhuma dentro de 'det[${0}]\\imposto\\ICMS'", new String[] { "" + countDet });
          }
        } else if ("10".equals(det.getImposto().getIcms().getCst())) {
          /*
           * Grupo N03. Grupo Tributação do ICMS= 10
           */
          try {
            rfwValidator.validatePersist(ICMSVO.class, det.getImposto().getIcms(), new String[] { ICMSVO_._orig, ICMSVO_._modBC, ICMSVO_._vbc, ICMSVO_._picms, ICMSVO_._vicms, ICMSVO_._modBCST, ICMSVO_._vbcST });
          } catch (RFWValidationException e) {
            val.addValidationException(e);
          }

          // Validação do Grupo 178.01/N17.0
          {
            int countTags = 0;
            countTags += (det.getImposto().getIcms().getVbcFCP() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getPfcp() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getVfcp() != null ? 1 : 0);
            if (countTags != 0 && countTags != 3) {
              val.addValidationException("As TAGs 'vBCFCP', 'pFCP' e 'vFCP' devem ser todas ou nenhuma informada na TAG 'det[${0}]\\imposto\\ICMS'.", new String[] { "" + countDet });
            }
          }

          // Validação do Grupo 184.0/N23.1
          {
            int countTags = 0;
            countTags += (det.getImposto().getIcms().getVbcFCPST() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getPfcpST() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getVfcpST() != null ? 1 : 0);
            if (countTags != 0 && countTags != 3) {
              val.addValidationException("As TAGs 'vBCFCPST', 'pFCPST' e 'vFCPST' devem ser todas ou nenhuma informada na TAG 'det[${0}]\\imposto\\ICMS'.", new String[] { "" + countDet });
            }
          }
        } else if ("20".equals(det.getImposto().getIcms().getCst())) {
          /*
           * Grupo N04. Grupo Tributação do ICMS= 20
           */
          try {
            rfwValidator.validatePersist(ICMSVO.class, det.getImposto().getIcms(), new String[] { ICMSVO_._orig, ICMSVO_._modBC, ICMSVO_._predBC, ICMSVO_._vbc, ICMSVO_._picms, ICMSVO_._vicms });
          } catch (RFWValidationException e) {
            val.addValidationException(e);
          }

          // Validação do Grupo 192.0/N17.1
          {
            int countTags = 0;
            countTags += (det.getImposto().getIcms().getVbcFCP() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getPfcp() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getVfcp() != null ? 1 : 0);
            if (countTags != 0 && countTags != 3) {
              val.addValidationException("As TAGs 'vBCFCP', 'pFCP' e 'vFCP' devem ser todas ou nenhuma informada na TAG 'det[${0}]\\imposto\\ICMS'.", new String[] { "" + countDet });
            }
          }

          // Validação do Grupo 192.1/N27.1
          {
            int countTags = 0;
            countTags += (det.getImposto().getIcms().getVicmsDeson() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getMotDesICMS() != null ? 1 : 0);
            if (countTags != 0 && countTags != 2) {
              val.addValidationException("As TAGs 'vICMSDeson' e 'motDesICMS' devem ser ambas ou nenhuma informada na TAG 'det[${0}]\\imposto\\ICMS'.", new String[] { "" + countDet });
            }
          }
        } else if ("30".equals(det.getImposto().getIcms().getCst())) {
          /*
           * Grupo N05. Grupo Tributação do ICMS= 30
           */
          try {
            rfwValidator.validatePersist(ICMSVO.class, det.getImposto().getIcms(), new String[] { ICMSVO_._orig, ICMSVO_._modBCST, ICMSVO_._vbcST, ICMSVO_._picmsST, ICMSVO_._vicmsST });
          } catch (RFWValidationException e) {
            val.addValidationException(e);
          }

          // Validação do Grupo 201.0/N23.1
          {
            int countTags = 0;
            countTags += (det.getImposto().getIcms().getVbcFCPST() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getPfcpST() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getVfcpST() != null ? 1 : 0);
            if (countTags != 0 && countTags != 3) {
              val.addValidationException("As TAGs 'vBCFCPST', 'pFCPST' e 'vFCPST' devem ser todas ou nenhuma informada na TAG 'det[${0}]\\imposto\\ICMS'.", new String[] { "" + countDet });
            }
          }

          // Validação do Grupo 201.1/N27.1
          {
            int countTags = 0;
            countTags += (det.getImposto().getIcms().getVicmsDeson() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getMotDesICMS() != null ? 1 : 0);
            if (countTags != 0 && countTags != 2) {
              val.addValidationException("As TAGs 'vICMSDeson' e 'motDesICMS' devem ser ambas ou nenhuma informada na TAG 'det[${0}]\\imposto\\ICMS'.", new String[] { "" + countDet });
            }
          }
        } else if ("40".equals(det.getImposto().getIcms().getCst()) || "41".equals(det.getImposto().getIcms().getCst()) || "50".equals(det.getImposto().getIcms().getCst())) {
          /*
           * Grupo N06. Grupo Tributação do ICMS= 40, 41, 50
           */
          try {
            rfwValidator.validatePersist(ICMSVO.class, det.getImposto().getIcms(), new String[] { ICMSVO_._orig });
          } catch (RFWValidationException e) {
            val.addValidationException(e);
          }

          // Validação do Grupo 204.00/N27.1
          {
            int countTags = 0;
            countTags += (det.getImposto().getIcms().getVicmsDeson() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getMotDesICMS() != null ? 1 : 0);
            if (countTags != 0 && countTags != 2) {
              val.addValidationException("As TAGs 'vICMSDeson' e 'motDesICMS' devem ser ambas ou nenhuma informada na TAG 'det[${0}]\\imposto\\ICMS'.", new String[] { "" + countDet });
            }
          }
        } else if ("51".equals(det.getImposto().getIcms().getCst())) {
          /*
           * Grupo N07. Grupo Tributação do ICMS= 51
           */
          try {
            rfwValidator.validatePersist(ICMSVO.class, det.getImposto().getIcms(), new String[] { ICMSVO_._orig });
          } catch (RFWValidationException e) {
            val.addValidationException(e);
          }

          // Validação do Grupo 212.0/N17.1
          {
            int countTags = 0;
            countTags += (det.getImposto().getIcms().getVbcFCP() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getPfcp() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getVfcp() != null ? 1 : 0);
            if (countTags != 0 && countTags != 3) {
              val.addValidationException("As TAGs 'vBCFCP', 'pFCP' e 'vFCP' devem ser todas ou nenhuma informada na TAG 'det[${0}]\\imposto\\ICMS'.", new String[] { "" + countDet });
            }
          }
        } else if ("60".equals(det.getImposto().getIcms().getCst())) {
          /*
           * Grupo N08. Grupo Tributação do ICMS= 60
           */
          try {
            rfwValidator.validatePersist(ICMSVO.class, det.getImposto().getIcms(), new String[] { ICMSVO_._orig });
          } catch (RFWValidationException e) {
            val.addValidationException(e);
          }

          // Validação do Grupo 215.1/N25.1
          {
            int countReqTags = 0;
            countReqTags += (det.getImposto().getIcms().getVbcSTRet() != null ? 1 : 0);
            countReqTags += (det.getImposto().getIcms().getPst() != null ? 1 : 0);
            countReqTags += (det.getImposto().getIcms().getVicmsSTRet() != null ? 1 : 0);

            int countOtherTags = 0;
            countOtherTags += (det.getImposto().getIcms().getVicmsSubstituto() != null ? 1 : 0);

            if ((countOtherTags + countReqTags) > 0 && countReqTags != 3) {
              val.addValidationException("As TAGs 'vBCSTRet', 'pST' e 'vICMSSTRet' devem ser todas informada na TAG 'det[${0}]\\imposto\\ICMS' quando seu grupo de TAGs for informado.", new String[] { "" + countDet });
            }
          }

          // Validação do 217.0/N27.1
          {
            int countReqTags = 0;
            countReqTags += (det.getImposto().getIcms().getPredBCEfet() != null ? 1 : 0);
            countReqTags += (det.getImposto().getIcms().getVbcEfet() != null ? 1 : 0);
            countReqTags += (det.getImposto().getIcms().getPicmsEfet() != null ? 1 : 0);
            countReqTags += (det.getImposto().getIcms().getVicmsEfet() != null ? 1 : 0);

            if (countReqTags > 0 && countReqTags != 4) {
              val.addValidationException("As TAGs 'pRedBCEfet', 'vBCEfet', 'pICMSEfet' e 'vICMSEfet' devem ser todas ou nenhuma informada na TAG 'det[${0}]\\imposto\\ICMS' quando seu grupo de TAGs for informado.", new String[] { "" + countDet });
            }
          }
        } else if ("70".equals(det.getImposto().getIcms().getCst())) {
          /*
           * Grupo N09. Grupo Tributação do ICMS= 70
           */
          try {
            rfwValidator.validatePersist(ICMSVO.class, det.getImposto().getIcms(), new String[] { ICMSVO_._orig, ICMSVO_._modBC, ICMSVO_._vbc, ICMSVO_._picms, ICMSVO_._vicms, ICMSVO_._modBCST, ICMSVO_._vbcST, ICMSVO_._picmsST });
          } catch (RFWValidationException e) {
            val.addValidationException(e);
          }

          // Validação do Grupo 225.0/N17.0
          {
            int countTags = 0;
            countTags += (det.getImposto().getIcms().getVbcFCP() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getPfcp() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getVfcp() != null ? 1 : 0);
            if (countTags != 0 && countTags != 3) {
              val.addValidationException("As TAGs 'vBCFCP', 'pFCP' e 'vFCP' devem ser todas ou nenhuma informada na TAG 'det[${0}]\\imposto\\ICMS'.", new String[] { "" + countDet });
            }
          }

          // Validação do 231.0/N23.1
          {
            int countTags = 0;
            countTags += (det.getImposto().getIcms().getVbcFCPST() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getPfcpST() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getVfcpST() != null ? 1 : 0);
            if (countTags != 0 && countTags != 3) {
              val.addValidationException("As TAGs 'vBCFCPST', 'pFCPST' e 'vFCPST' devem ser todas ou nenhuma informada na TAG 'det[${0}]\\imposto\\ICMS'.", new String[] { "" + countDet });
            }
          }

          // Validação do 231.1/N27.1
          {
            int countTags = 0;
            countTags += (det.getImposto().getIcms().getVicmsDeson() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getMotDesICMS() != null ? 1 : 0);
            if (countTags != 0 && countTags != 2) {
              val.addValidationException("As TAGs 'vICMSDeson' e 'motDesICMS' devem ser ambas ou nenhuma informada na TAG 'det[${0}]\\imposto\\ICMS'.", new String[] { "" + countDet });
            }
          }
        } else if ("90".equals(det.getImposto().getIcms().getCst())) {
          /*
           * Grupo N10. Grupo Tributação do ICMS= 90
           */
          try {
            rfwValidator.validatePersist(ICMSVO.class, det.getImposto().getIcms(), new String[] { ICMSVO_._orig });
          } catch (RFWValidationException e) {
            val.addValidationException(e);
          }

          // Validação do Grupo 234.1/N12.1
          {
            int countReqTags = 0;
            countReqTags += (det.getImposto().getIcms().getModBC() != null ? 1 : 0);
            countReqTags += (det.getImposto().getIcms().getVbc() != null ? 1 : 0);
            countReqTags += (det.getImposto().getIcms().getPicms() != null ? 1 : 0);
            countReqTags += (det.getImposto().getIcms().getVicms() != null ? 1 : 0);

            int countOtherTags = 0;
            countOtherTags += (det.getImposto().getIcms().getPredBC() != null ? 1 : 0);

            if ((countOtherTags + countReqTags) > 0 && countReqTags != 4) {
              val.addValidationException("As TAGs 'modBC', 'vBC', 'pICMS' e 'vICMS' devem ser todas informada na TAG 'det[${0}]\\imposto\\ICMS' quando seu grupo de TAGs for informado.", new String[] { "" + countDet });
            }
          }

          // Validação do Grupo 239.0/N17.0
          {
            int countTags = 0;
            countTags += (det.getImposto().getIcms().getVbcFCP() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getPfcp() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getVfcp() != null ? 1 : 0);
            if (countTags != 0 && countTags != 3) {
              val.addValidationException("As TAGs 'vBCFCP', 'pFCP' e 'vFCP' devem ser todas ou nenhuma informada na TAG 'det[${0}]\\imposto\\ICMS'.", new String[] { "" + countDet });
            }
          }

          // Validação do Grupo 239.1/N17.1
          {
            int countReqTags = 0;
            countReqTags += (det.getImposto().getIcms().getModBCST() != null ? 1 : 0);
            countReqTags += (det.getImposto().getIcms().getVbcST() != null ? 1 : 0);
            countReqTags += (det.getImposto().getIcms().getPicmsST() != null ? 1 : 0);
            countReqTags += (det.getImposto().getIcms().getVicmsST() != null ? 1 : 0);

            int countOtherTags = 0;
            countOtherTags += (det.getImposto().getIcms().getPmvaST() != null ? 1 : 0);
            countOtherTags += (det.getImposto().getIcms().getPredBCST() != null ? 1 : 0);

            if ((countOtherTags + countReqTags) > 0 && countReqTags != 4) {
              val.addValidationException("As TAGs 'modBCST', 'vBCST', 'pICMSST' e 'vICMSST' devem ser todas informada na TAG 'det[${0}]\\imposto\\ICMS' quando seu grupo de TAGs for informado.", new String[] { "" + countDet });
            }
          }

          // Validação do Grupo 245.0/N23.1
          {
            int countTags = 0;
            countTags += (det.getImposto().getIcms().getVbcFCPST() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getPfcpST() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getVfcpST() != null ? 1 : 0);
            if (countTags != 0 && countTags != 3) {
              val.addValidationException("As TAGs 'vBCFCPST', 'pFCPST' e 'vFCPST' devem ser todas ou nenhuma informada na TAG 'det[${0}]\\imposto\\ICMS'.", new String[] { "" + countDet });
            }
          }

          // Validação do Grupo 245.1/N27.1
          {
            int countTags = 0;
            countTags += (det.getImposto().getIcms().getVicmsDeson() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getMotDesICMS() != null ? 1 : 0);
            if (countTags != 0 && countTags != 2) {
              val.addValidationException("As TAGs 'vICMSDeson' e 'motDesICMS' devem ser ambas ou nenhuma informada na TAG 'det[${0}]\\imposto\\ICMS'.", new String[] { "" + countDet });
            }
          }
        } else if ("10".equals(det.getImposto().getIcms().getCst())) {
          /*
           * Grupo N10. Grupo Tributação do ICMS= 90
           */
          try {
            rfwValidator.validatePersist(ICMSVO.class, det.getImposto().getIcms(), new String[] { ICMSVO_._orig });
          } catch (RFWValidationException e) {
            val.addValidationException(e);
          }

          // Validação do Grupo 234.1/N12.1
          {
            int countReqTags = 0;
            countReqTags += (det.getImposto().getIcms().getModBC() != null ? 1 : 0);
            countReqTags += (det.getImposto().getIcms().getVbc() != null ? 1 : 0);
            countReqTags += (det.getImposto().getIcms().getPicms() != null ? 1 : 0);
            countReqTags += (det.getImposto().getIcms().getVicms() != null ? 1 : 0);

            int countOtherTags = 0;
            countOtherTags += (det.getImposto().getIcms().getPredBC() != null ? 1 : 0);

            if ((countOtherTags + countReqTags) > 0 && countReqTags != 4) {
              val.addValidationException("As TAGs 'modBC', 'vBC', 'pICMS' e 'vICMS' devem ser todas informada na TAG 'det[${0}]\\imposto\\ICMS' quando seu grupo de TAGs for informado.", new String[] { "" + countDet });
            }
          }

          // Validação do Grupo 239.0/N17.0
          {
            int countTags = 0;
            countTags += (det.getImposto().getIcms().getVbcFCP() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getPfcp() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getVfcp() != null ? 1 : 0);
            if (countTags != 0 && countTags != 3) {
              val.addValidationException("As TAGs 'vBCFCP', 'pFCP' e 'vFCP' devem ser todas ou nenhuma informada na TAG 'det[${0}]\\imposto\\ICMS'.", new String[] { "" + countDet });
            }
          }

          // Validação do Grupo 239.1/N17.1
          {
            int countReqTags = 0;
            countReqTags += (det.getImposto().getIcms().getModBCST() != null ? 1 : 0);
            countReqTags += (det.getImposto().getIcms().getVbcST() != null ? 1 : 0);
            countReqTags += (det.getImposto().getIcms().getPicmsST() != null ? 1 : 0);
            countReqTags += (det.getImposto().getIcms().getVicmsST() != null ? 1 : 0);

            int countOtherTags = 0;
            countOtherTags += (det.getImposto().getIcms().getPmvaST() != null ? 1 : 0);
            countOtherTags += (det.getImposto().getIcms().getPredBCST() != null ? 1 : 0);

            if ((countOtherTags + countReqTags) > 0 && countReqTags != 4) {
              val.addValidationException("As TAGs 'modBCST', 'vBCST', 'pICMSST' e 'vICMSST' devem ser todas informada na TAG 'det[${0}]\\imposto\\ICMS' quando seu grupo de TAGs for informado.", new String[] { "" + countDet });
            }
          }

          // Validação do Grupo 245.0/N23.1
          {
            int countTags = 0;
            countTags += (det.getImposto().getIcms().getVbcFCPST() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getPfcpST() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getVfcpST() != null ? 1 : 0);
            if (countTags != 0 && countTags != 3) {
              val.addValidationException("As TAGs 'vBCFCPST', 'pFCPST' e 'vFCPST' devem ser todas ou nenhuma informada na TAG 'det[${0}]\\imposto\\ICMS'.", new String[] { "" + countDet });
            }
          }

          // Validação do Grupo 245.1/N27.1
          {
            int countTags = 0;
            countTags += (det.getImposto().getIcms().getVicmsDeson() != null ? 1 : 0);
            countTags += (det.getImposto().getIcms().getMotDesICMS() != null ? 1 : 0);
            if (countTags != 0 && countTags != 2) {
              val.addValidationException("As TAGs 'vICMSDeson' e 'motDesICMS' devem ser ambas ou nenhuma informada na TAG 'det[${0}]\\imposto\\ICMS'.", new String[] { "" + countDet });
            }
          }
        }
      }

      countDet++;
    }
  }

}
