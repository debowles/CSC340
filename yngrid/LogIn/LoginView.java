package LogIn;

/*
* The purpose of this class to display messages and create the view for our
* login form.
* Last updated: 11/09/2020
* Author: Yngrid Corrales
 */
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginView extends JFrame {

    /* All the buttons, text fields, checkboxes, and labels created to display window */
    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("Pet Matcher");
    private JLabel emailLabel = new JLabel("Email:");
    private JTextField email = new JTextField();
    private JLabel passwordLabel = new JLabel("Password:");
    private JButton signInButton = new JButton("Sign In");
    private JButton signUpButton = new JButton("Sign Up");
    private JTextField password = new JPasswordField();
    private JLabel pic = new JLabel("");

    /* This constructor formats and displays the buttons, text fields, checkboxes, and labels */
    public LoginView() {
        String myimgpath;
        myimgpath = "C:\\Users\\Liz\\Downloads\\Pet Matcher logo.png";
        Icon myimgicon = new ImageIcon(myimgpath);
        pic.setIcon(myimgicon);

        frame.add(panel);

        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(null);

        emailLabel.setBounds(100, 150, 80, 25);
        panel.add(emailLabel);

        email.setBounds(100, 170, 165, 25);
        panel.add(email);

        passwordLabel.setBounds(100, 200, 80, 25);
        panel.add(passwordLabel);

        password.setBounds(100, 220, 165, 25);
        panel.add(password);

        signInButton.setBounds(150, 260, 80, 25);
        panel.add(signInButton);

        signUpButton.setBounds(150, 300, 80, 25);
        panel.add(signUpButton);

        pic.setBounds(80, 00, 210, 190);
        panel.add(pic);

        this.add(panel);

    /* The following methods create strings equal to the users input */
    }

    public String getEmail() {
        String userEmail = email.getText();
        return userEmail;
    }

    public String getPassword() {
        String userPassword = password.getText();
        return userPassword;
    }

    /* If the sign in button is clicked execute a method in the controller named actionPerformed */
    void addsignInListener(ActionListener _listenForSignInButton) {
        signInButton.addActionListener(_listenForSignInButton);
    }

    /* If the sign up button is clicked execute a method in the controller named actionPerformed */
    void addsignUpListener(ActionListener _listenForSignUpButton) {
        signUpButton.addActionListener(_listenForSignUpButton);
    }

    /* Opens a popup that contains the error message passed */
    void displayLoginSuccessful(String _message) {
        JOptionPane.showMessageDialog(this, _message);

    }

    /* Opens a popup that contains the error message passed */
    void displayLoginUnsuccessful(String _message) {
        JOptionPane.showMessageDialog(this, _message);

    }

}
