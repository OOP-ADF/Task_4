/*
 * Fauzy Alfy A. (1301144269)
 * IF-38-09
 */
package Driver;

import consoleApp.ConnectionThread;
import javaChat.ServerConnection;

/*
 * @author Eggy
 */
public class DriverServer {
    public static void main(String[] args) {
        try {
            ServerConnection server = new ServerConnection();
            System.out.println("Server Information");
            System.out.println(server.getServerInformation());
            
            while (true) {
                ConnectionThread connection = new ConnectionThread(server.getClient());
                connection.start();
            }
        } catch (Exception e) {
            System.out.println("Error System : "+e.getMessage());
        }
    }
}
