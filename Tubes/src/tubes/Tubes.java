/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author SagabAdi
 */
public class Tubes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Pelanggan> pe = new ArrayList();
        List<Pengemudi> peng = new ArrayList();
        Scanner cin = new Scanner(System.in);
        Scanner can = new Scanner(System.in);
        boolean nemu = false;
        boolean nemus = false;
        String a;
        String b;
        String c;
        String d;
        String e;
        int pil = 0;
        int pal = 0;
        int i = 0;
        do {
            System.out.println("1. Tambah Pelanggan ");
            System.out.println("2. Tambah Pengemudi ");
            System.out.println("3. Login Pelanggan ");
            System.out.println("4. Login Pengemudi ");
            System.out.println("5. Exit ");
            System.out.print("Masukkan Pilihan Anda : ");
            pil = can.nextInt();
            if (pil == 1) {
                System.out.print("Masukkan Nama Anda : ");
                a = cin.nextLine();
                System.out.print("Masukkan Id Anda   : ");
                b = cin.nextLine();
                Pelanggan p = new Pelanggan(a, b);
                pe.add(p);
                System.out.println("1. Tambah Pelanggan");
                System.out.println("2. Selesai");
                System.out.print("Masukkan Pilihan Anda :  ");
                pal = can.nextInt();
                while (pal != 2) {
                    System.out.print("Masukkan Nama Anda : ");
                    a = cin.nextLine();
                    System.out.print("Masukkan Id Anda   : ");
                    b = cin.nextLine();
                    Pelanggan pela = new Pelanggan(a, b);
                    pe.add(pela);
                    System.out.println("1. Tambah pesanan");
                    System.out.println("2. Selesai");
                    System.out.print("Masukkan Pilihan Anda :  ");
                    pal = can.nextInt();
                }
            } else if (pil == 2) {
                System.out.print("Masukkan Nama Anda : ");
                a = cin.nextLine();
                System.out.print("Masukkan Id Anda   : ");
                b = cin.nextLine();
                Pengemudi pen = new Pengemudi(a, b);
                peng.add(pen);
                System.out.println("1. Tambah Pelanggan");
                System.out.println("2. Selesai");
                System.out.print("Masukkan Pilihan Anda :  ");
                pal = can.nextInt();
                while (pal != 2) {
                    System.out.print("Masukkan Nama Anda : ");
                    a = cin.nextLine();
                    System.out.print("Masukkan Id Anda   : ");
                    b = cin.nextLine();
                    Pengemudi pens = new Pengemudi(a, b);
                    peng.add(pens);
                    System.out.println("1. Tambah pesanan");
                    System.out.println("2. Selesai");
                    System.out.print("Masukkan Pilihan Anda :  ");
                    pal = can.nextInt();
                }
            } else if (pil == 3) {
                System.out.print("Masukkan Nama Anda : ");
                c = cin.nextLine();
                System.out.print("Masukkan Id Anda   : ");
                d = cin.nextLine();
                while (nemu != true) {
                    if (pe.get(i).getId().equals(d) && pe.get(i).getNama().equals(c)) {
                        nemu = true;
                    } else {
                        i++;
                    }
                }

                if (nemu == true) {
                    System.out.println("Login Sukses");
                    do {
                        System.out.println("1. Tambah Pesanan ");
                        System.out.println("2. Batalkan Pesanan ");
                        System.out.println("3. Lihat Pesanan ");
                        System.out.println("4. Exit ");
                        System.out.print("Masukkan Pilihan Anda :  ");
                        pil = can.nextInt();
                        if (pil == 1) {
                            pal = 0;
                            while (pal != 2) {
                                System.out.print("Masukkan Id Pesanan         : ");
                                String f = cin.nextLine();
                                System.out.print("Masukkan Asal Keberangkatan : ");
                                String g = cin.nextLine();
                                System.out.print("Masukkan Tujuan             : ");
                                String h = cin.nextLine();
                                pe.get(i).createPesanan(f, g, h);
                                System.out.println("1. Tambah pesanan");
                                System.out.println("2. Selesai");
                                System.out.print("Masukkan Pilihan Anda :  ");
                                pal = can.nextInt();
                            }
                            pil = 0;
                        } else if (pil == 2) {

                        } else if (pil == 3) {
                            System.out.println("Nama Pelanggan : " + pe.get(i).getNama());
                            for (int j = 0; j < pe.get(i).getLength(); j++) {
                                System.out.println(j + 1 + ".Id Pesanan : " + pe.get(i).getPesanan(j).getId());
                                System.out.println("  Asal       : " + pe.get(i).getPesanan(j).getAsal());
                                System.out.println("  Tujuan     : " + pe.get(i).getPesanan(j).getTujuan());
                            }
                            pil = 0;
                        }

                    } while (pil != 4);
                    nemu = false;
                    pil = 0;
                    i = 0;
                    System.out.println("Anda Telah Logout");
                } else {
                    System.out.println("Login Gagal");
                    i = 0;
                }
            } else if (pil == 4) {
                System.out.print("Masukkan Nama Anda : ");
                c = cin.nextLine();
                System.out.print("Masukkan Id Anda   : ");
                d = cin.nextLine();
                while (nemu != true) {
                    if (peng.get(i).getId().equals(d) && peng.get(i).getNama().equals(c)) {
                        nemu = true;
                    } else {
                        i++;
                    }
                }

                if (nemu == true) {
                    System.out.println("Login Sukses");
                    nemu = false;
                    pil = 0;
                    i = 0;
                } else {
                    System.out.println("Login Gagal");
                    i = 0;
                }
            }
        } while (pil != 5);

    }
}
