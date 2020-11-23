/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.apiCall;
import static CSC340.apiCall.PetFinderAPIConnector.apiCall;
import static CSC340.apiCall.PetFinderAPIConnector.mapApiCall;
import CSC340.DBtoAPI.DBtoAPIController;
import static CSC340.DBtoAPI.DBtoAPIController.DBtoAPI;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
/**
 *
 * @author David Bowles
 */
public class PetFinderAPIController {
    public static String callAPI(String id) throws SQLException, IOException, JSONException{
         HashMap<String,String> map;
         String s = DBtoAPI(id);
        
         String s1 = mapApiCall(s);
         //String url = "https://api.petfinder.com/v2/animals?" + DBtoAPIController.DBtoAPI(id);
         //String apiString = apiCall(url);  
         return s1;
    }
}
