/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author SagabAdi
 */
public class Controller2 {
    private Model model;
    private G2 g2;
    int l = 0;
    public Controller2 (G2 g2, Model model,int i){
        this.g2 = g2;
        this.model = model;
        if (model.pe.get(i).getLength() >= 0){
            for (int j = 0 ; j < model.pe.get(i).getLength() ; j ++){
                g2.setTpesan(model.pe.get(i).getPesanan(j).getId(), model.pe.get(i).getPesanan(j).getAsal(), model.pe.get(i).getPesanan(j).getTujuan());
            }
        }
        g2.setUse(model.pe.get(i).getNama(),Integer.toString(i+1));
        this.g2.addListener1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a,b;
                
                a = g2.getAsal();
                b = g2.getTujuan();
                model.pe.get(i).createPesanan(a, b);
                l = model.pe.get(i).getLength();
                JOptionPane.showMessageDialog(null, "Pesanan Berhasil");
                g2.reset();
                g2.setTpesan(model.pe.get(i).getPesanan(l-1).getId(), model.pe.get(i).getPesanan(l-1).getAsal(), model.pe.get(i).getPesanan(l-1).getTujuan());
            }
        });
        this.g2.addListener2(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String j;
                j = g2.getBatals();
                if (model.pe.get(i).getLength() == 0){
                    JOptionPane.showMessageDialog(null, "PESANAN KOSONG !!");
                    g2.reset();
                }
//                else if (g2.getBatals()== "" || (j-1 > l-1)){
//                    JOptionPane.showMessageDialog(null, "Isi dengan benar!!");
//                    g2.reset();
//                }
                else {
                JOptionPane.showMessageDialog(null, "Pesanan Berhasil Dibatalkan");
                g2.reset();
                int n = 0;
                boolean nemu = false;
                while (nemu != true){
                    if (model.pe.get(i).getPesanan(n).getId().equals(j)){
                        nemu = true;
                    }
                    else{
                        n++;
                    }
                }
                model.pe.get(i).Removepesanan(n);
                g2.removeRow(n);
                }
            }
        });
        this.g2.addListener3(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g2.dispose();
                G1 g = new G1 ();
                Controller c = new Controller(g, model);
                g.setVisible(true);
            }
        });
    }
}
