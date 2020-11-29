/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.DBtoAPI;

import static CSC340.DB.DBController.getAllDBInfo;
import static CSC340.DBtoAPI.SignUpDBPetFinderParcer.animalPropertiesListToString;
import static CSC340.DBtoAPI.SignUpDBPetFinderParcer.animalPropertiesListToStringBarnyard;
import static CSC340.DBtoAPI.SignUpDBPetFinderParcer.animalPropertiesListToStringBird;
import static CSC340.DBtoAPI.SignUpDBPetFinderParcer.animalPropertiesListToStringCat;
import static CSC340.DBtoAPI.SignUpDBPetFinderParcer.animalPropertiesListToStringDog;
import static CSC340.DBtoAPI.SignUpDBPetFinderParcer.animalPropertiesListToStringHorse;
import static CSC340.DBtoAPI.SignUpDBPetFinderParcer.animalPropertiesListToStringRabbit;
import static CSC340.DBtoAPI.SignUpDBPetFinderParcer.animalPropertiesListToStringScales;
import static CSC340.DBtoAPI.SignUpDBPetFinderParcer.animalPropertiesListToStringSmallF;
import static CSC340.DBtoAPI.SignUpDBPetFinderParcer.animalPropertiesParced;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author biscu
 */
public class DBtoAPIController {
    public static String DBtoAPI(String id) throws SQLException{       
        HashMap<String,String> properties;
        properties = getAllDBInfo(id);
       ArrayList<String> apiParametersList = animalPropertiesParced(properties);        
        String apiParameters = animalPropertiesListToString(apiParametersList,"0");
        
        return apiParameters;
    }
    public static String DBtoAPIPage(String id,String page) throws SQLException{       
        HashMap<String,String> properties;
        properties = getAllDBInfo(id);
        ArrayList<String> apiParametersList = animalPropertiesParced(properties);        
        String apiParameters = animalPropertiesListToString(apiParametersList,page);
        
        return apiParameters;
    }
    public static String DBToAPIDog(String id, String page) throws SQLException{
        HashMap<String,String> properties;
        properties = getAllDBInfo(id);
        ArrayList<String> apiParametersList = animalPropertiesParced(properties);     
        String apiParameters = animalPropertiesListToStringDog(apiParametersList,page);
        return apiParameters;
    }
    public static String DBToAPICat(String id, String page) throws SQLException{
        HashMap<String,String> properties;
        properties = getAllDBInfo(id);
        ArrayList<String> apiParametersList = animalPropertiesParced(properties);     
        String apiParameters = animalPropertiesListToStringCat(apiParametersList,page);
        return apiParameters;
    }
    public static String DBToAPIRabbit(String id, String page) throws SQLException{
        HashMap<String,String> properties;
        properties = getAllDBInfo(id);
        ArrayList<String> apiParametersList = animalPropertiesParced(properties);     
        String apiParameters = animalPropertiesListToStringRabbit(apiParametersList,page);
        return apiParameters;
    }
    public static String DBToAPIBird(String id, String page) throws SQLException{
        HashMap<String,String> properties;
        properties = getAllDBInfo(id);
        ArrayList<String> apiParametersList = animalPropertiesParced(properties);     
        String apiParameters = animalPropertiesListToStringBird(apiParametersList,page);
        return apiParameters;
    }
    public static String DBToAPIScales(String id, String page) throws SQLException{
        HashMap<String,String> properties;
        properties = getAllDBInfo(id);
        ArrayList<String> apiParametersList = animalPropertiesParced(properties);     
        String apiParameters = animalPropertiesListToStringScales(apiParametersList,page);
        return apiParameters;
    }
    public static String DBToAPISmallF(String id, String page) throws SQLException{
        HashMap<String,String> properties;
        properties = getAllDBInfo(id);
        ArrayList<String> apiParametersList = animalPropertiesParced(properties);     
        String apiParameters = animalPropertiesListToStringSmallF(apiParametersList,page);
        return apiParameters;
    }
    public static String DBToAPIHorse(String id, String page) throws SQLException{
        HashMap<String,String> properties;
        properties = getAllDBInfo(id);
        ArrayList<String> apiParametersList = animalPropertiesParced(properties);     
        String apiParameters = animalPropertiesListToStringHorse(apiParametersList,page);
        return apiParameters;
    }
    public static String DBToAPIBarnyard(String id, String page) throws SQLException{
        HashMap<String,String> properties;
        properties = getAllDBInfo(id);
        ArrayList<String> apiParametersList = animalPropertiesParced(properties);     
        String apiParameters = animalPropertiesListToStringBarnyard(apiParametersList,page);
        return apiParameters;
    }
}
