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
            data[i].setRuang(tentukanRuang(i));//generate
            data[i].setNilaiFitness(0);
        }
        for (int i = 0; i < matkul; i++) {
            cek[i] = false;
        }

        int index = 0; //untuk index matakuliah
        while (N != 0) {
            int tangkap = r.nextInt(data.length);
            if (data[tangkap].getAllele().getIdKelas()==0) {
                data[tangkap].setAllele(dataa.get(index));
                String idMK = data[tangkap].getAllele().getIdMK().getIdMK();
                data[tangkap].getAllele().getIdMK().setSemester(isiSemester(idMK));
                index++;
                N--;
            }
        }
        return data;
    }
    
    public int isiSemester(String idMK){
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

    public Ruang tentukanRuang(int index) {
        int hari = 5;
        int waktu = 12;
        int N = (hari * ruang * waktu) / 3;//220

        int bagi = N / 5;//44 (5 adl 5 hari kuliah)
        int bagiruang = 0;

        bagiruang = bagi / ruang;//4

        if (index < bagi * 1) {
            if (index < bagiruang * 1) {
                return rng.get(0);
            } else if (index < bagiruang * 2) {
                return rng.get(1);
            } else if (index < bagiruang * 3) {
                return rng.get(2);
            } else if (index < bagiruang * 4) {
                return rng.get(3);
            } else if (index < bagiruang * 5) {
                return rng.get(4);
            } else if (index < bagiruang * 6) {
                return rng.get(5);
            } else if (index < bagiruang * 7) {
                return rng.get(6);
            } else if (index < bagiruang * 8) {
                return rng.get(7);
            } else if (index < bagiruang * 9) {
                return rng.get(8);
            } else if (index < bagiruang * 10) {
                return rng.get(9);
            } else {
                return rng.get(10);
            }
        } else if (index < bagi * 2) {
            if (index < bagiruang * 12) {
                return rng.get(0);
            } else if (index < bagiruang * 13) {
                return rng.get(1);
            } else if (index < bagiruang * 14) {
                return rng.get(2);
            } else if (index < bagiruang * 15) {
                return rng.get(3);
            } else if (index < bagiruang * 16) {
                return rng.get(4);
            } else if (index < bagiruang * 17) {
                return rng.get(5);
            } else if (index < bagiruang * 18) {
                return rng.get(6);
            } else if (index < bagiruang * 19) {
                return rng.get(7);
            } else if (index < bagiruang * 20) {
                return rng.get(8);
            } else if (index < bagiruang * 21) {
                return rng.get(9);
            } else {
                return rng.get(10);
            }
        } else if (index < bagi * 3) {
            if (index < bagiruang * 23) {
                return rng.get(0);
            } else if (index < bagiruang * 24) {
                return rng.get(1);
            } else if (index < bagiruang * 25) {
                return rng.get(2);
            } else if (index < bagiruang * 26) {
                return rng.get(3);
            } else if (index < bagiruang * 27) {
                return rng.get(4);
            } else if (index < bagiruang * 28) {
                return rng.get(5);
            } else if (index < bagiruang * 29) {
                return rng.get(6);
            } else if (index < bagiruang * 30) {
                return rng.get(7);
            } else if (index < bagiruang * 31) {
                return rng.get(8);
            } else if (index < bagiruang * 32) {
                return rng.get(9);
            } else {
                return rng.get(10);
            }
        } else if (index < bagi * 4) {
            if (index < bagiruang * 34) {
                return rng.get(0);
            } else if (index < bagiruang * 35) {
                return rng.get(1);
            } else if (index < bagiruang * 36) {
                return rng.get(2);
            } else if (index < bagiruang * 37) {
                return rng.get(3);
            } else if (index < bagiruang * 38) {
                return rng.get(4);
            } else if (index < bagiruang * 39) {
                return rng.get(5);
            } else if (index < bagiruang * 40) {
                return rng.get(6);
            } else if (index < bagiruang * 41) {
                return rng.get(7);
            } else if (index < bagiruang * 42) {
                return rng.get(8);
            } else if (index < bagiruang * 43) {
                return rng.get(9);
            } else {
                return rng.get(10);
            }
        } else {
            if (index < bagiruang * 45) {
                return rng.get(0);
            } else if (index < bagiruang * 46) {
                return rng.get(1);
            } else if (index < bagiruang * 47) {
                return rng.get(2);
            } else if (index < bagiruang * 48) {
                return rng.get(3);
            } else if (index < bagiruang * 49) {
                return rng.get(4);
            } else if (index < bagiruang * 50) {
                return rng.get(5);
            } else if (index < bagiruang * 51) {
                return rng.get(6);
            } else if (index < bagiruang * 52) {
                return rng.get(7);
            } else if (index < bagiruang * 53) {
                return rng.get(8);
            } else if (index < bagiruang * 54) {
                return rng.get(9);
            } else {
                return rng.get(10);
            }
        }
    }

    public Kromosom solusiAwal() {
        Kromosom krom = new Kromosom();
        krom.setData(prosesRandom());
        return krom;
    }
}
