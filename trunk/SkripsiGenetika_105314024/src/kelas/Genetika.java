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
        //parent 1 A - B
        //parent 2 C - D
        //child 1 A - D
        //child 2 C - B

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
        for (int i = 2; i < krom.length; i++) { // 2-3 --> hanya kromosom anak yg di mutasi
//            String simsem_duplikat = "";
            String simsem_hilang = "";
            for (int j = 0; j < krom[i].data.length; j++) {
                if (krom[i].data[j].allele.getIdKelas() == 0) {
                } else {
                    int tangkap = sercing(krom[i].data[j].allele.getIdKelas());
                    if (checklist_kk[tangkap].split("-")[1].equals("0")) {
                        checklist_kk[tangkap] = checklist_kk[tangkap].split("-")[0] + "-1";//idkelas-<1/0>-index gen
                    } else {
//                        simsem_duplikat = simsem_duplikat + checklist_kk[tangkap].split("-")[0] + "-"; //menyimpan kelas makul yang duplikat
                        krom[i].data[j].setAllele(new KelasKuliah(0, new MataKuliah("-"), "-", new Dosen("-"))); //langsung menghapus matkul duplikat
                    }
                }
            }
//            for (int a = 0; a < simsem_duplikat.split("-").length; a++) {
//                System.out.print(simsem_duplikat.split("-")[a] + " ");
//            }
            //menyaring id yang belum ada di gen[]
            for (int j = 0; j < checklist_kk.length; j++) {
                if (checklist_kk[j].split("-")[1].equals("0")) {
                    simsem_hilang = simsem_hilang + checklist_kk[j].split("-")[0] + "-";
                }
            }
//            System.out.println("Yang HILANG");
//            for (int a = 0; a < simsem_hilang.split("-").length; a++) {
//                System.out.print(simsem_hilang.split("-")[a] + " ");
//            }

            //replace 0 dengan kelas makul yang tidak ada di dalam kromosom
            int point = krom[i].data.length / 2;
            for (int s = 0; s < simsem_hilang.split("-").length; s++) {
                int tangkap = 0;
                Random r = new Random();
                while (tangkap < point) {
                    tangkap = r.nextInt(krom[i].data.length);
                    if (krom[i].data[tangkap].allele.getIdKelas() != 0) {
                        tangkap = 0;
                    } else {
                        tangkap = tangkap;
                    }
                }
                if (simsem_hilang.equals("")) {
                } else {
                    String id = simsem_hilang.split("-")[s];
                    krom[i].data[tangkap].setAllele(gantiKelasKuliah(id));
                }
            }

            //menggeser 1 gen yang memiliki nilai fitness
            int kiri = 0, kanan = 0;
            for (int t = 0; t < krom[i].data.length; t++) {
                if (krom[i].data[t].getAllele().getIdKelas() == 0) {
                    kiri = kiri;
                    kanan = kanan;
                } else {
                    if (t < point) {
                        kiri++;
                    } else {
                        kanan++;
                    }
                }
            }
            while (true) {
                int posisiAsal = 0;
                int posisiTujuan = 0;
                Random r = new Random();
                if (kiri > kanan) {
                    posisiAsal = r.nextInt(point);
                    posisiTujuan = r.nextInt(krom[i].data.length);
                    if (krom[i].data[posisiAsal].getAllele().getIdKelas() != 0
                            && krom[i].data[posisiTujuan].getAllele().getIdKelas() == 0
                            && posisiTujuan >= point) {
                        krom[i].data[posisiTujuan].setAllele(krom[i].data[posisiAsal].getAllele());
                        krom[i].data[posisiAsal].setAllele(new KelasKuliah(0, new MataKuliah("-"), "-", new Dosen("-"))); //menghapus gen posisiasal
//                        System.out.println("Kiri "+kiri+" Kanan "+kanan);
//                        System.out.println("Pindah Mutasi "+posisiAsal+" ke "+posisiTujuan);
                        break;
                    } else {
                        posisiAsal = 0;
                        posisiTujuan = 0;
                    }
                } else {
                    posisiAsal = r.nextInt(krom[i].data.length);
                    posisiTujuan = r.nextInt(point);
                    if (krom[i].data[posisiAsal].getAllele().getIdKelas() != 0
                            && krom[i].data[posisiTujuan].getAllele().getIdKelas() == 0
                            && posisiAsal >= point) {
                        krom[i].data[posisiTujuan].setAllele(krom[i].data[posisiAsal].getAllele());
                        krom[i].data[posisiAsal].setAllele(new KelasKuliah(0, new MataKuliah("-"), "-", new Dosen("-"))); //menghapus gen posisiasal
//                        System.out.println("Kiri "+kiri+" Kanan "+kanan);
//                        System.out.println("Pindah Mutasi "+posisiAsal+" ke "+posisiTujuan);
                        break;
                    } else {
                        posisiAsal = 0;
                        posisiTujuan = 0;
                    }
                }
            }
            for (int p = 0; i < checklist_kk.length; i++) {
                checklist_kk[p] = checklist_kk[p].split("-") + "-0";
            }
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
