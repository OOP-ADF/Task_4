/*
  * Biyan Ilham Akbar (1301144319)
  * IF 38 09
  */
 package chatGUI;
 
 /**
  *
  * @author biyan
  */
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import javaChat.ClientConnection;
 public class ChatController {
     private ChatView view;
     private ClientConnection client = null;
     
     public ChatController() {
         view = new ChatView();
         view.setVisible(true);
         view.addListener((ActionListener) this);
         client = null;
     }
     class WriteOutput extends Thread {
         @Override
         public void run() {
             try {
                 String inputan;
                 while ((inputan = client.readStream()) != null) {
                     view.setTxAreaChat(inputan);
                 }
             }
             catch (Exception e) {
                 System.out.println("Error");
             }
         }
         public void actionPerformed (ActionEvent ae) { 
             Object souce = ae.getSource();
             try{
                 String ip = view.getStringChat();
                 client.connect(ip);
                 WriteOutput w = new WriteOutput();
                 w.start();
             }
             catch (Exception e) {
                 System.out.println("Error");
             }
             String input = view.getStringChat();
             client.writeStream(input);
             view.setTxFieldChat("");
         }
     }
 }