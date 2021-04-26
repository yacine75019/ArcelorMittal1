package model;

import java.io.*;


public class Ouvrier extends Salarie {

        public void executeOrowanModel(String stand, String id) {

            String path = "C:\\Users\\Yacine Mam'd\\Desktop\\orowan\\";
            String filecage = id+"_"+ stand+".txt";
            String fileoutput= "output.txt";
            String ligne = "";

            try {

                BufferedReader br = new BufferedReader(new FileReader(path+filecage));

                // On le fichier 'id_stand.txt' ligne par ligne
                while ((ligne = br.readLine()) != null ) {


                //création d'un fichier d'une ligne en entrée du modèle Orowan

                String[] values = ligne.split("\t");

                System.out.println(values);
                File file = new File("C:\\Users\\Yacine Mam'd\\Desktop\\orowan\\"+"input.txt");
                    //File Writer
                FileWriter fw = new FileWriter(file);
                    //Print Writer
                PrintWriter pw = new PrintWriter(fw);
                pw.println("Cas\tHe\tHs\tTe\tTs\tDiam_WR\tWRyoung\toffset ini\tmu_ini\tForce\tG");


                //  Certaines valeurs ont un chiffre qui ne permet pas l'execution du modèle
                    // on traite ces valeurs

                if (values[4].length() < 6){
                   for (int i =0 ; i<6 ;i++){
                         values[4]+="0";
                     }
                 }
                if (values[10].length()<7){
                     for (int i =0; i < 7; i++){
                       values[10]+="0";
                     }
                }

                // insérer les valeurs dans le fichier

                    pw.println("1\t"+values[4].substring(0,6)+"\t"+ values[5]+"\t"+values[6]+"\t"+values[7]+"\t"+values[10].substring(0,7)+" "+values[12]+"\t"+"200"+"\t"+"0.2\t"+values[8]+" \t"+values[9]);
                    pw.close();

                    // enregistrer ces valeurs dans la table standmodele de la base de donnée

                    requeteUpdate("INSERT INTO "+stand+"modele (Cas,He,Hs,Te,Ts,Diam_WR,WRyoung,offsett,ini,mu_ini,Force_F,G) VALUES( 1,"+"'"+values[4]+"',"+"'"+values[5]+"',"+"'"+values[6]+"',"+"'"+values[7]+"',"+"'"+values[10]+"',"+"'"+values[11]+"',"+"'"+values[17]+"',"+"0.2,"+"'"+values[15]+"',"+"'"+values[8]+"',"+"'"+values[9]+"')");


                    //Execution du modèle mathématique pour le fichier qui vient d'être créé

                    // TODO Auto-generated method stub
                    String absolutePath = "C:\\Users\\Yacine Mam'd\\Desktop\\orowan\\";
                    String line;
                    OutputStream stdin = null;
                    InputStream stderr = null;
                    InputStream stdout = null;
                    // launch EXE and grab stdin/stdout and stderr
                    Process process = null;
                    try {
                        process = Runtime.getRuntime ().exec (absolutePath+"Orowan_x64.exe");
                        // deal with OutputStream to send inputs
                        stdin = process.getOutputStream ();
                        // deal with ErrorStream to get error outputs
                        stderr = process.getErrorStream ();
                        // deal with InputStream to get ordinary outputs
                        stdout = process.getInputStream ();
                        // "write" the parms into stdin
                        line = "i" + "\n";
                        stdin.write(line.getBytes());
                        stdin.flush();
                        line = "c" + "\n";
                        stdin.write(line.getBytes() );
                        stdin.flush();
                        line = absolutePath + "input.txt" + "\n";
                        stdin.write(line.getBytes() );
                        stdin.flush();
                        line = absolutePath + fileoutput + "\n";
                        stdin.write(line.getBytes() );
                        stdin.flush();
                        stdin.close();
                        // clean up if any output in stdout
                        BufferedReader brCleanUp = new BufferedReader (new InputStreamReader(stdout));
                        while ((line = brCleanUp.readLine ()) != null) {
                        }
                        brCleanUp.close();
                        // clean up if any output in stderr
                        brCleanUp = new BufferedReader (new InputStreamReader (stderr));
                        while ((line = brCleanUp.readLine ()) != null) {
                        }
                        brCleanUp.close();
                        process.destroy();
                        System.out.println("Orowan Execution Terminated ....");


                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    // On enregistre le resultat dans un fichier output.txt

                    BufferedReader buffer = new BufferedReader(new FileReader(path+fileoutput));
                    String columns = buffer.readLine();
                    String valeurs = buffer.readLine();
                    String[] columnslist = columns.split("\t");
                    String[] valeurslist = valeurs.split("\t");

                    // On enregistre le resultat dans une table dans la base de données

                    requeteUpdate("INSERT INTO "+stand+"output(cases, Errors, OffsetYield, Friction, Rolling_Torque, Sigma_Moy, Sigma_Ini, Sigma_Out, Sigma_Max, Force_Error, Slip_Error, Has_Converged) " +
                            "VALUES('"+valeurslist[0]+"','"+valeurslist[1]+"','"+valeurslist[2]+"','"+valeurslist[3]+"','"+valeurslist[4]+"','"+valeurslist[5]+"','"+valeurslist[6]+"','"+valeurslist[7]+"','"+valeurslist[8]+"','"+valeurslist[9]+"','"+valeurslist[10]+"','"+valeurslist[11]+"')");


                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }



        }


