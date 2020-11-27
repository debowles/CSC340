package CSC340.InteractionPage;
/*
* The purpose of this class is to display and save the animals description
* based on the api
* pets.
* Last updated: 11/25/2020
* Authors: Yngrid Corrales & David Bowles
 */
import CSC340.APIParcer.Animal;
import static CSC340.APIParcer.Animal.formatAnimal;
import static apiCall.PetFinderAPIController.callAPI;
import java.io.IOException;
import java.sql.SQLException;
import org.json.JSONException;


public class InteractionPageModel {

    Animal animal;
   // int i= 0;
    String info;

    private InteractionPageView theView;
    //private LoginController theController;
    public InteractionPageModel(InteractionPageView _theView) {
        this.theView = _theView;
       // this.theController = _theController;

    }

    public void yes() throws SQLException, IOException, JSONException {
       //if(this.theController.yesListener().isPressed())

        //for (int i=0 ;i<10; i++){
        String animalSubString = callAPI(String.valueOf("1"));
        Animal animal = formatAnimal(animalSubString);
        theView.setTypeInfo(animal.getType());
        theView.setStatusInfo(animal.getPublished_at());
        theView.setBreedInfo(animal.getBreeds());
        theView.setSexInfo(animal.getGender());
        theView.setAgeInfo(animal.getAge());
        theView.setNameInfo(animal.getName());

        System.out.println(animalSubString);
        System.out.println(animal.getSize());
        System.out.println(animal.getTotal_pages());

    }
}
