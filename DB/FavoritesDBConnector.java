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

//TODO:FIX READING FROM DB

public class FavoritesDBConnector implements DBConnectorInterface {
    public static String readUserParameters(String label, String id) throws SQLException {
        String userInfo;
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM FAVORITES WHERE ID = "+id);            
            userInfo = results.getString(label);
            results.close();
            stmt.close();
        }
        return userInfo;
    }

    //reads whole row
    public static HashMap<String, String> readUserInfoDB(String id) throws SQLException {
        HashMap<String, String> map = new HashMap<>();
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM FAVORITES");
            int rowNum = Integer.parseInt(id);
            for (int i = 0; i <= rowNum; i++) {
                results.next();
            }         
            map.put("NAME", results.getString("NAME"));            
            map.put("GENDER", results.getString("GENDER"));
            map.put("SIZE", results.getString("SIZE"));
            map.put("AGE", results.getString("AGE"));
            map.put("DISTANCE", results.getString("DISTANCE"));
            map.put("TYPE", results.getString("TYPE"));
            map.put("COLORS", results.getString("COLORS"));
            map.put("BREEDS", results.getString("BREEDS"));           
            map.put("DESCRIPTION", results.getString("DESCRIPTION"));
            map.put("PRIMARY_PHOTO_CROPPED", results.getString("PRIMARY_PHOTO_CROPPED"));
            map.put("ATTRIBUTES", results.getString("ATTRIBUTES"));
            map.put("CONTACT", results.getString("CONTACT"));
            map.put("PUBLISHED_AT", results.getString("PUBLISHED_AT"));
            map.put("ID", results.getString("ID"));
            results.close();
            stmt.close();
        }
        return map;
    }

    //Changes the User Info
    public static void updateUserInfoDB(String label, String variable, String id) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            System.out.println("UPDATE FAVORITES \nSET " + label + " = " + "'" + variable + "'" + " \nWHERE ID = " + id);
            stmt.executeUpdate("UPDATE FAVORITES SET " + label + " = " + "'" + variable + "'" + " WHERE ID = " + id);
            stmt.close();
            System.out.println("DB Info Updated");
        }
    }
    //Deletes the User

    public static void deleteUserInfoDB(int id) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            System.out.println("DELETE FROM PROPERTIES WHERE id =" + id);
            stmt.executeUpdate("DELETE FROM PROPERTIES WHERE id =" + id);
            stmt.close();
            System.out.println("DB Info Deleted");
        }
    }
    //Adds a New Row in DB

    public static void addUserInfoDB(HashMap<String, String> map, String id) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            String statementLabels = "";
            String statementValues = "";

            
            if (map.containsKey("NAME")) {
                statementLabels = "NAME";
                statementValues = "'" + map.get("NAME") + "'";
            }
            if (map.containsKey("GENDER")) {
                statementLabels = "GENDER";
                statementValues = "'" + map.get("GENDER") + "'";
            }
            if (map.containsKey("SIZE")) {
                statementLabels = "SIZE";
                statementValues = "'" + map.get("SIZE") + "'";
            }
            if (map.containsKey("AGE")) {
                statementLabels = "AGE";
                statementValues = "'" + map.get("AGE") + "'";
            }
            if (map.containsKey("DISTANCE")) {
                statementLabels = "DISTANCE";
                statementValues = "'" + map.get("DISTANCE") + "'";
            }
            if (map.containsKey("TYPE")) {
                statementLabels = "TYPE";
                statementValues = "'" + map.get("TYPE") + "'";
            }
            if (map.containsKey("COLORS")) {
                statementLabels = "COLORS";
                statementValues = "'" + map.get("COLORS") + "'";
            }
            if (map.containsKey("BREEDS")) {
                statementLabels = "BREEDS";
                statementValues = "'" + map.get("BREEDS") + "'";
            }                       
            if (map.containsKey("DESCRIPTION")) {
                statementLabels = "DESCRIPTION";
                statementValues = "'" + map.get("DESCRIPTION") + "'";
            }
            if (map.containsKey("PRIMARY_PHOTO_CROPPED")) {
                statementLabels = "PRIMARY_PHOTO_CROPPED";
                statementValues = "'" + map.get("PRIMARY_PHOTO_CROPPED") + "'";
            }
            if (map.containsKey("ATTRIBUTES")) {
                statementLabels = "ATTRIBUTES";
                statementValues = "'" + map.get("ATTRIBUTES") + "'";
            }
            if (map.containsKey("CONTACT")) {
                statementLabels = "CONTACT";
                statementValues = "'" + map.get("CONTACT") + "'";
            }
            if (map.containsKey("PUBLISHED_AT")) {
                statementLabels = "PUBLISHED_AT";
                statementValues = "'" + map.get("PUBLISHED_AT") + "'";
            }
                                   
            statementLabels = statementLabels + ",ID"; 
            statementValues = statementValues + ","+ id;
            
            System.out.println("INSERT INTO FAVORITES(" + statementLabels + ") VALUES (" + statementValues + ")");
            stmt.executeUpdate("INSERT INTO FAVORITES(" + statementLabels + ") VALUES (" + statementValues + ")");

            stmt.close();
            System.out.println("DB info added");

        }

    }
}
