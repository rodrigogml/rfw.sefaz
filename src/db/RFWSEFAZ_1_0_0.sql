-- ----------------------------
-- Script para criação das tabelas 'sefaz_' oferecidas pelo RFW.SEFAZ
-- ----------------------------

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZNFeProcVO
CREATE TABLE `sefaz_nfeproc` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `versao` varchar(50) NOT NULL COMMENT 'Verso do XML nfeProc',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZEnviNFeVO
CREATE TABLE `sefaz_envinfe` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `versao` varchar(50) NOT NULL,
  `idlote` varchar(15) NOT NULL,
  `indsinc` varchar(50) ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE `sefaz_nfe` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_envinfe` bigint ,
  `idsefaz_nfeproc` bigint ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_nfe_sefaz_envinfe` FOREIGN KEY (`idsefaz_envinfe`) REFERENCES `sefaz_envinfe` (`id`),
  CONSTRAINT `fk_sefaz_nfe_sefaz_nfeproc` FOREIGN KEY (`idsefaz_nfeproc`) REFERENCES `sefaz_nfeproc` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZInfNFeVO
CREATE TABLE `sefaz_infnfe` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_nfe` bigint NOT NULL,
  `versao` varchar(50) NOT NULL COMMENT 'Verso do leiaute da NF-e',
  `idxml` char(47) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_infnfe_sefaz_nfe` FOREIGN KEY (`idsefaz_nfe`) REFERENCES `sefaz_nfe` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZIdeVO
CREATE TABLE `sefaz_ide` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_infnfe` bigint NOT NULL,
  `cuf` int ,
  `cnf` int ,
  `natop` varchar(60) ,
  `mod` varchar(50) ,
  `serie` int ,
  `nnf` int ,
  `dhemi` datetime ,
  `dhsaient` datetime ,
  `tpnf` varchar(50) ,
  `iddest` varchar(50) ,
  `cmunfg` int ,
  `tpimp` varchar(50) ,
  `tpemis` varchar(50) ,
  `cdv` tinyint ,
  `tpamb` varchar(50) ,
  `finnfe` varchar(50) ,
  `indfinal` varchar(50) ,
  `indpres` varchar(50) ,
  `indintermed` varchar(50) ,
  `procemi` varchar(50) ,
  `verproc` varchar(20) ,
  `dhcont` datetime ,
  `xjust` varchar(256) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_ide_sefaz_infnfe` FOREIGN KEY (`idsefaz_infnfe`) REFERENCES `sefaz_infnfe` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZNFRefVO
CREATE TABLE `sefaz_nfref` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_ide` bigint NOT NULL,
  `refnfe` char(44) ,
  `refcte` char(44) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_nfref_sefaz_ide` FOREIGN KEY (`idsefaz_ide`) REFERENCES `sefaz_ide` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZRefNFVO
CREATE TABLE `sefaz_refnf` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_nfref` bigint NOT NULL,
  `cuf` int NOT NULL,
  `aamm` char(4) NOT NULL,
  `cnpj` char(14) NOT NULL,
  `mod` varchar(50) ,
  `serie` int NOT NULL,
  `nnf` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_refnf_sefaz_nfref` FOREIGN KEY (`idsefaz_nfref`) REFERENCES `sefaz_nfref` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZRefNFPVO
CREATE TABLE `sefaz_refnfp` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_nfref` bigint NOT NULL,
  `cuf` int NOT NULL,
  `aamm` char(4) NOT NULL,
  `cnpj` char(14) ,
  `cpf` char(11) NOT NULL,
  `ie` varchar(20) NOT NULL,
  `mod` varchar(50) ,
  `serie` int NOT NULL,
  `nnf` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_refnfp_sefaz_nfref` FOREIGN KEY (`idsefaz_nfref`) REFERENCES `sefaz_nfref` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZRefECFVO
CREATE TABLE `sefaz_refecf` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_nfref` bigint NOT NULL,
  `mod` varchar(50) ,
  `necf` char(3) NOT NULL,
  `ncoo` char(6) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_refecf_sefaz_nfref` FOREIGN KEY (`idsefaz_nfref`) REFERENCES `sefaz_nfref` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZEmitVO
CREATE TABLE `sefaz_emit` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_infnfe` bigint NOT NULL,
  `cnpj` char(14) ,
  `cpf` char(11) ,
  `xnome` varchar(60) ,
  `xfant` varchar(60) ,
  `ie` varchar(14) ,
  `iest` varchar(14) ,
  `im` varchar(15) ,
  `cnae` varchar(8) ,
  `crt` varchar(50) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_emit_sefaz_infnfe` FOREIGN KEY (`idsefaz_infnfe`) REFERENCES `sefaz_infnfe` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZEnderEmitVO
CREATE TABLE `sefaz_enderemit` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_emitvo` bigint NOT NULL,
  `xlgr` varchar(60) ,
  `nro` varchar(60) ,
  `xcpl` varchar(60) ,
  `xbairro` varchar(60) ,
  `xmun` varchar(60) ,
  `uf` char(2) ,
  `cmun` char(7) ,
  `cep` char(8) ,
  `cpais` varchar(4) ,
  `fone` varchar(14) ,
  `xpais` varchar(60) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_enderemit_sefaz_emit` FOREIGN KEY (`idsefaz_emitvo`) REFERENCES `sefaz_emit` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZDetVO
CREATE TABLE `sefaz_det` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_infnfe` bigint NOT NULL,
  `nitem` int ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_det_sefaz_infnfe` FOREIGN KEY (`idsefaz_infnfe`) REFERENCES `sefaz_infnfe` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZProdVO
CREATE TABLE `sefaz_prod` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_det` bigint NOT NULL,
  `cprod` varchar(60) ,
  `cean` varchar(14) ,
  `xprod` varchar(120) ,
  `ncm` char(8) ,
  `nve` char(6) ,
  `cest` char(7) ,
  `indescala` char(1) ,
  `cnpjfab` char(14) ,
  `cbenef` varchar(8) ,
  `extipi` char(3) ,
  `cfop` char(4) ,
  `ucom` varchar(6) ,
  `qcom` decimal(15,4) ,
  `vuncom` decimal(21,10) ,
  `vprod` decimal(15,2) ,
  `ceantrib` varchar(14) ,
  `utrib` varchar(6) ,
  `qtrib` decimal(15,4) ,
  `vuntrib` decimal(21,10) ,
  `vfrete` decimal(15,2) ,
  `vseg` decimal(15,2) ,
  `vdesc` decimal(15,2) ,
  `voutro` decimal(15,2) ,
  `indtot` varchar(50) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_prod_sefaz_det` FOREIGN KEY (`idsefaz_det`) REFERENCES `sefaz_det` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZImpostoVO
CREATE TABLE `sefaz_imposto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_det` bigint NOT NULL,
  `vtottrib` decimal(15,2) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_imposto_sefaz_det` FOREIGN KEY (`idsefaz_det`) REFERENCES `sefaz_det` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZICMSVO
CREATE TABLE `sefaz_icms` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_imposto` bigint NOT NULL,
  `orig` varchar(50) ,
  `csosn` varchar(50) ,
  `modbc` varchar(50) ,
  `vbc` decimal(15,2) ,
  `predbc` decimal(15,4) ,
  `picms` decimal(9,4) ,
  `modbcst` varchar(50) ,
  `pmvast` decimal(9,4) ,
  `predbcst` decimal(9,4) ,
  `vbcst` decimal(15,2) ,
  `picmsst` decimal(9,4) ,
  `vicmsst` decimal(15,2) ,
  `vbcfcpst` decimal(15,2) ,
  `pfcpst` decimal(9,4) ,
  `vfcpst` decimal(15,2) ,
  `pcredsn` decimal(9,4) ,
  `vcredicmssn` decimal(15,2) ,
  `vbcstret` decimal(15,2) ,
  `pst` decimal(9,4) ,
  `vicmssubstituto` decimal(15,2) ,
  `vicmsstret` decimal(15,2) ,
  `vbcfcpstret` decimal(15,2) ,
  `pfcpstret` decimal(9,4) ,
  `vfcpstret` decimal(15,2) ,
  `predbcefet` decimal(9,4) ,
  `vbcefet` decimal(15,2) ,
  `picmsefet` decimal(9,4) ,
  `vicmsefet` decimal(15,2) ,
  `vfcp` decimal(15,2) ,
  `vicmsdeson` decimal(15,2) ,
  `motdesicms` varchar(50) ,
  `cst` varchar(50) ,
  `vicmsop` decimal(15,2) ,
  `pdif` decimal(9,4) ,
  `vicmsdif` decimal(15,2) ,
  `vicms` decimal(15,2) ,
  `vbcfcp` decimal(15,2) ,
  `pfcp` decimal(9,4) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_icms_sefaz_imposto` FOREIGN KEY (`idsefaz_imposto`) REFERENCES `sefaz_imposto` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZIPIVO
CREATE TABLE `sefaz_ipi` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_imposto` bigint NOT NULL,
  `cienq` varchar(5) ,
  `cnpjprod` char(14) ,
  `cselo` varchar(60) ,
  `qselo` decimal(15,0) ,
  `cenq` varchar(3) ,
  `cstipi` varchar(50) ,
  `vbcipi` decimal(15,2) ,
  `pipi` decimal(9,4) ,
  `qunidipi` decimal(15,4) ,
  `vunidipi` decimal(15,4) ,
  `vipi` decimal(15,2) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_ipi_sefaz_imposto` FOREIGN KEY (`idsefaz_imposto`) REFERENCES `sefaz_imposto` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZPISVO
CREATE TABLE `sefaz_pis` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_imposto` bigint NOT NULL,
  `cst` varchar(50) ,
  `vbc` decimal(15,2) ,
  `ppis` decimal(9,4) ,
  `vpis` decimal(15,2) ,
  `qbcprod` decimal(15,4) ,
  `valiqprod` decimal(15,4) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_pis_sefaz_imposto` FOREIGN KEY (`idsefaz_imposto`) REFERENCES `sefaz_imposto` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZCOFINSVO
CREATE TABLE `sefaz_cofins` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_imposto` bigint NOT NULL,
  `cst` varchar(50) ,
  `vbc` decimal(15,2) ,
  `pcofins` decimal(9,4) ,
  `vcofins` decimal(15,2) ,
  `qbcprod` decimal(15,4) ,
  `valiqprod` decimal(15,4) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_cofins_sefaz_imposto` FOREIGN KEY (`idsefaz_imposto`) REFERENCES `sefaz_imposto` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZICMSUFDestVO
CREATE TABLE `sefaz_icmsufdest` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_imposto` bigint NOT NULL,
  `vbcufdest` decimal(15,2) ,
  `vbcfcpifdest` decimal(15,2) ,
  `pfcpufdest` decimal(9,4) ,
  `picmsufdest` decimal(9,4) ,
  `picmsinter` decimal(9,4) ,
  `picmsinterpart` decimal(9,4) ,
  `vfcpufdest` decimal(15,2) ,
  `vicmsufdest` decimal(15,2) ,
  `vicmsufremet` decimal(15,2) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_icmsufdest_sefaz_imposto` FOREIGN KEY (`idsefaz_imposto`) REFERENCES `sefaz_imposto` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZTranspVO
CREATE TABLE `sefaz_transp` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_infnfe` bigint NOT NULL,
  `modfrete` varchar(50) ,
  `vagao` varchar(20) ,
  `balsa` varchar(20) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_transp_sefaz_infnfe` FOREIGN KEY (`idsefaz_infnfe`) REFERENCES `sefaz_infnfe` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZTransportaVO
CREATE TABLE `sefaz_transporta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_transp` bigint NOT NULL,
  `cnpj` char(14) ,
  `cpf` char(11) ,
  `xnome` varchar(60) ,
  `ie` varchar(20) ,
  `xender` varchar(60) ,
  `xmun` varchar(60) ,
  `uf` char(2) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_transporta_sefaz_transp` FOREIGN KEY (`idsefaz_transp`) REFERENCES `sefaz_transp` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZRetTranspVO
CREATE TABLE `sefaz_rettransp` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_transp` bigint NOT NULL,
  `vserv` decimal(15,2) ,
  `vbcret` decimal(15,2) ,
  `picmsret` decimal(9,4) ,
  `vicmsret` decimal(15,2) ,
  `cfop` char(4) ,
  `cmunfg` char(7) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_rettransp_sefaz_transp` FOREIGN KEY (`idsefaz_transp`) REFERENCES `sefaz_transp` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZVeicTranspVO
CREATE TABLE `sefaz_veictransp` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_transp` bigint NOT NULL,
  `placa` char(7) ,
  `uf` char(2) ,
  `rntc` varchar(20) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_veictransp_sefaz_transp` FOREIGN KEY (`idsefaz_transp`) REFERENCES `sefaz_transp` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZReboqueVO
CREATE TABLE `sefaz_reboque` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_transp` bigint NOT NULL,
  `placa` char(7) ,
  `uf` char(2) ,
  `rntc` varchar(20) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_reboque_sefaz_transp` FOREIGN KEY (`idsefaz_transp`) REFERENCES `sefaz_transp` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZVolVO
CREATE TABLE `sefaz_vol` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_transp` bigint NOT NULL,
  `qvol` decimal(15,0) ,
  `esp` varchar(60) ,
  `marca` varchar(60) ,
  `nvol` varchar(60) ,
  `pesol` decimal(15,3) ,
  `pesob` decimal(15,3) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_vol_sefaz_transp` FOREIGN KEY (`idsefaz_transp`) REFERENCES `sefaz_transp` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZLacresVO
CREATE TABLE `sefaz_lacres` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_vol` bigint NOT NULL,
  `nlacre` varchar(60) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_lacres_sefaz_vol` FOREIGN KEY (`idsefaz_vol`) REFERENCES `sefaz_vol` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZDestVO
CREATE TABLE `sefaz_dest` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_infnfe` bigint NOT NULL,
  `cnpj` char(14) ,
  `cpf` char(11) ,
  `idestrangeiro` varchar(20) ,
  `xnome` varchar(60) ,
  `indiedest` varchar(50) ,
  `ie` varchar(14) ,
  `isuf` varchar(9) ,
  `im` varchar(15) ,
  `email` varchar(60) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_dest_sefaz_infnfe` FOREIGN KEY (`idsefaz_infnfe`) REFERENCES `sefaz_infnfe` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZEnderDestVO
CREATE TABLE `sefaz_enderdest` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_dest` bigint NOT NULL,
  `xlgr` varchar(60) ,
  `nro` varchar(60) ,
  `xcpl` varchar(60) ,
  `xbairro` varchar(60) ,
  `cmun` char(7) ,
  `xmun` varchar(60) ,
  `uf` char(2) ,
  `cep` char(8) ,
  `cpais` varchar(4) ,
  `xpais` varchar(60) ,
  `fone` varchar(14) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_enderdest_sefaz_dest` FOREIGN KEY (`idsefaz_dest`) REFERENCES `sefaz_dest` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZTotalVO
CREATE TABLE `sefaz_total` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_infnfe` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_total_sefaz_infnfe` FOREIGN KEY (`idsefaz_infnfe`) REFERENCES `sefaz_infnfe` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZICMSTotVO
CREATE TABLE `sefaz_icmstot` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_total` bigint NOT NULL,
  `vbc` decimal(15,2) ,
  `vicms` decimal(15,2) ,
  `vicmsdeson` decimal(15,2) ,
  `vfcpufdest` decimal(15,2) ,
  `vicmsufdest` decimal(15,2) ,
  `vicmsufremet` decimal(15,2) ,
  `vfcp` decimal(15,2) ,
  `vbcst` decimal(15,2) ,
  `vst` decimal(15,2) ,
  `vfcpst` decimal(15,2) ,
  `vfcpstret` decimal(15,2) ,
  `vprod` decimal(15,2) ,
  `vfrete` decimal(15,2) ,
  `vseg` decimal(15,2) ,
  `vdesc` decimal(15,2) ,
  `vii` decimal(15,2) ,
  `vipi` decimal(15,2) ,
  `vipidevol` decimal(15,2) ,
  `vpis` decimal(15,2) ,
  `vcofins` decimal(15,2) ,
  `voutro` decimal(15,2) ,
  `vnf` decimal(15,2) ,
  `vtottrib` decimal(15,2) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_icmstot_sefaz_total` FOREIGN KEY (`idsefaz_total`) REFERENCES `sefaz_total` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZISSQNTotVO
CREATE TABLE `sefaz_issqntot` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_total` bigint NOT NULL,
  `vserv` decimal(15,2) ,
  `vbc` decimal(15,2) ,
  `viss` decimal(15,2) ,
  `vpis` decimal(15,2) ,
  `vcofins` decimal(15,2) ,
  `dcompet` date ,
  `vdeducao` decimal(15,2) ,
  `voutro` decimal(15,2) ,
  `vdescincond` decimal(15,2) ,
  `vdesccond` decimal(15,2) ,
  `vissret` decimal(15,2) ,
  `cregtrib` varchar(50) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_issqntot_sefaz_total` FOREIGN KEY (`idsefaz_total`) REFERENCES `sefaz_total` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZInfAdicVO
CREATE TABLE `sefaz_infadic` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_infnfe` bigint NOT NULL,
  `infadfisco` varchar(2000) ,
  `infcpl` varchar(5000) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_infadic_sefaz_infnfe` FOREIGN KEY (`idsefaz_infnfe`) REFERENCES `sefaz_infnfe` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZObsContVO
CREATE TABLE `sefaz_obscont` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_infadic` bigint NOT NULL,
  `xcampo` varchar(20) ,
  `xtexto` varchar(60) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_obscont_sefaz_infadic` FOREIGN KEY (`idsefaz_infadic`) REFERENCES `sefaz_infadic` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZObsFiscoVO
CREATE TABLE `sefaz_obsfisco` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_infadic` bigint NOT NULL,
  `xcampo` varchar(20) ,
  `xtexto` varchar(60) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_obsfisco_sefaz_infadic` FOREIGN KEY (`idsefaz_infadic`) REFERENCES `sefaz_infadic` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZProcRefVO
CREATE TABLE `sefaz_procref` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_infadic` bigint NOT NULL,
  `nproc` varchar(60) ,
  `indproc` varchar(50) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_procref_sefaz_infadic` FOREIGN KEY (`idsefaz_infadic`) REFERENCES `sefaz_infadic` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZCobrVO
CREATE TABLE `sefaz_cobr` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_infnfe` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_cobr_sefaz_infnfe` FOREIGN KEY (`idsefaz_infnfe`) REFERENCES `sefaz_infnfe` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZFatVO
CREATE TABLE `sefaz_fat` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_cobr` bigint NOT NULL,
  `nfat` varchar(60) ,
  `vorig` decimal(15,2) ,
  `vdesc` decimal(15,2) ,
  `vliq` decimal(15,2) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_fat_sefaz_cobr` FOREIGN KEY (`idsefaz_cobr`) REFERENCES `sefaz_cobr` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZDupVO
CREATE TABLE `sefaz_dup` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_cobr` bigint NOT NULL,
  `ndup` varchar(60) ,
  `dvenc` date ,
  `vdup` decimal(15,2) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_dup_sefaz_cobr` FOREIGN KEY (`idsefaz_cobr`) REFERENCES `sefaz_cobr` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZPagVO
CREATE TABLE `sefaz_pag` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_infnfe` bigint NOT NULL,
  `vtroco` decimal(15,2) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_pag_sefaz_infnfe` FOREIGN KEY (`idsefaz_infnfe`) REFERENCES `sefaz_infnfe` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZDetPagVO
CREATE TABLE `sefaz_detpag` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_pag` bigint NOT NULL,
  `indpag` varchar(50) ,
  `tpag` varchar(50) ,
  `vpag` decimal(15,2) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_detpag_sefaz_pag` FOREIGN KEY (`idsefaz_pag`) REFERENCES `sefaz_pag` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZCardVO
CREATE TABLE `sefaz_card` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_detpag` bigint NOT NULL,
  `tpintegra` varchar(50) ,
  `cnpj` char(14) ,
  `tband` varchar(50) ,
  `caut` varchar(20) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_card_sefaz_detpag` FOREIGN KEY (`idsefaz_detpag`) REFERENCES `sefaz_detpag` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZISSQNVO
CREATE TABLE `sefaz_issqn` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_imposto` bigint NOT NULL,
  `vbc` decimal(15,2) ,
  `valiq` decimal(9,4) ,
  `vissqn` decimal(15,2) ,
  `cmunfg` char(7) ,
  `clistserv` varchar(5) ,
  `vdeducao` decimal(15,2) ,
  `voutro` decimal(15,2) ,
  `vdescincond` decimal(15,2) ,
  `vdesccond` decimal(15,2) ,
  `vissret` decimal(15,2) ,
  `indiss` varchar(50) ,
  `cservico` varchar(20) ,
  `cmun` char(7) ,
  `cpais` char(4) ,
  `nprocesso` varchar(30) ,
  `indincentivo` varchar(50) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_issqn_sefaz_imposto` FOREIGN KEY (`idsefaz_imposto`) REFERENCES `sefaz_imposto` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZPISSTVO
CREATE TABLE `sefaz_pisst` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_imposto` bigint NOT NULL,
  `vbc` decimal(15,2) ,
  `ppis` decimal(9,4) ,
  `qbcprod` decimal(15,4) ,
  `valiqprod` decimal(15,4) ,
  `vpis` decimal(15,2) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_pisst_sefaz_imposto` FOREIGN KEY (`idsefaz_imposto`) REFERENCES `sefaz_imposto` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZCOFINSSTVO
CREATE TABLE `sefaz_cofinsst` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_imposto` bigint NOT NULL,
  `vbc` decimal(15,2) ,
  `pcofins` decimal(9,4) ,
  `qbcprod` decimal(15,4) ,
  `valiqprod` decimal(15,4) ,
  `vcofins` decimal(15,2) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_cofinsst_sefaz_imposto` FOREIGN KEY (`idsefaz_imposto`) REFERENCES `sefaz_imposto` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZICMSPartVO
CREATE TABLE `sefaz_icmspart` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_icms` bigint NOT NULL,
  `orig` varchar(50) ,
  `cst` varchar(50) ,
  `modbc` varchar(50) ,
  `vbc` decimal(15,2) ,
  `predbc` decimal(9,4) ,
  `picms` decimal(9,4) ,
  `modbcst` varchar(50) ,
  `pmvast` decimal(9,4) ,
  `predbcst` decimal(9,4) ,
  `vbcst` decimal(15,2) ,
  `picmsst` decimal(9,4) ,
  `vicmsst` decimal(15,2) ,
  `pbcop` decimal(9,4) ,
  `ufst` char(2) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_icmspart_sefaz_icms` FOREIGN KEY (`idsefaz_icms`) REFERENCES `sefaz_icms` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZICMSSTVO
CREATE TABLE `sefaz_icmsst` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_icms` bigint NOT NULL,
  `orig` varchar(50) ,
  `cst` varchar(50) ,
  `vbcstret` decimal(15,2) ,
  `pst` decimal(9,4) ,
  `vicmssubstituto` decimal(15,2) ,
  `vicmsstret` decimal(15,2) ,
  `vbcfcpstret` decimal(15,2) ,
  `pfcpstret` decimal(9,4) ,
  `vfcpstret` decimal(15,2) ,
  `vbcstdest` decimal(15,2) ,
  `vicmsstdest` decimal(15,2) ,
  `predbcefet` decimal(9,4) ,
  `vbcefet` decimal(15,2) ,
  `picmsefet` decimal(9,4) ,
  `vicmsefet` decimal(15,2) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_icmsst_sefaz_icms` FOREIGN KEY (`idsefaz_icms`) REFERENCES `sefaz_icms` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZEnviNFeVO
-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZRetEnviNFeVO
CREATE TABLE `sefaz_retenvinfe` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `versao` varchar(50) ,
  `tpamb` varchar(50) ,
  `veraplic` varchar(20) ,
  `cstat` int ,
  `xmotivo` varchar(255) ,
  `cuf` int ,
  `dhrecbto` datetime ,
  `nrec` bigint ,
  `tmed` decimal(15,4) ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZProtNFeVO
CREATE TABLE `sefaz_protnfe` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_retenvinfe` bigint NOT NULL,
  `versao` varchar(50) ,
  `tpamb` varchar(50) ,
  `veraplic` varchar(20) ,
  `chnfe` char(44) ,
  `dhrecbto` datetime ,
  `nprot` bigint ,
  `digval` varchar(28) ,
  `cstat` int ,
  `xmotivo` varchar(255) ,
  `cmsg` int ,
  `xmsg` varchar(200) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_protnfe_retenvinfe` FOREIGN KEY (`idsefaz_retenvinfe`) REFERENCES `sefaz_retenvinfe` (`id`)
) ENGINE=InnoDB;
