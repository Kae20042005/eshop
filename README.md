# Module 2 Reflection

(1) Seperti menggunakan exception yang generic, strategi saya untuk membenarkannya adalah dengan cara mencoba untuk membuat exception yang lebih spesifik, semisal untuk value yang tidak ada maka menggunakan NullPointerException.<br>
(2) Iya, Karena saya telah membuat workflow untuk melakukan pemeriksaan dan deploy secara otomatis melalui file build.yml, ci.yml, dan scorecard.yml. Otomasi ini terjadi ketika saya melakukan push ke github saya, sehingga file-file tersebut membantu memeriksa dan mendeploy kode aplikasi saya.

# Module 3 Reflection

(1) Prinsip yang baru saja saya tambahkan ke project adalah prinsip Single Responsibility Principle (SRP), Open-Closed Principle (ORP), dan Dependency Inversion. Untuk Liskov Subtitution dan Interface Segregation tidak saya tambahkan karena project saya telah memenuhi kedua prinsip tersebut.<br>
(2) Keuntungan dari penerapan SOLID pada project saya adalah project saya menjadi lebih mudah untuk dirawat dan jika ada perubahan akan lebih mudah dilakukannya. Misalkan, dengan memisahkan method update untuk setiap attribute jika ada perubahan pada attributenya kita bisa tinggal menambahkan atau mengurangi method update attribute tersebut saja.<br>
(3) Kerugian dari tidak menerapkan SOLID pada project saya adalah project saya menjadi sulit untuk dimodifikasi. Misal, jika ada perubahan struktur data pada penyimpanan carData, maka kita perlu menulis ulang banyak method.