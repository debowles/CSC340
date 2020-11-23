/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.DB;

import static CSC340.DB.DBConnector.createID;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author biscu
 */
public class DBController {
    public static String createUserDB(HashMap<String,String> signUp) throws SQLException{        
        String id = createID();
        SignUpDatabaseConnector.addUserInfoDB(signUp, id);
        PropertiesDBConnector.addUserInfoDB(signUp, id);
        return id;
    }
    public static void loginUserDB(String username, String password) throws SQLException{
        
    }
    
    public static HashMap<String, String> getAllDBInfo(String id) throws SQLException{
        HashMap<String,String> map = SignUpDatabaseConnector.readUserInfoDB(id);
        HashMap<String,String> propertiesMap = PropertiesDBConnector.readUserInfoDB(id);
        map.putAll(propertiesMap);
        return map;
    }
}
