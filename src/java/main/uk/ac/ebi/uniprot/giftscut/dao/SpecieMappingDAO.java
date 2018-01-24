package uk.ac.ebi.uniprot.giftscut.dao;

import uk.ac.ebi.uniprot.giftscut.jaxb.SpecieMapping;
import uk.ac.ebi.uniprot.giftscut.jaxb.SpecieMappingHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Christophe Coenraets
 */
public class SpecieMappingDAO {


    public SpecieMappingHistory findByTaxid(int taxId) {
    	String sql = "select esh.species, esh.ensembl_release, esh.ensembl_tax_id, mh.entries_mapped, " +
                " mh.entries_unmapped, mh.uniprot_release, mh.uniprot_taxid" +
                " from mapping_history mh, ensembl_species_history esh " +
                " where mh.ensembl_species_history_id = esh.ensembl_species_history_id" +
                " and mh.uniprot_taxid= ? " +
			" ORDER BY mh.time_mapped";
        SpecieMappingHistory specieMappingHistory = new SpecieMappingHistory();
        Connection c = null;
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, taxId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SpecieMapping specieMapping = new SpecieMapping();
                specieMapping.setSpecie(rs.getString("species"));
                specieMapping.setEnsemblRelease(rs.getInt("ensembl_release"));
                specieMapping.setEnsemblTaxId(rs.getInt("ensembl_tax_id"));
                specieMapping.setEntriesMapped(rs.getInt("entries_mapped"));
                specieMapping.setEntriesUnmapped(rs.getInt("entries_unmapped"));
                specieMapping.setUniprotRelease(rs.getString("uniprot_release"));
                specieMapping.setUniprotTaxId(rs.getInt("uniprot_taxid"));
                specieMappingHistory.getSpecieMapping().add(specieMapping);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
        return specieMappingHistory;
    }


    public SpecieMapping findLatestByTaxid(int taxId) {
        String sql = "select esh.species, esh.ensembl_release, esh.ensembl_tax_id, mh.entries_mapped, mh.entries_unmapped, mh.uniprot_release, mh.uniprot_taxid" +
                " from mapping_history mh, ensembl_species_history esh , (select max(mh.mapping_history_id) latest, esh.species" +
                "      from mapping_history mh, ensembl_species_history esh " +
                "      where mh.ensembl_species_history_id = esh.ensembl_species_history_id" +
                "      GROUP BY esh.species) b" +
                " where mh.ensembl_species_history_id = esh.ensembl_species_history_id" +
                "      and mh.mapping_history_id=b.latest" +
                " and mh.uniprot_taxid= ? ";
        SpecieMapping specieMapping = new SpecieMapping();
        Connection c = null;
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, taxId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                specieMapping.setSpecie(rs.getString("species"));
                specieMapping.setEnsemblRelease(rs.getInt("ensembl_release"));
                specieMapping.setEnsemblTaxId(rs.getInt("ensembl_tax_id"));
                specieMapping.setEntriesMapped(rs.getInt("entries_mapped"));
                specieMapping.setEntriesUnmapped(rs.getInt("entries_unmapped"));
                specieMapping.setUniprotRelease(rs.getString("uniprot_release"));
                specieMapping.setUniprotTaxId(rs.getInt("uniprot_taxid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            ConnectionHelper.close(c);
        }
        return specieMapping;
    }
}
