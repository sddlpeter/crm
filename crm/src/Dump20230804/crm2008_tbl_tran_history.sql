-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: crm2008
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `tbl_tran_history`
--

DROP TABLE IF EXISTS `tbl_tran_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_tran_history` (
  `id` char(32) NOT NULL,
  `stage` varchar(255) DEFAULT NULL,
  `money` varchar(255) DEFAULT NULL,
  `expected_date` char(10) DEFAULT NULL,
  `create_time` char(19) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `tran_id` char(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_tran_history`
--

LOCK TABLES `tbl_tran_history` WRITE;
/*!40000 ALTER TABLE `tbl_tran_history` DISABLE KEYS */;
INSERT INTO `tbl_tran_history` VALUES ('4e8d22e1d5294a418bcf866108b5b145','29805c804dd94974b568cfc9017b2e4c','500','2023-08-31','2023-08-03 09:54:50','40f6cdea0bd34aceb77492a1656d9fb3','6470131b4fd9412f80bf86c7689afbff'),('5c3189d628dc4fc3a28a7f9d2eaee057','29805c804dd94974b568cfc9017b2e4c','500','2023-09-01','2023-08-03 10:16:25','40f6cdea0bd34aceb77492a1656d9fb3','70a69a0c8c894e029d3e5e1bdbdc8174'),('7124555df2a44822813f553e67b4ce29','e81577d9458f4e4192a44650a3a3692b','500','2023-09-01','2023-08-03 10:24:10','40f6cdea0bd34aceb77492a1656d9fb3','fe60ed246f82435a9bb0ba04d6e8f4df'),('7234c9b398eb4989ab8b199e149552dd','29805c804dd94974b568cfc9017b2e4c','500','2023-08-31','2023-08-03 09:54:53','40f6cdea0bd34aceb77492a1656d9fb3','25f001b1621540d1a039f07cf9daa658'),('939d9d5bf9bd45a6b5ec2133ddbe8e13','c13ad8f9e2f74d5aa84697bb243be3bb','500','2023-08-31','2023-08-03 10:03:14','40f6cdea0bd34aceb77492a1656d9fb3','d4209449fa6c4b959f32544ccf93f107'),('98748f0bd8e6445988ee34a4bed7831a','c13ad8f9e2f74d5aa84697bb243be3bb','500','2023-08-31','2023-08-03 09:58:55','40f6cdea0bd34aceb77492a1656d9fb3','4e93a6751eba452a9fae916cf0e13a5a'),('c08d686e22c34ee6a2b2eb2d0198fe65','c13ad8f9e2f74d5aa84697bb243be3bb','500','2023-09-01','2023-08-03 10:11:48','40f6cdea0bd34aceb77492a1656d9fb3','783b299780c54757ada3fe6985a5f30c'),('e492fa05fc554127a7b6bad7e884bea0','29805c804dd94974b568cfc9017b2e4c','500','2023-09-01','2023-08-03 10:21:08','40f6cdea0bd34aceb77492a1656d9fb3','ca90b45610ca4ee1b9044b2f81711df4'),('e622474b97cf442ab24866e212e7303b','c13ad8f9e2f74d5aa84697bb243be3bb','','2023-09-01','2023-08-03 10:07:26','40f6cdea0bd34aceb77492a1656d9fb3','9ad36490cb044f38b3d89930e76a9150');
/*!40000 ALTER TABLE `tbl_tran_history` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-04  9:02:07
