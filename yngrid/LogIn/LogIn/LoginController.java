package LogIn;

/*
* The purpose of this class to have the view and the model connect to the controller
* which responds to buttons clicked from the user from the view.
* Last updated: 11/18/2020
* Author: Yngrid Corrales
 */
import CSC340.InteractionPage.InteractionPageController;
import CSC340.InteractionPage.InteractionPageView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import SignUp.SignUpController;
import SignUp.SignUpModel;
import SignUp.SignUpView;

public class LoginController {

    private LoginView theView;
    private LoginModel theModel;

    /* The Controller coordinates interactions between the view and model */
    public LoginController(LoginView _theView, LoginModel _theModel) {
        this.theView = _theView;
        this.theModel = _theModel;

        /* This tells the view that when these buttons are clicked on, to execute the
         * actionPerformed methods created from the classes created below
         */
        this.theView.addsignInListener(new signInListener());
        this.theView.addsignUpListener(new signUpListener());
    }

    /* When the sign in button is clicked, excute the methods in the model and
     * if successful display interaction page
    */
    class signInListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String email;
            String password;
            try {
                email = theView.getEmail();
                password = theView.getPassword();
                theModel.addToDB(email, password);
            } catch (Exception ex) {
                System.out.println("Error" + ex);
            }
            theView.dispose();
            InteractionPageView theView = new InteractionPageView();
            InteractionPageController theController = new  InteractionPageController(theView);
            theView.setVisible(true);
        }

    }

    /* When the sign up button is clicked, show the signup view */
    class signUpListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            SignUpView theView = new SignUpView();
            SignUpModel theModel = new SignUpModel(theView);
            SignUpController theController = new SignUpController(theView, theModel);
            theView.setVisible(true);
        }

    }
}
