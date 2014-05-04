/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelas;

import java.util.Random;

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
        int random = 140;//gen ke[x]
        int matkul = 101;
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
        randomTertentu();
        randomTertentu();
    }
}
