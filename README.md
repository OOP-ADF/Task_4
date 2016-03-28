# Task_4
Exercise on Inner Class and Threading


Buatlah program java untuk untuk chatting antar computer sebagai berikut <br>

## Package javaChat
Package berisi kelas-kelas Socket dan Network Programming
<i> disediakan </i>

## Package consoleApp
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
 * Constructor mengeset attribut client dan menginstansiasi objek Connection dengan input client
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
  
## Package driver
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
 
### DriverClient.java
Buatlah class DriverClient.java sebagai berikut
 * kelas memiliki main method (psvm)
 * instansiasi objek ConsoleApplication
 * panggil method startChat dari objek ConsoleApplication
