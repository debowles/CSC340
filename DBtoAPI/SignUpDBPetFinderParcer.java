/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.DBtoAPI;

import static CSC340.DB.DBFactory.getAPIParameters;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author David Bowles
 */
public class SignUpDBPetFinderParcer {

//    public static String parseParameters(HashMap<String, String> parameters) throws SQLException {
//        //add getUserRow        
//        String s = parameters.toString();
//        String parsedString = "&";
//        
//        System.out.println(s);
//               
//        if (s.contains("ZIPCODE")) {
//            parsedString  = parsedString + zipCodeParced(parameters);
//        }
//        if (s.contains("RADIUS")) {
//            parsedString = parsedString + radiusParced(parameters);
//        }
//        //if(s.contains("PARAMETERS")){
//       //     parsedString = parsedString + getAnimalProperties(parameters);
//        //}
//        if (s.contains("ANIMALTYPE")) {
//           parsedString  = parsedString + animalPropertiesParced(parameters);
//        }
//        return parsedString;
//    }

    
    //parces the data from the dataabse to fit the api
    public static HashMap<String, String> animalPropertiesParced(HashMap<String, String> parameters) {
        HashMap<String,String> parcedMap = new HashMap<String,String>();
        String parsedString = "";
        String parametersString = parameters.toString();
        if (parametersString.contains("Dog")) {
            parcedMap.put("Dog_URL",zipCodeParced(parameters)+radiusParced(parameters)+ "?type=" + "Dog&" + dogPropertiesParced(parameters)); //ADD PREFERENCES ON TOP OF THIS ? TO SEPERATE ANIMALTYPE
        }
        if (parametersString.contains("Cat")) {
            parcedMap.put("Cat_URL",zipCodeParced(parameters)+radiusParced(parameters)+ "?type=" + "Cat&" + catPropertiesParced(parameters));
        }
        if (parametersString.contains("Rabbit")) {
            parcedMap.put("Rabbit_URL",zipCodeParced(parameters)+radiusParced(parameters)+ "?type=" + "Rabbit&" + rabbitPropertiesParced(parameters));
        }
        if (parametersString.contains("Bird")) {
            parcedMap.put("Bird_URL",zipCodeParced(parameters)+radiusParced(parameters)+ "?type=" + "Bird&" + birdPropertiesParced(parameters));
        }
        if (parametersString.contains("Scales, Fins & Other")) {
            parcedMap.put("Scales_URL",zipCodeParced(parameters)+radiusParced(parameters)+ "?type=" + "Scales, Fins & Other&" + scalePropertiesParced(parameters));
        }
        if (parametersString.contains("Small & Furry")) {
            parcedMap.put("SmallF_URL",zipCodeParced(parameters)+radiusParced(parameters)+ "?type=" + "Small & Furry&" + smallFPropertiesParced(parameters));
        }
        if (parametersString.contains("Horse")) {
            parcedMap.put("Horse_URL",zipCodeParced(parameters)+radiusParced(parameters)+ "?type=" + "Horse&" + horsePropertiesParced(parameters));
        }
        if (parametersString.contains("Barnyard")) {
            parcedMap.put("Barnyard_URL",zipCodeParced(parameters)+radiusParced(parameters)+ "?type=" + "Barnyard&" + barnyardPropertiesParced(parameters));
        }

        System.out.println(parcedMap.toString());
        return parcedMap;

    }

    //parces the Zip code to fit the API
    public static String zipCodeParced(HashMap<String,String> parameters){
        if(parameters.containsKey("ZIPCODE")){
            String s = parameters.get("ZIPCODE");           
            return "location="+s+"&";
        }                     
        return null;
        
    }
    public static String radiusParced(HashMap<String,String> parameters){
        if(parameters.containsKey("RADIUS")){
            String s = parameters.get("RADIUS");           
            return "distance="+s+"&";
        }                     
        return null;
        
    }
    
    public static String dogPropertiesParced(HashMap<String, String> parameters){
        String parsedString = "";
        String parametersString = "";
        if(parameters.containsValue("DOG_PARAMETERS")){
            parametersString = parameters.get("DOG_PARAMETERS"); 
            
            //Gender
            if(parametersString.contains("Male")&&!(parametersString.contains("Female"))){
                parsedString = parsedString + "Gender=" + "Male&";
            }
            if(!(parametersString.contains("Male"))&&parametersString.contains("Female")){
                parsedString = parsedString + "Gender=" + "Female&";
            }
            
            //Age
            if(parametersString.contains("Baby")){
                parsedString = parsedString + "Age=" + "Baby&";
            }
            if(parametersString.contains("Young")){
                parsedString = parsedString + "Age=" + "Young&";
            }
            if(parametersString.contains("Adult")){
                parsedString = parsedString + "Age=" + "Adult&";
            }
            if(parametersString.contains("Senior")){
                parsedString = parsedString + "Age=" + "Senior&";
            }
            
            //Size
            if(parametersString.contains("Small")){
                parsedString = parsedString + "Size=" + "Small&";
            }
            if(parametersString.contains("Medium")){
                parsedString = parsedString + "Size=" + "Medium&";
            }
            if(parametersString.contains("Large")){
                parsedString = parsedString + "Size=" + "Large&";
            }
            if(parametersString.contains("XLarge")){
                parsedString = parsedString + "Size=" + "XLarge&";
            }
        }
        
        //TODO:Preferences Parcer
        
        return parsedString;
    }
    
    public static String catPropertiesParced(HashMap<String, String> parameters){
        String parsedString = "";
        String parametersString = "";
        if(parameters.containsValue("CAT_PARAMETERS")){
            parametersString = parameters.get("CAT_PARAMETERS"); 
            
            //Gender
            if(parametersString.contains("Male")&&!(parametersString.contains("Female"))){
                parsedString = parsedString + "Gender=" + "Male&";
            }
            if(!(parametersString.contains("Male"))&&parametersString.contains("Female")){
                parsedString = parsedString + "Gender=" + "Female&";
            }
            
            //Age
            if(parametersString.contains("Baby")){
                parsedString = parsedString + "Age=" + "Baby&";
            }
            if(parametersString.contains("Young")){
                parsedString = parsedString + "Age=" + "Young&";
            }
            if(parametersString.contains("Adult")){
                parsedString = parsedString + "Age=" + "Adult&";
            }
            if(parametersString.contains("Senior")){
                parsedString = parsedString + "Age=" + "Senior&";
            }
            
            //Size
            if(parametersString.contains("Small")){
                parsedString = parsedString + "Size=" + "Small&";
            }
            if(parametersString.contains("Medium")){
                parsedString = parsedString + "Size=" + "Medium&";
            }
            if(parametersString.contains("Large")){
                parsedString = parsedString + "Size=" + "Large&";
            }
            if(parametersString.contains("XLarge")){
                parsedString = parsedString + "Size=" + "XLarge&";
            }
        }
        
        //TODO:Preferences Parcer
        
        return parsedString;
    }
    
    public static String rabbitPropertiesParced(HashMap<String, String> parameters){
        String parsedString = "";
        String parametersString = "";
        if(parameters.containsValue("RABBIT_PARAMETERS")){
            parametersString = parameters.get("RABBIT_PARAMETERS"); 
            
            //Gender
            if(parametersString.contains("Male")&&!(parametersString.contains("Female"))){
                parsedString = parsedString + "Gender=" + "Male&";
            }
            if(!(parametersString.contains("Male"))&&parametersString.contains("Female")){
                parsedString = parsedString + "Gender=" + "Female&";
            }
            
            //Age
            if(parametersString.contains("Baby")){
                parsedString = parsedString + "Age=" + "Baby&";
            }
            if(parametersString.contains("Young")){
                parsedString = parsedString + "Age=" + "Young&";
            }
            if(parametersString.contains("Adult")){
                parsedString = parsedString + "Age=" + "Adult&";
            }
            if(parametersString.contains("Senior")){
                parsedString = parsedString + "Age=" + "Senior&";
            }
            
            //Size
            if(parametersString.contains("Small")){
                parsedString = parsedString + "Size=" + "Small&";
            }
            if(parametersString.contains("Medium")){
                parsedString = parsedString + "Size=" + "Medium&";
            }
            if(parametersString.contains("Large")){
                parsedString = parsedString + "Size=" + "Large&";
            }
            if(parametersString.contains("XLarge")){
                parsedString = parsedString + "Size=" + "XLarge&";
            }
        }
        
        //TODO:Preferences Parcer
        
        return parsedString;
    }
    
    public static String birdPropertiesParced(HashMap<String, String> parameters){
        String parsedString = "";
        String parametersString = "";
        if(parameters.containsValue("BIRD_PARAMETERS")){
            parametersString = parameters.get("BIRD_PARAMETERS"); 
            
            //Gender
            if(parametersString.contains("Male")&&!(parametersString.contains("Female"))){
                parsedString = parsedString + "Gender=" + "Male&";
            }
            if(!(parametersString.contains("Male"))&&parametersString.contains("Female")){
                parsedString = parsedString + "Gender=" + "Female&";
            }
            
            //Age
            if(parametersString.contains("Baby")){
                parsedString = parsedString + "Age=" + "Baby&";
            }
            if(parametersString.contains("Young")){
                parsedString = parsedString + "Age=" + "Young&";
            }
            if(parametersString.contains("Adult")){
                parsedString = parsedString + "Age=" + "Adult&";
            }
            if(parametersString.contains("Senior")){
                parsedString = parsedString + "Age=" + "Senior&";
            }
            
            //Size
            if(parametersString.contains("Small")){
                parsedString = parsedString + "Size=" + "Small&";
            }
            if(parametersString.contains("Medium")){
                parsedString = parsedString + "Size=" + "Medium&";
            }
            if(parametersString.contains("Large")){
                parsedString = parsedString + "Size=" + "Large&";
            }
            if(parametersString.contains("XLarge")){
                parsedString = parsedString + "Size=" + "XLarge&";
            }
        }
        
        //TODO:Preferences Parcer
        
        return parsedString;
    }
    
    public static String scalePropertiesParced(HashMap<String, String> parameters){
        String parsedString = "";
        String parametersString = "";
        if(parameters.containsValue("SCLAES_PARAMETERS")){
            parametersString = parameters.get("SCLAES_PARAMETERS"); 
            
            //Gender
            if(parametersString.contains("Male")&&!(parametersString.contains("Female"))){
                parsedString = parsedString + "Gender=" + "Male&";
            }
            if(!(parametersString.contains("Male"))&&parametersString.contains("Female")){
                parsedString = parsedString + "Gender=" + "Female&";
            }
            
            //Age
            if(parametersString.contains("Baby")){
                parsedString = parsedString + "Age=" + "Baby&";
            }
            if(parametersString.contains("Young")){
                parsedString = parsedString + "Age=" + "Young&";
            }
            if(parametersString.contains("Adult")){
                parsedString = parsedString + "Age=" + "Adult&";
            }
            if(parametersString.contains("Senior")){
                parsedString = parsedString + "Age=" + "Senior&";
            }
            
            //Size
            if(parametersString.contains("Small")){
                parsedString = parsedString + "Size=" + "Small&";
            }
            if(parametersString.contains("Medium")){
                parsedString = parsedString + "Size=" + "Medium&";
            }
            if(parametersString.contains("Large")){
                parsedString = parsedString + "Size=" + "Large&";
            }
            if(parametersString.contains("XLarge")){
                parsedString = parsedString + "Size=" + "XLarge&";
            }
        }
        
        //TODO:Preferences Parcer
        
        return parsedString;
    }
    
    public static String smallFPropertiesParced(HashMap<String, String> parameters){
        String parsedString = "";
        String parametersString = "";
        if(parameters.containsValue("SMALLANDFURRY_PARAMETERS")){
            parametersString = parameters.get("SMALLANDFURRY_PARAMETERS"); 
            
            //Gender
            if(parametersString.contains("Male")&&!(parametersString.contains("Female"))){
                parsedString = parsedString + "Gender=" + "Male&";
            }
            if(!(parametersString.contains("Male"))&&parametersString.contains("Female")){
                parsedString = parsedString + "Gender=" + "Female&";
            }
            
            //Age
            if(parametersString.contains("Baby")){
                parsedString = parsedString + "Age=" + "Baby&";
            }
            if(parametersString.contains("Young")){
                parsedString = parsedString + "Age=" + "Young&";
            }
            if(parametersString.contains("Adult")){
                parsedString = parsedString + "Age=" + "Adult&";
            }
            if(parametersString.contains("Senior")){
                parsedString = parsedString + "Age=" + "Senior&";
            }
            
            //Size
            if(parametersString.contains("Small")){
                parsedString = parsedString + "Size=" + "Small&";
            }
            if(parametersString.contains("Medium")){
                parsedString = parsedString + "Size=" + "Medium&";
            }
            if(parametersString.contains("Large")){
                parsedString = parsedString + "Size=" + "Large&";
            }
            if(parametersString.contains("XLarge")){
                parsedString = parsedString + "Size=" + "XLarge&";
            }
        }
        
        //TODO:Preferences Parcer
        
        return parsedString;
    }
    public static String horsePropertiesParced(HashMap<String, String> parameters){
        String parsedString = "";
        String parametersString = "";
        if(parameters.containsValue("HORSES_PARAMETERS")){
            parametersString = parameters.get("HORSES_PARAMETERS"); 
            
            //Gender
            if(parametersString.contains("Male")&&!(parametersString.contains("Female"))){
                parsedString = parsedString + "Gender=" + "Male&";
            }
            if(!(parametersString.contains("Male"))&&parametersString.contains("Female")){
                parsedString = parsedString + "Gender=" + "Female&";
            }
            
            //Age
            if(parametersString.contains("Baby")){
                parsedString = parsedString + "Age=" + "Baby&";
            }
            if(parametersString.contains("Young")){
                parsedString = parsedString + "Age=" + "Young&";
            }
            if(parametersString.contains("Adult")){
                parsedString = parsedString + "Age=" + "Adult&";
            }
            if(parametersString.contains("Senior")){
                parsedString = parsedString + "Age=" + "Senior&";
            }
            
            //Size
            if(parametersString.contains("Small")){
                parsedString = parsedString + "Size=" + "Small&";
            }
            if(parametersString.contains("Medium")){
                parsedString = parsedString + "Size=" + "Medium&";
            }
            if(parametersString.contains("Large")){
                parsedString = parsedString + "Size=" + "Large&";
            }
            if(parametersString.contains("XLarge")){
                parsedString = parsedString + "Size=" + "XLarge&";
            }
        }
        
        //TODO:Preferences Parcer
        
        return parsedString;
    }
    
    public static String barnyardPropertiesParced(HashMap<String, String> parameters){
        String parsedString = "";
        String parametersString = "";
        if(parameters.containsValue("BARNYARD_PARAMETERS")){
            parametersString = parameters.get("BARNYARD_PARAMETERS"); 
            
            //Gender
            if(parametersString.contains("Male")&&!(parametersString.contains("Female"))){
                parsedString = parsedString + "Gender=" + "Male&";
            }
            if(!(parametersString.contains("Male"))&&parametersString.contains("Female")){
                parsedString = parsedString + "Gender=" + "Female&";
            }
            
            //Age
            if(parametersString.contains("Baby")){
                parsedString = parsedString + "Age=" + "Baby&";
            }
            if(parametersString.contains("Young")){
                parsedString = parsedString + "Age=" + "Young&";
            }
            if(parametersString.contains("Adult")){
                parsedString = parsedString + "Age=" + "Adult&";
            }
            if(parametersString.contains("Senior")){
                parsedString = parsedString + "Age=" + "Senior&";
            }
            
            //Size
            if(parametersString.contains("Small")){
                parsedString = parsedString + "Size=" + "Small&";
            }
            if(parametersString.contains("Medium")){
                parsedString = parsedString + "Size=" + "Medium&";
            }
            if(parametersString.contains("Large")){
                parsedString = parsedString + "Size=" + "Large&";
            }
            if(parametersString.contains("XLarge")){
                parsedString = parsedString + "Size=" + "XLarge&";
            }
        }
        
        //TODO:Preferences Parcer
        
        return parsedString;
    }
    
    
    
    //TODO:Preferences Parcer
}
