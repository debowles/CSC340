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
 * @author David Bowles
 */
public class Animal extends PetFinderAPIJson {

    String name;
    String gender;
    String size;
    String age;
    String distance;
    String type;
    String colors;
    String breeds;
    String description;
    String primary_photo_cropped;
    String attributes;
    String contact;
    String published_at;

    public Animal(String name, String gender, String size, String age, String distance, String type, String colors, String breeds, String description, String primary_photo_cropped, String attributes, String contact, String published_at) {
        this.name = name;
        this.gender = gender;
        this.size = size;
        this.age = age;
        this.distance = distance;
        this.type = type;
        this.colors = colors;
        this.breeds = breeds;
        this.description = description;
        this.primary_photo_cropped = primary_photo_cropped;
        this.attributes = attributes;
        this.contact = contact;
        this.published_at = published_at;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getSize() {
        return size;
    }

    public String getAge() {
        return age;
    }

    public String getDistance() {
        return distance;
    }

    public String getType() {
        return type;
    }

    public String getColors() {
        return colors;
    }

    public String getBreeds() {
        return breeds;
    }

    public String getDescription() {
        return description;
    }

    public String getPrimary_photo_cropped() {
        return primary_photo_cropped;
    }

    public String getAttributes() {
        return attributes;
    }

    public String getContact() {
        return contact;
    }

    public String getPublished_at() {
        return published_at;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public void setBreeds(String breeds) {
        this.breeds = breeds;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrimary_photo_cropped(String primary_photo_cropped) {
        this.primary_photo_cropped = primary_photo_cropped;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setPublished_at(String published_at) {
        this.published_at = published_at;
    }

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
                System.out.println("\nCompleted a Animal String: " + animalSubString + "\n");
                animalList.add(formatAnimal(animalSubString));
                k = j + 1;
                i = i - 2;
            }

            j++;

        }

        System.out.println(j);

        return animalList;
    }

    public static Animal formatAnimal(String animalSubString) {
        int i = 0;
        int j = 1;
        int k = 0;
        Animal animal = new Animal("","","","","","","","","","","","","");

        if (animalSubString.contains("gender")) {
            k = animalSubString.indexOf("gender") + 8;
            String s = "";

            while (animalSubString.charAt(k) != 44) {
                s = s + animalSubString.charAt(k);
                k++;
            }
            //System.out.println("gender of animal: " + s);
            animal.setGender(s);
        }

        if (animalSubString.contains("name")) {
            k = animalSubString.indexOf("name") + 6;
            String s = "";

            while (animalSubString.charAt(k) != 44) {
                s = s + animalSubString.charAt(k);
                k++;
            }
            //System.out.println("name of animal: " + s);
            animal.setName(s);
        }
        if (animalSubString.contains("size")) {
            k = animalSubString.indexOf("size") + 6;
            String s = "";

            while (animalSubString.charAt(k) != 44) {
                s = s + animalSubString.charAt(k);
                k++;
            }
            //System.out.println("size of animal: " + s);
            animal.setSize(s);
        }
        if (animalSubString.contains("age")) {
            k = animalSubString.indexOf("age") + 5;
            String s = "";

            while (animalSubString.charAt(k) != 44) {
                s = s + animalSubString.charAt(k);
                k++;
            }
            //System.out.println("age of animal: " + s);
            animal.setAge(s);
        }
        if (animalSubString.contains("distance")) {

            k = animalSubString.indexOf("distance") + 10;
            String s = "";

            while (animalSubString.charAt(k) != 44) {
                s = s + animalSubString.charAt(k);
                k++;
            }
            //System.out.println("distance of animal: " + s);
            animal.setDistance(s);
        }
        if (animalSubString.contains("type")) {
            k = animalSubString.indexOf("type") + 6;
            String s = "";

            while (animalSubString.charAt(k) != 44) {
                s = s + animalSubString.charAt(k);
                k++;
            }
            //System.out.println("type of animal: " + s);
            animal.setType(s);
        }

        if (animalSubString.contains("colors")) {
            k = animalSubString.indexOf("colors") + 9;
            String s = "";

            while (animalSubString.charAt(k) != 125) {
                s = s + animalSubString.charAt(k);
                k++;
            }
            //System.out.println("colors of animal: " + s);
            animal.setColors(s);
        }
        if (animalSubString.contains("breeds")) {
            k = animalSubString.indexOf("breeds") + 9;
            String s = "";

            while (animalSubString.charAt(k) != 125) {
                s = s + animalSubString.charAt(k);
                k++;
            }
            //System.out.println("breeds of the animal: " + s);
            animal.setBreeds(s);
        }

        if (animalSubString.contains("description")) {
            k = animalSubString.indexOf("description") + 14;
            String s = "";

            while (animalSubString.charAt(k) != 34) {
                s = s + animalSubString.charAt(k);
                k++;
            }
            //System.out.println("description of the animal: " + s);

            animal.setDescription(s);
        }

        if (animalSubString.contains("primary_photo_cropped")) {
            k = animalSubString.indexOf("primary_photo_cropped") + 24;
            String s = "";

            while (animalSubString.charAt(k) != 125) {
                s = s + animalSubString.charAt(k);
                k++;
            }
            //System.out.println("primary_photo_cropped of the animal: " + s);

            animal.setPrimary_photo_cropped(s);
        }

        if (animalSubString.contains("attributes")) {
            k = animalSubString.indexOf("attributes") + 13;
            String s = "";

            while (animalSubString.charAt(k) != 125) {
                s = s + animalSubString.charAt(k);
                k++;
            }
            //System.out.println("attributes of the animal: " + s);

            animal.setAttributes(s);
        }

        if (animalSubString.contains("contact")) {
            k = animalSubString.indexOf("contact") + 10;
            String s = "";

            while (animalSubString.charAt(k) != 125) {
                s = s + animalSubString.charAt(k);
                k++;
            }
            //System.out.println("contact of the animal: " + s);

            animal.setContact(s);
        }
        if (animalSubString.contains("published_at")) {
            k = animalSubString.indexOf("published_at") + 14;
            String s = "";

            while (animalSubString.charAt(k) != 44) {
                s = s + animalSubString.charAt(k);
                k++;
            }
            //System.out.println("publised_at of animal: " + s);
            animal.setPublished_at(s);
        }
        return animal;

    }

}