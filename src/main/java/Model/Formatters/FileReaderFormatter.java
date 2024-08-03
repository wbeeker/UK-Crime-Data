package Model.Formatters;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import Model.Crime;

import java.io.*;
import java.util.List;

public class FileReaderFormatter {

    public static InputStream loadFile(String filePath) throws FileNotFoundException {
        try{
            return new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return null;
    }

    public static List<Crime> readXmlInput(InputStream in) throws IOException {
        List<Crime> crimeList;
        XmlMapper xmlMapper = new XmlMapper();
        crimeList = xmlMapper.readValue(in, new TypeReference<List<Crime>>() {
        });
        return crimeList;
    }

    public static List<Crime> readJsonInput(InputStream in) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(in, mapper.getTypeFactory().constructCollectionType(List.class, Crime.class));
    }

    public static List<Crime> readCsvInput(InputStream in) throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        MappingIterator<Crime> iterator = csvMapper.readerFor(Crime.class)
                .with(schema)
                .readValues(in);
        return iterator.readAll();
    }


    public static List<Crime> read (String filePath) throws IOException {
        String formattedFilePath = filePath.toLowerCase();
        if (formattedFilePath.contains(".xml")) {
            return readXmlInput(loadFile(formattedFilePath));
        } else if (formattedFilePath.contains(".json")) {
            return readJsonInput(loadFile(formattedFilePath));
        } else if (formattedFilePath.contains(".csv")) {
            return readCsvInput(loadFile(formattedFilePath));
        } else {
            throw new IllegalArgumentException("Unsupported file type.");
        }
    }
}
