/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.ChangePreference;

import CSC340.DB.PropertiesDBConnector;
import CSC340.DB.SignUpDatabaseConnector;
import java.sql.SQLException;

/**
 *
 * @author David Bowles
 */
public class PetChangePreferencesModel {
    String animalType = "";
    String zipCode;
    String searchDistance;
    
    private PetChangePreferencesView theView;
    
    public PetChangePreferencesModel(PetChangePreferencesView _theView) {
        this.theView = _theView;
    }
    
    //Adds info to DB when user clicks Save
    public void addToDB() throws SQLException {
    //TODO: find a way to save ID
    PropertiesDBConnector.updateUserInfoDB("ANIMALTYPE", animalType, "12");
    
    SignUpDatabaseConnector.updateUserInfoDB("ANIMALTYPE", animalType, "12");
    SignUpDatabaseConnector.updateUserInfoDB("ZIPCODE", zipCode, "12");
    SignUpDatabaseConnector.updateUserInfoDB("RADIUS", searchDistance, "12");
    }
    
    
    public void zipCodeAndRadius(String _zipCode, String _radius) {
        zipCode = _zipCode;
        searchDistance = _radius;
    }
    
    public void animalSelected(String _animal) {
        animalType = animalType + _animal;
    }
    
    //Checks for valid Zip
    public Boolean inValidZip(String _zipCode) {
        if ((Integer.valueOf(_zipCode) < 12345) || (Integer.valueOf(_zipCode) > 67890)) {
            theView.displayLoginUnsuccessful("Please enter a valid zipcode.");
            return true;
        } else if ((Integer.valueOf(_zipCode) > 12345) || (Integer.valueOf(_zipCode) < 67890)) {
        }
        return false;
    }
    
    //Checks to see if amount of miles is in range
    public Boolean outOfBoundsRadius(String _radius) {
        if ((Integer.valueOf(_radius) < 100) || (Integer.valueOf(_radius) > 500)) {
            theView.displayLoginUnsuccessful("Out of bounds, please enter a search radius between 100-500miles");
            return true;
        } else if ((Integer.valueOf(_radius) > 100) || (Integer.valueOf(_radius) < 500)) {
        }
        return false;
    }
    
    //Makes sure radius isn't empty
    public Boolean emptyRadius(String _radius) {
        if (_radius.equals("")) {
            theView.displayLoginUnsuccessful("No search radius added, please add radius.");
            return true;
        } else if (!_radius.equals("")) {
        }
        return false;
    }
    
    
    //Makes sure Zip is not empty
    public Boolean emptyZip(String _zipCode) {
        if (_zipCode.equals("")) {
            theView.displayLoginUnsuccessful("No zip code added, please add zip code.");
            return true;
        } else if (!_zipCode.equals("")) {
        }
        return false;
    }
}
