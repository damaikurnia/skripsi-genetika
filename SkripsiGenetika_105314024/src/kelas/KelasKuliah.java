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
    private MataKuliah idKuliah;
    private String kelasKuliah;//A B C
    private Dosen dosenPengampu;

    /**
     * @return the idKuliah
     */
    public MataKuliah getIdKuliah() {
        return idKuliah;
    }

    /**
     * @param idKuliah the idKuliah to set
     */
    public void setIdKuliah(MataKuliah idKuliah) {
        this.idKuliah = idKuliah;
    }

    /**
     * @return the kelasKuliah
     */
    public String getKelasKuliah() {
        return kelasKuliah;
    }

    /**
     * @param kelasKuliah the kelasKuliah to set
     */
    public void setKelasKuliah(String kelasKuliah) {
        this.kelasKuliah = kelasKuliah;
    }

    /**
     * @return the dosenPengampu
     */
    public Dosen getDosenPengampu() {
        return dosenPengampu;
    }

    /**
     * @param dosenPengampu the dosenPengampu to set
     */
    public void setDosenPengampu(Dosen dosenPengampu) {
        this.dosenPengampu = dosenPengampu;
    }

}
