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
    public Controller2 (G2 g2, Model model,int i){
        this.g2 = g2;
        this.model = model;
        g2.setUse(model.pe.get(i).getNama());
        this.g2.addListener1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a,b;
                a = g2.getAsal();
                b = g2.getTujuan();
                model.pe.get(i).createPesanan(a, b);
                JOptionPane.showMessageDialog(null, "Pesanan Berhasil");
                
            }
        });
    }
}
