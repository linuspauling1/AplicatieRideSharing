package graphicalUserInterface.customerPage;

import DOM.Parser;
import dataStructures.Client;
import dataStructures.ComandaEfectuata;
import dataStructures.ComandaNepreluata;
import graphicalUserInterface.AutentificationGUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class CustomerGUI {
    private Client client;
    private static Client ocupat;
    private static JFrame f;
    private JButton b1,b2,b3,b4;
    private JLabel l1,l2;
    private boolean flag1,flag2,flag3,flag4;
    private static boolean flagFunction;
    private static boolean flagFunction0;
    private static boolean flagFunction1;
    private static boolean flagFunction2;

    public static boolean isFlagFunction0() {
        return flagFunction0;
    }

    public static boolean isFlagFunction1() {
        return flagFunction1;
    }

    public static boolean isFlagFunction() {
        return flagFunction;
    }

    public static boolean isFlagFunction2() {
        return flagFunction2;
    }

    public boolean isFlag1() {
        return flag1;
    }

    public boolean isFlag2() {
        return flag2;
    }

    public boolean isFlag3() {
        return flag3;
    }

    public boolean isFlag4() {
        return flag4;
    }

    public JButton getB1() {
        return b1;
    }

    public JButton getB2() {
        return b2;
    }

    public JButton getB3() {
        return b3;
    }

    public JButton getB4() {
        return b4;
    }

    public static void afiseaza(){
        flagFunction = true;
        f.setVisible(true);
    }
    public static boolean activ(){
        flagFunction0 = true;
        return f.isActive();
    }
    public static void ascunde(){
        flagFunction1 = true;
        f.setVisible(false);
    }
    public boolean find(String filename){
        ArrayList<ComandaNepreluata> aux = Parser.getNepreluata(filename);
        for(ComandaNepreluata tmp: aux)
            if(tmp.getClient().equals(client)&&CommandGUI.verificaData(tmp)==true)
                return true;
        return false;
    }

    public boolean check(String fileName){
        ArrayList<ComandaEfectuata> aux = Parser.getEfectuate(fileName);
        for(ComandaEfectuata tmp: aux)
            if(tmp.getClient().equals(client)&&tmp.getDistanta()==0)
                return true;
        return false;
    }

    public CustomerGUI(Client c){
        client=c;
        f = new JFrame("Customer's page");
        f.getContentPane().setBackground(new Color(44, 224, 174));
        b1 = new JButton("Comenzile mele");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag1 = true;
                f.setVisible(false);
                new ComenzileMele(c);
            }
        });
        b2 = new JButton("Comanda noua");
        b3 = new JButton("Scrieti recenzie");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag3 = true;
                f.setVisible(false);
                new Review(c);
            }
        });
        b4 = new JButton("Inapoi");
        l1 = new JLabel("Customer's page");
        l1.setBounds(225, 0, 300, 50);
        l1.setFont(new Font("Berlin Sans FB Demi",Font.BOLD, 25));
        l1.setForeground(Color.magenta);
        b1.setBounds(350,200,210,30);
        b2.setBounds(350,150,210,30);
        b3.setBounds(350,100,210,30);
        b4.setBounds(350,250,210,30);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag4 = true;
                f.setVisible(false);
                AutentificationGUI.afiseaza();
            }
        });
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src/main/resources/drive.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(250, 250,Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(dimg);
        l2 = new JLabel(icon);
        l2.setBounds(40, 60, 250, 250);
        f.pack();
        f.add(l1);
        f.add(l2);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                flag2 = true;
                f.setVisible(false);
                if(find("src/main/resources/data.xml"))
                    new CommandGUI(client);
                else if(check("src/main/resources/completed.xml"))
                    new CompletedGUI(client);
                else
                    new ComandaNoua(client);
            }
        });
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(f,"Leave" +
                        " ?","Confirmare iesire :", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                else
                    f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        f.setSize(700,400);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void setOcupat(Client ocupat) {
        flagFunction2 = true;
        CustomerGUI.ocupat = ocupat;
    }
}