package CSC340.SignUp;

/*
* The purpose of this class to have the view and the model connect to the controller
* which responds to buttons clicked from the user from the view.
* Last updated: 11/10/2020
* Author: Yngrid Corrales
 */
import CSC340.LogIn.LoginController;
import CSC340.LogIn.LoginModel;
import java.awt.event.ActionEvent;
import CSC340.LogIn.LoginView;
import java.awt.event.ActionListener;

public class SignUpController {

    private SignUpView theView;
    private SignUpModel theModel;

    /* The Controller coordinates interactions between the view and model */
    public SignUpController(SignUpView _theView, SignUpModel _theModel) {
        this.theView = _theView;
        this.theModel = _theModel;

        /* This tells the view that when these buttons are clicked on, to execute the
         * actionPerformed methods created from the classes created below
         */
        this.theView.addBackListener(new backListener());
        this.theView.addSignUpListener(new signUpListener());
        this.theView.addCancelListener(new cancelListener());
        this.theView.addDogListener(new dogListener());
        this.theView.addCatListener(new catListener());
        this.theView.addBirdsListener(new birdsListener());
        this.theView.addRabbitsListener(new rabbitListener());
        this.theView.addScalesListener(new scalesListener());
        this.theView.addSmallFListener(new smallFListener());
        this.theView.addHorsesListener(new horsesListener());
        this.theView.addBarnyardListener(new barnyardListener());
    }

    /* When the back button is clicked, go back to the login view */
    class backListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            LoginView theView = new LoginView();
            LoginModel theModel = new LoginModel(theView);
            LoginController theController = new LoginController(theView, theModel);
            theView.setVisible(true);
        }
    }


    /* When the sign up button is clicked, excute the methods in the model */
    class signUpListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            /* The theView.getTypes() are the getter and setters that were created
             * in the view class to get the user info
             */

            if (theModel.noMatch(theView.getPassword(), theView.getRePass())) {
            }
            if (theModel.emailExists(theView.getEmail())) {
            } else if (theModel.emptyFirstName(theView.getFirstName())) {
            } else if (theModel.emptyLastName(theView.getLastName())) {
            } else if (theModel.emptyPhoneNo(theView.getPhoneNo())) {
            } else if (theModel.emptyZip(theView.getZipCode())) {
            } else if (theModel.emptyRadius(theView.getRadius())) {
            } else if (theModel.emptyPass(theView.getPassword())) {
            } else if (theModel.emptyRePass(theView.getRePass())) {
            } else if (theModel.inValidZip(theView.getZipCode())) {
            } else if (theModel.outOfBoundsRadius(theView.getRadius())) {
            } else if (theModel.validEmail(theView.getEmail())) {
            } else {
                try {
                    theModel.emailPhoneNo(theView.getEmail(), theView.getPhoneNo());
                    theModel.firstAndLastName(theView.getFirstName(), theView.getLastName());
                    theModel.passAndRePass(theView.getPassword(), theView.getRePass());
                    theModel.zipCodeAndRadius(theView.getZipCode(), theView.getRadius());
                    theModel.addToDB();
                } catch (Exception ex) {
                    System.out.println("Error" + ex);
                }
            }
        }
    }

    /* When the cancel button is clicked, exit */
    class cancelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
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
