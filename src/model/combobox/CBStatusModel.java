/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.combobox;

/**
 *
 * @author ZAFL
 */
public class CBStatusModel {

    private String nama;

    public CBStatusModel() {
    }

    public CBStatusModel(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return nama;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof CBStatusModel) {
            CBStatusModel comboBoxItem = (CBStatusModel) obj;
            return comboBoxItem.getNama().equals(getNama());
        } else if (obj instanceof String) {
            return nama.equals(obj);
        } else {
            return super.equals(obj);
        }
    }

}
