-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Ven 25 Octobre 2013 à 21:53
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `edf`
--
CREATE DATABASE IF NOT EXISTS `edf` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `edf`;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `identifiant` int(11) NOT NULL,
  `nom` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `prenom` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `adresse` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `cp` char(5) COLLATE utf8_unicode_ci NOT NULL,
  `ville` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `tl` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `idcompteur` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `ancien_releve` double NOT NULL,
  `date_ancien_releve` date NOT NULL,
  `dernier_releve` double NOT NULL,
  `date_dernier_releve` date NOT NULL,
  `signature_Base64` longtext COLLATE utf8_unicode_ci NOT NULL,
  `situation` int(11) NOT NULL,
  `idcontroleur` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`identifiant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`identifiant`, `nom`, `prenom`, `adresse`, `cp`, `ville`, `tl`, `idcompteur`, `ancien_releve`, `date_ancien_releve`, `dernier_releve`, `date_dernier_releve`, `signature_Base64`, `situation`, `idcontroleur`) VALUES
(1001, 'dupont', 'paul', '10 rue Anne Frank', '49000', 'angers', '0624553212', '19950055123', 1456.24, '2012-03-15', 0, '0000-00-00', '', 0, 'fhollande'),
(1002, 'lulu', 'isabelle', '10 Avenue des arts et métiers', '49000', 'angers', '0624553212', '19950055234', 1546.22, '2012-12-19', 0, '0000-00-00', '', 0, 'fhollande'),
(1003, 'caolin', 'etienne', '10 rue Boisnet', '49000', 'angers', '0624553212', '19990057894', 45698.25, '2013-02-04', 0, '0000-00-00', '', 0, 'fhollande'),
(1004, 'breche', 'alfred', '25 rue du quinconce', '49000', 'angers', '0623553211', '20110055123', 5656.26, '2012-08-08', 0, '0000-00-00', '', 0, 'fhollande'),
(1005, 'centaure', 'marie', '20 rue des lutins', '49000', 'angers', '0744553212', '20070055123', 57356.24, '2012-05-15', 0, '0000-00-00', '', 0, 'fhollande'),
(1006, 'salsa', 'solado', '12 rue locarno', '49000', 'angers', '0612345678', '20080055123', 8963.45, '2012-11-13', 0, '0000-00-00', '', 0, 'amerkel');

-- --------------------------------------------------------

--
-- Structure de la table `controleur`
--

DROP TABLE IF EXISTS `controleur`;
CREATE TABLE IF NOT EXISTS `controleur` (
  `id` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `mp` char(32) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `controleur`
--

INSERT INTO `controleur` (`id`, `mp`) VALUES
('amerkel', '5f4dcc3b5aa765d61d8327deb882cf99'),
('fhollande', '5f4dcc3b5aa765d61d8327deb882cf99');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
