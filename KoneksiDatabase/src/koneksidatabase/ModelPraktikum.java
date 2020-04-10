package koneksidatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelPraktikum {
    //mengkoneksikan ke database. model berisi query2
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/praktikum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";//nama database
    static final String USER = "root";
    static final String PASS = "";

    Connection koneksi;
    Statement statement; //untuk penggunaan query

    public ModelPraktikum() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi gagal");
        }

    }

    public void insertMahasiswa(String nim, String nama, String alamat){
        try{
            String query = "INSERT INTO `mahasiswa`(`NIM`, `Nama`, `Alamat`) VALUES ('"+nim+"','"+nama+"','"+alamat+"')";
            //String '"+string+"', kalau int "+int+"
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query); //excecute query nya
            System.out.println("Berhasil Ditambahkan");
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambah");

        }catch(Exception sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public String[][] readMahasiswa(){ //dua dimensi (baris-kolom)
        try{
            int jmlData = 0; //menampung jumlah data sebanyak jumlah data yang ada, defaultnya 0
            String data[][] = new String[getBanyakData()][3];//menampung array. barisnya isinya di getBanyakData,kolomnya itu atribut
            String query = "Select * from `mahasiswa`"; //proses pengambilan data
            ResultSet resultSet = statement.executeQuery(query); //result isinya tabel belum berupa string
            while(resultSet.next()){ //konversi tabel ke string
                data[jmlData][0] = resultSet.getString("NIM"); //Harus sesuai database
                data[jmlData][1] = resultSet.getString("Nama"); //Harus sesuai database
                data[jmlData][2] = resultSet.getString("Alamat"); //Harus sesuai database
                jmlData++; //barisnya berpindah terus sampai habis
                //jmlData = baris, kolom 0 nim 1 nama 2 alamat
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public int getBanyakData(){ //menghitung jumlah baris yg ada
        int jmlData = 0; //nilai awal 0
        try{
            statement = koneksi.createStatement();
            String query = "Select * from `mahasiswa`";
            ResultSet resultSet = statement.executeQuery(query); //pengambilan data dalam java dari database
            while(resultSet.next()){ //ambil nilai dari baris ke 0 sampai baris akhir
                jmlData++;
            }
            return jmlData; //mengembalikan jumlah data ke readMahasiswa
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    public void deleteMahasiswa(String nim){ //menghapus data bds nim
        try{
            String query = "DELETE FROM `mahasiswa` WHERE `NIM` = '"+nim+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");

        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
    public void updateMahasiswa(String nim, String nama, String alamat){
        try{

            statement = koneksi.createStatement();

            String query = "UPDATE `mahasiswa` SET `nim`='"+nim+"',`nama`='"+nama+"',`alamat`='"+alamat+"' WHERE `nim` = '"+nim+"'";
            statement.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Edit Data Sukses!");

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}