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
    static List<tabelPermintaan> dataPermintaan;

    public Genetika() {
//        ambilDatabase();
    }

    public Genetika(List<KelasKuliah> datakelaskuliah, List<MataKuliah> datamakul, List<tabelPermintaan> Permintaan) {
        ambilDatabase(datakelaskuliah, datamakul, Permintaan);
    }

    public static Kromosom[] crossover(Kromosom[] parent, List<KelasKuliah> datakelaskuliah, List<MataKuliah> datamakul, List<tabelPermintaan> Permintaan) {
        new Genetika(datakelaskuliah, datamakul, Permintaan);
        Kromosom[] krom = parent;
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

    public static Kromosom[] Mutasi(Kromosom[] parent, List<KelasKuliah> datakelaskuliah, List<MataKuliah> datamakul, List<tabelPermintaan> Permintaan) {
        new Genetika(datakelaskuliah, datamakul, Permintaan);
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

            //menggeser 1 gen tertentu secara acak
            int indexawal = 0, indextujuan = 0;

            while (true) {
                Random r = new Random();
                indexawal = r.nextInt(krom[i].data.length);
                indextujuan = r.nextInt(krom[i].data.length);

                if (krom[i].data[indexawal].isKunci() == true || krom[i].data[indextujuan].isKunci() == true) {
                    if (krom[i].data[indexawal].isKunci() == true && krom[i].data[indextujuan].isKunci() == true) {
                        tabelPermintaan isitPermintaan_awal = new Genetika().cariKelasKuliahPermintaan(krom[i].data[indexawal].getAllele().getIdKelas());
                        tabelPermintaan isitPermintaan_tujuan = new Genetika().cariKelasKuliahPermintaan(krom[i].data[indextujuan].getAllele().getIdKelas());
                        boolean kesimpulan_awal = new Genetika().penentuanLokasiGen(isitPermintaan_awal, krom[i].data[indextujuan]);
                        boolean kesimpulan_tujuan = new Genetika().penentuanLokasiGen(isitPermintaan_tujuan, krom[i].data[indexawal]);
                        if (kesimpulan_awal == true && kesimpulan_tujuan == true) {
                            KelasKuliah temp = krom[i].data[indexawal].getAllele();
                            krom[i].data[indexawal].setAllele(krom[i].data[indextujuan].getAllele());
                            krom[i].data[indextujuan].setAllele(temp);
                            krom[i].data[indexawal].setNilaiFitness(0);
                            krom[i].data[indextujuan].setNilaiFitness(0);
                            System.out.println("Geser Keduanya");
                            break;
                        }
                    } else if (krom[i].data[indexawal].isKunci() == true) { //jika index awal yang true
                        tabelPermintaan isitPermintaan = new Genetika().cariKelasKuliahPermintaan(krom[i].data[indexawal].getAllele().getIdKelas());
                        boolean kesimpulan = new Genetika().penentuanLokasiGen(isitPermintaan, krom[i].data[indextujuan]);
                        if (kesimpulan == true) {
                            KelasKuliah temp = krom[i].data[indexawal].getAllele();
                            krom[i].data[indexawal].setAllele(krom[i].data[indextujuan].getAllele());
                            krom[i].data[indextujuan].setAllele(temp);
                            krom[i].data[indexawal].setNilaiFitness(0);
                            krom[i].data[indextujuan].setNilaiFitness(0);
                            krom[i].data[indextujuan].setKunci(true);
                            krom[i].data[indexawal].setKunci(false);
                            System.out.println("Geser Index Awal");
                            break;
                        }
                    } else if (krom[i].data[indextujuan].isKunci() == true){ //jika index tujuan yang true
                        tabelPermintaan isitPermintaan = new Genetika().cariKelasKuliahPermintaan(krom[i].data[indextujuan].getAllele().getIdKelas());
                        boolean kesimpulan = new Genetika().penentuanLokasiGen(isitPermintaan, krom[i].data[indexawal]);
                        if (kesimpulan == true) {
                            KelasKuliah temp = krom[i].data[indextujuan].getAllele();
                            krom[i].data[indextujuan].setAllele(krom[i].data[indexawal].getAllele());
                            krom[i].data[indexawal].setAllele(temp);
                            krom[i].data[indexawal].setNilaiFitness(0);
                            krom[i].data[indextujuan].setNilaiFitness(0);
                            krom[i].data[indexawal].setKunci(true);
                            krom[i].data[indextujuan].setKunci(false);
                            System.out.println("Geser Index Tujuan");
                            break;
                        }
                    }
                } else {
                    if (krom[i].data[indextujuan].getAllele().getIdKelas() != 0 || krom[i].data[indexawal].getAllele().getIdKelas() != 0) {
                        KelasKuliah temp = krom[i].data[indexawal].getAllele();
                        krom[i].data[indexawal].setAllele(krom[i].data[indextujuan].getAllele());
                        krom[i].data[indextujuan].setAllele(temp);
                        krom[i].data[indexawal].setNilaiFitness(0);
                        krom[i].data[indextujuan].setNilaiFitness(0);
                        break;
                    }
                }
            }
            for (int p = 0; i < checklist_kk.length; i++) {
                checklist_kk[p] = checklist_kk[p].split("-") + "-0";
            }
        }

        return krom;
    }

    public void ambilDatabase(List<KelasKuliah> datakelaskuliah, List<MataKuliah> datamakul, List<tabelPermintaan> Permintaan) {
        kelasKuliah = datakelaskuliah;
        matkul = datamakul;
        dataPermintaan = Permintaan;
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

    public tabelPermintaan cariKelasKuliahPermintaan(int idKelas) {
        tabelPermintaan posisi = null;
        for (int i = 0; i < dataPermintaan.size(); i++) {
            if (dataPermintaan.get(i).getIdKelas().getIdKelas() == idKelas) {
                posisi = dataPermintaan.get(i);
                break;
            }
        }
        return posisi;
    }

    public int tentukanJamPermintaan(String jam) {
        if (jam.equals("07:00-09:59")) {
            return 1;
        } else if (jam.equals("10:00-12:59")) {
            return 2;
        } else if (jam.equals("13:00-15:59")) {
            return 3;
        } else if (jam.equals("16:00-18:59")) {
            return 4;
        } else {
            return 0;//0 berarti bisa jam berapa aja
        }
    }

    public boolean penentuanLokasiGen(tabelPermintaan kelasPermintaan, Gen targetGen) {
        String ruang_permintaan = kelasPermintaan.getIdRuang().idRuang;
        String hari_permintaan = kelasPermintaan.getHari();
        int jam_permintaan = tentukanJamPermintaan(kelasPermintaan.getJam());

        boolean kesimpulan = false;
        if (!ruang_permintaan.equals("-") && !hari_permintaan.equals("-") && jam_permintaan != 0) {//semua ditentukan
            if (targetGen.getRuang().getIdRuang().equals(ruang_permintaan)
                    && targetGen.getHari().equals(hari_permintaan)
                    && targetGen.getJam() == jam_permintaan) {
                kesimpulan = true;
            }
        } else if (ruang_permintaan.equals("-") && !hari_permintaan.equals("-") && jam_permintaan != 0) { //meminta hari dan jam tertentu
            if (targetGen.getHari().equals(hari_permintaan)
                    && targetGen.getJam() == jam_permintaan) {
                kesimpulan = true;
            }
        } else if (!ruang_permintaan.equals("-") && hari_permintaan.equals("-") && jam_permintaan != 0) { //meminta ruang dan jam tertentu
            if (targetGen.getRuang().getIdRuang().equals(ruang_permintaan)
                    && targetGen.getJam() == jam_permintaan) {
                kesimpulan = true;
            }
        } else if (!ruang_permintaan.equals("-") && !hari_permintaan.equals("-") && jam_permintaan == 0) { //meminta ruang dan hari tertentu
            if (targetGen.getRuang().getIdRuang().equals(ruang_permintaan)
                    && targetGen.getHari().equals(hari_permintaan)) {
                kesimpulan = true;
            }
        } else if (!ruang_permintaan.equals("-") && hari_permintaan.equals("-") && jam_permintaan == 0) {//hanya meminta ruang
            if (targetGen.getRuang().getIdRuang().equals(ruang_permintaan)) {
                kesimpulan = true;
            }
        } else if (ruang_permintaan.equals("-") && !hari_permintaan.equals("-") && jam_permintaan == 0) {//Hanya meminta hari
            if (targetGen.getHari().equals(hari_permintaan)) {
                kesimpulan = true;
            }
        } else if (ruang_permintaan.equals("-") && hari_permintaan.equals("-") && jam_permintaan != 0) {//Hanya meminta waktu
            if (targetGen.getJam() == jam_permintaan) {
                kesimpulan = true;
            }
        }
        return kesimpulan;
    }
}
