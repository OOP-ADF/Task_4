/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

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
        Scanner cin = new Scanner(System.in);
        System.out.println("Masukkan Nama Anda : ");
        String a = cin.nextLine();
        System.out.println("Masukkan Id Anda   : ");
        String b = cin.nextLine();
        Pelanggan p = new Pelanggan(a, b);
        String pilih = "Y";
        while (pilih != "N") {
            System.out.println("Masukkan Id Pesanan         : ");
            String c = cin.nextLine();
            System.out.println("Masukkan Asal Keberangkatan : ");
            String d = cin.nextLine();
            System.out.println("Masukkan Tujuan             : ");
            String e = cin.nextLine();
            p.createPesanan(c, d, e);
            System.out.println("Apakah anda ingin memesan lagi ? (Y/N)");
            pilih = cin.nextLine();
        }
//
    }
}
