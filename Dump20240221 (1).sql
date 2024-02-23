-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: typespeeder
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attempt`
--

DROP TABLE IF EXISTS `attempt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attempt` (
  `attempt_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `task_id` bigint NOT NULL,
  `outcome` varchar(100) NOT NULL,
  `end_time` timestamp NOT NULL,
  `gamename` varchar(45) NOT NULL,
  PRIMARY KEY (`attempt_id`),
  KEY `FKtask_idx` (`task_id`),
  KEY `FKuser_idx` (`user_id`),
  CONSTRAINT `FKtask` FOREIGN KEY (`task_id`) REFERENCES `gametask` (`task_id`),
  CONSTRAINT `FKuser` FOREIGN KEY (`user_id`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=162 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attempt`
--

LOCK TABLES `attempt` WRITE;
/*!40000 ALTER TABLE `attempt` DISABLE KEYS */;
INSERT INTO `attempt` VALUES (1,1,1,'40','2024-02-11 17:15:04',''),(2,1,1,'44','2024-02-11 17:32:26',''),(3,2,2,'36','2024-02-11 19:54:44',''),(4,1,1,'46','2024-02-11 20:02:00',''),(5,1,1,'32','2024-02-11 20:06:34',''),(6,1,1,'40','2024-02-11 20:07:58',''),(7,1,1,'39','2024-02-11 20:10:14',''),(8,1,2,'24','2024-02-11 20:15:49',''),(9,1,2,'48','2024-02-11 20:16:57',''),(10,1,1,'46','2024-02-11 20:18:17',''),(11,1,1,'37','2024-02-11 20:19:26',''),(12,2,1,'35','2024-02-12 07:50:23',''),(13,1,2,'45','2024-02-12 08:04:52',''),(14,1,2,'39','2024-02-12 11:31:20',''),(15,1,1,'43','2024-02-13 08:55:25',''),(16,1,2,'47','2024-02-13 10:08:23',''),(17,1,1,'50','2024-02-13 10:12:11',''),(18,2,1,'38','2024-02-13 10:13:02',''),(19,1,1,'39','2024-02-13 10:29:57',''),(20,1,2,'38','2024-02-13 10:32:15',''),(21,1,2,'47','2024-02-13 10:37:31',''),(22,2,1,'46','2024-02-13 10:39:30',''),(23,1,1,'31','2024-02-13 10:50:45',''),(24,1,2,'0','2024-02-13 11:14:13',''),(25,1,3,'47','2024-02-13 11:16:31',''),(26,2,3,'42','2024-02-13 11:17:34',''),(27,1,3,'44','2024-02-13 11:18:24',''),(28,1,2,'0','2024-02-13 11:21:02',''),(29,1,3,'39','2024-02-13 11:21:37',''),(30,1,3,'38','2024-02-13 11:23:32',''),(31,1,3,'50','2024-02-13 11:26:45',''),(32,1,3,'31','2024-02-13 11:32:17',''),(33,1,3,'42','2024-02-13 11:33:21',''),(34,1,3,'42','2024-02-13 12:02:56',''),(35,1,4,'45','2024-02-13 12:06:52',''),(36,1,4,'42','2024-02-13 12:08:57',''),(37,1,3,'46','2024-02-13 12:11:07',''),(38,1,4,'40','2024-02-13 12:11:51',''),(39,1,3,'40','2024-02-13 12:28:41',''),(40,1,1,'0','2024-02-13 14:57:38',''),(41,1,3,'28','2024-02-13 14:58:38',''),(42,1,2,'0','2024-02-13 16:44:17',''),(43,2,1,'0','2024-02-13 16:45:13',''),(44,2,1,'2','2024-02-13 16:49:51',''),(45,2,1,'0','2024-02-13 16:52:37',''),(46,2,1,'0','2024-02-13 16:57:08',''),(47,2,1,'0','2024-02-13 17:12:04',''),(48,1,2,'0','2024-02-13 17:22:38',''),(49,2,1,'0','2024-02-13 17:24:27',''),(50,2,1,'0','2024-02-13 18:19:27',''),(51,2,1,'0','2024-02-13 18:37:42',''),(52,1,2,'0','2024-02-13 18:38:19',''),(53,2,4,'29','2024-02-13 18:57:00',''),(54,2,2,'0','2024-02-13 18:58:15',''),(55,1,3,'33','2024-02-14 11:35:56',''),(56,1,2,'0','2024-02-14 18:43:05',''),(57,1,1,'0','2024-02-14 18:44:04',''),(58,2,4,'67','2024-02-14 18:44:58',''),(59,2,4,'189','2024-02-14 18:47:21',''),(60,2,4,'137','2024-02-14 18:49:45',''),(61,2,4,'63','2024-02-14 18:52:10',''),(62,2,4,'159','2024-02-14 18:56:57',''),(63,2,4,'28','2024-02-14 18:59:48',''),(64,2,4,'60132','2024-02-14 19:01:27',''),(65,2,4,'59802','2024-02-14 19:05:51',''),(66,2,4,'2002','2024-02-14 19:07:31',''),(67,2,4,'0','2024-02-14 19:22:31',''),(68,2,4,'0','2024-02-14 19:23:50',''),(69,2,4,'0','2024-02-14 19:25:16',''),(70,2,4,'0','2024-02-14 19:31:09',''),(71,2,4,'0','2024-02-14 19:33:58',''),(72,2,4,'0','2024-02-14 19:38:30',''),(73,2,4,'0','2024-02-14 19:41:46',''),(74,2,4,'0','2024-02-14 19:43:19',''),(75,2,4,'0','2024-02-15 08:18:54',''),(76,2,4,'0.000000006000893182942838','2024-02-15 08:29:04',''),(77,2,4,'0,00','2024-02-15 08:32:24',''),(78,2,4,'0,00','2024-02-15 08:38:26',''),(79,2,4,'0','2024-02-15 08:45:41',''),(80,2,4,'0','2024-02-15 08:46:59',''),(81,2,4,'0,00','2024-02-15 08:48:23',''),(82,2,4,'29','2024-02-15 09:58:41',''),(83,2,4,'35','2024-02-15 10:33:29',''),(84,2,4,'27','2024-02-15 10:39:56',''),(85,2,2,'0','2024-02-15 10:40:29',''),(86,2,2,'0','2024-02-15 10:40:52',''),(87,2,2,'0','2024-02-15 10:41:13',''),(88,2,1,'0','2024-02-15 10:42:19',''),(89,2,1,'0','2024-02-15 10:42:59',''),(90,2,1,'0','2024-02-15 10:43:11',''),(91,2,1,'0','2024-02-15 10:43:21',''),(92,2,1,'0','2024-02-15 10:43:33',''),(93,2,1,'0','2024-02-15 10:43:45',''),(94,2,1,'0','2024-02-15 10:44:35',''),(95,2,1,'0','2024-02-15 11:03:54',''),(96,2,4,'21','2024-02-15 11:04:50',''),(97,2,4,'28','2024-02-15 11:08:06',''),(98,2,1,'0','2024-02-15 11:08:42',''),(99,2,4,'31','2024-02-15 11:09:36',''),(100,2,4,'22','2024-02-15 11:55:48',''),(101,2,1,'0','2024-02-15 11:57:13',''),(102,2,1,'0','2024-02-15 11:58:42',''),(103,2,1,'0','2024-02-15 11:59:27',''),(104,2,4,'18','2024-02-15 12:00:03',''),(105,2,4,'0','2024-02-15 12:01:41',''),(106,2,4,'0','2024-02-15 12:02:57',''),(107,2,4,'29','2024-02-15 12:05:46',''),(108,2,4,'28','2024-02-15 12:09:42',''),(109,2,1,'0','2024-02-15 12:10:28',''),(110,2,1,'0','2024-02-15 12:11:08',''),(111,2,1,'0','2024-02-15 12:11:45',''),(112,2,1,'0','2024-02-15 12:11:55',''),(113,2,1,'0','2024-02-15 12:12:03',''),(114,1,3,'30','2024-02-15 12:15:26',''),(115,1,3,'32','2024-02-15 12:17:08',''),(116,1,3,'29','2024-02-15 12:18:57',''),(117,1,3,'27','2024-02-15 12:19:45',''),(118,1,3,'35','2024-02-15 12:20:30',''),(119,2,1,'0','2024-02-15 12:20:51',''),(120,1,3,'29','2024-02-15 12:21:45',''),(121,1,3,'30','2024-02-15 12:22:25',''),(122,1,3,'24','2024-02-15 12:23:14',''),(123,2,1,'0','2024-02-15 12:24:58',''),(124,2,4,'4','2024-02-15 12:27:47',''),(125,2,1,'0','2024-02-15 12:28:43',''),(126,2,1,'0','2024-02-15 12:34:53',''),(127,2,1,'0','2024-02-15 12:36:15',''),(128,2,1,'0','2024-02-15 12:36:30',''),(129,2,1,'0','2024-02-15 12:36:51',''),(130,2,4,'26','2024-02-15 18:35:33',''),(131,2,4,'28','2024-02-15 18:50:02',''),(132,2,4,'30','2024-02-15 19:00:48',''),(133,2,1,'0','2024-02-15 19:05:34',''),(134,2,1,'0','2024-02-15 19:15:02',''),(135,1,2,'0','2024-02-19 11:08:32',''),(136,1,4,'29','2024-02-19 12:07:18',''),(137,2,4,'28','2024-02-19 12:18:34',''),(138,3,2,'0','2024-02-20 09:09:13',''),(139,3,3,'32','2024-02-20 09:10:34',''),(140,2,1,'0','2024-02-20 11:34:51',''),(141,2,2,'0','2024-02-20 11:35:48',''),(142,1,3,'69','2024-02-20 12:20:44',''),(143,1,3,'47','2024-02-20 15:26:27',''),(144,1,3,'53','2024-02-20 16:07:33',''),(145,1,3,'32','2024-02-20 16:31:10',''),(146,1,1,'0','2024-02-20 20:07:43',''),(147,1,3,'44','2024-02-20 20:08:13',''),(148,1,3,'51','2024-02-21 08:49:44',''),(149,1,1,'0','2024-02-21 08:59:59',''),(150,1,3,'46','2024-02-21 09:05:44',''),(151,1,3,'47','2024-02-21 09:36:24','EmSley77'),(152,2,1,'0','2024-02-21 09:42:50','ZakJ'),(153,1,5,'43','2024-02-21 10:15:01','emsley'),(154,1,1,'0','2024-02-21 10:36:38','emsley77'),(155,2,2,'0','2024-02-22 09:36:41','zakJ'),(156,2,9,'0','2024-02-22 12:19:21','zakj'),(157,2,2,'0','2024-02-22 19:06:36','ZakJ'),(158,2,5,'0','2024-02-22 19:07:34','zakj'),(159,5,2,'0','2024-02-22 19:28:43','laban'),(160,4,1,'0','2024-02-22 19:29:00','Husse'),(161,2,2,'0','2024-02-22 20:38:51','zakj');
/*!40000 ALTER TABLE `attempt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gametask`
--

DROP TABLE IF EXISTS `gametask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gametask` (
  `task_id` bigint NOT NULL AUTO_INCREMENT,
  `language` enum('engelska','svenska') NOT NULL,
  `task_type` int NOT NULL,
  `created_timestamp` timestamp NOT NULL,
  `solution` text NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gametask`
--

LOCK TABLES `gametask` WRITE;
/*!40000 ALTER TABLE `gametask` DISABLE KEYS */;
INSERT INTO `gametask` VALUES (1,'svenska',2,'2024-01-10 23:00:00','hej','test'),(2,'engelska',1,'2024-01-10 23:00:00','hej','test1'),(3,'engelska',2,'2024-01-12 23:00:00','apple table chair book dog house car sky cloud music','lowerCase'),(4,'svenska',1,'2024-01-12 23:00:00','Bil Hund Sol Äpple Vatten Skola Träd Hus Katt Blomma hej kan fan','Stor bokstav i början'),(5,'engelska',3,'2024-02-19 23:00:00','Welcome home soldier, sit down and get comfortable','hard sentence'),(6,'engelska',2,'2024-02-20 23:00:00','Central Park, an oasis amidst city chaos, offers tranquility. Sunlight filters through lush trees, casting dappled shadows on winding paths where visitors find solace. Couples stroll, children laugh, and solitary readers seek refuge on benches. The park\'s lakes mirror skyscrapers, a juxtaposition of nature and urban life. With each season, Central Park transforms – cherry blossoms in spring, vibrant foliage in fall, and a soft blanket of snow in winter. It\'s a sanctuary where time stands still, offering respite from daily demands. Amidst ceaseless city energy, Central Park remains a cherished haven for all seeking peace.','Little text'),(7,'svenska',2,'2024-02-20 23:00:00','Central Park, en oas mitt i stadens kaos, erbjuder lugn. Solljuset sipprar genom grönskande träd, kastar fläckiga skuggor på slingrande stigar där besökare finner frid. Par promenerar, barn skrattar, och ensamma läsare söker skydd på bänkar. Parkens sjöar speglar skyskrapor, en kontrast mellan natur och stadsliv. Med varje säsong förvandlas Central Park – körsbärsblommor på våren, färgglada löv på hösten, och ett mjukt täcke av snö på vintern. Det är en fristad där tiden står stilla, och erbjuder vila från dagliga krav. Mitt i stadens oavbrutna energi förblir Central Park en uppskattad tillflyktsort för alla som söker frid.','Liten text'),(8,'engelska',3,'2024-02-20 23:00:00','Cen%tr#al Pa&rk, an oas#is am%id^st city ch#aos, of%fe&rs tr%anq$uili^ty. Su%nli!ght fil#ters throug~h l%ush tre!es, cast$ing dapp~led shadows o%n win!ding paths where vi!sit^ors fin!d s^olace. Co%upl^es stro%ll, childr#en lau!gh, an!d so%lit#ary r#ea&ders se%ek r%efu%ge on b%enches. The pa$r^k\'s la%ke&s mirr%or skysc^ra&p%ers, a ju&x%taposition of n^at#ure a&nd urb^an life. Wi!th each s#ea!son, Ce%ntral Park tr^ansf%orms – ch#erry blos%som^s in s~pring, vibra!nt fo%liag#e in fa!ll, and a soft b^lank~et of s%no&w in wint!er','Very tough text'),(9,'svenska',3,'2024-02-20 23:00:00','C^e%n#tr&a!l P¤ark, en o!a#s^is a%m&i#d^st ci#ty k^a&os, of!fe#r*s t^r&a%nq%ui¤lit#y. S^u%nl!ig^h%t f^i!lt#er s^ g^e&n%om lu#sh t^r&ä#d, k#as^t*i!ng dap!p%l#ed s^h#adows p&å v^i#nd*a!d^e s!t^ig#ar d^ä&r b&es^ök&a!r f^i!nd s^o!l&a!c#. P#a!r st^r&oll^ar, b^a&r^n l^a!u#gh&a!r, o!c^h s^o!l^it&a!r l#äs^a!r sök#er r&a!f^u%g^e o%m b&ä#n^ch#a!r. P#a&r^k^e%ns l&a!k^e¤r m&ir!ra^r sky&s^k&r#a!p^e%r&s, e!n ju¤x&t&a!p&o%si^t!i%o^n a!v n%a!t^u!r^e o!c^h u¤r^b^a!n li^f^e. M^e&d e#a!c!h s!ä!s^o%ng, C^e%n#tr^a!l P¤ar^k t^r&a!n^s%f&or!m^s – c^h&e^rr^y bl&o!s¤s^o!ms i!n sp^r&a!i!n^g, v^ib^r&a!n!t f^o^li^a#g!e i!n f%ä#l!l^, o!ch e!n so!f^t b&a!ln^ke!t o!m s^n^ö v^i!n^te!r#.','Väldigt svårt att skriva ');
/*!40000 ALTER TABLE `gametask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leaderboard`
--

DROP TABLE IF EXISTS `leaderboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leaderboard` (
  `leaderboard_id` bigint NOT NULL AUTO_INCREMENT,
  `average` double NOT NULL,
  `speed` double NOT NULL,
  `mostrights` int NOT NULL,
  `mostright_inorder` varchar(45) NOT NULL,
  `resultcol` varchar(45) NOT NULL,
  `playerid` bigint NOT NULL,
  PRIMARY KEY (`leaderboard_id`),
  KEY `FKleaderboard_idx` (`playerid`),
  CONSTRAINT `FKleaderboard` FOREIGN KEY (`playerid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leaderboard`
--

LOCK TABLES `leaderboard` WRITE;
/*!40000 ALTER TABLE `leaderboard` DISABLE KEYS */;
INSERT INTO `leaderboard` VALUES (81,92.3076923076923,32.8495361,12,'9','21',2),(82,61.53846153846154,25.5348738,8,'5','28',2),(84,46.15384615384615,22.8907056,6,'6','31',2),(85,92.3076923076923,31.9042006,12,'9','22',2),(89,15.384615384615385,9.8803176,2,'2','18',2),(121,76,24.0717042,10,'6','29',1),(122,84,25.0892366,11,'6','28',2),(123,100,3.1271726,1,'1','0',3),(124,70,16.4398065,7,'6','32',3),(125,100,2.1306609,1,'1','0',2),(126,100,2.5413452,1,'1','0',2),(127,90,8.6571146,9,'5','69',1),(128,80,12.7637634,8,'5','47',1),(129,100,11.3136356,10,'10','53',1),(130,100,18.5120595,10,'10','32',1),(131,100,1.9156731,1,'1','0',1),(132,100,13.3641791,10,'10','44',1),(133,100,11.7336776,10,'10','51',1),(134,100,2.1808758,1,'1','0',1),(135,70,12.8177079,7,'7','46',1),(136,100,12.5864814,10,'10','47',1),(137,100,1.5709864,1,'1','0',2),(138,100,13.8916858,8,'8','43',1),(139,100,1.4944876,1,'1','0',1),(140,100,2.1025294,1,'1','0',2),(141,0,21.2525996,0,'0','0',2),(142,100,6.2094011,1,'1','0',2),(143,0,36.353165,0,'0','0',2),(144,100,1.7585222,1,'1','0',5),(145,100,2.0055032,1,'1','0',4),(146,100,2.2036614,1,'1','0',2);
/*!40000 ALTER TABLE `leaderboard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userid` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `gamelevel` int NOT NULL,
  `gamename` varchar(45) NOT NULL,
  `xp` int NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Emanuel','123',4,'EmSley77',51),(2,'zakaria','123',2,'ZakJ',80),(3,'03','30',0,'30',20),(4,'Husein','123',0,'husse',10),(5,'apan','123',0,'laban',10),(6,'todo','123',0,'todo',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-23 11:00:25
