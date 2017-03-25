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
public class AplikasiConsole {

    public void appss() {
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
                if (pe.size() == 0) {

                    c = (Integer.toString(pe.size() + 1));
                } else {
                    c = (Integer.toString(Integer.parseInt(pe.get(pe.size() - 1).getPk()) + 1));
                }
                Pelanggan p = new Pelanggan(a, b, c,(pe.size()+1));
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
                    if (pe.size() == 0) {

                        c = (Integer.toString(pe.size() + 1));
                    } else {
                        c = (Integer.toString(Integer.parseInt(pe.get(pe.size() - 1).getPk()) + 1));
                    }
                    Pelanggan pela = new Pelanggan(a, b, c,pe.size()+1);
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
                if (peng.size() == 0) {

                    c = (Integer.toString(peng.size() + 1));
                } else {
                    c = (Integer.toString(Integer.parseInt(peng.get(peng.size() - 1).getPk()) + 1));
                }
                Pengemudi pen = new Pengemudi(a, b, c);
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
                    if (peng.size() == 0) {

                        c = (Integer.toString(peng.size() + 1));
                    } else {
                        c = (Integer.toString(Integer.parseInt(peng.get(peng.size() - 1).getPk()) + 1));
                    }
                    Pengemudi pens = new Pengemudi(a, b, c);
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

                                System.out.print("Masukkan Asal Keberangkatan : ");
                                String g = cin.nextLine();
                                System.out.print("Masukkan Tujuan             : ");
                                String h = cin.nextLine();
                                pe.get(i).createPesanan(g, h);
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
                    System.out.println("1. List Pesanan ");
                    System.out.println("2. Lihat Pesanan Ter-Accept ");
                    System.out.println("3. Batalkan Pesanan ");
                    System.out.println("4. Exit ");
                    System.out.print("Masukkan Pilihan Anda :  ");
                    pil = can.nextInt();
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
