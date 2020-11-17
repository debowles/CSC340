/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.DB;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author biscu
 */
public interface DBConnectorInterface {
   
    
   public static String readUserParameters(String label, int rowNum) throws SQLException{
       return null;
   };
   
   //reads whole row
   public static HashMap<String,String> readUserInfoDB(int rowNum) throws SQLException{
       return null;
   };
   
   public static void updateUserInfoDB(String label, String variable, String id) throws SQLException{
       
   };
   
   public static void deleteUserInfoDB(int rowNum) throws SQLException{
       
   };
   
   public static void addUserInfoDB(HashMap<String,String> map ) throws SQLException{
       
   };
}


    