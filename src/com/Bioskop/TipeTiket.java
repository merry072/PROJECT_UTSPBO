package com.Bioskop;
public class TipeTiket {

    //deklarai variabel private (-)
    private String jenisStudio;

    //constructor public dengan parameter jenisStudio
    public TipeTiket(String jenisStudio) {
        this.jenisStudio = jenisStudio;
    }

    /*setter
    untuk nge-set variabel (jenisStudio) yang bersifat private*/
    public void setJenisStudio(String jenisStudio) {
        this.jenisStudio = jenisStudio;
    }

    /*getter
    untuk mengambil/membaca variabel (jenisStudio) yang bersifat private*/
    public String getJenisStudio() {
        return jenisStudio;
    }
}