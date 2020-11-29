package CSC340.InteractionPage;

/*
* The purpose of this class to have the view and the model connect to the controller
* which responds to buttons clicked from the user from the view.
* Last updated: 11/23/2020
* Author: Yngrid Corrales
 */
import CSC340.APIParcer.Animal;
import CSC340.APIParcer.AnimalController;
import CSC340.ChangePreference.PetChangePreferencesController;
import CSC340.ChangePreference.PetChangePreferencesModel;
import CSC340.ChangePreference.PetChangePreferencesView;
import static CSC340.DB.DBController.getFavoritesAnimalList;
import CSC340.PetHistory.PetHistoryController;
import CSC340.PetHistory.PetHistoryModel;
import CSC340.PetHistory.PetHistoryView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;

public class InteractionPageController {
    private Animal animal;
    private InteractionPageView theView;
    private String id;
    private InteractionPageModel theModel;
    private String token;
    /* The Controller coordinates interactions between the view and model */
    public InteractionPageController(InteractionPageView _theView,InteractionPageModel _theModel, String _id ,Animal _animal) throws MalformedURLException {
        this.theView = _theView;
        this.theModel = _theModel;
        this.id = _id;
        this.animal = _animal;
        
        theModel.setAnimal(animal);
        
        
        theView.setTypeInfo(_animal.getType());
        theView.setStatusInfo(_animal.getPublished_at());
        theView.setBreedInfo(_animal.getBreeds());
        theView.setSexInfo(_animal.getGender());
        theView.setAgeInfo(_animal.getAge());
        theView.setNameInfo(_animal.getName());
        //theView.setUrl(_animal.getPhoto());
        /* This tells the view that when these buttons are clicked on, to execute the
         * actionPerformed methods created from the classes created below
         */
        this.theView.addNoListener(new noListener());
        this.theView.addYesListener(new yesListener());
        this.theView.addUpdateListener(new updateListener());
        this.theView.addFavoriteListener(new favoriteListener());
        
        setToken(AnimalController.getAnimalToken());
        tokenTimer();
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    

    public String getId() {
        return id;
    }

    
    public void tokenTimer(){
        Timer time = new Timer();
        time.schedule(new TimerTask() {
            
            public void run(){
            setToken(AnimalController.getAnimalToken());
                System.out.println("Token Reset");
                tokenTimer();
                    } 
            
        }, 3600000);
    }
    
    
    
    class noListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theModel.nextAnimal(getId(),token);
            } catch (SQLException ex) {
                Logger.getLogger(InteractionPageController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(InteractionPageController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(InteractionPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    
 class yesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theModel.addToDB(id);
                theModel.nextAnimal(getId(),token);
            } catch (SQLException ex) {
                Logger.getLogger(InteractionPageController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(InteractionPageController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(InteractionPageController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    /* When the update preference button is clicked, go to the PetChangePreferences view */
    class updateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            theView.dispose();

            System.out.println("Update Preferences Clicked");

            PetChangePreferencesView theView = new PetChangePreferencesView();
            PetChangePreferencesModel theModel = new PetChangePreferencesModel(theView);
            PetChangePreferencesController theController = new PetChangePreferencesController(theView, theModel, getId());
            theView.setVisible(true);

        }

    }

    /* When the see favorites button is clicked, go to the PetHistory view */
    class favoriteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           
            try {
                theView.dispose();
           PetHistoryView  theView = new PetHistoryView();
           PetHistoryModel theModel = new PetHistoryModel(theView);
                PetHistoryController theController= new PetHistoryController(theView,theModel,getId(),getFavoritesAnimalList(getId()));
                theView.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(InteractionPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}
