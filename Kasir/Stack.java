// Stack LIFO menyimpan seluruh transaksi yang telah selesai dilayani.
public class Stack {
    private Node top;
    private int size;

    // Salin data ke node baru agar rantai stack terpisah dari queue.
    public void push(Node pelanggan) {
        if (pelanggan == null) return;
        Node baru = new Node(pelanggan.kode, pelanggan.nama, pelanggan.total);
        baru.next = top;
        top = baru;
        size++;
    }

    // Display tidak menghapus riwayat dan dimulai dari transaksi terbaru.
    public void display() {
        System.out.println("Riwayat Transaksi (terbaru ke lama):");
        if (top == null) System.out.println("Belum ada transaksi.");
        for (Node p = top; p != null; p = p.next)
            System.out.println(p.detail());
        System.out.println("Total Transaksi: " + size);
    }
}
