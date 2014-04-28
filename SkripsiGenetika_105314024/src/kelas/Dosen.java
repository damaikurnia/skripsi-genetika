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
public class Dosen {
    String idDosen;
    String namaDosen;
    String status;
    
    public Dosen(String id){
        this.idDosen = id;
    }
    
    public Dosen(String id,String nama,String status){
        this.idDosen = id;
        this.namaDosen = nama;
        this.status = status;
    }
    /**
     * @return the idDosen
     */
    public String getIdDosen() {
        return idDosen;
    }

    /**
     * @param idDosen the idDosen to set
     */
    public void setIdDosen(String idDosen) {
        this.idDosen = idDosen;
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

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
