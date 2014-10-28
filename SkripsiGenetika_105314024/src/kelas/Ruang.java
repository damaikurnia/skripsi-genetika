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
public class Ruang {
    String idRuang;
    String namaRuang;
    String jenisRuang;
    
    public Ruang(String id,String nama,String jenis){
        this.idRuang = id;
        this.namaRuang = nama;
        this.jenisRuang = jenis;
    }
    
    public Ruang(String id){
        this.idRuang = id;
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

    /**
     * @return the jenisRuang
     */
    public String getJenisRuang() {
        return jenisRuang;
    }

    /**
     * @param jenisRuang the jenisRuang to set
     */
    public void setJenisRuang(String jenisRuang) {
        this.jenisRuang = jenisRuang;
    }
    
}
