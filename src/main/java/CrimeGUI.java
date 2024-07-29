
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
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


    //private String[]categoryList = {"all"};
    //private CrimeList crimeList;

    public CrimeGUI() {
        //crimeList = new CrimeList();
        setTitle("Crime: UK Police Data GUI");
        setSize(800, 500);
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
        scrollPane.setPreferredSize(new Dimension(200, 700));
        scrollPane2.setPreferredSize(new Dimension(200, 700));

        scrollPane.setBorder(new TitledBorder("Crime Info"));
        scrollPane2.setBorder(new TitledBorder("Crime Stats"));

        List<Crime> crimes = NetUtils.getURLContents();
        Set<String> categorySet = new HashSet<>();
        for (Crime crime : crimes) {
            categorySet.add(crime.getCategory());
        }
        categories = new JComboBox(categorySet.toArray(new String[0]));

        //categories = new JComboBox(categoryList);
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
                    output += crime.toString() + "\n";
                }
            }
            info.setText(output);
        }
    }
    
    private class mapListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //textArea.setText("  Map");
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
        String output = "Number of \n'" + selectedCategory + "'\ncrimes: " + count;
        for (Map.Entry<String, Integer> entry : streetCounts.entrySet()) {
            if (entry.getValue() > 1) {
                output += "\n\nStreet '\n" + entry.getKey() + "\n' has " + entry.getValue() + " crimes.";
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

