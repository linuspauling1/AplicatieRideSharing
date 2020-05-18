package graphicalUserInterface.driverPage;
import dataStructures.Client;
import dataStructures.ComandaNepreluata;
import jsonClasses.JSONClient;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class InfoClient {
    private JFrame frame;
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

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 16));
        frame.getContentPane().setForeground(new Color(0, 0, 128));
        frame.getContentPane().setBackground(new Color(0, 206, 209));
        frame.getContentPane().setLayout(null);
        cautaClient();

        JLabel lblNewLabel = new JLabel("Informatii client");
        lblNewLabel.setBackground(Color.BLUE);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNewLabel.setForeground(new Color(0, 0, 128));
        lblNewLabel.setBounds(111, 10, 226, 29);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNume = new JLabel("Nume:");
        lblNume.setForeground(new Color(0, 0, 128));
        lblNume.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNume.setBounds(23, 61, 46, 13);
        frame.getContentPane().add(lblNume);

        JLabel lblTelefon = new JLabel("Telefon:");
        lblTelefon.setForeground(new Color(0, 0, 128));
        lblTelefon.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblTelefon.setBounds(23, 100, 109, 20);
        frame.getContentPane().add(lblTelefon);

        JLabel lblAdresa = new JLabel("Adresa:");
        lblAdresa.setForeground(new Color(0, 0, 128));
        lblAdresa.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblAdresa.setBounds(23, 141, 109, 29);
        frame.getContentPane().add(lblAdresa);

        JLabel lblCnp = new JLabel("CNP:");
        lblCnp.setForeground(new Color(0, 0, 128));
        lblCnp.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblCnp.setBounds(23, 193, 80, 20);
        frame.getContentPane().add(lblCnp);

        JLabel lblLocatie = new JLabel("Locatie:");
        lblLocatie.setForeground(new Color(0, 0, 128));
        lblLocatie.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblLocatie.setBounds(228, 53, 129, 29);
        frame.getContentPane().add(lblLocatie);

        JLabel lblDestinatie = new JLabel("Destinatie:");
        lblDestinatie.setForeground(new Color(0, 0, 128));
        lblDestinatie.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblDestinatie.setBounds(228, 96, 128, 29);
        frame.getContentPane().add(lblDestinatie);

        JButton btnTerminareComanda = new JButton("Terminare comanda");
        btnTerminareComanda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnTerminareComanda.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnTerminareComanda.setForeground(new Color(0, 0, 128));
        btnTerminareComanda.setBounds(233, 220, 175, 21);
        frame.getContentPane().add(btnTerminareComanda);

        JLabel lblNewLabel_1 = new JLabel(client.getUsername());
        lblNewLabel_1.setForeground(new Color(0, 0, 128));
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1.setBounds(79, 61, 151, 13);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel(client.getTelefon());
        lblNewLabel_2.setForeground(new Color(0, 0, 128));
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_2.setBounds(90, 103, 109, 15);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel(client.getAdresa());
        lblNewLabel_3.setForeground(new Color(0, 0, 128));
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_3.setBounds(90, 145, 109, 20);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel(client.getCNP());
        lblNewLabel_4.setForeground(new Color(0, 0, 128));
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_4.setBounds(69, 196, 109, 15);
        frame.getContentPane().add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel(comanda.getLocatie());
        lblNewLabel_5.setForeground(new Color(0, 0, 128));
        lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_5.setBounds(290, 57, 118, 20);
        frame.getContentPane().add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel(comanda.getDestinatie());
        lblNewLabel_6.setForeground(new Color(0, 0, 128));
        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_6.setBounds(311, 103, 103, 15);
        frame.getContentPane().add(lblNewLabel_6);
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
