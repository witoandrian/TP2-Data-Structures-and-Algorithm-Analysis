import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);

    private static String baca(String pesan) {
        while (true) {
            System.out.print(pesan);
            String nilai = input.nextLine().trim();
            if (!nilai.isEmpty()) return nilai;
            System.out.println("Input tidak boleh kosong.");
        }
    }

    // Tolak teks, pecahan, angka negatif, dan nilai di luar rentang long.
    private static long bacaTotal() {
        while (true) {
            try {
                long nilai = Long.parseLong(baca("Masukkan Total Belanja: "));
                if (nilai >= 0) return nilai;
            } catch (NumberFormatException e) {
                // Pesan validasi yang sama digunakan untuk format tidak sah.
            }
            System.out.println("Total harus rupiah bulat >= 0 tanpa titik/koma.");
        }
    }

    private static void tambah(Queue antrean) {
        if (antrean.isFull()) {
            System.out.println("Antrean penuh. Maksimal 5 pelanggan.");
            return;
        }
        String kode;
        while (true) {
            kode = baca("Masukkan Nomor Antrian: ");
            if (!antrean.adaKode(kode)) break;
            System.out.println("Nomor antrian sudah digunakan.");
        }
        String nama = baca("Masukkan Nama Pelanggan: ");
        long total = bacaTotal();
        if (antrean.enqueue(kode, nama, total))
            System.out.println("Data pelanggan ditambahkan ke antrian!");
    }

    public static void main(String[] args) {
        Queue antrean = new Queue();
        Stack riwayat = new Stack();
        System.out.println("=== INPUT AWAL 5 PELANGGAN ===");
        while (antrean.size() < 5) {
            System.out.println("Pelanggan ke-" + (antrean.size() + 1));
            tambah(antrean);
        }
        while (true) {
            System.out.println("\n=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian\n2. Layani Pelanggan"
                    + "\n3. Tampilkan Antrian\n4. Lihat Riwayat Transaksi"
                    + "\n5. Keluar");
            String menu = baca("Pilih menu: ");
            switch (menu) {
                case "1": tambah(antrean); break;
                case "2":
                    // FIFO memilih pelanggan, lalu push mencatat transaksi.
                    Node pelanggan = antrean.dequeue();
                    if (pelanggan == null) {
                        System.out.println("Tidak ada pelanggan untuk dilayani.");
                    } else {
                        riwayat.push(pelanggan);
                        System.out.println("Melayani pelanggan " + pelanggan.kode
                                + " (" + pelanggan.nama + ")");
                        System.out.println("Transaksi disimpan ke riwayat.");
                    }
                    break;
                case "3": antrean.display(); break;
                case "4": riwayat.display(); break;
                case "5":
                    System.out.println("Program selesai.");
                    input.close();
                    return;
                default: System.out.println("Menu tidak valid. Pilih 1-5.");
            }
        }
    }
}
