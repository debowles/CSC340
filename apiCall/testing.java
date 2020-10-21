/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiCall;
import apiCall.PetFinderAPI;
import java.io.IOException;
/**
 *
 * @author biscu
 */
public class testing extends PetFinderAPI{
    public static void main(String []args) throws IOException{
        ApiUrl url = new ApiUrl("https://api.petfinder.com/v2/animals");
        url.addParameter("location", "27403");
        System.out.println(url.toString());
       url.changeValue("location", "27403", "28428");
        System.out.println(url.toString());
        String s = apiCall(url);
        System.out.println(s);
    }
}
