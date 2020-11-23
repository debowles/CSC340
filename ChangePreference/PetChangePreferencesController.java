/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.ChangePreference;

import CSC340.ChangePreference.BirdPreferences.BirdPreferencesModel;
import CSC340.ChangePreference.BirdPreferences.BirdPreferencesController;
import CSC340.ChangePreference.BirdPreferences.BirdPreferencesView;
import CSC340.ChangePreference.CatPreferances.CatPreferencesController;
import CSC340.ChangePreference.CatPreferances.CatPreferencesModel;
import CSC340.ChangePreference.CatPreferances.CatPreferencesView;
import CSC340.ChangePreference.DogPreferances.DogPreferencesModel;
import CSC340.ChangePreference.DogPreferances.DogPreferencesController;
import CSC340.ChangePreference.DogPreferances.DogPreferencesView;
import CSC340.ChangePreference.HorsesPreferences.HorsesPreferencesController;
import CSC340.ChangePreference.HorsesPreferences.HorsesPreferencesView;
import CSC340.ChangePreference.HorsesPreferences.HorsesPreferencesModel;
import CSC340.ChangePreference.RabbitPreferances.RabbitPreferencesController;
import CSC340.ChangePreference.RabbitPreferances.RabbitPreferencesModel;
import CSC340.ChangePreference.RabbitPreferances.RabbitPreferencesView;
import CSC340.ChangePreference.ScalesAndOtherPreferences.ScalesAndOtherPreferencesView;
import CSC340.ChangePreference.ScalesAndOtherPreferences.ScalesAndOtherPreferencesModel;
import CSC340.ChangePreference.ScalesAndOtherPreferences.ScalesAndOtherPreferencesController;
import CSC340.ChangePreference.SmallAndFurryPreferences.SmallAndFurryPreferencesView;
import CSC340.ChangePreference.SmallAndFurryPreferences.SmallAndFurryPreferencesModel;
import CSC340.ChangePreference.SmallAndFurryPreferences.SmallAndFurryPreferencesController;
import CSC340.ChangePreference.BarnyardPreferences.BarnyardPreferencesView;
import CSC340.ChangePreference.BarnyardPreferences.BarnyardPreferencesModel;
import CSC340.ChangePreference.BarnyardPreferences.BarnyardPreferencesController;
import CSC340.InteractionPage.InteractionPageController;
import CSC340.InteractionPage.InteractionPageView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author David Bowles
 */
public class PetChangePreferencesController {
    
    private PetChangePreferencesView theView;
    private PetChangePreferencesModel theModel;
    private String id;
    
    public PetChangePreferencesController(PetChangePreferencesView _theView, PetChangePreferencesModel _theModel, String _id) {
        this.theView = _theView;
        this.theModel = _theModel;
        this.id = _id;
        
        
        this.theView.addSaveListiner(new saveListener());
        this.theView.addCancelListiner(new cancelListener());
        
        
        this.theView.addDogCheckListener(new dogListener());
        this.theView.addCatCheckListener(new catListener());
        this.theView.addRabbitsCheckListener(new rabbitListener());
        this.theView.addScalesCheckListener(new scalesListener());
        this.theView.addBirdsCheckListener(new birdsListener());
        this.theView.addSmallFCheckListener(new smallFListener());
        this.theView.addHorsesCheckListener(new horsesListener());
        this.theView.addBarnyardCheckListener(new barnyardListener());
        
        
        this.theView.addBarnyardParametersButtonListener(new barnyardPreferencesListener());
        this.theView.addDogParametersButtonListener(new dogPreferencesListener());
        this.theView.addCatParametersButtonListener(new catPreferencesListener());
        this.theView.addRabbitParametersButtonListener(new rabbitPreferencesListener());
        this.theView.addScalesParametersButtonListener(new scalesAndOtherPreferencesListener());
        this.theView.addBirdsParametersButtonListener(new birdPreferencesListener());
        this.theView.addSmallFParametersButtonListener(new samllAndFurryPreferencesListener());
        this.theView.addHorsesParametersButtonListener(new horsesPreferencesListener());
    }

    public String getId() {
        return id;
    }
    
    
    class cancelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
                    InteractionPageView theView = new InteractionPageView();
                    InteractionPageController theController= new InteractionPageController(theView, getId());
                    theView.setVisible(true);
        }
    }

    
    class saveListener implements ActionListener {
    @Override
        public void actionPerformed(ActionEvent e) {
            if(theModel.emptyRadius(theView.getRadius())){                
            } else if(theModel.inValidZip(theView.getZipCode())){
            } else if(theModel.outOfBoundsRadius(theView.getRadius())){               
            } else if(theModel.emptyZip(theView.getZipCode())){                
            }else{
                try{
                    theModel.zipCodeAndRadius(theView.getZipCode(), theView.getRadius());
                    //figure out how to store ID
                    theModel.addToDB(getId());
                }
                catch(Exception ex) {
                    System.out.println("Error" + ex);
            }
                
        }
    }
    }
    
    class dogPreferencesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            DogPreferencesView theView = new DogPreferencesView();
            DogPreferencesModel theModel = new DogPreferencesModel(theView);
            DogPreferencesController theController = new DogPreferencesController(theView, theModel,getId());
            theView.setVisible(true);
        }
    }
    
    class catPreferencesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            CatPreferencesView theView = new CatPreferencesView();
            CatPreferencesModel theModel = new CatPreferencesModel(theView);
            CatPreferencesController theController = new CatPreferencesController(theView, theModel,getId());
            theView.setVisible(true);
        }
    }
    
    class birdPreferencesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            BirdPreferencesView theView = new BirdPreferencesView();
            BirdPreferencesModel theModel = new BirdPreferencesModel(theView);
            BirdPreferencesController theController = new BirdPreferencesController(theView, theModel,getId());
            theView.setVisible(true);
        }
    }
    
    class horsesPreferencesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            HorsesPreferencesView theView = new HorsesPreferencesView();
            HorsesPreferencesModel theModel = new HorsesPreferencesModel(theView);
            HorsesPreferencesController theController = new HorsesPreferencesController(theView, theModel,getId());
            theView.setVisible(true);
        }
    }
    
    class rabbitPreferencesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            RabbitPreferencesView theView = new RabbitPreferencesView();
            RabbitPreferencesModel theModel = new RabbitPreferencesModel(theView);
            RabbitPreferencesController theController = new RabbitPreferencesController(theView, theModel,getId());
            theView.setVisible(true);
        }
    }
    
    
    class scalesAndOtherPreferencesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            ScalesAndOtherPreferencesView theView = new ScalesAndOtherPreferencesView();
            ScalesAndOtherPreferencesModel theModel = new ScalesAndOtherPreferencesModel(theView);
            ScalesAndOtherPreferencesController theController = new ScalesAndOtherPreferencesController(theView, theModel,getId());
            theView.setVisible(true);
        }
    }
    
    
    
    class barnyardPreferencesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            BarnyardPreferencesView theView = new BarnyardPreferencesView();
            BarnyardPreferencesModel theModel = new BarnyardPreferencesModel(theView);
            BarnyardPreferencesController theController = new BarnyardPreferencesController(theView, theModel,getId());
            theView.setVisible(true);
        }
    }
    
    class samllAndFurryPreferencesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            SmallAndFurryPreferencesView theView = new SmallAndFurryPreferencesView();
            SmallAndFurryPreferencesModel theModel = new SmallAndFurryPreferencesModel(theView);
            SmallAndFurryPreferencesController theController = new SmallAndFurryPreferencesController(theView, theModel,getId());
            theView.setVisible(true);
        }
    }
    
    
    
    /* When the dogs checkbox is clicked, excute the method in the model */
    class dogListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String dog = "Dog ";
            try {
                theModel.animalSelected(dog);

            } catch (NullPointerException ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    /* When the cats checkbox is clicked, excute the method in the model */
    class catListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String cat = "Cats ";
            try {
                theModel.animalSelected(cat);

            } catch (Exception ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    /* When the rabbits checkbox is clicked, excute the method in the model */
    class rabbitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String rabbit = "Rabbit ";
            try {

                theModel.animalSelected(rabbit);

            } catch (Exception ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    /* When the Scales, Fins & Other checkbox is clicked, excute the method in the model */
    class scalesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String scales = "Scales, Fins & Other ";
            try {
                theModel.animalSelected(scales);

            } catch (Exception ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    /* When the birds checkbox is clicked, excute the method in the model */
    class birdsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String birds = "Bird ";
            try {
                theModel.animalSelected(birds);

            } catch (Exception ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    /* When the small & furry checkbox is clicked, excute the method in the model */
    class smallFListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String smallF = "Small & Furry ";
            try {
                theModel.animalSelected(smallF);

            } catch (Exception ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    /* When the horses checkbox is clicked, excute the method in the model */
    class horsesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String horse = "Horse ";
            try {
                theModel.animalSelected(horse);

            } catch (Exception ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    /* When the barnyard checkbox is clicked, excute the method in the model */
    class barnyardListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String barnyard = "Barnyard ";
            try {
                theModel.animalSelected(barnyard);

            } catch (Exception ex) {
                System.out.println("Error" + ex);
            }
        }
    }
    
    
}
