package Controller;

import Model.CrimeManager;
import View.CrimeView;

public class Main {
    /**
     * Main method to run the program.
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        CrimeView view = new CrimeView();
        CrimeManager model = new CrimeManager();
        new CrimeController(view, model);
    }
}
