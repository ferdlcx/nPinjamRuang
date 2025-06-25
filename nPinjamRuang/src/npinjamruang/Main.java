/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npinjamruang;
import com.formdev.flatlaf.FlatLightLaf;

public class Main {
    public static void main(String[] args) {
        try {
        // Aktifkan FlatLaf
        FlatLightLaf.setup();
    } catch (Exception ex) {
        System.err.println("Gagal memuat FlatLaf");
    }
    }
}
