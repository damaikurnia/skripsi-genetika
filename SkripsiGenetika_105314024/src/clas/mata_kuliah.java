package clas;
public class mata_kuliah {
private String idMK;
private String namaMK;
private int sks;
private int semester;
private int JP;
private String jenis;

    public mata_kuliah() {
    }

    public mata_kuliah(String idMK, String namaMK, int sks, int semester, int JP, String jenis) {
        this.idMK = idMK;
        this.namaMK = namaMK;
        this.sks = sks;
        this.semester = semester;
        this.JP = JP;
        this.jenis = jenis;
    }

    public mata_kuliah(String idMK, String namaMK, int sks, int semester, int JP) {
        this.idMK = idMK;
        this.namaMK = namaMK;
        this.sks = sks;
        this.semester = semester;
        this.JP = JP;
    }

    public String getIdMK() {
        return idMK;
    }

    public void setIdMK(String idMK) {
        this.idMK = idMK;
    }

    public String getNamaMK() {
        return namaMK;
    }

    public void setNamaMK(String namaMK) {
        this.namaMK = namaMK;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getJP() {
        return JP;
    }

    public void setJP(int JP) {
        this.JP = JP;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
}
