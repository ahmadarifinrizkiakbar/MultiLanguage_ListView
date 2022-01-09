package com.example.multilanguage_listview.model;


import java.io.Serializable;

public class Hewan implements Serializable {
    private String jenis;
    private String ras;
    private String latin;
    private String deskripsi;
    private int drawableRes;

    public Hewan(String jenis, String ras, String latin, String deskripsi, int drawableRes) {
        this.jenis = jenis;
        this.ras = ras;
        this.latin = latin;
        this.deskripsi = deskripsi;
        this.drawableRes = drawableRes;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getRas() {
        return ras;
    }

    public void setRas(String ras) {
        this.ras = ras;
    }

    public String getLatin() {
        return latin;
    }

    public void setLatin(String latin) {
        this.latin = latin;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getDrawableRes() {
        return drawableRes;
    }

    public void setDrawableRes(int drawableRes) {
        this.drawableRes = drawableRes;
    }
}
