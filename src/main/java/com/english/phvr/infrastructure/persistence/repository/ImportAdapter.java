package com.english.phvr.infrastructure.persistence.repository;

import org.springframework.stereotype.Repository;

import com.english.phvr.domain.models.Import;
import com.english.phvr.domain.repository.ImportPort;
import com.english.phvr.infrastructure.persistence.daos.ImportMongoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class ImportAdapter implements ImportPort {
    
    private final ImportMongoRepository mongoRepository;

    @Override
    public Import saveImport(Import importObject) {
        return mongoRepository.save(importObject);
    }
    
}
