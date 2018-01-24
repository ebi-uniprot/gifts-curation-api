package uk.ac.ebi.uniprot.giftscut.dao;

import uk.ac.ebi.uniprot.giftscut.jaxb.EnsemblTranscriptType;
import uk.ac.ebi.uniprot.giftscut.jaxb.EntryMapping;
import uk.ac.ebi.uniprot.giftscut.jaxb.EntryTypeType;
import uk.ac.ebi.uniprot.giftscut.jaxb.SpecieMapping;
import uk.ac.ebi.uniprot.giftscut.jaxb.SpecieMappingHistory;
import uk.ac.ebi.uniprot.giftscut.jaxb.UniprotEntryType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.ws.rs.core.MultivaluedMap;

/**
 * @author Christophe Coenraets
 */
public class EntryMappingDAO {

    private SpecieMappingHistory findEntryMappings(List<String> parameters, String sql) {
        Map<String, SpecieMapping> localMapping = new TreeMap<>();
        SpecieMappingHistory specieMappingHistory = new SpecieMappingHistory();
        Connection c = null;
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            for (int i = 1; i <= parameters.size(); i++) {
                ps.setString(i, parameters.get(i - 1));
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SpecieMapping specieMapping = localMapping.computeIfAbsent(
                        rs.getString("uniprot_release") + "_" + rs.getInt("ensembl_release"), k -> new SpecieMapping());
                specieMapping.setSpecie(rs.getString("species"));
                specieMapping.setEnsemblRelease(rs.getInt("ensembl_release"));
                specieMapping.setEnsemblTaxId(rs.getInt("ensembl_tax_id"));
                specieMapping.setEntriesMapped(rs.getInt("entries_mapped"));
                specieMapping.setEntriesUnmapped(rs.getInt("entries_unmapped"));
                specieMapping.setUniprotRelease(rs.getString("uniprot_release"));
                specieMapping.setUniprotTaxId(rs.getInt("uniprot_taxid"));
                specieMapping.getEntryMapping().add(processRow(rs));
            }
            specieMappingHistory.getSpecieMapping().addAll(localMapping.values());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            ConnectionHelper.close(c);
        }
        return specieMappingHistory;
    }

    private SpecieMapping findEntryMapping(List<String> parameters, String sql) {
        Map<String, SpecieMapping> localMapping = new TreeMap<>();
        Connection c = null;
        SpecieMapping specieMapping = new SpecieMapping();
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            for (int i = 1; i <= parameters.size(); i++) {
                ps.setString(i, parameters.get(i - 1));
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                specieMapping.setSpecie(rs.getString("species"));
                specieMapping.setEnsemblRelease(rs.getInt("ensembl_release"));
                specieMapping.setEnsemblTaxId(rs.getInt("ensembl_tax_id"));
                specieMapping.setEntriesMapped(rs.getInt("entries_mapped"));
                specieMapping.setEntriesUnmapped(rs.getInt("entries_unmapped"));
                specieMapping.setUniprotRelease(rs.getString("uniprot_release"));
                specieMapping.setUniprotTaxId(rs.getInt("uniprot_taxid"));
                specieMapping.getEntryMapping().add(processRow(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            ConnectionHelper.close(c);
        }
        return specieMapping;
    }

    private List<EntryMapping> findEntryMappingList(List<String> parameters, String sql) {
        List<EntryMapping> entryMappings = new ArrayList<>();
        Connection c = null;
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            for (int i = 1; i <= parameters.size(); i++) {
                ps.setString(i, parameters.get(i - 1));
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                entryMappings.add(processRow(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            ConnectionHelper.close(c);
        }
        return entryMappings;
    }

    private String processParameters(List<String> params, MultivaluedMap<String, String> parameters, String paramName,
            String filterValue) {
        if (parameters != null && parameters.get(paramName) != null && parameters.getFirst(paramName) != null) {
            params.add(parameters.getFirst(paramName));
            return " and " + filterValue + " =? ";
        }
        return "";
    }

    public SpecieMappingHistory findHistory(MultivaluedMap<String, String> parameters) {
        String filter = "";
        List<String> params = new ArrayList<>();
        filter += processParameters(params, parameters, "enstID", "et.enst_id");
        filter += processParameters(params, parameters, "acc", "u.uniprot_acc");

        String sql = "select esh.species, esh.ensembl_release, esh.ensembl_tax_id, mh.entries_mapped, " +
                "                 mh.entries_unmapped, mh.uniprot_release, mh.uniprot_taxid," +
                " u.uniprot_acc, u.upi, cet.description entry_type, u.entry_version, u.sequence_version, et.enst_id," +
                " et.uniparc_accession, et.biotype, eg.ensg_id, et.enst_version, et.seq_region_end, et.seq_region_start "
                +
                " from ensembl_uniprot eu, ensembl_transcript et, uniprot u, cv_entry_type cet, ensembl_gene eg, " +
                " mapping_history mh, ensembl_species_history esh " +
                " where eu.transcript_id = et.transcript_id" +
                " and eu.uniprot_id=u.uniprot_id" +
                " and u.entry_type = cet.id" +
                " and et.gene_id=eg.gene_id" +
                " and mh.ensembl_species_history_id = esh.ensembl_species_history_id" +
                " and mh.mapping_history_id=eu.mapping_history_id" +
                filter +
                " order by eu.timestamp;";
        return findEntryMappings(params, sql);
    }

    public SpecieMapping findLatest(MultivaluedMap<String, String> parameters) {
        String filter = "";
        List<String> params = new ArrayList<>();
        filter += processParameters(params, parameters, "enstID", "et.enst_id");
        filter += processParameters(params, parameters, "acc", "u.uniprot_acc");
        String sql = "select esh.species, esh.ensembl_release, esh.ensembl_tax_id, mh.entries_mapped, " +
                "                 mh.entries_unmapped, mh.uniprot_release, mh.uniprot_taxid," +
                " u.uniprot_acc, u.upi, cet.description entry_type, u.entry_version, u.sequence_version, et.enst_id," +
                " et.uniparc_accession, et.biotype, eg.ensg_id, et.enst_version, et.seq_region_end, et.seq_region_start "
                +
                " from ensembl_uniprot eu, ensembl_transcript et, uniprot u, cv_entry_type cet, ensembl_gene eg, " +
                " mapping_history mh, ensembl_species_history esh, " +
                " (select max(mh.mapping_history_id) latest, esh.species " +
                "      from mapping_history mh, ensembl_species_history esh " +
                "      where mh.ensembl_species_history_id = esh.ensembl_species_history_id" +
                "      GROUP BY esh.species) b" +
                " where eu.transcript_id = et.transcript_id" +
                " and eu.uniprot_id=u.uniprot_id" +
                " and u.entry_type = cet.id" +
                " and et.gene_id=eg.gene_id" +
                " and mh.ensembl_species_history_id = esh.ensembl_species_history_id" +
                " and mh.mapping_history_id=eu.mapping_history_id" +
                " and mh.mapping_history_id=b.latest" +
                filter +
                " order by eu.timestamp;";
        return findEntryMapping(params, sql);
    }

    protected EntryMapping processRow(ResultSet rs) throws SQLException {
        EntryMapping entryMapping = new EntryMapping();
        UniprotEntryType uniprotEntry = new UniprotEntryType();
        EnsemblTranscriptType ensemblTranscript = new EnsemblTranscriptType();
        entryMapping.setUniprotEntry(uniprotEntry);
        entryMapping.setEnsemblTranscript(ensemblTranscript);

        uniprotEntry.setUniprotAccession(rs.getString("uniprot_acc"));
        uniprotEntry.setUpi(rs.getString("upi"));
        EntryTypeType entryType = EntryTypeType.fromValue(rs.getString("entry_type"));
        uniprotEntry.setEntryType(entryType);
        uniprotEntry.setEntryVersion(rs.getInt("entry_version"));
        uniprotEntry.setSequenceVersion(rs.getInt("sequence_version"));
        uniprotEntry.setUniprotTaxId(rs.getInt("uniprot_taxid"));

        ensemblTranscript.setUpi(rs.getString("uniparc_accession"));
        ensemblTranscript.setBiotype(rs.getString("biotype"));
        ensemblTranscript.setEnsgId(rs.getString("ensg_id"));
        ensemblTranscript.setEnstVersion(rs.getInt("enst_version"));
        ensemblTranscript.setSeqRegionEnd(rs.getInt("seq_region_end"));
        ensemblTranscript.setSeqRegionStart(rs.getInt("seq_region_start"));

        return entryMapping;
    }

    public List<EntryMapping> findLatestEntries(MultivaluedMap<String, String> parameters) {
        String filter = "";
        List<String> params = new ArrayList<>();
        filter += processParameters(params, parameters, "enstID", "et.enst_id");
        filter += processParameters(params, parameters, "acc", "u.uniprot_acc");
        filter += processParameters(params, parameters, "uniprot_taxid", "u.uniprot_taxid");
        String sql = "select esh.species, esh.ensembl_release, esh.ensembl_tax_id, mh.entries_mapped, " +
                "                 mh.entries_unmapped, mh.uniprot_release, mh.uniprot_taxid," +
                " u.uniprot_acc, u.upi, cet.description entry_type, u.entry_version, u.sequence_version, et.enst_id," +
                " et.uniparc_accession, et.biotype, eg.ensg_id, et.enst_version, et.seq_region_end, et.seq_region_start "
                +
                " from ensembl_uniprot eu, ensembl_transcript et, uniprot u, cv_entry_type cet, ensembl_gene eg, " +
                " mapping_history mh, ensembl_species_history esh, " +
                " (select max(mh.mapping_history_id) latest, esh.species " +
                "      from mapping_history mh, ensembl_species_history esh " +
                "      where mh.ensembl_species_history_id = esh.ensembl_species_history_id" +
                "      GROUP BY esh.species) b" +
                " where eu.transcript_id = et.transcript_id" +
                " and eu.uniprot_id=u.uniprot_id" +
                " and u.entry_type = cet.id" +
                " and et.gene_id=eg.gene_id" +
                " and mh.ensembl_species_history_id = esh.ensembl_species_history_id" +
                " and mh.mapping_history_id=eu.mapping_history_id" +
                " and mh.mapping_history_id=b.latest" +
                filter +
                " order by eu.timestamp"
                + " limit 0, 30;";
        return findEntryMappingList(params, sql);
    }
}
