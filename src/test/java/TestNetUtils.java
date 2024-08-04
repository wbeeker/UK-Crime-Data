

import Model.Crime;
import Model.CrimeBean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Model.Net.NetUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestNetUtils {

    @BeforeEach
    public void setup() {

    }

    @Test
    public void testGetURLContents() {
        List<Crime> crimeList = NetUtils.getURLContents();
        assertEquals(1448, crimeList.size());
        assertEquals("anti-social-behaviour", crimeList.get(0).getCategory());
        assertEquals("other-crime", crimeList.get(1447).getCategory());
        assertEquals(107770414, crimeList.get(0).getID());
        assertEquals(107768318, crimeList.get(1447).getID());
        assertEquals("other-theft", crimeList.get(500).getCategory());
        assertEquals(107765935, crimeList.get(500).getID());
    }

    @Test
    public void testConvertJSONToString() {
        String actual = NetUtils.convertJSONToString("datatest.json");
        String expected = "[{\"category\":\"anti-social-behaviour\",\"location_type\":\"Force\",\"location\":{\"latitude\":\"52.632985\",\"street\":{\"id\":1737285,\n" +
                "  \"name\":\"On or near Fosse Road Central\"},\"longitude\":\"-1.152092\"},\"context\":\"\",\"outcome_status\":null,\"persistent_id\":\"\",\n" +
                "  \"id\":107770414,\"location_subtype\":\"\",\"month\":\"2023-01\"},{\"category\":\"anti-social-behaviour\",\"location_type\":\"Force\",\n" +
                "  \"location\":{\"latitude\":\"52.636041\",\"street\":{\"id\":1738351,\"name\":\"On or near East Gates\"},\"longitude\":\"-1.133444\"},\n" +
                "  \"context\":\"\",\"outcome_status\":null,\"persistent_id\":\"\",\"id\":107770751,\"location_subtype\":\"\",\"month\":\"2023-01\"},\n" +
                "  {\"category\":\"anti-social-behaviour\",\"location_type\":\"Force\",\"location\":{\"latitude\":\"52.634409\",\n" +
                "    \"street\":{\"id\":1738338,\"name\":\"On or near \"},\"longitude\":\"-1.133652\"},\"context\":\"\",\n" +
                "    \"outcome_status\":null,\"persistent_id\":\"\",\"id\":107770747,\"location_subtype\":\"\",\"month\":\"2023-01\"},\n" +
                "  {\"category\":\"anti-social-behaviour\",\"location_type\":\"Force\",\"location\":{\"latitude\":\"52.635486\",\n" +
                "    \"street\":{\"id\":1738632,\"name\":\"On or near Yeoman Street\"},\"longitude\":\"-1.128741\"},\"context\":\"\",\n" +
                "    \"outcome_status\":null,\"persistent_id\":\"\",\"id\":107770743,\"location_subtype\":\"\",\"month\":\"2023-01\"},\n" +
                "  {\"category\":\"anti-social-behaviour\",\"location_type\":\"Force\",\"location\":{\"latitude\":\"52.631777\",\n" +
                "    \"street\":{\"id\":1737346,\"name\":\"On or near Catesby Street\"},\"longitude\":\"-1.150416\"},\"context\":\"\",\n" +
                "    \"outcome_status\":null,\"persistent_id\":\"\",\"id\":107770735,\"location_subtype\":\"\",\"month\":\"2023-01\"},\n" +
                "  {\"category\":\"anti-social-behaviour\",\"location_type\":\"Force\",\"location\":{\"latitude\":\"52.634136\",\n" +
                "    \"street\":{\"id\":1738239,\"name\":\"On or near Hotel Street\"},\"longitude\":\"-1.134752\"},\"context\":\"\",\n" +
                "    \"outcome_status\":null,\"persistent_id\":\"\",\"id\":107770763,\"location_subtype\":\"\",\"month\":\"2023-01\"},\n" +
                "  {\"category\":\"anti-social-behaviour\",\"location_type\":\"Force\",\"location\":{\"latitude\":\"52.628997\",\n" +
                "    \"street\":{\"id\":1738518,\"name\":\"On or near Crescent Street\"},\"longitude\":\"-1.130273\"},\n" +
                "    \"context\":\"\",\"outcome_status\":null,\"persistent_id\":\"\",\"id\":107770665,\"location_subtype\":\"\",\n" +
                "    \"month\":\"2023-01\"},{\"category\":\"anti-social-behaviour\",\"location_type\":\"Force\",\n" +
                "  \"location\":{\"latitude\":\"52.636041\",\"street\":{\"id\":1738351,\"name\":\"On or near East Gates\"},\n" +
                "    \"longitude\":\"-1.133444\"},\"context\":\"\",\"outcome_status\":null,\"persistent_id\":\"\",\n" +
                "  \"id\":107770660,\"location_subtype\":\"\",\"month\":\"2023-01\"},{\"category\":\"anti-social-behaviour\",\n" +
                "  \"location_type\":\"Force\",\"location\":{\"latitude\":\"52.628473\",\"street\":{\"id\":1737234,\"name\":\"On or near Harrow Road\"},\n" +
                "    \"longitude\":\"-1.153553\"},\"context\":\"\",\"outcome_status\":null,\"persistent_id\":\"\",\"id\":107770653,\n" +
                "  \"location_subtype\":\"\",\"month\":\"2023-01\"}]\n";
        assertEquals(expected, actual);
    }

    @Test
    public void testWriteJsonToCrimeList() {
        List<CrimeBean> beanList = NetUtils.writeJSONToCrimeList();
        assertEquals(1448, beanList.size());
        assertEquals("anti-social-behaviour", beanList.get(0).getCategory());
        assertEquals("other-crime", beanList.get(1447).getCategory());
        assertEquals("bicycle-theft", beanList.get(100).getCategory());
        assertEquals("Investigation complete; no suspect identified", beanList.get(500).getOutcomeStatus()
                .getCategory());
        assertEquals("2023-01", beanList.get(500).getOutcomeStatus().getDate());
        assertEquals("52.636041", beanList.get(500).getLocation().getLatitude());
        assertEquals("On or near East Gates", beanList.get(500).getLocation().getStreet().getName());
        assertEquals(1738351, beanList.get(500).getLocation().getStreet().getId());
    }
}
