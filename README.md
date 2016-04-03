# Task_4
Exercise on Inner Class and Threading


Buatlah program java untuk chatting antar computer sebagai berikut <br>

## Package javaChat
---
Package berisi kelas-kelas Socket dan Network Programming
<b><i> [disediakan] </i></b>

## Package consoleApp
---
Package berisi kelas-kelas model

### ConnectionThread.java
Buatlah class ConnectionThread.java sebagai berikut
 * <b> extends Thread </b>
 * import library berikut <br>
	![01] (/asset/01.JPG) <br>
 * buatlah class sesuai class diagram berikut <br>
	![02] (/asset/02.JPG) <br>
	
#### Constructor
 * Constructor throws IOException
 * Constructor mengeset attribut client dan menginstansiasi objek Connection dengan input client <br>
	![03] (/asset/03.JPG) <br>
 
#### method run()
 * Merupakan method yang dijalankan saat thread diaktifkan
 * Thread akan aktif setiap ada Client baru yang terhubung ke Server
 * Thread akan berhenti ketika Client mengirimkan pesan "quit"
 * lakukan proses berikut dalam blok <b> try-catch </b>
  * jalankan proses chatting dengan memanggil method startChat(String) dari objek connection <br>
  ![04] (/asset/04.JPG) <br>
  * tampilkan informasi Client yang terhubung dengan method getClientInformation dari Objek connection <br>
  ![05] (/asset/05.JPG) <br>
  * lakukan proses loop membaca inputan text dari client dengan memanggil method readStream() dari objek connection selama input readStream masih membaca dan input String bukanlah "quit" 
  * tampilkan pesan yang diterima dari client, dan kirimkan (broadcast) pesat tersebut ke client yang lain menggunakan method sendToAll() dari objek connection <br>
  ![06] (/asset/06.JPG) <br>
  * tampilkan pesan kepada semua client jika ada client yang keluar dari chat room, kemudian putuskan koneksi terhadap client tsb dengan memanggil method disconnect() dari object connection <br>
  ![07] (/asset/07.JPG) <br>
  * tambahkan pesan di blok <b> catch </b> untuk menampilkan pesan error
 
### ConsoleApplication.java
Buatlah class ConsoleApplication.java sebagai berikut
 * buatlah class sesuai class diagram berikut <br>
	![08] (/asset/08.JPG) <br>
 * class ReadInput dan WriteOutput merupakan <b> Inner Class </b>
 
 #### inner class ReadInput
  * <b> extends Thread </b>
  * method run()
   * lakukan proses berikut dalam blok <b> try-catch </b>
   * Thread akan membaca input keyboard dari client dengan memanggil method inputString()
   * Mengirimkan hasil input keyboard ke server melalui method writeStream() selama input dari client bukanlah kata "quit" <br>
	![09] (/asset/09.JPG) <br>
   * tambahkan pesan di blok <b> catch </b> untuk menampilkan pesan error
 
 #### inner class WriteOutput
  * <b> extends Thread </b>
  * method run()
   * lakukan proses berikut dalam blok <b> try-catch </b>
   * Thread akan menerima pesan yang dikirimkan dari server melalui method readStream()
   * Menampilkan ke layar selama pesan dari server masih ada (bukan null) <br>
	![10] (/asset/10.JPG) <br>
   * tambahkan pesan di blok <b> catch </b> untuk menampilkan pesan error
 
 #### method startChat()
  * lakukan proses berikut dalam blok <b> try-catch </b>
   * Instansiasi objek ClientConnection <br>
	![11] (/asset/11.JPG) <br>
   * Minta input alamat ip Server menggunakan method inputString()
   * Koneksikan ip client ke server dengan memanggil method connect(ip) <br>
	![12] (/asset/12.JPG) <br>
   * Instansiasi dan jalankan Thread ReadInput dan WriteInput <br>
	![13] (/asset/13.JPG) <br>
   * tambahkan pesan di blok <b> catch </b> untuk menampilkan pesan error

## Package chatGUI
 ---
Package berisi kelas view GUI dan controller

### ChatView.java
Buatlah class JFrame ChatView.java dengan tampilan sebagai berikut <br>
![16] (/asset/16.JPG) <br>
 * terdapat sebuah text area (txAreaChat)
 * set editable text area = false (uncheck editable) 
 * tambahkan text "Input Server IP Address : " pada text area<br>
	![17] (/asset/17.JPG) <br>
 * terdapat sebuah text field (txFieldChat)
 * tambahkan method getTxFieldChat() yang mengembalikan objek text field txFieldChat
 * tambahkan method getStringChat() yang mengembalikan String dari text field txFieldChat
 * tambahkan method setTxFieldChat(String) yang mengeset String pada text field txFieldChat
 * tambahkan method setTxAreaChat(String) yang menambahkan string pada baris baru pada text area txAreaChat	<br>
	![18] (/asset/18.JPG) <br>
 * import java.awt.event.ActionListener;
 * tambahkan method addListener(ActionListener e)
 * tambahkan add listener dengan memanggil method addActionListener pada text field txfieldChat<br>
	![19] (/asset/19.JPG) <br>

### ChatController.java
Buatlah class JChatController.java sebagai berikut <br>
 * buatlah class sesuai class diagram berikut <br>
	![20] (/asset/20.JPG) <br>
 * class WriteOutput merupakan <b> Inner Class </b>
 * import java.awt.event.ActionListener;
 * kelas <b> implements ActionListener </b>
 * implementasikan method actionPerformed(ActionEvent ae)
 
#### Constructor ChatController
 * Constructor menginstansiasi GUI view
 * set visible view = true
 * set lisener view dengan controller this
 * set client = null <br>
	![21] (/asset/21.JPG) <br>

#### inner class WriteOutput
 * <b> extends Thread </b>
 * method run()
  * lakukan proses berikut dalam blok <b> try-catch </b>
  * Thread akan menerima pesan yang dikirimkan dari server melalui method readStream()
  * Menampilkan pesan ke text area view selama pesan dari server masih ada (bukan null) menggunakan method setTxAreaChat <br>
	![23] (/asset/23.JPG) <br>
  * tambahkan pesan di blok <b> catch </b> untuk menampilkan pesan error
 	
#### method actionPerformed(ActionEvent ae)
 * get Object source action event<br>
	![22] (/asset/22.JPG) <br>
 * cek source action event
 * jika event berasal dari text field (tekan tombol enter di text field), cek apakah client sudah terhubung
 * jika client masih null
  * lakukan proses berikut dalam blok <b> try-catch </b> 
  * instansiasi ClientConnection baru
  * Terima string ip dari user dengan memanggil method getStringChat dari objek view<br>
	![24] (/asset/24.JPG) <br>
  * Instansiasi dan jalankan objek WriteOutput<br>
	![25] (/asset/25.JPG) <br>
  * tambahkan pesan di blok <b> catch </b> untuk menampilkan pesan error
 * jika client sudah terbentuk (koneksi sudah terbentuk)
  * terima input dari view menggunakan method getStringChat()
  * kirimkan hasil input String ke server melalui method writeStream()<br>
	![26] (/asset/26.JPG) <br>
 * hapus isi dari text field pada view menggunakan method setTxFieldChat<br>
	![27] (/asset/27.JPG) <br>

## Package driver
  ---
Package berisi kelas-kelas model

### DriverServer.java
Buatlah class DriverServer.java sebagai berikut
 * kelas memiliki main method (psvm)
 * lakukan proses berikut dalam blok <b> try-catch </b> di dalam main method
  * Instansiasi objek ServerConnection dan tampilkan informasi server dengan memanggil method getServerInformation()<br>
	![14] (/asset/14.JPG) <br>
  * Lakukan perulangan untuk menjalankan ConnectionThread setiap server menerima Client baru
  * Jalankan thread connection<br>
	![15] (/asset/15.JPG) <br>
  * tambahkan pesan di blok <b> catch </b> untuk menampilkan pesan error
  * <b> Jalankan kelas DriverServer </b>
 
### DriverClientConsole.java
Buatlah class DriverClient.java sebagai berikut
 * kelas memiliki main method (psvm)
 * instansiasi objek ConsoleApplication
 * panggil method startChat dari objek ConsoleApplication
 * <b> Jalankan kelas DriverClientConsole </b>
 * hubungkan dengan IP server
 * cobalah aplikasi chat console yang telah dibuat

### DriverClientGui.java
Buatlah class DriverClientGui.java sebagai berikut
 * kelas memiliki main method (psvm)
 * instansiasi objek ChatController
 * <b> Jalankan kelas DriverClientGui </b>
 * hubungkan dengan IP server
 * cobalah aplikasi chat Gui yang telah dibuat
