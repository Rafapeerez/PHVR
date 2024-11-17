package com.english.phvr.application;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.english.phvr.domain.models.PhrasalVerb;
import com.english.phvr.infrastructure.persistence.daos.PhrasalVerbMongoRepository;
import com.english.phvr.infrastructure.persistence.repository.PhrasalVerbAdapter;
import com.english.phvr.mother.InfoObjectMother;

@ExtendWith(MockitoExtension.class)
class SavePhrasalVerbUseCaseTest {
    
    @Mock
    private PhrasalVerbMongoRepository mongoRepository;

    @Mock
    private PhrasalVerbAdapter phrasalVerbAdapter;

    @InjectMocks
    private SavePhrasalVerbUseCase useCase;

    @Test
    void shouldSaveAPhrasalVerb() {
        // GIVEN
        PhrasalVerb firstPhrasalVerb = InfoObjectMother.createPhrasalVerb1();
        
        // WHEN
        useCase.execute(firstPhrasalVerb);

        // THEN
        verify(phrasalVerbAdapter, times(1)).insertPhrasalVerb(firstPhrasalVerb);
    }
}
