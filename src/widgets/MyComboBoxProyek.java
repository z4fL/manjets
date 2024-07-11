/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package widgets;

import javax.swing.JComboBox;
import model.combobox.CBProyekModel;

/**
 *
 * @author ZAFL
 */
public class MyComboBoxProyek extends JComboBox<CBProyekModel> {

    public MyComboBoxProyek() {
        super();
    }

    @Override
    public void addItem(CBProyekModel item) {
        super.addItem(item);
    }

    public void removeItem(CBProyekModel item) {
        super.removeItem(item);
    }

    public boolean containsItem(CBProyekModel item) {
        for (int i = 0; i < getItemCount(); i++) {
            if (getItemAt(i).equals(item)) {
                return true;
            }
        }
        return false;
    }

    public CBProyekModel getItemByName(String name) {
        for (int i = 0; i < getItemCount(); i++) {
            Object item = getItemAt(i);
            if (item instanceof CBProyekModel && ((CBProyekModel) item).getNama().equals(name)) {
                return (CBProyekModel) item;
            }
        }
        return null;
    }
}
