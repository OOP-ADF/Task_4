/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import com.sun.javafx.css.CalculatedValue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author SagabAdi
 */
public class Controller {

    private Model model;
    private Gui g;
    
    public Controller (Gui g, Model model){
        this.g = g;
        this.model = model;
        this.g.addCalculationListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int a,b;
            a = g.getIn1();
            b = g.getIn2();
            model.setHasil(a, b);
            g.setOut(model.getHasil());
        }
    }
    
}
