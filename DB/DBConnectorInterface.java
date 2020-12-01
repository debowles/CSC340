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
 * @author David Bowles
 */
public interface DBConnectorInterface {
   
    //reda one parameter
   public static String readUserParameters(String label, int rowNum) throws SQLException{
       return null;
   };
   
   //reads whole row
   public static HashMap<String,String> readUserInfoDB(int rowNum) throws SQLException{
       return null;
   };
   
   //updates userinfo
   public static void updateUserInfoDB(String label, String variable, String id) throws SQLException{
       
   };
   //deletes info
   public static void deleteUserInfoDB(int rowNum) throws SQLException{
       
   };
   //adds new user
   public static void addUserInfoDB(HashMap<String,String> map ) throws SQLException{
       
   };
}


    