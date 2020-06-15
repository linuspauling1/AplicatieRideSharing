package graphicalUserInterface.customerPage;

import DOM.Parser;
import dataStructures.Client;
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
import java.util.Iterator;

public class CommandGUI {
    private JFrame jf;
    private ComandaNepreluata comanda;
    public CommandGUI(Client client){
        ArrayList<ComandaNepreluata> c= Parser.getNepreluata();
        Iterator<ComandaNepreluata>it=c.iterator();
        while(it.hasNext()) {
            ComandaNepreluata cn = it.next();
            if (cn.getUsernameClient().equals(client.getUsername()))
                comanda = cn;
        }
        int an = Calendar.getInstance().get(Calendar.YEAR);
        int luna = Calendar.getInstance().get(Calendar.MONTH);
        int zi = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int ora = Calendar.getInstance().get(Calendar.HOUR);
        int minut = Calendar.getInstance().get(Calendar.MINUTE);
        int secunda = Calendar.getInstance().get(Calendar.SECOND);
        long time_now=(new Date(an,luna+1,zi,ora,minut,secunda).getTime());;
        long time_comanda=(new Date(comanda.getAn(),comanda.getLuna(),comanda.getZi(),comanda.getOra(),comanda.getMinut(),comanda.getSecunda()).getTime());
        int TIME_VISIBLE=(int)(5*60*1000-(time_now-time_comanda));

        jf = new JFrame("Comanda in asteptare");
        jf.getContentPane().setBackground(new Color(127, 255, 212));
        JLabel lblComandaInAstepatre = new JLabel("Comanda in asteptare");
        lblComandaInAstepatre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
        lblComandaInAstepatre.setBounds(189, 116, 335, 72);
        jf.add(lblComandaInAstepatre);
        JButton btnInapoi = new JButton("Inapoi");
        btnInapoi.setBounds(288, 275, 115, 44);


        new Timer(TIME_VISIBLE, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jf.dispose();
                Parser.delete(comanda);
                ComandaNoua.afiseaza();
            }
        }).start();

        btnInapoi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
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

