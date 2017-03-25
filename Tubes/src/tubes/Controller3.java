/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author SagabAdi
 */
public class Controller3 {

    private Model model;
    private G3 g3;
    int x;

    public Controller3(G3 g3, Model model, int i) {
        this.model = model;
        this.g3 = g3;
        this.x = i;
        for (int j = 0; j < model.pe.size(); j++) {
            for (int k = 0; k < model.pe.get(j).getLength(); k++) {
                g3.settable(model.pe.get(j).getPk(), model.pe.get(j).getNama(), model.pe.get(j).getPesanan(k).getId(), model.pe.get(j).getPesanan(k).getAsal(), model.pe.get(j).getPesanan(k).getTujuan());

            }

        }
        for (int j = 0; j < model.peng.get(i).getLength(); j++) {
            g3.settterima(model.peng.get(i).getPesanan(j).getId(), model.peng.get(i).getPesanan(j).getAsal(), model.peng.get(i).getPesanan(j).getTujuan());
        }
        g3.Listener1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a, b;
                boolean nemu = false;
                boolean nemus = false;
                int i = 0;
                int j = 0;

                a = g3.getTerima1();
                i = Integer.parseInt(a) - 1;
                b = g3.getTerima2();

                while (nemu != true) {
                    if (model.pe.get(i).getPesanan(j).getId().equals(b)) {
                        nemu = true;
                    } else if (j != model.pe.get(i).getLength()) {
                        j++;
                    }
                }

                if (nemu == true) {
                    Pesanan p = new Pesanan();
                    p.setId(model.pe.get(i).getPesanan(j).getId());
                    p.setAsal(model.pe.get(i).getPesanan(j).getAsal());
                    p.setTujuan(model.pe.get(i).getPesanan(j).getTujuan());
                    model.peng.get(x).addPesanan(p);
                    JOptionPane.showMessageDialog(null, "Pesanan telah diambil");
                    g3.settterima(model.pe.get(i).getPesanan(j).getId(), model.pe.get(i).getPesanan(j).getAsal(), model.pe.get(i).getPesanan(j).getTujuan());
                } else {
                    JOptionPane.showMessageDialog(null, "Error!!");
                }
                g3.reset();
            }
        });
        g3.Listener2(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a;
                a = g3.getBatals2();
                if (g3.getBatals2().equals("")) {
                    JOptionPane.showMessageDialog(null, "Isi Dengan Benar !! ");
                } else {
                    a = g3.getBatals2();
                    if (model.peng.get(i).getLength() == 0) {
                        JOptionPane.showMessageDialog(null, "PESANAN KOSONG !!");
                        g3.reset();
                    } else {
                        JOptionPane.showMessageDialog(null, "Pesanan Berhasil Dibatalkan");
                        g3.reset();
                        int n = 0;
                        boolean nemu = false;
                        while (nemu != true) {
                            if (model.peng.get(i).getPesanan(n).getId().equals(a)) {
                                nemu = true;
                            } else {
                                n++;
                            }
                        }
                        model.peng.get(i).Removepesanan(n);
                        g3.removeRow(n);
                    }
                }
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
