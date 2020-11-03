
package LogIn_signUp;

/*
* The purpose of this class to establish a connection to the login database
* Last updated: 10/22/2020
* Author: Yngrid Corrales
*/

import LogIn_signUp.userSignIn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DatabaseConnector {
    // Creating a connection to login database
     public static Connection connectdb(){
       Connection con = null;
       try {
           con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root");
           return con;
       } catch (SQLException ex) {
           Logger.getLogger(userSignIn.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
   }
}
