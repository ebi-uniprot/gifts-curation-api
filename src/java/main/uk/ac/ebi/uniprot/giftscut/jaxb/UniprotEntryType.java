
package uk.ac.ebi.uniprot.giftscut.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Describes a single Uniprot entry.
 *
 * <p>
 * Java class for uniprotEntryType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="uniprotEntryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="uniprotAccession" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="entryType" type="{}entryTypeType" />
 *       &lt;attribute name="entryVersion" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="sequenceVersion" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="upi" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="md5" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ensemblDerived" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="isoform" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "uniprotEntryType")
public class UniprotEntryType {

    @XmlAttribute(name = "uniprotAccession")
    protected String uniprotAccession;
    @XmlAttribute(name = "entryType")
    protected EntryTypeType entryType;
    @XmlAttribute(name = "entryVersion")
    protected Integer entryVersion;
    @XmlAttribute(name = "sequenceVersion")
    protected Integer sequenceVersion;
    @XmlAttribute(name = "upi")
    protected String upi;
    @XmlAttribute(name = "md5")
    protected String md5;
    @XmlAttribute(name = "ensemblDerived")
    protected Boolean ensemblDerived;
    @XmlAttribute(name = "isoform")
    protected Boolean isoform;
    @XmlAttribute(name = "uniprotTaxId")
    protected Integer uniprotTaxId;

    /**
     * Gets the value of the uniprotAccession property.
     *
     * @return possible object is {@link String }
     * 
     */
    public String getUniprotAccession() {
        return uniprotAccession;
    }

    /**
     * Sets the value of the uniprotAccession property.
     *
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setUniprotAccession(String value) {
        this.uniprotAccession = value;
    }

    /**
     * Gets the value of the entryType property.
     *
     * @return possible object is {@link EntryTypeType }
     * 
     */
    public EntryTypeType getEntryType() {
        return entryType;
    }

    /**
     * Sets the value of the entryType property.
     *
     * @param value
     *            allowed object is {@link EntryTypeType }
     * 
     */
    public void setEntryType(EntryTypeType value) {
        this.entryType = value;
    }

    /**
     * Gets the value of the entryVersion property.
     *
     * @return possible object is {@link Integer }
     * 
     */
    public Integer getEntryVersion() {
        return entryVersion;
    }

    /**
     * Sets the value of the entryVersion property.
     *
     * @param value
     *            allowed object is {@link Integer }
     * 
     */
    public void setEntryVersion(Integer value) {
        this.entryVersion = value;
    }

    /**
     * Gets the value of the sequenceVersion property.
     *
     * @return possible object is {@link Integer }
     * 
     */
    public Integer getSequenceVersion() {
        return sequenceVersion;
    }

    /**
     * Sets the value of the sequenceVersion property.
     *
     * @param value
     *            allowed object is {@link Integer }
     * 
     */
    public void setSequenceVersion(Integer value) {
        this.sequenceVersion = value;
    }

    /**
     * Gets the value of the upi property.
     *
     * @return possible object is {@link String }
     * 
     */
    public String getUpi() {
        return upi;
    }

    /**
     * Sets the value of the upi property.
     *
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setUpi(String value) {
        this.upi = value;
    }

    /**
     * Gets the value of the md5 property.
     *
     * @return possible object is {@link String }
     * 
     */
    public String getMd5() {
        return md5;
    }

    /**
     * Sets the value of the md5 property.
     *
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setMd5(String value) {
        this.md5 = value;
    }

    /**
     * Gets the value of the ensemblDerived property.
     *
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isEnsemblDerived() {
        return ensemblDerived;
    }

    /**
     * Sets the value of the ensemblDerived property.
     *
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setEnsemblDerived(Boolean value) {
        this.ensemblDerived = value;
    }

    /**
     * Gets the value of the isoform property.
     *
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isIsoform() {
        return isoform;
    }

    /**
     * Sets the value of the isoform property.
     *
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setIsoform(Boolean value) {
        this.isoform = value;
    }

    public Integer getUniprotTaxId() {
        return uniprotTaxId;
    }

    public void setUniprotTaxId(Integer uniprotTaxId) {
        this.uniprotTaxId = uniprotTaxId;
    }

}
