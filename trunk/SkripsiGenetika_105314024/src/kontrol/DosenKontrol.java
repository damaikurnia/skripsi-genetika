
package kontrol;

import java.sql.*;
import koneksi.Koneksi;
import clas.Dosen;

public class DosenKontrol {
    private Connection conn;

    public DosenKontrol(Connection conn) {
        this.conn = conn;
    }

    public static DosenKontrol getKoneksiDosen() {
        DosenKontrol dosen = new DosenKontrol(Koneksi.getKoneksi());
        return dosen;
    }

    public void tambahDosen(Dosen dosen) throws SQLException {
        String idDosen = dosen.getIdDosen();
        String namaDosen = dosen.getNamaDosen();
        String status = dosen.getStatus();
        String sql = "insert into " + "dosen(idDosen,namaDosen,status)"
                + "values('" + idDosen + "','" + namaDosen + "','" + status + "')";
        Statement stat = conn.createStatement();
        stat.executeUpdate(sql);
    }
    
    public void UpdateDosen(Dosen dosen) throws SQLException {
        String idDosen = dosen.getIdDosen();
        String namaDosen = dosen.getNamaDosen();
        String status = dosen.getStatus();
        String sql = "update Dosen set namaDosen = '" + namaDosen + "',status = '" + status + "' where idDosen = '" + idDosen + "";
        Statement stat = conn.createStatement();
        stat.executeUpdate(sql);
    }
    
    public void hapusDosen(Dosen dosen) throws SQLException {
        String idDosen = dosen.getIdDosen();
        String namaDosen = dosen.getNamaDosen();
        String status = dosen.getStatus();
        String sql = "delete from Dosen where idDosen = '" + idDosen + "'";
        Statement stat = conn.createStatement();
        stat.executeUpdate(sql);
    }
    
}
