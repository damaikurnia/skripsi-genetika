/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kelas;

import kelas.Dosen;

/**
 *
 * @author Mich
 */
public class KelasKuliah {

    private int idKelas;
    private MataKuliah idMK;
    private String kelas;//A B C
    private Dosen idDosen;
//=======================DIPAKAI DI FRAME PENJADWALAN==========================
    private String hari;
    private int jam;
    
    public KelasKuliah() {}

    public KelasKuliah(int id) {
        this.idKelas = id;
        this.idMK = new MataKuliah("-");
        this.kelas = "-";
        this.idDosen = new Dosen("-");
    }

    public KelasKuliah(int id, MataKuliah idm, String kls, Dosen idsn) {
        this.idKelas = id;
        this.idMK = idm;
        this.kelas = kls;
        this.idDosen = idsn;
    }

    /**
     * @return the idKelas
     */
    public int getIdKelas() {
        return idKelas;
    }

    /**
     * @param idKelas the idKelas to set
     */
    public void setIdKelas(int idKelas) {
        this.idKelas = idKelas;
    }

    /**
     * @return the idMK
     */
    public MataKuliah getIdMK() {
        return idMK;
    }

    /**
     * @param idMK the idMK to set
     */
    public void setIdMK(MataKuliah idMK) {
        this.idMK = idMK;
    }

    /**
     * @return the kelas
     */
    public String getKelas() {
        return kelas;
    }

    /**
     * @param kelas the kelas to set
     */
    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    /**
     * @return the idDosen
     */
    public Dosen getIdDosen() {
        return idDosen;
    }

    /**
     * @param idDosen the idDosen to set
     */
    public void setIdDosen(Dosen idDosen) {
        this.idDosen = idDosen;
    }
//=======================DIPAKAI DI VIEW PENJADWALAN==========================
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
    public int getJam() {
        return jam;
    }

    /**
     * @param jam the jam to set
     */
    public void setJam(int jam) {
        this.jam = jam;
    }
}
