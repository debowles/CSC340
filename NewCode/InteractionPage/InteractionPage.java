/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.InteractionPage;

/**
 *
 * @author Liz
 */
public class InteractionPage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        InteractionPageView theView = new InteractionPageView();
         InteractionPageModel theModel = new InteractionPageModel(theView);
        InteractionPageController theController= new InteractionPageController(theView,  "0", theModel );
         theView.setVisible(true);
    }

}
