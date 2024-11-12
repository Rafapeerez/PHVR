package com.english.phvr.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.List;

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
class GetPhrasalVerbsToTestUseCaseTest {

    @Mock
    private PhrasalVerbMongoRepository mongoRepository;

    @Mock
    private PhrasalVerbAdapter phrasalVerbAdapter;

    @InjectMocks
    private GetPhrasalVerbsToTestUseCase useCase;

    @Test
    void shouldGetRandomPhrasalVerbsToTest() {
        // GIVEN
        PhrasalVerb firstvPhrasalVerb = InfoObjectMother.createPhrasalVerb1();
        PhrasalVerb secondpPhrasalVerb = InfoObjectMother.createPhrasalVerb2();

        List<PhrasalVerb> verbs = List.of(firstvPhrasalVerb, secondpPhrasalVerb);

        when(useCase.execute(anyInt())).thenReturn(verbs);

        // WHEN
        List<PhrasalVerb> results = useCase.execute(2);

        // THEN
        assertEquals(2, results.size());
    }
}
