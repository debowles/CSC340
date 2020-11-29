/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.DB;

import static CSC340.DB.PropertiesDBConnector.readUserInfoDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author David Bowles
 */
public class DBFactory {

    //Reads the Labels from a specific user in the database
    
    public static String getUserFirst_Name(int rowNum) throws SQLException {
        String s = SignUpDatabaseConnector.readUserParameters("FIRST_NAME", rowNum);
        return s;
    }

    public static String getUserAnimalType(int rowNum) throws SQLException {
        String s = SignUpDatabaseConnector.readUserParameters("ANIMALTYPE", rowNum);
        return s;
    }

    public static String getUserZipCode(int rowNum) throws SQLException {
        String s = SignUpDatabaseConnector.readUserParameters("ZIPCODE", rowNum);
        return s;
    }

    public static String getUserLast_Name(int rowNum) throws SQLException {
        String s = SignUpDatabaseConnector.readUserParameters("LAST_NAME", rowNum);
        return s;
    }

    public static String getUserEmail(int rowNum) throws SQLException {
        String s = SignUpDatabaseConnector.readUserParameters("EMAIL", rowNum);
        return s;
    }

    public static String getUserPhonenumber(int rowNum) throws SQLException {
        String s = SignUpDatabaseConnector.readUserParameters("PHONENUMBER", rowNum);
        return s;
    }

    public static String getUserPassword(int rowNum) throws SQLException {
        String s = SignUpDatabaseConnector.readUserParameters("PASSWORD", rowNum);
        return s;
    }

    public static String getUserRadius(int rowNum) throws SQLException {
        String s = SignUpDatabaseConnector.readUserParameters("RADIUS", rowNum);
        return s;
    }

    public static ArrayList<String> getAnimalTypeList(String id) throws SQLException{
        HashMap<String,String> map = readUserInfoDB(id);
        String parametersString = map.get("ANIMALTYPE");
        ArrayList<String> list = new ArrayList<String>();
        if (parametersString.contains("Dog")) {
            list.add("Dog");
        }
        if (parametersString.contains("Cat")) {
           list.add("Cat");
        }
        if (parametersString.contains("Rabbit")) {
            list.add("Rabbit");
        }
        if (parametersString.contains("Bird")) {
            list.add("Bird");
        }
        if (parametersString.contains("Scales, Fins & Other")) {
            list.add("Scales, Fins & Other");
        }
        if (parametersString.contains("Small & Furry")) {
            list.add("Small & Furry");
        }
        if (parametersString.contains("Horse")) {
            list.add("Horse");
        }
        if (parametersString.contains("Barnyard")) {
            list.add("Barnyard");
        }
        
        return list;
    }
    
    //gets the parameters for the api from the user in the database
    public static HashMap<String, String> getAPIParameters(int rowNum) throws SQLException {
        HashMap<String, String> parameters = new HashMap<>();

        String s = getUserAnimalType(rowNum);
        if (s != "NULL") {
            parameters.put("ANIMALTYPE", s);
        }
        s = getUserZipCode(rowNum);
        if (s != "NULL") {
            parameters.put("ZIPCODE", s);
        }
        s = getUserRadius(rowNum);
        if (s != "NULL") {
            parameters.put("RADIUS", s);
        }

        return parameters;

    }
}
