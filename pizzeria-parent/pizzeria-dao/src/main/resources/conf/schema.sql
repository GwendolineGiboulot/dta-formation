CREATE TABLE `pizza` (
  `id` int(11) auto_increment NOT NULL,
  `categorie` varchar(255) DEFAULT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(25) DEFAULT NULL,
  `prix` double DEFAULT NULL,
  `url_image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

