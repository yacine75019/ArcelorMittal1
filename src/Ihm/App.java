package Ihm;

import Ihm.ActionIngénieur.AppIngenieur;
import Ihm.ActionOuvrier.AppOuvrier;
import model.Ingenieur;
import model.Ouvrier;
import model.Salarie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JPanel panel1;
    private JButton opérateurButton;
    private JButton ingénieurButton;
    private JLabel quelleEstVotreFonctionLabel;
    private JTextField rootTextField;
    private JTextField vroumTextField;
    private JLabel messageLabel;
    private JButton ingenieurButton;
    private JButton ouvrierButton;

    AppOuvrier appouvrier = new AppOuvrier() ;
    AppIngenieur appIngenieur = new AppIngenieur();
    public App() {
        opérateurButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               int statut =Ouvrier.getConnection(rootTextField.getText(), vroumTextField.getText());
                if (statut==1){
                    appouvrier.setFrame(appouvrier.frame);
                }else{
                    messageLabel.setText("Le Nom d'utilisateur ou le mot de passe est incorrecte");
                }


            }
        });

        ingénieurButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int statut = Ingenieur.getConnection(rootTextField.getText(), vroumTextField.getText());
                if (statut==1){
                    appIngenieur.setFrame(appIngenieur.frame);
                }else{
                    messageLabel.setText("Le Nom d'utilisateur ou le mot de passe est incorrecte");
                }


            }
        });
    }
    public static void main(String[] args){
        JFrame frame = new JFrame("Arcelor Mittal");
        frame.setContentPane(new App().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }



}

