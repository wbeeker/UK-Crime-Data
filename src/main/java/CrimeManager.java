import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to manage a list of Crime objects.
 * This class provides methods to add, clear, count, and save crimes.
 */
public class CrimeManager {
    private List<Crime> crimes; // List to store Crime objects

    /**
     * Constructor for CrimeManager.
     * Initializes the list of crimes.
     */
    public CrimeManager() {
        this.crimes = new ArrayList<>(); // Initialize the list of crimes
    }

    /**
     * Adds a new crime to the list if it's not already present and sorts the list by category.
     * 
     * @param crime the Crime object to add
     */
    public void addCrime(Crime crime) {
        if (!crimes.contains(crime)) { // Add only if the crime is not already in the list
            crimes.add(crime); // Add the crime to the list
            sortCrimes(); // Sort the list after adding
        }
    }

    /**
     * Adds specific crimes from another list based on a condition.
     * 
     * @param newCrimes the list of Crime objects to potentially add
     */
    public void addSpecificCrimes(List<Crime> newCrimes) {
        for (Crime crime : newCrimes) {
            if (!crimes.contains(crime)) {
                crimes.add(crime); // Add specific crimes if not already in the list
            }
        }
        sortCrimes(); // Sort the list after adding
    }

    /**
     * Clears all crimes from the list.
     */
    public void clearCrimes() {
        crimes.clear(); // Clear the list of crimes
    }

    /**
     * Returns the count of crimes in the list.
     * 
     * @return the number of crimes
     */
    public int countCrimes() {
        return crimes.size(); // Return the size of the list
    }

    /**
     * Sorts the crimes by category.
     */
    private void sortCrimes() {
        crimes.sort((c1, c2) -> c1.getCategory().compareToIgnoreCase(c2.getCategory())); // Sort crimes by category
    }

    /**
     * Gets the list of crimes.
     * 
     * @return the list of crimes
     */
    public List<Crime> getCrimes() {
        return new ArrayList<>(crimes); // Return a copy of the list
    }

    /**
     * Saves the list of crimes to a file.
     * 
     * @param filename the name of the file to save to
     */
    public void saveCrimesToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Crime crime : crimes) {
                writer.println(crime);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle or log the exception
        }
    }
}