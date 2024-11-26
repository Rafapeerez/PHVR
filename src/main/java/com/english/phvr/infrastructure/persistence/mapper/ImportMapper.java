package com.english.phvr.infrastructure.persistence.mapper;

import java.util.UUID;

import com.english.phvr.domain.models.Import;
import com.english.phvr.infrastructure.persistence.entity.ImportEntity;

public class ImportMapper {
    
    public static Import toImport(ImportEntity entity) {
        return Import.builder()
            .id(UUID.fromString(entity.getId()))
            .fileName(entity.getFilename())
            .status(entity.getStatus())
            .startDateTime(entity.getStartDateTime())
            .endDateTime(entity.getEndDateTime())
            .summary(entity.getSummary())
        .build();
    }

    public static ImportEntity toEntity(Import importObject) {
        return ImportEntity.builder()
            .id(importObject.getId().toString())
            .filename(importObject.getFileName())
            .status(importObject.getStatus())
            .startDateTime(importObject.getStartDateTime())
            .endDateTime(importObject.getEndDateTime())
            .summary(importObject.getSummary())
        .build();
    }
}
