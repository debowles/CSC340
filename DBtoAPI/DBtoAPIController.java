/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.DBtoAPI;

import static CSC340.DB.DBController.getAllDBInfo;
import static CSC340.DBtoAPI.SignUpDBPetFinderParcer.animalPropertiesParced;

import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author biscu
 */
public class DBtoAPIController {
    public static String DBtoAPI(String id) throws SQLException{       
        HashMap<String,String> properties;
        properties = getAllDBInfo(id);
        String apiParameters; 
        apiParameters = animalPropertiesParced(properties);
        
        return apiParameters;
    }
}
