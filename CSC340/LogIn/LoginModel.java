package CSC340.LogIn;
/*
* The purpose of this class to grab data from login database, where the user
* inserts their information and is granted access or not.
* Last updated: 11/10/2020
* Author: Yngrid Corrales
 */
import CSC340.DB.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class LoginModel{
    /* Establishing connection to DatabaseConnector class*/
    Connection con = DatabaseConnector.connectdb();
    PreparedStatement ps = null;
    ResultSet result = null;

    /* The Model coordinates interactions with the view */
    private LoginView theView;
    public LoginModel (LoginView _theView){
        this.theView = _theView;
    }
/* This method grabs data from login database and checks to see if user exists */
    public void addToDB(String _email, String _password){
         /* Grabs users email and password saved from the signUp database */
        String login = "SELECT * FROM userSignUp WHERE email =? AND password=?";

         /* Checks to see if the email and password inserted matches the database */
           try {
            ps = con.prepareStatement (login);
            ps.setString(1, _email);
            ps.setString(2, _password);
            result = ps.executeQuery();


            if (_email.equals("") && _password.equals("")){
                theView.displayLoginUnsuccessful("Login Failed... Please type in your information");
            }
            else if (result.next() ) {

                theView.displayLoginSuccessful("Login Successful");

            } else{

                theView.displayLoginUnsuccessful("Login Failed..");
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex);
        }
}
}
