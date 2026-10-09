// Single Linked List buatan sendiri, tanpa koleksi bawaan Java.
public class LinkedList {
    private Node head, tail;
    private int size;

    public int size() { return size; }

    // Tambahkan buku di akhir. Kode harus unik dan maksimal 5 karakter.
    public boolean push(String kode, String judul, String penulis) {
        if (kode == null || judul == null || penulis == null) return false;
        kode = kode.trim();
        judul = judul.trim();
        penulis = penulis.trim();
        if (kode.isEmpty() || kode.length() > 5 || judul.isEmpty()
                || penulis.isEmpty() || cari(kode) != null) return false;
        Node baru = new Node(kode, judul, penulis);
        if (head == null) head = baru;
        else tail.next = baru;
        tail = baru;
        size++;
        return true;
    }

    // Hapus node terakhir; cari pendahulunya pada list berisi banyak node.
    public Node pop() {
        if (head == null) return null;
        Node dihapus = tail;
        if (head == tail) {
            head = tail = null;
        } else {
            Node bantu = head;
            while (bantu.next != tail) bantu = bantu.next;
            bantu.next = null;
            tail = bantu;
        }
        size--;
        return dihapus;
    }

    // Pencarian linear berdasarkan kode, tanpa membedakan huruf besar/kecil.
    public Node cari(String kode) {
        if (kode == null) return null;
        for (Node p = head; p != null; p = p.next) {
            if (p.kodeBuku.equalsIgnoreCase(kode.trim())) return p;
        }
        return null;
    }

    // Traversal dari head mempertahankan urutan pemasukan buku.
    public void tampil() {
        System.out.println("Daftar Buku:");
        if (head == null) System.out.println("Daftar buku kosong.");
        for (Node p = head; p != null; p = p.next)
            System.out.println(p.detail());
        System.out.println("Total Buku: " + size);
    }
}
