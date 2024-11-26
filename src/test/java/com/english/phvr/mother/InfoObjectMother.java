package com.english.phvr.mother;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.english.phvr.domain.models.Import;
import com.english.phvr.domain.models.PhrasalVerb;
import com.english.phvr.domain.models.enums.ImportStatusEnum;

public class InfoObjectMother {

    public static PhrasalVerb createPhrasalVerb1() {
        List<String> examples = List.of();

        return PhrasalVerb.builder()
                .id(UUID.randomUUID())
                .verb("First Verb")
                .meaning("First meaning")
                .creationDateTime(LocalDateTime.of(2024, 11, 11, 19, 32, 0))
                .examples(examples)
                .build();
    }

    public static PhrasalVerb createPhrasalVerb2() {
        List<String> examples = List.of();

        return PhrasalVerb.builder()
                .id(UUID.randomUUID())
                .verb("Second Verb")
                .meaning("Second meaning")
                .creationDateTime(LocalDateTime.of(2024, 11, 11, 19, 33, 0))
                .examples(examples)
                .build();
    }

    public static PhrasalVerb createPhrasalVerb3() {
        List<String> examples = List.of();

        return PhrasalVerb.builder()
                .id(UUID.randomUUID())
                .verb("Third Verb")
                .meaning("Third meaning")
                .creationDateTime(LocalDateTime.of(2024, 11, 11, 19, 34, 0))
                .examples(examples)
                .build();
    }

    public static Import createImport() {
        Map<String, String> map = new HashMap<>();
        return Import.builder()
            .id(UUID.randomUUID())
            .fileName("file.txt")
            .status(ImportStatusEnum.OK)
            .startDateTime(LocalDateTime.of(2024, 11, 11, 19, 34, 0))
            .endDateTime(LocalDateTime.of(2024, 11, 11, 19, 34, 20))
            .summary(map)
        .build();
    }
}
