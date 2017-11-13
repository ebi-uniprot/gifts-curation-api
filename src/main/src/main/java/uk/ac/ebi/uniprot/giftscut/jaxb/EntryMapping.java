
package uk.ac.ebi.uniprot.giftscut.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Describes a single mapping between Uniprot protein and Ensembl transcript.
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
 *         &lt;element name="uniprotEntry" type="{}uniprotEntryType"/>
 *         &lt;element name="ensemblTranscript" type="{}ensemblTranscriptType"/>
 *         &lt;element name="annotation" type="{}annotationType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "uniprotEntry",
    "ensemblTranscript",
    "annotation"
})
@XmlRootElement(name = "entryMapping")
public class EntryMapping {

    @XmlElement(required = true)
    protected UniprotEntryType uniprotEntry;
    @XmlElement(required = true)
    protected EnsemblTranscriptType ensemblTranscript;
    @XmlElement(required = true)
    protected AnnotationType annotation;

    /**
     * Gets the value of the uniprotEntry property.
     * 
     * @return
     *     possible object is
     *     {@link UniprotEntryType }
     *     
     */
    public UniprotEntryType getUniprotEntry() {
        return uniprotEntry;
    }

    /**
     * Sets the value of the uniprotEntry property.
     * 
     * @param value
     *     allowed object is
     *     {@link UniprotEntryType }
     *     
     */
    public void setUniprotEntry(UniprotEntryType value) {
        this.uniprotEntry = value;
    }

    /**
     * Gets the value of the ensemblTranscript property.
     * 
     * @return
     *     possible object is
     *     {@link EnsemblTranscriptType }
     *     
     */
    public EnsemblTranscriptType getEnsemblTranscript() {
        return ensemblTranscript;
    }

    /**
     * Sets the value of the ensemblTranscript property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnsemblTranscriptType }
     *     
     */
    public void setEnsemblTranscript(EnsemblTranscriptType value) {
        this.ensemblTranscript = value;
    }

    /**
     * Gets the value of the annotation property.
     * 
     * @return
     *     possible object is
     *     {@link AnnotationType }
     *     
     */
    public AnnotationType getAnnotation() {
        return annotation;
    }

    /**
     * Sets the value of the annotation property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnnotationType }
     *     
     */
    public void setAnnotation(AnnotationType value) {
        this.annotation = value;
    }

}
