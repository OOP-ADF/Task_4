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
    private String Nama;
    private String id;
    private int length;

    public Pelanggan(String Nama, String id) {
        super(Nama, id);

    }

    public void createPesanan(String Asal, String Tujuan) {
        Pesanan p = new Pesanan();
        p.setAsal(Asal);
        p.setId(Integer.toString(pesanan.size() + 1));
        p.setTujuan(Tujuan);
        pesanan.add(p);
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

    public int getLength() {
        return pesanan.size();
    }
    
    public void Removepesanan(int i) {
        pesanan.remove(i);
    }

}
