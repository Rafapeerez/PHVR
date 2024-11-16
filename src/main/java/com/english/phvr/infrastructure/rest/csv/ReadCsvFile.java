package com.english.phvr.infrastructure.rest.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.english.phvr.domain.models.Import;
import com.english.phvr.domain.models.PhrasalVerb;
import com.english.phvr.infrastructure.rest.csv.exception.ContentFileFormatException;
import com.english.phvr.infrastructure.rest.csv.mapper.PhrasalVerbCsvMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReadCsvFile {

    public static Stream<PhrasalVerb> readInformation(InputStream inputStream, Import importObject) throws IOException {
        List<PhrasalVerb> verbsList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            reader.readLine(); // Omit first line

            String line;

            while ((line = reader.readLine()) != null) {
                processLine(line, importObject).ifPresent(verbsList::add);
            }
            return verbsList.stream();
        } catch (IOException e) {
            log.error("Error processing file", e);
            throw e;
        }
    }

    private static Optional<PhrasalVerb> processLine(String line, Import importObject) {
        Optional<PhrasalVerb> phrasalVerb = Optional.empty();
        try {
            phrasalVerb = PhrasalVerbCsvMapper.toDomain(line);
            log.debug(line);
        } catch (ContentFileFormatException e) {
            importObject.getSummary().put(e.getErrorLine(),
                    Optional.ofNullable(e.getCause()).map(Throwable::getMessage)
                            .orElse(e.getMessage()));
        }
        return phrasalVerb;
    }
}
