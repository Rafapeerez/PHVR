package com.english.phvr.infrastructure.csv;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.english.phvr.domain.models.Import;
import com.english.phvr.domain.models.PhrasalVerb;
import com.english.phvr.infrastructure.rest.csv.ReadCsvFile;

@ExtendWith(MockitoExtension.class)
class ReadCsvFileTest {

    @Test
    void shouldReadACsvFile() throws IOException {

        // GIVEN
        String fileContent = " header\n" +
                "verb,meaning,-\n"
                +
                "verb1,meaning1,-\n";

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
                fileContent.getBytes(StandardCharsets.UTF_8));
        Import importObject = Import.builder().summary(new HashMap<>()).build();

        // WHEN
        List<PhrasalVerb> result = ReadCsvFile.readInformation(byteArrayInputStream, importObject).toList();

        // THEN
        assertEquals(2, result.size());
        assertEquals("verb", result.get(0).getVerb());
        assertEquals("meaning", result.get(0).getMeaning());
        assertEquals("verb1", result.get(1).getVerb());
        assertEquals("meaning1", result.get(1).getMeaning());
    }
}
