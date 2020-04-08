package koneksidatabase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewPraktikum extends JFrame {
    //tampilan aja
    JLabel lNim = new JLabel("NIM    :");
    JTextField tfNim = new JTextField();
    JLabel lNamaMhs = new JLabel("Nama Mahasiswa   :");
    JTextField tfNamaMhs = new JTextField();
    JLabel lAlamatMhs = new JLabel("Alamat Mahasiswa  :");
    JTextField tfAlamatMhs = new JTextField();
    JButton btnTambahPanel = new JButton("Tambah");
    JButton btnBatalPanel = new JButton("Batal");
    JButton btnEditPanel = new JButton("Edit");

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
        lNim.setBounds(5, 5, 90, 20);
        add(tfNim);
        tfNim.setBounds(110, 5, 120, 20);
        add(lNamaMhs);
        lNamaMhs.setBounds(5, 30, 90, 20);
        add(tfNamaMhs);
        tfNamaMhs.setBounds(110, 30, 120, 20);
        add(lAlamatMhs);
        lAlamatMhs.setBounds(5, 55, 90, 20);
        add(tfAlamatMhs);
        tfAlamatMhs.setBounds(110, 55, 120, 20);
        add(btnTambahPanel);
        btnTambahPanel.setBounds(20, 105, 90, 20);
        add(btnBatalPanel);
        btnBatalPanel.setBounds(130, 105, 90, 20);

        //TABEL
        add(scrollPane);
        scrollPane.setBounds(20, 145, 480, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollpane-nya vertikal
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