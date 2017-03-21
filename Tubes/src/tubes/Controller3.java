/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author SagabAdi
 */
public class Controller3 {

    private Model model;
    private G3 g3;

    public Controller3(G3 g3, Model model, int i) {
        this.model = model;
        this.g3 = g3;
        int j = 0;
        int k = 0;
        while (j != model.pe.size()) {
            while (k != model.pe.get(j).getLength()) {
                g3.settable(model.pe.get(j).getPk(), model.pe.get(j).getNama(), model.pe.get(j).getPesanan(k).getId(), model.pe.get(j).getPesanan(k).getAsal(), model.pe.get(j).getPesanan(k).getTujuan());
                k++;
            }
            j++;
        }
        g3.Listener1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a, b;
                a = g3.getTerima1();
                b = g3.getTerima2();

            }
        });
        g3.Listener2(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a, b;
                a = g3.getBatals1();
                b = g3.getBatals2();
            }
        });
        g3.Listener3(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g3.dispose();
                G1 g = new G1();
                Controller c = new Controller(g, model);
                g.setVisible(true);
            }
        });
    }
}
