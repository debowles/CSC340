/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.APIParcer;

import static CSC340.APIParcer.Animal.formatAnimal;
import static CSC340.APIParcer.Animal.getAnimalObjectFromHashMap;
import static CSC340.apiCall.PetFinderAPIConnector.apiCall;
import static CSC340.apiCall.PetFinderAPIController.callAPI;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import org.json.JSONException;

/**
 *
 * @author biscu
 */
public class APIParcerTester {
    public static void main(String[] args) throws SQLException, IOException, JSONException{
        String animalSubString = callAPI("0");
        Animal animal =  formatAnimal(animalSubString);
          
        
        
        
        System.out.println(animalSubString);
        
      
        System.out.println(animal.getName()); 
        System.out.println(animal.getTotal_pages());
        //System.out.println(animal.getPrimary_photo_cropped());
        

            }
        
    }

