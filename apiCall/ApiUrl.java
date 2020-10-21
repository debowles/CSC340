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
public class ApiUrl extends PetFinderAPI implements ApiUrlInterface{
    String apiUrl;

    public ApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }
    
    public String toString(){
        String url = apiUrl.toString();
        return url;
    }
    //adds a parameter and value to the url
    @Override
    public void addParameter(String parameter, String value){
        String urlString = this.apiUrl;
        urlString = urlString + "?" + parameter + "=" + value;
        this.apiUrl = urlString;
    }
    
    //deletes the parameter and value out of the url
    @Override
    public void deleteParameter(String parameter, String value){
        String urlString = this.apiUrl;
        String remove = "?" + parameter + "=" + value;
        String replace = urlString.replace(remove, "");               
        this.apiUrl = replace;
    }
    
    
    //cahnges a value for a specific parameter
    @Override
    public void changeValue(String parameter, String value1, String value2){
        String urlString = this.apiUrl;
        String replace = urlString.replace(value1, value2);                        
        this.apiUrl = replace;
        }
    }
    
    
    

