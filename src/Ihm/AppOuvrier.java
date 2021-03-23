package Ihm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  model.*;
public class AppOuvrier {
    private JTextField WELCOMMMMMMMMMMMMMMMMMETextField;
    private JPanel panel1;
    private JButton button1;
    private JButton ajouterDesValeursBaseButton;
    private JButton executerLeModeleMathématiqueButton;

    public  JFrame frame = new JFrame();

   Ouvrier ouvrier = new Ouvrier();

    public AppOuvrier(){

        executerLeModeleMathématiqueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             String cmd ="C:\\Users\\Yacine Mam'd\\Desktop\\orowan\\Orowan_x64.exe.exe" ;
             try {
                 Runtime runtime = Runtime.getRuntime();
                 String[] args = { "cmd", "cd C:\\Users\\Yacine Mam'd\\Desktop\\orowan","Orowan_x64.exe.exe", "i", "c","inv.txt","yes.txt"};
                 Process process = runtime.exec(cmd);
                 process.waitFor();
                 System.out.println("Modele exc");


             }catch (Exception e1){
                 e1.printStackTrace();

             }


            }
        });
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
        frame.setContentPane(new AppOuvrier().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
