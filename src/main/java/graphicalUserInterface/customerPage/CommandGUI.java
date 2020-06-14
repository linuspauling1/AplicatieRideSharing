package graphicalUserInterface.customerPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CommandGUI {
    private JFrame jf;
    public CommandGUI(){
        jf = new JFrame("Comanda in asteptare");
        jf.getContentPane().setBackground(new Color(127, 255, 212));
        JLabel lblComandaInAstepatre = new JLabel("Comanda in astepatre");
        lblComandaInAstepatre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
        lblComandaInAstepatre.setBounds(189, 116, 335, 72);
        jf.add(lblComandaInAstepatre);
        JButton btnInapoi = new JButton("Inapoi");
        btnInapoi.setBounds(288, 275, 115, 44);
        btnInapoi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jf.setVisible(false);
                CustomerGUI.afiseaza();
            }
        });
        jf.getContentPane().add(btnInapoi);
        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(jf,"Leave" +
                        " ?","Confirmare iesire :", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                else if( result == JOptionPane.NO_OPTION)
                    jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });

        jf.setSize(700,400);
        jf.setLayout(null);
        jf.setVisible(true);
    }
}

