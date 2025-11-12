-- ----------------------------
-- Script para criação das tabelas 'sefaz_' oferecidas pelo RFW.SEFAZ
-- ----------------------------
-- [1]
CREATE TABLE `sefaz_nfeproc` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `versao` decimal(4,2) NOT NULL COMMENT 'Versão do XML nfeProc (0 a 99,99, 2 casas decimais)',
  PRIMARY KEY (`id`),
  CONSTRAINT `chk_sefaz_nfeproc_versao` CHECK (`versao` >= 0.00 AND `versao` <= 99.99)
) ENGINE=InnoDB;

CREATE TABLE `sefaz_nfe` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_nfeproc` bigint NOT NULL COMMENT 'Relacionamento com sefaz_nfeproc (nfeProc)',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_nfe_sefaz_nfeproc` FOREIGN KEY (`idsefaz_nfeproc`) REFERENCES `sefaz_nfeproc` (`id`)
) ENGINE=InnoDB;

CREATE TABLE `sefaz_infnfe` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idsefaz_nfe` bigint NOT NULL COMMENT 'Relacionamento com sefaz_nfe (NFe)',
  `versao` varchar(4) DEFAULT NULL COMMENT 'Versão do leiaute (ex.: 4.00)',
  `idtag` varchar(47) UNIQUE DEFAULT NULL COMMENT 'Identificador da TAG a ser assinada (NFe + 44 dígitos)',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sefaz_infnfe_sefaz_nfe` FOREIGN KEY (`idsefaz_nfe`) REFERENCES `sefaz_nfe` (`id`)
) ENGINE=InnoDB;

