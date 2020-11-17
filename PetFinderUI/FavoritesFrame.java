package CSC340.PetFinderUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * Serena Wisnewski Herter
 */
public final class FavoritesFrame extends JFrame implements ActionListener{
    final int _FRAME_WIDTH = 500;
    final int _FRAME_HEIGHT = 500;
    final String FRAME_TITLE = "Pet Matcher: Favorites";
    final String SEE_MORE_MESSAGE = "See More Pets!";
    final String SEARCH_LABEL_MESSAGE ="Search By Pet Name";
    final String SEARCH_BUTTON_MESSAGE = "Go";
    final String PREFERENCES_MESSAGE = "Update User Preferences";
    final String MADE_BY_MESSAGE = "Made by: Passive-Aggressive Post-It Notes";
    private JButton seeMoreButton = new JButton(SEE_MORE_MESSAGE);
    private JButton searchButton = new JButton(SEARCH_BUTTON_MESSAGE);
    private JButton preferencesButton = new JButton(PREFERENCES_MESSAGE);
    private JPanel petDetailPanel = new JPanel();
    private JPanel petDetailSubPanel = new JPanel();
    private JPanel headerPanel = new JPanel();
    private JPanel footerPanel = new JPanel();
    private JPanel repeaterPanel = new JPanel();
    private JPanel returnPanel = new JPanel();
    private JTextArea searchBox = new JTextArea(1, 30);
    private ImageIcon logoImage = new ImageIcon("logo.png");
    private ImageIcon petImage = new ImageIcon();
    private JLabel petName = new JLabel();
    private JLabel petPicture = new JLabel(petImage);
    private JLabel petType = new JLabel();
    private JLabel petBreed = new JLabel();
    private JLabel petSex = new JLabel();
    private JLabel petAge = new JLabel();
    private JLabel shelterURL = new JLabel();
    private JLabel logo = new JLabel(logoImage);
    private JLabel search = new JLabel(SEARCH_LABEL_MESSAGE);
    private JLabel madeBy = new JLabel(MADE_BY_MESSAGE);
   
    
    
   public FavoritesFrame()
{
    super();
    headerSection();
    repeaterSection();
    returnSection();
    footerSection();
    setSize(_FRAME_WIDTH, _FRAME_HEIGHT);
    setTitle(FRAME_TITLE);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
} 
 
public void headerSection()
{
    headerPanel.setBackground(Color.blue);
    headerPanel.add(logo);
    preferencesButton.addActionListener(this);
    headerPanel.add(preferencesButton); 
    add(headerPanel, BorderLayout.BEFORE_FIRST_LINE);
}

public void footerSection()
{
    footerPanel.setBackground(Color.blue);
    footerPanel.add(madeBy);
    add(footerPanel, BorderLayout.AFTER_LAST_LINE);
}

public void returnSection()
{
    returnPanel.setBackground(Color.LIGHT_GRAY);
    returnPanel.add(search);
    returnPanel.add(searchBox);
    searchButton.addActionListener(this);
    returnPanel.add(searchButton);
    seeMoreButton.addActionListener(this);
    returnPanel.add(seeMoreButton);
    add(returnPanel);    
}

public void petDetailSection()
{
    petDetailPanel.setBackground(Color.LIGHT_GRAY);
    petDetailPanel.add(petName);
    petDetailPanel.add(petPicture);
    petDetailPanel.add(petDetailSubPanel);
    add(petDetailPanel);    
}

public void repeaterSection()
{
    repeaterPanel.setBackground(Color.LIGHT_GRAY);
    
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
         if (e.getSource() == seeMoreButton) {
       new SwipeFrame();
       dispose(); 
       } else if (e.getSource() == searchButton) {
      JOptionPane.showMessageDialog(null, "search not yet supported");
    } else if (e.getSource() == preferencesButton) {
//       new PreferencesFrame();
//       dispose(); 
       JOptionPane.showMessageDialog(null, "Go to preferences not yet supported");
    }
    }
}
