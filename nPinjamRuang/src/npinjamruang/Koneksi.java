/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npinjamruang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dyana
 */
public class Koneksi {

    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_NAME = "pinjam_ruang";
    private final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
    private final String USER = "root";
    private final String PASS = "";
    Connection conn;

    public Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        System.out.println("Koneksi sukses!");
        return conn;
    }
}

