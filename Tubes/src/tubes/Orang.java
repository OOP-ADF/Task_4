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
public class Orang {

    private String Nama;
    private String id;
    private String pk;

    public Orang(String Nama, String id, String pk) {
        this.Nama = Nama;
        this.id = id;
        this.pk = pk;
    }

    public String getPk() {
        return pk;
    }

    public String getNama() {
        return Nama;
    }

    public String getId() {
        return id;
    }
}
