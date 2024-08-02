# Design Documents

You may have multiple design documents for this project. Place them all in this folder. File naming is up to you, but it should be clear what the document is about. At the bare minimum, you will want a pre/post UML diagram for the project. 

OVERVIEW

Our app will take UK crime data and display it on an interactive map using the longitude and latitude associated with each crime report. The data comes from crimes committed in January 2023 in Leicester, England. It includes the following categories of crimes: 

    anti-social behaviour
    bicycle-theft
    burglary
    criminal damage arson
    drugs
    other theft
    possession of weapons
    public order
    robbery
    shoplifting
    theft from the person
    vehicle crime
    other crime

A typical crime report inludes data like the category of crime, the longitude and latitude of where it was committed, an ID number, the month the crime was committed, and an outcome status if the case has been resolved. 

The app will read in the JSON-formatted data from the UK police data API, put the data into a list that can be sorted by category, and then displayed on a map using the latitude and longitude points included with each crime report. 

Users will also be able to create their own sub-lists and write them out in various file formats. 

```mermaid
classDiagram
    class SearchBox {
        +String query
        +search()
    }
    class MapView {
        +Double latitude
        +Double longitude
        +viewResults()
    }
    class CrimeDetails {
        +String crimeType
        +String location
        +Date date
        +String outcomeStatus
        +displayDetails()
    }
    class StatisticsPanel {
        +Int totalCrimes
        +String mostCommonCrime
        +Double crimeRateChange
        +displayStatistics()
    }
    class CrimeTimeline {
        +Date[] crimeDates
        +displayTimeline()
    }
    class LocationDetails {
        +String streetName
        +String neighborhood
        +displayDetails()
    }
    class NetUtils {
        + getURLContents(String urlStr: InputStream)
    }
    class Crime {
        - category: String
        - locationType: String
        - latitude: float
        - streetID: int
        - streetName: String
        - longitude: float
        - outcomeStatusCategory: String
        - outcomeStatusDate: String
        - persistentID: String
        - id: int
        - month: String
    }
    class JSONMapper {
        + writeJSONFile(InputStream contents): List~Crime~
    }
    class FileWriter {
        - writeCSVList(Collection~Crime~, OutputStream out): void
        - writeXMLList(Collection~Crime~, OutputStream out): void
        - writeJSONList(Collection~Crime~, OutputStream out): void
        - writePrettyList(Collection~Crime~, OutputStream out): void
        + writeOutFiles(Collection~Crime~, Formats format, OutputStream out): void
    }
    class Formats {
    <<enumerator>>
    JSON, XML, CSV, PRETTY
    }
    class CrimeManager {
        + CrimeManager()
        + addCrime(Crime crime) : void
        + addSpecificCrimes(List<Crime> newCrimes) : void
        + clearCrimes() : void
        + countCrimes() : int
        - sortCrimes() : void
        + getCrimes() : List<Crime>
        + saveCrimesToFile(String filename), : void
    }
    
    SearchBox --> MapView : provides search query
    MapView --> CrimeDetails : selects crime
    MapView --> StatisticsPanel : provides crime data
    MapView --> CrimeTimeline : provides crime data
    MapView --> LocationDetails : selects location
    NetUtils --> JSONMapper : converts URL contents to Crime objects
    Crime -- JSONMapper
    Crime --> CrimeManager
    CrimeManager --> MapView
    CrimeManager --> MapView

```