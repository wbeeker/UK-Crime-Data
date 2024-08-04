package View;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;


/**
 * CrmieView class
 * Represents the graphical user interface for displaying crime data.
 */
public class CrimeView extends JFrame {
    /** The main panel */
    private JPanel panel;
    /** The ccombo box for selecting crime categories */
    private JComboBox<String> categories;
    /** Button for initiating a crime search */
    private JButton crimeButton;
    /** Button for adding a crime to the list */
    private JButton addCrimeButton;
    /** Button for showing crime locations on a map */
    private JButton mapButton;
    /** Button for populating crime stats */
    private JButton statsButton;
    /** Button for clearing the list of crimes */
    private JButton clearListButton;
    /** Button for saving crimes */
    private JButton saveButton;
    /** Button for exiting the program */
    private JButton exitButton;
    /** Panel at the top of the main panel */
    private JPanel topPanel;
    /** Panel for holding buttons */
    private JPanel buttonPanel;
    /** Panel on the east side of the main panel */
    private JPanel eastPanel;
    /** Scroll pane for displaying the map */
    private JScrollPane mapPane;
    /** Scroll pane for displaying crime information */
    private JScrollPane infoPane;
    /** Scroll pane for displaying crime stats */
    private JScrollPane statsPane;
    /** Scroll pane for displaying the list of crimes */
    private JScrollPane listOfCrimesPane;
    /** Text area for displaying crime information */
    private JTextArea info;
    /** Text area for displaying crime stats */
    private JTextArea stats;
    /** Text area for displaying the list of crimes */
    private JTextArea listOfCrimes;


    /**
     * Constructor for the CrimeView class.
     * Initializes the GUI components and layout.
     */
    public CrimeView() {
        // Set up the main frame
        setTitle("Crime: UK Police Data GUI");
        setSize(1270, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the main panel
        panel = new JPanel(new BorderLayout());
        buttonPanel = new JPanel();
        topPanel = new JPanel();
        mapPane = new JScrollPane();
        eastPanel = new JPanel();
        
        // Create the text areas
        info = new JTextArea();
        stats = new JTextArea();
        listOfCrimes = new JTextArea();
        
        // Create the scroll panes
        infoPane = new JScrollPane(info);
        statsPane = new JScrollPane(stats);
        listOfCrimesPane = new JScrollPane(listOfCrimes);
        
        // Set the preferred sizes for the scroll panes
        infoPane.setPreferredSize(new Dimension(300, 700));
        statsPane.setPreferredSize(new Dimension(300, 350));
        listOfCrimes.setPreferredSize(new Dimension(300, 350));

        
        // Set the titles for the scroll panes
        infoPane.setBorder(new TitledBorder("Crime Info"));
        statsPane.setBorder(new TitledBorder("Crime Stats"));
        mapPane.setBorder(new TitledBorder("Leicester UK Map"));
        listOfCrimes.setBorder(new TitledBorder("Crimes Added to List"));

        // Create list and combo box for crime categories
        List<String> categoryList = new ArrayList<>();
        categories = new JComboBox<>(categoryList.toArray(new String[0]));

        // Create the buttons
        crimeButton = new JButton("Crime Search");
        addCrimeButton = new JButton("Add Crime");
        mapButton = new JButton("Show Crime Locations");
        statsButton = new JButton("Populate Crime Stats");
        clearListButton = new JButton("Clear List");
        saveButton = new JButton("Save Crimes");
        exitButton = new JButton("Exit");

        // Set the layout for the main panel
        topPanel.add(categories);
        topPanel.add(crimeButton);
        buttonPanel.add(addCrimeButton);
        buttonPanel.add(mapButton);
        buttonPanel.add(statsButton);
        buttonPanel.add(clearListButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(exitButton);

        // Set the layout for the east panel
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
        eastPanel.add(statsPane);
        eastPanel.add(listOfCrimes);

        // Add the components to the main panel
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(infoPane, BorderLayout.WEST);
        panel.add(mapPane, BorderLayout.CENTER);
        panel.add(eastPanel, BorderLayout.EAST);

        add(panel);

        setVisible(true);
    }


    /**
     * Gets the categories combo box.
     * @return JComboBox of categories
     */
    public JComboBox<String> getCategories() {
        return categories;
    }

    /**
     * Gets the crime search button.
     * @return JButton for crime search
     */
    public JButton getCrimeButton() {
        return crimeButton;
    }

    /**
     * Gets the add crime button.
     * @return JButton for adding a crime
     */
    public JButton getAddCrimeButton() {
        return addCrimeButton;
    }

    /**
     * Gets the map button.
     * @return JButton for showing crime locations
     */
    public JButton getMapButton() {
        return mapButton;
    }

    /**
     * Gets the stats button.
     * @return JButton for populating crime stats
     */
    public JButton getStatsButton() {
        return statsButton;
    }

    /**
     * Gets the clear list button.
     * @return JButton for clearing the list of crimes
     */
    public JButton getClearListButton() {
        return clearListButton;
    }

    /**
     * Gets the save button.
     * @return JButton for saving crimes
     */
    public JButton getSaveButton() {
        return saveButton;
    }

    /**
     * Gets the exit button.
     * @return JButton for exiting the program
     */
    public JButton getExitButton() {
        return exitButton;
    }

    /**
     * Gets the info text area.
     * @return JTextArea for crime info
     */
    public JTextArea getInfo() {
        return info;
    }

    /**
     * Gets the stats text area.
     * @return JTextArea for crime stats
     */
    public JTextArea getStats() {
        return stats;
    }

    /**
     * Gets the list of crimes text area.
     * @return JTextArea for the list of crimes
     */
    public JTextArea getListOfCrimes() {
        return listOfCrimes;
    }

    /**
     * Gets the map pane.
     * @return JScrollPane for the map
     */
    public JScrollPane getMapPane() {
        return mapPane;
    }
      
}
