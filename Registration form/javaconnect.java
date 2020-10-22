
package LogIn_signUp;

import LogIn_signUp.userSignIn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Liz
 */

//Connecting to logindb with username and password being root
public class javaconnect {
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
