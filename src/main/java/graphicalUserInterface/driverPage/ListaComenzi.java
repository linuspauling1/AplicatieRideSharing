package graphicalUserInterface.driverPage;

import dataStructures.ComandaNepreluata;

import javax.swing.*;
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
        frame = new JFrame();
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
        scrollPane.setBounds(0, 0, 678, 213);
        frame.getContentPane().add(scrollPane);

        DefaultListModel<String> l1 = new DefaultListModel<>();
        int i = 0;
        for(ComandaNepreluata tmp: cn)
            l1.addElement("Preluati comanda " + " " + (++i) + " " + tmp.toString());

        JList list = new JList(l1);
        scrollPane.setViewportView(list);

        JTextPane textPane = new JTextPane();
        textPane.setBounds(391, 247, 30, 26);
        frame.getContentPane().add(textPane);

        JLabel lblNewLabel = new JLabel("Preluati comanda");
        lblNewLabel.setBounds(265, 239, 111, 34);
        frame.getContentPane().add(lblNewLabel);

        frame.setSize(700,400);
        frame.setVisible(true);
    }
}