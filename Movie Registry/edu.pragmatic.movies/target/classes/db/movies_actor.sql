CREATE DATABASE  IF NOT EXISTS `movies` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `movies`;

DROP TABLE IF EXISTS `actor`;
CREATE TABLE `actor` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) DEFAULT NULL,
  `LAST_NAME` varchar(45) DEFAULT NULL,
  `BIRTH_DAY` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

LOCK TABLES `actor` WRITE;

INSERT INTO `actor` VALUES (1,'Morgan','Freeman','1936-12-27'),(2,'Tim',' Robbins','1957-12-29'),(3,'Morgan','Freeman','1936-12-27'),(4,'Tim',' Robbins','1957-12-29'),(5,'Morgan','Freeman','1939-12-31'),(6,'Al','Pacino','1923-12-30'),(7,'Marlon','Brando','1923-12-30');

UNLOCK TABLES;