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
import kontrol.DosenKontrol;
import kontrol.MataKuliahKontrol;
import kontrol.RuangKontrol;

/**
 *
 * @author Adhi
 */
public class Pelanggaran {

    static int jumlah_ruang;

    public Pelanggaran() {
    }

    public static Kromosom cekRuang(Kromosom x) {
        return x;
    } //aturan 1 - return kromosom

    public static Kromosom cekDosen(Kromosom x) {
        int[] posisi_jam = new int[jumlah_ruang];//menetukan jam ke x di setiap ruang
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};
        int jam = 1;
        int count = 0;

        for (int i = 0; i < posisi_jam.length; i++) { //menentukan index jam
            if (i == 0) {
                posisi_jam[i] = 0;
            } else {
                posisi_jam[i] = posisi_jam[i - 1] + 4;
            }
        }

        while (true) { //mencari rentang hari
            if (x.getData()[count].getHari().equals(hari[0])) {
                count++;
            } else {
                break;
            }
        }

        for (int i = 1; i < hari.length; i++) {//loop hari
            for (int b = 0; b < 4; b++) {//loop timeslot
                for (int j = 0; j < jumlah_ruang; j++) {//loop perbandingan gen dalam timeslot
                    for (int k = j + 1; k < jumlah_ruang; k++) {
                        String banding1 = x.getData()[posisi_jam[j]].getAllele().getIdDosen().getIdDosen();
                        String banding2 = x.getData()[posisi_jam[k]].getAllele().getIdDosen().getIdDosen();
                        if (banding1.equals("-")) {
                        } else if (banding1.equals(banding2)) {
                            int fitnes_awal = x.getData()[posisi_jam[k]].getNilaiFitness();
                            x.getData()[posisi_jam[k]].setNilaiFitness(fitnes_awal + 1); //penambahan pelanggaran dengan nilai pelanggaran
//                            System.out.println("Penlanggaran(1) " + posisi_jam[j] + " dengan " + posisi_jam[k]);
                        }

                    }

                }
                for (int l = 0; l < posisi_jam.length; l++) { //menentukan index jam (pergeseran 1 timeslot)
                    posisi_jam[l] = posisi_jam[l] + 1;
                }
            }

            for (int l = 0; l < posisi_jam.length; l++) { //menentukan index jam hari berikutnya
                if (l == 0) {
                    posisi_jam[l] = count;
                } else {
                    posisi_jam[l] = posisi_jam[l - 1] + 4;
                }
            }
            count = count + count;
        }
        return x;
    }

    public static Kromosom cekMatakuliah(Kromosom x) { //matakuliah untuk 1 semester tertentu dan kelas tertentu tidak boleh di jam yg sama
        int[] posisi_jam = new int[jumlah_ruang];//menetukan jam ke x di setiap ruang
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};
        int jam = 1;
        int count = 0;

        for (int i = 0; i < posisi_jam.length; i++) { //menentukan index jam
            if (i == 0) {
                posisi_jam[i] = 0;
            } else {
                posisi_jam[i] = posisi_jam[i - 1] + 4;
            }
        }

        while (true) { //mencari rentang hari
            if (x.getData()[count].getHari().equals(hari[0])) {
                count++;
            } else {
                break;
            }
        }

        for (int i = 1; i < hari.length; i++) {//loop hari
            for (int b = 0; b < 4; b++) {//loop timeslot
                for (int j = 0; j < jumlah_ruang; j++) {//loop perbandingan gen dalam timeslot
                    for (int k = j + 1; k < jumlah_ruang; k++) {

                        String banding1 = x.getData()[posisi_jam[j]].getAllele().getIdMK().getIdMK(); //matakuliah
                        String banding2 = x.getData()[posisi_jam[k]].getAllele().getIdMK().getIdMK();
                        int banding3 = x.getData()[posisi_jam[j]].getAllele().getIdMK().getSemester(); //semester
                        int banding4 = x.getData()[posisi_jam[k]].getAllele().getIdMK().getSemester();
                        String banding7 = x.getData()[posisi_jam[j]].getAllele().getKelas(); //kelas
                        String banding8 = x.getData()[posisi_jam[k]].getAllele().getKelas();

                        if (banding1.equals("-")) {
                        } else if (banding3 == banding4) { //semester sama?
                            if (banding7.equals(banding8)) { // kelas sama?
                                int fitnes_awal = x.getData()[posisi_jam[k]].getNilaiFitness();
                                x.getData()[posisi_jam[k]].setNilaiFitness(fitnes_awal + 1); //penambahan pelanggaran dengan nilai pelanggaran
//                                System.out.println("Penlanggaran(2) " + posisi_jam[j] + " dengan " + posisi_jam[k]);
                            }
                        }

                    }

                }
                for (int l = 0; l < posisi_jam.length; l++) { //menentukan index jam (pergeseran 1 timeslot)
                    posisi_jam[l] = posisi_jam[l] + 1;
                }
            }

            for (int l = 0; l < posisi_jam.length; l++) { //menentukan index jam hari berikutnya
                if (l == 0) {
                    posisi_jam[l] = count;
                } else {
                    posisi_jam[l] = posisi_jam[l - 1] + 4;
                }
            }
            count = count + count;
        }
        return x;
    } //aturan 3

    public static Kromosom cekJumlahMatakuliah(Kromosom x) {
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};
        int jam = 0;
        int count = 0;
        int temp_count = 0;
        List<String> kel = null;
        try {
            kel = MataKuliahKontrol.getKoneksi().cariKelompokKelas();
        } catch (SQLException ex) {
            Logger.getLogger(Pelanggaran.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (true) { //mencari rentang hari
            if (x.getData()[count].getHari().equals(hari[0])) {
                count++;
            } else {
                break;
            }
        }
        temp_count = count;
        for (int i = 0; i < hari.length; i++) {
            for (jam = jam; jam < temp_count; jam++) { //loop index perhari
                String banding2 = Integer.toString(x.getData()[jam].getAllele().getIdMK().getSemester());//semester
                String banding3 = x.getData()[jam].getAllele().getKelas();//kelas

                for (int j = 0; j < kel.size(); j++) { //loop kelas dan semester
                    String[] banding1 = kel.get(j).split("-");
                    if (banding1[0].equals(banding2) && banding1[1].equals(banding3)) { // membandingkan kelas dengan semester
                        int temp = Integer.parseInt(banding1[2]);
                        temp = temp + 1;
                        kel.set(j, banding1[0] + "-" + banding1[1] + "-" + temp);

                        if (temp > 3) { //temp : jumlah dalam sehari melebihi 3 makul tiap kelas tiap semester
                            int fitnes_awal = x.getData()[jam].getNilaiFitness();
                            x.getData()[jam].setNilaiFitness(fitnes_awal + 1); //penambahan pelanggaran dengan nilai pelanggaran
//                            System.out.println("Penlanggaran(3) " + jam);
                        }
                    }
                }
            }
            for (int j = 0; j < kel.size(); j++) { //reset kel spt semula
                String[] temp = kel.get(j).split("-");
                kel.set(j, temp[0] + "-" + temp[1] + "-0");
            }
            temp_count = temp_count + count;//pergeserah ke hari selanjutnya
        }
        return x;
    }

    public static Kromosom cekDosenMengajar(Kromosom x) {
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};
        int jam = 0;
        int count = 0;
        int temp_count = 0;
        List<String> kel = null;
        try {
            kel = DosenKontrol.getKoneksi().cariKelompokDosen();
        } catch (SQLException ex) {
            Logger.getLogger(Pelanggaran.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (true) { //mencari rentang hari
            if (x.getData()[count].getHari().equals(hari[0])) {
                count++;
            } else {
                break;
            }
        }
        temp_count = count;
        for (int i = 0; i < hari.length; i++) {
            for (jam = jam; jam < temp_count; jam++) { //loop index perhari
                String banding2 = x.getData()[jam].getAllele().getIdDosen().idDosen;//iddosen

                for (int j = 0; j < kel.size(); j++) { //loop kelas dan semester
                    String[] banding1 = kel.get(j).split("-");
                    if (banding1[0].equals(banding2.trim())) { // membandingkan kelas dengan semester
                        int temp = Integer.parseInt(banding1[1]);
                        temp = temp + 1;
                        kel.set(j, banding1[0] + "-" + temp);

                        if (temp > 3) { //temp : jumlah dalam sehari melebihi 3 makul tiap kelas tiap semester
                            int fitnes_awal = x.getData()[jam].getNilaiFitness();
                            x.getData()[jam].setNilaiFitness(fitnes_awal + 1); //penambahan pelanggaran dengan nilai pelanggaran
//                            System.out.println("Penlanggaran(4) " + jam);
                        }
                    }
                }
            }
            for (int j = 0; j < kel.size(); j++) { //reset kel spt semula
                String[] temp = kel.get(j).split("-");
                kel.set(j, temp[0] + "-0");
            }
            temp_count = temp_count + count;//pergeseran ke hari selanjutnya
        }
        return x;
    } //aturan 5

    public static Kromosom eksekusiAturan(Kromosom x) {
        try {
            jumlah_ruang = RuangKontrol.getKoneksi().jumlahRuang();
        } catch (SQLException ex) {
            Logger.getLogger(Pelanggaran.class.getName()).log(Level.SEVERE, null, ex);
        }
        Kromosom parent;
        parent = Pelanggaran.cekRuang(x);
        parent = Pelanggaran.cekDosen(x);
        parent = Pelanggaran.cekMatakuliah(x);
        parent = Pelanggaran.cekJumlahMatakuliah(x);
        parent = Pelanggaran.cekDosenMengajar(x);
        return parent;
    }
}
