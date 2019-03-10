-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le :  sam. 12 jan. 2019 à 21:41
-- Version du serveur :  5.7.23
-- Version de PHP :  7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `service`
--

-- --------------------------------------------------------

--
-- Structure de la table `bons`
--

CREATE TABLE `bons` (
  `id` int(11) NOT NULL,
  `dateajoutbons` datetime DEFAULT NULL,
  `val` double DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `bons`
--

INSERT INTO `bons` (`id`, `dateajoutbons`, `val`, `designation`) VALUES
(5, '2018-11-15 00:00:00', 1150, 'bons1150'),
(6, '2018-11-15 00:00:00', 850, 'bons850'),
(8, '2018-11-15 00:00:00', 839, 'bons839'),
(9, '2018-11-15 00:00:00', 690, 'bons690'),
(10, '2018-11-15 00:00:00', 416, 'bons416'),
(11, '2018-11-15 00:00:00', 332, 'bons332');

-- --------------------------------------------------------

--
-- Structure de la table `decbons`
--

CREATE TABLE `decbons` (
  `id` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `nbons` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `idbons` int(11) NOT NULL,
  `iddeclaration` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `decbons`
--

INSERT INTO `decbons` (`id`, `date`, `nbons`, `total`, `idbons`, `iddeclaration`) VALUES
(27, '2018-11-16', 1, 1150, 5, 14),
(28, '2018-11-16', 1, 850, 6, 14),
(29, '2018-11-16', 1, 839, 8, 14),
(30, '2018-11-16', 1, 839, 9, 14),
(31, '2018-11-16', 1, 416, 10, 14),
(38, '2018-11-19', 2, 2300, 5, 15),
(39, '2018-11-19', 3, 2550, 6, 15),
(40, '2018-11-19', 5, 4195, 8, 15),
(41, '2018-11-19', 7, 4195, 9, 15),
(42, '2018-11-19', 6, 2496, 10, 15),
(43, '2018-11-19', 5, 1660, 11, 15),
(48, '2018-11-26', 1, 1150, 5, 16),
(49, '2018-11-26', 1, 850, 6, 16),
(50, '2018-11-26', 1, 839, 8, 16),
(51, '2018-11-26', 1, 839, 9, 16),
(52, '2018-11-26', 1, 416, 10, 16),
(53, '2018-11-26', 1, 332, 11, 16),
(58, '2018-12-02', 1, 1150, 5, 17),
(59, '2018-12-02', 1, 850, 6, 17),
(60, '2018-12-02', 1, 839, 8, 17),
(61, '2018-12-02', 1, 839, 9, 17),
(62, '2018-12-02', 1, 416, 10, 17),
(63, '2018-12-02', 1, 332, 11, 17),
(68, '2018-12-21', 1, 1150, 5, 18),
(69, '2018-12-21', 1, 850, 6, 18),
(70, '2018-12-21', 1, 839, 8, 18),
(71, '2018-12-21', 1, 839, 9, 18),
(72, '2018-12-21', 1, 416, 10, 18),
(73, '2018-12-21', 1, 332, 11, 18),
(122, '2018-12-14', 1, 1150, 5, 19),
(123, '2018-12-14', 1, 850, 6, 19),
(124, '2018-12-14', 1, 839, 8, 19),
(125, '2018-12-14', 1, 839, 9, 19),
(126, '2018-12-14', 1, 416, 10, 19),
(127, '2018-12-14', 1, 332, 11, 19),
(132, '2018-12-14', 1, 1150, 5, 20),
(133, '2018-12-14', 1, 850, 6, 20),
(134, '2018-12-14', 1, 839, 8, 20),
(135, '2018-12-14', 1, 839, 9, 20),
(136, '2018-12-14', 1, 416, 10, 20),
(137, '2018-12-14', 1, 332, 11, 20),
(142, '2018-12-15', 1, 1150, 5, 21),
(143, '2018-12-15', 1, 850, 6, 21),
(144, '2018-12-15', 1, 839, 8, 21),
(145, '2018-12-15', 1, 839, 9, 21),
(146, '2018-12-15', 1, 416, 10, 21),
(147, '2018-12-15', 1, 332, 11, 21),
(152, '2018-12-19', 1, 1150, 5, 22),
(153, '2018-12-19', 1, 850, 6, 22),
(154, '2018-12-19', 1, 839, 8, 22),
(155, '2018-12-19', 1, 839, 9, 22),
(156, '2018-12-19', 1, 416, 10, 22),
(157, '2018-12-19', 1, 332, 11, 22),
(162, '2018-12-20', 1, 1150, 5, 23),
(163, '2018-12-20', 1, 850, 6, 23),
(164, '2018-12-20', 1, 839, 8, 23),
(165, '2018-12-20', 1, 839, 9, 23),
(166, '2018-12-20', 1, 416, 10, 23),
(167, '2018-12-20', 1, 332, 11, 23),
(174, '2019-01-08', 1, 1150, 5, 24),
(175, '2019-01-08', 1, 850, 6, 24),
(176, '2019-01-08', 0, 0, 8, 24),
(177, '2019-01-08', 0, 0, 9, 24),
(178, '2019-01-08', 0, 0, 10, 24),
(179, '2019-01-08', 0, 0, 11, 24),
(184, '2019-01-12', 0, 0, 5, 25),
(185, '2019-01-12', 0, 0, 6, 25),
(186, '2019-01-12', 0, 0, 8, 25),
(187, '2019-01-12', 2, 0, 9, 25),
(188, '2019-01-12', 0, 0, 10, 25),
(189, '2019-01-12', 0, 0, 11, 25),
(194, '2019-01-11', 1, 1150, 5, 26),
(195, '2019-01-11', 0, 0, 6, 26),
(196, '2019-01-11', 0, 0, 8, 26),
(197, '2019-01-11', 0, 0, 9, 26),
(198, '2019-01-11', 0, 0, 10, 26),
(199, '2019-01-11', 0, 0, 11, 26),
(204, '2019-01-11', 6, 6900, 5, 27),
(205, '2019-01-11', 0, 0, 6, 27),
(206, '2019-01-11', 0, 0, 8, 27),
(207, '2019-01-11', 0, 0, 9, 27),
(208, '2019-01-11', 0, 0, 10, 27),
(209, '2019-01-11', 0, 0, 11, 27);

-- --------------------------------------------------------

--
-- Structure de la table `declaration`
--

CREATE TABLE `declaration` (
  `id` int(11) NOT NULL,
  `bons` double DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `total` double DEFAULT NULL,
  `idpompiste` int(11) NOT NULL,
  `debut_job` time DEFAULT NULL,
  `fin_job` time DEFAULT NULL,
  `avance` double DEFAULT NULL,
  `billets` double DEFAULT NULL,
  `iduser` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `declaration`
--

INSERT INTO `declaration` (`id`, `bons`, `date`, `total`, `idpompiste`, `debut_job`, `fin_job`, `avance`, `billets`, `iduser`) VALUES
(19, 4277, '2018-12-14 00:00:00', 318960, 33, '08:00:00', '20:00:00', 10000, 100, 1),
(20, 4277, '2018-12-14 00:00:00', 317760, 33, '08:00:00', '20:00:00', 10000, 300, 1),
(21, 4277, '2018-12-15 00:00:00', 318960, 33, '08:00:00', '20:00:00', 10000, 4444, 1),
(22, 4277, '2018-12-19 00:00:00', 234740, 33, '08:00:00', '20:00:00', 10000, 1000, 1),
(23, 4277, '2018-12-20 00:00:00', 20580, 33, '08:00:00', '20:00:00', 10000, 155, 1),
(24, 2000, '2019-01-08 00:00:00', 11934, 33, '08:00:00', '20:00:00', 10000, 200, 1);

-- --------------------------------------------------------

--
-- Structure de la table `declarationproduit`
--

CREATE TABLE `declarationproduit` (
  `id` int(11) NOT NULL,
  `ancien` int(11) DEFAULT NULL,
  `nouveau` int(11) DEFAULT NULL,
  `prix` double DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  `somme` double DEFAULT NULL,
  `iddeclaration` int(11) NOT NULL,
  `idproduit` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `declarationproduit`
--

INSERT INTO `declarationproduit` (`id`, `ancien`, `nouveau`, `prix`, `quantite`, `somme`, `iddeclaration`, `idproduit`) VALUES
(23, 1000, 100, 10, 900, 9000, 14, 9),
(24, 2000, 200, 10, 1800, 18000, 14, 7),
(25, 3000, 300, 10, 2700, 27000, 14, 8),
(26, 4000, 4000, 10, 0, 0, 14, 10),
(34, 1000, 10, 10, 990, 9900, 15, 9),
(35, 1000, 900, 10, 100, 1000, 15, 7),
(36, 100, 50, 10, 50, 500, 15, 8),
(37, 12000, 100, 10, 11900, 119000, 15, 10),
(44, 1100, 3, 10, 1097, 10970, 16, 9),
(45, 22, 44, 10, 22, 220, 16, 7),
(46, 59000, 300, 10, 58700, 587000, 16, 8),
(47, 300, 20, 10, 280, 2800, 16, 10),
(54, 0, 1000, 10, 1000, 10000, 17, 9),
(55, 0, 1000, 10, 1000, 10000, 17, 7),
(56, 0, 10000, 10, 10000, 100000, 17, 8),
(57, 0, 10000, 10, 10000, 100000, 17, 10),
(64, 0, 1000, 10, 1000, 10000, 18, 9),
(65, 0, 1000, 10, 1000, 10000, 18, 7),
(66, 0, 1000, 10, 1000, 10000, 18, 8),
(67, 0, 1000, 10, 1000, 10000, 18, 10),
(118, 8778, 300, 10, 8478, 84780, 19, 9),
(119, 15155, 300, 10, 14855, 148550, 19, 7),
(120, 585, 300, 10, 285, 2850, 19, 8),
(121, 8578, 300, 10, 8278, 82780, 19, 10),
(128, 8778, 330, 10, 8448, 84480, 20, 9),
(129, 15155, 330, 10, 14825, 148250, 20, 7),
(130, 585, 330, 10, 255, 2550, 20, 8),
(131, 8578, 330, 10, 8248, 82480, 20, 10),
(138, 8778, 300, 10, 8478, 84780, 21, 9),
(139, 15155, 300, 10, 14855, 148550, 21, 7),
(140, 585, 300, 10, 285, 2850, 21, 8),
(141, 8578, 300, 10, 8278, 82780, 21, 10),
(148, 300, 45, 10, 255, 2550, 22, 9),
(149, 15155, 54, 10, 15101, 151010, 22, 7),
(150, 585, 45, 10, 540, 5400, 22, 8),
(151, 8578, 1000, 10, 7578, 75780, 22, 10),
(158, 45, 547, 10, 502, 5020, 23, 9),
(159, 54, 445, 10, 391, 3910, 23, 7),
(160, 45, 788, 10, 743, 7430, 23, 8),
(161, 1000, 578, 10, 422, 4220, 23, 10),
(170, 547, 600, 27, 53, 1431, 24, 9),
(171, 445, 800, 27, 355, 9585, 24, 7),
(172, 788, 800, 27, 12, 324, 24, 8),
(173, 578, 600, 27, 22, 594, 24, 10),
(180, 600, 700, 27, 100, 2700, 25, 9),
(181, 800, 900, 27, 100, 2700, 25, 7),
(182, 800, 900, 27, 100, 2700, 25, 8),
(183, 600, 700, 27, 100, 2700, 25, 10),
(190, 700, 200, 27, 500, 13500, 26, 9),
(191, 900, 0, 27, 0, 0, 26, 7),
(192, 900, 0, 27, 0, 0, 26, 8),
(193, 700, 0, 27, 0, 0, 26, 10),
(200, 200, 700, 27, 500, 13500, 27, 9),
(201, 0, 500, 27, 500, 13500, 27, 7),
(202, 0, 600, 27, 600, 16200, 27, 8),
(203, 0, 700, 27, 700, 18900, 27, 10);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(211),
(211);

-- --------------------------------------------------------

--
-- Structure de la table `pompiste`
--

CREATE TABLE `pompiste` (
  `id` int(11) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `dateajoutpompiste` datetime DEFAULT NULL,
  `datenes` datetime DEFAULT NULL,
  `lieunais` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `pompiste`
--

INSERT INTO `pompiste` (`id`, `adresse`, `dateajoutpompiste`, `datenes`, `lieunais`, `nom`, `prenom`, `telephone`) VALUES
(8, 'vds', '2018-11-12 00:00:00', '2018-11-13 00:00:00', 'vd', 'dfvd', 'vdsvd', '12345'),
(33, 'lieu', '2018-11-19 00:00:00', '2018-11-18 00:00:00', 'lieu', 'pompiste1', 'pompiste1', '0553440'),
(169, 'hny', '2019-01-07 00:00:00', '2019-01-04 00:00:00', 'hhbh', 'yy', 'yy', '77788');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `disignations` varchar(255) DEFAULT '0',
  `min` int(11) DEFAULT '0',
  `quantite` float DEFAULT '0',
  `max` int(11) DEFAULT '0',
  `compteur` int(11) DEFAULT '0',
  `prix` float DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id`, `date`, `disignations`, `min`, `quantite`, `max`, `compteur`, `prix`) VALUES
(7, '2018-11-15', 'sans plomb1', 1000, 13553, 20000, 500, 100),
(8, '2018-11-15', 'sans plomb2', 1000, 16005, 20000, 600, 27),
(9, '2018-11-15', 'super', 1000, 15090, 20000, 700, 27),
(10, '2018-11-15', 'gazoil', 1000, 12756, 20000, 700, 27);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `dateajoute` date DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `privilege` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `active`, `dateajoute`, `password`, `privilege`, `username`) VALUES
(1, b'1', '2018-12-14', 'b', 'admin', 'c');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `bons`
--
ALTER TABLE `bons`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `decbons`
--
ALTER TABLE `decbons`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7w4qk4o0evykiy5uprw9or40c` (`idbons`),
  ADD KEY `FKevxf0bgh7xodl5538cq1nkh6e` (`iddeclaration`);

--
-- Index pour la table `declaration`
--
ALTER TABLE `declaration`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKk9069mo04smbrojpqyel0jdfo` (`idpompiste`),
  ADD KEY `FKt8ypqsf9kpwoy6t8jbtsqccg6` (`iduser`);

--
-- Index pour la table `declarationproduit`
--
ALTER TABLE `declarationproduit`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKimcwrwrh4vx4asuflc0yc44u0` (`iddeclaration`),
  ADD KEY `FKejst60t54um62eypdlclg2hhy` (`idproduit`);

--
-- Index pour la table `pompiste`
--
ALTER TABLE `pompiste`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `decbons`
--
ALTER TABLE `decbons`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=210;

--
-- AUTO_INCREMENT pour la table `declaration`
--
ALTER TABLE `declaration`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT pour la table `declarationproduit`
--
ALTER TABLE `declarationproduit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=204;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=211;
