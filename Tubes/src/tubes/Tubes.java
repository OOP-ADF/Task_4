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
public class Tubes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        G1 g = new G1();
        Model model = new Model();
        Controller c = new Controller(g, model);
        g.setVisible(true);
        AplikasiConsole apps = new AplikasiConsole(model);
        apps.appss();
        
    }
}
