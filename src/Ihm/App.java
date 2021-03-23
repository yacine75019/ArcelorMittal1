package Ihm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JButton connardButton;
    private JPanel panelMain;
    private JButton ingenieurButton;
    private JButton ouvrierButton;

    public App() {
        ouvrierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AppOuvrier appouvrier = new AppOuvrier() ;
                appouvrier.setFrame(appouvrier.frame);

            }
        });
        ingenieurButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
    public static void main(String[] args){
        JFrame frame = new JFrame("Arcelor Mittal");
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

