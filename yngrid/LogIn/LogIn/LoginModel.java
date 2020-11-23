package LogIn;

/*
* The purpose of this class to grab data from login database, where the user
* inserts their information and is granted access or not.
* Last updated: 11/17/2020
* Author: Yngrid Corrales
 */
import static CSC340.DB.SignUpDatabaseConnector.checkForValue;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginModel {

    /* The Model coordinates interactions with the view */
    private LoginView theView;

    public LoginModel(LoginView _theView) {
        this.theView = _theView;
    }

    /* This method grabs data from login database and checks to see if user exists */
    public void addToDB(String _email, String _password) {
        /* Checks to see if the email and password inserted matches the database */
        try {
            checkForValue("EMAIL", _email);
            checkForValue("PASSWORD", _password);

            if (_email.equals("") && _password.equals("")) {
                theView.displayLoginUnsuccessful("Login Failed... Please type in your information");
            } else if (checkForValue("EMAIL", _email) && (checkForValue("PASSWORD", _password))) {

                theView.displayLoginSuccessful("Login Successful");

            } else {

                theView.displayLoginUnsuccessful("Login Failed..");
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
