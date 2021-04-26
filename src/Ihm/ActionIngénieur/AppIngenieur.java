package Ihm.ActionIngénieur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppIngenieur {

    private JPanel panelMain;
    private JButton créerUnUtilisateurButton;
    private JButton activerDésactiverUneTableButton;
    private JButton donnerRetirerDesDroitsButton;


    public  JFrame frame = new JFrame("Ingénieur Arcelor Mittal");

    CreationUser creationUser = new CreationUser();
    GrantUser grantUser = new GrantUser();
    ActivateStand activateStand = new ActivateStand();

    public AppIngenieur() {


        créerUnUtilisateurButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                creationUser.setFrame();

            }
        });
        donnerRetirerDesDroitsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                grantUser.setFrame();
            }
        });
        activerDésactiverUneTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                activateStand.setFrame();
            }
        });
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
        frame.setContentPane(new AppIngenieur().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
