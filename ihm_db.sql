-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Ven 15 Mai 2014 à 22:10
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `ihm_db`
--
CREATE DATABASE IF NOT EXISTS `ihm_db` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `ihm_db`;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE IF NOT EXISTS `categorie` (
  `idCategorie` int(11) NOT NULL AUTO_INCREMENT,
  `libCategorie` varchar(45) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  PRIMARY KEY (`idCategorie`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `categorie`
--

INSERT INTO `categorie` (`idCategorie`, `libCategorie`, `description`) VALUES
(1, 'Guidage', 'moyens mis en oeuvre pour conseiller, orienter, informer, et conduire l’utilisateur lors de ses interactions avec l’ordinateur (messages, alarmes, labels, etc.), y compris dans ses aspects lexicaux'),
(2, 'Charge de travail', 'Ce critère concerne l’ensemble des éléments de l’interface jouant un rôle dans la réduction de la charge perceptive ou mnésique des utilisateurs, et dans l’augmentation de l’efficacité du dialogue'),
(3, 'Controle explicite', 'concerne à la fois la prise en compte par le système des actions explicites des utilisateurs, et le contrôle qu’ont les utilisateurs sur le traitement de leurs actions.'),
(4, 'Adaptabilite', 'L’adaptabilité d’un système concerne sa capacité à réagir selon le contexte, et selon les besoins et préférences des utilisateurs.'),
(5, 'Gestion des erreurs', 'Ce critère concerne tous les moyens permettant d’une part d’éviter ou de réduire les erreurs, et d’autre part de les corriger lorsqu’elles surviennent. Les erreurs sont ici considérées comme des saisi'),
(6, 'Homogeneite/Coherence', 'Le critère Homogénéité/Cohérence se réfère à la façon avec laquelle les choix de conception de l’interface (codes, dénominations, formats, procédures, etc.) sont conservés pour des contextes identique'),
(7, 'Signifiance des codes et denomination', 'Ce critère concerne l’adéquation entre l’objet ou l’information affichée ou entrée, et son référent. Des codes et dénominations « signifiants » disposent d’une relation sémantique forte avec leur réfé'),
(8, 'Compatibilite', 'concerne l’accord pouvant exister entre les caractéristiques des utilisateurs (mémoire, perceptions, habitudes, compétences, âge, attentes, etc.) et des tâches, d’une part, et l’organisation des sorti'),
(9, 'Heuristique de nielsen', 'Catégorie qui regroupe les Heuristique de nielsen');

-- --------------------------------------------------------

--
-- Structure de la table `critere_bs`
--

CREATE TABLE IF NOT EXISTS `critere_bs` (
  `idcritaire` int(11) NOT NULL AUTO_INCREMENT,
  `libcritaire` varchar(45) DEFAULT NULL,
  `idcategorie` int(11) DEFAULT NULL,
  `definition` text,
  PRIMARY KEY (`idcritaire`),
  KEY `idcategorie_idx` (`idcategorie`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Contenu de la table `critere_bs`
--

INSERT INTO `critere_bs` (`idcritaire`, `libcritaire`, `idcategorie`, `definition`) VALUES
(1, 'Incitation', 1, 'Moyens mis en oeuvre pour amener les utilisateurs à effectuer des actions spécifiques, qu’il s’agisse d’entrée de données ou autre et Mécanismes ou moyens faisant connaître aux utilisateurs les alternatives, lorsque plusieurs actions sont possibles, selon les états ou contextes dans lesquels ils se trouvent. barre d''''état, mesure, espace, format, indice, titre, aide...tout élément facilitant la navigation '),
(2, 'Groupement', 1, 'Organisation visuelle de l''''information pour illustrer une relation de classe de type appartenance/distinction (a localisation des informations les unes par rapport aux autres et - le format ( caractéristiques graphiques (format, couleur, etc.))'),
(3, 'Feed-back immediat', 1, 'concerne les réponses de l’ordinateur consécutives aux actions des utilisateurs. l’ordinateur devrait répondre, dans des délais brefs, appropriés et homogènes selon les types de transactions. Une réponse aussi immédiate que possible devrait être fournie à ’utilisateur, le renseignant sur l’action accomplie et sur son résultat'),
(4, 'Lisibilite', 1, 'caractéristiques lexicales de présentation des informations à l’écran pouvant entraver ou faciliter la lecture de celles-ci (luminance des caractères, contraste caractères/fond, dimension des lettres, espacement entre les mots, espacement entre les lignes, espacement entre les paragraphes, longueur des lignes, etc.).'),
(5, 'Brievete', 2, 'Concision : concerne la charge de travail au niveau perceptif et mnésique à la fois pour les éléments individuels d’entrée ou de sortie,  et Actions minimales :les séquences d’entrées (c’est-à-dire, les suites d’actions nécessaires à l’atteinte d’un but, à l’accomplissement d’une tâche). Il s’agit ici de limiter autant que possible le travail de lecture, d’entrée de données, et les étapes par lesquelles doivent passer les utilisateurs. '),
(6, 'Densite information', 2, 'Ce critère concerne la charge de travail du point de vue perceptif et mnésique, pour des ensembles d’éléments et non pour des items.'''),
(7, 'Actions explicites', 3, 'concerne la relation pouvant exister entre le fonctionnement de l’application et les actions des utilisateurs. Cette relation doit être explicite, c’est-à-dire que le système doit exécuter seulement les opérations demandées par l’utilisateur et pas d’autres opérations et ce, au moment où il les demande'),
(8, 'Controle Utilisateur', 3, 'l’utilisateur doit toujours avoir la main, pouvoir contrôler le déroulement (interrompre, reprendre) des traitements informatiques en cours. Ses actions devraient être anticipées, et des options appropriées devraient être fournies pour chaque cas. '),
(9, 'Flexibilite', 4, 'concerne les moyens mis à la disposition des utilisateurs pour personnaliser l’interface afin de rendre compte de leurs stratégies ou habitudes de travail et des exigences de la tâche. Le critère Flexibilité correspond aussi aux différentes possibilités qu’ont les utilisateurs pour atteindre un objectif donné. Il s’agit, en d’autres termes, de la capacité de l’interface à s’adapter à des actions variées des utilisateurs. '),
(10, 'Prise en compte de l''expérience de l''utilisat', 4, 'concerne les moyens mis en oeuvre pour respecter le niveau d’expérience de l’utilisateur. '),
(11, 'Prevention des erreurs', 5, 'Ce critère concerne les moyens servant à détecter et prévenir les erreurs d’entrées de données ou commandes, ou les actions aux conséquences néfastes '),
(12, 'Qualite des messages d''erreur', 5, 'concerne la pertinence, la facilité de lecture et l’exactitude de l’information donnée aux utilisateurs sur la nature des erreurs commises et sur les actions à entreprendre pour les corriger. De manière générale il faudrait : Fournir des messages d’erreur orientés-tâches (par exemple, Un problème est survenu pendant la copie du fichier sur le disque plutôt que Erreur d’exécution). Utiliser des termes aussi spécifiques que possible, éviter les termes ambigus. Adopter un vocabulaire neutre'''),
(13, 'Correction des erreurs', 5, 'concerne les moyens mis à la disposition des utilisateurs pour leur permettre de corriger leurs erreurs. '''),
(14, 'Coherence interne', 6, 'Cohérence générale des différents éléments du système entre eux.  * Métaphore: cohérence des référents du système.  * Mapping: cohérence de l''''ensemble des signifiants.  * Évidence (affordance): évidence physique  pragmatique des éléments. '),
(15, 'Relation semantique forte', 7, 'Relation entre objet ou information affichée et référent.'''),
(16, 'Coherence externe', 8, 'similitude entre divers éléments, environnements et applications.');

-- --------------------------------------------------------

--
-- Structure de la table `critere_nielsen`
--

CREATE TABLE IF NOT EXISTS `critere_nielsen` (
  `idcritaire` int(11) NOT NULL AUTO_INCREMENT,
  `libcritaire` varchar(45) DEFAULT NULL,
  `idcategorie` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcritaire`),
  KEY `FKAB353B79D0CA50F` (`idcategorie`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Contenu de la table `critere_nielsen`
--

INSERT INTO `critere_nielsen` (`idcritaire`, `libcritaire`, `idcategorie`) VALUES
(1, 'Visibility of system status', 9),
(2, 'Match between system and real world', 9),
(3, 'User control and freedom', 9),
(4, 'Consistency and standards', 9),
(5, 'Error prevention', 9),
(6, 'Recognition rather than recall', 9),
(7, 'Flexibility and efficiency of use', 9),
(8, 'Aesthetic and minimalist design', 9),
(9, 'Help users recover from errors', 9),
(10, 'Help and documentation', 9),
(11, 'Navigation', 9),
(12, 'Use of modes', 9),
(13, 'Structure of information', 9),
(14, 'Enjoyment', 9),
(15, 'Physical constraints', 9),
(16, 'Extraordinary users', 9);

-- --------------------------------------------------------

--
-- Structure de la table `grille`
--

CREATE TABLE IF NOT EXISTS `grille` (
  `idgrille` int(11) NOT NULL AUTO_INCREMENT,
  `nomgrille` varchar(30) NOT NULL,
  `Date` varchar(20) DEFAULT NULL,
  `type` int(11) NOT NULL,
  `idTerm` int(11) DEFAULT NULL,
  `idpopulation` int(11) DEFAULT NULL,
  `idtype` int(11) DEFAULT NULL,
  `note` int(11) DEFAULT NULL,
  PRIMARY KEY (`idgrille`),
  UNIQUE KEY `index1` (`idTerm`),
  KEY `idtype` (`idtype`),
  KEY `idpopulation` (`idpopulation`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Contenu de la table `grille`
--

INSERT INTO `grille` (`idgrille`, `nomgrille`, `Date`, `type`, `idTerm`, `idpopulation`, `idtype`, `note`) VALUES
(19, 'Site web del l''INSAT', '10/03/2014', 2, NULL, NULL, NULL, 70);

-- --------------------------------------------------------

--
-- Structure de la table `lignegrille`
--

CREATE TABLE IF NOT EXISTS `lignegrille` (
  `idigne` int(11) NOT NULL AUTO_INCREMENT,
  `idgrille` int(11) NOT NULL,
  `idquestion` int(11) NOT NULL,
  `reponse` int(11) NOT NULL,
  `justification` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`idigne`),
  KEY `idgrille` (`idgrille`),
  KEY `idquestion` (`idquestion`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=49 ;

--
-- Contenu de la table `lignegrille`
--

INSERT INTO `lignegrille` (`idigne`, `idgrille`, `idquestion`, `reponse`, `justification`) VALUES
(37, 19, 17, 2, 'justification 1 '),
(38, 19, 11, 4, 'justification 2'),
(39, 19, 10, 4, 'justification 3'),
(40, 19, 9, 2, 'justification 4'),
(41, 19, 8, 4, 'justification 5'),
(42, 19, 7, 3, 'justification 7'),
(43, 19, 15, 1, NULL),
(44, 19, 26, 1, NULL),
(45, 19, 27, 4, NULL),
(46, 19, 38, 1, 'justification 8'),
(47, 19, 39, 4, NULL),
(48, 19, 40, 1, 'justification 9');

-- --------------------------------------------------------

--
-- Structure de la table `population_cible`
--

CREATE TABLE IF NOT EXISTS `population_cible` (
  `idpopulation` int(11) NOT NULL AUTO_INCREMENT,
  `libpopulation` varchar(50) NOT NULL,
  PRIMARY KEY (`idpopulation`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `population_cible`
--

INSERT INTO `population_cible` (`idpopulation`, `libpopulation`) VALUES
(1, 'Enfant'),
(2, 'Adolescent');

-- --------------------------------------------------------

--
-- Structure de la table `question-population`
--

CREATE TABLE IF NOT EXISTS `question-population` (
  `idq` int(11) NOT NULL,
  `idp` int(11) NOT NULL,
  PRIMARY KEY (`idq`,`idp`),
  KEY `question-population_ibfk_2` (`idp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `question-population`
--

INSERT INTO `question-population` (`idq`, `idp`) VALUES
(4, 1),
(5, 1),
(5, 2);

-- --------------------------------------------------------

--
-- Structure de la table `question-terminal`
--

CREATE TABLE IF NOT EXISTS `question-terminal` (
  `idq` int(11) NOT NULL,
  `idt` int(11) NOT NULL,
  PRIMARY KEY (`idq`,`idt`),
  KEY `question-terminal_ibfk_2` (`idt`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `question-terminal`
--

INSERT INTO `question-terminal` (`idq`, `idt`) VALUES
(4, 1),
(4, 2);

-- --------------------------------------------------------

--
-- Structure de la table `question-type`
--

CREATE TABLE IF NOT EXISTS `question-type` (
  `idq` int(11) NOT NULL,
  `idt` int(11) NOT NULL,
  PRIMARY KEY (`idq`,`idt`),
  KEY `question-type_ibfk_2` (`idt`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `question-type`
--

INSERT INTO `question-type` (`idq`, `idt`) VALUES
(4, 1),
(6, 2),
(22, 2),
(7, 3),
(12, 3);

-- --------------------------------------------------------

--
-- Structure de la table `question_bs`
--

CREATE TABLE IF NOT EXISTS `question_bs` (
  `idquestion` int(11) NOT NULL AUTO_INCREMENT,
  `question` text,
  `idcritaire` int(11) DEFAULT NULL,
  PRIMARY KEY (`idquestion`),
  KEY `idcritaire_idx` (`idcritaire`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=56 ;

--
-- Contenu de la table `question_bs`
--

INSERT INTO `question_bs` (`idquestion`, `question`, `idcritaire`) VALUES
(4, 'L''utilisateur est-il assisté dans la façon de se servir du logiciel (en\r\nfournissant par exemple le format de saisie des données, une liste des\r\nvaleurs possibles, etc.) ?', 1),
(5, 'Une aide en ligne est-elle proposée ?', 1),
(6, 'La documentation est-elle claire ?', 1),
(7, 'Le logiciel correspond-il au contexte d''utilisation ?', 8),
(8, 'Est-il adapté au profil des utilisateurs visés ?', 8),
(9, 'Le vocabulaire de l''interface est-il celui employé par les utilisateurs ?', 8),
(10, 'Les informations sont-elles présentées de manière cohérente par rapport\r\naux autres supports de travail ?', 8),
(11, 'L''accès aux commandes est-il adapté au contexte de réalisation de la\r\ntâche ?', 8),
(12, 'L''utilisateur est-il amené à effectuer des actions spécifiques ?', 1),
(13, 'Les informations de même type sont-elles regroupées ?', 2),
(14, 'Distingue-t-on les données différentes ?', 2),
(15, 'Le système fournit-il un retour aux actions de l''utilisateur ?', 8),
(16, 'Les opérations réalisées par le système sont-elles perceptibles ?', 8),
(17, 'Les informations sont-elles correctement lisibles et interprétables ?', 4),
(18, 'L''agencement des fenêtres est-il semblable (tracé régulateur) ?', 6),
(19, 'Les couleurs, les icônes, les éléments graphiques et les polices de\r\ncaractères sont-ils utilisés de façon cohérente ?', 6),
(20, 'Les formats de présentation des données sont-ils constants ?', 6),
(21, 'Un vocabulaire uniforme est-il utilisé dans l''ensemble des fenêtres ?', 6),
(22, 'Le fonctionnement de la souris est-il cohérent ?', 6),
(23, 'Le logiciel est-il cohérent du point de vue de son comportement ?', 6),
(24, 'Différents moyens sont-ils offerts à l''utilisateur pour déclencher les\r\nmêmes commandes ?', 4),
(25, 'Les commandes sont-elles également accessibles au clavier ?', 4),
(26, 'L''utilisateur peut-il paramétrer le logiciel selon ses préférences ?', 10),
(27, 'Une alternative rapide est-elle proposée à l''utilisation des menus (par\r\nexemple des raccourcis clavier) ?', 10),
(28, 'Les fonctions sont-elles toujours explicitement activées par l''utilisateur ?', 3),
(29, 'Peut-il quitter, abandonner facilement ou interrompre un traitement en\r\ncours ?', 3),
(30, 'L''utilisateur peut-il revenir en arrière ?', 3),
(31, 'L''utilisateur maîtrise-t-il tous les traitements réalisés par le système ?', 3),
(32, 'Est-il possible d''explorer le logiciel sans risque ?', 5),
(33, 'L''impact des erreurs est-il minimisé ?', 5),
(34, 'Le système offre-t-il des moyens de prévenir des erreurs (boutons grisés,\r\nliste des valeurs possibles, affichage des unités, …) ?', 5),
(35, 'L''utilisateur est-il prévenu rapidement de son erreur ?', 5),
(36, 'L''utilisation du clavier est-elle minimale ?', 5),
(37, 'L''utilisateur est-il averti lors d''opérations dangereuses ?', 5),
(38, 'Les messages sont-ils bien visibles ?', 12),
(39, 'La nature et les causes des erreurs sont-elles aisément identifiables ?', 12),
(40, 'Les messages sont-ils explicites concernant les moyens de corriger\r\nl''erreur ?', 12),
(41, 'Les erreurs peuvent-elles être facilement corrigées ?', 13),
(42, 'Les éléments erronés sont-ils mis en évidence ?', 13),
(43, 'Existe-t-il un moyen de récupérer des données détruites ?', 13),
(44, 'Les activités de perception et de mémorisation sont-elles réduites au\r\nminimum ?', 2),
(45, 'Le nombre d''options dans les menus est-il raisonnable ?', 2),
(46, 'Les labels et textes sont-ils concis ?', 2),
(47, 'Les saisies sont-elles réduites au minimum ?', 2),
(48, 'Le nombre d''étapes pour atteindre un but est-il minimal ?', 2),
(49, 'Existe-t-il des raccourcis ?', 2),
(50, 'L''affichage demande-t-il un effort de perception ?', 6),
(51, 'Y a-t-il des informations inutiles à l''écran ?', 6),
(52, 'Les textes sont ils rédigés de manière simple ?', 6),
(53, 'Tous les éléments de l''interface sont-ils facilement interprétables par\r\nl''utilisateur ?', 7),
(54, 'L''application respecte-t-elle les standards en vigueur dans le domaine\r\nd''application ?', 7),
(55, 'Les abréviations et autres codages sont-ils compréhensibles ?', 7);

-- --------------------------------------------------------

--
-- Structure de la table `question_nielsen`
--

CREATE TABLE IF NOT EXISTS `question_nielsen` (
  `idquestion` int(11) NOT NULL AUTO_INCREMENT,
  `question` text,
  `idcritaire` int(11) DEFAULT NULL,
  PRIMARY KEY (`idquestion`),
  KEY `idcritaire2_idx` (`idcritaire`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=87 ;

--
-- Contenu de la table `question_nielsen`
--

INSERT INTO `question_nielsen` (`idquestion`, `question`, `idcritaire`) VALUES
(1, 'Is status feedback provided continuously (eg progress indicators or messages)?', 1),
(2, 'Are warning messages displayed for long enough?', 1),
(3, 'Is there provision for some form of feedback?', 1),
(4, 'Are the words, phrases and concepts used familiar to the user?', 2),
(5, 'Does the task sequence parallel the user''s work processes?', 2),
(6, 'Is information presented in a simple, natural and logical order?', 2),
(7, 'Is the use of metaphors easily understandable by the user?', 2),
(8, 'Does the system cater for users with no prior experience of electronic devices?', 2),
(9, 'Does the system make the user''s work easier and quicker than without the system?', 2),
(10, '	Does the system fit in with the environment in which the user''s tasks are carried out?', 2),
(11, 'Can the system realistically reflect real world situations and appear to respond to the user?', 2),
(12, 'Are important controls represented on the screen and is there an obvious mapping between them and the real controls?', 2),
(13, 'Are facilities provided to "undo" (or "cancel") and "redo" actions?', 3),
(14, 'Are there clearly marked exits (for when the user finds themselves somewhere unexpected)?', 3),
(15, 'Are facilities provided to return to the top level at any stage (eg links back to homepage)?', 3),
(16, 'Is the use of terminology, controls, graphics and menus consistent throughout the system?', 4),
(17, 'Is there consistency between data entry and data display?', 4),
(18, 'Is the interface consistent with any platform conventions?', 4),
(19, 'Have ambiguous phrases/actions been avoided?', 4),
(20, 'Is the interface consistent with standard PC conventions?', 4),
(21, 'Is interactive TV consistent with the related TV programmes (and are the colours consistent between them)?', 4),
(22, 'Have colour and style conventions been followed for links (and no other text)?', 4),
(23, 'Is a selection method provided (eg from a list) as an alternative to direct entry of information?', 5),
(24, 'Is user confirmation required before carrying out a potentially ''dangerous'' action (eg deleting something)?', 5),
(25, 'Does the system ensure work is not lost either by user or system error?', 5),
(26, 'Does the system prevent calls being accidentally made?', 5),
(27, 'Are the options given in dialog boxes obvious?', 5),
(28, 'Does the system provide foolproof synchronization with a PC?', 5),
(29, 'Has the possibility of the user making errors been removed?', 5),
(30, 'Is the system robust and safe enough for its surroundings?', 5),
(31, 'Are help and instructions visible or easily accessible when needed?', 6),
(32, 'Is the relationship between controls and their actions obvious?', 6),
(33, 'Is it possible to search for information (eg a phone number) rather than entering the information directly?', 6),
(34, 'Is the functionality of the buttons on the device obvious from their labels?', 6),
(35, 'Are input formats (eg dates or lengths of names) and units of values indicated?', 6),
(36, 'Is the functionality of novel device controls (eg thumbwheels) obvious?', 6),
(37, 'Does the system allow for a range of user expertise?', 7),
(38, 'Does the system guide novice users sufficiently?', 7),
(39, 'Is it possible for expert users to use shortcuts and to tailor frequent actions?', 7),
(40, 'Is it possible to access and re-use a recent history of instructions (eg recently called numbers)?', 7),
(41, 'Does the system allow for a range of user goals and interaction styles?', 7),
(42, 'Does the system allow all functionality to be accessed either using function buttons or using the stylus?', 7),
(43, 'Is it possible to replace and restore default settings easily?', 7),
(44, 'Have unnecessary registrations been avoided?', 7),
(45, 'Is the design simple, intuitive, easy to learn and pleasing?', 8),
(46, 'Is the system free from irrelevant, unnecessary and distracting information?', 8),
(47, 'Are icons clear and buttons labelled and is the use of graphic controls obvious?', 8),
(48, 'Is the information displayed at any one time kept to a minimum?', 8),
(49, 'Is the number of applications provided appropriate (and has ''featuritis'' been avoided)?', 8),
(50, 'Has the need to scroll been minimized and where necessary, are navigation facilities repeated at the bottom of the screen?', 8),
(51, 'Is the system easy to remember how to use?', 8),
(52, 'Have excessive scripts, applets, movies, graphics and images been avoided?', 8),
(53, 'Do error messages describe problems sufficiently, assist in their diagnosis and suggest ways of recovery in a constructive way?', 9),
(54, 'Are error messages written in a non-derisory tone and refrain from attributing blame to the user?', 9),
(55, 'Is it clear how the user can recover from errors?', 9),
(56, 'Is help clear and direct and simply expressed in plain English, free from jargon and buzzwords?', 10),
(57, 'Is help provided in a series of steps that can be easily followed?', 10),
(58, 'Is it easy for the user to search, understand and apply help text?', 10),
(59, 'Is navigational feedback provided (eg showing a user''s current and initial states, where they''ve been and what options they have for where to go)?', 11),
(60, 'Are any navigational aids provided (eg find facilities)?', 11),
(61, 'Does the system track where the user was in the last session (and any progress made)?\r\n', 11),
(62, 'Has opening unecessary new browser windows been avoided?', 11),
(63, 'Does the system use different modes appropriately and effectively?', 12),
(64, 'Is it easy to exit from each mode of use?', 12),
(65, 'Is there a hierarchical organisation of information from general to specific?', 13),
(66, 'Are related pieces of information clustered together?', 13),
(67, 'Is the length of a piece of text appropriate to the display size and interaction device?', 13),
(68, 'Has the number of screens required per task been minimized?', 13),
(69, 'Does each screen comprise 1 document on 1 topic with the most important information appearing at the top?', 13),
(70, 'Has hypertext been used appropriately to structure content and are links intuitive and descriptive?', 13),
(71, 'Have pages been structured to facilitate scanning by the reader?', 13),
(72, 'Are the URLs, page titles and headlines straightforward, short and descriptive?', 13),
(73, 'Has excessive use of whitespace been avoided?', 13),
(74, 'Has textual content been kept to a maximum of two columns?', 13),
(75, 'Is the system fun to use?', 14),
(76, 'Are function buttons large enough to be usable?', 15),
(77, 'Is the screen visible at a range of distances and in various types of lighting?', 15),
(78, 'Does the touch-screen cater for users touching the screen quickly and slowly?', 15),
(79, 'Is the distance between targets (eg icons) and the size of the targets appropriate (size should be proportional to distance)?', 15),
(80, 'Has the use of text in images and large or irregular imagemaps been avoided?', 15),
(81, 'Is the use of colour restricted appropriately (and suitable for colour-blind users)?', 16),
(82, 'Do the buttons allow for use by older, less agile fingers or people wearing gloves?', 16),
(83, 'Do buttons give tactile feedback when selected?', 16),
(84, 'Is the touch-screen usable by people of all heights and those in wheelchairs?', 16),
(85, 'Are equivalent alternatives provided for visual and auditory content?', 16),
(86, 'Have accessibility and internationalization guidelines been applied if appropriate?', 16);

-- --------------------------------------------------------

--
-- Structure de la table `terminal`
--

CREATE TABLE IF NOT EXISTS `terminal` (
  `idterminal` int(11) NOT NULL AUTO_INCREMENT,
  `libteriminal` varchar(20) NOT NULL,
  `resolution` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idterminal`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `terminal`
--

INSERT INTO `terminal` (`idterminal`, `libteriminal`, `resolution`) VALUES
(1, 'Ordinateur', '1024 x 768'),
(2, 'Smartphone', '320×480'),
(3, 'Tablette', '800×480');

-- --------------------------------------------------------

--
-- Structure de la table `type_application`
--

CREATE TABLE IF NOT EXISTS `type_application` (
  `idtype` int(11) NOT NULL AUTO_INCREMENT,
  `libtype` varchar(50) NOT NULL,
  PRIMARY KEY (`idtype`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `type_application`
--

INSERT INTO `type_application` (`idtype`, `libtype`) VALUES
(1, 'Jeux'),
(2, 'Educatifs'),
(3, 'Professionnelle');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `critere_bs`
--
ALTER TABLE `critere_bs`
  ADD CONSTRAINT `idcategorie` FOREIGN KEY (`idcategorie`) REFERENCES `categorie` (`idCategorie`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `critere_nielsen`
--
ALTER TABLE `critere_nielsen`
  ADD CONSTRAINT `FKAB353B79D0CA50F` FOREIGN KEY (`idcategorie`) REFERENCES `categorie` (`idCategorie`);

--
-- Contraintes pour la table `grille`
--
ALTER TABLE `grille`
  ADD CONSTRAINT `grille_ibfk_1` FOREIGN KEY (`idTerm`) REFERENCES `terminal` (`idterminal`),
  ADD CONSTRAINT `grille_ibfk_2` FOREIGN KEY (`idpopulation`) REFERENCES `population_cible` (`idpopulation`),
  ADD CONSTRAINT `grille_ibfk_3` FOREIGN KEY (`idtype`) REFERENCES `type_application` (`idtype`);

--
-- Contraintes pour la table `lignegrille`
--
ALTER TABLE `lignegrille`
  ADD CONSTRAINT `lignegrille_ibfk_1` FOREIGN KEY (`idgrille`) REFERENCES `grille` (`idgrille`) ON DELETE CASCADE,
  ADD CONSTRAINT `lignegrille_ibfk_2` FOREIGN KEY (`idquestion`) REFERENCES `question_bs` (`idquestion`);

--
-- Contraintes pour la table `question-population`
--
ALTER TABLE `question-population`
  ADD CONSTRAINT `question-population_ibfk_1` FOREIGN KEY (`idq`) REFERENCES `question_bs` (`idquestion`),
  ADD CONSTRAINT `question-population_ibfk_2` FOREIGN KEY (`idp`) REFERENCES `population_cible` (`idpopulation`);

--
-- Contraintes pour la table `question-terminal`
--
ALTER TABLE `question-terminal`
  ADD CONSTRAINT `question-terminal_ibfk_1` FOREIGN KEY (`idq`) REFERENCES `question_bs` (`idquestion`),
  ADD CONSTRAINT `question-terminal_ibfk_2` FOREIGN KEY (`idt`) REFERENCES `terminal` (`idterminal`);

--
-- Contraintes pour la table `question-type`
--
ALTER TABLE `question-type`
  ADD CONSTRAINT `question-type_ibfk_1` FOREIGN KEY (`idq`) REFERENCES `question_bs` (`idquestion`),
  ADD CONSTRAINT `question-type_ibfk_2` FOREIGN KEY (`idt`) REFERENCES `type_application` (`idtype`);

--
-- Contraintes pour la table `question_bs`
--
ALTER TABLE `question_bs`
  ADD CONSTRAINT `idcritaire` FOREIGN KEY (`idcritaire`) REFERENCES `critere_bs` (`idcritaire`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `question_nielsen`
--
ALTER TABLE `question_nielsen`
  ADD CONSTRAINT `idcritaire2` FOREIGN KEY (`idcritaire`) REFERENCES `critere_nielsen` (`idcritaire`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
