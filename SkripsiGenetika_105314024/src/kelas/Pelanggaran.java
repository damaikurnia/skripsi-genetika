/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelas;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        return null;
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
                        String banding1 = x.getData()[posisi_jam[j]].getTimeSlot().getIdDosen().getIdDosen();
                        String banding2 = x.getData()[posisi_jam[k]].getTimeSlot().getIdDosen().getIdDosen();
                        if (banding1.equals("-")) {
                        } else if (banding1.equals(banding2)) {
                            int fitnes_awal = x.getData()[posisi_jam[k]].getNilaiFitness();
                            x.getData()[posisi_jam[k]].setNilaiFitness(fitnes_awal + 1); //penambahan pelanggaran dengan nilai pelanggaran
                            System.out.println("Penlanggaran " + posisi_jam[j] + " dengan " + posisi_jam[k]);
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
            System.out.println("");
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

                        String banding1 = x.getData()[posisi_jam[j]].getTimeSlot().getIdMK().getIdMK(); //matakuliah
                        String banding2 = x.getData()[posisi_jam[k]].getTimeSlot().getIdMK().getIdMK();
                        int banding3 = x.getData()[posisi_jam[j]].getTimeSlot().getIdMK().getSemester(); //semester
                        int banding4 = x.getData()[posisi_jam[k]].getTimeSlot().getIdMK().getSemester();
                        String banding7 = x.getData()[posisi_jam[j]].getTimeSlot().getKelas(); //kelas
                        String banding8 = x.getData()[posisi_jam[k]].getTimeSlot().getKelas();

                        if (banding1.equals("-")) {
                        } else if (banding3 == banding4) { //semester sama?
                            if (banding7.equals(banding8)) { // kelas sama?
                                int fitnes_awal = x.getData()[posisi_jam[k]].getNilaiFitness();
                                x.getData()[posisi_jam[k]].setNilaiFitness(fitnes_awal + 1); //penambahan pelanggaran dengan nilai pelanggaran
                                System.out.println("Penlanggaran " + posisi_jam[j] + " dengan " + posisi_jam[k]);
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
        int[] posisi_jam = new int[jumlah_ruang];//menetukan jam ke x di setiap ruang
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};
        int jam = 1;
        int count = 0;

        while (true) { //mencari rentang hari
            if (x.getData()[count].getHari().equals(hari[0])) {
                count++;
            } else {
                break;
            }
        }

        for (int i = 0; i < hari.length; i++) {
            for (jam = jam; jam < count; jam++) {
                
            }
            count = count+count;
        }

        return x;
    } //aturan 4

    public static Kromosom cekDosenMengajar(Kromosom x) {
        return x;
    } //aturan 5

    public static Kromosom eksekusiAturan(Kromosom x) {
        try {
            jumlah_ruang = RuangKontrol.getKoneksi().jumlahRuang();
        } catch (SQLException ex) {
            Logger.getLogger(Pelanggaran.class.getName()).log(Level.SEVERE, null, ex);
        }
        Kromosom parent;
//        parent = Pelanggaran.cekRuang(x);
//        parent = Pelanggaran.cekDosen(x);
        parent = Pelanggaran.cekMatakuliah(x);
//        parent = Pelanggaran.cekJumlahMatakuliah(x);
//        parent = Pelanggaran.cekDosenMengajar(x);
        return parent;
    }
}
