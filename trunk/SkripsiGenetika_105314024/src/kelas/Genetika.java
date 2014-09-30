/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelas;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontrol.KelasMatkulKontrol;
import kontrol.MataKuliahKontrol;

/**
 *
 * @author Adhi
 */
public class Genetika {

    static List<KelasKuliah> kelasKuliah;
    List<MataKuliah> matkul;
    static String[] checklist_kk; // <-- untuk cek kk sdh ada di dlm kromosom apa blm.

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
        new Genetika();
        Kromosom[] krom = parent;

        //replace id duplikat (setelah di cross)
//        for (int i = 2; i < krom.length; i++) { // 2-3 --> hanya kromosom anak yg di mutasi
        for (int i = 2; i < 3; i++) { // 2-3 --> hanya kromosom anak yg di mutasi
            String simsem = "";
            for (int j = 0; j < krom[i].data.length; j++) {
                if (krom[i].data[j].allele.getIdKelas() == 0) {
                } else {
                    int tangkap = sercing(krom[i].data[j].allele.getIdKelas());
                    if (checklist_kk[tangkap].split("-")[1].equals("0")) {
                        checklist_kk[tangkap] = checklist_kk[tangkap].split("-")[0] + "-1";
                    } else {
                        simsem = simsem + checklist_kk[tangkap].split("-")[0] + "-"; //menyimpan kelas makul yang duplikat
                        krom[i].data[j].setAllele(new KelasKuliah(0, new MataKuliah("-"), "-", new Dosen("-"))); //langsung menghapus matkul duplikat
                    }
                }
            }
            
            for (int a = 0; a < simsem.split("-").length; a++) {
                System.out.print(simsem.split("-")[a] + " ");
            }
            
            for (int j = 0; j < checklist_kk.length; j++) { //replace 0 dengan kelas makul yang tidak ada di dalam kromosom
                Random r = new Random();//sampe sini
                if(checklist_kk[j].split("-")[1].equals("0")){
                    int tangkap = r.nextInt(krom[i].data.length);
                    if(krom[i].data[tangkap].getAllele().getIdKelas()==0){
                        
                    }
                }
            }   
//            for (int j = 0; j < checklist_kk.length; j++) { //reset checklist_kk
//                checklist_kk[j] = checklist_kk[j].split("-")[0] + "-0";
//            }
        }

        return krom;
    }

    public void ambilDatabase() {
        try {
            kelasKuliah = KelasMatkulKontrol.getKoneksi().tampilKelasMataKuliah();
            matkul = MataKuliahKontrol.getKoneksi().tampilMataKuliah();
            checklist_kk = new String[kelasKuliah.size()];
            Kromosom a = new Kromosom(0);
            for (int i = 0; i < kelasKuliah.size(); i++) {
                String idMK = kelasKuliah.get(i).getIdMK().getIdMK();
                for (int j = 0; j < matkul.size(); j++) {
                    if (idMK.equals(matkul.get(j).getIdMK())) {
                        kelasKuliah.get(i).getIdMK().setSemester(matkul.get(j).getSemester());
                    }
                }

            }
            //addOn checklist_kk
            for (int i = 0; i < checklist_kk.length; i++) {
                checklist_kk[i] = Integer.toString(kelasKuliah.get(i).getIdKelas()) + "-0";
            }
//            sorting();
        } catch (SQLException ex) {
            Logger.getLogger(Genetika.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static int sercing(int key) { //<-- Sequential Search
        int counter = 0;
        for (int a = 0; a < (checklist_kk.length); a++) {
            if (Integer.parseInt(checklist_kk[a].split("-")[0]) == key) {
                counter = a;
                break;
            } else {
                counter = -1;
            }
        }
        return counter;
    }

    public static KelasKuliah gantiKelasKuliah(String kelas) {
        for (int i = 0; i < kelasKuliah.size(); i++) {
            if (kelasKuliah.get(i).getIdKelas() == Integer.parseInt(kelas)) {
                return kelasKuliah.get(i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Genetika a = new Genetika();
//        for (int i = 1; i < checklist_kk.length; i++) {
//            int tangkap = a.sercing(i);
//            System.out.println("i : " + i + " = " + tangkap + " isi checklist " + checklist_kk[tangkap]);
//        }
    }
}
