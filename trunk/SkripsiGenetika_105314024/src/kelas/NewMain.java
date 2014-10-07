/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelas;

/**
 *
 * @author Mega
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int hari = 5;
        int waktu = 12;
        int ruang = 11;
        int N = 220;//220

        int bagi = N / 5;//44 (5 adl 5 hari kuliah)
        int bagiruang = 0;

        bagiruang = bagi / ruang;//4

        int count_bagiruang = 0;
        int count_ruang = 1;

        for (int i = 0; i < 220;) {
            if (count_bagiruang < bagiruang) {
                System.out.println(count_ruang);
                count_bagiruang++;
                if (count_ruang == 11 &&count_bagiruang==bagiruang) {
                    count_ruang = 1;
                    count_bagiruang = 0;
                } else {
                    count_ruang = count_ruang;
                }
                i++;
            } else {
                count_ruang = count_ruang + 1;
                count_bagiruang = 0;
            }
        }

    }

}
