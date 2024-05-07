CREATE DATABASE  IF NOT EXISTS `billingsystem_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `billingsystem_db`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: billingsystem_db
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
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `client_id` int NOT NULL AUTO_INCREMENT,
  `client_name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` bigint NOT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'John Smith','john.smith@email.com',1234567890),(2,'Emily Johnson','emily.johnson@email.com',2345678901),(3,'Michael Brown','michael.brown@email.com',3456789012),(4,'Emma Davis','emma.davis@email.com',4567890123),(5,'Daniel Wilson','daniel.wilson@email.com',5678901234);
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `emp_no` int NOT NULL AUTO_INCREMENT,
  `birth_date` date NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `sex` enum('M','F') NOT NULL,
  `join_date` date DEFAULT NULL,
  `hourly_rate` int NOT NULL,
  PRIMARY KEY (`emp_no`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'1985-01-15','Albert','John','M','2010-01-01',2000),(2,'1990-02-20','Janey','Sagar','F','2011-05-15',2000),(3,'1987-03-30','Alice','Johnson','F','2013-07-20',2000),(4,'1989-04-25','William','Harry','M','2013-02-11',2000),(5,'1991-05-19','Eve','Davis','M','2014-08-29',1700),(6,'1992-06-22','Clara','Gargi','F','2015-03-23',1700),(7,'1992-09-30','Eva','Zerin','F','2016-11-13',1700),(8,'1994-09-02','Harold','Venis','M','2017-08-07',1700);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoices`
--

DROP TABLE IF EXISTS `invoices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoices` (
  `invoice_id` int NOT NULL AUTO_INCREMENT,
  `project_id` int NOT NULL,
  `date` date NOT NULL,
  `total_amount` decimal(10,0) NOT NULL,
  `status` enum('Pending','Paid','Unpaid') NOT NULL,
  PRIMARY KEY (`invoice_id`),
  KEY `project_id` (`project_id`),
  CONSTRAINT `invoices_ibfk_2` FOREIGN KEY (`project_id`) REFERENCES `projects` (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoices`
--

LOCK TABLES `invoices` WRITE;
/*!40000 ALTER TABLE `invoices` DISABLE KEYS */;
INSERT INTO `invoices` VALUES (1,1,'2024-05-03',550000,'Paid'),(2,2,'2024-05-03',680000,'Paid'),(3,3,'2024-05-03',655000,'Pending'),(4,4,'2024-05-03',450000,'Pending'),(5,5,'2024-05-03',700500,'Pending');
/*!40000 ALTER TABLE `invoices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projects` (
  `project_id` int NOT NULL AUTO_INCREMENT,
  `project_name` varchar(50) NOT NULL,
  `client_id` int NOT NULL,
  `created_by` int NOT NULL,
  `updated_by` int NOT NULL,
  `created_date` date DEFAULT NULL,
  `updated_date` date DEFAULT NULL,
  `description` text,
  `total_amount` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  KEY `client_id` (`client_id`),
  KEY `created_by` (`created_by`),
  KEY `updated_by` (`updated_by`),
  CONSTRAINT `projects_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`client_id`),
  CONSTRAINT `projects_ibfk_2` FOREIGN KEY (`created_by`) REFERENCES `employees` (`emp_no`),
  CONSTRAINT `projects_ibfk_3` FOREIGN KEY (`updated_by`) REFERENCES `employees` (`emp_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (1,'Project Alpha',1,1,3,'2023-12-20','2024-05-02','E-commerce',550000),(2,'Project Beta',2,3,4,'2024-01-18','2024-05-02','Health care',680000),(3,'Project Gamma',3,2,5,'2024-02-10','2024-05-02','Insurance',655000),(4,'Project Delta',4,6,8,'2024-02-25','2024-05-02','Food delivery',450000),(5,'Project Epsilon',5,7,5,'2024-03-25','2024-05-02','Industry Policies',700500);
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time_entries`
--

DROP TABLE IF EXISTS `time_entries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time_entries` (
  `time_entry_id` int NOT NULL AUTO_INCREMENT,
  `emp_no` int NOT NULL,
  `project_id` int NOT NULL,
  `date` date NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  `hours_worked` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`time_entry_id`),
  KEY `emp_no` (`emp_no`),
  KEY `project_id` (`project_id`),
  CONSTRAINT `time_entries_ibfk_1` FOREIGN KEY (`emp_no`) REFERENCES `employees` (`emp_no`),
  CONSTRAINT `time_entries_ibfk_2` FOREIGN KEY (`project_id`) REFERENCES `projects` (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_entries`
--

LOCK TABLES `time_entries` WRITE;
/*!40000 ALTER TABLE `time_entries` DISABLE KEYS */;
INSERT INTO `time_entries` VALUES (1,1,1,'2023-12-25','08:00:00','17:00:00',9.00),(2,1,1,'2023-12-28','08:30:00','17:30:00',9.00),(3,3,2,'2024-01-20','09:00:00','18:00:00',9.00),(4,3,2,'2024-01-29','08:00:00','16:30:00',8.50),(5,2,3,'2024-02-15','08:30:00','17:30:00',9.00),(6,5,3,'2024-02-21','08:00:00','17:00:00',9.00),(7,5,3,'2024-02-25','08:30:00','18:00:00',9.50),(8,6,4,'2024-02-26','09:00:00','17:00:00',8.00),(9,6,4,'2024-02-28','08:00:00','17:30:00',9.50),(10,7,5,'2024-03-25','08:30:00','17:30:00',9.00),(11,3,1,'2024-05-02','08:00:00','11:00:00',3.00),(12,4,2,'2024-05-02','08:30:00','11:30:00',3.00),(13,5,3,'2024-05-02','09:00:00','12:30:00',3.50),(14,8,4,'2024-05-02','08:00:00','11:00:00',3.00),(15,5,5,'2024-05-02','08:30:00','12:00:00',3.50);
/*!40000 ALTER TABLE `time_entries` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-07 11:53:59
