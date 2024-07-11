/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package widgets;

import model.combobox.CBKategoriModel;

/**
 *
 * @author ZAFL
 */
import javax.swing.JComboBox;

public class MyComboBoxKategori extends JComboBox<CBKategoriModel> {

    public MyComboBoxKategori() {
        super();
    }

    @Override
    public void addItem(CBKategoriModel item) {
        super.addItem(item);
    }

    @Override
    public void removeItem(Object anObject) {
        if (anObject instanceof CBKategoriModel) {
            super.removeItem(anObject);
        }
    }

    public boolean containsItem(CBKategoriModel item) {
        for (int i = 0; i < getItemCount(); i++) {
            if (getItemAt(i).equals(item)) {
                return true;
            }
        }
        return false;
    }

    public CBKategoriModel getItemByName(String name) {
        for (int i = 0; i < getItemCount(); i++) {
            CBKategoriModel item = getItemAt(i);
            if (item.getNama().equals(name)) {
                return item;
            }
        }
        return null;
    }
}
