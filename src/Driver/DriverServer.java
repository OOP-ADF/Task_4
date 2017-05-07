/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;
import javaChat.ConnectionThread;
import javaChat.ServerConnection;
/**
 *
 * @author YangPentingHappy
 */
public class DriverServer {
    public static void main(String[] args) {
        try {
            ServerConnection s = new ServerConnection();
            System.out.println("System Information");
            System.out.println(s.getServerInformation());
            while(true){
                ConnectionThread connection = new ConnectionThread(s.getClient());
            }
        } catch (Exception e) {
            System.out.println("System Error");
        }
    }
}
