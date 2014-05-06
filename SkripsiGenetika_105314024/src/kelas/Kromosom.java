/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelas;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontrol.KelasMatkulKontrol;

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

    public Gen[] prosesRandom() {
        List<KelasKuliah> dataa = null;
        try {
            //data
            dataa = KelasMatkulKontrol.getKoneksi().tampilKelasMataKuliah();
        } catch (SQLException ex) {
            Logger.getLogger(Kromosom.class.getName()).log(Level.SEVERE, null, ex);
        }

        Random r = new Random();
        int random = 30;//gen ke[x]
        int matkul = dataa.size();
        data = new Gen[random];
        boolean cek[] = new boolean[matkul + 1];
        for (int i = 0; i < cek.length; i++) {
            cek[i] = false;
        }

        int index = 0; //untuk index gen
        while (random != 0) {
            int tangkap = r.nextInt(matkul+1);
            if (tangkap - 1 == -1) {
                data[index] = new Gen();
                data[index].setTimeSlot(new KelasKuliah(0, new MataKuliah("-"), "-", new Dosen("-")));
                data[index].setHari("-");//generate
                data[index].setJam(0);//generate
                data[index].setRuang(new Ruang("-","-"));//generate
                data[index].setNilaiFitness(0);
                index++;
                random--;
                
            } else {
                if (cek[tangkap-1] == false) {
                    data[index] = new Gen();
                    int temp = tangkap;temp = temp -1;
                    data[index].setTimeSlot(dataa.get(temp));
                    data[index].setHari(tentukanHari(index));//generate
                    data[index].setJam(tentukanJam(index));//generate
                    data[index].setRuang(tentukanRuang(index));//generate
                    data[index].setNilaiFitness(0);
                    index++;
                    cek[temp] = true;
                    random--;
                }
            }
        }
        return data;
    }

    public String tentukanHari(int index) {
        return "Senin";
    }

    public int tentukanJam(int index) {
        return 1;
    }

    public Ruang tentukanRuang(int index) {
        return new Ruang("K205", "K206");
    }
}
