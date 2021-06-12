-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: dbs_petsi
-- ------------------------------------------------------
-- Server version	5.7.33-log

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
-- Table structure for table `tbl_citas`
--

DROP TABLE IF EXISTS `tbl_citas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_citas` (
  `cit_id` int(11) NOT NULL AUTO_INCREMENT,
  `cit_usuarioid` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  `cit_idmascota` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  `cit_horallegada` datetime DEFAULT NULL,
  `cit_horasalida` datetime DEFAULT NULL,
  `cit_horainicio` datetime DEFAULT NULL,
  `cit_horafinalizacion` datetime DEFAULT NULL,
  `cit_estado` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  `cit_motivoanulacion` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  PRIMARY KEY (`cit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_citas`
--

LOCK TABLES `tbl_citas` WRITE;
/*!40000 ALTER TABLE `tbl_citas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_citas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_citas_has_tbl_estados`
--

DROP TABLE IF EXISTS `tbl_citas_has_tbl_estados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_citas_has_tbl_estados` (
  `tbl_citas_cit_id` int(11) DEFAULT NULL,
  `tbl_estados_est_id` int(11) DEFAULT NULL,
  KEY `s1_idx` (`tbl_citas_cit_id`),
  KEY `s2_idx` (`tbl_estados_est_id`),
  CONSTRAINT `s1` FOREIGN KEY (`tbl_citas_cit_id`) REFERENCES `tbl_citas` (`cit_id`),
  CONSTRAINT `s2` FOREIGN KEY (`tbl_estados_est_id`) REFERENCES `tbl_estados` (`est_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_citas_has_tbl_estados`
--

LOCK TABLES `tbl_citas_has_tbl_estados` WRITE;
/*!40000 ALTER TABLE `tbl_citas_has_tbl_estados` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_citas_has_tbl_estados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_citas_has_tbl_servicios`
--

DROP TABLE IF EXISTS `tbl_citas_has_tbl_servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_citas_has_tbl_servicios` (
  `tbl_citas_cit_id` int(11) DEFAULT NULL,
  `tbl_servicios_svc_id` int(11) DEFAULT NULL,
  KEY `v2_idx` (`tbl_servicios_svc_id`),
  KEY `v1` (`tbl_citas_cit_id`),
  CONSTRAINT `v1` FOREIGN KEY (`tbl_citas_cit_id`) REFERENCES `tbl_citas` (`cit_id`),
  CONSTRAINT `v2` FOREIGN KEY (`tbl_servicios_svc_id`) REFERENCES `tbl_servicios` (`svc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_citas_has_tbl_servicios`
--

LOCK TABLES `tbl_citas_has_tbl_servicios` WRITE;
/*!40000 ALTER TABLE `tbl_citas_has_tbl_servicios` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_citas_has_tbl_servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_estados`
--

DROP TABLE IF EXISTS `tbl_estados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_estados` (
  `est_id` int(11) NOT NULL AUTO_INCREMENT,
  `est_descripcion` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  `est_aceptada` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  `est_eliminada` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  `est_rechazada` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  `est_finalizada` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  PRIMARY KEY (`est_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_estados`
--

LOCK TABLES `tbl_estados` WRITE;
/*!40000 ALTER TABLE `tbl_estados` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_estados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_historiaclinica`
--

DROP TABLE IF EXISTS `tbl_historiaclinica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_historiaclinica` (
  `hc_id` int(11) NOT NULL,
  `hc_idmascota` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  `hc_descripcion` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  `hc_fechanacimiento` date DEFAULT NULL,
  `hc_descripvacunas` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  `hc_tratamientos` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  `hc_sintomas` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  `hc_recetas` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  PRIMARY KEY (`hc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_historiaclinica`
--

LOCK TABLES `tbl_historiaclinica` WRITE;
/*!40000 ALTER TABLE `tbl_historiaclinica` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_historiaclinica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_historiaclinica_has_tbl_mascotas`
--

DROP TABLE IF EXISTS `tbl_historiaclinica_has_tbl_mascotas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_historiaclinica_has_tbl_mascotas` (
  `tbl_historiaclinica_hc_id` int(11) DEFAULT NULL,
  `tbl_mascotas_mct_id` int(11) DEFAULT NULL,
  KEY `fk_1_idx` (`tbl_historiaclinica_hc_id`),
  KEY `fk_2_idx` (`tbl_mascotas_mct_id`),
  CONSTRAINT `fk_1` FOREIGN KEY (`tbl_historiaclinica_hc_id`) REFERENCES `tbl_historiaclinica` (`hc_id`),
  CONSTRAINT `fk_2` FOREIGN KEY (`tbl_mascotas_mct_id`) REFERENCES `tbl_mascotas` (`mct_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_historiaclinica_has_tbl_mascotas`
--

LOCK TABLES `tbl_historiaclinica_has_tbl_mascotas` WRITE;
/*!40000 ALTER TABLE `tbl_historiaclinica_has_tbl_mascotas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_historiaclinica_has_tbl_mascotas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_mascotas`
--

DROP TABLE IF EXISTS `tbl_mascotas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_mascotas` (
  `mct_id` int(11) NOT NULL AUTO_INCREMENT,
  `mct_nombre` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  `mct_tipomascota` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  `mct_tipomct_otro` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  `mct_raza` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  `mct_raza_otro` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  `mct_descripcion` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  `mct_fechanacimiento` date DEFAULT NULL,
  `mct_sexo` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  PRIMARY KEY (`mct_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_mascotas`
--

LOCK TABLES `tbl_mascotas` WRITE;
/*!40000 ALTER TABLE `tbl_mascotas` DISABLE KEYS */;
INSERT INTO `tbl_mascotas` VALUES (1,'Loki','Perro',NULL,'Puddle',NULL,'Muy Peludo',NULL,'M'),(2,'Loki','Perro','','chihuahua','','Muy Peluda',NULL,NULL),(3,'Loki','Perro','','chihuahua','','Muy Peluda',NULL,NULL),(4,'Lulu','Gato','','Otro','Persa','Muy Peluda',NULL,NULL),(5,'Ramon','Gato','','Otro','Persa','Ojos grandes',NULL,NULL),(6,'Eli','Gato','','Otro','Bengala','Parece un tigre ',NULL,NULL),(7,'Valeri','Hanster','','Otro','Siberiana','Prueba registro mascota',NULL,NULL),(8,'Luis','Otro','Raton','Otro','Montes','Prueba registro mascota',NULL,NULL),(9,'Camila','Otro','Cacatua','Otro','Africana','Yoquese',NULL,NULL),(10,'Camila','Otro','Cacatua','Otro','Africana','Yoquese',NULL,NULL),(11,'Paula','Otro','Cacatua','Otro','Africana','Yoquese',NULL,NULL),(12,'Samantha','Gato','','Otro','Persa',' muy peluda',NULL,NULL),(13,'Thor','Perro','','chihuahua','',' muy peludo',NULL,NULL),(14,'gato','Gato','','Dalmata','','tiene 6 meses',NULL,NULL);
/*!40000 ALTER TABLE `tbl_mascotas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_mascotas_has_tbl_citas`
--

DROP TABLE IF EXISTS `tbl_mascotas_has_tbl_citas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_mascotas_has_tbl_citas` (
  `tbl_mascotas_mct_id` int(11) DEFAULT NULL,
  `tbl_citas_cit_id` int(11) DEFAULT NULL,
  KEY `jk1_idx` (`tbl_mascotas_mct_id`),
  KEY `jk2_idx` (`tbl_citas_cit_id`),
  CONSTRAINT `jk1` FOREIGN KEY (`tbl_mascotas_mct_id`) REFERENCES `tbl_mascotas` (`mct_id`),
  CONSTRAINT `jk2` FOREIGN KEY (`tbl_citas_cit_id`) REFERENCES `tbl_citas` (`cit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_mascotas_has_tbl_citas`
--

LOCK TABLES `tbl_mascotas_has_tbl_citas` WRITE;
/*!40000 ALTER TABLE `tbl_mascotas_has_tbl_citas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_mascotas_has_tbl_citas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_rol`
--

DROP TABLE IF EXISTS `tbl_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_rol` (
  `ro_rolid` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `permisos` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ro_rolid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_rol`
--

LOCK TABLES `tbl_rol` WRITE;
/*!40000 ALTER TABLE `tbl_rol` DISABLE KEYS */;
INSERT INTO `tbl_rol` VALUES (1,'Usuario','Comprar','usuario'),(2,'Veterinario','Consultar y editar citas','veterinario'),(3,'Administrador','Todos','administrador');
/*!40000 ALTER TABLE `tbl_rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_servicios`
--

DROP TABLE IF EXISTS `tbl_servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_servicios` (
  `svc_id` int(11) NOT NULL AUTO_INCREMENT,
  `svc_tiposervicio` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  `svc_tiposervicio_otro` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  `svc_descripcion` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  `svc_encargado` varchar(45) COLLATE latin1_bin DEFAULT NULL,
  PRIMARY KEY (`svc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_servicios`
--

LOCK TABLES `tbl_servicios` WRITE;
/*!40000 ALTER TABLE `tbl_servicios` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_usuario`
--

DROP TABLE IF EXISTS `tbl_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_usuario` (
  `usu_usuarioid` int(11) NOT NULL AUTO_INCREMENT,
  `usu_tipodocumento` varchar(45) DEFAULT NULL,
  `usu_documento` varchar(45) DEFAULT NULL,
  `usu_nombre` varchar(45) DEFAULT NULL,
  `usu_apellido` varchar(45) DEFAULT NULL,
  `usu_correo` varchar(45) DEFAULT NULL,
  `usu_movil` varchar(50) DEFAULT NULL,
  `usu_clave` varchar(45) DEFAULT NULL,
  `usu_estado` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`usu_usuarioid`),
  UNIQUE KEY `usu_correo_UNIQUE` (`usu_correo`),
  UNIQUE KEY `usu_documento_UNIQUE` (`usu_documento`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_usuario`
--

LOCK TABLES `tbl_usuario` WRITE;
/*!40000 ALTER TABLE `tbl_usuario` DISABLE KEYS */;
INSERT INTO `tbl_usuario` VALUES (1,'Cedula','1001825107','Sergio Andres','Castillo Perez','sergioandres031@hotmail.com','3193512403','proyecto',1),(2,'Tarjeta de Identidad','72140455','Rafael','Castillo','rcastillo@ejemplo.com','3024627004','proyecto',1),(19,'Cedula Ciudadania','10007240','Guadalupe','Perez','luperez@ejemplo.com','3227632768','proyecto',1);
/*!40000 ALTER TABLE `tbl_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_usuario_has_tbl_rol`
--

DROP TABLE IF EXISTS `tbl_usuario_has_tbl_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_usuario_has_tbl_rol` (
  `usu_usuario_id` int(11) DEFAULT NULL,
  `rol_rol_id` int(11) DEFAULT NULL,
  KEY `fk_1_idx` (`usu_usuario_id`),
  KEY `kf_2_idx` (`rol_rol_id`),
  CONSTRAINT `fkey1` FOREIGN KEY (`usu_usuario_id`) REFERENCES `tbl_usuario` (`usu_usuarioid`),
  CONSTRAINT `fkey2` FOREIGN KEY (`rol_rol_id`) REFERENCES `tbl_rol` (`ro_rolid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_usuario_has_tbl_rol`
--

LOCK TABLES `tbl_usuario_has_tbl_rol` WRITE;
/*!40000 ALTER TABLE `tbl_usuario_has_tbl_rol` DISABLE KEYS */;
INSERT INTO `tbl_usuario_has_tbl_rol` VALUES (1,1),(2,1),(1,3),(1,2),(2,3),(2,2),(19,1),(19,2),(19,3);
/*!40000 ALTER TABLE `tbl_usuario_has_tbl_rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'dbs_petsi'
--

--
-- Dumping routines for database 'dbs_petsi'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-12 11:25:14
