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
-- Table structure for table `tbl_dic_value`
--

DROP TABLE IF EXISTS `tbl_dic_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_dic_value` (
  `id` char(32) NOT NULL COMMENT '主键，采用UUID',
  `value` varchar(255) DEFAULT NULL COMMENT '不能为空，并且要求同一个字典类型下字典值不能重复，具有唯一性。',
  `text` varchar(255) DEFAULT NULL COMMENT '可以为空',
  `order_no` varchar(255) DEFAULT NULL COMMENT '可以为空，但不为空的时候，要求必须是正整数',
  `type_code` varchar(255) DEFAULT NULL COMMENT '外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_dic_value`
--

LOCK TABLES `tbl_dic_value` WRITE;
/*!40000 ALTER TABLE `tbl_dic_value` DISABLE KEYS */;
INSERT INTO `tbl_dic_value` VALUES ('06e3cbdf10a44eca8511dddfc6896c55','虚假线索','虚假线索','4','clueState'),('0fe33840c6d84bf78df55d49b169a894','销售邮件','销售邮件','8','source'),('12302fd42bd349c1bb768b19600e6b20','交易会','交易会','11','source'),('1615f0bb3e604552a86cde9a2ad45bea','最高','最高','2','returnPriority'),('176039d2a90e4b1a81c5ab8707268636','教授','教授','5','appellation'),('1e0bd307e6ee425599327447f8387285','将来联系','将来联系','2','clueState'),('2173663b40b949ce928db92607b5fe57','丢失线索','丢失线索','5','clueState'),('2876690b7e744333b7f1867102f91153','未启动','未启动','1','returnState'),('29805c804dd94974b568cfc9017b2e4c','成交','成交','7','stage'),('310e6a49bd8a4962b3f95a1d92eb76f4','试图联系','试图联系','1','clueState'),('31539e7ed8c848fc913e1c2c93d76fd1','博士','博士','4','appellation'),('37ef211719134b009e10b7108194cf46','资质审查','资质审查','1','stage'),('391807b5324d4f16bd58c882750ee632','丢失的线索','丢失的线索','8','stage'),('3a39605d67da48f2a3ef52e19d243953','聊天','聊天','14','source'),('474ab93e2e114816abf3ffc596b19131','低','低','3','returnPriority'),('48512bfed26145d4a38d3616e2d2cf79','广告','广告','1','source'),('4d03a42898684135809d380597ed3268','合作伙伴研讨会','合作伙伴研讨会','9','source'),('59795c49896947e1ab61b7312bd0597c','先生','先生','1','appellation'),('5c6e9e10ca414bd499c07b886f86202a','高','高','1','returnPriority'),('67165c27076e4c8599f42de57850e39c','夫人','夫人','2','appellation'),('68a1b1e814d5497a999b8f1298ace62b','因竞争丢失关闭','因竞争丢失关闭','9','stage'),('6b86f215e69f4dbd8a2daa22efccf0cf','web调研','web调研','13','source'),('72f13af8f5d34134b5b3f42c5d477510','合作伙伴','合作伙伴','6','source'),('7c07db3146794c60bf975749952176df','未联系','未联系','6','clueState'),('86c56aca9eef49058145ec20d5466c17','内部研讨会','内部研讨会','10','source'),('9095bda1f9c34f098d5b92fb870eba17','进行中','进行中','3','returnState'),('954b410341e7433faa468d3c4f7cf0d2','已有业务','已有业务','1','transaction'),('966170ead6fa481284b7d21f90364984','已联系','已联系','3','clueState'),('96b03f65dec748caa3f0b6284b19ef2f','推迟','推迟','2','returnState'),('97d1128f70294f0aac49e996ced28c8a','新业务','新业务','2','transaction'),('9ca96290352c40688de6596596565c12','完成','完成','4','returnState'),('9e6d6e15232549af853e22e703f3e015','需要条件','需要条件','7','clueState'),('9ff57750fac04f15b10ce1bbb5bb8bab','需求分析','需求分析','2','stage'),('a70dc4b4523040c696f4421462be8b2f','等待某人','等待某人','5','returnState'),('a83e75ced129421dbf11fab1f05cf8b4','推销电话','推销电话','2','source'),('ab8472aab5de4ae9b388b2f1409441c1','常规','常规','5','returnPriority'),('ab8c2a3dc05f4e3dbc7a0405f721b040','提案/报价','提案/报价','5','stage'),('b924d911426f4bc5ae3876038bc7e0ad','web下载','web下载','12','source'),('c13ad8f9e2f74d5aa84697bb243be3bb','价值建议','价值建议','3','stage'),('c83c0be184bc40708fd7b361b6f36345','最低','最低','4','returnPriority'),('db867ea866bc44678ac20c8a4a8bfefb','员工介绍','员工介绍','3','source'),('e44be1d99158476e8e44778ed36f4355','确定决策者','确定决策者','4','stage'),('e5f383d2622b4fc0959f4fe131dafc80','女士','女士','3','appellation'),('e81577d9458f4e4192a44650a3a3692b','谈判/复审','谈判/复审','6','stage'),('fb65d7fdb9c6483db02713e6bc05dd19','在线商场','在线商场','5','source'),('fd677cc3b5d047d994e16f6ece4d3d45','公开媒介','公开媒介','7','source'),('ff802a03ccea4ded8731427055681d48','外部介绍','外部介绍','4','source');
/*!40000 ALTER TABLE `tbl_dic_value` ENABLE KEYS */;
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
