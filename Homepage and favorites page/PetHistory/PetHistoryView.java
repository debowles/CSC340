package CSC340.PetHistory;

/*
* The purpose of this class to display the view for the favorites page
* Last updated: 11/22/2020
* Author: Yngrid Corrales
 */
import javax.swing.*;
import java.awt.event.ActionListener;

public class PetHistoryView extends JFrame {

    /* All the buttons, text fields, checkboxes, and labels created to display window */
    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("");
    private JLabel petNameLabel = new JLabel("pet name");
    private JLabel typeLabel = new JLabel("TYPE: ");
    private JLabel breedLabel = new JLabel("BREED: ");
    private JLabel contactLabel = new JLabel("CONTACT: ");
    private JLabel contactinfoLabel = new JLabel(".");
    private JLabel typeinfoLabel = new JLabel(".");
    private JLabel breedinfoLabel = new JLabel(".");

    private JLabel petName2Label = new JLabel("pet name");
    private JLabel type2Label = new JLabel("TYPE: ");
    private JLabel breed2Label = new JLabel("BREED: ");
    private JLabel contact2Label = new JLabel("CONTACT: ");
    private JLabel contactinfo2Label = new JLabel(".");
    private JLabel typeinfo2Label = new JLabel(".");
    private JLabel breedinfo2Label = new JLabel(".");

    private JLabel petName3Label = new JLabel("pet name");
    private JLabel type3Label = new JLabel("TYPE: ");
    private JLabel breed3Label = new JLabel("BREED: ");
    private JLabel contact3Label = new JLabel("CONTACT: ");
    private JLabel contactinfo3Label = new JLabel(".");
    private JLabel typeinfo3Label = new JLabel(".");
    private JLabel breedinfo3Label = new JLabel(".");

    private JLabel petName4Label = new JLabel("pet name");
    private JLabel type4Label = new JLabel("TYPE: ");
    private JLabel breed4Label = new JLabel("BREED: ");
    private JLabel contact4Label = new JLabel("CONTACT: ");
    private JLabel contactinfo4Label = new JLabel(".");
    private JLabel typeinfo4Label = new JLabel(".");
    private JLabel breedinfo4Label = new JLabel(".");

    private JLabel pic = new JLabel("");
    JButton updateButton = new JButton("Update Preferences");
    JButton backButton = new JButton("Back to Homepage");

    /* This constructor formats and displays the buttons, text fields, checkboxes, and labels */
    public PetHistoryView() {

        String myimgpath;
        myimgpath = "C:\\Users\\Liz\\Downloads\\Pet Matcher logo.png";
        Icon myimgicon = new ImageIcon(myimgpath);
        pic.setIcon(myimgicon);

        setTitle("Favorites");
        this.setSize(630, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        pic.setBounds(130, 00, 210, 180);
        panel.add(pic);

        updateButton.setBounds(10, 10, 150, 25);
        panel.add(updateButton);

        backButton.setBounds(10, 500, 150, 25);
        panel.add(backButton);

        petNameLabel.setBounds(140, 160, 70, 25);
        panel.add(petNameLabel);

        typeLabel.setBounds(220, 160, 70, 25);
        panel.add(typeLabel);

        typeinfoLabel.setBounds(280, 160, 100, 25);
        panel.add(typeinfoLabel);

        breedLabel.setBounds(220, 180, 70, 25);
        panel.add(breedLabel);

        breedinfoLabel.setBounds(280, 179, 100, 25);
        panel.add(breedinfoLabel);

        contactLabel.setBounds(220, 200, 70, 25);
        panel.add(contactLabel);

        contactinfoLabel.setBounds(290, 200, 100, 25);
        panel.add(contactinfoLabel);

        petName2Label.setBounds(140, 240, 70, 25);
        panel.add(petName2Label);

        type2Label.setBounds(220, 240, 70, 25);
        panel.add(type2Label);

        typeinfo2Label.setBounds(280, 240, 100, 25);
        panel.add(typeinfo2Label);

        breed2Label.setBounds(220, 260, 70, 25);
        panel.add(breed2Label);

        breedinfo2Label.setBounds(280, 260, 100, 25);
        panel.add(breedinfo2Label);

        contact2Label.setBounds(220, 280, 70, 25);
        panel.add(contact2Label);

        contactinfo2Label.setBounds(290, 280, 100, 25);
        panel.add(contactinfo2Label);

        petName3Label.setBounds(140, 320, 70, 25);
        panel.add(petName3Label);

        type3Label.setBounds(220, 320, 70, 25);
        panel.add(type3Label);

        typeinfo3Label.setBounds(280, 320, 100, 25);
        panel.add(typeinfo3Label);

        breed3Label.setBounds(220, 340, 70, 25);
        panel.add(breed3Label);

        breedinfo3Label.setBounds(280, 340, 100, 25);
        panel.add(breedinfo3Label);

        contact3Label.setBounds(220, 360, 70, 25);
        panel.add(contact3Label);

        contactinfo3Label.setBounds(290, 360, 100, 25);
        panel.add(contactinfo3Label);

        petName4Label.setBounds(140, 400, 70, 25);
        panel.add(petName4Label);

        type4Label.setBounds(220, 400, 70, 25);
        panel.add(type4Label);

        typeinfo4Label.setBounds(280, 400, 100, 25);
        panel.add(typeinfo4Label);

        breed4Label.setBounds(220, 420, 70, 25);
        panel.add(breed4Label);

        breedinfo4Label.setBounds(280, 420, 100, 25);
        panel.add(breedinfo4Label);

        contact4Label.setBounds(220, 440, 70, 25);
        panel.add(contact4Label);

        contactinfo4Label.setBounds(290, 440, 100, 25);
        panel.add(contactinfo4Label);

        this.add(panel);

    }

    /* If the update preference button is clicked execute a method in the controller named actionPerformed */
    void addUpdateListener(ActionListener _listenForUpdateButton) {
        updateButton.addActionListener(_listenForUpdateButton);
    }

    /* If the back home button is clicked execute a method in the controller named actionPerformed */
    void addBackListener(ActionListener _listenForBackButton) {
        backButton.addActionListener(_listenForBackButton);
    }
}
