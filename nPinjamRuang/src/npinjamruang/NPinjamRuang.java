/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package npinjamruang;
import java.sql.SQLException;

/**
 *
 * @author dyana
 */
public class NPinjamRuang {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, 
            SQLException {
                // TODO code application logic here
        new Koneksi().connect();
        new LoginPage().setVisible(true);
    }
}
