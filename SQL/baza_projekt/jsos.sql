-- MariaDB dump 10.19  Distrib 10.10.2-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: jsos
-- ------------------------------------------------------
-- Server version	10.10.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `kraje`
--

DROP TABLE IF EXISTS `kraje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kraje` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kraje`
--

LOCK TABLES `kraje` WRITE;
/*!40000 ALTER TABLE `kraje` DISABLE KEYS */;
INSERT INTO `kraje` VALUES
(1,'Poland'),
(2,'United States of America'),
(3,'England'),
(4,'Germany'),
(5,'Austria'),
(6,'France'),
(7,'Spain'),
(8,'Norway');
/*!40000 ALTER TABLE `kraje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kursy`
--

DROP TABLE IF EXISTS `kursy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kursy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(150) DEFAULT NULL,
  `uczelnia` int(11) DEFAULT NULL,
  `Wykladowca` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uczelnia` (`uczelnia`),
  KEY `Wykladowca` (`Wykladowca`),
  CONSTRAINT `kursy_ibfk_1` FOREIGN KEY (`uczelnia`) REFERENCES `uczelnie` (`id`),
  CONSTRAINT `kursy_ibfk_2` FOREIGN KEY (`Wykladowca`) REFERENCES `uzytkownicy` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kursy`
--

LOCK TABLES `kursy` WRITE;
/*!40000 ALTER TABLE `kursy` DISABLE KEYS */;
INSERT INTO `kursy` VALUES
(1,'Bazy Danych',4,2),
(2,'Technologia Programowania',4,2);
/*!40000 ALTER TABLE `kursy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oceny`
--

DROP TABLE IF EXISTS `oceny`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oceny` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ocena` int(11) NOT NULL,
  `opis` varchar(150) DEFAULT NULL,
  `uzytkownik_id` int(11) DEFAULT NULL,
  `kurs_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uzytkownik_id` (`uzytkownik_id`),
  KEY `kurs_id` (`kurs_id`),
  CONSTRAINT `oceny_ibfk_1` FOREIGN KEY (`uzytkownik_id`) REFERENCES `uzytkownicy` (`id`),
  CONSTRAINT `oceny_ibfk_2` FOREIGN KEY (`kurs_id`) REFERENCES `kursy` (`id`),
  CONSTRAINT `Oceny_w_zakresie` CHECK (`ocena` >= 0 and `ocena` <= 6)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oceny`
--

LOCK TABLES `oceny` WRITE;
/*!40000 ALTER TABLE `oceny` DISABLE KEYS */;
INSERT INTO `oceny` VALUES
(3,3,'Kolokwium z normalizacji',1,1),
(6,4,'Kolokwium z normalizacji',1,1),
(7,5,'Projekt bazy jsos',1,1);
/*!40000 ALTER TABLE `oceny` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statusy`
--

DROP TABLE IF EXISTS `statusy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `statusy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statusy`
--

LOCK TABLES `statusy` WRITE;
/*!40000 ALTER TABLE `statusy` DISABLE KEYS */;
INSERT INTO `statusy` VALUES
(1,'student'),
(2,'wykladowca'),
(3,'administrator'),
(4,'nieaktywny'),
(5,'rektor');
/*!40000 ALTER TABLE `statusy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uczelnie`
--

DROP TABLE IF EXISTS `uczelnie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uczelnie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(50) DEFAULT NULL,
  `miasto` varchar(30) DEFAULT NULL,
  `kraj` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `kraj` (`kraj`),
  CONSTRAINT `uczelnie_ibfk_1` FOREIGN KEY (`kraj`) REFERENCES `kraje` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uczelnie`
--

LOCK TABLES `uczelnie` WRITE;
/*!40000 ALTER TABLE `uczelnie` DISABLE KEYS */;
INSERT INTO `uczelnie` VALUES
(1,'Uniwersytet Jagiellonski','Krakow',1),
(2,'Uniwersytet Warszawski','Warszawa',1),
(3,'Politechnika Warszawska','Warszawa',1),
(4,'Politechnika Wroclawska','Wroclaw',1),
(5,'Uniwersytet Wroclawski','Wroclaw',1),
(6,'West Virginia University','Morgantown',2),
(7,'Duke University','Durham',2),
(8,'Harvard University','Cambridge',2),
(9,'Yale University','New Haven',2),
(10,'University of Oxford','Oxford',3),
(11,'University of Cambridge','Cambridge',3),
(12,'University of Munich','Munich',4),
(13,'Heidelberg University','Heidelberg',4),
(14,'University of Salamanca','Salamanca',7),
(15,'University of Barcelona','Barcelona',7);
/*!40000 ALTER TABLE `uczelnie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uzytkownicy`
--

DROP TABLE IF EXISTS `uzytkownicy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uzytkownicy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imie` varchar(30) DEFAULT NULL,
  `nazwisko` varchar(30) DEFAULT NULL,
  `pochodzenie` int(11) DEFAULT NULL,
  `uczelnia` int(11) DEFAULT NULL,
  `Haslo` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pochodzenie` (`pochodzenie`),
  KEY `uczelnia` (`uczelnia`),
  CONSTRAINT `uzytkownicy_ibfk_1` FOREIGN KEY (`pochodzenie`) REFERENCES `kraje` (`id`),
  CONSTRAINT `uzytkownicy_ibfk_2` FOREIGN KEY (`uczelnia`) REFERENCES `uczelnie` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uzytkownicy`
--

LOCK TABLES `uzytkownicy` WRITE;
/*!40000 ALTER TABLE `uzytkownicy` DISABLE KEYS */;
INSERT INTO `uzytkownicy` VALUES
(1,'Adrian','Herda',1,4,'Adrian14'),
(2,'Jaroslaw','Kowalski',1,4,'Adrian14'),
(3,'Jack','Black',2,NULL,NULL);
/*!40000 ALTER TABLE `uzytkownicy` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER Czysc BEFORE DELETE ON Uzytkownicy
FOR EACH ROW
BEGIN
    DELETE FROM Uzytkownik_Status WHERE Uzytkownik_Status.uzytkownik_id=OLD.id;
    DELETE FROM Uzytkownik_Kurs WHERE Uzytkownik_Kurs.uzytkownik_id=OLD.id;
    DELETE FROM Oceny WHERE Oceny.uzytkownik_id=OLD.id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `uzytkownik_kurs`
--

DROP TABLE IF EXISTS `uzytkownik_kurs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uzytkownik_kurs` (
  `uzytkownik_id` int(11) DEFAULT NULL,
  `kurs_id` int(11) DEFAULT NULL,
  KEY `uzytkownik_id` (`uzytkownik_id`),
  KEY `kurs_id` (`kurs_id`),
  CONSTRAINT `uzytkownik_kurs_ibfk_1` FOREIGN KEY (`uzytkownik_id`) REFERENCES `uzytkownicy` (`id`),
  CONSTRAINT `uzytkownik_kurs_ibfk_2` FOREIGN KEY (`kurs_id`) REFERENCES `kursy` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uzytkownik_kurs`
--

LOCK TABLES `uzytkownik_kurs` WRITE;
/*!40000 ALTER TABLE `uzytkownik_kurs` DISABLE KEYS */;
INSERT INTO `uzytkownik_kurs` VALUES
(1,1);
/*!40000 ALTER TABLE `uzytkownik_kurs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uzytkownik_status`
--

DROP TABLE IF EXISTS `uzytkownik_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uzytkownik_status` (
  `uzytkownik_id` int(11) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  KEY `uzytkownik_id` (`uzytkownik_id`),
  KEY `status_id` (`status_id`),
  CONSTRAINT `uzytkownik_status_ibfk_1` FOREIGN KEY (`uzytkownik_id`) REFERENCES `uzytkownicy` (`id`),
  CONSTRAINT `uzytkownik_status_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `statusy` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uzytkownik_status`
--

LOCK TABLES `uzytkownik_status` WRITE;
/*!40000 ALTER TABLE `uzytkownik_status` DISABLE KEYS */;
INSERT INTO `uzytkownik_status` VALUES
(1,1),
(2,2),
(3,3);
/*!40000 ALTER TABLE `uzytkownik_status` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-25 11:58:00
