 package Driver;
  import consoleApp.ConnectionThread;
  import java.io.IOException;
  import javaChat.ServerConnection;
  
  public class DriverServer {
  
     
      public static void main(String[] args) {
          try {
              ServerConnection server = new ServerConnection();
              System.out.println("Server Information");
              System.out.println(server.getServerInformation());
              while(true) {
                  ConnectionThread connection = new ConnectionThread(server.getClient());
                  connection.start();
              }
          } catch (IOException ex) {
              System.out.println("Error : "   ex.getMessage());
          }
      }
      
  }