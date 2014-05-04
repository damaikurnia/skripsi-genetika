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
public class Kromosom {
    private Gen[] data;// 1 Kromosom terdiri dari n-GEN (140)    

    /**
     * @return the data
     */
    public Gen[] getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Gen[] data) {
        this.data = data;
    }
    
    public void prosesRandom(){
        Random r = new Random();
        int random = 50;//gen ke[x]
        int matkul = 31;
        boolean cek[] = new boolean[matkul];
        for (int i = 0; i < cek.length; i++) {
            cek[i] = false; 
        }
        
        
        while (random != 0) {
            int tangkap = r.nextInt(matkul);
            if (cek[tangkap] == false) {
                if (tangkap == 0) {
                    System.out.print(tangkap+" ");
                    random--;
                    cek[tangkap] = false;
                } else {
                    System.out.print(tangkap+" ");
                    random--;
                    cek[tangkap] = true;
                }
            }
        }
    }
}
