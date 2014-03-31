/*
SQLyog Enterprise - MySQL GUI v8.05 
MySQL - 5.5.16 : Database - pgsd
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`pgsd` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `pgsd`;

/*Table structure for table `dosen` */

DROP TABLE IF EXISTS `dosen`;

CREATE TABLE `dosen` (
  `idDosen` varchar(100) NOT NULL,
  `namaDosen` varchar(100) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idDosen`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `dosen` */

insert  into `dosen`(`idDosen`,`namaDosen`,`status`) values ('D001','Puspa','Tetap'),('D002','Albert','Tetap'),('D003','Kartono','Tidak Tetap');

/*Table structure for table `kelas_makul` */

DROP TABLE IF EXISTS `kelas_makul`;

CREATE TABLE `kelas_makul` (
  `idKelas` varchar(50) NOT NULL,
  `namaKelas` varchar(5) DEFAULT NULL,
  `jumlahMahasiswa` int(50) DEFAULT NULL,
  PRIMARY KEY (`idKelas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `kelas_makul` */

/*Table structure for table `mata_kuliah` */

DROP TABLE IF EXISTS `mata_kuliah`;

CREATE TABLE `mata_kuliah` (
  `idMK` varchar(100) NOT NULL,
  `namaMK` varchar(100) DEFAULT NULL,
  `sks` int(5) DEFAULT NULL,
  `semester` int(5) DEFAULT NULL,
  `JP` int(5) DEFAULT NULL,
  `jenis` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idMK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `mata_kuliah` */

/*Table structure for table `ruang` */

DROP TABLE IF EXISTS `ruang`;

CREATE TABLE `ruang` (
  `idRuang` varchar(50) NOT NULL,
  `namaRuang` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idRuang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ruang` */

insert  into `ruang`(`idRuang`,`namaRuang`) values ('204','K 204'),('205','K 205');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
