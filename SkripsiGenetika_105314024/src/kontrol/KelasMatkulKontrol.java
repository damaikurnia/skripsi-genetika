/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontrol;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import koneksi.Koneksi;
import kelas.Dosen;
import kelas.KelasKuliah;
import kelas.MataKuliah;

/**
 *
 * @author Adhi
 */
public class KelasMatkulKontrol {

    private Connection conn;

    public KelasMatkulKontrol(Connection conn) {
        this.conn = conn;
    }

    public static KelasMatkulKontrol getKoneksi() {
        KelasMatkulKontrol matkul = new KelasMatkulKontrol(Koneksi.getKoneksi());
        return matkul;
    }

    public void insertKelasMataKuliah(KelasKuliah kk) throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "INSERT INTO KELAS_MAKUL VALUES(?,?,?,?)";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, Integer.toString(kk.getIdKelas()));
        stmt.setString(2, kk.getIdMK().getIdMK());
        stmt.setString(3, kk.getIdDosen().getIdDosen());
        stmt.setString(4, kk.getKelas());

        stmt.executeUpdate();
        conn.commit();
        conn.close();
    }

    public void updateKelasMataKuliah(KelasKuliah kk) throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "update KELAS_MAKUL set idDosen = ? where idKelas = ?";
        stmt = conn.prepareStatement(query);

        stmt.setString(1, kk.getIdDosen().getIdDosen());
        stmt.setString(2, Integer.toString(kk.getIdKelas()));

        stmt.executeUpdate();
        conn.commit();
        conn.close();
    }

    public void deleteKelasMataKuliah(KelasKuliah kk) throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "delete from KELAS_MAKUL where idKelas = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, Integer.toString(kk.getIdKelas()));

        stmt.executeUpdate();
        conn.commit();
        conn.close();
    }
    
    public void deleteAllKelasMatkul() throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "DELETE FROM kelas_makul WHERE idKelas <> \"0\";";
        stmt = conn.prepareStatement(query);

        stmt.executeUpdate();
        conn.commit();
        conn.close();
    }

    public List<KelasKuliah> tampilKelasMataKuliah() throws SQLException {
        PreparedStatement stmt = null;
        ResultSet result = null;
        conn.setAutoCommit(false);
        String query = "SELECT a.idKelas,a.idMK,b.namaMK,a.Kelas,b.sks,b.semester,b.JP,c.namaDosen\n"
                + "FROM kelas_makul a, matakuliah b, dosen c \n"
                + "WHERE a.idMK = b.idMK AND a.idDosen = c.idDosen\n"
                + "AND a.idKelas <> \"0\"\n"
                + "ORDER BY b.semester,a.idMK,a.Kelas;";
        stmt = conn.prepareStatement(query);
        result = stmt.executeQuery();
        List<KelasKuliah> mk = new ArrayList<KelasKuliah>();

        KelasKuliah temp = null;
        while (result.next()) {
            temp = new KelasKuliah();
            temp.setIdKelas(Integer.parseInt(result.getString(1)));
            temp.setIdMK(new MataKuliah(result.getString(2), result.getString(3), result.getInt(5), result.getInt(6), result.getInt(7)));
            temp.setIdDosen(new Dosen("", result.getString(8), ""));
            temp.setKelas(result.getString(4));
            mk.add(temp);
        }
        conn.close();
        return mk;
    }

    public MataKuliah tampilMatakuliah(String idMK) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet result = null;
        conn.setAutoCommit(false);
        String query = "SELECT idMK,namaMk FROM MATAKULIAH WHERE idMK = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, idMK);
        result = stmt.executeQuery();
        MataKuliah mk = new MataKuliah();
        while (result.next()) {
            mk.setIdMK(result.getString(1));
            mk.setNamaMK(result.getString(2));
        }
        conn.commit();
        conn.close();
        return mk;
    }

    public Dosen tampilDosen(String idDosen) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet result = null;
        conn.setAutoCommit(false);
        String query = "SELECT idDosen,namaDosen FROM DOSEN WHERE idDosen = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, idDosen);
        result = stmt.executeQuery();
        Dosen mk = null;
        while (result.next()) {
            mk = new Dosen(result.getString(1), result.getString(2), "");
        }
        conn.close();
        return mk;
    }

    public List<MataKuliah> tampilMatakuliahPerSemester(int semester) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet result = null;
        conn.setAutoCommit(false);
        String query = "SELECT * FROM matakuliah WHERE semester = ?";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, semester);
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

//======================METHOD KHUSUS FRAME VIEW PENJADWALAN===================
    public List<KelasKuliah> tampilMakulDosen(String idDosen) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet result = null;
        conn.setAutoCommit(false);
        String query = "SELECT a.idKelas,CONCAT(a.idMK,\"-\",b.namaMK) AS \"Matakuliah\","
                + "a.kelas,b.semester FROM kelas_makul a, matakuliah b "
                + "WHERE a.idMK = b.idMK AND a.idDosen = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, idDosen);
        result = stmt.executeQuery();
        List<KelasKuliah> mk = new ArrayList<KelasKuliah>();

        KelasKuliah temp = null;
        while (result.next()) {
            temp = new KelasKuliah();
            temp.setIdKelas(Integer.parseInt(result.getString(1)));
            temp.setIdMK(new MataKuliah(result.getString(2), result.getInt(4)));// outputnya USD 120 -Pendidikan Agama
            temp.setKelas(result.getString(3));
            mk.add(temp);
        }
        conn.close();
        return mk;
    }
}
