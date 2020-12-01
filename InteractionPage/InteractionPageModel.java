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
import java.awt.Image;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import org.json.JSONException;

public class InteractionPageModel {

    Animal animal;
    Image image = null;
    String info;
    int dogPageNum = 1;
    int catPageNum = 1;
    int rabbitPageNum = 1;
    int birdPageNum = 1;
    int scalesPageNum = 1;
    int smallFPageNum = 1;
    int horsePageNum = 1;
    int barnyardPageNum = 1;

    ImageModel imageModel;
    
    ArrayList<String> animalTypes;

    
    public InteractionPageModel(InteractionPageView _theView,ImageModel _imageModel) {
        this.theView = _theView;
        this.imageModel = _imageModel;

    }
    
    
    
    
    
    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal _animal) {             
            this.animal = _animal;
            theView.setTypeInfo(_animal.getType());
            theView.setStatusInfo(_animal.getPublished_at());
            theView.setBreedInfo(_animal.getBreeds());
            theView.setSexInfo(_animal.getGender());
            theView.setSizeInfo(_animal.getSize());
            theView.setAgeInfo(_animal.getAge());
            theView.setNameInfo(_animal.getName());
            theView.setPetPic(_animal.getPhoto());
            //theView.reloadPetPic();
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
    

    public void addToDB(String id) throws SQLException {
        HashMap<String, String> animalMap = Animal.animalToHashMap(animal, id);
        DBController.addToFavoritesDB(animalMap);
    }

    public void nextAnimal(String id, String token) throws SQLException, IOException, JSONException {
        //if(this.theController.yesListener().isPressed())

        String animalType = "";
        Animal animal = null;
        Random rand = new Random();
        if (animalTypes == null) {
            animalTypes = getAnimalTypeList(id);
        }
        try {
            int randomInt = rand.nextInt(animalTypes.size());
            animalType = animalTypes.get(randomInt);

            //String animalType = animalTypes.get(randomInt);
            //while(pageNum <= totalPageNum){
            if (animalType.contains("Dog")) {
                animal = callDogPage(id, Integer.toString(dogPageNum), token);
                if(Integer.parseInt(animal.getTotal_count())== 0){
                    animalTypes.remove("Rabbit");
                    nextAnimal(id, token);
                }
                else{
                if (dogPageNum < Integer.parseInt(animal.getTotal_pages())) {
                    dogPageNum++;
                } else {
                    animalTypes.remove("Dog");
                }
                }
            }
            if (animalType.contains("Cat")) {
                animal = callCatPage(id, Integer.toString(catPageNum), token);
                if(Integer.parseInt(animal.getTotal_count())== 0){
                    animalTypes.remove("Rabbit");
                    nextAnimal(id, token);
                }
                else{
                if (catPageNum < Integer.parseInt(animal.getTotal_pages())) {
                    catPageNum++;
                } else {
                    animalTypes.remove("Cat");
                }
                }
            }
            if (animalType.contains("Rabbit")) {
                animal = callRabbitPage(id, Integer.toString(rabbitPageNum), token);
                if(Integer.parseInt(animal.getTotal_count())== 0){
                    animalTypes.remove("Rabbit");
                    nextAnimal(id, token);
                }
                else{
                if (rabbitPageNum < Integer.parseInt(animal.getTotal_pages())) {
                    rabbitPageNum++;
                    System.out.println("Rabbit animal Name: " + animal.getName());
                } else {
                    animalTypes.remove("Rabbit");
                }
                }
            }
            if (animalType.contains("Bird")) {
                animal = callBirdPage(id, Integer.toString(birdPageNum), token);
                if(Integer.parseInt(animal.getTotal_count())== 0){
                    animalTypes.remove("Rabbit");
                    nextAnimal(id, token);
                }
                else{
                if (birdPageNum < Integer.parseInt(animal.getTotal_pages())) {
                    birdPageNum++;
                    System.out.println("Bird animal Name: " + animal.getName());
                } else {
                    animalTypes.remove("Bird");
                }
                }
            }
            if (animalType.contains("Scales, Fins & Other")) {
                if(Integer.parseInt(animal.getTotal_count())== 0){
                    animalTypes.remove("Rabbit");
                    nextAnimal(id, token);
                }
                else{
                animal = callScalePage(id, Integer.toString(scalesPageNum), token);
                if (scalesPageNum < Integer.parseInt(animal.getTotal_pages())) {
                    scalesPageNum++;
                } else {
                    animalTypes.remove("Scales, Fins & Other");
                }
                }
            }
            if (animalType.contains("Small & Furry")) {
                if(Integer.parseInt(animal.getTotal_count())== 0){
                    animalTypes.remove("Rabbit");
                    nextAnimal(id, token);
                }
                else{
                animal = callSmallFPage(id, Integer.toString(smallFPageNum), token);
                if (smallFPageNum < Integer.parseInt(animal.getTotal_pages())) {
                    smallFPageNum++;
                } else {
                    animalTypes.remove("Small & Furry");
                }
                }
            }
            if (animalType.contains("Horse")) {
                animal = callHorsePage(id, Integer.toString(horsePageNum), token);
                if(Integer.parseInt(animal.getTotal_count())== 0){
                    animalTypes.remove("Rabbit");
                    nextAnimal(id, token);
                }
                else{
                if (horsePageNum < Integer.parseInt(animal.getTotal_pages())) {
                    horsePageNum++;
                } else {
                    animalTypes.remove("Horse");
                }
                }
            }
            if (animalType.contains("Barnyard")) {
                animal = callBarnyardPage(id, Integer.toString(barnyardPageNum), token);
                if(Integer.parseInt(animal.getTotal_count())== 0){
                    animalTypes.remove("Rabbit");
                    nextAnimal(id, token);
                }
                else{
                if (barnyardPageNum < Integer.parseInt(animal.getTotal_pages())) {
                    barnyardPageNum++;
                } else {
                    animalTypes.remove("Barnyard");
                }
                }
            }
            Animal previousAnimal = this.animal;
            setAnimal(animal);
            System.out.println("AnimalTypes size: " + animalTypes.size());
              if (animal.getName().equals("")) {
                    if (animalTypes.size() == 0) {
                        System.out.println("If statement No Animals of this type in radius found");
                        theView.setNameInfo("No Animals of this type in radius found");
                    } else {
                        System.out.println("Calling a new animal");
                        nextAnimal(id, token);
                    }
                }  
             if ((animal.getName().equals(previousAnimal.getName()) && (animal.getType().equals(previousAnimal.getType())))) {
                System.out.println("Animal is the same");
                nextAnimal(id, token);
            }           
        }
        catch (Exception IllegalArgumentException) {
            if (animalTypes.size() != 0){
                nextAnimal(id, token);
            }
            else{
            System.out.println("No Animals in radius found");
        theView.setNameInfo("No Animals of this type in radius found");
        theView.setAgeInfo("");
        theView.setTypeInfo("");
        theView.setStatusInfo("");
        theView.setBreedInfo("");
        theView.setSexInfo("");
        theView.setSizeInfo("");
        theView.setPhoto("");
        
    }
        }
    }
    
//    public void picture(String _photo) {
//        try {
//        
//          _photo = _photo.replace("\\","");
//            URL url = new URL(_photo);
//            image = ImageIO.read(url);
//            theView.setPetPic(_photo);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}


