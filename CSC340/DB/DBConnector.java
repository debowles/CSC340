/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Bowles
 */
public class DBConnector {
    public static Connection connectdb() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(SignUpDatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //Creates the ID for the user when they sign up
     public static String createID() throws SQLException{
        int i = 0;
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM USERSIGNUP");
             
            while(results.next()){
                 i++;
             }            
            results.close();
            stmt.close();
        }  
        String num =String.valueOf(i);
            return num;
            }
    
     //When User Signs up they get a specific ID that is set in the DB, This method is to Transfer that ID to the other DB's
    public static void addToOtherDB(String database, HashMap<String,String> map) throws SQLException{
          try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            int i = 0;
            String statementLabels = "";
            String statementValues = "";           
            
             if (map.containsKey("ANIMALTYPE")) {
                statementLabels = "ANIMALTYPE";
                statementValues = "'"+ map.get("ANIMALTYPE") + "'";
            }
            if (map.containsKey("ID")) {
                statementLabels = statementLabels + ",ID";
                statementValues = statementValues + "," + map.get("ID");
            }            
            System.out.println(statementLabels);
            System.out.println(statementValues);

            System.out.println("INSERT INTO "+database+"(" + statementLabels + ") VALUES (" + statementValues + ")");
            stmt.executeUpdate("INSERT INTO "+database+"(" + statementLabels + ") VALUES (" + statementValues + ")");

            stmt.close();
            System.out.println("DB info added");

        }
    }
    
    
    
}