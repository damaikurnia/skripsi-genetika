package clas;
public class kelas_matkul {
private String idKelas;
private String namaKelas;
private int jumlahMahasiswa;
private Dosen idDosen;
private ruang_kelas idRuang;

    public kelas_matkul() {
    }

    public kelas_matkul(String idKelas, String namaKelas, int jumlahMahasiswa, Dosen idDosen, ruang_kelas idRuang) {
        this.idKelas = idKelas;
        this.namaKelas = namaKelas;
        this.jumlahMahasiswa = jumlahMahasiswa;
        this.idDosen = idDosen;
        this.idRuang = idRuang;
    }

    public kelas_matkul(String idKelas, String namaKelas) {
        this.idKelas = idKelas;
        this.namaKelas = namaKelas;
    }

    public String getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(String idKelas) {
        this.idKelas = idKelas;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public int getJumlahMahasiswa() {
        return jumlahMahasiswa;
    }

    public void setJumlahMahasiswa(int jumlahMahasiswa) {
        this.jumlahMahasiswa = jumlahMahasiswa;
    }

    public Dosen getIdDosen() {
        return idDosen;
    }

    public void setIdDosen(Dosen idDosen) {
        this.idDosen = idDosen;
    }

    public ruang_kelas getIdRuang() {
        return idRuang;
    }

    public void setIdRuang(ruang_kelas idRuang) {
        this.idRuang = idRuang;
    }
}
