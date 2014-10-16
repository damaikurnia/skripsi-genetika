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
public class MataKuliah {

    private String idMK;
    private String namaMK;
    private int sks;
    private int semester;
    private int JP;

    public MataKuliah(String idMK) {
        this.idMK = idMK;
    }
    
    public MataKuliah(String idMK,int Semester) {
        this.idMK = idMK;
        this.semester = Semester;
    }
    
    public MataKuliah() {}
    
    public MataKuliah(String idMK, String namaMK, int sks, int semester, int JP) {
        this.idMK = idMK;
        this.namaMK = namaMK;
        this.sks = sks;
        this.semester = semester;
        this.JP = JP;
    }

    /**
     * @return the idMK
     */
    public String getIdMK() {
        return idMK;
    }

    /**
     * @param idMK the idMK to set
     */
    public void setIdMK(String idMK) {
        this.idMK = idMK;
    }

    /**
     * @return the namaMK
     */
    public String getNamaMK() {
        return namaMK;
    }

    /**
     * @param namaMK the namaMK to set
     */
    public void setNamaMK(String namaMK) {
        this.namaMK = namaMK;
    }

    /**
     * @return the sks
     */
    public int getSks() {
        return sks;
    }

    /**
     * @param sks the sks to set
     */
    public void setSks(int sks) {
        this.sks = sks;
    }

    /**
     * @return the semester
     */
    public int getSemester() {
        return semester;
    }

    /**
     * @param semester the semester to set
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     * @return the JP
     */
    public int getJP() {
        return JP;
    }

    /**
     * @param JP the JP to set
     */
    public void setJP(int JP) {
        this.JP = JP;
    }

}
