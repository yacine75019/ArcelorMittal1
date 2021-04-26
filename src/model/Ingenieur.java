package model;
import java.io.*;
import java.sql.*;


import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Ingenieur extends Salarie {



    public int createUser(String id, String password){
        return requeteUpdate("CREATE USER '"+ id+ "' IDENTIFIED BY '"+ password+"'");
    }


    public int grantToUser(String userId, String privilege) {
        requeteUpdate("GRANT " + privilege + " on table 1939351_f3 to " + userId);
        return requeteUpdate("GRANT " + privilege + " on table 1939351_f2 to " + userId );
    }

    public int disableStand(String stand, String id){
        return requeteUpdate("LOCK TABLE "+ id+"_"+stand+" as "+id+"_"+stand+" READ");
    }
    public int acivateStand(String stand, String id){
        return requeteUpdate("UNLOCK TABLES ");
    }



}
