package com.english.phvr.infrastructure.persistence.daos;

import com.english.phvr.domain.models.Import;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportMongoRepository extends MongoRepository<Import, String> {
    
}
