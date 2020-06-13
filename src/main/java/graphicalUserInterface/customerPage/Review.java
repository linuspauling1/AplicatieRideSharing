package graphicalUserInterface.customerPage;

import DOM.Parser;
import dataStructures.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Review {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private Client client;

    public Review(Client client) {
        this.client = client;
        initialize();
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame("Recenzii");
        frame.getContentPane().setBackground(new Color(0, 155, 255));
        frame.getContentPane().setLayout(null);

        JLabel lblRecenzii = new JLabel("Recenzii");
        lblRecenzii.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 30));
        lblRecenzii.setBounds(259, 42, 159, 34);
        frame.getContentPane().add(lblRecenzii);

        JButton btnNewButton = new JButton("Salvati\r\n");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textRecenzie = textField.getText();
                String data = textField_1.getText();
                try{
                    Parser.addReview(client,data,textRecenzie);
                } catch(Exception exception){
                    JOptionPane.showMessageDialog(frame, "Data incorecta.");
                }
                CustomerGUI.afiseaza();
                frame.setVisible(false);
            }
        });
        btnNewButton.setBounds(274, 254, 115, 29);

        frame.getContentPane().add(btnNewButton);

        JButton btnInapoi = new JButton("Inapoi");
        btnInapoi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                CustomerGUI.afiseaza();
            }
        });
        btnInapoi.setBounds(274, 299, 115, 29);
        frame.getContentPane().add(btnInapoi);

        JLabel label = new JLabel("Data:");
        label.setFont(new Font("Stencil", Font.PLAIN, 16));
        label.setBounds(86, 107, 69, 20);
        frame.getContentPane().add(label);

        JLabel lblNewLabel_1 = new JLabel("Recenzia:");
        lblNewLabel_1.setFont(new Font("Stencil", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(82, 165, 87, 41);
        frame.getContentPane().add(lblNewLabel_1);

        textField = new JTextField();
        textField.setFont(new Font("Sylfaen", Font.PLAIN, 18));
        textField.setBackground(new Color(240, 128, 128));
        textField.setBounds(200, 170, 300, 30);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Sylfaen", Font.PLAIN, 18));
        textField_1.setBackground(new Color(255, 160, 122));
        textField_1.setColumns(10);
        textField_1.setBounds(200, 104, 300, 30);
        frame.getContentPane().add(textField_1);
        frame.setBounds(100, 100, 700, 400);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(frame,"Leave" +
                        " ?","Confirmare iesire :", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                else if( result == JOptionPane.NO_OPTION)
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
    }
}

