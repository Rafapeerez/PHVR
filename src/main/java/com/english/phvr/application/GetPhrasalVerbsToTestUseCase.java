package com.english.phvr.application;

import java.util.List;

import com.english.phvr.domain.models.PhrasalVerb;
import com.english.phvr.domain.repository.PhrasalVerbPort;

public class GetPhrasalVerbsToTestUseCase {

    private PhrasalVerbPort repository;

    public GetPhrasalVerbsToTestUseCase(PhrasalVerbPort phrasalVerbRepository) {
        this.repository = phrasalVerbRepository;
    }

    public List<PhrasalVerb> execute(int limit) {
        return repository.getPhrasalVerbs(limit);
    }
}
