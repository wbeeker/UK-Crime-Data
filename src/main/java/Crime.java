import java.util.Objects;

/**
 * Class representing a crime with various details.
 * Contains information such as category, location, and outcome.
 */
public class Crime {
    private String category; // Type of crime committed
    private String locationLatitude; // Latitude of the crime location
    private int streetID; // Street ID where the crime occurred
    private String streetName; // Name of the street (approximate location)
    private String locationLongitude; // Longitude of the crime location
    private String outcomeCategory; // Outcome status category (e.g., investigation completed)
    private String outcomeDate; // Date of the outcome status
    private String persistentID; // Persistent ID string (unique identifier)
    private int id; // ID number for the crime report
    private String month; // Month the crime occurred

    /** 
     * Default constructor for the Crime class.
     */
    public Crime() {
    }

    /**
     * Parameterized constructor for the Crime class.
     * 
     * @param category The type of crime committed
     * @param locationLatitude The latitude of the crime location
     * @param streetID The street ID where the crime occurred
     * @param streetName The name of the street (approximate location)
     * @param locationLongitude The longitude of the crime location
     * @param outcomeCategory The outcome status category
     * @param outcomeDate The date of the outcome status
     * @param persistentID The persistent ID string
     * @param id The ID number for the crime report
     * @param month The month the crime occurred
     */
    public Crime(String category, String locationLatitude, int streetID, String streetName,
                 String locationLongitude, String outcomeCategory, String outcomeDate, String persistentID, int id,
                 String month) {
        this.category = category;
        this.locationLatitude = locationLatitude;
        this.streetID = streetID;
        this.streetName = streetName;
        this.locationLongitude = locationLongitude;
        this.outcomeCategory = outcomeCategory;
        this.outcomeDate = outcomeDate;
        this.persistentID = persistentID;
        this.id = id;
        this.month = month;
    }

    // Getters and Setters for each field

    public String getCategory() {
        return category;
    }

    public String getLocationLatitude() {
        return locationLatitude;
    }

    public int getStreetID() {
        return streetID;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getLocationLongitude() {
        return locationLongitude;
    }

    public String getOutcomeCategory() {
        return outcomeCategory;
    }

    public String getOutcomeDate() {
        return outcomeDate;
    }

    public String getPersistentID() {
        return persistentID;
    }

    public int getID() {
        return id;
    }

    public String getMonth() {
        return month;
    }

    /**
     * Provides a string representation of the Crime object.
     * 
     * @return the string representation of the Crime object
     */
    @Override
    public String toString() {
        return "Crime {\n" +
                "\tcategory='" + category + '\n' +
                "\tlocationLatitude='" + locationLatitude + '\n' +
                "\tstreetID=" + streetID + '\n' +
                "\tstreetName='" + streetName + '\n' +
                "\tlocationLongitude='" + locationLongitude + '\n' +
                "\toutcomeCategory='" + outcomeCategory + '\n' +
                "\toutcomeDate='" + outcomeDate + '\n' +
                "\tpersistentID='" + persistentID + '\n' +
                "\tID=" + id + '\n' +
                "\tmonth='" + month + '\n' +
                '}';
    }

    /**
     * Provides a concise string representation for displaying in a list.
     * 
     * @return the concise string representation of the Crime object
     */
    public String getInfo() {
        return "Month: " + month + '\n' +
                "Street Name: " + streetName + '\n' +
                "Outcome: " + outcomeCategory + '\n' +
                "Outcome Date: " + outcomeDate + '\n';
    }

    /**
     * Compares this Crime object to another object for equality.
     * 
     * @param o the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crime crime = (Crime) o;
        return streetID == crime.streetID &&
                id == crime.id &&
                Objects.equals(category, crime.category) &&
                Objects.equals(locationLatitude, crime.locationLatitude) &&
                Objects.equals(streetName, crime.streetName) &&
                Objects.equals(locationLongitude, crime.locationLongitude) &&
                Objects.equals(outcomeCategory, crime.outcomeCategory) &&
                Objects.equals(outcomeDate, crime.outcomeDate) &&
                Objects.equals(persistentID, crime.persistentID) &&
                Objects.equals(month, crime.month);
    }

    /**
     * Generates a hash code for the Crime object.
     * 
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(category, locationLatitude, streetID, streetName, locationLongitude,
                outcomeCategory, outcomeDate, persistentID, id, month);
    }
}