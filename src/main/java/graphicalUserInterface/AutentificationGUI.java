package graphicalUserInterface;

import dataStructures.Client;
import dataStructures.Sofer;
import jsonClasses.JSONFile;
import graphicalUserInterface.customerPage.*;
import graphicalUserInterface.driverPage.*;

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

public class AutentificationGUI  {
    static JFrame f;
    JLabel l1,l2,l3,l4,l5;//labels
    JButton b;//button
    JTextField t1;//camp nume
    JPasswordField t2;//camp parola
    public AutentificationGUI() {
        f = new JFrame("inregistrare");//frame
        l1 = new JLabel("Numele complet:");//eticheta indicatoare camp pentru nume complet
        l2 = new JLabel("Parola:");//eticheta indicatoare camp pentru parola
        l3 = new JLabel("Welcome to Ride-Sharing app!");//eticheta indicatoare titlu
        l4 = new JLabel(" Va rugam sa completati spatiile albe");//eticheta indrumare
        b = new JButton("autentificare");//button
        t1 = new JTextField();//camp nume
        t2 = new JPasswordField();//camp parola
        l3.setBounds(175, 0, 300, 50);
        l3.setFont(new Font("Bernard MT Condensed", Font.ITALIC, 25));
        l3.setForeground(Color.blue);
        l1.setBounds(400,50, 100,30);
        t1.setBounds(400,100, 200,30);
        l2.setBounds(400,150, 100,30);
        t2.setBounds(400,200, 200,30);
        b.setBounds(450,270,110,30);//x axis, y axis, width, height
        l4.setBounds(100,50,500,30);
        l4.setFont(new Font("Arial", Font.ITALIC, 12));
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s1 = t1.getText();
                String s2 = t2.getText();
                Client c=new Client(s1,s2);
                Sofer s=new Sofer(s1,s2);
                if(e.getSource() == b) {
                    if(JSONFile.verificaCredentiale("src/customers.json",c)) {
                        f.setVisible(false);
                        new CustomerGUI();
                    }
                    else if(JSONFile.verificaCredentiale("src/drivers.json",s)) {
                        f.setVisible(false);
                        new DriverPage(s);
                    }
                    else
                        JOptionPane.showMessageDialog(new JFrame(),
                                "Nu sunteti inregistrat.",
                                "Persoana neautentificata",
                                JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src/drive.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(250, 250,Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(dimg);
        l5 = new JLabel(icon);
        l5.setBounds(80, 80, 250, 250);
        f.add(l3);
        f.add(t1);
        f.add(t2);
        f.add(l1);
        f.add(l2);
        f.add(b);
        f.add(l4);
        f.add(l5);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(f,"Leave" +
                        " ?","Confirmare iesire :", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                else if( result == JOptionPane.NO_OPTION)
                    f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        f.setSize(700,400);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void resetFields(){
        t1.setText("");
        t2.setText("");
    }

    public static void afiseaza(){
        f.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AutentificationGUI();
            }
        });
    }
}