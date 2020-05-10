package graphicalUserInterface;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class AutentificationGUI {

    private JFrame frame;
    public AutentificationGUI() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AutentificationGUI window = new AutentificationGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
