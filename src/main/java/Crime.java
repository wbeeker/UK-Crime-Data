import java.util.Objects;

/**
 * This class holds the crime objects built from the details of the crime report.
 */
public class Crime {
    /** The type of crime committed. */
    private String category;
    /** The latitude at which the crime occurred. */
    private String locationLatitude;
    /** The ID of the street where the crime occurred. */
    private int streetID;
    /** The name of the street where the crime occurred (often an approximate location: i.e. near Bridge street). */
    private String streetName;
    /** The longitude where the crime occurred. */
    private String locationLongitude;
    /** The outcome_status category (i.e. investigation completed). */
    private String outcomeCategory;
    /** The date of the outcome_status. */
    private String outcomeDate;
    /** The persistent ID string (mix of letters and numbers). */
    private String persistentID;
    /** The ID number for the crime report. */
    private int id;
    /** The month the crime occurred. */
    private String month;

    /** Default constructor to instantiate Crime class during deserialization. */
    public Crime() {
    }

    public Crime (String category, String locationLatitude, int streetID, String streetName,
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

    /**
     * Gets the category of the crime committed.
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the latitude where the crime occurred.
     * @return location latitude
     */
    public String getLocationLatitude() {
        return locationLatitude;
    }

    /**
     * Gets the street ID number.
     * @return street ID number
     */
    public int getStreetID() { return streetID; }

    /**
     * Gets the street name (or approximate location).
     * @return street name
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Gets the longitude where the crime occurred.
     * @return location longitude
     */
    public String getLocationLongitude() {
        return locationLongitude;
    }

    /**
     * Gets the outcome_status category.
     * @return outcome category
     */
    public String getOutcomeCategory() {
        return outcomeCategory;
    }

    /**
     * Gets the date of the outcome_status.
     * @return outcome date
     */
    public String getOutcomeDate() {
        return outcomeDate;
    }

    /**
     * Gets the persistent ID for the crime report.
     * @return persistent ID
     */
    public String getPersistentID() {
        return persistentID;
    }

    /**
     * Gets the ID number for the crime report.
     * @return ID number
     */
    public int getID() {
        return id;
    }

    /**
     * Gets the month the crime was committed.
     * @return month
     */
    public String getMonth() {
        return month;
    }

    /**
     * Formats the crime objet as a string.
     * @return toString of the crime object
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
     * Formats the crime object as a string.
     * @return crime object as a string for map display
     */
    public String getInfo() {
        return  "Month: " + month + '\n' +
                "Street Name: " + streetName + '\n' +
                "Outcome: " + outcomeCategory + '\n' +
                "Outcome Date: " + outcomeDate + '\n';
    }

    /**
     * Compares Crime objects to see if they're equal.
     * @param o crime object
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crime crime = (Crime) o;
        return streetID == crime.streetID
                && id == crime.id
                && Objects.equals(category, crime.category)
                && Objects.equals(locationLatitude, crime.locationLatitude)
                && Objects.equals(streetName, crime.streetName)
                && Objects.equals(locationLongitude, crime.locationLongitude)
                && Objects.equals(outcomeCategory, crime.outcomeCategory)
                && Objects.equals(outcomeDate, crime.outcomeDate)
                && Objects.equals(persistentID, crime.persistentID)
                && Objects.equals(month, crime.month);
    }

    /**
     * Gets a unique hashcode for a crime object.
     * @return hashcode integer
     */
    @Override
    public int hashCode() {
        return Objects.hash(category, locationLatitude, streetID, streetName, locationLongitude,
                outcomeCategory, outcomeDate, persistentID, id, month);
    }
}
