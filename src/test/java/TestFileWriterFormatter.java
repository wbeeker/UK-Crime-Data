import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Model.Crime;
import Model.Formatters.FileWriterFormatter;
import Model.Formatters.Formats;

import java.util.ArrayList;
import java.util.List;

import static Model.Formatters.FileWriterFormatter.write;


public class TestFileWriterFormatter {
    private static Crime crime;
    private static List<Crime> crimeList;

    @BeforeEach
    public void setup() {
        crimeList = new ArrayList<>();
        crime = new Crime("other-theft", "52.627045", 1737780,
                "On or near Eastern Boulevard", "-1.142456",
                "Investigation complete; no suspect identified", "2023-01",
                "8aad3617297c99d605b9531563e3208efa3aaa2b4a63a45c94f502edd0e645f6", 107763146,
                "2023-01");
        crimeList.add(crime);
    }

    @Test
    public void testPrettySingle() {
        FileWriterFormatter.prettySingle(crime, System.out);
    }

    @Test
    public void testWritePrettySingle() {
        write(crimeList, Formats.PRETTY, System.out);
    }

    @Test
    public void testXmlData() {
        FileWriterFormatter.writeXmlData(crimeList, System.out);
    }

    @Test
    public void testWriteXmlData() {
        write(crimeList, Formats.XML, System.out);
    }

    @Test
    public void testJsonData() {
        FileWriterFormatter.writeJsonData(crimeList, System.out);
    }

    @Test
    public void testWriteJsonData() {
        write(crimeList, Formats.JSON, System.out);
    }

    @Test
    public void testCsvData() {
        FileWriterFormatter.writeCSVData(crimeList, System.out);
    }

    @Test
    public void testWriteCsvData() {
        write(crimeList, Formats.CSV, System.out);
    }
}
