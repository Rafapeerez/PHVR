package com.english.phvr.infrastructure.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.english.phvr.domain.models.Verb;
import com.english.phvr.infrastructure.persistence.entity.VerbEntity;

@Mapper
public interface VerbMapper {
    
    VerbMapper INSTANCE = Mappers.getMapper(VerbMapper.class);

    Verb toVerb(VerbEntity verbEntity);

    VerbEntity toEntity(Verb verb);
}
