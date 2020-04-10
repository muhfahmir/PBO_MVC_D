package koneksidatabase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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

    JTable tabel;
    DefaultTableModel tableModel; //otomatis dibuat kalo buat JTable
    JScrollPane scrollPane;
    Object namaKolom[] = {"NIM","Nama","Alamat"}; //membuat kolom dgn array tipe object;

    public ViewPraktikum() {
        tableModel = new DefaultTableModel(namaKolom,0); //0 menandakan jumlah baris
        tabel = new JTable(tableModel); //tabel merupakan variabel untuk tabelnya dengan isi tablemodel
        scrollPane = new JScrollPane(tabel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(600, 500);

        add(lNim);
        lNim.setBounds(120, 15, 135, 20);
        add(tfNim);
        tfNim.setBounds(250, 15, 120, 20);
        add(lNamaMhs);
        lNamaMhs.setBounds(120, 40, 135, 20);
        add(tfNamaMhs);
        tfNamaMhs.setBounds(250, 40, 120, 20);
        add(lAlamatMhs);
        lAlamatMhs.setBounds(120, 65, 135, 20);
        add(tfAlamatMhs);
        tfAlamatMhs.setBounds(250, 65, 120, 20);
        add(btnTambahPanel);
        btnTambahPanel.setBounds(40, 105, 90, 20);
        add(btnBatalPanel);
        btnBatalPanel.setBounds(150, 105, 90, 20);
        add(btnUpdatePanel);
        btnUpdatePanel.setBounds(260, 105, 90, 20);
        add(btnHapusPanel);
        btnHapusPanel.setBounds(370, 105, 90, 20);

        //TABEL
        add(scrollPane);
        scrollPane.setBounds(20, 145, 480, 300);
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