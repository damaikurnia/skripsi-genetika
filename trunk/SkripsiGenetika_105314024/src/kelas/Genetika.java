/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelas;

import java.util.List;
import java.util.Random;

/**
 *
 * @author Adhi
 */
public class Genetika {

    static List<KelasKuliah> kelasKuliah;
    List<MataKuliah> matkul;
    static String[] checklist_kk; // <-- untuk cek kk sdh ada di dlm kromosom apa blm.

    public Genetika() {
//        ambilDatabase();
    }

    public Genetika(List<KelasKuliah> datakelaskuliah, List<MataKuliah> datamakul) {
        ambilDatabase(datakelaskuliah, datamakul);
    }

    public static Kromosom[] crossover(Kromosom[] parent, List<KelasKuliah> datakelaskuliah, List<MataKuliah> datamakul) {
        new Genetika(datakelaskuliah, datamakul);
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

    public static Kromosom[] Mutasi(Kromosom[] parent, List<KelasKuliah> datakelaskuliah, List<MataKuliah> datamakul) {
        new Genetika(datakelaskuliah, datamakul);
        Kromosom[] krom = parent;

        //replace id duplikat (setelah di cross)
        for (int i = 2; i < krom.length; i++) { // 2-3 --> hanya kromosom anak yg di mutasi
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

            //menyaring id yang belum ada di gen[]
            for (int j = 0; j < checklist_kk.length; j++) {
                if (checklist_kk[j].split("-")[1].equals("0")) {
                    simsem_hilang = simsem_hilang + checklist_kk[j].split("-")[0] + "-";
                }
            }

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
            int indexawal = 0, indextujuan = 0;

            while (true) {
                Random r = new Random();
                indexawal = r.nextInt(krom[i].data.length);
                indextujuan = r.nextInt(krom[i].data.length);
                if (krom[i].data[indextujuan].getAllele().getIdKelas() == 0 && krom[i].data[indexawal].getAllele().getIdKelas() != 0) {
                    krom[i].data[indextujuan].setAllele(krom[i].data[indexawal].getAllele());
                    krom[i].data[indexawal].setAllele(new KelasKuliah(0, new MataKuliah("-"), "-", new Dosen("-"))); //menghapus gen posisiasal
                    break;
                } 

            }
            
//            krom[i] = Pelanggaran.eksekusiAturan(krom[i], dataruang, datadosen);
//            int maxFitness = 0, index = 0;
//
//            for (int t = 0; t < krom[i].data.length; t++) {
//                if (krom[i].data[t].getNilaiFitness() > maxFitness) {
//                    maxFitness = krom[i].data[t].getNilaiFitness();
//                    index = t;
//                } else {
//                    maxFitness = maxFitness;
//                    index = index;
//                }
//            }
//            while (true) {
//                int indexTujuan = 0;
//                Random r = new Random();
//                indexTujuan = r.nextInt(krom[i].data.length);
//                if (krom[i].data[indexTujuan].getAllele().getIdKelas() == 0) {
//                    krom[i].data[indexTujuan].setAllele(krom[i].data[index].getAllele());
//                    krom[i].data[index].setAllele(new KelasKuliah(0, new MataKuliah("-"), "-", new Dosen("-"))); //menghapus gen posisiasal
//                    krom[i].data[index].setNilaiFitness(0);
////                        System.out.println("Kiri "+kiri+" Kanan "+kanan);
////                        System.out.println("Pindah Mutasi "+posisiAsal+" ke "+posisiTujuan);
//                    break;
//                } 
//
//            }
            for (int p = 0; i < checklist_kk.length; i++) {
                checklist_kk[p] = checklist_kk[p].split("-") + "-0";
            }
        }

        return krom;
    }

//    public void ambilDatabase() {
//        try {
//            kelasKuliah = KelasMatkulKontrol.getKoneksi().tampilKelasMataKuliah();
//            matkul = MataKuliahKontrol.getKoneksi().tampilMataKuliah();
//            checklist_kk = new String[kelasKuliah.size()];
//            Kromosom a = new Kromosom(0);
//            for (int i = 0; i < kelasKuliah.size(); i++) {
//                String idMK = kelasKuliah.get(i).getIdMK().getIdMK();
//                for (int j = 0; j < matkul.size(); j++) {
//                    if (idMK.equals(matkul.get(j).getIdMK())) {
//                        kelasKuliah.get(i).getIdMK().setSemester(matkul.get(j).getSemester());
//                    }
//                }
//
//            }
//            //addOn checklist_kk
//            for (int i = 0; i < checklist_kk.length; i++) {
//                checklist_kk[i] = Integer.toString(kelasKuliah.get(i).getIdKelas()) + "-0";
//            }
////            sorting();
//        } catch (SQLException ex) {
//            Logger.getLogger(Genetika.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public void ambilDatabase(List<KelasKuliah> datakelaskuliah, List<MataKuliah> datamakul) {
        kelasKuliah = datakelaskuliah;
        matkul = datamakul;
        checklist_kk = new String[kelasKuliah.size()];
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

}
