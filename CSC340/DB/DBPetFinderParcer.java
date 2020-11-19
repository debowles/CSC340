/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.DB;

import static CSC340.DB.DBFactory.getUserParameters;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author David Bowles
 */
public class DBPetFinderParcer {

    public static String getParameters() throws SQLException {
        //add getUserRow
        
        //Hardcoded row number Fix
        HashMap<String, String> parameters = getUserParameters(1);
        String s = parameters.toString();
        String parsedString = "&";
        
        System.out.println(s);
        
        if (s.contains("ANIMALTYPE")) {
           parsedString  = parsedString + animalTypeParced(s);
        }
        if (s.contains("ZIPCODE")) {
            parsedString  = parsedString + "location="+parameters.get("ZIPCODE")+"&";
        }

        if (s.contains("RADIUS")) {
            parsedString = parsedString + "distance="+parameters.get("RADIUS")+"&" ;
        }
        
        return parsedString;
    }

    //parces the data from the dataabse to fit the api
    public static String animalTypeParced(String s) {
        String parsedString = "";

        //returns "type=Dog?"
        if (s.contains("Dog")) {
            parsedString = parsedString + "type=" + "Dog&";
        }
        if (s.contains("Cat")) {
            parsedString = parsedString + "type=" + "Cat&";
        }
        if (s.contains("Rabbit")) {
            parsedString = parsedString + "type=" + "Rabbit&";
        }
        if (s.contains("Bird")) {
            parsedString = parsedString + "type=" + "Bird&";
        }
        if (s.contains("Scales, Fins & Other")) {
            parsedString = parsedString + "type=" + "Scales, Fins & Other&";
        }
        if (s.contains("Small & Furry")) {
            parsedString = parsedString + "type=" + "Small & Furry&";
        }
        if (s.contains("Horse")) {
            parsedString = parsedString + "type=" + "Horse&";
        }
        if (s.contains("Barnyard")) {
            parsedString = parsedString + "type=" + "Barnyard&";
        }

        System.out.println(parsedString);
        return parsedString;

    }

    //parces the Zip code to fit the API
    public static String zipCodeParced(HashMap<String,String> map){
        if(map.containsKey("ZIPCODE")){
            String s = map.get("ZIPCODE");           
            return "location="+s+"&";
        }                     
        return null;
        
    }
}
