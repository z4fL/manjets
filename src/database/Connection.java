/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;

/**
 *
 * @author ZAFL
 */
public class Connection {
    private static java.sql.Connection koneksi;
    
    public static java.sql.Connection getConnection() throws SQLException {
        if (koneksi == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/manjets");
            dataSource.setUser("root");
            dataSource.setPassword("");
            
            koneksi = dataSource.getConnection();
        }
        
        return koneksi;
    }
}
