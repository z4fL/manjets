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
public class CBKategoriModel {

    private int id;
    private String nama;

    public CBKategoriModel() {

    }

    public CBKategoriModel(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        if (obj instanceof CBKategoriModel) {
            CBKategoriModel comboBoxItem = (CBKategoriModel) obj;
            return comboBoxItem.getNama().equals(getNama());
        } else if (obj instanceof String) {
            return nama.equals(obj);
        } else {
            return super.equals(obj);
        }
    }

}
