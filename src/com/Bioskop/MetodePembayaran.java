package com.Bioskop;

public class MetodePembayaran {
    //deklarasi variabel private (-)
    private String tipePembayaran;

    //constructor public 
    public MetodePembayaran() {
        this.tipePembayaran = ""; //memberikan nilai awal string kosong
    }

    /*setter
    untuk nge-set variabel (tipePembayaran) yang bersifat private*/
    public void setTipePembayaran(String tipePembayaran) {
        this.tipePembayaran = tipePembayaran;
    }

    /*getter
    untuk mengambil/membaca variabel (tipePembayaran) yang bersifat private*/
    public String getTipePembayaran() {
        return tipePembayaran;
    }
}