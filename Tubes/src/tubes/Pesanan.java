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
public class Pesanan {

    private String Id, Asal, Tujuan, Nama;

    public Pesanan(String Asal, String Tujuan) {
        this.Asal = Asal;
        this.Tujuan = Tujuan;
    }

    public Pesanan(String id,String nama, String Asal, String Tujuan) {
        this.Asal = Asal;
        this.Tujuan = Tujuan;
        this.Nama = nama;
        this.Id = id;
    }

    public String getAsal() {
        return Asal;
    }

    public String getNama() {
        return Nama;
    }

    public void setAsal(String Asal) {
        this.Asal = Asal;
    }

    public String getTujuan() {
        return Tujuan;
    }

    public void setTujuan(String Tujuan) {
        this.Tujuan = Tujuan;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

}
