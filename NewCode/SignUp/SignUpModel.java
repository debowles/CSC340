package CSC340.SignUp;

/*
* The purpose of this class to save data to the login database, where the user
* inserts their information and given the option to choose their preference of
* pets.
* Last updated: 11/17/2020
* Author: Yngrid Corrales
 */
import static CSC340.DB.DBController.createUserDB;
import static CSC340.DB.SignUpDatabaseConnector.checkForValue;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpModel {

    /* Creating strings from the methods created to grab user inputs */
    String email;
    String password;
    String firstName;
    String lastName;
    String phoneNumber;
    String zipCode;
    String searchDistance;
    String animalType = "";
    boolean userNameExists = false;

    /* The Model coordinates interactions with the view */
    private SignUpView theView;

    public SignUpModel(SignUpView _theView) {
        this.theView = _theView;
    }

    /* This method updates the login database objects according to userSignUp table and
     * the haspmap created in the DatabaseConnector Class */
    public String addToDBandGetID() {
        if (animalType.equals("")) {
            theView.displayLoginUnsuccessful("Please select at least one check box.");
        } else if (!animalType.equals("")) {

            try {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("FIRST_NAME", firstName);
                map.put("LAST_NAME", lastName);
                map.put("EMAIL", email);
                map.put("PHONENUMBER", phoneNumber);
                map.put("PASSWORD", password);
                map.put("ZIPCODE", zipCode);
                map.put("RADIUS", searchDistance);
                map.put("ANIMALTYPE", animalType);

                String id = createUserDB(map);

                theView.displayLoginSuccessful("New user added.");

            } catch (SQLException ex) {
                theView.displayLoginSuccessful("catch");
                Logger.getLogger(SignUpModel.class.getName()).log(Level.SEVERE, null, ex);

            }

        }return null;

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

    /* This method grabs users email from the controller and checks if the email already exists */
    public Boolean emailExists(String _email) {
        try {
            checkForValue("EMAIL", _email);
            if (checkForValue("EMAIL", _email)) {
                userNameExists = true;
                theView.displayLoginUnsuccessful("Email already exists..");
                return true;
            } else if (!checkForValue("EMAIL", _email)) {
            }
        } catch (SQLException ex) {
            Logger.getLogger(SignUpModel.class.getName()).log(Level.SEVERE, null, ex);
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

    /* This methods check to see if the textfield was left blank and displays a message */
    public Boolean emptyFirstName(String _firstName) {
        if (_firstName.equals("")) {
            theView.displayLoginUnsuccessful("Something was left unanswered, please go back and check.");
            return true;
        } else if (!_firstName.equals("")) {
        }
        return false;
    }

    /* This methods check to see if the textfield was left blank and displays a message */
    public Boolean emptyLastName(String _lastName) {
        if (_lastName.equals("")) {
            theView.displayLoginUnsuccessful("Something was left unanswered, please go back and check.");
            return true;
        } else if (!_lastName.equals("")) {
        }
        return false;
    }

    /* This method checks for null input and if it's a string rather than a int */
    public Boolean emptyRadius(String _radius) {
        if (_radius.equals("")) {
            theView.displayLoginUnsuccessful("Something was left unanswered, please go back and check.");
            return true;
        } else if (!_radius.equals("")) {
            try {
                Integer.parseInt(_radius);
            } catch (NumberFormatException e) {
                theView.displayLoginUnsuccessful(_radius + " Is not a valid search radius");
                return true;
            }
        } else if (!_radius.equals("")) {
        }
        return false;
    }

    /* This method checks for null input and if it's a string rather than a int */
    public Boolean emptyPhoneNo(String _phoneNo) {
        if (_phoneNo.equals("")) {
            theView.displayLoginUnsuccessful("Something was left unanswered, please go back and check.");
            return true;
        } else if (!_phoneNo.equals("")) {
            try {
                Long.parseLong(_phoneNo);
            } catch (NumberFormatException e) {
                theView.displayLoginUnsuccessful(_phoneNo + " Is not a valid Phone Number");
                return true;
            }
        } else if (!_phoneNo.equals("")) {
        }
        return false;
    }

    /* This method checks for null input and if it's a string rather than a int */
    public Boolean emptyZip(String _zipCode) {

        if (_zipCode.equals("")) {
            theView.displayLoginUnsuccessful("Something was left unanswered, please go back and check.");
            return true;
        } else if (!_zipCode.equals("")) {
            try {
                Integer.parseInt(_zipCode);
            } catch (NumberFormatException e) {
                theView.displayLoginUnsuccessful(_zipCode + " Is not a valid ZipCode");
                return true;
            }
        } else if (!_zipCode.equals("")) {
        }
        return false;
    }

    /* This methods check to see if the textfield was left blank and displays a message */
    public Boolean emptyPass(String _password) {
        if (_password.equals("")) {
            theView.displayLoginUnsuccessful("Something was left unanswered, please go back and check.");
            return true;
        } else if (!_password.equals("")) {
        }
        return false;
    }

    /* This methods check to see if the textfield was left blank and displays a message */
    public Boolean emptyRePass(String _rePass) {
        if (_rePass.equals("")) {
            theView.displayLoginUnsuccessful("Something was left unanswered, please go back and check.");
            return true;
        } else if (!_rePass.equals("")) {
        }
        return false;
    }
}
