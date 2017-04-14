package javaChat;
import java.awt.event.ActionEvent;
import javaChat.ClientConnection;
import java.awt.event.ActionListener;

public class ChatController implements ActionListener {
     private ChatView view;
     private ClientConnection client = null;
     
     public ChatController() {
         view = new ChatView();
         view.setVisible(true);
         view.addListener(this);
         client = null;
     }
     
     public class WriteOutput extends Thread{
         @Override
         public void run() {
             try {
                 String inputan;
                 while((inputan = client.readStream()) != null){
                     view.setTxAreaChat(inputan);
                 }
             } catch(Exception z) {
                 System.out.println("Exception occurred: " + z.getMessage());
             }
         }
     }
     
     @Override
     public void actionPerformed(ActionEvent ae) {
         Object source = ae.getSource();
         if (source == view.getTxFieldChat()) {
             if (client == null) {
                 try {
                     client = new ClientConnection();
                     String ip = view.getStringChat();
                     client.connect(ip);
                     WriteOutput w = new WriteOutput();
                     w.start();
                 } catch(Exception e) {
                     System.out.println("Exception occurred: " + e.getMessage());
                 }
             } else {
                 String input = view.getStringChat();
                 client.writeStream(input);
                 view.setTxFieldChat("");
             }
         }
     }
 }