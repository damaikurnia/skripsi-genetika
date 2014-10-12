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

    public void insertDosen(Dosen d) throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "INSERT INTO DOSEN VALUES(?,?,?)";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, d.getIdDosen());
        stmt.setString(2, d.getNamaDosen());
        stmt.setString(3, d.getStatus());

        stmt.executeUpdate();
        conn.commit();
        conn.close();
    }

    public void updateDosen(Dosen dosen) throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "update Dosen set namaDosen = ?, status = ? where idDosen = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, dosen.getNamaDosen());
        stmt.setString(2, dosen.getStatus());
        stmt.setString(3, dosen.getIdDosen());

        stmt.executeUpdate();
        conn.commit();
        conn.close();
    }

    public void deleteDosen(Dosen dosen) throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "delete from Dosen where idDosen = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, dosen.getIdDosen());

        stmt.executeUpdate();
        conn.commit();
        conn.close();
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
            temp = new Dosen(result.getString(1), result.getString(2), result.getString(3));
            dsn.add(temp);
        }
        conn.close();
        return dsn;
    }

    public List<Dosen> cariDosen(String key) throws SQLException {
        PreparedStatement psmt = null;
        ResultSet rset = null;
        conn.setAutoCommit(false);
        String sql = "select * from dosen where "
                + "idDosen LIKE '%" + key + "%' OR namaDosen LIKE '%" + key + "%' OR "
                + "status LIKE '%" + key + "%'"
                + "order by idDosen";
        psmt = conn.prepareStatement(sql);
        rset = psmt.executeQuery();
        List<Dosen> dosen = new ArrayList<Dosen>();
        while (rset.next()) {
            dosen.add(new Dosen(rset.getString(1), rset.getString(2), rset.getString(1)));
        }
        conn.commit();
        conn.close();
        return dosen;
    }

//    public List<String> cariKelompokDosen() throws SQLException {
//        PreparedStatement psmt = null;
//        ResultSet result = null;
//        conn.setAutoCommit(false);
//        String sql = "SELECT idDosen FROM dosen";
//        psmt = conn.prepareStatement(sql);
//        result = psmt.executeQuery();
//        List<String> kel = new ArrayList<String>();
//        while (result.next()) {
//            kel.add(result.getString(1)+"-0");
//        }
//        conn.commit();
//        conn.close();
//        return kel;
//    }
    public static List<String> cariKelompokDosen(List<Dosen> dataDosen) {
        List<String> kel = new ArrayList<String>();
        for (int i = 0; i < dataDosen.size(); i++) {
            kel.add(dataDosen.get(i).getIdDosen() + "-0");
        }
        return kel;
    }
}
