package CSC340.PetHistory;

/*
* The purpose of this class to have the view and the model connect to the controller
* which responds to buttons clicked from the user from the view.
* Last updated: 11/23/2020
* Author: Yngrid Corrales
 */
import CSC340.ChangePreference.PetChangePreferencesView;
import CSC340.InteractionPage.InteractionPageView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetHistoryController {

    private PetHistoryView theView;

    /* The Controller coordinates interactions between the view and model */
    public PetHistoryController(PetHistoryView _theView) {
        this.theView = _theView;

        this.theView.addBackListener(new backListener());
        this.theView.addUpdateListener(new updateListener());
    }

    /* When the back to home page button is clicked, go back to the InteractionPage view */
    class backListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            InteractionPageView theView = new InteractionPageView();
            theView.setVisible(true);
        }
    }

    /* When the update preference button is clicked, go to the PetChangePreferences view */
    class updateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            PetChangePreferencesView theView = new PetChangePreferencesView();
            theView.setVisible(true);
        }

    }

}
