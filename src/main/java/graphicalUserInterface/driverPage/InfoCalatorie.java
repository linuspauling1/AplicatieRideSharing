package graphicalUserInterface.driverPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InfoCalatorie {

    private JFrame frmInfoCursa;
    private int distanta;
    private boolean flag;
    private JButton btnNewButton;

    public JButton getBtnNewButton(){
        return btnNewButton;
    }

    public boolean isFlag(){
        return flag;
    }

    /**
     * Create the application.
     */
    public InfoCalatorie(int distanta) {
        this.distanta = distanta;
        initialize();
        frmInfoCursa.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmInfoCursa = new JFrame();
        frmInfoCursa.setTitle("informatii cursa");
        frmInfoCursa.getContentPane().setBackground(new Color(127, 255, 212));
        frmInfoCursa.setBounds(100, 100, 450, 300);
        frmInfoCursa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmInfoCursa.getContentPane().setLayout(null);
        frmInfoCursa.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(frmInfoCursa,"Leave" +
                        " ?","Confirmare iesire :", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                    frmInfoCursa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                else
                    frmInfoCursa.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });

        btnNewButton = new JButton("Inapoi");
        btnNewButton.setBounds(152, 184, 115, 29);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                flag = true;
                DriverPage.afiseaza();
                frmInfoCursa.setVisible(false);
            }
        });
        frmInfoCursa.getContentPane().add(btnNewButton);

        JLabel lblNewLabel = new JLabel("Durata cursa:");
        lblNewLabel.setFont(new Font("Showcard Gothic", Font.BOLD, 16));
        lblNewLabel.setBounds(82, 48, 136, 26);
        frmInfoCursa.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("\tPret cursa:");
        lblNewLabel_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(82, 132, 136, 26);
        frmInfoCursa.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("" + distanta * 3 + " lei");
        lblNewLabel_2.setBounds(261, 50, 69, 20);
        frmInfoCursa.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel(distanta * 2 + " minute");
        lblNewLabel_3.setBounds(261, 134, 69, 20);
        frmInfoCursa.getContentPane().add(lblNewLabel_3);
    }
}

