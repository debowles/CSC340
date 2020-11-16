/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.DB;

import static CSC340.DB.DBFactory.getUserParameters;
import static CSC340.DB.DatabaseConnector.*;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author biscu
 */
public class DBTester {
    public static void main(String[] args) throws SQLException{
        //System.out.println(getUserParameters(5));
        //HashMap<String,String> map = readUserInfoDB(1);
        
        HashMap<String,String> map = new HashMap<String,String>();
            map.put("FIRST_NAME", "David");
            map.put("LAST_NAME", "Bowles");
            map.put("EMAIL", "debowles@uncg.edu");
            map.put("PHONENUMBER", "9102629621");
            map.put("PASSWORD", "Rascal123");
            map.put("ZIPCODE", "28428");
            map.put("RADIUS", "100");
            map.put("ANIMALTYPE", "Dog");
            map.put("ID", "1");  
            addUserInfoDB(map);
        
        
        
        
        
        System.out.println(map.toString());
        
        
        
        addUserInfoDB(map);
        
        //updateUserInfoDB("FIRST_NAME", "David", "1");
        
        deleteUserInfoDB("2");
        
        //addUserInfoDB(map);
    }
}
