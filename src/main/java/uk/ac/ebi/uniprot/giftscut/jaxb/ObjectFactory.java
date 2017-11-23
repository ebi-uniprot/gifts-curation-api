
package uk.ac.ebi.uniprot.giftscut.jaxb;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the uk.ac.ebi.uniprot.giftscut.jaxb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: uk.ac.ebi.uniprot.giftscut.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SpecieMappings }
     * 
     */
    public SpecieMappings createSpecieMappings() {
        return new SpecieMappings();
    }

    /**
     * Create an instance of {@link SpecieMappingHistory }
     * 
     */
    public SpecieMappingHistory createSpecieMappingHistory() {
        return new SpecieMappingHistory();
    }

    /**
     * Create an instance of {@link SpecieMapping }
     * 
     */
    public SpecieMapping createSpecieMapping() {
        return new SpecieMapping();
    }

    /**
     * Create an instance of {@link EntryMapping }
     * 
     */
    public EntryMapping createEntryMapping() {
        return new EntryMapping();
    }

    /**
     * Create an instance of {@link UniprotEntryType }
     * 
     */
    public UniprotEntryType createUniprotEntryType() {
        return new UniprotEntryType();
    }

    /**
     * Create an instance of {@link EnsemblTranscriptType }
     * 
     */
    public EnsemblTranscriptType createEnsemblTranscriptType() {
        return new EnsemblTranscriptType();
    }

    /**
     * Create an instance of {@link AnnotationType }
     * 
     */
    public AnnotationType createAnnotationType() {
        return new AnnotationType();
    }

    /**
     * Create an instance of {@link CommentType }
     * 
     */
    public CommentType createCommentType() {
        return new CommentType();
    }

    /**
     * Create an instance of {@link LabelType }
     * 
     */
    public LabelType createLabelType() {
        return new LabelType();
    }

}
