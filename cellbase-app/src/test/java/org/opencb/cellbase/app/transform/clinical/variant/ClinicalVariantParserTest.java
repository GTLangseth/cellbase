package org.opencb.cellbase.app.transform.clinical.variant;

import org.junit.Ignore;
import org.junit.Test;
import org.opencb.cellbase.core.serializer.CellBaseJsonFileSerializer;
import org.opencb.cellbase.core.serializer.CellBaseSerializer;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by fjlopez on 07/10/16.
 */
@Ignore
public class ClinicalVariantParserTest {
    @Test
    public void parse() throws Exception {
        Path clinicalVariantFolder = Paths.get(getClass().getResource("/clinicalVariant").toURI());
        Path genomeSequenceFilePath = Paths.get(getClass()
                .getResource("/clinicalVariant/Homo_sapiens.GRCh37.75.dna.primary_assembly.chr17.fa.gz").toURI());

        CellBaseSerializer serializer = new CellBaseJsonFileSerializer(Paths.get("/tmp/"), "clinical_variant", true);
        (new ClinicalVariantParser(clinicalVariantFolder, genomeSequenceFilePath, "GRCh37",  serializer)).parse();

        // FIXME: commented to enable compiling for priesgo. Must be uncommented and fixed
//        List<Variant> variantList = loadSerializedVariants("/tmp/clinical_variant.json.gz");
//        assertEquals(8, variantList.size());
//
//        Variant variant = getVariantByAccession(variantList, "COSM1193237");
//        assertNotNull(variant);
//        assertThat(variant.getAnnotation().getVariantTraitAssociation().getGermline().stream()
//                .map(somatic -> somatic.getAccession()).collect(Collectors.toList()),
//                CoreMatchers.hasItems("RCV000148505"));
//
//        variant = getVariantByAccession(variantList, "RCV000148485");
//        assertNotNull(variant);
//        assertThat(variant.getAnnotation().getVariantTraitAssociation().getSomatic().stream()
//                        .map(somatic -> somatic.getAccession()).collect(Collectors.toList()),
//                CoreMatchers.hasItems("COSM5745645"));
//
//        variant = getVariantByAccession(variantList, "COSM4059225");
//        assertNotNull(variant);
//
//        variant = getVariantByAccession(variantList, "3259");
//        assertEquals(Integer.valueOf(7577545), variant.getStart());
//        assertEquals("T", variant.getReference());
//        assertEquals("C", variant.getAlternate());
//        assertEquals("PMID:0008075648",
//                variant.getAnnotation().getVariantTraitAssociation().getGermline().get(0).getBibliography().get(0));
//
//        variant = getVariantByAccession(variantList, "5223");
//        assertEquals(Integer.valueOf(4), variant.getStart());
//        assertEquals("CTTCTCACCCT", variant.getReference());
//        assertEquals("", variant.getAlternate());
//        assertEquals("PMID:0008479743",
//                variant.getAnnotation().getVariantTraitAssociation().getGermline().get(0).getBibliography().get(0));
//
//        variant = getVariantByAccession(variantList, "1590");
//        assertEquals(Integer.valueOf(7578502), variant.getStart());
//        assertEquals("A", variant.getReference());
//        assertEquals("G", variant.getAlternate());
//        assertEquals("PMID:0002649981",
//                variant.getAnnotation().getVariantTraitAssociation().getSomatic().get(0).getBibliography().get(0));
//
//        variant = getVariantByAccession(variantList, "2143");
//        assertEquals(Integer.valueOf(7578406), variant.getStart());
//        assertEquals("C", variant.getReference());
//        assertEquals("T", variant.getAlternate());
//        assertEquals("PMID:0002649981",
//                variant.getAnnotation().getVariantTraitAssociation().getSomatic().get(0).getBibliography().get(0));
//
//        variant = getVariantByAccession(variantList, "1407");
//        assertEquals(Integer.valueOf(7578536), variant.getStart());
//        assertEquals("T", variant.getReference());
//        assertEquals("G", variant.getAlternate());
//        assertEquals("PMID:0001694291",
//                variant.getAnnotation().getVariantTraitAssociation().getSomatic().get(0).getBibliography().get(0));
//
//    }
//
//    private Variant getVariantByAccession(List<Variant> variantList, String accession) {
//        for (Variant variant : variantList) {
//            if (variant.getAnnotation().getVariantTraitAssociation().getGermline() != null) {
//                for (Germline germline : variant.getAnnotation().getVariantTraitAssociation().getGermline()) {
//                    if (germline.getAccession().equals(accession)) {
//                        return variant;
//                    }
//                }
//            }
//            if (variant.getAnnotation().getVariantTraitAssociation().getSomatic() != null) {
//                for (Somatic somatic : variant.getAnnotation().getVariantTraitAssociation().getSomatic()) {
//                    if (somatic.getAccession().equals(accession)) {
//                        return variant;
//                    }
//                }
//            }
//        }
//
//        return null;
//    }
//
//    private List<Variant> loadSerializedVariants(String fileName) {
//        List<Variant> variantList = new ArrayList<>(3);
//
//        try {
//            BufferedReader bufferedReader = FileUtils.newBufferedReader(Paths.get(fileName));
//            ObjectMapper jsonObjectMapper = new ObjectMapper();
//            jsonObjectMapper.configure(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS, true);
//            jsonObjectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                if (line.startsWith("#") || line.trim().isEmpty()) {
//                    continue;
//                }
//                variantList.add(new Variant(jsonObjectMapper.convertValue(JSON.parse(line), VariantAvro.class)));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            assertFalse(false);
//        }
//
//        return variantList;
    }

}