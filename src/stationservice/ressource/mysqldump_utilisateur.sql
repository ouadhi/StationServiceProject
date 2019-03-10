
DROP TABLE IF EXISTS `etatprivilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `etatprivilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nomEtatPrivilege` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idEtatPrivilege` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `privilege`
--

DROP TABLE IF EXISTS `privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateAjoutPrivilege` datetime NOT NULL,
  `idEtatPrivilege` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idPrivilage` (`id`),
  KEY `idEtatPrivilege` (`idEtatPrivilege`),
  CONSTRAINT `Privilege_ibfk_1` FOREIGN KEY (`idEtatPrivilege`) REFERENCES `etatprivilege` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utilisateur` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `dateAjoutUtilisateur` date DEFAULT NULL,
  `login` char(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` char(56) COLLATE utf8_unicode_ci DEFAULT NULL,
  `utlCrtUtl` smallint(6) DEFAULT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `datenes`  date DEFAULT NULL,
  `lieunais` varchar(50) DEFAULT NULL,
  `adresse` varchar(50) DEFAULT NULL,
  `telephone` char(10) DEFAULT NULL,
  `idPrivilage` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`),
  KEY `utlCrtUtl` (`utlCrtUtl`),
  KEY `idPrivilage` (`idPrivilage`),
  CONSTRAINT `utilisateur_ibfk_1` FOREIGN KEY (`utlCrtUtl`) REFERENCES `utilisateur` (`id`),
  CONSTRAINT `utilisateur_ibfk_3` FOREIGN KEY (`idPrivilage`) REFERENCES `privilege` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `etatutilisateur`
--

DROP TABLE IF EXISTS `etatutilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `etatutilisateur` (
  `id` smallint(6) NOT NULL,
  `dateActivation` datetime DEFAULT NULL,
  `activer` tinyint(1) DEFAULT NULL,
  `utlActEtUtl` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idUtilisateur` (`id`),
  CONSTRAINT `etatUtilisateur_ibfk_1` FOREIGN KEY (`utlActEtUtl`) REFERENCES `utilisateur` (`id`),
  CONSTRAINT `FK_etatUtilisateur` FOREIGN KEY (`id`) REFERENCES `utilisateur` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `session`
--

DROP TABLE IF EXISTS `session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `session` (
  `id` smallint(11) NOT NULL AUTO_INCREMENT,
  `idUtilisateur` smallint(6) NOT NULL,
  `dateDebutSession` datetime DEFAULT NULL,
  `dateFinSession` datetime DEFAULT NULL,
  `description` tinyint(1) DEFAULT NULL,
  `ipAdress` char(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_sessionUtilisateur` (`idUtilisateur`),
  CONSTRAINT `FK_sessionUtilisateur` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `id` smallint(6) NOT NULL,
  `description` char(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
--
-- Table structure for table `fichierlog`
--

DROP TABLE IF EXISTS `fichierlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fichierlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idMessage` smallint(6) DEFAULT NULL,
  `idSession` smallint(6) NOT NULL,
  `dateCreationFichierLog` datetime DEFAULT NULL,
  `idLog` smallint(6) DEFAULT NULL,
  `description` char(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_fichierLogSession` (`idSession`),
  KEY `FK_messageLog` (`idMessage`),
  CONSTRAINT `FK_fichierLogSession` FOREIGN KEY (`idSession`) REFERENCES `session` (`id`),
  CONSTRAINT `FK_messageLog` FOREIGN KEY (`idMessage`) REFERENCES `message` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;



DROP TABLE IF EXISTS `pompiste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pompiste` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `dateajoutpompiste` datetime DEFAULT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `datenes`  date DEFAULT NULL,
  `lieunais` varchar(50) DEFAULT NULL,
 `adresse` varchar(50) DEFAULT NULL,
 `telephone` char(10) DEFAULT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `declaration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `declaration` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idutilisateur` smallint(6) NOT NULL,
  `idpompiste` smallint(6) NOT NULL,
  `date` datetime DEFAULT NULL,
  `total` decimal(16,4) DEFAULT '0.0000',
  `bons` decimal(16,4) DEFAULT '0.0000',
  `esp` decimal(16,4) DEFAULT '0.0000',
  PRIMARY KEY (`id`),
  CONSTRAINT `declaration_ibfk_1` FOREIGN KEY (`idutilisateur`) REFERENCES `utilisateur` (`id`),
  CONSTRAINT `declaration_ibfk_2` FOREIGN KEY (`idpompiste`) REFERENCES `pompiste` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `produit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produit` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `disignations` char(20) NOT NULL,
  `prix` decimal(16,4) DEFAULT '0.0000',
  `date` datetime DEFAULT NULL,
  `min` decimal(16,4) DEFAULT '0.0000',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `vente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iddeclaration`  int(11) NOT NULL,
  `idproduite` smallint(6) NOT NULL,
  `date` datetime DEFAULT NULL,
  `nouveau` decimal(16,4) DEFAULT '0.0000',
  `ancien` decimal(16,4) DEFAULT '0.0000',
  `quantite` decimal(16,4) DEFAULT '0.0000',
  `total` decimal(16,4) DEFAULT '0.0000',
  PRIMARY KEY (`id`),
  CONSTRAINT `vente_ibfk_1` FOREIGN KEY (`iddeclaration`) REFERENCES `declaration` (`id`),
  CONSTRAINT `vente_ibfk_2` FOREIGN KEY (`idproduite`) REFERENCES `produit` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `bons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bons` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `dateajoutbons` datetime DEFAULT NULL,
  `val` decimal(16,4) DEFAULT '0.0000',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `vente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `decbons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iddeclaration`  int(11) NOT NULL,
  `idbons` smallint(6) NOT NULL,
  `date` datetime DEFAULT NULL,
  `nbons` smallint(6) NOT NULL,
  `total` decimal(16,4) DEFAULT '0.0000',
  PRIMARY KEY (`id`),
  CONSTRAINT `decbons_ibfk_1` FOREIGN KEY (`iddeclaration`) REFERENCES `declaration` (`id`),
  CONSTRAINT `decbons_ibfk_2` FOREIGN KEY (`idbons`) REFERENCES `bons` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;




























