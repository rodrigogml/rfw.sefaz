package br.eng.rodrigogml.rfw.sefaz.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import br.eng.rodrigogml.rfw.kernel.exceptions.RFWException;
import br.eng.rodrigogml.rfw.kernel.utils.RUTypes;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.IndIEDestEnum;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CRT;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CST_COFINS;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CST_PIS;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_finNFe;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_idDest;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indFinal;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indIntermed;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indPres;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indSinc;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_indTot;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_mod;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_procEmi;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tpAmb;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tpEmis;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tpImp;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_tpNF;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_versao;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZUtils;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZCOFINSVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZDestVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZDetVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZEmitVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZEnderDestVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZEnderEmitVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZEnviNFeVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZIdeVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZImpostoVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZInfNFeVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZLacresVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZNFRefVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZNFeProcVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZNFeVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZPISVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZProdVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZReboqueVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZRefECFVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZRefNFPVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZRefNFVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZRetTranspVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZTranspVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZTransportaVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZVeicTranspVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZVolVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZProtNFeVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZRetEnviNFeVO;

import xsdobjects.enviNFe400.TEnderEmi;
import xsdobjects.enviNFe400.TEndereco;
import xsdobjects.enviNFe400.TEnviNFe;
import xsdobjects.enviNFe400.TNFe;
import xsdobjects.enviNFe400.TNFe.InfNFe.Ide.NFref;
import xsdobjects.enviNFe400.TNfeProc;
import xsdobjects.enviNFe400.TUf;
import xsdobjects.enviNFe400.TUfEmi;
import xsdobjects.enviNFe400.TVeiculo;
import xsdobjects.enviNFe400.TProtNFe;
import xsdobjects.enviNFe400.TRetEnviNFe;

/**
 * Mapper responsvel por converter o VO {@link SEFAZEnviNFeVO} no contrato JAXB {@link TEnviNFe} utilizado pelo mtodo {@code nfeAutorizacaoLoteV400} (envio de lote v4.00), e vice-versa.
 *
 * <p>
 * O objetivo desta classe centralizar as converses VO &lt;-&gt; JAXB do lote, mantendo as regras de preenchimento fora da camada de validao/persistncia. Converses recursivas (NF-e e filhos) sero disponibilizadas em mtodos privados especficos, a medida que novas tarefas forem liberadas.
 */
public final class MapperForNfeAutorizacaoLoteV400 {

  private MapperForNfeAutorizacaoLoteV400() {
  }

  /**
   * Converte o {@link SEFAZEnviNFeVO} para {@link TEnviNFe}, preenchendo atributos simples e delegando a converso dos descendentes para submtodos.
   *
   * @param source VO persistido/instanciado internamente.
   * @return {@link TEnviNFe} pronto para assinatura e envio; {@code null} se {@code source} for {@code null}.
   */
  public static TEnviNFe toJaxb(SEFAZEnviNFeVO source) {
    if (source == null) {
      return null;
    }
    TEnviNFe target = new TEnviNFe();
    if (source.getVersao() != null) {
      target.setVersao(source.getVersao().getXmlData());
    }
    target.setIdLote(source.getIdLote());
    if (source.getIndSinc() != null) {
      target.setIndSinc(source.getIndSinc().getXmlData());
    }
    if (source.getNfeList() != null && !source.getNfeList().isEmpty()) {
      for (SEFAZNFeVO nfeVO : source.getNfeList()) {
        TNFe nfe = toJaxb(nfeVO);
        if (nfe != null) {
          target.getNFe().add(nfe);
        }
      }
    }
    return target;
  }

  /**
   * Converte o {@link TEnviNFe} retornado/emitido para o VO equivalente.
   *
   * @param source objeto JAXB recebido/construido via SEFAZ.
   * @return {@link SEFAZEnviNFeVO} populado; {@code null} se {@code source} for {@code null}.
   * @throws RFWException
   */
  public static SEFAZEnviNFeVO toVO(TEnviNFe source) throws RFWException {
    if (source == null) {
      return null;
    }
    SEFAZEnviNFeVO target = new SEFAZEnviNFeVO();
    if (source.getVersao() != null) {
      target.setVersao(SEFAZEnums.valueOfXMLData(SEFAZ_versao.class, source.getVersao()));
    }
    target.setIdLote(source.getIdLote());
    if (source.getIndSinc() != null) {
      target.setIndSinc(SEFAZEnums.valueOfXMLData(SEFAZ_indSinc.class, source.getIndSinc()));
    }
    if (source.getNFe() != null && !source.getNFe().isEmpty()) {
      ArrayList<SEFAZNFeVO> nfeList = new ArrayList<>(source.getNFe().size());
      for (TNFe nfe : source.getNFe()) {
        SEFAZNFeVO item = toVO(nfe, target);
        if (item != null) {
          nfeList.add(item);
        }
      }
      target.setNfeList(nfeList);
    }
    return target;
  }

  public static TRetEnviNFe toJaxb(SEFAZRetEnviNFeVO source) {
    if (source == null) {
      return null;
    }
    TRetEnviNFe target = new TRetEnviNFe();
    if (source.getVersao() != null) {
      target.setVersao(source.getVersao().getXmlData());
    }
    if (source.getTpAmb() != null) {
      target.setTpAmb(source.getTpAmb().getXmlData());
    }
    target.setVerAplic(source.getVerAplic());
    if (source.getCstat() != null) {
      target.setCStat(RUTypes.toString(source.getCstat()));
    }
    target.setXMotivo(source.getXmotivo());
    if (source.getCuf() != null) {
      target.setCUF(RUTypes.toString(source.getCuf()));
    }
    target.setDhRecbto(formatDateTime(source.getDhRecbto()));
    if (source.getProtNFeVO() != null) {
      target.setProtNFe(toJaxb(source.getProtNFeVO()));
    } else if (source.getNrec() != null || source.getTmed() != null) {
      TRetEnviNFe.InfRec infRec = new TRetEnviNFe.InfRec();
      if (source.getNrec() != null) {
        infRec.setNRec(RUTypes.toString(source.getNrec()));
      }
      if (source.getTmed() != null) {
        infRec.setTMed(RUTypes.toString(source.getTmed()));
      }
      target.setInfRec(infRec);
    }
    return target;
  }

  public static SEFAZRetEnviNFeVO toVO(TRetEnviNFe source) throws RFWException {
    if (source == null) {
      return null;
    }
    SEFAZRetEnviNFeVO target = new SEFAZRetEnviNFeVO();
    if (source.getVersao() != null) {
      target.setVersao(SEFAZEnums.valueOfXMLData(SEFAZ_versao.class, source.getVersao()));
    }
    if (source.getTpAmb() != null) {
      target.setTpAmb(SEFAZEnums.valueOfXMLData(SEFAZ_tpAmb.class, source.getTpAmb()));
    }
    target.setVerAplic(source.getVerAplic());
    if (source.getCStat() != null) {
      target.setCstat(RUTypes.toInteger(source.getCStat()));
    }
    target.setXmotivo(source.getXMotivo());
    if (source.getCUF() != null) {
      target.setCuf(RUTypes.toInteger(source.getCUF()));
    }
    target.setDhRecbto(parseDateTime(source.getDhRecbto()));
    if (source.getProtNFe() != null) {
      target.setProtNFeVO(toVO(source.getProtNFe(), target));
    } else if (source.getInfRec() != null) {
      target.setNrec(RUTypes.toLong(source.getInfRec().getNRec()));
      target.setTmed(RUTypes.toBigDecimal(source.getInfRec().getTMed()));
    }
    return target;
  }

  public static TNfeProc toJaxb(SEFAZNFeProcVO source) {
    if (source == null) {
      return null;
    }
    TNfeProc target = new TNfeProc();
    if (source.getVersao() != null) {
      target.setVersao(source.getVersao().getXmlData());
    }
    target.setNFe(toJaxb(source.getNfeVO()));
    return target;
  }

  public static TProtNFe toJaxb(SEFAZProtNFeVO source) {
    if (source == null) {
      return null;
    }
    TProtNFe target = new TProtNFe();
    if (source.getVersao() != null) {
      target.setVersao(source.getVersao().getXmlData());
    }
    TProtNFe.InfProt infProt = new TProtNFe.InfProt();
    if (source.getTpAmb() != null) {
      infProt.setTpAmb(source.getTpAmb().getXmlData());
    }
    infProt.setVerAplic(source.getVerAplic());
    infProt.setChNFe(source.getChNFe());
    infProt.setDhRecbto(formatDateTime(source.getDhRecbto()));
    if (source.getNprot() != null) {
      infProt.setNProt(RUTypes.toString(source.getNprot()));
    }
    if (source.getDigVal() != null) {
      infProt.setDigVal(source.getDigVal().getBytes());
    }
    if (source.getCstat() != null) {
      infProt.setCStat(RUTypes.toString(source.getCstat()));
    }
    infProt.setXMotivo(source.getXmotivo());
    if (source.getCmsg() != null) {
      infProt.setCMsg(RUTypes.toString(source.getCmsg()));
    }
    infProt.setXMsg(source.getXmsg());
    target.setInfProt(infProt);
    return target;
  }

  public static SEFAZProtNFeVO toVO(TProtNFe source, SEFAZRetEnviNFeVO parent) throws RFWException {
    if (source == null) {
      return null;
    }
    SEFAZProtNFeVO target = new SEFAZProtNFeVO();
    if (source.getVersao() != null) {
      target.setVersao(SEFAZEnums.valueOfXMLData(SEFAZ_versao.class, source.getVersao()));
    }
    if (source.getInfProt() != null) {
      if (source.getInfProt().getTpAmb() != null) {
        target.setTpAmb(SEFAZEnums.valueOfXMLData(SEFAZ_tpAmb.class, source.getInfProt().getTpAmb()));
      }
      target.setVerAplic(source.getInfProt().getVerAplic());
      target.setChNFe(source.getInfProt().getChNFe());
      target.setDhRecbto(parseDateTime(source.getInfProt().getDhRecbto()));
      target.setNprot(RUTypes.toLong(source.getInfProt().getNProt()));
      if (source.getInfProt().getDigVal() != null) {
        target.setDigVal(new String(source.getInfProt().getDigVal()));
      }
      target.setCstat(RUTypes.toInteger(source.getInfProt().getCStat()));
      target.setXmotivo(source.getInfProt().getXMotivo());
      target.setCmsg(RUTypes.toInteger(source.getInfProt().getCMsg()));
      target.setXmsg(source.getInfProt().getXMsg());
    }
    return target;
  }

  public static SEFAZNFeProcVO toVO(TNfeProc source) throws RFWException {
    if (source == null) {
      return null;
    }
    SEFAZNFeProcVO target = new SEFAZNFeProcVO();
    if (source.getVersao() != null) {
      target.setVersao(SEFAZEnums.valueOfXMLData(SEFAZ_versao.class, source.getVersao()));
    }
    target.setNfeVO(toVO(source.getNFe(), (SEFAZEnviNFeVO) null));
    return target;
  }

  public static TNFe toJaxb(SEFAZNFeVO nfeVO) {
    if (nfeVO == null) {
      return null;
    }
    TNFe target = new TNFe();
    target.setInfNFe(toJaxb(nfeVO.getInfNFeVO()));
    return target;
  }

  public static SEFAZNFeVO toVO(TNFe nfe, SEFAZEnviNFeVO parent) throws RFWException {
    if (nfe == null) {
      return null;
    }
    SEFAZNFeVO target = new SEFAZNFeVO();
    target.setInfNFeVO(toVO(nfe.getInfNFe(), target));
    return target;
  }

  public static TNFe.InfNFe toJaxb(SEFAZInfNFeVO source) {
    if (source == null) {
      return null;
    }
    TNFe.InfNFe target = new TNFe.InfNFe();
    if (source.getVersao() != null) {
      target.setVersao(source.getVersao().getXmlData());
    }
    target.setId(source.getIdXML());
    target.setIde(toJaxb(source.getIdeVO()));
    target.setEmit(toJaxb(source.getEmitVO()));
    target.setDest(toJaxb(source.getDestVO()));
    if (source.getDetList() != null && !source.getDetList().isEmpty()) {
      for (SEFAZDetVO detVO : source.getDetList()) {
        TNFe.InfNFe.Det detNode = toJaxb(detVO);
        if (detNode != null) {
          target.getDet().add(detNode);
        }
      }
    }
    target.setTransp(toJaxb(source.getTranspVO()));
    return target;
  }

  public static SEFAZInfNFeVO toVO(TNFe.InfNFe source, SEFAZNFeVO parent) throws RFWException {
    if (source == null) {
      return null;
    }
    SEFAZInfNFeVO target = new SEFAZInfNFeVO();
    target.setNfeVO(parent);
    if (source.getVersao() != null) {
      target.setVersao(SEFAZEnums.valueOfXMLData(SEFAZ_versao.class, source.getVersao()));
    }
    target.setIdXML(source.getId());
    target.setIdeVO(toVO(source.getIde(), target));
    target.setEmitVO(toVO(source.getEmit(), target));
    target.setDestVO(toVO(source.getDest(), target));
    if (source.getDet() != null && !source.getDet().isEmpty()) {
      List<SEFAZDetVO> detList = new ArrayList<>(source.getDet().size());
      for (TNFe.InfNFe.Det det : source.getDet()) {
        SEFAZDetVO item = toVO(det, target);
        if (item != null) {
          detList.add(item);
        }
      }
      target.setDetList(detList);
    }
    target.setTranspVO(toVO(source.getTransp(), target));
    return target;
  }

  public static TNFe.InfNFe.Ide toJaxb(SEFAZIdeVO source) {
    if (source == null) {
      return null;
    }
    TNFe.InfNFe.Ide target = new TNFe.InfNFe.Ide();
    if (source.getCuf() != null) {
      target.setCUF(source.getCuf());
    }
    if (source.getCnf() != null) {
      target.setCNF(RUTypes.toString(source.getCnf()));
    }
    target.setNatOp(source.getNatOp());
    if (source.getMod() != null) {
      target.setMod(source.getMod().getXmlData());
    }
    if (source.getSerie() != null) {
      target.setSerie(RUTypes.toString(source.getSerie()));
    }
    if (source.getNnf() != null) {
      target.setNNF(RUTypes.toString(source.getNnf()));
    }
    if (source.getDhEmi() != null) {
      target.setDhEmi(formatDateTime(source.getDhEmi()));
    }
    if (source.getDhSaiEnt() != null) {
      target.setDhSaiEnt(formatDateTime(source.getDhSaiEnt()));
    }
    if (source.getTpNF() != null) {
      target.setTpNF(source.getTpNF().getXmlData());
    }
    if (source.getIdDest() != null) {
      target.setIdDest(source.getIdDest().getXmlData());
    }
    if (source.getCmunFG() != null) {
      target.setCMunFG(RUTypes.toString(source.getCmunFG()));
    }
    if (source.getTpImp() != null) {
      target.setTpImp(source.getTpImp().getXmlData());
    }
    if (source.getTpEmis() != null) {
      target.setTpEmis(source.getTpEmis().getXmlData());
    }
    if (source.getCdv() != null) {
      target.setCDV(RUTypes.toString(source.getCdv()));
    }
    if (source.getTpAmb() != null) {
      target.setTpAmb(source.getTpAmb().getXmlData());
    }
    if (source.getFinNFe() != null) {
      target.setFinNFe(source.getFinNFe().getXmlData());
    }
    if (source.getIndFinal() != null) {
      target.setIndFinal(source.getIndFinal().getXmlData());
    }
    if (source.getIndPres() != null) {
      target.setIndPres(source.getIndPres().getXmlData());
    }
    if (source.getIndIntermed() != null) {
      target.setIndIntermed(source.getIndIntermed().getXmlData());
    }
    if (source.getProcEmi() != null) {
      target.setProcEmi(source.getProcEmi().getXmlData());
    }
    target.setVerProc(source.getVerProc());
    if (source.getDhCont() != null) {
      target.setDhCont(formatDateTime(source.getDhCont()));
    }
    target.setXJust(source.getXjust());
    if (source.getNfRefList() != null) {
      for (SEFAZNFRefVO nfRefVO : source.getNfRefList()) {
        TNFe.InfNFe.Ide.NFref nfref = toJaxb(nfRefVO);
        if (nfref != null) {
          target.getNFref().add(nfref);
        }
      }
    }
    return target;
  }

  public static SEFAZIdeVO toVO(TNFe.InfNFe.Ide source, SEFAZInfNFeVO parent) throws RFWException {
    if (source == null) {
      return null;
    }
    SEFAZIdeVO target = new SEFAZIdeVO();
    target.setInfNFeVO(parent);
    target.setCuf(source.getCUF());
    target.setCnf(RUTypes.toBigDecimal(source.getCNF()));
    target.setNatOp(source.getNatOp());
    if (source.getMod() != null) {
      target.setMod(SEFAZEnums.valueOfXMLData(SEFAZ_mod.class, source.getMod()));
    }
    target.setSerie(RUTypes.toBigDecimal(source.getSerie()));
    target.setNnf(RUTypes.toBigDecimal(source.getNNF()));
    target.setDhEmi(parseDateTime(source.getDhEmi()));
    target.setDhSaiEnt(parseDateTime(source.getDhSaiEnt()));
    if (source.getTpNF() != null) {
      target.setTpNF(SEFAZEnums.valueOfXMLData(SEFAZ_tpNF.class, source.getTpNF()));
    }
    if (source.getIdDest() != null) {
      target.setIdDest(SEFAZEnums.valueOfXMLData(SEFAZ_idDest.class, source.getIdDest()));
    }
    target.setCmunFG(RUTypes.toBigDecimal(source.getCMunFG()));
    if (source.getTpImp() != null) {
      target.setTpImp(SEFAZEnums.valueOfXMLData(SEFAZ_tpImp.class, source.getTpImp()));
    }
    if (source.getTpEmis() != null) {
      target.setTpEmis(SEFAZEnums.valueOfXMLData(SEFAZ_tpEmis.class, source.getTpEmis()));
    }
    target.setCdv(RUTypes.toInteger(source.getCDV()));
    if (source.getTpAmb() != null) {
      target.setTpAmb(SEFAZEnums.valueOfXMLData(SEFAZ_tpAmb.class, source.getTpAmb()));
    }
    if (source.getFinNFe() != null) {
      target.setFinNFe(SEFAZEnums.valueOfXMLData(SEFAZ_finNFe.class, source.getFinNFe()));
    }
    if (source.getIndFinal() != null) {
      target.setIndFinal(SEFAZEnums.valueOfXMLData(SEFAZ_indFinal.class, source.getIndFinal()));
    }
    if (source.getIndPres() != null) {
      target.setIndPres(SEFAZEnums.valueOfXMLData(SEFAZ_indPres.class, source.getIndPres()));
    }
    if (source.getIndIntermed() != null) {
      target.setIndIntermed(SEFAZEnums.valueOfXMLData(SEFAZ_indIntermed.class, source.getIndIntermed()));
    }
    if (source.getProcEmi() != null) {
      target.setProcEmi(SEFAZEnums.valueOfXMLData(SEFAZ_procEmi.class, source.getProcEmi()));
    }
    target.setVerProc(source.getVerProc());
    target.setDhCont(parseDateTime(source.getDhCont()));
    target.setXjust(source.getXJust());

    if (source.getNFref() != null && !source.getNFref().isEmpty()) {
      ArrayList<SEFAZNFRefVO> nfRefList = new ArrayList<>();
      for (NFref nfRef : source.getNFref()) {
        nfRefList.add(toVO(nfRef, target));
      }
      target.setNfRefList(nfRefList);
    }
    return target;
  }

  public static TNFe.InfNFe.Ide.NFref toJaxb(SEFAZNFRefVO source) {
    if (source == null) {
      return null;
    }
    TNFe.InfNFe.Ide.NFref target = new TNFe.InfNFe.Ide.NFref();
    target.setRefNFe(source.getRefNFe());
    target.setRefCTe(source.getRefCTe());
    if (source.getRefNFVO() != null) {
      target.setRefNF(toJaxb(source.getRefNFVO()));
    }
    if (source.getRefNFPVO() != null) {
      target.setRefNFP(toJaxbP(source.getRefNFPVO()));
    }
    if (source.getRefECFVO() != null) {
      target.setRefECF(toJaxb(source.getRefECFVO()));
    }
    return target;
  }

  public static SEFAZNFRefVO toVO(TNFe.InfNFe.Ide.NFref source, SEFAZIdeVO parent) {
    if (source == null) {
      return null;
    }
    SEFAZNFRefVO target = new SEFAZNFRefVO();
    target.setIdeVO(parent);
    target.setRefNFe(source.getRefNFe());
    target.setRefCTe(source.getRefCTe());
    if (source.getRefNF() != null) {
      target.setRefNFVO(toVO(source.getRefNF(), target));
    }
    if (source.getRefNFP() != null) {
      target.setRefNFPVO(toVOP(source.getRefNFP(), target));
    }
    if (source.getRefECF() != null) {
      target.setRefECFVO(toVO(source.getRefECF(), target));
    }
    return target;
  }

  public static TNFe.InfNFe.Ide.NFref.RefNF toJaxb(SEFAZRefNFVO source) {
    if (source == null) {
      return null;
    }
    TNFe.InfNFe.Ide.NFref.RefNF target = new TNFe.InfNFe.Ide.NFref.RefNF();
    target.setCUF(source.getCuf());
    target.setAAMM(source.getAamm());
    target.setCNPJ(source.getCnpj());
    if (source.getMod() != null) {
      target.setMod(source.getMod().getXmlData());
    }
    target.setSerie(source.getSerie());
    target.setNNF(source.getNnf());
    return target;
  }

  public static SEFAZRefNFVO toVO(TNFe.InfNFe.Ide.NFref.RefNF source, SEFAZNFRefVO parent) {
    if (source == null) {
      return null;
    }
    SEFAZRefNFVO target = new SEFAZRefNFVO();
    target.setNfRefVO(parent);
    target.setCuf(source.getCUF());
    target.setAamm(source.getAAMM());
    target.setCnpj(source.getCNPJ());
    if (source.getMod() != null) {
      target.setMod(SEFAZEnums.valueOfXMLData(SEFAZ_mod.class, source.getMod()));
    }
    target.setSerie(source.getSerie());
    target.setNnf(source.getNNF());
    return target;
  }

  public static TNFe.InfNFe.Ide.NFref.RefNFP toJaxbP(SEFAZRefNFPVO source) {
    if (source == null) {
      return null;
    }
    TNFe.InfNFe.Ide.NFref.RefNFP target = new TNFe.InfNFe.Ide.NFref.RefNFP();
    target.setCUF(source.getCuf());
    target.setAAMM(source.getAamm());
    target.setCNPJ(source.getCnpj());
    target.setCPF(source.getCpf());
    target.setIE(source.getIe());
    if (source.getMod() != null) {
      target.setMod(source.getMod().getXmlData());
    }
    target.setSerie(source.getSerie());
    target.setNNF(source.getNnf());
    return target;
  }

  public static SEFAZRefNFPVO toVOP(TNFe.InfNFe.Ide.NFref.RefNFP source, SEFAZNFRefVO parent) {
    if (source == null) {
      return null;
    }
    SEFAZRefNFPVO target = new SEFAZRefNFPVO();
    target.setNfRefVO(parent);
    target.setCuf(source.getCUF());
    target.setAamm(source.getAAMM());
    target.setCnpj(source.getCNPJ());
    target.setCpf(source.getCPF());
    target.setIe(source.getIE());
    if (source.getMod() != null) {
      target.setMod(SEFAZEnums.valueOfXMLData(SEFAZ_mod.class, source.getMod()));
    }
    target.setSerie(source.getSerie());
    target.setNnf(source.getNNF());
    return target;
  }

  public static TNFe.InfNFe.Ide.NFref.RefECF toJaxb(SEFAZRefECFVO source) {
    if (source == null) {
      return null;
    }
    TNFe.InfNFe.Ide.NFref.RefECF target = new TNFe.InfNFe.Ide.NFref.RefECF();
    if (source.getMod() != null) {
      target.setMod(source.getMod().getXmlData());
    }
    target.setNECF(source.getNecf());
    target.setNCOO(source.getNcoo());
    return target;
  }

  public static SEFAZRefECFVO toVO(TNFe.InfNFe.Ide.NFref.RefECF source, SEFAZNFRefVO parent) {
    if (source == null) {
      return null;
    }
    SEFAZRefECFVO target = new SEFAZRefECFVO();
    target.setNfRefVO(parent);
    if (source.getMod() != null) {
      target.setMod(SEFAZEnums.valueOfXMLData(SEFAZ_mod.class, source.getMod()));
    }
    target.setNecf(source.getNECF());
    target.setNcoo(source.getNCOO());
    return target;
  }

  public static TNFe.InfNFe.Emit toJaxb(SEFAZEmitVO source) {
    if (source == null) {
      return null;
    }
    TNFe.InfNFe.Emit target = new TNFe.InfNFe.Emit();
    target.setCNPJ(source.getCnpj());
    target.setCPF(source.getCpf());
    target.setXNome(source.getXnome());
    target.setXFant(source.getXfant());
    target.setIE(source.getIe());
    target.setIEST(source.getIest());
    target.setIM(source.getIm());
    target.setCNAE(source.getCnae());
    if (source.getCrt() != null) {
      target.setCRT(source.getCrt().getXmlData());
    }
    target.setEnderEmit(toJaxb(source.getEnderEmitVO()));
    return target;
  }

  public static TNFe.InfNFe.Dest toJaxb(SEFAZDestVO source) {
    if (source == null) {
      return null;
    }
    TNFe.InfNFe.Dest target = new TNFe.InfNFe.Dest();
    target.setCNPJ(source.getCnpj());
    target.setCPF(source.getCpf());
    target.setIdEstrangeiro(source.getIdEstrangeiro());
    target.setXNome(source.getXnome());
    target.setEnderDest(toJaxb(source.getEnderDestVO()));
    if (source.getIndIEDest() != null) {
      target.setIndIEDest(source.getIndIEDest().getXmlData());
    }
    target.setIE(source.getIe());
    target.setISUF(source.getIsuf());
    target.setIM(source.getIm());
    target.setEmail(source.getEmail());
    return target;
  }

  public static SEFAZDestVO toVO(TNFe.InfNFe.Dest source, SEFAZInfNFeVO parent) {
    if (source == null) {
      return null;
    }
    SEFAZDestVO target = new SEFAZDestVO();
    target.setInfNFeVO(parent);
    target.setCnpj(source.getCNPJ());
    target.setCpf(source.getCPF());
    target.setIdEstrangeiro(source.getIdEstrangeiro());
    target.setXnome(source.getXNome());
    if (source.getIndIEDest() != null) {
      target.setIndIEDest(SEFAZEnums.valueOfXMLData(IndIEDestEnum.class, source.getIndIEDest()));
    }
    target.setIe(source.getIE());
    target.setIsuf(source.getISUF());
    target.setIm(source.getIM());
    target.setEmail(source.getEmail());
    target.setEnderDestVO(toVO(source.getEnderDest(), target));
    return target;
  }

  public static TEndereco toJaxb(SEFAZEnderDestVO source) {
    if (source == null) {
      return null;
    }
    TEndereco target = new TEndereco();
    target.setXLgr(source.getXlgr());
    target.setNro(source.getNro());
    target.setXCpl(source.getXcpl());
    target.setXBairro(source.getXbairro());
    target.setCMun(source.getCmun());
    target.setXMun(source.getXmun());
    if (source.getUf() != null) {
      target.setUF(TUf.valueOf(source.getUf()));
    }
    target.setCEP(source.getCep());
    target.setCPais(source.getCpais());
    target.setXPais(source.getXpais());
    target.setFone(source.getFone());
    return target;
  }

  public static SEFAZEnderDestVO toVO(TEndereco source, SEFAZDestVO parent) {
    if (source == null) {
      return null;
    }
    SEFAZEnderDestVO target = new SEFAZEnderDestVO();
    target.setDestVO(parent);
    target.setXlgr(source.getXLgr());
    target.setNro(source.getNro());
    target.setXcpl(source.getXCpl());
    target.setXbairro(source.getXBairro());
    target.setCmun(source.getCMun());
    target.setXmun(source.getXMun());
    if (source.getUF() != null) {
      target.setUf(source.getUF().value());
    }
    target.setCep(source.getCEP());
    target.setCpais(source.getCPais());
    target.setXpais(source.getXPais());
    target.setFone(source.getFone());
    return target;
  }

  public static TNFe.InfNFe.Det toJaxb(SEFAZDetVO source) {
    if (source == null) {
      return null;
    }
    TNFe.InfNFe.Det target = new TNFe.InfNFe.Det();
    if (source.getNitem() != null) {
      target.setNItem(String.valueOf(source.getNitem()));
    }
    target.setProd(toJaxb(source.getProdVO()));
    target.setImposto(toJaxb(source.getImpostoVO()));
    return target;
  }

  public static SEFAZDetVO toVO(TNFe.InfNFe.Det source, SEFAZInfNFeVO parent) throws RFWException {
    if (source == null) {
      return null;
    }
    SEFAZDetVO target = new SEFAZDetVO();
    target.setInfNFeVO(parent);
    if (source.getNItem() != null) {
      target.setNitem(RUTypes.parseInteger(source.getNItem()));
    }
    target.setProdVO(toVO(source.getProd(), target));
    target.setImpostoVO(toVO(source.getImposto(), target));
    return target;
  }

  public static TNFe.InfNFe.Det.Prod toJaxb(SEFAZProdVO source) {
    if (source == null) {
      return null;
    }
    TNFe.InfNFe.Det.Prod target = new TNFe.InfNFe.Det.Prod();
    target.setCProd(source.getCprod());
    target.setCEAN(source.getCean());
    target.setXProd(source.getXprod());
    target.setNCM(source.getNcm());
    if (source.getNve() != null) {
      target.getNVE().add(source.getNve());
    }
    target.setCEST(source.getCest());
    target.setIndEscala(source.getIndescala());
    target.setCNPJFab(source.getCnpjFab());
    target.setCBenef(source.getCbenef());
    target.setEXTIPI(source.getExtipi());
    target.setCFOP(source.getCfop());
    target.setUCom(source.getUcom());
    target.setQCom(RUTypes.toString(source.getQcom()));
    target.setVUnCom(RUTypes.toString(source.getVunCom()));
    target.setVProd(RUTypes.toString(source.getVprod()));
    target.setCEANTrib(source.getCeanTrib());
    target.setUTrib(source.getUtrib());
    target.setQTrib(RUTypes.toString(source.getQtrib()));
    target.setVUnTrib(RUTypes.toString(source.getVunTrib()));
    target.setVFrete(RUTypes.toString(source.getVfrete()));
    target.setVSeg(RUTypes.toString(source.getVseg()));
    target.setVDesc(RUTypes.toString(source.getVdesc()));
    target.setVOutro(RUTypes.toString(source.getVoutro()));
    if (source.getIndTot() != null) {
      target.setIndTot(source.getIndTot().getXmlData());
    }
    return target;
  }

  public static SEFAZProdVO toVO(TNFe.InfNFe.Det.Prod source, SEFAZDetVO parent) throws RFWException {
    if (source == null) {
      return null;
    }
    SEFAZProdVO target = new SEFAZProdVO();
    target.setDetVO(parent);
    target.setCprod(source.getCProd());
    target.setCean(source.getCEAN());
    target.setXprod(source.getXProd());
    target.setNcm(source.getNCM());
    if (source.getNVE() != null && !source.getNVE().isEmpty()) {
      target.setNve(source.getNVE().get(0));
    }
    target.setCest(source.getCEST());
    target.setIndescala(source.getIndEscala());
    target.setCnpjFab(source.getCNPJFab());
    target.setCbenef(source.getCBenef());
    target.setExtipi(source.getEXTIPI());
    target.setCfop(source.getCFOP());
    target.setUcom(source.getUCom());
    target.setQcom(RUTypes.toBigDecimal(source.getQCom()));
    target.setVunCom(RUTypes.toBigDecimal(source.getVUnCom()));
    target.setVprod(RUTypes.toBigDecimal(source.getVProd()));
    target.setCeanTrib(source.getCEANTrib());
    target.setUtrib(source.getUTrib());
    target.setQtrib(RUTypes.toBigDecimal(source.getQTrib()));
    target.setVunTrib(RUTypes.toBigDecimal(source.getVUnTrib()));
    target.setVfrete(RUTypes.toBigDecimal(source.getVFrete()));
    target.setVseg(RUTypes.toBigDecimal(source.getVSeg()));
    target.setVdesc(RUTypes.toBigDecimal(source.getVDesc()));
    target.setVoutro(RUTypes.toBigDecimal(source.getVOutro()));
    if (source.getIndTot() != null) {
      target.setIndTot(SEFAZEnums.valueOfXMLData(SEFAZ_indTot.class, source.getIndTot()));
    }
    return target;
  }

  public static TNFe.InfNFe.Det.Imposto toJaxb(SEFAZImpostoVO source) {
    if (source == null) {
      return null;
    }
    TNFe.InfNFe.Det.Imposto target = new TNFe.InfNFe.Det.Imposto();
    if (source.getVtotTrib() != null) {
      target.getContent().add(SEFAZUtils.auxCreateJAXBElement("vTotTrib", RUTypes.toString(source.getVtotTrib())));
    }
    TNFe.InfNFe.Det.Imposto.PIS pis = toJaxb(source.getPisVO());
    if (pis != null) {
      target.getContent().add(SEFAZUtils.auxCreateJAXBElement("PIS", pis));
    }
    TNFe.InfNFe.Det.Imposto.COFINS cofins = toJaxb(source.getCofinsVO());
    if (cofins != null) {
      target.getContent().add(SEFAZUtils.auxCreateJAXBElement("COFINS", cofins));
    }
    return target;
  }

  public static SEFAZImpostoVO toVO(TNFe.InfNFe.Det.Imposto source, SEFAZDetVO parent) throws RFWException {
    if (source == null) {
      return null;
    }
    SEFAZImpostoVO target = new SEFAZImpostoVO();
    target.setDetVO(parent);
    if (source.getContent() != null) {
      for (JAXBElement<?> element : source.getContent()) {
        if (element == null || element.getName() == null) {
          continue;
        }
        Object value = element.getValue();
        String localName = element.getName().getLocalPart();
        if ("vTotTrib".equals(localName) && value instanceof String) {
          target.setVtotTrib(RUTypes.toBigDecimal((String) value));
        } else if ("PIS".equals(localName) && value instanceof TNFe.InfNFe.Det.Imposto.PIS) {
          target.setPisVO(toVO((TNFe.InfNFe.Det.Imposto.PIS) value, target));
        } else if ("COFINS".equals(localName) && value instanceof TNFe.InfNFe.Det.Imposto.COFINS) {
          target.setCofinsVO(toVO((TNFe.InfNFe.Det.Imposto.COFINS) value, target));
        }
      }
    }
    return target;
  }

  public static TNFe.InfNFe.Det.Imposto.PIS toJaxb(SEFAZPISVO source) {
    if (source == null || source.getCst() == null) {
      return null;
    }
    TNFe.InfNFe.Det.Imposto.PIS target = new TNFe.InfNFe.Det.Imposto.PIS();
    String cst = source.getCst().getXmlData();
    switch (source.getCst()) {
      case CST_01_OPERACAO_TRIBUTAVEL_BC_VALOR_ALIQUOTA_NORMAL:
      case CST_02_OPERACAO_TRIBUTAVEL_BC_VALOR_ALIQUOTA_DIFERENCIADA:
        TNFe.InfNFe.Det.Imposto.PIS.PISAliq pisAliq = new TNFe.InfNFe.Det.Imposto.PIS.PISAliq();
        pisAliq.setCST(cst);
        pisAliq.setVBC(RUTypes.toString(source.getVbc()));
        pisAliq.setPPIS(RUTypes.toString(source.getPpis()));
        pisAliq.setVPIS(RUTypes.toString(source.getVpis()));
        target.setPISAliq(pisAliq);
        break;
      case CST_03_OPERACAO_TRIBUTAVEL_BC_QTDE_ALIQUOTA_POR_UNIDADE:
        TNFe.InfNFe.Det.Imposto.PIS.PISQtde pisQtde = new TNFe.InfNFe.Det.Imposto.PIS.PISQtde();
        pisQtde.setCST(cst);
        pisQtde.setQBCProd(RUTypes.toString(source.getQbcProd()));
        pisQtde.setVAliqProd(RUTypes.toString(source.getValiqProd()));
        pisQtde.setVPIS(RUTypes.toString(source.getVpis()));
        target.setPISQtde(pisQtde);
        break;
      case CST_04_OPERACAO_TRIBUTAVEL_MONOFASICA_ALIQUOTA_ZERO:
      case CST_05_OPERACAO_TRIBUTAVEL_SUBSTITUICAO_TRIBUTARIA:
      case CST_06_OPERACAO_TRIBUTAVEL_ALIQUOTA_ZERO:
      case CST_07_OPERACAO_ISENTA:
      case CST_08_OPERACAO_SEM_INCIDENCIA:
      case CST_09_OPERACAO_COM_SUSPENSAO:
        TNFe.InfNFe.Det.Imposto.PIS.PISNT pisnt = new TNFe.InfNFe.Det.Imposto.PIS.PISNT();
        pisnt.setCST(cst);
        target.setPISNT(pisnt);
        break;
      default:
        TNFe.InfNFe.Det.Imposto.PIS.PISOutr pisOutr = new TNFe.InfNFe.Det.Imposto.PIS.PISOutr();
        pisOutr.setCST(cst);
        pisOutr.setVBC(RUTypes.toString(source.getVbc()));
        pisOutr.setPPIS(RUTypes.toString(source.getPpis()));
        pisOutr.setQBCProd(RUTypes.toString(source.getQbcProd()));
        pisOutr.setVAliqProd(RUTypes.toString(source.getValiqProd()));
        pisOutr.setVPIS(RUTypes.toString(source.getVpis()));
        target.setPISOutr(pisOutr);
        break;
    }
    return target;
  }

  public static SEFAZPISVO toVO(TNFe.InfNFe.Det.Imposto.PIS source, SEFAZImpostoVO parent) throws RFWException {
    if (source == null) {
      return null;
    }
    SEFAZPISVO target = new SEFAZPISVO();
    target.setImpostoVO(parent);
    if (source.getPISAliq() != null) {
      TNFe.InfNFe.Det.Imposto.PIS.PISAliq aliq = source.getPISAliq();
      target.setCst(SEFAZEnums.valueOfXMLData(SEFAZ_CST_PIS.class, aliq.getCST()));
      target.setVbc(RUTypes.toBigDecimal(aliq.getVBC()));
      target.setPpis(RUTypes.toBigDecimal(aliq.getPPIS()));
      target.setVpis(RUTypes.toBigDecimal(aliq.getVPIS()));
    } else if (source.getPISQtde() != null) {
      TNFe.InfNFe.Det.Imposto.PIS.PISQtde qtde = source.getPISQtde();
      target.setCst(SEFAZEnums.valueOfXMLData(SEFAZ_CST_PIS.class, qtde.getCST()));
      target.setQbcProd(RUTypes.toBigDecimal(qtde.getQBCProd()));
      target.setValiqProd(RUTypes.toBigDecimal(qtde.getVAliqProd()));
      target.setVpis(RUTypes.toBigDecimal(qtde.getVPIS()));
    } else if (source.getPISNT() != null) {
      TNFe.InfNFe.Det.Imposto.PIS.PISNT nt = source.getPISNT();
      target.setCst(SEFAZEnums.valueOfXMLData(SEFAZ_CST_PIS.class, nt.getCST()));
    } else if (source.getPISOutr() != null) {
      TNFe.InfNFe.Det.Imposto.PIS.PISOutr outr = source.getPISOutr();
      target.setCst(SEFAZEnums.valueOfXMLData(SEFAZ_CST_PIS.class, outr.getCST()));
      target.setVbc(RUTypes.toBigDecimal(outr.getVBC()));
      target.setPpis(RUTypes.toBigDecimal(outr.getPPIS()));
      target.setQbcProd(RUTypes.toBigDecimal(outr.getQBCProd()));
      target.setValiqProd(RUTypes.toBigDecimal(outr.getVAliqProd()));
      target.setVpis(RUTypes.toBigDecimal(outr.getVPIS()));
    }
    return target;
  }

  public static TNFe.InfNFe.Det.Imposto.COFINS toJaxb(SEFAZCOFINSVO source) {
    if (source == null || source.getCst() == null) {
      return null;
    }
    TNFe.InfNFe.Det.Imposto.COFINS target = new TNFe.InfNFe.Det.Imposto.COFINS();
    String cst = source.getCst().getXmlData();
    switch (source.getCst()) {
      case CST_01_OPERACAO_TRIBUTAVEL_BC_VALOR_ALIQUOTA_NORMAL:
      case CST_02_OPERACAO_TRIBUTAVEL_BC_VALOR_ALIQUOTA_DIFERENCIADA:
        TNFe.InfNFe.Det.Imposto.COFINS.COFINSAliq cofinsAliq = new TNFe.InfNFe.Det.Imposto.COFINS.COFINSAliq();
        cofinsAliq.setCST(cst);
        cofinsAliq.setVBC(RUTypes.toString(source.getVbc()));
        cofinsAliq.setPCOFINS(RUTypes.toString(source.getPcofins()));
        cofinsAliq.setVCOFINS(RUTypes.toString(source.getVcofins()));
        target.setCOFINSAliq(cofinsAliq);
        break;
      case CST_03_OPERACAO_TRIBUTAVEL_BC_QTDE_ALIQUOTA_POR_UNIDADE:
        TNFe.InfNFe.Det.Imposto.COFINS.COFINSQtde cofinsQtde = new TNFe.InfNFe.Det.Imposto.COFINS.COFINSQtde();
        cofinsQtde.setCST(cst);
        cofinsQtde.setQBCProd(RUTypes.toString(source.getQbcProd()));
        cofinsQtde.setVAliqProd(RUTypes.toString(source.getValiqProd()));
        cofinsQtde.setVCOFINS(RUTypes.toString(source.getVcofins()));
        target.setCOFINSQtde(cofinsQtde);
        break;
      case CST_04_OPERACAO_TRIBUTAVEL_MONOFASICA_ALIQUOTA_ZERO:
      case CST_05_OPERACAO_TRIBUTAVEL_SUBSTITUICAO_TRIBUTARIA:
      case CST_06_OPERACAO_TRIBUTAVEL_ALIQUOTA_ZERO:
      case CST_07_OPERACAO_ISENTA:
      case CST_08_OPERACAO_SEM_INCIDENCIA:
      case CST_09_OPERACAO_COM_SUSPENSAO:
        TNFe.InfNFe.Det.Imposto.COFINS.COFINSNT cofinsnt = new TNFe.InfNFe.Det.Imposto.COFINS.COFINSNT();
        cofinsnt.setCST(cst);
        target.setCOFINSNT(cofinsnt);
        break;
      default:
        TNFe.InfNFe.Det.Imposto.COFINS.COFINSOutr cofinsOutr = new TNFe.InfNFe.Det.Imposto.COFINS.COFINSOutr();
        cofinsOutr.setCST(cst);
        cofinsOutr.setVBC(RUTypes.toString(source.getVbc()));
        cofinsOutr.setPCOFINS(RUTypes.toString(source.getPcofins()));
        cofinsOutr.setQBCProd(RUTypes.toString(source.getQbcProd()));
        cofinsOutr.setVAliqProd(RUTypes.toString(source.getValiqProd()));
        cofinsOutr.setVCOFINS(RUTypes.toString(source.getVcofins()));
        target.setCOFINSOutr(cofinsOutr);
        break;
    }
    return target;
  }

  public static SEFAZCOFINSVO toVO(TNFe.InfNFe.Det.Imposto.COFINS source, SEFAZImpostoVO parent) throws RFWException {
    if (source == null) {
      return null;
    }
    SEFAZCOFINSVO target = new SEFAZCOFINSVO();
    target.setImpostoVO(parent);
    if (source.getCOFINSAliq() != null) {
      TNFe.InfNFe.Det.Imposto.COFINS.COFINSAliq aliq = source.getCOFINSAliq();
      target.setCst(SEFAZEnums.valueOfXMLData(SEFAZ_CST_COFINS.class, aliq.getCST()));
      target.setVbc(RUTypes.toBigDecimal(aliq.getVBC()));
      target.setPcofins(RUTypes.toBigDecimal(aliq.getPCOFINS()));
      target.setVcofins(RUTypes.toBigDecimal(aliq.getVCOFINS()));
    } else if (source.getCOFINSQtde() != null) {
      TNFe.InfNFe.Det.Imposto.COFINS.COFINSQtde qtde = source.getCOFINSQtde();
      target.setCst(SEFAZEnums.valueOfXMLData(SEFAZ_CST_COFINS.class, qtde.getCST()));
      target.setQbcProd(RUTypes.toBigDecimal(qtde.getQBCProd()));
      target.setValiqProd(RUTypes.toBigDecimal(qtde.getVAliqProd()));
      target.setVcofins(RUTypes.toBigDecimal(qtde.getVCOFINS()));
    } else if (source.getCOFINSNT() != null) {
      TNFe.InfNFe.Det.Imposto.COFINS.COFINSNT nt = source.getCOFINSNT();
      target.setCst(SEFAZEnums.valueOfXMLData(SEFAZ_CST_COFINS.class, nt.getCST()));
    } else if (source.getCOFINSOutr() != null) {
      TNFe.InfNFe.Det.Imposto.COFINS.COFINSOutr outr = source.getCOFINSOutr();
      target.setCst(SEFAZEnums.valueOfXMLData(SEFAZ_CST_COFINS.class, outr.getCST()));
      target.setVbc(RUTypes.toBigDecimal(outr.getVBC()));
      target.setPcofins(RUTypes.toBigDecimal(outr.getPCOFINS()));
      target.setQbcProd(RUTypes.toBigDecimal(outr.getQBCProd()));
      target.setValiqProd(RUTypes.toBigDecimal(outr.getVAliqProd()));
      target.setVcofins(RUTypes.toBigDecimal(outr.getVCOFINS()));
    }
    return target;
  }

  public static SEFAZEmitVO toVO(TNFe.InfNFe.Emit source, SEFAZInfNFeVO parent) {
    if (source == null) {
      return null;
    }
    SEFAZEmitVO target = new SEFAZEmitVO();
    target.setInfNFeVO(parent);
    target.setCnpj(source.getCNPJ());
    target.setCpf(source.getCPF());
    target.setXnome(source.getXNome());
    target.setXfant(source.getXFant());
    target.setIe(source.getIE());
    target.setIest(source.getIEST());
    target.setIm(source.getIM());
    target.setCnae(source.getCNAE());
    if (source.getCRT() != null) {
      target.setCrt(SEFAZEnums.valueOfXMLData(SEFAZ_CRT.class, source.getCRT()));
    }
    target.setEnderEmitVO(toVO(source.getEnderEmit(), target));
    return target;
  }

  public static TEnderEmi toJaxb(SEFAZEnderEmitVO source) {
    if (source == null) {
      return null;
    }
    TEnderEmi target = new TEnderEmi();
    target.setXLgr(source.getXlgr());
    target.setNro(source.getNro());
    target.setXCpl(source.getXcpl());
    target.setXBairro(source.getXbairro());
    target.setCMun(source.getCmun());
    target.setXMun(source.getXmun());
    if (source.getUf() != null) {
      target.setUF(TUfEmi.fromValue(source.getUf()));
    }
    target.setCEP(source.getCep());
    target.setCPais(source.getCpais());
    target.setXPais(source.getXpais());
    target.setFone(source.getFone());
    return target;
  }

  public static SEFAZEnderEmitVO toVO(TEnderEmi source, SEFAZEmitVO parent) {
    if (source == null) {
      return null;
    }
    SEFAZEnderEmitVO target = new SEFAZEnderEmitVO();
    target.setEmitVO(parent);
    target.setXlgr(source.getXLgr());
    target.setNro(source.getNro());
    target.setXcpl(source.getXCpl());
    target.setXbairro(source.getXBairro());
    target.setCmun(source.getCMun());
    target.setXmun(source.getXMun());
    if (source.getUF() != null) {
      target.setUf(source.getUF().value());
    }
    target.setCep(source.getCEP());
    target.setCpais(source.getCPais());
    target.setXpais(source.getXPais());
    target.setFone(source.getFone());
    return target;
  }

  public static TNFe.InfNFe.Transp toJaxb(SEFAZTranspVO source) {
    if (source == null) {
      return null;
    }
    TNFe.InfNFe.Transp target = new TNFe.InfNFe.Transp();
    if (source.getModFrete() != null) {
      target.setModFrete(source.getModFrete().getXmlData());
    }
    target.setTransporta(toJaxb(source.getTransportaVO()));
    target.setRetTransp(toJaxb(source.getRetTranspVO()));
    target.setVeicTransp(toJaxb(source.getVeicTranspVO()));
    if (source.getReboqueVO() != null) {
      for (SEFAZReboqueVO reboque : source.getReboqueVO()) {
        TVeiculo vehicle = toJaxb(reboque);
        if (vehicle != null) {
          target.getReboque().add(vehicle);
        }
      }
    }
    if (source.getVolVO() != null) {
      for (SEFAZVolVO volume : source.getVolVO()) {
        TNFe.InfNFe.Transp.Vol node = toJaxb(volume);
        if (node != null) {
          target.getVol().add(node);
        }
      }
    }
    target.setVagao(source.getVagao());
    target.setBalsa(source.getBalsa());
    return target;
  }

  public static SEFAZTranspVO toVO(TNFe.InfNFe.Transp source, SEFAZInfNFeVO parent) throws RFWException {
    if (source == null) {
      return null;
    }
    SEFAZTranspVO target = new SEFAZTranspVO();
    target.setInfNFeVO(parent);
    if (source.getModFrete() != null) {
      target.setModFrete(SEFAZEnums.valueOfXMLData(SEFAZEnums.SEFAZ_modFrete.class, source.getModFrete()));
    }
    target.setTransportaVO(toVO(source.getTransporta(), target));
    target.setRetTranspVO(toVO(source.getRetTransp(), target));
    target.setVeicTranspVO(toVO(source.getVeicTransp(), target, (SEFAZVeicTranspVO) null));
    if (source.getReboque() != null && !source.getReboque().isEmpty()) {
      List<SEFAZReboqueVO> reboques = new ArrayList<>(source.getReboque().size());
      for (TVeiculo reboque : source.getReboque()) {
        SEFAZReboqueVO item = toVO(reboque, target, (SEFAZReboqueVO) null);
        if (item != null) {
          reboques.add(item);
        }
      }
      target.setReboqueVO(reboques);
    }
    if (source.getVol() != null && !source.getVol().isEmpty()) {
      List<SEFAZVolVO> volumes = new ArrayList<>(source.getVol().size());
      for (TNFe.InfNFe.Transp.Vol vol : source.getVol()) {
        SEFAZVolVO item = toVO(vol, target);
        if (item != null) {
          volumes.add(item);
        }
      }
      target.setVolVO(volumes);
    }
    target.setVagao(source.getVagao());
    target.setBalsa(source.getBalsa());
    return target;
  }

  public static TNFe.InfNFe.Transp.Transporta toJaxb(SEFAZTransportaVO source) {
    if (source == null) {
      return null;
    }
    TNFe.InfNFe.Transp.Transporta target = new TNFe.InfNFe.Transp.Transporta();
    target.setCNPJ(source.getCnpj());
    target.setCPF(source.getCpf());
    target.setXNome(source.getXnome());
    target.setIE(source.getIe());
    target.setXEnder(source.getXender());
    target.setXMun(source.getXmun());
    if (source.getUf() != null) {
      target.setUF(TUf.fromValue(source.getUf()));
    }
    return target;
  }

  public static SEFAZTransportaVO toVO(TNFe.InfNFe.Transp.Transporta source, SEFAZTranspVO parent) {
    if (source == null) {
      return null;
    }
    SEFAZTransportaVO target = new SEFAZTransportaVO();
    target.setTranspVO(parent);
    target.setCnpj(source.getCNPJ());
    target.setCpf(source.getCPF());
    target.setXnome(source.getXNome());
    target.setIe(source.getIE());
    target.setXender(source.getXEnder());
    target.setXmun(source.getXMun());
    if (source.getUF() != null) {
      target.setUf(source.getUF().value());
    }
    return target;
  }

  public static TNFe.InfNFe.Transp.RetTransp toJaxb(SEFAZRetTranspVO source) {
    if (source == null) {
      return null;
    }
    TNFe.InfNFe.Transp.RetTransp target = new TNFe.InfNFe.Transp.RetTransp();
    target.setVServ(RUTypes.toString(source.getVserv()));
    target.setVBCRet(RUTypes.toString(source.getVbcret()));
    target.setPICMSRet(RUTypes.toString(source.getPicmsRet()));
    target.setVICMSRet(RUTypes.toString(source.getVicmsRet()));
    target.setCFOP(source.getCfop());
    target.setCMunFG(source.getCmunFg());
    return target;
  }

  public static SEFAZRetTranspVO toVO(TNFe.InfNFe.Transp.RetTransp source, SEFAZTranspVO parent) throws RFWException {
    if (source == null) {
      return null;
    }
    SEFAZRetTranspVO target = new SEFAZRetTranspVO();
    target.setTranspVO(parent);
    target.setVserv(RUTypes.toBigDecimal(source.getVServ()));
    target.setVbcret(RUTypes.toBigDecimal(source.getVBCRet()));
    target.setPicmsRet(RUTypes.toBigDecimal(source.getPICMSRet()));
    target.setVicmsRet(RUTypes.toBigDecimal(source.getVICMSRet()));
    target.setCfop(source.getCFOP());
    target.setCmunFg(source.getCMunFG());
    return target;
  }

  public static TVeiculo toJaxb(SEFAZVeicTranspVO source) {
    if (source == null) {
      return null;
    }
    TVeiculo target = new TVeiculo();
    target.setPlaca(source.getPlaca());
    if (source.getUf() != null) {
      target.setUF(TUf.fromValue(source.getUf()));
    }
    target.setRNTC(source.getRntc());
    return target;
  }

  public static TVeiculo toJaxb(SEFAZReboqueVO source) {
    if (source == null) {
      return null;
    }
    TVeiculo target = new TVeiculo();
    target.setPlaca(source.getPlaca());
    if (source.getUf() != null) {
      target.setUF(TUf.fromValue(source.getUf()));
    }
    target.setRNTC(source.getRntc());
    return target;
  }

  public static SEFAZVeicTranspVO toVO(TVeiculo source, SEFAZTranspVO parent, SEFAZVeicTranspVO marker) {
    if (source == null) {
      return null;
    }
    SEFAZVeicTranspVO target = new SEFAZVeicTranspVO();
    target.setTranspVO(parent);
    target.setPlaca(source.getPlaca());
    if (source.getUF() != null) {
      target.setUf(source.getUF().value());
    }
    target.setRntc(source.getRNTC());
    return target;
  }

  public static SEFAZReboqueVO toVO(TVeiculo source, SEFAZTranspVO parent, SEFAZReboqueVO marker) {
    if (source == null) {
      return null;
    }
    SEFAZReboqueVO target = new SEFAZReboqueVO();
    target.setTranspVO(parent);
    target.setPlaca(source.getPlaca());
    if (source.getUF() != null) {
      target.setUf(source.getUF().value());
    }
    target.setRntc(source.getRNTC());
    return target;
  }

  public static TNFe.InfNFe.Transp.Vol toJaxb(SEFAZVolVO source) {
    if (source == null) {
      return null;
    }
    TNFe.InfNFe.Transp.Vol target = new TNFe.InfNFe.Transp.Vol();
    target.setQVol(RUTypes.toString(source.getQvol()));
    target.setEsp(source.getEsp());
    target.setMarca(source.getMarca());
    target.setNVol(source.getNvol());
    target.setPesoL(RUTypes.toString(source.getPesoL()));
    target.setPesoB(RUTypes.toString(source.getPesoB()));
    if (source.getLacresVO() != null) {
      for (SEFAZLacresVO lacre : source.getLacresVO()) {
        TNFe.InfNFe.Transp.Vol.Lacres node = toJaxb(lacre);
        if (node != null) {
          target.getLacres().add(node);
        }
      }
    }
    return target;
  }

  public static SEFAZVolVO toVO(TNFe.InfNFe.Transp.Vol source, SEFAZTranspVO parent) throws RFWException {
    if (source == null) {
      return null;
    }
    SEFAZVolVO target = new SEFAZVolVO();
    target.setTranspVO(parent);
    target.setQvol(RUTypes.toBigDecimal(source.getQVol()));
    target.setEsp(source.getEsp());
    target.setMarca(source.getMarca());
    target.setNvol(source.getNVol());
    target.setPesoL(RUTypes.toBigDecimal(source.getPesoL()));
    target.setPesoB(RUTypes.toBigDecimal(source.getPesoB()));
    if (source.getLacres() != null && !source.getLacres().isEmpty()) {
      List<SEFAZLacresVO> lacres = new ArrayList<>(source.getLacres().size());
      for (TNFe.InfNFe.Transp.Vol.Lacres lacre : source.getLacres()) {
        SEFAZLacresVO item = toVO(lacre, target);
        if (item != null) {
          lacres.add(item);
        }
      }
      target.setLacresVO(lacres);
    }
    return target;
  }

  public static TNFe.InfNFe.Transp.Vol.Lacres toJaxb(SEFAZLacresVO source) {
    if (source == null) {
      return null;
    }
    TNFe.InfNFe.Transp.Vol.Lacres target = new TNFe.InfNFe.Transp.Vol.Lacres();
    target.setNLacre(source.getNlacre());
    return target;
  }

  public static SEFAZLacresVO toVO(TNFe.InfNFe.Transp.Vol.Lacres source, SEFAZVolVO parent) {
    if (source == null) {
      return null;
    }
    SEFAZLacresVO target = new SEFAZLacresVO();
    target.setVolVO(parent);
    target.setNlacre(source.getNLacre());
    return target;
  }

  private static String formatDateTime(LocalDateTime value) {
    return value != null ? RUTypes.formatToyyyy_MM_dd_T_HH_mm_ssXXX(value) : null;
  }

  private static LocalDateTime parseDateTime(String value) {
    if (value == null) {
      return null;
    }
    try {
      return SEFAZUtils.parseLocalDateTime(value);
    } catch (RFWException e) {
      throw new IllegalStateException("Falha ao converter data/hora da NF-e.", e);
    }
  }
}
