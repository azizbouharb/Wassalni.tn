-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 25 fév. 2023 à 11:24
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `wassalnidb`
--

-- --------------------------------------------------------

--
-- Structure de la table `annonces`
--

CREATE TABLE `annonces` (
  `id_anno` int(11) NOT NULL,
  `id_chauf` int(11) NOT NULL,
  `date_depart` date NOT NULL,
  `dest` varchar(50) NOT NULL,
  `etat` varchar(20) NOT NULL,
  `depart` varchar(50) NOT NULL,
  `prix_cov` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `chats`
--

CREATE TABLE `chats` (
  `id_chat` int(11) NOT NULL,
  `message` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `chauffeurs`
--

CREATE TABLE `chauffeurs` (
  `id_chauf` int(11) NOT NULL,
  `cin_chauf` int(20) NOT NULL,
  `permis_chauf` int(20) NOT NULL,
  `image_permis` varchar(50) NOT NULL,
  `id_voiture` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

CREATE TABLE `clients` (
  `id_client` int(100) NOT NULL,
  `nom_client` varchar(20) NOT NULL,
  `prenom_client` varchar(20) NOT NULL,
  `email_client` varchar(50) NOT NULL,
  `date_client` date NOT NULL,
  `cin_client` int(11) NOT NULL,
  `image_client` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `event`
--

CREATE TABLE `event` (
  `id_event` int(11) NOT NULL,
  `nom_event` varchar(50) NOT NULL,
  `id_chauf` int(11) NOT NULL,
  `desc_event` varchar(100) NOT NULL,
  `date_event` date NOT NULL,
  `duree` time NOT NULL,
  `type_event` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `feedback`
--

CREATE TABLE `feedback` (
  `id_feedback` int(11) NOT NULL,
  `rate` int(11) NOT NULL,
  `desc_feedback` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `livraisons`
--

CREATE TABLE `livraisons` (
  `id_livraison` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `id_chauf` int(11) NOT NULL,
  `depart` varchar(50) NOT NULL,
  `dest` varchar(50) NOT NULL,
  `image_pr` varchar(50) NOT NULL,
  `etat_liv` varchar(20) NOT NULL,
  `prix` float NOT NULL,
  `date_liv` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `livreurs`
--

CREATE TABLE `livreurs` (
  `id_livreur` int(11) NOT NULL,
  `cin_livreur` int(11) NOT NULL,
  `secteur_livreur` varchar(50) NOT NULL,
  `dispo_livreur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `location`
--

CREATE TABLE `location` (
  `id_location` int(11) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `prix_location` int(11) NOT NULL,
  `id_voiture` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `voiture`
--

CREATE TABLE `voiture` (
  `id_voiture` int(11) NOT NULL,
  `matricule` varchar(50) NOT NULL,
  `modele` varchar(50) NOT NULL,
  `carte_grise` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `voiture`
--

INSERT INTO `voiture` (`id_voiture`, `matricule`, `modele`, `carte_grise`) VALUES
(11, '161TUN9000', 'hyundai i20', '587834');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `annonces`
--
ALTER TABLE `annonces`
  ADD PRIMARY KEY (`id_anno`),
  ADD KEY `id_chauf` (`id_chauf`);

--
-- Index pour la table `chats`
--
ALTER TABLE `chats`
  ADD PRIMARY KEY (`id_chat`);

--
-- Index pour la table `chauffeurs`
--
ALTER TABLE `chauffeurs`
  ADD PRIMARY KEY (`id_chauf`),
  ADD KEY `cin_chauf` (`cin_chauf`),
  ADD KEY `id_voiture` (`id_voiture`);

--
-- Index pour la table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id_client`),
  ADD UNIQUE KEY `cin_client` (`cin_client`);

--
-- Index pour la table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`id_event`),
  ADD KEY `id_chauf` (`id_chauf`);

--
-- Index pour la table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`id_feedback`);

--
-- Index pour la table `livraisons`
--
ALTER TABLE `livraisons`
  ADD PRIMARY KEY (`id_livraison`),
  ADD KEY `id_client` (`id_client`),
  ADD KEY `id_chauf` (`id_chauf`);

--
-- Index pour la table `livreurs`
--
ALTER TABLE `livreurs`
  ADD PRIMARY KEY (`id_livreur`),
  ADD UNIQUE KEY `cin` (`cin_livreur`);

--
-- Index pour la table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`id_location`),
  ADD KEY `id_voiture` (`id_voiture`);

--
-- Index pour la table `voiture`
--
ALTER TABLE `voiture`
  ADD PRIMARY KEY (`id_voiture`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `annonces`
--
ALTER TABLE `annonces`
  MODIFY `id_anno` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `chats`
--
ALTER TABLE `chats`
  MODIFY `id_chat` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `chauffeurs`
--
ALTER TABLE `chauffeurs`
  MODIFY `id_chauf` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `clients`
--
ALTER TABLE `clients`
  MODIFY `id_client` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `event`
--
ALTER TABLE `event`
  MODIFY `id_event` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `id_feedback` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `livraisons`
--
ALTER TABLE `livraisons`
  MODIFY `id_livraison` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `livreurs`
--
ALTER TABLE `livreurs`
  MODIFY `id_livreur` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `location`
--
ALTER TABLE `location`
  MODIFY `id_location` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT pour la table `voiture`
--
ALTER TABLE `voiture`
  MODIFY `id_voiture` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `chauffeurs`
--
ALTER TABLE `chauffeurs`
  ADD CONSTRAINT `chauffeurs_ibfk_1` FOREIGN KEY (`cin_chauf`) REFERENCES `clients` (`cin_client`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `clients`
--
ALTER TABLE `clients`
  ADD CONSTRAINT `clients_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `livraisons` (`id_client`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `livreurs`
--
ALTER TABLE `livreurs`
  ADD CONSTRAINT `livreurs_ibfk_1` FOREIGN KEY (`cin_livreur`) REFERENCES `chauffeurs` (`cin_chauf`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `livreurs_ibfk_2` FOREIGN KEY (`id_livreur`) REFERENCES `livraisons` (`id_chauf`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `location`
--
ALTER TABLE `location`
  ADD CONSTRAINT `location_ibfk_1` FOREIGN KEY (`id_voiture`) REFERENCES `voiture` (`id_voiture`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
