/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tabel;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Tugas;

/**
 *
 * @author ZAFL
 */
public class TugasTableModel extends AbstractTableModel {

    private final List<Tugas> tugasList;
    private final String[] columnNames = {"No", "ID", "Kategori", "Judul", "Deskripsi", "Tanggal Deadline", "Status", "Proyek"};

    public TugasTableModel(List<Tugas> tugasList) {
        this.tugasList = tugasList;
    }

    public void addRow(Tugas tugas) {
        tugasList.add(tugas);
        fireTableRowsInserted(getRowCount(), getRowCount());
    }

    public void removeRow(int firstRow, int lastRow) {
        tugasList.remove(firstRow);
        fireTableRowsDeleted(firstRow, lastRow);
    }

    public void removeAll() {
        int size = tugasList.size();
        tugasList.clear();
        fireTableRowsDeleted(0, size);
    }

    @Override
    public int getRowCount() {
        return tugasList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tugas tugas = tugasList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return tugas.getId();
            case 2:
                return tugas.getKategori();
            case 3:
                return tugas.getJudul();
            case 4:
                return tugas.getDeskripsi();
            case 5:
                return tugas.getTanggalDeadline();
            case 6:
                return tugas.getStatus();
            case 7:
                return tugas.getProyek();
            default:
                return null;
        }
    }
}
