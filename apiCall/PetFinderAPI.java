/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.apiCall;

import static CSC340.apiCall.PetFinderAPIConnector.apiCall;
import static CSC340.apiCall.PetFinderAPIConnector.getToken;
import static CSC340.apiCall.PetFinderAPIConnector.runApi;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;

/**
 *
 * @author David Bowles
 */
public class PetFinderAPI implements PetFinderAPIInterface {

    //adds a parameter and value to the url
    public String addParameter(String apiUrl,String parameter, String value) {
        String urlString = apiUrl;
        urlString = urlString + "&" + parameter + "=" + value;
        apiUrl = urlString;
        return apiUrl;
    }

    //deletes the parameter and value out of the url
    @Override
    public String deleteParameter(String apiUrl,String parameter, String value) {
        String urlString = apiUrl;
        String remove = "&" + parameter + "=" + value;
        String replace = urlString.replace(remove, "");
        apiUrl = replace;
        return apiUrl;
    }

    //cahnges a value for a specific parameter
    @Override
    public String changeValue(String apiUrl, String parameter, String value1, String value2) {
        String urlString = apiUrl;
        String replace = urlString.replace(value1, value2);
        apiUrl = replace;
        return apiUrl;
    }

    public String loadAPI(String apiUrl) throws IOException, JSONException{
        String s;
        s = runApi(getToken(),apiUrl);
        return s;   
    }

    public Boolean conatinsParameter(String apiUrl, String parameter) {
        if (parameter.contains(apiUrl)) {
            return true;
        } else {
            return false;
        }
        
    //public void addPetType(String value){
      //  if(value=="Rabbit"||value=="Bird"||value=="Dog"||value=="Cat"||value=="Small & Furry"||value=="Horse"||value=="Barnyard"){
     //       addParameter("types", value);
     //   }
     //   else{
            
     //   }
    //}
    }
}
