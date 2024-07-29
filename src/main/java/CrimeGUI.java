
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class CrimeGUI extends JFrame {

    private JPanel panel;
    private JTextField crimeTextField;
    private JComboBox categories;
    private JButton crimeButton;
    private JButton detailsButton;
    private JButton mapButton;
    private JButton statsButton;
    private JButton timelineButton;
    private JButton locationButton;

    private JPanel topPanel;
    private JPanel buttonPanel;
    private JPanel mapPanel;

    private JTextArea info;
    private JTextArea stats;
    private JScrollPane scrollPane;
    private JScrollPane scrollPane2;

    private boolean crimeSearchClicked = false;

    public CrimeGUI() {
        setTitle("Crime: UK Police Data GUI");
        setSize(1250, 725);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        buttonPanel = new JPanel();
        topPanel = new JPanel();
        mapPanel = new JPanel();

        info = new JTextArea();
        stats = new JTextArea();
        scrollPane = new JScrollPane(info);
        scrollPane2 = new JScrollPane(stats);
        scrollPane.setPreferredSize(new Dimension(300, 700));
        scrollPane2.setPreferredSize(new Dimension(300, 700));

        scrollPane.setBorder(new TitledBorder("Crime Info"));
        scrollPane2.setBorder(new TitledBorder("Crime Stats"));

        createMap();

        List<Crime> crimes = NetUtils.getURLContents();
        Set<String> categorySet = new HashSet<>();
        for (Crime crime : crimes) {
            categorySet.add(crime.getCategory());
        }
        categories = new JComboBox(categorySet.toArray(new String[0]));

        crimeTextField = new JTextField(10);
        crimeButton = new JButton("Crime Search");
        crimeButton.addActionListener(new crimeSearchListener());
        detailsButton = new JButton("Crime Details");
        detailsButton.addActionListener(new detailsListener());
        mapButton = new JButton("Crime Map");
        mapButton.addActionListener(new mapListener());
        statsButton = new JButton("Crime Stats");
        statsButton.addActionListener(new statsListener());
        locationButton = new JButton("Location");
        locationButton.addActionListener(new locationListener());
        timelineButton = new JButton("Timeline");
        timelineButton.addActionListener(new timelineListener());

        topPanel.add(categories);
        topPanel.add(crimeButton);

        buttonPanel.add(detailsButton);
        buttonPanel.add(mapButton);
        buttonPanel.add(statsButton);
        buttonPanel.add(timelineButton);
        buttonPanel.add(locationButton);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(scrollPane, BorderLayout.WEST);
        panel.add(scrollPane2, BorderLayout.EAST);
        panel.add(mapPanel, BorderLayout.CENTER);
        add(panel);

        setVisible(true);
        
    }

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
            mapPanel.removeAll();
            mapPanel.add(label);
            mapPanel.revalidate();
            mapPanel.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void createMap() {
        String latitude = "52.629729";
        String longitude = "-1.131592";
        String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center=" +
                           latitude + "," + longitude +
                          "&zoom=14&size=512x512&maptype=satellite&key=AIzaSyA0q8-kHzgWZKLG_l_jXFEu0kjDgfu8QpA";
        createMapImage(imageUrl);
    }
    
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

    private class detailsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //textArea.setText("  Details");
        }
    }

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
    
    private class mapListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (categories.getSelectedItem() != null && crimeSearchClicked) {
                String selectedCategory = (String) categories.getSelectedItem();
                createMapWithMarkers(selectedCategory);
            }
        }
    }
    
    private class statsListener implements ActionListener {
        @Override
    public void actionPerformed(ActionEvent e) {
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

    private class timelineListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //textArea.setText("  Timeline");
        }
    }

    private class locationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //textArea.setText("  Location Details");
        }
    }
}
