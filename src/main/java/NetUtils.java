
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.io.FileWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NetUtils {

    public static final String URLSTRING = "https://data.police.uk/api/crimes-street/all-crime?lat=52.629729&lng=-1.131592&date=2023-01";
    public static final String FILEPATH = "data.json";

    public static List<Crime> getURLContents() {
        try {
            URL url = new URL(URLSTRING);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                FileWriter fileWriter = new FileWriter(FILEPATH);
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    fileWriter.write(inputLine);
                }
                in.close();
                fileWriter.close();
                System.out.println("Data successfully written to " + FILEPATH);
            } else {
                System.out.println("GET request failed");
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        List<CrimeBean> crimes = writeJSONToCrimeList();
        List<Crime> crimeList = new ArrayList<>();
        for (CrimeBean bean : crimes) {
            crimeList.add(CrimeBeanMapper.map(bean));
        }
        return crimeList;
    }

    public static List<CrimeBean> writeJSONToCrimeList() {
        ObjectMapper mapper = new ObjectMapper();
        List<CrimeBean> crimes;
        String json = convertJSONToString(FILEPATH);
        try {
            return mapper.readValue(json, new TypeReference<List<CrimeBean>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String convertJSONToString(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }


}
