package uk.ac.ebi.uniprot.giftscut.dao;

import uk.ac.ebi.uniprot.giftscut.jaxb.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Christophe Coenraets
 */
public class EntryMappingDAO {

    private SpecieMappingHistory findEntryMappings(String parameter, String sql) {
        Map<String, SpecieMapping> localMapping =  new TreeMap<>();
        SpecieMappingHistory specieMappingHistory = new SpecieMappingHistory();
        Connection c = null;
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, parameter);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SpecieMapping specieMapping = localMapping.computeIfAbsent(rs.getString("uniprot_release") + "_" + rs.getInt("ensembl_release"), k ->new SpecieMapping());
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

    private SpecieMapping findEntryMapping(String parameter, String sql) {
        Map<String, SpecieMapping> localMapping =  new TreeMap<>();
        Connection c = null;
        SpecieMapping specieMapping = new SpecieMapping();
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, parameter);
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

    public SpecieMappingHistory findHistoryByEnstId(String enstId) {
        String sql = "select esh.species, esh.ensembl_release, esh.ensembl_tax_id, mh.entries_mapped, " +
                "                 mh.entries_unmapped, mh.uniprot_release, mh.uniprot_taxid," +
                " u.uniprot_acc, u.upi, cet.description entry_type, u.entry_version, u.sequence_version, et.enst_id," +
                " et.uniparc_accession, et.biotype, eg.ensg_id, et.enst_version, et.seq_region_end, et.seq_region_start " +
                " from ensembl_uniprot eu, ensembl_transcript et, uniprot u, cv_entry_type cet, ensembl_gene eg, " +
                " mapping_history mh, ensembl_species_history esh " +
                " where et.enst_id=?" +
                " and eu.transcript_id = et.transcript_id" +
                " and eu.uniprot_id=u.uniprot_id" +
                " and u.entry_type = cet.id" +
                " and et.gene_id=eg.gene_id" +
                " and mh.ensembl_species_history_id = esh.ensembl_species_history_id" +
                " and mh.mapping_history_id=eu.mapping_history_id" +
                " order by eu.timestamp;";
        return findEntryMappings(enstId, sql);
    }


    public SpecieMappingHistory findHistoryByUniprot(String accession) {
        String sql = "select esh.species, esh.ensembl_release, esh.ensembl_tax_id, mh.entries_mapped, " +
                "                 mh.entries_unmapped, mh.uniprot_release, mh.uniprot_taxid," +
                " u.uniprot_acc, u.upi, cet.description entry_type, u.entry_version, u.sequence_version, et.enst_id," +
                " et.uniparc_accession, et.biotype, eg.ensg_id, et.enst_version, et.seq_region_end, et.seq_region_start " +
                " from ensembl_uniprot eu, ensembl_transcript et, uniprot u, cv_entry_type cet, ensembl_gene eg, " +
                " mapping_history mh, ensembl_species_history esh " +
                " where u.uniprot_acc=?" +
                " and eu.transcript_id = et.transcript_id" +
                " and eu.uniprot_id=u.uniprot_id" +
                " and u.entry_type = cet.id" +
                " and et.gene_id=eg.gene_id" +
                " and mh.ensembl_species_history_id = esh.ensembl_species_history_id" +
                " and mh.mapping_history_id=eu.mapping_history_id" +
                " order by eu.timestamp;";
        return findEntryMappings(accession, sql);
    }

    public SpecieMapping findLatestByEnstId(String enstId) {
        String sql = "select esh.species, esh.ensembl_release, esh.ensembl_tax_id, mh.entries_mapped, " +
                "                 mh.entries_unmapped, mh.uniprot_release, mh.uniprot_taxid," +
                " u.uniprot_acc, u.upi, cet.description entry_type, u.entry_version, u.sequence_version, et.enst_id," +
                " et.uniparc_accession, et.biotype, eg.ensg_id, et.enst_version, et.seq_region_end, et.seq_region_start " +
                " from ensembl_uniprot eu, ensembl_transcript et, uniprot u, cv_entry_type cet, ensembl_gene eg, " +
                " mapping_history mh, ensembl_species_history esh, " +
                " (select max(mh.mapping_history_id) latest, esh.species " +
                "      from mapping_history mh, ensembl_species_history esh " +
                "      where mh.ensembl_species_history_id = esh.ensembl_species_history_id" +
                "      GROUP BY esh.species) b" +
                " where et.enst_id=?" +
                " and eu.transcript_id = et.transcript_id" +
                " and eu.uniprot_id=u.uniprot_id" +
                " and u.entry_type = cet.id" +
                " and et.gene_id=eg.gene_id" +
                " and mh.ensembl_species_history_id = esh.ensembl_species_history_id" +
                " and mh.mapping_history_id=eu.mapping_history_id" +
                " and mh.mapping_history_id=b.latest" +
                " order by eu.timestamp;";
        return findEntryMapping(enstId, sql);
    }

    public SpecieMapping findLatestByUniprot(String accession) {
        String sql = "select esh.species, esh.ensembl_release, esh.ensembl_tax_id, mh.entries_mapped, " +
                "                 mh.entries_unmapped, mh.uniprot_release, mh.uniprot_taxid," +
                " u.uniprot_acc, u.upi, cet.description entry_type, u.entry_version, u.sequence_version, et.enst_id," +
                " et.uniparc_accession, et.biotype, eg.ensg_id, et.enst_version, et.seq_region_end, et.seq_region_start " +
                " from ensembl_uniprot eu, ensembl_transcript et, uniprot u, cv_entry_type cet, ensembl_gene eg, " +
                " mapping_history mh, ensembl_species_history esh , " +
                " (select max(mh.mapping_history_id) latest, esh.species " +
                "      from mapping_history mh, ensembl_species_history esh " +
                "      where mh.ensembl_species_history_id = esh.ensembl_species_history_id" +
                "      GROUP BY esh.species) b" +
                " where u.uniprot_acc=?" +
                " and eu.transcript_id = et.transcript_id" +
                " and eu.uniprot_id=u.uniprot_id" +
                " and u.entry_type = cet.id" +
                " and et.gene_id=eg.gene_id" +
                " and mh.ensembl_species_history_id = esh.ensembl_species_history_id" +
                " and mh.mapping_history_id=eu.mapping_history_id" +
                " and mh.mapping_history_id=b.latest" +
                " order by eu.timestamp;";
        return findEntryMapping(accession, sql);
    }

    protected EntryMapping processRow(ResultSet rs) throws SQLException {
        EntryMapping entryMapping = new EntryMapping();
        UniprotEntryType uniprotEntry = new UniprotEntryType();
        EnsemblTranscriptType ensemblTranscript = new EnsemblTranscriptType();
        entryMapping.setUniprotEntry(uniprotEntry);
        entryMapping.setEnsemblTranscript(ensemblTranscript);

        uniprotEntry.setUniprotAccession(rs.getString("uniprot_acc"));
        uniprotEntry.setUpi(rs.getString("upi"));
        EntryTypeType entryType = EntryTypeType.fromValue (rs.getString("entry_type"));
        uniprotEntry.setEntryType(entryType);
        uniprotEntry.setEntryVersion(rs.getInt("entry_version"));
        uniprotEntry.setSequenceVersion(rs.getInt("sequence_version"));

        ensemblTranscript.setUpi(rs.getString("uniparc_accession"));
        ensemblTranscript.setBiotype(rs.getString("biotype"));
        ensemblTranscript.setEnsgId(rs.getString("ensg_id"));
        ensemblTranscript.setEnstVersion(rs.getInt("enst_version"));
        ensemblTranscript.setSeqRegionEnd(rs.getInt("seq_region_end"));
        ensemblTranscript.setSeqRegionStart(rs.getInt("seq_region_start"));

        return entryMapping;
    }

}
