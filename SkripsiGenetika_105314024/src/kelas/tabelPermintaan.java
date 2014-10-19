/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kelas;

/**
 *
 * @author Adhi
 */
public class tabelPermintaan {
    int noRule;
    KelasKuliah idKelas;
    Ruang idRuang;
    String hari;
    String jam;
    
    //buat tampilan
    String matakuliah;
    String namaDosen;
    
    public tabelPermintaan(int noRule,int idKelas,String idRuang,String hari,String jam){ //untuk input
        this.noRule = noRule;
        this.idKelas = new KelasKuliah(idKelas);
        this.idRuang = new Ruang(idRuang);
        this.hari = hari;
        this.jam = jam;
    }
    
    public tabelPermintaan(){}

    /**
     * @return the noRule
     */
    public int getNoRule() {
        return noRule;
    }

    /**
     * @param noRule the noRule to set
     */
    public void setNoRule(int noRule) {
        this.noRule = noRule;
    }

    /**
     * @return the idKelas
     */
    public KelasKuliah getIdKelas() {
        return idKelas;
    }

    /**
     * @param idKelas the idKelas to set
     */
    public void setIdKelas(KelasKuliah idKelas) {
        this.idKelas = idKelas;
    }

    /**
     * @return the idRuang
     */
    public Ruang getIdRuang() {
        return idRuang;
    }

    /**
     * @param idRuang the idRuang to set
     */
    public void setIdRuang(Ruang idRuang) {
        this.idRuang = idRuang;
    }

    /**
     * @return the hari
     */
    public String getHari() {
        return hari;
    }

    /**
     * @param hari the hari to set
     */
    public void setHari(String hari) {
        this.hari = hari;
    }

    /**
     * @return the jam
     */
    public String getJam() {
        return jam;
    }

    /**
     * @param jam the jam to set
     */
    public void setJam(String jam) {
        this.jam = jam;
    }

    /**
     * @return the matakuliah
     */
    public String getMatakuliah() {
        return matakuliah;
    }

    /**
     * @param matakuliah the matakuliah to set
     */
    public void setMatakuliah(String matakuliah) {
        this.matakuliah = matakuliah;
    }

    /**
     * @return the namaDosen
     */
    public String getNamaDosen() {
        return namaDosen;
    }

    /**
     * @param namaDosen the namaDosen to set
     */
    public void setNamaDosen(String namaDosen) {
        this.namaDosen = namaDosen;
    }
  }
