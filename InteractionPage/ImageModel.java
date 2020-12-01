/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.InteractionPage;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author biscu
 */
public class ImageModel {
    

    public ImageModel() {
        System.out.println("ImageModelMade");
    }
    
    //String urlString = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49924499/1/?bust=1606775475u0026width=300.jpg";
    
    public ImageIcon urlStringToImageIcon(String urlString){
        try{
            System.out.println("URL String urlStringToImageIcon = "+urlString);
            URL url = new URL(urlString);       
            ImageIcon image  =new ImageIcon(ImageIO.read(url));
            return image;
        }catch (Exception ex) {
            Logger.getLogger(ImageModel.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        System.out.println("return null");
        return null;
    }
//    public ImageIcon getImage(){
//        try{
//            String urlString = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49924499/1/?bust=1606775475u0026width=300.jpg";
//            System.out.println("URL String = "+urlString);
//            URL url = new URL(urlString);       
//            ImageIcon image  =new ImageIcon(ImageIO.read(url));
//            return image;
//        }catch (Exception ex) {
//            Logger.getLogger(ImageModel.class.getName()).log(Level.SEVERE, null, ex);
//        
//        }
//        System.out.println("return null");
//        return null;
//    }
    
    
//    public void setImage(String _urlString){ 
//        System.out.println("Set Image: "+ _urlString);
//         this.urlString =   _urlString;    
//    }
    
    
}
