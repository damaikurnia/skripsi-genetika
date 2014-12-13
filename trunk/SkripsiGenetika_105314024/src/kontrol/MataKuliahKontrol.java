package kontrol;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import kelas.KelasKuliah;
import koneksi.Koneksi;
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
        String query = "SELECT * FROM matakuliah WHERE idMK <> \"-\" ORDER BY semester";
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

    public static int cariSemester(String idMK, List<MataKuliah> makul) {
        int semester = 0;
        for (int i = 0; i < makul.size(); i++) {
            if (makul.get(i).getIdMK().equals(idMK)) {
                semester = makul.get(i).getSemester();
            }
        }
        return semester;
    }
  
    public static List<String> cariKelompokKelas(List<KelasKuliah> kk, List<MataKuliah> mk){
        List<KelasKuliah> klsKul = kk;
        for (int i = 0; i < klsKul.size(); i++) {//satukan dlu kls kul dan matkul
            for (int j = 0; j < mk.size(); j++) {
                if (klsKul.get(i).getIdMK().getIdMK().equals(mk.get(j).getIdMK())) {
                    klsKul.get(i).setIdMK(mk.get(j));
                }
            }
        }

        List<String> kel = new ArrayList<String>();
        for (int i = 0; i < klsKul.size(); i++) {
            if (kel.size() == 0) {
                kel.add(klsKul.get(i).getIdMK().getSemester() + "-" + klsKul.get(i).getKelas()+"-0");
            } else {
                boolean cek = false;
                for (int j = 0; j < kel.size(); j++) {
                    int semester = klsKul.get(i).getIdMK().getSemester();
                    String kelas = klsKul.get(i).getKelas();
                    
                    if (semester==Integer.parseInt(kel.get(j).split("-")[0])&&
                            kelas.equals(kel.get(j).split("-")[1])) {
                        cek = true;
                    } else {
                        cek = cek;
                    }
                }
                if (cek == false) {
                    kel.add(klsKul.get(i).getIdMK().getSemester() + "-" + klsKul.get(i).getKelas()+"-0");
                }
            }
        }
        return kel;
    }
    
    public boolean cekMatakuliah(String key) throws SQLException {
        PreparedStatement psmt = null;
        ResultSet rset = null;
        conn.setAutoCommit(false);
        String sql = "select TRUE from matakuliah where idMK = ?";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, key);
        rset = psmt.executeQuery();
        boolean result = false;
        while (rset.next()) {
            if(rset.getInt(1)== 1){
                result = true;
            }
        }
        conn.commit();
        conn.close();
        return result;
    }
}
