/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

/**
 *
 * @author SagabAdi
 */
public class Kurir extends Pesanan {

    private String idKurir, namaKurir, asal, tujuan;

    public Kurir(String id, String nama, String asal, String tujuan) {
        super(id, nama, asal, tujuan);
    }

    public String getNamaKurir() {
        return super.getNama();
    }

    public String getAsal() {
        return super.getAsal();
    }

    public String getTujuan() {
        return super.getTujuan();
    }

    public void setNamaKurir(String namaKurir) {
        this.namaKurir = namaKurir;
    }

    public String getIdKurir() {
        return super.getId();
    }

    public void setIdKurir(String idKurir) {
        this.idKurir = idKurir;
    }
}
