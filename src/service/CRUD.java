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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

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

    public List<Map<String, Object>> getListComboBox(Connection conn, String tableName) throws SQLException {
        List<Map<String, Object>> list = new ArrayList<>();
        String sql = "SELECT id, nama FROM " + tableName;
        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>(columns);
                for (int i = 1; i <= columns; ++i) {
                    row.put(md.getColumnName(i), rs.getObject(i));
                }
                list.add(row);
            }

        } catch (SQLException ex) {
            System.err.println("Error in getList " + ex.getMessage());
        } finally {
            conn.close();
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
