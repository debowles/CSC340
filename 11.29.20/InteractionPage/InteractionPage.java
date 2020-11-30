package CSC340.InteractionPage;

/*
* The purpose of this class to use the model, the view, and the controller all in
* one.
* Last updated: 11/26/2020
* Author: Yngrid Corrales
 */

public class InteractionPage {

    public static void main(String[] args) {
        InteractionPageView theView = new InteractionPageView();
        InteractionPageModel theModel = new InteractionPageModel(theView);
        // InteractionPageController theController= new InteractionPageController(theView, theModel, "0", "" );
        theView.setVisible(true);
    }

}
