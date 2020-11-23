/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.InteractionPage;

import CSC340.APIParcer.Animal;

/**
 *
 * @author biscu
 */
public class InteractionPageModel {
    Animal animal;
    private InteractionPageView theView;
    public InteractionPageModel(InteractionPageView _theView) {
        this.theView = _theView;
    }
    
}
