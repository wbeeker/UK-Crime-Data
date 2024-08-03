package Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CrimeBean {
    private String category;
    @JsonIgnore
    private String location_type;
    private Location location;
    @JsonIgnore
    private String context;
    private OutcomeStatus outcomeStatus;
    private String persistentID;
    private int ID;
    @JsonIgnore
    private String locationSubtype;
    private String month;


    private CrimeBean() {
    }

    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation_type() {
        return location_type;
    }

    @JsonProperty("location_type")
    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    @JsonProperty("location")
    private void unpackLocationFromNestedObject(Map<String, Object> location) {
        this.location = new Location();
        this.location.setLatitude((String) location.get("latitude"));
        this.location.setLongitude((String) location.get("longitude"));

        Map<String, Object> street = (Map<String, Object>) location.get("street");
        if (street != null) {
            Street streetObj = new Street();
            streetObj.setId((Integer) street.get("id"));
            streetObj.setName((String) street.get("name"));
            this.location.setStreet(streetObj);
        }
    }

    public Location getLocation() {
        return location;
    }

    @JsonProperty("outcome_status")
    private void unpackOutcomeStatusFromNestedObject(Map<String, Object> outcomeStatus) {
        if (outcomeStatus != null) {
            this.outcomeStatus = new OutcomeStatus();
            this.outcomeStatus.setCategory((String) outcomeStatus.get("category"));
            this.outcomeStatus.setDate((String) outcomeStatus.get("date"));
        } else {
            this.outcomeStatus = new OutcomeStatus();
            this.outcomeStatus.setCategory("");
            this.outcomeStatus.setDate("");
        }
    }

    public OutcomeStatus getOutcomeStatus() {
        return outcomeStatus;
    }

    @JsonProperty("persistent_id")
    public void setPersistentID(String persistentId) {
        this.persistentID = persistentId;
    }

    public String getPersistentID() {
        return persistentID;
    }

    @JsonProperty("id")
    public void setID(int id) {
        this.ID = id;
    }

    public int getId() {
        return ID;
    }

    public String getMonth() {
        return month;
    }
    public String getLatitude() {
        return location != null ? location.getLatitude() : null;
    }

    public String getLongitude() {
        return location != null ? location.getLongitude() : null;
    }

    public String getStreetName() {
        return location != null && location.getStreet() != null ? location.getStreet().getName() : null;
    }

    @Override
    public String toString() {
        return "Crime{" +
                "category='" + category + '\'' +
                ", location=" + location +
                ", outcomeStatus=" + outcomeStatus +
                ", persistentId='" + persistentID + '\'' +
                ", id=" + ID +
                ", month='" + month + '\'' +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Location {
        @JacksonXmlProperty(localName = "locationLatitude")
        private String latitude;
        private Street street;
        private String longitude;



        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public Street getStreet() {
            return street;
        }

        public void setStreet(Street street) {
            this.street = street;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "latitude='" + latitude + '\'' +
                    ", street=" + street +
                    ", longitude='" + longitude + '\'' +
                    '}';
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Street {
        private int id;
        private String name;

        @Override
        public String toString() {
            return "Street{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OutcomeStatus {
        private String category;
        private String date;

        @Override
        public String toString() {
            return "OutcomeStatus{" +
                    "category='" + category + '\'' +
                    ", date='" + date + '\'' +
                    '}';
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }

}
