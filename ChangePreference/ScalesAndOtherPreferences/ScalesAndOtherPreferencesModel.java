/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.ChangePreference.ScalesAndOtherPreferences;

import CSC340.DB.PropertiesDBConnector;
import java.sql.SQLException;

/**
 *
 * @author biscu
 */
public class ScalesAndOtherPreferencesModel {
    String gender = "";
    String age = "";  
    String size = "";

    private ScalesAndOtherPreferencesView theView;

    public ScalesAndOtherPreferencesModel(ScalesAndOtherPreferencesView _theView) {
        this.theView = _theView;
    }
    //Adds info to DB
    public void addToDB(String id) throws SQLException {
        String preferances = gender+","+age+","+size;
        

        PropertiesDBConnector.updateUserInfoDB("SCALES_PARAMETERS",preferances,id);
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
