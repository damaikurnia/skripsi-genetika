package clas;
public class ruang_kelas {
private String idRuang;
private String namaRuang;
private int kapasitas;

    public ruang_kelas() {
    }

    public ruang_kelas(String idRuang, String namaRuang, int kapasitas) {
        this.idRuang = idRuang;
        this.namaRuang = namaRuang;
        this.kapasitas = kapasitas;
    }

    public ruang_kelas(String idRuang, String namaRuang) {
        this.idRuang = idRuang;
        this.namaRuang = namaRuang;
    }

    public String getIdRuang() {
        return idRuang;
    }

    public void setIdRuang(String idRuang) {
        this.idRuang = idRuang;
    }

    public String getNamaRuang() {
        return namaRuang;
    }

    public void setNamaRuang(String namaRuang) {
        this.namaRuang = namaRuang;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }
}
