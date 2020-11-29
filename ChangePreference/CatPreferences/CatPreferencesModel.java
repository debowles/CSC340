/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.ChangePreference.CatPreferences;

import CSC340.DB.PropertiesDBConnector;
import java.sql.SQLException;

/**
 *
 * @author David Bowles
 */
public class CatPreferencesModel {
    String gender = "";
    String age = "";  
    String size = "";

    private CatPreferencesView theView;

    public CatPreferencesModel(CatPreferencesView _theView) {
        this.theView = _theView;
    }

    public void addToDB(String id) throws SQLException {
        String preferances = gender+","+age+","+size;
        
        //Figure out how to store current ID
        PropertiesDBConnector.updateUserInfoDB("CAT_PARAMETERS",preferances,id);
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
