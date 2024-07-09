/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZAFL
 * @param <T>
 */
public class CRUD<T> {

    private final Class<T> type;

    public CRUD(Class<T> type) {
        this.type = type;
    }

    public void tambah(Connection conn, String tableName, String[] columns, Object[] values) throws SQLException {
        StringBuilder sql = new StringBuilder("INSERT INTO " + tableName + " (");
        for (String column : columns) {
            sql.append(column).append(",");
        }
        sql.setLength(sql.length() - 1); // Remove last comma
        sql.append(") VALUES (");
        for (int i = 0; i < values.length; i++) {
            sql.append("?,");
        }
        sql.setLength(sql.length() - 1); // Remove last comma
        sql.append(")");

        try (PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
            for (int i = 0; i < values.length; i++) {
                stmt.setObject(i + 1, values[i]);
            }
            stmt.executeUpdate();
        }
    }

    public List getAll(Connection conn, String tableName) throws SQLException, IllegalAccessException, InstantiationException {
        List list = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName;

        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                T instance = type.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    field.setAccessible(true);
                    field.set(instance, rs.getObject(field.getName()));
                }
                list.add(instance);
            }
        }
        return list;
    }

    public void update(Connection conn, String tableName, String[] columns, Object[] values, String idColumn, Object idValue) throws SQLException {
        StringBuilder sql = new StringBuilder("UPDATE " + tableName + " SET ");
        for (String column : columns) {
            sql.append(column).append("=?,");
        }
        sql.setLength(sql.length() - 1); // Remove last comma
        sql.append(" WHERE ").append(idColumn).append("=?");

        try (PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
            for (int i = 0; i < values.length; i++) {
                stmt.setObject(i + 1, values[i]);
            }
            stmt.setObject(values.length + 1, idValue);
            stmt.executeUpdate();
        }
    }

    public void delete(Connection conn, String tableName, String idColumn, Object idValue) throws SQLException {
        String sql = "DELETE FROM " + tableName + " WHERE " + idColumn + "=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, idValue);
            stmt.executeUpdate();
        }
    }

}
