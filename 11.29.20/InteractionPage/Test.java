/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.InteractionPage;

import static CSC340.APIParcer.Animal.callAnimal;
import java.io.IOException;
import java.sql.SQLException;
import org.json.JSONException;

/**
 *
 * @author biscu
 */
public class Test {
    public static void main(String[] args) throws SQLException, IOException, JSONException, JSONException, JSONException, JSONException, JSONException{
        InteractionPageView theView = new InteractionPageView();
                    InteractionPageModel theModel = new InteractionPageModel(theView);
                    InteractionPageController theController = new InteractionPageController(theView,theModel, "0", callAnimal("0"));
                    theView.setVisible(true);
    }
}
