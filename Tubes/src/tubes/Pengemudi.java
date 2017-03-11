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
public class Pengemudi extends Orang {

    private List<Pesanan> pesanan;
    private String Nama;
    private String id;

    public Pengemudi(String Nama, String id) {
        super(Nama, id);
        List pesanan = new ArrayList();
    }

    public void addPesanan(Pesanan p) {
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
    public void Removepesanan (){
        
    }
    
}
