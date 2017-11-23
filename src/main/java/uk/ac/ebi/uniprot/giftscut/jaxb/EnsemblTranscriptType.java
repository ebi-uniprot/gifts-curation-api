
package uk.ac.ebi.uniprot.giftscut.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Describes a single Ensembl transcript.
 * 
 * <p>Java class for ensemblTranscriptType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ensemblTranscriptType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="enstId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="enstVersion" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="upi" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="biotype" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="deleted" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="seqRegionStart" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="seqRegionEnd" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ensgId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ensemblTranscriptType")
public class EnsemblTranscriptType {

    @XmlAttribute(name = "enstId")
    protected String enstId;
    @XmlAttribute(name = "enstVersion")
    protected Integer enstVersion;
    @XmlAttribute(name = "upi")
    protected String upi;
    @XmlAttribute(name = "biotype")
    protected String biotype;
    @XmlAttribute(name = "deleted")
    protected Boolean deleted;
    @XmlAttribute(name = "seqRegionStart")
    protected Integer seqRegionStart;
    @XmlAttribute(name = "seqRegionEnd")
    protected Integer seqRegionEnd;
    @XmlAttribute(name = "ensgId")
    protected String ensgId;

    /**
     * Gets the value of the enstId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnstId() {
        return enstId;
    }

    /**
     * Sets the value of the enstId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnstId(String value) {
        this.enstId = value;
    }

    /**
     * Gets the value of the enstVersion property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEnstVersion() {
        return enstVersion;
    }

    /**
     * Sets the value of the enstVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEnstVersion(Integer value) {
        this.enstVersion = value;
    }

    /**
     * Gets the value of the upi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpi() {
        return upi;
    }

    /**
     * Sets the value of the upi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpi(String value) {
        this.upi = value;
    }

    /**
     * Gets the value of the biotype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBiotype() {
        return biotype;
    }

    /**
     * Sets the value of the biotype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBiotype(String value) {
        this.biotype = value;
    }

    /**
     * Gets the value of the deleted property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDeleted() {
        return deleted;
    }

    /**
     * Sets the value of the deleted property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeleted(Boolean value) {
        this.deleted = value;
    }

    /**
     * Gets the value of the seqRegionStart property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSeqRegionStart() {
        return seqRegionStart;
    }

    /**
     * Sets the value of the seqRegionStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSeqRegionStart(Integer value) {
        this.seqRegionStart = value;
    }

    /**
     * Gets the value of the seqRegionEnd property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSeqRegionEnd() {
        return seqRegionEnd;
    }

    /**
     * Sets the value of the seqRegionEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSeqRegionEnd(Integer value) {
        this.seqRegionEnd = value;
    }

    /**
     * Gets the value of the ensgId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnsgId() {
        return ensgId;
    }

    /**
     * Sets the value of the ensgId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnsgId(String value) {
        this.ensgId = value;
    }

}
