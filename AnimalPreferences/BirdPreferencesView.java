/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.ChangePreferance;

import java.awt.event.ActionListener;
import javax.swing.*;

public class BirdPreferencesView extends JFrame {

    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("");
    private JLabel genderLabel = new JLabel("Gender:");
    private JLabel ageLabel = new JLabel("Age:");
    private JLabel sizeLabel = new JLabel("Size:");
    private JCheckBox jCheckBoxMale = new JCheckBox("Male");
    private JCheckBox jCheckBoxFemale = new JCheckBox("Female");
    private JCheckBox jCheckBoxBaby = new JCheckBox("Baby");
    private JCheckBox jCheckBoxYoung = new JCheckBox("Young");
    private JCheckBox jCheckBoxAdult = new JCheckBox("Adult");
    private JCheckBox jCheckBoxSenior = new JCheckBox("Senior");
    private JCheckBox jCheckBoxSmall = new JCheckBox("Small");
    private JCheckBox jCheckBoxMedium = new JCheckBox("Medium");
    private JCheckBox jCheckBoxLarge = new JCheckBox("Large");
    private JCheckBox jCheckBoxXLarge = new JCheckBox("XLarge");

    JButton cancelButton = new JButton("Cancel");
    JButton saveButton = new JButton("Save");

    public BirdPreferencesView() {

        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        genderLabel.setBounds(63, 30, 80, 25);
        panel.add(genderLabel);

        ageLabel.setBounds(80, 60, 80, 25);
        panel.add(ageLabel);

        sizeLabel.setBounds(75, 160, 80, 25);
        panel.add(sizeLabel);

        jCheckBoxMale.setBounds(120, 30, 80, 25);
        panel.add(jCheckBoxMale);

        jCheckBoxFemale.setBounds(200, 30, 170, 25);
        panel.add(jCheckBoxFemale);

        jCheckBoxBaby.setBounds(120, 60, 100, 25);
        panel.add(jCheckBoxBaby);

        jCheckBoxYoung.setBounds(120, 80, 100, 25);
        panel.add(jCheckBoxYoung);

        jCheckBoxAdult.setBounds(120, 100, 100, 25);
        panel.add(jCheckBoxAdult);

        jCheckBoxSenior.setBounds(120, 120, 100, 25);
        panel.add(jCheckBoxSenior);

        jCheckBoxSmall.setBounds(120, 160, 100, 25);
        panel.add(jCheckBoxSmall);

        jCheckBoxMedium.setBounds(120, 180, 100, 25);
        panel.add(jCheckBoxMedium);

        jCheckBoxLarge.setBounds(120, 200, 100, 25);
        panel.add(jCheckBoxLarge);

        jCheckBoxXLarge.setBounds(120, 220, 100, 25);
        panel.add(jCheckBoxXLarge);

        cancelButton.setBounds(90, 300, 80, 25);
        panel.add(cancelButton);

        saveButton.setBounds(200, 300, 80, 25);
        panel.add(saveButton);

        this.add(panel);

    }
}
