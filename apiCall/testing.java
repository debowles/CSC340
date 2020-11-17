/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.apiCall;
import CSC340.DB.DBPetFinderParcer;
import CSC340.APIParcer.PetFinderParcerTester;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
/**
 *
 * @author David Bowles
 */
public class testing{
    public static void main(String []args) throws IOException, SQLException{
        HashMap<String, String> mapFileContents = new HashMap<String, String>();
        
        
        
        
        PetFinderAPI url = new PetFinderAPI("https://api.petfinder.com/v2/animals?");
               
        String a = "https://api.petfinder.com/v2/animals?"+DBPetFinderParcer.getParameters();
        PetFinderAPI url2 = new PetFinderAPI(a);
        System.out.println(url2.toString());
        String s1 = url2.loadAPI(url);  
    }
}

