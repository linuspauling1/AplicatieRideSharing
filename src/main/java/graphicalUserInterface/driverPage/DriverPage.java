package graphicalUserInterface.driverPage;

import dataStructures.ComandaEfectuata;
import dataStructures.Sofer;
import graphicalUserInterface.AutentificationGUI;
import jsonClasses.JSONEditProfile;

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
import java.util.Iterator;

public class DriverPage {

    private static JFrame frame;
    private static Sofer sofer;
    private JButton edit;
    private JButton list;
    private JButton add;
    private JButton inapoi;
    private boolean b1,b2,b3,b4;

    public static Sofer getSofer(){
        return sofer;
    }

    public DriverPage(Sofer s)
    {
        b1=false;
        b2=false;
        b3=false;
        b4=false;
        ArrayList<Sofer> soferi= JSONEditProfile.getDriver();
        Iterator<Sofer> it=soferi.iterator();
        while(it.hasNext()) {
            Sofer aux = it.next();
            if (aux.getUsername().equals(s.getUsername())) {
                sofer = aux;
            }
        }
        initialize();
    }

    public static void afiseaza(){
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 650, 500);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(frame,"Leave" +
                        " ?","Confirmare iesire :", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                else
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });

        frame.getContentPane().setLayout(new BorderLayout(20, 20));
        frame.setVisible(true);

        edit=new JButton("Editare profil");
        list=new JButton("  Comenzile mele");
        add=new JButton("Preia o comanda");
        inapoi=new JButton("   Inapoi      ");
        inapoi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                b1=true;
                AutentificationGUI.afiseaza();
            }
        });

        list.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                b2=true;
                new VizualizareComenzi(sofer);
            }
        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                b3=true;
                ArrayList<ComandaEfectuata> ef=DOM.Parser.getEfectuate(
                        "src/main/resources/completed.xml");
                Iterator<ComandaEfectuata> it=ef.iterator();
                boolean c=false;
                while(it.hasNext()){
                    ComandaEfectuata com=it.next();
                    if(com.getUsernameSofer().equals(sofer.getUsername())&&com.getPret()==0){
                        c=true;
                        frame.setVisible(false);
                        new InfoClient(com);
                    }
                }
                if(c==false){
                    frame.setVisible(false);
                    DOM.Parser.afisareXML();
                }
            }
        });

        JPanel titlu=new JPanel();
        titlu.setLayout(new GridBagLayout());
        GridBagConstraints gct=new GridBagConstraints();
        gct.insets=new Insets(30,5,0,5);
        JLabel lblNewLabel = new JLabel("DRIVER'S PAGE");
        lblNewLabel.setForeground(Color.BLUE);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlu.add(lblNewLabel,gct);
        frame.getContentPane().add(titlu, BorderLayout.NORTH);

        JPanel jp=new JPanel();
        jp.setLayout(new GridBagLayout());
        GridBagConstraints gc=new GridBagConstraints();
        gc.insets=new Insets(0,5,25,5);
        gc.gridx=0;
        gc.gridy=0;
        gc.anchor=GridBagConstraints.PAGE_START;
        jp.add(edit,gc);
        edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                b4=true;
                new EditProfileGUI(sofer);
            }
        });

        gc.insets=new Insets(5,5,25,5);
        gc.gridx=0;
        gc.gridy=1;
        gc.anchor=GridBagConstraints.CENTER;
        jp.add(list,gc);

        gc.insets=new Insets(5,5,25,5);
        gc.anchor=GridBagConstraints.CENTER;
        gc.gridx=0;
        gc.gridy=2;
        jp.add(add,gc);

        gc.insets=new Insets(5,5,25,5);
        gc.anchor=GridBagConstraints.CENTER;
        gc.gridx=0;
        gc.gridy=3;
        jp.add(inapoi,gc);

        JPanel west=new JPanel();
        west.setLayout(new GridBagLayout());
        GridBagConstraints gcw=new GridBagConstraints();
        gcw.insets=new Insets(15,5,5,5);
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src/main/resources/drive.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel aux=new JLabel();
        Image dimg = img.getScaledInstance(250, 250,Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        aux.setIcon(imageIcon);
        west.add(aux,gcw);
        frame.getContentPane().add(jp, BorderLayout.CENTER);
        frame.getContentPane().add(west, BorderLayout.WEST);

    }
    public boolean isB1() {
        return b1;
    }

    public boolean isB2() {
        return b2;
    }

    public boolean isB3() {
        return b3;
    }

    public boolean isB4() {
        return b4;
    }

    public static JFrame getFrame() {
        return frame;
    }

    public JButton getEdit() {
        return edit;
    }

    public JButton getList() {
        return list;
    }

    public JButton getAdd() {
        return add;
    }

    public JButton getInapoi() {
        return inapoi;
    }

}