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
import javax.swing.table.DefaultTableModel;

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

    public void showData(DefaultTableModel dtm) {
        // block statement try & catch
        try {
            conn = new npinjamruang.Koneksi().connect();
            // query untuk mengambil semua data produk
            String sql = "SELECT * FROM peminjaman";
            // jalankan statement
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            // looping data
            while (rs.next()) {
                // simpan setiap nilai pada kolom ke dalam objek data
                Object[] data = {
                    rs.getString("id"),
                    rs.getString("nama"),
                    rs.getString("tanggal"),
                    rs.getString("jam_mulai"),
                    rs.getString("jam_selesai"),
                    rs.getString("keperluan"),};

// tambahkan pada model table model dengan data dari objek data
                dtm.addRow(data);
            }
//           hentikan koneksi
            rs.close();
            conn.close();
        } catch (ClassNotFoundException ex) {
            // untuk handling error class not found
            Logger.getLogger(PinjamModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            // untuk handling error class sql exception
            Logger.getLogger(PinjamModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteData(Integer id) {
        try {
            conn = new Koneksi().connect();

            String sql = "DELETE FROM peminjaman"
                    + " WHERE Id=?";

            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Sukses delete data");
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PinjamModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PinjamModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void searchData(DefaultTableModel dtm, String cari) {
        try {
            conn = new Koneksi().connect();
            //    searching data berdasarkan nama produk atau kategori produk
            String sql = "SELECT * FROM peminjaman WHERE "
           + "nama LIKE ? OR "
           + "tanggal LIKE ? OR "
           + "jam_mulai LIKE ? OR "
           + "jam_selesai LIKE ? OR "
           + "keperluan LIKE ?";

            pst = conn.prepareStatement(sql);
            //    gunakan percent sebelum variable untuk mencari nama
            pst.setString(1, "%" + cari + "%");
            pst.setString(2, "%" + cari + "%");
            pst.setString(3, "%" + cari + "%");
            pst.setString(4, "%" + cari + "%");
            pst.setString(5, "%" + cari + "%");
           


            rs = pst.executeQuery();
//             looping data
            while (rs.next()) {

                Object[] data = {
                     rs.getString("id"),
                    rs.getString("nama"),
                    rs.getString("tanggal"),
                    rs.getString("jam_mulai"),
                    rs.getString("jam_selesai"),
                    rs.getString("keperluan"),};

                dtm.addRow(data);
            }
            rs.close();
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PinjamModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PinjamModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
