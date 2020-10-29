package PetFinderUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * Serena Wisnewski Herter
 */
public class SwipeFrame extends JFrame implements ActionListener{
    final int _FRAME_WIDTH = 500;
    final int _FRAME_HEIGHT = 500;
    final String FRAME_TITLE = "Pet Matcher: Swipe";
    final String YES_MESSAGE = "Swipe Right";
    final String NO_MESSAGE = "Swipe Left";
    final String FAVORITES_MESSAGE = "See Favorites";
    final String PREFERENCES_MESSAGE = "Update User Preferences";
    final String MADE_BY_MESSAGE = "Made by: Passive-Aggressive Post-It Notes";
    private JButton yesButton = new JButton(YES_MESSAGE);
    private JButton noButton = new JButton(NO_MESSAGE);
    private JButton favoritesButton = new JButton(FAVORITES_MESSAGE);
    private JButton preferencesButton = new JButton(PREFERENCES_MESSAGE);
    private JPanel petDetailPanel = new JPanel();
    private JPanel petDetailSubPanel = new JPanel();
    private JPanel actionPanel = new JPanel();
    private JPanel headerPanel = new JPanel();
    private JPanel footerPanel = new JPanel();
    private ImageIcon logoImage = new ImageIcon("logo.png");
    private ImageIcon petImage = new ImageIcon("not yet supported");
    private JLabel petName = new JLabel("not yet supported");
    private JLabel petPicture = new JLabel(petImage);
    private JLabel petType = new JLabel("not yet supported");
    private JLabel petBreed = new JLabel("not yet supported");
    private JLabel petSex = new JLabel("not yet supported");
    private JLabel petAge = new JLabel("not yet supported");
    private JLabel shelterURL = new JLabel("not yet supported");
    private JLabel logo = new JLabel(logoImage);
    private JLabel madeBy = new JLabel(MADE_BY_MESSAGE);
   
    
    
public SwipeFrame()
{
    super();
    setSize(_FRAME_WIDTH, _FRAME_HEIGHT);
    setTitle(FRAME_TITLE);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    headerSection();
    petDetailSection();
    actionSection();
    footerSection();
}



public void headerSection()
{
    headerPanel.setBackground(Color.blue);
    headerPanel.add(logo);
    //preferencesButton.addActionListener(this);
    //headerPanel.add(preferencesButton); 
    add(headerPanel, BorderLayout.BEFORE_FIRST_LINE);
}

public void footerSection()
{
    footerPanel.setBackground(Color.blue);
    footerPanel.add(madeBy);
    add(footerPanel, BorderLayout.AFTER_LAST_LINE);
}

public void actionSection()
{
    actionPanel.setBackground(Color.LIGHT_GRAY);
    yesButton.addActionListener(this);
    noButton.addActionListener(this);
    favoritesButton.addActionListener(this);
    actionPanel.add(yesButton);
    actionPanel.add(noButton);
    actionPanel.add(favoritesButton);
    add(actionPanel);
}
public void petDetailSection()
{
    petDetailPanel.setBackground(Color.LIGHT_GRAY);
    petDetailPanel.add(petName);
    petDetailPanel.add(petPicture);
    petDetailPanel.add(petDetailSubPanel);
    add(petDetailPanel);    
}

public void petDetailSubPanel()
{
    petDetailSubPanel.setBackground(Color.GRAY);
    petDetailSubPanel.add(petType);
    petDetailSubPanel.add(petBreed);
    petDetailSubPanel.add(petAge);
    petDetailSubPanel.add(petSex);
    petDetailSubPanel.add(shelterURL);
}

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == yesButton) {
      JOptionPane.showMessageDialog(null, "Add to favotites not yet supported");
    } else if (e.getSource() == noButton) {
      JOptionPane.showMessageDialog(null, "Add to dislikes not yet supported");
    } else if (e.getSource() == favoritesButton) {
       new FavoritesFrame();
       dispose();       
    } else if (e.getSource() == preferencesButton) {
//       new PreferencesFrame();
//       dispose(); 
       JOptionPane.showMessageDialog(null, "Go to preferences not yet supported");
    }
    }
}
