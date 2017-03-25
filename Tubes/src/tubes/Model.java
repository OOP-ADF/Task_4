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
        String c;
        if (pe.size() == 0) {

             c = (Integer.toString(pe.size() + 1));
        } else {
             c = (Integer.toString(Integer.parseInt(pe.get(pe.size() - 1).getPk()) + 1));
        }
        Pelanggan p = new Pelanggan (a,b,c,(pe.size()+1));
        pe.add(p);
    }

    public Pengemudi getPeng(int i) {
        return peng.get(i);
    }

    public void setPeng(String a, String b) {
        String c;
        if (peng.size() == 0) {

             c = (Integer.toString(peng.size() + 1));
        } else {
             c = (Integer.toString(Integer.parseInt(peng.get(peng.size() - 1).getPk()) + 1));
        }
        Pengemudi pe = new Pengemudi(a, b,c);
        peng.add(pe);
    }
    
    

}
