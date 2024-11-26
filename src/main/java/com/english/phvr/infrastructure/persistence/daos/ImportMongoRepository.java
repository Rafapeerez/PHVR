package com.english.phvr.infrastructure.persistence.daos;

import com.english.phvr.infrastructure.persistence.entity.ImportEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportMongoRepository extends MongoRepository<ImportEntity, String> {
    
}
