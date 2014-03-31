
package kontrol;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import koneksi.Koneksi;
import kelas.Dosen;
import kelas.Ruang;

public class DosenKontrol {
    private Connection conn;

    public DosenKontrol(Connection conn) {
        this.conn = conn;
    }

    public static DosenKontrol getKoneksi() {
        DosenKontrol dosen = new DosenKontrol(Koneksi.getKoneksi());
        return dosen;
    }

    public void insertDosen(Dosen r) throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "INSERT INTO DOSEN VALUES(?,?,?)";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, r.getIdDosen());
        stmt.setString(2, r.getNamaDosen());
        stmt.setString(3, r.getStatus());

        stmt.executeUpdate();
        conn.commit();
    }

    public void updateDosen(Dosen ruang) throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "update Dosen set namaDosen = ?, status = ? where idDosen = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, ruang.getNamaDosen());
        stmt.setString(2, ruang.getStatus());
        stmt.setString(3, ruang.getIdDosen());

        stmt.executeUpdate();
        conn.commit();
    }

    public void deleteDosen(Dosen ruang) throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "delete from Dosen where idDosen = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, ruang.getIdDosen());

        stmt.executeUpdate();
        conn.commit();
    }
    
    public List<Dosen> tampilDosen() throws SQLException {
        PreparedStatement stmt = null;
        ResultSet result = null;
        conn.setAutoCommit(false);
        String query = "SELECT * FROM Dosen";
        stmt = conn.prepareStatement(query);
        result = stmt.executeQuery();
        List<Dosen> dsn = new ArrayList<Dosen>();
        
        Dosen temp = null;
        while (result.next()) {
            temp = new Dosen(result.getString(1), result.getString(2),result.getString(3));
            dsn.add(temp);
        }
        return dsn;
    }
    
}
