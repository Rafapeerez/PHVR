package com.english.phvr.application;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.english.phvr.domain.models.Import;
import com.english.phvr.infrastructure.persistence.daos.ImportMongoRepository;
import com.english.phvr.infrastructure.persistence.repository.ImportAdapter;
import com.english.phvr.mother.InfoObjectMother;

@ExtendWith(MockitoExtension.class)
class UpdateImportUseCaseTest {
    
    @Mock
    private ImportMongoRepository mongoRepository;

    @Mock
    private ImportAdapter importAdapter;

    @InjectMocks
    private UpdateImportUseCase useCase;

    @Test
    void shouldUpdateAnImport() {
        
        //GIVEN
        Import importObject = InfoObjectMother.createImport();

        //WHEN
        useCase.execute(importObject);

        //THEN
        verify(importAdapter, times(1)).updateImport(importObject);
    }
}
