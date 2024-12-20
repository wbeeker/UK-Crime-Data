import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Model.Crime;
import Model.CrimeManager;

import java.util.List;
import java.util.Arrays; // Importing the Arrays class to resolve the Arrays.asList method
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Unit tests for the CrimeManager class.
 */
public class TestCrimeManager {
    private CrimeManager crimeManager;
    private Crime crime1;
    private Crime crime2;
    private Crime crime3;

    @BeforeEach
    public void setUp() {
        crimeManager = new CrimeManager();
        crime1 = new Crime("Theft", "40.7128", 123, "Main Street", "-74.0060", "Investigation complete", "2023-07-01", "ABCD1234", 1, "2023-06");
        crime2 = new Crime("Assault", "34.0522", 456, "Second Street", "-118.2437", "Under investigation", "2023-07-02", "EFGH5678", 2, "2023-06");
        crime3 = new Crime("Burglary", "41.8781", 789, "Third Street", "-87.6298", "No suspects identified", "2023-07-03", "IJKL9012", 3, "2023-06");
    }

    @Test
    public void testAddCrime() {
        crimeManager.addCrime(crime1);
        assertEquals(1, crimeManager.countCrimes());
        assertTrue(crimeManager.getCrimes().contains(crime1));
    }

    @Test
    public void testAddSpecificCrimes() {
        List<Crime> newCrimes = Arrays.asList(crime1, crime2);
        crimeManager.addSpecificCrimes(newCrimes);
        assertEquals(2, crimeManager.countCrimes());
        assertTrue(crimeManager.getCrimes().containsAll(newCrimes));
    }

    @Test
    public void testClearCrimes() {
        crimeManager.addCrime(crime1);
        crimeManager.clearCrimes();
        assertEquals(0, crimeManager.countCrimes());
    }

    @Test
    public void testCountCrimes() {
        assertEquals(0, crimeManager.countCrimes());
        crimeManager.addCrime(crime1);
        assertEquals(1, crimeManager.countCrimes());
    }

    @Test
    public void testSortCrimes() {
        List<Crime> newCrimes = Arrays.asList(crime3, crime1, crime2);
        crimeManager.addSpecificCrimes(newCrimes);
        List<Crime> sortedCrimes = crimeManager.getCrimes();
        assertEquals("Assault", sortedCrimes.get(0).getCategory());
        assertEquals("Burglary", sortedCrimes.get(1).getCategory());
        assertEquals("Theft", sortedCrimes.get(2).getCategory());
    }

    @Test
    public void testSaveCrimesToFile() {
        crimeManager.addCrime(crime1);
        crimeManager.addCrime(crime2);
        String filename = "test_crimes.txt";
        crimeManager.saveCrimesToFile(filename);

        // Check if the file was created and has the expected content
        File file = new File(filename);
        assertTrue(file.exists());
        
        // Add code to read the file and verify its content if necessary
        // (omitted for brevity)
        
        // Clean up the test file
        file.delete();
    }
}