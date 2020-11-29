package CSC340.ChangePreference;

import java.awt.event.ActionListener;
import javax.swing.*;

public class PetChangePreferencesView extends JFrame {

    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("");
    private JLabel zipCodeLabel = new JLabel("Update Zip Code:");
    private JTextField zipCode = new JTextField();
    private JLabel radiusLabel = new JLabel(" Update Search Distance:");
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
        setTitle("Pet Change Preferences");
        this.setSize(500, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        zipCodeLabel.setBounds(90, 30, 100, 25);
        panel.add(zipCodeLabel);
        zipCode.setBounds(210, 30, 90, 25);
        panel.add(zipCode);

        radiusLabel.setBounds(60, 60, 150, 25);
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


    public String getZipCode(){
        return zipCode.getText();
    }

    public String getRadius() {
        return searchDistance.getText();
    }

    public void setZipCode(String _zipCode) {
        this.zipCode.setText(_zipCode);
    }

    public void setRadius(String _searchDistance) {
        this.searchDistance.setText(_searchDistance);
    }

    void addSaveListiner(ActionListener _listenForSaveListener){
        saveButton.addActionListener(_listenForSaveListener);
    }

    void addCancelListiner(ActionListener _listenForCancelListener){
        cancelButton.addActionListener(_listenForCancelListener);
    }

    void addDogCheckListener(ActionListener _listenForDogCheckListener){
        jCheckBoxDogs.addActionListener(_listenForDogCheckListener);
    }

    void addCatCheckListener(ActionListener _listenForCatCheckListener){
        jCheckBoxCats.addActionListener(_listenForCatCheckListener);
    }

    void addRabbitsCheckListener(ActionListener _listenForRabbitsCheckListener){
        jCheckBoxRabbits.addActionListener(_listenForRabbitsCheckListener);
    }

    void addBirdsCheckListener(ActionListener _listenForBirdsCheckListener){
        jCheckBoxBirds.addActionListener(_listenForBirdsCheckListener);
    }
    void addScalesCheckListener(ActionListener _listenForScalesCheckListener){
        jCheckBoxScales.addActionListener(_listenForScalesCheckListener);
    }
    void addSmallFCheckListener(ActionListener _listenForSmallFCheckListener){
        jCheckBoxSmallF.addActionListener(_listenForSmallFCheckListener);
    }
     void addHorsesCheckListener(ActionListener _listenForHorsesCheckListener){
        jCheckBoxHorses.addActionListener(_listenForHorsesCheckListener);
    }
     void addBarnyardCheckListener(ActionListener _listenForBarnyardCheckListener){
        jCheckBoxBarnyard.addActionListener(_listenForBarnyardCheckListener);
    }




    void addDogParametersButtonListener(ActionListener _listenForDogParametersButton){
        dogParametersButton.addActionListener(_listenForDogParametersButton);
    }

    void addCatParametersButtonListener(ActionListener _listenForCatParametersButton){
        catParametersButton.addActionListener(_listenForCatParametersButton);
    }

    void addBirdsParametersButtonListener(ActionListener _listenForBirdsParametersButton){
        birdsParametersButton.addActionListener(_listenForBirdsParametersButton);
    }

    void addScalesParametersButtonListener(ActionListener _listenForScalesParametersButton){
        scalesParametersButton.addActionListener(_listenForScalesParametersButton);
    }

    void addRabbitParametersButtonListener(ActionListener _listenForRabbitParametersButton){
        rabbitParametersButton.addActionListener(_listenForRabbitParametersButton);
    }

    void addSmallFParametersButtonListener(ActionListener _listenForSmallFParametersButton){
        smallAndFurryParametersButton.addActionListener(_listenForSmallFParametersButton);
    }

    void addHorsesParametersButtonListener(ActionListener _listenForHorsesParametersButton){
        horsesParametersButton.addActionListener(_listenForHorsesParametersButton);
    }

    void addBarnyardParametersButtonListener(ActionListener _listenForBarnyardParametersButton){
        barnyardParametersButton.addActionListener(_listenForBarnyardParametersButton);
    }






    void displayLoginUnsuccessful(String _message) {
        JOptionPane.showMessageDialog(this, _message);
    }


}
