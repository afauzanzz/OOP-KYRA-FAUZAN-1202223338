// Don't delete any comments below!!!

public class Makanan {
    // Todo : Create private attribute of Makanan (nama, jumlah, and harga)
    private String nama;
    private int jumlah;
    private int harga;

    // Todo : Create Constructor of Makanan
    public Makanan(String nama, int jumlah, int harga) {
        this.nama = nama;
        this.jumlah = jumlah;
        this.harga = harga;
    }
    // Todo : Create Getter and Setter
    public String getName(){
        return nama;
    }

    public void setName(){
        this.nama = nama;
    }
}
