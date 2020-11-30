package CSC340.InteractionPage;
/*
* The purpose of this class is to display and save the animals description
* based on the api
* pets.
* Last updated: 11/25/2020
* Authors: Yngrid Corrales & David Bowles
 */
import CSC340.APIParcer.Animal;
import static CSC340.APIParcer.Animal.callAnimal;
import static CSC340.APIParcer.Animal.formatAnimal;
import CSC340.APIParcer.AnimalController;
import static CSC340.APIParcer.AnimalController.callAnimalPage;
import static CSC340.APIParcer.AnimalController.*;
import CSC340.DB.DBController;
import static CSC340.DB.DBFactory.getAnimalTypeList;
import static CSC340.apiCall.PetFinderAPIController.callAPI;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;


public class InteractionPageModel {

    Animal animal;
    String info;
    int dogPageNum = 1;
    int catPageNum = 1;
    int rabbitPageNum = 1;
    int birdPageNum = 1;
    int scalesPageNum = 1;
    int smallFPageNum = 1;
    int horsePageNum = 1;
    int barnyardPageNum = 1;

    ArrayList<String> animalTypes;

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public ArrayList<String> getAnimalTypes() {
        return animalTypes;
    }

    public void setAnimalTypes(ArrayList<String> animalTypes) {
        this.animalTypes = animalTypes;
    }
    private InteractionPageController theController;
    private InteractionPageView theView;
    //private LoginController theController;
    public InteractionPageModel(InteractionPageView _theView) {
        this.theView = _theView;
       // this.theController = _theController;

    }
    public void addToDB(String id) throws SQLException{
       HashMap<String,String> animalMap =  Animal.animalToHashMap(animal, id);
       DBController.addToFavoritesDB(animalMap);
    }
    public void nextAnimal(String id, String token) throws SQLException, IOException, JSONException {
       //if(this.theController.yesListener().isPressed())
       
       Animal animal = null;
       Random rand = new Random();
       if(animalTypes==null){
       animalTypes = getAnimalTypeList(id);
       }
       int randomInt = rand.nextInt(animalTypes.size());
       String animalType = animalTypes.get(randomInt);
       
       
        //while(pageNum <= totalPageNum){
        
        
        if (animalType.contains("Dog")) {
            animal = callDogPage(id,Integer.toString(dogPageNum),token);
            if(dogPageNum < Integer.parseInt(animal.getTotal_pages())){
            dogPageNum++;
            }
            else{
                animalTypes.remove("Dog");
            }
        }
        if (animalType.contains("Cat")) {
           animal =callCatPage(id,Integer.toString(catPageNum),token);
           if(catPageNum < Integer.parseInt(animal.getTotal_pages())){
           catPageNum++;
            }
            else{
                animalTypes.remove("Cat");
            }
        }
        if (animalType.contains("Rabbit")) {
            animal =callRabbitPage(id,Integer.toString(rabbitPageNum),token);
            if(rabbitPageNum < Integer.parseInt(animal.getTotal_pages())){
            rabbitPageNum++;
            }
            else{
                animalTypes.remove("Rabbit");
            }
        }
        if (animalType.contains("Bird")) {
            animal =callBirdPage(id,Integer.toString(birdPageNum),token);
            if(birdPageNum < Integer.parseInt(animal.getTotal_pages())){
            birdPageNum++;
            }
            else{
                animalTypes.remove("Bird");
            }
        }
        if (animalType.contains("Scales, Fins & Other")) {
           animal =callScalePage(id,Integer.toString(scalesPageNum),token);
            if(scalesPageNum < Integer.parseInt(animal.getTotal_pages())){
            scalesPageNum++;
            }
            else{
                animalTypes.remove("Scales, Fins & Other");
            }
        }
        if (animalType.contains("Small & Furry")) {
            animal =callSmallFPage(id,Integer.toString(smallFPageNum),token);
            if(smallFPageNum < Integer.parseInt(animal.getTotal_pages())){
            smallFPageNum++;
            }
            else{
                animalTypes.remove("Small & Furry");
            }
        }
        if (animalType.contains("Horse")) {
            animal =callHorsePage(id,Integer.toString(horsePageNum),token);
            if(horsePageNum < Integer.parseInt(animal.getTotal_pages())){
            horsePageNum++;
            }
            else{
                animalTypes.remove("Horse");
            }
        }
        if (animalType.contains("Barnyard")) {
            animal = callBarnyardPage(id,Integer.toString(barnyardPageNum),token);
            if(barnyardPageNum < Integer.parseInt(animal.getTotal_pages())){
            barnyardPageNum++;
            }
            else{
                animalTypes.remove("Barnyard");
            }
        }
        
        
        this.animal = animal;
        System.out.println("Animal Called in yes listener: " + animal.getName() );
        theView.setTypeInfo(animal.getType());
        theView.setStatusInfo(animal.getPublished_at());
        theView.setBreedInfo(animal.getBreeds());
        theView.setSexInfo(animal.getGender());
        theView.setAgeInfo(animal.getAge());
        theView.setNameInfo(animal.getName());
        theView.setPhoto(animal.getPhoto());
        System.out.println("The Model Photo: "+animal.getPhoto());
        //System.out.println(animalSubString);
        //System.out.println(animal.getSize());
        //System.out.println(animal.getTotal_pages());
        //System.out.println(pageNum);        
        }

    
    
    
    
    
    }

