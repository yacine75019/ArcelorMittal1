package Ihm.ActionIngénieur;

import model.Ingenieur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActivateStand {
    JFrame frame = new JFrame();
    private JPanel PanelMain;
    private JButton LOCKButton;
    private JButton UNLOCKButton;
    private JTextField standtextField;
    private JTextField idtextField;
    private JLabel messageLabel;

    Ingenieur ingenieur = new Ingenieur();

    public ActivateStand() {
        LOCKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int statut = ingenieur.disableStand(standtextField.getText(),idtextField.getText());
                if (statut==1){
                    messageLabel.setText("La Cage a été bloquée");
                }else{
                    messageLabel.setText("Cette cage n'existe pas");
                }
            }
        });
        UNLOCKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int statut =ingenieur.acivateStand(standtextField.getText(), idtextField.getText());
                if (statut==1){
                    messageLabel.setText("La cage a été débloquée");
                }else{
                    messageLabel.setText("Cette cage n'existe pas");
                }
            }
        });
    }

    public void setFrame() {
        this.frame = frame;
        frame.setContentPane(new ActivateStand().PanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
