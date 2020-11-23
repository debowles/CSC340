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
        ArrayList<String> animalSubStringList = callAPI("0");
        animalSubStringList.toString();
          
        //ArrayList<Animal> animalList = getAnimalObjectFromHashMap(animalSubString);
        
        String animalSubString = animalSubStringList.get(0);
        System.out.println(animalSubString);
        
        Animal animal = formatAnimal(animalSubString);
        System.out.println(animal.getName());      
        System.out.println(animal.getPrimary_photo_cropped());
        
//        int i = 0;
//            int j = 1;
//            int k = 0;
//            String s = "";
//            if (animal.contains("total_pages")) {
//                k = animal.indexOf("total_pages") + 13;                
//
//                while (animal.charAt(k) != 44) {
//                    s = s + animal.charAt(k);
//                    k++;
//                }
//                System.out.println("total_pages of animal: " + s);
//                //animal.setPublished_at(s);
//                int pageNum=Integer.parseInt(s);
//            
//            for(int page = 1; page <= pageNum; page++){
//                animal = apiCall(token, url+"&page="+Integer.toString(page));
//                list.add(animal);
//            }
            }
        
    }

