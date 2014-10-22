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
public class Gen {
    KelasKuliah allele;
    Ruang Ruang;
    String hari;
    int jam;
    int nilaiFitness;

    /**
     * @return the timeSlot
     */
    public KelasKuliah getAllele() {
        return allele;
    }

    /**
     * @param timeSlot the timeSlot to set
     */
    public void setAllele(KelasKuliah timeSlot) {
        this.allele = timeSlot;
    }

    /**
     * @return the Ruang
     */
    public Ruang getRuang() {
        return Ruang;
    }

    /**
     * @param Ruang the Ruang to set
     */
    public void setRuang(Ruang Ruang) {
        this.Ruang = Ruang;
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
    public int getJam() {
        return jam;
    }

    /**
     * @param jam the jam to set
     */
    public void setJam(int jam) {
        this.jam = jam;
    }

    /**
     * @return the nilaiFitness
     */
    public int getNilaiFitness() {
        return nilaiFitness;
    }

    /**
     * @param nilaiFitness the nilaiFitness to set
     */
    public void setNilaiFitness(int nilaiFitness) {
        this.nilaiFitness = nilaiFitness;
    }
}
