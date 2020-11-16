/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.APIParcer;

import static CSC340.APIParcer.Animal.getAnimalObjectFromHashMap;
import static CSC340.APIParcer.PetFinderAPIJson.getJsonHashMap;
import CSC340.DB.DBPetFinderParcer;
import CSC340.apiCall.PetFinderAPI;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author biscu
 */
public class PetFinderParcerTester {
    public static void main(String[] args) throws SQLException, IOException, JSONException{
        //System.out.println(DBPetFinderParcer.getParameters());
        
        PetFinderAPI url = new PetFinderAPI("https://api.petfinder.com/v2/animals?");
        String a = "https://api.petfinder.com/v2/animals?"+DBPetFinderParcer.getParameters();
        PetFinderAPI url2 = new PetFinderAPI(a);
        System.out.println(url2.toString());
        String s1 = url2.loadAPI(url);  
        
        
        HashMap<String, Object> map = getJsonHashMap(s1);
        
        
        
        
        //System.out.println(jObject.toString());
        
        
        ArrayList<Animal> animalList  = getAnimalObjectFromHashMap((map.get("animals")).toString());
        
    }
    
    
    
    
}
