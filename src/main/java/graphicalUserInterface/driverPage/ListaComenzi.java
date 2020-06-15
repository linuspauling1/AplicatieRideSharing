package graphicalUserInterface.driverPage;

import DOM.Parser;
import dataStructures.ComandaEfectuata;
import dataStructures.ComandaNepreluata;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ListaComenzi {

    private JFrame frame;
    private JTextPane textPane;
    private ArrayList<ComandaNepreluata> comandaNepreluata;
    /**
     * Create the application.
     */
    public ListaComenzi(ArrayList<ComandaNepreluata> cn) {
        comandaNepreluata=cn;
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
        for(ComandaNepreluata tmp: cn) {
            int an = Calendar.getInstance().get(Calendar.YEAR);
            int luna = Calendar.getInstance().get(Calendar.MONTH);
            int zi = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
            int ora = Calendar.getInstance().get(Calendar.HOUR);
            int minut = Calendar.getInstance().get(Calendar.MINUTE);
            int secunda = Calendar.getInstance().get(Calendar.SECOND);
            long time_now=(new Date(an,luna+1,zi,ora,minut,secunda).getTime());;
            long time_comanda=(new Date(tmp.getAn(),tmp.getLuna(),tmp.getZi(),tmp.getOra(),tmp.getMinut(),tmp.getSecunda()).getTime());
            int TIME_VISIBLE=(int)(5*60*1000-(time_now-time_comanda));
            if(TIME_VISIBLE>=0)
                   l1.addElement("Preluati comanda " + " " + (++i) + " " + tmp.toString());
        }
        JList list = new JList(l1);
        list.setBackground(new Color(0, 153, 153));
        scrollPane.setViewportView(list);

        textPane = new JTextPane();
        textPane.setBounds(391, 247, 30, 26);
        frame.getContentPane().add(textPane);

        JButton lblNewLabel = new JButton("Preluati comanda");
        lblNewLabel.setBounds(245, 239, 141, 34);
        frame.getContentPane().add(lblNewLabel);
        lblNewLabel.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ev){
               int number=Integer.parseInt(textPane.getText());
               try{
                   ComandaNepreluata comanda = comandaNepreluata.get(number - 1);
                   ComandaEfectuata ce = new ComandaEfectuata(comanda.getClient(),comanda.getAn(),
                           comanda.getLuna(),comanda.getZi(),comanda.getOra(),comanda.getMinut(),
                           comanda.getSecunda(),comanda.getLocatie(),comanda.getDestinatie(),
                           DriverPage.getSofer(),0,0);
                   Parser.createXMLEfectuate(ce);
                   Parser.delete(comanda);
                   new InfoClient(comanda);
                   frame.setVisible(false);
               }catch (IndexOutOfBoundsException e){
                   JOptionPane.showMessageDialog(frame, "Index ilegal!Reintroduceti numarul.");
               }
        }});

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