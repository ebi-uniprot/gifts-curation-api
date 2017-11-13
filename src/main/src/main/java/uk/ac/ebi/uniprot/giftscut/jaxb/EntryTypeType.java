
package uk.ac.ebi.uniprot.giftscut.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for entryTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="entryTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Swiss-Prot"/>
 *     &lt;enumeration value="TrEMBL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "entryTypeType")
@XmlEnum
public enum EntryTypeType {

    @XmlEnumValue("Swiss-Prot")
    SWISS_PROT("Swiss-Prot"),
    @XmlEnumValue("TrEMBL")
    TR_EMBL("TrEMBL"),
    @XmlEnumValue("Swiss-Prot isoform")
    ISOFORM("Swiss-Prot isoform");
    private final String value;

    EntryTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EntryTypeType fromValue(String v) {
        for (EntryTypeType c: EntryTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
