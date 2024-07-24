import java.util.Objects;

public class Crime {
    private String category;
    private String locationType;
    private String locationLatitude;
    private int streetID;
    private String streetName;
    private String locationLongitude;
    private String outcomeCategory;
    private String outcomeDate;
    private String persistentID;
    private int ID;
    private String month;

    public Crime (String category, String locationType, String locationLatitude, int streetID, String streetName,
                  String locationLongitude, String outcomeCategory, String outcomeDate, String persistentID, int ID,
                  String month) {
        this.category = category;
        this.locationType = locationType;
        this.locationLatitude = locationLatitude;
        this.streetID = streetID;
        this.streetName = streetName;
        this.locationLongitude = locationLongitude;
        this.outcomeCategory = outcomeCategory;
        this.outcomeDate = outcomeDate;
        this.persistentID = persistentID;
        this.ID = ID;
        this.month = month;
    }

    public String getCategory() {
        return category;
    }

    public String getLocationType() {
        return locationType;
    }

    public String getLocationLatitude() {
        return locationLatitude;
    }

    public int getStreetID() { return streetID; }

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
        return ID;
    }

    public String getMonth() {
        return month;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crime crime = (Crime) o;
        return streetID == crime.streetID
                && ID == crime.ID
                && Objects.equals(category, crime.category)
                && Objects.equals(locationType, crime.locationType)
                && Objects.equals(locationLatitude, crime.locationLatitude)
                && Objects.equals(streetName, crime.streetName)
                && Objects.equals(locationLongitude, crime.locationLongitude)
                && Objects.equals(outcomeCategory, crime.outcomeCategory)
                && Objects.equals(outcomeDate, crime.outcomeDate)
                && Objects.equals(persistentID, crime.persistentID)
                && Objects.equals(month, crime.month);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, locationType, locationLatitude, streetID, streetName, locationLongitude,
                outcomeCategory, outcomeDate, persistentID, ID, month);
    }
}