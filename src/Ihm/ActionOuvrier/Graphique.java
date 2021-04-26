package Ihm.ActionOuvrier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Graphique extends JPanel {



    public  void drawing(){
        repaint();
    }

    protected void paintComponent(Graphics g) {
        Graphics2D gr = (Graphics2D)g;

        // path du fichier où on va récupérer les ordonnées

        Path path = Paths.get("C:\\Users\\Yacine Mam'd\\Desktop\\orowan\\out_put.txt");

        // liste des ordonnées
        ArrayList<Integer> ordonnees = new ArrayList();

        // on récupère les valeurs du fichier pour les mettre dans la liste

        List<String> output = null;
        try {
            output = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        output.remove(0);
        for (String ligne: output){
            ligne.replace("\\s","");
            ordonnees.add((int) ( Double.parseDouble(ligne.substring(19,28)))*200);
            System.out.println(ligne.substring(19,28));
        }

        //  on choisit la couleur de la courbe

        gr.setColor(Color.red);

        // Tracer la courbe du coefficient de friction

        for (int x =0; x< ordonnees.size()-1; x++){
            gr.drawLine(15*x+20,600- ordonnees.get(x),15*(x+1)+20, 600- ordonnees.get(x+1));
        }
        gr.setColor(Color.black);
        gr.drawLine(10,100,10,600);
        gr.drawString("Coefficient de Friction (e-01)",10,100);
        gr.drawLine(10,600,700,600);
        gr.drawString("Temps (200 ms)",705,600);

    }
    public Graphique() {
        drawing();
    }

}
