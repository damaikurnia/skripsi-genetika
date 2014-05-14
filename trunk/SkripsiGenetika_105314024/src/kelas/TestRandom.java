/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelas;

import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontrol.KelasMatkulKontrol;

/**
 *
 * @author Adhi
 */
public class TestRandom {

    private static void hitungRandom() {
        Random r = new Random(6);
        int random;
        int angka0 = 0;
        int angka1 = 0;
        int angka2 = 0;
        int angka3 = 0;
        int angka4 = 0;
        int angka5 = 0;

        for (int i = 0; i <= 1000000; i++) {
            random = r.nextInt(6);

            switch (random) {
                case 0:
                    angka0++;
                    break;
                case 1:
                    angka1++;
                    break;
                case 2:
                    angka2++;
                    break;
                case 3:
                    angka3++;
                    break;
                case 4:
                    angka4++;
                    break;
                case 5:
                    angka5++;
                    break;
            }
        }
        System.out.println("Angka 0 muncul " + angka0 + " kali");
        System.out.println("Angka 1 muncul " + angka1 + " kali");
        System.out.println("Angka 2 muncul " + angka2 + " kali");
        System.out.println("Angka 3 muncul " + angka3 + " kali");
        System.out.println("Angka 4 muncul " + angka4 + " kali");
        System.out.println("Angka 5 muncul " + angka5 + " kali");
    }

    public static void randomTertentu() {
        Random r = new Random();
        int random = 30;//gen ke[x]
        int matkul = 16;
        int countt = 0;
        boolean cek[] = new boolean[matkul];
        for (int i = 0; i < cek.length; i++) {
            cek[i] = false;
        }

        while (random != 0) {
            int tangkap = r.nextInt(matkul);
            if (cek[tangkap] == false) {
                if (tangkap == 0) {
                    System.out.print(tangkap + " ");
                    random--;
                    cek[tangkap] = false;
                    countt++;
                } else {
                    System.out.print(tangkap + " ");
                    random--;
                    cek[tangkap] = true;
                    countt++;
                }
            }
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        // TODO code application logic here
//        hitungRandom();
//        randomTertentu();
//        randomTertentu();
        
        Kromosom a = new Kromosom();
//        try {
//            System.out.println(KelasMatkulKontrol.getKoneksi().tampilKelasMataKuliah().size());
//        } catch (SQLException ex) {
//            Logger.getLogger(TestRandom.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        Gen[] data = a.prosesRandom();
        for (int i = 0; i < data.length; i++) {
            System.out.println("Gen["+i+"]");
            System.out.println("idKelas     : "+data[i].getTimeSlot().getIdKelas());
            System.out.println("kodeMatkul  : "+data[i].getTimeSlot().getIdMK().getIdMK());
            System.out.println("kelas       : "+data[i].getTimeSlot().getKelas());
            System.out.println("hari        : "+data[i].getHari());
            System.out.println("ruang       : "+data[i].getRuang().getIdRuang());
            System.out.println("jam ke      : "+data[i].getJam());
            System.out.println("");
        }
    }
}
