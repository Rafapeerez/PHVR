package com.english.phvr.infrastructure.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.english.phvr.domain.models.PhrasalVerb;
import com.english.phvr.infrastructure.persistence.daos.PhrasalVerbMongoRepository;
import com.english.phvr.infrastructure.persistence.entity.PhrasalVerbEntity;
import com.english.phvr.infrastructure.persistence.mapper.PhrasalVerbMapper;
import com.english.phvr.infrastructure.persistence.repository.PhrasalVerbAdapter;
import com.english.phvr.mother.InfoObjectMother;

@ExtendWith(MockitoExtension.class)
class PhrasalVerbAdapterTest {

    @Mock
    private PhrasalVerbMongoRepository mongoRepository;

    @InjectMocks
    private PhrasalVerbAdapter phrasalVerbAdapter;

    @Test
    void shouldGetRandomVerb() {
        // GIVEN
        PhrasalVerbEntity firstEntity = PhrasalVerbMapper.toEntity(InfoObjectMother.createPhrasalVerb1());
        PhrasalVerbEntity secondEntity = PhrasalVerbMapper.toEntity(InfoObjectMother.createPhrasalVerb2());

        List<PhrasalVerbEntity> entityVerbs = List.of(firstEntity, secondEntity);

        when(mongoRepository.findRandomPhrasalVerbs(anyInt())).thenReturn(entityVerbs);

        // WHEN
        List<PhrasalVerb> result = phrasalVerbAdapter.getPhrasalVerbs(2);

        // THEN
        assertEquals(2, result.size());
    }

    @Test
    void shouldInsertAPhrasalVerb() {
        // GIVEN
        PhrasalVerb phrasalVerb = InfoObjectMother.createPhrasalVerb1();

        when(mongoRepository.save(any())).thenReturn(phrasalVerb);

        // WHEN
        phrasalVerbAdapter.insertPhrasalVerb(phrasalVerb);

        // THEN
        verify(mongoRepository, times(1)).save(any());
    }
}
