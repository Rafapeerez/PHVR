package com.english.phvr.infrastructure.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.english.phvr.domain.models.PhrasalVerb;
import com.english.phvr.infrastructure.persistence.entity.PhrasalVerbEntity;

@Mapper
public interface PhrasalVerbMapper {

    PhrasalVerbMapper INSTANCE = Mappers.getMapper(PhrasalVerbMapper.class);

    PhrasalVerb toVerb(PhrasalVerbEntity verbEntity);

    PhrasalVerbEntity toEntity(PhrasalVerb phrasalVerb);
}
