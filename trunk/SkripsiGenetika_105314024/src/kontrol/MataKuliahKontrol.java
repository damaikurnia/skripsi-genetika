
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
        conn.close();
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
        conn.close();
    }

    public void deleteMataKuliah(MataKuliah mk) throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "delete from MATAKULIAH where idMK = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, mk.getIdMK());

        stmt.executeUpdate();
        conn.commit();
        conn.close();
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
        conn.close();
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
        conn.close();
        return semester;
    } 
    
    public List<MataKuliah> cariMatakuliah(String key) throws SQLException {
        PreparedStatement psmt = null;
        ResultSet result = null;
        conn.setAutoCommit(false);
        String sql = "select * from matakuliah where "
                + "idMK LIKE '%" + key + "%' OR namaMK LIKE '%" + key + "%' OR "
                + "sks LIKE '%" + key + "%' OR semester LIKE '%" + key + "%' OR "
                + "JP LIKE '%" + key + "%'"
                + "order by idMK";
        psmt = conn.prepareStatement(sql);
        result = psmt.executeQuery();
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
        conn.commit();
        conn.close();
        return mk;
    }
    
    public List<String> cariKelompokKelas() throws SQLException {
        PreparedStatement psmt = null;
        ResultSet result = null;
        conn.setAutoCommit(false);
        String sql = "SELECT b.semester,a.Kelas FROM kelas_makul a, matakuliah b "
                + "WHERE a.idMK=b.idMK "
                + "GROUP BY semester,Kelas ORDER BY semester;";
        psmt = conn.prepareStatement(sql);
        result = psmt.executeQuery();
        List<String> kel = new ArrayList<String>();
        while (result.next()) {
            kel.add(result.getString(1)+"-"+result.getString(2)+"-0");
        }
        conn.commit();
        conn.close();
        return kel;
    }
}
