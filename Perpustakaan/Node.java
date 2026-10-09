// Node menyimpan satu buku dan referensi ke node berikutnya.
public class Node {
    String kodeBuku, judul, penulis;
    Node next;

    public Node(String kodeBuku, String judul, String penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
    }

    public String detail() {
        return "Kode: " + kodeBuku + " | Judul: " + judul
                + " | Penulis: " + penulis;
    }
}
