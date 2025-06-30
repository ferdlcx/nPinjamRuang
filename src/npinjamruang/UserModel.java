/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npinjamruang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dyana
 */
public class UserModel {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    public int getUserIdByName(String username) {
        int id = -1;
        try {
            Connection conn = new Koneksi().connect();
            String sql = "SELECT id FROM users WHERE username = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
  


    public void login(String username, String pass, LoginPage lp)
            throws ClassNotFoundException, SQLException {

        conn = new Koneksi().connect();
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        pst = conn.prepareStatement(query);
        pst.setString(1, username);
        pst.setString(2, pass);

        rs = pst.executeQuery();
        if (rs.next()) {
            // debug sistem
            System.out.println("Login Berhasil");

            String namaUser = rs.getString("username"); // panggil username
            JOptionPane.showMessageDialog(null, "Login berhasil. Selamat datang, " + namaUser + "!");

            System.out.println("username: " + rs.getString("username")); // debug sistem
            System.out.println("password: " + rs.getString("password")); // debug sistem

            lp.dispose();
            MainMenu d = new MainMenu();
            d.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Login gagal, harap periksa username dan password");
            System.out.println("Login gagal, Data tidak ada"); // debug sistm
        }

        rs.close();
        pst.close();
        conn.close();
    }
}
