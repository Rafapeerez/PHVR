package com.english.phvr.infrastructure.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.english.phvr.domain.models.Import;
import com.english.phvr.infrastructure.persistence.daos.ImportMongoRepository;
import com.english.phvr.infrastructure.persistence.mapper.ImportMapper;
import com.english.phvr.infrastructure.persistence.repository.ImportAdapter;
import com.english.phvr.mother.InfoObjectMother;

@ExtendWith(MockitoExtension.class)
class ImportAdapterTest {

    @Mock
    private ImportMongoRepository mongoRepository;

    @InjectMocks
    private ImportAdapter importAdapter;

    @Test
    void shouldGetRandomVerb() {
        // GIVEN
        Import importObject = InfoObjectMother.createImport();

        when(mongoRepository.save(any())).thenReturn(ImportMapper.toEntity(importObject));

        // WHEN
        Import result = importAdapter.saveImport(importObject);

        // THEN
        verify(mongoRepository, times(1)).save(any());
        assertEquals(importObject.getFileName(), result.getFileName());
    }
}
