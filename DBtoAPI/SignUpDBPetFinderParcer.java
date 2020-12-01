/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.DBtoAPI;

import static CSC340.DB.DBFactory.getAPIParameters;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author David Bowles
 */
public class SignUpDBPetFinderParcer {
    
    public static String animalPropertiesListToStringDog(ArrayList<String> animalList,String pageNum){
        return animalList.get(0)+ "page="+pageNum;        
    }
    
    public static String animalPropertiesListToStringCat(ArrayList<String> animalList,String pageNum){
        int listSize = animalList.size();  
        int i = 0;
        while(!(animalList.get(i).contains("Cat"))){
            i++;
        }
        return animalList.get(i)+ "page="+pageNum;
    }    
    public static String animalPropertiesListToStringRabbit(ArrayList<String> animalList,String pageNum){
        int listSize = animalList.size();  
        int i = 0;
        while(!(animalList.get(i).contains("Rabbit"))){
            i++;
        }
        return animalList.get(i)+ "page="+pageNum;       
    }
    public static String animalPropertiesListToStringBird(ArrayList<String> animalList,String pageNum){
        int listSize = animalList.size();  
        int i = 0;
        while(!(animalList.get(i).contains("Bird"))){
            i++;
        }
        return animalList.get(i)+ "page="+pageNum;        
    }
    public static String animalPropertiesListToStringScales(ArrayList<String> animalList,String pageNum){
        int listSize = animalList.size();  
        int i = 0;
        while(!(animalList.get(i).contains("Scales, Fins & Other"))){
            i++;
        }
        return animalList.get(i)+ "page="+pageNum;        
    }
    public static String animalPropertiesListToStringSmallF(ArrayList<String> animalList,String pageNum){
        int listSize = animalList.size();  
        int i = 0;
        while(!(animalList.get(i).contains("Small & Furry"))){
            i++;
        }
        return animalList.get(i)+ "page="+pageNum;        
    }
    public static String animalPropertiesListToStringHorse(ArrayList<String> animalList,String pageNum){
        int listSize = animalList.size();  
        int i = 0;
        while(!(animalList.get(i).contains("Horse"))){
            i++;
        }
        return animalList.get(i)+ "page="+pageNum;        
    }
    public static String animalPropertiesListToStringBarnyard(ArrayList<String> animalList,String pageNum){
        int listSize = animalList.size();  
        int i = 0;
        while(!(animalList.get(i).contains("Barnyard"))){
            i++;
        }
        return animalList.get(i)+ "page="+pageNum;        
    }
    public static String animalPropertiesListToString(ArrayList<String> animalList,String pageNum){
        String animalProperties = "";
        int listSize = animalList.size();
        
        Random rand = new Random(); 
        animalProperties = animalList.get(rand.nextInt(listSize)) ; //"page="+pageNum;
        System.out.println();
        System.out.println(animalProperties);
        return animalProperties;
    }
    
    
    public static ArrayList<String> animalPropertiesParced(HashMap<String, String> parameters) {
        ArrayList<String> parcedArray = new ArrayList<String>();
        String parsedString = "";
        System.out.println("animalPropertiesParced parameters.toString(): "+ parameters.toString());
        String parametersString = parameters.toString();
        
        parsedString = parsedString + zipCodeParced(parameters)+radiusParced(parameters);
        System.out.println("animalPropertiesParced parced string: " + parsedString);
        if (parametersString.contains("Dog")) {
            System.out.println("animalPropertiesParced type dog called");
            parcedArray.add(parsedString + "type=" + "Dog&" + dogPropertiesParced(parameters)); //ADD PREFERENCES ON TOP OF THIS ? TO SEPERATE ANIMALTYPE
        }
        if (parametersString.contains("Cat")) {
            System.out.println("animalPropertiesParced type cat called");
            parcedArray.add(parsedString + "type=" + "Cat&" + catPropertiesParced(parameters));
            System.out.println("catPropertiesParced type cat called: " + parsedString + "type=" + "Cat&" + catPropertiesParced(parameters) );
        }
        if (parametersString.contains("Rabbit")) {
            parcedArray.add(parsedString + "type=" + "Rabbit&" + rabbitPropertiesParced(parameters));
        }
        if (parametersString.contains("Bird")) {
            parcedArray.add(parsedString + "type=" + "Bird&" + birdPropertiesParced(parameters));
        }
        if (parametersString.contains("Scales, Fins & Other")) {
            parcedArray.add(parsedString+ "type=" + "Scales, Fins \\u0026 Other&" + scalePropertiesParced(parameters));
        }
        if (parametersString.contains("Small & Furry")) {
            parcedArray.add(parsedString + "type=" + "Small\\u0026Furry&" + smallFPropertiesParced(parameters));
        }
        if (parametersString.contains("Horse")) {
            parcedArray.add(parsedString + "type=" + "Horse&" + horsePropertiesParced(parameters));
        }
        if (parametersString.contains("Barnyard")) {
            parcedArray.add(parsedString + "type=" + "Barnyard&" + barnyardPropertiesParced(parameters));
        }
        
        System.out.println(parcedArray.toString());
        return parcedArray;

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
        System.out.println("dogProperties parced " + parameters.toString());
        String parsedString = "";
        String parametersString = "";
        System.out.println("dogPropertiesParced(HashMap<String, String> parameters: " + parameters.get("DOG_PARAMETERS"));
        if(parameters.containsKey("DOG_PARAMETERS")){
            parametersString =parametersString + parameters.get("DOG_PARAMETERS"); 
            System.out.println("parametersString = parameters.get(\"DOG_PARAMETERS\");  "+ parametersString);
            
            //Gender
            if(parametersString.contains("Male")&&!(parametersString.contains("Female"))){
                parsedString = parsedString + "Gender=" + "Male&";
            }
            if(!(parametersString.contains("Male"))&&parametersString.contains("Female")){
                parsedString = parsedString + "Gender=" + "Female&";
            }
            
            //Age
//            if(parametersString.contains("Baby")){
//                parsedString = parsedString + "Age=" + "Baby&";
//            }
//            if(parametersString.contains("Young")){
//                parsedString = parsedString + "Age=" + "Young&";
//            }
//            if(parametersString.contains("Adult")){
//                parsedString = parsedString + "Age=" + "Adult&";
//            }
//            if(parametersString.contains("Senior")){
//                parsedString = parsedString + "Age=" + "Senior&";
//            }
//            
//            //Size
//            if(parametersString.contains("Small")){
//                parsedString = parsedString + "Size=" + "Small&";
//            }
//            if(parametersString.contains("Medium")){
//                parsedString = parsedString + "Size=" + "Medium&";
//            }
//            if(parametersString.contains("Large")){
//                parsedString = parsedString + "Size=" + "Large&";
//            }
//            if(parametersString.contains("XLarge")){
//                parsedString = parsedString + "Size=" + "XLarge&";
//            }
        }
        
        //TODO:Preferences Parcer
        
        return parsedString;
    }
    
    public static String catPropertiesParced(HashMap<String, String> parameters){
        String parsedString = "";
        String parametersString = "";
        if(parameters.containsKey("CAT_PARAMETERS")){
            parametersString = parametersString + parameters.get("CAT_PARAMETERS"); 
            System.out.println("Cat Parameters String " + parametersString);
            //Gender
            if(parametersString.contains("Male")&&!(parametersString.contains("Female"))){
                parsedString = parsedString + "Gender=" + "Male&";
            }
            if(!(parametersString.contains("Male"))&&parametersString.contains("Female")){
                parsedString = parsedString + "Gender=" + "Female&";
            }
            
            //Age
//            if(parametersString.contains("Baby")){
//                parsedString = parsedString + "Age=" + "Baby&";
//            }
//            if(parametersString.contains("Young")){
//                parsedString = parsedString + "Age=" + "Young&";
//            }
//            if(parametersString.contains("Adult")){
//                parsedString = parsedString + "Age=" + "Adult&";
//            }
//            if(parametersString.contains("Senior")){
//                parsedString = parsedString + "Age=" + "Senior&";
//            }
//            
//            //Size
//            if(parametersString.contains("Small")){
//                parsedString = parsedString + "Size=" + "Small&";
//            }
//            if(parametersString.contains("Medium")){
//                parsedString = parsedString + "Size=" + "Medium&";
//            }
//            if(parametersString.contains("Large")){
//                parsedString = parsedString + "Size=" + "Large&";
//            }
//            if(parametersString.contains("XLarge")){
//                parsedString = parsedString + "Size=" + "XLarge&";
//            }
        }
        
        //TODO:Preferences Parcer
        
        System.out.println("catPropertiesParced: "+ parsedString);
        
        return parsedString;
    }
    
    public static String rabbitPropertiesParced(HashMap<String, String> parameters){
        String parsedString = "";
        String parametersString = "";
        if(parameters.containsKey("RABBIT_PARAMETERS")){
            parametersString = parametersString + parameters.get("RABBIT_PARAMETERS"); 
            
            //Gender
            if(parametersString.contains("Male")&&!(parametersString.contains("Female"))){
                parsedString = parsedString + "Gender=" + "Male&";
            }
            if(!(parametersString.contains("Male"))&&parametersString.contains("Female")){
                parsedString = parsedString + "Gender=" + "Female&";
            }
            
            //Age
//            if(parametersString.contains("Baby")){
//                parsedString = parsedString + "Age=" + "Baby&";
//            }
//            if(parametersString.contains("Young")){
//                parsedString = parsedString + "Age=" + "Young&";
//            }
//            if(parametersString.contains("Adult")){
//                parsedString = parsedString + "Age=" + "Adult&";
//            }
//            if(parametersString.contains("Senior")){
//                parsedString = parsedString + "Age=" + "Senior&";
//            }
//            
//            //Size
//            if(parametersString.contains("Small")){
//                parsedString = parsedString + "Size=" + "Small&";
//            }
//            if(parametersString.contains("Medium")){
//                parsedString = parsedString + "Size=" + "Medium&";
//            }
//            if(parametersString.contains("Large")){
//                parsedString = parsedString + "Size=" + "Large&";
//            }
//            if(parametersString.contains("XLarge")){
//                parsedString = parsedString + "Size=" + "XLarge&";
//            }
        }
        
        //TODO:Preferences Parcer
        
        return parsedString;
    }
    
    public static String birdPropertiesParced(HashMap<String, String> parameters){
        String parsedString = "";
        String parametersString = "";
        if(parameters.containsKey("BIRD_PARAMETERS")){
            parametersString =parametersString +  parameters.get("BIRD_PARAMETERS"); 
            
            //Gender
            if(parametersString.contains("Male")&&!(parametersString.contains("Female"))){
                parsedString = parsedString + "Gender=" + "Male&";
            }
            if(!(parametersString.contains("Male"))&&parametersString.contains("Female")){
                parsedString = parsedString + "Gender=" + "Female&";
            }
            
            //Age
//            if(parametersString.contains("Baby")){
//                parsedString = parsedString + "Age=" + "Baby&";
//            }
//            if(parametersString.contains("Young")){
//                parsedString = parsedString + "Age=" + "Young&";
//            }
//            if(parametersString.contains("Adult")){
//                parsedString = parsedString + "Age=" + "Adult&";
//            }
//            if(parametersString.contains("Senior")){
//                parsedString = parsedString + "Age=" + "Senior&";
//            }
//            
//            //Size
//            if(parametersString.contains("Small")){
//                parsedString = parsedString + "Size=" + "Small&";
//            }
//            if(parametersString.contains("Medium")){
//                parsedString = parsedString + "Size=" + "Medium&";
//            }
//            if(parametersString.contains("Large")){
//                parsedString = parsedString + "Size=" + "Large&";
//            }
//            if(parametersString.contains("XLarge")){
//                parsedString = parsedString + "Size=" + "XLarge&";
//            }
        }
        
        //TODO:Preferences Parcer
        
        return parsedString;
    }
    
    public static String scalePropertiesParced(HashMap<String, String> parameters){
        String parsedString = "";
        String parametersString = "";
        if(parameters.containsKey("SCLAES_PARAMETERS")){
            parametersString = parametersString + parameters.get("SCLAES_PARAMETERS"); 
            
            //Gender
            if(parametersString.contains("Male")&&!(parametersString.contains("Female"))){
                parsedString = parsedString + "Gender=" + "Male&";
            }
            if(!(parametersString.contains("Male"))&&parametersString.contains("Female")){
                parsedString = parsedString + "Gender=" + "Female&";
            }
            
            //Age
//            if(parametersString.contains("Baby")){
//                parsedString = parsedString + "Age=" + "Baby&";
//            }
//            if(parametersString.contains("Young")){
//                parsedString = parsedString + "Age=" + "Young&";
//            }
//            if(parametersString.contains("Adult")){
//                parsedString = parsedString + "Age=" + "Adult&";
//            }
//            if(parametersString.contains("Senior")){
//                parsedString = parsedString + "Age=" + "Senior&";
//            }
//            
//            //Size
//            if(parametersString.contains("Small")){
//                parsedString = parsedString + "Size=" + "Small&";
//            }
//            if(parametersString.contains("Medium")){
//                parsedString = parsedString + "Size=" + "Medium&";
//            }
//            if(parametersString.contains("Large")){
//                parsedString = parsedString + "Size=" + "Large&";
//            }
//            if(parametersString.contains("XLarge")){
//                parsedString = parsedString + "Size=" + "XLarge&";
//            }
        }
        
        //TODO:Preferences Parcer
        
        return parsedString;
    }
    
    public static String smallFPropertiesParced(HashMap<String, String> parameters){
        String parsedString = "";
        String parametersString = "";
        if(parameters.containsKey("SMALLANDFURRY_PARAMETERS")){
            parametersString = parametersString + parameters.get("SMALLANDFURRY_PARAMETERS"); 
            
            //Gender
            if(parametersString.contains("Male")&&!(parametersString.contains("Female"))){
                parsedString = parsedString + "Gender=" + "Male&";
            }
            if(!(parametersString.contains("Male"))&&parametersString.contains("Female")){
                parsedString = parsedString + "Gender=" + "Female&";
            }
            
            //Age
//            if(parametersString.contains("Baby")){
//                parsedString = parsedString + "Age=" + "Baby&";
//            }
//            if(parametersString.contains("Young")){
//                parsedString = parsedString + "Age=" + "Young&";
//            }
//            if(parametersString.contains("Adult")){
//                parsedString = parsedString + "Age=" + "Adult&";
//            }
//            if(parametersString.contains("Senior")){
//                parsedString = parsedString + "Age=" + "Senior&";
//            }
//            
//            //Size
//            if(parametersString.contains("Small")){
//                parsedString = parsedString + "Size=" + "Small&";
//            }
//            if(parametersString.contains("Medium")){
//                parsedString = parsedString + "Size=" + "Medium&";
//            }
//            if(parametersString.contains("Large")){
//                parsedString = parsedString + "Size=" + "Large&";
//            }
//            if(parametersString.contains("XLarge")){
//                parsedString = parsedString + "Size=" + "XLarge&";
//            }
        }
        
        //TODO:Preferences Parcer
        
        return parsedString;
    }
    public static String horsePropertiesParced(HashMap<String, String> parameters){
        String parsedString = "";
        String parametersString = "";
        if(parameters.containsKey("HORSES_PARAMETERS")){
            parametersString = parametersString + parameters.get("HORSES_PARAMETERS"); 
            
            //Gender
            if(parametersString.contains("Male")&&!(parametersString.contains("Female"))){
                parsedString = parsedString + "Gender=" + "Male&";
            }
            if(!(parametersString.contains("Male"))&&parametersString.contains("Female")){
                parsedString = parsedString + "Gender=" + "Female&";
            }
            
            //Age
//            if(parametersString.contains("Baby")){
//                parsedString = parsedString + "Age=" + "Baby&";
//            }
//            if(parametersString.contains("Young")){
//                parsedString = parsedString + "Age=" + "Young&";
//            }
//            if(parametersString.contains("Adult")){
//                parsedString = parsedString + "Age=" + "Adult&";
//            }
//            if(parametersString.contains("Senior")){
//                parsedString = parsedString + "Age=" + "Senior&";
//            }
//            
//            //Size
//            if(parametersString.contains("Small")){
//                parsedString = parsedString + "Size=" + "Small&";
//            }
//            if(parametersString.contains("Medium")){
//                parsedString = parsedString + "Size=" + "Medium&";
//            }
//            if(parametersString.contains("Large")){
//                parsedString = parsedString + "Size=" + "Large&";
//            }
//            if(parametersString.contains("XLarge")){
//                parsedString = parsedString + "Size=" + "XLarge&";
//            }
        }
        
        //TODO:Preferences Parcer
        
        return parsedString;
    }
    
    public static String barnyardPropertiesParced(HashMap<String, String> parameters){
        String parsedString = "";
        String parametersString = "";
        if(parameters.containsKey("BARNYARD_PARAMETERS")){
            parametersString = parametersString +parameters.get("BARNYARD_PARAMETERS"); 
            
            //Gender
            if(parametersString.contains("Male")&&!(parametersString.contains("Female"))){
                parsedString = parsedString + "Gender=" + "Male&";
            }
            if(!(parametersString.contains("Male"))&&parametersString.contains("Female")){
                parsedString = parsedString + "Gender=" + "Female&";
            }
            
            //Age
//            if(parametersString.contains("Baby")){
//                parsedString = parsedString + "Age=" + "Baby&";
//            }
//            if(parametersString.contains("Young")){
//                parsedString = parsedString + "Age=" + "Young&";
//            }
//            if(parametersString.contains("Adult")){
//                parsedString = parsedString + "Age=" + "Adult&";
//            }
//            if(parametersString.contains("Senior")){
//                parsedString = parsedString + "Age=" + "Senior&";
//            }
//            
//            //Size
//            if(parametersString.contains("Small")){
//                parsedString = parsedString + "Size=" + "Small&";
//            }
//            if(parametersString.contains("Medium")){
//                parsedString = parsedString + "Size=" + "Medium&";
//            }
//            if(parametersString.contains("Large")){
//                parsedString = parsedString + "Size=" + "Large&";
//            }
//            if(parametersString.contains("XLarge")){
//                parsedString = parsedString + "Size=" + "XLarge&";
//            }
        }
        
        //TODO:Preferences Parcer
        
        return parsedString;
    }
    
    
    
    //TODO:Preferences Parcer
}
