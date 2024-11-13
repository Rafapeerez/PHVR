package com.english.phvr.infrastructure.rest.mapper;

import com.english.phvr.domain.models.PhrasalVerb;
import com.english.phvr.infrastructure.rest.dto.VerbDTO;

public class VerbDTOMapper {

    public static VerbDTO toVerbDTO(PhrasalVerb phrasalVerb) {
        return VerbDTO.builder()
                .verb(phrasalVerb.getVerb())
                .meaning(phrasalVerb.getMeaning())
                .creationDateTime(DateTimeMapper.toOffsetDateTime(phrasalVerb.getCreationDateTime()))
                .examples(phrasalVerb.getExamples())
                .build();
    }
}
