-- ----------------------------
-- Script para criação das tabelas 'sefaz_' oferecidas pelo RFW.SEFAZ
-- ----------------------------

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZNFeProcVO
CREATE TABLE `sefaz_nfeproc` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `versao` varchar(50) NOT NULL COMMENT 'Verso do XML nfeProc',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZNFeVO
CREATE TABLE `sefaz_nfe` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_nfeproc` bigint NOT NULL,
  PRIMARY KEY (`id`),
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
  `cuf` smallint DEFAULT NULL,
  `cnf` int DEFAULT NULL,
  `natop` varchar(60) DEFAULT NULL,
  `indpag` tinyint DEFAULT NULL,
  `mod` varchar(50) DEFAULT NULL,
  `serie` smallint DEFAULT NULL,
  `nnf` int DEFAULT NULL,
  `dhemi` datetime DEFAULT NULL,
  `dhsaient` datetime DEFAULT NULL,
  `tpnf` varchar(50) DEFAULT NULL,
  `iddest` varchar(50) DEFAULT NULL,
  `cmunfg` int DEFAULT NULL,
  `tpimp` varchar(50) DEFAULT NULL,
  `tpemis` varchar(50) DEFAULT NULL,
  `cdv` tinyint DEFAULT NULL,
  `tpamb` varchar(50) DEFAULT NULL,
  `finnfe` varchar(50) DEFAULT NULL,
  `indfinal` varchar(50) DEFAULT NULL,
  `indpres` varchar(50) DEFAULT NULL,
  `indintermed` varchar(50) DEFAULT NULL,
  `procemi` varchar(50) DEFAULT NULL,
  `verproc` varchar(20) DEFAULT NULL,
  `dhcont` datetime DEFAULT NULL,
  `xjust` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_ide_sefaz_infnfe` FOREIGN KEY (`idsefaz_infnfe`) REFERENCES `sefaz_infnfe` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZNFRefVO
CREATE TABLE `sefaz_nfref` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_ide` bigint NOT NULL,
  `refnfe` char(44) DEFAULT NULL,
  `refcte` char(44) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_nfref_sefaz_ide` FOREIGN KEY (`idsefaz_ide`) REFERENCES `sefaz_ide` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZRefNFVO
CREATE TABLE `sefaz_refnf` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_nfref` bigint NOT NULL,
  `cuf` char(2) NOT NULL,
  `aamm` char(4) NOT NULL,
  `cnpj` char(14) NOT NULL,
  `mod` varchar(50) DEFAULT NULL,
  `serie` varchar(255) NOT NULL,
  `nnf` varchar(9) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_refnf_sefaz_nfref` FOREIGN KEY (`idsefaz_nfref`) REFERENCES `sefaz_nfref` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZRefNFPVO
CREATE TABLE `sefaz_refnfp` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_nfref` bigint NOT NULL,
  `cuf` char(2) NOT NULL,
  `aamm` char(4) NOT NULL,
  `cnpj` char(14) DEFAULT NULL,
  `cpf` char(11) NOT NULL,
  `ie` varchar(20) NOT NULL,
  `mod` varchar(50) DEFAULT NULL,
  `serie` varchar(255) NOT NULL,
  `nnf` varchar(9) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_refnfp_sefaz_nfref` FOREIGN KEY (`idsefaz_nfref`) REFERENCES `sefaz_nfref` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZRefECFVO
CREATE TABLE `sefaz_refecf` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_nfref` bigint NOT NULL,
  `mod` varchar(50) DEFAULT NULL,
  `necf` char(3) NOT NULL,
  `ncoo` char(6) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_refecf_sefaz_nfref` FOREIGN KEY (`idsefaz_nfref`) REFERENCES `sefaz_nfref` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZEmitVO
CREATE TABLE `sefaz_emit` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_infnfe` bigint NOT NULL,
  `cnpj` char(14) DEFAULT NULL,
  `cpf` char(11) DEFAULT NULL,
  `xnome` varchar(60) DEFAULT NULL,
  `xfant` varchar(60) DEFAULT NULL,
  `ie` varchar(14) DEFAULT NULL,
  `iest` varchar(14) DEFAULT NULL,
  `im` varchar(15) DEFAULT NULL,
  `cnae` varchar(8) DEFAULT NULL,
  `crt` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_emit_sefaz_infnfe` FOREIGN KEY (`idsefaz_infnfe`) REFERENCES `sefaz_infnfe` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZEnderEmitVO
CREATE TABLE `sefaz_enderemit` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_emitvo` bigint NOT NULL,
  `xlgr` varchar(60) DEFAULT NULL,
  `nro` varchar(60) DEFAULT NULL,
  `xcpl` varchar(60) DEFAULT NULL,
  `xbairro` varchar(60) DEFAULT NULL,
  `xmun` varchar(60) DEFAULT NULL,
  `uf` char(2) DEFAULT NULL,
  `cmun` char(7) DEFAULT NULL,
  `cep` char(8) DEFAULT NULL,
  `cpais` varchar(4) DEFAULT NULL,
  `fone` varchar(14) DEFAULT NULL,
  `xpais` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_enderemit_sefaz_emit` FOREIGN KEY (`idsefaz_emitvo`) REFERENCES `sefaz_emit` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZDetVO
CREATE TABLE `sefaz_det` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_infnfe` bigint NOT NULL,
  `nitem` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_det_sefaz_infnfe` FOREIGN KEY (`idsefaz_infnfe`) REFERENCES `sefaz_infnfe` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZProdVO
CREATE TABLE `sefaz_prod` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_det` bigint NOT NULL,
  `cprod` varchar(60) DEFAULT NULL,
  `cean` varchar(14) DEFAULT NULL,
  `xprod` varchar(120) DEFAULT NULL,
  `ncm` char(8) DEFAULT NULL,
  `nve` char(6) DEFAULT NULL,
  `cest` char(7) DEFAULT NULL,
  `indescala` char(1) DEFAULT NULL,
  `cnpjfab` char(14) DEFAULT NULL,
  `cbenef` varchar(8) DEFAULT NULL,
  `extipi` char(3) DEFAULT NULL,
  `cfop` char(4) DEFAULT NULL,
  `ucom` varchar(6) DEFAULT NULL,
  `qcom` decimal(15,4) DEFAULT NULL,
  `vuncom` decimal(21,10) DEFAULT NULL,
  `vprod` decimal(15,2) DEFAULT NULL,
  `ceantrib` varchar(14) DEFAULT NULL,
  `utrib` varchar(6) DEFAULT NULL,
  `qtrib` decimal(15,4) DEFAULT NULL,
  `vuntrib` decimal(21,10) DEFAULT NULL,
  `vfrete` decimal(15,2) DEFAULT NULL,
  `vseg` decimal(15,2) DEFAULT NULL,
  `vdesc` decimal(15,2) DEFAULT NULL,
  `voutro` decimal(15,2) DEFAULT NULL,
  `indtot` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_prod_sefaz_det` FOREIGN KEY (`idsefaz_det`) REFERENCES `sefaz_det` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZImpostoVO
CREATE TABLE `sefaz_imposto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_det` bigint NOT NULL,
  `vtottrib` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_imposto_sefaz_det` FOREIGN KEY (`idsefaz_det`) REFERENCES `sefaz_det` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZICMSVO
CREATE TABLE `sefaz_icms` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_imposto` bigint NOT NULL,
  `orig` varchar(50) DEFAULT NULL,
  `csosn` varchar(50) DEFAULT NULL,
  `modbc` varchar(50) DEFAULT NULL,
  `vbc` decimal(15,2) DEFAULT NULL,
  `predbc` decimal(15,4) DEFAULT NULL,
  `picms` decimal(9,4) DEFAULT NULL,
  `modbcst` varchar(50) DEFAULT NULL,
  `pmvast` decimal(9,4) DEFAULT NULL,
  `predbcst` decimal(9,4) DEFAULT NULL,
  `vbcst` decimal(15,2) DEFAULT NULL,
  `picmsst` decimal(9,4) DEFAULT NULL,
  `vicmsst` decimal(15,2) DEFAULT NULL,
  `vbcfcpst` decimal(15,2) DEFAULT NULL,
  `pfcpst` decimal(9,4) DEFAULT NULL,
  `vfcpst` decimal(15,2) DEFAULT NULL,
  `pcredsn` decimal(9,4) DEFAULT NULL,
  `vcredicmssn` decimal(15,2) DEFAULT NULL,
  `vbcstret` decimal(15,2) DEFAULT NULL,
  `pst` decimal(9,4) DEFAULT NULL,
  `vicmssubstituto` decimal(15,2) DEFAULT NULL,
  `vicmsstret` decimal(15,2) DEFAULT NULL,
  `vbcfcpstret` decimal(15,2) DEFAULT NULL,
  `pfcpstret` decimal(9,4) DEFAULT NULL,
  `vfcpstret` decimal(15,2) DEFAULT NULL,
  `predbcefet` decimal(9,4) DEFAULT NULL,
  `vbcefet` decimal(15,2) DEFAULT NULL,
  `picmsefet` decimal(9,4) DEFAULT NULL,
  `vicmsefet` decimal(15,2) DEFAULT NULL,
  `vfcp` decimal(15,2) DEFAULT NULL,
  `vicmsdeson` decimal(15,2) DEFAULT NULL,
  `motdesicms` varchar(50) DEFAULT NULL,
  `cst` varchar(50) DEFAULT NULL,
  `vicmsop` decimal(15,2) DEFAULT NULL,
  `pdif` decimal(9,4) DEFAULT NULL,
  `vicmsdif` decimal(15,2) DEFAULT NULL,
  `vicms` decimal(15,2) DEFAULT NULL,
  `vbcfcp` decimal(15,2) DEFAULT NULL,
  `pfcp` decimal(9,4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_icms_sefaz_imposto` FOREIGN KEY (`idsefaz_imposto`) REFERENCES `sefaz_imposto` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZIPIVO
CREATE TABLE `sefaz_ipi` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_imposto` bigint NOT NULL,
  `cienq` varchar(5) DEFAULT NULL,
  `cnpjprod` char(14) DEFAULT NULL,
  `cselo` varchar(60) DEFAULT NULL,
  `qselo` decimal(15,0) DEFAULT NULL,
  `cenq` varchar(3) DEFAULT NULL,
  `cstipi` varchar(50) DEFAULT NULL,
  `vbcipi` decimal(15,2) DEFAULT NULL,
  `pipi` decimal(9,4) DEFAULT NULL,
  `qunidipi` decimal(15,4) DEFAULT NULL,
  `vunidipi` decimal(15,4) DEFAULT NULL,
  `vipi` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_ipi_sefaz_imposto` FOREIGN KEY (`idsefaz_imposto`) REFERENCES `sefaz_imposto` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZPISVO
CREATE TABLE `sefaz_pis` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_imposto` bigint NOT NULL,
  `cst` varchar(50) DEFAULT NULL,
  `vbc` decimal(15,2) DEFAULT NULL,
  `ppis` decimal(9,4) DEFAULT NULL,
  `vpis` decimal(15,2) DEFAULT NULL,
  `qbcprod` decimal(15,4) DEFAULT NULL,
  `valiqprod` decimal(15,4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_pis_sefaz_imposto` FOREIGN KEY (`idsefaz_imposto`) REFERENCES `sefaz_imposto` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZCOFINSVO
CREATE TABLE `sefaz_cofins` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_imposto` bigint NOT NULL,
  `cst` varchar(50) DEFAULT NULL,
  `vbc` decimal(15,2) DEFAULT NULL,
  `pcofins` decimal(9,4) DEFAULT NULL,
  `vcofins` decimal(15,2) DEFAULT NULL,
  `qbcprod` decimal(15,4) DEFAULT NULL,
  `valiqprod` decimal(15,4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_cofins_sefaz_imposto` FOREIGN KEY (`idsefaz_imposto`) REFERENCES `sefaz_imposto` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZICMSUFDestVO
CREATE TABLE `sefaz_icmsufdest` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_imposto` bigint NOT NULL,
  `vbcufdest` decimal(15,2) DEFAULT NULL,
  `vbcfcpifdest` decimal(15,2) DEFAULT NULL,
  `pfcpufdest` decimal(9,4) DEFAULT NULL,
  `picmsufdest` decimal(9,4) DEFAULT NULL,
  `picmsinter` decimal(9,4) DEFAULT NULL,
  `picmsinterpart` decimal(9,4) DEFAULT NULL,
  `vfcpufdest` decimal(15,2) DEFAULT NULL,
  `vicmsufdest` decimal(15,2) DEFAULT NULL,
  `vicmsufremet` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_icmsufdest_sefaz_imposto` FOREIGN KEY (`idsefaz_imposto`) REFERENCES `sefaz_imposto` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZTranspVO
CREATE TABLE `sefaz_transp` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_infnfe` bigint NOT NULL,
  `modfrete` varchar(50) DEFAULT NULL,
  `vagao` varchar(20) DEFAULT NULL,
  `balsa` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_transp_sefaz_infnfe` FOREIGN KEY (`idsefaz_infnfe`) REFERENCES `sefaz_infnfe` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZTransportaVO
CREATE TABLE `sefaz_transporta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_transp` bigint NOT NULL,
  `cnpj` char(14) DEFAULT NULL,
  `cpf` char(11) DEFAULT NULL,
  `xnome` varchar(60) DEFAULT NULL,
  `ie` varchar(20) DEFAULT NULL,
  `xender` varchar(60) DEFAULT NULL,
  `xmun` varchar(60) DEFAULT NULL,
  `uf` char(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_transporta_sefaz_transp` FOREIGN KEY (`idsefaz_transp`) REFERENCES `sefaz_transp` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZRetTranspVO
CREATE TABLE `sefaz_rettransp` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_transp` bigint NOT NULL,
  `vserv` decimal(15,2) DEFAULT NULL,
  `vbcret` decimal(15,2) DEFAULT NULL,
  `picmsret` decimal(9,4) DEFAULT NULL,
  `vicmsret` decimal(15,2) DEFAULT NULL,
  `cfop` char(4) DEFAULT NULL,
  `cmunfg` char(7) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_rettransp_sefaz_transp` FOREIGN KEY (`idsefaz_transp`) REFERENCES `sefaz_transp` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZVeicTranspVO
CREATE TABLE `sefaz_veictransp` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_transp` bigint NOT NULL,
  `placa` char(7) DEFAULT NULL,
  `uf` char(2) DEFAULT NULL,
  `rntc` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_veictransp_sefaz_transp` FOREIGN KEY (`idsefaz_transp`) REFERENCES `sefaz_transp` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZReboqueVO
CREATE TABLE `sefaz_reboque` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_transp` bigint NOT NULL,
  `placa` char(7) DEFAULT NULL,
  `uf` char(2) DEFAULT NULL,
  `rntc` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_reboque_sefaz_transp` FOREIGN KEY (`idsefaz_transp`) REFERENCES `sefaz_transp` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZVolVO
CREATE TABLE `sefaz_vol` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_transp` bigint NOT NULL,
  `qvol` decimal(15,0) DEFAULT NULL,
  `esp` varchar(60) DEFAULT NULL,
  `marca` varchar(60) DEFAULT NULL,
  `nvol` varchar(60) DEFAULT NULL,
  `pesol` decimal(15,3) DEFAULT NULL,
  `pesob` decimal(15,3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_vol_sefaz_transp` FOREIGN KEY (`idsefaz_transp`) REFERENCES `sefaz_transp` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZLacresVO
CREATE TABLE `sefaz_lacres` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_vol` bigint NOT NULL,
  `nlacre` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_lacres_sefaz_vol` FOREIGN KEY (`idsefaz_vol`) REFERENCES `sefaz_vol` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZDestVO
CREATE TABLE `sefaz_dest` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_infnfe` bigint NOT NULL,
  `cnpj` char(14) DEFAULT NULL,
  `cpf` char(11) DEFAULT NULL,
  `idestrangeiro` varchar(20) DEFAULT NULL,
  `xnome` varchar(60) DEFAULT NULL,
  `indiedest` varchar(50) DEFAULT NULL,
  `ie` varchar(14) DEFAULT NULL,
  `isuf` varchar(9) DEFAULT NULL,
  `im` varchar(15) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_dest_sefaz_infnfe` FOREIGN KEY (`idsefaz_infnfe`) REFERENCES `sefaz_infnfe` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZEnderDestVO
CREATE TABLE `sefaz_enderdest` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_dest` bigint NOT NULL,
  `xlgr` varchar(60) DEFAULT NULL,
  `nro` varchar(60) DEFAULT NULL,
  `xcpl` varchar(60) DEFAULT NULL,
  `xbairro` varchar(60) DEFAULT NULL,
  `cmun` char(7) DEFAULT NULL,
  `xmun` varchar(60) DEFAULT NULL,
  `uf` char(2) DEFAULT NULL,
  `cep` char(8) DEFAULT NULL,
  `cpais` varchar(4) DEFAULT NULL,
  `xpais` varchar(60) DEFAULT NULL,
  `fone` varchar(14) DEFAULT NULL,
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
  `vbc` decimal(15,2) DEFAULT NULL,
  `vicms` decimal(15,2) DEFAULT NULL,
  `vicmsdeson` decimal(15,2) DEFAULT NULL,
  `vfcpufdest` decimal(15,2) DEFAULT NULL,
  `vicmsufdest` decimal(15,2) DEFAULT NULL,
  `vicmsufremet` decimal(15,2) DEFAULT NULL,
  `vfcp` decimal(15,2) DEFAULT NULL,
  `vbcst` decimal(15,2) DEFAULT NULL,
  `vst` decimal(15,2) DEFAULT NULL,
  `vfcpst` decimal(15,2) DEFAULT NULL,
  `vfcpstret` decimal(15,2) DEFAULT NULL,
  `vprod` decimal(15,2) DEFAULT NULL,
  `vfrete` decimal(15,2) DEFAULT NULL,
  `vseg` decimal(15,2) DEFAULT NULL,
  `vdesc` decimal(15,2) DEFAULT NULL,
  `vii` decimal(15,2) DEFAULT NULL,
  `vipi` decimal(15,2) DEFAULT NULL,
  `vipidevol` decimal(15,2) DEFAULT NULL,
  `vpis` decimal(15,2) DEFAULT NULL,
  `vcofins` decimal(15,2) DEFAULT NULL,
  `voutro` decimal(15,2) DEFAULT NULL,
  `vnf` decimal(15,2) DEFAULT NULL,
  `vtottrib` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_icmstot_sefaz_total` FOREIGN KEY (`idsefaz_total`) REFERENCES `sefaz_total` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZISSQNTotVO
CREATE TABLE `sefaz_issqntot` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_total` bigint NOT NULL,
  `vserv` decimal(15,2) DEFAULT NULL,
  `vbc` decimal(15,2) DEFAULT NULL,
  `viss` decimal(15,2) DEFAULT NULL,
  `vpis` decimal(15,2) DEFAULT NULL,
  `vcofins` decimal(15,2) DEFAULT NULL,
  `dcompet` date DEFAULT NULL,
  `vdeducao` decimal(15,2) DEFAULT NULL,
  `voutro` decimal(15,2) DEFAULT NULL,
  `vdescincond` decimal(15,2) DEFAULT NULL,
  `vdesccond` decimal(15,2) DEFAULT NULL,
  `vissret` decimal(15,2) DEFAULT NULL,
  `cregtrib` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_issqntot_sefaz_total` FOREIGN KEY (`idsefaz_total`) REFERENCES `sefaz_total` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZInfAdicVO
CREATE TABLE `sefaz_infadic` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_infnfe` bigint NOT NULL,
  `infadfisco` varchar(2000) DEFAULT NULL,
  `infcpl` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_infadic_sefaz_infnfe` FOREIGN KEY (`idsefaz_infnfe`) REFERENCES `sefaz_infnfe` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZObsContVO
CREATE TABLE `sefaz_obscont` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_infadic` bigint NOT NULL,
  `xcampo` varchar(20) DEFAULT NULL,
  `xtexto` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_obscont_sefaz_infadic` FOREIGN KEY (`idsefaz_infadic`) REFERENCES `sefaz_infadic` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZObsFiscoVO
CREATE TABLE `sefaz_obsfisco` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_infadic` bigint NOT NULL,
  `xcampo` varchar(20) DEFAULT NULL,
  `xtexto` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_obsfisco_sefaz_infadic` FOREIGN KEY (`idsefaz_infadic`) REFERENCES `sefaz_infadic` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZProcRefVO
CREATE TABLE `sefaz_procref` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_infadic` bigint NOT NULL,
  `nproc` varchar(60) DEFAULT NULL,
  `indproc` varchar(50) DEFAULT NULL,
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
  `nfat` varchar(60) DEFAULT NULL,
  `vorig` decimal(15,2) DEFAULT NULL,
  `vdesc` decimal(15,2) DEFAULT NULL,
  `vliq` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_fat_sefaz_cobr` FOREIGN KEY (`idsefaz_cobr`) REFERENCES `sefaz_cobr` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZDupVO
CREATE TABLE `sefaz_dup` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_cobr` bigint NOT NULL,
  `ndup` varchar(60) DEFAULT NULL,
  `dvenc` date DEFAULT NULL,
  `vdup` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_dup_sefaz_cobr` FOREIGN KEY (`idsefaz_cobr`) REFERENCES `sefaz_cobr` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZPagVO
CREATE TABLE `sefaz_pag` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_infnfe` bigint NOT NULL,
  `vtroco` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_pag_sefaz_infnfe` FOREIGN KEY (`idsefaz_infnfe`) REFERENCES `sefaz_infnfe` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZDetPagVO
CREATE TABLE `sefaz_detpag` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_pag` bigint NOT NULL,
  `indpag` varchar(50) DEFAULT NULL,
  `tpag` varchar(50) DEFAULT NULL,
  `vpag` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_detpag_sefaz_pag` FOREIGN KEY (`idsefaz_pag`) REFERENCES `sefaz_pag` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZCardVO
CREATE TABLE `sefaz_card` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_detpag` bigint NOT NULL,
  `tpintegra` varchar(50) DEFAULT NULL,
  `cnpj` char(14) DEFAULT NULL,
  `tband` varchar(50) DEFAULT NULL,
  `caut` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_card_sefaz_detpag` FOREIGN KEY (`idsefaz_detpag`) REFERENCES `sefaz_detpag` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZISSQNVO
CREATE TABLE `sefaz_issqn` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_imposto` bigint NOT NULL,
  `vbc` decimal(15,2) DEFAULT NULL,
  `valiq` decimal(9,4) DEFAULT NULL,
  `vissqn` decimal(15,2) DEFAULT NULL,
  `cmunfg` char(7) DEFAULT NULL,
  `clistserv` varchar(5) DEFAULT NULL,
  `vdeducao` decimal(15,2) DEFAULT NULL,
  `voutro` decimal(15,2) DEFAULT NULL,
  `vdescincond` decimal(15,2) DEFAULT NULL,
  `vdesccond` decimal(15,2) DEFAULT NULL,
  `vissret` decimal(15,2) DEFAULT NULL,
  `indiss` varchar(50) DEFAULT NULL,
  `cservico` varchar(20) DEFAULT NULL,
  `cmun` char(7) DEFAULT NULL,
  `cpais` char(4) DEFAULT NULL,
  `nprocesso` varchar(30) DEFAULT NULL,
  `indincentivo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_issqn_sefaz_imposto` FOREIGN KEY (`idsefaz_imposto`) REFERENCES `sefaz_imposto` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZPISSTVO
CREATE TABLE `sefaz_pisst` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_imposto` bigint NOT NULL,
  `vbc` decimal(15,2) DEFAULT NULL,
  `ppis` decimal(9,4) DEFAULT NULL,
  `qbcprod` decimal(15,4) DEFAULT NULL,
  `valiqprod` decimal(15,4) DEFAULT NULL,
  `vpis` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_pisst_sefaz_imposto` FOREIGN KEY (`idsefaz_imposto`) REFERENCES `sefaz_imposto` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZCOFINSSTVO
CREATE TABLE `sefaz_cofinsst` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_imposto` bigint NOT NULL,
  `vbc` decimal(15,2) DEFAULT NULL,
  `pcofins` decimal(9,4) DEFAULT NULL,
  `qbcprod` decimal(15,4) DEFAULT NULL,
  `valiqprod` decimal(15,4) DEFAULT NULL,
  `vcofins` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_cofinsst_sefaz_imposto` FOREIGN KEY (`idsefaz_imposto`) REFERENCES `sefaz_imposto` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZICMSPartVO
CREATE TABLE `sefaz_icmspart` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_icms` bigint NOT NULL,
  `orig` varchar(50) DEFAULT NULL,
  `cst` varchar(50) DEFAULT NULL,
  `modbc` varchar(50) DEFAULT NULL,
  `vbc` decimal(15,2) DEFAULT NULL,
  `predbc` decimal(9,4) DEFAULT NULL,
  `picms` decimal(9,4) DEFAULT NULL,
  `modbcst` varchar(50) DEFAULT NULL,
  `pmvast` decimal(9,4) DEFAULT NULL,
  `predbcst` decimal(9,4) DEFAULT NULL,
  `vbcst` decimal(15,2) DEFAULT NULL,
  `picmsst` decimal(9,4) DEFAULT NULL,
  `vicmsst` decimal(15,2) DEFAULT NULL,
  `pbcop` decimal(9,4) DEFAULT NULL,
  `ufst` char(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_icmspart_sefaz_icms` FOREIGN KEY (`idsefaz_icms`) REFERENCES `sefaz_icms` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZICMSSTVO
CREATE TABLE `sefaz_icmsst` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_icms` bigint NOT NULL,
  `orig` varchar(50) DEFAULT NULL,
  `cst` varchar(50) DEFAULT NULL,
  `vbcstret` decimal(15,2) DEFAULT NULL,
  `pst` decimal(9,4) DEFAULT NULL,
  `vicmssubstituto` decimal(15,2) DEFAULT NULL,
  `vicmsstret` decimal(15,2) DEFAULT NULL,
  `vbcfcpstret` decimal(15,2) DEFAULT NULL,
  `pfcpstret` decimal(9,4) DEFAULT NULL,
  `vfcpstret` decimal(15,2) DEFAULT NULL,
  `vbcstdest` decimal(15,2) DEFAULT NULL,
  `vicmsstdest` decimal(15,2) DEFAULT NULL,
  `predbcefet` decimal(9,4) DEFAULT NULL,
  `vbcefet` decimal(15,2) DEFAULT NULL,
  `picmsefet` decimal(9,4) DEFAULT NULL,
  `vicmsefet` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_icmsst_sefaz_icms` FOREIGN KEY (`idsefaz_icms`) REFERENCES `sefaz_icms` (`id`)
) ENGINE=InnoDB;

-- Tabela derivada de br.eng.rodrigogml.rfw.sefaz.vo.SEFAZEnviNFeVO
CREATE TABLE `sefaz_envinfe` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `versao` varchar(50) NOT NULL,
  `idlote` varchar(15) NOT NULL,
  `indsinc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- Tabela de associao entre lotes (SEFAZEnviNFeVO) e NF-e
CREATE TABLE `sefaz_envinfe_nfe` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_envinfe` bigint NOT NULL,
  `idsefaz_nfe` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_envinfe_nfe_envinfe` FOREIGN KEY (`idsefaz_envinfe`) REFERENCES `sefaz_envinfe` (`id`),
  CONSTRAINT `fk_sefaz_envinfe_nfe_nfe` FOREIGN KEY (`idsefaz_nfe`) REFERENCES `sefaz_nfe` (`id`)
) ENGINE=InnoDB;
