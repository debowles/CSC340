
package CSC340.ChangePreference;

/**
 *
 * @author Liz
 */
public class AnimalPreferences {


    public static void main(String[] args) {
        // TODO code application logic here
        PetChangePreferencesView theView = new PetChangePreferencesView();
        PetChangePreferencesModel theModel = new PetChangePreferencesModel(theView);
        PetChangePreferencesController theController = new PetChangePreferencesController(theView,theModel);

        theView.setVisible(true);
    }

}
