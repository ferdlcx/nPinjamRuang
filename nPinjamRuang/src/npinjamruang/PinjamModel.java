/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npinjamruang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dyana
 */
public class PinjamModel {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    public void insertData(String nama, String tanggal, String jamMulai, String jamSelesai, String keperluan) {
        try {
            conn = new npinjamruang.Koneksi().connect();

            String sql = "INSERT INTO peminjaman (nama, tanggal, jam_mulai, jam_selesai, keperluan) VALUES (?, ?, ?, ?, ?)";

            pst = conn.prepareStatement(sql);
            pst.setString(1, nama);
            pst.setString(2, tanggal);
            pst.setString(3, jamMulai);
            pst.setString(4, jamSelesai);
            pst.setString(5, keperluan);

            pst.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan.");
            conn.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PinjamModel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Gagal menyimpan data.");
        }
    }
}
