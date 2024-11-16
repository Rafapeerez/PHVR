package com.english.phvr.infrastructure.rest.csv.mapper;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import com.english.phvr.domain.models.PhrasalVerb;
import com.english.phvr.infrastructure.rest.csv.exception.ContentFileFormatException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PhrasalVerbCsvMapper {

    public static Optional<PhrasalVerb> toDomain(String line) {
        if (line == null || line.isEmpty()) {
            return Optional.empty();
        }

        String[] elements = line.split(",");
        validateCountElements(elements);
        try {
            PhrasalVerb phrasalVerb = PhrasalVerb.builder()
                    .id(UUID.randomUUID())
                    .verb(elements[0])
                    .meaning(elements[1])
                    .creationDateTime(LocalDateTime.now())
                    .build();
            return Optional.of(phrasalVerb);

        } catch (Exception e) {
            log.error("Error trying to convert timesheet to domain", e);
            throw e;
        }
    }

    private static void validateCountElements(String[] elements) {
        if (elements.length != 3) {
            log.error("Error reading file, it has different number of elements that are required");
            throw new ContentFileFormatException(
                    "Line read has a different number of elements than required", String.join(
                            ",", elements));
        }
    }
}
