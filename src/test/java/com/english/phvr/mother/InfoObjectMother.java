package com.english.phvr.mother;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.english.phvr.domain.models.PhrasalVerb;

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
}
