package graphicalUserInterface.driverPage;

import dataStructures.ComandaNepreluata;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ListaComenzi {

    private JFrame frame;

    /**
     * Create the application.
     */
    public ListaComenzi(ArrayList<ComandaNepreluata> cn) {
        initialize(cn);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(ArrayList<ComandaNepreluata> cn) {
        frame = new JFrame("preluati comanda");
        frame.getContentPane().setBackground(new Color(0, 123, 123));
        frame.getContentPane().setForeground(Color.BLACK);
        frame.setBounds(100, 100, 502, 337);
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
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(5, 5, 673, 213);
        frame.getContentPane().add(scrollPane);

        DefaultListModel<String> l1 = new DefaultListModel<>();
        int i = 0;
        for(ComandaNepreluata tmp: cn)
            l1.addElement("Preluati comanda " + " " + (++i) + " " + tmp.toString());

        JList list = new JList(l1);
        list.setBackground(new Color(0, 153, 153));
        scrollPane.setViewportView(list);

        JTextPane textPane = new JTextPane();
        textPane.setBounds(391, 247, 30, 26);
        frame.getContentPane().add(textPane);

        JButton lblNewLabel = new JButton("Preluati comanda");
        lblNewLabel.setBounds(245, 239, 141, 34);
        frame.getContentPane().add(lblNewLabel);

        JButton btnInapoi = new JButton("Inapoi");
        btnInapoi.setBounds(255, 289, 115, 29);
        frame.getContentPane().add(btnInapoi);

        btnInapoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                DriverPage.afiseaza();
            }
        });

        frame.setSize(700,400);
        frame.setVisible(true);
    }
}