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
        
    public void addParameter(String parameter, String value);
    public void deleteParameter(String parameter, String value);
    public void changeValue(String parameter, String value1, String value2);
    public String loadAPI(PetFinderAPI apiUrl) throws IOException, JSONException;
}

