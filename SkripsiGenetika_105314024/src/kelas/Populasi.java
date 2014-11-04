/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelas;

import java.sql.SQLException;
import java.util.List;
import kontrol.DosenKontrol;
import kontrol.KelasMatkulKontrol;
import kontrol.MataKuliahKontrol;
import kontrol.PenjadwalanKontrol;
import kontrol.RuangKontrol;
import view.viewPenjadwalan;

/**
 *
 * @author Adhi
 */
public class Populasi {

    Kromosom[] parent = new Kromosom[4];//satu populasi terdiri dari 4 kromosom
    int iterasi = 0;
    int indexSolusi = -1;
    int[] score = new int[4];

    int fitnessTerkecil = 1000;

    //databasenya
    List<Ruang> dataRuang;
    List<KelasKuliah> dataKelasKuliah;
    List<MataKuliah> dataMakul;
    List<Dosen> dataDosen;
    List<tabelPermintaan> dataPermintaan;

    public void ambilData() throws SQLException { //untuk select database
        dataRuang = RuangKontrol.getKoneksi().tampilRuangTeori();//KELAS PELANGGARAN
        dataKelasKuliah = KelasMatkulKontrol.getKoneksi().ambilKelasKuliah();//KELAS KROMOSOM
        dataMakul = MataKuliahKontrol.getKoneksi().tampilMataKuliah();
        dataDosen = DosenKontrol.getKoneksi().tampilDosen();//KELAS PELANGGARAN
        dataPermintaan = PenjadwalanKontrol.getKoneksi().selectTabelPermintaan();
    }

    public void solusiAwalIterasi() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = new Kromosom(dataKelasKuliah, dataRuang).solusiAwal(dataKelasKuliah, dataRuang, dataMakul, dataPermintaan);
        }
        iterasi++;
    }

    public void EvaluasiFitness() {
        for (int i = 0; i < getParent().length; i++) {
            parent[i] = Pelanggaran.eksekusiAturan(parent[i], dataRuang, dataDosen);
        }
    }

    public void EvaluasiFitness_child() {
        for (int i = 2; i < getParent().length; i++) {
            parent[i] = Pelanggaran.eksekusiAturan(parent[i], dataRuang, dataDosen);
        }
    }

    public void kriteriaBerhenti() {
        for (int i = 0; i < parent.length; i++) {
            for (int j = 0; j < parent[i].data.length; j++) {
                if (parent[i].data[j].getNilaiFitness() != 0) {
                    score[i] = score[i] + parent[i].data[j].getNilaiFitness();
                } else {
                    score[i] = score[i];
                }
            }
            if (score[i] == 0) {
                indexSolusi = i;
                fitnessTerkecil = 0;
                viewPenjadwalan.progres_barnya.setValue(100);
            } else {
                int n = parent[i].data.length;
                if (score[i] < fitnessTerkecil) {
                    fitnessTerkecil = score[i];
                    viewPenjadwalan.progres_barnya.setValue(((n - fitnessTerkecil) / n) * 100);
                } else {
                    viewPenjadwalan.progres_barnya.setValue(((n - fitnessTerkecil) / n) * 100);
                }
            }
        }
    }

    public void cetak() {
        for (int j = 0; j < parent[indexSolusi].getData().length; j++) {
            if (j == 110) {
                System.out.println(parent[indexSolusi].getData()[j].getAllele().getIdKelas());
            } else {
                System.out.println(parent[indexSolusi].getData()[j].getAllele().getIdKelas());
            }
        }
        System.out.println("");
    }

    public void RouleteWheelSelection() {
        for (int iterasi = 0; iterasi <= score.length - 2; iterasi++) {//selection Sort Method
            int minIndex = iterasi;
            for (int elemen = iterasi + 1; elemen <= score.length - 1; elemen++) {
                if (score[elemen] < score[minIndex]) {
                    minIndex = elemen;
                }
            }
            Kromosom temp = parent[iterasi];
            parent[iterasi] = parent[minIndex];
            parent[minIndex] = temp;

            int temp1 = score[iterasi];
            score[iterasi] = score[minIndex];
            score[minIndex] = temp1;
        }

        for (int i = 0; i < score.length; i++) { //reset score
            score[i] = 0;
        }
    }

    /**
     * @return the parent
     */
    public Kromosom[] getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Kromosom[] parent) {
        this.parent = parent;
    }

    /**
     * @return the iterasi
     */
    public int getIterasi() {
        return iterasi;
    }

    /**
     * @param iterasi the iterasi to set
     */
    public void setIterasi(int iterasi) {
        this.iterasi = iterasi;
    }

    public void prosesGenetika() throws SQLException {
        ambilData();
        solusiAwalIterasi();
        EvaluasiFitness();
        kriteriaBerhenti();
//        cetak();
        while (indexSolusi == -1) {
            iterasi++;
            RouleteWheelSelection();
            parent = Genetika.crossover(parent, dataKelasKuliah, dataMakul, dataPermintaan);
            parent = Genetika.Mutasi(parent, dataKelasKuliah, dataMakul, dataPermintaan);
            EvaluasiFitness_child();
            kriteriaBerhenti();
        }
        System.out.println("Solusi : " + indexSolusi);
        System.out.println("Selama : " + iterasi + " iterasi");
        simpanJadwal(parent[indexSolusi]);
//        cetak();
//        System.out.println("");
//        for (int i = 0; i < parent.length; i++) { // parent.length
//            for (int j = 0; j < parent[indexSolusi].getData().length; j++) {
//                System.out.println("Gen[" + indexSolusi + "]");
//                System.out.println("Index " + j);
//                System.out.println("idKelas     : " + parent[indexSolusi].getData()[j].getAllele().getIdKelas());
//                System.out.println("kodeMatkul  : " + parent[indexSolusi].getData()[j].getAllele().getIdMK().getIdMK() + " - " + parent[indexSolusi].getData()[j].getAllele().getIdDosen().idDosen);
//                System.out.println("kelas       : " + parent[indexSolusi].getData()[j].getAllele().getKelas());
//                System.out.println("hari        : " + parent[indexSolusi].getData()[j].getHari());
//                System.out.println("ruang       : " + parent[indexSolusi].getData()[j].getRuang().getIdRuang());
//                System.out.println("jam ke      : " + parent[indexSolusi].getData()[j].getJam());
//                System.out.println("Semester    : " + parent[indexSolusi].getData()[j].getAllele().getIdMK().getSemester());
//                System.out.println("FITNES      : " + parent[indexSolusi].getData()[j].getNilaiFitness());
//                System.out.println("");
//
//            }
//            System.out.println("------------------------------------------------------------------------------------");
//        }
    }
//    public void prosesGenetika() throws SQLException {
//        ambilData();
//        solusiAwalIterasi();
//        EvaluasiFitness();
//        kriteriaBerhenti();
////        cetak();
////        while (indexSolusi == -1) {
////            iterasi++;
////            RouleteWheelSelection();
////            parent = Genetika.crossover(parent, dataKelasKuliah, dataMakul, dataPermintaan);
////            parent = Genetika.Mutasi(parent, dataKelasKuliah, dataMakul, dataPermintaan);
////            EvaluasiFitness_child();
////            kriteriaBerhenti();
////        }
////        System.out.println("Solusi : " + indexSolusi);
////        System.out.println("Selama : " + iterasi + " iterasi");
////        simpanJadwal(parent[indexSolusi]);
////        cetak();
////        System.out.println("");
//        for (int i = 0; i < parent.length; i++) { // parent.length
//            for (int j = 0; j < parent[i].getData().length; j++) {
//                System.out.println("Gen[" + i + "]");
//                System.out.println("Index " + j);
//                System.out.println("idKelas     : " + parent[i].getData()[j].getAllele().getIdKelas());
//                System.out.println("kodeMatkul  : " + parent[i].getData()[j].getAllele().getIdMK().getIdMK() + " - " + parent[i].getData()[j].getAllele().getIdDosen().idDosen);
//                System.out.println("kelas       : " + parent[i].getData()[j].getAllele().getKelas());
//                System.out.println("hari        : " + parent[i].getData()[j].getHari());
//                System.out.println("ruang       : " + parent[i].getData()[j].getRuang().getIdRuang());
//                System.out.println("jam ke      : " + parent[i].getData()[j].getJam());
//                System.out.println("Semester    : " + parent[i].getData()[j].getAllele().getIdMK().getSemester());
//                System.out.println("FITNES      : " + parent[i].getData()[j].getNilaiFitness());
//                System.out.println("");
//
//            }
//            System.out.println("------------------------------------------------------------------------------------");
//        }
//    }

    public void simpanJadwal(Kromosom solusi) throws SQLException {
        PenjadwalanKontrol.getKoneksi().deleteJadwal();
        for (int i = 0; i < solusi.data.length; i++) {
            int noRule = i;
            int idKelas = solusi.getData()[i].getAllele().getIdKelas();
            String idRuang = solusi.getData()[i].getRuang().getIdRuang();
            String hari = solusi.getData()[i].getHari();
            String jam = konversiJam(solusi.getData()[i].getJam());
            tabelPermintaan temp = new tabelPermintaan(noRule, idKelas, idRuang, hari, jam);
            PenjadwalanKontrol.getKoneksi().insertJadwal(temp);
        }
    }

    public String konversiJam(int jam) {
        if (jam == 1) {
            return "07:00-09:59";
        } else if (jam == 2) {
            return "10:00-12:59";
        } else if (jam == 3) {
            return "13:00-15:59";
        } else if (jam == 4) {
            return "16:00-18:59";
        } else {
            return "";//0 berarti bisa jam berapa aja
        }
    }

//    public static void main(String[] args) throws SQLException {
//        Populasi pop = new Populasi();
//        pop.prosesGenetika();
//    }
}
