
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;




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

    private String[]categoryList = {"all"};
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


        info = new JTextArea("Crime Info");
        stats = new JTextArea("Crime Stats");
        scrollPane = new JScrollPane(info);
        scrollPane.setPreferredSize(new Dimension(200, 700));
        stats.setPreferredSize(new Dimension(200, 700));

        categories = new JComboBox(categoryList);
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
        panel.add(stats, BorderLayout.EAST);
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
            //String crime = crimeTextField.getText();
            //textArea.setText("  " + crime);
            //ArrayList<Crime> crimes = crimeList.getCrimes();
            String output = "";
            //for (Crime crime: crimes) {
                //output += crime.toString();
            }
            //info.setText(output);
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
            //textArea.setText("  Stats");
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

