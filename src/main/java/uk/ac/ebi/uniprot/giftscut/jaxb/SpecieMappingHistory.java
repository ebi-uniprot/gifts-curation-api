
package uk.ac.ebi.uniprot.giftscut.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Describes specie mapping history.
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
 *         &lt;element ref="{}specieMapping" maxOccurs="unbounded"/>
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
    "specieMapping"
})
@XmlRootElement(name = "specieMappingHistory")
public class SpecieMappingHistory {

    @XmlElement(required = true)
    protected List<SpecieMapping> specieMapping;

    /**
     * Gets the value of the specieMapping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specieMapping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecieMapping().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpecieMapping }
     * 
     * 
     */
    public List<SpecieMapping> getSpecieMapping() {
        if (specieMapping == null) {
            specieMapping = new ArrayList<SpecieMapping>();
        }
        return this.specieMapping;
    }

}
