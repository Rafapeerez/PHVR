package com.english.phvr.infrastructure.persistence.repository;

import java.util.List;
import java.util.stream.Stream;

import com.english.phvr.domain.models.PhrasalVerb;
import com.english.phvr.domain.repository.PhrasalVerbRepository;
import com.english.phvr.infrastructure.persistence.daos.PhrasalVerbMongoRepository;
import com.english.phvr.infrastructure.persistence.entity.PhrasalVerbEntity;
import com.english.phvr.infrastructure.persistence.mapper.PhrasalVerbMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PhrasalVerbAdapter implements PhrasalVerbRepository {

    private PhrasalVerbMongoRepository mongoRepository;

    @Override
    public List<PhrasalVerb> getPhrasalVerbs(int limit) {
        Stream<PhrasalVerbEntity> verbs = mongoRepository.findRandomPhrasalVerbs(limit).stream();
        return verbs.map(PhrasalVerbMapper.INSTANCE::toVerb).toList();
    }

}
