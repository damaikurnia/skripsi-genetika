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
import kontrol.MataKuliahKontrol;
import kontrol.RuangKontrol;

/**
 *
 * @author Adhi
 */
public class Kromosom {

    Gen[] data;// 1 Kromosom terdiri dari n-GEN (140)
    List<KelasKuliah> dataa = null;
    int ruang = 0;
    List<Ruang> rng = null;

    public Kromosom() {
        try {
            dataa = KelasMatkulKontrol.getKoneksi().tampilKelasMataKuliah();
            ruang = RuangKontrol.getKoneksi().jumlahRuang();//jumlah ruang teori
            rng = RuangKontrol.getKoneksi().tampilRuangTeori();//list nama ruang teori
        } catch (SQLException ex) {
            Logger.getLogger(Kromosom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Kromosom(int a) {
    }

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

//    public Gen[] prosesRandom() { //yg di random matakuliahnya
//        Random r = new Random();
//        int hari = 5;
//        int waktu = 12;
//        
//        int N = (hari * ruang * waktu) / 3;
//        int matkul = dataa.size();
//        data = new Gen[N];
//
//        boolean cek[] = new boolean[matkul + 1];
//        for (int i = 0; i < cek.length; i++) {
//            cek[i] = false;
//        }
//
//        int index = 0; //untuk index gen
//        while (N != 0) {
//            int tangkap = r.nextInt(matkul + 1);
//            if (tangkap - 1 == -1) {
//                data[index] = new Gen();
//                data[index].setTimeSlot(new KelasKuliah(0, new MataKuliah("-"), "-", new Dosen("-")));
//                data[index].setHari(tentukanHari(index));//generate
//                data[index].setJam(tentukanJam(index));//generate
//                data[index].setRuang(tentukanRuang(index));//generate
//                data[index].setNilaiFitness(0);
//                index++;
//                N--;
//
//            } else {
//                if (cek[tangkap - 1] == false) {
//                    data[index] = new Gen();
//                    int temp = tangkap;
//                    temp = temp - 1;
//                    data[index].setTimeSlot(dataa.get(temp));
//                    data[index].setHari(tentukanHari(index));//generate
//                    data[index].setJam(tentukanJam(index));//generate
//                    data[index].setRuang(tentukanRuang(index));//generate
//                    data[index].setNilaiFitness(0);
//                    index++;
//                    cek[temp] = true;
//                    N--;
//                }
//            }
//        }
//        return data;
//    }
    public Gen[] prosesRandom() { //yang di random slot gennya
        Random r = new Random();
        int hari = 5;
        int waktu = 12;

        int matkul = dataa.size();
        data = new Gen[(hari * ruang * waktu) / 3]; //220

        boolean cek[] = new boolean[matkul]; //126
        int N = matkul;

        for (int i = 0; i < data.length; i++) {
            data[i] = new Gen();
            data[i].setAllele(new KelasKuliah(0, new MataKuliah("-"), "-", new Dosen("-")));
            data[i].setHari(tentukanHari(i));//generate
            data[i].setJam(tentukanJam(i));//generate
//            data[i].setRuang(tentukanRuang(i));//generate
            data[i].setNilaiFitness(0);
        }
        data = tentukanRuang(data);
        for (int i = 0; i < matkul; i++) {
            cek[i] = false;
        }

        int index = 0; //untuk index matakuliah
        while (N != 0) {
            int tangkap = r.nextInt(data.length);
            if (data[tangkap].getAllele().getIdKelas() == 0) {
                data[tangkap].setAllele(dataa.get(index));
                String idMK = data[tangkap].getAllele().getIdMK().getIdMK();
                data[tangkap].getAllele().getIdMK().setSemester(isiSemester(idMK));
                index++;
                N--;
            }
        }
        return data;
    }

    public int isiSemester(String idMK) {
        int semester = 0;

        try {
            semester = MataKuliahKontrol.getKoneksi().cariSemester(idMK);
        } catch (SQLException ex) {
            Logger.getLogger(Kromosom.class.getName()).log(Level.SEVERE, null, ex);
        }

        return semester;
    }

    public String tentukanHari(int index) {
        int hari = 5;
        int waktu = 12;
        int N = (hari * ruang * waktu) / 3;

        int bagi = N / 5;

        if (index < bagi * 1) {
            return "Senin";
        } else if (index < bagi * 2) {
            return "Selasa";
        } else if (index < bagi * 3) {
            return "Rabu";
        } else if (index < bagi * 4) {
            return "Kamis";
        } else {
            return "Jumat";
        }
    }

    public int tentukanJam(int index) {
        return (index % 4) + 1;
    }

    public Gen[] tentukanRuang(Gen[] data) {
        int hari = 5;
        int waktu = 12;
        int N = (hari * ruang * waktu) / 3;//220

        int bagi = N / 5;//44 (5 adl 5 hari kuliah)
        int bagiruang = 0;

        bagiruang = bagi / ruang;//4

        int count_bagiruang = 0;
        int count_ruang = 0;//ini

        for (int i = 0; i < data.length;) {
            if (count_bagiruang < bagiruang) {
                data[i].setRuang(rng.get(count_ruang));
                count_bagiruang++;
                if (count_ruang == rng.size()-1 &&count_bagiruang==bagiruang) {
                    count_ruang = 0;
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
        return data;
    }

    public Kromosom solusiAwal() {
        Kromosom krom = new Kromosom();
        krom.setData(prosesRandom());
        return krom;
    }
}
