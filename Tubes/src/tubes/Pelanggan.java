/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SagabAdi
 */
public class Pelanggan extends Orang {

    private List<Pesanan> pesanan = new ArrayList();
    private List<Kurir> kurir = new ArrayList();
    private String Nama;
    private String id, pk;
    private int i;
    private int length;

    public Pelanggan(String Nama, String id, String pk, int i) {
        super(Nama, id, pk);
        this.i = i;

    }

    public void createPesanan(String Asal, String Tujuan) {
        boolean nemu = false;
        Pesanan p = new Pesanan(Asal, Tujuan);
        if (pesanan.size() == 0) {

            p.setId(Integer.toString((this.i * 100) + (pesanan.size() + 1)));
        } else {
            p.setId(Integer.toString(Integer.parseInt(pesanan.get(pesanan.size() - 1).getId()) + 1));
        }
        pesanan.add(p);
    }

    public void createKurir(String nama, String Asal, String Tujuan) {
        boolean nemu = false;

        if (kurir.size() == 0) {
            Kurir p = new Kurir(Integer.toString((this.i * 100) + (kurir.size() + 1)), nama, Asal, Tujuan);
            kurir.add(p);
        } else {
            Kurir p = new Kurir(Integer.toString(Integer.parseInt(kurir.get(kurir.size() - 1).getId()) + 1), nama, Asal, Tujuan);
            kurir.add(p);
        }

    }

    public String getPk() {
        return super.getPk();
    }

    public String getNama() {
        return super.getNama();
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getId() {
        return super.getId();
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pesanan getPesanan(int i) {
        return pesanan.get(i);

    }

    public Pesanan getKurir(int i) {
        return kurir.get(i);

    }

    public int getLength() {
        return pesanan.size();
    }

    public int getLengthk() {
        return kurir.size();
    }

    public void Removepesanan(int i) {
        pesanan.remove(i);

    }

    public void Removekurir(int i) {
        kurir.remove(i);

    }

}
