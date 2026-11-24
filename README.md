# Student Management Application | Aplikasi Manajemen Data Siswa

## English

A desktop-based student management application built with Java Swing and SQLite. The application provides a login screen and tools to manage student records.

### Features
- Login and logout.
- Show or hide the password on the login screen.
- Add student records.
- View student records in a table.
- Update student records.
- Delete student records.
- Search student names.
- Display the total number of students.
- Store student data in an SQLite database.

### Technologies
- Java
- Java Swing
- SQLite
- JDBC
- Apache NetBeans

### Project Structure
- `FormLogin.java`: Login interface and authentication logic.
- `FormUtama.java`: Main interface and student data management.
- `Koneksi.java`: SQLite database connection and table initialization.
- `Sesi.java`: Stores the current username for the application session.
- `*.form`: NetBeans GUI Builder form files.

### Getting Started
1. Clone or download this repository.
2. Open the project in Apache NetBeans.
3. Make sure the SQLite JDBC driver is available in the project libraries.
4. Build and run the project from NetBeans.
5. The application creates the `siswa` table if it does not already exist.

---

## Bahasa Indonesia

Aplikasi desktop untuk mengelola data siswa yang dibuat menggunakan Java Swing dan SQLite. Aplikasi ini menyediakan halaman login serta fitur untuk mengelola data siswa.

### Fitur
- Login dan logout.
- Menampilkan atau menyembunyikan password pada halaman login.
- Menambahkan data siswa.
- Menampilkan data siswa dalam tabel.
- Mengubah data siswa.
- Menghapus data siswa.
- Mencari nama siswa.
- Menampilkan jumlah seluruh siswa.
- Menyimpan data siswa ke database SQLite.

### Teknologi
- Java
- Java Swing
- SQLite
- JDBC
- Apache NetBeans

### Struktur Proyek
- `FormLogin.java`: Tampilan login dan logika autentikasi.
- `FormUtama.java`: Tampilan utama dan pengelolaan data siswa.
- `Koneksi.java`: Koneksi database SQLite dan pembuatan tabel.
- `Sesi.java`: Menyimpan nama pengguna selama sesi aplikasi.
- `*.form`: File desain GUI dari NetBeans GUI Builder.

### Cara Menjalankan
1. Clone atau unduh repository ini.
2. Buka proyek menggunakan Apache NetBeans.
3. Pastikan SQLite JDBC driver sudah tersedia pada Libraries proyek.
4. Build dan jalankan proyek melalui NetBeans.
5. Aplikasi akan membuat tabel `siswa` jika tabel tersebut belum tersedia.
