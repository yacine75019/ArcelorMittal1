package model;

import java.sql.*;

public class Salarie {

    // Elements pour se connecter à la base de donnée

    static  final String driver = "com.mysql.jdbc.Driver";
    static  final String url = "jdbc:mysql://localhost/arcelor1";

    static final String user = "root";
    static final String pass = "vroum";


    public Salarie() {
    }

    public static void createDataBase(){

        Connection conn = null;
        Statement st = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(url, user, pass);

            System.out.println("creating database");
            st = conn.createStatement();
            String sql = "CREATE DATABASE arcelor1";
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

    // Méthodes pour effectuer des requetes à partir de Java

    public ResultSet requeteQuery(String requete){
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

                System.out.println(resultat.getInt("Lp"));
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

    public int requeteUpdate(String requete) {
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
            return 1;


        } catch (SQLException e) {
            e.printStackTrace();
            return 0;

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



    public static int getConnection(String user, String pass) {


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
            return  1;


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return 0;
        }finally {
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException ignore) {
                }
            }
        }
    } //méthode pour que la connexion à l'application corresponde à la connexion dans la base de données

}