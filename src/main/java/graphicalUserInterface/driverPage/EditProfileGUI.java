package graphicalUserInterface.driverPage;
import dataStructures.Sofer;
import jsonClasses.JSONEditProfile;
import jsonClasses.JSONFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public class EditProfileGUI {

    private JFrame frame;
    private JTextField textField;
    private JPasswordField passwordField;
    private JTextField cnp;
    private JTextField nri;
    private JTextField car;
    private Sofer sofer;

    public EditProfileGUI(Sofer s) {
        sofer=s;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setForeground(Color.BLUE);
        frame.setBounds(100, 100, 550, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
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

        JLabel lblEditeazaProfilul = new JLabel("Editeaza Profilul");
        lblEditeazaProfilul.setForeground(Color.BLUE);
        lblEditeazaProfilul.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblEditeazaProfilul.setBounds(180, 10, 197, 20);
        frame.getContentPane().add(lblEditeazaProfilul);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblUsername.setBounds(20, 76, 90, 15);
        frame.getContentPane().add(lblUsername);

        textField = new JTextField();
        textField.setBounds(94, 74, 96, 19);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        textField.setText(sofer.getUsername());

        JLabel lblParola = new JLabel("Parola");
        lblParola.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblParola.setBounds(20, 118, 46, 13);
        frame.getContentPane().add(lblParola);

        passwordField = new JPasswordField();
        passwordField.setBounds(94, 115, 96, 19);
        frame.getContentPane().add(passwordField);

        cnp = new JTextField();
        cnp.setBounds(94, 162, 96, 19);
        frame.getContentPane().add(cnp);
        cnp.setColumns(10);
        cnp.setText(sofer.getCNP());

        JLabel lblCnp = new JLabel("CNP");
        lblCnp.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblCnp.setBounds(20, 165, 46, 13);
        frame.getContentPane().add(lblCnp);

        JLabel lblNumarInmatriculare = new JLabel("Numar Inmatriculare");
        lblNumarInmatriculare.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblNumarInmatriculare.setBounds(222, 77, 128, 13);
        frame.getContentPane().add(lblNumarInmatriculare);

        nri = new JTextField();
        nri.setBounds(330, 74, 96, 19);
        frame.getContentPane().add(nri);
        nri.setColumns(10);
        nri.setText(sofer.getNumarInmatriculare());


        JLabel lblMasina = new JLabel("Masina");
        lblMasina.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblMasina.setBounds(222, 118, 46, 13);
        frame.getContentPane().add(lblMasina);

        car = new JTextField();
        car.setBounds(330, 115, 96, 19);
        frame.getContentPane().add(car);
        car.setColumns(10);
        car.setText(sofer.getMasina());

        JButton btnSalveazaModificari = new JButton("Salveaza modificari");
        btnSalveazaModificari.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnSalveazaModificari.setBounds(260, 218, 147, 32);
        frame.getContentPane().add(btnSalveazaModificari);

        btnSalveazaModificari.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    ArrayList<Sofer> soferi = JSONEditProfile.getDriver();
                    soferi.remove(sofer);
                    String nume, parola, CNP, masina, nr;
                    nume=sofer.getUsername();
                    parola=sofer.getPassword();
                    CNP=sofer.getCNP();
                    masina=sofer.getMasina();
                    nr=sofer.getNumarInmatriculare();
                    if(textField.getText().equals("")==false)
                         nume = textField.getText();
                    if(passwordField.getText().equals("")==false)
                         parola = passwordField.getText();
                    if(cnp.getText().equals("")==false)
                        CNP = cnp.getText();
                    if(car.getText().equals("")==false)
                        masina = car.getText();
                    if(nri.getText().equals("")==false)
                        nr = nri.getText();
                    Sofer sof = new Sofer(nume, JSONFile.encrypt(parola));
                    sof.setNumarInmatriculare(nr);
                    sof.setMasina(masina);
                    sof.setCNP(CNP);
                    soferi.add(sof);
                    JSONEditProfile.writeDriver(soferi);
                    frame.setVisible(false);
                    new DriverPage(sof);
                }
        });
    }
}

