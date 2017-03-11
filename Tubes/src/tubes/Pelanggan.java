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

    private List<Pesanan> pesanan;
    private String Nama;
    private String id;

    public Pelanggan(String Nama, String id) {
        super(Nama, id);
        List pesanan = new ArrayList();
    }

    public void createPesanan(String Id,String Asal, String Tujuan) {
        Pesanan p = new Pesanan();
        p.setAsal(Asal);
        p.setId(Id);
        p.setTujuan(Tujuan);
        pesanan.add(p);
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pesanan getPesanan(int i) {
        return pesanan.get(i);

    }

}
