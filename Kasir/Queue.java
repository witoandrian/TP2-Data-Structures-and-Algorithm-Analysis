// Queue FIFO dengan kapasitas maksimal lima pelanggan aktif.
public class Queue {
    private Node front, rear;
    private int size;
    private static final int KAPASITAS = 5;

    public int size() { return size; }
    public boolean isFull() { return size == KAPASITAS; }

    // Mencegah kode ganda dalam antrean yang masih aktif.
    public boolean adaKode(String kode) {
        for (Node p = front; p != null; p = p.next)
            if (p.kode.equalsIgnoreCase(kode)) return true;
        return false;
    }

    // Pelanggan baru ditempatkan di belakang antrean.
    public boolean enqueue(String kode, String nama, long total) {
        if (kode == null || nama == null || total < 0 || isFull()) return false;
        kode = kode.trim();
        nama = nama.trim();
        if (kode.isEmpty() || nama.isEmpty() || adaKode(kode)) return false;
        Node baru = new Node(kode, nama, total);
        if (rear == null) front = baru;
        else rear.next = baru;
        rear = baru;
        size++;
        return true;
    }

    // Lepaskan node depan sebelum menyerahkannya ke riwayat transaksi.
    public Node dequeue() {
        if (front == null) return null;
        Node dilayani = front;
        front = front.next;
        dilayani.next = null;
        size--;
        if (front == null) rear = null;
        return dilayani;
    }

    public void display() {
        System.out.println("Antrean saat ini (depan ke belakang):");
        if (front == null) System.out.println("Antrean kosong.");
        for (Node p = front; p != null; p = p.next)
            System.out.println(p.detail());
        System.out.println("Total Antrean: " + size + "/" + KAPASITAS);
    }
}
