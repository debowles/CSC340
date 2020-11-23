/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.APIParcer;

import CSC340.apiCall.PetFinderAPIConnector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeObject.keys;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author biscu
 */
public class PetFinderAPIJson {

    public static HashMap<String, Object> getJsonHashMap(String json) throws JSONException {

        HashMap<String, Object> map = new HashMap<String, Object>();
        JSONObject jObject = new JSONObject(json);
        Iterator<?> keys = jObject.keys();

        while (keys.hasNext()) {
            try {
                String key = (String) keys.next();
                String value = jObject.getString(key);
                map.put(key, value);
            } catch (JSONException ex) {
                Logger.getLogger(PetFinderAPIConnector.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        System.out.println("json : " + jObject);
        System.out.println("map : " + map);

        return map;
    }

}
