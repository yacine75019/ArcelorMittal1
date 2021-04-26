package Ihm.ActionIngénieur;

import model.Ingenieur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GrantUser {

    private JPanel PanelMain;
    private JTextField textField1;
    private JButton ingenieurRoleButton;
    private JButton opérateurRoleButton;
    private JButton SELECTButton;
    private JButton INSERTButton;
    private JButton DELETEButton;
    private JButton CREATEButton;
    private JButton DROPButton;
    private JTextPane textPane1;

    String userID ;
    //On
    Ingenieur ingenieur = new Ingenieur();

    JFrame frame = new JFrame("Attribution des privilèges");

    public GrantUser() {
        ingenieurRoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userID = textField1.getText();

               int statut= ingenieur.requeteUpdate("GRANT 'ingenieur' to "+userID);
                if (statut==1){
                    textPane1.setText("Privilège attribué");
                }else{
                    textPane1.setText("Cet User ID n'existe pas");
                }
            }
        });
        opérateurRoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userID = textField1.getText();

                int statut = ingenieur.requeteUpdate("GRANT 'ouvrier' to "+ userID);
                if (statut==1){
                    textPane1.setText("Privilège attribué");
                }else{
                    textPane1.setText("Cet User ID n'existe pas");
                }
            }
        });
        INSERTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userID = textField1.getText();

                int statut =ingenieur.grantToUser(userID,"INSERT");
                if (statut==1){
                    textPane1.setText("Privilège attribué");
                }else{
                    textPane1.setText("Cet User ID n'existe pas");
                }

            }
        });
        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userID = textField1.getText();

               int statut= ingenieur.grantToUser(userID,"DELETE");
                if (statut==1){
                    textPane1.setText("Privilège attribué");
                }else{
                    textPane1.setText("Cet User ID n'existe pas");
                }
            }
        });
        CREATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userID = textField1.getText();


                int statut =ingenieur.grantToUser(userID,"CREATE");
                if (statut==1){
                    textPane1.setText("Privilège attribué");
                }else{
                    textPane1.setText("Cet User ID n'existe pas");
                }

            }
        });
        DROPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userID = textField1.getText();

                int statut = ingenieur.grantToUser(userID,"DROP");

                if (statut==1){
                    textPane1.setText("Privilège attribué");
                }else{
                    textPane1.setText("Cet User ID n'existe pas");
                }

            }
        });
        SELECTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userID = textField1.getText();

                int statut =ingenieur.grantToUser(userID,"SELECT");

                if (statut==1){
                    textPane1.setText("Privilège attribué");
                }else{
                    textPane1.setText("Cet User ID n'existe pas");
                }
            }
        });
    }
    public void setFrame() {
        this.frame = frame;
        frame.setContentPane(new GrantUser().PanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
