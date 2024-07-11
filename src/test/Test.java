package test;

import database.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import model.Kategori;
import service.CRUD;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ZAFL
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            Connection.getConnection();

        } catch (SQLException e) {
            System.out.println("Error Koneksi");
            e.printStackTrace();
        }

    }

}
