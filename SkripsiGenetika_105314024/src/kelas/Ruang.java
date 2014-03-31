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
public class Ruang {
    String idRuang;
    String namaRuang; 
    
    public Ruang(String id,String nama){
        this.idRuang = id;
        this.namaRuang = nama;
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
     * @return the namaRuang
     */
    public String getNamaRuang() {
        return namaRuang;
    }

    /**
     * @param namaRuang the namaRuang to set
     */
    public void setNamaRuang(String namaRuang) {
        this.namaRuang = namaRuang;
    }
}
