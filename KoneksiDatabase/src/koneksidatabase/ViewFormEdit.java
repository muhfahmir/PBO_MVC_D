package koneksidatabase;

import javax.swing.*;
import java.awt.*;

public class ViewFormEdit extends JFrame {
    JLabel lnama = new JLabel("Nama        :");
    JTextField tfnama = new JTextField();
    JLabel lnim = new JLabel("NIM            :");
    JTextField tfnim = new JTextField();
    JLabel lalamat = new JLabel("Alamat     :");
    JTextField taalamat = new JTextField();
    Font fontt = new Font("SanSerif", Font.PLAIN, 20);

    JButton btnUpdatePanel = new JButton("Update");
    JButton btnBatalPanel = new JButton("Batal");

    public ViewFormEdit() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(350, 250);
        setBackground(Color.blue);
        setTitle("Form Edit");

        JLabel label = new JLabel("---Form Edit---");
        add(label);
        label.setBounds(100, 20, 200, 20);
        label.setFont(fontt);

        add(lnama);
        lnama.setBounds(50, 70, 90, 20);
        add(tfnama);
        tfnama.setBounds(150, 70, 120, 20);
        add(lnim);
        lnim.setBounds(50, 95, 90, 20);
        add(tfnim);
        tfnim.setBounds(150, 95, 120, 20);
        add(lalamat);
        lalamat.setBounds(50, 120, 90, 20);
        add(taalamat);
        taalamat.setBounds(150, 120, 120, 20);

        add(btnUpdatePanel);
        btnUpdatePanel.setBounds(60, 150, 90, 20);

        add(btnBatalPanel);
        btnBatalPanel.setBounds(170, 150, 90, 20);

    }

    public String getTfnama() {
        return tfnama.getText();
    }

    public String getTfnim() {
        return tfnim.getText();
    }

    public String getTaalamat() {
        return taalamat.getText();
    }
}
