/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kelas;

/**
 *
 * @author Mich
 */
public class Gen {
    private KelasKuliah timeSlot;
    private Ruang Ruang;
    private String hari;
    private int jam;
    private int nilaiFitness;

    /**
     * @return the timeSlot
     */
    public KelasKuliah getTimeSlot() {
        return timeSlot;
    }

    /**
     * @param timeSlot the timeSlot to set
     */
    public void setTimeSlot(KelasKuliah timeSlot) {
        this.timeSlot = timeSlot;
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