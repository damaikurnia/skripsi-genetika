/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelas;

import java.util.List;
import java.util.Random;
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
    List<MataKuliah> makul = null; //buat method isisemester
    List<tabelPermintaan> dataPermintaan;

    public Kromosom() {
//        try {
//            dataa = KelasMatkulKontrol.getKoneksi().tampilKelasMataKuliah();//1
//            ruang = RuangKontrol.getKoneksi().jumlahRuang();//jumlah ruang teori
//            rng = RuangKontrol.getKoneksi().tampilRuangTeori();//list nama ruang teori
//        } catch (SQLException ex) {
//            Logger.getLogger(Kromosom.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public Kromosom(List<KelasKuliah> kelasKuliah, List<Ruang> ruang) {
        dataa = kelasKuliah;
        this.ruang = RuangKontrol.jumlahRuang(ruang);
        rng = ruang;
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

        for (int i = 0; i < matkul; i++) {//checklist kelasmatkul (sdh dimasukkan/blm)
            cek[i] = false;
        }

        for (int i = 0; i < dataPermintaan.size(); i++) { //memasukkan permintaan terlebih dalulu
            KelasKuliah matkulPermintaan = dataa.get(cariIndexKelasKuliah(dataPermintaan.get(i).getIdKelas().getIdKelas()));
            int posisiGen = penentuanLokasiGen(dataPermintaan.get(i));

            data[posisiGen].setAllele(matkulPermintaan);
            String idMK = data[posisiGen].getAllele().getIdMK().getIdMK();
            data[posisiGen].getAllele().getIdMK().setSemester(isiSemester(idMK));
            data[posisiGen].setKunci(true);
            cek[cariIndexKelasKuliah(dataPermintaan.get(i).getIdKelas().getIdKelas())] = true;
//            System.out.println("NoRule "+dataPermintaan.get(i).getNoRule()+" berada di index " + posisiGen);
            N--;
        }

        int index = 0; //untuk index matakuliah
        while (N != 0) {//untuk kelas non permintaan
            //random
            int tangkap = r.nextInt(data.length);
            if (cek[index] == true) {
                index++;
            } else {
                if (data[tangkap].getAllele().getIdKelas() == 0) {
                    data[tangkap].setAllele(dataa.get(index));
                    String idMK = data[tangkap].getAllele().getIdMK().getIdMK();
                    data[tangkap].getAllele().getIdMK().setSemester(isiSemester(idMK));
                    data[tangkap].setKunci(false);
                    index++;
                    N--;
                }
            }
        }
        return data;
    }

    public int isiSemester(String idMK) {
        int semester = 0;
        semester = MataKuliahKontrol.cariSemester(idMK, makul);
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
                if (count_ruang == rng.size() - 1 && count_bagiruang == bagiruang) {
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

    public int cariIndexKelasKuliah(int idKelas) {
        int temp = 0;
        for (int i = 0; i < dataa.size(); i++) {
            if (dataa.get(i).getIdKelas() == idKelas) {
                temp = i;
                break;
            }
        }
        return temp;
    }

    public int penentuanLokasiGen(tabelPermintaan kelasPermintaan) {
        String ruang_permintaan = kelasPermintaan.getIdRuang().idRuang;
        String hari_permintaan = kelasPermintaan.getHari();
        int jam_permintaan = tentukanJamPermintaan(kelasPermintaan.getJam());

        int posisiGen = 0;
        if (!ruang_permintaan.equals("-") && !hari_permintaan.equals("-") && jam_permintaan != 0) {//semua ditentukan
            for (int j = 0; j < data.length; j++) {
                if (data[j].getRuang().getIdRuang().equals(ruang_permintaan)
                        && data[j].getHari().equals(hari_permintaan)
                        && data[j].getJam() == jam_permintaan) {
                    posisiGen = j;
                    break;
                }
            }
        } else if (ruang_permintaan.equals("-") && !hari_permintaan.equals("-") && jam_permintaan != 0) { //meminta hari dan jam tertentu
            for (int j = 0; j < data.length; j++) {
                if (data[j].getHari().equals(hari_permintaan)
                        && data[j].getJam() == jam_permintaan) {
                    posisiGen = j;
                    break;
                }
            }
        } else if (!ruang_permintaan.equals("-") && hari_permintaan.equals("-") && jam_permintaan != 0) { //meminta ruang dan jam tertentu
            for (int j = 0; j < data.length; j++) {
                if (data[j].getRuang().getIdRuang().equals(ruang_permintaan)
                        && data[j].getJam() == jam_permintaan) {
                    posisiGen = j;
                    break;
                }
            }
        } else if (!ruang_permintaan.equals("-") && !hari_permintaan.equals("-") && jam_permintaan == 0) { //meminta ruang dan hari tertentu
            for (int j = 0; j < data.length; j++) {
                if (data[j].getRuang().getIdRuang().equals(ruang_permintaan)
                        && data[j].getHari().equals(hari_permintaan)) {
                    posisiGen = j;
                    break;
                }
            }
        } else if (!ruang_permintaan.equals("-") && hari_permintaan.equals("-") && jam_permintaan == 0) {//hanya meminta ruang
            for (int j = 0; j < data.length; j++) {
                if (data[j].getRuang().getIdRuang().equals(ruang_permintaan)) {
                    posisiGen = j;
                    break;
                }
            }
        } else if (ruang_permintaan.equals("-") && !hari_permintaan.equals("-") && jam_permintaan == 0) {//Hanya meminta hari
            for (int j = 0; j < data.length; j++) {
                if (data[j].getHari().equals(hari_permintaan)) {
                    posisiGen = j;
                    break;
                }
            }
        } else if (ruang_permintaan.equals("-") && hari_permintaan.equals("-") && jam_permintaan != 0) {//Hanya meminta waktu
            for (int j = 0; j < data.length; j++) {
                if (data[j].getJam() == jam_permintaan) {
                    posisiGen = j;
                    break;
                }
            }
        }
        return posisiGen;
    }

    public Kromosom solusiAwal(List<KelasKuliah> kelasKuliah, List<Ruang> ruang, List<MataKuliah> makul, List<tabelPermintaan> dataPer) {//
        Kromosom krom = new Kromosom(kelasKuliah, ruang);
        this.makul = makul;
        this.dataPermintaan = dataPer;
        krom.setData(prosesRandom());
        return krom;
    }
}
