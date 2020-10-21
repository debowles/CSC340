/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiCall;

/**
 *
 * @author biscu
 */

  public interface ApiUrlInterface {
   //public String changeType(String Type);
    
    //public String changeBreed(String Breed);
    
    //public String changeLocation(String zip);
        
    public void addParameter(String parameter, String value);
    public void deleteParameter(String parameter, String value);
    public void changeValue(String parameter, String value1, String value2);
}

