package graphicalUserInterface.customerPage;

import dataStructures.Client;
import dataStructures.ComandaNepreluata;

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
import java.util.Calendar;

public class ComandaNoua {
	private Client client;
	private static JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private String locatie;
	private String destinatie;
	private static ArrayList<ComandaNepreluata> c = new ArrayList<ComandaNepreluata>();

	public ComandaNoua(Client c) {
		client = c;
		initialize();
	}

	public static void afiseaza(){
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 204, 204));
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JLabel lblComandaNoua = new JLabel("Comanda Noua");
		lblComandaNoua.setForeground(Color.BLUE);
		lblComandaNoua.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblComandaNoua.setBounds(273, 10, 180, 29);
		frame.getContentPane().add(lblComandaNoua);

		JLabel lblLocatieCurenta = new JLabel("Locatie curenta");
		lblLocatieCurenta.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblLocatieCurenta.setBounds(345, 74, 146, 29);
		frame.getContentPane().add(lblLocatieCurenta);

		JLabel lblDestinatie = new JLabel("Destinatie");
		lblDestinatie.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDestinatie.setBounds(365, 119, 122, 20);
		frame.getContentPane().add(lblDestinatie);

		textField = new JTextField();
		textField.setBounds(478, 80, 136, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(478, 119, 136, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);


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
		aux.setBounds(40, 60, 250, 250);
		frame.getContentPane().add(aux);

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

		JButton btnContinuare = new JButton("Continuare");
		btnContinuare.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnContinuare.setBounds(438, 196, 132, 21);
		JButton btnInapoi = new JButton("Inapoi");
		btnInapoi.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnInapoi.setBounds(438, 236, 132, 21);

		btnInapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				CustomerGUI.afiseaza();
			}
		});
		btnContinuare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int an = Calendar.getInstance().get(Calendar.YEAR);
				int luna = Calendar.getInstance().get(Calendar.MONTH);
				int zi = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
				int ora = Calendar.getInstance().get(Calendar.HOUR);
				int minut = Calendar.getInstance().get(Calendar.MINUTE);
				int secunda = Calendar.getInstance().get(Calendar.SECOND);
				locatie = textField.getText();
				destinatie = textField_1.getText();
				ComandaNepreluata cn = new ComandaNepreluata(client,an,luna,zi,ora,minut,secunda,locatie,destinatie);
				c.add(cn);
				DOM.Parser.createXML(cn);
				frame.setVisible(false);
				new CommandGUI();
			}
		});
		frame.getContentPane().add(btnInapoi);
		frame.getContentPane().add(btnContinuare);
		frame.setBounds(100, 100, 700, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
