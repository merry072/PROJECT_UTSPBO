package com.Bioskop;

public class Studio extends Film implements Tiket {
    //deklarasi variabel private (-)
    private String tanggal;
    private String jam;
    private int studio;
    private int kolom;
    private String baris;

    //constructor public dengan parameter jenisStudio, judulFilm, namaMall, tanggal, jam, studio, kolom, baris
    public Studio(String jenisStudio, String judulFilm, String namaMall, String tanggal, String jam, int studio, int kolom, String baris) {
        super(jenisStudio, judulFilm, namaMall); //menghubungkan ke variabel super jenisStudio, judulFilm, namaMall di class Tiket
        this.tanggal = tanggal;
        this.jam = jam;
        this.studio = studio;
        this.kolom = kolom;
        this.baris = baris;
    }

    /*setter
    untuk nge-set variabel (tanggal, jam, studio, kolom, baris) yang bersifat private*/
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public void setStudio(int studio) {
        this.studio = studio;
    }

    public void setKolom(int kolom) {
        this.kolom = kolom;
    }

    public void setBaris(String baris) {
        this.baris = baris;
    }

    /*getter
    untuk mengambil/membaca variabel (tanggal, jam, studio, kolom, baris) yang bersifat private*/
    public String getTanggal() {
        return tanggal;
    }

    public String getJam() {
        return jam;
    }

    public int getStudio() {
        return studio;
    }

    public int getKolom() {
        return kolom;
    }

    public String getBaris() {
        return baris;
    }

    //perhitungan abstract method HitungHargaTiket
    public int HitungHargaTiket() {
    if (getJenisStudio().equalsIgnoreCase("Reguler")) {
        return 50000;
    } else if(getJenisStudio().equalsIgnoreCase("Premiere")) {
        return 100000;
    } else {
        return 150000; //IMAX
    }
}

    //implementasi interface Tiket 
    //override methods
    public void CetakTiket() {
        System.out.println("=== TIKET ===");
        System.out.println("Film    : " + getJudulFilm());
        System.out.println("Mall    : " + getNamaMall());
        System.out.println("Tanggal : " + tanggal);
        System.out.println("Jam     : " + jam);
        System.out.println("Studio  : " + studio);
        System.out.println("Kursi   : " + baris + kolom);
    }
}