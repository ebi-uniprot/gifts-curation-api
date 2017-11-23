package uk.ac.ebi.uniprot.giftscut.rest;

import uk.ac.ebi.uniprot.giftscut.dao.EntryMappingDAO;
import uk.ac.ebi.uniprot.giftscut.dao.SpecieMappingDAO;
import uk.ac.ebi.uniprot.giftscut.dao.SpeciesMappingDAO;
import uk.ac.ebi.uniprot.giftscut.jaxb.SpecieMapping;
import uk.ac.ebi.uniprot.giftscut.jaxb.SpecieMappingHistory;
import uk.ac.ebi.uniprot.giftscut.jaxb.SpecieMappings;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/specie")
public class GiftsCutService {

    SpecieMappingDAO specieMappingDAO = new SpecieMappingDAO();
    SpeciesMappingDAO speciesMappingDAO = new SpeciesMappingDAO();
    EntryMappingDAO entryMappingDAO = new EntryMappingDAO();

    @GET
    @Path("/history/{taxId}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public SpecieMappingHistory getSpecieHistoryMapping(@PathParam("taxId") String taxId) {
        return specieMappingDAO.findByTaxid(Integer.parseInt(taxId));
    }

    @GET
    @Path("/latest")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public SpecieMappings getLatestSpeciesMapping() {
        return speciesMappingDAO.findLatest();
    }


    @GET
    @Path("/latest/{taxId}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public SpecieMapping getLatestSpeciesMapping(@PathParam("taxId") String taxId) {
        return specieMappingDAO.findLatestByTaxid(Integer.parseInt(taxId));
    }

    @GET
    @Path("/entry/history/transcript/{enstId}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public SpecieMappingHistory getEnstMappingHistory(@PathParam("enstId") String enstId) {
        return entryMappingDAO.findHistoryByEnstId(enstId);
    }

    @GET
    @Path("/entry/history/uniprot/{acc}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public SpecieMappingHistory getUniprotMappingHistory(@PathParam("acc") String acc) {
        return entryMappingDAO.findHistoryByUniprot(acc);
    }

    @GET
    @Path("/entry/latest/transcript/{enstId}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public SpecieMapping getEnstMappingLatest(@PathParam("enstId") String enstId) {
        return entryMappingDAO.findLatestByEnstId(enstId);
    }

    @GET
    @Path("/entry/latest/uniprot/{acc}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public SpecieMapping getUniprotMappingLatest(@PathParam("acc") String acc) {
        return entryMappingDAO.findLatestByUniprot(acc);
    }

}