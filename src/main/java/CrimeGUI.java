
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
    private JButton mapButton;
    private JButton statsButton;

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
        mapButton = new JButton("Crime Map");
        mapButton.addActionListener(new mapListener());
        statsButton = new JButton("Crime Stats");
        statsButton.addActionListener(new statsListener());


        crimePanel.add(crimeTextField);
        crimePanel.add(crimeButton);


        buttonPanel.add(mapButton);
        buttonPanel.add(statsButton);


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
}
