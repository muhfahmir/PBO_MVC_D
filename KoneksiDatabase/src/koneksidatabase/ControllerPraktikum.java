package koneksidatabase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControllerPraktikum {

    //perantara model dan view
    ModelPraktikum modelPraktikum;
    ViewPraktikum viewPraktikum;

    public ControllerPraktikum(ModelPraktikum modelPraktikum, ViewPraktikum viewPraktikum) {
        this.modelPraktikum = modelPraktikum;
        this.viewPraktikum = viewPraktikum;

        if (modelPraktikum.getBanyakData() != 0) { //kalau banyak datanya tidak sama dengan 0
            String dataMahasiswa[][] = modelPraktikum.readMahasiswa(); //ambil method readMahasiswa di model
            viewPraktikum.tabel.setModel((new JTable(dataMahasiswa, viewPraktikum.namaKolom)).getModel());
            //menampilkan data yang ada didalam database ke tabel
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        viewPraktikum.btnTambahPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (viewPraktikum.getNim().equals("")
                        || viewPraktikum.getNama().equals("")
                        || viewPraktikum.getAlamat().equals("")) {
                    JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
                } else {

                    String nim = viewPraktikum.getNim();
                    String nama = viewPraktikum.getNama();
                    String alamat = viewPraktikum.getAlamat();

                    modelPraktikum.insertMahasiswa(nim, nama, alamat);
                    viewPraktikum.tfNim.setText("");
                    viewPraktikum.tfNamaMhs.setText("");
                    viewPraktikum.tfAlamatMhs.setText("");

                    //untuk menampilkan output langsung tanpa reload
                    String dataMahasiswa[][] = modelPraktikum.readMahasiswa();
                    viewPraktikum.tabel.setModel(new JTable(dataMahasiswa, viewPraktikum.namaKolom).getModel());
                }

            }
        });

        viewPraktikum.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { //alt+insert
                int baris = viewPraktikum.tabel.getSelectedRow();
                int kolom = viewPraktikum.tabel.getSelectedColumn(); //ga kepake
                //ngambil nim yang ada di kolom indeks 0
                String dataterpilih = viewPraktikum.tabel.getValueAt(baris, 0).toString();

                System.out.println(dataterpilih);
                //konfirmasi untuk menghapus
                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus NIM "+ dataterpilih+ "?", "Pilih Opsi...",JOptionPane.YES_NO_CANCEL_OPTION);

                if(input==0){
                    modelPraktikum.deleteMahasiswa(dataterpilih); //mengambil method hapus di model
                    //untuk menampilkan output langsung tanpa reload
                    String dataMahasiswa[][] = modelPraktikum.readMahasiswa();
                    viewPraktikum.tabel.setModel(new JTable(dataMahasiswa, viewPraktikum.namaKolom).getModel());
                }else{
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }



            }

        });
    }
}