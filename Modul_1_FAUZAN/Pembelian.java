package Modul_1_FAUZAN;

import java.util.ArrayList;
import java.util.Scanner;

class Pembelian {
    private ArrayList<Penerbangan> daftarPenerbangan;
    private Penumpang penumpang;
    private Penerbangan penerbanganDipilih;

    public Pembelian() {
        daftarPenerbangan = new ArrayList<>();
        // Menambahkan beberapa penerbangan contoh
        daftarPenerbangan.add(new Penerbangan("BA101", "CGK, Jakarta", "DPS, Bali", "06:30", "08:15", 1200000));
        daftarPenerbangan.add(new Penerbangan("QZ202", "SUB, Surabaya", "KNO, Medan", "09:00", "11:45", 1350000));
    }

    public void tampilkanDaftarPenerbangan() {
        for (int i = 0; i < daftarPenerbangan.size(); i++) {
            daftarPenerbangan.get(i).tampilDaftarPenerbangan(i);
        }
    }

    public void pemesananTiket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Silahkan isi data diri anda terlebih dahulu!");
        System.out.println("------------------------------");
        System.out.print("Masukan NIK : ");
        String NIK = scanner.nextLine();
        System.out.print("Masukan Nama Depan : ");
        String namaDepan = scanner.nextLine();
        System.out.print("Masukan Nama Belakang : ");
        String namaBelakang = scanner.nextLine();
        
        penumpang = new Penumpang(NIK, namaDepan, namaBelakang);
        System.out.println("Terima Kasih telah mengisi data pelanggan. Silahkan pilih tiket penerbangan yang tersedia");
        System.out.println("------------------------------");
        
        tampilkanDaftarPenerbangan();
        
        System.out.print("Pilih nomor penerbangan : ");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < daftarPenerbangan.size()) {
            penerbanganDipilih = daftarPenerbangan.get(index);
            System.out.println("Pemesanan tiket berhasil dilakukan, cek pesanan tiket pada menu (3)");
        } else {
            System.out.println("Pilihan tidak valid!");
        }
    }

    public void tampilkanPesananTiket() {
        if (penumpang != null && penerbanganDipilih != null) {
            System.out.println("======= Detail Tiket Penerbangan =======");
            penumpang.tampilDaftarPenumpang();
            System.out.println("Bandara Keberangkatan : " + penerbanganDipilih.getBandaraKeberangkatan());
            System.out.println("Bandara Tujuan : " + penerbanganDipilih.getBandaraTujuan());
            System.out.println("Waktu Keberangkatan : " + penerbanganDipilih.getWaktuKeberangkatan());
            System.out.println("Waktu Kedatangan : " + penerbanganDipilih.getWaktuKedatangan());
            System.out.println("Harga Tiket : Rp" + penerbanganDipilih.getHargaTiket());
        } else {
            System.out.println("Pembelian Tiket Tidak Ada");
        }
    }

    public static void main(String[] args) {
        Pembelian pembelian = new Pembelian();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("======== EAD Ticket Booking System ========");
            System.out.println("1. Tampilkan Daftar Penerbangan");
            System.out.println("2. Beli Tiket");
            System.out.println("3. Tampilkan Pesanan Tiket");
            System.out.println("4. Exit");
            System.out.print("Silahkan pilih menu : ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    pembelian.tampilkanDaftarPenerbangan();
                    break;
                case 2:
                    pembelian.pemesananTiket();
                    break;
                case 3:
                    pembelian.tampilkanPesananTiket();
                    break;
                case 4:
                    System.out.println("Terima Kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        } while (pilihan != 4);

        scanner.close();
    }
}