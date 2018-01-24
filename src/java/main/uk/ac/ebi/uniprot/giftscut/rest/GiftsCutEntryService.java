package uk.ac.ebi.uniprot.giftscut.rest;

import uk.ac.ebi.uniprot.giftscut.dao.EntryMappingDAO;
import uk.ac.ebi.uniprot.giftscut.jaxb.SpecieMappings;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

public class GiftsCutEntryService {
    EntryMappingDAO entryMappingDAO = new EntryMappingDAO();

    @GET
    @Path("/entries")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public SpecieMappings getEntries(@Context UriInfo uriInfo) {
        // all possible filters

        uriInfo.getQueryParameters();

        return EntryMappingDAOfindByTaxid(Integer.parseInt(taxId));
    }
}
