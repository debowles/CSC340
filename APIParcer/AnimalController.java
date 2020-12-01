/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.APIParcer;

import static CSC340.APIParcer.Animal.formatAnimal;
import static CSC340.apiCall.PetFinderAPIController.callAPI;
import static CSC340.apiCall.PetFinderAPIController.callAPIPage;
import static CSC340.apiCall.PetFinderAPIController.callBarnyardAPIPage;
import static CSC340.apiCall.PetFinderAPIController.callBirdAPIPage;
import static CSC340.apiCall.PetFinderAPIController.callCatAPIPage;
import static CSC340.apiCall.PetFinderAPIController.callDogAPIPage;
import static CSC340.apiCall.PetFinderAPIController.callHorseAPIPage;
import static CSC340.apiCall.PetFinderAPIController.callRabbitAPIPage;
import static CSC340.apiCall.PetFinderAPIController.callScaleAPIPage;
import static CSC340.apiCall.PetFinderAPIController.callSmallFAPIPage;
import static CSC340.apiCall.PetFinderAPIController.getApiToken;
import java.io.IOException;
import java.sql.SQLException;
import org.json.JSONException;

/**
 *
 * @author biscu
 */
public class AnimalController {
    //Calls a random animal with the parameters of the id
    public static Animal callAnimal(String id) throws SQLException, IOException, JSONException {
        String animalSubString = callAPI(id);
        System.out.println("Call Animal");
        Animal animal = formatAnimal(animalSubString);
        return animal;
    }
    //Calls a random animal with the parameters of the id and specific page
    public static Animal callAnimalPage(String id, String page,String token) throws SQLException, IOException, JSONException{
        String animalSubString = callAPIPage(id,page,token);
        System.out.println("Call Animal Page");
        Animal animal = formatAnimal(animalSubString);
        return animal;
    }
    //calls Dog 
    public static Animal callDogPage(String id, String page,String token) throws SQLException, IOException, JSONException{
        String animalSubString = callDogAPIPage(id,page,token);
        System.out.println("Call Animal Page");
        Animal animal = formatAnimal(animalSubString);
        return animal;
    }
    //calls Cat
    public static Animal callCatPage(String id, String page,String token) throws SQLException, IOException, JSONException{
        String animalSubString = callCatAPIPage(id,page,token);
        System.out.println("Call Animal Page");
        Animal animal = formatAnimal(animalSubString);
        return animal;
    }
    
    public static Animal callRabbitPage(String id, String page,String token) throws SQLException, IOException, JSONException{
        String animalSubString = callRabbitAPIPage(id,page,token);
        System.out.println("Call Animal Page");
        Animal animal = formatAnimal(animalSubString);
        return animal;
    }
    public static Animal callBirdPage(String id, String page,String token) throws SQLException, IOException, JSONException{
        String animalSubString = callBirdAPIPage(id,page,token);
        System.out.println("Call Animal Page");
        Animal animal = formatAnimal(animalSubString);
        return animal;
    }
    
    public static Animal callScalePage(String id, String page,String token) throws SQLException, IOException, JSONException{
        String animalSubString = callScaleAPIPage(id,page,token);
        System.out.println("Call Animal Page");
        Animal animal = formatAnimal(animalSubString);
        return animal;
    }
    public static Animal callSmallFPage(String id, String page,String token) throws SQLException, IOException, JSONException{
        String animalSubString = callSmallFAPIPage(id,page,token);
        System.out.println("Call Animal Page");
        Animal animal = formatAnimal(animalSubString);
        return animal;
    }
    public static Animal callHorsePage(String id, String page,String token) throws SQLException, IOException, JSONException{
        String animalSubString = callHorseAPIPage(id,page,token);
        System.out.println("Call Animal Page");
        Animal animal = formatAnimal(animalSubString);
        return animal;
    }
    public static Animal callBarnyardPage(String id, String page,String token) throws SQLException, IOException, JSONException{
        String animalSubString = callBarnyardAPIPage(id,page,token);
        System.out.println("Call Animal Page");
        Animal animal = formatAnimal(animalSubString);
        return animal;
    }
    
    
    public static String getAnimalToken(){
        return getApiToken();
    }
    
}
