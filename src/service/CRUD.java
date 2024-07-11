/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

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
import model.Tugas;

/**
 *
 * @author ZAFL
 *
 */
public class CRUD {

    public CRUD() {

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

        String sqlWithValues = sql.toString();
        StringBuilder sqlDebug = new StringBuilder(sqlWithValues);

        for (Object value : values) {
            String valueStr = (value instanceof String) ? "'" + value + "'" : value.toString();
            int index = sqlDebug.indexOf("?");
            sqlDebug.replace(index, index + 1, valueStr);
        }

        System.out.println("SQL with values: " + sqlDebug.toString());

        try (PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
            for (int i = 0; i < values.length; i++) {
                stmt.setObject(i + 1, values[i]);
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Berhasil tambah data");
    }

    // Read with Join
    public List<Tugas> getAllTugasWithJoin(Connection conn) throws SQLException {
        List<Tugas> list = new ArrayList<>();
        String sql = "SELECT t.id, t.judul, t.deskripsi, t.tanggal_deadline, t.status, k.nama AS kategori, p.nama AS proyek "
                + "FROM tugas t "
                + "LEFT JOIN kategori k ON t.kategori_id = k.id "
                + "LEFT JOIN proyek p ON t.proyek_id = p.id";

        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Tugas tugas = new Tugas();
                tugas.setId(rs.getInt("id"));
                tugas.setJudul(rs.getString("judul"));
                tugas.setDeskripsi(rs.getString("deskripsi"));
                tugas.setTanggalDeadline(rs.getDate("tanggal_deadline"));
                tugas.setStatus(rs.getString("status"));
                tugas.setKategori(rs.getString("kategori"));
                tugas.setProyek(rs.getString("proyek"));
                list.add(tugas);
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
