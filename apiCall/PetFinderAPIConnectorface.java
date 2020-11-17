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
public interface PetFinderAPIConnectorface {
    public String getToken();
    public String apiCall(PetFinderAPI apiUrl)throws IOException, JSONException;
}
