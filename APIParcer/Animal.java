/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.APIParcer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author biscu
 */
public class Animal extends PetFinderAPIJson {

    int id;
    String organization_id;
    String url;
    String tpe;
    String species;
    String color;

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public Animal(String gender) {
        this.gender = gender;
    }
    String age;
    String gender;
    String size;
    String coat;
    String name;
    String description;
    HashMap<String, String> photos;
    String videos;
    String status;
    HashMap<String, Boolean> attributes;
    HashMap<String, Boolean> environment;
    String[] tags;
    HashMap<String, String> contact;
    HashMap<String, String> address;
    String publised_at;
    double distance;

    public static ArrayList<Animal> getAnimalObjectFromHashMap(String animalString) throws JSONException {
        ArrayList<Animal> animalList = new ArrayList();
        Animal animal = null;
        ArrayList<String> animalStringList = new ArrayList();
        int i = 0;
        int j = 1;
        int k = 0;
        
        while (j < animalString.length()) {
            if (animalString.charAt(j) == 123) {
                i--;
            }
            if (animalString.charAt(j) == 125) {
                i++;
            }

            if (i == 0) {
                String animalSubString = animalString.substring(k, j);
                System.out.println("\nCompleted a Animal String: "+ animalSubString+"\n");
                animalList.add(formatAnimal(animalSubString));
                k = j+1;
                i = i-2;
            }

            j++;

        }

        System.out.println(j);

        return animalList;
    }
    
    public static Animal formatAnimal(String animalSubString){       
        int i = 0;
        int j = 1;
        int k = 0;
        if (animalSubString.contains("gender")) {
                    k = animalSubString.indexOf("gender") + 8;
                    String s = "";

                    while (animalSubString.charAt(k) != 44) {
                        s = s + animalSubString.charAt(k);
                        k++;
                    }
                    System.out.println("gender of animal: " + s);
                    //animal.setGender(s);
                }

                if (animalSubString.contains("distance")) {

                    k = animalSubString.indexOf("distance") + 10;
                    String s = "";

                    while (animalSubString.charAt(k) != 44) {
                        s = s + animalSubString.charAt(k);
                        k++;
                    }
                    System.out.println("distance of animal: " + s);
                    //animal.setGender(s);
                }
                if (animalSubString.contains("status_changed_at")) {

                    k = animalSubString.indexOf("status_changed_at") + 17;
                    String s = "";

                    while (animalSubString.charAt(k) != 44) {
                        s = s + animalSubString.charAt(k);
                        k++;
                    }
                    System.out.println("status_changed_at of animal: " + s);
                    //animal.setGender(s);

                }
                if (animalSubString.contains("description")) {
                    k = animalSubString.indexOf("description") + 17;
                    String s = "";

                    while (animalSubString.charAt(k) != 34 && animalSubString.charAt(k+1) != 44 && animalSubString.charAt(k+2) != 34) {
                        s = s + animalSubString.charAt(k);
                        k++;
                    }
                    System.out.println("description of animal: " + s);
                    //animal.setGender(s);
                }
                if (animalSubString.contains("organization_animal_id")) {
                    k = animalSubString.indexOf("organization_animal_id")+22;
                    String s = "";
                    
                    while(animalSubString.charAt(k)!= 44){
                        s = s + animalSubString.charAt(k);
                        k++;
                    }
                    System.out.println("organization_animal_id of animal: " + s);
                    //animal.setGender(s);
                }
                if (animalSubString.contains("videos")) {
                    k = animalSubString.indexOf("videos")+6;
                    String s = "";
                    
                    while(animalSubString.charAt(k)!= 44){
                        s = s + animalSubString.charAt(k);
                        k++;
                    }
                    System.out.println("videos of animal: " + s);
                    //animal.setGender(s);
                }
                if (animalSubString.contains("type")) {
                    k = animalSubString.indexOf("type")+4;
                    String s = "";
                    
                    while(animalSubString.charAt(k)!= 44){
                        s = s + animalSubString.charAt(k);
                        k++;
                    }
                    System.out.println("type of animal: " + s);
                    //animal.setGender(s);
                }
                if (animalSubString.contains("photos")) {
                    k = animalSubString.indexOf("photos")+6;
                    String s = "";
                    
                    while(animalSubString.charAt(k+1)!= 44&&animalSubString.charAt(k)!= 93){
                        s = s + animalSubString.charAt(k);
                        k++;
                    }
                    System.out.println("photo of animal: " + s);
                    //animal.setGender(s);
                }
                if (animalSubString.contains("colors")) {
                    k = animalSubString.indexOf("colors")+6;
                    String s = "";
                    
                    while(animalSubString.charAt(k)!= 44&& animalSubString.charAt(k)!= 125){
                        s = s + animalSubString.charAt(k);
                        k++;
                    }
                    System.out.println("colors of animal: " + s);
                    //animal.setGender(s);
                }
                if (animalSubString.contains("breeds")) {
                    k = animalSubString.indexOf("breeds")+6;
                    String s = "";
                    
                    while(animalSubString.charAt(k+1)!= 44 && animalSubString.charAt(k) !=125){
                        s = s + animalSubString.charAt(k);
                        k++;
                    }
                    System.out.println("breeds of the animal: " + s);
                    //animal.setGender(s);
                }
                if (animalSubString.contains("contact")) {
                    
                }
                if (animalSubString.contains("address")) {
                    
                }
                if (animalSubString.contains("id")) {

                }
                if (animalSubString.contains("published_at")) {

                }
                if (animalSubString.contains("primary_photo_cropped")) {

                }
                if (animalSubString.contains("url")) {

                }
                if (animalSubString.contains("tags")) {

                }
                if (animalSubString.contains("url")) {

                }
                if (animalSubString.contains("url")) {

                }
                if (animalSubString.contains("url")) {

                }
        
        return null;
        
        
        
        
        
        
        
        
    } 
    

}
