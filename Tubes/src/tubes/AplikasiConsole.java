/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author SagabAdi
 */
public class AplikasiConsole {

    Model model;

    public AplikasiConsole(Model model) {
        this.model = model;
    }

    public void appss() {
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
                if (model.pe.size() == 0) {

                    c = (Integer.toString(model.pe.size() + 1));
                } else {
                    c = (Integer.toString(Integer.parseInt(model.pe.get(model.pe.size() - 1).getPk()) + 1));
                }
                model.setPe(a, b);
                System.out.println("1. Tambah Pelanggan");
                System.out.println("2. Selesai");
                System.out.print("Masukkan Pilihan Anda :  ");
                pal = can.nextInt();
                while (pal != 2) {
                    System.out.print("Masukkan Nama Anda : ");
                    a = cin.nextLine();
                    System.out.print("Masukkan Id Anda   : ");
                    b = cin.nextLine();
                    if (model.pe.size() == 0) {

                        c = (Integer.toString(model.pe.size() + 1));
                    } else {
                        c = (Integer.toString(Integer.parseInt(model.pe.get(model.pe.size() - 1).getPk()) + 1));
                    }
                    model.setPe(a, b);
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
                if (model.peng.size() == 0) {

                    c = (Integer.toString(model.peng.size() + 1));
                } else {
                    c = (Integer.toString(Integer.parseInt(model.peng.get(model.peng.size() - 1).getPk()) + 1));
                }
                model.setPeng(a, b);
                System.out.println("1. Tambah Pelanggan");
                System.out.println("2. Selesai");
                System.out.print("Masukkan Pilihan Anda :  ");
                pal = can.nextInt();
                while (pal != 2) {
                    System.out.print("Masukkan Nama Anda : ");
                    a = cin.nextLine();
                    System.out.print("Masukkan Id Anda   : ");
                    b = cin.nextLine();
                    model.setPeng(a, b);
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
                    if (model.pe.get(i).getId().equals(d) && model.pe.get(i).getNama().equals(c)) {
                        nemu = true;
                    } else {
                        i++;
                    }
                }

                if (nemu == true) {
                    System.out.println("Login Sukses");
                    do {
                        System.out.println("1. Tambah Pesanan Transportasi ");
                        System.out.println("2. Batalkan Pesanan Transportasi ");
                        System.out.println("3. Lihat Pesanan ");
                        System.out.println("4. Tambah Pesanan Kurir ");
                        System.out.println("5. Batalkan Pesanan Kurir ");
                        System.out.println("6. Lihat Pesanan Kurir ");
                        System.out.println("7. Exit ");
                        System.out.print("Masukkan Pilihan Anda :  ");
                        pil = can.nextInt();
                        if (pil == 1) {
                            pal = 0;
                            while (pal != 2) {
                                System.out.print("Masukkan Asal Keberangkatan : ");
                                a = cin.nextLine();
                                System.out.print("Masukkan Tujuan             : ");
                                b = cin.nextLine();
                                model.pe.get(i).createPesanan(a, b);
                                System.out.println("1. Tambah pesanan");
                                System.out.println("2. Selesai");
                                System.out.print("Masukkan Pilihan Anda :  ");
                                pal = can.nextInt();
                            }
                            pil = 0;
                        } else if (pil == 2) {
                            System.out.print("Masukkan ID Pemesanan yang akan dibatalkan : ");
                            a = cin.nextLine();
                            if (a == "") {
                                JOptionPane.showMessageDialog(null, "Isi Dengan Benar !! ");
                            } else {
                                if (model.pe.get(i).getLength() == 0) {
                                    System.out.println("PESANAN KOSONG !!");
                                } else {
                                    System.out.println("Pesanan Berhasil Dibatalkan");
                                    int n = 0;
                                    nemu = false;
                                    while (nemu != true) {
                                        if (model.pe.get(i).getPesanan(n).getId().equals(a)) {
                                            nemu = true;
                                        } else {
                                            n++;
                                        }
                                    }
                                    model.pe.get(i).Removepesanan(n);
                                }
                            }

                        } else if (pil == 3) {
                            System.out.println("Nama Pelanggan : " + model.pe.get(i).getNama());
                            for (int j = 0; j < model.pe.get(i).getLength(); j++) {
                                System.out.println(j + 1 + ".Id Pesanan : " + model.pe.get(i).getPesanan(j).getId());
                                System.out.println("  Asal       : " + model.pe.get(i).getPesanan(j).getAsal());
                                System.out.println("  Tujuan     : " + model.pe.get(i).getPesanan(j).getTujuan());
                            }
                            pil = 0;
                        } else if (pil == 4) {
                            System.out.print("Masukkan Jenis Kurir (Makanan / Paket / dll) : ");
                            a = cin.nextLine();
                            System.out.print("Masukkan Asal                                : ");
                            b = cin.nextLine();
                            System.out.print("Masukkan Tujuan                              : ");
                            c = cin.nextLine();
                            model.pe.get(i).createKurir(a, b, c);
                        } else if (pil == 5) {
                            System.out.print("Masukkan ID Kurir yang akan dibatalkan : ");
                            a = cin.nextLine();
                            if (a == "") {
                                JOptionPane.showMessageDialog(null, "Isi Dengan Benar !! ");
                            } else {
                                if (model.pe.get(i).getLengthk() == 0) {
                                    System.out.println("PESANAN KOSONG !!");
                                } else {
                                    System.out.println("Pesanan Berhasil Dibatalkan");
                                    int n = 0;
                                    nemu = false;
                                    while (nemu != true) {
                                        if (model.pe.get(i).getKurir(n).getId().equals(a)) {
                                            nemu = true;
                                        } else {
                                            n++;
                                        }
                                    }
                                    model.pe.get(i).Removekurir(n);
                                }
                            }

                        } else if (pil == 6) {
                            for (int j = 0; j < model.pe.get(i).getLengthk(); j++) {
                                System.out.println(j + 1 + ".Id Kurir    : " + model.pe.get(i).getKurir(j).getId());
                                System.out.println("  Jenis Kurir : " + model.pe.get(i).getKurir(j).getNama());
                                System.out.println("  Asal        : " + model.pe.get(i).getKurir(j).getAsal());
                                System.out.println("  Tujuan      : " + model.pe.get(i).getKurir(j).getTujuan());
                                System.out.println("");
                            }
                        }

                    } while (pil != 7);
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
                    if (model.peng.get(i).getId().equals(d) && model.peng.get(i).getNama().equals(c)) {
                        nemu = true;
                    } else {
                        i++;
                    }
                }

                if (nemu == true) {
                    System.out.println("Login Sukses");
                    while (pil != 9) {
                        System.out.println("1. List Pesanan Transportasi Pelanggan ");
                        System.out.println("3. Terima Pesanan ");
                        System.out.println("3. Lihat Pesanan Transportasi Yang anda Terima ");
                        System.out.println("4. Batalkan Pesanan ");
                        System.out.println("5. List Pesanan Kurir Pelanggan ");
                        System.out.println("6. Terima Pesanan Kurir ");
                        System.out.println("7. Lihat Pesanan Kurir Yang anda Terima ");
                        System.out.println("8. Batalkan Pesanan ");
                        System.out.println("9. Exit");
                        System.out.print("Masukkan Pilihan Anda :  ");
                        pil = can.nextInt();
                        switch (pil) {
                            case 1:
                                for (int j = 0; j < model.pe.size(); j++) {
                                    for (int k = 0; k < model.pe.get(j).getLength(); k++) {
                                        System.out.println("Id Pelanggan   : " + model.pe.get(j).getPk());
                                        System.out.println("Nama Pelanggan : " + model.pe.get(j).getNama());
                                        System.out.println("Id Pesanan     : " + model.pe.get(j).getPesanan(k).getId());
                                        System.out.println("Asal           : " + model.pe.get(j).getPesanan(k).getAsal());
                                        System.out.println("Tujuan         : " + model.pe.get(j).getPesanan(k).getTujuan());
                                        System.out.println("");
                                    }
                                }
                                break;
                            case 2:
                                int k = 0;
                                int j = 0;
                                System.out.print("Masukkan Id Pelanggan : ");
                                a = cin.nextLine();
                                System.out.print("Masukkan Id Pemesanan : ");
                                b = cin.nextLine();
                                k = Integer.parseInt(a) - 1;
                                while (nemus != true) {
                                    if (model.pe.get(k).getPesanan(j).getId().equals(b)) {
                                        nemus = true;
                                    } else if (j != model.pe.get(k).getLength()) {
                                        j++;
                                    }
                                    if (nemus == true) {
                                        Pesanan p = new Pesanan(model.pe.get(k).getPesanan(j).getAsal(), model.pe.get(k).getPesanan(j).getTujuan());
                                        p.setId(model.pe.get(k).getPesanan(j).getId());
                                        model.peng.get(i).addPesanan(p);
                                        System.out.println("Pesanan telah diambil");
                                    } else {
                                        System.out.println("Error!!");
                                    }

                                }
                                break;
                            case 3:
                                for (j = 0; j < model.peng.get(i).getLength(); j++) {
                                    System.out.println(j + 1 + ".Id Pesanan : " + model.peng.get(i).getPesanan(j).getId());
                                    System.out.println("  Asal       : " + model.peng.get(i).getPesanan(j).getAsal());
                                    System.out.println("  Tujuan     : " + model.peng.get(i).getPesanan(j).getTujuan());
                                    System.out.println("");
                                }
                                break;
                            case 4:
                                System.out.print("Masukkan ID Pemesanan yang akan dibatalkan : ");
                                a = cin.nextLine();
                                if (a == "") {
                                    JOptionPane.showMessageDialog(null, "Isi Dengan Benar !! ");
                                } else {
                                    if (model.peng.get(i).getLength() == 0) {
                                        System.out.println("PESANAN KOSONG !!");
                                    } else {
                                        System.out.println("Pesanan Berhasil Dibatalkan");
                                        int n = 0;
                                        nemu = false;
                                        while (nemu != true) {
                                            if (model.peng.get(i).getPesanan(n).getId().equals(a)) {
                                                nemu = true;
                                            } else {
                                                n++;
                                            }
                                        }
                                        model.peng.get(i).Removepesanan(n);
                                    }
                                }
                                break;
                            case 5:
                                for (j = 0; j < model.pe.size(); j++) {
                                    for (k = 0; k < model.pe.get(j).getLengthk(); k++) {
                                        System.out.println("Id Pelanggan   : " + model.pe.get(j).getPk());
                                        System.out.println("Nama Pelanggan : " + model.pe.get(j).getNama());
                                        System.out.println("Id Kurir       : " + model.pe.get(j).getKurir(k).getId());
                                        System.out.println("Jenis Kurir    : " + model.pe.get(j).getKurir(k).getNama());
                                        System.out.println("Asal           : " + model.pe.get(j).getKurir(k).getAsal());
                                        System.out.println("Tujuan         : " + model.pe.get(j).getKurir(k).getTujuan());
                                        System.out.println("");
                                    }
                                }
                                break;
                            case 6:
                                break;
                            case 7:
                                break;
                            case 8:
                                break;
                            case 9:
                                break;
                        }
                    }
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
