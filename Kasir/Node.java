// Satu node menyimpan data pelanggan dan total belanja rupiah bulat.
public class Node {
    String kode, nama;
    long total;
    Node next;

    public Node(String kode, String nama, long total) {
        this.kode = kode;
        this.nama = nama;
        this.total = total;
    }

    public String detail() {
        return "Kode: " + kode + " | Nama: " + nama + " | Total: Rp " + total;
    }
}
