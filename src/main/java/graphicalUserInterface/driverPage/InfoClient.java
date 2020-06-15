package graphicalUserInterface.driverPage;

import DOM.Parser;
import dataStructures.Client;
import dataStructures.ComandaEfectuata;
import dataStructures.ComandaNepreluata;
import jsonClasses.JSONClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class InfoClient {
    private static JFrame frame;
    private ComandaNepreluata comanda;
    private Client client;
    public InfoClient(ComandaNepreluata c) {
        comanda=c;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void cautaClient(){
        String nume=comanda.getUsernameClient();
        ArrayList<Client> clienti= JSONClient.getClient();
        Iterator<Client> it=clienti.iterator();
        while(it.hasNext()){
            Client c=it.next();
            if(nume.equals(c.getUsername())){
                client=c;
            }
        }
    }

    public static void afisare(){
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 16));
        frame.getContentPane().setForeground(new Color(0, 0, 128));
        frame.getContentPane().setBackground(new Color (255, 165,0));
        frame.getContentPane().setLayout(null);
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
        cautaClient();

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 128));
        panel.setBounds(0, 0, 686, 52);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Informatii client");
        lblNewLabel.setBackground(Color.BLUE);
        lblNewLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 24));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(228, 10, 226, 29);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(23, 62, 638, 274);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(0, 0, 128));
        panel_2.setBounds(23, 20, 589, 231);
        panel_1.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNume = new JLabel("Nume:");
        lblNume.setForeground(new Color(255, 255, 255));
        lblNume.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNume.setBounds(56, 23, 46, 16);
        panel_2.add(lblNume);

        JLabel lblTelefon = new JLabel("Telefon:");
        lblTelefon.setForeground(new Color(255, 255, 255));
        lblTelefon.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblTelefon.setBounds(56, 67, 109, 20);
        panel_2.add(lblTelefon);

        JLabel lblAdresa = new JLabel("Adresa:");
        lblAdresa.setForeground(new Color(255, 255, 255));
        lblAdresa.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblAdresa.setBounds(56, 115, 109, 29);
        panel_2.add(lblAdresa);

        JLabel lblCnp = new JLabel("CNP:");
        lblCnp.setForeground(new Color(255, 255, 255));
        lblCnp.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblCnp.setBounds(318, 21, 80, 20);
        panel_2.add(lblCnp);

        JLabel lblLocatie = new JLabel("Locatie:");
        lblLocatie.setForeground(new Color(255, 255, 255));
        lblLocatie.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblLocatie.setBounds(324, 63, 129, 29);
        panel_2.add(lblLocatie);

        JLabel lblDestinatie = new JLabel("Destinatie:");
        lblDestinatie.setForeground(new Color(255, 255, 255));
        lblDestinatie.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblDestinatie.setBounds(324, 115, 128, 29);
        panel_2.add(lblDestinatie);

        JButton btnTerminareComanda = new JButton("Terminare comanda");
        btnTerminareComanda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int distanta = (int)(Math.random()*5 + 1);
                ComandaEfectuata ce = new ComandaEfectuata(comanda.getClient(),comanda.getAn(),
                        comanda.getLuna(),comanda.getZi(),comanda.getOra(),comanda.getMinut(),
                        comanda.getSecunda(),comanda.getLocatie(),comanda.getDestinatie(),
                        DriverPage.getSofer(), distanta * 3, distanta);
                Parser.deleteEfectuate(ce);
                Parser.createXMLEfectuate(ce);
                frame.setVisible(false);
                new InfoCalatorie(distanta);
            }
        });
        btnTerminareComanda.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnTerminareComanda.setForeground(new Color(0, 0, 128));
        btnTerminareComanda.setBounds(61, 184, 175, 25);
        panel_2.add(btnTerminareComanda);

        JLabel lblNewLabel_1 = new JLabel(client.getUsername());
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1.setBounds(127, 21, 151, 20);
        panel_2.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel(client.getTelefon());
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_2.setBounds(127, 67, 109, 20);
        panel_2.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel(client.getAdresa());
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_3.setBounds(127, 119, 109, 20);
        panel_2.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel(client.getCNP());
        lblNewLabel_4.setForeground(new Color(255, 255, 255));
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_4.setBounds(418, 22, 109, 19);
        panel_2.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel(comanda.getLocatie());
        lblNewLabel_5.setForeground(new Color(255, 255, 255));
        lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_5.setBounds(424, 67, 118, 20);
        panel_2.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel(comanda.getDestinatie());
        lblNewLabel_6.setForeground(new Color(255, 255, 255));
        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_6.setBounds(424, 118, 103, 22);
        panel_2.add(lblNewLabel_6);
        frame.setSize(700, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnNewButton=new JButton("Inapoi");
        btnNewButton.setForeground(new Color(0,0,128));
        btnNewButton.setFont(new Font("Times New Roman",Font.BOLD,16));
        btnNewButton.setBounds(318,184,140,25);
        panel_2.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    DriverPage.afiseaza();
            }
        });
    }
}
