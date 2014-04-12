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

/*Table structure for table `matakuliah` */

DROP TABLE IF EXISTS `matakuliah`;

CREATE TABLE `matakuliah` (
  `idMK` varchar(100) NOT NULL,
  `namaMK` varchar(100) DEFAULT NULL,
  `sks` int(5) DEFAULT NULL,
  `semester` int(5) DEFAULT NULL,
  `JP` int(5) DEFAULT NULL,
  PRIMARY KEY (`idMK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `matakuliah` */

insert  into `matakuliah`(`idMK`,`namaMK`,`sks`,`semester`,`JP`) values ('PDW 2106','Logika',2,1,2),('PDW 2107','Pendidikan Keterampilan Menulis Indah dan Kerajinan Tangan',2,1,2),('PDW 2119','Perkembangan dan Belajar Peserta Didik 1',2,1,2),('PDW 2122','Bahasa dan Sastra Indonesia',2,1,2),('PDW 2123','IPA Biologi',3,1,3),('PDW 2124','IPA Fisika',3,1,3),('PDW 2125','Matematika 1',3,1,3),('PDW 2126','Bahasa Inggris 1',2,1,2),('PDW 2155','Keterampilan Menulis Ilmiah',2,1,2),('PDW 2208','Pendidikan Seni Rupa',2,2,2),('PDW 2217','Landasan Pendidikan',3,2,3),('PDW 2218','Bimbingan dan Konseling',2,2,2),('PDW 2228','Praktikum IPA Biologi',2,2,4),('PDW 2229','Praktikum IPA Fisika',2,2,4),('PDW 2230','Matematika 2',3,2,3),('PDW 2231','Keterampilan Bahasa Indonesia',3,2,3),('PDW 2232','Bahasa Inggris 2',2,2,2),('PDW 2233','Bimbingan Pramuka',1,2,2),('PDW 2319','Perkembangan dan Belajar Peserta Didik 2',2,3,2),('PDW 2334','PKn',2,3,2),('PDW 2335','IPS',3,3,3),('PDW 2336','Permainan Anak',2,3,2),('PDW 2337','Bimbingan Belajar 1',1,3,2),('PDW 2343','Pendidikan IPA',3,3,3),('PDW 2344','Pendidikan Matematika 1',3,3,3),('PDW 2345','Pendidikan Bahasa dan Sastra Indonesia',3,3,3),('PDW 2356','Statistik Pendidikan',2,3,2),('PDW 2409','Pendidikan Religiositas Anak',2,4,2),('PDW 2420','Pendidikan Anak Berkebutuhan Khusus',2,4,2),('PDW 2438','Bimbingan Belajar 2',1,4,2),('PDW 2446','Pendidikan PKn',2,4,2),('PDW 2447','Pendidikan IPS',3,4,3),('PDW 2448','Pendidikan Matematika 2',3,4,3),('PDW 2449','Pendidikan Bahasa dan Sastra Indonesia 2',3,4,3),('PDW 2450','Evaluasi Pembelajaran',3,4,3),('PDW 2451','Media Pembelajaran Berbasis ICT',3,4,3),('PDW 2510','Kesehatan Sekolah',2,5,2),('PDW 2539','Program Pengakraban dengan Lingkingan 1',1,5,2),('PDW 2552','Pembelajaran Terpadu',3,5,3),('PDW 2553','Pengembangan Kurikulum dan Pembelajaran',3,5,3),('PDW 2554','Manajemen Kelas',2,5,2),('PDW 2557','Metode Penelitian Pendidikan',3,5,3),('USD 120','Pendidikan Agama',2,1,2),('USD 121','Teologi Moral',2,2,2),('USD 122','Filsafat Moral',2,2,2),('USD 123','Pendidikan Pancasila',2,3,2),('USD 224','Pendidikan Kewarganegaraan/Kewiraan',2,5,2);

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
