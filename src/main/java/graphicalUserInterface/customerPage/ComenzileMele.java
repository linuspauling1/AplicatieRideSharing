package graphicalUserInterface.customerPage;

import DOM.Parser;
import dataStructures.Client;
import dataStructures.ComandaEfectuata;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ComenzileMele {
    private Client client;
    private Object[][] campuriComanda;
    private static ArrayList<ComandaEfectuata> comandaDeAfisat;
    private JFrame frame;
    private JTable table;
    private JScrollPane scrollPane;

    public ComenzileMele(Client client) {
        this.client = client;
        comandaDeAfisat = Parser.getEfectuate();
        if (comandaDeAfisat != null) {
            int i = 0,size = 0;
            for (ComandaEfectuata tmp : comandaDeAfisat) {
                if (tmp.getClient().equals(client)) {
                    ++size;
                }
            }
            campuriComanda = new Object[size][5];
            for (ComandaEfectuata tmp : comandaDeAfisat) {
                if (tmp.getClient().equals(client)) {
                    campuriComanda[i][0] = tmp.getDestinatie();
                    campuriComanda[i][1] = tmp.getDistanta();
                    campuriComanda[i][2] = tmp.getPret();
                    campuriComanda[i][3] = tmp.getUsernameSofer();
                    campuriComanda[i++][4] = tmp.getReview();
                }
            }

            frame = new JFrame("Comenzile mele");
            frame.getContentPane().setBackground(SystemColor.activeCaption);
            frame.setBounds(100, 100, 700, 400);
            frame.getContentPane().setLayout(null);

            JLabel lblComenzileMele = new JLabel("Comenzile Mele");
            lblComenzileMele.setFont(new Font("Bernard MT Condensed", Font.BOLD, 22));
            lblComenzileMele.setBounds(264, 16, 158, 45);
            frame.getContentPane().add(lblComenzileMele);


            JButton btnInapoi = new JButton("Inapoi");
            btnInapoi.setBounds(275, 265, 115, 29);
            btnInapoi.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    CustomerGUI.afiseaza();
                }
            });
            frame.getContentPane().add(btnInapoi);

            scrollPane = new JScrollPane();
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setBounds(15, 64, 648, 177);
            frame.getContentPane().add(scrollPane);

            table = new JTable();
            table.setBackground(Color.LIGHT_GRAY);
            scrollPane.setViewportView(table);
            table.setModel(new DefaultTableModel(
                    campuriComanda,
                    new String[]{
                            "Destinatie", "Distanta", "Pret", "Sofer","Recenzie"
                    }
            ));
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    int result = JOptionPane.showConfirmDialog(frame, "Leave" +
                            " ?", "Confirmare iesire :", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION)
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    else if (result == JOptionPane.NO_OPTION)
                        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            });
            frame.setVisible(true);
        }
    }
}