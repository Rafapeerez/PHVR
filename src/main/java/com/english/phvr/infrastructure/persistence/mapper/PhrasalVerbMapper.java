package com.english.phvr.infrastructure.persistence.mapper;

import java.util.UUID;

import com.english.phvr.domain.models.PhrasalVerb;
import com.english.phvr.infrastructure.persistence.entity.PhrasalVerbEntity;

public class PhrasalVerbMapper {

    public static PhrasalVerb toVerb(PhrasalVerbEntity verbEntity) {
        return PhrasalVerb.builder()
                .id(UUID.fromString(verbEntity.getId()))
                .verb(verbEntity.getVerb())
                .meaning(verbEntity.getMeaning())
                .creationDateTime(verbEntity.getCreationDateTime())
                .examples(verbEntity.getExamples())
                .build();
    }

    public static PhrasalVerbEntity toEntity(PhrasalVerb phrasalVerb) {
        return PhrasalVerbEntity.builder()
                .id(phrasalVerb.getId().toString())
                .verb(phrasalVerb.getVerb())
                .meaning(phrasalVerb.getMeaning())
                .creationDateTime(phrasalVerb.getCreationDateTime())
                .examples(phrasalVerb.getExamples())
                .build();
    }
}
