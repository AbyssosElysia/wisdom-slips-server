-- MySQL dump 10.13  Distrib 8.0.40, for Linux (x86_64)
--
-- Host: localhost    Database: wisdom_slips_db
-- ------------------------------------------------------
-- Server version	8.0.40-0ubuntu0.24.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- create wisdom_slips_db
DROP DATABASE IF EXISTS `wisdom_slips_db`;
CREATE DATABASE `wisdom_slips_db`
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_general_ci;

USE `wisdom_slips_db`;

--
-- Table structure for table `function_point`
--

DROP TABLE IF EXISTS `function_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `function_point` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '历史数据id',
  `project_id` bigint NOT NULL COMMENT '对应项目id',
  `subsystem_id` bigint NOT NULL COMMENT '所属子系统id',
  `if_delete` int NOT NULL DEFAULT '0' COMMENT '是否删除：0=未删除，1=已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间：如果删除时间超过3个月，自动清理',
  `module` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所属模块名',
  `name` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '功能点名',
  `description` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '功能点描述',
  `category` varchar(5) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分类',
  `ufp` int DEFAULT '0' COMMENT '对应ufp',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='功能点';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `function_point`
--

LOCK TABLES `function_point` WRITE;
/*!40000 ALTER TABLE `function_point` DISABLE KEYS */;
/*!40000 ALTER TABLE `function_point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '查询历史id',
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '项目名',
  `user_id` bigint NOT NULL COMMENT '对应用户id',
  `if_delete` int NOT NULL DEFAULT '0' COMMENT '是否删除：0=未删除，1=已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间：如果删除时间超过3个月，自动清理',
  `ilf` int DEFAULT '0' COMMENT '内部逻辑文件',
  `eif` int DEFAULT '0' COMMENT '外部接口文件',
  `ei` int DEFAULT '0' COMMENT '外部输入',
  `eo` int DEFAULT '0' COMMENT '外部输出',
  `eq` int DEFAULT '0' COMMENT '外部查询',
  `gsc_dc` int DEFAULT '0' COMMENT '数据通信',
  `gsc_ddp` int DEFAULT '0' COMMENT '分布式数据处理',
  `gsc_p` int DEFAULT '0' COMMENT '性能',
  `gsc_huc` int DEFAULT '0' COMMENT '重度配置',
  `gsc_tr` int DEFAULT '0' COMMENT '处理速率',
  `gsc_ode` int DEFAULT '0' COMMENT '在线数据输入',
  `gsc_eue` int DEFAULT '0' COMMENT '最终用户使用效率',
  `gsc_ou` int DEFAULT '0' COMMENT '在线升级',
  `gsc_cp` int DEFAULT '0' COMMENT '复杂处理',
  `gsc_r` int DEFAULT '0' COMMENT '可重用性',
  `gsc_ie` int DEFAULT '0' COMMENT '易安装性',
  `gsc_oe` int DEFAULT '0' COMMENT '易操作性',
  `gsc_ms` int DEFAULT '0' COMMENT '多场所',
  `gsc_fc` int DEFAULT '0' COMMENT '支持变更',
  `di_sum` int DEFAULT '0' COMMENT '综合系统特征',
  `vaf` float DEFAULT '0' COMMENT '调整系数值',
  `cf` float DEFAULT '0' COMMENT '规模变更调整因子',
  `complexity` int DEFAULT '0' COMMENT '复杂度：1=低，2=中，3=高',
  `stage` int DEFAULT '0' COMMENT '状态：1=项目立项，2=项目招标，3=项目早期，4=项目中期，5=项目完成',
  `method` int DEFAULT '0' COMMENT '方法：1=dfp，2=s',
  `ufp` float DEFAULT '0' COMMENT '未调整功能点数',
  `dfp` float DEFAULT '0' COMMENT '调整后功能点数（通用系统调整因子法）',
  `s` float DEFAULT '0' COMMENT '调整后功能点数（需求变更调整因子法）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='项目分析';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subsystem`
--

DROP TABLE IF EXISTS `subsystem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subsystem` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '子系统id',
  `project_id` bigint NOT NULL COMMENT '所属项目id',
  `name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '子系统名',
  `if_delete` int NOT NULL DEFAULT '0' COMMENT '是否删除：0=未删除，1=已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间：如果删除时间超过3个月，自动清理',
  `ufp` int DEFAULT '0' COMMENT '未调整功能点数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='子系统';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subsystem`
--

LOCK TABLES `subsystem` WRITE;
/*!40000 ALTER TABLE `subsystem` DISABLE KEYS */;
/*!40000 ALTER TABLE `subsystem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `if_delete` int NOT NULL DEFAULT '0' COMMENT '是否删除：0=未删除，1=已删除',
  `role` int NOT NULL DEFAULT '1' COMMENT '角色：0=管理员，1=用户',
  `status` int NOT NULL DEFAULT '1' COMMENT '账号状态：0=停用，1=正常',
  `avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像路径',
  `gender` int DEFAULT '0' COMMENT '性别：0=未知，1=男，2=女',
  `age` int DEFAULT (-(1)) COMMENT '年龄',
  `telephone` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT (-(1)) COMMENT '电话号码',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '电子邮箱地址',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后一次修改时间',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (10000,'Admin','$2a$10$.aQ6lx8vZSeY7xmWASqUq.L/2v2CZQdtxPVVigJkcCPAHyM5y2i2G',0,0,1,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-19 21:27:39
