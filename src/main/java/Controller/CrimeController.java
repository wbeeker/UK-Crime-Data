package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Crime;
import Model.CrimeManager;
import Model.Formatters.FileWriterFormatter;
import Model.Formatters.Formats;
import Model.Net.NetUtils;
import View.CrimeView;

/**
 * CrimeController class
 * Controller for the CrimeView class
 * Handles user input and updates the model and view accordingly
 */
public class CrimeController {
    private CrimeView view;
    private CrimeManager model;
    private List<Crime> addedCrimes = new ArrayList<>();
    private boolean crimeSearchClicked = false;
    

    /**
     * Constructor
     * @param view CrimeView object
     * @param model CrimeManager object
     */
    public CrimeController(CrimeView view, CrimeManager model) {
        this.view = view;
        this.model = model;

        // Add action listeners
        view.getCrimeButton().addActionListener(new crimeSearchListener());
        view.getAddCrimeButton().addActionListener(new addCrimeListener());
        view.getMapButton().addActionListener(new mapListener());
        view.getStatsButton().addActionListener(new statsListener());
        view.getClearListButton().addActionListener(new clearListListener());
        view.getSaveButton().addActionListener(new saveCrimeListener());
        view.getExitButton().addActionListener(new exitListener());

        // Initialize categories and data
        initializeCategories();
        initializeMap();
    }

    /**
     * Initialize categories
     * Fetches crime data from the network and populates the model and view with categories.
     */
    private void initializeCategories() {
        List<Crime> crimes = NetUtils.getURLContents();
        for (Crime crime : crimes) {
            model.addCrime(crime);
        }
        List<Crime> sortedCrimes = model.getCrimes();
        List<String> categoryList = new ArrayList<>();
        categoryList.add("all crimes");
        for (Crime crime : sortedCrimes) {
            if (!categoryList.contains(crime.getCategory())) {
                categoryList.add(crime.getCategory());
            }
        }
        Collections.sort(categoryList);
        view.getCategories().setModel(new DefaultComboBoxModel<>(categoryList.toArray(new String[0])));
    }

    /**
     * Initialize map
     * Sets up the initial map view with a default location.
     */
    private void initializeMap() {
        String latitude = "52.629729";
        String longitude = "-1.131592";
        String apiKey = System.getenv("GOOGLE_MAPS_API_KEY");
        String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center=" +
                           latitude + "," + longitude +
                          "&zoom=14&size=512x512&maptype=satellite&key=" + apiKey;
        createMapImage(imageUrl);
    }

    /**
     * Create map image
     * Downloads and displays a map image from the given URL.
     * @param imageUrl URL of the image
     */
    private void createMapImage(String imageUrl) {
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
            view.getMapPane().setViewportView(imagePanel);
            view.getMapPane().revalidate();
            view.getMapPane().repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crime search listener
     * Listens for the crime search button click and updates the view with the search results.
     */
    private class crimeSearchListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedCategory = (String) view.getCategories().getSelectedItem();
        List<Crime> crimes = NetUtils.getURLContents();
        String output = "";
        for (Crime crime : crimes) {
            if (selectedCategory.equals("all crimes") || crime.getCategory().equals(selectedCategory)) {
                output += crime.getInfo() + "\n";
            }
        }
        view.getInfo().setText(output);
        crimeSearchClicked = true;
        initializeMap();
        view.getStats().setText("");
    }
}

    /**
     * Map listener
     * Listens for the map button click and updates the map with markers for the selected category.
     */
    private class mapListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.getCategories().getSelectedItem() != null && crimeSearchClicked) {
                String selectedCategory = (String) view.getCategories().getSelectedItem();
                String latitude = "52.629729";
                String longitude = "-1.131592";
                String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center=" +
                                   latitude + "," + longitude +
                                  "&zoom=14&size=512x512&maptype=satellite" +
                                  getMarkersForCategory(selectedCategory) + "&key=AIzaSyA0q8-kHzgWZKLG_l_jXFEu0kjDgfu8QpA";
                createMapImage(imageUrl);
            }
        }

        /**
         * Get markers for the selected category
         * Generates markers for the map based on the selected crime category.
         * @param category Selected category
         * @return Markers for the selected category
         */
        private String getMarkersForCategory(String category) {
            List<Crime> crimes = NetUtils.getURLContents();
            String markers = "";
            int maxMarkers = 400;
            int markerCount = 0;
        
            for (Crime crime : crimes) {
                if (category.equals("all crimes") || crime.getCategory().equals(category)) {
                    markers += "&markers=color:red%7C" + crime.getLocationLatitude() + "," + crime.getLocationLongitude();
                    markerCount++;
                    if (markerCount >= maxMarkers) {
                        break;
                    }
                }
            }
            if (category.equals("all crimes") || category.equals("violent-crime")) {
                System.out.println("Displaying first 400 crimes.");
            }
            return markers;
        }
    }

    /**
     * Add crime listener
     * Listens for the add crime button click and adds the selected crime to the list.
     */
    private class addCrimeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (crimeSearchClicked) {
                String selectedCategory = (String) view.getCategories().getSelectedItem();
                String currentText = view.getListOfCrimes().getText();
                
                if (currentText.contains("all crimes")) {
                    return;
                }
                if (!currentText.contains(selectedCategory)) {
                    view.getListOfCrimes().append(selectedCategory + "\n");
                }
                List<Crime> crimes = NetUtils.getURLContents();
                List<Crime> specificCrimes = new ArrayList<>();

                if (selectedCategory.equals("all crimes")) {
                    view.getListOfCrimes().setText("all crimes\n");
                    addedCrimes.clear();
                    addedCrimes.addAll(crimes);
                } else {
                    for (Crime crime : crimes) {
                        if (crime.getCategory().equals(selectedCategory) && !addedCrimes.contains(crime)) {
                            specificCrimes.add(crime);
                            addedCrimes.add(crime);
                        }
                    }
                    model.addSpecificCrimes(specificCrimes);
                }
                crimeSearchClicked = true;
            }
        }
    }

    /**
     * Stats listener
     * Listens for the stats button click and updates the view with crime statistics.
     */
    private class statsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!crimeSearchClicked) {
                return;
            }
            crimeSearchClicked = false;
            view.getStats().setText("");
            String selectedCategory = (String) view.getCategories().getSelectedItem();
            List<Crime> crimes = NetUtils.getURLContents();
            int count = 0;
            Map<String, Integer> streetCounts = new HashMap<>();
            Map<String, Integer> categoryCounts = new HashMap<>();
    
            for (Crime crime : crimes) {
                if (selectedCategory.equalsIgnoreCase("all crimes") || crime.getCategory().equals(selectedCategory)) {
                    count++;
                    String streetName = crime.getStreetName();
                    if (streetName != null) {
                        streetCounts.put(streetName, streetCounts.getOrDefault(streetName, 0) + 1);
                    }
                    categoryCounts.put(crime.getCategory(), categoryCounts.getOrDefault(crime.getCategory(), 0) + 1);
                }
            }
            String output = "Number of " + selectedCategory + " crimes: " + count;
            if (selectedCategory.equalsIgnoreCase("all crimes")) {
                output = "Total number of crimes: " + count;
                output += "\n\nCrimes by category:\n";
                List<String> sortedCategories = new ArrayList<>(categoryCounts.keySet());
                Collections.sort(sortedCategories);
                for (String category : sortedCategories) {
                    output += "\n" + category + ": " + categoryCounts.get(category);
                }
            }
            output += "\n\nStreets with multiple crimes:\n";
            List<String> sortedStreets = new ArrayList<>(streetCounts.keySet());
            Collections.sort(sortedStreets);
            for (String street : sortedStreets) {
                if (streetCounts.get(street) > 1) {
                    output += "\n" + street + ": " + streetCounts.get(street);
                }
            }
            view.getStats().setText(output);
            crimeSearchClicked = true;
        }
    }

    /**
     * Clear list listener
     * Listens for the clear list button click and clears the list of added crimes.
     */
    private class clearListListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getListOfCrimes().setText("");
            model.clearCrimes();
            addedCrimes.clear();
        }
    }


    /**
     * Save crime listener
     * Listens for the save button click and saves the added crimes to a file.
     */
    private class saveCrimeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Save crimes to a file using CrimeManager
            model.saveCrimesToFile("crimes.txt");

            // Format and re-save crimes using FileWriterFormatter
            try (FileOutputStream output = new FileOutputStream("crimes.xml")) {
                List<Crime> crimesToSave;
                if (view.getCategories().getSelectedItem().equals("all crimes")) {
                    crimesToSave = model.getCrimes();
                    for (Crime crime : crimesToSave) {
                        model.addCrime(crime);
                    }
                } else {
                    crimesToSave = new ArrayList<>(addedCrimes);
                    model.addSpecificCrimes(crimesToSave);
                }
                crimesToSave.sort(Comparator.comparing(Crime::getCategory));
                FileWriterFormatter.write(crimesToSave, Formats.PRETTY, output);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Exit listener
     * Listens for the exit button click and exits the application.
     */
    private class exitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           System.exit(0);
        }
    }
    
}
