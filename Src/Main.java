package Src;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Masukkan jumlah rak: ");
            int jumlahRak = input.nextInt();
            Apotek apotek = new Apotek(jumlahRak);

            while (true) {
                System.out.println("\nSelamat datang di apotek!");
                System.out.println("1. Lihat obat");
                System.out.println("2. Tambah obat");
                System.out.println("3. Hapus obat");
                System.out.println("4. Pindah obat");
                System.out.println("5. Beli obat");
                System.out.println("6. Exit");
                System.out.print("Pilih menu: ");
                int menu = input.nextInt();

                switch (menu) {
                    case 1:
                        apotek.lihatObat();
                        break;
                    case 2:
                        apotek.tambahObat();
                        break;
                    case 3:
                        apotek.hapusObat();
                        break;
                    case 4:
                        apotek.pindahObat();
                        break;
                    case 5:
                        apotek.beliObat();
                        break;
                    case 6:
                        apotek.exit();
                        System.exit(0);
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            }
        }
    }
}