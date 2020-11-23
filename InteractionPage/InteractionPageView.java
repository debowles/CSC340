package CSC340.InteractionPage;

/*
* The purpose of this class to display the interaction page
* Last updated: 11/23/2020
* Author: Yngrid Corrales
 */
import java.awt.event.ActionListener;
import javax.swing.*;

public class InteractionPageView extends JFrame {

    /* All the buttons, text fields, checkboxes, and labels created to display window */
    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("");
    private JLabel petNameLabel = new JLabel("pet name");
    private JLabel sexLabel = new JLabel("SEX: ");
    private JLabel typeLabel = new JLabel("TYPE: ");
    private JLabel ageLabel = new JLabel("AGE: ");
    private JLabel breedLabel = new JLabel("BREED: ");
    private JLabel contactLabel = new JLabel("CONTACT: ");
    private JLabel contactinfoLabel = new JLabel(".");
    private JLabel typeinfoLabel = new JLabel(".");
    private JLabel breedinfoLabel = new JLabel(".");
    private JLabel sexinfoLabel = new JLabel(".");
    private JLabel ageinfoLabel = new JLabel(".");

    private JLabel pic = new JLabel("");
    private JLabel petPic = new JLabel("PET PICTURE");
    JButton updateButton = new JButton("Update Preferences");
    JButton noButton = new JButton("yess");
    JButton yesButton = new JButton("noo");
    JButton favoriteButton = new JButton("See Favorites");

    /* This constructor formats and displays the buttons, text fields, checkboxes, and labels */
    public InteractionPageView() {
        String myimgpath;
        myimgpath = "C:\\Users\\Liz\\Downloads\\Pet Matcher logo.png";
        Icon myimgicon = new ImageIcon(myimgpath);
        pic.setIcon(myimgicon);

        setTitle("Interaction page");
        this.setSize(700, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        pic.setBounds(220, 00, 210, 180);
        panel.add(pic);

        updateButton.setBounds(10, 10, 150, 25);
        panel.add(updateButton);

        yesButton.setBounds(10, 650, 150, 25);
        panel.add(yesButton);

        noButton.setBounds(460, 650, 150, 25);
        panel.add(noButton);

        favoriteButton.setBounds(500, 10, 150, 25);
        panel.add(favoriteButton);

        petPic.setBounds(285, 185, 210, 180);
        panel.add(petPic);

        petNameLabel.setBounds(295, 140, 100, 25);
        panel.add(petNameLabel);

        typeLabel.setBounds(250, 420, 210, 180);
        panel.add(typeLabel);

        typeinfoLabel.setBounds(320, 420, 210, 180);
        panel.add(typeinfoLabel);

        breedLabel.setBounds(250, 440, 210, 180);
        panel.add(breedLabel);

        breedinfoLabel.setBounds(320, 440, 210, 180);
        panel.add(breedinfoLabel);

        ageLabel.setBounds(250, 460, 210, 180);
        panel.add(ageLabel);

        ageinfoLabel.setBounds(320, 460, 210, 180);
        panel.add(ageinfoLabel);

        sexLabel.setBounds(250, 480, 210, 180);
        panel.add(sexLabel);

        sexinfoLabel.setBounds(320, 480, 210, 180);
        panel.add(sexinfoLabel);

        contactLabel.setBounds(250, 500, 210, 180);
        panel.add(contactLabel);

        contactinfoLabel.setBounds(350, 500, 210, 180);
        panel.add(contactinfoLabel);

        this.add(panel);

    }

    /* If the update preference button is clicked execute a method in the controller named actionPerformed */
    void addUpdateListener(ActionListener _listenForUpdateButton) {
        updateButton.addActionListener(_listenForUpdateButton);
    }

    /* If the no button is clicked execute a method in the controller named actionPerformed */
    void addNoListener(ActionListener _listenForNoButton) {
        noButton.addActionListener(_listenForNoButton);
    }

    /* If the yes button is clicked execute a method in the controller named actionPerformed */
    void addYesListener(ActionListener _listenForYesButton) {
        yesButton.addActionListener(_listenForYesButton);
    }

    /* If the see favorites button is clicked execute a method in the controller named actionPerformed */
    void addFavoriteListener(ActionListener _listenForFavoriteButton) {
        favoriteButton.addActionListener(_listenForFavoriteButton);
    }
}
