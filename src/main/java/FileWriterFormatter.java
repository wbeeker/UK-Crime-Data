
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import javax.annotation.*;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Collection;


public class FileWriterFormatter {

    public FileWriterFormatter() {

    }

    private static void prettyPrint(Collection<Crime> crimes, OutputStream out) {
        PrintStream pout = new PrintStream(out);
        for (Crime crime : crimes) {
            prettySingle(crime, pout);
            pout.println();
        }
    }

    public static void prettySingle(Crime crime, PrintStream out) {
        out.println(crime.getCategory().replace("-", " ") + "\n");
        out.println("       LOCATION: ");
        out.println("           latitude: " + crime.getLocationLatitude());
        out.println("           longitude: " + crime.getLocationLongitude());
        out.println("       STREET: ");
        out.println("           id: " + crime.getStreetID());
        out.println("           name: " + crime.getStreetName());
        out.println("        OUTCOME_STATUS: ");
        out.println("           category: " + crime.getOutcomeCategory());
        out.println("           date: " + crime.getOutcomeDate() + "\n");
        out.println("        persistent_id: " + crime.getPersistentID());
        out.println("        id: " + crime.getID());
        out.println("        month: " + crime.getMonth());
    }

    public static void writeXmlData(Collection<Crime> crimes, OutputStream out) {
        ObjectMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        CrimeXmlWrapper wrapper = new CrimeXmlWrapper(crimes);
        try {
            mapper.writeValue(out, wrapper);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeJsonData(Collection<Crime> crimes, OutputStream out) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(out, crimes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCSVData(Collection<Crime> crimes, OutputStream out) {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(Crime.class).withHeader();
        try {
            mapper.writer(schema).writeValue(out, crimes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(Collection<Crime> crimes, Formats format,
                             OutputStream out) {
        switch (format) {
            case XML:
                writeXmlData(crimes, out);
                break;
            case JSON:
                writeJsonData(crimes, out);
                break;
            case CSV:
                writeCSVData(crimes, out);
                break;
            default:
                prettyPrint(crimes, out);
        }
    }
}
