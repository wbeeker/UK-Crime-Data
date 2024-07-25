
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class CrimeGUI extends JFrame {

    private JPanel panel;
    private JTextField crimeTextField;
    private JButton crimeButton;
    private JButton detailsButton;
    private JButton mapButton;
    private JButton statsButton;
    private JButton timelineButton;
    private JButton locationButton;

    private JPanel topPanel;
    private JPanel crimePanel;
    private JPanel buttonPanel;

    private JTextArea textArea;



    public CrimeGUI() {
        setTitle("Crime: UK Police Data GUI");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel = new JPanel();
        panel.setLayout(new BorderLayout());


        crimePanel = new JPanel();
        buttonPanel = new JPanel();
        topPanel = new JPanel();
        textArea = new JTextArea();


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




        crimePanel.add(crimeTextField);
        crimePanel.add(crimeButton);
        buttonPanel.add(detailsButton);
        buttonPanel.add(mapButton);
        buttonPanel.add(statsButton);
        buttonPanel.add(timelineButton);
        buttonPanel.add(locationButton);


        topPanel.add(crimePanel);


        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(textArea, BorderLayout.CENTER);


        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CrimeGUI();
    }

    
    private class detailsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setText("  Details");
        }
    }

    private class crimeSearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String crime = crimeTextField.getText();
            textArea.setText("  " + crime);
        }
    }

    private class mapListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setText("  Map");
        }
    }

    private class statsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setText("  Stats");
        }
    }

    private class timelineListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setText("  Timeline");
        }
    }

    private class locationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setText("  Location Details");
        }
    }

}
