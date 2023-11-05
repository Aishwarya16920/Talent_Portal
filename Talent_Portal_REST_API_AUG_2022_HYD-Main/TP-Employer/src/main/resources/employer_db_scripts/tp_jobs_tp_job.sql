CREATE DATABASE  IF NOT EXISTS `tp_jobs` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tp_jobs`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: tp_jobs
-- ------------------------------------------------------
-- Server version	5.5.40-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tp_job`
--

DROP TABLE IF EXISTS `tp_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tp_job` (
  `id` int(11) NOT NULL,
  `created_date` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `max_exp` int(11) NOT NULL,
  `min_exp` int(11) NOT NULL,
  `modified_date` date DEFAULT NULL,
  `primary_skill` varchar(255) DEFAULT NULL,
  `sec_skills` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `status_id` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tp_job`
--

LOCK TABLES `tp_job` WRITE;
/*!40000 ALTER TABLE `tp_job` DISABLE KEYS */;
INSERT INTO `tp_job` VALUES (1,'2022-09-19','Looking for a qualified Application Developer to design and code functional programs and applications.','Pune',8,2,'2022-09-21','C#  ASP.NET .NET frameworks','HTML5 CSS XML jQuery','Open',0,'DotNet Developer','Kranti'),(2,'2022-09-20','Proven experience as a Full Stack Developer or similar role','Hyderabad',1,0,'2022-09-22','Spring boot, Microservices,Rest API.',' Angular, Linux, shell scripting.','Open',0,'Java Full Stack Developer','Shailesh2000'),(3,'2022-09-23','Analyzes, develops, designs, and maintains software for the organization\'s products and systems. ','Banglore',12,3,'2022-09-25','JavaScript, Java, Spring','SQL Cloud  Database Management','Open',0,'Software Engineer','Kranti'),(4,'2022-09-24','Performs assigned tasks in support of consolidation of the Service Assurance function for IT and Networks, (incidents, problem and change management) for both fixed and mobile.','Kolkata',13,5,'2022-09-26','Cloud, Security, Network Access Technology','Dev ops,Automation and Robotics','Open',0,'Assistant Manager','Shailesh2000'),(5,'2022-09-27','Develop and test features according to the requirement, using appointed tools and technologies, keeping in mind quality, cost, and timeline.','Pune',5,2,'2022-09-29','C# Python Devops','MangoDB Angular Js','Open',0,'Associate Software Engineer','Kranti'),(15,'2022-10-03','Java, React','Bangalore',4,2,NULL,'Java','React','Open',0,'Java',NULL);
/*!40000 ALTER TABLE `tp_job` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-06 12:40:07
