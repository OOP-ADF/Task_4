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
public class Model {
    List<Pelanggan> pe = new ArrayList();
    List<Pengemudi> peng = new ArrayList();

    public Pelanggan getPe(int i) {
        return pe.get(i);
    }

    public void setPe(String a, String b) {
        Pelanggan p = new Pelanggan (a,b);
        pe.add(p);
    }

    public Pengemudi getPeng(int i) {
        return peng.get(i);
    }

    public void setPeng(String a, String b) {
        Pengemudi pe = new Pengemudi(a, b);
        peng.add(pe);
    }
    
    

}
