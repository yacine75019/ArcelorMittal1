package model;

import com.mysql.cj.protocol.Message;

import java.sql.*;

public class Main {
    static  final String driver = "com.mysql.jdbc.Driver";
    static  final String url = "jdbc:mysql://localhost/valeurs";

    static final String user = "root";
    static final String pass = "vroum";
    public static void main(String[] args) throws SQLException {
        Utilisateur utilisateur = new Utilisateur();
        System.out.println(utilisateur.requeteQuery("SELECT * FROM 1939351_f2"));
    }
}
