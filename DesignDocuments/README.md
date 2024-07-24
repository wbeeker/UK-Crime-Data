# Design Documents

You may have multiple design documents for this project. Place them all in this folder. File naming is up to you, but it should be clear what the document is about. At the bare minimum, you will want a pre/post UML diagram for the project. 

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
    class FilterOptions {
        +String crimeType
        +Date date
        +String outcomeStatus
        +applyFilters()
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

    class CrimeList {
        +CrimeList()
        +getCrimes() : List<String>
        +clear() : void
        +count() : int
        +addToList(String str, Stream<List> sorted) : void
        +removeFromList(String str) : void
    }

class CrimeSort {
        -Set<Crime> crimes
        +CrimeList(Set<Crime> crimes)
        -sortByName(Stream<Crime> crime) : Stream<Crime>
        -sortByDate(Stream<Crime> crime) : Stream<BoardGame>
        -sortStream(Stream<Crime> crime, Crime sortOn, boolean ascending) : Stream<Crime>
    }
    SearchBox --> MapView : provides search query
    MapView --> CrimeDetails : selects crime
    FilterOptions --> MapView : filters results
    MapView --> StatisticsPanel : provides crime data
    MapView --> CrimeTimeline : provides crime data
    MapView --> LocationDetails : selects location

```
