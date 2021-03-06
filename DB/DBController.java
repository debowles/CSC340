/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.DB;

import CSC340.APIParcer.Animal;
import static CSC340.DB.DBConnector.createID;
import static CSC340.DB.SignUpDatabaseConnector.getID;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author David Bowles
 */
public class DBController {
    public static void createUserDB(HashMap<String,String> signUp) throws SQLException{        
        String id = createID();
        SignUpDatabaseConnector.addUserInfoDB(signUp, id);
        PropertiesDBConnector.addUserInfoDB(signUp, id);
        
    }
    public static boolean loginUserDB(String username, String password) throws SQLException{
        return SignUpDatabaseConnector.DBLogIn(username,password);
    }
    
    public static String getIDController(String username) throws SQLException{
        System.out.println("getIDController");
        return getID("EMAIL",username);                
    }
    
    public static HashMap<String, String> getAllDBInfo(String id) throws SQLException{
        HashMap<String,String> map = SignUpDatabaseConnector.readUserInfoDB(id);
        HashMap<String,String> propertiesMap = PropertiesDBConnector.readUserInfoDB(id);
        map.putAll(propertiesMap);
        return map;
    }
    
//    public static HashMap<String,String> getFavoritesList(String id) throws SQLException{
//        HashMap<String,String> list = FavoritesDBConnector.readUserInfoDB(id);
//        return list;
//    }
    
    public static void addToFavoritesDB(HashMap<String,String> animalMap) throws SQLException{
        FavoritesDBConnector.addUserInfoDB(animalMap);
    }

    public static ArrayList<Animal> getFavoritesAnimalList(String id) throws SQLException {
        ArrayList<Animal> animal = DBFactory.getAnimalList(id);
        System.out.println("Animal List DB Controller: "+animal.toString());
        return animal;
    }
}
