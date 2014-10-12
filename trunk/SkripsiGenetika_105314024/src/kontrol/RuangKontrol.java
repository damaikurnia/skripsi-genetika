/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontrol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kelas.Ruang;
import koneksi.Koneksi;

/**
 *
 * @author Mich
 */
public class RuangKontrol {

    private Connection conn;

    public RuangKontrol(Connection conn) {
        this.conn = conn;
    }

    public static RuangKontrol getKoneksi() {
        RuangKontrol ruang = new RuangKontrol(Koneksi.getKoneksi());
        return ruang;
    }

    public void insertRuang(Ruang r) throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "INSERT INTO RUANG VALUES(?,?,?)";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, r.getIdRuang());
        stmt.setString(2, r.getNamaRuang());
        stmt.setString(3, r.getJenisRuang());

        stmt.executeUpdate();
        conn.commit();
        conn.close();
    }

    public void updateRuang(Ruang ruang) throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "update Ruang set namaRuang = ?, jenisRuang = ? where idRuang = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, ruang.getNamaRuang());
        stmt.setString(2, ruang.getJenisRuang());
        stmt.setString(3, ruang.getIdRuang());

        stmt.executeUpdate();
        conn.commit();
        conn.close();
    }

    public void deleteRuang(Ruang ruang) throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "delete from Ruang where idRuang = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, ruang.getIdRuang());

        stmt.executeUpdate();
        conn.commit();
        conn.close();
    }

    public List<Ruang> tampilRuang() throws SQLException {
        PreparedStatement stmt = null;
        Ruang temp = null;
        ResultSet result = null;
        conn.setAutoCommit(false);
        String query = "SELECT * FROM Ruang";
        stmt = conn.prepareStatement(query);
        result = stmt.executeQuery();
        List<Ruang> ruang = new ArrayList<Ruang>();

        while (result.next()) {
            temp = new Ruang(result.getString(1), result.getString(2), result.getString(3));
            ruang.add(temp);
        }
        conn.close();
        return ruang;
    }

    public static int jumlahRuang(List<Ruang> dataruang) {
        int jumlah = 0;
        for (int i = 0; i < dataruang.size(); i++) {
            if (dataruang.get(i).getJenisRuang().contains("TEORI")) {
                jumlah = jumlah + 1;
            } else {
                jumlah = jumlah;
            }
        }
        return jumlah;
    }

    public List<Ruang> tampilRuangTeori() throws SQLException {
        PreparedStatement stmt = null;
        Ruang temp = null;
        ResultSet result = null;
        conn.setAutoCommit(false);
//        String query = "SELECT * FROM Ruang WHERE jenisRuang LIKE ('TEORI%')";
        String query = "SELECT * FROM ruang WHERE jenisRuang LIKE('TEORI%') ORDER BY jenisRuang;";
        stmt = conn.prepareStatement(query);
        result = stmt.executeQuery();
        List<Ruang> ruang = new ArrayList<Ruang>();

        while (result.next()) {
            temp = new Ruang(result.getString(1), result.getString(2), result.getString(3));
            ruang.add(temp);
        }
        conn.close();
        return ruang;
    }
}
