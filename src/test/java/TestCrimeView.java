
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import View.CrimeView;

public class TestCrimeView {

    private CrimeView view;

    @BeforeEach
    public void setUp() {
        view = new CrimeView();
    }

    @Test
    public void testComponentsInitialization() {
        // Test if components are initialized
        assertNotNull(view.getCategories());
        assertNotNull(view.getCrimeButton());
        assertNotNull(view.getAddCrimeButton());
        assertNotNull(view.getMapButton());
        assertNotNull(view.getStatsButton());
        assertNotNull(view.getClearListButton());
        assertNotNull(view.getSaveButton());
        assertNotNull(view.getExitButton());
        assertNotNull(view.getInfo());
        assertNotNull(view.getStats());
        assertNotNull(view.getListOfCrimes());
        assertNotNull(view.getMapPane());
    }

}
