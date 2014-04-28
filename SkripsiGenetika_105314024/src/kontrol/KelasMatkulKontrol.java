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
 * @author Mich
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
    }

    public void updateKelasMataKuliah(KelasKuliah kk) throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "update KELAS_MAKUL set idMK = ?, idDosen = ?,"
                + "Kelas = ? where idKelas = ?";
        stmt = conn.prepareStatement(query);
        
        stmt.setString(1, kk.getIdMK().getIdMK());
        stmt.setString(2, kk.getIdDosen().getIdDosen());
        stmt.setString(3, kk.getKelas());
        stmt.setString(4, Integer.toString(kk.getIdKelas()));
        
        stmt.executeUpdate();
        conn.commit();
    }

    public void deleteKelasMataKuliah(KelasKuliah kk) throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "delete from KELAS_MAKUL where idKelas = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, Integer.toString(kk.getIdKelas()));

        stmt.executeUpdate();
        conn.commit();
    }
    
    public List<KelasKuliah> tampilKelasMataKuliah() throws SQLException {
        PreparedStatement stmt = null;
        ResultSet result = null;
        conn.setAutoCommit(false);
        String query = "SELECT * FROM KELAS_MAKUL ORDER BY idKelas";
        stmt = conn.prepareStatement(query);
        result = stmt.executeQuery();
        List<KelasKuliah> mk = new ArrayList<KelasKuliah>();
        
        KelasKuliah temp = null;
        while (result.next()) {
            temp = new KelasKuliah();
            temp.setIdKelas(Integer.parseInt(result.getString(1)));
            temp.setIdMK(new MataKuliah(result.getString(2)));
            temp.setIdDosen(new Dosen(result.getString(3)));
            temp.setKelas(result.getString(4));
            mk.add(temp);
        }
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
        mk.setIdMK(result.getString(1));
        mk.setNamaMK(result.getString(2));
        conn.commit();
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
        
        Dosen mk = new Dosen(result.getString(1), result.getString(2), "");
        conn.commit();
        return mk;
    }
}
