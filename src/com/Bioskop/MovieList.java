package com.Bioskop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieList {
    //arraylist untuk menyimpan list film yang ada
    private ArrayList<Film> listFilm;

    //constructor public 
    public MovieList() {
        listFilm = new ArrayList<>();
    }

    //membaca data film yang sedang tayang dari file MovieList.txt
    public void bacaMovie() {
        try {
            File file = new File("MovieList.txt");
            Scanner inputFile = new Scanner(file);

            while (inputFile.hasNextLine()) { //baca file baris demi baris

                String judulFilm = inputFile.nextLine();

                //membuat object Film dari data yang dibaca
                //karena Film abstract, kita gunakan anonymous object
                Film film = new Film("", judulFilm, "") {
                    public int HitungHargaTiket() {
                        return 0;
                    }
                };

                //memasukkan film ke arraylist
                listFilm.add(film);
            }

            inputFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("File MovieList.txt tidak ditemukan.");
        }
    }

    //mengambil seluruh daftar film
    public ArrayList<Film> getListFilm() {
        return listFilm;
    }

    //menampilkan daftar film
    public void tampilkanMovie() {
        System.out.println();
        System.out.println("=================================");
        System.out.println("          PILIHAN FILM");
        System.out.println("=================================");

        for (int i = 0; i < listFilm.size(); i++) { //penomoran film
            System.out.println((i + 1) + ". " + listFilm.get(i).getJudulFilm());
        }
    }
}