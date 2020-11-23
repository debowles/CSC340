/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.ChangePreference.BirdPreferences;

import CSC340.DB.PropertiesDBConnector;
import java.sql.SQLException;

/**
 *
 * @author David Bowles
 */
public class BirdPreferencesModel {
    String gender = "";
    String age = "";  
    String size = "";

    private BirdPreferencesView theView;

    public BirdPreferencesModel(BirdPreferencesView _theView) {
        this.theView = _theView;
    }

    public void addToDB() throws SQLException {
        String preferances = gender+","+age+","+size;
        
        //Figure out how to store current ID
        PropertiesDBConnector.updateUserInfoDB("BIRD_PARAMETERS",preferances,"12");
    }

    public void genderSelected(String _gender){
        gender = gender + _gender;
    }
    public void ageSelected(String _age) {
        age = age + _age;
    }
    
    public void sizeSelected(String _size) {
        size = size + _size;
    }
}
