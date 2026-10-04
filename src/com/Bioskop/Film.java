package com.Bioskop;

public abstract class Film extends TipeTiket {
    //deklarasi variabel private (-)
    private String judulFilm;
    private String namaMall;

    //constructor public dengan parameter jenisStudio, judulFilm, namaMall
    public Film(String jenisStudio, String judulFilm, String namaMall) {
        super(jenisStudio); //menghubungkan ke variabel super jenisStudio di class TipeTiket
        this.judulFilm = judulFilm;
        this.namaMall = namaMall;
    }

    /*setter
    untuk nge-set variabel (judulFilm dan namaMall) yang bersifat private*/
    public void setJudulFilm(String judulFilm) {
        this.judulFilm = judulFilm;
    }

    public void setNamaMall(String namaMall) {
        this.namaMall = namaMall;
    }

    /*getter
    untuk mengambil/membaca variabel (judulFilm dan namaMall) yang bersifat private*/
    public String getJudulFilm() {
        return judulFilm;
    }

    public String getNamaMall() {
        return namaMall;
    }

    //abstract method untuk menghitung harga tiketnya
    public abstract int HitungHargaTiket();
}