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

insert  into `dosen`(`idDosen`,`namaDosen`,`status`) values ('D001','Drs. Paulus Wahana, M.Hum.','Tetap'),('D002','Drs. Y.B. Adimassana, M.A.','Tetap'),('D003','Catur Rismiati, S.Pd., M.A., Ph.D.','Tetap'),('D004','G. Ari Nugrahanta, S.J, M.A.','Tetap'),('D005','Rusmawan, S.Pd., M.Pd.','Tetap'),('D006','Eny Winarti, Ph. D.','Tetap'),('D007','Galih Kusumo, S.Pd, M.Pd.','Tetap'),('D008','Theresia Yunia Setyawan, S.Pd, M.Hum.','Tetap'),('D009','Dra. Ignatia Esti Sumarah, M.Hum.','Tetap'),('D010','Drs. Puji Purnomo, M.Si.','Tetap'),('D011','Andri Anugrahana, S.Pd., M.Pd.','Tetap'),('D012','Wahyu Wido Sari, S.Si., M.Biotech.','Tetap'),('D013','Elisabeth Desiana Mayasari, S.Psi., M.A.','Tetap'),('D014','Agnes Herlina Dwi Hadiyanti, M.T., M. Sc.','Tetap'),('D015','Christiyanti Aprinastuti, S.Si., M.Pd.','Tetap'),('D016','Laurensia Aptik Evanjeli, S.Psi., M.A.','Tetap'),('D017','Brigitta Erlita Tri Anggadewi, S.Psi., M.Psi.','Tetap'),('D018','Irine Kurniastuti, S.Psi., M.Psi.','Tetap'),('D019','Apri Damai Sagita Krissandi, S.S., M.Pd.','Tetap'),('D020','Maria Melani Ika Susanti, S.Pd.','Tetap'),('T001','Pdt. Jonsa Manulang, S. Th, M.Th','Tidak Tetap'),('T002','Khusnul Khotimah, M.A.','Tidak Tetap'),('T003','Paulus Tri Anung, SIP, M.A.','Tidak Tetap'),('T004','Cahya Fujianto, S.Si, M.Tech','Tidak Tetap'),('T005','Ganjar','Tidak Tetap'),('T006','Renyaan','Tidak Tetap'),('T007','Widodo Budi','Tidak Tetap'),('T008','Veronika Fitri, S.Pd., M.Sc.','Tidak Tetap'),('T009','Elisabeth Ayunika, S.Pd., M.Ed.','Tidak Tetap'),('T010','A.G. Sujatmiko Bambang Santoso, M.Hum.','Tidak Tetap'),('T011','Drs. St. Kartono, M.Hum.','Tidak Tetap'),('T012','Dr. Christina Dewi Tri Murwani, M.Hum.','Tidak Tetap'),('T013','Dr. Y.R. Subakti, M.Pd','Tidak Tetap'),('T014','Wahyudi','Tidak Tetap'),('T015','Dr. Purwanta','Tidak Tetap'),('T016','Drs. B. Musidi, M.Pd.','Tidak Tetap'),('T017','Bp. Sahana','Tidak Tetap'),('T018','Dra. Maslicah A., M.Pd.','Tidak Tetap'),('T019','Dr. Anton Haryono','Tidak Tetap'),('T020','Drs. A.K. Wiharyanto, M.Pd.','Tidak Tetap'),('T021','Y.R. Adisusilo, M.Pd.','Tidak Tetap'),('T022','Dra. T.H. Sumini, M.Pd.','Tidak Tetap'),('T023','Th. Laksmi, M.Pd','Tidak Tetap'),('T024','Drs. Johanes Sabari, M.Si.','Tidak Tetap'),('T025','Dr. CB Mulyanto, Pr., S.S','Tidak Tetap'),('T026','Rm. Warsito, Pr.','Tidak Tetap');

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

insert  into `kelas_makul`(`idKelas`,`idMK`,`idDosen`,`Kelas`) values ('1','USD 120 ','D009 ','A'),('10','PDW 2106','D002 ','E'),('100','PDW 2553','D010 ','A'),('101','PDW 2553','D010 ','B'),('102','PDW 2553','D010 ','C'),('103','PDW 2553','D010 ','D'),('104','PDW 2553','D006 ','E'),('105','PDW 2553','D006 ','F'),('106','PDW 2554','D005 ','A'),('107','PDW 2554','D005 ','B'),('108','PDW 2554','D005 ','C'),('109','PDW 2554','D007 ','D'),('11','PDW 2119','D017 ','A'),('110','PDW 2554','T023 ','E'),('111','PDW 2554','D008 ','F'),('112','PDW 2557','D017 ','A'),('113','PDW 2557','D016 ','B'),('114','PDW 2557','D006 ','C'),('115','PDW 2557','D003 ','D'),('116','PDW 2557','D008 ','E'),('117','PDW 2557','D005 ','F'),('118','USD 325 ','T025 ','A'),('119','USD 325 ','T025 ','B'),('12','PDW 2119','D017 ','B'),('120','USD 325 ','T025 ','C'),('121','USD 325 ','T026 ','D'),('122','USD 325 ','T026 ','E'),('13','PDW 2119','D017 ','C'),('14','PDW 2119','T003 ','D'),('15','PDW 2119','T003 ','E'),('16','PDW 2123','D014 ','A'),('17','PDW 2123','D012 ','B'),('18','PDW 2123','D012 ','C'),('19','PDW 2123','T004 ','D'),('2','USD 120 ','T001 ','B'),('20','PDW 2123','T004 ','E'),('21','PDW 2124','T005 ','A'),('22','PDW 2124','T006 ','B'),('23','PDW 2124','T006 ','C'),('24','PDW 2124','T007 ','D'),('25','PDW 2124','T007 ','E'),('26','PDW 2125','T008 ','A'),('27','PDW 2125','T009 ','B'),('28','PDW 2125','T009 ','C'),('29','PDW 2125','D015 ','D'),('3','USD 120 ','D009 ','C'),('30','PDW 2125','D015 ','E'),('31','PDW 2126','T010 ','A'),('32','PDW 2126','T010 ','B'),('33','PDW 2126','T010 ','C'),('34','PDW 2126','T010 ','D'),('35','PDW 2126','T010 ','E'),('36','PDW 2155','T011 ','A'),('37','PDW 2155','T011 ','B'),('38','PDW 2155','T012 ','C'),('39','PDW 2155','T012 ','D'),('4','USD 120 ','T002 ','D'),('40','PDW 2155','T012 ','E'),('41','USD 123 ','D001 ','A'),('42','USD 123 ','D001 ','B'),('43','USD 123 ','D001 ','C'),('44','USD 123 ','D001 ','D'),('45','USD 123 ','T013 ','E'),('46','USD 123 ','T013 ','F'),('47','PDW 2319','D016 ','A'),('48','PDW 2319','D016 ','B'),('49','PDW 2319','D016 ','C'),('5','USD 120 ','D009 ','E'),('50','PDW 2319','D016 ','D'),('51','PDW 2319','T003 ','E'),('52','PDW 2334','D001 ','A'),('53','PDW 2334','D001 ','B'),('54','PDW 2334','D001 ','C'),('55','PDW 2334','T014 ','D'),('56','PDW 2334','T014 ','E'),('57','PDW 2335','T015 ','A'),('58','PDW 2335','T016 ','B'),('59','PDW 2335','T017 ','C'),('6','PDW 2106','D004 ','A'),('60','PDW 2335','T015 ','D'),('61','PDW 2335','T015 ','E'),('62','PDW 2336','D013 ','A'),('63','PDW 2336','D013 ','B'),('64','PDW 2336','D018 ','C'),('65','PDW 2336','D018 ','D'),('66','PDW 2336','D018 ','E'),('67','PDW 2343','D012 ','A'),('68','PDW 2343','D012 ','B'),('69','PDW 2343','T018 ','C'),('7','PDW 2106','D004 ','B'),('70','PDW 2343','T018 ','D'),('71','PDW 2343','T018 ','E'),('72','PDW 2344','D015 ','A'),('73','PDW 2344','D015 ','B'),('74','PDW 2344','D015 ','C'),('75','PDW 2344','D011 ','D'),('76','PDW 2344','D011 ','E'),('77','PDW 2356','D018 ','A'),('78','PDW 2356','D017 ','B'),('79','PDW 2356','D017 ','C'),('8','PDW 2106','D004 ','C'),('80','PDW 2356','D003 ','D'),('81','PDW 2356','D016 ','E'),('82','USD 224 ','T019 ','A'),('83','USD 224 ','T020 ','B'),('84','USD 224 ','T020 ','C'),('85','USD 224 ','T013 ','D'),('86','USD 224 ','T021 ','E'),('87','USD 224 ','T022 ','F'),('88','PDW 2510','D009 ','A'),('89','PDW 2510','D009 ','B'),('9','PDW 2106','D002 ','D'),('90','PDW 2510','D009 ','C'),('91','PDW 2510','D009 ','D'),('92','PDW 2510','D015 ','E'),('93','PDW 2510','D012 ','F'),('94','PDW 2552','D005 ','A'),('95','PDW 2552','D005 ','B'),('96','PDW 2552','D005 ','C'),('97','PDW 2552','T018 ','D'),('98','PDW 2552','D014 ','E'),('99','PDW 2552','D014 ','F');

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

insert  into `matakuliah`(`idMK`,`namaMK`,`sks`,`semester`,`JP`) values ('KPDS 032','Pendidikan Jasmani 1',1,7,2),('KPDS 050A','Penelitian Tindakan Kelas',3,7,3),('KPDS 058','Pendidikan Multikultural',2,7,2),('KPDS 067A','Evaluasi Pembelajaran 2',2,7,2),('KPDS 085','Media Pembelajaran Konvensional dan Berbasis IT',3,7,3),('KPDS 086','Keterampilan Dasar Mengajar',2,7,4),('PDW 2106','Logika',2,1,2),('PDW 2107','Pendidikan Keterampilan Menulis Indah dan Kerajinan Tangan',2,1,2),('PDW 2119','Perkembangan dan Belajar Peserta Didik 1',2,1,2),('PDW 2122','Bahasa dan Sastra Indonesia',2,1,2),('PDW 2123','IPA Biologi',3,1,3),('PDW 2124','IPA Fisika',3,1,3),('PDW 2125','Matematika 1',3,1,3),('PDW 2126','Bahasa Inggris 1',2,1,2),('PDW 2155','Keterampilan Menulis Ilmiah',2,1,2),('PDW 2208','Pendidikan Seni Rupa',2,2,2),('PDW 2217','Landasan Pendidikan',3,2,3),('PDW 2218','Bimbingan dan Konseling',2,2,2),('PDW 2228','Praktikum IPA Biologi',2,2,4),('PDW 2229','Praktikum IPA Fisika',2,2,4),('PDW 2230','Matematika 2',3,2,3),('PDW 2231','Keterampilan Bahasa Indonesia',3,2,3),('PDW 2232','Bahasa Inggris 2',2,2,2),('PDW 2233','Bimbingan Pramuka',1,2,2),('PDW 2319','Perkembangan dan Belajar Peserta Didik 2',2,3,2),('PDW 2334','PKn',2,3,2),('PDW 2335','IPS',3,3,3),('PDW 2336','Permainan Anak',2,3,2),('PDW 2337','Bimbingan Belajar 1',1,3,2),('PDW 2343','Pendidikan IPA',3,3,3),('PDW 2344','Pendidikan Matematika 1',3,3,3),('PDW 2345','Pendidikan Bahasa dan Sastra Indonesia',3,3,3),('PDW 2356','Statistik Pendidikan',2,3,2),('PDW 2409','Pendidikan Religiositas Anak',2,4,2),('PDW 2420','Pendidikan Anak Berkebutuhan Khusus',2,4,2),('PDW 2438','Bimbingan Belajar 2',1,4,2),('PDW 2446','Pendidikan PKn',2,4,2),('PDW 2447','Pendidikan IPS',3,4,3),('PDW 2448','Pendidikan Matematika 2',3,4,3),('PDW 2449','Pendidikan Bahasa dan Sastra Indonesia 2',3,4,3),('PDW 2450','Evaluasi Pembelajaran',3,4,3),('PDW 2451','Media Pembelajaran Berbasis ICT',3,4,3),('PDW 2510','Kesehatan Sekolah',2,5,2),('PDW 2539','Program Pengakraban dengan Lingkingan 1',1,5,2),('PDW 2552','Pembelajaran Terpadu',3,5,3),('PDW 2553','Pengembangan Kurikulum dan Pembelajaran',3,5,3),('PDW 2554','Manajemen Kelas',2,5,2),('PDW 2557','Metode Penelitian Pendidikan',3,5,3),('PDW 2611','Pendidikan Jasmani',2,6,2),('PDW 2612','Pendidikan Seni Musik',2,6,2),('PDW 2613','Pendidikan Seni Tari',2,6,2),('PDW 2614','Pendidikan Seni Drama',2,6,2),('PDW 2615','Pendidikan Bahasa Jawa/Budaya Jawa',2,6,2),('PDW 2621','Manajemen Berbasis Sekolah',2,6,2),('PDW 2640','Pengajaran Mikro',2,6,4),('PDW 2641','Program Pengakraban dengan Lingkungan 2',1,6,2),('PDW 2658','Penelitian Tindakan Kelas',3,6,3),('USD 120','Pendidikan Agama',2,1,2),('USD 121','Teologi Moral',2,2,2),('USD 122','Filsafat Moral',2,2,2),('USD 123','Pendidikan Pancasila',2,3,2),('USD 224','Pendidikan Kewarganegaraan/Kewiraan',2,5,2),('USD 325','Filsafat Ilmu Pengetahuan',2,7,2);

/*Table structure for table `ruang` */

DROP TABLE IF EXISTS `ruang`;

CREATE TABLE `ruang` (
  `idRuang` varchar(50) NOT NULL,
  `namaRuang` varchar(50) DEFAULT NULL,
  `jenisRuang` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idRuang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ruang` */

insert  into `ruang`(`idRuang`,`namaRuang`,`jenisRuang`) values ('-','',''),('11','I PGSD 1','TEORI'),('12','I PGSD 2','TEORI'),('13','I PGSD 3 / LAB IPS/PKN','TEORI PRAKTIKUM'),('21','II PGSD 1 / LAB MATEMATIKA','TEORI PRAKTIKUM'),('22','II PGSD 2 / LAB MATEMATIKA','TEORI PRAKTIKUM'),('23','II PGSD 3','TEORI'),('24','II PGSD 4/ LAB BAHASA','TEORI PRAKTIKUM'),('300','LT. 3 DEPAN XAVERIUS','TEORI'),('401','LT. 4','TEORI'),('402','LT. 4','TEORI'),('L.IPA','LAB. IPA','PRAKTIKUM'),('L.LIS','LT. 4 POJOK','PRAKTIKUM'),('L.M','LAB MULTIMEDIA','PRAKTIKUM'),('L.SBK','LAB. SBK','PRAKTIKUM'),('MIKRO','LAB MIKRO TEACHING','PRAKTIKUM'),('MONTE','LAB MONTESSORI','PRAKTIKUM'),('REA1','REALINO 1','PRAKTIKUM'),('REA2','REALINO 2','PRAKTIKUM'),('REA3','REALINO 3','PRAKTIKUM'),('XAV','XAVERIUS','TEORI');

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
