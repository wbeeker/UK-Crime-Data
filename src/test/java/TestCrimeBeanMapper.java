
import java.util.ArrayList;
import java.util.List;

import Model.Net.NetUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Model.Crime;
import Model.CrimeBean;
import Model.CrimeBeanMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCrimeBeanMapper {
    private List<CrimeBean> list;
    private List<Crime> crimeList;

    @BeforeEach
    public void setup() {
        list = NetUtils.writeJSONToCrimeList();
        crimeList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            crimeList.add(CrimeBeanMapper.map(list.get(i)));
        }
    }

    @Test
    public void testCrimeBeanMapper() {
        for (Crime crime: crimeList) {
            System.out.println(crime.toString());
        }
        assertEquals("52.627798", crimeList.get(9).getLocationLatitude());
        assertEquals(1737705, crimeList.get(9).getStreetID());
        assertEquals("-1.144613", crimeList.get(9).getLocationLongitude());
        assertEquals(107770651, crimeList.get(9).getID());
        assertEquals("On or near Tarragon Road", crimeList.get(9).getStreetName());
        assertEquals("", crimeList.get(9).getOutcomeCategory());
        assertEquals("", crimeList.get(9).getOutcomeDate());
        assertEquals("", crimeList.get(9).getPersistentID());
    }

    @Test
    public void testCrimeBeanMapperOutcomeStatus() {
        List<Crime> subList = new ArrayList<>();
        for (int i = 0; i < 1200; i += 100) {
            subList.add(CrimeBeanMapper.map(list.get(i)));
        }
        System.out.println(subList);
        assertEquals("bicycle-theft", subList.get(1).getCategory());
        assertEquals("Unable to prosecute suspect", subList.get(1).getOutcomeCategory());
        assertEquals("2023-01", subList.get(1).getOutcomeDate());
        assertEquals("fdcdf377b7cbdee27fbb3af8b90e43be3e17d974d84aa33c3544c6e24b5354c2", subList.get(1)
                .getPersistentID());
    }



}
