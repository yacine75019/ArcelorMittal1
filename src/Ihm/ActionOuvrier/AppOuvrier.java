package Ihm.ActionOuvrier;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  model.*;



public class AppOuvrier {
    private JPanel panel1;
    private Graphique graphique = new Graphique();
    private JButton afficherLesCoefficientsDeButton;
    private JButton executerLeModeleMathématiqueButton;
    private JTextField standtextField;
    private JTextField idtextField;
    private JLabel messageLabel;

    //frame où s'ouvrir Appouvrier

    public  JFrame frame = new JFrame("Opérateur Arcelor Mittal");

    // frame où va s'ouvrir le graphique

    public JFrame framegraph = new JFrame("Allure des coeffcients de frictions");

    // On instancie la classe ouvrier

   Ouvrier ouvrier = new Ouvrier();



    public AppOuvrier(){

        executerLeModeleMathématiqueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ouvrier.executeOrowanModel(standtextField.getText(), idtextField.getText());

            }
        });
        afficherLesCoefficientsDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                framegraph.setContentPane(new AppOuvrier().graphique);
                framegraph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                framegraph.pack();
                framegraph.setVisible(true);

            }
        });
    }

    //méthode pour ouvrir appouvrier à partir de App
    public void setFrame(JFrame frame) {
        this.frame = frame;
        frame.setContentPane(new AppOuvrier().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
