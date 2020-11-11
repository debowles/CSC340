package SignUp;
/*
* The purpose of this class to save data to the login database, where the user
* inserts their information and given the option to choose their preference of
* pets.
* Last updated: 11/10/2020
* Author: Yngrid Corrales
 */
import CSC340.DB.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpModel {

    /* Establishing connection to DatabaseConnector class*/
    Connection con = DatabaseConnector.connectdb();
    PreparedStatement ps = null;

    /* Creating strings from the methods created to grab user inputs */
    String email;
    String password;
    String firstName;
    String lastName;
    String phoneNumber;
    String zipCode;
    String searchDistance;
    String animalType = "";

    /* The Model coordinates interactions with the view */
    private SignUpView theView;

    public SignUpModel(SignUpView _theView) {
        this.theView = _theView;
    }

    /* This method updates the login database objects according to userSignUp table */
    public void addToDB() {
        try {
            ps = con.prepareStatement("insert into userSignUp values(?,?,?,?,?,?,?,?)");
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, phoneNumber);
            ps.setString(5, password);
            ps.setString(6, zipCode);
            ps.setString(7, searchDistance);
            ps.setString(8, animalType);
            ps.executeUpdate();

            /* If successfully inserted display message */
            theView.displayLoginSuccessful("New user added.");

        } catch (SQLException ex) {
            theView.displayLoginSuccessful("catch");
            Logger.getLogger(SignUpModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* This method grabs users email and phonenumber from the controller */
    public void emailPhoneNo(String _email, String _phoneNumber) {
        email = _email;
        phoneNumber = _phoneNumber;
    }

    /* This method grabs users first name and last name from the controller */
    public void firstAndLastName(String _firstName, String _lastName) {
        firstName = _firstName;
        lastName = _lastName;

    }

    /* This method grabs users password and repassword from the controller */
    public void passAndRePass(String _password, String _rePass) {
        password = _password;
    }

    /* This method grabs users zip code and search radius from the controller */
    public void zipCodeAndRadius(String _zipCode, String _radius) {
        zipCode = _zipCode;
        searchDistance = _radius;
    }

    /* This method grabs users pet preference from the controller */
    public void animalSelected(String _animal) {
        animalType = animalType + _animal;
    }


    /* This method grabs users email from the controller and checks if valid */
    public Boolean validEmail(String _email) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matches = emailPat.matcher(_email);
        if (matches.find() == false) {
            theView.displayLoginUnsuccessful("Please enter a valid email address.");
            return true;
        } else if (matches.find() == true) {

        }
        return false;
    }

    /* This method grabs users password and repasword from the controller and checks if they match */
    public Boolean noMatch(String _password, String _rePass) {
        if (!_password.equals(_rePass)) {
            theView.displayLoginUnsuccessful("Password does not match, retype password.");
            return true;
        } else if (_password.equals(_rePass)) {
        }
        return false;
    }

    /* This method grabs users zip code from the controller and checks if it's valid */
    public Boolean inValidZip(String _zipCode) {
        if ((Integer.valueOf(_zipCode) < 12345) || (Integer.valueOf(_zipCode) > 67890)) {
            theView.displayLoginUnsuccessful("Please enter a valid zipcode.");
            return true;
        } else if ((Integer.valueOf(_zipCode) > 12345) || (Integer.valueOf(_zipCode) < 67890)) {
        }
        return false;
    }

    /* This method grabs users search radius the controller and checks if it's within bounds */
    public Boolean outOfBoundsRadius(String _radius) {
        if ((Integer.valueOf(_radius) < 100) || (Integer.valueOf(_radius) > 500)) {
            theView.displayLoginUnsuccessful("Out of bounds, please enter a search radius between 100-500miles");
            return true;
        } else if ((Integer.valueOf(_radius) > 100) || (Integer.valueOf(_radius) < 500)) {
        }
        return false;
    }

    /* The following methods check to see if each textfield was left blank and displays a message */
    public Boolean emptyFirstName(String _firstName) {
        if (_firstName.equals("")) {
            theView.displayLoginUnsuccessful("No first name added, please add first name.");
            return true;
        } else if (!_firstName.equals("")) {
        }
        return false;
    }

    public Boolean emptyLastName(String _lastName) {
        if (_lastName.equals("")) {
            theView.displayLoginUnsuccessful("No last name added, please add last name.");
            return true;
        } else if (!_lastName.equals("")) {
        }
        return false;
    }

    public Boolean emptyRadius(String _radius) {
        if (_radius.equals("")) {
            theView.displayLoginUnsuccessful("No search radius added, please add radius.");
            return true;
        } else if (!_radius.equals("")) {
        }
        return false;
    }

    public Boolean emptyPhoneNo(String _phoneNo) {
        if (_phoneNo.equals("")) {
            theView.displayLoginUnsuccessful("No phone number added, please add phone number.");
            return true;
        } else if (!_phoneNo.equals("")) {
        }
        return false;
    }

    public Boolean emptyZip(String _zipCode) {
        if (_zipCode.equals("")) {
            theView.displayLoginUnsuccessful("No zip code added, please add zip code.");
            return true;
        } else if (!_zipCode.equals("")) {
        }
        return false;
    }

    public Boolean emptyPass(String _password) {
        if (_password.equals("")) {
            theView.displayLoginUnsuccessful("No password added, please add password.");
            return true;
        } else if (!_password.equals("")) {
        }
        return false;
    }

    public Boolean emptyRePass(String _rePass) {
        if (_rePass.equals("")) {
            theView.displayLoginUnsuccessful("Please type in the password for retype password.");
            return true;
        } else if (!_rePass.equals("")) {
        }
        return false;
    }
}
