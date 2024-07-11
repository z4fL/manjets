/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ZAFL
 */
public class MyConnection {

    private static java.sql.Connection koneksi;

    public static java.sql.Connection getConnection() throws SQLException {
        if (koneksi == null) {
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/manjets", "root", "");
        }

        return koneksi;
    }
}
