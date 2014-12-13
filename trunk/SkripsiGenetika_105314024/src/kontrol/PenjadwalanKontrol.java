/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontrol;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import kelas.KelasKuliah;
import kelas.Ruang;
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
        stmt.setString(2, Integer.toString(tab_permintaan.getIdKelas().getIdKelas()));
        stmt.setString(3, tab_permintaan.getIdRuang().getIdRuang());
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
        stmt.setString(1, Integer.toString(tab_permintaan.getIdKelas().getIdKelas()));
        stmt.setString(2, tab_permintaan.getIdRuang().getIdRuang());
        stmt.setString(3, tab_permintaan.getHari());
        stmt.setString(4, tab_permintaan.getJam());
        stmt.setInt(5, tab_permintaan.getNoRule());

        stmt.executeUpdate();
        conn.commit();
        conn.close();
    }

    public void deleteTabelPermintaan(String idKelas) throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "delete from tabelPermintaan where idKelas = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, idKelas);

        stmt.executeUpdate();
        conn.commit();
        conn.close();
    }

    public List<tabelPermintaan> tampilTabelPermintaan() throws SQLException {
        PreparedStatement stmt = null;
        ResultSet result = null;
        conn.setAutoCommit(false);
        String query = "SELECT a.idKelas,CONCAT(b.idMK,'-',c.namaMK,'-',b.Kelas) AS \"MATAKULIAH\", "
                + "e.namaDosen, CONCAT(a.idRuang,'-',d.namaRuang) AS \"RUANG\",a.Hari,a.Jam \n"
                + "FROM tabelpermintaan a,kelas_makul b,matakuliah c, ruang d, dosen e \n"
                + "WHERE a.idKelas = b.idKelas AND a.idRuang = d.idRuang AND b.idMK = c.idMK AND b.idDosen = e.idDosen;";
        stmt = conn.prepareStatement(query);
        result = stmt.executeQuery();
        List<tabelPermintaan> tab = new ArrayList<tabelPermintaan>();

        tabelPermintaan temp = null;
        while (result.next()) {
            temp = new tabelPermintaan();
            temp.setIdKelas(new KelasKuliah(result.getInt(1)));
            temp.setMatakuliah(result.getString(2));
            temp.setNamaDosen(result.getString(3));
            temp.setIdRuang(new Ruang("-", result.getString(4), "-"));
            temp.setHari(result.getString(5));
            temp.setJam(result.getString(6));
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

//    public int cariNoRule2(String idKelas) throws SQLException {
//        PreparedStatement stmt = null;
//        ResultSet result = null;
//        conn.setAutoCommit(false);
//        String query = "SELECT noRule FROM tabelpermintaan where idKelas = ?";
//        stmt = conn.prepareStatement(query);
//        stmt.setString(1, idKelas);
//        result = stmt.executeQuery();
//        int temp = 0;
//        while (result.next()) {
//            temp = result.getInt(1);
//        }
//        conn.close();
//        return temp;
//    }
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

    public List<tabelPermintaan> selectTabelPermintaan() throws SQLException {
        PreparedStatement stmt = null;
        ResultSet result = null;
        conn.setAutoCommit(false);
        String query = "SELECT * FROM tabelpermintaan";
        stmt = conn.prepareStatement(query);
        result = stmt.executeQuery();
        List<tabelPermintaan> tab = new ArrayList<tabelPermintaan>();

        tabelPermintaan temp = null;
        while (result.next()) {
            temp = new tabelPermintaan();
            temp.setNoRule(result.getInt(1));
            temp.setIdKelas(new KelasKuliah(result.getInt(2)));
            temp.setIdRuang(new Ruang(result.getString(3)));
            temp.setHari(result.getString(4));
            temp.setJam(result.getString(5));
            tab.add(temp);
        }
        conn.close();
        return tab;
    }

    //==========================UNTUK JADWAL SOLUSI============================
    public void insertJadwal(tabelPermintaan tab_permintaan) throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "INSERT INTO tabel_jadwal VALUES(?,?,?,?,?)";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, tab_permintaan.getNoRule());
        stmt.setString(2, Integer.toString(tab_permintaan.getIdKelas().getIdKelas()));
        stmt.setString(3, tab_permintaan.getIdRuang().getIdRuang());
        stmt.setString(4, tab_permintaan.getHari());
        stmt.setString(5, tab_permintaan.getJam());

        stmt.executeUpdate();
        conn.commit();
        conn.close();
    }

    public void deleteJadwal() throws SQLException {
        PreparedStatement stmt = null;
        conn.setAutoCommit(false);
        String query = "DELETE FROM tabel_jadwal";
        stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
        conn.commit();
        conn.close();
    }

    public List<tabelPermintaan> tampilTabelJadwal(int sem, String kelas) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet result = null;
        conn.setAutoCommit(false);
        String query = "SELECT a.idKelas,CONCAT(b.idMK,'-',c.namaMK,'-',b.Kelas) "
                + "AS \"MATAKULIAH\", e.namaDosen, CONCAT(a.idRuang,'-',d.namaRuang) "
                + "AS \"RUANG\",a.Hari,a.Jam \n "
                + "FROM tabel_jadwal a,kelas_makul b,matakuliah c, ruang d, dosen e \n"
                + "WHERE a.idKelas = b.idKelas AND a.idRuang = d.idRuang "
                + "AND b.idMK = c.idMK AND b.idDosen = e.idDosen "
                + "AND c.semester = ? AND b.Kelas = ?;";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, sem);
        stmt.setString(2, kelas);
        result = stmt.executeQuery();
        List<tabelPermintaan> tab = new ArrayList<tabelPermintaan>();

        tabelPermintaan temp = null;
        while (result.next()) {
            temp = new tabelPermintaan();
            temp.setIdKelas(new KelasKuliah(result.getInt(1)));
            temp.setMatakuliah(result.getString(2));
            temp.setNamaDosen(result.getString(3));
            temp.setIdRuang(new Ruang("-", result.getString(4), "-"));
            temp.setHari(result.getString(5));
            temp.setJam(result.getString(6));
            tab.add(temp);
        }
        conn.close();
        return tab;
    }

    public List<String> tampilSemesterKelas() throws SQLException {
        PreparedStatement stmt = null;
        ResultSet result = null;
        conn.setAutoCommit(false);
        String query = "SELECT b.semester,c.Kelas  \n"
                + "FROM tabel_jadwal a, matakuliah b, kelas_makul c \n"
                + "where a.idKelas = c.idKelas and c.idMK = b.idMK AND b.semester <> 0\n"
                + "GROUp by b.semester,c.Kelas;";
        stmt = conn.prepareStatement(query);
        result = stmt.executeQuery();
        List<String> tab = new ArrayList<String>();

        tabelPermintaan temp = null;
        while (result.next()) {
            tab.add(result.getString(1) + "-" + result.getString(2));
        }
        conn.close();
        return tab;
    }

    public void ExportExcel(int sem, String kelas) throws SQLException, IOException, WriteException {//punya awenk
        try {
            PreparedStatement psmt = null;
            ResultSet rset = null;
            conn.setAutoCommit(false);
            String sql = "select a.Hari,a.Jam,a.idKelas,b.Kelas,c.namaMK,"
                    + "c.semester,c.JP,d.namaDosen,e.namaRuang \n"
                    + "from tabel_jadwal a,kelas_makul b, matakuliah c, dosen d,ruang e \n"
                    + "where a.idKelas = b.idKelas AND b.idMK = c.idMK "
                    + "AND b.idDosen = d.idDosen AND a.idRuang = e.idRuang \n"
                    + "AND c.semester = ? AND b.Kelas = ?\n"
                    + "ORDER by noRule ASC;";

            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, sem);
            psmt.setString(2, kelas);
            rset = psmt.executeQuery();

            //Membuat file XLS baru bernama "output.xls"
            WritableWorkbook w = Workbook.createWorkbook(new File("JADWAL-" + sem + "-" + kelas +".xls"));
            //Membuat sheet baru bernama "Sheet Baru"
            //(kolom,baris)
            WritableSheet s = w.createSheet("Sheet 0", 0);
//            s.addCell(new Label(1, 0, "JADWAL MATAKULIAH PGSD SEMESTER "+sem+" KELAS "+kelas));
            s.addCell(new Label(0, 1, "HARI/JAM"));

            s.addCell(new Label(1, 1, "SENIN"));
            s.addCell(new Label(2, 1, "SELASA"));
            s.addCell(new Label(3, 1, "RABU"));
            s.addCell(new Label(4, 1, "KAMIS"));
            s.addCell(new Label(5, 1, "JUMAT"));

            s.addCell(new Label(0, 2, "07.00-07.50"));
            s.addCell(new Label(0, 3, "08.00-08.50"));
            s.addCell(new Label(0, 4, "09.00-09.50"));
            s.addCell(new Label(0, 5, "10.00-10.50"));
            s.addCell(new Label(0, 6, "11.00-11.50"));
            s.addCell(new Label(0, 7, "12.00-12.50"));
            s.addCell(new Label(0, 8, "13.00-13.50"));
            s.addCell(new Label(0, 9, "14.00-14.50"));
            s.addCell(new Label(0, 10, "15.00-15.50"));
            s.addCell(new Label(0, 11, "16.00-16.50"));
            s.addCell(new Label(0, 12, "17.00-17.50"));
            s.addCell(new Label(0, 13, "18.00-18.50"));

            while (rset.next()) {
                s.addCell(new Label(0, 0, "MATAKULIAH PGSD SEMESTER " + rset.getInt(6) + " KELAS " + rset.getString(4)));
                if (rset.getString(1).equals("Senin")) {
                    if (rset.getString(2).equals("07:00-09:59")) {
                        if (rset.getInt(7) < 3) {//2 jp
                            s.addCell(new Label(1, 2, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(1, 3, "IDEM"));

                        } else {//3jp
                            s.addCell(new Label(1, 2, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(1, 3, "IDEM"));
                            s.addCell(new Label(1, 4, "IDEM"));
                        }
                    }
                    if (rset.getString(2).equals("10:00-12:59")) {
                        if (rset.getInt(7) < 3) {
                            s.addCell(new Label(1, 5, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(1, 6, "IDEM"));

                        } else {
                            s.addCell(new Label(1, 5, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(1, 6, "IDEM"));
                            s.addCell(new Label(1, 7, "IDEM"));
                        }
                    }
                    if (rset.getString(2).equals("13:00-15:59")) {
                        if (rset.getInt(7) < 3) {
                            s.addCell(new Label(1, 8, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(1, 9, "IDEM"));
                        } else {
                            s.addCell(new Label(1, 8, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(1, 9, "IDEM"));
                            s.addCell(new Label(1, 10, "IDEM"));
                        }
                    }
                    if (rset.getString(2).equals("16:00-18:59")) {
                        if (rset.getInt(7) < 3) {
                            s.addCell(new Label(1, 11, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(1, 12, "IDEM"));
                        } else {
                            s.addCell(new Label(1, 11, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(1, 12, "IDEM"));
                            s.addCell(new Label(1, 13, "IDEM"));
                        }
                    }
                }
                if (rset.getString(1).equals("Selasa")) {
                    if (rset.getString(2).equals("07:00-09:59")) {
                        if (rset.getInt(7) < 3) {//2 jp
                            s.addCell(new Label(2, 2, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(2, 3, "IDEM"));

                        } else {//3jp
                            s.addCell(new Label(2, 2, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(2, 3, "IDEM"));
                            s.addCell(new Label(2, 4, "IDEM"));
                        }
                    }
                    if (rset.getString(2).equals("10:00-12:59")) {
                        if (rset.getInt(7) < 3) {
                            s.addCell(new Label(2, 5, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(2, 6, "IDEM"));
                        } else {
                            s.addCell(new Label(2, 5, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(2, 6, "IDEM"));
                            s.addCell(new Label(2, 7, "IDEM"));
                        }
                    }
                    if (rset.getString(2).equals("13:00-15:59")) {
                        if (rset.getInt(7) < 3) {
                            s.addCell(new Label(2, 8, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(2, 9, "IDEM"));
                        } else {
                            s.addCell(new Label(2, 8, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(2, 9, "IDEM"));
                            s.addCell(new Label(2, 10, "IDEM"));
                        }
                    }
                    if (rset.getString(2).equals("16:00-18:59")) {
                        if (rset.getInt(7) < 3) {
                            s.addCell(new Label(2, 11, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(2, 12, "IDEM"));
                        } else {
                            s.addCell(new Label(2, 11, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(2, 12, "IDEM"));
                            s.addCell(new Label(2, 13, "IDEM"));
                        }
                    }
                }
                if (rset.getString(1).equals("Rabu")) {
                    if (rset.getString(2).equals("07:00-09:59")) {
                        if (rset.getInt(7) < 3) {//2 jp
                            s.addCell(new Label(3, 2, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(3, 3, "IDEM"));

                        } else {//3jp
                            s.addCell(new Label(3, 2, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(3, 3, "IDEM"));
                            s.addCell(new Label(3, 4, "IDEM"));
                        }
                    }
                    if (rset.getString(2).equals("10:00-12:59")) {
                        if (rset.getInt(7) < 3) {
                            s.addCell(new Label(3, 5, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(3, 6, "IDEM"));
                        } else {
                            s.addCell(new Label(3, 5, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(3, 6, "IDEM"));
                            s.addCell(new Label(3, 7, "IDEM"));
                        }
                    }
                    if (rset.getString(2).equals("13:00-15:59")) {
                        if (rset.getInt(7) < 3) {
                            s.addCell(new Label(3, 8, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(3, 9, "IDEM"));
                        } else {
                            s.addCell(new Label(3, 8, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(3, 9, "IDEM"));
                            s.addCell(new Label(3, 10, "IDEM"));
                        }
                    }
                    if (rset.getString(2).equals("16:00-18:59")) {
                        if (rset.getInt(7) < 3) {
                            s.addCell(new Label(3, 11, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(3, 12, "IDEM"));
                        } else {
                            s.addCell(new Label(3, 11, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(3, 12, "IDEM"));
                            s.addCell(new Label(3, 13, "IDEM"));
                        }
                    }
                }
                if (rset.getString(1).equals("Kamis")) {
                    if (rset.getString(2).equals("07:00-09:59")) {
                        if (rset.getInt(7) < 3) {//2 jp
                            s.addCell(new Label(4, 2, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(4, 3, "IDEM"));

                        } else {//3jp
                            s.addCell(new Label(4, 2, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(4, 3, "IDEM"));
                            s.addCell(new Label(4, 4, "IDEM"));
                        }
                    }
                    if (rset.getString(2).equals("10:00-12:59")) {
                        if (rset.getInt(7) < 3) {
                            s.addCell(new Label(4, 5, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(4, 6, "IDEM"));
                        } else {
                            s.addCell(new Label(4, 5, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(4, 6, "IDEM"));
                            s.addCell(new Label(4, 7, "IDEM"));
                        }
                    }
                    if (rset.getString(2).equals("13:00-15:59")) {
                        if (rset.getInt(7) < 3) {
                            s.addCell(new Label(4, 8, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(4, 9, "IDEM"));
                        } else {
                            s.addCell(new Label(4, 8, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(4, 9, "IDEM"));
                            s.addCell(new Label(4, 10, "IDEM"));
                        }
                    }
                    if (rset.getString(2).equals("16:00-18:59")) {
                        if (rset.getInt(7) < 3) {
                            s.addCell(new Label(4, 11, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(4, 12, "IDEM"));
                        } else {
                            s.addCell(new Label(4, 11, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(4, 12, "IDEM"));
                            s.addCell(new Label(4, 13, "IDEM"));
                        }
                    }
                }
                if (rset.getString(1).equals("Jumat")) {
                    if (rset.getString(2).equals("07:00-09:59")) {
                        if (rset.getInt(7) < 3) {//2 jp
                            s.addCell(new Label(5, 2, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(5, 3, "IDEM"));

                        } else {//3jp
                            s.addCell(new Label(5, 2, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(5, 3, "IDEM"));
                            s.addCell(new Label(5, 4, "IDEM"));
                        }
                    }
                    if (rset.getString(2).equals("10:00-12:59")) {
                        if (rset.getInt(7) < 3) {
                            s.addCell(new Label(5, 5, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(5, 6, "IDEM"));
                        } else {
                            s.addCell(new Label(5, 5, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(5, 6, "IDEM"));
                            s.addCell(new Label(5, 7, "IDEM"));
                        }
                    }
                    if (rset.getString(2).equals("13:00-15:59")) {
                        if (rset.getInt(7) < 3) {
                            s.addCell(new Label(5, 8, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(5, 9, "IDEM"));
                        } else {
                            s.addCell(new Label(5, 8, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(5, 9, "IDEM"));
                            s.addCell(new Label(5, 10, "IDEM"));
                        }
                    }
                    if (rset.getString(2).equals("16:00-18:59")) {
                        if (rset.getInt(7) < 3) {
                            s.addCell(new Label(5, 11, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(5, 12, "IDEM"));
                        } else {
                            s.addCell(new Label(5, 11, rset.getString(5) + " (" + rset.getString(4) + ") \n" + rset.getString(8) + "\n" + rset.getString(9)));
                            s.addCell(new Label(5, 12, "IDEM"));
                            s.addCell(new Label(5, 13, "IDEM"));
                        }
                    }
                }
            }   //Menulis data ke excell shet
            w.write();
            //Menutup sambungan
            w.close();

            conn.commit();
        } catch (WriteException ex) {
            Logger.getLogger(PenjadwalanKontrol.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PenjadwalanKontrol.class.getName()).log(Level.SEVERE, null, ex);
        }
        //        return st;
    }
}
