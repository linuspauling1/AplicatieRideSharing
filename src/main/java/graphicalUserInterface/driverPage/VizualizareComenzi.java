package graphicalUserInterface.driverPage;

import dataStructures.ComandaEfectuata;
import dataStructures.Sofer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class VizualizareComenzi {

    private JFrame frame;
    private JTable table_1;
    private Sofer sofer;
    private boolean b=false;
    private JButton btnNewButton;

    public JButton getBtnNewButton() {
        return btnNewButton;
    }

    public boolean isB() {
        return b;
    }

    public VizualizareComenzi(Sofer sofer) {
        this.sofer=sofer;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(32, 178, 170));
        frame.setBounds(100, 100, 700, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblVizualizareComenzi = new JLabel("Vizualizare comenzi");
        lblVizualizareComenzi.setForeground(new Color(0, 0, 128));
        lblVizualizareComenzi.setFont(new Font("Showcard Gothic", Font.PLAIN, 24));
        lblVizualizareComenzi.setBounds(195, 10, 301, 51);
        frame.getContentPane().add(lblVizualizareComenzi);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(54, 83, 581, 171);
        frame.getContentPane().add(scrollPane_1);

        int pret=0;
        Object data [][]=new Object [100][5];
        int contor=0;
        ArrayList<ComandaEfectuata> ef=DOM.Parser.getEfectuate(
                "src/main/resources/completed.xml");
        Iterator<ComandaEfectuata> it=ef.iterator();
        while(it.hasNext()) {
            ComandaEfectuata com = it.next();
            if(com.getUsernameSofer().equals(sofer.getUsername())){
                data[contor][0]=com.getUsernameClient();
                data[contor][1]=com.getDestinatie();
                data[contor][2]=com.getPret();
                pret+=(int)data[contor][2];
                data[contor++][3]=com.getReview();
            }
        }
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

        table_1 = new JTable();
        scrollPane_1.setViewportView(table_1);
        scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        table_1.setModel(new DefaultTableModel(
                data,
                new String[] {
                        "Client", "Destinatie", "Pret","Recenzie"
                }
        ));
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 128));
        panel.setForeground(new Color(0, 0, 128));
        panel.setBounds(54, 264, 581, 34);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblSumaDeBani = new JLabel("Suma de bani castigata pana in prezent este de :");
        lblSumaDeBani.setForeground(new Color(255, 255, 255));
        lblSumaDeBani.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblSumaDeBani.setBounds(57, 0, 382, 34);
        panel.add(lblSumaDeBani);

        JLabel lblNewLabel = new JLabel(pret+" lei");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(436, 5, 63, 24);
        panel.add(lblNewLabel);

        btnNewButton = new JButton("Inapoi");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnNewButton.setForeground(new Color(0, 0, 128));
        btnNewButton.setBounds(251, 318, 173, 21);
        frame.getContentPane().add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                b=true;
                frame.dispose();
                DriverPage.afiseaza();
            }
        });
    }
}