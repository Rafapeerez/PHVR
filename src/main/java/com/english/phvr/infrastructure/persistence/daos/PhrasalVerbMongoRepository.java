package com.english.phvr.infrastructure.persistence.daos;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.english.phvr.infrastructure.persistence.entity.PhrasalVerbEntity;

@Repository
public interface PhrasalVerbMongoRepository extends MongoRepository<PhrasalVerbEntity, String> {

    @Aggregation(pipeline = { "{ '$sample': { 'size': ?0 } }" })
    List<PhrasalVerbEntity> findRandomPhrasalVerbs(int limit);

}
