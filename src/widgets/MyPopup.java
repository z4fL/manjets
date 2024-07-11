/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package widgets;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import view.DialogTugas;
import view.TugasView;

/**
 *
 * @author ZAFL
 */
public class MyPopup extends JPopupMenu {

    private JMenuItem editMenuItem;
    private JMenuItem deleteMenuItem;
    private TugasView tugasView;

    public MyPopup(TugasView tugasView) {
        this.tugasView = tugasView;
        // Tambahkan menu Edit
        editMenuItem = new JMenuItem("Edit");
        editMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action untuk Edit
                System.out.println("Edit menu clicked");
                // Tambahkan logika untuk Edit di sini
                editDialog();
            }
        });
        add(editMenuItem);

        // Tambahkan menu Hapus
        deleteMenuItem = new JMenuItem("Hapus");
        deleteMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action untuk Hapus
                System.out.println("Hapus menu clicked");
                // Tambahkan logika untuk Hapus di sini
            }
        });
        add(deleteMenuItem);
    }

    private void editDialog() {
        int baris = tugasView.getSelectedRow();
        DialogTugas dialogTugas = new DialogTugas((java.awt.Frame) SwingUtilities.getWindowAncestor(tugasView), tugasView, true);
        tugasView.getSelectedRow();
        if (baris != -1) {
            dialogTugas.setID(tugasView.tableTugas.getValueAt(baris, 1).toString());
            if (tugasView.tableTugas.getValueAt(baris, 2) != null) {
                dialogTugas.setKategori(tugasView.tableTugas.getValueAt(baris, 2).toString());
            }
            dialogTugas.setJudul(tugasView.tableTugas.getValueAt(baris, 3).toString());
            dialogTugas.setDeskripsi(tugasView.tableTugas.getValueAt(baris, 4).toString());
            dialogTugas.setDeadline(tugasView.tableTugas.getValueAt(baris, 5).toString());
            dialogTugas.setStatus(tugasView.tableTugas.getValueAt(baris, 6).toString());
            if (tugasView.tableTugas.getValueAt(baris, 7) != null) {
                dialogTugas.setProyek(tugasView.tableTugas.getValueAt(baris, 7).toString());
            }

            dialogTugas.isOnEdit = true;
            dialogTugas.jLabel7.setVisible(true);
            dialogTugas.comboBoxStatus.setVisible(true);
            dialogTugas.setLocationRelativeTo(null);
            dialogTugas.setVisible(true);
        }
    }
}
