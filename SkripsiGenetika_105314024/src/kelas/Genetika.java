/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelas;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontrol.KelasMatkulKontrol;
import kontrol.MataKuliahKontrol;

/**
 *
 * @author Adhi
 */
public class Genetika {

    List<KelasKuliah> kelasKuliah;
    List<MataKuliah> matkul;
    String[] checklist_kk; // <-- untuk cek kk sdh ada di dlm kromosom apa blm.

    public Genetika() {
        ambilDatabase();
    }
//        public void routleWheelSelection() {
////        for (int i = 0; i < parent.length; i++) {
////            Kromosom kromosom = parent[i];
////            
////        }
//
//        for (int i = 1; i < N_fitness.length; i++) { //sorting routel wheel selection
//            for (int j = 0; j < (N_fitness.length - i); j++) {
//                if (N_fitness[j] > N_fitness[j + 1]) {
//                    Kromosom temp = parent[j];
//                    int temp_n = N_fitness[j];
//                    parent[j] = parent[j + 1];
//                    N_fitness[j] = N_fitness[j + 1];
//                    parent[j + 1] = temp;
//                    N_fitness[j + 1] = temp_n;
//                }
//
//            }
//        }
//    }

    public static Kromosom[] crossover(Kromosom[] parent) {
//        routleWheelSelection();
        Kromosom[] krom = parent;
//        popul[0] = parent1;//parent 1 A - B
//        popul[1] = parent2;//parent 2 C - D
//        popul[2] = parent1;//child 1 A - D
//        popul[3] = parent2;//child 2 C - B

        int point = krom[0].getData().length / 2;//titik one point crossover
        for (int i = 0; i < krom[0].getData().length; i++) {
            if (i < point) { // samakan gen A dan C ke child 1 dan 2
                krom[2].getData()[i].setAllele(krom[0].getData()[i].getAllele());
                krom[3].getData()[i].setAllele(krom[1].getData()[i].getAllele());
            } else {
                krom[2].getData()[i].setAllele(krom[1].getData()[i].getAllele());
                krom[3].getData()[i].setAllele(krom[0].getData()[i].getAllele());
            }
            krom[2].getData()[i].setNilaiFitness(0);
            krom[3].getData()[i].setNilaiFitness(0);
        }

        return krom;
    }

    public static Kromosom[] Mutasi(Kromosom[] parent) {
        Kromosom[] krom = parent;

        //replace id duplikat (setelah di cross)
        for (int i = 2; i < krom.length; i++) { // 2-3 --> hanya kromosom anak yg di mutasi
            for (int j = 0; j < krom[i].data.length; j++) {
                if (krom[i].data[j].allele.getIdKelas() != 0) {
//                    if () {
//                    }
//<<-sampe disini
                }
            }
        }

        //pindahkah 1 gen
        return null;
    }

    public void ambilDatabase() {
        try {
            kelasKuliah = KelasMatkulKontrol.getKoneksi().tampilKelasMataKuliah();
            matkul = MataKuliahKontrol.getKoneksi().tampilMataKuliah();
            checklist_kk = new String[kelasKuliah.size()];
            //addOn checklist_kk
            for (int i = 0; i < kelasKuliah.size(); i++) {
                checklist_kk[i] = Integer.toString(kelasKuliah.get(i).getIdKelas()) + "-0";
            }
            sorting();
        } catch (SQLException ex) {
            Logger.getLogger(Genetika.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sorting() { //<--insertion sort method
        for (int i = 1; i <= checklist_kk.length - 1; i++) {
            for (int j = i; j >= 1; j--) {
                int banding1 = Integer.parseInt(checklist_kk[j].split("-")[0]);
                int banding2 = Integer.parseInt(checklist_kk[j - 1].split("-")[0]);
                if (banding1 < banding2) {
                    String temp = checklist_kk[j];
                    checklist_kk[j] = checklist_kk[j - 1];
                    checklist_kk[j - 1] = temp;
                }
            }
        }
    }

    public int sercing(int key) {
        int awal = 0;
        int akhir = checklist_kk.length - 1;
        while (awal < akhir) {
            int tengah = (awal + akhir) / 2;
            int banding = Integer.parseInt(checklist_kk[tengah].split("-")[0]);
            if (banding == key) {
                return tengah;
            } else {
                if (banding > key) {
                    akhir = tengah - 1;
                } else {
                    awal = tengah + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Genetika a = new Genetika();
    }
}
