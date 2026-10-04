import com.Bioskop.MovieList;
import com.Bioskop.Studio;
import com.Bioskop.Transaksi;
import com.Bioskop.MovieList;

import java.util.Scanner;
import java.text.SimpleDateFormat; //tambahan import untuk mengatur format
import java.util.Date; //tambahan import untuk timestamp date

public class App {
public static void main(String[] args) {
        App app = new App();

        app.jalankanProgram();
}
        public void jalankanProgram() {
                //untuk input
                Scanner input = new Scanner(System.in);

                //menginput data bioskopnya
                System.out.println("=================================");
                System.out.println("       SISTEM TIKET BIOSKOP");
                System.out.println("=================================");

                System.out.print("Masukkan jenis studio : ");
                String jenisStudio = input.nextLine();

                //membuat object MovieList
                MovieList movieList = new MovieList();

                //membaca daftar film dari MovieList.txt
                movieList.bacaMovie();

                //menampilkan daftar film
                movieList.tampilkanMovie();

                //user memilih film berdasarkan nomor
                System.out.print("Pilih nomor film      : ");
                int pilihanFilm = input.nextInt();
                input.nextLine();

                //mengambil judul film berdasarkan pilihan user
                String judulFilm = movieList.getListFilm().get(pilihanFilm - 1).getJudulFilm();

                System.out.print("Masukkan nama mall    : ");
                String namaMall = input.nextLine();


                //set nomor transaksi dan waktu cetak 
                String noTransaksi = "TRX001";
                String waktuCetak = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());

                //jumlah tiket yang ingin dipesan
                System.out.print("Masukkan jumlah tiket : ");
                int jumlahStudio = input.nextInt();

                input.nextLine();

                //metode pembayaran
                System.out.println("Pilihan Metode Pembayaran: CC/DC/CASH/MTIX ");
                System.out.print("Masukkan metode pembayaran : ");
                String pembayaran = input.nextLine();

                //data tiket
                System.out.print("Tanggal      : ");
                String tanggal = input.nextLine();

                System.out.print("Jam          : ");
                String jam = input.nextLine();

                System.out.print("Nomor Studio : ");
                int nomorStudio = input.nextInt();


                //OBJECT TRANSAKSI
                //set harga sementara 0
                Transaksi transaksi = new Transaksi(0, noTransaksi, waktuCetak);

                //membuat/set metode pembayaran
                transaksi.getObjMetode().setTipePembayaran(pembayaran);

                //harga tiket
                float hargaTiket = 0;

                //input data tiket sesuai jumlah yang dimasukkan sebelumnya
                for (int i = 1; i <= jumlahStudio; i++) {
                        System.out.println();
                        System.out.println("---------------------------------");
                        System.out.println("       DATA TIKET KE-" + i);
                        System.out.println("---------------------------------");

                        System.out.print("Seat        : ");
                        int kolom = input.nextInt();

                        input.nextLine();

                        System.out.print("Row         : ");
                        String baris = input.nextLine();


                        //OBJECT STUDIO
                        Studio studio = new Studio(jenisStudio, judulFilm, namaMall, tanggal, jam, nomorStudio, kolom, baris);
                        
                        //memanggil abstract method
                        hargaTiket = studio.HitungHargaTiket();

                        //memasukkan studio ke transaksi
                        transaksi.tambahStudio(studio);
                }

                //menghitung total harga
                float harga = hargaTiket * jumlahStudio;
                transaksi.setHarga(harga);


                //mencetak detail transaksinya
                System.out.println();
                System.out.println("========================================");
                System.out.println("          DETAIL TRANSAKSI");
                System.out.println("========================================");

                System.out.println("No. Transaksi : " + transaksi.getNoTransaksi());
                System.out.println("Waktu Cetak   : " + transaksi.getWaktuCetak());
                System.out.println("----------------------------------------");

                System.out.println("Jumlah Tiket  : " + jumlahStudio);
                System.out.println("Harga/Tiket   : Rp " + String.format("%,.0f", hargaTiket));
                System.out.println("Total Harga   : Rp " + String.format("%,.0f", transaksi.getHarga()));
                System.out.println("Pembayaran    : " + transaksi.getObjMetode().getTipePembayaran());

                System.out.println("----------------------------------------");
                System.out.println("              DATA TIKET");
                System.out.println("----------------------------------------");


                //mencetak tiket
                for (int i = 0; i < transaksi.getListStudio().size(); i++) {
                Studio studio = transaksi.getListStudio().get(i);
                System.out.println();
                System.out.println("             " + studio.getNamaMall());
                System.out.println(studio.getJudulFilm());
                System.out.println("Jenis Studio: " + studio.getJenisStudio());
                System.out.println("Date: " + studio.getTanggal());
                System.out.println("Time: " + studio.getJam());
                System.out.println("Nomor Studio: " + studio.getStudio());
                System.out.println("Row: " + studio.getBaris() + "      Seat: " + studio.getKolom());
                System.out.println("Price: Rp " + String.format("%,.0f", hargaTiket));
                System.out.println("No. Transaksi : " + transaksi.getNoTransaksi());
                System.out.println("----------------------------------------");
                }

                //simpen data ke txt
                transaksi.simpanHistory();

                System.out.println();
                System.out.println("Data transaksi berhasil disimpan ke HistoryTiket.txt");
        }
}
