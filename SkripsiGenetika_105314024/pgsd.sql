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

insert  into `dosen`(`idDosen`,`namaDosen`,`status`) values ('-','-','-'),('D001','Drs. Paulus Wahana, M.Hum.','Tetap'),('D002','Drs. Y.B. Adimassana, M.A.','Tetap'),('D003','Catur Rismiati, S.Pd., M.A., Ph.D.','Tetap'),('D004','G. Ari Nugrahanta, S.J, M.A.','Tetap'),('D005','Rusmawan, S.Pd., M.Pd.','Tetap'),('D006','Eny Winarti, Ph. D.','Tetap'),('D007','Galih Kusumo, S.Pd, M.Pd.','Tetap'),('D008','Theresia Yunia Setyawan, S.Pd, M.Hum.','Tetap'),('D009','Dra. Ignatia Esti Sumarah, M.Hum.','Tetap'),('D010','Drs. Puji Purnomo, M.Si.','Tetap'),('D011','Andri Anugrahana, S.Pd., M.Pd.','Tetap'),('D012','Wahyu Wido Sari, S.Si., M.Biotech.','Tetap'),('D013','Elisabeth Desiana Mayasari, S.Psi., M.A.','Tetap'),('D014','Agnes Herlina Dwi Hadiyanti, M.T., M. Sc.','Tetap'),('D015','Christiyanti Aprinastuti, S.Si., M.Pd.','Tetap'),('D016','Laurensia Aptik Evanjeli, S.Psi., M.A.','Tetap'),('D017','Brigitta Erlita Tri Anggadewi, S.Psi., M.Psi.','Tetap'),('D018','Irine Kurniastuti, S.Psi., M.Psi.','Tetap'),('D019','Apri Damai Sagita Krissandi, S.S., M.Pd.','Tetap'),('D020','Maria Melani Ika Susanti, S.Pd.','Tetap'),('T001','Pdt. Jonsa Manulang, S. Th, M.Th','Tidak Tetap'),('T002','Khusnul Khotimah, M.A.','Tidak Tetap'),('T003','Paulus Tri Anung, SIP, M.A.','Tidak Tetap'),('T004','Cahya Fujianto, S.Si, M.Tech','Tidak Tetap'),('T005','Ganjar','Tidak Tetap'),('T006','Renyaan','Tidak Tetap'),('T007','Widodo Budi','Tidak Tetap'),('T008','Veronika Fitri, S.Pd., M.Sc.','Tidak Tetap'),('T009','Elisabeth Ayunika, S.Pd., M.Ed.','Tidak Tetap'),('T010','A.G. Sujatmiko Bambang Santoso, M.Hum.','Tidak Tetap'),('T011','Drs. St. Kartono, M.Hum.','Tidak Tetap'),('T012','Dr. Christina Dewi Tri Murwani, M.Hum.','Tidak Tetap'),('T013','Dr. Y.R. Subakti, M.Pd','Tidak Tetap'),('T014','Wahyudi','Tidak Tetap'),('T015','Dr. Purwanta','Tidak Tetap'),('T016','Drs. B. Musidi, M.Pd.','Tidak Tetap'),('T017','Bp. Sahana','Tidak Tetap'),('T018','Dra. Maslicah A., M.Pd.','Tidak Tetap'),('T019','Dr. Anton Haryono','Tidak Tetap'),('T020','Drs. A.K. Wiharyanto, M.Pd.','Tidak Tetap'),('T021','Y.R. Adisusilo, M.Pd.','Tidak Tetap'),('T022','Dra. T.H. Sumini, M.Pd.','Tidak Tetap'),('T023','Th. Laksmi, M.Pd','Tidak Tetap'),('T024','Drs. Johanes Sabari, M.Si.','Tidak Tetap'),('T025','Dr. CB Mulyanto, Pr., S.S','Tidak Tetap'),('T026','Rm. Warsito, Pr.','Tidak Tetap');

/*Table structure for table `kelas_makul` */

DROP TABLE IF EXISTS `kelas_makul`;

CREATE TABLE `kelas_makul` (
  `idKelas` varchar(3) NOT NULL,
  `idMK` varchar(100) DEFAULT NULL,
  `idDosen` varchar(100) DEFAULT NULL,
  `Kelas` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`idKelas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `kelas_makul` */

insert  into `kelas_makul`(`idKelas`,`idMK`,`idDosen`,`Kelas`) values ('0','-','-','-'),('1','USD 120 ','D009 ','A'),('10','PDW 2106','D002 ','E'),('100','PDW 2553','D010 ','A'),('101','PDW 2553','D010 ','B'),('102','PDW 2553','D010 ','C'),('103','PDW 2553','D010 ','D'),('104','PDW 2553','D006 ','E'),('105','PDW 2553','D006 ','F'),('106','PDW 2554','D005 ','A'),('107','PDW 2554','D005 ','B'),('108','PDW 2554','D005 ','C'),('109','PDW 2554','D007 ','D'),('11','PDW 2119','D017 ','A'),('110','PDW 2554','T023 ','E'),('111','PDW 2554','D008 ','F'),('112','PDW 2557','D017 ','A'),('113','PDW 2557','D016 ','B'),('114','PDW 2557','D006 ','C'),('115','PDW 2557','D003 ','D'),('116','PDW 2557','D008 ','E'),('117','PDW 2557','D005 ','F'),('118','USD 325 ','T025 ','A'),('119','USD 325 ','T025 ','B'),('12','PDW 2119','D017 ','B'),('120','USD 325 ','T025 ','C'),('121','USD 325 ','T026 ','D'),('122','USD 325 ','T026 ','E'),('13','PDW 2119','D017 ','C'),('14','PDW 2119','T003 ','D'),('15','PDW 2119','T003 ','E'),('16','PDW 2123','D014 ','A'),('17','PDW 2123','D012 ','B'),('18','PDW 2123','D012 ','C'),('19','PDW 2123','T004 ','D'),('2','USD 120 ','T001 ','B'),('20','PDW 2123','T004 ','E'),('21','PDW 2124','T005 ','A'),('22','PDW 2124','T006 ','B'),('23','PDW 2124','T006 ','C'),('24','PDW 2124','T007 ','D'),('25','PDW 2124','T007 ','E'),('26','PDW 2125','T008 ','A'),('27','PDW 2125','T009 ','B'),('28','PDW 2125','T009 ','C'),('29','PDW 2125','D015 ','D'),('3','USD 120 ','D009 ','C'),('30','PDW 2125','D015 ','E'),('31','PDW 2126','T010 ','A'),('32','PDW 2126','T010 ','B'),('33','PDW 2126','T010 ','C'),('34','PDW 2126','T010 ','D'),('35','PDW 2126','T010 ','E'),('36','PDW 2155','T011 ','A'),('37','PDW 2155','T011 ','B'),('38','PDW 2155','T012 ','C'),('39','PDW 2155','T012 ','D'),('4','USD 120 ','T002 ','D'),('40','PDW 2155','T012 ','E'),('41','USD 123 ','D001 ','A'),('42','USD 123 ','D001 ','B'),('43','USD 123 ','D001 ','C'),('44','USD 123 ','D001 ','D'),('45','USD 123 ','T013 ','E'),('46','USD 123 ','T013 ','F'),('47','PDW 2319','D016 ','A'),('48','PDW 2319','D016 ','B'),('49','PDW 2319','D016 ','C'),('5','USD 120 ','D009 ','E'),('50','PDW 2319','D016 ','D'),('51','PDW 2319','T003 ','E'),('52','PDW 2334','D001 ','A'),('53','PDW 2334','D001 ','B'),('54','PDW 2334','D001 ','C'),('55','PDW 2334','T014 ','D'),('56','PDW 2334','T014 ','E'),('57','PDW 2335','T015 ','A'),('58','PDW 2335','T016 ','B'),('59','PDW 2335','T017 ','C'),('6','PDW 2106','D004 ','A'),('60','PDW 2335','T015 ','D'),('61','PDW 2335','T015 ','E'),('62','PDW 2336','D013 ','A'),('63','PDW 2336','D013 ','B'),('64','PDW 2336','D018 ','C'),('65','PDW 2336','D018 ','D'),('66','PDW 2336','D018 ','E'),('67','PDW 2343','D012 ','A'),('68','PDW 2343','D012 ','B'),('69','PDW 2343','T018 ','C'),('7','PDW 2106','D004 ','B'),('70','PDW 2343','T018 ','D'),('71','PDW 2343','T018 ','E'),('72','PDW 2344','D015 ','A'),('73','PDW 2344','D015 ','B'),('74','PDW 2344','D015 ','C'),('75','PDW 2344','D011 ','D'),('76','PDW 2344','D011 ','E'),('77','PDW 2356','D018 ','A'),('78','PDW 2356','D017 ','B'),('79','PDW 2356','D017 ','C'),('8','PDW 2106','D004 ','C'),('80','PDW 2356','D003 ','D'),('81','PDW 2356','D016 ','E'),('82','USD 224 ','T019 ','A'),('83','USD 224 ','T020 ','B'),('84','USD 224 ','T020 ','C'),('85','USD 224 ','T013 ','D'),('86','USD 224 ','T021 ','E'),('87','USD 224 ','T022 ','F'),('88','PDW 2510','D009 ','A'),('89','PDW 2510','D009 ','B'),('9','PDW 2106','D002 ','D'),('90','PDW 2510','D009 ','C'),('91','PDW 2510','D009 ','D'),('92','PDW 2510','D015 ','E'),('93','PDW 2510','D012 ','F'),('94','PDW 2552','D005 ','A'),('95','PDW 2552','D005 ','B'),('96','PDW 2552','D005 ','C'),('97','PDW 2552','T018 ','D'),('98','PDW 2552','D014 ','E'),('99','PDW 2552','D014 ','F');

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

insert  into `matakuliah`(`idMK`,`namaMK`,`sks`,`semester`,`JP`) values ('-','-',0,0,0),('KPDS 032','Pendidikan Jasmani 1',1,7,2),('KPDS 050A','Penelitian Tindakan Kelas',3,7,3),('KPDS 058','Pendidikan Multikultural',2,7,2),('KPDS 067A','Evaluasi Pembelajaran 2',2,7,2),('KPDS 085','Media Pembelajaran Konvensional dan Berbasis IT',3,7,3),('KPDS 086','Keterampilan Dasar Mengajar',2,7,4),('PDW 2106','Logika',2,1,2),('PDW 2107','Pendidikan Keterampilan Menulis Indah dan Kerajinan Tangan',2,1,2),('PDW 2119','Perkembangan dan Belajar Peserta Didik 1',2,1,2),('PDW 2122','Bahasa dan Sastra Indonesia',2,1,2),('PDW 2123','IPA Biologi',3,1,3),('PDW 2124','IPA Fisika',3,1,3),('PDW 2125','Matematika 1',3,1,3),('PDW 2126','Bahasa Inggris 1',2,1,2),('PDW 2155','Keterampilan Menulis Ilmiah',2,1,2),('PDW 2208','Pendidikan Seni Rupa',2,2,2),('PDW 2217','Landasan Pendidikan',3,2,3),('PDW 2218','Bimbingan dan Konseling',2,2,2),('PDW 2228','Praktikum IPA Biologi',2,2,4),('PDW 2229','Praktikum IPA Fisika',2,2,4),('PDW 2230','Matematika 2',3,2,3),('PDW 2231','Keterampilan Bahasa Indonesia',3,2,3),('PDW 2232','Bahasa Inggris 2',2,2,2),('PDW 2233','Bimbingan Pramuka',1,2,2),('PDW 2319','Perkembangan dan Belajar Peserta Didik 2',2,3,2),('PDW 2334','PKn',2,3,2),('PDW 2335','IPS',3,3,3),('PDW 2336','Permainan Anak',2,3,2),('PDW 2337','Bimbingan Belajar 1',1,3,2),('PDW 2343','Pendidikan IPA',3,3,3),('PDW 2344','Pendidikan Matematika 1',3,3,3),('PDW 2345','Pendidikan Bahasa dan Sastra Indonesia',3,3,3),('PDW 2356','Statistik Pendidikan',2,3,2),('PDW 2409','Pendidikan Religiositas Anak',2,4,2),('PDW 2420','Pendidikan Anak Berkebutuhan Khusus',2,4,2),('PDW 2438','Bimbingan Belajar 2',1,4,2),('PDW 2446','Pendidikan PKn',2,4,2),('PDW 2447','Pendidikan IPS',3,4,3),('PDW 2448','Pendidikan Matematika 2',3,4,3),('PDW 2449','Pendidikan Bahasa dan Sastra Indonesia 2',3,4,3),('PDW 2450','Evaluasi Pembelajaran',3,4,3),('PDW 2451','Media Pembelajaran Berbasis ICT',3,4,3),('PDW 2510','Kesehatan Sekolah',2,5,2),('PDW 2539','Program Pengakraban dengan Lingkingan 1',1,5,2),('PDW 2552','Pembelajaran Terpadu',3,5,3),('PDW 2553','Pengembangan Kurikulum dan Pembelajaran',3,5,3),('PDW 2554','Manajemen Kelas',2,5,2),('PDW 2557','Metode Penelitian Pendidikan',3,5,3),('PDW 2611','Pendidikan Jasmani',2,6,2),('PDW 2612','Pendidikan Seni Musik',2,6,2),('PDW 2613','Pendidikan Seni Tari',2,6,2),('PDW 2614','Pendidikan Seni Drama',2,6,2),('PDW 2615','Pendidikan Bahasa Jawa/Budaya Jawa',2,6,2),('PDW 2621','Manajemen Berbasis Sekolah',2,6,2),('PDW 2640','Pengajaran Mikro',2,6,4),('PDW 2641','Program Pengakraban dengan Lingkungan 2',1,6,2),('PDW 2658','Penelitian Tindakan Kelas',3,6,3),('USD 120','Pendidikan Agama',2,1,2),('USD 121','Teologi Moral',2,2,2),('USD 122','Filsafat Moral',2,2,2),('USD 123','Pendidikan Pancasila',2,3,2),('USD 224','Pendidikan Kewarganegaraan/Kewiraan',2,5,2),('USD 325','Filsafat Ilmu Pengetahuan',2,7,2);

/*Table structure for table `ruang` */

DROP TABLE IF EXISTS `ruang`;

CREATE TABLE `ruang` (
  `idRuang` varchar(50) NOT NULL,
  `namaRuang` varchar(50) DEFAULT NULL,
  `jenisRuang` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idRuang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ruang` */

insert  into `ruang`(`idRuang`,`namaRuang`,`jenisRuang`) values ('-','-','-'),('11','I PGSD 1','TEORI'),('12','I PGSD 2','TEORI'),('13','I PGSD 3 / LAB IPS/PKN','TEORI PRAKTIKUM'),('21','II PGSD 1 / LAB MATEMATIKA','TEORI PRAKTIKUM'),('22','II PGSD 2 / LAB MATEMATIKA','TEORI PRAKTIKUM'),('23','II PGSD 3','TEORI'),('24','II PGSD 4/ LAB BAHASA','TEORI PRAKTIKUM'),('300','LT. 3 DEPAN XAVERIUS','TEORI'),('401','LT. 4','TEORI'),('402','LT. 4','TEORI'),('L.IPA','LAB. IPA','PRAKTIKUM'),('L.LIS','LT. 4 POJOK','PRAKTIKUM'),('L.M','LAB MULTIMEDIA','PRAKTIKUM'),('L.SBK','LAB. SBK','PRAKTIKUM'),('MIKRO','LAB MIKRO TEACHING','PRAKTIKUM'),('MONTE','LAB MONTESSORI','PRAKTIKUM'),('REA1','REALINO 1','PRAKTIKUM'),('REA2','REALINO 2','PRAKTIKUM'),('REA3','REALINO 3','PRAKTIKUM'),('XAV','XAVERIUS','TEORI');

/*Table structure for table `tabel_jadwal` */

DROP TABLE IF EXISTS `tabel_jadwal`;

CREATE TABLE `tabel_jadwal` (
  `noRule` int(10) NOT NULL,
  `idKelas` varchar(3) NOT NULL,
  `idRuang` varchar(50) NOT NULL,
  `Hari` varchar(50) NOT NULL,
  `Jam` varchar(50) NOT NULL,
  PRIMARY KEY (`noRule`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tabel_jadwal` */

insert  into `tabel_jadwal`(`noRule`,`idKelas`,`idRuang`,`Hari`,`Jam`) values (0,'70','11','Senin','07:00-09:59'),(1,'0','11','Senin','10:00-12:59'),(2,'114','11','Senin','13:00-15:59'),(3,'4','11','Senin','16:00-18:59'),(4,'0','402','Senin','07:00-09:59'),(5,'33','402','Senin','10:00-12:59'),(6,'0','402','Senin','13:00-15:59'),(7,'0','402','Senin','16:00-18:59'),(8,'0','401','Senin','07:00-09:59'),(9,'0','401','Senin','10:00-12:59'),(10,'18','401','Senin','13:00-15:59'),(11,'23','401','Senin','16:00-18:59'),(12,'30','300','Senin','07:00-09:59'),(13,'0','300','Senin','10:00-12:59'),(14,'50','300','Senin','13:00-15:59'),(15,'94','300','Senin','16:00-18:59'),(16,'0','23','Senin','07:00-09:59'),(17,'21','23','Senin','10:00-12:59'),(18,'0','23','Senin','13:00-15:59'),(19,'0','23','Senin','16:00-18:59'),(20,'2','12','Senin','07:00-09:59'),(21,'98','12','Senin','10:00-12:59'),(22,'22','12','Senin','13:00-15:59'),(23,'51','12','Senin','16:00-18:59'),(24,'0','XAV','Senin','07:00-09:59'),(25,'0','XAV','Senin','10:00-12:59'),(26,'82','XAV','Senin','13:00-15:59'),(27,'0','XAV','Senin','16:00-18:59'),(28,'0','22','Senin','07:00-09:59'),(29,'83','22','Senin','10:00-12:59'),(30,'0','22','Senin','13:00-15:59'),(31,'62','22','Senin','16:00-18:59'),(32,'36','24','Senin','07:00-09:59'),(33,'69','24','Senin','10:00-12:59'),(34,'46','24','Senin','13:00-15:59'),(35,'104','24','Senin','16:00-18:59'),(36,'77','21','Senin','07:00-09:59'),(37,'120','21','Senin','10:00-12:59'),(38,'54','21','Senin','13:00-15:59'),(39,'58','21','Senin','16:00-18:59'),(40,'17','13','Senin','07:00-09:59'),(41,'0','13','Senin','10:00-12:59'),(42,'0','13','Senin','13:00-15:59'),(43,'0','13','Senin','16:00-18:59'),(44,'59','11','Selasa','07:00-09:59'),(45,'0','11','Selasa','10:00-12:59'),(46,'0','11','Selasa','13:00-15:59'),(47,'0','11','Selasa','16:00-18:59'),(48,'0','402','Selasa','07:00-09:59'),(49,'0','402','Selasa','10:00-12:59'),(50,'48','402','Selasa','13:00-15:59'),(51,'0','402','Selasa','16:00-18:59'),(52,'39','401','Selasa','07:00-09:59'),(53,'12','401','Selasa','10:00-12:59'),(54,'8','401','Selasa','13:00-15:59'),(55,'71','401','Selasa','16:00-18:59'),(56,'0','300','Selasa','07:00-09:59'),(57,'109','300','Selasa','10:00-12:59'),(58,'27','300','Selasa','13:00-15:59'),(59,'0','300','Selasa','16:00-18:59'),(60,'15','23','Selasa','07:00-09:59'),(61,'0','23','Selasa','10:00-12:59'),(62,'0','23','Selasa','13:00-15:59'),(63,'0','23','Selasa','16:00-18:59'),(64,'90','12','Selasa','07:00-09:59'),(65,'0','12','Selasa','10:00-12:59'),(66,'0','12','Selasa','13:00-15:59'),(67,'0','12','Selasa','16:00-18:59'),(68,'0','XAV','Selasa','07:00-09:59'),(69,'0','XAV','Selasa','10:00-12:59'),(70,'96','XAV','Selasa','13:00-15:59'),(71,'0','XAV','Selasa','16:00-18:59'),(72,'0','22','Selasa','07:00-09:59'),(73,'0','22','Selasa','10:00-12:59'),(74,'26','22','Selasa','13:00-15:59'),(75,'6','22','Selasa','16:00-18:59'),(76,'63','24','Selasa','07:00-09:59'),(77,'0','24','Selasa','10:00-12:59'),(78,'0','24','Selasa','13:00-15:59'),(79,'67','24','Selasa','16:00-18:59'),(80,'0','21','Selasa','07:00-09:59'),(81,'0','21','Selasa','10:00-12:59'),(82,'0','21','Selasa','13:00-15:59'),(83,'49','21','Selasa','16:00-18:59'),(84,'37','13','Selasa','07:00-09:59'),(85,'0','13','Selasa','10:00-12:59'),(86,'105','13','Selasa','13:00-15:59'),(87,'35','13','Selasa','16:00-18:59'),(88,'121','11','Rabu','07:00-09:59'),(89,'0','11','Rabu','10:00-12:59'),(90,'84','11','Rabu','13:00-15:59'),(91,'107','11','Rabu','16:00-18:59'),(92,'0','402','Rabu','07:00-09:59'),(93,'0','402','Rabu','10:00-12:59'),(94,'87','402','Rabu','13:00-15:59'),(95,'0','402','Rabu','16:00-18:59'),(96,'81','401','Rabu','07:00-09:59'),(97,'43','401','Rabu','10:00-12:59'),(98,'0','401','Rabu','13:00-15:59'),(99,'93','401','Rabu','16:00-18:59'),(100,'103','300','Rabu','07:00-09:59'),(101,'0','300','Rabu','10:00-12:59'),(102,'52','300','Rabu','13:00-15:59'),(103,'0','300','Rabu','16:00-18:59'),(104,'0','23','Rabu','07:00-09:59'),(105,'0','23','Rabu','10:00-12:59'),(106,'0','23','Rabu','13:00-15:59'),(107,'118','23','Rabu','16:00-18:59'),(108,'108','12','Rabu','07:00-09:59'),(109,'40','12','Rabu','10:00-12:59'),(110,'78','12','Rabu','13:00-15:59'),(111,'97','12','Rabu','16:00-18:59'),(112,'0','XAV','Rabu','07:00-09:59'),(113,'0','XAV','Rabu','10:00-12:59'),(114,'88','XAV','Rabu','13:00-15:59'),(115,'7','XAV','Rabu','16:00-18:59'),(116,'32','22','Rabu','07:00-09:59'),(117,'0','22','Rabu','10:00-12:59'),(118,'122','22','Rabu','13:00-15:59'),(119,'0','22','Rabu','16:00-18:59'),(120,'0','24','Rabu','07:00-09:59'),(121,'1','24','Rabu','10:00-12:59'),(122,'0','24','Rabu','13:00-15:59'),(123,'34','24','Rabu','16:00-18:59'),(124,'60','21','Rabu','07:00-09:59'),(125,'28','21','Rabu','10:00-12:59'),(126,'0','21','Rabu','13:00-15:59'),(127,'0','21','Rabu','16:00-18:59'),(128,'0','13','Rabu','07:00-09:59'),(129,'79','13','Rabu','10:00-12:59'),(130,'0','13','Rabu','13:00-15:59'),(131,'0','13','Rabu','16:00-18:59'),(132,'111','11','Kamis','07:00-09:59'),(133,'64','11','Kamis','10:00-12:59'),(134,'57','11','Kamis','13:00-15:59'),(135,'53','11','Kamis','16:00-18:59'),(136,'0','402','Kamis','07:00-09:59'),(137,'0','402','Kamis','10:00-12:59'),(138,'0','402','Kamis','13:00-15:59'),(139,'74','402','Kamis','16:00-18:59'),(140,'0','401','Kamis','07:00-09:59'),(141,'56','401','Kamis','10:00-12:59'),(142,'5','401','Kamis','13:00-15:59'),(143,'44','401','Kamis','16:00-18:59'),(144,'110','300','Kamis','07:00-09:59'),(145,'38','300','Kamis','10:00-12:59'),(146,'0','300','Kamis','13:00-15:59'),(147,'20','300','Kamis','16:00-18:59'),(148,'55','23','Kamis','07:00-09:59'),(149,'0','23','Kamis','10:00-12:59'),(150,'0','23','Kamis','13:00-15:59'),(151,'61','23','Kamis','16:00-18:59'),(152,'0','12','Kamis','07:00-09:59'),(153,'0','12','Kamis','10:00-12:59'),(154,'92','12','Kamis','13:00-15:59'),(155,'117','12','Kamis','16:00-18:59'),(156,'47','XAV','Kamis','07:00-09:59'),(157,'106','XAV','Kamis','10:00-12:59'),(158,'9','XAV','Kamis','13:00-15:59'),(159,'113','XAV','Kamis','16:00-18:59'),(160,'14','22','Kamis','07:00-09:59'),(161,'0','22','Kamis','10:00-12:59'),(162,'3','22','Kamis','13:00-15:59'),(163,'45','22','Kamis','16:00-18:59'),(164,'19','24','Kamis','07:00-09:59'),(165,'11','24','Kamis','10:00-12:59'),(166,'73','24','Kamis','13:00-15:59'),(167,'0','24','Kamis','16:00-18:59'),(168,'0','21','Kamis','07:00-09:59'),(169,'119','21','Kamis','10:00-12:59'),(170,'0','21','Kamis','13:00-15:59'),(171,'89','21','Kamis','16:00-18:59'),(172,'80','13','Kamis','07:00-09:59'),(173,'99','13','Kamis','10:00-12:59'),(174,'0','13','Kamis','13:00-15:59'),(175,'102','13','Kamis','16:00-18:59'),(176,'25','11','Jumat','07:00-09:59'),(177,'95','11','Jumat','10:00-12:59'),(178,'75','11','Jumat','13:00-15:59'),(179,'13','11','Jumat','16:00-18:59'),(180,'76','402','Jumat','07:00-09:59'),(181,'16','402','Jumat','10:00-12:59'),(182,'100','402','Jumat','13:00-15:59'),(183,'68','402','Jumat','16:00-18:59'),(184,'0','401','Jumat','07:00-09:59'),(185,'42','401','Jumat','10:00-12:59'),(186,'85','401','Jumat','13:00-15:59'),(187,'0','401','Jumat','16:00-18:59'),(188,'0','300','Jumat','07:00-09:59'),(189,'0','300','Jumat','10:00-12:59'),(190,'91','300','Jumat','13:00-15:59'),(191,'0','300','Jumat','16:00-18:59'),(192,'0','23','Jumat','07:00-09:59'),(193,'86','23','Jumat','10:00-12:59'),(194,'66','23','Jumat','13:00-15:59'),(195,'10','23','Jumat','16:00-18:59'),(196,'31','12','Jumat','07:00-09:59'),(197,'0','12','Jumat','10:00-12:59'),(198,'0','12','Jumat','13:00-15:59'),(199,'0','12','Jumat','16:00-18:59'),(200,'65','XAV','Jumat','07:00-09:59'),(201,'0','XAV','Jumat','10:00-12:59'),(202,'41','XAV','Jumat','13:00-15:59'),(203,'0','XAV','Jumat','16:00-18:59'),(204,'72','22','Jumat','07:00-09:59'),(205,'0','22','Jumat','10:00-12:59'),(206,'24','22','Jumat','13:00-15:59'),(207,'101','22','Jumat','16:00-18:59'),(208,'112','24','Jumat','07:00-09:59'),(209,'29','24','Jumat','10:00-12:59'),(210,'0','24','Jumat','13:00-15:59'),(211,'0','24','Jumat','16:00-18:59'),(212,'116','21','Jumat','07:00-09:59'),(213,'115','21','Jumat','10:00-12:59'),(214,'0','21','Jumat','13:00-15:59'),(215,'0','21','Jumat','16:00-18:59'),(216,'0','13','Jumat','07:00-09:59'),(217,'0','13','Jumat','10:00-12:59'),(218,'0','13','Jumat','13:00-15:59'),(219,'0','13','Jumat','16:00-18:59');

/*Table structure for table `tabelpermintaan` */

DROP TABLE IF EXISTS `tabelpermintaan`;

CREATE TABLE `tabelpermintaan` (
  `noRule` int(10) NOT NULL,
  `idKelas` varchar(3) NOT NULL,
  `idRuang` varchar(50) NOT NULL,
  `Hari` varchar(50) NOT NULL,
  `Jam` varchar(50) NOT NULL,
  PRIMARY KEY (`noRule`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tabelpermintaan` */

insert  into `tabelpermintaan`(`noRule`,`idKelas`,`idRuang`,`Hari`,`Jam`) values (1,'59','-','Selasa','07:00-09:59'),(2,'21','23','Senin','10:00-12:59'),(3,'121','-','Rabu','-'),(4,'82','XAV','-','13:00-15:59'),(5,'110','300','Kamis','-'),(6,'2','12','-','-'),(7,'4','-','-','16:00-18:59');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
