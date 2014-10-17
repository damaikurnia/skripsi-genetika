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
import kelas.tabelPermintaan;

/**
 *
 * @author Adhi
 */
public class PenjadwalanKontrol {

    private Connection conn;

    public PenjadwalanKontrol(Connection conn) {
        this.conn = conn;
    }

    public static PenjadwalanKontrol getKoneksi() {
        PenjadwalanKontrol matkul = new PenjadwalanKontrol(Koneksi.getKoneksi());
        return matkul;
    }

    public void insertTabelPermintaan(tabelPermintaan tab_permintaan) throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "INSERT INTO tabelPermintaan VALUES(?,?,?,?,?)";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, tab_permintaan.getNoRule());
        stmt.setString(2, tab_permintaan.getIdKelas());
        stmt.setString(3, tab_permintaan.getIdRuang());
        stmt.setString(4, tab_permintaan.getHari());
        stmt.setString(5, tab_permintaan.getJam());

        stmt.executeUpdate();
        conn.commit();
        conn.close();
    }

    public void updateTabelPermintaan(tabelPermintaan tab_permintaan) throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "update tabelPermintaan set idKelas = ?, idRuang = ?,"
                + "Hari = ?, Jam = ? where noRule = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, tab_permintaan.getIdKelas());
        stmt.setString(2, tab_permintaan.getIdRuang());
        stmt.setString(3, tab_permintaan.getHari());
        stmt.setString(4, tab_permintaan.getJam());
        stmt.setInt(5, tab_permintaan.getNoRule());

        stmt.executeUpdate();
        conn.commit();
        conn.close();
    }

    public void deleteTabelPermintaan(tabelPermintaan tab_permintaan) throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "delete from tabelPermintaan where noRule = ?";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, tab_permintaan.getNoRule());

        stmt.executeUpdate();
        conn.commit();
        conn.close();
    }

    public List<tabelPermintaan> tampilTabelPermintaan() throws SQLException {
        PreparedStatement stmt = null;
        ResultSet result = null;
        conn.setAutoCommit(false);
        String query = "SELECT * FROM tabelPermintaan";
        stmt = conn.prepareStatement(query);
        result = stmt.executeQuery();
        List<tabelPermintaan> tab = new ArrayList<tabelPermintaan>();

        tabelPermintaan temp = null;
        while (result.next()) {
            temp = new tabelPermintaan();
            temp.setNoRule(result.getInt(1));
            temp.setIdKelas(result.getString(2));
            temp.setIdRuang(result.getString(3));
            temp.setHari(result.getString(4));
            temp.setJam(result.getString(5));
            tab.add(temp);
        }
        conn.close();
        return tab;
    }

    public int cariNoRule() throws SQLException {
        PreparedStatement stmt = null;
        ResultSet result = null;
        conn.setAutoCommit(false);
        String query = "SELECT IFNULL(MAX(noRule),0) FROM tabelpermintaan";
        stmt = conn.prepareStatement(query);
        result = stmt.executeQuery();
        int temp = 0;
        while (result.next()) {
            temp = result.getInt(1);
        }
        conn.close();
        return temp;
    }

    public boolean cekRuang(String idRuang, String hari, String jam) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet result = null;
        conn.setAutoCommit(false);
        String query = "SELECT TRUE FROM tabelpermintaan WHERE idRuang = ? AND Hari = ? AND Jam = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, idRuang);
        stmt.setString(2, hari);
        stmt.setString(3, jam);
        result = stmt.executeQuery();
        int temp = 0;
        while (result.next()) {
            temp = result.getInt(1);
        }
        conn.close();
        if (temp == 1) {
            return false;
        } else {
            return true;
        }
    }
}
