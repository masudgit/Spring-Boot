-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.19-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for crossride
CREATE DATABASE IF NOT EXISTS `crossride` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `crossride`;


-- Dumping structure for table crossride.person
CREATE TABLE IF NOT EXISTS `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `registration_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table crossride.person: ~2 rows (approximately)
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` (`id`, `name`, `email`, `registration_number`) VALUES
	(1, 'masud', 'masud@yahoo.com', '01712'),
	(2, 'rassel', 'rassel@gmail.com', '01835'),
	(3, 'abdullah', 'abdullah@yahoo.com', '01914');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;


-- Dumping structure for table crossride.ride
CREATE TABLE IF NOT EXISTS `ride` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `driver_id` bigint(20) DEFAULT NULL,
  `rider_id` bigint(20) DEFAULT NULL,
  `start_time` varchar(255) DEFAULT NULL,
  `end_time` varchar(255) DEFAULT NULL,
  `distance` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_address_person_driver` (`driver_id`),
  KEY `fk_address_person_rider` (`rider_id`),
  CONSTRAINT `fk_address_person_driver` FOREIGN KEY (`driver_id`) REFERENCES `person` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_address_person_rider` FOREIGN KEY (`rider_id`) REFERENCES `person` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table crossride.ride: ~0 rows (approximately)
/*!40000 ALTER TABLE `ride` DISABLE KEYS */;
INSERT INTO `ride` (`id`, `driver_id`, `rider_id`, `start_time`, `end_time`, `distance`) VALUES
	(1, 1, 2, '2018-08-24 09:30', '2018-08-24 10:00', 7),
	(2, 1, 3, '2018-08-24 09:20', '2018-08-24 09:45', 5),
	(3, 2, 1, '2018-08-24 09:15', '2018-08-24 09:30', 6);
/*!40000 ALTER TABLE `ride` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
