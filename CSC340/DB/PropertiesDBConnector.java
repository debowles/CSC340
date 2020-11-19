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

/**
 *
 * @author David Bowles
 */
public class PropertiesDBConnector implements DBConnectorInterface{
    public static String readUserParameters(String label, int rowNum) throws SQLException{
        String userInfo;
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("SELECT " + label + " FROM PROPERTIES");
            for (int i = 0; i < rowNum; i++) {
                results.next();
            }
            userInfo = results.getString(label);
            results.close();
            stmt.close();
        }
        return userInfo;
   }
   
   //reads whole row
   public static HashMap<String,String> readUserInfoDB(int rowNum) throws SQLException{
       HashMap<String, String> map = new HashMap<>();
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM PROPERTIES");
            for (int i = 0; i < rowNum; i++) {
                results.next();
            }

            map.put("DOG_PARAMETERS", results.getString("DOG_PARAMETERS"));
            map.put("CAT_PARAMETERS", results.getString("CAT_PARAMETERS"));
            map.put("BIRD_PARAMETERS", results.getString("BIRD_PARAMETERS"));
            map.put("BARNYARD_PARAMETERS", results.getString("BARNYARD_PARAMETERS"));
            map.put("HORSES_PARAMETERS", results.getString("HORSES_PARAMETERS"));
            map.put("RABBIT_PARAMETERS", results.getString("RABBIT_PARAMETERS"));
            map.put("SCALES_PARAMETERS", results.getString("SCALES_PARAMETERS"));
            map.put("SAMLLANDFURRY_PARAMETERS", results.getString("SAMLLANDFURRY_PARAMETERS"));
            map.put("ID", results.getString("ID"));
            map.put("ANIMALTYPE", results.getString("ANIMALTYPE"));
            
            results.close();
            stmt.close();
        }
        return map;
   }
   
   //Changes the User Info
   public static void updateUserInfoDB(String label, String variable, String id) throws SQLException{
       try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            System.out.println("UPDATE PROPERTIES \nSET " + label + " = " + "'"+variable+"'" + " \nWHERE ID = " + id);
            stmt.executeUpdate("UPDATE PROPERTIES SET " + label + " = " + "'"+variable+"'" + " WHERE ID = " + id);
            stmt.close();
            System.out.println("DB Info Updated");
        }
   }
   //Deletes the User
   public static void deleteUserInfoDB(int id) throws SQLException{
       try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            System.out.println("DELETE FROM PROPERTIES WHERE id =" + id);
            stmt.executeUpdate("DELETE FROM PROPERTIES WHERE id =" + id);
            stmt.close();
            System.out.println("DB Info Deleted");
        }
   }
   //Adds a New Row in DB
   public static void addUserInfoDB(HashMap<String,String> map, String id ) throws SQLException{
       try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            int i = 0;
            String statementString ="";
                      
            
            
            if (map.containsKey("DOG_PARAMETERS")) {                
                statementString = statementString + "DOG_PARAMETERS" +"'"+ map.get("DOG_PARAMETERS") + "',";
            }
            if (map.containsKey("CAT_PARAMETERS")) {
               statementString = statementString + "CAT_PARAMETERS" +"'"+ map.get("CAT_PARAMETERS") + "',";
            }
            if (map.containsKey("BIRD_PARAMETERS")) {
                statementString = statementString + "BIRD_PARAMETERS" +"'"+ map.get("BIRD_PARAMETERS") + "',";
            }
            if (map.containsKey("BARNYARD_PARAMETERS")) {
               statementString = statementString + "BARNYARD_PARAMETERS" +"'"+ map.get("BARNYARD_PARAMETERS") + "',";
            }
            if (map.containsKey("HORSES_PARAMETERS")) {
                statementString = statementString + "HORSES_PARAMETERS" +"'"+ map.get("HORSES_PARAMETERS") + "',";
            }
            if (map.containsKey("RABBIT_PARAMETERS")) {
                statementString = statementString + "RABBIT_PARAMETERS" +"'"+ map.get("RABBIT_PARAMETERS") + "',";
            }
            if (map.containsKey("SCALES_PARAMETERS")) {
               statementString = statementString + "SCALES_PARAMETERS" +"'"+ map.get("SCALES_PARAMETERS") + "',";
            }
            if (map.containsKey("SAMLLANDFURRY_PARAMETERS")) {
               statementString = statementString + "SAMLLANDFURRY_PARAMETERS" +"'"+ map.get("SAMLLANDFURRY_PARAMETERS") + "',";
            }                                                            
            
            

            System.out.println("UPDATE PROPERTIES\n SET " +statementString+"\n WHERE ID = " + id+";");
            stmt.executeUpdate("UPDATE PROPERTIES\n SET " +statementString+"\n WHERE ID = " + id+";");

            stmt.close();
            System.out.println("DB info added");

        }
        
        
        
    }
   }

