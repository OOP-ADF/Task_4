# Task_4 2017
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
	![01](https://cloud.githubusercontent.com/assets/13241336/24838003/47eae6d0-1d6a-11e7-9c60-74e646db74de.JPG) <br>
 * buatlah class sesuai class diagram berikut <br>
	![02](https://cloud.githubusercontent.com/assets/13241336/24838004/47efac38-1d6a-11e7-9469-d84bfce698fb.JPG) <br>
	
#### Constructor
 * Constructor throws IOException
 * Constructor mengeset attribut client dan menginstansiasi objek Connection dengan input client <br>
	![03](https://cloud.githubusercontent.com/assets/13241336/24838006/47f63c6a-1d6a-11e7-848e-7070c0503ec3.JPG) <br>
 
#### method run()
 * Merupakan method yang dijalankan saat thread diaktifkan
 * Thread akan aktif setiap ada Client baru yang terhubung ke Server
 * Thread akan berhenti ketika Client mengirimkan pesan "quit"
 * lakukan proses berikut dalam blok <b> try-catch </b>
  * jalankan proses chatting dengan memanggil method startChat(String) dari objek connection <br>
  ![04](https://cloud.githubusercontent.com/assets/13241336/24838005/47f3b74c-1d6a-11e7-80a9-4625e38a221f.JPG) <br>
  * tampilkan informasi Client yang terhubung dengan method getClientInformation dari Objek connection <br>
  ![05](https://cloud.githubusercontent.com/assets/13241336/24838008/481131b4-1d6a-11e7-8f61-50c4c27b8b24.JPG) <br>
  * lakukan proses loop membaca inputan text dari client dengan memanggil method readStream() dari objek connection selama input readStream masih membaca dan input String bukanlah "quit" 
  * tampilkan pesan yang diterima dari client, dan kirimkan (broadcast) pesat tersebut ke client yang lain menggunakan method sendToAll() dari objek connection <br>
  ![06](https://cloud.githubusercontent.com/assets/13241336/24838007/480487de-1d6a-11e7-9802-5b446d56e83c.JPG) <br>
  * tampilkan pesan kepada semua client jika ada client yang keluar dari chat room, kemudian putuskan koneksi terhadap client tsb dengan memanggil method disconnect() dari object connection <br>
  ![07](https://cloud.githubusercontent.com/assets/13241336/24838009/4821394c-1d6a-11e7-9404-42bedc403a17.JPG)<br>
  * tambahkan pesan di blok <b> catch </b> untuk menampilkan pesan error
 
### ConsoleApplication.java
Buatlah class ConsoleApplication.java sebagai berikut
 * buatlah class sesuai class diagram berikut <br>
	![08](https://cloud.githubusercontent.com/assets/13241336/24838010/4826b34a-1d6a-11e7-9e3a-e6d849949100.JPG) <br>
 * class ReadInput dan WriteOutput merupakan <b> Inner Class </b>
 
 #### inner class ReadInput
  * <b> extends Thread </b>
  * method run()
   * lakukan proses berikut dalam blok <b> try-catch </b>
   * Thread akan membaca input keyboard dari client dengan memanggil method inputString()
   * Mengirimkan hasil input keyboard ke server melalui method writeStream() selama input dari client bukanlah kata "quit" <br>
	![09](https://cloud.githubusercontent.com/assets/13241336/24838011/482a861e-1d6a-11e7-8fc9-173a14f8e567.JPG) <br>
   * tambahkan pesan di blok <b> catch </b> untuk menampilkan pesan error
 
 #### inner class WriteOutput
  * <b> extends Thread </b>
  * method run()
   * lakukan proses berikut dalam blok <b> try-catch </b>
   * Thread akan menerima pesan yang dikirimkan dari server melalui method readStream()
   * Menampilkan ke layar selama pesan dari server masih ada (bukan null) <br>
	![10](https://cloud.githubusercontent.com/assets/13241336/24838012/48306f2a-1d6a-11e7-9a43-f47ee2b98f02.JPG) <br>
   * tambahkan pesan di blok <b> catch </b> untuk menampilkan pesan error
 
 #### method startChat()
  * lakukan proses berikut dalam blok <b> try-catch </b>
   * Instansiasi objek ClientConnection <br>
	![11](https://cloud.githubusercontent.com/assets/13241336/24838013/483c890e-1d6a-11e7-98b6-4c301860475b.JPG) <br>
   * Minta input alamat ip Server menggunakan method inputString()
   * Koneksikan ip client ke server dengan memanggil method connect(ip) <br>
	![12](https://cloud.githubusercontent.com/assets/13241336/24838014/484be2c8-1d6a-11e7-8692-b8d78bc9278b.JPG) <br>
   * Instansiasi dan jalankan Thread ReadInput dan WriteInput <br>
	![13](https://cloud.githubusercontent.com/assets/13241336/24838015/4857e94c-1d6a-11e7-8dc2-8d4532139dd0.JPG) <br>
   * tambahkan pesan di blok <b> catch </b> untuk menampilkan pesan error

## Package chatGUI
 ---
Package berisi kelas view GUI dan controller

### ChatView.java
Buatlah class JFrame ChatView.java dengan tampilan sebagai berikut <br>
	![16](https://cloud.githubusercontent.com/assets/13241336/24838018/4866d664-1d6a-11e7-973e-f8d8fce9fd69.JPG) <br>
 * terdapat sebuah text area (txAreaChat)
 * set editable text area = false (uncheck editable) 
 * tambahkan text "Input Server IP Address : " pada text area<br>
	![17](https://cloud.githubusercontent.com/assets/13241336/24838019/4875389e-1d6a-11e7-8eac-c0d8458cec6d.JPG) <br>
 * terdapat sebuah text field (txFieldChat)
 * tambahkan method getTxFieldChat() yang mengembalikan objek text field txFieldChat
 * tambahkan method getStringChat() yang mengembalikan String dari text field txFieldChat
 * tambahkan method setTxFieldChat(String) yang mengeset String pada text field txFieldChat
 * tambahkan method setTxAreaChat(String) yang menambahkan string pada baris baru pada text area txAreaChat	<br>
	![18](https://cloud.githubusercontent.com/assets/13241336/24838020/48857ff6-1d6a-11e7-85ac-5ec918c3f5de.JPG) <br>
 * import java.awt.event.ActionListener;
 * tambahkan method addListener(ActionListener e)
 * tambahkan add listener dengan memanggil method addActionListener pada text field txfieldChat<br>
	![19](https://cloud.githubusercontent.com/assets/13241336/24838021/48a8a4a4-1d6a-11e7-9282-e179f4354f66.JPG) <br>

### ChatController.java
Buatlah class JChatController.java sebagai berikut <br>
 * buatlah class sesuai class diagram berikut <br>
	![20](https://cloud.githubusercontent.com/assets/13241336/24838022/48ac72dc-1d6a-11e7-9a64-c667207f5ba3.JPG) <br>
 * class WriteOutput merupakan <b> Inner Class </b>
 * import java.awt.event.ActionListener;
 * kelas <b> implements ActionListener </b>
 * implementasikan method actionPerformed(ActionEvent ae)
 
#### Constructor ChatController
 * Constructor menginstansiasi GUI view
 * set visible view = true
 * set lisener view dengan controller this
 * set client = null <br>
	![21](https://cloud.githubusercontent.com/assets/13241336/24838023/48af978c-1d6a-11e7-8687-556450c3f166.JPG) <br>

#### inner class WriteOutput
 * <b> extends Thread </b>
 * method run()
  * lakukan proses berikut dalam blok <b> try-catch </b>
  * Thread akan menerima pesan yang dikirimkan dari server melalui method readStream()
  * Menampilkan pesan ke text area view selama pesan dari server masih ada (bukan null) menggunakan method setTxAreaChat <br>
	![23](https://cloud.githubusercontent.com/assets/13241336/24838025/48b71034-1d6a-11e7-8a34-2eba0fd76ae6.JPG) <br>
  * tambahkan pesan di blok <b> catch </b> untuk menampilkan pesan error
 	
#### method actionPerformed(ActionEvent ae)
 * get Object source action event<br>
	![22](https://cloud.githubusercontent.com/assets/13241336/24838024/48b3917a-1d6a-11e7-82be-7034ca4b1dbe.JPG) <br>
 * cek source action event
 * jika event berasal dari text field (tekan tombol enter di text field), cek apakah client sudah terhubung
 * jika client masih null
  * lakukan proses berikut dalam blok <b> try-catch </b> 
  * instansiasi ClientConnection baru
  * Terima string ip dari user dengan memanggil method getStringChat dari objek view<br>
	![24](https://cloud.githubusercontent.com/assets/13241336/24838026/48c684c4-1d6a-11e7-96c1-749c7c99fa9c.JPG) <br>
  * Instansiasi dan jalankan objek WriteOutput<br>
	![25](https://cloud.githubusercontent.com/assets/13241336/24838027/48e2eb8c-1d6a-11e7-87c2-d5edd36bbbb4.JPG) <br>
  * tambahkan pesan di blok <b> catch </b> untuk menampilkan pesan error
 * jika client sudah terbentuk (koneksi sudah terbentuk)
  * terima input dari view menggunakan method getStringChat()
  * kirimkan hasil input String ke server melalui method writeStream()<br>
	![26](https://cloud.githubusercontent.com/assets/13241336/24838028/48e4e428-1d6a-11e7-9dd6-1be75b5816bb.JPG) <br>
 * hapus isi dari text field pada view menggunakan method setTxFieldChat<br>
	![27](https://cloud.githubusercontent.com/assets/13241336/24838029/48e6fd62-1d6a-11e7-8d3c-a72e5ee005ec.JPG) <br>

## Package driver
  ---
Package berisi kelas-kelas model

### DriverServer.java
Buatlah class DriverServer.java sebagai berikut
 * kelas memiliki main method (psvm)
 * lakukan proses berikut dalam blok <b> try-catch </b> di dalam main method
  * Instansiasi objek ServerConnection dan tampilkan informasi server dengan memanggil method getServerInformation()<br>
	![14](https://cloud.githubusercontent.com/assets/13241336/24838016/485e7bae-1d6a-11e7-8072-05a72897aa4e.JPG) <br>
  * Lakukan perulangan untuk menjalankan ConnectionThread setiap server menerima Client baru
  * Jalankan thread connection<br>
	![15](https://cloud.githubusercontent.com/assets/13241336/24838017/4865aa00-1d6a-11e7-997c-f59cdf225d97.JPG) <br>
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
