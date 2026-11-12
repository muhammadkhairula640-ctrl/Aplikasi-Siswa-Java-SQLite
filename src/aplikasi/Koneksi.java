/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package aplikasi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Koneksi {

    public static Connection getKoneksi() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:siswa.db");

        try (Statement st = conn.createStatement()) {
            st.execute("CREATE TABLE IF NOT EXISTS siswa ("
                    + "nis TEXT PRIMARY KEY, "
                    + "nama TEXT NOT NULL, "
                    + "kelas TEXT, "
                    + "alamat TEXT)");
        }

        return conn;
    }
}