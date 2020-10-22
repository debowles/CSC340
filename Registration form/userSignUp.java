/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogIn_signUp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class userSignUp {

    /**
     * @return 
     */
    public static Connection getConnection(){
        // TODO code application logic here
        Connection connection =null;
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:derby://localhost/userInfo","localHost","root");
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
         return connection;
    }
   
    
}
 