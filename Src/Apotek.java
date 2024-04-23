package Src;

import java.util.ArrayList;
import java.util.Scanner;

public class Apotek {
    private Obat[] rak;
    private ArrayList<String> beliObat = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public Apotek(int jumlahRak) {
        rak = new Obat[jumlahRak];
    }

    public void lihatObat() {
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < rak.length; i++) {
            if (rak[i] != null) {
                System.out.println(i + " nama = " + rak[i].getNama() + " | stok = " + rak[i].getStok() + " | harga = Rp " + rak[i].getHarga());
                System.out.println("-------------------------------------------------------------");
            }
        }
    }

    public void tambahObat() {
        System.out.print("Masukkan indeks obat: ");
        int indeks = input.nextInt();
        input.nextLine(); // Membersihkan baris input

        if (indeks >= 0 && indeks < rak.length) {
            if (rak[indeks] == null) {
                System.out.print("Masukkan nama obat: ");
                String nama = input.nextLine();
                System.out.print("Masukkan stok obat: ");
                int stok = input.nextInt();
                System.out.print("Masukkan harga obat: ");
                double harga = input.nextDouble();

                rak[indeks] = new Obat(nama, stok, harga);
                System.out.println("Obat berhasil ditambahkan!");
            } else {
                System.out.println("Rak indeks " + indeks + " sudah terisi.");
            }
        } else {
            System.out.println("Indeks tidak valid!");
        }
    }

    public void hapusObat() {
        lihatObat();
        System.out.print("Pilih indeks obat yang akan dihapus: ");
        int indeks = input.nextInt();

        if (indeks >= 0 && indeks < rak.length && rak[indeks] != null) {
            rak[indeks] = null;
            System.out.println("Obat berhasil dihapus!");
        } else {
            System.out.println("Indeks tidak valid atau rak kosong!");
        }
    }

    public void pindahObat() {
        lihatObat();
        System.out.print("Pilih indeks yang akan dipindah: ");
        int indeksSumber = input.nextInt();
        System.out.print("Pilih indeks tujuan: ");
        int indeksTujuan = input.nextInt();
    
        if (indeksSumber >= 0 && indeksSumber < rak.length && indeksTujuan
         >= 0 && indeksTujuan < rak.length) {
            if (rak[indeksSumber] != null) {
                if (rak[indeksTujuan] == null) {
                    rak[indeksTujuan] = rak[indeksSumber];
                    rak[indeksSumber] = null;
                    System.out.println("Obat berhasil dipindahkan!");
                } else {
                    Obat temp = rak[indeksSumber];
                    rak[indeksSumber] = rak[indeksTujuan];
                    rak[indeksTujuan] = temp;
                    System.out.println("Obat berhasil dipindahkan!");
                }
            } else {
                System.out.println
                ("Indeks sumber tidak valid atau rak kosong!");
            }
        } else {
            System.out.println("Indeks tidak valid!");
        }
    }

    public void beliObat() {
        lihatObat();
        System.out.print("Pilih indeks obat: ");
        int indeks = input.nextInt();
        System.out.print("Pilih jumlah obat: ");
        int jumlah = input.nextInt();

        if (indeks >= 0 && indeks < rak.length && rak[indeks] != null) {
            Obat obat = rak[indeks];
            if (obat.getStok() >= jumlah) {
                obat.setStok(obat.getStok() - jumlah);
                double totalHarga = obat.getHarga() * jumlah;
                beliObat.add(obat.getNama() + " | jumlah = " + jumlah + " | harga = Rp " + totalHarga);
                System.out.println("Pembelian sukses!");
            } else {
                System.out.println("Stok obat tidak cukup!");
            }
        } else {
            System.out.println("Indeks tidak valid atau rak kosong!");
        }
    }

    public void exit() {
        if (!beliObat.isEmpty()) {
            double totalTagihan = 0;
            System.out.println("Daftar Pembelian:");
            for (int i = 0; i < beliObat.size(); i++) {
                System.out.println((i + 1) + ". " + beliObat.get(i));
                String[] parts = beliObat.get(i).split(" \\| ");
                double harga = Double.parseDouble(parts[2].substring(3).replaceAll("[^\\d.]", ""));
                totalTagihan += harga;
            }
            System.out.println("Jumlah tagihan: Rp " + totalTagihan);
        } else {
            System.out.println("Tidak ada pembelian yang dilakukan.");
        }
    }
}  