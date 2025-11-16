package br.eng.rodrigogml.rfw.sefaz.mapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.eng.rodrigogml.rfw.kernel.exceptions.RFWException;
import br.eng.rodrigogml.rfw.kernel.utils.RUTypes;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CRT;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CST_COFINS;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.SEFAZ_CST_PIS;
import br.eng.rodrigogml.rfw.sefaz.utils.SEFAZEnums.IndIEDestEnum;
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
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZDetVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZDestVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZEmitVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZEnderDestVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZEnderEmitVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZEnviNFeVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZImpostoVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZIdeVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZInfNFeVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZLacresVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZNFRefVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZNFeVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZPISVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZProdVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZRefECFVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZRefNFPVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZRefNFVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZReboqueVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZRetTranspVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZTransportaVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZTranspVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZVeicTranspVO;
import br.eng.rodrigogml.rfw.sefaz.vo.SEFAZVolVO;

import javax.xml.bind.JAXBElement;

import xsdobjects.enviNFe400.TEndereco;
import xsdobjects.enviNFe400.TEnviNFe;
import xsdobjects.enviNFe400.TEnderEmi;
import xsdobjects.enviNFe400.TNFe;
import xsdobjects.enviNFe400.TUf;
import xsdobjects.enviNFe400.TUfEmi;
import xsdobjects.enviNFe400.TVeiculo;

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
      target.getNFe().addAll(mapNFeListToJaxb(source.getNfeList()));
    }
    return target;
  }

  /**
   * Converte o {@link TEnviNFe} retornado/emitido para o VO equivalente.
   *
   * @param source objeto JAXB recebido/construido via SEFAZ.
   * @return {@link SEFAZEnviNFeVO} populado; {@code null} se {@code source} for {@code null}.
   */
  public static SEFAZEnviNFeVO toVO(TEnviNFe source) {
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
      target.setNfeList(mapNFeListToVo(source.getNFe(), target));
    }
    return target;
  }

  private static List<TNFe> mapNFeListToJaxb(List<SEFAZNFeVO> sourceList) {
    if (sourceList == null || sourceList.isEmpty()) {
      return new ArrayList<>();
    }
    List<TNFe> targetList = new ArrayList<>(sourceList.size());
    for (SEFAZNFeVO nfeVO : sourceList) {
      targetList.add(toJaxb(nfeVO));
    }
    return targetList;
  }

  private static List<SEFAZNFeVO> mapNFeListToVo(List<TNFe> sourceList, SEFAZEnviNFeVO parent) {
    if (sourceList == null || sourceList.isEmpty()) {
      return new ArrayList<>();
    }
    List<SEFAZNFeVO> targetList = new ArrayList<>(sourceList.size());
    for (TNFe nfe : sourceList) {
      targetList.add(toVO(nfe, parent));
    }
    return targetList;
  }

  private static TNFe toJaxb(SEFAZNFeVO nfeVO) {
    if (nfeVO == null) {
      return null;
    }
    TNFe target = new TNFe();
    target.setInfNFe(toJaxb(nfeVO.getInfNFeVO()));
    return target;
  }

  private static SEFAZNFeVO toVO(TNFe nfe, SEFAZEnviNFeVO parent) {
    if (nfe == null) {
      return null;
    }
    SEFAZNFeVO target = new SEFAZNFeVO();
    target.setInfNFeVO(toVO(nfe.getInfNFe(), target));
    return target;
  }

  private static TNFe.InfNFe toJaxb(SEFAZInfNFeVO source) {
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

  private static SEFAZInfNFeVO toVO(TNFe.InfNFe source, SEFAZNFeVO parent) {
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

  private static TNFe.InfNFe.Ide toJaxb(SEFAZIdeVO source) {
    if (source == null) {
      return null;
    }
    TNFe.InfNFe.Ide target = new TNFe.InfNFe.Ide();
    if (source.getCuf() != null) {
      target.setCUF(toPlainString(source.getCuf()));
    }
    if (source.getCnf() != null) {
      target.setCNF(toPlainString(source.getCnf()));
    }
    target.setNatOp(source.getNatOp());
    if (source.getMod() != null) {
      target.setMod(source.getMod().getXmlData());
    }
    if (source.getSerie() != null) {
      target.setSerie(toPlainString(source.getSerie()));
    }
    if (source.getNnf() != null) {
      target.setNNF(toPlainString(source.getNnf()));
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
      target.setCMunFG(toPlainString(source.getCmunFG()));
    }
    if (source.getTpImp() != null) {
      target.setTpImp(source.getTpImp().getXmlData());
    }
    if (source.getTpEmis() != null) {
      target.setTpEmis(source.getTpEmis().getXmlData());
    }
    if (source.getCdv() != null) {
      target.setCDV(toPlainString(source.getCdv()));
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
    if (source.getNfRefVO() != null) {
      TNFe.InfNFe.Ide.NFref nfref = toJaxb(source.getNfRefVO());
      if (nfref != null) {
        target.getNFref().add(nfref);
      }
    }
    return target;
  }

  private static SEFAZIdeVO toVO(TNFe.InfNFe.Ide source, SEFAZInfNFeVO parent) {
    if (source == null) {
      return null;
    }
    SEFAZIdeVO target = new SEFAZIdeVO();
    target.setInfNFeVO(parent);
    target.setCuf(toBigDecimal(source.getCUF()));
    target.setCnf(toBigDecimal(source.getCNF()));
    target.setNatOp(source.getNatOp());
    if (source.getMod() != null) {
      target.setMod(SEFAZEnums.valueOfXMLData(SEFAZ_mod.class, source.getMod()));
    }
    target.setSerie(toBigDecimal(source.getSerie()));
    target.setNnf(toBigDecimal(source.getNNF()));
    target.setDhEmi(parseDateTime(source.getDhEmi()));
    target.setDhSaiEnt(parseDateTime(source.getDhSaiEnt()));
    if (source.getTpNF() != null) {
      target.setTpNF(SEFAZEnums.valueOfXMLData(SEFAZ_tpNF.class, source.getTpNF()));
    }
    if (source.getIdDest() != null) {
      target.setIdDest(SEFAZEnums.valueOfXMLData(SEFAZ_idDest.class, source.getIdDest()));
    }
    target.setCmunFG(toBigDecimal(source.getCMunFG()));
    if (source.getTpImp() != null) {
      target.setTpImp(SEFAZEnums.valueOfXMLData(SEFAZ_tpImp.class, source.getTpImp()));
    }
    if (source.getTpEmis() != null) {
      target.setTpEmis(SEFAZEnums.valueOfXMLData(SEFAZ_tpEmis.class, source.getTpEmis()));
    }
    target.setCdv(toBigDecimal(source.getCDV()));
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
      target.setNfRefVO(toVO(source.getNFref().get(0), target));
    }
    return target;
  }

  private static TNFe.InfNFe.Ide.NFref toJaxb(SEFAZNFRefVO source) {
    if (source == null) {
      return null;
    }
    TNFe.InfNFe.Ide.NFref target = new TNFe.InfNFe.Ide.NFref();
    target.setRefNFe(source.getRefNFe());
    target.setRefCTe(source.getRefCte());
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

  private static SEFAZNFRefVO toVO(TNFe.InfNFe.Ide.NFref source, SEFAZIdeVO parent) {
    if (source == null) {
      return null;
    }
    SEFAZNFRefVO target = new SEFAZNFRefVO();
    target.setIdeVO(parent);
    target.setRefNFe(source.getRefNFe());
    target.setRefCte(source.getRefCTe());
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

  private static TNFe.InfNFe.Ide.NFref.RefNF toJaxb(SEFAZRefNFVO source) {
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

  private static SEFAZRefNFVO toVO(TNFe.InfNFe.Ide.NFref.RefNF source, SEFAZNFRefVO parent) {
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

  private static TNFe.InfNFe.Ide.NFref.RefNFP toJaxbP(SEFAZRefNFPVO source) {
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

  private static SEFAZRefNFPVO toVOP(TNFe.InfNFe.Ide.NFref.RefNFP source, SEFAZNFRefVO parent) {
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

  private static TNFe.InfNFe.Ide.NFref.RefECF toJaxb(SEFAZRefECFVO source) {
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

  private static SEFAZRefECFVO toVO(TNFe.InfNFe.Ide.NFref.RefECF source, SEFAZNFRefVO parent) {
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

  private static TNFe.InfNFe.Emit toJaxb(SEFAZEmitVO source) {
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

  private static TNFe.InfNFe.Dest toJaxb(SEFAZDestVO source) {
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

  private static SEFAZDestVO toVO(TNFe.InfNFe.Dest source, SEFAZInfNFeVO parent) {
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

  private static TEndereco toJaxb(SEFAZEnderDestVO source) {
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

  private static SEFAZEnderDestVO toVO(TEndereco source, SEFAZDestVO parent) {
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

  private static TNFe.InfNFe.Det toJaxb(SEFAZDetVO source) {
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

  private static SEFAZDetVO toVO(TNFe.InfNFe.Det source, SEFAZInfNFeVO parent) {
    if (source == null) {
      return null;
    }
    SEFAZDetVO target = new SEFAZDetVO();
    target.setInfNFeVO(parent);
    if (source.getNItem() != null) {
      target.setNitem(parseInteger(source.getNItem()));
    }
    target.setProdVO(toVO(source.getProd(), target));
    target.setImpostoVO(toVO(source.getImposto(), target));
    return target;
  }

  private static TNFe.InfNFe.Det.Prod toJaxb(SEFAZProdVO source) {
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
    target.setQCom(toPlainString(source.getQcom()));
    target.setVUnCom(toPlainString(source.getVunCom()));
    target.setVProd(toPlainString(source.getVprod()));
    target.setCEANTrib(source.getCeanTrib());
    target.setUTrib(source.getUtrib());
    target.setQTrib(toPlainString(source.getQtrib()));
    target.setVUnTrib(toPlainString(source.getVunTrib()));
    target.setVFrete(toPlainString(source.getVfrete()));
    target.setVSeg(toPlainString(source.getVseg()));
    target.setVDesc(toPlainString(source.getVdesc()));
    target.setVOutro(toPlainString(source.getVoutro()));
    if (source.getIndTot() != null) {
      target.setIndTot(source.getIndTot().getXmlData());
    }
    return target;
  }

  private static SEFAZProdVO toVO(TNFe.InfNFe.Det.Prod source, SEFAZDetVO parent) {
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
    target.setQcom(toBigDecimal(source.getQCom()));
    target.setVunCom(toBigDecimal(source.getVUnCom()));
    target.setVprod(toBigDecimal(source.getVProd()));
    target.setCeanTrib(source.getCEANTrib());
    target.setUtrib(source.getUTrib());
    target.setQtrib(toBigDecimal(source.getQTrib()));
    target.setVunTrib(toBigDecimal(source.getVUnTrib()));
    target.setVfrete(toBigDecimal(source.getVFrete()));
    target.setVseg(toBigDecimal(source.getVSeg()));
    target.setVdesc(toBigDecimal(source.getVDesc()));
    target.setVoutro(toBigDecimal(source.getVOutro()));
    if (source.getIndTot() != null) {
      target.setIndTot(SEFAZEnums.valueOfXMLData(SEFAZ_indTot.class, source.getIndTot()));
    }
    return target;
  }

  private static TNFe.InfNFe.Det.Imposto toJaxb(SEFAZImpostoVO source) {
    if (source == null) {
      return null;
    }
    TNFe.InfNFe.Det.Imposto target = new TNFe.InfNFe.Det.Imposto();
    if (source.getVtotTrib() != null) {
      target.getContent().add(SEFAZUtils.auxCreateJAXBElement("vTotTrib", toPlainString(source.getVtotTrib())));
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

  private static SEFAZImpostoVO toVO(TNFe.InfNFe.Det.Imposto source, SEFAZDetVO parent) {
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
          target.setVtotTrib(toBigDecimal((String) value));
        } else if ("PIS".equals(localName) && value instanceof TNFe.InfNFe.Det.Imposto.PIS) {
          target.setPisVO(toVO((TNFe.InfNFe.Det.Imposto.PIS) value, target));
        } else if ("COFINS".equals(localName) && value instanceof TNFe.InfNFe.Det.Imposto.COFINS) {
          target.setCofinsVO(toVO((TNFe.InfNFe.Det.Imposto.COFINS) value, target));
        }
      }
    }
    return target;
  }

  private static TNFe.InfNFe.Det.Imposto.PIS toJaxb(SEFAZPISVO source) {
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
        pisAliq.setVBC(toPlainString(source.getVbc()));
        pisAliq.setPPIS(toPlainString(source.getPpis()));
        pisAliq.setVPIS(toPlainString(source.getVpis()));
        target.setPISAliq(pisAliq);
        break;
      case CST_03_OPERACAO_TRIBUTAVEL_BC_QTDE_ALIQUOTA_POR_UNIDADE:
        TNFe.InfNFe.Det.Imposto.PIS.PISQtde pisQtde = new TNFe.InfNFe.Det.Imposto.PIS.PISQtde();
        pisQtde.setCST(cst);
        pisQtde.setQBCProd(toPlainString(source.getQbcProd()));
        pisQtde.setVAliqProd(toPlainString(source.getValiqProd()));
        pisQtde.setVPIS(toPlainString(source.getVpis()));
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
        pisOutr.setVBC(toPlainString(source.getVbc()));
        pisOutr.setPPIS(toPlainString(source.getPpis()));
        pisOutr.setQBCProd(toPlainString(source.getQbcProd()));
        pisOutr.setVAliqProd(toPlainString(source.getValiqProd()));
        pisOutr.setVPIS(toPlainString(source.getVpis()));
        target.setPISOutr(pisOutr);
        break;
    }
    return target;
  }

  private static SEFAZPISVO toVO(TNFe.InfNFe.Det.Imposto.PIS source, SEFAZImpostoVO parent) {
    if (source == null) {
      return null;
    }
    SEFAZPISVO target = new SEFAZPISVO();
    target.setImpostoVO(parent);
    if (source.getPISAliq() != null) {
      TNFe.InfNFe.Det.Imposto.PIS.PISAliq aliq = source.getPISAliq();
      target.setCst(SEFAZEnums.valueOfXMLData(SEFAZ_CST_PIS.class, aliq.getCST()));
      target.setVbc(toBigDecimal(aliq.getVBC()));
      target.setPpis(toBigDecimal(aliq.getPPIS()));
      target.setVpis(toBigDecimal(aliq.getVPIS()));
    } else if (source.getPISQtde() != null) {
      TNFe.InfNFe.Det.Imposto.PIS.PISQtde qtde = source.getPISQtde();
      target.setCst(SEFAZEnums.valueOfXMLData(SEFAZ_CST_PIS.class, qtde.getCST()));
      target.setQbcProd(toBigDecimal(qtde.getQBCProd()));
      target.setValiqProd(toBigDecimal(qtde.getVAliqProd()));
      target.setVpis(toBigDecimal(qtde.getVPIS()));
    } else if (source.getPISNT() != null) {
      TNFe.InfNFe.Det.Imposto.PIS.PISNT nt = source.getPISNT();
      target.setCst(SEFAZEnums.valueOfXMLData(SEFAZ_CST_PIS.class, nt.getCST()));
    } else if (source.getPISOutr() != null) {
      TNFe.InfNFe.Det.Imposto.PIS.PISOutr outr = source.getPISOutr();
      target.setCst(SEFAZEnums.valueOfXMLData(SEFAZ_CST_PIS.class, outr.getCST()));
      target.setVbc(toBigDecimal(outr.getVBC()));
      target.setPpis(toBigDecimal(outr.getPPIS()));
      target.setQbcProd(toBigDecimal(outr.getQBCProd()));
      target.setValiqProd(toBigDecimal(outr.getVAliqProd()));
      target.setVpis(toBigDecimal(outr.getVPIS()));
    }
    return target;
  }

  private static TNFe.InfNFe.Det.Imposto.COFINS toJaxb(SEFAZCOFINSVO source) {
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
        cofinsAliq.setVBC(toPlainString(source.getVbc()));
        cofinsAliq.setPCOFINS(toPlainString(source.getPcofins()));
        cofinsAliq.setVCOFINS(toPlainString(source.getVcofins()));
        target.setCOFINSAliq(cofinsAliq);
        break;
      case CST_03_OPERACAO_TRIBUTAVEL_BC_QTDE_ALIQUOTA_POR_UNIDADE:
        TNFe.InfNFe.Det.Imposto.COFINS.COFINSQtde cofinsQtde = new TNFe.InfNFe.Det.Imposto.COFINS.COFINSQtde();
        cofinsQtde.setCST(cst);
        cofinsQtde.setQBCProd(toPlainString(source.getQbcProd()));
        cofinsQtde.setVAliqProd(toPlainString(source.getValiqProd()));
        cofinsQtde.setVCOFINS(toPlainString(source.getVcofins()));
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
        cofinsOutr.setVBC(toPlainString(source.getVbc()));
        cofinsOutr.setPCOFINS(toPlainString(source.getPcofins()));
        cofinsOutr.setQBCProd(toPlainString(source.getQbcProd()));
        cofinsOutr.setVAliqProd(toPlainString(source.getValiqProd()));
        cofinsOutr.setVCOFINS(toPlainString(source.getVcofins()));
        target.setCOFINSOutr(cofinsOutr);
        break;
    }
    return target;
  }

  private static SEFAZCOFINSVO toVO(TNFe.InfNFe.Det.Imposto.COFINS source, SEFAZImpostoVO parent) {
    if (source == null) {
      return null;
    }
    SEFAZCOFINSVO target = new SEFAZCOFINSVO();
    target.setImpostoVO(parent);
    if (source.getCOFINSAliq() != null) {
      TNFe.InfNFe.Det.Imposto.COFINS.COFINSAliq aliq = source.getCOFINSAliq();
      target.setCst(SEFAZEnums.valueOfXMLData(SEFAZ_CST_COFINS.class, aliq.getCST()));
      target.setVbc(toBigDecimal(aliq.getVBC()));
      target.setPcofins(toBigDecimal(aliq.getPCOFINS()));
      target.setVcofins(toBigDecimal(aliq.getVCOFINS()));
    } else if (source.getCOFINSQtde() != null) {
      TNFe.InfNFe.Det.Imposto.COFINS.COFINSQtde qtde = source.getCOFINSQtde();
      target.setCst(SEFAZEnums.valueOfXMLData(SEFAZ_CST_COFINS.class, qtde.getCST()));
      target.setQbcProd(toBigDecimal(qtde.getQBCProd()));
      target.setValiqProd(toBigDecimal(qtde.getVAliqProd()));
      target.setVcofins(toBigDecimal(qtde.getVCOFINS()));
    } else if (source.getCOFINSNT() != null) {
      TNFe.InfNFe.Det.Imposto.COFINS.COFINSNT nt = source.getCOFINSNT();
      target.setCst(SEFAZEnums.valueOfXMLData(SEFAZ_CST_COFINS.class, nt.getCST()));
    } else if (source.getCOFINSOutr() != null) {
      TNFe.InfNFe.Det.Imposto.COFINS.COFINSOutr outr = source.getCOFINSOutr();
      target.setCst(SEFAZEnums.valueOfXMLData(SEFAZ_CST_COFINS.class, outr.getCST()));
      target.setVbc(toBigDecimal(outr.getVBC()));
      target.setPcofins(toBigDecimal(outr.getPCOFINS()));
      target.setQbcProd(toBigDecimal(outr.getQBCProd()));
      target.setValiqProd(toBigDecimal(outr.getVAliqProd()));
      target.setVcofins(toBigDecimal(outr.getVCOFINS()));
    }
    return target;
  }

  private static SEFAZEmitVO toVO(TNFe.InfNFe.Emit source, SEFAZInfNFeVO parent) {
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

  private static TEnderEmi toJaxb(SEFAZEnderEmitVO source) {
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

  private static SEFAZEnderEmitVO toVO(TEnderEmi source, SEFAZEmitVO parent) {
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


  private static TNFe.InfNFe.Transp toJaxb(SEFAZTranspVO source) {
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

  private static SEFAZTranspVO toVO(TNFe.InfNFe.Transp source, SEFAZInfNFeVO parent) {
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

  private static TNFe.InfNFe.Transp.Transporta toJaxb(SEFAZTransportaVO source) {
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

  private static SEFAZTransportaVO toVO(TNFe.InfNFe.Transp.Transporta source, SEFAZTranspVO parent) {
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

  private static TNFe.InfNFe.Transp.RetTransp toJaxb(SEFAZRetTranspVO source) {
    if (source == null) {
      return null;
    }
    TNFe.InfNFe.Transp.RetTransp target = new TNFe.InfNFe.Transp.RetTransp();
    target.setVServ(toPlainString(source.getVserv()));
    target.setVBCRet(toPlainString(source.getVbcret()));
    target.setPICMSRet(toPlainString(source.getPicmsRet()));
    target.setVICMSRet(toPlainString(source.getVicmsRet()));
    target.setCFOP(source.getCfop());
    target.setCMunFG(source.getCmunFg());
    return target;
  }

  private static SEFAZRetTranspVO toVO(TNFe.InfNFe.Transp.RetTransp source, SEFAZTranspVO parent) {
    if (source == null) {
      return null;
    }
    SEFAZRetTranspVO target = new SEFAZRetTranspVO();
    target.setTranspVO(parent);
    target.setVserv(toBigDecimal(source.getVServ()));
    target.setVbcret(toBigDecimal(source.getVBCRet()));
    target.setPicmsRet(toBigDecimal(source.getPICMSRet()));
    target.setVicmsRet(toBigDecimal(source.getVICMSRet()));
    target.setCfop(source.getCFOP());
    target.setCmunFg(source.getCMunFG());
    return target;
  }

  private static TVeiculo toJaxb(SEFAZVeicTranspVO source) {
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

  private static TVeiculo toJaxb(SEFAZReboqueVO source) {
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

  private static SEFAZVeicTranspVO toVO(TVeiculo source, SEFAZTranspVO parent, SEFAZVeicTranspVO marker) {
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

  private static SEFAZReboqueVO toVO(TVeiculo source, SEFAZTranspVO parent, SEFAZReboqueVO marker) {
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

  private static TNFe.InfNFe.Transp.Vol toJaxb(SEFAZVolVO source) {
    if (source == null) {
      return null;
    }
    TNFe.InfNFe.Transp.Vol target = new TNFe.InfNFe.Transp.Vol();
    target.setQVol(toPlainString(source.getQvol()));
    target.setEsp(source.getEsp());
    target.setMarca(source.getMarca());
    target.setNVol(source.getNvol());
    target.setPesoL(toPlainString(source.getPesoL()));
    target.setPesoB(toPlainString(source.getPesoB()));
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

  private static SEFAZVolVO toVO(TNFe.InfNFe.Transp.Vol source, SEFAZTranspVO parent) {
    if (source == null) {
      return null;
    }
    SEFAZVolVO target = new SEFAZVolVO();
    target.setTranspVO(parent);
    target.setQvol(toBigDecimal(source.getQVol()));
    target.setEsp(source.getEsp());
    target.setMarca(source.getMarca());
    target.setNvol(source.getNVol());
    target.setPesoL(toBigDecimal(source.getPesoL()));
    target.setPesoB(toBigDecimal(source.getPesoB()));
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

  private static TNFe.InfNFe.Transp.Vol.Lacres toJaxb(SEFAZLacresVO source) {
    if (source == null) {
      return null;
    }
    TNFe.InfNFe.Transp.Vol.Lacres target = new TNFe.InfNFe.Transp.Vol.Lacres();
    target.setNLacre(source.getNlacre());
    return target;
  }

  private static SEFAZLacresVO toVO(TNFe.InfNFe.Transp.Vol.Lacres source, SEFAZVolVO parent) {
    if (source == null) {
      return null;
    }
    SEFAZLacresVO target = new SEFAZLacresVO();
    target.setVolVO(parent);
    target.setNlacre(source.getNLacre());
    return target;
  }

  private static Integer parseInteger(String value) {
    if (value == null) {
      return null;
    }
    try {
      return Integer.valueOf(value);
    } catch (NumberFormatException e) {
      throw new IllegalStateException("Falha ao converter campo numerico da NF-e.", e);
    }
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

  private static String toPlainString(BigDecimal value) {
    return value != null ? value.toPlainString() : null;
  }

  private static BigDecimal toBigDecimal(String value) {
    return value == null ? null : new BigDecimal(value);
  }
}
