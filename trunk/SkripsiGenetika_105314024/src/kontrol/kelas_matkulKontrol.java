package kontrol;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import koneksi.Koneksi;
import clas.kelas_matkul;

public class kelas_matkulKontrol {
       private Connection conn;

    public kelas_matkulKontrol(Connection conn) {
        this.conn = conn;
    }

    public static kelas_matkulKontrol getKoneksikelas_matkulKontrol() {
        kelas_matkulKontrol kelas = new kelas_matkulKontrol(Koneksi.getKoneksi());
        return kelas;
    }

    public void tambahKelas(kelas_matkul kelas) throws SQLException {
        String idKelas = kelas.getIdKelas();
        String namaKelas = kelas.getNamaKelas();
        int jumlahMahasiswa = kelas.getJumlahMahasiswa();
        String sql = "insert into " + "kelas_matkul(idKelas,namaKelas,jumlahMahasiswa)"
                + "values('" + idKelas + "','" + namaKelas + "'," + jumlahMahasiswa + ")";
        Statement stat = conn.createStatement();
        stat.executeUpdate(sql);
    }
    
    public void UpdateKelas(kelas_matkul kelas) throws SQLException {
        String idKelas = kelas.getIdKelas();
        String namaKelas = kelas.getNamaKelas();
        int jumlahMahasiswa = kelas.getJumlahMahasiswa();
        String sql = "update kelas_matkul set namaKelas = '" + namaKelas + "',jumlahMahasiswa = " + jumlahMahasiswa + " where idKelas = '" + idKelas + "'";
        Statement stat = conn.createStatement();
        stat.executeUpdate(sql);
    }
    
    public void hapusKelas(kelas_matkul kelas) throws SQLException {
        String idKelas = kelas.getIdKelas();
        String namaKelas = kelas.getNamaKelas();
        int jumlahMahasiswa = kelas.getJumlahMahasiswa();
        String sql = "delete from kelas_matkul where idKelas = '" + idKelas + "'";
        Statement stat = conn.createStatement();
        stat.executeUpdate(sql);
    }
    
}
