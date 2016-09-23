-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.17 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.3.0.5027
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para dbcandidatos
CREATE DATABASE IF NOT EXISTS `gc_aitor` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `gc_aitor`;


-- Volcando estructura para tabla dbcandidatos.candidatos
CREATE TABLE IF NOT EXISTS `candidatos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(50) DEFAULT '0',
  `nombre` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `Índice 2` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla dbcandidatos.candidatos: ~6 rows (aproximadamente)
DELETE FROM `candidatos`;
/*!40000 ALTER TABLE `candidatos` DISABLE KEYS */;
INSERT INTO `candidatos` (`id`, `dni`, `nombre`) VALUES
	(1, '12345678p', 'ramon'),
	(2, '12345678g', 'teresa'),
	(3, '34565432t', 'carlos'),
	(4, '6565ttt', 'Swety'),
	(7, '44445566', 'Paco'),
	(17, 'pepe', 'pep');
/*!40000 ALTER TABLE `candidatos` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
