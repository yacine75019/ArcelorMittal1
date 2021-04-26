package Ihm.ActionIngénieur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
public class CreationUser {

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    private JPanel panelMain;
    private JButton VALIDERButton;
    private JTextPane textPane1;

    JFrame frame = new JFrame("Création d'un utilisateur");
    Ingenieur ingenieur=new Ingenieur();
    String identifiant;
    String mdp;


    public CreationUser() {

        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textField1.getText());
            }
        });
        textField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                identifiant= textField2.getText();
            }
        });
        textField3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                 mdp = textField3.getText();
            }
        });

        VALIDERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int statut = ingenieur.createUser(identifiant,mdp);
                if (statut==1){
                    textPane1.setText("L'identifiant a bien été créé");
                }else{
                    textPane1.setText("L'identifiant existe déjà");
                }
            }
        });
    }

    public void setFrame() {
        this.frame = frame;
        frame.setContentPane(new CreationUser().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
