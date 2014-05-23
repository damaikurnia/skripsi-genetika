
package kontrol;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import koneksi.Koneksi;
import kelas.Dosen;
import kelas.MataKuliah;

public class MataKuliahKontrol {
    private Connection conn;

    public MataKuliahKontrol(Connection conn) {
        this.conn = conn;
    }

    public static MataKuliahKontrol getKoneksi() {
        MataKuliahKontrol matkul = new MataKuliahKontrol(Koneksi.getKoneksi());
        return matkul;
    }

    public void insertMataKuliah(MataKuliah mk) throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "INSERT INTO MATAKULIAH VALUES(?,?,?,?,?)";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, mk.getIdMK());
        stmt.setString(2, mk.getNamaMK());
        stmt.setInt(3, mk.getSks());
        stmt.setInt(4, mk.getSemester());
        stmt.setInt(5, mk.getJP());
        
        stmt.executeUpdate();
        conn.commit();
    }

    public void updateMataKuliah(MataKuliah mk) throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "update MATAKULIAH set namaMK = ?, sks = ?,"
                + "semester = ?, JP = ? where idMK = ?";
        stmt = conn.prepareStatement(query);
        
        stmt.setString(1, mk.getNamaMK());
        stmt.setInt(2, mk.getSks());
        stmt.setInt(3, mk.getSemester());
        stmt.setInt(4, mk.getJP());
        stmt.setString(5, mk.getIdMK());

        stmt.executeUpdate();
        conn.commit();
    }

    public void deleteMataKuliah(MataKuliah mk) throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "delete from MATAKULIAH where idMK = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, mk.getIdMK());

        stmt.executeUpdate();
        conn.commit();
    }
    
    public List<MataKuliah> tampilMataKuliah() throws SQLException {
        PreparedStatement stmt = null;
        ResultSet result = null;
        conn.setAutoCommit(false);
        String query = "SELECT * FROM matakuliah ORDER BY semester";
        stmt = conn.prepareStatement(query);
        result = stmt.executeQuery();
        List<MataKuliah> mk = new ArrayList<MataKuliah>();
        
        MataKuliah temp = null;
        while (result.next()) {
            temp = new MataKuliah();
            temp.setIdMK(result.getString(1));
            temp.setNamaMK(result.getString(2));
            temp.setSks(result.getInt(3));
            temp.setSemester(result.getInt(4));
            temp.setJP(result.getInt(5));
            mk.add(temp);
        }
        return mk;
    }
    
    public int cariSemester(String idMK) throws SQLException{
        PreparedStatement stmt = null;
        ResultSet result = null;
        conn.setAutoCommit(false);
        String query = "SELECT semester FROM matakuliah WHERE idMK = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, idMK);
        result = stmt.executeQuery();
        int semester = 0;
        
        while (result.next()) {
            semester = result.getInt(1);
        }
        
        return semester;
    } 
}
