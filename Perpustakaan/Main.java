import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);

    // Membaca teks yang tidak kosong, termasuk judul dengan spasi.
    private static String baca(String pesan) {
        while (true) {
            System.out.print(pesan);
            String nilai = input.nextLine().trim();
            if (!nilai.isEmpty()) return nilai;
            System.out.println("Input tidak boleh kosong.");
        }
    }

    // Ulangi input sampai satu buku valid berhasil ditambahkan.
    private static void tambah(LinkedList buku) {
        while (true) {
            String kode = baca("Masukkan Kode Buku: ");
            if (kode.length() > 5) {
                System.out.println("Kode buku maksimal 5 karakter.");
                continue;
            }
            if (buku.cari(kode) != null) {
                System.out.println("Kode buku sudah digunakan.");
                continue;
            }
            String judul = baca("Masukkan Judul: ");
            String penulis = baca("Masukkan Penulis: ");
            if (buku.push(kode, judul, penulis)) {
                System.out.println("Data berhasil ditambahkan!");
                return;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList buku = new LinkedList();
        System.out.println("=== INPUT AWAL MINIMAL 5 BUKU ===");
        while (buku.size() < 5) {
            System.out.println("Buku ke-" + (buku.size() + 1));
            tambah(buku);
        }
        // Setelah input awal, seluruh operasi dapat dipilih berulang kali.
        while (true) {
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku\n2. Hapus Buku\n3. Cari Buku"
                    + "\n4. Lihat Semua Buku\n5. Keluar");
            String menu = baca("Pilih menu: ");
            switch (menu) {
                case "1": tambah(buku); break;
                case "2":
                    Node hapus = buku.pop();
                    System.out.println(hapus == null
                            ? "Tidak ada data untuk dihapus."
                            : "Buku dihapus: " + hapus.detail());
                    break;
                case "3":
                    Node hasil = buku.cari(baca("Masukkan Kode Buku: "));
                    System.out.println(hasil == null
                            ? "Buku tidak ditemukan." : hasil.detail());
                    break;
                case "4": buku.tampil(); break;
                case "5":
                    System.out.println("Program selesai.");
                    input.close();
                    return;
                default: System.out.println("Menu tidak valid. Pilih 1-5.");
            }
        }
    }
}
