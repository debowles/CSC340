package CSC340.ChangePreference;

import java.awt.event.ActionListener;
import javax.swing.*;

public class PetChangePreferencesView extends JFrame {

    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("");
    private JLabel zipCodeLabel = new JLabel("Zip Code:");
    private JTextField zipCode = new JTextField();
    private JLabel radiusLabel = new JLabel("Search Distance:");
    private JTextField searchDistance = new JTextField();
    private JLabel rangeLabel = new JLabel("Range from 100-500miles");
    private JCheckBox jCheckBoxDogs = new JCheckBox("Dogs");
    private JCheckBox jCheckBoxCats = new JCheckBox("Cats");
    private JCheckBox jCheckBoxRabbits = new JCheckBox("Rabbits");
    private JCheckBox jCheckBoxBirds = new JCheckBox("Birds");
    private JCheckBox jCheckBoxScales = new JCheckBox("Scales & Other");
    private JCheckBox jCheckBoxSmallF = new JCheckBox("Small & Furry");
    private JCheckBox jCheckBoxHorses = new JCheckBox("Horses");
    private JCheckBox jCheckBoxBarnyard = new JCheckBox("Barnyard");

    JButton dogParametersButton = new JButton("Edit Dog Parameters");
    JButton catParametersButton = new JButton("Edit Cat Parameters");
    JButton birdsParametersButton = new JButton("Edit Bird Parameters");
    JButton rabbitParametersButton = new JButton("Edit Rabbit Parameters");
    JButton smallAndFurryParametersButton = new JButton("Edit Parameters");
    JButton horsesParametersButton = new JButton("Edit Horse Parameters");
    JButton barnyardParametersButton = new JButton("Edit Barnyard Parameters");
    JButton scalesParametersButton = new JButton("Edit Scales Parameters");
    JButton cancelButton = new JButton("Cancel");
    JButton saveButton = new JButton("Save");

    public PetChangePreferencesView() {

        this.setSize(500, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        zipCodeLabel.setBounds(150, 30, 80, 25);
        panel.add(zipCodeLabel);
        zipCode.setBounds(210, 30, 90, 25);
        panel.add(zipCode);

        radiusLabel.setBounds(105, 60, 100, 25);
        panel.add(radiusLabel);
        searchDistance.setBounds(210, 60, 90, 25);
        panel.add(searchDistance);
        rangeLabel.setBounds(180, 85, 150, 25);
        panel.add(rangeLabel);

        jCheckBoxDogs.setBounds(90, 125, 80, 25);
        panel.add(jCheckBoxDogs);
        dogParametersButton.setBounds(230, 125, 180, 25);
        panel.add(dogParametersButton);

        jCheckBoxCats.setBounds(90, 160, 80, 25);
        panel.add(jCheckBoxCats);
        catParametersButton.setBounds(230, 160, 180, 25);
        panel.add(catParametersButton);

        jCheckBoxRabbits.setBounds(90, 195, 80, 25);
        panel.add(jCheckBoxRabbits);
        rabbitParametersButton.setBounds(230, 195, 180, 25);
        panel.add(rabbitParametersButton);

        jCheckBoxBirds.setBounds(90, 230, 80, 25);
        panel.add(jCheckBoxBirds);
        birdsParametersButton.setBounds(230, 230, 180, 25);
        panel.add(birdsParametersButton);

        jCheckBoxScales.setBounds(90, 270, 140, 25);
        panel.add(jCheckBoxScales);
        scalesParametersButton.setBounds(230, 270, 180, 25);
        panel.add(scalesParametersButton);

        jCheckBoxSmallF.setBounds(90, 305, 140, 25);
        panel.add(jCheckBoxSmallF);
        smallAndFurryParametersButton.setBounds(230, 305, 180, 25);
        panel.add(smallAndFurryParametersButton);

        jCheckBoxHorses.setBounds(90, 340, 140, 25);
        panel.add(jCheckBoxHorses);
        horsesParametersButton.setBounds(230, 340, 180, 25);
        panel.add(horsesParametersButton);

        jCheckBoxBarnyard.setBounds(90, 375, 140, 25);
        panel.add(jCheckBoxBarnyard);
        barnyardParametersButton.setBounds(230, 375, 183, 25);
        panel.add(barnyardParametersButton);

        cancelButton.setBounds(100,500,80,25);
        panel.add(cancelButton);

       saveButton.setBounds(300,500,80,25);
        panel.add(saveButton);


        this.add(panel);
    }
}
