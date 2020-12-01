/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.apiCall;

import java.io.IOException;
import org.json.JSONException;

/**
 *
 * @author David Bowles
 */

  public interface PetFinderAPIInterface {
       
    //adds parameter to url  
    public String addParameter(String apiUrl,String parameter, String value);
    
    //deletes parameter on url
    public String deleteParameter(String apiUrl,String parameter, String value);
    
    //changes parameter on url
    public String changeValue(String apiUrl,String parameter, String value1, String value2);
    
    //loads parameter on url
    public String loadAPI(String urlString) throws IOException, JSONException;
}

