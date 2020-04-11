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
    ViewFormEdit viewFormEdit;
    String dataterpilih = null;
    int baris,kolom;

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
                    // updateTable
                    updateTable(); // ke arah method updateTable
                }

            }
        });

        viewPraktikum.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { //alt+insert
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                baris = viewPraktikum.tabel.getSelectedRow();
                kolom = viewPraktikum.tabel.getSelectedColumn();

                dataterpilih = viewPraktikum.tabel.getValueAt(baris, 0).toString();
                System.out.println(dataterpilih);
                if (dataterpilih != null) {
                    viewPraktikum.btnHapusPanel.setEnabled(true);
                    viewPraktikum.btnUpdatePanel.setEnabled(true);
                    viewPraktikum.btnTambahPanel.setEnabled(false);
                }
            }

        });

        viewPraktikum.btnBatalPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewPraktikum.btnHapusPanel.setEnabled(false);
                viewPraktikum.btnUpdatePanel.setEnabled(false);
                viewPraktikum.btnTambahPanel.setEnabled(true);
                viewPraktikum.tfNim.setText("");
                viewPraktikum.tfNamaMhs.setText("");
                viewPraktikum.tfAlamatMhs.setText("");
            }
        });

        viewPraktikum.btnHapusPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if (dataterpilih != null) {
                        modelPraktikum.deleteMahasiswa(dataterpilih);
                        // update tabel
                        updateTable(); // mengarah ke method updateTable
                        viewPraktikum.btnHapusPanel.setEnabled(false);
                        viewPraktikum.btnUpdatePanel.setEnabled(false);
                        viewPraktikum.btnTambahPanel.setEnabled(true);
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Gagal Hapus!");
                }
            }
        });

        viewPraktikum.btnUpdatePanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    if(dataterpilih != null){
                        String dataEditNim = viewPraktikum.tabel.getValueAt(baris,0).toString();
                        String dataEditNama = viewPraktikum.tabel.getValueAt(baris,1).toString();
                        String dataEditAlamat = viewPraktikum.tabel.getValueAt(baris,2).toString();

                        System.out.println("data edit terpilih :"+dataEditNim+" "+dataEditNama+" "+dataEditAlamat+"");
                        viewFormEdit = new ViewFormEdit();

                        viewPraktikum.dispose();
                        viewFormEdit.tfnim.setText(dataEditNim);
                        viewFormEdit.tfnama.setText(dataEditNama);
                        viewFormEdit.taalamat.setText(dataEditAlamat);
                        viewFormEdit.tfnim.setEditable(false);
                        viewFormEdit.btnBatalPanel.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                viewFormEdit.dispose();
                                MVC_Praktikum mvc_praktikum = new MVC_Praktikum();
                            }
                        });
                        viewFormEdit.btnUpdatePanel.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                if(dataterpilih != null){
                                    modelPraktikum.updateMahasiswa(
                                            viewFormEdit.getTfnim(),
                                            viewFormEdit.getTfnama(),
                                            viewFormEdit.getTaalamat());
                                    viewFormEdit.dispose();
                                    MVC_Praktikum mvc_praktikum = new MVC_Praktikum();
                                }
                            }
                        });
                    }
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                    System.out.println("Edit Gagal!");
                }
            }
        });


    }

    private void updateTable(){
        String dataMahasiswa[][] =modelPraktikum.readMahasiswa();
        viewPraktikum.tabel.setModel(new JTable(dataMahasiswa,viewPraktikum.namaKolom).getModel());
    }
}