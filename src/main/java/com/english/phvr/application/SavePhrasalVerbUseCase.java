package com.english.phvr.application;

import com.english.phvr.domain.models.PhrasalVerb;
import com.english.phvr.domain.repository.PhrasalVerbPort;

public class SavePhrasalVerbUseCase {

    private PhrasalVerbPort repository;

    public SavePhrasalVerbUseCase(PhrasalVerbPort phrasalVerbRepository) {
        this.repository = phrasalVerbRepository;
    }

    public void execute(PhrasalVerb phrasalVerb) {
        repository.insertPhrasalVerb(phrasalVerb);
    }
}
