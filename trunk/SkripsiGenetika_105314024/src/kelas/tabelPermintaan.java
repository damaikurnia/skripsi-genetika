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
    private int noRule;
    private String idKelas; //id kelas makul
    private String idRuang;
    private String Hari;
    private String Jam;
    
    public tabelPermintaan(int noRule,String idKelas,String idRuang,String Hari,String Jam){
        this.noRule = noRule;
        this.idKelas = idKelas;
        this.idRuang = idRuang;
        this.Hari = Hari;
        this.Jam = Jam;
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
    public String getIdKelas() {
        return idKelas;
    }

    /**
     * @param idKelas the idKelas to set
     */
    public void setIdKelas(String idKelas) {
        this.idKelas = idKelas;
    }

    /**
     * @return the idRuang
     */
    public String getIdRuang() {
        return idRuang;
    }

    /**
     * @param idRuang the idRuang to set
     */
    public void setIdRuang(String idRuang) {
        this.idRuang = idRuang;
    }

    /**
     * @return the Hari
     */
    public String getHari() {
        return Hari;
    }

    /**
     * @param Hari the Hari to set
     */
    public void setHari(String Hari) {
        this.Hari = Hari;
    }

    /**
     * @return the Jam
     */
    public String getJam() {
        return Jam;
    }

    /**
     * @param Jam the Jam to set
     */
    public void setJam(String Jam) {
        this.Jam = Jam;
    }
    
}
