package uk.ac.ebi.uniprot.giftscut.rest;

import uk.ac.ebi.uniprot.giftscut.dao.EntryMappingDAO;
import uk.ac.ebi.uniprot.giftscut.dao.SpecieMappingDAO;
import uk.ac.ebi.uniprot.giftscut.dao.SpeciesMappingDAO;
import uk.ac.ebi.uniprot.giftscut.jaxb.SpeciesMapping;
import uk.ac.ebi.uniprot.giftscut.jaxb.SpeciesMappingHistory;
import uk.ac.ebi.uniprot.giftscut.jaxb.SpeciesMappings;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/specie")
public class GiftsCutService {

    SpecieMappingDAO specieMappingDAO = new SpecieMappingDAO();
    SpeciesMappingDAO speciesMappingDAO = new SpeciesMappingDAO();
    EntryMappingDAO entryMappingDAO = new EntryMappingDAO();

    @GET
    @Path("/history/{taxId}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public SpeciesMappingHistory getSpecieHistoryMapping(@PathParam("taxId") String taxId) {
        return specieMappingDAO.findByTaxid(Integer.parseInt(taxId));
    }

    @GET
    @Path("/latest")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public SpeciesMappings getLatestSpeciesMapping() {
        return speciesMappingDAO.findLatest();
    }


    @GET
    @Path("/latest/{taxId}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public SpeciesMapping getLatestSpeciesMapping(@PathParam("taxId") String taxId) {
        return specieMappingDAO.findLatestByTaxid(Integer.parseInt(taxId));
    }

    @GET
    @Path("/entry/history")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public SpeciesMappingHistory getUniprotMappingHistory(@Context UriInfo uriInfo) {
        return entryMappingDAO.findHistory(uriInfo.getQueryParameters());
    }

    @GET
    @Path("/entry/latest/mapping")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public SpeciesMapping getMappingLatest(@Context UriInfo uriInfo) {
        return entryMappingDAO.findLatest(uriInfo.getQueryParameters());
    }



}