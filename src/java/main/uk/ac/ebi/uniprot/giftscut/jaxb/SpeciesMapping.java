
package uk.ac.ebi.uniprot.giftscut.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Describes a specie mapping.
 * 
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}entryMapping" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="specie" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ensemblTaxId" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="uniprotTaxId" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ensemblRelease" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="uniprotRelease" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="timeMapped" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="entriesMapped" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="entriesUnmapped" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "entryMapping"
})
@XmlRootElement(name = "speciesMapping")
public class SpeciesMapping {

    protected List<EntryMapping> entryMapping;
    @XmlAttribute(name = "species")
    protected String species;
    @XmlAttribute(name = "ensemblTaxId")
    protected Integer ensemblTaxId;
    @XmlAttribute(name = "uniprotTaxId")
    protected Integer uniprotTaxId;
    @XmlAttribute(name = "ensemblRelease")
    protected Integer ensemblRelease;
    @XmlAttribute(name = "uniprotRelease")
    protected String uniprotRelease;
    @XmlAttribute(name = "timeMapped")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar timeMapped;
    @XmlAttribute(name = "entriesMapped")
    protected Integer entriesMapped;
    @XmlAttribute(name = "entriesUnmapped")
    protected Integer entriesUnmapped;

    /**
     * Gets the value of the entryMapping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entryMapping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntryMapping().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntryMapping }
     * 
     * 
     */
    public List<EntryMapping> getEntryMapping() {
        if (entryMapping == null) {
            entryMapping = new ArrayList<EntryMapping>();
        }
        return this.entryMapping;
    }

    /**
     * Gets the value of the specie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Sets the value of the specie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecies(String value) {
        this.species = value;
    }

    /**
     * Gets the value of the ensemblTaxId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEnsemblTaxId() {
        return ensemblTaxId;
    }

    /**
     * Sets the value of the ensemblTaxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEnsemblTaxId(Integer value) {
        this.ensemblTaxId = value;
    }

    /**
     * Gets the value of the uniprotTaxId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUniprotTaxId() {
        return uniprotTaxId;
    }

    /**
     * Sets the value of the uniprotTaxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUniprotTaxId(Integer value) {
        this.uniprotTaxId = value;
    }

    /**
     * Gets the value of the ensemblRelease property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEnsemblRelease() {
        return ensemblRelease;
    }

    /**
     * Sets the value of the ensemblRelease property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEnsemblRelease(Integer value) {
        this.ensemblRelease = value;
    }

    /**
     * Gets the value of the uniprotRelease property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUniprotRelease() {
        return uniprotRelease;
    }

    /**
     * Sets the value of the uniprotRelease property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUniprotRelease(String value) {
        this.uniprotRelease = value;
    }

    /**
     * Gets the value of the timeMapped property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeMapped() {
        return timeMapped;
    }

    /**
     * Sets the value of the timeMapped property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeMapped(XMLGregorianCalendar value) {
        this.timeMapped = value;
    }

    /**
     * Gets the value of the entriesMapped property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEntriesMapped() {
        return entriesMapped;
    }

    /**
     * Sets the value of the entriesMapped property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEntriesMapped(Integer value) {
        this.entriesMapped = value;
    }

    /**
     * Gets the value of the entriesUnmapped property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEntriesUnmapped() {
        return entriesUnmapped;
    }

    /**
     * Sets the value of the entriesUnmapped property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEntriesUnmapped(Integer value) {
        this.entriesUnmapped = value;
    }

}
