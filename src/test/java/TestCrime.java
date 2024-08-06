import Model.Crime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCrime {
    private Crime crime1, crime2, crime3;

    @BeforeEach
    public void setup() {
        crime1 = new Crime("anti-social-behaviour", "52.555", 12345678,
                "Near Bishop Street", "-1.23498", "Investigation completed",
                "2023-05", "123jkh345908sdfkj3455", 123456, "2023-01");
        crime2 = new Crime("drugs", "53.7564", 77777, "On or near",
                "-1.55555", "Investigation ongoing", "", "",
                888891, "2023-01");
        crime3 = new Crime("other-crime", "51.1111", 13579,
                "On or near Langston St", "-1.6421", "", "",
                "adsf243jk78dfs", 442233, "2023-01");
    }

    @Test
    public void testGetCategory() {
        assertEquals("anti-social-behaviour", crime1.getCategory());
        assertEquals("drugs", crime2.getCategory());
        assertEquals("other-crime", crime3.getCategory());
    }

    @Test
    public void testGetLatitude() {
        assertEquals("52.555", crime1.getLocationLatitude());
        assertEquals("53.7564", crime2.getLocationLatitude());
        assertEquals("51.1111", crime3.getLocationLatitude());
    }

    @Test
    public void testGetStreetID() {
        assertEquals(12345678, crime1.getStreetID());
        assertEquals(77777, crime2.getStreetID());
        assertEquals(13579, crime3.getStreetID());
    }

    @Test
    public void testGetStreetName() {
        assertEquals("Near Bishop Street", crime1.getStreetName());
        assertEquals("On or near", crime2.getStreetName());
        assertEquals("", crime3.getStreetName());
    }

    @Test
    public void testGetLongitude() {
        assertEquals("-1.23498", crime1.getLocationLongitude());
        assertEquals("-1.55555", crime2.getLocationLongitude());
        assertEquals("-1.6421", crime3.getLocationLongitude());
    }

    @Test
    public void testGetOutcomeCategory() {
        assertEquals("Investigation completed", crime1.getOutcomeCategory());
        assertEquals("Investigation ongoing", crime2.getOutcomeCategory());
        assertEquals("", crime3.getOutcomeCategory());
    }

    @Test
    public void testGetOutcomeDate() {
        assertEquals("2023-05", crime1.getOutcomeDate());
        assertEquals("", crime2.getOutcomeDate());
        assertEquals("", crime3.getOutcomeDate());
    }

    @Test
    public void testGetPersistentID() {
        assertEquals("123jkh345908sdfkj3455", crime1.getPersistentID());
        assertEquals("", crime2.getPersistentID());
        assertEquals("adsf243jk78dfs", crime3.getPersistentID());
    }

    @Test
    public void testGetID() {
        assertEquals(123456, crime1.getID());
        assertEquals(888891, crime2.getID());
        assertEquals(442233, crime3.getID());
    }

    @Test
    public void testGetMonth() {
        assertEquals("2023-01", crime1.getMonth());
        assertEquals("2023-01", crime2.getMonth());
        assertEquals("2023-01", crime3.getMonth());
    }

    @Test
    public void testToString() {
        assertEquals("Crime {\n" +
                "\tcategory='anti-social-behaviour\n" +
                "\tlocationLatitude='52.555\n" +
                "\tstreetID=12345678\n" +
                "\tstreetName='Near Bishop Street\n" +
                "\tlocationLongitude='-1.23498\n" +
                "\toutcomeCategory='Investigation completed\n" +
                "\toutcomeDate='2023-05\n" +
                "\tpersistentID='123jkh345908sdfkj3455\n" +
                "\tID=123456\n" +
                "\tmonth='2023-01\n" +
                "}", crime1.toString());
        assertEquals("Crime {\n" +
                "\tcategory='drugs\n" +
                "\tlocationLatitude='53.7564\n" +
                "\tstreetID=77777\n" +
                "\tstreetName='On or near\n" +
                "\tlocationLongitude='-1.55555\n" +
                "\toutcomeCategory='Investigation ongoing\n" +
                "\toutcomeDate='\n" +
                "\tpersistentID='\n" +
                "\tID=888891\n" +
                "\tmonth='2023-01\n" +
                "}", crime2.toString());
        assertEquals("Crime {\n" +
                "\tcategory='other-crime\n" +
                "\tlocationLatitude='51.1111\n" +
                "\tstreetID=13579\n" +
                "\tstreetName='On or near Langston St\n" +
                "\tlocationLongitude='-1.6421\n" +
                "\toutcomeCategory='\n" +
                "\toutcomeDate='\n" +
                "\tpersistentID='adsf243jk78dfs\n" +
                "\tID=442233\n" +
                "\tmonth='2023-01\n" +
                "}", crime3.toString());
    }

    @Test
    public void testGetInfo() {
        assertEquals("Category: anti-social-behaviour\n" +
                "Month: 2023-01\n" +
                "Street Name: Near Bishop Street\n" +
                "Outcome: Investigation completed\n" +
                "Outcome Date: 2023-05\n", crime1.getInfo());
        assertEquals("Category: drugs\n" +
                "Month: 2023-01\n" +
                "Street Name: On or near\n" +
                "Outcome: Investigation ongoing\n" +
                "Outcome Date: \n", crime2.getInfo());
        assertEquals("Category: other-crime\n" +
                "Month: 2023-01\n" +
                "Street Name: On or near Langston St\n" +
                "Outcome: \n" +
                "Outcome Date: \n", crime3.getInfo());
    }

    @Test
    public void testEquals() {
        Crime crimeTest = new Crime("test category", "55.555", 123456,
                "Near Bishop Street", "-1.1111", "Investigation open.",
                "2023-09", "123jkh345908sdfkj3455", 76543221, "2023-01");
        assertFalse(crime1.equals(crimeTest));
        assertNotEquals(crime1.hashCode(), crimeTest.hashCode());
        assertFalse(crime2.equals(crimeTest));
        assertNotEquals(crime2.hashCode(), crimeTest.hashCode());
        assertFalse(crime3.equals(crimeTest));
        assertNotEquals(crime3.hashCode(), crimeTest.hashCode());
    }
}
