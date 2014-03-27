package clas;
public class Dosen {
private String idDosen;
private String namaDosen;
private String status;

    public Dosen() {
    }

    public Dosen(String idDosen, String namaDosen, String status) {
        this.idDosen = idDosen;
        this.namaDosen = namaDosen;
        this.status = status;
    }

    public Dosen(String idDosen, String namaDosen) {
        this.idDosen = idDosen;
        this.namaDosen = namaDosen;
    }

    public String getIdDosen() {
        return idDosen;
    }

    public void setIdDosen(String idDosen) {
        this.idDosen = idDosen;
    }

    public String getNamaDosen() {
        return namaDosen;
    }

    public void setNamaDosen(String namaDosen) {
        this.namaDosen = namaDosen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
