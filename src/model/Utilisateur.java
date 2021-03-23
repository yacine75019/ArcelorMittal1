package model;

import java.sql.*;

public class Utilisateur{

    static  final String driver = "com.mysql.jdbc.Driver";
    static  final String url = "jdbc:mysql://localhost/valeurs";

    static final String user = "root";
    static final String pass = "vroum";

    public static void createDataBase(){

        Connection conn = null;
        Statement st = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(url, user, pass);

            System.out.println("creating database");
            st = conn.createStatement();
            String sql = "CREATE DATABASE valeurs";
            st.executeUpdate(sql);
            System.out.println(" Database created successfully");
        }catch(SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(st !=null)
                    st.close();
            }catch (SQLException e1){
            }
            try {
                if (conn != null)
                    conn.close();
            }catch (SQLException e2){
                e2.printStackTrace();
            }
        }


    }

    public static ResultSet requeteQuery(String requete){
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try{
            System.out.println("Chargement du Driver");
            Class.forName(driver);
            System.out.println("Driver chargé");
        }catch (ClassNotFoundException e){
            System.out.println(("Echec charge Driver"));
            e.printStackTrace();
        }

        try {
            System.out.println("Connexion à la base de donnée");
            connexion= DriverManager.getConnection(url,user,pass);
            System.out.println("Connexion réussie");

            /*Création de l'objet gérant les requêtes */
            statement = connexion.createStatement();

            /*Execution d'une requête de lecture */

            resultat = statement.executeQuery(requete);
            System.out.println((requete));
            while (resultat.next()){
                resultat.getInt("Lp");

            }


        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            System.out.println("Fermeture de l'objet ReslutSet");
            if (resultat != null){
                try {
                    resultat.close();
                }catch (SQLException ignore){
                }
            }
            if (statement != null){
                try {
                    statement.close();
                }catch (SQLException ignore){

                }
            }
            if (connexion != null){
                try {
                    connexion.close();
                }catch (SQLException ignore){
                }
            }
        }
        return resultat;



    }

    public static void requeteUpdate(String requete) {
        Connection connexion = null;
        Statement statement = null;


        try {
            System.out.println("Chargement du Driver");
            Class.forName(driver);
            System.out.println("Driver chargé");
        } catch (ClassNotFoundException e) {
            System.out.println(("Echec charge Driver"));
            e.printStackTrace();
        }

        try {
            System.out.println("Connexion à la base de donnée");
            connexion = DriverManager.getConnection(url, user, pass);
            System.out.println("Connexion réussie");

            /*Création de l'objet gérant les requêtes */
            statement = connexion.createStatement();

            /*Execution d'une requête de lecture */

            int statut = statement.executeUpdate(requete);
            System.out.println(requete);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Fermeture de l'objet ReslutSet");

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ignore) {

                }
            }
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException ignore) {
                }
            }
        }


    }



    // public void executer la commande
}