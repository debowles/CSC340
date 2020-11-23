/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.ChangePreference.SmallAndFurryPreferences;

import CSC340.DB.PropertiesDBConnector;
import java.sql.SQLException;

/**
 *
 * @author biscu
 */
public class SmallAndFurryPreferencesModel {
     String gender = "";
    String age = "";  
    String size = "";

    private SmallAndFurryPreferencesView theView;

    public SmallAndFurryPreferencesModel(SmallAndFurryPreferencesView _theView) {
        this.theView = _theView;
    }

    public void addToDB() throws SQLException {
        String preferances = gender+","+age+","+size;
        
        //Figure out how to store current ID
        PropertiesDBConnector.updateUserInfoDB("BARNYARD_PARAMETERS",preferances,"12");
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
