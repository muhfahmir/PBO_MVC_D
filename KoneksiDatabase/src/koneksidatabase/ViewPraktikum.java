package koneksidatabase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewPraktikum extends JFrame {
    //tampilan aja
    JLabel lNim = new JLabel("NIM                               :");
    JTextField tfNim = new JTextField();
    JLabel lNamaMhs = new JLabel("Nama Mahasiswa    :");
    JTextField tfNamaMhs = new JTextField();
    JLabel lAlamatMhs = new JLabel("Alamat Mahasiswa  :");
    JTextField tfAlamatMhs = new JTextField();
    JButton btnTambahPanel = new JButton("Tambah");
    JButton btnBatalPanel = new JButton("Batal");
    JButton btnUpdatePanel = new JButton("Update");
    JButton btnHapusPanel = new JButton("Hapus");
    JButton btnExitPanel = new JButton("Exit");
    Font fontt = new Font("SanSerif", Font.PLAIN, 20);

    JTable tabel;
    DefaultTableModel tableModel; //otomatis dibuat kalo buat JTable
    JScrollPane scrollPane;
    Object namaKolom[] = {"NIM","Nama","Alamat"}; //membuat kolom dgn array tipe object;

    public ViewPraktikum() {
        tableModel = new DefaultTableModel(namaKolom,0); //0 menandakan jumlah baris
        tabel = new JTable(tableModel); //tabel merupakan variabel untuk tabelnya dengan isi tablemodel
        scrollPane = new JScrollPane(tabel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Mahasiswa");
        JLabel judul = new JLabel("Data Mahasiswa");
        setVisible(true);
        setLayout(null);
        setSize(660, 550);

        add(judul);
        judul.setBounds(200,15,165,20);
        judul.setFont(fontt);
        add(lNim);
        lNim.setBounds(150, 50, 135, 20);
        add(tfNim);
        tfNim.setBounds(280, 50, 120, 20);
        add(lNamaMhs);
        lNamaMhs.setBounds(150, 75, 135, 20);
        add(tfNamaMhs);
        tfNamaMhs.setBounds(280, 75, 120, 20);
        add(lAlamatMhs);
        lAlamatMhs.setBounds(150, 100, 135, 20);
        add(tfAlamatMhs);
        tfAlamatMhs.setBounds(280, 100, 120, 20);
        add(btnTambahPanel);
        btnTambahPanel.setBounds(40, 145, 90, 20);
        add(btnBatalPanel);
        btnBatalPanel.setBounds(150, 145, 90, 20);
        add(btnUpdatePanel);
        btnUpdatePanel.setBounds(260, 145, 90, 20);
        add(btnHapusPanel);
        btnHapusPanel.setBounds(370, 145, 90, 20);
        add(btnExitPanel);
        btnExitPanel.setBounds(480, 145, 90, 20);

        //TABEL
        add(scrollPane);
        scrollPane.setBounds(20, 175, 580, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollpane-nya vertikal

        // mematikan tombol update dan hapus
        btnHapusPanel.setEnabled(false);
        btnUpdatePanel.setEnabled(false);
    }

    public String getNim(){
        return tfNim.getText();
    }
    public String getNama(){
        return tfNamaMhs.getText();
    }
    public String getAlamat(){
        return tfAlamatMhs.getText();
    }
}