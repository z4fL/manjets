/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author ZAFL
 */
public class Tugas {

    private int id;
    private String judul;
    private String deskripsi;
    private Date tanggalDeadline;
    private String prioritas;
    private String status;
    private String kategori;
    private String proyek;

    // Constructors
    public Tugas() {
    }

    public Tugas(int id, String judul, String deskripsi, Date tanggalDeadline, String prioritas, String status, String kategoriId, String proyekId) {
        this.id = id;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.tanggalDeadline = tanggalDeadline;
        this.prioritas = prioritas;
        this.status = status;
        this.kategori = kategoriId;
        this.proyek = proyekId;
    }

    public Tugas(String judul, String deskripsi, Date tanggalDeadline, String prioritas, String status, String kategoriId, String proyekId) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.tanggalDeadline = tanggalDeadline;
        this.prioritas = prioritas;
        this.status = status;
        this.kategori = kategoriId;
        this.proyek = proyekId;
    }
    
    

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Date getTanggalDeadline() {
        return tanggalDeadline;
    }

    public void setTanggalDeadline(Date tanggalDeadline) {
        this.tanggalDeadline = tanggalDeadline;
    }

    public String getPrioritas() {
        return prioritas;
    }

    public void setPrioritas(String prioritas) {
        this.prioritas = prioritas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getProyek() {
        return proyek;
    }

    public void setProyek(String proyek) {
        this.proyek = proyek;
    }

    
}
