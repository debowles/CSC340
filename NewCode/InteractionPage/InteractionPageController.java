package CSC340.InteractionPage;

/*
* The purpose of this class to have the view and the model connect to the controller
* which responds to buttons clicked from the user from the view.
* Last updated: 11/23/2020
* Author: Yngrid Corrales
 */
import CSC340.APIParcer.Animal;
import CSC340.ChangePreference.PetChangePreferencesController;
import CSC340.ChangePreference.PetChangePreferencesModel;
import CSC340.ChangePreference.PetChangePreferencesView;
import CSC340.PetHistory.PetHistoryController;
import CSC340.PetHistory.PetHistoryView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InteractionPageController {
    private Animal animals;
    private InteractionPageView theView;
    private String id;
    private InteractionPageModel theModel;
    /* The Controller coordinates interactions between the view and model */
    public InteractionPageController(InteractionPageView _theView, String _id ,InteractionPageModel _theModel) {
        this.theView = _theView;
        this.theModel = _theModel;
        this.id = _id;
        /* This tells the view that when these buttons are clicked on, to execute the
         * actionPerformed methods created from the classes created below
         */
        this.theView.addNoListener(new noListener());
        this.theView.addYesListener(new yesListener());
        this.theView.addUpdateListener(new updateListener());
        this.theView.addFavoriteListener(new favoriteListener());
    }

    public String getId() {
        return id;
    }

    class noListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

 class yesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theModel.yes();
            } catch (SQLException ex) {
                Logger.getLogger(InteractionPageController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
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
           theView.dispose();
           PetHistoryView  theView = new PetHistoryView();
           PetHistoryController theController= new PetHistoryController(theView);
           theView.setVisible(true);
        }

    }
}
