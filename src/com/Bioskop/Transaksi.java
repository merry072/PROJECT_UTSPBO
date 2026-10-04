package com.Bioskop;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Transaksi implements Tiket {
        //deklarasi variabel private (-)
        private float harga;
        private String noTransaksi;
        private String waktuCetak;
        private MetodePembayaran ObjMetode; //memanggil class MetodePembayaran melalui var ObjMetode
        private ArrayList<Studio> listStudio; //menyimpan object studio dengan ArrayList

        //constructor public dengan parameter harga, noTransaksi, waktuCetak
        public Transaksi(float harga, String noTransaksi, String waktuCetak) {
                this.harga = harga;
                this.noTransaksi = noTransaksi;
                this.waktuCetak = waktuCetak;
                ObjMetode = new MetodePembayaran();
                listStudio = new ArrayList<>();
        }

        /*setter
        untuk nge-set variabel (harga, noTransaksi, waktuCetak) yang bersifat private*/
        public void setHarga(float harga) {
                this.harga = harga;
        }

        public void setNoTransaksi(String noTransaksi) {
                this.noTransaksi = noTransaksi;
        }

        public void setWaktuCetak(String waktuCetak) {
                this.waktuCetak = waktuCetak;
        }

        /*getter
        untuk mengambil/membaca variabel (harga, noTransaksi, waktuCetak) yang bersifat private*/
        public float getHarga() {
                return harga;
        }

        public String getNoTransaksi() {
                return noTransaksi;
        }

        public String getWaktuCetak() {
                return waktuCetak;
        }

        public MetodePembayaran getObjMetode() {
                return ObjMetode;
        }

        //mambahkan objek studio ke dalam arraylist
        public void tambahStudio(Studio studio) {
                listStudio.add(studio);
        }

        //ambil list studio untuk di return
        public ArrayList<Studio> getListStudio() {
                return listStudio;
        }

        //implementasi interface Tiket 
        //override methods
        public void CetakTiket() {
                System.out.println("=== TRANSAKSI ===");
                System.out.println("No Transaksi : " + noTransaksi);
                System.out.println("Harga : Rp" + harga);
                System.out.println("Waktu Cetak : " + waktuCetak);
                System.out.println("Pembayaran : " + ObjMetode.getTipePembayaran());
        }

        //untuk simpan hasil historynya (object studio dan transaksi) ke dalam txt 
        public void simpanHistory() {
                try {
                FileWriter file = new FileWriter("HistoryTiket.txt", true);

                //header transaksi
                file.write("\n");
                file.write("========================================\n");
                file.write("          DETAIL TRANSAKSI\n");
                file.write("========================================\n");
                file.write("No. Transaksi : " + noTransaksi + "\n");
                file.write("Waktu Cetak   : " + waktuCetak + "\n");
                file.write("----------------------------------------\n");
                file.write("Jumlah Tiket  : " + listStudio.size() + "\n");
                file.write("Total Harga   : Rp " + String.format("%,.0f", harga) + "\n");
                file.write("Pembayaran    : " + ObjMetode.getTipePembayaran() + "\n");

                file.write("----------------------------------------\n");
                file.write("              DATA TIKET\n");
                file.write("----------------------------------------\n");


                //menyimpan setiap data Studio
                for (Studio studio : listStudio) {
                        file.write("\n");
                        file.write("           " + studio.getNamaMall() + "\n");
                        file.write(studio.getJudulFilm() + "\n");
                        file.write("Jenis Studio: " + studio.getJenisStudio() + "\n");
                        file.write("Date: " + studio.getTanggal() + "\n");
                        file.write("Time: " + studio.getJam() + "\n");
                        file.write("Nomor Studio: " + studio.getStudio() + "\n");
                        file.write("Row: " + studio.getBaris() + "     Seat: " + studio.getKolom() + "\n");
                        file.write("Price: Rp " + String.format("%,.0f", (float) studio.HitungHargaTiket()) + "\n");
                        file.write("No. Transaksi : " + noTransaksi + "\n");
                        file.write("----------------------------------------\n");
                }

                //menutup file
                file.close();

                } catch (IOException e) {
                System.out.println("Gagal menyimpan HistoryTiket.txt");
                System.out.println(e.getMessage());
                }
        }
}