
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;


/**
 * This class represents a graphical user interface for the Crime application.
 */
public class CrimeGUI extends JFrame {
    /** Panel to hold main content of GUI */
    private JPanel panel;
    /** Drop-down list of crime categories */
    private JComboBox categories;
    /** Buttons to navigate the GUI */
    private JButton crimeButton;
    private JButton addCrimeButton;
    private JButton mapButton;
    private JButton statsButton;
    private JButton clearListButton;
    //private JButton locationButton;
    /** Panels to hold different sections of the GUI */
    private JPanel topPanel;
    private JPanel buttonPanel;
    private JScrollPane mapPane;
    /** Text areas to display information */
    private JTextArea info;
    private JTextArea stats;
    private JTextArea listOfCrimes;
    private JScrollPane infoPane;
    private JScrollPane statsPane;
    /** Boolean to check if crime search button has been clicked */
    private boolean crimeSearchClicked = false;

    private CrimeManager crimeManager;


    /**
     * Constructor to create the CrimeGUI object.
     */
    public CrimeGUI() {

        this.crimeManager = new CrimeManager();
    
        setTitle("Crime: UK Police Data GUI");
        setSize(1270, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        // Create the main panel and set its layout
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        buttonPanel = new JPanel();
        topPanel = new JPanel();
        mapPane = new JScrollPane();
        JPanel eastPanel = new JPanel();


    
        // Create text areas and scroll panes
        info = new JTextArea();
        stats = new JTextArea();
        infoPane = new JScrollPane(info);
        statsPane = new JScrollPane(stats);
        infoPane.setPreferredSize(new Dimension(300, 700));
        statsPane.setPreferredSize(new Dimension(300, 350));
        infoPane.setBorder(new TitledBorder("Crime Info"));
        statsPane.setBorder(new TitledBorder("Crime Stats"));
        mapPane.setBorder(new TitledBorder("Leicester UK Map"));
    
        // Create the second scroll pane
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
        listOfCrimes = new JTextArea();

        //JTextArea listOfCrimes = new JTextArea();
        JScrollPane listOfCrimesPane = new JScrollPane(listOfCrimes);
        listOfCrimes.setPreferredSize(new Dimension(300, 350)); // Adjust size as needed
        listOfCrimes.setBorder(new TitledBorder("Crimes Added to List"));
    
        createMap();
    
        // Create the drop-down list of crime categories
        List<Crime> crimes = NetUtils.getURLContents();
        for (Crime crime : crimes) {
            crimeManager.addCrime(crime);
        }
        List<Crime> sortedCrimes = crimeManager.getCrimes();
        List<String> categoryList = new ArrayList<>();
        for (Crime crime : sortedCrimes) {
            if (!categoryList.contains(crime.getCategory())) {
                categoryList.add(crime.getCategory());
            }
        }
        Collections.sort(categoryList);
        categories = new JComboBox(categoryList.toArray(new String[0]));
    
        // Create the buttons and add action listeners
        crimeButton = new JButton("Crime Search");
        crimeButton.addActionListener(new crimeSearchListener());
        addCrimeButton = new JButton("Add Crime");
        addCrimeButton.addActionListener(new addCrimeListener());
        mapButton = new JButton("Show Crime Locations");
        mapButton.addActionListener(new mapListener());
        statsButton = new JButton("Populate Crime Stats");
        statsButton.addActionListener(new statsListener());
        clearListButton = new JButton("Clear List");
        clearListButton.addActionListener(new clearListListener());
    
        // Add components to the panels
        topPanel.add(categories);
        topPanel.add(crimeButton);
        buttonPanel.add(addCrimeButton);
        buttonPanel.add(mapButton);
        buttonPanel.add(statsButton);
        buttonPanel.add(clearListButton);
    
        eastPanel.add(statsPane);
        eastPanel.add(listOfCrimes);
    
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(infoPane, BorderLayout.WEST);
        panel.add(mapPane, BorderLayout.CENTER);
        panel.add(eastPanel, BorderLayout.EAST);
    
        add(panel);
    
        setVisible(true);
    }

    
    /**
     * Creates a map image from a URL.
     * @param imageUrl the URL of the image
     */
    public void createMapImage(String imageUrl) {
        try {
            String destinationFile = "image.jpg";
            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);
            byte[] b = new byte[2048];
            int length;
            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }
            is.close();
            os.close();
            JLabel label = new JLabel(new ImageIcon((new ImageIcon("image.jpg"))
                        .getImage().getScaledInstance(630, 600, java.awt.Image.SCALE_SMOOTH)));
            JPanel imagePanel = new JPanel();
            imagePanel.add(label);
            mapPane.setViewportView(imagePanel);
            mapPane.revalidate();
            mapPane.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Creates a map image at a specific latitude and longitude.
     */
    public void createMap() {
        String latitude = "52.629729";
        String longitude = "-1.131592";
        String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center=" +
                           latitude + "," + longitude +
                          "&zoom=14&size=512x512&maptype=satellite&key=AIzaSyA0q8-kHzgWZKLG_l_jXFEu0kjDgfu8QpA";
        createMapImage(imageUrl);
    }
    
    /**
     * Creates a map image with markers at specific latitude and longitude points.
     * @param selectedCategory the category of crime to display on the map
     */
    public void createMapWithMarkers(String selectedCategory) {
        String latitude = "52.629729";
        String longitude = "-1.131592";
        List<Crime> crimes = NetUtils.getURLContents();
        String markers = "";
        for (Crime crime : crimes) {
            if (crime.getCategory().equals(selectedCategory)) {
                markers += "&markers=color:red%7C" + crime.getLocationLatitude() + "," + crime.getLocationLongitude();
            }
        }
        String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center=" +
                           latitude + "," + longitude + "&zoom=14&size=512x512&maptype=satellite" +
                           markers + "&key=AIzaSyA0q8-kHzgWZKLG_l_jXFEu0kjDgfu8QpA";
        createMapImage(imageUrl);
    }
    
    public static void main(String[] args) {
        new CrimeGUI();
    }


    /**
     * Action listener for the crime search button.
     */
    private class crimeSearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedCategory = (String) categories.getSelectedItem();
            List<Crime> crimes = NetUtils.getURLContents();
            String output = "";
            for (Crime crime : crimes) {
                if (crime.getCategory().equals(selectedCategory)) {
                    output += crime.getInfo() + "\n";
                }
            }
            info.setText(output);
            crimeSearchClicked = true;
            createMap();
        }
    }
    
    /**
     * Action listener for the map button.
     */
    private class mapListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (categories.getSelectedItem() != null && crimeSearchClicked) {
                String selectedCategory = (String) categories.getSelectedItem();
                createMapWithMarkers(selectedCategory);
            }
        }
    }
    
    /**
     * Action listener for the stats button.
     */
    private class statsListener implements ActionListener {
        @Override
    public void actionPerformed(ActionEvent e) {
        if (!crimeSearchClicked) {
            return;
        }
        String selectedCategory = (String) categories.getSelectedItem();
        List<Crime> crimes = NetUtils.getURLContents();
        int count = 0;
        Map<String, Integer> streetCounts = new HashMap<>();
        for (Crime crime : crimes) {
            if (crime.getCategory().equals(selectedCategory)) {
                count++;
                String streetName = crime.getStreetName();
                if (streetName != null) {
                    streetCounts.put(streetName, streetCounts.getOrDefault(streetName, 0) + 1);
                }
            }
        }
        String output = "Number of " + selectedCategory + " crimes: " + count;
        output += "\n\nStreets with multiple crimes:\n";
        for (Map.Entry<String, Integer> entry : streetCounts.entrySet()) {
            if (entry.getValue() > 1) {
                output += "\n" + entry.getKey() + ": " + entry.getValue();
            }
        }
        stats.setText(output);
    }
}

    private class addCrimeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (crimeSearchClicked) {
                String selectedCategory = (String) categories.getSelectedItem();
                listOfCrimes.append(selectedCategory + "\n");
                crimeSearchClicked = false;
        }
    }
}

  

    private class clearListListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            listOfCrimes.setText(""); // Clear the JTextArea
            crimeManager.clearCrimes(); // Clear the CrimeManager
        }
    }

    /*private class locationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //textArea.setText("  Location Details");
        }
    }*/
}
