/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package koneksi;
import java.sql.*;

public class Koneksi {

    private static String jdbcURL = "jdbc:mysql://localhost:3306/pgsd";
    private static String user = "root";
    private static String password = "";
    private static Connection connection = null;

    public static Connection getKoneksi() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            connection = DriverManager.getConnection(jdbcURL, user, password);
//            System.out.println("koneksi berhasil");
            return connection;
        } catch (Exception ex) {
            System.out.println("message: " + ex.getMessage() + "\nTidak konek");
            return null;
        }
    }

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        Koneksi proses = new Koneksi();
        proses.getKoneksi();
    }
}

