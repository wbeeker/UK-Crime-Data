package Model.Formatters;
import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import Model.Crime;


@JacksonXmlRootElement(localName = "crimeList")
public final class CrimeXmlWrapper {

    /**
     * List of the crimes.
     */
    @JacksonXmlElementWrapper(useWrapping = false)
    private Collection<Crime> crime;

    /**
     * Constructor.
     *
     * @param crimes the records to wrap
     */
    public CrimeXmlWrapper(Collection<Crime> crimes) {
        this.crime = crimes;
    }
}
